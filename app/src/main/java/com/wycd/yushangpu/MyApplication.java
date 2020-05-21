package com.wycd.yushangpu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.google.gson.Gson;
import com.loopj.android.http.PersistentCookieStore;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.QbSdk;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.tools.AppLanguageUtils;
import com.wycd.yushangpu.tools.CrashHandler;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.wxapi.Constants;

import net.posprinter.posprinterface.IMyBinder;
import net.posprinter.service.PosprinterService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import androidx.multidex.MultiDexApplication;
import cz.msebera.android.httpclient.cookie.Cookie;

/**
 * Created by songxiaotao on 2018/5/28.
 */

public class MyApplication extends MultiDexApplication {

    public static final double versionCode = 3.010;//版本号

    public static IWXAPI mWxApi;
    private static Context sContext;

    private static MyApplication homeApplication;


    /**
     * 正式版
     **/
//    public static String BASE_URL = "http://pc.yunvip123.com/";
    public static String BASE_URL = "https://pcbeta.yunvip123.com/";

    public static String IMAGE_URL = "http://pc.yunvip123.com";
    public static String CTMONEY_URL = "http://core.yunvip123.com/";
//    public static String CTMONEY_URL = "http://corebeta.yunvip123.com/";


    /***
     *测试版
     *
     */
//    public static  String BASE_URL = "http://pcbeta.yunvip123.com/api/";
//    public static  String IMAGE_URL = "http://pcbeta.yunvip123.com";
//    public static  String CTMONEY_URL = "http://admin.znheqi.com/";


    /**
     * logo
     */
    public static Bitmap HYCZ_LOGO, HYCC_LOGO, SPXF_LOGO, KSXF_LOGO, JCXF_LOGO, JFDH_LOGO,
            SPTH_LOGO, JB_LOGO, FTXF_LOGO, HYSK_LOGO, TCXF_LOGO, OPENCARD_LOGO, RK_LOGO, CK_LOGO;
    /**
     * 二维码
     */
    public static Bitmap HYCZ_QR, HYCC_QR, SPXF_QR, KSXF_QR, JCXF_QR, JFDH_QR,
            SPTH_QR, JB_QR, FTXF_QR, HYSK_QR, TCXF_QR, OPENCARD_QR, RK_QR, CK_QR;

    /**
     * 会员充次
     */
    public static Map<String, String> mTimesRechargeMap;
    /**
     * 会员充值
     */
    public static Map<String, String> mRechargeMap;
    /**
     * 商品消费
     */
    public static Map<String, String> mGoodsConsumeMap;
    /**
     * 计次消费
     */
    public static Map<String, String> mTimesConsumeMap;
    /**
     * 积分兑换
     */
    public static Map<String, String> mIntegralExchangeMap;
    /**
     * 快速消费
     */
    public static Map<String, String> mFastConsumeMap;
    /**
     * 套餐消费
     */
    public static Map<String, String> mTCConsumeMap;
    /**
     * 会员开卡
     */
    public static Map<String, String> mCardOpenMap;

    /**
     * 商品入库
     */
    public static Map<String, String> mGoodsIn;

    /**
     * 商品出库
     */
    public static Map<String, String> mGoodsOut;

    /**
     * 商品退货
     */
    public static Map<String, String> mReTureOrder;

    /**
     * 交班
     */
    public static Map<String, String> mHandOverMap;

    /**
     * 打印是否开启
     */
    public static boolean PRINT_IS_OPEN = false;

    /**
     * 标签打印是否开启
     */
    public static boolean LABELPRINT_IS_OPEN = false;

    /**
     * 标签打印是否开启
     */
    public static int LABEL_TYPE = 0;

    /**
     * 蓝牙打印机列表
     */
    public static List<String> mPrintList;

    /**
     * 是否发送短信
     */
    public static boolean shortMessage;

    /**
     * 是否是弹窗
     * 1是 0否
     */
    public static String isDialog = "0";

    /**
     * 店铺名称
     */
    public static String SHOP_NAME = "";

    /**
     * 小票打印份数
     */
    public static int SPXF_PRINT_TIMES = 1;
    public static int JB_PRINT_TIMES = 1;

    public static LoginBean loginBean;//登录数据

    public static IMyBinder myBinder;
    public static boolean ISLABELCONNECT = false;//USB标签打印机
    public static boolean ISBULETOOTHCONNECT = false;//蓝牙小票打印机
    public static boolean ISCONNECT = false;//USB小票打印机


    public static MyApplication getInstance() {
        return homeApplication;
    }


    ServiceConnection mSerconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (IMyBinder) service;
            Log.e("myBinder", "connect");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("myBinder", "disconnect");
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        homeApplication = this;
        sContext = this;

        mTimesRechargeMap = new HashMap<>();
        mRechargeMap = new HashMap<>();
        mGoodsConsumeMap = new HashMap<>();
        mTimesConsumeMap = new HashMap<>();
        mIntegralExchangeMap = new HashMap<>();
        mFastConsumeMap = new HashMap<>();
        mTCConsumeMap = new HashMap<>();
        mCardOpenMap = new HashMap<>();
        mHandOverMap = new HashMap<>();
        mGoodsIn = new HashMap<>();
        mGoodsOut = new HashMap<>();
        mReTureOrder = new HashMap<>();

        //全局异常捕获
        CrashHandler.getInstance().init(this);

        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                // other setters
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        onLanguageChange();
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);
        // 将该app注册到微信
        mWxApi.registerApp(Constants.APP_ID);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUtils.d("xxapp", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
        Intent intent = new Intent(this, PosprinterService.class);
        bindService(intent, mSerconnection, BIND_AUTO_CREATE);

    }

    public static Context getContext() {
        return sContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(AppLanguageUtils.attachBaseContext(base, getAppLanguage(base)));
    }

    /**
     * Handling Configuration Changes
     *
     * @param newConfig newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        onLanguageChange();
    }

    private void onLanguageChange() {
        AppLanguageUtils.changeAppLanguage(this, AppLanguageUtils.getSupportLanguage(getAppLanguage(this)));
    }

    private String getAppLanguage(Context context) {
        String language;
        if (PreferenceHelper.readString(context, "lottery", "lagavage", "").equals("")) {
            Locale locale = context.getResources().getConfiguration().locale;
            language = locale.getLanguage();
        } else {
            language = PreferenceHelper.readString(context, "lottery", "lagavage", "");
        }
        PreferenceHelper.write(context, "lottery", "lagavage", language);
        return language;
    }


    public static String getLoginBean() {
        String result = null;
        String loginResultString = null;
        try {
            String JSESSIONID = null;

            final PersistentCookieStore myCookieStore = new PersistentCookieStore(sContext);
            List<Cookie> cookies = myCookieStore.getCookies();

            for (int i = 0; i < cookies.size(); i++) {
                if (cookies.get(i).getName().equals("ASP.NET_SessionId") && BASE_URL.contains(cookies.get(i).getDomain())) {//.yunvip123.com
                    JSESSIONID = cookies.get(i).getValue();
                }
            }

            result = JSESSIONID;

            loginBean.setSessionId(result);
            Gson gson = new Gson();
            loginResultString = gson.toJson(loginBean);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return loginResultString;
    }
}

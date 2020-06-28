package com.wycd.yushangpu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
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
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.tools.AppLanguageUtils;
import com.wycd.yushangpu.tools.CrashHandler;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.wxapi.Constants;

import net.posprinter.posprinterface.IMyBinder;
import net.posprinter.service.PosprinterService;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import androidx.multidex.MultiDexApplication;
import cz.msebera.android.httpclient.cookie.Cookie;

/**
 * Created by songxiaotao on 2018/5/28.
 */

public class MyApplication extends MultiDexApplication {

    public static final double versionCode = 3.013;//版本号

    public static IWXAPI mWxApi;
    private static Context sContext;

    private static MyApplication homeApplication;


    /**
     * 正式版
     **/
    public static String BASE_URL = "http://pc.yunvip123.com/";
//    public static String BASE_URL = "https://pcbeta.yunvip123.com/";

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
     * 是否发送短信
     */
    public static boolean shortMessage;

    /**
     * 店铺名称
     */
    public static String SHOP_NAME = "";

    public static LoginBean loginBean;//登录数据

    public static IMyBinder myBinder;


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

package com.wycd.yushangpu.web;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.loopj.android.http.PersistentCookieStore;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.tools.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cz.msebera.android.httpclient.cookie.Cookie;


public class WebDialog extends Dialog {

    /**
     * 用于展示在web端<input type=text>的标签被选择之后，文件选择器的制作和生成
     */

    private static WebView webView;
    private LinearLayout llmain;
    private ValueCallback<Uri> uploadFile;
    private ValueCallback<Uri[]> uploadFiles;
    private long firstTime = 0;
    String versionDownURL;

    private static Activity ac;
    private int mwidth;
    private int mheight;
    //    private static Dialog dialog;
    //Usb连接
    private PendingIntent mPermissionIntent;
    private UsbManager mUsbManager;
    private UsbDeviceConnection mUsbDeviceConnection;

    private UsbEndpoint ep, printerEp;
    private UsbInterface usbInterface;
    private static final int TIME_OUT = 10000;
    public static final String ACTION_USB_PERMISSION = "com.usb.printer.USB_PERMISSION";

    private List<String> printNameList;


    public WebDialog(Activity activity, int width, int height, String url) {
        super(activity, R.style.Dialog_Fullscreen);

        this.ac = activity;
        this.versionDownURL = url;
        this.mwidth = width;
        this.mheight = height;
//        dialog = LoadingDialog.loadingDialog(activity, 1);

//        Window window = this.getWindow();
//        WindowManager.LayoutParams wl = window.getAttributes();
//        wl.x = 0;
//        wl.y = mheight;
////                ((Activity) activity).getWindowManager().getDefaultDisplay().getHeight();
//        // 以下这两句是为了保证按钮可以水平满屏
//        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        wl.height = ViewGroup.LayoutParams.MATCH_PARENT;
//
//        this.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        this.setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //获取连接的USB设备
//        init(ac);
        //初始化界面
        initview();
        //加载数据
        initData();


    }


    private void initData() {
//        versionDownURL=getIntent().getStringExtra("versionDownURL");
//        loginBean = (LoginBean) CacheData.restoreObject("login");
//        loginString = (String) CacheData.restoreObject("LOGINSTRING");

        initHardwareAccelerate();
//        dialog.show();


        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDefaultTextEncodingName("utf-8");
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        //本地存储
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);


//        webView.setWebChromeClient(new WebChromeClient() {
//            // For Android 3.0+
//            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
//                Log.i("test", "openFileChooser 1");
//                uploadFile = uploadFile;
////                openFileChooseProcess();
//            }
//
//            // For Android < 3.0
//            public void openFileChooser(ValueCallback<Uri> uploadMsgs) {
//                Log.i("test", "openFileChooser 2");
//                uploadFile = uploadFile;
////                openFileChooseProcess();
//            }
//
//            // For Android  > 4.1.1
//            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
//                Log.i("test", "openFileChooser 3");
//                uploadFile = uploadFile;
////                openFileChooseProcess();
//            }
//
//            // For Android  >= 5.0
//            public boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView,
//                                             ValueCallback<Uri[]> filePathCallback,
//                                             WebChromeClient.FileChooserParams fileChooserParams) {
//                Log.i("test", "openFileChooser 4:" + filePathCallback.toString());
//                uploadFiles = filePathCallback;
////                openFileChooseProcess();
//                return true;
//            }
//
//        });

//        syncCookie(ac,versionDownURL);

        webView.loadUrl(versionDownURL);
        // 传入一个Java对象和一个接口名,在JavaScript代码中用这个接口名代替这个对象,通过接口名调用Android接口的方法
        webView.addJavascriptInterface(new JavascriptInterfaceImpl(ac, webView), "TS_AndroidApi");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242

//                if (url.toString().contains("sina.cn")){
//                    view.loadUrl("http://ask.csdn.net/questions/178242");
//                    return true;
//                }
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                dialog.dismiss();

            }
        });


    }


    /**
     * 给WebView同步Cookie
     *
     * @param context 上下文
     * @param url     可以使用[domain][host]
     */
    private void syncCookie(Context context, String url) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();// 移除旧的[可以省略]
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        List<Cookie> cookies = myCookieStore.getCookies();
        for (int i = 0; i < cookies.size(); i++) {
            Cookie cookie = cookies.get(i);
            String value = cookie.getName() + "=" + cookie.getValue();
            cookieManager.setCookie(url, value);
        }
        CookieSyncManager.getInstance().sync();// To get instant sync instead of waiting for the timer to trigger, the host can call this.
    }


    private void initview() {

        llmain = (LinearLayout) findViewById(R.id.main);
        webView = (WebView) findViewById(R.id.xweb);
        ViewGroup.LayoutParams params = llmain.getLayoutParams();
        params.height = dip2px(ac, mheight);
        params.width = dip2px(ac, mwidth);
        llmain.setLayoutParams(params);


        Button btn = (Button) findViewById(R.id.btn_close);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebDialog.this.dismiss();
            }
        });
    }

    /**
     * 启用硬件加速
     */
    private void initHardwareAccelerate() {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                getWindow()
                        .setFlags(
                                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                dismiss();
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void init(Activity context) {
//        list.clear();
        mUsbManager = (UsbManager) ac.getSystemService(Context.USB_SERVICE);
        mPermissionIntent = PendingIntent.getBroadcast(ac, 0, new Intent(ACTION_USB_PERMISSION), 0);
        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        ac.registerReceiver(mUsbDeviceReceiver, filter);

        // 列出所有的USB设备，并且都请求获取USB权限
        HashMap<String, UsbDevice> deviceList = mUsbManager.getDeviceList();
        printNameList = new ArrayList<>();
        for (UsbDevice device : deviceList.values()) {
            usbInterface = device.getInterface(0);
            if (usbInterface.getInterfaceClass() == 7) {//7为打印机
                Log.d("device", device.getProductName() + "     " + device.getManufacturerName());
                Log.d("device", device.getVendorId() + "     " + device.getProductId() + "      " + device.getDeviceId());
                Log.d("device", usbInterface.getInterfaceClass() + "");
                if (!mUsbManager.hasPermission(device)) {
                    mUsbManager.requestPermission(device, mPermissionIntent);
                } else {
                    connectUsbPrinter(device);
                }
            }
        }

    }

    private final BroadcastReceiver mUsbDeviceReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("action", action);
            UsbDevice mUsbDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
            if (ACTION_USB_PERMISSION.equals(action)) {
                synchronized (this) {
                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false) && mUsbDevice != null) {
                        Log.d("receiver", action);
                        connectUsbPrinter(mUsbDevice);
                    } else {
//                        ToastUtils.showToast(context, "USB设备请求被拒绝");
                        com.blankj.utilcode.util.ToastUtils.showShort("USB设备请求被拒绝");
                    }
                }
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                if (mUsbDevice != null) {
//                    ToastUtils.showToast(context, "有设备拔出");
                    com.blankj.utilcode.util.ToastUtils.showShort("有设备拔出");
                }
            } else if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
//                ToastUtils.showToast(context, "有设备插入");
                com.blankj.utilcode.util.ToastUtils.showShort("有设备插入");
                if (mUsbDevice != null) {
                    if (!mUsbManager.hasPermission(mUsbDevice)) {
                        mUsbManager.requestPermission(mUsbDevice, mPermissionIntent);
                    }
                }
            }
        }
    };

    public void close() {
        if (mUsbDeviceConnection != null) {
            mUsbDeviceConnection.close();
            mUsbDeviceConnection = null;
        }
        ac.unregisterReceiver(mUsbDeviceReceiver);
        ac = null;
        mUsbManager = null;
    }

    private void connectUsbPrinter(UsbDevice mUsbDevice) {
        if (mUsbDevice != null) {
            for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
                ep = usbInterface.getEndpoint(i);
                if (ep.getType() == UsbConstants.USB_ENDPOINT_XFER_BULK) {
                    if (ep.getDirection() == UsbConstants.USB_DIR_OUT) {
                        mUsbDeviceConnection = mUsbManager.openDevice(mUsbDevice);
                        printerEp = ep;
                        if (mUsbDeviceConnection != null) {
//                            ToastUtils.showToast(ac, "设备已连接");
                            com.blankj.utilcode.util.ToastUtils.showShort("设备已连接");
                            mUsbDeviceConnection.claimInterface(usbInterface, true);
                            mUsbDeviceConnection.releaseInterface(usbInterface);
                        }
                    }
                }
            }
        } else {
//            ToastUtils.showToast(ac, "未发现可用的打印机");
            com.blankj.utilcode.util.ToastUtils.showShort("未发现可用的打印机");
        }
    }

    private void write(byte[] bytes) {
        if (mUsbDeviceConnection != null) {
            int b = mUsbDeviceConnection.bulkTransfer(printerEp, bytes, bytes.length, TIME_OUT);
            Log.i("Return Status", "b-->" + b);
        } else {
            Looper.prepare();
            handler.sendEmptyMessage(0);
            Looper.loop();
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            ToastUtils.showToast(ac, "未发现可用的打印机");
            com.blankj.utilcode.util.ToastUtils.showShort("未发现可用的打印机");
        }
    };


//    /**
//     * 确保注销配置能够被释放
//     */
//    @Override
//    protected void onDestroy() {
//        // TODO Auto-generated method stub
//        if (this.webView != null) {
//            webView.destroy();
//        }
//        super.onDestroy();
//        ac.unregisterReceiver(receiver);
//    }


}

package com.wycd.yushangpu.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.wycd.yushangpu.ui.Presentation.GuestShowPresentation;
import com.wycd.yushangpu.widget.dialog.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by songxiaotao on 2018/1/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = "TAG";

    public Dialog dialog;
    public Resources res;
    public Activity ac;
    /**
     * 小键盘
     */
    protected InputMethodManager mInputMethodManager;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = LoadingDialog.loadingDialog(BaseActivity.this, 1);
        ac = this;
//        setNavigationBar();
        res = getResources();
//        initLocaleLanguage();
//        ImmersionBar.with(this).statusBarDarkFont(true, 0.2f) //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//                .init();
        init();
        //输入法
        mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        //底部虚拟键始终隐藏，触摸屏幕时也不出现
//        Window _window = getWindow();
//        WindowManager.LayoutParams params = _window.getAttributes();
//        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
//        _window.setAttributes(params);
    }

    protected void init() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        ac = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        dialog.dismiss();
    }

    /*防止系统字体影响到app的字体*/
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 必须调用该方法，防止内存泄漏
        ImmersionBar.with(this).destroy();
    }

    /**
     * 申请后的处理
     */
    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            List<String> deniedList = new ArrayList<>();
            // 遍历所有申请的权限，把被拒绝的权限放入集合
            for (int i = 0; i < grantResults.length; i++) {
                int grantResult = grantResults[i];
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
//                    mListener.granted();
                } else {
                    deniedList.add(permissions[i]);
                }
            }
            if (!deniedList.isEmpty()) {
//                mListener.denied(deniedList);
            }
        }
    }

    /**
     * 点击空白隐藏小键盘
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // getCurrentFocus()是获取当前activity中获得焦点的view
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
                mInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) hideSoftInput(v.getWindowToken());
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            showPresentation();
        }
    }

    public void showPresentation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                DisplayManager mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
                Display[] displays = mDisplayManager.getDisplays();
                if (displays.length > 1) {
                    if (GuestShowPresentation.guestShowPresentation == null) {
                        GuestShowPresentation.guestShowPresentation = new GuestShowPresentation(ac, displays[1]);//displays[1]是副屏
                        GuestShowPresentation.guestShowPresentation.getWindow().setType(WindowManager.LayoutParams.TYPE_PHONE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                            GuestShowPresentation.guestShowPresentation.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
                    }
                    GuestShowPresentation.guestShowPresentation.show();
                }
            }
        }
    }
}

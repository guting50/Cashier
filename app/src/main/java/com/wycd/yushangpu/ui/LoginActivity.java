package com.wycd.yushangpu.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ClassMsg;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.db.SaveObjectName;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpLogin;
import com.wycd.yushangpu.model.ImpShopClass;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.KeyBoardHelper;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.ScreenUtils;
import com.wycd.yushangpu.tools.ShadowUtils;
import com.wycd.yushangpu.tools.ToastUtils;
import com.wycd.yushangpu.views.ClearEditText;
import com.yanzhenjie.permission.AndPermission;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.et_login_account)
    ClearEditText mEtLoginAccount;
    @Bind(R.id.et_login_password)
    ClearEditText mEtLoginPassword;
    @Bind(R.id.rl_login)
    RelativeLayout mRlLogin;
    @Bind(R.id.li_bg)
    LinearLayout mLiBg;

    @Bind(R.id.login_cb)
    CheckBox cb;
    private LoginBean loginBean;

    private int screenHeight;
    private View layout_content;
    private View layout_bottom;
    private int bottomHeight;
    private KeyBoardHelper boardHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initEvent();
        ShadowUtils.setShadowBackgroud(ac, res, mLiBg);
        mEtLoginAccount.setText(PreferenceHelper.readString(ac, "lottery", "account", ""));
        if (PreferenceHelper.readBoolean(ac, "lottery", "remember", false)) {
            cb.setChecked(true);
            mEtLoginPassword.setText(PreferenceHelper.readString(ac, "lottery", "pwd", ""));
        }

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
                    PreferenceHelper.write(ac, "lottery", "remember", b);

            }
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AndPermission.with(this)
                .requestCode(100)
                .permission(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                .send();

    }


    private void initEvent() {
        layout_content = findViewById(R.id.layout_content);
        layout_bottom = findViewById(R.id.layout_bottom);

        boardHelper = new KeyBoardHelper(this);
        boardHelper.onCreate();
        boardHelper.setOnKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener);
//        layout_bottom.post(new Runnable() {
//            @Override
//            public void run() {
//                bottomHeight = layout_bottom.getHeight();
//                Log.i("vlog","=================bottomHeight:"+bottomHeight);
//            }
//        });

        mRlLogin.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {


                if (mEtLoginAccount.getText().toString().equals("")) {
//                    ToastUtils.showToast(ac, res.getString(R.string.enter_email_mobile));
                    com.blankj.utilcode.util.ToastUtils.showShort(res.getString(R.string.enter_email_mobile));
                } else if (mEtLoginPassword.getText().toString().equals("")) {
//                    ToastUtils.showToast(ac, res.getString(R.string.enter_password));
                    com.blankj.utilcode.util.ToastUtils.showShort(res.getString(R.string.enter_password));
                } else {
                dialog.show();
//                    17780716425  121121
                ImpLogin login = new ImpLogin();
                login.login(ac, mEtLoginAccount.getText().toString(), mEtLoginPassword.getText().toString(), new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        Gson gson = new Gson();
                        String resultString = (String) response;
                        loginBean = gson.fromJson(resultString,LoginBean.class);

                        dialog.dismiss();
                        //保存登录账号密码
                        PreferenceHelper.write(ac, "lottery", "account", mEtLoginAccount.getText().toString());
                        PreferenceHelper.write(ac, "lottery", "pwd", mEtLoginPassword.getText().toString());

                        if (loginBean.getData().getShopList().get(0).getSM_Type() == 3009){
                            MyApplication.LABELPRINT_IS_OPEN = true;
                        }
                        MyApplication.SHOP_NAME = loginBean.getData().getSM_Name();

                        Intent intent = new Intent(ac, HomeActivity.class);
//                        intent.putExtra("class", (Serializable) onelist);
                        intent.putExtra("loginBean", (Serializable) loginBean);
                        startActivity(intent);
                        finish();

                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        dialog.dismiss();
                    }
                });

                }
            }
        });
    }


    private KeyBoardHelper.OnKeyBoardStatusChangeListener onKeyBoardStatusChangeListener = new KeyBoardHelper.OnKeyBoardStatusChangeListener() {
        @Override
        public void OnKeyBoardPop(int keyBoardheight) {
            final int height = keyBoardheight;
            if (bottomHeight > height) {
//                layout_bottom.setVisibility(View.GONE);
            } else {
//                int offset = bottomHeight - height;
                int offset = 200 - height;
                final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                        .getLayoutParams();
                //当offset为负数时，layout_content向上移
                lp.topMargin = offset;
                layout_content.setLayoutParams(lp);
            }
        }
        @Override
        public void OnKeyBoardClose(int oldKeyBoardheight) {
            if (View.VISIBLE != layout_bottom.getVisibility()) {
                layout_bottom.setVisibility(View.VISIBLE);
            }
            final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                    .getLayoutParams();
            if (lp.topMargin != 0) {
                lp.topMargin = 0;
                layout_content.setLayoutParams(lp);
            }
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        boardHelper.onDestory();

    }
}

package com.wycd.yushangpu.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.gt.utils.base64.BASE64Decoder;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpLogin;
import com.wycd.yushangpu.model.ImpPreLoading;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.tools.KeyBoardHelper;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.ShadowUtils;
import com.yanzhenjie.permission.AndPermission;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_login_account)
    TextInputEditText mEtLoginAccount;
    @BindView(R.id.et_login_password)
    TextInputEditText mEtLoginPassword;
    @BindView(R.id.et_verification_code)
    TextInputEditText mVerificationCode;
    @BindView(R.id.rl_login)
    TextView mRlLogin;
    @BindView(R.id.li_bg)
    LinearLayout mLiBg;
    @BindView(R.id.iv_code)
    ImageView ivCode;

    @BindView(R.id.login_cb)
    CheckBox cb;

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
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
        layout_content.post(new Runnable() {
            @Override
            public void run() {
                int[] location = new int[2];
                layout_content.getLocationInWindow(location);
                layout_content.getLocationOnScreen(location);
                bottomHeight = ((View) layout_content.getParent()).getHeight() - location[1] - layout_content.getHeight();
                Log.i("vlog", "=================bottomHeight:" + bottomHeight);
            }
        });

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
                    login.login(ac, mEtLoginAccount.getText().toString(), mEtLoginPassword.getText().toString(), mVerificationCode.getText().toString(), new InterfaceBack() {

                        @Override
                        public void onResponse(Object response) {
                            Gson gson = new Gson();
                            String resultString = (String) response;
                            MyApplication.loginBean = gson.fromJson(resultString, LoginBean.class);

//                        dialog.dismiss();
                            //保存登录账号密码
                            PreferenceHelper.write(ac, "lottery", "account", mEtLoginAccount.getText().toString());
                            PreferenceHelper.write(ac, "lottery", "pwd", mEtLoginPassword.getText().toString());

                            if (MyApplication.loginBean.getData().getShopList().get(0).getSM_Type() == 3009) {
                                MyApplication.LABELPRINT_IS_OPEN = true;
                            }
                            MyApplication.SHOP_NAME = MyApplication.loginBean.getData().getSM_Name();
                            startActivity(new Intent(ac, HomeActivity.class));
                            finish();

                            ImpPreLoading.preLoad(ac);
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            dialog.dismiss();
                            getCode();
                        }
                    });

                }
            }
        });
    }

    @OnClick({R.id.iv_get_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_get_code:
                getCode();
                break;
        }
    }

    private void getCode() {
        ((View) ivCode.getParent()).setVisibility(View.VISIBLE);
        new ImpLogin().getCode(ac, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                String imageDate = response.toString();
                BASE64Decoder decoder = new BASE64Decoder();
                try {
                    Glide.with(ac).load(decoder.decodeBuffer(imageDate))
                            .transform(new GlideTransform.GlideCornersTransform(ac, 5))
                            .into(ivCode);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
    }


    private KeyBoardHelper.OnKeyBoardStatusChangeListener onKeyBoardStatusChangeListener = new KeyBoardHelper.OnKeyBoardStatusChangeListener() {
        @Override
        public void OnKeyBoardPop(int keyBoardheight) {
            if (bottomHeight < keyBoardheight) {
                int offset = 180 - keyBoardheight;
                final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                        .getLayoutParams();
                //当offset为负数时，layout_content向上移
                lp.topMargin = offset;
                layout_content.setLayoutParams(lp);
            }
        }

        @Override
        public void OnKeyBoardClose(int oldKeyBoardheight) {
            final ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layout_content
                    .getLayoutParams();
            lp.topMargin = 0;
            layout_content.setLayoutParams(lp);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        boardHelper.onDestory();

    }
}

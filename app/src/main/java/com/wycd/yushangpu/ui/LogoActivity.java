package com.wycd.yushangpu.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;

import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.UpdateAppVersion;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class LogoActivity extends BaseActivity {

    public static String VERSION_ADDRESS = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequestParams params = new RequestParams();
        params.put("Type", 3);
        AsyncHttpUtils.postHttp(ac, HttpAPI.API().GET_NEWS_VERSION, params, new InterfaceBack<BaseRes>() {
            @Override
            public void onResponse(BaseRes response) {
                try {
                    // 获取包信息
                    // 参1 包名 参2 获取额外信息的flag 不需要的话 写0
                    PackageInfo packageInfo = getPackageManager().getPackageInfo(
                            getPackageName(), 0);
                    Map<String, Object> baen = response.getData(Map.class);
                    String version = baen.get("VA_Version").toString();
                    if (Double.parseDouble(version) > packageInfo.versionCode) {
                        VERSION_ADDRESS = MyApplication.CTMONEY_URL + baen.get("VA_VersionAddress").toString();
                        if (Double.parseDouble(baen.get("VA_UpdateMechanism").toString()) == 0) {
                            //自动升级
                            UpdateAppVersion.UpdateInfoRes updateInfoBean = new UpdateAppVersion.UpdateInfoRes();
                            updateInfoBean.setContent(baen.get("VA_Remark").toString());
                            updateInfoBean.setCurrentversion(Double.parseDouble(version));
                            updateInfoBean.setMinversionrequire(Double.parseDouble(version));
                            //updateInfoBean.setCurrentversiondesc(baen.get("VA_VersionName").toString());
                            updateInfoBean.setUrl(VERSION_ADDRESS);
                            new UpdateAppVersion(LogoActivity.this, updateInfoBean, new UpdateAppVersion.OnUpdateVersionBackListener() {
                                @Override
                                public void onBackListener() {
                                    toLoginActivity();
                                }
                            }).compareVersion();
                            return;
                        }
                    }
                    toLoginActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                    onErrorResponse(e.getMessage());
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                toLoginActivity();
            }
        });
    }

    public void toLoginActivity() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(LogoActivity.this, LoginActivity.class));
                finish();
            }
        }, 500);
    }
}

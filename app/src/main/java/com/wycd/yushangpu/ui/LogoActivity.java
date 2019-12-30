package com.wycd.yushangpu.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;

import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpLogin;
import com.wycd.yushangpu.tools.UpdateAppVersion;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class LogoActivity extends BaseActivity {

    public static String VERSION_ADDRESS = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new ImpLogin().getNewsVersion(ac, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                String imageDate = response.toString();
                try {
                    JSONObject jso = new JSONObject(imageDate);
                    String version = jso.getString("VA_Version");

                    // 获取包信息
                    // 参1 包名 参2 获取额外信息的flag 不需要的话 写0
                    PackageInfo packageInfo = getPackageManager().getPackageInfo(
                            getPackageName(), 0);
                    if (Double.parseDouble(version) > packageInfo.versionCode) {
                        VERSION_ADDRESS = jso.getString("VA_VersionAddress");
                        if (jso.getInt("VA_UpdateMechanism") == 0) {
                            //自动升级
                            UpdateAppVersion.UpdateInfoRes updateInfoBean = new UpdateAppVersion.UpdateInfoRes();
                            updateInfoBean.setContent(jso.getString("VA_Remark"));
                            updateInfoBean.setCurrentversion(Double.parseDouble(version));
                            updateInfoBean.setMinversionrequire(Double.parseDouble(version));
                            updateInfoBean.setCurrentversiondesc(jso.getString("VA_VersionName"));
                            updateInfoBean.setUrl(jso.getString("VA_VersionAddress"));
                            new UpdateAppVersion(LogoActivity.this, updateInfoBean, new UpdateAppVersion.OnUpdateVersionBackListener() {
                                @Override
                                public void onBackListener() {
                                    toLoginActivity();
                                }
                            }).compareVersion();
                        } else {
                            toLoginActivity();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    toLoginActivity();
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

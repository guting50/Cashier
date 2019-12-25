package com.wycd.yushangpu.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpLogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class LogoActivity extends BaseActivity {

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
                    if (Integer.parseInt(version) > packageInfo.versionCode) {
                        if(jso.getInt("VA_UpdateMechanism") == 0){
                            //自动升级
                        }else{
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(LogoActivity.this, LoginActivity.class));
                                    finish();
                                }
                            }, 500);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(LogoActivity.this, LoginActivity.class));
                finish();
            }
        }, 500);

    }
}

package com.wycd.yushangpu.http;

import android.app.Activity;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.Installation;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.SignUtils;
import com.wycd.yushangpu.tools.ToastUtils;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/5.
 */

public class AsyncHttpUtls {
    public static void postHttp(final Activity ac, String url, RequestParams map, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        //        api_version: 0.0.1                  (必须) 接口版本号
//        content_type: application/json      (必须) 接口请求数据格式
//        platform: web                       (必须) 支持选项：[iOS, android]
//        language: cn                        (必须) 支持选项：[cn, en]
//        uuid:111                            (必须) 手机唯一标识码
//        system_version:9.0                  (必须) 手机系统版本
//        token:                              (必须)
        client.addHeader("api_version", "0.0.1");
        client.addHeader("content_type", "application/json");
        client.addHeader("platform", "android");
        client.addHeader("language", PreferenceHelper.readString(ac, "lottery", "lagavage", "cn"));
        client.addHeader("uuid", Installation.id(ac));
        client.addHeader("system_version", CommonUtils.getVersionName(ac));
        client.addHeader("token", PreferenceHelper.readString(ac, "lottery", "token", ""));
//        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
//        client.setCookieStore(myCookieStore);
        LogUtils.d("xxurl", url);
        LogUtils.d("xxmap", new Gson().toJson(map));
        client.post(url, map, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxmsg", SignUtils.decode(new String(responseBody, "UTF-8")));
                    JSONObject jso = new JSONObject(SignUtils.decode(new String(responseBody, "UTF-8")));
                    if (jso.getInt("status") == 0) {
                        back.onResponse(jso.getString("data"));
                    } else {
//                        if (jso.getInt("status") == 106) {
//                            PreferenceHelper.write(ac, "carapp", "token", "");
//                            ActivityStack.create().finishAllActivity();
//                            Intent intent = new Intent(ac, LoginActivity.class);
//                            ac.startActivity(intent);
//                        }
                        back.onErrorResponse("");
//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                    }
                } catch (Exception e) {
                    back.onErrorResponse("");
                    e.printStackTrace();
//                    ToastUtils.showToast(ac, "服务异常，请稍后再试");
//                    com.blankj.utilcode.util.ToastUtils.showShort("服务异常，请稍后再试");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                back.onErrorResponse("");
//                ToastUtils.showToast(ac, "服务异常，请稍后再试");
                com.blankj.utilcode.util.ToastUtils.showShort("服务异常，请稍后再试");
            }
        });
    }

    public static void getHttp(final Activity ac, String url, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("api_version", "0.0.1");
        client.addHeader("content_type", "application/json");
        client.addHeader("platform", "android");
        client.addHeader("language", PreferenceHelper.readString(ac, "lottery", "lagavage", "cn"));
        client.addHeader("uuid", Installation.id(ac));
        client.addHeader("system_version", CommonUtils.getVersionName(ac));
        client.addHeader("token", PreferenceHelper.readString(ac, "lottery", "token", ""));
        LogUtils.d("xxurl", url);
        client.get(ac, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxmsg", SignUtils.decode(new String(responseBody, "UTF-8")));
                    JSONObject jso = new JSONObject(SignUtils.decode(new String(responseBody, "UTF-8")));
                    if (jso.getInt("status") == 0) {
                        back.onResponse(jso.getString("data"));
                    } else {
//                        if (jso.getInt("status") == 106) {
//                            PreferenceHelper.write(ac, "carapp", "token", "");
//                            ActivityStack.create().finishAllActivity();
//                            Intent intent = new Intent(ac, LoginActivity.class);
//                            ac.startActivity(intent);
//                        }

//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort( jso.getString("msg"));
                        back.onErrorResponse("");
                    }
                } catch (Exception e) {
                    back.onErrorResponse("");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                back.onErrorResponse("");
//                ToastUtils.showToast(ac, "服务异常，请稍后再试");
                com.blankj.utilcode.util.ToastUtils.showShort("服务异常，请稍后再试");
            }
        });
    }
}

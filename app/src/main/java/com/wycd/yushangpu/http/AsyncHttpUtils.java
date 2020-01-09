package com.wycd.yushangpu.http;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.Installation;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.SignUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/5.
 */

public class AsyncHttpUtils {

    public static void postHttp(final Activity ac, String url, final InterfaceBack back) {
        RequestParams params = new RequestParams();
        postHttp(ac, url, params, back);
    }

    public static void postHttp(final Activity ac, String url, RequestParams map, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        LogUtils.d("======== url ======== >>>", url);
        LogUtils.d("======== params ======== >>>", new Gson().toJson(map));
        client.post(url, map, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody, "UTF-8");
                    LogUtils.d("<<< ======== url ======== ", url);
                    LogUtils.d("<<< ======== result ======== ", result);
                    Type type = new TypeToken<BaseRes>() {
                    }.getType();
                    BaseRes baseRes = new Gson().fromJson(result, type);
                    if (baseRes.isSuccess()) {
                        back.onResponse(baseRes);
                    } else {
                        if (baseRes.getCode() != null &&
                                (baseRes.getCode().equals("RemoteLogin") || baseRes.getCode().equals("LoginTimeout"))) {
                            ActivityManager.getInstance().exit();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            com.blankj.utilcode.util.ToastUtils.showShort(baseRes.getMsg());
                            return;
                        }
                        com.blankj.utilcode.util.ToastUtils.showShort(baseRes.getMsg());
                        back.onErrorResponse(baseRes);
                    }
                } catch (Exception e) {
                    back.onErrorResponse(e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String errorMsg = new String(responseBody, "UTF-8");
                    back.onErrorResponse(errorMsg);
                    com.blankj.utilcode.util.ToastUtils.showShort("服务异常，请稍后再试");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getHttp(final Activity ac, String url, final InterfaceBack<String> back) {
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
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
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

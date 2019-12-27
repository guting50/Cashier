package com.wycd.yushangpu.model;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpLogin {

    private static HashMap<String, String> CookieContiner = new HashMap<String, String>();
    public static String cookie;

    public void login(final Activity ac, final String UserAcount, final String PassWord, String verifyCode,
                      final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("UserAcount", UserAcount);
        params.put("PassWord", PassWord);
//        客户端类型 1.网页 2.安卓 APP 3.PC客户端 4.苹果APP 5.触屏收银
        params.put("Type", "5");
        if (!TextUtils.isEmpty(verifyCode))
            params.put("VerifyCode", verifyCode);
        String url = HttpAPI.API().LOGIN;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    if (headers == null) {
                        return;
                    } else {
                        for (int i = 0; i < headers.length; i++) {
                            String cookie = headers[i].getValue();
                            String[] cookievalues = cookie.split(";");
                            for (int j = 0; j < cookievalues.length; j++) {
                                String[] keyPair = cookievalues[j].split("=");
                                String key = keyPair[0].trim();
                                String value = keyPair.length > 1 ? keyPair[1].trim() : "";
                                CookieContiner.put(key, value);
                            }
                        }
                        AddCookies();
                    }
                    LogUtils.d("xxLoginS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso.toString());
                        PreferenceHelper.write(ac, "yunshangpu", "UserAcount", UserAcount);
                        PreferenceHelper.write(ac, "yunshangpu", "PassWord", PassWord);
                    } else {
//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse(jso.getString("msg"));
                    }
                } catch (Exception e) {
//                    ToastUtils.showToast(ac, "登录失败，请重新登录");
//                    com.blankj.utilcode.util.ToastUtils.showShort("登录失败，请重新登录");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "登录失败，请重新登录");
                com.blankj.utilcode.util.ToastUtils.showShort("登录失败，请重新登录");
                LogUtils.d("xxerror", error.getMessage() + "");
                back.onErrorResponse("");
            }
        });
    }

    /**
     * 增加Cookie
     *
     * @param
     */
    @SuppressWarnings("rawtypes")
    public void AddCookies() {
        StringBuilder sb = new StringBuilder();
        Iterator iter = CookieContiner.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = entry.getKey().toString();
            String val = entry.getValue().toString();
            sb.append(key);
            sb.append("=");
            sb.append(val);
            sb.append(";");
        }
        cookie = sb.toString();
    }

    public void getCode(final Activity ac, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();

        String url = HttpAPI.API().GET_CODE;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxoutLoginS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso.get("data"));
                    } else {
                        if (jso.getString("code").equals("RemoteLogin") || jso.getString("code").equals("LoginTimeout")) {
                            ActivityManager.getInstance().exit();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                            return;
                        }
//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse("");
                    }
                } catch (Exception e) {
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "获取店铺信息失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取验证码失败");
                LogUtils.d("xxerror", error.getMessage());
                back.onErrorResponse("");
            }
        });
    }


    public void getNewsVersion(final Activity ac, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();

        params.put("Code", 3);
        String url = HttpAPI.API().GET_NEWS_VERSION;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxoutLoginS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso.get("data"));
                    } else {
                        if (jso.getString("code").equals("RemoteLogin") || jso.getString("code").equals("LoginTimeout")) {
                            ActivityManager.getInstance().exit();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                            return;
                        }
//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse("");
                    }
                } catch (Exception e) {
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "获取店铺信息失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取版本更新失败");
                LogUtils.d("xxerror", error.getMessage());
                back.onErrorResponse("");
            }
        });
    }
}

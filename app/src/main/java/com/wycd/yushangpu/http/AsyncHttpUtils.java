package com.wycd.yushangpu.http;

import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/5.
 */

public class AsyncHttpUtils {

    public static void postHttp(String url, CallBack back) {
        RequestParams params = new RequestParams();
        postHttp(url, params, back);
    }

    public static void postHttp(String url, RequestParams map, CallBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(MyApplication.getContext());
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
                    back.onErrorResponse(errorMsg + error.getMessage());
                    com.blankj.utilcode.util.ToastUtils.showShort("服务异常，请稍后再试");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

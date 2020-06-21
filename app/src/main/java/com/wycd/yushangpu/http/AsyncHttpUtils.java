package com.wycd.yushangpu.http;

import android.content.Intent;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gt.utils.GsonUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

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
        postHttp(new AsyncHttpClient(), url, map, back);
    }

    public static void postSyncHttp(String url, CallBack back) {
        RequestParams params = new RequestParams();
        postSyncHttp(url, params, back);
    }

    public static void postSyncHttp(String url, RequestParams map, CallBack back) {
        postHttp(new SyncHttpClient(), url, map, back);
    }

    public static void postHttp(AsyncHttpClient httpClient, String url, RequestParams map, CallBack back) {
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(MyApplication.getContext());
        httpClient.setCookieStore(myCookieStore);
        LogUtils.d(">>> ======== url    ======== >>>", url);
        Class clazz = map.getClass();
        try {
            Field field = clazz.getDeclaredField("urlParams");
            field.setAccessible(true);
            ConcurrentHashMap hashMap = GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(field.get(map)), ConcurrentHashMap.class);

            field = clazz.getDeclaredField("urlParamsWithObjects");
            field.setAccessible(true);
            hashMap.putAll((ConcurrentHashMap) field.get(map));
            LogUtils.d(">>> ======== params ======== >>>", GsonUtils.getGson().toJson(hashMap));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(">>> ======== params ======== >>>", map.toString());
        }

        httpClient.post(url, map, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody, "UTF-8");
                    LogUtils.d("<<< ======== url    ======== <<<", url);
                    LogUtils.d("<<< ======== result ======== <<<", result);
                    BaseRes baseRes = GsonUtils.getGson().fromJson(result, BaseRes.class);
                    if (baseRes.isSuccess()) {
                        back.onResponse(baseRes);
                    } else {
                        if (baseRes.getCode() != null &&
                                (baseRes.getCode().equals("RemoteLogin") || baseRes.getCode().equals("LoginTimeout"))) {
                            ActivityUtils.finishAllActivitiesExceptNewest();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            ToastUtils.showLong(baseRes.getMsg());
                            return;
                        }
                        back.onErrorResponse(baseRes);
                    }
                } catch (Exception e) {
                    back.onErrorResponse(e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                LogUtils.e("======== Error ========", error.getMessage());
                try {
                    String errorMsg = new String(responseBody, "UTF-8");
                    back.onErrorResponse(errorMsg + error.getMessage());
                } catch (Exception e) {
                    LogUtils.e("======== Error ========", e.getMessage());
                    e.printStackTrace();
                    ToastUtils.showLong("服务异常，请稍后再试");
                }
            }
        });
    }

}

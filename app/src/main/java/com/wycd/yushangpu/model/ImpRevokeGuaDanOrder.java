package com.wycd.yushangpu.model;

/**
 * Created by ZPH on 2019-06-18.
 */

import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.GuadanList;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.UrlTools;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.ToastUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.util.List;


/**
 * 首页商品数据
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpRevokeGuaDanOrder {

    private Gson mGson = new Gson();


    public void revokeGuaDan(final Activity ac, final String gid, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("GID", gid);

        String url = HttpAPI.API().REVOKE_GUADAN;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxGuadanS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {

                        Type listType = new TypeToken<RevokeGuaDanBean>() {}.getType();

                        RevokeGuaDanBean sllist = mGson.fromJson(jso.toString(), listType);

                        back.onResponse(sllist);
//                        }
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
//                    ToastUtils.showToast(ac, "解挂失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("解挂失败");
                    LogUtils.d("xxe", e.getMessage());
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, error.getMessage());
                com.blankj.utilcode.util.ToastUtils.showShort(error.getMessage());
                LogUtils.d("xxe", error.getMessage());
                back.onErrorResponse("");
            }
        });
    }
}


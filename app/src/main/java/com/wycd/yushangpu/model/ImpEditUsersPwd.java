package com.wycd.yushangpu.model;

import android.app.Activity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.LogUtils;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ImpEditUsersPwd {

    public void editPwd(final Activity ac, String oldPwd, String newPwd
            , final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("UM_Pwd", oldPwd);
        params.put("UMNew_Pwd", newPwd);

        LogUtils.d("======== url ======== >>", HttpAPI.API().EDIT_USERPWD);
        LogUtils.d("======== params ======== >>", params.toString());
        client.post(HttpAPI.API().EDIT_USERPWD, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("<< ======== " + HttpAPI.API().EDIT_USERPWD + " result ========", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso);
                    } else {

//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse("");
                    }
                } catch (Exception e) {
//                    ToastUtils.showToast(ac, "修改密码失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("修改密码失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "修改密码失败");
                com.blankj.utilcode.util.ToastUtils.showShort("修改密码失败");
                LogUtils.d("xxerror", error.getMessage());
                back.onErrorResponse("");

            }

        });
    }
}

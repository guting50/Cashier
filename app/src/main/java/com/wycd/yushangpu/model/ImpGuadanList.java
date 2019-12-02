package com.wycd.yushangpu.model;

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
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.UrlTools;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.ToastUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * 首页商品数据
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpGuadanList {
    private List<GuadanList> shoplist = new ArrayList<>();
    private Gson mGson = new Gson();
    private int index = 1;

    public void guadanList(final Activity ac, final int PageIndex, final int PageSize, String mSmGid, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("PageIndex", PageIndex);
        params.put("PageSize", PageSize);
        params.put("CO_TypeCode", "SPXF");
        params.put("SM_GID", mSmGid);
        params.put("IdentifyingState", 20);

        String url = HttpAPI.API().QUERYALL_LIST;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxGuadanS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        JSONObject js = jso.getJSONObject("data");
                        Type listType = new TypeToken<List<GuadanList>>() {
                        }.getType();

                        List<GuadanList> sllist = mGson.fromJson(js.getString("DataList"), listType);
                        shoplist.addAll(sllist);
//                        if (index < js.getInt("PageTotal")) {
//                            index = index + 1;
//                            guadanList(ac, index, PageSize, back);
//                        } else {
                        back.onResponse(js);
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
//                    ToastUtils.showToast(ac, "获取商品数据失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("获取商品数据失败");
//                    LogUtils.d("xxe", e.getMessage());
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "获取商品数据失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取商品数据失败");
                LogUtils.d("xxe", error.getMessage());
                back.onErrorResponse("");
            }
        });
    }
}

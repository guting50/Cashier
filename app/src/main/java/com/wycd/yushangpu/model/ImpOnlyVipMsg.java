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
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpOnlyVipMsg {
    private Gson mGson = new Gson();

    public void vipMsg(final Activity ac, final String VCH_Card, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("VCH_Card", VCH_Card);
        params.put("isNeedVG", 1);//需要VGInfo的时候传1，其余不传
        String url = HttpAPI.API().QUERY_SINGLE_LIST;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        LogUtils.d("params", params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxVipS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        Type listType = new TypeToken<List<VipInfoMsg>>() {
                        }.getType();
                        List<VipInfoMsg> sllist = mGson.fromJson(jso.getString("data"), listType);
                        if (sllist != null && sllist.size() > 0)
                            back.onResponse(sllist.get(0));
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
//                        ToastUtils.showToast(ac, "获取会员信息失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("获取会员信息失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    ToastUtils.showToast(ac, "获取会员信息失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取会员信息失败");
                back.onErrorResponse("");
            }
        });
    }

    public void vipMsgs(final Activity ac, final String VCH_Card, int pageIndex, int pageSize, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("PageIndex", pageIndex);
        params.put("PageSize", pageSize);
        params.put("CardOrNameOrCellPhoneOrFace", VCH_Card);
        params.put("SM_GID", MyApplication.loginBean.getData().getShopID());
        String url = HttpAPI.API().VIPLIST;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        LogUtils.d("params", params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxVipS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso);
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
//                        ToastUtils.showToast(ac, "获取会员信息失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("获取会员信息失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    ToastUtils.showToast(ac, "获取会员信息失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取会员列表失败");
                back.onErrorResponse("");
            }
        });
    }
}

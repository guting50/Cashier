package com.wycd.yushangpu.model;

import android.app.Activity;
import android.content.Intent;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.printutil.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ImpSubmitOrder {
    public void submitOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist, boolean isGuadan,
                            final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
//        params.put("CO_OrderCode", CO_OrderCode);
        params.put("CO_OrderCode", CreateOrder.createOrder("SP"));
        params.put("OrderTime", OrderTime);
        params.put("VIP_Card", VIP_Card);
        if (VIP_Card.equals("00000")) {
            params.put("OrderType", 2);
        } else {
            params.put("OrderType", 1);
        }
        params.put("isGuadan", isGuadan);
        for (int i = 0; i < shoplist.size(); i++) {
            params.put("Goods[" + i + "][PM_GID]", shoplist.get(i).getGID());
            params.put("Goods[" + i + "][PM_Name]", shoplist.get(i).getPM_Name());
            params.put("Goods[" + i + "][PM_Number]", shoplist.get(i).getNum());
            params.put("Goods[" + i + "][PM_Money]", Decima2KeeplUtil.stringToDecimal(shoplist.get(i).getAllprice() + ""));
            params.put("Goods[" + i + "][EM_GIDList]", shoplist.get(i).getEM_GIDList());
            params.put("Goods[" + i + "][Type]", shoplist.get(i).getType());
            params.put("Goods[" + i + "][ExpiryTime]", "");
            params.put("Goods[" + i + "][WR_GIDList]", "");
            params.put("Goods[" + i + "][PM_UnitPrice]", shoplist.get(i).getPM_UnitPrice());
            params.put("Goods[" + i + "][PM_MemPrice]", shoplist.get(i).getPM_MemPrice());
            params.put("Goods[" + i + "][PM_Discount]", shoplist.get(i).getPD_Discount());//折扣后的单价除以原价
        }
        String url = HttpAPI.API().GOODS_CONSUME_SUB;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        JSONObject js = jso.getJSONObject("data");
                        OrderCanshhu canshhu = new OrderCanshhu();
                        canshhu.setCO_OrderCode(js.getString("CO_OrderCode"));
                        canshhu.setCO_Type(js.getString("CO_Type"));
                        canshhu.setGID(js.getString("GID"));
                        back.onResponse(canshhu);
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
                    e.printStackTrace();
                    LogUtils.d("xxorderE", e.getMessage());
//                    ToastUtils.showToast(ac, "提交订单失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("提交订单失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "提交订单失败");
                com.blankj.utilcode.util.ToastUtils.showShort("提交订单失败");
                back.onErrorResponse("");
            }
        });
    }

    public void submitCelerityOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, String mone,
                                    final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
//        params.put("CO_OrderCode", CO_OrderCode);
        params.put("CO_OrderCode", CreateOrder.createOrder("SP"));
        params.put("OrderTime", OrderTime);
        params.put("VIP_Card", VIP_Card);
        if (VIP_Card.equals("00000")) {
            params.put("OrderType", 2);
        } else {
            params.put("OrderType", 1);
        }
        //CO_Monetary CO_TotalPrice EM_GIDList
        params.put("CO_Monetary", mone);
        params.put("CO_TotalPrice", 1);

        String url = HttpAPI.API().GOODS_CELERITY_SUB;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        System.out.println("============================url===" + url);
        System.out.println("============================params===" + params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        JSONObject js = jso.getJSONObject("data");
                        OrderCanshhu canshhu = new OrderCanshhu();
                        canshhu.setCO_OrderCode(js.getString("CO_OrderCode"));
                        canshhu.setCO_Type(js.getString("CO_Type"));
                        canshhu.setGID(js.getString("GID"));
                        back.onResponse(canshhu);
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
                    e.printStackTrace();
                    LogUtils.d("xxorderE", e.getMessage());
//                    ToastUtils.showToast(ac, "提交订单失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("提交订单失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "提交订单失败");
                com.blankj.utilcode.util.ToastUtils.showShort("提交订单失败");
                back.onErrorResponse("");
            }
        });
    }

}

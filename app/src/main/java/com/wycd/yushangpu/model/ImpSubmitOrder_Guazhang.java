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
import com.wycd.yushangpu.http.UrlTools;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.ToastUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ZPH on 2019-06-17.
 */

public class ImpSubmitOrder_Guazhang {
    public void submitOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist, boolean isGuaZhang,
                            final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("CO_OrderCode", CO_OrderCode);
        params.put("OrderTime", OrderTime);
        params.put("VIP_Card", VIP_Card);
        params.put("OrderType", 2);

        params.put("isGuadan",false);
        params.put("isGuaZhang",isGuaZhang);
//        params.put("DisMoney",isGuaZhang);
        for (int i = 0; i < shoplist.size(); i++) {
            params.put("Goods[" + i + "][PM_GID]", shoplist.get(i).getGID());
            params.put("Goods[" + i + "][PM_Name]", shoplist.get(i).getPM_Name());
            params.put("Goods[" + i + "][PM_Number]", shoplist.get(i).getNum());
            params.put("Goods[" + i + "][PM_Money]", shoplist.get(i).getJisuanPrice());
            params.put("Goods[" + i + "][EM_GIDList]", shoplist.get(i).getEM_GIDList());
            params.put("Goods[" + i + "][Type]", shoplist.get(i).getType());
            params.put("Goods[" + i + "][ExpiryTime]", "");
            params.put("Goods[" + i + "][WR_GIDList]", "");
            params.put("Goods[" + i + "][PM_UnitPrice]", shoplist.get(i).getPM_UnitPrice());
            params.put("Goods[" + i + "][PM_MemPrice]", shoplist.get(i).getPM_MemPrice());
            params.put("Goods[" + i + "][PM_Discount]", CommonUtils.div(shoplist.get(i).getJisuanPrice(),shoplist.get(i).getPM_UnitPrice(),2));//折扣后的单价除以原价
        }
        params.put("ActivityValue","");
        String url = HttpAPI.API().CONSUME_GUAZHANG;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        JSONObject js = jso.getJSONObject("data");
                        back.onResponse(js);
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
                    LogUtils.d("xxorderE",e.getMessage());
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

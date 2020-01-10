package com.wycd.yushangpu.model;

import android.app.Activity;
import android.content.Intent;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.wycd.yushangpu.MyApplication.shortMessage;

/**
 * 首页商品数据
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpSaoma {

    public void saomaPay(final Activity ac, String Code, String Money, final String OrderGID, String OrderNo, OrderPayResult orderPayResult,
                         final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
//        Code	条码(授权码)	string	否
//        Money	金额	decimal	否
//        OrderGID	订单GID	string	否
//        OrderType	订单类型	string	否
//        OrderNo	订单编号	string	否
//        OrderPayInfo	收银台信息	OrderPayResult	否
        params.put("Code", Code);
        params.put("Money", Money);
        params.put("OrderGID", OrderGID);
        params.put("OrderType", 10);
        params.put("OrderNo", OrderNo);
        params.put("Smsg", shortMessage);

        params.put("OrderPayInfo[GiveChange]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getGiveChange() + ""));
        params.put("OrderPayInfo[PayTotalMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getPayTotalMoney() + ""));
        params.put("OrderPayInfo[DisMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getDisMoney() + ""));
        List<PayType> typelist = orderPayResult.getPayTypeList();
        for (int i = 0; i < typelist.size(); i++) {
            params.put("OrderPayInfo[PayTypeList][" + i + "][PayCode]", typelist.get(i).getPayCode());
            params.put("OrderPayInfo[PayTypeList][" + i + "][PayName]", typelist.get(i).getPayName());
            params.put("OrderPayInfo[PayTypeList][" + i + "][PayMoney]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayMoney() + ""));
            params.put("OrderPayInfo[PayTypeList][" + i + "][PayPoint]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayPoint() + ""));
            params.put("OrderPayInfo[PayTypeList][" + i + "][GID]", typelist.get(i).getGID());
        }
        if (orderPayResult.getYhqList() != null)
            for (int i = 0; i < orderPayResult.getYhqList().size(); i++) {
                params.put("OrderPayInfo[GIDList][" + i + "]", orderPayResult.getYhqList().get(i).getGID());
            }

        params.put("OrderPayInfo[CC_GID]", orderPayResult.getActive() == null ? "" : orderPayResult.getActive().getGID());
        params.put("OrderPayInfo[EraseOdd]", orderPayResult.getMolingMoney());
        params.put("OrderPayInfo[IsPrint]", orderPayResult.isPrint());

        String url = HttpAPI.API().BAR_CODE_PAY;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxSaomaS", new String(responseBody, "UTF-8"));
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
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse(jso);
                    }
                } catch (Exception e) {
                    LogUtils.d("xxe", e.getMessage());
                    back.onErrorResponse(null);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                com.blankj.utilcode.util.ToastUtils.showShort("扫码支付失败");
                back.onErrorResponse(null);
            }
        });
    }

    public void saomaPayQuery(final Activity ac, String GID, final InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        String url = HttpAPI.API().QUERY_PAY_RESULT;
        params.put("ResultGID", GID);
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxSaomaS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));

                    if (jso.getString("code").equals("RemoteLogin") || jso.getString("code").equals("LoginTimeout")) {
                        ActivityManager.getInstance().exit();
                        Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        MyApplication.getContext().startActivity(intent);
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        return;
                    }
                    back.onResponse(jso);

                } catch (Exception e) {
                    LogUtils.d("xxe", e.getMessage());
                    back.onErrorResponse(null);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                com.blankj.utilcode.util.ToastUtils.showShort("扫码支付失败");
                back.onErrorResponse(null);
            }
        });
    }
}

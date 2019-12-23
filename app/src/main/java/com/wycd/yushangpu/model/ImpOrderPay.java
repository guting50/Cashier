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
import com.wycd.yushangpu.printutil.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;

import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.wycd.yushangpu.MyApplication.shortMessage;

public class ImpOrderPay {
    public void orderpay(final Activity ac, String OrderGID, OrderPayResult orderPayResult, JiesuanBFragment.OrderType orderType,
                         final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
//        OrderGID	订单GID	String
//        PayResult	收银台信息	OrderPayResult
        params.put("OrderGID", OrderGID);
        params.put("PayResult[GiveChange]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getGiveChange() + ""));
        params.put("PayResult[PayTotalMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getPayTotalMoney() + ""));
        params.put("PayResult[DisMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getDisMoney() + ""));
        params.put("IS_Sms", shortMessage);
        List<PayType> typelist = orderPayResult.getPayTypeList();
        for (int i = 0; i < typelist.size(); i++) {
            params.put("PayResult[PayTypeList][" + i + "][PayCode]", typelist.get(i).getPayCode());
            params.put("PayResult[PayTypeList][" + i + "][PayName]", typelist.get(i).getPayName());
            params.put("PayResult[PayTypeList][" + i + "][PayMoney]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayMoney() + ""));
            params.put("PayResult[PayTypeList][" + i + "][PayPoint]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayPoint() + ""));

            System.out.println("============================[" + i + "]PayCode===" + typelist.get(i).getPayCode());
            System.out.println("============================[" + i + "]PayName===" + typelist.get(i).getPayName());
            System.out.println("============================[" + i + "]PayMoney===" + typelist.get(i).getPayMoney());
            System.out.println("============================[" + i + "]PayPoint===" + typelist.get(i).getPayPoint());
            if (typelist.get(i).getPayName().equals("优惠券")) {
                params.put("PayResult[PayTypeList][" + i + "][GID][]", typelist.get(i).getGID());
            }
        }

        System.out.println("============================PayCode===" + OrderGID);
        System.out.println("============================GiveChange===" + orderPayResult.getGiveChange());
        System.out.println("============================PayTotalMoney===" + orderPayResult.getPayTotalMoney());
        System.out.println("============================DisMoney===" + orderPayResult.getDisMoney());

        params.put("PayResult[CC_GID]", "");
        params.put("PayResult[EraseOdd]", orderPayResult.getMolingMoney());
        params.put("PayResult[IsPrint]", orderPayResult.isPrint());
        params.put("PayResult[IsSms]", shortMessage);

        String url = HttpAPI.API().GOODS_CONSUME_PAY;
        switch (orderType) {
            case CONSUM_ORDER:
                url = HttpAPI.API().GOODS_CONSUME_PAY;
                break;
            case CELERITY_ORDER:
                url = HttpAPI.API().GOODS_CELERITY_PAY;
                break;
            case GUAZHANG_ORDER:
                url = HttpAPI.API().GUAZHANG;
                break;
        }

        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        System.out.println("============================url===" + url);
        System.out.println("============================params===" + params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxorderpayS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));

                    System.out.println("========onSuccess=============random" + jso.toString());

                    if (jso.getBoolean("success")) {
                        back.onResponse(jso.toString());
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
                    LogUtils.d("xxorderpayE", e.getMessage());
//                    ToastUtils.showToast(ac, "订单支付失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("订单支付失败");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "订单支付失败");
                com.blankj.utilcode.util.ToastUtils.showShort("订单支付失败");
                back.onErrorResponse("");
            }
        });
    }
}

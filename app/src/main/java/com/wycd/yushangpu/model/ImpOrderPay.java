package com.wycd.yushangpu.model;

import android.app.Activity;

import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;

import java.util.List;

import static com.wycd.yushangpu.MyApplication.shortMessage;

public class ImpOrderPay {
    public void orderpay(final Activity ac, String OrderGID, OrderPayResult orderPayResult, JiesuanBFragment.OrderType orderType,
                         final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
//        OrderGID	订单GID	String
//        PayResult	收银台信息	OrderPayResult
        params.put("OrderGID", OrderGID);
        params.put("Smsg", shortMessage);

        params.put("PayResult[GiveChange]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getGiveChange() + ""));
        params.put("PayResult[PayTotalMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getPayTotalMoney() + ""));
        params.put("PayResult[DisMoney]", Decima2KeeplUtil.stringToDecimal(orderPayResult.getDisMoney() + ""));
        List<PayType> typelist = orderPayResult.getPayTypeList();
        for (int i = 0; i < typelist.size(); i++) {
            params.put("PayResult[PayTypeList][" + i + "][PayCode]", typelist.get(i).getPayCode());
            params.put("PayResult[PayTypeList][" + i + "][PayName]", typelist.get(i).getPayName());
            params.put("PayResult[PayTypeList][" + i + "][PayMoney]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayMoney() + ""));
            params.put("PayResult[PayTypeList][" + i + "][PayPoint]", Decima2KeeplUtil.stringToDecimal(typelist.get(i).getPayPoint() + ""));
            params.put("PayResult[PayTypeList][" + i + "][GID]", typelist.get(i).getGID());
        }
        if (orderPayResult.getYhqList() != null)
            for (int i = 0; i < orderPayResult.getYhqList().size(); i++) {
                params.put("PayResult[GIDList][" + i + "]", orderPayResult.getYhqList().get(i).getGID());
            }

        params.put("PayResult[CC_GID]", orderPayResult.getActive() == null ? "" : orderPayResult.getActive().getGID());
        params.put("PayResult[EraseOdd]", orderPayResult.getMolingMoney());
        params.put("PayResult[IsPrint]", orderPayResult.isPrint());

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

        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(SPXFSuccessBean.class).getGID());
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

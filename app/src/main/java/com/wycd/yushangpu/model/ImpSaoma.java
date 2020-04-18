package com.wycd.yushangpu.model;

import com.google.gson.reflect.TypeToken;
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

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static com.wycd.yushangpu.MyApplication.shortMessage;
import static com.wycd.yushangpu.ui.fragment.JiesuanBFragment.OrderType.MEM_RECHARGE_PAY;

/**
 * 扫码支付
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpSaoma {

    public void saomaPay(String Code, String Money, String OrderGID, String OrderNo, OrderPayResult orderPayResult,
                         JiesuanBFragment.OrderType orderType, InterfaceBack back) {
        // TODO 自动生成的方法存根
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
        //10商品消费 20充次 30计时消费 40 充值 50 套餐消费 60快速消费
        if (orderType == MEM_RECHARGE_PAY) {
            params.put("OrderType", 40);
        } else {
            params.put("OrderType", 10);
        }
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
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type type = new TypeToken<Map<String, Object>>() {
                }.getType();
                Map<String, Object> map = response.getData(type);
                back.onResponse(map.get("Order_GID").toString());
            }

            @Override
            public void onErrorResponse(Object msg) {
                back.onErrorResponse(msg);
            }
        });
    }

    public void saomaPayQuery(String GID, final InterfaceBack back) {
        RequestParams params = new RequestParams();
        String url = HttpAPI.API().QUERY_PAY_RESULT;
        params.put("ResultGID", GID);
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response);
            }

            @Override
            public void onErrorResponse(Object msg) {
                back.onErrorResponse(msg);
            }
        });
    }
}

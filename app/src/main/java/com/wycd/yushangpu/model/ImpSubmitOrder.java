package com.wycd.yushangpu.model;

import android.app.Activity;
import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.CreateOrder;

import java.util.List;

public class ImpSubmitOrder {
    public void submitOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist, boolean isGuadan,
                            final InterfaceBack back) {
        // TODO 自动生成的方法存根
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
        AsyncHttpUtils.postHttp(ac, url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshhu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    public void submitGuaOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist,
                               final InterfaceBack back) {
        // TODO 自动生成的方法存根
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
        String url = HttpAPI.API().GOODS_CONSUME_GUADAN;

        AsyncHttpUtils.postHttp(ac, url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshhu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    public void submitCelerityOrder(final Activity ac, String CO_OrderCode, String OrderTime, String VIP_Card, String mone,
                                    final InterfaceBack back) {
        // TODO 自动生成的方法存根
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
        params.put("CO_TotalPrice", mone);

        String url = HttpAPI.API().GOODS_CELERITY_SUB;

        AsyncHttpUtils.postHttp(ac, url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshhu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    public void closeGuadanOrder(final Context ac, String GID, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("GID", GID);

        String url = HttpAPI.API().CLOSE_GUADAN_ORDER;

        AsyncHttpUtils.postHttp(ac, url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response);
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

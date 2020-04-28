package com.wycd.yushangpu.model;

import android.app.Activity;
import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.OrderCanshu;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;

import java.util.List;

public class ImpSubmitOrder {
    /**
     * 商品消费订单提交
     *
     * @param ac
     * @param CO_OrderCode
     * @param OrderTime
     * @param VIP_Card
     * @param shoplist
     * @param isGuadan
     * @param back
     */
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
            params.put("Goods[" + i + "][GOD_Proportion]", shoplist.get(i).getGOD_Proportion());
            params.put("Goods[" + i + "][Type]", shoplist.get(i).getType());
            params.put("Goods[" + i + "][ExpiryTime]", "");
            params.put("Goods[" + i + "][WR_GIDList]", "");
            params.put("Goods[" + i + "][PM_UnitPrice]", shoplist.get(i).getPM_UnitPrice());
            params.put("Goods[" + i + "][PM_MemPrice]", shoplist.get(i).getPM_MemPrice());
            params.put("Goods[" + i + "][PM_Discount]", shoplist.get(i).getPD_Discount());//折扣后的单价除以原价
        }
        String url = HttpAPI.API().GOODS_CONSUME_SUB;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                if (msg.toString().contains("该会员卡已过期")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("该会员卡已过期");
                } else
                    super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    /**
     * 挂单\替换挂单
     *
     * @param ac
     * @param CO_OrderCode
     * @param OrderTime
     * @param VIP_Card
     * @param shoplist
     * @param back
     */
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
            params.put("Goods[" + i + "][GOD_Proportion]", shoplist.get(i).getGOD_Proportion());
            params.put("Goods[" + i + "][Type]", shoplist.get(i).getType());
            params.put("Goods[" + i + "][ExpiryTime]", "");
            params.put("Goods[" + i + "][WR_GIDList]", "");
            params.put("Goods[" + i + "][PM_UnitPrice]", shoplist.get(i).getPM_UnitPrice());
            params.put("Goods[" + i + "][PM_MemPrice]", shoplist.get(i).getPM_MemPrice());
            params.put("Goods[" + i + "][PM_Discount]", shoplist.get(i).getPD_Discount());//折扣后的单价除以原价
        }
        String url = HttpAPI.API().GOODS_CONSUME_GUADAN;

        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    /**
     * 快速消费订单提交
     *
     * @param ac
     * @param CO_OrderCode
     * @param OrderTime
     * @param VIP_Card
     * @param mone
     * @param back
     */
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

        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                if (msg.toString().contains("该会员卡已过期")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("该会员卡已过期");
                } else
                    super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    /**
     * 删除挂单
     *
     * @param ac
     * @param GID
     * @param back
     */
    public void closeGuadanOrder(final Context ac, String GID, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("GID", GID);

        String url = HttpAPI.API().CLOSE_GUADAN_ORDER;

        AsyncHttpUtils.postHttp(url, params, new CallBack() {
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

    /**
     * 会员充值订单提交
     *
     * @param ac
     * @param mOrderNo
     * @param OrderTime
     * @param VCH_Card
     * @param mDiscountActivityGid
     * @param mRechargeMoney
     * @param mGiveMoney
     * @param mGetPoints
     * @param mStaffListGid
     * @param remark
     * @param back
     */
    public void submitRechargeOrder(final Context ac, String mOrderNo, String OrderTime, String VCH_Card,
                                    String mDiscountActivityGid, String mRechargeMoney, String mGiveMoney,
                                    double mGetPoints, List<String> mStaffListGid, List<Integer> staffProportion, String remark, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        //订单号
        params.put("MR_Order", mOrderNo);
        //订单时间
        params.put("OrderTime", OrderTime);
        //会员卡号
        params.put("VIP_Card", VCH_Card);
        //快捷充值GID
        params.put("CC_GID", mDiscountActivityGid);
        //充值金额
        params.put("MR_Amount", Decima2KeeplUtil.stringToDecimal(mRechargeMoney + ""));
        //赠送金额
        params.put("MR_GivenAmount", Decima2KeeplUtil.stringToDecimal(mGiveMoney + ""));
        //赠送积分
        params.put("MR_Integral", (int) mGetPoints);
        //提成员工
        if (mStaffListGid != null) {
            for (int j = 0; j < mStaffListGid.size(); j++) {
                params.put("EM_GIDList[" + j + "]", mStaffListGid.get(j));
                params.put("GOD_Proportion[" + j + "]", staffProportion.get(j));
            }
        }
        //备注
        params.put("MR_Remark", remark);

        String url = HttpAPI.API().MEM_RECHARGE_SUB;

        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(OrderCanshu.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

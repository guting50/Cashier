package com.wycd.yushangpu.Presenter;

import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BasicEucalyptusPresnter {

    public static PayTypeMsg defaultMode;// 默认支付方式
    public static ArrayList<PayTypeMsg> payModeList = new ArrayList<>(); // 支付方式列表
    public static boolean isZeroStock; //是否禁止0库存销售
    public static int mModifyPrice = 0;//商品数据修改(修改单价/修改折扣/修改小计/修改数量)
    public static int mChangePrice = 0;//修改改价
    public static int mChangeDiscount = 0;//修改折扣
    public static int mChangeSubtotal = 0; //修改小计

    static {
        init();
    }

    public static void init() {
        String url = HttpAPI.API().GET_SWITCH_LIST;
        AsyncHttpUtils.postHttp(url, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<PayTypeMsg>>() {
                }.getType();
                handleSystem(response.getData(listType));
            }
        });
    }

    private static void handleSystem(List<PayTypeMsg> sllist) {
        payModeList.clear();
        for (PayTypeMsg p : sllist) {
            switch (p.getSS_Name()) {
                case "默认支付":
                    defaultMode = p;
                    break;
                case "现金支付":
                case "余额支付":
                case "银联支付":
                case "微信记账":
                case "支付宝记账":
                case "优惠券":
                case "扫码支付":
                case "其他支付":
                case "积分支付":
                case "积分支付限制": // 加入积分支付限制是为了在结算界面中获取积分计算规则
                    payModeList.add(p);
                    break;
                case "禁止0库存销售":
                    if (p.getSS_State() == 1) {
                        isZeroStock = true;
                    } else {
                        isZeroStock = false;
                    }
                    break;
            }
            if (p.getSS_Code() == 601) {
                //商品数据修改
                mModifyPrice = p.getSS_State();
            } else if (p.getSS_Code() == 900) {
                //修改单价
                mChangePrice = p.getSS_State();
            } else if (p.getSS_Code() == 901) {
                //修改折扣
                mChangeDiscount = p.getSS_State();
            } else if (p.getSS_Code() == 902) {
                //修改小计
                mChangeSubtotal = p.getSS_State();
            }
        }
    }
}

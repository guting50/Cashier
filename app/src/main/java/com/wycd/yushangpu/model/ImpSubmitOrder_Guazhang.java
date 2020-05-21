package com.wycd.yushangpu.model;

import android.app.Activity;

import com.blankj.utilcode.util.ToastUtils;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.LogUtils;

import java.util.List;

/**
 * Created by ZPH on 2019-06-17.
 */

public class ImpSubmitOrder_Guazhang {
    public void submitOrder(String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist, boolean isGuaZhang,
                            final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("CO_OrderCode", CO_OrderCode);
        params.put("OrderTime", OrderTime);
        params.put("VIP_Card", VIP_Card);
        params.put("OrderType", 2);

        params.put("isGuadan", false);
        params.put("isGuaZhang", isGuaZhang);
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
            params.put("Goods[" + i + "][PM_Discount]", CommonUtils.div(shoplist.get(i).getJisuanPrice(), shoplist.get(i).getPM_UnitPrice(), 2));//折扣后的单价除以原价
        }
        params.put("ActivityValue", "");
        String url = HttpAPI.API().CONSUME_GUAZHANG;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response);
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                ToastUtils.showLong("提交订单失败");
                back.onErrorResponse(msg);
            }
        });
    }
}

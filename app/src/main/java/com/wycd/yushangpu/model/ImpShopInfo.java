package com.wycd.yushangpu.model;

import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ImpShopInfo {

    public void shopInfo(final InterfaceBack back) {
        // TODO 自动生成的方法存根
        String url = HttpAPI.API().GET_SHOP_INFO;
        AsyncHttpUtils.postHttp(url, new CallBack() {

            @Override
            public void onResponse(BaseRes response) {
                ShopInfoBean infoBean = response.getData(ShopInfoBean.class);
                RequestParams params = new RequestParams();

                String url = HttpAPI.API().GET_SHOPS_INFO;
                params.put("GID", infoBean.getGID());
                AsyncHttpUtils.postHttp(url, params, new CallBack() {

                    @Override
                    public void onResponse(BaseRes response) {
                        ShopInfoBean tmp = response.getData(ShopInfoBean.class);
                        infoBean.setSM_Industry(tmp.getSM_Industry());
                        infoBean.setSM_Type(tmp.getSM_Type());
                        infoBean.setSM_DetailAddr(tmp.getSM_DetailAddr());
                        infoBean.setSM_Range(tmp.getSM_Range());
                        infoBean.setSM_BusinessType(tmp.getSM_BusinessType());
                        infoBean.setSM_Remark(tmp.getSM_Remark());
                        back.onResponse(infoBean);
                    }
                });
            }
        });
    }
}

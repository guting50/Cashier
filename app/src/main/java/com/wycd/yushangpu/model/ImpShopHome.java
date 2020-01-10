package com.wycd.yushangpu.model;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 首页商品数据
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpShopHome {

    public void shoplist(final int PageIndex, final int PageSize, final String PT_GID, final String PM_CodeOrNameOrSimpleCode,
                         final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("PageIndex", PageIndex);
        params.put("PageSize", PageSize);
        params.put("PT_GID", PT_GID);
        params.put("DataType", 2);
        params.put("showGroupPro", 1);
        params.put("PM_CodeOrNameOrSimpleCode", PM_CodeOrNameOrSimpleCode);
        String url = HttpAPI.API().COMBOGOODS;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type basePageRes = new TypeToken<BasePageRes>() {
                }.getType();
                back.onResponse(response.getData(basePageRes));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

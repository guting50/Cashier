package com.wycd.yushangpu.model;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpVipList {
    private List<VipInfoMsg> shoplist = new ArrayList<>();
    private int index = 1;

    public void vipList(int PageIndex, int PageSize, String CardOrNameOrCellPhoneOrFace,
                        InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("PageIndex", PageIndex);
        params.put("PageSize", PageSize);
        params.put("CardOrNameOrCellPhoneOrFace", CardOrNameOrCellPhoneOrFace);
        String url = HttpAPI.API().VIPLIST;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                BasePageRes basePageRes = response.getData(BasePageRes.class);
                Type listType = new TypeToken<List<VipInfoMsg>>() {
                }.getType();
                List<VipInfoMsg> sllist = basePageRes.getData(listType);
                shoplist.addAll(sllist);
                if (index < basePageRes.getPageTotal()) {
                    index = index + 1;
                    vipList(index, PageSize, CardOrNameOrCellPhoneOrFace, back);
                } else {
                    back.onResponse(shoplist);
                }

            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

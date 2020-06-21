package com.wycd.yushangpu.model;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.gt.utils.GsonUtils;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.bean.ShopMsg;
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
 * 首页商品数据
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpShopHome {

    public void shoplist(final int PageIndex, final int PageSize, final String PT_GID, final String PM_CodeOrNameOrSimpleCode,
                         final InterfaceBack back) {
        // TODO 自动生成的方法存根
        if (cacheList.size() > 0) {
            getShopCacheList(PT_GID, PM_CodeOrNameOrSimpleCode, PageIndex, PageSize, back);
            return;
        }
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
                shopCacheList();
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    public static List<ShopMsg> cacheList = new ArrayList<>();

    public void getShopCacheList(final String PT_GID, final String PM_CodeOrNameOrSimpleCode, int PageIndex, final int PageSize, InterfaceBack back) {
        Type listType = new TypeToken<List<ShopMsg>>() {
        }.getType();
        List<ShopMsg> tempList = GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(cacheList), listType);

        BasePageRes basePageRes = new BasePageRes();
        List<ShopMsg> newList = new ArrayList<>();
        if (TextUtils.isEmpty(PT_GID) && TextUtils.isEmpty(PM_CodeOrNameOrSimpleCode)) {
            newList = tempList;
        } else {
            for (ShopMsg shopMsg : tempList) {
                if (!TextUtils.isEmpty(PT_GID) && !TextUtils.isEmpty(PM_CodeOrNameOrSimpleCode)) {
                    if (TextUtils.equals(shopMsg.getPT_ID(), PT_GID) &&
                            (TextUtils.equals(shopMsg.getPM_Code(), PM_CodeOrNameOrSimpleCode) ||
                                    TextUtils.equals(shopMsg.getPM_Name(), PM_CodeOrNameOrSimpleCode) ||
                                    TextUtils.equals(shopMsg.getPM_SimpleCode(), PM_CodeOrNameOrSimpleCode))) {
                        newList.add(shopMsg);
                    }
                } else {
                    if (!TextUtils.isEmpty(PT_GID) && TextUtils.equals(shopMsg.getPT_ID(), PT_GID)) {
                        newList.add(shopMsg);
                    } else if (!TextUtils.isEmpty(PM_CodeOrNameOrSimpleCode) &&
                            (TextUtils.equals(shopMsg.getPM_Code(), PM_CodeOrNameOrSimpleCode) ||
                                    TextUtils.equals(shopMsg.getPM_Name(), PM_CodeOrNameOrSimpleCode) ||
                                    TextUtils.equals(shopMsg.getPM_SimpleCode(), PM_CodeOrNameOrSimpleCode))) {
                        newList.add(shopMsg);
                    }
                }
            }
        }
        basePageRes.setDataCount(newList.size());
        int toIndex = PageIndex * PageSize + 1;
        basePageRes.setDataList(newList.subList((PageIndex - 1) * PageSize, toIndex > newList.size() ? newList.size() : toIndex));
        back.onResponse(basePageRes);
    }

    public void shopCacheList() {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("PageIndex", 1);
        params.put("PageSize", 1);
        params.put("PT_GID", "");
        params.put("DataType", 2);
        params.put("showGroupPro", 1);
        params.put("PM_CodeOrNameOrSimpleCode", "");
        String url = HttpAPI.API().COMBOGOODS;
        //获取数据的总条数
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type basePageResType = new TypeToken<BasePageRes>() {
                }.getType();
                BasePageRes basePageRes = response.getData(basePageResType);
                params.put("PageSize", basePageRes.getDataCount());

                AsyncHttpUtils.postHttp(url, params, new CallBack() {
                    @Override
                    public void onResponse(BaseRes response) {
                        Type basePageResType = new TypeToken<BasePageRes>() {
                        }.getType();
                        BasePageRes basePageRes = response.getData(basePageResType);
                        Type listType = new TypeToken<List<ShopMsg>>() {
                        }.getType();
                        cacheList = basePageRes.getData(listType);
                        for (ShopMsg msg : cacheList) {
                            msg.init();
                        }
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        super.onErrorResponse(msg);
                    }
                });
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
            }
        });
    }
}

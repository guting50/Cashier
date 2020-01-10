package com.wycd.yushangpu.model;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpOnlyVipMsg {

    public void vipMsg(final String VCH_Card, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("VCH_Card", VCH_Card);
        params.put("isNeedVG", 1);//需要VGInfo的时候传1，其余不传
        String url = HttpAPI.API().QUERY_SINGLE_LIST;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<VipInfoMsg>>() {
                }.getType();
                List<VipInfoMsg> sllist = response.getData(listType);
                for (VipInfoMsg vipInfoMsg : sllist) {
                    if (vipInfoMsg.getVCH_Card().equals(VCH_Card)) {
                        back.onResponse(vipInfoMsg);
                        return;
                    }
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }

    public void vipMsgs(final String VCH_Card, int pageIndex, int pageSize, final InterfaceBack back) {
        // TODO 自动生成的方法存根
        RequestParams params = new RequestParams();
        params.put("PageIndex", pageIndex);
        params.put("PageSize", pageSize);
        params.put("CardOrNameOrCellPhoneOrFace", VCH_Card);
        params.put("SM_GID", MyApplication.loginBean.getShopID());
        String url = HttpAPI.API().VIPLIST;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                back.onResponse(response.getData(BasePageRes.class));
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                back.onErrorResponse(msg);
            }
        });
    }
}

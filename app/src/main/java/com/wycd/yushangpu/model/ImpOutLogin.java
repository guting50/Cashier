package com.wycd.yushangpu.model;

import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;

/**
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpOutLogin {
    public void outLogin(InterfaceBack back) {
        // TODO 自动生成的方法存根
        String url = HttpAPI.API().SIGNOUT;
        AsyncHttpUtils.postHttp(url, new CallBack() {
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

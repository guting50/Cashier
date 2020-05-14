package com.wycd.yushangpu.http;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;

/**
 * Created by songxiaotao on 2017/7/2.
 */

public abstract class CallBack<T extends BaseRes> {
    public abstract void onResponse(T response);

    public void onErrorResponse(Object msg) {
        LogUtils.e("======== Error ========", new Gson().toJson(msg));
        if (msg instanceof BaseRes) {
            ToastUtils.showLong(((BaseRes) msg).getMsg());
        } else
            ToastUtils.showLong(new Gson().toJson(msg));
    }
}

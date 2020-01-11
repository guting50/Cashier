package com.wycd.yushangpu.http;

import com.google.gson.Gson;
import com.gt.utils.LogsUtils;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.tools.LogUtils;

/**
 * Created by songxiaotao on 2017/7/2.
 */

public abstract class CallBack<T extends BaseRes> {
    public abstract void onResponse(T response);

    public void onErrorResponse(Object msg) {
        LogUtils.e("======== Error ========", new Gson().toJson(msg));
        com.blankj.utilcode.util.ToastUtils.showShort(new Gson().toJson(msg));
    }
}

package com.wycd.yushangpu.printutil;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;

/**
 * 作者：罗咏哲 on 2017/10/24 17:44.
 * 邮箱：137615198@qq.com
 */

public class IPrintSetPresenter implements Presenter {
    private Context mContext;
    private IPrintSetView mView;

    public IPrintSetPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate(String s) {
        getPrintSet();
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    @Override
    public void attachView(IBaseView view) {
        mView = (IPrintSetView) view;
    }

    /**
     * 保存打印设置
     *
     * @param params
     */
    public void savePrintSet(Context context, RequestParams params) {

         CallBack callBack = new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                mView.saveSetSuccess();
            }

            @Override
            public void onFailure(String msg) {
//                mView.saveSetFail(msg);
            }
        };
        callBack.setLoadingAnimation(context,"保存中...",false);
        HttpHelper.post(mContext, "api/PrintSet/EditPrintSet", params,callBack);

    }

    /**
     * 获取打印设置
     */
    public void getPrintSet() {  // http://dj.zhiluo.net/api/PrintSet/GetPrintSet
        HttpHelper.post(mContext, HttpAPI.API().GET_PRINT_SET, new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                PrintSetBean bean = CommonFun.JsonToObj(responseString, PrintSetBean.class);
                mView.getPrintSetSuccess(bean);
            }

            @Override
            public void onFailure(String msg) {
                mView.getPrintSetFail(msg);
            }
        });
    }
}

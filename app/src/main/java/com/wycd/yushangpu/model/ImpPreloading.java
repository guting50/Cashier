package com.wycd.yushangpu.model;

import android.app.Activity;

import com.google.gson.Gson;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.CallBack;
import com.wycd.yushangpu.printutil.CommonFun;
import com.wycd.yushangpu.printutil.HttpHelper;

/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpPreLoading {
    public static ReportMessageBean REPORT_BEAN;

    public static void preLoad(final Activity ac) {
        HttpHelper.post(ac, HttpAPI.API().PRE_LOAD, new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                REPORT_BEAN = CommonFun.JsonToObj(responseString, ReportMessageBean.class);
                if (REPORT_BEAN != null) {
                    ReportMessageBean.DataBean.PrintSetBean printbean = REPORT_BEAN.getData().getPrintSet();
                    if (printbean.getPS_IsEnabled() == 1) {
                        MyApplication.PRINT_IS_OPEN = true;
                    } else {
                        MyApplication.PRINT_IS_OPEN = false;
                    }
                    if (printbean != null && printbean.getPrintTimesList() != null) {
                        for (int i = 0; i < printbean.getPrintTimesList().size(); i++) {
                            ReportMessageBean.DataBean.PrintSetBean.PrintTimesListBean bean = printbean.getPrintTimesList().get(i);
                            if ("SPXF".equals(bean.getPT_Code())) {
                                MyApplication.SPXF_PRINT_TIMES = bean.getPT_Times();
                            }
                            if ("JB".equals(bean.getPT_Code())) {
                                MyApplication.JB_PRINT_TIMES = bean.getPT_Times();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }
}

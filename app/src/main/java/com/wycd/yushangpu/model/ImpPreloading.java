package com.wycd.yushangpu.model;

import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;

/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpPreLoading {
    public static ReportMessageBean REPORT_BEAN;

    public static void preLoad() {
        AsyncHttpUtils.postHttp(HttpAPI.API().PRE_LOAD, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                REPORT_BEAN = response.getData(ReportMessageBean.class);
                if (REPORT_BEAN != null) {
                    ReportMessageBean.PrintSetBean printbean = REPORT_BEAN.getPrintSet();
                    if (printbean.getPS_IsEnabled() == 1) {
                        MyApplication.PRINT_IS_OPEN = true;
                    } else {
                        MyApplication.PRINT_IS_OPEN = false;
                    }
                    if (printbean != null && printbean.getPrintTimesList() != null) {
                        for (int i = 0; i < printbean.getPrintTimesList().size(); i++) {
                            ReportMessageBean.PrintSetBean.PrintTimesListBean bean = printbean.getPrintTimesList().get(i);
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
        });
    }
}

package com.wycd.yushangpu.model;

import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;

import io.reactivex.Observable;


/**
 * Created by songxiaotao on 2018/6/19.
 * 首页预加载数据
 */

public class ImpParamLoading {
    public static ReportMessageBean REPORT_BEAN = new ReportMessageBean();
    public static Observable<String> observable;

    public static void preLoad() {
        //创建一个被观察者(发布者)
        observable = Observable.create(emitter ->
                AsyncHttpUtils.postSyncHttp(HttpAPI.API().PRE_LOAD, new CallBack() {
                    @Override
                    public void onResponse(BaseRes response) {
                        REPORT_BEAN = response.getData(ReportMessageBean.class);
                        if (REPORT_BEAN != null) {
                            PrintSetBean printSetBean = REPORT_BEAN.getPrintSet();
                            if (printSetBean != null && printSetBean.getPrintTimesList() != null) {
                                MyApplication.LABEL_TYPE = printSetBean.getPS_TipPrintPaper();
                                if (printSetBean.getPS_IsEnabled() == 1) {
                                    MyApplication.PRINT_IS_OPEN = true;
                                } else {
                                    MyApplication.PRINT_IS_OPEN = false;
                                }
                                for (int i = 0; i < printSetBean.getPrintTimesList().size(); i++) {
                                    PrintSetBean.PrintTimesListBean bean = printSetBean.getPrintTimesList().get(i);
                                    if ("SPXF".equals(bean.getPT_Code())) {
                                        MyApplication.SPXF_PRINT_TIMES = bean.getPT_Times();
                                    }
                                    if ("JB".equals(bean.getPT_Code())) {
                                        MyApplication.JB_PRINT_TIMES = bean.getPT_Times();
                                    }
                                }
                            }


                            BasicEucalyptusPresnter.handleSystem(REPORT_BEAN.getGetSysSwitchList());

//                            List<ReportMessageBean.ActiveBean> actives = REPORT_BEAN.getActiveOth();
//                            for (ReportMessageBean.ActiveBean bean : actives) {
//                                Log.e("==========" + bean.getRP_Type(), bean.getRP_Name());
//                            }
                            emitter.onNext("");
                        }
                    }
                }));
    }
}



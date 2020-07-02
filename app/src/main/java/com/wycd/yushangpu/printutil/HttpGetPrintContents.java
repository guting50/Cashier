package com.wycd.yushangpu.printutil;

import android.app.Activity;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.bean.HandDutyBean;
import com.wycd.yushangpu.printutil.bean.Print_HYCZ_Bean;
import com.wycd.yushangpu.printutil.bean.Print_HYKK_Bean;
import com.wycd.yushangpu.printutil.bean.Print_KSXF_Bean;
import com.wycd.yushangpu.printutil.bean.Print_SPXF_Bean;
import com.wycd.yushangpu.tools.LogUtils;


/**
 * 获取打印参数
 * 作者：罗咏哲 on 2017/7/26 21:04.
 * 邮箱：137615198@qq.com
 */

public class HttpGetPrintContents {


    private static Gson gson = new Gson();

    private static int mPrintNum = 1;


    /**
     * 进行快速消费的打印
     */
    public static void KSXF(Activity mContext, String GID) {
        RequestParams params = new RequestParams();
        params.put("OrderGID", GID);

        LogUtils.d("======== url ======== >>", HttpAPI.API().GET_GOODS_PRINT_DATA);
        LogUtils.d("======== params ======== >>", params.toString());
        AsyncHttpUtils.postHttp(HttpAPI.API().GET_GOODS_PRINT_DATA, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Print_KSXF_Bean print_ksxf_bean = response.getData(Print_KSXF_Bean.class);
                //打印小票
                PrinterUtils printerUtils = new PrinterUtils(mContext, GetPrintSet.KSXF_PRINT_TIMES, print_ksxf_bean, "KSXF");
                printerUtils.print();
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                ToastUtils.showLong("获取快速消费打印参数失败");
            }

        });

    }

    /**
     * 进行商品消费的打印
     */
    public static void SPXF(final Activity mContext, String GID) {

        RequestParams params = new RequestParams();
        params.put("OrderGID", GID);

        LogUtils.d("======== url ======== >>", HttpAPI.API().GET_GOODS_PRINT_DATA);
        LogUtils.d("======== params ======== >>", params.toString());
        AsyncHttpUtils.postHttp(HttpAPI.API().GET_GOODS_PRINT_DATA, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Print_SPXF_Bean print_spxf_bean = response.getData(Print_SPXF_Bean.class);
                //打印小票
                PrinterUtils printerUtils = new PrinterUtils(mContext, GetPrintSet.SPXF_PRINT_TIMES, print_spxf_bean, "SPXF");
                printerUtils.print();
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                ToastUtils.showLong("获取快速消费打印参数失败");
            }

        });

    }

    /**
     * 进行会员充值的打印
     */
    public static void HYCZ(Activity mContext, String responseString) {
        try {
            Print_HYCZ_Bean print_hycz_bean = gson.fromJson(responseString, Print_HYCZ_Bean.class);
            //打印小票
            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, print_hycz_bean, "HYCZ");
            printerUtils.print();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
    }

    //
//    /**
//     * 进行会员充次的打印
//     */
//    public static void HYCC(Activity mContext, String responseString) {
//
//        try {
//            Print_HYCC_Bean print_hycc_bean = gson.fromJson(responseString, Print_HYCC_Bean.class);
//            //打印小票
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, print_hycc_bean, "HYCC");
//            printerUtils.print();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 进行计次消费的打印
//     */
//    public static void JCXF(Activity mContext, String responseString) {
//
//        try {
//            Print_JCXF_Bean print_jcxf_bean = gson.fromJson(responseString, Print_JCXF_Bean.class);
//            //打印小票
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, print_jcxf_bean, "JCXF");
//            printerUtils.print();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    /**
//     * 进行金粉兑换的打印
//     */
//    public static void JFDH(Activity mContext, String responseString) {
//
//        try {
//            Print_JFDH_Bean print_jfdh_bean = gson.fromJson(responseString, Print_JFDH_Bean.class);
//            //打印小票
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, print_jfdh_bean, "JFDH");
//            printerUtils.print();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    /**
//     * 进行会员开卡的打印
//     */
    public static void HYKK(Activity mContext, String GID) {
        RequestParams params = new RequestParams();
        params.put("OrderGID", GID);

        LogUtils.d("======== url ======== >>", HttpAPI.API().GET_GOODS_PRINT_DATA);
        LogUtils.d("======== params ======== >>", params.toString());
        AsyncHttpUtils.postHttp(HttpAPI.API().PRINT_VIP_OPEN_CARD, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Print_HYKK_Bean print_spxf_bean = response.getData(Print_HYKK_Bean.class);
                //打印小票
                PrinterUtils printerUtils = new PrinterUtils(mContext, GetPrintSet.HYKK_PRINT_TIMES, print_spxf_bean, "HYKK");
                printerUtils.print();
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                ToastUtils.showLong("获取打印参数失败");
            }

        });
    }
//
//
//    /**
//     * 入库打印
//     * 每页条数
//     * 查询入库记录
//     */
//
//    public static void RK(Activity mContext, String responseString) {
//
//        try {
//            RK_Success_Bean bean = gson.fromJson(responseString, RK_Success_Bean.class);
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, bean, "RK");
//            printerUtils.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 入库打印
//     * 每页条数
//     * 查询入库记录
//     */
//
//    public static void CK(Activity mContext, String responseString) {
//
//        try {
//            CK_Success_Bean bean = gson.fromJson(responseString, CK_Success_Bean.class);
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, bean, "CK");
//            printerUtils.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 退货打印
//     */
//
//    public static void SPTH(Activity mContext, String responseString) {
//
//        try {
//            Print_SPTH_Bean bean = gson.fromJson(responseString, Print_SPTH_Bean.class);
//            PrinterUtils printerUtils = new PrinterUtils(mContext, mPrintNum, bean, "SPTH");
//            printerUtils.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//

    /**
     * 交班
     */

    public static void JB(Activity mContext, String responseString) {
        try {
            HandDutyBean bean = gson.fromJson(responseString, HandDutyBean.class);
            PrinterUtils printerUtils = new PrinterUtils(mContext, GetPrintSet.JB_PRINT_TIMES, bean, "JB");
            printerUtils.print();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }

    }
}

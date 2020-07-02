package com.wycd.yushangpu.printutil;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.bean.PrintParamSetBean;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * 获取打印设置
 * 作者：罗咏哲 on 2017/8/18 14:05.
 * 邮箱：137615198@qq.com
 */

public class GetPrintSet {

    /**
     * 会员充次
     */
    public static Map<String, String> mTimesRechargeMap = new HashMap<>();
    /**
     * 会员充值
     */
    public static Map<String, String> mRechargeMap = new HashMap<>();
    /**
     * 商品消费
     */
    public static Map<String, String> mGoodsConsumeMap = new HashMap<>();
    /**
     * 计次消费
     */
    public static Map<String, String> mTimesConsumeMap = new HashMap<>();
    /**
     * 积分兑换
     */
    public static Map<String, String> mIntegralExchangeMap = new HashMap<>();
    /**
     * 快速消费
     */
    public static Map<String, String> mFastConsumeMap = new HashMap<>();
    /**
     * 套餐消费
     */
    public static Map<String, String> mTCConsumeMap = new HashMap<>();
    /**
     * 会员开卡
     */
    public static Map<String, String> mCardOpenMap = new HashMap<>();

    /**
     * 商品入库
     */
    public static Map<String, String> mGoodsIn = new HashMap<>();

    /**
     * 商品出库
     */
    public static Map<String, String> mGoodsOut = new HashMap<>();

    /**
     * 商品退货
     */
    public static Map<String, String> mReTureOrder = new HashMap<>();

    /**
     * 交班
     */
    public static Map<String, String> mHandOverMap = new HashMap<>();

    /**
     * logo
     */
    public static Bitmap HYKK_LOGO, HYCZ_LOGO, HYCC_LOGO, SPXF_LOGO, KSXF_LOGO, JCXF_LOGO, JFDH_LOGO,
            SPTH_LOGO, JB_LOGO, FTXF_LOGO, HYSK_LOGO, TCXF_LOGO, OPENCARD_LOGO, RK_LOGO, CK_LOGO;
    /**
     * 二维码
     */
    public static Bitmap HYKK_QR, HYCZ_QR, HYCC_QR, SPXF_QR, KSXF_QR, JCXF_QR, JFDH_QR,
            SPTH_QR, JB_QR, FTXF_QR, HYSK_QR, TCXF_QR, OPENCARD_QR, RK_QR, CK_QR;


    /**
     * 打印是否开启
     */
    public static boolean PRINT_IS_OPEN = false;

    /**
     * 标签打印是否开启
     */
    public static boolean LABELPRINT_IS_OPEN = false;

    /**
     * 标签打印是否开启
     */
    public static int LABEL_TYPE = 0;

    /**
     * 小票打印份数
     */
    public static int SPXF_PRINT_TIMES = 1;
    public static int KSXF_PRINT_TIMES = 1;
    public static int HYKK_PRINT_TIMES = 1;
    public static int JB_PRINT_TIMES = 1;

    public static boolean ISLABELCONNECT = false;//USB标签打印机
    public static boolean ISBULETOOTHCONNECT = false;//蓝牙小票打印机
    public static boolean ISCONNECT = false;//USB小票打印机

    /**
     * 获取打印设置
     */
    public static void getPrintParamSet() {
        mTimesRechargeMap.clear();
        mRechargeMap.clear();
        mGoodsConsumeMap.clear();
        mTimesConsumeMap.clear();
        mIntegralExchangeMap.clear();
        mFastConsumeMap.clear();
        mTCConsumeMap.clear();
        mCardOpenMap.clear();
        mHandOverMap.clear();
        mGoodsIn.clear();
        mGoodsOut.clear();
        mReTureOrder.clear();

        String url = HttpAPI.API().GET_PRINT_TEMP;
        AsyncHttpUtils.postHttp(url, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type type = new TypeToken<List<PrintParamSetBean>>() {
                }.getType();
                List<PrintParamSetBean> beanList = response.getData(type);
                for (int i = 0; i < beanList.size(); i++) {
                    List<PrintParamSetBean.TemplateItemsBean> itemsBean = beanList.get(i).getTemplateItems();
                    if (itemsBean != null) {
                        //会员充次
                        if ("HYCC".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCC", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCC", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCC", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCC", false);
                                    }
                                }
                                mTimesRechargeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //会员充值
                        if ("HYCZ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCZ", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCZ", false);
                                    }
                                }
                                mRechargeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //商品消费
                        if ("SPXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPXF", false);
                                    }
                                }
                                mGoodsConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //计次消费
                        if ("JCXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JCXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JCXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JCXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JCXF", false);
                                    }
                                }
                                mTimesConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //积分兑换
                        if ("JFDH".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JFDH", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JFDH", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JFDH", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JFDH", false);
                                    }
                                }
                                mIntegralExchangeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //快速消费
                        if ("KSXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "KSXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "KSXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "KSXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "KSXF", false);
                                    }
                                }
                                mFastConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //套餐消费
                        if ("TCXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "TCXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "TCXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "TCXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "TCXF", false);
                                    }
                                }
                                mTCConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //会员开卡
                        if ("HYKK".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYKK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYKK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYKK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYKK", false);
                                    }
                                }
                                mCardOpenMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //交班
                        if ("JB".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JB", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JB", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JB", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JB", false);
                                    }
                                }
                                mHandOverMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //入库
                        if ("RKJLXQ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "RK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "RK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "RK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "RK", false);
                                    }
                                }
                                mGoodsIn.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //出库
                        if ("CKJLXQ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "CK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "CK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "CK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "CK", false);
                                    }
                                }
                                mGoodsOut.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //商品退货
                        if ("SPTH".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPTH", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPTH", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http") || itemsBean.get(j).getItemValue().contains("https")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPTH", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPTH", false);
                                    }
                                }
                                mReTureOrder.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                    }
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                com.blankj.utilcode.util.ToastUtils.showShort("获取打印模板失败");
            }
        });
    }

    /**
     * 下载打印模板Logo、二维码
     *
     * @param str  下载地址
     * @param type 模板类型
     * @param b    二维码还是Logo true：Logo  false:二维码
     */
    private static void getBitmap(final String str, final String type, final boolean b) {
        new AsyncHttpClient().get(str, new BinaryHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] result) {
                switch (type) {
                    case "HYKK":
                        if (b) {
                            GetPrintSet.HYKK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.HYKK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //会员充值
                    case "HYCZ":
                        if (b) {
                            GetPrintSet.HYCZ_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.HYCZ_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //会员充次
                    case "HYCC":
                        if (b) {
                            GetPrintSet.HYCC_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.HYCC_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    // 商品消费
                    case "SPXF":
                        if (b) {
                            GetPrintSet.SPXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.SPXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //快速消费
                    case "KSXF":
                        if (b) {
                            GetPrintSet.KSXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.KSXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //计次消费
                    case "JCXF":
                        if (b) {
                            GetPrintSet.JCXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.JCXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //积分兑换
                    case "JFDH":
                        if (b) {
                            GetPrintSet.JFDH_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.JFDH_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品退货
                    case "SPTH":
                        if (b) {
                            GetPrintSet.SPTH_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.SPTH_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //交班
                    case "JB":
                        if (b) {
                            GetPrintSet.JB_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.JB_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //房台消费
                    case "FTXF":
                        if (b) {
                            GetPrintSet.FTXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.FTXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //刷卡登记
                    case "HYDJ":
                        if (b) {
                            GetPrintSet.HYSK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.HYSK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //套餐消费
                    case "TCXF":
                        if (b) {
                            GetPrintSet.TCXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.TCXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品入库
                    case "RK":
                        if (b) {
                            GetPrintSet.RK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.RK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品出库
                    case "CK":
                        if (b) {
                            GetPrintSet.CK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            GetPrintSet.CK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
                Log.e(type + "==" + b, str + "-----> ERROR:" + error.getMessage());
            }
        });
    }
}

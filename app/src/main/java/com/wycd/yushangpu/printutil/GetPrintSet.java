package com.wycd.yushangpu.printutil;


import android.content.Context;
import android.graphics.BitmapFactory;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.printutil.bean.PrintParamSetBean;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;

import java.lang.reflect.Type;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * 获取打印设置
 * 作者：罗咏哲 on 2017/8/18 14:05.
 * 邮箱：137615198@qq.com
 */

public class GetPrintSet {

    private static Context mContext;

    /**
     * 获取打印设置
     */
    public static void getPrintParamSet() {
        MyApplication.mTimesRechargeMap.clear();
        MyApplication.mRechargeMap.clear();
        MyApplication.mGoodsConsumeMap.clear();
        MyApplication.mTimesConsumeMap.clear();
        MyApplication.mIntegralExchangeMap.clear();
        MyApplication.mFastConsumeMap.clear();
        MyApplication.mTCConsumeMap.clear();
        MyApplication.mCardOpenMap.clear();
        MyApplication.mHandOverMap.clear();
        MyApplication.mGoodsIn.clear();
        MyApplication.mGoodsOut.clear();
        MyApplication.mReTureOrder.clear();

        mContext = MyApplication.getContext();

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
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCC", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCC", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCC", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCC", false);
                                    }
                                }
                                MyApplication.mTimesRechargeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //会员充值
                        if ("HYCZ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCZ", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYCZ", false);
                                    }
                                }
                                MyApplication.mRechargeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //商品消费
                        if ("SPXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPXF", false);
                                    }
                                }
                                MyApplication.mGoodsConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //计次消费
                        if ("JCXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JCXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JCXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JCXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JCXF", false);
                                    }
                                }
                                MyApplication.mTimesConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //积分兑换
                        if ("JFDH".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JFDH", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JFDH", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JFDH", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JFDH", false);
                                    }
                                }
                                MyApplication.mIntegralExchangeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //快速消费
                        if ("KSXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "KSXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "KSXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "KSXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "KSXF", false);
                                    }
                                }
                                MyApplication.mFastConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //套餐消费
                        if ("TCXF".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "TCXF", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "TCXF", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "TCXF", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "TCXF", false);
                                    }
                                }
                                MyApplication.mTCConsumeMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //会员开卡
                        if ("HYKK".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "KYKK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYKK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "HYKK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "HYKK", false);
                                    }
                                }
                                MyApplication.mCardOpenMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //交班
                        if ("JB".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JB", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JB", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "JB", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "JB", false);
                                    }
                                }
                                MyApplication.mHandOverMap.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //入库
                        if ("RKJLXQ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "RK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "RK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "RK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "RK", false);
                                    }
                                }
                                MyApplication.mGoodsIn.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                        //出库
                        if ("CKJLXQ".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "CK", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "CK", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "CK", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "CK", false);
                                    }
                                }
                                MyApplication.mGoodsOut.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }
                        //商品退货
                        if ("SPTH".equals(beanList.get(i).getPT_Code())) {
                            for (int j = 0; j < itemsBean.size(); j++) {
                                if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPTH", true);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPTH", true);
                                    }
                                }
                                if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                    if (itemsBean.get(j).getItemValue().contains("http")) {
                                        getBitmap(itemsBean.get(j).getItemValue(), "SPTH", false);
                                    } else {
                                        getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                "SPTH", false);
                                    }
                                }
                                MyApplication.mReTureOrder.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                            }
                        }

                    }
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                com.blankj.utilcode.util.ToastUtils.showShort("获取打印模板失败");
            }
        });
    }

    /**
     * 获取打印设置
     */
    public static void getPrintSet() {
        String url = HttpAPI.API().GET_PRINT_SET;
        AsyncHttpUtils.postHttp(url, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                PrintSetBean printSetBean = response.getData(PrintSetBean.class);
                MyApplication.LABEL_TYPE = printSetBean.getPS_TipPrintPaper();
                if (printSetBean.getPS_IsEnabled() == 1) {
                    MyApplication.PRINT_IS_OPEN = true;
                } else {
                    MyApplication.PRINT_IS_OPEN = false;
                }
                if (printSetBean != null && printSetBean.getPrintTimesList() != null) {
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
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                MyApplication.PRINT_IS_OPEN = false;
                if (msg instanceof String)
                    com.blankj.utilcode.util.ToastUtils.showShort((String) msg);
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
                    //会员充值
                    case "HYCZ":
                        if (b) {
                            MyApplication.HYCZ_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.HYCZ_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //会员充次
                    case "HYCC":
                        if (b) {
                            MyApplication.HYCC_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.HYCC_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    // 商品消费
                    case "SPXF":
                        if (b) {
                            MyApplication.SPXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.SPXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //快速消费
                    case "KSXF":
                        if (b) {
                            MyApplication.KSXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.KSXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //计次消费
                    case "JCXF":
                        if (b) {
                            MyApplication.JCXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.JCXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //积分兑换
                    case "JFDH":
                        if (b) {
                            MyApplication.JFDH_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.JFDH_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品退货
                    case "SPTH":
                        if (b) {
                            MyApplication.SPTH_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.SPTH_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //交班
                    case "JB":
                        if (b) {
                            MyApplication.JB_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.JB_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //房台消费
                    case "FTXF":
                        if (b) {
                            MyApplication.FTXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.FTXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //刷卡登记
                    case "HYDJ":
                        if (b) {
                            MyApplication.HYSK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.HYSK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //套餐消费
                    case "TCXF":
                        if (b) {
                            MyApplication.TCXF_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.TCXF_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品入库
                    case "RK":
                        if (b) {
                            MyApplication.RK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.RK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    //商品出库
                    case "CK":
                        if (b) {
                            MyApplication.CK_LOGO = BitmapFactory.decodeByteArray(result, 0, result.length);
                        } else {
                            MyApplication.CK_QR = BitmapFactory.decodeByteArray(result, 0, result.length);
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {

            }
        });
    }
}

package com.wycd.yushangpu.printutil;


import android.content.Context;
import android.graphics.BitmapFactory;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;

import cz.msebera.android.httpclient.Header;

/**
 * 作者：罗咏哲 on 2017/10/10 11:03.
 * 邮箱：137615198@qq.com
 */

public class HttpHelper {

    private static final AsyncHttpClient mClient = new AsyncHttpClient();

    public static AsyncHttpClient getmClient() {
        return mClient;
    }


    /**
     * @param context
     * @param api
     * @param params
     * @param callBack
     */
    public static void post(Context context, String api, RequestParams params, CallBack callBack) {
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
        mClient.setCookieStore(cookieStore);
        if (api.contains("http")) {
            mClient.post(api, params, callBack);
        } else {
            mClient.post(MyApplication.BASE_URL + api, params, callBack);
        }
    }


    /**
     * @param context
     * @param api
     * @param callBack
     */
    public static void post(Context context, String api, CallBack callBack) {
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
        mClient.setCookieStore(cookieStore);

        if (api.contains("http")) {
            mClient.post(api, callBack);
        } else {
            mClient.post(MyApplication.BASE_URL + api, callBack);
        }
    }


    /**
     * 下载打印模板Logo、二维码
     *
     * @param str  下载地址
     * @param type 模板类型
     * @param b    二维码还是Logo true：Logo  false:二维码
     */
    public static void getBitmap(final String str, final String type, final boolean b) {
        mClient.get(str, new BinaryHttpResponseHandler() {

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

package com.wycd.yushangpu.printutil;


import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.printutil.bean.PrintParamSetBean;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.ui.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
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

        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(mContext);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();


        String url = HttpAPI.API().GET_PRINT_TEMP;
        LogUtils.d("======== url ======== >>", url);
        LogUtils.d("======== params ======== >>", params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("<< ======== " + url + " result ========", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<PrintParamSetBean>>() {
                        }.getType();
                        List<PrintParamSetBean> beanList = gson.fromJson(jso.toString(), type);
                        for (int i = 0; i < beanList.size(); i++) {
                            List<PrintParamSetBean.TemplateItemsBean> itemsBean = beanList.get(i).getTemplateItems();
                            if (itemsBean != null) {
                                //会员充次
                                if ("HYCC".equals(beanList.get(i).getPT_Code())) {
                                    for (int j = 0; j < itemsBean.size(); j++) {
                                        if ("LOGO".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "HYCC", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "HYCC", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "HYCC", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "HYCZ", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "HYCZ", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "SPXF", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "SPXF", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "SPXF", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JCXF", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "JCXF", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JCXF", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JFDH", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "JFDH", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JFDH", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "KSXF", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "KSXF", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "KSXF", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "TCXF", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "TCXF", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "TCXF", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "KYKK", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "HYKK", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "HYKK", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JB", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "JB", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "JB", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "RK", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "RK", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "RK", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "CK", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "CK", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "CK", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
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
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "SPTH", true);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "SPTH", true);
                                            }
                                        }
                                        if ("二维码".equals(itemsBean.get(j).getItemName())) {
                                            if (itemsBean.get(j).getItemValue().contains("http")) {
                                                HttpHelper.getBitmap(itemsBean.get(j).getItemValue(), "SPTH", false);
                                            } else {
                                                HttpHelper.getBitmap(MyApplication.IMAGE_URL + itemsBean.get(j).getItemValue(),
                                                        "SPTH", false);
                                            }
                                        }
                                        MyApplication.mReTureOrder.put(itemsBean.get(j).getItemName(), itemsBean.get(j).getItemValue());
                                    }
                                }

                            }
                        }
                    } else {
                        if (jso.getString("code").equals("RemoteLogin") || jso.getString("code").equals("LoginTimeout")) {
                            ActivityManager.getInstance().exit();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                            return;
                        }
//                        ToastUtils.showToast(mContext, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));

                    }
                } catch (Exception e) {
//                    ToastUtils.showToast(mContext, "获取打印模板失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("获取打印模板失败");

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                com.blankj.utilcode.util.ToastUtils.showShort("获取打印模板失败");
                LogUtils.d("xxerror", error.getMessage());
            }
        });
    }

    /**
     * 获取打印设置
     */
    public static void getPrintSet() {
        getPrintSet(null);
    }

    public static void getPrintSet(InterfaceBack back) {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(MyApplication.getContext());
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();

        String url = HttpAPI.API().GET_PRINT_SET;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    Gson gson = new Gson();
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));

                    if (jso.getBoolean("success")) {
                        Type listType = new TypeToken<PrintSetBean>() {
                        }.getType();

                        if (!jso.getString("data").equals("")) {
                            PrintSetBean printSetBean = gson.fromJson(jso.toString(), listType);
                            if (back != null) {
                                back.onResponse(printSetBean);
                            }
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
                    } else {
                        back.onErrorResponse("");
                        if (jso.getString("code").equals("RemoteLogin") || jso.getString("code").equals("LoginTimeout")) {
                            ActivityManager.getInstance().exit();
                            Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MyApplication.getContext().startActivity(intent);
                            com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                            return;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] responseBody, Throwable error) {
                MyApplication.PRINT_IS_OPEN = false;
                com.blankj.utilcode.util.ToastUtils.showShort(error.getMessage());
                back.onErrorResponse(error.getMessage());
            }
        });
    }

}

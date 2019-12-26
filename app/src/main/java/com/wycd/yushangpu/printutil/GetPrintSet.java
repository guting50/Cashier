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
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    LogUtils.d("xxoutLoginS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {

                        Gson gson = new Gson();
                        PrintParamSetBean bean = gson.fromJson(jso.toString(), PrintParamSetBean.class);
                        for (int i = 0; i < bean.getData().size(); i++) {
                            List<PrintParamSetBean.DataBean.TemplateItemsBean> itemsBean = bean.getData().get(i).getTemplateItems();
                            if (itemsBean != null) {
                                //会员充次
                                if ("HYCC".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("HYCZ".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("SPXF".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("JCXF".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("JFDH".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("KSXF".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("TCXF".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("HYKK".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("JB".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("RKJLXQ".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("CKJLXQ".equals(bean.getData().get(i).getPT_Code())) {
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
                                if ("SPTH".equals(bean.getData().get(i).getPT_Code())) {
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
//                ToastUtils.showToast(mContext, "获取打印模板失败");
                com.blankj.utilcode.util.ToastUtils.showShort("获取打印模板失败");
                LogUtils.d("xxerror", error.getMessage());
            }

        });

    }

    /**
     * 获取打印设置
     */
    public static void getPrintSet() {


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
                            MyApplication.LABEL_TYPE = printSetBean.getData().getPS_TipPrintPaper();
                            if (printSetBean.getData().getPS_IsEnabled() == 1) {
                                MyApplication.PRINT_IS_OPEN = true;
                            } else {
                                MyApplication.PRINT_IS_OPEN = false;
                            }
                            if (printSetBean.getData() != null && printSetBean.getData().getPrintTimesList() != null) {
                                for (int i = 0; i < printSetBean.getData().getPrintTimesList().size(); i++) {
                                    PrintSetBean.DataBean.PrintTimesListBean bean = printSetBean.getData().getPrintTimesList().get(i);
                                    if ("SPXF".equals(bean.getPT_Code())) {
                                        MyApplication.SPXF_PRINT_TIMES = bean.getPT_Times();
                                    }
                                    if ("JB".equals(bean.getPT_Code())) {
                                        MyApplication.JB_PRINT_TIMES = bean.getPT_Times();
                                    }
                                }
//                                HomeActivity.printConnect(MyApplication.getContext(), printSetBean.getData().getPS_PrinterName());
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
//                ToastUtils.showToast(mContext, error.getMessage());
                com.blankj.utilcode.util.ToastUtils.showShort(error.getMessage());
            }

        });
    }

}

package com.wycd.yushangpu.model;

import android.app.Activity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by songxiaotao on 2018/6/19.
 */

public class ImpLogin {

    private static HashMap<String, String> CookieContiner = new HashMap<String, String>();
    public static String cookie;

    public void login(final Activity ac, final String UserAcount, final String PassWord,
                      final InterfaceBack back) {
        // TODO 自动生成的方法存根
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(ac);
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("UserAcount", UserAcount);
        params.put("PassWord", PassWord);
//        客户端类型 1.网页 2.安卓 APP 3.PC客户端 4.苹果APP 5.触屏收银
        params.put("Type", "5");
        String url = HttpAPI.API().LOGIN;
        LogUtils.d("xxparams", params.toString());
        LogUtils.d("xxurl", url);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    if (headers == null) {
                        return;
                    } else {
                        for (int i = 0; i < headers.length; i++) {
                            String cookie = headers[i].getValue();
                            String[] cookievalues = cookie.split(";");
                            for (int j = 0; j < cookievalues.length; j++) {
                                String[] keyPair = cookievalues[j].split("=");
                                String key = keyPair[0].trim();
                                String value = keyPair.length > 1 ? keyPair[1].trim() : "";
                                CookieContiner.put(key, value);
                            }
                        }
                        AddCookies();

                    }
                    LogUtils.d("xxLoginS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getBoolean("success")) {
                        back.onResponse(jso.toString());
                        PreferenceHelper.write(ac, "yunshangpu", "UserAcount", UserAcount);
                        PreferenceHelper.write(ac, "yunshangpu", "PassWord", PassWord);
                    } else {
//                        ToastUtils.showToast(ac, jso.getString("msg"));
                        com.blankj.utilcode.util.ToastUtils.showShort(jso.getString("msg"));
                        back.onErrorResponse("");
                    }
                } catch (Exception e) {
//                    ToastUtils.showToast(ac, "登录失败，请重新登录");
//                    com.blankj.utilcode.util.ToastUtils.showShort("登录失败，请重新登录");
                    back.onErrorResponse("");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                ToastUtils.showToast(ac, "登录失败，请重新登录");
                com.blankj.utilcode.util.ToastUtils.showShort("登录失败，请重新登录");
                LogUtils.d("xxerror", error.getMessage() + "");
                back.onErrorResponse("");
            }
        });
    }

    /**
     * 增加Cookie
     *
     * @param
     */
    @SuppressWarnings("rawtypes")
    public void AddCookies() {
        StringBuilder sb = new StringBuilder();
        Iterator iter = CookieContiner.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = entry.getKey().toString();
            String val = entry.getValue().toString();
            sb.append(key);
            sb.append("=");
            sb.append(val);
            sb.append(";");
        }
        cookie = sb.toString();
    }

    private void getSetting() {

    }
}

package com.wycd.yushangpu.http;

import com.wycd.yushangpu.MyApplication;

/**
 * Created by songxiaotao on 2018/1/17.
 */

public class UrlTools {
    public static String obtainUrl(String url) {
//        return  "http://192.168.1.240:807/" + url;
        return MyApplication.BASE_URL + url;
    }
}

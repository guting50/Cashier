package com.wycd.yushangpu.http;

import com.wycd.yushangpu.MyApplication;

/**
 * Created by songxiaotao on 2018/1/17.
 */

public class ImgUrlTools {
    public static String obtainUrl(String url) {
        if (url.startsWith("/")) {
            return MyApplication.IMAGE_URL + url;
        } else {
            return url;
        }
    }
}

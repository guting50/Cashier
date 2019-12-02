package com.wycd.yushangpu.http;

/**
 * Created by songxiaotao on 2018/1/17.
 */

public class ImgUrlTools {
    public static String obtainUrl(String url) {
//        return  "http://47.102.44.14:42259/" + url;
        if(url.startsWith("/")) {
            return "http://pc.yunvip123.com" + url;
        }else {
            return url;
        }
    }
}

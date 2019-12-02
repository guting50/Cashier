package com.wycd.yushangpu.http;

/**
 * Created by songxiaotao on 2017/7/2.
 */


public interface InterfaceThreeBack {
    public void onResponse(Object response);

    public void onErrorResponse(Object msg);
    public void onThreeResponse(Object object);
}

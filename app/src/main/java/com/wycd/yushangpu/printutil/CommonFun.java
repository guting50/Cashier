package com.wycd.yushangpu.printutil;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by ZPH on 2019-09-19.
 */

public class CommonFun {

    private static Gson gson = new Gson();

    static public <T> WebResult<T> ToWebResult(String strResult, Class<T> type) {
        WebResult<T> webResult = new WebResult<T>();
        webResult =gson.fromJson(strResult, webResult.getClass());
        String jsonData = gson.toJson(webResult.getData());
        T objData = gson.fromJson(jsonData, type);
        webResult.setData(objData);
        return webResult;
    }


    static public <T> T JsonToObj(String strResult, Class<T> type) {
        try {
            T objData = gson.fromJson(strResult, type);
            return objData;
        } catch (Exception ex){
             return null;
        }
    }

    static public <T> T JsonToObj(String strResult, Type type) {
        try {
            T objData = gson.fromJson(strResult, type);
            return objData;
        } catch (Exception ex){
            return null;
        }
    }
}

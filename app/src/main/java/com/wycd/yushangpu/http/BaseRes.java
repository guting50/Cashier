package com.wycd.yushangpu.http;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class BaseRes {
    private boolean success;
    private String code;
    private String msg;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public <T> T getData(Class<T> tClass) {
        return new Gson().fromJson(new Gson().toJson(data), tClass);
    }

    public <T> T getData(Type type) {
        return new Gson().fromJson(new Gson().toJson(data), type);
    }
}

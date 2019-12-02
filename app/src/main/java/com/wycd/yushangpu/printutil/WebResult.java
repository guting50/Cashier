package com.wycd.yushangpu.printutil;


/**
 * 描述：API统一返回结果
 * on 2018/02/20 11:27
 */

public class WebResult<T> {

    /**
     * success :返回结果  true成功  false失败
     * code : 状态码
     * msg : 消息
     * data : 返回数据
     */

    private boolean success;
    private String code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

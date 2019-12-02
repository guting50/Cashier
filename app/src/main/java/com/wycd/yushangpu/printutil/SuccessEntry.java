package com.wycd.yushangpu.printutil;

/**
 * Created by ZPH on 2019-02-20.
 */

public class SuccessEntry {

    /**
     * success :返回结果  true成功  false失败
     * code : 状态码
     * msg : 消息
     * data : 返回数据
     */

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
        if(code==null){
            code="";
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if(msg==null){
            msg="";
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

}
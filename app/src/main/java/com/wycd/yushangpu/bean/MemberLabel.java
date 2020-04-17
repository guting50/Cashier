package com.wycd.yushangpu.bean;

import java.io.Serializable;

public class MemberLabel implements Serializable {
    private static final long UID = 1L;
    /**
     * ML_GID : 3e2eb32e-f8c7-470f-98d8-6b6be4a2f729
     * ML_StoreID : null
     * ML_CYGID : 348e79f2-ff35-4d62-8298-9d37f06fd5e0
     * ML_Name : 标签4
     * ML_ColorValue : #ff0000
     * ML_CreateTime : 2017-06-28 13:55:34
     * ML_CreateUser : 1540004275@qq.com
     * ML_Remark : 444444444
     */

    private String ML_GID;
    private Object ML_StoreID;
    private String ML_CYGID;
    private String ML_Name;
    private String ML_ColorValue;
    private String ML_CreateTime;
    private String ML_CreateUser;
    private String ML_Remark;
    private int ML_Type;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;

    public String getML_GID() {
        return ML_GID;
    }

    public void setML_GID(String ML_GID) {
        this.ML_GID = ML_GID;
    }

    public Object getML_StoreID() {
        return ML_StoreID;
    }

    public void setML_StoreID(Object ML_StoreID) {
        this.ML_StoreID = ML_StoreID;
    }

    public String getML_CYGID() {
        return ML_CYGID;
    }

    public void setML_CYGID(String ML_CYGID) {
        this.ML_CYGID = ML_CYGID;
    }

    public String getML_Name() {
        return ML_Name;
    }

    public void setML_Name(String ML_Name) {
        this.ML_Name = ML_Name;
    }

    public String getML_ColorValue() {
        return ML_ColorValue;
    }

    public void setML_ColorValue(String ML_ColorValue) {
        this.ML_ColorValue = ML_ColorValue;
    }

    public String getML_CreateTime() {
        return ML_CreateTime;
    }

    public void setML_CreateTime(String ML_CreateTime) {
        this.ML_CreateTime = ML_CreateTime;
    }

    public String getML_CreateUser() {
        return ML_CreateUser;
    }

    public void setML_CreateUser(String ML_CreateUser) {
        this.ML_CreateUser = ML_CreateUser;
    }

    public String getML_Remark() {
        return ML_Remark;
    }

    public void setML_Remark(String ML_Remark) {
        this.ML_Remark = ML_Remark;
    }

    public int getML_Type() {
        return ML_Type;
    }

    public void setML_Type(int ML_Type) {
        this.ML_Type = ML_Type;
    }
}

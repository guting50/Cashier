package com.wycd.yushangpu.bean;

import java.io.Serializable;

public class OrderCanshhu implements Serializable {
     private String GID;
    private String   CO_Type;
    private String      CO_OrderCode;

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getCO_Type() {
        return CO_Type;
    }

    public void setCO_Type(String CO_Type) {
        this.CO_Type = CO_Type;
    }

    public String getCO_OrderCode() {
        return CO_OrderCode;
    }

    public void setCO_OrderCode(String CO_OrderCode) {
        this.CO_OrderCode = CO_OrderCode;
    }
}

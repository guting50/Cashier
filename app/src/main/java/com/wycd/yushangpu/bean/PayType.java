package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class PayType implements Serializable {

    private String PayCode;//	 编码	String
    private String PayName;//	名称	string
    private double PayMoney;//	 金额	decimal?
    private double PayPoint;//	抵扣积分	decimal?
    private String[] GID;//	 优惠券关系表GID	string[]

    public String[] getGID() {
        return GID;
    }

    public void setGID(String[] GID) {
        this.GID = GID;
    }

    public String getPayCode() {
        return PayCode;
    }

    public void setPayCode(String payCode) {
        PayCode = payCode;
    }

    public String getPayName() {
        return PayName;
    }

    public void setPayName(String payName) {
        PayName = payName;
    }

    public double getPayMoney() {
        return PayMoney;
    }

    public void setPayMoney(double payMoney) {
        PayMoney = payMoney;
    }

    public double getPayPoint() {
        return PayPoint;
    }

    public void setPayPoint(double payPoint) {
        PayPoint = payPoint;
    }

}

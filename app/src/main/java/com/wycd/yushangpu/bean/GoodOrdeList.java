package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class GoodOrdeList implements Serializable {

    private String PM_GID;//	商品GID	String
    private double PM_Number;//商品数量	decimal
    private double PM_Money;//	折后金额（小计）	decimal?
    private List<String> EM_GIDList;//	提成员工	List<string>
    private int Type;//	类型	int	0普通，1套餐
    private String ExpiryTime;//	过期时间(充次)	string	null为永久有效
    private String WR_GIDList;//	计次规则	string
    private double PM_UnitPrice;//	商品单价	decimal?
    private double PM_MemPrice;//	会员价格
    private double jisuanPrice;

    public double getJisuanPrice() {
        return jisuanPrice;
    }

    public void setJisuanPrice(double jisuanPrice) {
        this.jisuanPrice = jisuanPrice;
    }

    public double getPM_MemPrice() {
        return PM_MemPrice;
    }

    public void setPM_MemPrice(double PM_MemPrice) {
        this.PM_MemPrice = PM_MemPrice;
    }

    public String getPM_GID() {
        return PM_GID;
    }

    public void setPM_GID(String PM_GID) {
        this.PM_GID = PM_GID;
    }

    public double getPM_Number() {
        return PM_Number;
    }

    public void setPM_Number(double PM_Number) {
        this.PM_Number = PM_Number;
    }

    public double getPM_Money() {
        return PM_Money;
    }

    public void setPM_Money(double PM_Money) {
        this.PM_Money = PM_Money;
    }

    public List<String> getEM_GIDList() {
        return EM_GIDList;
    }

    public void setEM_GIDList(List<String> EM_GIDList) {
        this.EM_GIDList = EM_GIDList;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getExpiryTime() {
        return ExpiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        ExpiryTime = expiryTime;
    }

    public String getWR_GIDList() {
        return WR_GIDList;
    }

    public void setWR_GIDList(String WR_GIDList) {
        this.WR_GIDList = WR_GIDList;
    }

    public double getPM_UnitPrice() {
        return PM_UnitPrice;
    }

    public void setPM_UnitPrice(double PM_UnitPrice) {
        this.PM_UnitPrice = PM_UnitPrice;
    }
}

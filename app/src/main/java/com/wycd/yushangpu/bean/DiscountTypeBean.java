package com.wycd.yushangpu.bean;

import java.io.Serializable;

/**
 * 优惠活动JavaBean
 * 作者：罗咏哲 on 2017/6/24 16:00.
 * 邮箱：137615198@qq.com
 */

public class DiscountTypeBean implements Serializable {
    /**
     * RP_IsOpen : 1
     * GID : f239564a-c77b-432f-a1b1-beeb558fa673
     * RP_Name : 充值满100元送10元
     * RP_Type : 1
     * RP_RechargeMoney : 100.0
     * RP_GiveMoney : 10.0
     * RP_GivePoint : 10
     * RP_ReduceMoney : 0.0
     * RP_ValidType : 1
     * RP_ValidWeekMonth :
     * RP_ValidStartTime : 2017-06-23 00:00:00
     * RP_ValidEndTime : 2017-06-29 00:00:00
     * RP_ISDouble : 0
     * RP_Creator : 1540004275@qq.com
     * RP_CreateTime : 2017-06-24 15:29:43
     * CY_GID : 348e79f2-ff35-4d62-8298-9d37f06fd5e0
     * RP_Remark : null
     */

    private int RP_IsOpen;
    private String GID;
    private String RP_Name;
    private int RP_Type;
    private double RP_RechargeMoney;
    private double RP_GiveMoney;
    private int RP_GivePoint;
    private double RP_ReduceMoney;
    private int RP_ValidType;
    private String RP_ValidWeekMonth;
    private String RP_ValidStartTime;
    private String RP_ValidEndTime;
    private int RP_ISDouble;
    private String RP_Creator;
    private String RP_CreateTime;
    private String CY_GID;
    private String RP_Remark;
    private boolean isChecked;//是否选中
    private boolean flag;
    private boolean show;
    private String str;
    private double RP_Discount;


    public double getRP_Discount() {
        return RP_Discount;
    }

    public void setRP_Discount(double RP_Discount) {
        this.RP_Discount = RP_Discount;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getRP_IsOpen() {
        return RP_IsOpen;
    }

    public void setRP_IsOpen(int RP_IsOpen) {
        this.RP_IsOpen = RP_IsOpen;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getRP_Name() {
        return RP_Name;
    }

    public void setRP_Name(String RP_Name) {
        this.RP_Name = RP_Name;
    }

    public int getRP_Type() {
        return RP_Type;
    }

    public void setRP_Type(int RP_Type) {
        this.RP_Type = RP_Type;
    }

    public double getRP_RechargeMoney() {
        return RP_RechargeMoney;
    }

    public void setRP_RechargeMoney(double RP_RechargeMoney) {
        this.RP_RechargeMoney = RP_RechargeMoney;
    }

    public double getRP_GiveMoney() {
        return RP_GiveMoney;
    }

    public void setRP_GiveMoney(double RP_GiveMoney) {
        this.RP_GiveMoney = RP_GiveMoney;
    }

    public int getRP_GivePoint() {
        return RP_GivePoint;
    }

    public void setRP_GivePoint(int RP_GivePoint) {
        this.RP_GivePoint = RP_GivePoint;
    }

    public double getRP_ReduceMoney() {
        return RP_ReduceMoney;
    }

    public void setRP_ReduceMoney(double RP_ReduceMoney) {
        this.RP_ReduceMoney = RP_ReduceMoney;
    }

    public int getRP_ValidType() {
        return RP_ValidType;
    }

    public void setRP_ValidType(int RP_ValidType) {
        this.RP_ValidType = RP_ValidType;
    }

    public String getRP_ValidWeekMonth() {
        return RP_ValidWeekMonth;
    }

    public void setRP_ValidWeekMonth(String RP_ValidWeekMonth) {
        this.RP_ValidWeekMonth = RP_ValidWeekMonth;
    }

    public String getRP_ValidStartTime() {
        return RP_ValidStartTime;
    }

    public void setRP_ValidStartTime(String RP_ValidStartTime) {
        this.RP_ValidStartTime = RP_ValidStartTime;
    }

    public String getRP_ValidEndTime() {
        return RP_ValidEndTime;
    }

    public void setRP_ValidEndTime(String RP_ValidEndTime) {
        this.RP_ValidEndTime = RP_ValidEndTime;
    }

    public int getRP_ISDouble() {
        return RP_ISDouble;
    }

    public void setRP_ISDouble(int RP_ISDouble) {
        this.RP_ISDouble = RP_ISDouble;
    }

    public String getRP_Creator() {
        return RP_Creator;
    }

    public void setRP_Creator(String RP_Creator) {
        this.RP_Creator = RP_Creator;
    }

    public String getRP_CreateTime() {
        return RP_CreateTime;
    }

    public void setRP_CreateTime(String RP_CreateTime) {
        this.RP_CreateTime = RP_CreateTime;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getRP_Remark() {
        return RP_Remark;
    }

    public void setRP_Remark(String RP_Remark) {
        this.RP_Remark = RP_Remark;
    }

}

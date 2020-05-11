package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DeductRuleBean implements Parcelable {
    /**
     * SS_CouponPayValue : 0.0
     * SS_CouponPayUnit : %
     * SS_GoodOrCombo : 0
     * SS_GoodTypeGID : 000000
     * SS_GoodTypeName : 所有分类
     * GID : e88178a3-42dc-43e3-8ed9-1a80c389729a
     * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
     * SS_Type : 10
     * SS_ProductGID : 000000
     * SS_ProductName : 所有产品
     * SS_GradeGID : 000002
     * SS_GradeName : 会员
     * SS_ShopGID : 000000
     * SS_ShopName : 所有店铺
     * SS_DepartmentGID : 000000
     * SS_DepartmentName : 所有部门
     * SS_Mode : 10
     * SS_Value : 10.0
     * SS_Unit : %
     * SS_BalancePayValue : 0.0
     * SS_BalancePayUnit : %
     * SS_PointPayValue : 0.0
     * SS_PointPayUnit : %
     * SS_OtherPayValue : 0.0
     * SS_OtherPayUnit : %
     * SS_Remark :
     * SS_UpdateTime : 2018-06-29 16:03:35
     */

    private double SS_CouponPayValue;
    private String SS_CouponPayUnit;
    private int SS_GoodOrCombo;
    private String SS_GoodTypeGID;
    private String SS_GoodTypeName;
    private String GID;
    private String CY_GID;
    private int SS_Type;//提成类型 10售卡提成20充值提成30充次提成40快速消费提成50商品消费提成60计次提成80计时提成 90房台消费提成
    private String SS_ProductGID;
    private String SS_ProductName;
    private String SS_GradeGID;
    private String SS_GradeName;
    private String SS_ShopGID;
    private String SS_ShopName;
    private String SS_DepartmentGID;
    private String SS_DepartmentName;
    private int SS_Mode;
    private double SS_Value;
    private String SS_Unit;
    private double SS_BalancePayValue;
    private String SS_BalancePayUnit;
    private double SS_PointPayValue;
    private String SS_PointPayUnit;
    private double SS_OtherPayValue;
    private String SS_OtherPayUnit;
    private String SS_Remark;
    private String SS_UpdateTime;

    public double getSS_CouponPayValue() {
        return SS_CouponPayValue;
    }

    public void setSS_CouponPayValue(double SS_CouponPayValue) {
        this.SS_CouponPayValue = SS_CouponPayValue;
    }

    public String getSS_CouponPayUnit() {
        return SS_CouponPayUnit;
    }

    public void setSS_CouponPayUnit(String SS_CouponPayUnit) {
        this.SS_CouponPayUnit = SS_CouponPayUnit;
    }

    public int getSS_GoodOrCombo() {
        return SS_GoodOrCombo;
    }

    public void setSS_GoodOrCombo(int SS_GoodOrCombo) {
        this.SS_GoodOrCombo = SS_GoodOrCombo;
    }

    public String getSS_GoodTypeGID() {
        return SS_GoodTypeGID;
    }

    public void setSS_GoodTypeGID(String SS_GoodTypeGID) {
        this.SS_GoodTypeGID = SS_GoodTypeGID;
    }

    public String getSS_GoodTypeName() {
        return SS_GoodTypeName;
    }

    public void setSS_GoodTypeName(String SS_GoodTypeName) {
        this.SS_GoodTypeName = SS_GoodTypeName;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public int getSS_Type() {
        return SS_Type;
    }

    public void setSS_Type(int SS_Type) {
        this.SS_Type = SS_Type;
    }

    public String getSS_ProductGID() {
        return SS_ProductGID;
    }

    public void setSS_ProductGID(String SS_ProductGID) {
        this.SS_ProductGID = SS_ProductGID;
    }

    public String getSS_ProductName() {
        return SS_ProductName;
    }

    public void setSS_ProductName(String SS_ProductName) {
        this.SS_ProductName = SS_ProductName;
    }

    public String getSS_GradeGID() {
        return SS_GradeGID;
    }

    public void setSS_GradeGID(String SS_GradeGID) {
        this.SS_GradeGID = SS_GradeGID;
    }

    public String getSS_GradeName() {
        return SS_GradeName;
    }

    public void setSS_GradeName(String SS_GradeName) {
        this.SS_GradeName = SS_GradeName;
    }

    public String getSS_ShopGID() {
        return SS_ShopGID;
    }

    public void setSS_ShopGID(String SS_ShopGID) {
        this.SS_ShopGID = SS_ShopGID;
    }

    public String getSS_ShopName() {
        return SS_ShopName;
    }

    public void setSS_ShopName(String SS_ShopName) {
        this.SS_ShopName = SS_ShopName;
    }

    public String getSS_DepartmentGID() {
        return SS_DepartmentGID;
    }

    public void setSS_DepartmentGID(String SS_DepartmentGID) {
        this.SS_DepartmentGID = SS_DepartmentGID;
    }

    public String getSS_DepartmentName() {
        return SS_DepartmentName;
    }

    public void setSS_DepartmentName(String SS_DepartmentName) {
        this.SS_DepartmentName = SS_DepartmentName;
    }

    public int getSS_Mode() {
        return SS_Mode;
    }

    public void setSS_Mode(int SS_Mode) {
        this.SS_Mode = SS_Mode;
    }

    public double getSS_Value() {
        return SS_Value;
    }

    public void setSS_Value(double SS_Value) {
        this.SS_Value = SS_Value;
    }

    public String getSS_Unit() {
        return SS_Unit;
    }

    public void setSS_Unit(String SS_Unit) {
        this.SS_Unit = SS_Unit;
    }

    public double getSS_BalancePayValue() {
        return SS_BalancePayValue;
    }

    public void setSS_BalancePayValue(double SS_BalancePayValue) {
        this.SS_BalancePayValue = SS_BalancePayValue;
    }

    public String getSS_BalancePayUnit() {
        return SS_BalancePayUnit;
    }

    public void setSS_BalancePayUnit(String SS_BalancePayUnit) {
        this.SS_BalancePayUnit = SS_BalancePayUnit;
    }

    public double getSS_PointPayValue() {
        return SS_PointPayValue;
    }

    public void setSS_PointPayValue(double SS_PointPayValue) {
        this.SS_PointPayValue = SS_PointPayValue;
    }

    public String getSS_PointPayUnit() {
        return SS_PointPayUnit;
    }

    public void setSS_PointPayUnit(String SS_PointPayUnit) {
        this.SS_PointPayUnit = SS_PointPayUnit;
    }

    public double getSS_OtherPayValue() {
        return SS_OtherPayValue;
    }

    public void setSS_OtherPayValue(double SS_OtherPayValue) {
        this.SS_OtherPayValue = SS_OtherPayValue;
    }

    public String getSS_OtherPayUnit() {
        return SS_OtherPayUnit;
    }

    public void setSS_OtherPayUnit(String SS_OtherPayUnit) {
        this.SS_OtherPayUnit = SS_OtherPayUnit;
    }

    public String getSS_Remark() {
        return SS_Remark;
    }

    public void setSS_Remark(String SS_Remark) {
        this.SS_Remark = SS_Remark;
    }

    public String getSS_UpdateTime() {
        return SS_UpdateTime;
    }

    public void setSS_UpdateTime(String SS_UpdateTime) {
        this.SS_UpdateTime = SS_UpdateTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.SS_CouponPayValue);
        dest.writeString(this.SS_CouponPayUnit);
        dest.writeInt(this.SS_GoodOrCombo);
        dest.writeString(this.SS_GoodTypeGID);
        dest.writeString(this.SS_GoodTypeName);
        dest.writeString(this.GID);
        dest.writeString(this.CY_GID);
        dest.writeInt(this.SS_Type);
        dest.writeString(this.SS_ProductGID);
        dest.writeString(this.SS_ProductName);
        dest.writeString(this.SS_GradeGID);
        dest.writeString(this.SS_GradeName);
        dest.writeString(this.SS_ShopGID);
        dest.writeString(this.SS_ShopName);
        dest.writeString(this.SS_DepartmentGID);
        dest.writeString(this.SS_DepartmentName);
        dest.writeInt(this.SS_Mode);
        dest.writeDouble(this.SS_Value);
        dest.writeString(this.SS_Unit);
        dest.writeDouble(this.SS_BalancePayValue);
        dest.writeString(this.SS_BalancePayUnit);
        dest.writeDouble(this.SS_PointPayValue);
        dest.writeString(this.SS_PointPayUnit);
        dest.writeDouble(this.SS_OtherPayValue);
        dest.writeString(this.SS_OtherPayUnit);
        dest.writeString(this.SS_Remark);
        dest.writeString(this.SS_UpdateTime);
    }

    public DeductRuleBean() {
    }

    protected DeductRuleBean(Parcel in) {
        this.SS_CouponPayValue = in.readDouble();
        this.SS_CouponPayUnit = in.readString();
        this.SS_GoodOrCombo = in.readInt();
        this.SS_GoodTypeGID = in.readString();
        this.SS_GoodTypeName = in.readString();
        this.GID = in.readString();
        this.CY_GID = in.readString();
        this.SS_Type = in.readInt();
        this.SS_ProductGID = in.readString();
        this.SS_ProductName = in.readString();
        this.SS_GradeGID = in.readString();
        this.SS_GradeName = in.readString();
        this.SS_ShopGID = in.readString();
        this.SS_ShopName = in.readString();
        this.SS_DepartmentGID = in.readString();
        this.SS_DepartmentName = in.readString();
        this.SS_Mode = in.readInt();
        this.SS_Value = in.readDouble();
        this.SS_Unit = in.readString();
        this.SS_BalancePayValue = in.readDouble();
        this.SS_BalancePayUnit = in.readString();
        this.SS_PointPayValue = in.readDouble();
        this.SS_PointPayUnit = in.readString();
        this.SS_OtherPayValue = in.readDouble();
        this.SS_OtherPayUnit = in.readString();
        this.SS_Remark = in.readString();
        this.SS_UpdateTime = in.readString();
    }

    public static final Parcelable.Creator<DeductRuleBean> CREATOR = new Parcelable.Creator<DeductRuleBean>() {
        @Override
        public DeductRuleBean createFromParcel(Parcel source) {
            return new DeductRuleBean(source);
        }

        @Override
        public DeductRuleBean[] newArray(int size) {
            return new DeductRuleBean[size];
        }
    };
}

package com.wycd.yushangpu.bean;

public class YhqMsg {


    private String GID;//	电子优惠券GID	string
    private String VIP_GID;
    private String EC_GID;
    private String EC_ReddemCode;
    private int VCR_IsForver;//	是否永久有效	itn?	0否 1 是 2 相对时间

    private String VCR_StatrTime;//	有效开始时间	DateTime?
    private String VCR_EndTime;//	有效结束时间	DateTime？
    private int VCR_IsUse;
    private String VCR_CreatorTime;
    private String SM_GID;

    private String CY_GID;
    private int EC_DiscountType;//	优惠券类型	int?	1代金券，2折扣券
    private int EC_UseType;//	使用类型	int?	1消费，2 充值
    private double EC_Discount;//	优惠券金额/折扣	decimal?
    private double EC_Denomination;//	优惠券面额	decimal?

    private String EC_Name;//	优惠券名称	string
    private int EC_IsOverlay;// 是否可叠加 0不可叠加使用 1可叠加使用
    private double EC_GiftCondition;//	优惠券赠送条件值	decimal?
    private String SM_Name;//	店铺名	string

    private boolean isChose;

    public boolean isChose() {
        return isChose;
    }

    public void setChose(boolean chose) {
        isChose = chose;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getVIP_GID() {
        return VIP_GID;
    }

    public void setVIP_GID(String VIP_GID) {
        this.VIP_GID = VIP_GID;
    }

    public String getEC_GID() {
        return EC_GID;
    }

    public void setEC_GID(String EC_GID) {
        this.EC_GID = EC_GID;
    }

    public String getEC_ReddemCode() {
        return EC_ReddemCode;
    }

    public void setEC_ReddemCode(String EC_ReddemCode) {
        this.EC_ReddemCode = EC_ReddemCode;
    }

    public int getVCR_IsForver() {
        return VCR_IsForver;
    }

    public void setVCR_IsForver(int VCR_IsForver) {
        this.VCR_IsForver = VCR_IsForver;
    }

    public String getVCR_StatrTime() {
        return VCR_StatrTime;
    }

    public void setVCR_StatrTime(String VCR_StatrTime) {
        this.VCR_StatrTime = VCR_StatrTime;
    }

    public String getVCR_EndTime() {
        return VCR_EndTime;
    }

    public void setVCR_EndTime(String VCR_EndTime) {
        this.VCR_EndTime = VCR_EndTime;
    }

    public int getVCR_IsUse() {
        return VCR_IsUse;
    }

    public void setVCR_IsUse(int VCR_IsUse) {
        this.VCR_IsUse = VCR_IsUse;
    }

    public String getVCR_CreatorTime() {
        return VCR_CreatorTime;
    }

    public void setVCR_CreatorTime(String VCR_CreatorTime) {
        this.VCR_CreatorTime = VCR_CreatorTime;
    }

    public String getSM_GID() {
        return SM_GID;
    }

    public void setSM_GID(String SM_GID) {
        this.SM_GID = SM_GID;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public int getEC_DiscountType() {
        return EC_DiscountType;
    }

    public void setEC_DiscountType(int EC_DiscountType) {
        this.EC_DiscountType = EC_DiscountType;
    }

    public int getEC_UseType() {
        return EC_UseType;
    }

    public void setEC_UseType(int EC_UseType) {
        this.EC_UseType = EC_UseType;
    }

    public double getEC_Discount() {
        return EC_Discount;
    }

    public void setEC_Discount(double EC_Discount) {
        this.EC_Discount = EC_Discount;
    }

    public double getEC_Denomination() {
        return EC_Denomination;
    }

    public void setEC_Denomination(double EC_Denomination) {
        this.EC_Denomination = EC_Denomination;
    }

    public String getEC_Name() {
        return EC_Name;
    }

    public void setEC_Name(String EC_Name) {
        this.EC_Name = EC_Name;
    }

    public int getEC_IsOverlay() {
        return EC_IsOverlay;
    }

    public void setEC_IsOverlay(int EC_IsOverlay) {
        this.EC_IsOverlay = EC_IsOverlay;
    }

    public double getEC_GiftCondition() {
        return EC_GiftCondition;
    }

    public void setEC_GiftCondition(double EC_GiftCondition) {
        this.EC_GiftCondition = EC_GiftCondition;
    }

    public String getSM_Name() {
        return SM_Name;
    }

    public void setSM_Name(String SM_Name) {
        this.SM_Name = SM_Name;
    }


}

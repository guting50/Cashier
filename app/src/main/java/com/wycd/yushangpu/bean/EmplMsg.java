package com.wycd.yushangpu.bean;

public class EmplMsg {

    private String GID;//	员工GID
    private String SM_GID;//	店铺ID
    private String SM_Name;//	店铺名称
    private String CY_GID;//	公司表ID
    private String DM_GID;//	部门ID
    private String DM_Name;//	部门名称
    private String EM_Code;//	员工编号
    private String EM_Name;//	员工姓名
    private int EM_Sex;//	员工性别
    private String EM_Phone;//	手机号
    private String EM_Addr;//	联系地址
    private String EM_Remark;//	备注
    private String EM_UpdateTime;//	创建时间
    private String EM_Creator;//	操作员
    private String EM_Birthday;//	员工生日
    private int EM_TipCard;//	售卡提成
    private int EM_TipRecharge;//	充值提成
    private int EM_TipChargeTime;//	充次提成
    private int EM_TipGoodsConsume;//	商品消费提成
    private int EM_TipFastConsume;//	快速消费提成
    private int EM_TipTimesConsume;//	签到提成
    private int EM_TipComboConsume;//	套餐消费提成
    private String staffProportion;//提成比例或者固定提成金额
    private boolean ischose;

    public boolean isIschose() {
        return ischose;
    }

    public void setIschose(boolean ischose) {
        this.ischose = ischose;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getSM_GID() {
        return SM_GID;
    }

    public void setSM_GID(String SM_GID) {
        this.SM_GID = SM_GID;
    }

    public String getSM_Name() {
        return SM_Name;
    }

    public void setSM_Name(String SM_Name) {
        this.SM_Name = SM_Name;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getDM_GID() {
        return DM_GID;
    }

    public void setDM_GID(String DM_GID) {
        this.DM_GID = DM_GID;
    }

    public String getDM_Name() {
        return DM_Name;
    }

    public void setDM_Name(String DM_Name) {
        this.DM_Name = DM_Name;
    }

    public String getEM_Code() {
        return EM_Code;
    }

    public void setEM_Code(String EM_Code) {
        this.EM_Code = EM_Code;
    }

    public String getEM_Name() {
        return EM_Name;
    }

    public void setEM_Name(String EM_Name) {
        this.EM_Name = EM_Name;
    }

    public int getEM_Sex() {
        return EM_Sex;
    }

    public void setEM_Sex(int EM_Sex) {
        this.EM_Sex = EM_Sex;
    }

    public String getEM_Phone() {
        return EM_Phone;
    }

    public void setEM_Phone(String EM_Phone) {
        this.EM_Phone = EM_Phone;
    }

    public String getEM_Addr() {
        return EM_Addr;
    }

    public void setEM_Addr(String EM_Addr) {
        this.EM_Addr = EM_Addr;
    }

    public String getEM_Remark() {
        return EM_Remark;
    }

    public void setEM_Remark(String EM_Remark) {
        this.EM_Remark = EM_Remark;
    }

    public String getEM_UpdateTime() {
        return EM_UpdateTime;
    }

    public void setEM_UpdateTime(String EM_UpdateTime) {
        this.EM_UpdateTime = EM_UpdateTime;
    }

    public String getEM_Creator() {
        return EM_Creator;
    }

    public void setEM_Creator(String EM_Creator) {
        this.EM_Creator = EM_Creator;
    }

    public String getEM_Birthday() {
        return EM_Birthday;
    }

    public void setEM_Birthday(String EM_Birthday) {
        this.EM_Birthday = EM_Birthday;
    }

    public int getEM_TipCard() {
        return EM_TipCard;
    }

    public void setEM_TipCard(int EM_TipCard) {
        this.EM_TipCard = EM_TipCard;
    }

    public int getEM_TipRecharge() {
        return EM_TipRecharge;
    }

    public void setEM_TipRecharge(int EM_TipRecharge) {
        this.EM_TipRecharge = EM_TipRecharge;
    }

    public int getEM_TipChargeTime() {
        return EM_TipChargeTime;
    }

    public void setEM_TipChargeTime(int EM_TipChargeTime) {
        this.EM_TipChargeTime = EM_TipChargeTime;
    }

    public int getEM_TipGoodsConsume() {
        return EM_TipGoodsConsume;
    }

    public void setEM_TipGoodsConsume(int EM_TipGoodsConsume) {
        this.EM_TipGoodsConsume = EM_TipGoodsConsume;
    }

    public int getEM_TipFastConsume() {
        return EM_TipFastConsume;
    }

    public void setEM_TipFastConsume(int EM_TipFastConsume) {
        this.EM_TipFastConsume = EM_TipFastConsume;
    }

    public int getEM_TipTimesConsume() {
        return EM_TipTimesConsume;
    }

    public void setEM_TipTimesConsume(int EM_TipTimesConsume) {
        this.EM_TipTimesConsume = EM_TipTimesConsume;
    }

    public int getEM_TipComboConsume() {
        return EM_TipComboConsume;
    }

    public void setEM_TipComboConsume(int EM_TipComboConsume) {
        this.EM_TipComboConsume = EM_TipComboConsume;
    }

    public String getStaffProportion() {
        return staffProportion;
    }

    public void setStaffProportion(String staffProportion) {
        this.staffProportion = staffProportion;
    }
}

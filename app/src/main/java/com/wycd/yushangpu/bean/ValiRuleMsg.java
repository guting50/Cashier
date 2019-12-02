package com.wycd.yushangpu.bean;

public class ValiRuleMsg {
    private String GID;//	部门ID	string
    private String CY_GID;//	公司表ID	string
    private String DM_Name;//	部门名称	string
    private String DM_Remark;//	备注	string
    private String DM_UpdateTime;//	创建时间	DateTime?
    private String DM_Creator;//	操作员	string
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

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getDM_Name() {
        return DM_Name;
    }

    public void setDM_Name(String DM_Name) {
        this.DM_Name = DM_Name;
    }

    public String getDM_Remark() {
        return DM_Remark;
    }

    public void setDM_Remark(String DM_Remark) {
        this.DM_Remark = DM_Remark;
    }

    public String getDM_UpdateTime() {
        return DM_UpdateTime;
    }

    public void setDM_UpdateTime(String DM_UpdateTime) {
        this.DM_UpdateTime = DM_UpdateTime;
    }

    public String getDM_Creator() {
        return DM_Creator;
    }

    public void setDM_Creator(String DM_Creator) {
        this.DM_Creator = DM_Creator;
    }
}

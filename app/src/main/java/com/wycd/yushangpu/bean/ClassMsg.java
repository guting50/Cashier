package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassMsg implements Serializable {
    private String SM_ID;//"9fb4ab6f-328c-48ec-817f-27b5a6c0928a",
    private String SM_Name;//"成都总店时尚22",
    private String GID;//"821d030e-a380-4be6-8f16-99a64b978503",
    private String PT_Name;//"二级分类",
    private String PT_Parent;//"0320b169-a0fe-4e65-ae94-84925733ea86",
    private String PT_Remark;//"",
    private String PT_Creator;//"智络成都",
    private String PT_UpdateTime;//"2019-04-15 17:03:47",
    private String PT_SynType;//0
    private boolean isChose;
    private List<ClassMsg> twolist=new ArrayList<>();

    public List<ClassMsg> getTwolist() {
        return twolist;
    }

    public void setTwolist(ClassMsg classMsg) {
        this.twolist.add(classMsg);
    }
    public boolean isChose() {
        return isChose;
    }

    public void setChose(boolean chose) {
        isChose = chose;
    }
    public String getSM_ID() {
        return SM_ID;
    }

    public void setSM_ID(String SM_ID) {
        this.SM_ID = SM_ID;
    }

    public String getSM_Name() {
        return SM_Name;
    }

    public void setSM_Name(String SM_Name) {
        this.SM_Name = SM_Name;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getPT_Name() {
        return PT_Name;
    }

    public void setPT_Name(String PT_Name) {
        this.PT_Name = PT_Name;
    }

    public String getPT_Parent() {
        return PT_Parent;
    }

    public void setPT_Parent(String PT_Parent) {
        this.PT_Parent = PT_Parent;
    }

    public String getPT_Remark() {
        return PT_Remark;
    }

    public void setPT_Remark(String PT_Remark) {
        this.PT_Remark = PT_Remark;
    }

    public String getPT_Creator() {
        return PT_Creator;
    }

    public void setPT_Creator(String PT_Creator) {
        this.PT_Creator = PT_Creator;
    }

    public String getPT_UpdateTime() {
        return PT_UpdateTime;
    }

    public void setPT_UpdateTime(String PT_UpdateTime) {
        this.PT_UpdateTime = PT_UpdateTime;
    }

    public String getPT_SynType() {
        return PT_SynType;
    }

    public void setPT_SynType(String PT_SynType) {
        this.PT_SynType = PT_SynType;
    }
}

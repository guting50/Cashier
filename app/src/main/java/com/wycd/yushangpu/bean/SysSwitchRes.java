package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class SysSwitchRes implements Parcelable {
    private String GID;//	开关设置GID	string
    private String SS_Name;//	开关名称	string
    private int SS_Code;//	开关编码	Int32?
    private int SS_State;//	状态	string  1开启、0关闭
    private String SS_Remark;//	备注	string
    private String SS_Update;//	修改者	string
    private String SS_UpdateTime;//修改时间	DateTime?
    private String CY_GID;//	企业GID	string
    private int SS_Sort;//	排序	Int32?
    private String SS_Value;//	开关对应参数值	string
    private boolean isMoren;

    public boolean isMoren() {
        return isMoren;
    }

    public void setMoren(boolean moren) {
        isMoren = moren;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getSS_Name() {
        return SS_Name;
    }

    public void setSS_Name(String SS_Name) {
        this.SS_Name = SS_Name;
    }

    public int getSS_Code() {
        return SS_Code;
    }

    public void setSS_Code(int SS_Code) {
        this.SS_Code = SS_Code;
    }

    public int getSS_State() {
        return SS_State;
    }

    public void setSS_State(int SS_State) {
        this.SS_State = SS_State;
    }

    public String getSS_Remark() {
        return SS_Remark;
    }

    public void setSS_Remark(String SS_Remark) {
        this.SS_Remark = SS_Remark;
    }

    public String getSS_Update() {
        return SS_Update;
    }

    public void setSS_Update(String SS_Update) {
        this.SS_Update = SS_Update;
    }

    public String getSS_UpdateTime() {
        return SS_UpdateTime;
    }

    public void setSS_UpdateTime(String SS_UpdateTime) {
        this.SS_UpdateTime = SS_UpdateTime;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public int getSS_Sort() {
        return SS_Sort;
    }

    public void setSS_Sort(int SS_Sort) {
        this.SS_Sort = SS_Sort;
    }

    public String getSS_Value() {
        return SS_Value;
    }

    public void setSS_Value(String SS_Value) {
        this.SS_Value = SS_Value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.GID);
        dest.writeString(this.SS_Name);
        dest.writeInt(this.SS_Code);
        dest.writeInt(this.SS_State);
        dest.writeString(this.SS_Remark);
        dest.writeString(this.SS_Update);
        dest.writeString(this.SS_UpdateTime);
        dest.writeString(this.CY_GID);
        dest.writeInt(this.SS_Sort);
        dest.writeString(this.SS_Value);
        dest.writeByte(this.isMoren ? (byte) 1 : (byte) 0);
    }

    public SysSwitchRes() {
    }

    protected SysSwitchRes(Parcel in) {
        this.GID = in.readString();
        this.SS_Name = in.readString();
        this.SS_Code = in.readInt();
        this.SS_State = in.readInt();
        this.SS_Remark = in.readString();
        this.SS_Update = in.readString();
        this.SS_UpdateTime = in.readString();
        this.CY_GID = in.readString();
        this.SS_Sort = in.readInt();
        this.SS_Value = in.readString();
        this.isMoren = in.readByte() != 0;
    }

    public static final Parcelable.Creator<SysSwitchRes> CREATOR = new Parcelable.Creator<SysSwitchRes>() {
        @Override
        public SysSwitchRes createFromParcel(Parcel source) {
            return new SysSwitchRes(source);
        }

        @Override
        public SysSwitchRes[] newArray(int size) {
            return new SysSwitchRes[size];
        }
    };
}

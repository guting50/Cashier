package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by YSL on 2018-06-22.
 * 短信开关bean
 */

public class SmsSwitch implements Serializable, Parcelable {
    /**
     * ST_State : null
     * GID : 1
     * ST_Code : 001
     * ST_Name : 添加会员
     * ST_Content : 尊敬的会员：恭喜您！您于#当前时间#成为本店会员，会员卡号为#卡号#，感谢您的光临！
     * ST_Wildcard : 卡号|姓名|当前时间|到期时间
     * CY_GID : 1
     * ST_CreateTime : 2017-02-27 00:00:00
     */
    /**
     * ST_Code:"001" ST_Name:"添加会员"
     * ST_Code:"002" ST_Name:"会员充值"
     * ST_Code:"003" ST_Name:"会员充次"
     * ST_Code:"004" ST_Name:"会员升级"
     * ST_Code:"005" ST_Name:"会员降级"
     * ST_Code:"006" ST_Name:"积分清零"
     * ST_Code:"007" ST_Name:"积分变动"
     * ST_Code:"008" ST_Name:"修改密码"
     * ST_Code:"009" ST_Name:"会员挂失"
     * ST_Code:"010" ST_Name:"快速消费"
     * ST_Code:"011" ST_Name:"商品消费"
     * ST_Code:"012" ST_Name:"计次消费"
     * ST_Code:"013" ST_Name:"礼品兑换"
     * ST_Code:"014" ST_Name:"生日提醒"
     * ST_Code:"016" ST_Name:"到期提醒"
     * ST_Code:"017" ST_Name:"刷卡登记"
     * ST_Code:"018" ST_Name:"房台消费"
     * ST_Code:"019" ST_Name:"套餐消费"
     * ST_Code:"020" ST_Name:"优惠券发送"
     * ST_Code:"021" ST_Name:"计时消费"
     */
    private String ST_State;
    private String GID;
    private String ST_Code;
    private String ST_Name;
    private String ST_Content;
    private String ST_Wildcard;
    private String CY_GID;
    private String ST_CreateTime;
    private int ST_Sort;
    private int ST_AuditState;
    private String ST_AuditMessage;

    public String getST_State() {
        return ST_State;
    }

    public void setST_State(String ST_State) {
        this.ST_State = ST_State;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getST_Code() {
        return ST_Code;
    }

    public void setST_Code(String ST_Code) {
        this.ST_Code = ST_Code;
    }

    public String getST_Name() {
        return ST_Name;
    }

    public void setST_Name(String ST_Name) {
        this.ST_Name = ST_Name;
    }

    public String getST_Content() {
        return ST_Content;
    }

    public void setST_Content(String ST_Content) {
        this.ST_Content = ST_Content;
    }

    public String getST_Wildcard() {
        return ST_Wildcard;
    }

    public void setST_Wildcard(String ST_Wildcard) {
        this.ST_Wildcard = ST_Wildcard;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getST_CreateTime() {
        return ST_CreateTime;
    }

    public void setST_CreateTime(String ST_CreateTime) {
        this.ST_CreateTime = ST_CreateTime;
    }

    public int getST_Sort() {
        return ST_Sort;
    }

    public void setST_Sort(int ST_Sort) {
        this.ST_Sort = ST_Sort;
    }

    public int getST_AuditState() {
        return ST_AuditState;
    }

    public void setST_AuditState(int ST_AuditState) {
        this.ST_AuditState = ST_AuditState;
    }

    public String getST_AuditMessage() {
        return ST_AuditMessage;
    }

    public void setST_AuditMessage(String ST_AuditMessage) {
        this.ST_AuditMessage = ST_AuditMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ST_State);
        dest.writeString(this.GID);
        dest.writeString(this.ST_Code);
        dest.writeString(this.ST_Name);
        dest.writeString(this.ST_Content);
        dest.writeString(this.ST_Wildcard);
        dest.writeString(this.CY_GID);
        dest.writeString(this.ST_CreateTime);
        dest.writeInt(this.ST_Sort);
        dest.writeInt(this.ST_AuditState);
        dest.writeString(this.ST_AuditMessage);
    }

    public SmsSwitch() {
    }

    protected SmsSwitch(Parcel in) {
        this.ST_State = in.readString();
        this.GID = in.readString();
        this.ST_Code = in.readString();
        this.ST_Name = in.readString();
        this.ST_Content = in.readString();
        this.ST_Wildcard = in.readString();
        this.CY_GID = in.readString();
        this.ST_CreateTime = in.readString();
        this.ST_Sort = in.readInt();
        this.ST_AuditState = in.readInt();
        this.ST_AuditMessage = in.readString();
    }

    public static final Parcelable.Creator<SmsSwitch> CREATOR = new Parcelable.Creator<SmsSwitch>() {
        @Override
        public SmsSwitch createFromParcel(Parcel source) {
            return new SmsSwitch(source);
        }

        @Override
        public SmsSwitch[] newArray(int size) {
            return new SmsSwitch[size];
        }
    };
}

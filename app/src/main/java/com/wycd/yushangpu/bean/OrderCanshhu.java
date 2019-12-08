package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderCanshhu implements Parcelable {
    private String GID;
    private String CO_Type;
    private String CO_OrderCode;

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getCO_Type() {
        return CO_Type;
    }

    public void setCO_Type(String CO_Type) {
        this.CO_Type = CO_Type;
    }

    public String getCO_OrderCode() {
        return CO_OrderCode;
    }

    public void setCO_OrderCode(String CO_OrderCode) {
        this.CO_OrderCode = CO_OrderCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.GID);
        dest.writeString(this.CO_Type);
        dest.writeString(this.CO_OrderCode);
    }

    public OrderCanshhu() {
    }

    protected OrderCanshhu(Parcel in) {
        this.GID = in.readString();
        this.CO_Type = in.readString();
        this.CO_OrderCode = in.readString();
    }

    public static final Parcelable.Creator<OrderCanshhu> CREATOR = new Parcelable.Creator<OrderCanshhu>() {
        @Override
        public OrderCanshhu createFromParcel(Parcel source) {
            return new OrderCanshhu(source);
        }

        @Override
        public OrderCanshhu[] newArray(int size) {
            return new OrderCanshhu[size];
        }
    };
}

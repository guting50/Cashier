package com.wycd.yushangpu.bean;

import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.io.Serializable;
import java.util.List;

public class ShopMsg implements Serializable, Parcelable {

    private String PM_GroupGID;//	商品组GID
    private String GroupCount;//	组商品数
    private String GID;//	商品GID	string
    private String PT_ID;//	分类ID	string
    private String SM_ID;//	所属店铺	string
    private String PT_Name;//	分类名	string
    private String PM_Code;//	商品编码	string
    private String PM_Name;//	商品名	string
    private String PM_SimpleCode;//	商品简码	string
    private String PM_Metering;//	计量单位	string
    private double PM_UnitPrice;//	商品单价	float?
    private String PM_BigImg;//	商品大图地址	string
    private String PM_SmallImg;//	商品小图地址	string
    private String PM_Description;//	商品说明	string
    private String PM_Modle;//	规格型号	string
    private String PM_Brand;//	品牌	string
    private double PM_Repertory;//	商品库存	decimal
    private double Stock_Number;//	库存值	decimal
    private double currtStock_Number;//	显示库存值	decimal
    private double PM_PurchasePrice;//	参考进价	decimal
    private String PM_MemPrice;//	会员价格	decimal?
    private int PM_IsDiscount;//	商品折扣	int
    private int PM_IsPoint;//	商品积分	int
    private int PM_IsService;//	商品类型	int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
    private String SP_GID;//	库存GID	string
    private double PM_SpecialOfferMoney; //特价金额值
    private double PM_SpecialOfferValue;//	特价折扣开关的值	decimal
    private double PM_MinDisCountValue;//	最低折扣开关的值	decimal
    private double PM_FixedIntegralValue;//	固定积分开关的值	decimal
    private List<String> EM_GIDList;//	提成员工	List<string>
    private String EM_NameList;//	提成员工	List<string>
    private double num;
    private int chosePosion;
    private double allprice;//折后总价
    private double totalPrice;//原价总价
    private double PD_Discount; //会员等级折扣
    private double jisuanPrice;//折后单价
    private double EachPoint;//每个商品积分
    private boolean isCheck;//是否选中
    private boolean hasvipDiscount; //是否会员折扣
    private boolean isgive;//是否赠送
    private int Type;
    private boolean ischanged;//是否手动修改

    public boolean isIschanged() {
        return ischanged;
    }

    public void setIschanged(boolean ischanged) {
        this.ischanged = ischanged;
    }

    public double getEachPoint() {
        return EachPoint;
    }

    public void setEachPoint(double eachPoint) {
        EachPoint = eachPoint;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public boolean isIsgive() {
        return isgive;
    }

    public void setIsgive(boolean isgive) {
        this.isgive = isgive;
    }


    public boolean isHasvipDiscount() {
        return hasvipDiscount;
    }

    public void setHasvipDiscount(boolean hasvipDiscount) {
        this.hasvipDiscount = hasvipDiscount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public List<String> getEM_GIDList() {
        return EM_GIDList;
    }

    public void setEM_GIDList(List<String> EM_GIDList) {
        this.EM_GIDList = EM_GIDList;
    }

    public String getEM_NameList() {
        return EM_NameList;
    }

    public void setEM_NameList(String EM_NameList) {
        this.EM_NameList = EM_NameList;
    }

    public double getJisuanPrice() {
        return jisuanPrice;
    }

    public void setJisuanPrice(double jisuanPrice) {
        this.jisuanPrice = jisuanPrice;
    }

    public double getPD_Discount() {
        return PD_Discount;
    }

    public void setPD_Discount(double PD_Discount) {
        this.PD_Discount = PD_Discount;
    }

    public double getPM_SpecialOfferMoney() {
        return PM_SpecialOfferMoney;
    }

    public void setPM_SpecialOfferMoney(double PM_SpecialOfferMoney) {
        this.PM_SpecialOfferMoney = PM_SpecialOfferMoney;
    }

    public double getPM_SpecialOfferValue() {
        return PM_SpecialOfferValue;
    }

    public void setPM_SpecialOfferValue(double PM_SpecialOfferValue) {
        this.PM_SpecialOfferValue = PM_SpecialOfferValue;
    }

    public double getPM_MinDisCountValue() {
        return PM_MinDisCountValue;
    }

    public void setPM_MinDisCountValue(double PM_MinDisCountValue) {
        this.PM_MinDisCountValue = PM_MinDisCountValue;
    }

    public double getPM_FixedIntegralValue() {
        return PM_FixedIntegralValue;
    }

    public void setPM_FixedIntegralValue(double PM_FixedIntegralValue) {
        this.PM_FixedIntegralValue = PM_FixedIntegralValue;
    }

    public double getAllprice() {
        return allprice;
    }

    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }

    public int getChosePosion() {
        return chosePosion;
    }

    public void setChosePosion(int chosePosion) {
        this.chosePosion = chosePosion;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getPM_GroupGID() {
        return PM_GroupGID;
    }

    public void setPM_GroupGID(String PM_GroupGID) {
        this.PM_GroupGID = PM_GroupGID;
    }

    public String getGroupCount() {
        return GroupCount;
    }

    public void setGroupCount(String groupCount) {
        GroupCount = groupCount;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getPT_ID() {
        return PT_ID;
    }

    public void setPT_ID(String PT_ID) {
        this.PT_ID = PT_ID;
    }

    public String getSM_ID() {
        return SM_ID;
    }

    public void setSM_ID(String SM_ID) {
        this.SM_ID = SM_ID;
    }

    public String getPT_Name() {
        return PT_Name;
    }

    public void setPT_Name(String PT_Name) {
        this.PT_Name = PT_Name;
    }

    public String getPM_Code() {
        return PM_Code;
    }

    public void setPM_Code(String PM_Code) {
        this.PM_Code = PM_Code;
    }

    public String getPM_Name() {
        return PM_Name;
    }

    public void setPM_Name(String PM_Name) {
        this.PM_Name = PM_Name;
    }

    public String getPM_SimpleCode() {
        return PM_SimpleCode;
    }

    public void setPM_SimpleCode(String PM_SimpleCode) {
        this.PM_SimpleCode = PM_SimpleCode;
    }

    public String getPM_Metering() {
        return PM_Metering;
    }

    public void setPM_Metering(String PM_Metering) {
        this.PM_Metering = PM_Metering;
    }

    public double getPM_UnitPrice() {
        return PM_UnitPrice;
    }

    public void setPM_UnitPrice(double PM_UnitPrice) {
        this.PM_UnitPrice = PM_UnitPrice;
    }

    public String getPM_BigImg() {
        return PM_BigImg;
    }

    public void setPM_BigImg(String PM_BigImg) {
        this.PM_BigImg = PM_BigImg;
    }

    public String getPM_SmallImg() {
        return PM_SmallImg;
    }

    public void setPM_SmallImg(String PM_SmallImg) {
        this.PM_SmallImg = PM_SmallImg;
    }

    public String getPM_Description() {
        return PM_Description;
    }

    public void setPM_Description(String PM_Description) {
        this.PM_Description = PM_Description;
    }

    public String getPM_Modle() {
        return PM_Modle;
    }

    public void setPM_Modle(String PM_Modle) {
        this.PM_Modle = PM_Modle;
    }

    public String getPM_Brand() {
        return PM_Brand;
    }

    public void setPM_Brand(String PM_Brand) {
        this.PM_Brand = PM_Brand;
    }

    public double getPM_Repertory() {
        return PM_Repertory;
    }

    public void setPM_Repertory(double PM_Repertory) {
        this.PM_Repertory = PM_Repertory;
    }

    public double getStock_Number() {
        return Stock_Number;
    }

    public void setStock_Number(double stock_Number) {
        Stock_Number = stock_Number;
    }

    public double getCurrtStock_Number() {
        return currtStock_Number;
    }

    public void setCurrtStock_Number(double currtStock_Number) {
        this.currtStock_Number = currtStock_Number;
    }


    public double getPM_PurchasePrice() {
        return PM_PurchasePrice;
    }

    public void setPM_PurchasePrice(double PM_PurchasePrice) {
        this.PM_PurchasePrice = PM_PurchasePrice;
    }

    public String getPM_MemPrice() {
        return PM_MemPrice;
    }

    public void setPM_MemPrice(String PM_MemPrice) {
        this.PM_MemPrice = PM_MemPrice;
    }

    public int getPM_IsDiscount() {
        return PM_IsDiscount;
    }

    public void setPM_IsDiscount(int PM_IsDiscount) {
        this.PM_IsDiscount = PM_IsDiscount;
    }

    public int getPM_IsPoint() {
        return PM_IsPoint;
    }

    public void setPM_IsPoint(int PM_IsPoint) {
        this.PM_IsPoint = PM_IsPoint;
    }

    public int getPM_IsService() {
        return PM_IsService;
    }

    public void setPM_IsService(int PM_IsService) {
        this.PM_IsService = PM_IsService;
    }

    public String getSP_GID() {
        return SP_GID;
    }

    public void setSP_GID(String SP_GID) {
        this.SP_GID = SP_GID;
    }

    public ShopMsg() {
    }

    public String PM_IsServiceText;
    public int StateTextColor;
    public int KuVisibility;
    public String TvVippriceText;
    public int TvSanpriceFlags, TvSanpriceTextColor;
    private boolean initialized = false;

    public void init() {
        if (initialized) {
            return;
        }
        initialized = true;
        switch (NullUtils.noNullHandle(getPM_IsService()).toString()) {
            case "0":
                PM_IsServiceText = "普";
                StateTextColor = R.color.textblue;
                KuVisibility = View.VISIBLE;
                break;
            case "1":
                PM_IsServiceText = "服";
                StateTextColor = R.color.textgreen;
                KuVisibility = View.INVISIBLE;
                break;
            case "2":
                PM_IsServiceText = "礼";
                StateTextColor = R.color.textred;
                KuVisibility = View.VISIBLE;
                break;
            case "3":
                PM_IsServiceText = "套";
                StateTextColor = R.color.textblue;
                KuVisibility = View.INVISIBLE;
                break;
            case "4":
                PM_IsServiceText = "套";
                StateTextColor = R.color.textgreen;
                KuVisibility = View.INVISIBLE;
                break;
        }

        if (NullUtils.noNullHandle(getPM_IsDiscount()).toString().equals("1")) {
            if (!NullUtils.noNullHandle(getPM_SpecialOfferMoney()).toString().equals("0.0") && getPM_SpecialOfferMoney() != -1) {
                //无最低折扣
                TvVippriceText = "特：" + getPM_SpecialOfferMoney();
                TvSanpriceFlags = (Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
                TvSanpriceTextColor = (R.color.a5a5a5);
            } else if (!NullUtils.noNullHandle(getPM_SpecialOfferValue()).toString().equals("0.0")) {
                //有特价折扣
                if (NullUtils.noNullHandle(getPM_MinDisCountValue()).toString().equals("0.0")) {
                    //无最低折扣
                    TvVippriceText = ("特：" + StringUtil.twoNum(CommonUtils.multiply(getPM_UnitPrice(), getPM_SpecialOfferValue())));
                } else {
                    //有最低折扣
                    if (getPM_SpecialOfferValue() > getPM_MinDisCountValue()) {
                        TvVippriceText = ("特：" + StringUtil.twoNum(CommonUtils.multiply(getPM_UnitPrice(), getPM_SpecialOfferValue())));
                    } else {
                        TvVippriceText = ("特：" + StringUtil.twoNum(CommonUtils.multiply(getPM_UnitPrice(), getPM_MinDisCountValue())));
                    }
                }
                TvSanpriceTextColor = (R.color.a5a5a5);
                TvSanpriceFlags = (Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
            } else {
                //无特价折扣
                if (!NullUtils.noNullHandle(getPM_MemPrice()).toString().equals("")) {
                    //有会员价
                    TvVippriceText = ("会：" + StringUtil.twoNum(NullUtils.noNullHandle(getPM_MemPrice()).toString()));
                } else {
                    TvVippriceText = ("");
                }
                TvSanpriceFlags = (0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
//                TvSanpriceTextColor = (R.color.textred);
                TvSanpriceTextColor = (R.color.text66);
            }
        } else {
            if (!NullUtils.noNullHandle(getPM_MemPrice()).toString().equals("")) {
                TvVippriceText = ("会：" + StringUtil.twoNum(NullUtils.noNullHandle(getPM_MemPrice()).toString()));
            } else {
                TvVippriceText = ("");
            }
            TvSanpriceFlags = (0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
//            TvSanpriceTextColor = (R.color.textred);
            TvSanpriceTextColor = (R.color.text66);
        }
    }

    @Override
    public String toString() {
        return "ShopMsg{" +
                "PM_GroupGID='" + PM_GroupGID + '\'' +
                ", GroupCount='" + GroupCount + '\'' +
                ", GID='" + GID + '\'' +
                ", PT_ID='" + PT_ID + '\'' +
                ", SM_ID='" + SM_ID + '\'' +
                ", PT_Name='" + PT_Name + '\'' +
                ", PM_Code='" + PM_Code + '\'' +
                ", PM_Name='" + PM_Name + '\'' +
                ", PM_SimpleCode='" + PM_SimpleCode + '\'' +
                ", PM_Metering='" + PM_Metering + '\'' +
                ", PM_UnitPrice=" + PM_UnitPrice +
                ", PM_BigImg='" + PM_BigImg + '\'' +
                ", PM_SmallImg='" + PM_SmallImg + '\'' +
                ", PM_Description='" + PM_Description + '\'' +
                ", PM_Modle='" + PM_Modle + '\'' +
                ", PM_Brand='" + PM_Brand + '\'' +
                ", PM_Repertory=" + PM_Repertory +
                ", Stock_Number=" + Stock_Number +
                ", currtStock_Number=" + currtStock_Number +
                ", PM_PurchasePrice=" + PM_PurchasePrice +
                ", PM_MemPrice='" + PM_MemPrice + '\'' +
                ", PM_IsDiscount=" + PM_IsDiscount +
                ", PM_IsPoint=" + PM_IsPoint +
                ", PM_IsService=" + PM_IsService +
                ", SP_GID='" + SP_GID + '\'' +
                ", PM_SpecialOfferMoney=" + PM_SpecialOfferMoney +
                ", PM_SpecialOfferValue=" + PM_SpecialOfferValue +
                ", PM_MinDisCountValue=" + PM_MinDisCountValue +
                ", PM_FixedIntegralValue=" + PM_FixedIntegralValue +
                ", EM_GIDList=" + EM_GIDList +
                ", EM_NameList='" + EM_NameList + '\'' +
                ", num=" + num +
                ", chosePosion=" + chosePosion +
                ", allprice=" + allprice +
                ", totalPrice=" + totalPrice +
                ", PD_Discount=" + PD_Discount +
                ", jisuanPrice=" + jisuanPrice +
                ", EachPoint=" + EachPoint +
                ", isCheck=" + isCheck +
                ", hasvipDiscount=" + hasvipDiscount +
                ", isgive=" + isgive +
                ", Type=" + Type +
                ", ischanged=" + ischanged +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.PM_GroupGID);
        dest.writeString(this.GroupCount);
        dest.writeString(this.GID);
        dest.writeString(this.PT_ID);
        dest.writeString(this.SM_ID);
        dest.writeString(this.PT_Name);
        dest.writeString(this.PM_Code);
        dest.writeString(this.PM_Name);
        dest.writeString(this.PM_SimpleCode);
        dest.writeString(this.PM_Metering);
        dest.writeDouble(this.PM_UnitPrice);
        dest.writeString(this.PM_BigImg);
        dest.writeString(this.PM_SmallImg);
        dest.writeString(this.PM_Description);
        dest.writeString(this.PM_Modle);
        dest.writeString(this.PM_Brand);
        dest.writeDouble(this.PM_Repertory);
        dest.writeDouble(this.Stock_Number);
        dest.writeDouble(this.currtStock_Number);
        dest.writeDouble(this.PM_PurchasePrice);
        dest.writeString(this.PM_MemPrice);
        dest.writeInt(this.PM_IsDiscount);
        dest.writeInt(this.PM_IsPoint);
        dest.writeInt(this.PM_IsService);
        dest.writeString(this.SP_GID);
        dest.writeDouble(this.PM_SpecialOfferMoney);
        dest.writeDouble(this.PM_SpecialOfferValue);
        dest.writeDouble(this.PM_MinDisCountValue);
        dest.writeDouble(this.PM_FixedIntegralValue);
        dest.writeStringList(this.EM_GIDList);
        dest.writeString(this.EM_NameList);
        dest.writeDouble(this.num);
        dest.writeInt(this.chosePosion);
        dest.writeDouble(this.allprice);
        dest.writeDouble(this.totalPrice);
        dest.writeDouble(this.PD_Discount);
        dest.writeDouble(this.jisuanPrice);
        dest.writeDouble(this.EachPoint);
        dest.writeByte(this.isCheck ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasvipDiscount ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isgive ? (byte) 1 : (byte) 0);
        dest.writeInt(this.Type);
        dest.writeByte(this.ischanged ? (byte) 1 : (byte) 0);
    }

    protected ShopMsg(Parcel in) {
        this.PM_GroupGID = in.readString();
        this.GroupCount = in.readString();
        this.GID = in.readString();
        this.PT_ID = in.readString();
        this.SM_ID = in.readString();
        this.PT_Name = in.readString();
        this.PM_Code = in.readString();
        this.PM_Name = in.readString();
        this.PM_SimpleCode = in.readString();
        this.PM_Metering = in.readString();
        this.PM_UnitPrice = in.readDouble();
        this.PM_BigImg = in.readString();
        this.PM_SmallImg = in.readString();
        this.PM_Description = in.readString();
        this.PM_Modle = in.readString();
        this.PM_Brand = in.readString();
        this.PM_Repertory = in.readDouble();
        this.Stock_Number = in.readDouble();
        this.currtStock_Number = in.readDouble();
        this.PM_PurchasePrice = in.readDouble();
        this.PM_MemPrice = in.readString();
        this.PM_IsDiscount = in.readInt();
        this.PM_IsPoint = in.readInt();
        this.PM_IsService = in.readInt();
        this.SP_GID = in.readString();
        this.PM_SpecialOfferMoney = in.readDouble();
        this.PM_SpecialOfferValue = in.readDouble();
        this.PM_MinDisCountValue = in.readDouble();
        this.PM_FixedIntegralValue = in.readDouble();
        this.EM_GIDList = in.createStringArrayList();
        this.EM_NameList = in.readString();
        this.num = in.readDouble();
        this.chosePosion = in.readInt();
        this.allprice = in.readDouble();
        this.totalPrice = in.readDouble();
        this.PD_Discount = in.readDouble();
        this.jisuanPrice = in.readDouble();
        this.EachPoint = in.readDouble();
        this.isCheck = in.readByte() != 0;
        this.hasvipDiscount = in.readByte() != 0;
        this.isgive = in.readByte() != 0;
        this.Type = in.readInt();
        this.ischanged = in.readByte() != 0;
    }

    public static final Creator<ShopMsg> CREATOR = new Creator<ShopMsg>() {
        @Override
        public ShopMsg createFromParcel(Parcel source) {
            return new ShopMsg(source);
        }

        @Override
        public ShopMsg[] newArray(int size) {
            return new ShopMsg[size];
        }
    };
}

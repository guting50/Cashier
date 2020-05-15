package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderCanshu implements Parcelable {

    private List<ViewGoodsDetailBean> ViewGoodsDetail;//	商品信息 	IList	返回订单详情
    private String CC_GID;//		活动GID	string
    private List<String> EM_GIDList;//		提成员工	List<string>
    private String PayPoint;//		抵扣积分	decimal
    private String DisMoney;//		折后金额/应收金额	decimal
    private String VCH_Money;//		卡内余额	decimal	打印用
    private String VCH_Point;//		卡内积分	decimal	打印用
    private String CO_SSMoney;//	实收金额	decimal
    private String CO_ZLMoney;//		找零金额	decimal
    private String CO_ActivityName;//		活动名称	string
    private String CO_ActivityValue;//		优惠信息	string	例如：抵扣50元
    private String CO_Discount;//		快速消费折扣	decimal?
    private String GID;//		消费订单GID	string
    private String VIP_GID;//		会员GID	string
    private String VIP_Card;//		会员卡号	string
    private String VIP_Name;//	会员姓名	string
    private String VIP_Phone;//		会员手机	string
    private String VIP_FaceNumber;//		卡面号码	string
    private String CO_OrderCode;//		订单编号	string
    private String CO_ConsumeWay;//		消费方式	string
    private String CO_Monetary;//		消费金额	decimal?
    private String CO_TotalPrice;//		折后总价	decimal?
    private String CO_Integral;//		订单积分	decimal?	获得积分
    private String CO_Type;//		消费类型	string
    private String CO_Creator;//		创建者	string
    private String CO_UpdateTime;//		创建时间	DateTime?
    private String CY_GID;//		企业GID	string
    private String SM_Name;//		店铺名称	string
    private String SM_Contacter;//		联系人	string
    private String CO_Identifying; //订单状态名
    private String CO_IdentifyingState; //订单状态码 1 挂单  8挂账

    public String getCO_Identifying() {
        return CO_Identifying;
    }

    public void setCO_Identifying(String CO_Identifying) {
        this.CO_Identifying = CO_Identifying;
    }

    public String getCO_IdentifyingState() {
        return CO_IdentifyingState;
    }

    public void setCO_IdentifyingState(String CO_IdentifyingState) {
        this.CO_IdentifyingState = CO_IdentifyingState;
    }

    public List<ViewGoodsDetailBean> getViewGoodsDetail() {
        return ViewGoodsDetail;
    }

    public void setViewGoodsDetail(List<ViewGoodsDetailBean> viewGoodsDetail) {
        ViewGoodsDetail = viewGoodsDetail;
    }

    public String getCC_GID() {
        return CC_GID;
    }

    public void setCC_GID(String CC_GID) {
        this.CC_GID = CC_GID;
    }

    public List<String> getEM_GIDList() {
        return EM_GIDList;
    }

    public void setEM_GIDList(List<String> EM_GIDList) {
        this.EM_GIDList = EM_GIDList;
    }

    public String getPayPoint() {
        return PayPoint;
    }

    public void setPayPoint(String payPoint) {
        PayPoint = payPoint;
    }

    public String getDisMoney() {
        return DisMoney;
    }

    public void setDisMoney(String disMoney) {
        DisMoney = disMoney;
    }

    public String getVCH_Money() {
        return VCH_Money;
    }

    public void setVCH_Money(String VCH_Money) {
        this.VCH_Money = VCH_Money;
    }

    public String getVCH_Point() {
        return VCH_Point;
    }

    public void setVCH_Point(String VCH_Point) {
        this.VCH_Point = VCH_Point;
    }

    public String getCO_SSMoney() {
        return CO_SSMoney;
    }

    public void setCO_SSMoney(String CO_SSMoney) {
        this.CO_SSMoney = CO_SSMoney;
    }

    public String getCO_ZLMoney() {
        return CO_ZLMoney;
    }

    public void setCO_ZLMoney(String CO_ZLMoney) {
        this.CO_ZLMoney = CO_ZLMoney;
    }

    public String getCO_ActivityName() {
        return CO_ActivityName;
    }

    public void setCO_ActivityName(String CO_ActivityName) {
        this.CO_ActivityName = CO_ActivityName;
    }

    public String getCO_ActivityValue() {
        return CO_ActivityValue;
    }

    public void setCO_ActivityValue(String CO_ActivityValue) {
        this.CO_ActivityValue = CO_ActivityValue;
    }

    public String getCO_Discount() {
        return CO_Discount;
    }

    public void setCO_Discount(String CO_Discount) {
        this.CO_Discount = CO_Discount;
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

    public String getVIP_Card() {
        return VIP_Card;
    }

    public void setVIP_Card(String VIP_Card) {
        this.VIP_Card = VIP_Card;
    }

    public String getVIP_Name() {
        return VIP_Name;
    }

    public void setVIP_Name(String VIP_Name) {
        this.VIP_Name = VIP_Name;
    }

    public String getVIP_Phone() {
        return VIP_Phone;
    }

    public void setVIP_Phone(String VIP_Phone) {
        this.VIP_Phone = VIP_Phone;
    }

    public String getVIP_FaceNumber() {
        return VIP_FaceNumber;
    }

    public void setVIP_FaceNumber(String VIP_FaceNumber) {
        this.VIP_FaceNumber = VIP_FaceNumber;
    }

    public String getCO_OrderCode() {
        return CO_OrderCode;
    }

    public void setCO_OrderCode(String CO_OrderCode) {
        this.CO_OrderCode = CO_OrderCode;
    }

    public String getCO_ConsumeWay() {
        return CO_ConsumeWay;
    }

    public void setCO_ConsumeWay(String CO_ConsumeWay) {
        this.CO_ConsumeWay = CO_ConsumeWay;
    }

    public String getCO_Monetary() {
        return CO_Monetary;
    }

    public void setCO_Monetary(String CO_Monetary) {
        this.CO_Monetary = CO_Monetary;
    }

    public String getCO_TotalPrice() {
        return CO_TotalPrice;
    }

    public void setCO_TotalPrice(String CO_TotalPrice) {
        this.CO_TotalPrice = CO_TotalPrice;
    }

    public String getCO_Integral() {
        return CO_Integral;
    }

    public void setCO_Integral(String CO_Integral) {
        this.CO_Integral = CO_Integral;
    }

    public String getCO_Type() {
        return CO_Type;
    }

    public void setCO_Type(String CO_Type) {
        this.CO_Type = CO_Type;
    }

    public String getCO_Creator() {
        return CO_Creator;
    }

    public void setCO_Creator(String CO_Creator) {
        this.CO_Creator = CO_Creator;
    }

    public String getCO_UpdateTime() {
        return CO_UpdateTime;
    }

    public void setCO_UpdateTime(String CO_UpdateTime) {
        this.CO_UpdateTime = CO_UpdateTime;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getSM_Name() {
        return SM_Name;
    }

    public void setSM_Name(String SM_Name) {
        this.SM_Name = SM_Name;
    }

    public String getSM_Contacter() {
        return SM_Contacter;
    }

    public void setSM_Contacter(String SM_Contacter) {
        this.SM_Contacter = SM_Contacter;
    }

    public static class ViewGoodsDetailBean implements Serializable {

        private String GID;//
        private String CO_GID;//
        private String PM_GID;//
        private int PM_IsService;//商品类型

        private String PM_Code;//商品编码
        private String PM_Name;//商品名
        private String PM_BigImg;//商品图片地址
        private String PM_Modle;//规格
        private String PM_Metering;//
        private String PT_Name;//分类名
        private String PT_GID;//分类gid
        private double PM_UnitPrice;//单价
        private double PM_Number;//数量
        private double SumPrice;//总价
        private double DiscountPrice;//折扣价
        private double PM_Discount;//商品折扣
        private double GOD_Integral;//获得积分
        private String State;//状态
        private String GOD_EMName;//
        private String GOD_EMGID;//
        private String WR_Name;//
        private String GOD_ExpireDate;//
        private int GOD_Type;//

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getCO_GID() {
            return CO_GID;
        }

        public void setCO_GID(String CO_GID) {
            this.CO_GID = CO_GID;
        }

        public String getPM_GID() {
            return PM_GID;
        }

        public void setPM_GID(String PM_GID) {
            this.PM_GID = PM_GID;
        }

        public int getPM_IsService() {
            return PM_IsService;
        }

        public void setPM_IsService(int PM_IsService) {
            this.PM_IsService = PM_IsService;
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

        public String getPM_BigImg() {
            return PM_BigImg;
        }

        public void setPM_BigImg(String PM_BigImg) {
            this.PM_BigImg = PM_BigImg;
        }

        public String getPM_Modle() {
            return PM_Modle;
        }

        public void setPM_Modle(String PM_Modle) {
            this.PM_Modle = PM_Modle;
        }

        public String getPM_Metering() {
            return PM_Metering;
        }

        public void setPM_Metering(String PM_Metering) {
            this.PM_Metering = PM_Metering;
        }

        public String getPT_Name() {
            return PT_Name;
        }

        public void setPT_Name(String PT_Name) {
            this.PT_Name = PT_Name;
        }

        public String getPT_GID() {
            return PT_GID;
        }

        public void setPT_GID(String PT_GID) {
            this.PT_GID = PT_GID;
        }

        public double getPM_UnitPrice() {
            return PM_UnitPrice;
        }

        public void setPM_UnitPrice(double PM_UnitPrice) {
            this.PM_UnitPrice = PM_UnitPrice;
        }

        public double getPM_Number() {
            return PM_Number;
        }

        public void setPM_Number(double PM_Number) {
            this.PM_Number = PM_Number;
        }

        public double getSumPrice() {
            return SumPrice;
        }

        public void setSumPrice(double sumPrice) {
            SumPrice = sumPrice;
        }

        public double getDiscountPrice() {
            return DiscountPrice;
        }

        public void setDiscountPrice(double discountPrice) {
            DiscountPrice = discountPrice;
        }

        public double getPM_Discount() {
            return PM_Discount;
        }

        public void setPM_Discount(double PM_Discount) {
            this.PM_Discount = PM_Discount;
        }

        public double getGOD_Integral() {
            return GOD_Integral;
        }

        public void setGOD_Integral(double GOD_Integral) {
            this.GOD_Integral = GOD_Integral;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public String getGOD_EMName() {
            return GOD_EMName;
        }

        public void setGOD_EMName(String GOD_EMName) {
            this.GOD_EMName = GOD_EMName;
        }

        public String getGOD_EMGID() {
            return GOD_EMGID;
        }

        public void setGOD_EMGID(String GOD_EMGID) {
            this.GOD_EMGID = GOD_EMGID;
        }

        public String getWR_Name() {
            return WR_Name;
        }

        public void setWR_Name(String WR_Name) {
            this.WR_Name = WR_Name;
        }

        public String getGOD_ExpireDate() {
            return GOD_ExpireDate;
        }

        public void setGOD_ExpireDate(String GOD_ExpireDate) {
            this.GOD_ExpireDate = GOD_ExpireDate;
        }

        public int getGOD_Type() {
            return GOD_Type;
        }

        public void setGOD_Type(int GOD_Type) {
            this.GOD_Type = GOD_Type;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.ViewGoodsDetail);
        dest.writeString(this.CC_GID);
        dest.writeStringList(this.EM_GIDList);
        dest.writeString(this.PayPoint);
        dest.writeString(this.DisMoney);
        dest.writeString(this.VCH_Money);
        dest.writeString(this.VCH_Point);
        dest.writeString(this.CO_SSMoney);
        dest.writeString(this.CO_ZLMoney);
        dest.writeString(this.CO_ActivityName);
        dest.writeString(this.CO_ActivityValue);
        dest.writeString(this.CO_Discount);
        dest.writeString(this.GID);
        dest.writeString(this.VIP_GID);
        dest.writeString(this.VIP_Card);
        dest.writeString(this.VIP_Name);
        dest.writeString(this.VIP_Phone);
        dest.writeString(this.VIP_FaceNumber);
        dest.writeString(this.CO_OrderCode);
        dest.writeString(this.CO_ConsumeWay);
        dest.writeString(this.CO_Monetary);
        dest.writeString(this.CO_TotalPrice);
        dest.writeString(this.CO_Integral);
        dest.writeString(this.CO_Type);
        dest.writeString(this.CO_Creator);
        dest.writeString(this.CO_UpdateTime);
        dest.writeString(this.CY_GID);
        dest.writeString(this.SM_Name);
        dest.writeString(this.SM_Contacter);
        dest.writeString(this.CO_Identifying);
        dest.writeString(this.CO_IdentifyingState);
    }

    public OrderCanshu() {
    }

    protected OrderCanshu(Parcel in) {
        this.ViewGoodsDetail = new ArrayList<ViewGoodsDetailBean>();
        in.readList(this.ViewGoodsDetail, ViewGoodsDetailBean.class.getClassLoader());
        this.CC_GID = in.readString();
        this.EM_GIDList = in.createStringArrayList();
        this.PayPoint = in.readString();
        this.DisMoney = in.readString();
        this.VCH_Money = in.readString();
        this.VCH_Point = in.readString();
        this.CO_SSMoney = in.readString();
        this.CO_ZLMoney = in.readString();
        this.CO_ActivityName = in.readString();
        this.CO_ActivityValue = in.readString();
        this.CO_Discount = in.readString();
        this.GID = in.readString();
        this.VIP_GID = in.readString();
        this.VIP_Card = in.readString();
        this.VIP_Name = in.readString();
        this.VIP_Phone = in.readString();
        this.VIP_FaceNumber = in.readString();
        this.CO_OrderCode = in.readString();
        this.CO_ConsumeWay = in.readString();
        this.CO_Monetary = in.readString();
        this.CO_TotalPrice = in.readString();
        this.CO_Integral = in.readString();
        this.CO_Type = in.readString();
        this.CO_Creator = in.readString();
        this.CO_UpdateTime = in.readString();
        this.CY_GID = in.readString();
        this.SM_Name = in.readString();
        this.SM_Contacter = in.readString();
        this.CO_Identifying = in.readString();
        this.CO_IdentifyingState = in.readString();
    }

    public static final Creator<OrderCanshu> CREATOR = new Creator<OrderCanshu>() {
        @Override
        public OrderCanshu createFromParcel(Parcel source) {
            return new OrderCanshu(source);
        }

        @Override
        public OrderCanshu[] newArray(int size) {
            return new OrderCanshu[size];
        }
    };
}

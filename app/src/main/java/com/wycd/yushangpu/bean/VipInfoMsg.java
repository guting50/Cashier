package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class VipInfoMsg implements Serializable {
    private String GID;//	会员GID	string
    private String VIP_HeadImg;//	头像地址	string
    private String VCH_Card;//	会员卡号	string
    private String VIP_Name;//	会员姓名	string
    private int VIP_Sex;//	会员性别	Int32
    private String VCH_CreateTime;//	开卡时间	DateTime
    private String VIP_Birthday;//	生日	string
    private String VIP_CellPhone;//	手机号	string
    private String VIP_ICCard;//	身份证号	string
    private String VIP_Email;//	电子邮箱	string
    private String VIP_Remark;//	备注	string
    private int VIP_IsForver;//	是否永久有效	Int32
    private String VIP_Overdue;//	过期时间	DateTime?
    private int VIP_State;//	会员状态	0正常1锁定2挂失
    private String VIP_FaceNumber;//	卡面号码	string
    private String VIP_Label;//	会员标签	string
    private String VG_GID;//	等级GID	string
    private String VIP_Referee;//	推荐人卡号	string
    private String VIP_Addr;//	会员地址	string
    private String VIP_FixedPhone;//	固定电话	string
    private String VG_Name;//	等级名称	string
    private double MA_AvailableBalance;//	可用余额	decimal
    private double MA_AvailableIntegral;//	可用积分	decimal
    private int MCA_HowMany;//	剩余充次总数	int
    private int VCH_Fee; //开卡费
    private Object SM_GID;//开卡店铺
    private String SM_Name;
    private String EM_Name; //办卡人员

    private Object VIP_RegSource;
    private int VIP_IsLunarCalendar;
    private Object EM_ID;
    private String VIP_Creator;
    private String VIP_OpenID;
    private int VIP_InterCalaryMonth;
    private Object MCA_HowManyDetail;
    private Object CY_GID;
    private String VIP_UpdateTime;
    private int VG_IsAccount;
    private int VG_IsIntegral;
    private int VG_IsDiscount;
    private int VG_IsCount;
    private int VG_IsTime;
    private double DS_Value;
    private double VS_Value;
    private double RS_Value;
    private Object MberChargeList;
    private Object CustomeFieldList;
    private int VIP_IsDeleted;
    private double MA_AggregateAmount;
    private double MA_AggregateStoredValue;
    private int MCA_TotalCharge;
    private String MA_UpdateTime;
    private double MA_AggregateIntegral;
    private Object MessageVIP;
    private Object MIA_SurplusTimes;
    private Object MIA_OverTime;
    private int RemindList_State;
    private Object CF_GID;
    private Object CF_FieldName;
    private Object CF_Value;
    private List<VGInfoBean> VGInfo;
    private List<CouponsListBean> CouponsList;

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getVIP_HeadImg() {
        return VIP_HeadImg == null ? "http://pc.yunvip123.com/img/nohead.png" : VIP_HeadImg;
    }

    public void setVIP_HeadImg(String VIP_HeadImg) {
        this.VIP_HeadImg = VIP_HeadImg;
    }

    public String getVCH_Card() {
        return VCH_Card;
    }

    public void setVCH_Card(String VCH_Card) {
        this.VCH_Card = VCH_Card;
    }

    public String getVIP_Name() {
        return VIP_Name;
    }

    public void setVIP_Name(String VIP_Name) {
        this.VIP_Name = VIP_Name;
    }

    public int getVIP_Sex() {
        return VIP_Sex;
    }

    public void setVIP_Sex(int VIP_Sex) {
        this.VIP_Sex = VIP_Sex;
    }

    public String getVCH_CreateTime() {
        return VCH_CreateTime;
    }

    public void setVCH_CreateTime(String VCH_CreateTime) {
        this.VCH_CreateTime = VCH_CreateTime;
    }

    public String getVIP_Birthday() {
        return VIP_Birthday;
    }

    public void setVIP_Birthday(String VIP_Birthday) {
        this.VIP_Birthday = VIP_Birthday;
    }

    public String getVIP_CellPhone() {
        return VIP_CellPhone;
    }

    public void setVIP_CellPhone(String VIP_CellPhone) {
        this.VIP_CellPhone = VIP_CellPhone;
    }

    public String getVIP_ICCard() {
        return VIP_ICCard;
    }

    public void setVIP_ICCard(String VIP_ICCard) {
        this.VIP_ICCard = VIP_ICCard;
    }

    public String getVIP_Email() {
        return VIP_Email;
    }

    public void setVIP_Email(String VIP_Email) {
        this.VIP_Email = VIP_Email;
    }

    public String getVIP_Remark() {
        return VIP_Remark;
    }

    public void setVIP_Remark(String VIP_Remark) {
        this.VIP_Remark = VIP_Remark;
    }

    public int getVIP_IsForver() {
        return VIP_IsForver;
    }

    public void setVIP_IsForver(int VIP_IsForver) {
        this.VIP_IsForver = VIP_IsForver;
    }

    public String getVIP_Overdue() {
        return VIP_Overdue;
    }

    public void setVIP_Overdue(String VIP_Overdue) {
        this.VIP_Overdue = VIP_Overdue;
    }

    public int getVIP_State() {
        return VIP_State;
    }

    public void setVIP_State(int VIP_State) {
        this.VIP_State = VIP_State;
    }

    public String getVIP_FaceNumber() {
        return VIP_FaceNumber;
    }

    public void setVIP_FaceNumber(String VIP_FaceNumber) {
        this.VIP_FaceNumber = VIP_FaceNumber;
    }

    public String getVIP_Label() {
        return VIP_Label;
    }

    public void setVIP_Label(String VIP_Label) {
        this.VIP_Label = VIP_Label;
    }

    public String getVG_GID() {
        return VG_GID;
    }

    public void setVG_GID(String VG_GID) {
        this.VG_GID = VG_GID;
    }

    public String getVIP_Referee() {
        return VIP_Referee;
    }

    public void setVIP_Referee(String VIP_Referee) {
        this.VIP_Referee = VIP_Referee;
    }

    public String getVIP_Addr() {
        return VIP_Addr;
    }

    public void setVIP_Addr(String VIP_Addr) {
        this.VIP_Addr = VIP_Addr;
    }

    public String getVIP_FixedPhone() {
        return VIP_FixedPhone;
    }

    public void setVIP_FixedPhone(String VIP_FixedPhone) {
        this.VIP_FixedPhone = VIP_FixedPhone;
    }

    public String getVG_Name() {
        return VG_Name;
    }

    public void setVG_Name(String VG_Name) {
        this.VG_Name = VG_Name;
    }

    public double getMA_AvailableBalance() {
        return MA_AvailableBalance;
    }

    public void setMA_AvailableBalance(double MA_AvailableBalance) {
        this.MA_AvailableBalance = MA_AvailableBalance;
    }

    public double getMA_AvailableIntegral() {
        return MA_AvailableIntegral;
    }

    public void setMA_AvailableIntegral(double MA_AvailableIntegral) {
        this.MA_AvailableIntegral = MA_AvailableIntegral;
    }

    public int getMCA_HowMany() {
        return MCA_HowMany;
    }

    public void setMCA_HowMany(int MCA_HowMany) {
        this.MCA_HowMany = MCA_HowMany;
    }

    public Object getVIP_RegSource() {
        return VIP_RegSource;
    }

    public void setVIP_RegSource(Object VIP_RegSource) {
        this.VIP_RegSource = VIP_RegSource;
    }

    public String getEM_Name() {
        return EM_Name;
    }

    public void setEM_Name(String EM_Name) {
        this.EM_Name = EM_Name;
    }

    public int getVIP_IsLunarCalendar() {
        return VIP_IsLunarCalendar;
    }

    public void setVIP_IsLunarCalendar(int VIP_IsLunarCalendar) {
        this.VIP_IsLunarCalendar = VIP_IsLunarCalendar;
    }

    public Object getEM_ID() {
        return EM_ID;
    }

    public void setEM_ID(Object EM_ID) {
        this.EM_ID = EM_ID;
    }

    public String getVIP_Creator() {
        return VIP_Creator;
    }

    public void setVIP_Creator(String VIP_Creator) {
        this.VIP_Creator = VIP_Creator;
    }

    public String getSM_Name() {
        return SM_Name;
    }

    public void setSM_Name(String SM_Name) {
        this.SM_Name = SM_Name;
    }

    public Object getSM_GID() {
        return SM_GID;
    }

    public void setSM_GID(Object SM_GID) {
        this.SM_GID = SM_GID;
    }

    public int getVCH_Fee() {
        return VCH_Fee;
    }

    public void setVCH_Fee(int VCH_Fee) {
        this.VCH_Fee = VCH_Fee;
    }

    public String getVIP_OpenID() {
        return VIP_OpenID;
    }

    public void setVIP_OpenID(String VIP_OpenID) {
        this.VIP_OpenID = VIP_OpenID;
    }

    public int getVIP_InterCalaryMonth() {
        return VIP_InterCalaryMonth;
    }

    public void setVIP_InterCalaryMonth(int VIP_InterCalaryMonth) {
        this.VIP_InterCalaryMonth = VIP_InterCalaryMonth;
    }

    public Object getMCA_HowManyDetail() {
        return MCA_HowManyDetail;
    }

    public void setMCA_HowManyDetail(Object MCA_HowManyDetail) {
        this.MCA_HowManyDetail = MCA_HowManyDetail;
    }

    public Object getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(Object CY_GID) {
        this.CY_GID = CY_GID;
    }

    public String getVIP_UpdateTime() {
        return VIP_UpdateTime;
    }

    public void setVIP_UpdateTime(String VIP_UpdateTime) {
        this.VIP_UpdateTime = VIP_UpdateTime;
    }

    public int getVG_IsAccount() {
        return VG_IsAccount;
    }

    public void setVG_IsAccount(int VG_IsAccount) {
        this.VG_IsAccount = VG_IsAccount;
    }

    public int getVG_IsIntegral() {
        return VG_IsIntegral;
    }

    public void setVG_IsIntegral(int VG_IsIntegral) {
        this.VG_IsIntegral = VG_IsIntegral;
    }

    public int getVG_IsDiscount() {
        return VG_IsDiscount;
    }

    public void setVG_IsDiscount(int VG_IsDiscount) {
        this.VG_IsDiscount = VG_IsDiscount;
    }

    public int getVG_IsCount() {
        return VG_IsCount;
    }

    public void setVG_IsCount(int VG_IsCount) {
        this.VG_IsCount = VG_IsCount;
    }

    public int getVG_IsTime() {
        return VG_IsTime;
    }

    public void setVG_IsTime(int VG_IsTime) {
        this.VG_IsTime = VG_IsTime;
    }

    public double getDS_Value() {
        return DS_Value;
    }

    public void setDS_Value(double DS_Value) {
        this.DS_Value = DS_Value;
    }

    public double getVS_Value() {
        return VS_Value;
    }

    public void setVS_Value(double VS_Value) {
        this.VS_Value = VS_Value;
    }

    public double getRS_Value() {
        return RS_Value;
    }

    public void setRS_Value(double RS_Value) {
        this.RS_Value = RS_Value;
    }

    public Object getMberChargeList() {
        return MberChargeList;
    }

    public void setMberChargeList(Object mberChargeList) {
        MberChargeList = mberChargeList;
    }

    public Object getCustomeFieldList() {
        return CustomeFieldList;
    }

    public void setCustomeFieldList(Object customeFieldList) {
        CustomeFieldList = customeFieldList;
    }

    public int getVIP_IsDeleted() {
        return VIP_IsDeleted;
    }

    public void setVIP_IsDeleted(int VIP_IsDeleted) {
        this.VIP_IsDeleted = VIP_IsDeleted;
    }

    public double getMA_AggregateAmount() {
        return MA_AggregateAmount;
    }

    public void setMA_AggregateAmount(double MA_AggregateAmount) {
        this.MA_AggregateAmount = MA_AggregateAmount;
    }

    public double getMA_AggregateStoredValue() {
        return MA_AggregateStoredValue;
    }

    public void setMA_AggregateStoredValue(double MA_AggregateStoredValue) {
        this.MA_AggregateStoredValue = MA_AggregateStoredValue;
    }

    public int getMCA_TotalCharge() {
        return MCA_TotalCharge;
    }

    public void setMCA_TotalCharge(int MCA_TotalCharge) {
        this.MCA_TotalCharge = MCA_TotalCharge;
    }

    public String getMA_UpdateTime() {
        return MA_UpdateTime;
    }

    public void setMA_UpdateTime(String MA_UpdateTime) {
        this.MA_UpdateTime = MA_UpdateTime;
    }

    public double getMA_AggregateIntegral() {
        return MA_AggregateIntegral;
    }

    public void setMA_AggregateIntegral(double MA_AggregateIntegral) {
        this.MA_AggregateIntegral = MA_AggregateIntegral;
    }

    public Object getMessageVIP() {
        return MessageVIP;
    }

    public void setMessageVIP(Object messageVIP) {
        MessageVIP = messageVIP;
    }

    public Object getMIA_SurplusTimes() {
        return MIA_SurplusTimes;
    }

    public void setMIA_SurplusTimes(Object MIA_SurplusTimes) {
        this.MIA_SurplusTimes = MIA_SurplusTimes;
    }

    public Object getMIA_OverTime() {
        return MIA_OverTime;
    }

    public void setMIA_OverTime(Object MIA_OverTime) {
        this.MIA_OverTime = MIA_OverTime;
    }

    public int getRemindList_State() {
        return RemindList_State;
    }

    public void setRemindList_State(int remindList_State) {
        RemindList_State = remindList_State;
    }

    public Object getCF_GID() {
        return CF_GID;
    }

    public void setCF_GID(Object CF_GID) {
        this.CF_GID = CF_GID;
    }

    public Object getCF_FieldName() {
        return CF_FieldName;
    }

    public void setCF_FieldName(Object CF_FieldName) {
        this.CF_FieldName = CF_FieldName;
    }

    public Object getCF_Value() {
        return CF_Value;
    }

    public void setCF_Value(Object CF_Value) {
        this.CF_Value = CF_Value;
    }

    public List<VGInfoBean> getVGInfo() {
        return VGInfo;
    }

    public void setVGInfo(List<VGInfoBean> VGInfo) {
        this.VGInfo = VGInfo;
    }

    public List<CouponsListBean> getCouponsList() {
        return CouponsList;
    }

    public void setCouponsList(List<CouponsListBean> couponsList) {
        CouponsList = couponsList;
    }

    public static class VGInfoBean implements Serializable {
        /**
         * VG_GID : 45a168cb-493e-43b7-8cfc-730ef4da27c7
         * VG_Name : 默认等级
         * PT_GID : ae26522f-d0e8-48f9-a9a7-1d6d41077eaf
         * PT_Name : 帕子
         * PT_Type : 商品
         * PD_Discount : 100
         * VS_CMoney : 1.0
         * VS_Number : 1.0
         * SM_GID : 757d1fe2-0a35-4475-b9a6-76c2dfa82bf0
         * SM_Name : 默认店铺
         * PT_Parent : a4d67cbf-9268-4a29-aef2-76ddb81200ba
         * PT_SynType : 1
         */

        private String VG_GID;
        private String VG_Name;
        private String PT_GID;
        private String PT_Name;
        private String PT_Type;
        private int PD_Discount;
        private double VS_CMoney;
        private double VS_Number;
        private String SM_GID;
        private String SM_Name;
        private String PT_Parent;
        private String PT_SynType;

        public String getVG_GID() {
            return VG_GID;
        }

        public void setVG_GID(String VG_GID) {
            this.VG_GID = VG_GID;
        }

        public String getVG_Name() {
            return VG_Name;
        }

        public void setVG_Name(String VG_Name) {
            this.VG_Name = VG_Name;
        }

        public String getPT_GID() {
            return PT_GID;
        }

        public void setPT_GID(String PT_GID) {
            this.PT_GID = PT_GID;
        }

        public String getPT_Name() {
            return PT_Name;
        }

        public void setPT_Name(String PT_Name) {
            this.PT_Name = PT_Name;
        }

        public String getPT_Type() {
            return PT_Type;
        }

        public void setPT_Type(String PT_Type) {
            this.PT_Type = PT_Type;
        }

        public int getPD_Discount() {
            return PD_Discount;
        }

        public void setPD_Discount(int PD_Discount) {
            this.PD_Discount = PD_Discount;
        }

        public double getVS_CMoney() {
            return VS_CMoney;
        }

        public void setVS_CMoney(double VS_CMoney) {
            this.VS_CMoney = VS_CMoney;
        }

        public double getVS_Number() {
            return VS_Number;
        }

        public void setVS_Number(double VS_Number) {
            this.VS_Number = VS_Number;
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

        public String getPT_Parent() {
            return PT_Parent;
        }

        public void setPT_Parent(String PT_Parent) {
            this.PT_Parent = PT_Parent;
        }

        public String getPT_SynType() {
            return PT_SynType;
        }

        public void setPT_SynType(String PT_SynType) {
            this.PT_SynType = PT_SynType;
        }
    }

    public static class CouponsListBean implements Serializable {
        /**
         * GID : 0b044bb9-0962-48ba-8a46-ec23899500c8
         * VIP_GID : 95aa3f34-5faf-409c-956e-a98f95b2d716
         * EC_GID : 0714adbe-8284-4302-a8e3-d744d34d500b
         * EC_ReddemCode : null
         * VCR_IsForver : 1
         * VCR_StatrTime : null
         * VCR_EndTime : null
         * VCR_IsUse : 0
         * VCR_CreatorTime : 2019-07-16 16:26:53
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * EC_DiscountType : 2
         * EC_UseType : 1
         * EC_Discount : 70.0
         * EC_Denomination : 0.0
         * EC_Name : 7折
         * EC_IsOverlay : 0
         * EC_GiftCondition : 20.0
         * SM_Name : null
         */

        private String GID;
        private String VIP_GID;
        private String EC_GID;
        private String EC_ReddemCode;
        private int VCR_IsForver;
        private String VCR_StatrTime;
        private String VCR_EndTime;
        private int VCR_IsUse;
        private String VCR_CreatorTime;
        private String SM_GID;
        private String CY_GID;
        private int EC_DiscountType;
        private int EC_UseType;
        private double EC_Discount;
        private double EC_Denomination;
        private String EC_Name;
        private int EC_IsOverlay;
        private double EC_GiftCondition;
        private String SM_Name;

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
}

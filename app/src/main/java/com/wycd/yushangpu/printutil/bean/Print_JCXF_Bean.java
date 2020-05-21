package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/2 19:50
 * email：jasoncheng9111@gmail.com
 */
public class Print_JCXF_Bean
{
    /**
     * Cashier : 18986810706
     * CheckoutDate : 2017-08-02 19:25:07
     * OrderCode : JC1708021925027152
     * ActivityName : null
     * ActivityValue : null
     * IntegralAdd : 0
     * IntegralDeduct : 0
     * YSMoney : 0
     * SSMoney : 0
     * ZLMoney : 0
     * VCH_Card : 33
     * VIP_Name : 哈哈哈
     * VCH_Money : 0
     * VCH_Point : 123928.2
     * GoodsList : null
     * ServiceList : [{"EM_GIDList":null,"GID":"9b568b4c-b7bd-4b4a-9381-e4fb81ca3c02","WO_GID":"045646a3-2383-4ee6-944b-9b23952a381a","WOD_UseNumber":8,
     * "WOD_ResidueDegree":50,"SG_GID":"1fa64f93-6634-443f-9d52-3ca279af610f","SG_Code":null,"SGC_Name":"啦咯啦咯啦咯啦咯啦","SG_Name":"啦咯啦咯啦咯啦咯啦","SG_Price":1,"SG_Abstract":null,
     * "SG_Detail":null,"CY_GID":null,"WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-02 19:25:07"}]
     * GiftList : null
     * ConsumeMoney : 0
     * Discount : 0
     * GiveMoney : 0
     * RechargeTotal : 0
     * ExchangeNum : 0
     */

    private String Cashier;
    private String CheckoutDate;
    private String OrderCode;
    private Object ActivityName;
    private Object ActivityValue;
    private double IntegralAdd;
    private double IntegralDeduct;
    private double YSMoney;
    private double SSMoney;
    private double ZLMoney;
    private String VCH_Card;
    private String VIP_Name;
    private double VCH_Money;
    private double VCH_Point;
    private Object GoodsList;
    private Object GiftList;
    private double ConsumeMoney;
    private double Discount;
    private String EMName;
    private double GiveMoney;
    private double RechargeTotal;
    private double ExchangeNum;
    private String PayInfo;
    private List<ServiceListBean> ServiceList;
    private String Remark;
    private String VIP_FaceNumber;


    public String getVIP_FaceNumber() {
        return VIP_FaceNumber;
    }

    public void setVIP_FaceNumber(String VIP_FaceNumber) {
        this.VIP_FaceNumber = VIP_FaceNumber;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getPayInfo() {
        return PayInfo;
    }

    public void setPayInfo(String payInfo) {
        PayInfo = payInfo;
    }

    public String getCashier() { return Cashier;}

    public void setCashier(String Cashier) { this.Cashier = Cashier;}

    public String getCheckoutDate() { return CheckoutDate;}

    public void setCheckoutDate(String CheckoutDate) { this.CheckoutDate = CheckoutDate;}

    public String getOrderCode() { return OrderCode;}

    public void setOrderCode(String OrderCode) { this.OrderCode = OrderCode;}

    public Object getActivityName() { return ActivityName;}

    public void setActivityName(Object ActivityName) { this.ActivityName = ActivityName;}

    public Object getActivityValue() { return ActivityValue;}

    public void setActivityValue(Object ActivityValue) { this.ActivityValue = ActivityValue;}

    public double getIntegralAdd() { return IntegralAdd;}

    public void setIntegralAdd(double IntegralAdd) { this.IntegralAdd = IntegralAdd;}

    public double getIntegralDeduct() { return IntegralDeduct;}

    public void setIntegralDeduct(double IntegralDeduct) { this.IntegralDeduct = IntegralDeduct;}

    public double getYSMoney() { return YSMoney;}

    public void setYSMoney(double YSMoney) { this.YSMoney = YSMoney;}

    public double getSSMoney() { return SSMoney;}

    public void setSSMoney(double SSMoney) { this.SSMoney = SSMoney;}

    public double getZLMoney() { return ZLMoney;}

    public void setZLMoney(double ZLMoney) { this.ZLMoney = ZLMoney;}

    public String getVCH_Card() { return VCH_Card;}

    public void setVCH_Card(String VCH_Card) { this.VCH_Card = VCH_Card;}

    public String getVIP_Name() { return VIP_Name;}

    public void setVIP_Name(String VIP_Name) { this.VIP_Name = VIP_Name;}

    public double getVCH_Money() { return VCH_Money;}

    public void setVCH_Money(double VCH_Money) { this.VCH_Money = VCH_Money;}

    public double getVCH_Point() { return VCH_Point;}

    public void setVCH_Point(double VCH_Point) { this.VCH_Point = VCH_Point;}

    public Object getGoodsList() { return GoodsList;}

    public void setGoodsList(Object GoodsList) { this.GoodsList = GoodsList;}

    public Object getGiftList() { return GiftList;}

    public void setGiftList(Object GiftList) { this.GiftList = GiftList;}

    public double getConsumeMoney() { return ConsumeMoney;}

    public void setConsumeMoney(double ConsumeMoney) { this.ConsumeMoney = ConsumeMoney;}

    public String getEMName() {
        return EMName;
    }

    public void setEMName(String EMName) {
        this.EMName = EMName;
    }


    public double getDiscount() { return Discount;}

    public void setDiscount(double Discount) { this.Discount = Discount;}

    public double getGiveMoney() { return GiveMoney;}

    public void setGiveMoney(double GiveMoney) { this.GiveMoney = GiveMoney;}

    public double getRechargeTotal() { return RechargeTotal;}

    public void setRechargeTotal(double RechargeTotal) { this.RechargeTotal = RechargeTotal;}

    public double getExchangeNum() { return ExchangeNum;}

    public void setExchangeNum(double ExchangeNum) { this.ExchangeNum = ExchangeNum;}

    public List<ServiceListBean> getServiceList() { return ServiceList;}

    public void setServiceList(List<ServiceListBean> ServiceList) { this.ServiceList = ServiceList;}

    public static class ServiceListBean
    {
        /**
         * EM_GIDList : null
         * GID : 9b568b4c-b7bd-4b4a-9381-e4fb81ca3c02
         * WO_GID : 045646a3-2383-4ee6-944b-9b23952a381a
         * WOD_UseNumber : 8
         * WOD_ResidueDegree : 50
         * SG_GID : 1fa64f93-6634-443f-9d52-3ca279af610f
         * SG_Code : null
         * SGC_Name : 啦咯啦咯啦咯啦咯啦
         * SG_Name : 啦咯啦咯啦咯啦咯啦
         * SG_Price : 1
         * SG_Abstract : null
         * SG_Detail : null
         * CY_GID : null
         * WOD_Crator : 18986810706
         * WOD_UpdateTime : 2017-08-02 19:25:07
         */

        private Object EM_GIDList;
        private String GID;
        private String WO_GID;
        private int WOD_UseNumber;
        private int WOD_ResidueDegree;
        private String SG_GID;
        private Object SG_Code;
        private String SGC_Name;
        private String SG_Name;
        private double SG_Price;
        private Object SG_Abstract;
        private Object SG_Detail;
        private Object CY_GID;
        private String WOD_Crator;
        private String WOD_EMName;
        private String WOD_UpdateTime;


        public String getWOD_EMName() {
            return WOD_EMName;
        }

        public void setWOD_EMName(String WOD_EMName) {
            this.WOD_EMName = WOD_EMName;
        }

        public Object getEM_GIDList() { return EM_GIDList;}

        public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

        public String getGID() { return GID;}

        public void setGID(String GID) { this.GID = GID;}

        public String getWO_GID() { return WO_GID;}

        public void setWO_GID(String WO_GID) { this.WO_GID = WO_GID;}

        public int getWOD_UseNumber() { return WOD_UseNumber;}

        public void setWOD_UseNumber(int WOD_UseNumber) { this.WOD_UseNumber = WOD_UseNumber;}

        public int getWOD_ResidueDegree() { return WOD_ResidueDegree;}

        public void setWOD_ResidueDegree(int WOD_ResidueDegree) { this.WOD_ResidueDegree = WOD_ResidueDegree;}

        public String getSG_GID() { return SG_GID;}

        public void setSG_GID(String SG_GID) { this.SG_GID = SG_GID;}

        public Object getSG_Code() { return SG_Code;}

        public void setSG_Code(Object SG_Code) { this.SG_Code = SG_Code;}

        public String getSGC_Name() { return SGC_Name;}

        public void setSGC_Name(String SGC_Name) { this.SGC_Name = SGC_Name;}

        public String getSG_Name() { return SG_Name;}

        public void setSG_Name(String SG_Name) { this.SG_Name = SG_Name;}

        public double getSG_Price() { return SG_Price;}

        public void setSG_Price(double SG_Price) { this.SG_Price = SG_Price;}

        public Object getSG_Abstract() { return SG_Abstract;}

        public void setSG_Abstract(Object SG_Abstract) { this.SG_Abstract = SG_Abstract;}

        public Object getSG_Detail() { return SG_Detail;}

        public void setSG_Detail(Object SG_Detail) { this.SG_Detail = SG_Detail;}

        public Object getCY_GID() { return CY_GID;}

        public void setCY_GID(Object CY_GID) { this.CY_GID = CY_GID;}

        public String getWOD_Crator() { return WOD_Crator;}

        public void setWOD_Crator(String WOD_Crator) { this.WOD_Crator = WOD_Crator;}

        public String getWOD_UpdateTime() { return WOD_UpdateTime;}

        public void setWOD_UpdateTime(String WOD_UpdateTime) { this.WOD_UpdateTime = WOD_UpdateTime;}
    }
}

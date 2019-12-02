package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/2 19:49
 * email：jasoncheng9111@gmail.com
 */
public class Print_HYCC_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"Cashier":"18986810706","CheckoutDate":"0001-01-01 00:00:00","OrderCode":"CC1708021925474958","ActivityName":null,"ActivityValue":null,"IntegralAdd":0,
     * "IntegralDeduct":0,"YSMoney":40000,"SSMoney":89032.66,"ZLMoney":49032.66,"VCH_Card":"33","VIP_Name":"哈哈哈","VCH_Money":0,"VCH_Point":123928.2,"GoodsList":null,
     * "ServiceList":[{"EM_GIDList":null,"SumPrice":null,"GID":"ccdbc3b7-860e-4846-bd3a-fa362040bd47","CO_GID":"fc22f79e-d532-4c05-9275-e1b90fb949a0",
     * "PM_GID":"79c4644b-df87-41bc-9b33-4300b931e848","PM_Code":"232323","PT_Name":"运动户外","PT_GID":"e16a41d2-d421-4260-8d49-04807766447d","PM_Name":"23232",
     * "PM_SimpleCode":"23232","PM_Metering":null,"PM_UnitPrice":10000,"PM_Detail":null,"PM_Description":"","PM_Modle":"","PM_Brand":"","PM_Number":4,"PM_FixedIntegralValue":0,
     * "PM_Discount":1,"GOD_DiscountPrice":10000,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:26:40",
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"}],"GiftList":null,"ConsumeMoney":0,"Discount":0,"GiveMoney":0,"RechargeTotal":0,"ExchangeNum":0}
     */

    private boolean success;
    private Object code;
    private String msg;
    private DataBean data;

    public boolean isSuccess() { return success;}

    public void setSuccess(boolean success) { this.success = success;}

    public Object getCode() { return code;}

    public void setCode(Object code) { this.code = code;}

    public String getMsg() { return msg;}

    public void setMsg(String msg) { this.msg = msg;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean
    {
        /**
         * Cashier : 18986810706
         * CheckoutDate : 0001-01-01 00:00:00
         * OrderCode : CC1708021925474958
         * ActivityName : null
         * ActivityValue : null
         * IntegralAdd : 0
         * IntegralDeduct : 0
         * YSMoney : 40000
         * SSMoney : 89032.66
         * ZLMoney : 49032.66
         * VCH_Card : 33
         * VIP_Name : 哈哈哈
         * VCH_Money : 0
         * VCH_Point : 123928.2
         * GoodsList : null
         * ServiceList : [{"EM_GIDList":null,"SumPrice":null,"GID":"ccdbc3b7-860e-4846-bd3a-fa362040bd47","CO_GID":"fc22f79e-d532-4c05-9275-e1b90fb949a0",
         * "PM_GID":"79c4644b-df87-41bc-9b33-4300b931e848","PM_Code":"232323","PT_Name":"运动户外","PT_GID":"e16a41d2-d421-4260-8d49-04807766447d","PM_Name":"23232",
         * "PM_SimpleCode":"23232","PM_Metering":null,"PM_UnitPrice":10000,"PM_Detail":null,"PM_Description":"","PM_Modle":"","PM_Brand":"","PM_Number":4,
         * "PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":10000,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:26:40",
         * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"}]
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
        private double GiveMoney;
        private double RechargeTotal;
        private double ExchangeNum;
        private String EMName;

        public String getEMName() {
            return EMName;
        }

        public void setEMName(String EMName) {
            this.EMName = EMName;
        }
        public String getVIP_FaceNumber() {
            return VIP_FaceNumber;
        }

        public void setVIP_FaceNumber(String VIP_FaceNumber) {
            this.VIP_FaceNumber = VIP_FaceNumber;
        }

        private String VIP_FaceNumber;

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String remark) {
            Remark = remark;
        }

        private String Remark;


        public String getPayInfo() {
            return PayInfo;
        }

        public void setPayInfo(String payInfo) {
            PayInfo = payInfo;
        }

        private String PayInfo;
        private List<ServiceListBean> ServiceList;

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
             * SumPrice : null
             * GID : ccdbc3b7-860e-4846-bd3a-fa362040bd47
             * CO_GID : fc22f79e-d532-4c05-9275-e1b90fb949a0
             * PM_GID : 79c4644b-df87-41bc-9b33-4300b931e848
             * PM_Code : 232323
             * PT_Name : 运动户外
             * PT_GID : e16a41d2-d421-4260-8d49-04807766447d
             * PM_Name : 23232
             * PM_SimpleCode : 23232
             * PM_Metering : null
             * PM_UnitPrice : 10000
             * PM_Detail : null
             * PM_Description :
             * PM_Modle :
             * PM_Brand :
             * PM_Number : 4
             * PM_FixedIntegralValue : 0
             * PM_Discount : 1
             * GOD_DiscountPrice : 10000
             * GOD_Integral : 0
             * GOD_Creator : 18986810706
             * GOD_UpdateTime : 2017-08-02 19:26:40
             * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
             */

            private Object EM_GIDList;
            private Object SumPrice;
            private String GID;
            private String CO_GID;
            private String PM_GID;
            private String PM_Code;
            private String PT_Name;
            private String PT_GID;
            private String PM_Name;
            private String PM_SimpleCode;
            private Object PM_Metering;
            private double PM_UnitPrice;
            private Object PM_Detail;
            private String PM_Description;
            private String PM_Modle;
            private String PM_Brand;
            private int PM_Number;
            private double PM_FixedIntegralValue;
            private double PM_Discount;
            private double GOD_DiscountPrice;
            private double GOD_Integral;
            private String GOD_Creator;
            private String GOD_UpdateTime;
            private String CY_GID;

            public String getGOD_ExpireDate() {
                return GOD_ExpireDate;
            }

            public void setGOD_ExpireDate(String GOD_ExpireDate) {
                this.GOD_ExpireDate = GOD_ExpireDate;
            }

            private String GOD_ExpireDate;

            public Object getEM_GIDList() { return EM_GIDList;}

            public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

            public Object getSumPrice() { return SumPrice;}

            public void setSumPrice(Object SumPrice) { this.SumPrice = SumPrice;}

            public String getGID() { return GID;}

            public void setGID(String GID) { this.GID = GID;}

            public String getCO_GID() { return CO_GID;}

            public void setCO_GID(String CO_GID) { this.CO_GID = CO_GID;}

            public String getPM_GID() { return PM_GID;}

            public void setPM_GID(String PM_GID) { this.PM_GID = PM_GID;}

            public String getPM_Code() { return PM_Code;}

            public void setPM_Code(String PM_Code) { this.PM_Code = PM_Code;}

            public String getPT_Name() { return PT_Name;}

            public void setPT_Name(String PT_Name) { this.PT_Name = PT_Name;}

            public String getPT_GID() { return PT_GID;}

            public void setPT_GID(String PT_GID) { this.PT_GID = PT_GID;}

            public String getPM_Name() { return PM_Name;}

            public void setPM_Name(String PM_Name) { this.PM_Name = PM_Name;}

            public String getPM_SimpleCode() { return PM_SimpleCode;}

            public void setPM_SimpleCode(String PM_SimpleCode) { this.PM_SimpleCode = PM_SimpleCode;}

            public Object getPM_Metering() { return PM_Metering;}

            public void setPM_Metering(Object PM_Metering) { this.PM_Metering = PM_Metering;}

            public double getPM_UnitPrice() { return PM_UnitPrice;}

            public void setPM_UnitPrice(double PM_UnitPrice) { this.PM_UnitPrice = PM_UnitPrice;}

            public Object getPM_Detail() { return PM_Detail;}

            public void setPM_Detail(Object PM_Detail) { this.PM_Detail = PM_Detail;}

            public String getPM_Description() { return PM_Description;}

            public void setPM_Description(String PM_Description) { this.PM_Description = PM_Description;}

            public String getPM_Modle() { return PM_Modle;}

            public void setPM_Modle(String PM_Modle) { this.PM_Modle = PM_Modle;}

            public String getPM_Brand() { return PM_Brand;}

            public void setPM_Brand(String PM_Brand) { this.PM_Brand = PM_Brand;}

            public int getPM_Number() { return PM_Number;}

            public void setPM_Number(int PM_Number) { this.PM_Number = PM_Number;}

            public double getPM_FixedIntegralValue() { return PM_FixedIntegralValue;}

            public void setPM_FixedIntegralValue(double PM_FixedIntegralValue) { this.PM_FixedIntegralValue = PM_FixedIntegralValue;}

            public double getPM_Discount() { return PM_Discount;}

            public void setPM_Discount(double PM_Discount) { this.PM_Discount = PM_Discount;}

            public double getGOD_DiscountPrice() { return GOD_DiscountPrice;}

            public void setGOD_DiscountPrice(double GOD_DiscountPrice) { this.GOD_DiscountPrice = GOD_DiscountPrice;}

            public double getGOD_Integral() { return GOD_Integral;}

            public void setGOD_Integral(double GOD_Integral) { this.GOD_Integral = GOD_Integral;}

            public String getGOD_Creator() { return GOD_Creator;}

            public void setGOD_Creator(String GOD_Creator) { this.GOD_Creator = GOD_Creator;}

            public String getGOD_UpdateTime() { return GOD_UpdateTime;}

            public void setGOD_UpdateTime(String GOD_UpdateTime) { this.GOD_UpdateTime = GOD_UpdateTime;}

            public String getCY_GID() { return CY_GID;}

            public void setCY_GID(String CY_GID) { this.CY_GID = CY_GID;}
        }
    }
}

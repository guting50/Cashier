package com.wycd.yushangpu.printutil.bean;

/**
 * Created by YSL on 2018-10-09.
 */

public class Print_HYKK_Bean {


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"Cashier":"销售001","CheckoutDate":"2018-10-09 15:11:11","OrderCode":null,"ActivityName":null,"ActivityValue":null,"IntegralAdd":0,"IntegralDeduct":0,"YSMoney":0,"SSMoney":0,"ZLMoney":0,"VCH_Card":"18381306467","VIP_Name":"嘤发","VCH_Money":0,"VCH_Point":0,"GoodsList":null,"ServiceList":null,"GiftList":null,"ConsumeMoney":0,"ConsumeTotal":0,"GoodsMoney":0,"Discount":0,"GiveMoney":0,"RechargeTotal":0,"ExchangeNum":0,"TS_UpdateTime":null,"TimeLong":null,"TS_MinusTimes":null,"TS_SurplusTimes":null,"VIP_FaceNumber":"","PayInfo":null,"VCH_Fee":0,"InitialAmount":0,"InitialIntegral":0,"Remark":""}
     */

    private boolean success;
    private Object code;
    private String msg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Cashier : 销售001
         * CheckoutDate : 2018-10-09 15:11:11
         * OrderCode : null
         * ActivityName : null
         * ActivityValue : null
         * IntegralAdd : 0.0
         * IntegralDeduct : 0.0
         * YSMoney : 0.0
         * SSMoney : 0.0
         * ZLMoney : 0.0
         * VCH_Card : 18381306467
         * VIP_Name : 嘤发
         * VCH_Money : 0.0
         * VCH_Point : 0.0
         * GoodsList : null
         * ServiceList : null
         * GiftList : null
         * ConsumeMoney : 0.0
         * ConsumeTotal : 0.0
         * GoodsMoney : 0.0
         * Discount : 0.0
         * GiveMoney : 0.0
         * RechargeTotal : 0.0
         * ExchangeNum : 0
         * TS_UpdateTime : null
         * TimeLong : null
         * TS_MinusTimes : null
         * TS_SurplusTimes : null
         * VIP_FaceNumber :
         * PayInfo : null
         * VCH_Fee : 0
         * InitialAmount : 0.0
         * InitialIntegral : 0.0
         * Remark :
         */

        private String Cashier;
        private String CheckoutDate;
        private Object OrderCode;
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
        private Object ServiceList;
        private Object GiftList;
        private double ConsumeMoney;
        private double ConsumeTotal;
        private double GoodsMoney;
        private double Discount;
        private double GiveMoney;
        private double RechargeTotal;
        private int ExchangeNum;
        private Object TS_UpdateTime;
        private Object TimeLong;
        private Object TS_MinusTimes;
        private Object TS_SurplusTimes;
        private String VIP_FaceNumber;
        private Object PayInfo;
        private double VCH_Fee;
        private double InitialAmount;
        private double InitialIntegral;
        private String Remark;
        private String EMName;

        public String getEMName() {
            return EMName;
        }

        public void setEMName(String EMName) {
            this.EMName = EMName;
        }


        public String getCashier() {
            return Cashier;
        }

        public void setCashier(String Cashier) {
            this.Cashier = Cashier;
        }

        public String getCheckoutDate() {
            return CheckoutDate;
        }

        public void setCheckoutDate(String CheckoutDate) {
            this.CheckoutDate = CheckoutDate;
        }

        public Object getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(Object OrderCode) {
            this.OrderCode = OrderCode;
        }

        public Object getActivityName() {
            return ActivityName;
        }

        public void setActivityName(Object ActivityName) {
            this.ActivityName = ActivityName;
        }

        public Object getActivityValue() {
            return ActivityValue;
        }

        public void setActivityValue(Object ActivityValue) {
            this.ActivityValue = ActivityValue;
        }

        public double getIntegralAdd() {
            return IntegralAdd;
        }

        public void setIntegralAdd(double IntegralAdd) {
            this.IntegralAdd = IntegralAdd;
        }

        public double getIntegralDeduct() {
            return IntegralDeduct;
        }

        public void setIntegralDeduct(double IntegralDeduct) {
            this.IntegralDeduct = IntegralDeduct;
        }

        public double getYSMoney() {
            return YSMoney;
        }

        public void setYSMoney(double YSMoney) {
            this.YSMoney = YSMoney;
        }

        public double getSSMoney() {
            return SSMoney;
        }

        public void setSSMoney(double SSMoney) {
            this.SSMoney = SSMoney;
        }

        public double getZLMoney() {
            return ZLMoney;
        }

        public void setZLMoney(double ZLMoney) {
            this.ZLMoney = ZLMoney;
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

        public double getVCH_Money() {
            return VCH_Money;
        }

        public void setVCH_Money(double VCH_Money) {
            this.VCH_Money = VCH_Money;
        }

        public double getVCH_Point() {
            return VCH_Point;
        }

        public void setVCH_Point(double VCH_Point) {
            this.VCH_Point = VCH_Point;
        }

        public Object getGoodsList() {
            return GoodsList;
        }

        public void setGoodsList(Object GoodsList) {
            this.GoodsList = GoodsList;
        }

        public Object getServiceList() {
            return ServiceList;
        }

        public void setServiceList(Object ServiceList) {
            this.ServiceList = ServiceList;
        }

        public Object getGiftList() {
            return GiftList;
        }

        public void setGiftList(Object GiftList) {
            this.GiftList = GiftList;
        }

        public double getConsumeMoney() {
            return ConsumeMoney;
        }

        public void setConsumeMoney(double ConsumeMoney) {
            this.ConsumeMoney = ConsumeMoney;
        }

        public double getConsumeTotal() {
            return ConsumeTotal;
        }

        public void setConsumeTotal(double ConsumeTotal) {
            this.ConsumeTotal = ConsumeTotal;
        }

        public double getGoodsMoney() {
            return GoodsMoney;
        }

        public void setGoodsMoney(double GoodsMoney) {
            this.GoodsMoney = GoodsMoney;
        }

        public double getDiscount() {
            return Discount;
        }

        public void setDiscount(double Discount) {
            this.Discount = Discount;
        }

        public double getGiveMoney() {
            return GiveMoney;
        }

        public void setGiveMoney(double GiveMoney) {
            this.GiveMoney = GiveMoney;
        }

        public double getRechargeTotal() {
            return RechargeTotal;
        }

        public void setRechargeTotal(double RechargeTotal) {
            this.RechargeTotal = RechargeTotal;
        }

        public int getExchangeNum() {
            return ExchangeNum;
        }

        public void setExchangeNum(int ExchangeNum) {
            this.ExchangeNum = ExchangeNum;
        }

        public Object getTS_UpdateTime() {
            return TS_UpdateTime;
        }

        public void setTS_UpdateTime(Object TS_UpdateTime) {
            this.TS_UpdateTime = TS_UpdateTime;
        }

        public Object getTimeLong() {
            return TimeLong;
        }

        public void setTimeLong(Object TimeLong) {
            this.TimeLong = TimeLong;
        }

        public Object getTS_MinusTimes() {
            return TS_MinusTimes;
        }

        public void setTS_MinusTimes(Object TS_MinusTimes) {
            this.TS_MinusTimes = TS_MinusTimes;
        }

        public Object getTS_SurplusTimes() {
            return TS_SurplusTimes;
        }

        public void setTS_SurplusTimes(Object TS_SurplusTimes) {
            this.TS_SurplusTimes = TS_SurplusTimes;
        }

        public String getVIP_FaceNumber() {
            return VIP_FaceNumber;
        }

        public void setVIP_FaceNumber(String VIP_FaceNumber) {
            this.VIP_FaceNumber = VIP_FaceNumber;
        }

        public Object getPayInfo() {
            return PayInfo;
        }

        public void setPayInfo(Object PayInfo) {
            this.PayInfo = PayInfo;
        }

        public double getVCH_Fee() {
            return VCH_Fee;
        }

        public void setVCH_Fee(double VCH_Fee) {
            this.VCH_Fee = VCH_Fee;
        }

        public double getInitialAmount() {
            return InitialAmount;
        }

        public void setInitialAmount(double InitialAmount) {
            this.InitialAmount = InitialAmount;
        }

        public double getInitialIntegral() {
            return InitialIntegral;
        }

        public void setInitialIntegral(double InitialIntegral) {
            this.InitialIntegral = InitialIntegral;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }
    }
}

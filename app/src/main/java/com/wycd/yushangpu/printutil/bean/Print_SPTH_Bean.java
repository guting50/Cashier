package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * Created by ZPH on 2019-04-08.
 */

public class Print_SPTH_Bean {

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"Cashier":"销售001","CheckoutDate":"2019-04-08 15:16:59","OrderCode":"SP1904040929296961","ActivityName":null,"ActivityValue":null,"IntegralAdd":0,"IntegralDeduct":11,"YSMoney":14,"SSMoney":0,"ZLMoney":0,"VCH_Card":"18338258258","VIP_Name":"来了","VCH_Money":1.11112766E7,"VCH_Point":1362,"GoodsList":[{"RO_Monetary":14,"PM_IsService":null,"GID":"a1d1d23d-ed42-4926-b454-ed737e845a0b","RO_GID":"1a8704a9-fc78-49d1-8433-3b5269304411","PM_GID":"7ace77f3-219b-4680-993f-ea1fc5e543bc","PM_Code":"10","PT_Name":"牙刷","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PM_Name":"1010","PM_BigImg":null,"PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":10,"PM_Detail":null,"PM_Description":null,"PM_Modle":"","PM_Brand":"","PM_Number":1,"PM_Discount":1,"ROD_DiscountPrice":10,"ROD_Integral":0,"ROD_Creator":"销售001","ROD_UpdateTime":"2019-04-08 15:16:59","CY_GID":null},{"RO_Monetary":14,"PM_IsService":null,"GID":"ec99ec3e-7dc5-4a83-96e6-578ebd869b84","RO_GID":"1a8704a9-fc78-49d1-8433-3b5269304411","PM_GID":"6993ae3b-7eed-4a90-9117-ddc074b1e13e","PM_Code":"1454464511","PT_Name":"1","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PM_Name":"111","PM_BigImg":null,"PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":10,"PM_Detail":null,"PM_Description":null,"PM_Modle":"","PM_Brand":"","PM_Number":1,"PM_Discount":1,"ROD_DiscountPrice":10,"ROD_Integral":10,"ROD_Creator":"销售001","ROD_UpdateTime":"2019-04-08 15:16:59","CY_GID":null}],"ServiceList":null,"GiftList":null,"ConsumeMoney":0,"ConsumeTotal":0,"GoodsMoney":0,"HM_Money":0,"HM_Name":null,"Discount":0,"GiveMoney":0,"RechargeTotal":0,"ExchangeNum":0,"TS_UpdateTime":null,"TimeLong":null,"TS_MinusTimes":null,"TS_SurplusTimes":null,"VIP_FaceNumber":"他特踏踏","PayInfo":"余额退款","VCH_Fee":0,"InitialAmount":0,"InitialIntegral":0,"Remark":"","VIPAddress":null,"EMName":null,"IndividualHand":null}
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
         * CheckoutDate : 2019-04-08 15:16:59
         * OrderCode : SP1904040929296961
         * ActivityName : null
         * ActivityValue : null
         * IntegralAdd : 0.0
         * IntegralDeduct : 11.0
         * YSMoney : 14.0
         * SSMoney : 0.0
         * ZLMoney : 0.0
         * VCH_Card : 18338258258
         * VIP_Name : 来了
         * VCH_Money : 1.11112766E7
         * VCH_Point : 1362.0
         * GoodsList : [{"RO_Monetary":14,"PM_IsService":null,"GID":"a1d1d23d-ed42-4926-b454-ed737e845a0b","RO_GID":"1a8704a9-fc78-49d1-8433-3b5269304411","PM_GID":"7ace77f3-219b-4680-993f-ea1fc5e543bc","PM_Code":"10","PT_Name":"牙刷","PT_GID":"071014a5-c89b-409f-a31c-7b0b3dbb7b68","PM_Name":"1010","PM_BigImg":null,"PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":10,"PM_Detail":null,"PM_Description":null,"PM_Modle":"","PM_Brand":"","PM_Number":1,"PM_Discount":1,"ROD_DiscountPrice":10,"ROD_Integral":0,"ROD_Creator":"销售001","ROD_UpdateTime":"2019-04-08 15:16:59","CY_GID":null},{"RO_Monetary":14,"PM_IsService":null,"GID":"ec99ec3e-7dc5-4a83-96e6-578ebd869b84","RO_GID":"1a8704a9-fc78-49d1-8433-3b5269304411","PM_GID":"6993ae3b-7eed-4a90-9117-ddc074b1e13e","PM_Code":"1454464511","PT_Name":"1","PT_GID":"054dbd3c-67ba-4109-9c5c-137b7f4596db","PM_Name":"111","PM_BigImg":null,"PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":10,"PM_Detail":null,"PM_Description":null,"PM_Modle":"","PM_Brand":"","PM_Number":1,"PM_Discount":1,"ROD_DiscountPrice":10,"ROD_Integral":10,"ROD_Creator":"销售001","ROD_UpdateTime":"2019-04-08 15:16:59","CY_GID":null}]
         * ServiceList : null
         * GiftList : null
         * ConsumeMoney : 0.0
         * ConsumeTotal : 0.0
         * GoodsMoney : 0.0
         * HM_Money : 0.0
         * HM_Name : null
         * Discount : 0.0
         * GiveMoney : 0.0
         * RechargeTotal : 0.0
         * ExchangeNum : 0
         * TS_UpdateTime : null
         * TimeLong : null
         * TS_MinusTimes : null
         * TS_SurplusTimes : null
         * VIP_FaceNumber : 他特踏踏
         * PayInfo : 余额退款
         * VCH_Fee : 0
         * InitialAmount : 0.0
         * InitialIntegral : 0.0
         * Remark :
         * VIPAddress : null
         * EMName : null
         * IndividualHand : null
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
        private Object ServiceList;
        private Object GiftList;
        private double ConsumeMoney;
        private double ConsumeTotal;
        private double GoodsMoney;
        private double HM_Money;
        private Object HM_Name;
        private double Discount;
        private double GiveMoney;
        private double RechargeTotal;
        private int ExchangeNum;
        private Object TS_UpdateTime;
        private Object TimeLong;
        private Object TS_MinusTimes;
        private Object TS_SurplusTimes;
        private String VIP_FaceNumber;
        private String PayInfo;
        private int VCH_Fee;
        private double InitialAmount;
        private double InitialIntegral;
        private String Remark;
        private Object VIPAddress;
        private Object EMName;
        private Object IndividualHand;
        private List<GoodsListBean> GoodsList;

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

        public String getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(String OrderCode) {
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

        public double getHM_Money() {
            return HM_Money;
        }

        public void setHM_Money(double HM_Money) {
            this.HM_Money = HM_Money;
        }

        public Object getHM_Name() {
            return HM_Name;
        }

        public void setHM_Name(Object HM_Name) {
            this.HM_Name = HM_Name;
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

        public String getPayInfo() {
            return PayInfo;
        }

        public void setPayInfo(String PayInfo) {
            this.PayInfo = PayInfo;
        }

        public int getVCH_Fee() {
            return VCH_Fee;
        }

        public void setVCH_Fee(int VCH_Fee) {
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

        public Object getVIPAddress() {
            return VIPAddress;
        }

        public void setVIPAddress(Object VIPAddress) {
            this.VIPAddress = VIPAddress;
        }

        public Object getEMName() {
            return EMName;
        }

        public void setEMName(Object EMName) {
            this.EMName = EMName;
        }

        public Object getIndividualHand() {
            return IndividualHand;
        }

        public void setIndividualHand(Object IndividualHand) {
            this.IndividualHand = IndividualHand;
        }

        public List<GoodsListBean> getGoodsList() {
            return GoodsList;
        }

        public void setGoodsList(List<GoodsListBean> GoodsList) {
            this.GoodsList = GoodsList;
        }

        public static class GoodsListBean {
            /**
             * RO_Monetary : 14.0
             * PM_IsService : null
             * GID : a1d1d23d-ed42-4926-b454-ed737e845a0b
             * RO_GID : 1a8704a9-fc78-49d1-8433-3b5269304411
             * PM_GID : 7ace77f3-219b-4680-993f-ea1fc5e543bc
             * PM_Code : 10
             * PT_Name : 牙刷
             * PT_GID : 071014a5-c89b-409f-a31c-7b0b3dbb7b68
             * PM_Name : 1010
             * PM_BigImg : null
             * PM_SimpleCode : null
             * PM_Metering :
             * PM_UnitPrice : 10.0
             * PM_Detail : null
             * PM_Description : null
             * PM_Modle :
             * PM_Brand :
             * PM_Number : 1.0
             * PM_Discount : 1.0
             * ROD_DiscountPrice : 10.0
             * ROD_Integral : 0.0
             * ROD_Creator : 销售001
             * ROD_UpdateTime : 2019-04-08 15:16:59
             * CY_GID : null
             */

            private double RO_Monetary;
            private Object PM_IsService;
            private String GID;
            private String RO_GID;
            private String PM_GID;
            private String PM_Code;
            private String PT_Name;
            private String PT_GID;
            private String PM_Name;
            private Object PM_BigImg;
            private Object PM_SimpleCode;
            private String PM_Metering;
            private double PM_UnitPrice;
            private Object PM_Detail;
            private Object PM_Description;
            private String PM_Modle;
            private String PM_Brand;
            private double PM_Number;
            private double PM_Discount;
            private double ROD_DiscountPrice;
            private double ROD_Integral;
            private String ROD_Creator;
            private String ROD_UpdateTime;
            private Object CY_GID;

            public double getRO_Monetary() {
                return RO_Monetary;
            }

            public void setRO_Monetary(double RO_Monetary) {
                this.RO_Monetary = RO_Monetary;
            }

            public Object getPM_IsService() {
                return PM_IsService;
            }

            public void setPM_IsService(Object PM_IsService) {
                this.PM_IsService = PM_IsService;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getRO_GID() {
                return RO_GID;
            }

            public void setRO_GID(String RO_GID) {
                this.RO_GID = RO_GID;
            }

            public String getPM_GID() {
                return PM_GID;
            }

            public void setPM_GID(String PM_GID) {
                this.PM_GID = PM_GID;
            }

            public String getPM_Code() {
                return PM_Code;
            }

            public void setPM_Code(String PM_Code) {
                this.PM_Code = PM_Code;
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

            public String getPM_Name() {
                return PM_Name;
            }

            public void setPM_Name(String PM_Name) {
                this.PM_Name = PM_Name;
            }

            public Object getPM_BigImg() {
                return PM_BigImg;
            }

            public void setPM_BigImg(Object PM_BigImg) {
                this.PM_BigImg = PM_BigImg;
            }

            public Object getPM_SimpleCode() {
                return PM_SimpleCode;
            }

            public void setPM_SimpleCode(Object PM_SimpleCode) {
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

            public Object getPM_Detail() {
                return PM_Detail;
            }

            public void setPM_Detail(Object PM_Detail) {
                this.PM_Detail = PM_Detail;
            }

            public Object getPM_Description() {
                return PM_Description;
            }

            public void setPM_Description(Object PM_Description) {
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

            public double getPM_Number() {
                return PM_Number;
            }

            public void setPM_Number(double PM_Number) {
                this.PM_Number = PM_Number;
            }

            public double getPM_Discount() {
                return PM_Discount;
            }

            public void setPM_Discount(double PM_Discount) {
                this.PM_Discount = PM_Discount;
            }

            public double getROD_DiscountPrice() {
                return ROD_DiscountPrice;
            }

            public void setROD_DiscountPrice(double ROD_DiscountPrice) {
                this.ROD_DiscountPrice = ROD_DiscountPrice;
            }

            public double getROD_Integral() {
                return ROD_Integral;
            }

            public void setROD_Integral(double ROD_Integral) {
                this.ROD_Integral = ROD_Integral;
            }

            public String getROD_Creator() {
                return ROD_Creator;
            }

            public void setROD_Creator(String ROD_Creator) {
                this.ROD_Creator = ROD_Creator;
            }

            public String getROD_UpdateTime() {
                return ROD_UpdateTime;
            }

            public void setROD_UpdateTime(String ROD_UpdateTime) {
                this.ROD_UpdateTime = ROD_UpdateTime;
            }

            public Object getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(Object CY_GID) {
                this.CY_GID = CY_GID;
            }
        }
    }
}

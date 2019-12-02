package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/2 19:50
 * email：jasoncheng9111@gmail.com
 */
public class Print_JFDH_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"Cashier":"18986810706","CheckoutDate":"2017-08-02 19:27:21","OrderCode":"LP1708021927135535","ActivityName":null,"ActivityValue":null,"IntegralAdd":0,
     * "IntegralDeduct":0,"YSMoney":0,"SSMoney":0,"ZLMoney":0,"VCH_Card":"33","VIP_Name":"哈哈哈","VCH_Money":0,"VCH_Point":123928.2,"GoodsList":null,"ServiceList":null,
     * "GiftList":[{"GID":"a200f847-d247-4ffe-bb17-738c1d862ada","IEG_GID":"76357866-6ee6-4a7a-9774-c64e6659a94d","EGD_DateTime":"2017-08-02 19:27:21","GT_Name":"绿萝路",
     * "GM_Name":"哦哦哦","GM_Code":"003","GM_Acount":7,"GM_Integral":null,"GM_PictureUrl":null,"EGD_Score":0,"EGD_Creator":"18986810706","CY_GID":null,"EGD_UpdateTime":"2017-08-02
     * 19:27:21","GM_GID":null}],"ConsumeMoney":0,"Discount":0,"GiveMoney":0,"RechargeTotal":0,"ExchangeNum":7}
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
         * CheckoutDate : 2017-08-02 19:27:21
         * OrderCode : LP1708021927135535
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
         * ServiceList : null
         * GiftList : [{"GID":"a200f847-d247-4ffe-bb17-738c1d862ada","IEG_GID":"76357866-6ee6-4a7a-9774-c64e6659a94d","EGD_DateTime":"2017-08-02 19:27:21","GT_Name":"绿萝路",
         * "GM_Name":"哦哦哦","GM_Code":"003","GM_Acount":7,"GM_Integral":null,"GM_PictureUrl":null,"EGD_Score":0,"EGD_Creator":"18986810706","CY_GID":null,
         * "EGD_UpdateTime":"2017-08-02 19:27:21","GM_GID":null}]
         * ConsumeMoney : 0
         * Discount : 0
         * GiveMoney : 0
         * RechargeTotal : 0
         * ExchangeNum : 7
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
        private Object ServiceList;
        private double ConsumeMoney;
        private double Discount;
        private double GiveMoney;
        private double RechargeTotal;
        private int ExchangeNum;

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
        private List<GiftListBean> GiftList;

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

        public Object getServiceList() { return ServiceList;}

        public void setServiceList(Object ServiceList) { this.ServiceList = ServiceList;}

        public double getConsumeMoney() { return ConsumeMoney;}

        public void setConsumeMoney(double ConsumeMoney) { this.ConsumeMoney = ConsumeMoney;}

        public double getDiscount() { return Discount;}

        public void setDiscount(double Discount) { this.Discount = Discount;}

        public double getGiveMoney() { return GiveMoney;}

        public void setGiveMoney(double GiveMoney) { this.GiveMoney = GiveMoney;}

        public double getRechargeTotal() { return RechargeTotal;}

        public void setRechargeTotal(double RechargeTotal) { this.RechargeTotal = RechargeTotal;}

        public int getExchangeNum() { return ExchangeNum;}

        public void setExchangeNum(int ExchangeNum) { this.ExchangeNum = ExchangeNum;}

        public List<GiftListBean> getGiftList() { return GiftList;}

        public void setGiftList(List<GiftListBean> GiftList) { this.GiftList = GiftList;}

        public static class GiftListBean
        {
            /**
             * GID : a200f847-d247-4ffe-bb17-738c1d862ada
             * IEG_GID : 76357866-6ee6-4a7a-9774-c64e6659a94d
             * EGD_DateTime : 2017-08-02 19:27:21
             * GT_Name : 绿萝路
             * GM_Name : 哦哦哦
             * GM_Code : 003
             * GM_Acount : 7
             * GM_Integral : null
             * GM_PictureUrl : null
             * EGD_Score : 0
             * EGD_Creator : 18986810706
             * CY_GID : null
             * EGD_UpdateTime : 2017-08-02 19:27:21
             * GM_GID : null
             */

            private String GID;
            private String IEG_GID;
            private String EGD_DateTime;
            private String GT_Name;
            private String GM_Name;
            private String GM_Code;
            private int GM_Acount;
            private double GM_Integral;
            private Object GM_PictureUrl;
            private int EGD_Score;
            private String EGD_Creator;
            private Object CY_GID;
            private String EGD_UpdateTime;
            private Object GM_GID;

            public String getGID() { return GID;}

            public void setGID(String GID) { this.GID = GID;}

            public String getIEG_GID() { return IEG_GID;}

            public void setIEG_GID(String IEG_GID) { this.IEG_GID = IEG_GID;}

            public String getEGD_DateTime() { return EGD_DateTime;}

            public void setEGD_DateTime(String EGD_DateTime) { this.EGD_DateTime = EGD_DateTime;}

            public String getGT_Name() { return GT_Name;}

            public void setGT_Name(String GT_Name) { this.GT_Name = GT_Name;}

            public String getGM_Name() { return GM_Name;}

            public void setGM_Name(String GM_Name) { this.GM_Name = GM_Name;}

            public String getGM_Code() { return GM_Code;}

            public void setGM_Code(String GM_Code) { this.GM_Code = GM_Code;}

            public int getGM_Acount() { return GM_Acount;}

            public void setGM_Acount(int GM_Acount) { this.GM_Acount = GM_Acount;}

            public double getGM_Integral() { return GM_Integral;}

            public void setGM_Integral(double GM_Integral) { this.GM_Integral = GM_Integral;}

            public Object getGM_PictureUrl() { return GM_PictureUrl;}

            public void setGM_PictureUrl(Object GM_PictureUrl) { this.GM_PictureUrl = GM_PictureUrl;}

            public int getEGD_Score() { return EGD_Score;}

            public void setEGD_Score(int EGD_Score) { this.EGD_Score = EGD_Score;}

            public String getEGD_Creator() { return EGD_Creator;}

            public void setEGD_Creator(String EGD_Creator) { this.EGD_Creator = EGD_Creator;}

            public Object getCY_GID() { return CY_GID;}

            public void setCY_GID(Object CY_GID) { this.CY_GID = CY_GID;}

            public String getEGD_UpdateTime() { return EGD_UpdateTime;}

            public void setEGD_UpdateTime(String EGD_UpdateTime) { this.EGD_UpdateTime = EGD_UpdateTime;}

            public Object getGM_GID() { return GM_GID;}

            public void setGM_GID(Object GM_GID) { this.GM_GID = GM_GID;}
        }
    }
}

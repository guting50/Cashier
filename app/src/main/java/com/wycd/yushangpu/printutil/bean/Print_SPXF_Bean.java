package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/2 19:44
 * email：jasoncheng9111@gmail.com
 */
public class Print_SPXF_Bean {
    /**
     * Cashier : 18986810706
     * CheckoutDate : 2017-08-02 19:24:33
     * OrderCode : SP1708021924038808
     * ActivityName : null
     * ActivityValue :
     * IntegralAdd : 1210
     * IntegralDeduct : 0
     * YSMoney : 2621
     * SSMoney : 222222.23
     * ZLMoney : 219601.23
     * VCH_Card : 33
     * VIP_Name : 哈哈哈
     * VCH_Money : 0
     * VCH_Point : 123928.2
     * GoodsList : [{"EM_GIDList":null,"SumPrice":null,"GID":"20ab1cfd-21d3-4ba7-9731-90fedf3664b7","CO_GID":"fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea",
     * "PM_GID":"fa97dc4a-46d7-4084-b441-701e818a7f65","PM_Code":"A0001","PT_Name":"家电","PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PM_Name":"电饭煲","PM_SimpleCode":null,
     * "PM_Metering":null,"PM_UnitPrice":200,"PM_Detail":null,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,
     * "GOD_DiscountPrice":200,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:24:33","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},
     * {"EM_GIDList":null,"SumPrice":null,"GID":"28aeb943-e547-41a6-a124-218b93008330","CO_GID":"fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea",
     * "PM_GID":"2cb25227-ee4a-4383-8ff0-5a7a05305288","PM_Code":"A0004","PT_Name":"家电","PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PM_Name":"电冰箱","PM_SimpleCode":null,
     * "PM_Metering":null,"PM_UnitPrice":1999,"PM_Detail":null,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,
     * "GOD_DiscountPrice":1999,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:24:33","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},
     * {"EM_GIDList":null,"SumPrice":null,"GID":"4c4657a6-1028-43f0-b48b-9e8523a97b72","CO_GID":"fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea",
     * "PM_GID":"e17cc0d1-24de-4528-87e1-7075937e8507","PM_Code":"D0001","PT_Name":"运动户外","PT_GID":"e16a41d2-d421-4260-8d49-04807766447d","PM_Name":"登山鞋",
     * "PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":200,"PM_Detail":null,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,
     * "PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":200,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:24:33",
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},{"EM_GIDList":null,"SumPrice":null,"GID":"828dd9b4-7e2e-4e7c-831a-29b8740fcd4e",
     * "CO_GID":"fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea","PM_GID":"694856b9-3571-43d5-b7ae-c3afee9fbb22","PM_Code":"4444","PT_Name":"西点",
     * "PT_GID":"0385858e-e4d8-4101-924b-6f3a088e5be7","PM_Name":"波士顿派","PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":121,"PM_Detail":null,"PM_Description":null,
     * "PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":121,"GOD_Integral":1210,"GOD_Creator":"18986810706",
     * "GOD_UpdateTime":"2017-08-02 19:24:33","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},{"EM_GIDList":null,"SumPrice":null,
     * "GID":"9d68d138-af85-4aa4-a811-a6afcd228b48","CO_GID":"fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea","PM_GID":"57921384-2d76-4a8d-bcb4-d7870be1bb58","PM_Code":"A0003",
     * "PT_Name":"家电","PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PM_Name":"咖啡机","PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":101,"PM_Detail":null,
     * "PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":101,"GOD_Integral":0,
     * "GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-02 19:24:33","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"}]
     * ServiceList : null
     * GiftList : null
     * ConsumeMoney : 2621
     * Discount : 0
     * GiveMoney : 0
     * RechargeTotal : 0
     * ExchangeNum : 0
     */

    private String Cashier;
    private String CheckoutDate;
    private String OrderCode;
    private Object ActivityName;
    private String ActivityValue;
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
    private double Discount;
    private double GiveMoney;
    private double RechargeTotal;
    private double ExchangeNum;
    private String EMName;
    private String PayInfo;
    private List<GoodsListBean> GoodsList;

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

    public void setYSMoney(double YSMoney) {
        this.YSMoney = YSMoney;
    }

    public void setVCH_Money(double VCH_Money) {
        this.VCH_Money = VCH_Money;
    }

    public void setConsumeMoney(double consumeMoney) {
        ConsumeMoney = consumeMoney;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public void setGiveMoney(double giveMoney) {
        GiveMoney = giveMoney;
    }

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

    public String getActivityValue() {
        return ActivityValue;
    }

    public void setActivityValue(String ActivityValue) {
        this.ActivityValue = ActivityValue;
    }

    public double getIntegralAdd() {
        return IntegralAdd;
    }

    public void setIntegralAdd(int IntegralAdd) {
        this.IntegralAdd = IntegralAdd;
    }

    public double getIntegralDeduct() {
        return IntegralDeduct;
    }

    public void setIntegralDeduct(int IntegralDeduct) {
        this.IntegralDeduct = IntegralDeduct;
    }

    public double getYSMoney() {
        return YSMoney;
    }

    public void setYSMoney(int YSMoney) {
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

    public void setVCH_Money(int VCH_Money) {
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

    public void setConsumeMoney(int ConsumeMoney) {
        this.ConsumeMoney = ConsumeMoney;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public double getGiveMoney() {
        return GiveMoney;
    }

    public void setGiveMoney(int GiveMoney) {
        this.GiveMoney = GiveMoney;
    }

    public double getRechargeTotal() {
        return RechargeTotal;
    }

    public void setRechargeTotal(int RechargeTotal) {
        this.RechargeTotal = RechargeTotal;
    }

    public double getExchangeNum() {
        return ExchangeNum;
    }

    public void setExchangeNum(int ExchangeNum) {
        this.ExchangeNum = ExchangeNum;
    }

    public List<GoodsListBean> getGoodsList() {
        return GoodsList;
    }

    public void setGoodsList(List<GoodsListBean> GoodsList) {
        this.GoodsList = GoodsList;
    }

    public static class GoodsListBean {
        /**
         * EM_GIDList : null
         * SumPrice : null
         * GID : 20ab1cfd-21d3-4ba7-9731-90fedf3664b7
         * CO_GID : fb79749f-d5cd-4ac7-a1ab-8bbf277a6bea
         * PM_GID : fa97dc4a-46d7-4084-b441-701e818a7f65
         * PM_Code : A0001
         * PT_Name : 家电
         * PT_GID : a1ca7d48-7c54-42a2-80a3-ea03c560db5a
         * PM_Name : 电饭煲
         * PM_SimpleCode : null
         * PM_Metering : null
         * PM_UnitPrice : 200
         * PM_Detail : null
         * PM_Description : null
         * PM_Modle : null
         * PM_Brand : null
         * PM_Number : 1
         * PM_FixedIntegralValue : 0
         * PM_Discount : 1
         * GOD_DiscountPrice : 200
         * GOD_Integral : 0
         * GOD_Creator : 18986810706
         * GOD_UpdateTime : 2017-08-02 19:24:33
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
        private Object PM_SimpleCode;
        private Object PM_Metering;
        private double PM_UnitPrice;
        private Object PM_Detail;
        private Object PM_Description;
        private Object PM_Modle;
        private Object PM_Brand;
        private double PM_Number;
        private double PM_FixedIntegralValue;
        private double PM_Discount;
        private double GOD_DiscountPrice;
        private double GOD_Integral;
        private String GOD_Creator;
        private String GOD_UpdateTime;
        private String CY_GID;

        public Object getEM_GIDList() {
            return EM_GIDList;
        }

        public void setEM_GIDList(Object EM_GIDList) {
            this.EM_GIDList = EM_GIDList;
        }

        public Object getSumPrice() {
            return SumPrice;
        }

        public void setSumPrice(Object SumPrice) {
            this.SumPrice = SumPrice;
        }

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

        public Object getPM_SimpleCode() {
            return PM_SimpleCode;
        }

        public void setPM_SimpleCode(Object PM_SimpleCode) {
            this.PM_SimpleCode = PM_SimpleCode;
        }

        public Object getPM_Metering() {
            return PM_Metering;
        }

        public void setPM_Metering(Object PM_Metering) {
            this.PM_Metering = PM_Metering;
        }

        public double getPM_UnitPrice() {
            return PM_UnitPrice;
        }

        public void setPM_UnitPrice(int PM_UnitPrice) {
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

        public Object getPM_Modle() {
            return PM_Modle;
        }

        public void setPM_Modle(Object PM_Modle) {
            this.PM_Modle = PM_Modle;
        }

        public Object getPM_Brand() {
            return PM_Brand;
        }

        public void setPM_Brand(Object PM_Brand) {
            this.PM_Brand = PM_Brand;
        }

        public double getPM_Number() {
            return PM_Number;
        }

        public void setPM_Number(double PM_Number) {
            this.PM_Number = PM_Number;
        }

        public double getPM_FixedIntegralValue() {
            return PM_FixedIntegralValue;
        }

        public void setPM_FixedIntegralValue(int PM_FixedIntegralValue) {
            this.PM_FixedIntegralValue = PM_FixedIntegralValue;
        }

        public double getPM_Discount() {
            return PM_Discount;
        }

        public void setPM_Discount(int PM_Discount) {
            this.PM_Discount = PM_Discount;
        }

        public double getGOD_DiscountPrice() {
            return GOD_DiscountPrice;
        }

        public void setGOD_DiscountPrice(int GOD_DiscountPrice) {
            this.GOD_DiscountPrice = GOD_DiscountPrice;
        }

        public double getGOD_Integral() {
            return GOD_Integral;
        }

        public void setGOD_Integral(int GOD_Integral) {
            this.GOD_Integral = GOD_Integral;
        }

        public String getGOD_Creator() {
            return GOD_Creator;
        }

        public void setGOD_Creator(String GOD_Creator) {
            this.GOD_Creator = GOD_Creator;
        }

        public String getGOD_UpdateTime() {
            return GOD_UpdateTime;
        }

        public void setGOD_UpdateTime(String GOD_UpdateTime) {
            this.GOD_UpdateTime = GOD_UpdateTime;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }
    }


}

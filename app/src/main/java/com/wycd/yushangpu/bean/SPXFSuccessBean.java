package com.wycd.yushangpu.bean;

import java.util.List;

/**
 * 商品消费 成功 后的jsonb
 * iauthor：Cheng
 * date: 2017/8/3 10:06
 * email：jasoncheng9111@gmail.com
 */
public class SPXFSuccessBean {
    /**
     * GoodsOrderDetailList : [{"EM_GIDList":null,"SumPrice":null,"GID":"764cfdb1-ac91-4350-a5d2-d123dfc23e8c","CO_GID":"59c62acb-c83c-482e-95b9-4c438b97e8a0",
     * "PM_GID":"e17cc0d1-24de-4528-87e1-7075937e8507","PM_Code":"D0001","PT_Name":"运动户外","PT_GID":"e16a41d2-d421-4260-8d49-04807766447d","PM_Name":"登山鞋",
     * "PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":200,"PM_Detail":null,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":2,
     * "PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":200,"GOD_Integral":0,"GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-03 10:06:26",
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},{"EM_GIDList":null,"SumPrice":null,"GID":"b70caed3-6171-45b5-aa7a-81240f1996e2",
     * "CO_GID":"59c62acb-c83c-482e-95b9-4c438b97e8a0","PM_GID":"fa97dc4a-46d7-4084-b441-701e818a7f65","PM_Code":"A0001","PT_Name":"家电",
     * "PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PM_Name":"电饭煲","PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":200,"PM_Detail":null,"PM_Description":null,
     * "PM_Modle":null,"PM_Brand":null,"PM_Number":2,"PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":200,"GOD_Integral":0,"GOD_Creator":"18986810706",
     * "GOD_UpdateTime":"2017-08-03 10:06:26","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},{"EM_GIDList":null,"SumPrice":null,
     * "GID":"b34e38b3-f88b-44c3-aa3f-e7b08aa48c40","CO_GID":"59c62acb-c83c-482e-95b9-4c438b97e8a0","PM_GID":"694856b9-3571-43d5-b7ae-c3afee9fbb22","PM_Code":"4444",
     * "PT_Name":"西点","PT_GID":"0385858e-e4d8-4101-924b-6f3a088e5be7","PM_Name":"波士顿派","PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":121,"PM_Detail":null,
     * "PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":121,"GOD_Integral":1210,
     * "GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-03 10:06:26","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"},{"EM_GIDList":null,"SumPrice":null,
     * "GID":"2395d6b6-b1bf-4e97-9c60-bb64d2c6c727","CO_GID":"59c62acb-c83c-482e-95b9-4c438b97e8a0","PM_GID":"57921384-2d76-4a8d-bcb4-d7870be1bb58","PM_Code":"A0003",
     * "PT_Name":"家电","PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PM_Name":"咖啡机","PM_SimpleCode":null,"PM_Metering":null,"PM_UnitPrice":101,"PM_Detail":null,
     * "PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_FixedIntegralValue":0,"PM_Discount":1,"GOD_DiscountPrice":101,"GOD_Integral":0,
     * "GOD_Creator":"18986810706","GOD_UpdateTime":"2017-08-03 10:06:26","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4"}]
     * Goods : [{"EM_GIDList":null,"PM_GID":"e17cc0d1-24de-4528-87e1-7075937e8507","PM_Code":"D0001","PT_GID":"e16a41d2-d421-4260-8d49-04807766447d","PT_Name":"运动户外",
     * "PM_Name":"登山鞋","PM_Metering":null,"PM_SimpleCode":null,"PM_UnitPrice":200,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":2,"PM_ReallyPrice":null,
     * "PM_SpecialOfferValue":0,"PM_MinDisCountValue":0,"PM_FixedIntegralValue":0},{"EM_GIDList":null,"PM_GID":"fa97dc4a-46d7-4084-b441-701e818a7f65","PM_Code":"A0001",
     * "PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PT_Name":"家电","PM_Name":"电饭煲","PM_Metering":null,"PM_SimpleCode":null,"PM_UnitPrice":200,"PM_Description":null,
     * "PM_Modle":null,"PM_Brand":null,"PM_Number":2,"PM_ReallyPrice":null,"PM_SpecialOfferValue":0,"PM_MinDisCountValue":0,"PM_FixedIntegralValue":0},{"EM_GIDList":null,
     * "PM_GID":"694856b9-3571-43d5-b7ae-c3afee9fbb22","PM_Code":"4444","PT_GID":"0385858e-e4d8-4101-924b-6f3a088e5be7","PT_Name":"西点","PM_Name":"波士顿派","PM_Metering":null,
     * "PM_SimpleCode":null,"PM_UnitPrice":121,"PM_Description":null,"PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_ReallyPrice":null,"PM_SpecialOfferValue":0,
     * "PM_MinDisCountValue":0,"PM_FixedIntegralValue":0},{"EM_GIDList":null,"PM_GID":"57921384-2d76-4a8d-bcb4-d7870be1bb58","PM_Code":"A0003",
     * "PT_GID":"a1ca7d48-7c54-42a2-80a3-ea03c560db5a","PT_Name":"家电","PM_Name":"咖啡机","PM_Metering":null,"PM_SimpleCode":null,"PM_UnitPrice":101,"PM_Description":null,
     * "PM_Modle":null,"PM_Brand":null,"PM_Number":1,"PM_ReallyPrice":null,"PM_SpecialOfferValue":0,"PM_MinDisCountValue":0,"PM_FixedIntegralValue":0}]
     * CC_GID :
     * EM_GIDList : null
     * PayTypeList : [{"PayCode":"XJZF","PayName":"现金支付","PayMoney":1022,"PayPoint":null}]
     * PayPoint : 0
     * DisMoney : 1022
     * VCH_Money : 0
     * VCH_Point : 0
     * IS_Sms : true
     * CO_SSMoney : 123123
     * CO_ZLMoney : 122101
     * CO_ActivityName : null
     * CO_ActivityValue :
     * CO_Discount : null
     * GID : 59c62acb-c83c-482e-95b9-4c438b97e8a0
     * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
     * VIP_Card : 33
     * VIP_Name : 哈哈哈
     * VIP_Phone : 18888888888
     * VIP_FaceNumber :
     * CO_OrderCode : SP1708031006144902
     * CO_ConsumeWay : 现金(1022)
     * CO_WayCode : XJZF
     * CO_Monetary : 1022
     * CO_TotalPrice : 1022
     * CO_Integral : 1210
     * CO_BalanceCard : 0
     * CO_Type : 商品消费
     * CO_TypeCode : SPXF
     * CO_CommissionAmount : 0
     * CO_Remark :
     * CO_Creator : 18986810706
     * CO_UpdateTime : 2017-08-03 10:06:26
     * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
     * SM_GID : bfb6cf66-cf97-4239-bb1e-bece3a86d09f
     * SM_Name : Tokyo Hot
     * SM_Contacter : 小田伽椰子
     * SM_Phone : 18866866668
     * SM_Addr :
     * CO_Identifying : 正常
     * CO_IdentifyingState : 2
     * CO_OrderState : null
     * CO_StateValue : null
     * CO_Device : 0
     */

    private String CC_GID;
    private Object EM_GIDList;
    private double PayPoint;
    private double DisMoney;
    private double VCH_Money;
    private double VCH_Point;
    private boolean IS_Sms;
    private double CO_SSMoney;
    private double CO_ZLMoney;
    private Object CO_ActivityName;
    private String CO_ActivityValue;
    private Object CO_Discount;
    private String GID;
    private String VIP_GID;
    private String VIP_Card;
    private String VIP_Name;
    private String VIP_Phone;
    private String VIP_FaceNumber;
    private String CO_OrderCode;
    private String CO_ConsumeWay;
    private String CO_WayCode;
    private double CO_Monetary;
    private double CO_TotalPrice;
    private double CO_Integral;
    private double CO_BalanceCard;
    private String CO_Type;
    private String CO_TypeCode;
    private double CO_CommissionAmount;
    private String CO_Remark;
    private String CO_Creator;
    private String CO_UpdateTime;
    private String CY_GID;
    private String SM_GID;
    private String SM_Name;
    private String SM_Contacter;
    private String SM_Phone;
    private String SM_Addr;
    private String CO_Identifying;
    private int CO_IdentifyingState;
    private Object CO_OrderState;
    private Object CO_StateValue;
    private int CO_Device;
    private List<GoodsOrderDetailListBean> GoodsOrderDetailList;
    private List<GoodsBean> Goods;
    private List<PayTypeListBean> PayTypeList;

    public String getCC_GID() {
        return CC_GID;
    }

    public void setCC_GID(String CC_GID) {
        this.CC_GID = CC_GID;
    }

    public Object getEM_GIDList() {
        return EM_GIDList;
    }

    public void setEM_GIDList(Object EM_GIDList) {
        this.EM_GIDList = EM_GIDList;
    }

    public double getPayPoint() {
        return PayPoint;
    }

    public void setPayPoint(double PayPoint) {
        this.PayPoint = PayPoint;
    }

    public double getDisMoney() {
        return DisMoney;
    }

    public void setDisMoney(double DisMoney) {
        this.DisMoney = DisMoney;
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

    public boolean isIS_Sms() {
        return IS_Sms;
    }

    public void setIS_Sms(boolean IS_Sms) {
        this.IS_Sms = IS_Sms;
    }

    public double getCO_SSMoney() {
        return CO_SSMoney;
    }

    public void setCO_SSMoney(double CO_SSMoney) {
        this.CO_SSMoney = CO_SSMoney;
    }

    public double getCO_ZLMoney() {
        return CO_ZLMoney;
    }

    public void setCO_ZLMoney(double CO_ZLMoney) {
        this.CO_ZLMoney = CO_ZLMoney;
    }

    public Object getCO_ActivityName() {
        return CO_ActivityName;
    }

    public void setCO_ActivityName(Object CO_ActivityName) {
        this.CO_ActivityName = CO_ActivityName;
    }

    public String getCO_ActivityValue() {
        return CO_ActivityValue;
    }

    public void setCO_ActivityValue(String CO_ActivityValue) {
        this.CO_ActivityValue = CO_ActivityValue;
    }

    public Object getCO_Discount() {
        return CO_Discount;
    }

    public void setCO_Discount(Object CO_Discount) {
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

    public String getCO_WayCode() {
        return CO_WayCode;
    }

    public void setCO_WayCode(String CO_WayCode) {
        this.CO_WayCode = CO_WayCode;
    }

    public double getCO_Monetary() {
        return CO_Monetary;
    }

    public void setCO_Monetary(double CO_Monetary) {
        this.CO_Monetary = CO_Monetary;
    }

    public double getCO_TotalPrice() {
        return CO_TotalPrice;
    }

    public void setCO_TotalPrice(double CO_TotalPrice) {
        this.CO_TotalPrice = CO_TotalPrice;
    }

    public double getCO_Integral() {
        return CO_Integral;
    }

    public void setCO_Integral(double CO_Integral) {
        this.CO_Integral = CO_Integral;
    }

    public double getCO_BalanceCard() {
        return CO_BalanceCard;
    }

    public void setCO_BalanceCard(int CO_BalanceCard) {
        this.CO_BalanceCard = CO_BalanceCard;
    }

    public String getCO_Type() {
        return CO_Type;
    }

    public void setCO_Type(String CO_Type) {
        this.CO_Type = CO_Type;
    }

    public String getCO_TypeCode() {
        return CO_TypeCode;
    }

    public void setCO_TypeCode(String CO_TypeCode) {
        this.CO_TypeCode = CO_TypeCode;
    }

    public double getCO_CommissionAmount() {
        return CO_CommissionAmount;
    }

    public void setCO_CommissionAmount(double CO_CommissionAmount) {
        this.CO_CommissionAmount = CO_CommissionAmount;
    }

    public String getCO_Remark() {
        return CO_Remark;
    }

    public void setCO_Remark(String CO_Remark) {
        this.CO_Remark = CO_Remark;
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

    public String getSM_Contacter() {
        return SM_Contacter;
    }

    public void setSM_Contacter(String SM_Contacter) {
        this.SM_Contacter = SM_Contacter;
    }

    public String getSM_Phone() {
        return SM_Phone;
    }

    public void setSM_Phone(String SM_Phone) {
        this.SM_Phone = SM_Phone;
    }

    public String getSM_Addr() {
        return SM_Addr;
    }

    public void setSM_Addr(String SM_Addr) {
        this.SM_Addr = SM_Addr;
    }

    public String getCO_Identifying() {
        return CO_Identifying;
    }

    public void setCO_Identifying(String CO_Identifying) {
        this.CO_Identifying = CO_Identifying;
    }

    public int getCO_IdentifyingState() {
        return CO_IdentifyingState;
    }

    public void setCO_IdentifyingState(int CO_IdentifyingState) {
        this.CO_IdentifyingState = CO_IdentifyingState;
    }

    public Object getCO_OrderState() {
        return CO_OrderState;
    }

    public void setCO_OrderState(Object CO_OrderState) {
        this.CO_OrderState = CO_OrderState;
    }

    public Object getCO_StateValue() {
        return CO_StateValue;
    }

    public void setCO_StateValue(Object CO_StateValue) {
        this.CO_StateValue = CO_StateValue;
    }

    public int getCO_Device() {
        return CO_Device;
    }

    public void setCO_Device(int CO_Device) {
        this.CO_Device = CO_Device;
    }

    public List<GoodsOrderDetailListBean> getGoodsOrderDetailList() {
        return GoodsOrderDetailList;
    }

    public void setGoodsOrderDetailList(List<GoodsOrderDetailListBean> GoodsOrderDetailList) {
        this.GoodsOrderDetailList = GoodsOrderDetailList;
    }

    public List<GoodsBean> getGoods() {
        return Goods;
    }

    public void setGoods(List<GoodsBean> Goods) {
        this.Goods = Goods;
    }

    public List<PayTypeListBean> getPayTypeList() {
        return PayTypeList;
    }

    public void setPayTypeList(List<PayTypeListBean> PayTypeList) {
        this.PayTypeList = PayTypeList;
    }

    public static class GoodsOrderDetailListBean {
        /**
         * EM_GIDList : null
         * SumPrice : null
         * GID : 764cfdb1-ac91-4350-a5d2-d123dfc23e8c
         * CO_GID : 59c62acb-c83c-482e-95b9-4c438b97e8a0
         * PM_GID : e17cc0d1-24de-4528-87e1-7075937e8507
         * PM_Code : D0001
         * PT_Name : 运动户外
         * PT_GID : e16a41d2-d421-4260-8d49-04807766447d
         * PM_Name : 登山鞋
         * PM_SimpleCode : null
         * PM_Metering : null
         * PM_UnitPrice : 200
         * PM_Detail : null
         * PM_Description : null
         * PM_Modle : null
         * PM_Brand : null
         * PM_Number : 2
         * PM_FixedIntegralValue : 0
         * PM_Discount : 1
         * GOD_DiscountPrice : 200
         * GOD_Integral : 0
         * GOD_Creator : 18986810706
         * GOD_UpdateTime : 2017-08-03 10:06:26
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
        private int PM_Number;
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

        public int getPM_Number() {
            return PM_Number;
        }

        public void setPM_Number(int PM_Number) {
            this.PM_Number = PM_Number;
        }

        public double getPM_FixedIntegralValue() {
            return PM_FixedIntegralValue;
        }

        public void setPM_FixedIntegralValue(double PM_FixedIntegralValue) {
            this.PM_FixedIntegralValue = PM_FixedIntegralValue;
        }

        public double getPM_Discount() {
            return PM_Discount;
        }

        public void setPM_Discount(double PM_Discount) {
            this.PM_Discount = PM_Discount;
        }

        public double getGOD_DiscountPrice() {
            return GOD_DiscountPrice;
        }

        public void setGOD_DiscountPrice(double GOD_DiscountPrice) {
            this.GOD_DiscountPrice = GOD_DiscountPrice;
        }

        public double getGOD_Integral() {
            return GOD_Integral;
        }

        public void setGOD_Integral(double GOD_Integral) {
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

    public static class GoodsBean {
        /**
         * EM_GIDList : null
         * PM_GID : e17cc0d1-24de-4528-87e1-7075937e8507
         * PM_Code : D0001
         * PT_GID : e16a41d2-d421-4260-8d49-04807766447d
         * PT_Name : 运动户外
         * PM_Name : 登山鞋
         * PM_Metering : null
         * PM_SimpleCode : null
         * PM_UnitPrice : 200
         * PM_Description : null
         * PM_Modle : null
         * PM_Brand : null
         * PM_Number : 2
         * PM_ReallyPrice : null
         * PM_SpecialOfferValue : 0
         * PM_MinDisCountValue : 0
         * PM_FixedIntegralValue : 0
         */

        private Object EM_GIDList;
        private String PM_GID;
        private String PM_Code;
        private String PT_GID;
        private String PT_Name;
        private String PM_Name;
        private Object PM_Metering;
        private Object PM_SimpleCode;
        private double PM_UnitPrice;
        private Object PM_Description;
        private Object PM_Modle;
        private Object PM_Brand;
        private int PM_Number;
        private Object PM_ReallyPrice;
        private double PM_SpecialOfferValue;
        private double PM_MinDisCountValue;
        private double PM_FixedIntegralValue;

        public Object getEM_GIDList() {
            return EM_GIDList;
        }

        public void setEM_GIDList(Object EM_GIDList) {
            this.EM_GIDList = EM_GIDList;
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

        public String getPM_Name() {
            return PM_Name;
        }

        public void setPM_Name(String PM_Name) {
            this.PM_Name = PM_Name;
        }

        public Object getPM_Metering() {
            return PM_Metering;
        }

        public void setPM_Metering(Object PM_Metering) {
            this.PM_Metering = PM_Metering;
        }

        public Object getPM_SimpleCode() {
            return PM_SimpleCode;
        }

        public void setPM_SimpleCode(Object PM_SimpleCode) {
            this.PM_SimpleCode = PM_SimpleCode;
        }

        public double getPM_UnitPrice() {
            return PM_UnitPrice;
        }

        public void setPM_UnitPrice(double PM_UnitPrice) {
            this.PM_UnitPrice = PM_UnitPrice;
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

        public int getPM_Number() {
            return PM_Number;
        }

        public void setPM_Number(int PM_Number) {
            this.PM_Number = PM_Number;
        }

        public Object getPM_ReallyPrice() {
            return PM_ReallyPrice;
        }

        public void setPM_ReallyPrice(Object PM_ReallyPrice) {
            this.PM_ReallyPrice = PM_ReallyPrice;
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
    }

    public static class PayTypeListBean {
        /**
         * PayCode : XJZF
         * PayName : 现金支付
         * PayMoney : 1022
         * PayPoint : null
         */

        private String PayCode;
        private String PayName;
        private double PayMoney;
        private Object PayPoint;

        public String getPayCode() {
            return PayCode;
        }

        public void setPayCode(String PayCode) {
            this.PayCode = PayCode;
        }

        public String getPayName() {
            return PayName;
        }

        public void setPayName(String PayName) {
            this.PayName = PayName;
        }

        public double getPayMoney() {
            return PayMoney;
        }

        public void setPayMoney(double PayMoney) {
            this.PayMoney = PayMoney;
        }

        public Object getPayPoint() {
            return PayPoint;
        }

        public void setPayPoint(Object PayPoint) {
            this.PayPoint = PayPoint;
        }
    }
}

package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * 快速消费 消费成功后的 jsonbean
 * iauthor：Cheng
 * date: 2017/8/3 09:56
 * email：jasoncheng9111@gmail.com
 */
public class KSXF_Success_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"GoodsOrderDetailList":null,"Goods":null,"CC_GID":"","EM_GIDList":null,"PayTypeList":[{"PayCode":"XJZF","PayName":"现金支付","PayMoney":123,"PayPoint":null}],
     * "PayPoint":0,"DisMoney":123,"VCH_Money":0,"VCH_Point":0,"IS_Sms":true,"CO_SSMoney":12312,"CO_ZLMoney":12189,"CO_ActivityName":null,"CO_ActivityValue":"","CO_Discount":1,
     * "GID":"bf52ebbd-a383-4e2c-88fe-4ffbbd06faa6","VIP_GID":"1d681028-b086-45bd-845b-3a538c1b3f4c","VIP_Card":"33","VIP_Name":"哈哈哈","VIP_Phone":"18888888888",
     * "VIP_FaceNumber":"","CO_OrderCode":"KS1708030951277058","CO_ConsumeWay":"现金(123)","CO_WayCode":"XJZF","CO_Monetary":123,"CO_TotalPrice":123,"CO_Integral":1230,
     * "CO_BalanceCard":0,"CO_Type":"快速消费","CO_TypeCode":"KSXF","CO_CommissionAmount":null,"CO_Remark":"","CO_Creator":"18986810706","CO_UpdateTime":"2017-08-03 09:51:34",
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","SM_GID":"bfb6cf66-cf97-4239-bb1e-bece3a86d09f","SM_Name":"Tokyo Hot","SM_Contacter":"小田伽椰子","SM_Phone":"18866866668",
     * "SM_Addr":"","CO_Identifying":"正常","CO_IdentifyingState":2,"CO_OrderState":null,"CO_StateValue":null,"CO_Device":0}
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
         * GoodsOrderDetailList : null
         * Goods : null
         * CC_GID :
         * EM_GIDList : null
         * PayTypeList : [{"PayCode":"XJZF","PayName":"现金支付","PayMoney":123,"PayPoint":null}]
         * PayPoint : 0
         * DisMoney : 123
         * VCH_Money : 0
         * VCH_Point : 0
         * IS_Sms : true
         * CO_SSMoney : 12312
         * CO_ZLMoney : 12189
         * CO_ActivityName : null
         * CO_ActivityValue :
         * CO_Discount : 1
         * GID : bf52ebbd-a383-4e2c-88fe-4ffbbd06faa6
         * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
         * VIP_Card : 33
         * VIP_Name : 哈哈哈
         * VIP_Phone : 18888888888
         * VIP_FaceNumber :
         * CO_OrderCode : KS1708030951277058
         * CO_ConsumeWay : 现金(123)
         * CO_WayCode : XJZF
         * CO_Monetary : 123
         * CO_TotalPrice : 123
         * CO_Integral : 1230
         * CO_BalanceCard : 0
         * CO_Type : 快速消费
         * CO_TypeCode : KSXF
         * CO_CommissionAmount : null
         * CO_Remark :
         * CO_Creator : 18986810706
         * CO_UpdateTime : 2017-08-03 09:51:34
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

        private Object GoodsOrderDetailList;
        private Object Goods;
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
        private double CO_Discount;
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
        private Object CO_CommissionAmount;
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
        private List<PayTypeListBean> PayTypeList;

        public Object getGoodsOrderDetailList() { return GoodsOrderDetailList;}

        public void setGoodsOrderDetailList(Object GoodsOrderDetailList) { this.GoodsOrderDetailList = GoodsOrderDetailList;}

        public Object getGoods() { return Goods;}

        public void setGoods(Object Goods) { this.Goods = Goods;}

        public String getCC_GID() { return CC_GID;}

        public void setCC_GID(String CC_GID) { this.CC_GID = CC_GID;}

        public Object getEM_GIDList() { return EM_GIDList;}

        public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

        public double getPayPoint() { return PayPoint;}

        public void setPayPoint(double PayPoint) { this.PayPoint = PayPoint;}

        public double getDisMoney() { return DisMoney;}

        public void setDisMoney(double DisMoney) { this.DisMoney = DisMoney;}

        public double getVCH_Money() { return VCH_Money;}

        public void setVCH_Money(double VCH_Money) { this.VCH_Money = VCH_Money;}

        public double getVCH_Point() { return VCH_Point;}

        public void setVCH_Point(double VCH_Point) { this.VCH_Point = VCH_Point;}

        public boolean isIS_Sms() { return IS_Sms;}

        public void setIS_Sms(boolean IS_Sms) { this.IS_Sms = IS_Sms;}

        public double getCO_SSMoney() { return CO_SSMoney;}

        public void setCO_SSMoney(double CO_SSMoney) { this.CO_SSMoney = CO_SSMoney;}

        public double getCO_ZLMoney() { return CO_ZLMoney;}

        public void setCO_ZLMoney(double CO_ZLMoney) { this.CO_ZLMoney = CO_ZLMoney;}

        public Object getCO_ActivityName() { return CO_ActivityName;}

        public void setCO_ActivityName(Object CO_ActivityName) { this.CO_ActivityName = CO_ActivityName;}

        public String getCO_ActivityValue() { return CO_ActivityValue;}

        public void setCO_ActivityValue(String CO_ActivityValue) { this.CO_ActivityValue = CO_ActivityValue;}

        public double getCO_Discount() { return CO_Discount;}

        public void setCO_Discount(double CO_Discount) { this.CO_Discount = CO_Discount;}

        public String getGID() { return GID;}

        public void setGID(String GID) { this.GID = GID;}

        public String getVIP_GID() { return VIP_GID;}

        public void setVIP_GID(String VIP_GID) { this.VIP_GID = VIP_GID;}

        public String getVIP_Card() { return VIP_Card;}

        public void setVIP_Card(String VIP_Card) { this.VIP_Card = VIP_Card;}

        public String getVIP_Name() { return VIP_Name;}

        public void setVIP_Name(String VIP_Name) { this.VIP_Name = VIP_Name;}

        public String getVIP_Phone() { return VIP_Phone;}

        public void setVIP_Phone(String VIP_Phone) { this.VIP_Phone = VIP_Phone;}

        public String getVIP_FaceNumber() { return VIP_FaceNumber;}

        public void setVIP_FaceNumber(String VIP_FaceNumber) { this.VIP_FaceNumber = VIP_FaceNumber;}

        public String getCO_OrderCode() { return CO_OrderCode;}

        public void setCO_OrderCode(String CO_OrderCode) { this.CO_OrderCode = CO_OrderCode;}

        public String getCO_ConsumeWay() { return CO_ConsumeWay;}

        public void setCO_ConsumeWay(String CO_ConsumeWay) { this.CO_ConsumeWay = CO_ConsumeWay;}

        public String getCO_WayCode() { return CO_WayCode;}

        public void setCO_WayCode(String CO_WayCode) { this.CO_WayCode = CO_WayCode;}

        public double getCO_Monetary() { return CO_Monetary;}

        public void setCO_Monetary(double CO_Monetary) { this.CO_Monetary = CO_Monetary;}

        public double getCO_TotalPrice() { return CO_TotalPrice;}

        public void setCO_TotalPrice(double CO_TotalPrice) { this.CO_TotalPrice = CO_TotalPrice;}

        public double getCO_Integral() { return CO_Integral;}

        public void setCO_Integral(double CO_Integral) { this.CO_Integral = CO_Integral;}

        public double getCO_BalanceCard() { return CO_BalanceCard;}

        public void setCO_BalanceCard(double CO_BalanceCard) { this.CO_BalanceCard = CO_BalanceCard;}

        public String getCO_Type() { return CO_Type;}

        public void setCO_Type(String CO_Type) { this.CO_Type = CO_Type;}

        public String getCO_TypeCode() { return CO_TypeCode;}

        public void setCO_TypeCode(String CO_TypeCode) { this.CO_TypeCode = CO_TypeCode;}

        public Object getCO_CommissionAmount() { return CO_CommissionAmount;}

        public void setCO_CommissionAmount(Object CO_CommissionAmount) { this.CO_CommissionAmount = CO_CommissionAmount;}

        public String getCO_Remark() { return CO_Remark;}

        public void setCO_Remark(String CO_Remark) { this.CO_Remark = CO_Remark;}

        public String getCO_Creator() { return CO_Creator;}

        public void setCO_Creator(String CO_Creator) { this.CO_Creator = CO_Creator;}

        public String getCO_UpdateTime() { return CO_UpdateTime;}

        public void setCO_UpdateTime(String CO_UpdateTime) { this.CO_UpdateTime = CO_UpdateTime;}

        public String getCY_GID() { return CY_GID;}

        public void setCY_GID(String CY_GID) { this.CY_GID = CY_GID;}

        public String getSM_GID() { return SM_GID;}

        public void setSM_GID(String SM_GID) { this.SM_GID = SM_GID;}

        public String getSM_Name() { return SM_Name;}

        public void setSM_Name(String SM_Name) { this.SM_Name = SM_Name;}

        public String getSM_Contacter() { return SM_Contacter;}

        public void setSM_Contacter(String SM_Contacter) { this.SM_Contacter = SM_Contacter;}

        public String getSM_Phone() { return SM_Phone;}

        public void setSM_Phone(String SM_Phone) { this.SM_Phone = SM_Phone;}

        public String getSM_Addr() { return SM_Addr;}

        public void setSM_Addr(String SM_Addr) { this.SM_Addr = SM_Addr;}

        public String getCO_Identifying() { return CO_Identifying;}

        public void setCO_Identifying(String CO_Identifying) { this.CO_Identifying = CO_Identifying;}

        public int getCO_IdentifyingState() { return CO_IdentifyingState;}

        public void setCO_IdentifyingState(int CO_IdentifyingState) { this.CO_IdentifyingState = CO_IdentifyingState;}

        public Object getCO_OrderState() { return CO_OrderState;}

        public void setCO_OrderState(Object CO_OrderState) { this.CO_OrderState = CO_OrderState;}

        public Object getCO_StateValue() { return CO_StateValue;}

        public void setCO_StateValue(Object CO_StateValue) { this.CO_StateValue = CO_StateValue;}

        public int getCO_Device() { return CO_Device;}

        public void setCO_Device(int CO_Device) { this.CO_Device = CO_Device;}

        public List<PayTypeListBean> getPayTypeList() { return PayTypeList;}

        public void setPayTypeList(List<PayTypeListBean> PayTypeList) { this.PayTypeList = PayTypeList;}

        public static class PayTypeListBean
        {
            /**
             * PayCode : XJZF
             * PayName : 现金支付
             * PayMoney : 123
             * PayPoint : null
             */

            private String PayCode;
            private String PayName;
            private double PayMoney;
            private Object PayPoint;

            public String getPayCode() { return PayCode;}

            public void setPayCode(String PayCode) { this.PayCode = PayCode;}

            public String getPayName() { return PayName;}

            public void setPayName(String PayName) { this.PayName = PayName;}

            public double getPayMoney() { return PayMoney;}

            public void setPayMoney(double PayMoney) { this.PayMoney = PayMoney;}

            public Object getPayPoint() { return PayPoint;}

            public void setPayPoint(Object PayPoint) { this.PayPoint = PayPoint;}
        }
    }
}

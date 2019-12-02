package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/3 12:49
 * email：jasoncheng9111@gmail.com
 */
public class HYCC_Success_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"MC_IdentifyingState":0,"EM_GIDList":null,"PayTypeList":[{"PayCode":"XJZF","PayName":"现金支付","PayMoney":20012,"PayPoint":null},{"PayCode":"YEZF","PayName":"余额支付",
     * "PayMoney":210,"PayPoint":null}],"DisMoney":20222,"PayPoint":0,"VCH_Card":"33","IS_Sms":true,"ServeceList":[{"EM_GIDList":null,
     * "PM_GID":"79c4644b-df87-41bc-9b33-4300b931e848","PM_Name":"23232","PM_Number":2},{"EM_GIDList":null,"PM_GID":"a6ad3cdb-b0eb-4592-b2b2-0a7894dd379c","PM_Name":"ff",
     * "PM_Number":4}],"MC_YSMoney":20222,"MC_SSMoney":20222,"MC_ZLMoney":0,"SG_Name":null,"MC_Discount":null,"MC_ServiceName":null,"MC_Price":null,
     * "GID":"936700d0-95a5-47bc-939c-4c227128d901","SM_GID":"bfb6cf66-cf97-4239-bb1e-bece3a86d09f","SG_GID":null,"VIP_GID":"1d681028-b086-45bd-845b-3a538c1b3f4c",
     * "MC_Order":"CC1708041440133829","MC_Way":"现金(20012),余额(210)","MC_Code":"XJZF,YEZF","MC_Amount":20444,"MC_AmountDis":20222,"MC_Number":6,"MC_Integral":22200,
     * "MC_ChargeTime":"2017-08-04 14:40:23","MC_Declare":null,"MC_Identifying":null,"MC_Remark":"","MC_Creator":"18986810706","MC_UpdateTime":null,
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","MC_Device":0}
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
         * MC_IdentifyingState : 0
         * EM_GIDList : null
         * PayTypeList : [{"PayCode":"XJZF","PayName":"现金支付","PayMoney":20012,"PayPoint":null},{"PayCode":"YEZF","PayName":"余额支付","PayMoney":210,"PayPoint":null}]
         * DisMoney : 20222
         * PayPoint : 0
         * VCH_Card : 33
         * IS_Sms : true
         * ServeceList : [{"EM_GIDList":null,"PM_GID":"79c4644b-df87-41bc-9b33-4300b931e848","PM_Name":"23232","PM_Number":2},{"EM_GIDList":null,
         * "PM_GID":"a6ad3cdb-b0eb-4592-b2b2-0a7894dd379c","PM_Name":"ff","PM_Number":4}]
         * MC_YSMoney : 20222
         * MC_SSMoney : 20222
         * MC_ZLMoney : 0
         * SG_Name : null
         * MC_Discount : null
         * MC_ServiceName : null
         * MC_Price : null
         * GID : 936700d0-95a5-47bc-939c-4c227128d901
         * SM_GID : bfb6cf66-cf97-4239-bb1e-bece3a86d09f
         * SG_GID : null
         * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
         * MC_Order : CC1708041440133829
         * MC_Way : 现金(20012),余额(210)
         * MC_Code : XJZF,YEZF
         * MC_Amount : 20444
         * MC_AmountDis : 20222
         * MC_Number : 6
         * MC_Integral : 22200
         * MC_ChargeTime : 2017-08-04 14:40:23
         * MC_Declare : null
         * MC_Identifying : null
         * MC_Remark :
         * MC_Creator : 18986810706
         * MC_UpdateTime : null
         * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
         * MC_Device : 0
         */

        private int MC_IdentifyingState;
        private Object EM_GIDList;
        private double DisMoney;
        private double PayPoint;
        private String VCH_Card;
        private boolean IS_Sms;
        private double MC_YSMoney;
        private double MC_SSMoney;
        private double MC_ZLMoney;
        private Object SG_Name;
        private Object MC_Discount;
        private Object MC_ServiceName;
        private Object MC_Price;
        private String GID;
        private String SM_GID;
        private Object SG_GID;
        private String VIP_GID;
        private String MC_Order;
        private String MC_Way;
        private String MC_Code;
        private double MC_Amount;
        private double MC_AmountDis;
        private int MC_Number;
        private double MC_Integral;
        private String MC_ChargeTime;
        private Object MC_Declare;
        private Object MC_Identifying;
        private String MC_Remark;
        private String MC_Creator;
        private Object MC_UpdateTime;
        private String CY_GID;
        private int MC_Device;
        private List<PayTypeListBean> PayTypeList;
        private List<ServeceListBean> ServeceList;

        public int getMC_IdentifyingState() { return MC_IdentifyingState;}

        public void setMC_IdentifyingState(int MC_IdentifyingState) { this.MC_IdentifyingState = MC_IdentifyingState;}

        public Object getEM_GIDList() { return EM_GIDList;}

        public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

        public double getDisMoney() { return DisMoney;}

        public void setDisMoney(double DisMoney) { this.DisMoney = DisMoney;}

        public double getPayPoint() { return PayPoint;}

        public void setPayPoint(double PayPoint) { this.PayPoint = PayPoint;}

        public String getVCH_Card() { return VCH_Card;}

        public void setVCH_Card(String VCH_Card) { this.VCH_Card = VCH_Card;}

        public boolean isIS_Sms() { return IS_Sms;}

        public void setIS_Sms(boolean IS_Sms) { this.IS_Sms = IS_Sms;}

        public double getMC_YSMoney() { return MC_YSMoney;}

        public void setMC_YSMoney(double MC_YSMoney) { this.MC_YSMoney = MC_YSMoney;}

        public double getMC_SSMoney() { return MC_SSMoney;}

        public void setMC_SSMoney(double MC_SSMoney) { this.MC_SSMoney = MC_SSMoney;}

        public double getMC_ZLMoney() { return MC_ZLMoney;}

        public void setMC_ZLMoney(double MC_ZLMoney) { this.MC_ZLMoney = MC_ZLMoney;}

        public Object getSG_Name() { return SG_Name;}

        public void setSG_Name(Object SG_Name) { this.SG_Name = SG_Name;}

        public Object getMC_Discount() { return MC_Discount;}

        public void setMC_Discount(Object MC_Discount) { this.MC_Discount = MC_Discount;}

        public Object getMC_ServiceName() { return MC_ServiceName;}

        public void setMC_ServiceName(Object MC_ServiceName) { this.MC_ServiceName = MC_ServiceName;}

        public Object getMC_Price() { return MC_Price;}

        public void setMC_Price(Object MC_Price) { this.MC_Price = MC_Price;}

        public String getGID() { return GID;}

        public void setGID(String GID) { this.GID = GID;}

        public String getSM_GID() { return SM_GID;}

        public void setSM_GID(String SM_GID) { this.SM_GID = SM_GID;}

        public Object getSG_GID() { return SG_GID;}

        public void setSG_GID(Object SG_GID) { this.SG_GID = SG_GID;}

        public String getVIP_GID() { return VIP_GID;}

        public void setVIP_GID(String VIP_GID) { this.VIP_GID = VIP_GID;}

        public String getMC_Order() { return MC_Order;}

        public void setMC_Order(String MC_Order) { this.MC_Order = MC_Order;}

        public String getMC_Way() { return MC_Way;}

        public void setMC_Way(String MC_Way) { this.MC_Way = MC_Way;}

        public String getMC_Code() { return MC_Code;}

        public void setMC_Code(String MC_Code) { this.MC_Code = MC_Code;}

        public double getMC_Amount() { return MC_Amount;}

        public void setMC_Amount(double MC_Amount) { this.MC_Amount = MC_Amount;}

        public double getMC_AmountDis() { return MC_AmountDis;}

        public void setMC_AmountDis(double MC_AmountDis) { this.MC_AmountDis = MC_AmountDis;}

        public int getMC_Number() { return MC_Number;}

        public void setMC_Number(int MC_Number) { this.MC_Number = MC_Number;}

        public double getMC_Integral() { return MC_Integral;}

        public void setMC_Integral(double MC_Integral) { this.MC_Integral = MC_Integral;}

        public String getMC_ChargeTime() { return MC_ChargeTime;}

        public void setMC_ChargeTime(String MC_ChargeTime) { this.MC_ChargeTime = MC_ChargeTime;}

        public Object getMC_Declare() { return MC_Declare;}

        public void setMC_Declare(Object MC_Declare) { this.MC_Declare = MC_Declare;}

        public Object getMC_Identifying() { return MC_Identifying;}

        public void setMC_Identifying(Object MC_Identifying) { this.MC_Identifying = MC_Identifying;}

        public String getMC_Remark() { return MC_Remark;}

        public void setMC_Remark(String MC_Remark) { this.MC_Remark = MC_Remark;}

        public String getMC_Creator() { return MC_Creator;}

        public void setMC_Creator(String MC_Creator) { this.MC_Creator = MC_Creator;}

        public Object getMC_UpdateTime() { return MC_UpdateTime;}

        public void setMC_UpdateTime(Object MC_UpdateTime) { this.MC_UpdateTime = MC_UpdateTime;}

        public String getCY_GID() { return CY_GID;}

        public void setCY_GID(String CY_GID) { this.CY_GID = CY_GID;}

        public int getMC_Device() { return MC_Device;}

        public void setMC_Device(int MC_Device) { this.MC_Device = MC_Device;}

        public List<PayTypeListBean> getPayTypeList() { return PayTypeList;}

        public void setPayTypeList(List<PayTypeListBean> PayTypeList) { this.PayTypeList = PayTypeList;}

        public List<ServeceListBean> getServeceList() { return ServeceList;}

        public void setServeceList(List<ServeceListBean> ServeceList) { this.ServeceList = ServeceList;}

        public static class PayTypeListBean
        {
            /**
             * PayCode : XJZF
             * PayName : 现金支付
             * PayMoney : 20012
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

        public static class ServeceListBean
        {
            /**
             * EM_GIDList : null
             * PM_GID : 79c4644b-df87-41bc-9b33-4300b931e848
             * PM_Name : 23232
             * PM_Number : 2
             */

            private Object EM_GIDList;
            private String PM_GID;
            private String PM_Name;
            private int PM_Number;

            public Object getEM_GIDList() { return EM_GIDList;}

            public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

            public String getPM_GID() { return PM_GID;}

            public void setPM_GID(String PM_GID) { this.PM_GID = PM_GID;}

            public String getPM_Name() { return PM_Name;}

            public void setPM_Name(String PM_Name) { this.PM_Name = PM_Name;}

            public int getPM_Number() { return PM_Number;}

            public void setPM_Number(int PM_Number) { this.PM_Number = PM_Number;}
        }
    }
}

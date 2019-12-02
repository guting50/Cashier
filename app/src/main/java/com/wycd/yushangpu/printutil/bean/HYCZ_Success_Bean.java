package com.wycd.yushangpu.printutil.bean;

/**
 * 会员充值  成功后的 jsonbean
 * iauthor：Cheng
 * date: 2017/8/3 10:16
 * email：jasoncheng9111@gmail.com
 */
public class HYCZ_Success_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"EM_GIDList":null,"MR_IdentifyingState":0,"PayTypeList":null,"DisMoney":0,"PayPoint":0,"CC_GID":null,"VCH_Card":null,"IS_Sms":false,"MR_SSMoney":232323,
     * "MR_ZLMoney":231212,"MR_ActivityName":null,"MR_ActivityValue":null,"VIP_Name":null,"VIP_CellPhone":null,"GID":"6c3388cf-4f26-4454-962f-6b172425f1bb","SM_GID":null,
     * "VIP_GID":"1d681028-b086-45bd-845b-3a538c1b3f4c","MR_Order":"CZ1708031012155857","MR_Way":"现金(1111)","MR_Code":null,"MR_Amount":1111,"MR_GivenAmount":0,"MR_Integral":0,
     * "MR_Total":1111,"MR_PrepaidTime":"2017-08-03 10:13:49","MA_AvailableBalance":null,"MI_Number":null,"MR_Declare":null,"MR_Identifying":null,"MR_Remark":"",
     * "MR_Creator":"18986810706","MR_UpdateTime":"2017-08-03 10:13:49","CY_GID":null,"MR_Device":null}
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
         * EM_GIDList : null
         * MR_IdentifyingState : 0
         * PayTypeList : null
         * DisMoney : 0
         * PayPoint : 0
         * CC_GID : null
         * VCH_Card : null
         * IS_Sms : false
         * MR_SSMoney : 232323
         * MR_ZLMoney : 231212
         * MR_ActivityName : null
         * MR_ActivityValue : null
         * VIP_Name : null
         * VIP_CellPhone : null
         * GID : 6c3388cf-4f26-4454-962f-6b172425f1bb
         * SM_GID : null
         * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
         * MR_Order : CZ1708031012155857
         * MR_Way : 现金(1111)
         * MR_Code : null
         * MR_Amount : 1111
         * MR_GivenAmount : 0
         * MR_Integral : 0
         * MR_Total : 1111
         * MR_PrepaidTime : 2017-08-03 10:13:49
         * MA_AvailableBalance : null
         * MI_Number : null
         * MR_Declare : null
         * MR_Identifying : null
         * MR_Remark :
         * MR_Creator : 18986810706
         * MR_UpdateTime : 2017-08-03 10:13:49
         * CY_GID : null
         * MR_Device : null
         */

        private Object EM_GIDList;
        private int MR_IdentifyingState;
        private Object PayTypeList;
        private double DisMoney;
        private double PayPoint;
        private Object CC_GID;
        private Object VCH_Card;
        private boolean IS_Sms;
        private double MR_SSMoney;
        private double MR_ZLMoney;
        private Object MR_ActivityName;
        private Object MR_ActivityValue;
        private Object VIP_Name;
        private Object VIP_CellPhone;
        private String GID;
        private Object SM_GID;
        private String VIP_GID;
        private String MR_Order;
        private String MR_Way;
        private Object MR_Code;
        private double MR_Amount;
        private double MR_GivenAmount;
        private double MR_Integral;
        private double MR_Total;
        private String MR_PrepaidTime;
        private Object MA_AvailableBalance;
        private Object MI_Number;
        private Object MR_Declare;
        private Object MR_Identifying;
        private String MR_Remark;
        private String MR_Creator;
        private String MR_UpdateTime;
        private Object CY_GID;
        private Object MR_Device;

        public Object getEM_GIDList() { return EM_GIDList;}

        public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

        public int getMR_IdentifyingState() { return MR_IdentifyingState;}

        public void setMR_IdentifyingState(int MR_IdentifyingState) { this.MR_IdentifyingState = MR_IdentifyingState;}

        public Object getPayTypeList() { return PayTypeList;}

        public void setPayTypeList(Object PayTypeList) { this.PayTypeList = PayTypeList;}

        public double getDisMoney() { return DisMoney;}

        public void setDisMoney(double DisMoney) { this.DisMoney = DisMoney;}

        public double getPayPoint() { return PayPoint;}

        public void setPayPoint(double PayPoint) { this.PayPoint = PayPoint;}

        public Object getCC_GID() { return CC_GID;}

        public void setCC_GID(Object CC_GID) { this.CC_GID = CC_GID;}

        public Object getVCH_Card() { return VCH_Card;}

        public void setVCH_Card(Object VCH_Card) { this.VCH_Card = VCH_Card;}

        public boolean isIS_Sms() { return IS_Sms;}

        public void setIS_Sms(boolean IS_Sms) { this.IS_Sms = IS_Sms;}

        public double getMR_SSMoney() { return MR_SSMoney;}

        public void setMR_SSMoney(double MR_SSMoney) { this.MR_SSMoney = MR_SSMoney;}

        public double getMR_ZLMoney() { return MR_ZLMoney;}

        public void setMR_ZLMoney(double MR_ZLMoney) { this.MR_ZLMoney = MR_ZLMoney;}

        public Object getMR_ActivityName() { return MR_ActivityName;}

        public void setMR_ActivityName(Object MR_ActivityName) { this.MR_ActivityName = MR_ActivityName;}

        public Object getMR_ActivityValue() { return MR_ActivityValue;}

        public void setMR_ActivityValue(Object MR_ActivityValue) { this.MR_ActivityValue = MR_ActivityValue;}

        public Object getVIP_Name() { return VIP_Name;}

        public void setVIP_Name(Object VIP_Name) { this.VIP_Name = VIP_Name;}

        public Object getVIP_CellPhone() { return VIP_CellPhone;}

        public void setVIP_CellPhone(Object VIP_CellPhone) { this.VIP_CellPhone = VIP_CellPhone;}

        public String getGID() { return GID;}

        public void setGID(String GID) { this.GID = GID;}

        public Object getSM_GID() { return SM_GID;}

        public void setSM_GID(Object SM_GID) { this.SM_GID = SM_GID;}

        public String getVIP_GID() { return VIP_GID;}

        public void setVIP_GID(String VIP_GID) { this.VIP_GID = VIP_GID;}

        public String getMR_Order() { return MR_Order;}

        public void setMR_Order(String MR_Order) { this.MR_Order = MR_Order;}

        public String getMR_Way() { return MR_Way;}

        public void setMR_Way(String MR_Way) { this.MR_Way = MR_Way;}

        public Object getMR_Code() { return MR_Code;}

        public void setMR_Code(Object MR_Code) { this.MR_Code = MR_Code;}

        public double getMR_Amount() { return MR_Amount;}

        public void setMR_Amount(double MR_Amount) { this.MR_Amount = MR_Amount;}

        public double getMR_GivenAmount() { return MR_GivenAmount;}

        public void setMR_GivenAmount(double MR_GivenAmount) { this.MR_GivenAmount = MR_GivenAmount;}

        public double getMR_Integral() { return MR_Integral;}

        public void setMR_Integral(double MR_Integral) { this.MR_Integral = MR_Integral;}

        public double getMR_Total() { return MR_Total;}

        public void setMR_Total(double MR_Total) { this.MR_Total = MR_Total;}

        public String getMR_PrepaidTime() { return MR_PrepaidTime;}

        public void setMR_PrepaidTime(String MR_PrepaidTime) { this.MR_PrepaidTime = MR_PrepaidTime;}

        public Object getMA_AvailableBalance() { return MA_AvailableBalance;}

        public void setMA_AvailableBalance(Object MA_AvailableBalance) { this.MA_AvailableBalance = MA_AvailableBalance;}

        public Object getMI_Number() { return MI_Number;}

        public void setMI_Number(Object MI_Number) { this.MI_Number = MI_Number;}

        public Object getMR_Declare() { return MR_Declare;}

        public void setMR_Declare(Object MR_Declare) { this.MR_Declare = MR_Declare;}

        public Object getMR_Identifying() { return MR_Identifying;}

        public void setMR_Identifying(Object MR_Identifying) { this.MR_Identifying = MR_Identifying;}

        public String getMR_Remark() { return MR_Remark;}

        public void setMR_Remark(String MR_Remark) { this.MR_Remark = MR_Remark;}

        public String getMR_Creator() { return MR_Creator;}

        public void setMR_Creator(String MR_Creator) { this.MR_Creator = MR_Creator;}

        public String getMR_UpdateTime() { return MR_UpdateTime;}

        public void setMR_UpdateTime(String MR_UpdateTime) { this.MR_UpdateTime = MR_UpdateTime;}

        public Object getCY_GID() { return CY_GID;}

        public void setCY_GID(Object CY_GID) { this.CY_GID = CY_GID;}

        public Object getMR_Device() { return MR_Device;}

        public void setMR_Device(Object MR_Device) { this.MR_Device = MR_Device;}
    }
}

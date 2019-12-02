package com.wycd.yushangpu.printutil.bean;

/**
 * Created by YSL on 2018-10-09.
 */

public class HYKK_Success_Bean {


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"FildsId":null,"FildsValue":null,"VIP_RegSource":2,"EM_Name":"","VIP_OpenID":null,"EM_GIDList":null,"VIP_IsLunarCalendar":0,"VIP_InterCalaryMonth":0,"GID":"40a0ee0a-5935-48df-ba45-9eeb480eba85","VG_GID":"532f5734-6923-4255-8e1a-68c2b2e3ccf5","VT_Code":"IntegerCard","VIP_Name":"芡粉","VIP_CellPhone":"15598465461","VIP_Birthday":null,"VIP_Email":null,"VIP_ICCard":null,"VIP_Creator":"qijian","VIP_CreatorGID":"f55dd4a4-d811-466e-a742-96fbe61332bd","EM_ID":"","VIP_Overdue":null,"VIP_IsForver":1,"VIP_State":0,"VIP_Sex":0,"VIP_FixedPhone":"","VIP_UpdateTime":"2018-10-09 15:05:36","VIP_Referee":null,"VIP_FaceNumber":"","VIP_Remark":null,"CY_GID":"e6f9eab1-ebd0-4544-a246-d2e0f836d3f9","VIP_HeadPicture":null,"SM_ID":"08cbc7f8-999e-4432-920c-7b6d79877995","VIP_IsDeleted":0,"VIP_Percent":0,"VCH_Card":"6545","VCH_Fee":10,"VCH_Fee_PayType":"XJZF","VCH_Fee_PayTypeText":"现金支付","VCH_Pwd":"123456","VIP_Addr":null,"VIP_HeadImg":"/img/nohead.png","VIP_Label":"[]","MA_AggregateAmount":0,"MA_AvailableIntegral":10,"VCH_CreateTime":null,"VT_Name":null,"IS_Sms":true,"VIP_LabelList":null}
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
         * FildsId : null
         * FildsValue : null
         * VIP_RegSource : 2
         * EM_Name :
         * VIP_OpenID : null
         * EM_GIDList : null
         * VIP_IsLunarCalendar : 0
         * VIP_InterCalaryMonth : 0
         * GID : 40a0ee0a-5935-48df-ba45-9eeb480eba85
         * VG_GID : 532f5734-6923-4255-8e1a-68c2b2e3ccf5
         * VT_Code : IntegerCard
         * VIP_Name : 芡粉
         * VIP_CellPhone : 15598465461
         * VIP_Birthday : null
         * VIP_Email : null
         * VIP_ICCard : null
         * VIP_Creator : qijian
         * VIP_CreatorGID : f55dd4a4-d811-466e-a742-96fbe61332bd
         * EM_ID :
         * VIP_Overdue : null
         * VIP_IsForver : 1
         * VIP_State : 0
         * VIP_Sex : 0
         * VIP_FixedPhone :
         * VIP_UpdateTime : 2018-10-09 15:05:36
         * VIP_Referee : null
         * VIP_FaceNumber :
         * VIP_Remark : null
         * CY_GID : e6f9eab1-ebd0-4544-a246-d2e0f836d3f9
         * VIP_HeadPicture : null
         * SM_ID : 08cbc7f8-999e-4432-920c-7b6d79877995
         * VIP_IsDeleted : 0
         * VIP_Percent : 0
         * VCH_Card : 6545
         * VCH_Fee : 10
         * VCH_Fee_PayType : XJZF
         * VCH_Fee_PayTypeText : 现金支付
         * VCH_Pwd : 123456
         * VIP_Addr : null
         * VIP_HeadImg : /img/nohead.png
         * VIP_Label : []
         * MA_AggregateAmount : 0.0
         * MA_AvailableIntegral : 10.0
         * VCH_CreateTime : null
         * VT_Name : null
         * IS_Sms : true
         * VIP_LabelList : null
         */

        private Object FildsId;
        private Object FildsValue;
        private int VIP_RegSource;
        private String EM_Name;
        private Object VIP_OpenID;
        private Object EM_GIDList;
        private int VIP_IsLunarCalendar;
        private int VIP_InterCalaryMonth;
        private String GID;
        private String VG_GID;
        private String VT_Code;
        private String VIP_Name;
        private String VIP_CellPhone;
        private Object VIP_Birthday;
        private Object VIP_Email;
        private Object VIP_ICCard;
        private String VIP_Creator;
        private String VIP_CreatorGID;
        private String EM_ID;
        private Object VIP_Overdue;
        private int VIP_IsForver;
        private int VIP_State;
        private int VIP_Sex;
        private String VIP_FixedPhone;
        private String VIP_UpdateTime;
        private Object VIP_Referee;
        private String VIP_FaceNumber;
        private Object VIP_Remark;
        private String CY_GID;
        private Object VIP_HeadPicture;
        private String SM_ID;
        private int VIP_IsDeleted;
        private int VIP_Percent;
        private String VCH_Card;
        private int VCH_Fee;
        private String VCH_Fee_PayType;
        private String VCH_Fee_PayTypeText;
        private String VCH_Pwd;
        private Object VIP_Addr;
        private String VIP_HeadImg;
        private String VIP_Label;
        private double MA_AggregateAmount;
        private double MA_AvailableIntegral;
        private Object VCH_CreateTime;
        private Object VT_Name;
        private boolean IS_Sms;
        private Object VIP_LabelList;

        public Object getFildsId() {
            return FildsId;
        }

        public void setFildsId(Object FildsId) {
            this.FildsId = FildsId;
        }

        public Object getFildsValue() {
            return FildsValue;
        }

        public void setFildsValue(Object FildsValue) {
            this.FildsValue = FildsValue;
        }

        public int getVIP_RegSource() {
            return VIP_RegSource;
        }

        public void setVIP_RegSource(int VIP_RegSource) {
            this.VIP_RegSource = VIP_RegSource;
        }

        public String getEM_Name() {
            return EM_Name;
        }

        public void setEM_Name(String EM_Name) {
            this.EM_Name = EM_Name;
        }

        public Object getVIP_OpenID() {
            return VIP_OpenID;
        }

        public void setVIP_OpenID(Object VIP_OpenID) {
            this.VIP_OpenID = VIP_OpenID;
        }

        public Object getEM_GIDList() {
            return EM_GIDList;
        }

        public void setEM_GIDList(Object EM_GIDList) {
            this.EM_GIDList = EM_GIDList;
        }

        public int getVIP_IsLunarCalendar() {
            return VIP_IsLunarCalendar;
        }

        public void setVIP_IsLunarCalendar(int VIP_IsLunarCalendar) {
            this.VIP_IsLunarCalendar = VIP_IsLunarCalendar;
        }

        public int getVIP_InterCalaryMonth() {
            return VIP_InterCalaryMonth;
        }

        public void setVIP_InterCalaryMonth(int VIP_InterCalaryMonth) {
            this.VIP_InterCalaryMonth = VIP_InterCalaryMonth;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getVG_GID() {
            return VG_GID;
        }

        public void setVG_GID(String VG_GID) {
            this.VG_GID = VG_GID;
        }

        public String getVT_Code() {
            return VT_Code;
        }

        public void setVT_Code(String VT_Code) {
            this.VT_Code = VT_Code;
        }

        public String getVIP_Name() {
            return VIP_Name;
        }

        public void setVIP_Name(String VIP_Name) {
            this.VIP_Name = VIP_Name;
        }

        public String getVIP_CellPhone() {
            return VIP_CellPhone;
        }

        public void setVIP_CellPhone(String VIP_CellPhone) {
            this.VIP_CellPhone = VIP_CellPhone;
        }

        public Object getVIP_Birthday() {
            return VIP_Birthday;
        }

        public void setVIP_Birthday(Object VIP_Birthday) {
            this.VIP_Birthday = VIP_Birthday;
        }

        public Object getVIP_Email() {
            return VIP_Email;
        }

        public void setVIP_Email(Object VIP_Email) {
            this.VIP_Email = VIP_Email;
        }

        public Object getVIP_ICCard() {
            return VIP_ICCard;
        }

        public void setVIP_ICCard(Object VIP_ICCard) {
            this.VIP_ICCard = VIP_ICCard;
        }

        public String getVIP_Creator() {
            return VIP_Creator;
        }

        public void setVIP_Creator(String VIP_Creator) {
            this.VIP_Creator = VIP_Creator;
        }

        public String getVIP_CreatorGID() {
            return VIP_CreatorGID;
        }

        public void setVIP_CreatorGID(String VIP_CreatorGID) {
            this.VIP_CreatorGID = VIP_CreatorGID;
        }

        public String getEM_ID() {
            return EM_ID;
        }

        public void setEM_ID(String EM_ID) {
            this.EM_ID = EM_ID;
        }

        public Object getVIP_Overdue() {
            return VIP_Overdue;
        }

        public void setVIP_Overdue(Object VIP_Overdue) {
            this.VIP_Overdue = VIP_Overdue;
        }

        public int getVIP_IsForver() {
            return VIP_IsForver;
        }

        public void setVIP_IsForver(int VIP_IsForver) {
            this.VIP_IsForver = VIP_IsForver;
        }

        public int getVIP_State() {
            return VIP_State;
        }

        public void setVIP_State(int VIP_State) {
            this.VIP_State = VIP_State;
        }

        public int getVIP_Sex() {
            return VIP_Sex;
        }

        public void setVIP_Sex(int VIP_Sex) {
            this.VIP_Sex = VIP_Sex;
        }

        public String getVIP_FixedPhone() {
            return VIP_FixedPhone;
        }

        public void setVIP_FixedPhone(String VIP_FixedPhone) {
            this.VIP_FixedPhone = VIP_FixedPhone;
        }

        public String getVIP_UpdateTime() {
            return VIP_UpdateTime;
        }

        public void setVIP_UpdateTime(String VIP_UpdateTime) {
            this.VIP_UpdateTime = VIP_UpdateTime;
        }

        public Object getVIP_Referee() {
            return VIP_Referee;
        }

        public void setVIP_Referee(Object VIP_Referee) {
            this.VIP_Referee = VIP_Referee;
        }

        public String getVIP_FaceNumber() {
            return VIP_FaceNumber;
        }

        public void setVIP_FaceNumber(String VIP_FaceNumber) {
            this.VIP_FaceNumber = VIP_FaceNumber;
        }

        public Object getVIP_Remark() {
            return VIP_Remark;
        }

        public void setVIP_Remark(Object VIP_Remark) {
            this.VIP_Remark = VIP_Remark;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public Object getVIP_HeadPicture() {
            return VIP_HeadPicture;
        }

        public void setVIP_HeadPicture(Object VIP_HeadPicture) {
            this.VIP_HeadPicture = VIP_HeadPicture;
        }

        public String getSM_ID() {
            return SM_ID;
        }

        public void setSM_ID(String SM_ID) {
            this.SM_ID = SM_ID;
        }

        public int getVIP_IsDeleted() {
            return VIP_IsDeleted;
        }

        public void setVIP_IsDeleted(int VIP_IsDeleted) {
            this.VIP_IsDeleted = VIP_IsDeleted;
        }

        public int getVIP_Percent() {
            return VIP_Percent;
        }

        public void setVIP_Percent(int VIP_Percent) {
            this.VIP_Percent = VIP_Percent;
        }

        public String getVCH_Card() {
            return VCH_Card;
        }

        public void setVCH_Card(String VCH_Card) {
            this.VCH_Card = VCH_Card;
        }

        public int getVCH_Fee() {
            return VCH_Fee;
        }

        public void setVCH_Fee(int VCH_Fee) {
            this.VCH_Fee = VCH_Fee;
        }

        public String getVCH_Fee_PayType() {
            return VCH_Fee_PayType;
        }

        public void setVCH_Fee_PayType(String VCH_Fee_PayType) {
            this.VCH_Fee_PayType = VCH_Fee_PayType;
        }

        public String getVCH_Fee_PayTypeText() {
            return VCH_Fee_PayTypeText;
        }

        public void setVCH_Fee_PayTypeText(String VCH_Fee_PayTypeText) {
            this.VCH_Fee_PayTypeText = VCH_Fee_PayTypeText;
        }

        public String getVCH_Pwd() {
            return VCH_Pwd;
        }

        public void setVCH_Pwd(String VCH_Pwd) {
            this.VCH_Pwd = VCH_Pwd;
        }

        public Object getVIP_Addr() {
            return VIP_Addr;
        }

        public void setVIP_Addr(Object VIP_Addr) {
            this.VIP_Addr = VIP_Addr;
        }

        public String getVIP_HeadImg() {
            return VIP_HeadImg;
        }

        public void setVIP_HeadImg(String VIP_HeadImg) {
            this.VIP_HeadImg = VIP_HeadImg;
        }

        public String getVIP_Label() {
            return VIP_Label;
        }

        public void setVIP_Label(String VIP_Label) {
            this.VIP_Label = VIP_Label;
        }

        public double getMA_AggregateAmount() {
            return MA_AggregateAmount;
        }

        public void setMA_AggregateAmount(double MA_AggregateAmount) {
            this.MA_AggregateAmount = MA_AggregateAmount;
        }

        public double getMA_AvailableIntegral() {
            return MA_AvailableIntegral;
        }

        public void setMA_AvailableIntegral(double MA_AvailableIntegral) {
            this.MA_AvailableIntegral = MA_AvailableIntegral;
        }

        public Object getVCH_CreateTime() {
            return VCH_CreateTime;
        }

        public void setVCH_CreateTime(Object VCH_CreateTime) {
            this.VCH_CreateTime = VCH_CreateTime;
        }

        public Object getVT_Name() {
            return VT_Name;
        }

        public void setVT_Name(Object VT_Name) {
            this.VT_Name = VT_Name;
        }

        public boolean isIS_Sms() {
            return IS_Sms;
        }

        public void setIS_Sms(boolean IS_Sms) {
            this.IS_Sms = IS_Sms;
        }

        public Object getVIP_LabelList() {
            return VIP_LabelList;
        }

        public void setVIP_LabelList(Object VIP_LabelList) {
            this.VIP_LabelList = VIP_LabelList;
        }
    }
}

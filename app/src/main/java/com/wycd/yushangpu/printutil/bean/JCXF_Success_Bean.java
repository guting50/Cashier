package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/3 10:42
 * email：jasoncheng9111@gmail.com
 */
public class JCXF_Success_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","VIP_GID":"1d681028-b086-45bd-845b-3a538c1b3f4c","VIP_Card":"33","VIP_Name":"哈哈哈","VIP_Phone":"18888888888",
     * "VIP_FaceNumber":"","WO_OrderCode":"JC1708031041257987","WO_Remark":"","WO_Creator":"18986810706","WO_UpdateTime":"2017-08-03 10:41:30",
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","SM_GID":"bfb6cf66-cf97-4239-bb1e-bece3a86d09f","SM_Name":"Tokyo Hot","SM_Contacter":"小田伽椰子","SM_Phone":"18866866668",
     * "SM_Addr":"","wouldOrderDetail":[{"EM_GIDList":null,"GID":"2e8ab074-60ac-4774-b326-9a834bcec2df","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":4,
     * "WOD_ResidueDegree":42,"SG_GID":"1fa64f93-6634-443f-9d52-3ca279af610f","SG_Code":null,"SGC_Name":"啦咯啦咯啦咯啦咯啦","SG_Name":"啦咯啦咯啦咯啦咯啦","SG_Price":1,"SG_Abstract":null,
     * "SG_Detail":null,"CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"},{"EM_GIDList":null,
     * "GID":"62f51237-d4c6-4c7a-b5d1-6749ab5f2ad0","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":1,"WOD_ResidueDegree":12,
     * "SG_GID":"a6ad3cdb-b0eb-4592-b2b2-0a7894dd379c","SG_Code":"2222","SGC_Name":"ff","SG_Name":"ff","SG_Price":111,"SG_Abstract":null,"SG_Detail":null,
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"},{"EM_GIDList":null,
     * "GID":"826ad67d-a811-45aa-acca-1fcdfe07d43e","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":2,"WOD_ResidueDegree":17,
     * "SG_GID":"79c4644b-df87-41bc-9b33-4300b931e848","SG_Code":"232323","SGC_Name":"23232","SG_Name":"23232","SG_Price":10000,"SG_Abstract":null,"SG_Detail":null,
     * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"}],"IS_Sms":true,"WO_Device":"0"}
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
         * GID : c4d0ec45-9efe-4c31-859d-0bcebc198f05
         * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
         * VIP_Card : 33
         * VIP_Name : 哈哈哈
         * VIP_Phone : 18888888888
         * VIP_FaceNumber :
         * WO_OrderCode : JC1708031041257987
         * WO_Remark :
         * WO_Creator : 18986810706
         * WO_UpdateTime : 2017-08-03 10:41:30
         * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
         * SM_GID : bfb6cf66-cf97-4239-bb1e-bece3a86d09f
         * SM_Name : Tokyo Hot
         * SM_Contacter : 小田伽椰子
         * SM_Phone : 18866866668
         * SM_Addr :
         * wouldOrderDetail : [{"EM_GIDList":null,"GID":"2e8ab074-60ac-4774-b326-9a834bcec2df","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":4,
         * "WOD_ResidueDegree":42,"SG_GID":"1fa64f93-6634-443f-9d52-3ca279af610f","SG_Code":null,"SGC_Name":"啦咯啦咯啦咯啦咯啦","SG_Name":"啦咯啦咯啦咯啦咯啦","SG_Price":1,"SG_Abstract":null,
         * "SG_Detail":null,"CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"},{"EM_GIDList":null,
         * "GID":"62f51237-d4c6-4c7a-b5d1-6749ab5f2ad0","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":1,"WOD_ResidueDegree":12,
         * "SG_GID":"a6ad3cdb-b0eb-4592-b2b2-0a7894dd379c","SG_Code":"2222","SGC_Name":"ff","SG_Name":"ff","SG_Price":111,"SG_Abstract":null,"SG_Detail":null,
         * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"},{"EM_GIDList":null,
         * "GID":"826ad67d-a811-45aa-acca-1fcdfe07d43e","WO_GID":"c4d0ec45-9efe-4c31-859d-0bcebc198f05","WOD_UseNumber":2,"WOD_ResidueDegree":17,
         * "SG_GID":"79c4644b-df87-41bc-9b33-4300b931e848","SG_Code":"232323","SGC_Name":"23232","SG_Name":"23232","SG_Price":10000,"SG_Abstract":null,"SG_Detail":null,
         * "CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","WOD_Crator":"18986810706","WOD_UpdateTime":"2017-08-03 10:41:30"}]
         * IS_Sms : true
         * WO_Device : 0
         */

        private String GID;
        private String VIP_GID;
        private String VIP_Card;
        private String VIP_Name;
        private String VIP_Phone;
        private String VIP_FaceNumber;
        private String WO_OrderCode;
        private String WO_Remark;
        private String WO_Creator;
        private String WO_UpdateTime;
        private String CY_GID;
        private String SM_GID;
        private String SM_Name;
        private String SM_Contacter;
        private String SM_Phone;
        private String SM_Addr;
        private boolean IS_Sms;
        private String WO_Device;
        private List<WouldOrderDetailBean> wouldOrderDetail;

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

        public String getWO_OrderCode() { return WO_OrderCode;}

        public void setWO_OrderCode(String WO_OrderCode) { this.WO_OrderCode = WO_OrderCode;}

        public String getWO_Remark() { return WO_Remark;}

        public void setWO_Remark(String WO_Remark) { this.WO_Remark = WO_Remark;}

        public String getWO_Creator() { return WO_Creator;}

        public void setWO_Creator(String WO_Creator) { this.WO_Creator = WO_Creator;}

        public String getWO_UpdateTime() { return WO_UpdateTime;}

        public void setWO_UpdateTime(String WO_UpdateTime) { this.WO_UpdateTime = WO_UpdateTime;}

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

        public boolean isIS_Sms() { return IS_Sms;}

        public void setIS_Sms(boolean IS_Sms) { this.IS_Sms = IS_Sms;}

        public String getWO_Device() { return WO_Device;}

        public void setWO_Device(String WO_Device) { this.WO_Device = WO_Device;}

        public List<WouldOrderDetailBean> getWouldOrderDetail() { return wouldOrderDetail;}

        public void setWouldOrderDetail(List<WouldOrderDetailBean> wouldOrderDetail) { this.wouldOrderDetail = wouldOrderDetail;}

        public static class WouldOrderDetailBean
        {
            /**
             * EM_GIDList : null
             * GID : 2e8ab074-60ac-4774-b326-9a834bcec2df
             * WO_GID : c4d0ec45-9efe-4c31-859d-0bcebc198f05
             * WOD_UseNumber : 4
             * WOD_ResidueDegree : 42
             * SG_GID : 1fa64f93-6634-443f-9d52-3ca279af610f
             * SG_Code : null
             * SGC_Name : 啦咯啦咯啦咯啦咯啦
             * SG_Name : 啦咯啦咯啦咯啦咯啦
             * SG_Price : 1
             * SG_Abstract : null
             * SG_Detail : null
             * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
             * WOD_Crator : 18986810706
             * WOD_UpdateTime : 2017-08-03 10:41:30
             */

            private Object EM_GIDList;
            private String GID;
            private String WO_GID;
            private int WOD_UseNumber;
            private int WOD_ResidueDegree;
            private String SG_GID;
            private Object SG_Code;
            private String SGC_Name;
            private String SG_Name;
            private double SG_Price;
            private Object SG_Abstract;
            private Object SG_Detail;
            private String CY_GID;
            private String WOD_Crator;
            private String WOD_UpdateTime;

            public Object getEM_GIDList() { return EM_GIDList;}

            public void setEM_GIDList(Object EM_GIDList) { this.EM_GIDList = EM_GIDList;}

            public String getGID() { return GID;}

            public void setGID(String GID) { this.GID = GID;}

            public String getWO_GID() { return WO_GID;}

            public void setWO_GID(String WO_GID) { this.WO_GID = WO_GID;}

            public int getWOD_UseNumber() { return WOD_UseNumber;}

            public void setWOD_UseNumber(int WOD_UseNumber) { this.WOD_UseNumber = WOD_UseNumber;}

            public int getWOD_ResidueDegree() { return WOD_ResidueDegree;}

            public void setWOD_ResidueDegree(int WOD_ResidueDegree) { this.WOD_ResidueDegree = WOD_ResidueDegree;}

            public String getSG_GID() { return SG_GID;}

            public void setSG_GID(String SG_GID) { this.SG_GID = SG_GID;}

            public Object getSG_Code() { return SG_Code;}

            public void setSG_Code(Object SG_Code) { this.SG_Code = SG_Code;}

            public String getSGC_Name() { return SGC_Name;}

            public void setSGC_Name(String SGC_Name) { this.SGC_Name = SGC_Name;}

            public String getSG_Name() { return SG_Name;}

            public void setSG_Name(String SG_Name) { this.SG_Name = SG_Name;}

            public double getSG_Price() { return SG_Price;}

            public void setSG_Price(double SG_Price) { this.SG_Price = SG_Price;}

            public Object getSG_Abstract() { return SG_Abstract;}

            public void setSG_Abstract(Object SG_Abstract) { this.SG_Abstract = SG_Abstract;}

            public Object getSG_Detail() { return SG_Detail;}

            public void setSG_Detail(Object SG_Detail) { this.SG_Detail = SG_Detail;}

            public String getCY_GID() { return CY_GID;}

            public void setCY_GID(String CY_GID) { this.CY_GID = CY_GID;}

            public String getWOD_Crator() { return WOD_Crator;}

            public void setWOD_Crator(String WOD_Crator) { this.WOD_Crator = WOD_Crator;}

            public String getWOD_UpdateTime() { return WOD_UpdateTime;}

            public void setWOD_UpdateTime(String WOD_UpdateTime) { this.WOD_UpdateTime = WOD_UpdateTime;}
        }
    }
}

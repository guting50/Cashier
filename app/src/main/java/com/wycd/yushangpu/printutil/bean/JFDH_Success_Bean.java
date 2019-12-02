package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * iauthor：Cheng
 * date: 2017/8/3 12:49
 * email：jasoncheng9111@gmail.com
 */
public class JFDH_Success_Bean
{

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"GID":"b536aec3-36f7-467c-8c57-ddc2a0eff400","VIP_GID":"1d681028-b086-45bd-845b-3a538c1b3f4c","VIP_Card":"33","VIP_Name":"哈哈哈","VIP_Phone":"18888888888",
     * "VIP_FaceNumber":"","IEG_OrderNo":"LP1708031226492463","EGD_DateTime":"2017-08-03 12:27:11","IEG_Number":4,"IEG_Score":8,"IEG_RemainingPoints":692933.4,"IEG_Remark":null,
     * "IEG_UpdateTime":"2017-08-03 12:27:11","IEG_Creator":"18986810706","CY_GID":"79dbfdba-9e74-4303-b72d-992318bf46c4","SM_GID":"bfb6cf66-cf97-4239-bb1e-bece3a86d09f",
     * "SM_Name":"Tokyo Hot","GiftsDetail":[{"GID":null,"IEG_GID":null,"EGD_DateTime":null,"GT_Name":"绿萝路","GM_Name":"哦哦哦","GM_Code":"003","GM_Acount":4,"GM_Integral":2,
     * "GM_PictureUrl":null,"EGD_Score":8,"EGD_Creator":null,"CY_GID":null,"EGD_UpdateTime":null,"GM_GID":"9a95a67f-8384-41eb-8217-b95db7309cac"}],"IS_Sms":true,"IEG_Device":0}
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
         * GID : b536aec3-36f7-467c-8c57-ddc2a0eff400
         * VIP_GID : 1d681028-b086-45bd-845b-3a538c1b3f4c
         * VIP_Card : 33
         * VIP_Name : 哈哈哈
         * VIP_Phone : 18888888888
         * VIP_FaceNumber :
         * IEG_OrderNo : LP1708031226492463
         * EGD_DateTime : 2017-08-03 12:27:11
         * IEG_Number : 4
         * IEG_Score : 8
         * IEG_RemainingPoints : 692933.4
         * IEG_Remark : null
         * IEG_UpdateTime : 2017-08-03 12:27:11
         * IEG_Creator : 18986810706
         * CY_GID : 79dbfdba-9e74-4303-b72d-992318bf46c4
         * SM_GID : bfb6cf66-cf97-4239-bb1e-bece3a86d09f
         * SM_Name : Tokyo Hot
         * GiftsDetail : [{"GID":null,"IEG_GID":null,"EGD_DateTime":null,"GT_Name":"绿萝路","GM_Name":"哦哦哦","GM_Code":"003","GM_Acount":4,"GM_Integral":2,"GM_PictureUrl":null,
         * "EGD_Score":8,"EGD_Creator":null,"CY_GID":null,"EGD_UpdateTime":null,"GM_GID":"9a95a67f-8384-41eb-8217-b95db7309cac"}]
         * IS_Sms : true
         * IEG_Device : 0
         */

        private String GID;
        private String VIP_GID;
        private String VIP_Card;
        private String VIP_Name;
        private String VIP_Phone;
        private String VIP_FaceNumber;
        private String IEG_OrderNo;
        private String EGD_DateTime;
        private double IEG_Number;
        private double IEG_Score;
        private double IEG_RemainingPoints;
        private Object IEG_Remark;
        private String IEG_UpdateTime;
        private String IEG_Creator;
        private String CY_GID;
        private String SM_GID;
        private String SM_Name;
        private boolean IS_Sms;
        private double IEG_Device;
        private List<GiftsDetailBean> GiftsDetail;

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

        public String getIEG_OrderNo() { return IEG_OrderNo;}

        public void setIEG_OrderNo(String IEG_OrderNo) { this.IEG_OrderNo = IEG_OrderNo;}

        public String getEGD_DateTime() { return EGD_DateTime;}

        public void setEGD_DateTime(String EGD_DateTime) { this.EGD_DateTime = EGD_DateTime;}

        public double getIEG_Number() { return IEG_Number;}

        public void setIEG_Number(double IEG_Number) { this.IEG_Number = IEG_Number;}

        public double getIEG_Score() { return IEG_Score;}

        public void setIEG_Score(double IEG_Score) { this.IEG_Score = IEG_Score;}

        public double getIEG_RemainingPoints() { return IEG_RemainingPoints;}

        public void setIEG_RemainingPoints(double IEG_RemainingPoints) { this.IEG_RemainingPoints = IEG_RemainingPoints;}

        public Object getIEG_Remark() { return IEG_Remark;}

        public void setIEG_Remark(Object IEG_Remark) { this.IEG_Remark = IEG_Remark;}

        public String getIEG_UpdateTime() { return IEG_UpdateTime;}

        public void setIEG_UpdateTime(String IEG_UpdateTime) { this.IEG_UpdateTime = IEG_UpdateTime;}

        public String getIEG_Creator() { return IEG_Creator;}

        public void setIEG_Creator(String IEG_Creator) { this.IEG_Creator = IEG_Creator;}

        public String getCY_GID() { return CY_GID;}

        public void setCY_GID(String CY_GID) { this.CY_GID = CY_GID;}

        public String getSM_GID() { return SM_GID;}

        public void setSM_GID(String SM_GID) { this.SM_GID = SM_GID;}

        public String getSM_Name() { return SM_Name;}

        public void setSM_Name(String SM_Name) { this.SM_Name = SM_Name;}

        public boolean isIS_Sms() { return IS_Sms;}

        public void setIS_Sms(boolean IS_Sms) { this.IS_Sms = IS_Sms;}

        public double getIEG_Device() { return IEG_Device;}

        public void setIEG_Device(double IEG_Device) { this.IEG_Device = IEG_Device;}

        public List<GiftsDetailBean> getGiftsDetail() { return GiftsDetail;}

        public void setGiftsDetail(List<GiftsDetailBean> GiftsDetail) { this.GiftsDetail = GiftsDetail;}

        public static class GiftsDetailBean
        {
            /**
             * GID : null
             * IEG_GID : null
             * EGD_DateTime : null
             * GT_Name : 绿萝路
             * GM_Name : 哦哦哦
             * GM_Code : 003
             * GM_Acount : 4
             * GM_Integral : 2
             * GM_PictureUrl : null
             * EGD_Score : 8
             * EGD_Creator : null
             * CY_GID : null
             * EGD_UpdateTime : null
             * GM_GID : 9a95a67f-8384-41eb-8217-b95db7309cac
             */

            private Object GID;
            private Object IEG_GID;
            private Object EGD_DateTime;
            private String GT_Name;
            private String GM_Name;
            private String GM_Code;
            private double GM_Acount;
            private double GM_Integral;
            private Object GM_PictureUrl;
            private double EGD_Score;
            private Object EGD_Creator;
            private Object CY_GID;
            private Object EGD_UpdateTime;
            private String GM_GID;

            public Object getGID() { return GID;}

            public void setGID(Object GID) { this.GID = GID;}

            public Object getIEG_GID() { return IEG_GID;}

            public void setIEG_GID(Object IEG_GID) { this.IEG_GID = IEG_GID;}

            public Object getEGD_DateTime() { return EGD_DateTime;}

            public void setEGD_DateTime(Object EGD_DateTime) { this.EGD_DateTime = EGD_DateTime;}

            public String getGT_Name() { return GT_Name;}

            public void setGT_Name(String GT_Name) { this.GT_Name = GT_Name;}

            public String getGM_Name() { return GM_Name;}

            public void setGM_Name(String GM_Name) { this.GM_Name = GM_Name;}

            public String getGM_Code() { return GM_Code;}

            public void setGM_Code(String GM_Code) { this.GM_Code = GM_Code;}

            public double getGM_Acount() { return GM_Acount;}

            public void setGM_Acount(double GM_Acount) { this.GM_Acount = GM_Acount;}

            public double getGM_Integral() { return GM_Integral;}

            public void setGM_Integral(double GM_Integral) { this.GM_Integral = GM_Integral;}

            public Object getGM_PictureUrl() { return GM_PictureUrl;}

            public void setGM_PictureUrl(Object GM_PictureUrl) { this.GM_PictureUrl = GM_PictureUrl;}

            public double getEGD_Score() { return EGD_Score;}

            public void setEGD_Score(double EGD_Score) { this.EGD_Score = EGD_Score;}

            public Object getEGD_Creator() { return EGD_Creator;}

            public void setEGD_Creator(Object EGD_Creator) { this.EGD_Creator = EGD_Creator;}

            public Object getCY_GID() { return CY_GID;}

            public void setCY_GID(Object CY_GID) { this.CY_GID = CY_GID;}

            public Object getEGD_UpdateTime() { return EGD_UpdateTime;}

            public void setEGD_UpdateTime(Object EGD_UpdateTime) { this.EGD_UpdateTime = EGD_UpdateTime;}

            public String getGM_GID() { return GM_GID;}

            public void setGM_GID(String GM_GID) { this.GM_GID = GM_GID;}
        }
    }
}

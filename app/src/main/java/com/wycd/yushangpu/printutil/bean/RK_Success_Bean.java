package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * Created by YSL on 2018-11-21.
 */

public class RK_Success_Bean {
    /**
     * StockInDetailList : [{"SI_PayType":null,"SI_TrackingNo":null,"SL_Name":null,"GID":"94c025dd-8bc5-49c6-94a3-961d96943b91","PM_BigImg":"/img/product.png","SI_GID":"31a9840c-c1dd-49bd-a7cd-c9d4ca9edfa8","SID_Amount":1,"SID_TotalPrice":1,"SID_CreateTime":"2018-11-21 14:44:15","SID_Remark":null,"SID_Creator":"销售001","CY_GID":null,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","PM_Code":"153233438222029","PM_Name":"1014584","PM_SimpleCode":"1014584","PM_Metering":"","PM_UnitPrice":1,"PM_Purchase":"","PT_ID":"7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d","PM_Description":"","PM_Modle":"","PM_Brand":"","PM_GID":"02772b9f-b4c1-4592-8af6-e9657e363386","PT_Name":null}]
     * SI_TrackingNo : CG1811211314291500
     * SI_Hander : 销售001
     * SI_CreateTime : 2018-11-21 13:14:38
     * SL_Name :
     * SI_PayCode : XJZF
     * SI_OtherMoney : 0.0
     * SI_Remark :
     * SI_InType : 1
     * SI_ISReturn : 0
     */

    private String SI_TrackingNo;
    private String SI_Hander;
    private String SI_CreateTime;
    private String SL_Name;
    private String SI_PayCode;
    private double SI_OtherMoney;
    private String SI_Remark;
    private String SI_InType;
    private int SI_ISReturn;
    private List<StockInDetailListBean> StockInDetailList;

    public String getSI_TrackingNo() {
        return SI_TrackingNo;
    }

    public void setSI_TrackingNo(String SI_TrackingNo) {
        this.SI_TrackingNo = SI_TrackingNo;
    }

    public String getSI_Hander() {
        return SI_Hander;
    }

    public void setSI_Hander(String SI_Hander) {
        this.SI_Hander = SI_Hander;
    }

    public String getSI_CreateTime() {
        return SI_CreateTime;
    }

    public void setSI_CreateTime(String SI_CreateTime) {
        this.SI_CreateTime = SI_CreateTime;
    }

    public String getSL_Name() {
        return SL_Name;
    }

    public void setSL_Name(String SL_Name) {
        this.SL_Name = SL_Name;
    }

    public String getSI_PayCode() {
        return SI_PayCode;
    }

    public void setSI_PayCode(String SI_PayCode) {
        this.SI_PayCode = SI_PayCode;
    }

    public double getSI_OtherMoney() {
        return SI_OtherMoney;
    }

    public void setSI_OtherMoney(double SI_OtherMoney) {
        this.SI_OtherMoney = SI_OtherMoney;
    }

    public String getSI_Remark() {
        return SI_Remark;
    }

    public void setSI_Remark(String SI_Remark) {
        this.SI_Remark = SI_Remark;
    }

    public String getSI_InType() {
        return SI_InType;
    }

    public void setSI_InType(String SI_InType) {
        this.SI_InType = SI_InType;
    }

    public int getSI_ISReturn() {
        return SI_ISReturn;
    }

    public void setSI_ISReturn(int SI_ISReturn) {
        this.SI_ISReturn = SI_ISReturn;
    }

    public List<StockInDetailListBean> getStockInDetailList() {
        return StockInDetailList;
    }

    public void setStockInDetailList(List<StockInDetailListBean> StockInDetailList) {
        this.StockInDetailList = StockInDetailList;
    }

    public static class StockInDetailListBean {
        /**
         * SI_PayType : null
         * SI_TrackingNo : null
         * SL_Name : null
         * GID : 94c025dd-8bc5-49c6-94a3-961d96943b91
         * PM_BigImg : /img/product.png
         * SI_GID : 31a9840c-c1dd-49bd-a7cd-c9d4ca9edfa8
         * SID_Amount : 1.0
         * SID_TotalPrice : 1.0
         * SID_CreateTime : 2018-11-21 14:44:15
         * SID_Remark : null
         * SID_Creator : 销售001
         * CY_GID : null
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * PM_Code : 153233438222029
         * PM_Name : 1014584
         * PM_SimpleCode : 1014584
         * PM_Metering :
         * PM_UnitPrice : 1.0
         * PM_Purchase :
         * PT_ID : 7cd7235c-4b5d-4859-b2a9-ef9557ef1b9d
         * PM_Description :
         * PM_Modle :
         * PM_Brand :
         * PM_GID : 02772b9f-b4c1-4592-8af6-e9657e363386
         * PT_Name : null
         */

        private Object SI_PayType;
        private Object SI_TrackingNo;
        private Object SL_Name;
        private String GID;
        private String PM_BigImg;
        private String SI_GID;
        private double SID_Amount;
        private double SID_TotalPrice;
        private String SID_CreateTime;
        private Object SID_Remark;
        private String SID_Creator;
        private Object CY_GID;
        private String SM_GID;
        private String PM_Code;
        private String PM_Name;
        private String PM_SimpleCode;
        private String PM_Metering;
        private double PM_UnitPrice;
        private String PM_Purchase;
        private String PT_ID;
        private String PM_Description;
        private String PM_Modle;
        private String PM_Brand;
        private String PM_GID;
        private Object PT_Name;

        public Object getSI_PayType() {
            return SI_PayType;
        }

        public void setSI_PayType(Object SI_PayType) {
            this.SI_PayType = SI_PayType;
        }

        public Object getSI_TrackingNo() {
            return SI_TrackingNo;
        }

        public void setSI_TrackingNo(Object SI_TrackingNo) {
            this.SI_TrackingNo = SI_TrackingNo;
        }

        public Object getSL_Name() {
            return SL_Name;
        }

        public void setSL_Name(Object SL_Name) {
            this.SL_Name = SL_Name;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getPM_BigImg() {
            return PM_BigImg;
        }

        public void setPM_BigImg(String PM_BigImg) {
            this.PM_BigImg = PM_BigImg;
        }

        public String getSI_GID() {
            return SI_GID;
        }

        public void setSI_GID(String SI_GID) {
            this.SI_GID = SI_GID;
        }

        public double getSID_Amount() {
            return SID_Amount;
        }

        public void setSID_Amount(double SID_Amount) {
            this.SID_Amount = SID_Amount;
        }

        public double getSID_TotalPrice() {
            return SID_TotalPrice;
        }

        public void setSID_TotalPrice(double SID_TotalPrice) {
            this.SID_TotalPrice = SID_TotalPrice;
        }

        public String getSID_CreateTime() {
            return SID_CreateTime;
        }

        public void setSID_CreateTime(String SID_CreateTime) {
            this.SID_CreateTime = SID_CreateTime;
        }

        public Object getSID_Remark() {
            return SID_Remark;
        }

        public void setSID_Remark(Object SID_Remark) {
            this.SID_Remark = SID_Remark;
        }

        public String getSID_Creator() {
            return SID_Creator;
        }

        public void setSID_Creator(String SID_Creator) {
            this.SID_Creator = SID_Creator;
        }

        public Object getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(Object CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getSM_GID() {
            return SM_GID;
        }

        public void setSM_GID(String SM_GID) {
            this.SM_GID = SM_GID;
        }

        public String getPM_Code() {
            return PM_Code;
        }

        public void setPM_Code(String PM_Code) {
            this.PM_Code = PM_Code;
        }

        public String getPM_Name() {
            return PM_Name;
        }

        public void setPM_Name(String PM_Name) {
            this.PM_Name = PM_Name;
        }

        public String getPM_SimpleCode() {
            return PM_SimpleCode;
        }

        public void setPM_SimpleCode(String PM_SimpleCode) {
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

        public String getPM_Purchase() {
            return PM_Purchase;
        }

        public void setPM_Purchase(String PM_Purchase) {
            this.PM_Purchase = PM_Purchase;
        }

        public String getPT_ID() {
            return PT_ID;
        }

        public void setPT_ID(String PT_ID) {
            this.PT_ID = PT_ID;
        }

        public String getPM_Description() {
            return PM_Description;
        }

        public void setPM_Description(String PM_Description) {
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

        public String getPM_GID() {
            return PM_GID;
        }

        public void setPM_GID(String PM_GID) {
            this.PM_GID = PM_GID;
        }

        public Object getPT_Name() {
            return PT_Name;
        }

        public void setPT_Name(Object PT_Name) {
            this.PT_Name = PT_Name;
        }
    }
}

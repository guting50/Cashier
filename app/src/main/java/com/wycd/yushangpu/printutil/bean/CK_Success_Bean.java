package com.wycd.yushangpu.printutil.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZPH on 2019-04-20.
 */

public class CK_Success_Bean {


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"StockOutDetailList":[{"CO_GID":null,"SL_Name":null,"SO_TrackingNo":"CT1904191812277427","PM_PurchasePrice":0,"SOD_DiscountPrice":0,"GID":"8b5de134-77d7-454d-8616-174876250fd1","SO_GID":"c9baf63d-3c91-41d5-8d62-77614b46fc9a","SOD_Amount":3,"SOD_TotalPrice":0,"SOD_CreateTime":"2019-04-19 18:13:20","SOD_Remark":null,"SOD_Creator":"销售001","CY_GID":null,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","PM_Code":"1531995698","PM_Name":"10元礼品","PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":0,"PM_Purchase":"","PT_ID":"1827050f-221b-4797-941c-87dc0eb36872","PM_Description":null,"PM_Modle":"","PM_Brand":"成都早餐","PM_GID":"4488b36f-b321-4f16-9f3a-fd1d8a24aae0","PT_Name":"理发","PM_BigImg":"/img/product.png"}],"SO_TrackingNo":"CT1904191812277427","SO_Hander":null,"SO_CreateTime":"2019-04-19 18:13:20","SO_PayCode":"XJZF","SO_OutType":"2","SO_OtherMoney":0,"SO_Remark":null,"SO_DiscountPrice":0}
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

    public static class DataBean implements Serializable {
        /**
         * StockOutDetailList : [{"CO_GID":null,"SL_Name":null,"SO_TrackingNo":"CT1904191812277427","PM_PurchasePrice":0,"SOD_DiscountPrice":0,"GID":"8b5de134-77d7-454d-8616-174876250fd1","SO_GID":"c9baf63d-3c91-41d5-8d62-77614b46fc9a","SOD_Amount":3,"SOD_TotalPrice":0,"SOD_CreateTime":"2019-04-19 18:13:20","SOD_Remark":null,"SOD_Creator":"销售001","CY_GID":null,"SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","PM_Code":"1531995698","PM_Name":"10元礼品","PM_SimpleCode":null,"PM_Metering":"","PM_UnitPrice":0,"PM_Purchase":"","PT_ID":"1827050f-221b-4797-941c-87dc0eb36872","PM_Description":null,"PM_Modle":"","PM_Brand":"成都早餐","PM_GID":"4488b36f-b321-4f16-9f3a-fd1d8a24aae0","PT_Name":"理发","PM_BigImg":"/img/product.png"}]
         * SO_TrackingNo : CT1904191812277427
         * SO_Hander : null
         * SO_CreateTime : 2019-04-19 18:13:20
         * SO_PayCode : XJZF
         * SO_OutType : 2
         * SO_OtherMoney : 0.0
         * SO_Remark : null
         * SO_DiscountPrice : 0.0
         */

        private String SO_TrackingNo;
        private Object SO_Hander;
        private String SO_CreateTime;
        private String SO_PayCode;
        private String SO_OutType;
        private double SO_OtherMoney;
        private Object SO_Remark;
        private double SO_DiscountPrice;
        private List<StockOutDetailListBean> StockOutDetailList;

        public String getSO_TrackingNo() {
            return SO_TrackingNo;
        }

        public void setSO_TrackingNo(String SO_TrackingNo) {
            this.SO_TrackingNo = SO_TrackingNo;
        }

        public Object getSO_Hander() {
            return SO_Hander;
        }

        public void setSO_Hander(Object SO_Hander) {
            this.SO_Hander = SO_Hander;
        }

        public String getSO_CreateTime() {
            return SO_CreateTime;
        }

        public void setSO_CreateTime(String SO_CreateTime) {
            this.SO_CreateTime = SO_CreateTime;
        }

        public String getSO_PayCode() {
            return SO_PayCode;
        }

        public void setSO_PayCode(String SO_PayCode) {
            this.SO_PayCode = SO_PayCode;
        }

        public String getSO_OutType() {
            return SO_OutType;
        }

        public void setSO_OutType(String SO_OutType) {
            this.SO_OutType = SO_OutType;
        }

        public double getSO_OtherMoney() {
            return SO_OtherMoney;
        }

        public void setSO_OtherMoney(double SO_OtherMoney) {
            this.SO_OtherMoney = SO_OtherMoney;
        }

        public Object getSO_Remark() {
            return SO_Remark;
        }

        public void setSO_Remark(Object SO_Remark) {
            this.SO_Remark = SO_Remark;
        }

        public double getSO_DiscountPrice() {
            return SO_DiscountPrice;
        }

        public void setSO_DiscountPrice(double SO_DiscountPrice) {
            this.SO_DiscountPrice = SO_DiscountPrice;
        }

        public List<StockOutDetailListBean> getStockOutDetailList() {
            return StockOutDetailList;
        }

        public void setStockOutDetailList(List<StockOutDetailListBean> StockOutDetailList) {
            this.StockOutDetailList = StockOutDetailList;
        }

        public static class StockOutDetailListBean {
            /**
             * CO_GID : null
             * SL_Name : null
             * SO_TrackingNo : CT1904191812277427
             * PM_PurchasePrice : 0.0
             * SOD_DiscountPrice : 0.0
             * GID : 8b5de134-77d7-454d-8616-174876250fd1
             * SO_GID : c9baf63d-3c91-41d5-8d62-77614b46fc9a
             * SOD_Amount : 3.0
             * SOD_TotalPrice : 0.0
             * SOD_CreateTime : 2019-04-19 18:13:20
             * SOD_Remark : null
             * SOD_Creator : 销售001
             * CY_GID : null
             * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * PM_Code : 1531995698
             * PM_Name : 10元礼品
             * PM_SimpleCode : null
             * PM_Metering :
             * PM_UnitPrice : 0.0
             * PM_Purchase :
             * PT_ID : 1827050f-221b-4797-941c-87dc0eb36872
             * PM_Description : null
             * PM_Modle :
             * PM_Brand : 成都早餐
             * PM_GID : 4488b36f-b321-4f16-9f3a-fd1d8a24aae0
             * PT_Name : 理发
             * PM_BigImg : /img/product.png
             */

            private Object CO_GID;
            private Object SL_Name;
            private String SO_TrackingNo;
            private double PM_PurchasePrice;
            private double SOD_DiscountPrice;
            private String GID;
            private String SO_GID;
            private double SOD_Amount;
            private double SOD_TotalPrice;
            private String SOD_CreateTime;
            private Object SOD_Remark;
            private String SOD_Creator;
            private Object CY_GID;
            private String SM_GID;
            private String PM_Code;
            private String PM_Name;
            private Object PM_SimpleCode;
            private String PM_Metering;
            private double PM_UnitPrice;
            private String PM_Purchase;
            private String PT_ID;
            private Object PM_Description;
            private String PM_Modle;
            private String PM_Brand;
            private String PM_GID;
            private String PT_Name;
            private String PM_BigImg;

            public Object getCO_GID() {
                return CO_GID;
            }

            public void setCO_GID(Object CO_GID) {
                this.CO_GID = CO_GID;
            }

            public Object getSL_Name() {
                return SL_Name;
            }

            public void setSL_Name(Object SL_Name) {
                this.SL_Name = SL_Name;
            }

            public String getSO_TrackingNo() {
                return SO_TrackingNo;
            }

            public void setSO_TrackingNo(String SO_TrackingNo) {
                this.SO_TrackingNo = SO_TrackingNo;
            }

            public double getPM_PurchasePrice() {
                return PM_PurchasePrice;
            }

            public void setPM_PurchasePrice(double PM_PurchasePrice) {
                this.PM_PurchasePrice = PM_PurchasePrice;
            }

            public double getSOD_DiscountPrice() {
                return SOD_DiscountPrice;
            }

            public void setSOD_DiscountPrice(double SOD_DiscountPrice) {
                this.SOD_DiscountPrice = SOD_DiscountPrice;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getSO_GID() {
                return SO_GID;
            }

            public void setSO_GID(String SO_GID) {
                this.SO_GID = SO_GID;
            }

            public double getSOD_Amount() {
                return SOD_Amount;
            }

            public void setSOD_Amount(double SOD_Amount) {
                this.SOD_Amount = SOD_Amount;
            }

            public double getSOD_TotalPrice() {
                return SOD_TotalPrice;
            }

            public void setSOD_TotalPrice(double SOD_TotalPrice) {
                this.SOD_TotalPrice = SOD_TotalPrice;
            }

            public String getSOD_CreateTime() {
                return SOD_CreateTime;
            }

            public void setSOD_CreateTime(String SOD_CreateTime) {
                this.SOD_CreateTime = SOD_CreateTime;
            }

            public Object getSOD_Remark() {
                return SOD_Remark;
            }

            public void setSOD_Remark(Object SOD_Remark) {
                this.SOD_Remark = SOD_Remark;
            }

            public String getSOD_Creator() {
                return SOD_Creator;
            }

            public void setSOD_Creator(String SOD_Creator) {
                this.SOD_Creator = SOD_Creator;
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

            public Object getPM_SimpleCode() {
                return PM_SimpleCode;
            }

            public void setPM_SimpleCode(Object PM_SimpleCode) {
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

            public Object getPM_Description() {
                return PM_Description;
            }

            public void setPM_Description(Object PM_Description) {
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

            public String getPT_Name() {
                return PT_Name;
            }

            public void setPT_Name(String PT_Name) {
                this.PT_Name = PT_Name;
            }

            public String getPM_BigImg() {
                return PM_BigImg;
            }

            public void setPM_BigImg(String PM_BigImg) {
                this.PM_BigImg = PM_BigImg;
            }
        }
    }
}

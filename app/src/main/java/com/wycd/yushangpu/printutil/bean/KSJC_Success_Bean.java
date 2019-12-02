package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * Created by ZPH on 2018-12-28.
 */

public class KSJC_Success_Bean {

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"WO_EMName":"营销全部","GoodsInfo":null,"WO_State":0,"GID":"ecc23136-a687-48ae-8e54-f9ca55198933","VIP_GID":"4d58355f-9848-4939-9208-084599c6a593","VIP_Card":"65456565","VIP_Name":"sad","VIP_Phone":"13535498651","VIP_FaceNumber":"","WO_OrderCode":"JC1812281624437276","WO_Remark":"","WO_Creator":"销售001","WO_UpdateTime":"2018-12-28 16:24:49","CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","SM_GID":"4a7b1141-8ca3-4bef-961f-ffd153357823","SM_Name":"jll","WouldOrderDetail":[{"MCA_GID":"40258a0e-2d41-4d8a-93c2-2d0d996dca5f","WOD_EMName":"营销全部","EM_GIDList":["264cc97a-5757-44d5-9152-90499daefe9b"],"GID":"484aa457-b967-4565-82a9-217a1fcc6d61","WO_GID":"ecc23136-a687-48ae-8e54-f9ca55198933","WOD_UseNumber":1,"WOD_ResidueDegree":3,"SG_GID":"d97d845e-29be-4379-8da4-a4dfe999e30c","SG_Code":"771","SGC_Name":"精品SPA","SG_Name":"精品SPA","SG_Price":30,"SG_Abstract":null,"SG_Detail":null,"PM_BigImg":null,"CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","WOD_Crator":"销售001","WOD_UpdateTime":"2018-12-28 16:24:49","MCA_OverTime":null,"WR_GID":null,"WR_Name":"","SG_Metering":null}],"IS_Sms":true,"WO_Device":"1","ErrorMsg":null,"WOD_UseNumber":null,"SG_Code":null,"SG_Name":null,"SG_Price":null,"WR_Name":null,"MCA_OverTime":null}
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
         * WO_EMName : 营销全部
         * GoodsInfo : null
         * WO_State : 0
         * GID : ecc23136-a687-48ae-8e54-f9ca55198933
         * VIP_GID : 4d58355f-9848-4939-9208-084599c6a593
         * VIP_Card : 65456565
         * VIP_Name : sad
         * VIP_Phone : 13535498651
         * VIP_FaceNumber :
         * WO_OrderCode : JC1812281624437276
         * WO_Remark :
         * WO_Creator : 销售001
         * WO_UpdateTime : 2018-12-28 16:24:49
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * SM_Name : jll
         * WouldOrderDetail : [{"MCA_GID":"40258a0e-2d41-4d8a-93c2-2d0d996dca5f","WOD_EMName":"营销全部","EM_GIDList":["264cc97a-5757-44d5-9152-90499daefe9b"],"GID":"484aa457-b967-4565-82a9-217a1fcc6d61","WO_GID":"ecc23136-a687-48ae-8e54-f9ca55198933","WOD_UseNumber":1,"WOD_ResidueDegree":3,"SG_GID":"d97d845e-29be-4379-8da4-a4dfe999e30c","SG_Code":"771","SGC_Name":"精品SPA","SG_Name":"精品SPA","SG_Price":30,"SG_Abstract":null,"SG_Detail":null,"PM_BigImg":null,"CY_GID":"33b26f6e-78c8-4da8-bdad-6b47c06f4aa4","WOD_Crator":"销售001","WOD_UpdateTime":"2018-12-28 16:24:49","MCA_OverTime":null,"WR_GID":null,"WR_Name":"","SG_Metering":null}]
         * IS_Sms : true
         * WO_Device : 1
         * ErrorMsg : null
         * WOD_UseNumber : null
         * SG_Code : null
         * SG_Name : null
         * SG_Price : null
         * WR_Name : null
         * MCA_OverTime : null
         */

        private String WO_EMName;
        private Object GoodsInfo;
        private int WO_State;
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
        private boolean IS_Sms;
        private String WO_Device;
        private Object ErrorMsg;
        private Object WOD_UseNumber;
        private Object SG_Code;
        private Object SG_Name;
        private Object SG_Price;
        private Object WR_Name;
        private Object MCA_OverTime;
        private List<WouldOrderDetailBean> WouldOrderDetail;

        public String getWO_EMName() {
            return WO_EMName;
        }

        public void setWO_EMName(String WO_EMName) {
            this.WO_EMName = WO_EMName;
        }

        public Object getGoodsInfo() {
            return GoodsInfo;
        }

        public void setGoodsInfo(Object GoodsInfo) {
            this.GoodsInfo = GoodsInfo;
        }

        public int getWO_State() {
            return WO_State;
        }

        public void setWO_State(int WO_State) {
            this.WO_State = WO_State;
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

        public String getWO_OrderCode() {
            return WO_OrderCode;
        }

        public void setWO_OrderCode(String WO_OrderCode) {
            this.WO_OrderCode = WO_OrderCode;
        }

        public String getWO_Remark() {
            return WO_Remark;
        }

        public void setWO_Remark(String WO_Remark) {
            this.WO_Remark = WO_Remark;
        }

        public String getWO_Creator() {
            return WO_Creator;
        }

        public void setWO_Creator(String WO_Creator) {
            this.WO_Creator = WO_Creator;
        }

        public String getWO_UpdateTime() {
            return WO_UpdateTime;
        }

        public void setWO_UpdateTime(String WO_UpdateTime) {
            this.WO_UpdateTime = WO_UpdateTime;
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

        public boolean isIS_Sms() {
            return IS_Sms;
        }

        public void setIS_Sms(boolean IS_Sms) {
            this.IS_Sms = IS_Sms;
        }

        public String getWO_Device() {
            return WO_Device;
        }

        public void setWO_Device(String WO_Device) {
            this.WO_Device = WO_Device;
        }

        public Object getErrorMsg() {
            return ErrorMsg;
        }

        public void setErrorMsg(Object ErrorMsg) {
            this.ErrorMsg = ErrorMsg;
        }

        public Object getWOD_UseNumber() {
            return WOD_UseNumber;
        }

        public void setWOD_UseNumber(Object WOD_UseNumber) {
            this.WOD_UseNumber = WOD_UseNumber;
        }

        public Object getSG_Code() {
            return SG_Code;
        }

        public void setSG_Code(Object SG_Code) {
            this.SG_Code = SG_Code;
        }

        public Object getSG_Name() {
            return SG_Name;
        }

        public void setSG_Name(Object SG_Name) {
            this.SG_Name = SG_Name;
        }

        public Object getSG_Price() {
            return SG_Price;
        }

        public void setSG_Price(Object SG_Price) {
            this.SG_Price = SG_Price;
        }

        public Object getWR_Name() {
            return WR_Name;
        }

        public void setWR_Name(Object WR_Name) {
            this.WR_Name = WR_Name;
        }

        public Object getMCA_OverTime() {
            return MCA_OverTime;
        }

        public void setMCA_OverTime(Object MCA_OverTime) {
            this.MCA_OverTime = MCA_OverTime;
        }

        public List<WouldOrderDetailBean> getWouldOrderDetail() {
            return WouldOrderDetail;
        }

        public void setWouldOrderDetail(List<WouldOrderDetailBean> WouldOrderDetail) {
            this.WouldOrderDetail = WouldOrderDetail;
        }

        public static class WouldOrderDetailBean {
            /**
             * MCA_GID : 40258a0e-2d41-4d8a-93c2-2d0d996dca5f
             * WOD_EMName : 营销全部
             * EM_GIDList : ["264cc97a-5757-44d5-9152-90499daefe9b"]
             * GID : 484aa457-b967-4565-82a9-217a1fcc6d61
             * WO_GID : ecc23136-a687-48ae-8e54-f9ca55198933
             * WOD_UseNumber : 1
             * WOD_ResidueDegree : 3
             * SG_GID : d97d845e-29be-4379-8da4-a4dfe999e30c
             * SG_Code : 771
             * SGC_Name : 精品SPA
             * SG_Name : 精品SPA
             * SG_Price : 30.0
             * SG_Abstract : null
             * SG_Detail : null
             * PM_BigImg : null
             * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
             * WOD_Crator : 销售001
             * WOD_UpdateTime : 2018-12-28 16:24:49
             * MCA_OverTime : null
             * WR_GID : null
             * WR_Name :
             * SG_Metering : null
             */

            private String MCA_GID;
            private String WOD_EMName;
            private String GID;
            private String WO_GID;
            private int WOD_UseNumber;
            private int WOD_ResidueDegree;
            private String SG_GID;
            private String SG_Code;
            private String SGC_Name;
            private String SG_Name;
            private double SG_Price;
            private Object SG_Abstract;
            private Object SG_Detail;
            private Object PM_BigImg;
            private String CY_GID;
            private String WOD_Crator;
            private String WOD_UpdateTime;
            private Object MCA_OverTime;
            private Object WR_GID;
            private String WR_Name;
            private Object SG_Metering;
            private List<String> EM_GIDList;

            public String getMCA_GID() {
                return MCA_GID;
            }

            public void setMCA_GID(String MCA_GID) {
                this.MCA_GID = MCA_GID;
            }

            public String getWOD_EMName() {
                return WOD_EMName;
            }

            public void setWOD_EMName(String WOD_EMName) {
                this.WOD_EMName = WOD_EMName;
            }

            public String getGID() {
                return GID;
            }

            public void setGID(String GID) {
                this.GID = GID;
            }

            public String getWO_GID() {
                return WO_GID;
            }

            public void setWO_GID(String WO_GID) {
                this.WO_GID = WO_GID;
            }

            public int getWOD_UseNumber() {
                return WOD_UseNumber;
            }

            public void setWOD_UseNumber(int WOD_UseNumber) {
                this.WOD_UseNumber = WOD_UseNumber;
            }

            public int getWOD_ResidueDegree() {
                return WOD_ResidueDegree;
            }

            public void setWOD_ResidueDegree(int WOD_ResidueDegree) {
                this.WOD_ResidueDegree = WOD_ResidueDegree;
            }

            public String getSG_GID() {
                return SG_GID;
            }

            public void setSG_GID(String SG_GID) {
                this.SG_GID = SG_GID;
            }

            public String getSG_Code() {
                return SG_Code;
            }

            public void setSG_Code(String SG_Code) {
                this.SG_Code = SG_Code;
            }

            public String getSGC_Name() {
                return SGC_Name;
            }

            public void setSGC_Name(String SGC_Name) {
                this.SGC_Name = SGC_Name;
            }

            public String getSG_Name() {
                return SG_Name;
            }

            public void setSG_Name(String SG_Name) {
                this.SG_Name = SG_Name;
            }

            public double getSG_Price() {
                return SG_Price;
            }

            public void setSG_Price(double SG_Price) {
                this.SG_Price = SG_Price;
            }

            public Object getSG_Abstract() {
                return SG_Abstract;
            }

            public void setSG_Abstract(Object SG_Abstract) {
                this.SG_Abstract = SG_Abstract;
            }

            public Object getSG_Detail() {
                return SG_Detail;
            }

            public void setSG_Detail(Object SG_Detail) {
                this.SG_Detail = SG_Detail;
            }

            public Object getPM_BigImg() {
                return PM_BigImg;
            }

            public void setPM_BigImg(Object PM_BigImg) {
                this.PM_BigImg = PM_BigImg;
            }

            public String getCY_GID() {
                return CY_GID;
            }

            public void setCY_GID(String CY_GID) {
                this.CY_GID = CY_GID;
            }

            public String getWOD_Crator() {
                return WOD_Crator;
            }

            public void setWOD_Crator(String WOD_Crator) {
                this.WOD_Crator = WOD_Crator;
            }

            public String getWOD_UpdateTime() {
                return WOD_UpdateTime;
            }

            public void setWOD_UpdateTime(String WOD_UpdateTime) {
                this.WOD_UpdateTime = WOD_UpdateTime;
            }

            public Object getMCA_OverTime() {
                return MCA_OverTime;
            }

            public void setMCA_OverTime(Object MCA_OverTime) {
                this.MCA_OverTime = MCA_OverTime;
            }

            public Object getWR_GID() {
                return WR_GID;
            }

            public void setWR_GID(Object WR_GID) {
                this.WR_GID = WR_GID;
            }

            public String getWR_Name() {
                return WR_Name;
            }

            public void setWR_Name(String WR_Name) {
                this.WR_Name = WR_Name;
            }

            public Object getSG_Metering() {
                return SG_Metering;
            }

            public void setSG_Metering(Object SG_Metering) {
                this.SG_Metering = SG_Metering;
            }

            public List<String> getEM_GIDList() {
                return EM_GIDList;
            }

            public void setEM_GIDList(List<String> EM_GIDList) {
                this.EM_GIDList = EM_GIDList;
            }
        }
    }
}

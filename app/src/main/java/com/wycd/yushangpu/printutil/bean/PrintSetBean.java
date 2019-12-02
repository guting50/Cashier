package com.wycd.yushangpu.printutil.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：罗咏哲 on 2017/8/24 18:25.
 * 邮箱：137615198@qq.com
 */

public class PrintSetBean implements Serializable {


    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : {"PS_GID":"4b5c9c8c-c333-4f7b-9c1a-2c9e195ad260","PS_CYGID":"ae405193-7377-43c4-b5e2-91d8d19ac80b","PS_SMGID":"fbfdd45a-c749-47a7-9ce7-33687976a56e","PS_IsEnabled":1,"PS_IsPreview":0,"PS_PaperType":2,"PS_PrintTimes":"[{\"PT_Code\":\"SPXF\",\"PT_Times\":1},{\"PT_Code\":\"JB\",\"PT_Times\":1}]","PS_PrinterName":"XP-58","PS_StylusPrintingName":"OneNote","PS_IsMultiEnabled":1,"PS_MultiPaperType":5,"PS_MultiPrintTimes":"[{\"PT_Code\":\"HYCC\",\"PT_Times\":1},{\"PT_Code\":\"SPXF\",\"PT_Times\":1},{\"PT_Code\":\"RKJLXQ\",\"PT_Times\":1},{\"PT_Code\":\"CKJLXQ\",\"PT_Times\":1},{\"PT_Code\":\"PDJLXQ\",\"PT_Times\":1}]","PS_TipPrinterName":"Gprinter  GP-2120TL","PS_TipPrintTimes":1,"PS_TipPrintPaper":0,"PrintTimesList":[{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"JB","PT_Times":1}],"MultiPrintTimesList":[{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"RKJLXQ","PT_Times":1},{"PT_Code":"CKJLXQ","PT_Times":1},{"PT_Code":"PDJLXQ","PT_Times":1}]}
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
         * PS_GID : 4b5c9c8c-c333-4f7b-9c1a-2c9e195ad260
         * PS_CYGID : ae405193-7377-43c4-b5e2-91d8d19ac80b
         * PS_SMGID : fbfdd45a-c749-47a7-9ce7-33687976a56e
         * PS_IsEnabled : 1
         * PS_IsPreview : 0
         * PS_PaperType : 2
         * PS_PrintTimes : [{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"JB","PT_Times":1}]
         * PS_PrinterName : XP-58
         * PS_StylusPrintingName : OneNote
         * PS_IsMultiEnabled : 1
         * PS_MultiPaperType : 5
         * PS_MultiPrintTimes : [{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"RKJLXQ","PT_Times":1},{"PT_Code":"CKJLXQ","PT_Times":1},{"PT_Code":"PDJLXQ","PT_Times":1}]
         * PS_TipPrinterName : Gprinter  GP-2120TL
         * PS_TipPrintTimes : 1
         * PS_TipPrintPaper : 0
         * PrintTimesList : [{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"JB","PT_Times":1}]
         * MultiPrintTimesList : [{"PT_Code":"HYCC","PT_Times":1},{"PT_Code":"SPXF","PT_Times":1},{"PT_Code":"RKJLXQ","PT_Times":1},{"PT_Code":"CKJLXQ","PT_Times":1},{"PT_Code":"PDJLXQ","PT_Times":1}]
         */

        private String PS_GID;
        private String PS_CYGID;
        private String PS_SMGID;
        private int PS_IsEnabled;
        private int PS_IsPreview;
        private int PS_PaperType;
        private String PS_PrintTimes;
        private String PS_PrinterName;
        private String PS_StylusPrintingName;
        private int PS_IsMultiEnabled;
        private int PS_MultiPaperType;
        private String PS_MultiPrintTimes;
        private String PS_TipPrinterName;
        private int PS_TipPrintTimes;
        private int PS_TipPrintPaper;
        private List<PrintTimesListBean> PrintTimesList;
        private List<MultiPrintTimesListBean> MultiPrintTimesList;

        public String getPS_GID() {
            return PS_GID;
        }

        public void setPS_GID(String PS_GID) {
            this.PS_GID = PS_GID;
        }

        public String getPS_CYGID() {
            return PS_CYGID;
        }

        public void setPS_CYGID(String PS_CYGID) {
            this.PS_CYGID = PS_CYGID;
        }

        public String getPS_SMGID() {
            return PS_SMGID;
        }

        public void setPS_SMGID(String PS_SMGID) {
            this.PS_SMGID = PS_SMGID;
        }

        public int getPS_IsEnabled() {
            return PS_IsEnabled;
        }

        public void setPS_IsEnabled(int PS_IsEnabled) {
            this.PS_IsEnabled = PS_IsEnabled;
        }

        public int getPS_IsPreview() {
            return PS_IsPreview;
        }

        public void setPS_IsPreview(int PS_IsPreview) {
            this.PS_IsPreview = PS_IsPreview;
        }

        public int getPS_PaperType() {
            return PS_PaperType;
        }

        public void setPS_PaperType(int PS_PaperType) {
            this.PS_PaperType = PS_PaperType;
        }

        public String getPS_PrintTimes() {
            return PS_PrintTimes;
        }

        public void setPS_PrintTimes(String PS_PrintTimes) {
            this.PS_PrintTimes = PS_PrintTimes;
        }

        public String getPS_PrinterName() {
            return PS_PrinterName;
        }

        public void setPS_PrinterName(String PS_PrinterName) {
            this.PS_PrinterName = PS_PrinterName;
        }

        public String getPS_StylusPrintingName() {
            return PS_StylusPrintingName;
        }

        public void setPS_StylusPrintingName(String PS_StylusPrintingName) {
            this.PS_StylusPrintingName = PS_StylusPrintingName;
        }

        public int getPS_IsMultiEnabled() {
            return PS_IsMultiEnabled;
        }

        public void setPS_IsMultiEnabled(int PS_IsMultiEnabled) {
            this.PS_IsMultiEnabled = PS_IsMultiEnabled;
        }

        public int getPS_MultiPaperType() {
            return PS_MultiPaperType;
        }

        public void setPS_MultiPaperType(int PS_MultiPaperType) {
            this.PS_MultiPaperType = PS_MultiPaperType;
        }

        public String getPS_MultiPrintTimes() {
            return PS_MultiPrintTimes;
        }

        public void setPS_MultiPrintTimes(String PS_MultiPrintTimes) {
            this.PS_MultiPrintTimes = PS_MultiPrintTimes;
        }

        public String getPS_TipPrinterName() {
            return PS_TipPrinterName;
        }

        public void setPS_TipPrinterName(String PS_TipPrinterName) {
            this.PS_TipPrinterName = PS_TipPrinterName;
        }

        public int getPS_TipPrintTimes() {
            return PS_TipPrintTimes;
        }

        public void setPS_TipPrintTimes(int PS_TipPrintTimes) {
            this.PS_TipPrintTimes = PS_TipPrintTimes;
        }

        public int getPS_TipPrintPaper() {
            return PS_TipPrintPaper;
        }

        public void setPS_TipPrintPaper(int PS_TipPrintPaper) {
            this.PS_TipPrintPaper = PS_TipPrintPaper;
        }

        public List<PrintTimesListBean> getPrintTimesList() {
            return PrintTimesList;
        }

        public void setPrintTimesList(List<PrintTimesListBean> PrintTimesList) {
            this.PrintTimesList = PrintTimesList;
        }

        public List<MultiPrintTimesListBean> getMultiPrintTimesList() {
            return MultiPrintTimesList;
        }

        public void setMultiPrintTimesList(List<MultiPrintTimesListBean> MultiPrintTimesList) {
            this.MultiPrintTimesList = MultiPrintTimesList;
        }

        public static class PrintTimesListBean {
            /**
             * PT_Code : SPXF
             * PT_Times : 1
             */

            private String PT_Code;
            private int PT_Times;

            public String getPT_Code() {
                return PT_Code;
            }

            public void setPT_Code(String PT_Code) {
                this.PT_Code = PT_Code;
            }

            public int getPT_Times() {
                return PT_Times;
            }

            public void setPT_Times(int PT_Times) {
                this.PT_Times = PT_Times;
            }
        }

        public static class MultiPrintTimesListBean {
            /**
             * PT_Code : HYCC
             * PT_Times : 1
             */

            private String PT_Code;
            private int PT_Times;

            public String getPT_Code() {
                return PT_Code;
            }

            public void setPT_Code(String PT_Code) {
                this.PT_Code = PT_Code;
            }

            public int getPT_Times() {
                return PT_Times;
            }

            public void setPT_Times(int PT_Times) {
                this.PT_Times = PT_Times;
            }
        }
    }
}

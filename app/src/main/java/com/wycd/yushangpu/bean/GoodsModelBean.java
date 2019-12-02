package com.wycd.yushangpu.bean;

import java.io.Serializable;

/**
 * Created by ZPH on 2019-06-28.
 */

public class GoodsModelBean {

        /**
         * GID : 543ed187-b93a-4dae-bcc6-9077a1182d47
         * PM_Name : 颜色
         * PM_Properties :
         * PM_Type : 0
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * SM_Name : jll2
         * PM_Creator : 销售001
         * PM_CreateTime : 2019-04-12 14:51:35
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         */

        private String GID;
        private String PM_Name;
        private String PM_Properties;
        private int PM_Type;
        private String SM_GID;
        private String SM_Name;
        private String PM_Creator;
        private String PM_CreateTime;
        private String CY_GID;


        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        private boolean isChecked;

        public boolean isEnable() {
            return isEnable;
        }

        public void setEnable(boolean enable) {
            isEnable = enable;
        }

        private boolean isEnable;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getPM_Name() {
            return PM_Name;
        }

        public void setPM_Name(String PM_Name) {
            this.PM_Name = PM_Name;
        }

        public String getPM_Properties() {
            return PM_Properties;
        }

        public void setPM_Properties(String PM_Properties) {
            this.PM_Properties = PM_Properties;
        }

        public int getPM_Type() {
            return PM_Type;
        }

        public void setPM_Type(int PM_Type) {
            this.PM_Type = PM_Type;
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

        public String getPM_Creator() {
            return PM_Creator;
        }

        public void setPM_Creator(String PM_Creator) {
            this.PM_Creator = PM_Creator;
        }

        public String getPM_CreateTime() {
            return PM_CreateTime;
        }

        public void setPM_CreateTime(String PM_CreateTime) {
            this.PM_CreateTime = PM_CreateTime;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

}

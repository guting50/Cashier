package com.wycd.yushangpu.printutil.bean;

import java.util.List;

/**
 * 打印设置JavaBean
 * 作者：罗咏哲 on 2017/8/18 13:51.
 * 邮箱：137615198@qq.com
 */

public class PrintParamSetBean {

    private String GID;
    private String CY_GID;
    private String SM_GID;
    private String PT_Code;
    private String PT_Items;
    private Object PT_AllItems;
    private List<TemplateItemsBean> TemplateItems;

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
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

    public String getPT_Code() {
        return PT_Code;
    }

    public void setPT_Code(String PT_Code) {
        this.PT_Code = PT_Code;
    }

    public String getPT_Items() {
        return PT_Items;
    }

    public void setPT_Items(String PT_Items) {
        this.PT_Items = PT_Items;
    }

    public Object getPT_AllItems() {
        return PT_AllItems;
    }

    public void setPT_AllItems(Object PT_AllItems) {
        this.PT_AllItems = PT_AllItems;
    }

    public List<TemplateItemsBean> getTemplateItems() {
        return TemplateItems;
    }

    public void setTemplateItems(List<TemplateItemsBean> TemplateItems) {
        this.TemplateItems = TemplateItems;
    }

    public static class TemplateItemsBean {
        /**
         * ItemName : LOGO
         * ItemValue : /FileUpload/131457988652166839.jpg
         */

        private String ItemName;
        private String ItemValue;

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String ItemName) {
            this.ItemName = ItemName;
        }

        public String getItemValue() {
            return ItemValue;
        }

        public void setItemValue(String ItemValue) {
            this.ItemValue = ItemValue;
        }
    }
}

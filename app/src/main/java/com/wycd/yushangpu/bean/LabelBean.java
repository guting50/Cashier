package com.wycd.yushangpu.bean;

import java.io.Serializable;

/**
 * 会员标签
 * 作者：罗咏哲 on 2017/11/30 16:46.
 * 邮箱：137615198@qq.com
 */

public class LabelBean implements Serializable {
    /**
     * ItemGID : b6fc7452-5152-4e77-90ce-25d54c24daf2
     * ItemName : 活跃客户
     * ItemColor : #33cccc
     */

    private String ItemGID;
    private String ItemName;
    private String ItemColor;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;

    public String getItemGID() {
        return ItemGID;
    }

    public void setItemGID(String ItemGID) {
        this.ItemGID = ItemGID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemColor() {
        return ItemColor;
    }

    public void setItemColor(String ItemColor) {
        this.ItemColor = ItemColor;
    }
}

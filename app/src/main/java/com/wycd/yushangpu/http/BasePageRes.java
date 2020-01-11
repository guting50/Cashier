package com.wycd.yushangpu.http;

import com.gt.utils.GsonUtils;

import java.lang.reflect.Type;

public class BasePageRes {

    /**
     * PageTotal : 3
     * PageSize : 50
     * DataCount : 103
     * PageIndex : 3
     * DataList : [{}]
     */

    private int PageTotal;
    private int PageSize;
    private int DataCount;
    private int PageIndex;
    private Object DataList;

    public int getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(int PageTotal) {
        this.PageTotal = PageTotal;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getDataCount() {
        return DataCount;
    }

    public void setDataCount(int DataCount) {
        this.DataCount = DataCount;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public Object getDataList() {
        return DataList;
    }

    public void setDataList(Object DataList) {
        this.DataList = DataList;
    }

    public <T> T getData(Type type) {
        return GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(DataList), type);
    }
}

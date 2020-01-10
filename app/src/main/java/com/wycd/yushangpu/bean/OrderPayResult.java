package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class OrderPayResult implements Serializable {
    private double GiveChange;//	找零金额	decimal
    private double PayTotalMoney;//	 实收金额	decimal
    private double DisMoney;//	应收金额	decimal
    private double molingMoney;//	抹零金额	decimal
    private boolean isPrint;//	是否打印
    private List<PayType> PayTypeList;//	 支付方式	List<PayType>
    private List<YhqMsg> yhqList;//	 优惠券
    private ReportMessageBean.ActiveBean active;// 优惠活动

    public List<PayType> getPayTypeList() {
        return PayTypeList;
    }

    public void setPayTypeList(List<PayType> payTypeList) {
        PayTypeList = payTypeList;
    }

    public double getGiveChange() {
        return GiveChange;
    }

    public void setGiveChange(double giveChange) {
        GiveChange = giveChange;
    }

    public double getPayTotalMoney() {
        return PayTotalMoney;
    }

    public void setPayTotalMoney(double payTotalMoney) {
        PayTotalMoney = payTotalMoney;
    }

    public double getDisMoney() {
        return DisMoney;
    }

    public void setDisMoney(double disMoney) {
        DisMoney = disMoney;
    }

    public double getMolingMoney() {
        return molingMoney;
    }

    public void setMolingMoney(double molingMoney) {
        this.molingMoney = molingMoney;
    }

    public boolean isPrint() {
        return isPrint;
    }

    public void setPrint(boolean print) {
        isPrint = print;
    }

    public List<YhqMsg> getYhqList() {
        return yhqList;
    }

    public void setYhqList(List<YhqMsg> yhqList) {
        this.yhqList = yhqList;
    }

    public ReportMessageBean.ActiveBean getActive() {
        return active;
    }

    public void setActive(ReportMessageBean.ActiveBean active) {
        this.active = active;
    }
}

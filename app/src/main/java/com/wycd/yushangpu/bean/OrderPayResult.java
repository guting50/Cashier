package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class OrderPayResult implements Serializable {
   private  List<PayType> PayTypeList;//	 支付方式	List<PayType>
  private double  GiveChange;//	找零金额	decimal
    private double  PayTotalMoney;//	 实收金额	decimal
    private double  DisMoney;//	应收金额	decimal

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
}

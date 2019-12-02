package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class ShopMsg implements Serializable {

    private String PM_GroupGID;//	商品组GID
    private String GroupCount;//	组商品数
    private String GID;//	商品GID	string
    private String PT_ID;//	分类ID	string
    private String SM_ID;//	所属店铺	string
    private String PT_Name;//	分类名	string
    private String PM_Code;//	商品编码	string
    private String PM_Name;//	商品名	string
    private String PM_SimpleCode;//	商品简码	string
    private String PM_Metering;//	计量单位	string
    private double PM_UnitPrice;//	商品单价	float?
    private String PM_BigImg;//	商品大图地址	string
    private String PM_SmallImg;//	商品小图地址	string
    private String PM_Description;//	商品说明	string
    private String PM_Modle;//	规格型号	string
    private String PM_Brand;//	品牌	string
    private double PM_Repertory;//	商品库存	decimal
    private double Stock_Number;//	库存值	decimal
    private double currtStock_Number;//	显示库存值	decimal
    private double PM_PurchasePrice;//	参考进价	decimal
    private String PM_MemPrice;//	会员价格	decimal?
    private int PM_IsDiscount;//	商品折扣	int
    private int PM_IsPoint;//	商品积分	int
    private int PM_IsService;//	商品类型	int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
    private String SP_GID;//	库存GID	string
    private double PM_SpecialOfferMoney; //特价金额值
    private double PM_SpecialOfferValue;//	特价折扣开关的值	decimal
    private double PM_MinDisCountValue;//	最低折扣开关的值	decimal
    private double PM_FixedIntegralValue;//	固定积分开关的值	decimal
    private List<String> EM_GIDList;//	提成员工	List<string>
    private String EM_NameList;//	提成员工	List<string>
    private double num;
    private int chosePosion;
    private double allprice;//折后总价
    private double PD_Discount; //会员等级折扣
    private double jisuanPrice;//折后单价
    private double EachPoint;//每个商品积分
    private boolean isCheck;//是否选中
    private boolean hasvipDiscount; //是否会员折扣
    private boolean isgive;//是否赠送
    private int Type;
    private boolean ischanged;//是否手动修改

    public boolean isIschanged() {
        return ischanged;
    }

    public void setIschanged(boolean ischanged) {
        this.ischanged = ischanged;
    }

    public double getEachPoint() {
        return EachPoint;
    }

    public void setEachPoint(double eachPoint) {
        EachPoint = eachPoint;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public boolean isIsgive() {
        return isgive;
    }

    public void setIsgive(boolean isgive) {
        this.isgive = isgive;
    }



    public boolean isHasvipDiscount() {
        return hasvipDiscount;
    }

    public void setHasvipDiscount(boolean hasvipDiscount) {
        this.hasvipDiscount = hasvipDiscount;
    }



    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public List<String> getEM_GIDList() {
        return EM_GIDList;
    }

    public void setEM_GIDList(List<String> EM_GIDList) {
        this.EM_GIDList = EM_GIDList;
    }

    public String getEM_NameList() {
        return EM_NameList;
    }

    public void setEM_NameList(String EM_NameList) {
        this.EM_NameList = EM_NameList;
    }

    public double getJisuanPrice() {
        return jisuanPrice;
    }

    public void setJisuanPrice(double jisuanPrice) {
        this.jisuanPrice = jisuanPrice;
    }

    public double getPD_Discount() {
        return PD_Discount;
    }

    public void setPD_Discount(double PD_Discount) {
        this.PD_Discount = PD_Discount;
    }

    public double getPM_SpecialOfferMoney() {
        return PM_SpecialOfferMoney;
    }

    public void setPM_SpecialOfferMoney(double PM_SpecialOfferMoney) {
        this.PM_SpecialOfferMoney = PM_SpecialOfferMoney;
    }

    public double getPM_SpecialOfferValue() {
        return PM_SpecialOfferValue;
    }

    public void setPM_SpecialOfferValue(double PM_SpecialOfferValue) {
        this.PM_SpecialOfferValue = PM_SpecialOfferValue;
    }

    public double getPM_MinDisCountValue() {
        return PM_MinDisCountValue;
    }

    public void setPM_MinDisCountValue(double PM_MinDisCountValue) {
        this.PM_MinDisCountValue = PM_MinDisCountValue;
    }

    public double getPM_FixedIntegralValue() {
        return PM_FixedIntegralValue;
    }

    public void setPM_FixedIntegralValue(double PM_FixedIntegralValue) {
        this.PM_FixedIntegralValue = PM_FixedIntegralValue;
    }

    public double getAllprice() {
        return allprice;
    }

    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }

    public int getChosePosion() {
        return chosePosion;
    }

    public void setChosePosion(int chosePosion) {
        this.chosePosion = chosePosion;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getPM_GroupGID() {
        return PM_GroupGID;
    }

    public void setPM_GroupGID(String PM_GroupGID) {
        this.PM_GroupGID = PM_GroupGID;
    }

    public String getGroupCount() {
        return GroupCount;
    }

    public void setGroupCount(String groupCount) {
        GroupCount = groupCount;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getPT_ID() {
        return PT_ID;
    }

    public void setPT_ID(String PT_ID) {
        this.PT_ID = PT_ID;
    }

    public String getSM_ID() {
        return SM_ID;
    }

    public void setSM_ID(String SM_ID) {
        this.SM_ID = SM_ID;
    }

    public String getPT_Name() {
        return PT_Name;
    }

    public void setPT_Name(String PT_Name) {
        this.PT_Name = PT_Name;
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

    public String getPM_BigImg() {
        return PM_BigImg;
    }

    public void setPM_BigImg(String PM_BigImg) {
        this.PM_BigImg = PM_BigImg;
    }

    public String getPM_SmallImg() {
        return PM_SmallImg;
    }

    public void setPM_SmallImg(String PM_SmallImg) {
        this.PM_SmallImg = PM_SmallImg;
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

    public double getPM_Repertory() {
        return PM_Repertory;
    }

    public void setPM_Repertory(double PM_Repertory) {
        this.PM_Repertory = PM_Repertory;
    }

    public double getStock_Number() {
        return Stock_Number;
    }

    public void setStock_Number(double stock_Number) {
        Stock_Number = stock_Number;
    }

    public double getCurrtStock_Number() {
        return currtStock_Number;
    }

    public void setCurrtStock_Number(double currtStock_Number) {
        this.currtStock_Number = currtStock_Number;
    }


    public double getPM_PurchasePrice() {
        return PM_PurchasePrice;
    }

    public void setPM_PurchasePrice(double PM_PurchasePrice) {
        this.PM_PurchasePrice = PM_PurchasePrice;
    }

    public String getPM_MemPrice() {
        return PM_MemPrice;
    }

    public void setPM_MemPrice(String PM_MemPrice) {
        this.PM_MemPrice = PM_MemPrice;
    }

    public int getPM_IsDiscount() {
        return PM_IsDiscount;
    }

    public void setPM_IsDiscount(int PM_IsDiscount) {
        this.PM_IsDiscount = PM_IsDiscount;
    }

    public int getPM_IsPoint() {
        return PM_IsPoint;
    }

    public void setPM_IsPoint(int PM_IsPoint) {
        this.PM_IsPoint = PM_IsPoint;
    }

    public int getPM_IsService() {
        return PM_IsService;
    }

    public void setPM_IsService(int PM_IsService) {
        this.PM_IsService = PM_IsService;
    }

    public String getSP_GID() {
        return SP_GID;
    }

    public void setSP_GID(String SP_GID) {
        this.SP_GID = SP_GID;
    }
}

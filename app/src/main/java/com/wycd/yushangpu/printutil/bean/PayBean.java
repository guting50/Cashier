package com.wycd.yushangpu.printutil.bean;

/**
 * 结算支付bean
 * iauthor：Yc
 * date: 2017/7/26 10:26
 * email：jasoncheng9111@gmail.com
 */
public class PayBean
{
    private String mMemberCardNo;//会员卡号
    private String mOrderNo;//订单号
    private double mOrderMoney;//订单金额
    private double mDiscountMoney;//折后金额
    private double mGiveChangeMoney;//找零金额
    private double mGetPoints;//获得积分
    private String mMemberName;//会员姓名

    private double mUsablePoint;//可用积分
    private String mPayType;//支付类型

    private double mPointSpend;//积分消费
    private String mRemark;//备注
    private String mPayWayName;//支付方式名称
    private String mPayWayCode;//支付方式代码

    private int mOrderType;//支付类型（会员 1，散客 2）
    private int mConsumeType;//消费优惠类型（1：充值优惠，2：消费优惠）
    private double mGiveMoney;//赠送金额
    private double mRechargeMoney;//充值金额
    private double mRechargeTotal;//充值合计（充值金额+赠送金额）
    private String mSG_GID;//服务GID
    private String mSG_Name;//服务名字
    private int mMC_Number;//充值服务次数

    private double mServicePrice;//服务单价
    private int mOperationNumber;//操作次数
    private int mResidueDegree;//剩余次数

    private String mMaccode;//蓝牙地址
    private String mOperator;//操作人员
    private String mShopName;//店铺名称


    public double getServicePrice()
    {
        return mServicePrice;
    }

    public void setServicePrice(double servicePrice)
    {
        mServicePrice = servicePrice;
    }

    public int getOperationNumber()
    {
        return mOperationNumber;
    }

    public void setOperationNumber(int operationNumber)
    {
        mOperationNumber = operationNumber;
    }

    public int getResidueDegree()
    {
        return mResidueDegree;
    }

    public void setResidueDegree(int residueDegree)
    {
        mResidueDegree = residueDegree;
    }

    public double getGiveChangeMoney()
    {
        return mGiveChangeMoney;
    }

    public void setGiveChangeMoney(double giveChangeMoney)
    {
        mGiveChangeMoney = giveChangeMoney;
    }

    public String getMaccode()
    {
        return mMaccode;
    }

    public void setMaccode(String maccode)
    {
        mMaccode = maccode;
    }

    public String getOperator()
    {
        return mOperator;
    }

    public void setOperator(String operator)
    {
        mOperator = operator;
    }

    public String getShopName()
    {
        return mShopName;
    }

    public void setShopName(String shopName)
    {
        mShopName = shopName;
    }

    public String getMemberCardNo()
    {
        return mMemberCardNo;
    }

    public void setMemberCardNo(String memberCardNo)
    {
        mMemberCardNo = memberCardNo;
    }

    public String getOrderNo()
    {
        return mOrderNo;
    }

    public void setOrderNo(String orderNo)
    {
        mOrderNo = orderNo;
    }

    public double getOrderMoney()
    {
        return mOrderMoney;
    }

    public void setOrderMoney(double orderMoney)
    {
        mOrderMoney = orderMoney;
    }

    public double getDiscountMoney()
    {
        return mDiscountMoney;
    }

    public void setDiscountMoney(double discountMoney)
    {
        mDiscountMoney = discountMoney;
    }

    public double getGetPoints()
    {
        return mGetPoints;
    }

    public void setGetPoints(double getPoints)
    {
        mGetPoints = getPoints;
    }

    public String getMemberName()
    {
        return mMemberName;
    }

    public void setMemberName(String memberName)
    {
        mMemberName = memberName;
    }

    public double getUsablePoint()
    {
        return mUsablePoint;
    }

    public void setUsablePoint(double usablePoint)
    {
        mUsablePoint = usablePoint;
    }

    public String getPayType()
    {
        return mPayType;
    }

    public void setPayType(String payType)
    {
        mPayType = payType;
    }

    public double getPointSpend()
    {
        return mPointSpend;
    }

    public void setPointSpend(double pointSpend)
    {
        mPointSpend = pointSpend;
    }

    public String getRemark()
    {
        return mRemark;
    }

    public void setRemark(String remark)
    {
        mRemark = remark;
    }

    public String getPayWayName()
    {
        return mPayWayName;
    }

    public void setPayWayName(String payWayName)
    {
        mPayWayName = payWayName;
    }

    public String getPayWayCode()
    {
        return mPayWayCode;
    }

    public void setPayWayCode(String payWayCode)
    {
        mPayWayCode = payWayCode;
    }

    public int getOrderType()
    {
        return mOrderType;
    }

    public void setOrderType(int orderType)
    {
        mOrderType = orderType;
    }

    public int getConsumeType()
    {
        return mConsumeType;
    }

    public void setConsumeType(int consumeType)
    {
        mConsumeType = consumeType;
    }

    public double getGiveMoney()
    {
        return mGiveMoney;
    }

    public void setGiveMoney(double giveMoney)
    {
        mGiveMoney = giveMoney;
    }

    public double getRechargeMoney()
    {
        return mRechargeMoney;
    }

    public void setRechargeMoney(double rechargeMoney)
    {
        mRechargeMoney = rechargeMoney;
    }

    public double getRechargeTotal()
    {
        return mRechargeTotal;
    }

    public void setRechargeTotal(double rechargeTotal)
    {
        mRechargeTotal = rechargeTotal;
    }

    public String getSG_GID()
    {
        return mSG_GID;
    }

    public void setSG_GID(String SG_GID)
    {
        mSG_GID = SG_GID;
    }

    public String getSG_Name()
    {
        return mSG_Name;
    }

    public void setSG_Name(String SG_Name)
    {
        mSG_Name = SG_Name;
    }

    public int getMC_Number()
    {
        return mMC_Number;
    }

    public void setMC_Number(int MC_Number)
    {
        mMC_Number = MC_Number;
    }
}



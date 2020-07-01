package com.wycd.yushangpu.bean;

import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * Created by YSL on 2018-08-28.
 * 登录获取所有相关数据设置
 */

public class ReportMessageBean implements Serializable {

    private Object MberList;
    private Object GoodsList;
    private SmssignBean Smssign;
    private PrintSetBean PrintSet;
    private List<GetCustomFieldsVIPBean> GetCustomFieldsVIP;
    private List<GetCustomFieldsBean> GetCustomFields;
    private List<GetLoginHistoryListBean> GetLoginHistoryList;
    private List<SysSwitchRes> GetSysSwitchList;
    private List<VIPGradeListBean> VIPGradeList;
    private List<EmplistBean> Emplist;
    private List<DepartmentListBean> DepartmentList;
    private List<ShopListBean> ShopList;
    private List<DeductRuleBean> DeductRule;
    private List<ActiveBean> Active;

    public Object getMberList() {
        return MberList;
    }

    public void setMberList(Object MberList) {
        this.MberList = MberList;
    }

    public Object getGoodsList() {
        return GoodsList;
    }

    public void setGoodsList(Object GoodsList) {
        this.GoodsList = GoodsList;
    }

    public SmssignBean getSmssign() {
        return Smssign;
    }

    public void setSmssign(SmssignBean Smssign) {
        this.Smssign = Smssign;
    }

    public PrintSetBean getPrintSet() {
        return PrintSet;
    }

    public void setPrintSet(PrintSetBean PrintSet) {
        this.PrintSet = PrintSet;
    }

    public List<GetCustomFieldsVIPBean> getGetCustomFieldsVIP() {
        Type listType = new TypeToken<List<GetCustomFieldsVIPBean>>() {
        }.getType();
        return GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(GetCustomFieldsVIP), listType);
    }

    public void setGetCustomFieldsVIP(List<GetCustomFieldsVIPBean> GetCustomFieldsVIP) {
        this.GetCustomFieldsVIP = GetCustomFieldsVIP;
    }

    public List<GetCustomFieldsBean> getGetCustomFields() {
        return GetCustomFields;
    }

    public void setGetCustomFields(List<GetCustomFieldsBean> GetCustomFields) {
        this.GetCustomFields = GetCustomFields;
    }

    public List<GetLoginHistoryListBean> getGetLoginHistoryList() {
        return GetLoginHistoryList;
    }

    public void setGetLoginHistoryList(List<GetLoginHistoryListBean> GetLoginHistoryList) {
        this.GetLoginHistoryList = GetLoginHistoryList;
    }

    public List<SysSwitchRes> getGetSysSwitchList() {
        Type listType = new TypeToken<List<SysSwitchRes>>() {
        }.getType();
        return GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(GetSysSwitchList), listType);
    }

    public void setGetSysSwitchList(List<SysSwitchRes> GetSysSwitchList) {
        this.GetSysSwitchList = GetSysSwitchList;
    }

    public List<VIPGradeListBean> getVIPGradeList() {
        Type listType = new TypeToken<List<VIPGradeListBean>>() {
        }.getType();
        return GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(VIPGradeList), listType);
    }

    public void setVIPGradeList(List<VIPGradeListBean> VIPGradeList) {
        this.VIPGradeList = VIPGradeList;
    }

    public List<EmplistBean> getEmplist() {
        return Emplist;
    }

    public void setEmplist(List<EmplistBean> Emplist) {
        this.Emplist = Emplist;
    }

    public List<DepartmentListBean> getDepartmentList() {
        return DepartmentList;
    }

    public void setDepartmentList(List<DepartmentListBean> DepartmentList) {
        this.DepartmentList = DepartmentList;
    }

    public List<ShopListBean> getShopList() {
        return ShopList;
    }

    public void setShopList(List<ShopListBean> ShopList) {
        this.ShopList = ShopList;
    }

    public List<DeductRuleBean> getDeductRule() {
        return DeductRule;
    }

    public void setDeductRule(List<DeductRuleBean> DeductRule) {
        this.DeductRule = DeductRule;
    }

    public List<ActiveBean> getActive() {
        return Active;
    }

    public List<ActiveBean> getActiveOth() {
        Type listType = new TypeToken<List<ActiveBean>>() {
        }.getType();
        return GsonUtils.getGson().fromJson(GsonUtils.getGson().toJson(Active), listType);
    }

    public void setActive(List<ActiveBean> Active) {
        this.Active = Active;
    }

    public static class SmssignBean implements Serializable {
        /**
         * GID : 28c31384-47bf-48d0-8295-502b5326716f
         * SM_Name : 85785
         * SM_State : 1
         * SM_Remark : null
         * SM_Creator : 1058346971@qq.com
         * SM_Update : 分号1
         * SM_CreatorTime : 2018-06-29 15:46:03
         * SM_UpdateTime : 2019-03-20 11:03:44
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         */

        private String GID;
        private String SM_Name;
        private int SM_State;
        private Object SM_Remark;
        private String SM_Creator;
        private String SM_Update;
        private String SM_CreatorTime;
        private String SM_UpdateTime;
        private String CY_GID;
        private String SM_GID;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getSM_Name() {
            return SM_Name;
        }

        public void setSM_Name(String SM_Name) {
            this.SM_Name = SM_Name;
        }

        public int getSM_State() {
            return SM_State;
        }

        public void setSM_State(int SM_State) {
            this.SM_State = SM_State;
        }

        public Object getSM_Remark() {
            return SM_Remark;
        }

        public void setSM_Remark(Object SM_Remark) {
            this.SM_Remark = SM_Remark;
        }

        public String getSM_Creator() {
            return SM_Creator;
        }

        public void setSM_Creator(String SM_Creator) {
            this.SM_Creator = SM_Creator;
        }

        public String getSM_Update() {
            return SM_Update;
        }

        public void setSM_Update(String SM_Update) {
            this.SM_Update = SM_Update;
        }

        public String getSM_CreatorTime() {
            return SM_CreatorTime;
        }

        public void setSM_CreatorTime(String SM_CreatorTime) {
            this.SM_CreatorTime = SM_CreatorTime;
        }

        public String getSM_UpdateTime() {
            return SM_UpdateTime;
        }

        public void setSM_UpdateTime(String SM_UpdateTime) {
            this.SM_UpdateTime = SM_UpdateTime;
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
    }

    public static class GetCustomFieldsVIPBean implements Serializable {
        /**
         * CF_GID : 34f6c04b-e516-42f5-902a-f7b31f9bcf7a
         * CF_FieldName : 办卡日期
         * CF_FieldType : 日期
         * CF_ItemsValue :
         * CF_Value :
         * CF_Required : 是
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * VIP_GID : 1
         * CF_CreateUser : 销售001
         * CF_CreateTime : 2018-10-29 15:40:27
         * CF_Order : 5
         * CF_IsShowVIP : 1
         */

        private String CF_GID;
        private String CF_FieldName;
        private String CF_FieldType;
        private String CF_ItemsValue;
        private String CF_Value;
        private String CF_Required;
        private String CY_GID;
        private String VIP_GID;
        private String CF_CreateUser;
        private String CF_CreateTime;
        private int CF_Order;
        private int CF_IsShowVIP;

        public String getM_ItemsValue() {
            return M_ItemsValue;
        }

        public void setM_ItemsValue(String m_ItemsValue) {
            M_ItemsValue = m_ItemsValue;
        }

        private String M_ItemsValue;

        public String getCF_GID() {
            return CF_GID;
        }

        public void setCF_GID(String CF_GID) {
            this.CF_GID = CF_GID;
        }

        public String getCF_FieldName() {
            return CF_FieldName;
        }

        public void setCF_FieldName(String CF_FieldName) {
            this.CF_FieldName = CF_FieldName;
        }

        public String getCF_FieldType() {
            return CF_FieldType;
        }

        public void setCF_FieldType(String CF_FieldType) {
            this.CF_FieldType = CF_FieldType;
        }

        public String getCF_ItemsValue() {
            return CF_ItemsValue;
        }

        public void setCF_ItemsValue(String CF_ItemsValue) {
            this.CF_ItemsValue = CF_ItemsValue;
        }

        public String getCF_Value() {
            return CF_Value;
        }

        public void setCF_Value(String CF_Value) {
            this.CF_Value = CF_Value;
        }

        public String getCF_Required() {
            return CF_Required;
        }

        public void setCF_Required(String CF_Required) {
            this.CF_Required = CF_Required;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getVIP_GID() {
            return VIP_GID;
        }

        public void setVIP_GID(String VIP_GID) {
            this.VIP_GID = VIP_GID;
        }

        public String getCF_CreateUser() {
            return CF_CreateUser;
        }

        public void setCF_CreateUser(String CF_CreateUser) {
            this.CF_CreateUser = CF_CreateUser;
        }

        public String getCF_CreateTime() {
            return CF_CreateTime;
        }

        public void setCF_CreateTime(String CF_CreateTime) {
            this.CF_CreateTime = CF_CreateTime;
        }

        public int getCF_Order() {
            return CF_Order;
        }

        public void setCF_Order(int CF_Order) {
            this.CF_Order = CF_Order;
        }

        public int getCF_IsShowVIP() {
            return CF_IsShowVIP;
        }

        public void setCF_IsShowVIP(int CF_IsShowVIP) {
            this.CF_IsShowVIP = CF_IsShowVIP;
        }
    }

    public static class GetCustomFieldsBean implements Serializable {
        /**
         * CF_Order : 3
         * CF_GID : d024aa5c-63ef-4ca3-b316-0cad2dc3965b
         * CF_FieldName : 备注
         * CF_FieldType : 文本
         * CF_ItemsValue :
         * CF_Value :
         * CF_Required : 是
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * VIP_GID :
         * PM_GID : 1
         * CF_CreateUser : 销售001
         * CF_CreateTime : 2018-10-30 09:24:01
         */

        private int CF_Order;
        private String CF_GID;
        private String CF_FieldName;
        private String CF_FieldType;
        private String CF_ItemsValue;
        private String CF_Value;
        private String CF_Required;
        private String CY_GID;
        private String VIP_GID;
        private String PM_GID;
        private String CF_CreateUser;
        private String CF_CreateTime;

        public int getCF_Order() {
            return CF_Order;
        }

        public void setCF_Order(int CF_Order) {
            this.CF_Order = CF_Order;
        }

        public String getCF_GID() {
            return CF_GID;
        }

        public void setCF_GID(String CF_GID) {
            this.CF_GID = CF_GID;
        }

        public String getCF_FieldName() {
            return CF_FieldName;
        }

        public void setCF_FieldName(String CF_FieldName) {
            this.CF_FieldName = CF_FieldName;
        }

        public String getCF_FieldType() {
            return CF_FieldType;
        }

        public void setCF_FieldType(String CF_FieldType) {
            this.CF_FieldType = CF_FieldType;
        }

        public String getCF_ItemsValue() {
            return CF_ItemsValue;
        }

        public void setCF_ItemsValue(String CF_ItemsValue) {
            this.CF_ItemsValue = CF_ItemsValue;
        }

        public String getCF_Value() {
            return CF_Value;
        }

        public void setCF_Value(String CF_Value) {
            this.CF_Value = CF_Value;
        }

        public String getCF_Required() {
            return CF_Required;
        }

        public void setCF_Required(String CF_Required) {
            this.CF_Required = CF_Required;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getVIP_GID() {
            return VIP_GID;
        }

        public void setVIP_GID(String VIP_GID) {
            this.VIP_GID = VIP_GID;
        }

        public String getPM_GID() {
            return PM_GID;
        }

        public void setPM_GID(String PM_GID) {
            this.PM_GID = PM_GID;
        }

        public String getCF_CreateUser() {
            return CF_CreateUser;
        }

        public void setCF_CreateUser(String CF_CreateUser) {
            this.CF_CreateUser = CF_CreateUser;
        }

        public String getCF_CreateTime() {
            return CF_CreateTime;
        }

        public void setCF_CreateTime(String CF_CreateTime) {
            this.CF_CreateTime = CF_CreateTime;
        }
    }

    public static class GetLoginHistoryListBean implements Serializable {
        /**
         * GID : null
         * CY_GID : null
         * SM_GID : null
         * LM_Account : 18328578333
         * LM_IP : 171.216.70.29
         * LM_Area : 未能解析IP:171.216.70.29
         * LM_Time : 2019-03-30 14:20:57
         * LM_Type : 苹果APP
         */

        private Object GID;
        private Object CY_GID;
        private Object SM_GID;
        private String LM_Account;
        private String LM_IP;
        private String LM_Area;
        private String LM_Time;
        private String LM_Type;

        public Object getGID() {
            return GID;
        }

        public void setGID(Object GID) {
            this.GID = GID;
        }

        public Object getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(Object CY_GID) {
            this.CY_GID = CY_GID;
        }

        public Object getSM_GID() {
            return SM_GID;
        }

        public void setSM_GID(Object SM_GID) {
            this.SM_GID = SM_GID;
        }

        public String getLM_Account() {
            return LM_Account;
        }

        public void setLM_Account(String LM_Account) {
            this.LM_Account = LM_Account;
        }

        public String getLM_IP() {
            return LM_IP;
        }

        public void setLM_IP(String LM_IP) {
            this.LM_IP = LM_IP;
        }

        public String getLM_Area() {
            return LM_Area;
        }

        public void setLM_Area(String LM_Area) {
            this.LM_Area = LM_Area;
        }

        public String getLM_Time() {
            return LM_Time;
        }

        public void setLM_Time(String LM_Time) {
            this.LM_Time = LM_Time;
        }

        public String getLM_Type() {
            return LM_Type;
        }

        public void setLM_Type(String LM_Type) {
            this.LM_Type = LM_Type;
        }
    }

    public static class VIPGradeListBean implements Serializable {
        /**
         * VG_IsDownLock : 0
         * VG_UpDownType : 0
         * VG_NextGradeName : 默认等级
         * VG_NextGradeGID : 45a168cb-493e-43b7-8cfc-730ef4da27c7
         * VG_LastGradeName :
         * VG_LastGradeGID :
         * US_ValueMax : 9.0
         * VG_IsTimeTimes : 1
         * GID : 3df0f677-442e-43ef-8706-18a54d7a2ded
         * US_Code : IntegerFulfil
         * US_Value : 1.0
         * VG_Name : 等级
         * VG_Code :
         * VG_CardAmount : 10.0
         * VG_InitialAmount : 0.0
         * VG_InitialIntegral : 0.0
         * VG_IsLock : 1
         * VG_IsAccount : 0
         * VG_IsIntegral : 0
         * VG_IsDiscount : 0
         * VG_IsCount : 0
         * VG_IsTime : 1
         * VG_IsTimeNum : 1
         * VG_IsTimeUnit : 天
         * VG_Remark :
         * VG_IntegralUniformRuleValue : 0.0
         * VG_IntegralRuleType : 1
         * VG_DiscountUniformRuleValue : 0
         * VG_DiscountRuleType : 1
         * DS_Value : 0.0
         * RS_CMoney : 0.0
         * RS_Value : 0.0
         * VS_CMoney : 0.0
         * VS_Value : 0.0
         * US_Name : 积分达到
         */

        private int VG_IsDownLock;
        private Integer VG_UpDownType;
        private String VG_NextGradeName;
        private String VG_NextGradeGID;
        private String VG_LastGradeName;
        private String VG_LastGradeGID;
        private String US_ValueMax;
        private Integer VG_IsTimeTimes;
        private String GID;
        private String US_Code;
        private double US_Value;
        private String VG_Name;
        private String VG_Code;
        private double VG_CardAmount;
        private double VG_InitialAmount;
        private double VG_InitialIntegral;
        private int VG_IsLock;
        private int VG_IsAccount;
        private int VG_IsIntegral;
        private int VG_IsDiscount;
        private int VG_IsCount;
        private int VG_IsTime;
        private String VG_IsTimeNum;
        private String VG_IsTimeUnit;
        private String VG_Remark;
        private double VG_IntegralUniformRuleValue;
        private int VG_IntegralRuleType;
        private int VG_DiscountUniformRuleValue;
        private int VG_DiscountRuleType;
        private double DS_Value;
        private double RS_CMoney;
        private double RS_Value;
        private double VS_CMoney;
        private double VS_Value;
        private String US_Name;
        private List<SettingsBean> Settings;
        private List<?> InitServiceList;

        public int getVG_IsDownLock() {
            return VG_IsDownLock;
        }

        public void setVG_IsDownLock(int VG_IsDownLock) {
            this.VG_IsDownLock = VG_IsDownLock;
        }

        public Integer getVG_UpDownType() {
            return VG_UpDownType;
        }

        public void setVG_UpDownType(Integer VG_UpDownType) {
            this.VG_UpDownType = VG_UpDownType;
        }

        public String getVG_NextGradeName() {
            return VG_NextGradeName;
        }

        public void setVG_NextGradeName(String VG_NextGradeName) {
            this.VG_NextGradeName = VG_NextGradeName;
        }

        public String getVG_NextGradeGID() {
            return VG_NextGradeGID;
        }

        public void setVG_NextGradeGID(String VG_NextGradeGID) {
            this.VG_NextGradeGID = VG_NextGradeGID;
        }

        public String getVG_LastGradeName() {
            return VG_LastGradeName;
        }

        public void setVG_LastGradeName(String VG_LastGradeName) {
            this.VG_LastGradeName = VG_LastGradeName;
        }

        public String getVG_LastGradeGID() {
            return VG_LastGradeGID;
        }

        public void setVG_LastGradeGID(String VG_LastGradeGID) {
            this.VG_LastGradeGID = VG_LastGradeGID;
        }

        public String getUS_ValueMax() {
            return US_ValueMax;
        }

        public void setUS_ValueMax(String US_ValueMax) {
            this.US_ValueMax = US_ValueMax;
        }

        public Integer getVG_IsTimeTimes() {
            return VG_IsTimeTimes;
        }

        public void setVG_IsTimeTimes(Integer VG_IsTimeTimes) {
            this.VG_IsTimeTimes = VG_IsTimeTimes;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getUS_Code() {
            return US_Code;
        }

        public void setUS_Code(String US_Code) {
            this.US_Code = US_Code;
        }

        public double getUS_Value() {
            return US_Value;
        }

        public void setUS_Value(double US_Value) {
            this.US_Value = US_Value;
        }

        public String getVG_Name() {
            return VG_Name;
        }

        public void setVG_Name(String VG_Name) {
            this.VG_Name = VG_Name;
        }

        public String getVG_Code() {
            return VG_Code;
        }

        public void setVG_Code(String VG_Code) {
            this.VG_Code = VG_Code;
        }

        public double getVG_CardAmount() {
            return VG_CardAmount;
        }

        public void setVG_CardAmount(double VG_CardAmount) {
            this.VG_CardAmount = VG_CardAmount;
        }

        public double getVG_InitialAmount() {
            return VG_InitialAmount;
        }

        public void setVG_InitialAmount(double VG_InitialAmount) {
            this.VG_InitialAmount = VG_InitialAmount;
        }

        public double getVG_InitialIntegral() {
            return VG_InitialIntegral;
        }

        public void setVG_InitialIntegral(double VG_InitialIntegral) {
            this.VG_InitialIntegral = VG_InitialIntegral;
        }

        public int getVG_IsLock() {
            return VG_IsLock;
        }

        public void setVG_IsLock(int VG_IsLock) {
            this.VG_IsLock = VG_IsLock;
        }

        public int getVG_IsAccount() {
            return VG_IsAccount;
        }

        public void setVG_IsAccount(int VG_IsAccount) {
            this.VG_IsAccount = VG_IsAccount;
        }

        public int getVG_IsIntegral() {
            return VG_IsIntegral;
        }

        public void setVG_IsIntegral(int VG_IsIntegral) {
            this.VG_IsIntegral = VG_IsIntegral;
        }

        public int getVG_IsDiscount() {
            return VG_IsDiscount;
        }

        public void setVG_IsDiscount(int VG_IsDiscount) {
            this.VG_IsDiscount = VG_IsDiscount;
        }

        public int getVG_IsCount() {
            return VG_IsCount;
        }

        public void setVG_IsCount(int VG_IsCount) {
            this.VG_IsCount = VG_IsCount;
        }

        public int getVG_IsTime() {
            return VG_IsTime;
        }

        public void setVG_IsTime(int VG_IsTime) {
            this.VG_IsTime = VG_IsTime;
        }

        public String getVG_IsTimeNum() {
            return VG_IsTimeNum;
        }

        public void setVG_IsTimeNum(String VG_IsTimeNum) {
            this.VG_IsTimeNum = VG_IsTimeNum;
        }

        public String getVG_IsTimeUnit() {
            return VG_IsTimeUnit;
        }

        public void setVG_IsTimeUnit(String VG_IsTimeUnit) {
            this.VG_IsTimeUnit = VG_IsTimeUnit;
        }

        public String getVG_Remark() {
            return VG_Remark;
        }

        public void setVG_Remark(String VG_Remark) {
            this.VG_Remark = VG_Remark;
        }

        public double getVG_IntegralUniformRuleValue() {
            return VG_IntegralUniformRuleValue;
        }

        public void setVG_IntegralUniformRuleValue(double VG_IntegralUniformRuleValue) {
            this.VG_IntegralUniformRuleValue = VG_IntegralUniformRuleValue;
        }

        public int getVG_IntegralRuleType() {
            return VG_IntegralRuleType;
        }

        public void setVG_IntegralRuleType(int VG_IntegralRuleType) {
            this.VG_IntegralRuleType = VG_IntegralRuleType;
        }

        public int getVG_DiscountUniformRuleValue() {
            return VG_DiscountUniformRuleValue;
        }

        public void setVG_DiscountUniformRuleValue(int VG_DiscountUniformRuleValue) {
            this.VG_DiscountUniformRuleValue = VG_DiscountUniformRuleValue;
        }

        public int getVG_DiscountRuleType() {
            return VG_DiscountRuleType;
        }

        public void setVG_DiscountRuleType(int VG_DiscountRuleType) {
            this.VG_DiscountRuleType = VG_DiscountRuleType;
        }

        public double getDS_Value() {
            return DS_Value;
        }

        public void setDS_Value(double DS_Value) {
            this.DS_Value = DS_Value;
        }

        public double getRS_CMoney() {
            return RS_CMoney;
        }

        public void setRS_CMoney(double RS_CMoney) {
            this.RS_CMoney = RS_CMoney;
        }

        public double getRS_Value() {
            return RS_Value;
        }

        public void setRS_Value(double RS_Value) {
            this.RS_Value = RS_Value;
        }

        public double getVS_CMoney() {
            return VS_CMoney;
        }

        public void setVS_CMoney(double VS_CMoney) {
            this.VS_CMoney = VS_CMoney;
        }

        public double getVS_Value() {
            return VS_Value;
        }

        public void setVS_Value(double VS_Value) {
            this.VS_Value = VS_Value;
        }

        public String getUS_Name() {
            return US_Name;
        }

        public void setUS_Name(String US_Name) {
            this.US_Name = US_Name;
        }

        public List<SettingsBean> getSettings() {
            return Settings;
        }

        public void setSettings(List<SettingsBean> Settings) {
            this.Settings = Settings;
        }

        public List<?> getInitServiceList() {
            return InitServiceList;
        }

        public void setInitServiceList(List<?> InitServiceList) {
            this.InitServiceList = InitServiceList;
        }

        public static class SettingsBean implements Serializable {
            /**
             * VG_GID : 3df0f677-442e-43ef-8706-18a54d7a2ded
             * VG_Name : 等级
             * PT_GID : 09945a52-1b71-481b-a49d-c78645270761
             * PT_Name : 普通商品类
             * PT_Type : 商品
             * PD_Discount : 100
             * VS_CMoney : 0.0
             * VS_Number : 0.0
             * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
             * SM_Name : jll2
             * PT_Parent :
             * PT_SynType : 0
             */

            private String VG_GID;
            private String VG_Name;
            private String PT_GID;
            private String PT_Name;
            private String PT_Type;
            private double PD_Discount;
            private double VS_CMoney;
            private double VS_Number;
            private String SM_GID;
            private String SM_Name;
            private String PT_Parent;
            private String PT_SynType;

            public String getVG_GID() {
                return VG_GID;
            }

            public void setVG_GID(String VG_GID) {
                this.VG_GID = VG_GID;
            }

            public String getVG_Name() {
                return VG_Name;
            }

            public void setVG_Name(String VG_Name) {
                this.VG_Name = VG_Name;
            }

            public String getPT_GID() {
                return PT_GID;
            }

            public void setPT_GID(String PT_GID) {
                this.PT_GID = PT_GID;
            }

            public String getPT_Name() {
                return PT_Name;
            }

            public void setPT_Name(String PT_Name) {
                this.PT_Name = PT_Name;
            }

            public String getPT_Type() {
                return PT_Type;
            }

            public void setPT_Type(String PT_Type) {
                this.PT_Type = PT_Type;
            }

            public double getPD_Discount() {
                return PD_Discount;
            }

            public void setPD_Discount(double PD_Discount) {
                this.PD_Discount = PD_Discount;
            }

            public double getVS_CMoney() {
                return VS_CMoney;
            }

            public void setVS_CMoney(double VS_CMoney) {
                this.VS_CMoney = VS_CMoney;
            }

            public double getVS_Number() {
                return VS_Number;
            }

            public void setVS_Number(double VS_Number) {
                this.VS_Number = VS_Number;
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

            public String getPT_Parent() {
                return PT_Parent;
            }

            public void setPT_Parent(String PT_Parent) {
                this.PT_Parent = PT_Parent;
            }

            public String getPT_SynType() {
                return PT_SynType;
            }

            public void setPT_SynType(String PT_SynType) {
                this.PT_SynType = PT_SynType;
            }
        }
    }

    public static class EmplistBean implements Serializable {
        /**
         * GID : 0f87e1fc-d8a0-4681-88e6-64bf08b0b15a
         * SM_GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * CY_GID : null
         * DM_GID : 473c9d88-d53c-40d5-9896-e9df345cb585
         * EM_Code : 335
         * EM_Name : C位狙击吃鸡手
         * EM_Sex : 0
         * EM_Phone :
         * EM_Addr :
         * EM_Remark :
         * EM_UpdateTime : 2018-08-29 16:44:38
         * EM_Creator : 销售001
         * EM_Birthday : null
         * SM_Name : jll2
         * DM_Name : 吃鸡小分队
         * EM_TipCard : 1
         * EM_TipRecharge : 0
         * EM_TipChargeTime : 0
         * EM_TipGoodsConsume : 0
         * EM_TipFastConsume : 0
         * EM_TipTimesConsume : 0
         * EM_TipComboConsume : 1
         * EM_TipTimingConsume : 0
         * EM_TipHouseConsume : 0
         */

        private String GID;
        private String SM_GID;
        private Object CY_GID;
        private String DM_GID;
        private String EM_Code;
        private String EM_Name;
        private int EM_Sex;
        private String EM_Phone;
        private String EM_Addr;
        private String EM_Remark;
        private String EM_UpdateTime;
        private String EM_Creator;
        private Object EM_Birthday;
        private String SM_Name;
        private String DM_Name;
        private int EM_TipCard;
        private int EM_TipRecharge;
        private int EM_TipChargeTime;
        private int EM_TipGoodsConsume;
        private int EM_TipFastConsume;
        private int EM_TipTimesConsume;
        private int EM_TipComboConsume;
        private int EM_TipTimingConsume;
        private int EM_TipHouseConsume;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        private boolean isCheck;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getSM_GID() {
            return SM_GID;
        }

        public void setSM_GID(String SM_GID) {
            this.SM_GID = SM_GID;
        }

        public Object getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(Object CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getDM_GID() {
            return DM_GID;
        }

        public void setDM_GID(String DM_GID) {
            this.DM_GID = DM_GID;
        }

        public String getEM_Code() {
            return EM_Code;
        }

        public void setEM_Code(String EM_Code) {
            this.EM_Code = EM_Code;
        }

        public String getEM_Name() {
            return EM_Name;
        }

        public void setEM_Name(String EM_Name) {
            this.EM_Name = EM_Name;
        }

        public int getEM_Sex() {
            return EM_Sex;
        }

        public void setEM_Sex(int EM_Sex) {
            this.EM_Sex = EM_Sex;
        }

        public String getEM_Phone() {
            return EM_Phone;
        }

        public void setEM_Phone(String EM_Phone) {
            this.EM_Phone = EM_Phone;
        }

        public String getEM_Addr() {
            return EM_Addr;
        }

        public void setEM_Addr(String EM_Addr) {
            this.EM_Addr = EM_Addr;
        }

        public String getEM_Remark() {
            return EM_Remark;
        }

        public void setEM_Remark(String EM_Remark) {
            this.EM_Remark = EM_Remark;
        }

        public String getEM_UpdateTime() {
            return EM_UpdateTime;
        }

        public void setEM_UpdateTime(String EM_UpdateTime) {
            this.EM_UpdateTime = EM_UpdateTime;
        }

        public String getEM_Creator() {
            return EM_Creator;
        }

        public void setEM_Creator(String EM_Creator) {
            this.EM_Creator = EM_Creator;
        }

        public Object getEM_Birthday() {
            return EM_Birthday;
        }

        public void setEM_Birthday(Object EM_Birthday) {
            this.EM_Birthday = EM_Birthday;
        }

        public String getSM_Name() {
            return SM_Name;
        }

        public void setSM_Name(String SM_Name) {
            this.SM_Name = SM_Name;
        }

        public String getDM_Name() {
            return DM_Name;
        }

        public void setDM_Name(String DM_Name) {
            this.DM_Name = DM_Name;
        }

        public int getEM_TipCard() {
            return EM_TipCard;
        }

        public void setEM_TipCard(int EM_TipCard) {
            this.EM_TipCard = EM_TipCard;
        }

        public int getEM_TipRecharge() {
            return EM_TipRecharge;
        }

        public void setEM_TipRecharge(int EM_TipRecharge) {
            this.EM_TipRecharge = EM_TipRecharge;
        }

        public int getEM_TipChargeTime() {
            return EM_TipChargeTime;
        }

        public void setEM_TipChargeTime(int EM_TipChargeTime) {
            this.EM_TipChargeTime = EM_TipChargeTime;
        }

        public int getEM_TipGoodsConsume() {
            return EM_TipGoodsConsume;
        }

        public void setEM_TipGoodsConsume(int EM_TipGoodsConsume) {
            this.EM_TipGoodsConsume = EM_TipGoodsConsume;
        }

        public int getEM_TipFastConsume() {
            return EM_TipFastConsume;
        }

        public void setEM_TipFastConsume(int EM_TipFastConsume) {
            this.EM_TipFastConsume = EM_TipFastConsume;
        }

        public int getEM_TipTimesConsume() {
            return EM_TipTimesConsume;
        }

        public void setEM_TipTimesConsume(int EM_TipTimesConsume) {
            this.EM_TipTimesConsume = EM_TipTimesConsume;
        }

        public int getEM_TipComboConsume() {
            return EM_TipComboConsume;
        }

        public void setEM_TipComboConsume(int EM_TipComboConsume) {
            this.EM_TipComboConsume = EM_TipComboConsume;
        }

        public int getEM_TipTimingConsume() {
            return EM_TipTimingConsume;
        }

        public void setEM_TipTimingConsume(int EM_TipTimingConsume) {
            this.EM_TipTimingConsume = EM_TipTimingConsume;
        }

        public int getEM_TipHouseConsume() {
            return EM_TipHouseConsume;
        }

        public void setEM_TipHouseConsume(int EM_TipHouseConsume) {
            this.EM_TipHouseConsume = EM_TipHouseConsume;
        }
    }

    public static class DepartmentListBean implements Serializable {
        /**
         * GID : 506400d2-dd4c-45a3-8c8e-ab964a8c3cf6
         * CY_GID : null
         * DM_Name : 营销
         * DM_Remark :
         * DM_UpdateTime : 2018-06-29 16:07:23
         * DM_Creator : 1058346971@qq.com
         */

        private String GID;
        private Object CY_GID;
        private String DM_Name;
        private String DM_Remark;
        private String DM_UpdateTime;
        private String DM_Creator;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        private boolean check;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public Object getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(Object CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getDM_Name() {
            return DM_Name;
        }

        public void setDM_Name(String DM_Name) {
            this.DM_Name = DM_Name;
        }

        public String getDM_Remark() {
            return DM_Remark;
        }

        public void setDM_Remark(String DM_Remark) {
            this.DM_Remark = DM_Remark;
        }

        public String getDM_UpdateTime() {
            return DM_UpdateTime;
        }

        public void setDM_UpdateTime(String DM_UpdateTime) {
            this.DM_UpdateTime = DM_UpdateTime;
        }

        public String getDM_Creator() {
            return DM_Creator;
        }

        public void setDM_Creator(String DM_Creator) {
            this.DM_Creator = DM_Creator;
        }
    }

    public static class ShopListBean implements Serializable {
        /**
         * SM_DefaultCode : null
         * GID : 4a7b1141-8ca3-4bef-961f-ffd153357823
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * SM_Name : jll2
         * SM_Contacter : 6545646
         * SM_Phone : 18328578333
         * SM_Addr :
         * SM_Remark :
         * SM_State : 0
         * SM_UpdateTime : 2019-01-22 11:12:08
         * SM_Picture : /img/head.png
         * SM_Creator : 1058346971@qq.com
         * SM_XLong : null
         * SM_YLat : null
         * SM_Industry : 汽车美容
         * SM_Range :
         * SM_Country : null
         * SM_Province : 四川省
         * SM_Disctrict : 龙泉驿区
         * SM_DetailAddr :
         * SM_MapAddr : null
         * SM_UpdateState : 1
         * SM_AcountNum : 10
         * SM_Type : 15
         * SM_EndTime : 2023-11-19 13:55:18
         * SM_CreateTime : 2018-06-29 15:45:53
         * SM_City : 中国
         * VipNumber : 0
         * ProNumber : 0
         * SM_IndustryType : 100
         * SaoBei_State : 0
         * SaoBei_Message : null
         */

        private Object SM_DefaultCode;
        private String GID;
        private String CY_GID;
        private String SM_Name;
        private String SM_Contacter;
        private String SM_Phone;
        private String SM_Addr;
        private String SM_Remark;
        private int SM_State;
        private String SM_UpdateTime;
        private String SM_Picture;
        private String SM_Creator;
        private Object SM_XLong;
        private Object SM_YLat;
        private String SM_Industry;
        private String SM_Range;
        private Object SM_Country;
        private String SM_Province;
        private String SM_Disctrict;
        private String SM_DetailAddr;
        private Object SM_MapAddr;
        private int SM_UpdateState;
        private int SM_AcountNum;
        private int SM_Type;
        private String SM_EndTime;
        private String SM_CreateTime;
        private String SM_City;
        private int VipNumber;
        private int ProNumber;
        private int SM_IndustryType;
        private int SaoBei_State;
        private Object SaoBei_Message;

        public Object getSM_DefaultCode() {
            return SM_DefaultCode;
        }

        public void setSM_DefaultCode(Object SM_DefaultCode) {
            this.SM_DefaultCode = SM_DefaultCode;
        }

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

        public String getSM_Name() {
            return SM_Name;
        }

        public void setSM_Name(String SM_Name) {
            this.SM_Name = SM_Name;
        }

        public String getSM_Contacter() {
            return SM_Contacter;
        }

        public void setSM_Contacter(String SM_Contacter) {
            this.SM_Contacter = SM_Contacter;
        }

        public String getSM_Phone() {
            return SM_Phone;
        }

        public void setSM_Phone(String SM_Phone) {
            this.SM_Phone = SM_Phone;
        }

        public String getSM_Addr() {
            return SM_Addr;
        }

        public void setSM_Addr(String SM_Addr) {
            this.SM_Addr = SM_Addr;
        }

        public String getSM_Remark() {
            return SM_Remark;
        }

        public void setSM_Remark(String SM_Remark) {
            this.SM_Remark = SM_Remark;
        }

        public int getSM_State() {
            return SM_State;
        }

        public void setSM_State(int SM_State) {
            this.SM_State = SM_State;
        }

        public String getSM_UpdateTime() {
            return SM_UpdateTime;
        }

        public void setSM_UpdateTime(String SM_UpdateTime) {
            this.SM_UpdateTime = SM_UpdateTime;
        }

        public String getSM_Picture() {
            return SM_Picture;
        }

        public void setSM_Picture(String SM_Picture) {
            this.SM_Picture = SM_Picture;
        }

        public String getSM_Creator() {
            return SM_Creator;
        }

        public void setSM_Creator(String SM_Creator) {
            this.SM_Creator = SM_Creator;
        }

        public Object getSM_XLong() {
            return SM_XLong;
        }

        public void setSM_XLong(Object SM_XLong) {
            this.SM_XLong = SM_XLong;
        }

        public Object getSM_YLat() {
            return SM_YLat;
        }

        public void setSM_YLat(Object SM_YLat) {
            this.SM_YLat = SM_YLat;
        }

        public String getSM_Industry() {
            return SM_Industry;
        }

        public void setSM_Industry(String SM_Industry) {
            this.SM_Industry = SM_Industry;
        }

        public String getSM_Range() {
            return SM_Range;
        }

        public void setSM_Range(String SM_Range) {
            this.SM_Range = SM_Range;
        }

        public Object getSM_Country() {
            return SM_Country;
        }

        public void setSM_Country(Object SM_Country) {
            this.SM_Country = SM_Country;
        }

        public String getSM_Province() {
            return SM_Province;
        }

        public void setSM_Province(String SM_Province) {
            this.SM_Province = SM_Province;
        }

        public String getSM_Disctrict() {
            return SM_Disctrict;
        }

        public void setSM_Disctrict(String SM_Disctrict) {
            this.SM_Disctrict = SM_Disctrict;
        }

        public String getSM_DetailAddr() {
            return SM_DetailAddr;
        }

        public void setSM_DetailAddr(String SM_DetailAddr) {
            this.SM_DetailAddr = SM_DetailAddr;
        }

        public Object getSM_MapAddr() {
            return SM_MapAddr;
        }

        public void setSM_MapAddr(Object SM_MapAddr) {
            this.SM_MapAddr = SM_MapAddr;
        }

        public int getSM_UpdateState() {
            return SM_UpdateState;
        }

        public void setSM_UpdateState(int SM_UpdateState) {
            this.SM_UpdateState = SM_UpdateState;
        }

        public int getSM_AcountNum() {
            return SM_AcountNum;
        }

        public void setSM_AcountNum(int SM_AcountNum) {
            this.SM_AcountNum = SM_AcountNum;
        }

        public int getSM_Type() {
            return SM_Type;
        }

        public void setSM_Type(int SM_Type) {
            this.SM_Type = SM_Type;
        }

        public String getSM_EndTime() {
            return SM_EndTime;
        }

        public void setSM_EndTime(String SM_EndTime) {
            this.SM_EndTime = SM_EndTime;
        }

        public String getSM_CreateTime() {
            return SM_CreateTime;
        }

        public void setSM_CreateTime(String SM_CreateTime) {
            this.SM_CreateTime = SM_CreateTime;
        }

        public String getSM_City() {
            return SM_City;
        }

        public void setSM_City(String SM_City) {
            this.SM_City = SM_City;
        }

        public int getVipNumber() {
            return VipNumber;
        }

        public void setVipNumber(int VipNumber) {
            this.VipNumber = VipNumber;
        }

        public int getProNumber() {
            return ProNumber;
        }

        public void setProNumber(int ProNumber) {
            this.ProNumber = ProNumber;
        }

        public int getSM_IndustryType() {
            return SM_IndustryType;
        }

        public void setSM_IndustryType(int SM_IndustryType) {
            this.SM_IndustryType = SM_IndustryType;
        }

        public int getSaoBei_State() {
            return SaoBei_State;
        }

        public void setSaoBei_State(int SaoBei_State) {
            this.SaoBei_State = SaoBei_State;
        }

        public Object getSaoBei_Message() {
            return SaoBei_Message;
        }

        public void setSaoBei_Message(Object SaoBei_Message) {
            this.SaoBei_Message = SaoBei_Message;
        }
    }

    public static class ActiveBean implements Serializable {
        /**
         * RP_Discount : 9.99
         * RP_IsOpen : 1
         * GID : b852626a-002f-4cdc-a3fb-f7d56a9848fe
         * RP_Name : 3213
         * RP_Type : 2
         * RP_RechargeMoney : 3211.0
         * RP_GiveMoney : -1.0
         * RP_GivePoint : 10
         * RP_ReduceMoney : -1.0
         * RP_ValidType : 0
         * RP_ValidWeekMonth :
         * RP_ValidStartTime : null
         * RP_ValidEndTime : null
         * RP_ISDouble : 0
         * RP_Creator : 销售001
         * RP_CreateTime : 2018-11-16 10:36:59
         * CY_GID : 33b26f6e-78c8-4da8-bdad-6b47c06f4aa4
         * RP_Remark : null
         */

        private double RP_Discount;
        private int RP_IsOpen;
        private String GID;
        private String RP_Name;
        private int RP_Type;
        private double RP_RechargeMoney;
        private double RP_GiveMoney;
        private int RP_GivePoint;
        private double RP_ReduceMoney;
        private int RP_ValidType;//期限类型 1固定时间断2按每周3按每月4会员生日当天
        private String RP_ValidWeekMonth;
        private Object RP_ValidStartTime;
        private Object RP_ValidEndTime;
        private int RP_ISDouble;
        private String RP_Creator;
        private String RP_CreateTime;
        private String CY_GID;
        private Object RP_Remark;

        public double getRP_Discount() {
            return RP_Discount;
        }

        public void setRP_Discount(double RP_Discount) {
            this.RP_Discount = RP_Discount;
        }

        public int getRP_IsOpen() {
            return RP_IsOpen;
        }

        public void setRP_IsOpen(int RP_IsOpen) {
            this.RP_IsOpen = RP_IsOpen;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getRP_Name() {
            return RP_Name;
        }

        public void setRP_Name(String RP_Name) {
            this.RP_Name = RP_Name;
        }

        public int getRP_Type() {
            return RP_Type;
        }

        public void setRP_Type(int RP_Type) {
            this.RP_Type = RP_Type;
        }

        public double getRP_RechargeMoney() {
            return RP_RechargeMoney;
        }

        public void setRP_RechargeMoney(double RP_RechargeMoney) {
            this.RP_RechargeMoney = RP_RechargeMoney;
        }

        public double getRP_GiveMoney() {
            return RP_GiveMoney;
        }

        public void setRP_GiveMoney(double RP_GiveMoney) {
            this.RP_GiveMoney = RP_GiveMoney;
        }

        public int getRP_GivePoint() {
            return RP_GivePoint;
        }

        public void setRP_GivePoint(int RP_GivePoint) {
            this.RP_GivePoint = RP_GivePoint;
        }

        public double getRP_ReduceMoney() {
            return RP_ReduceMoney;
        }

        public void setRP_ReduceMoney(double RP_ReduceMoney) {
            this.RP_ReduceMoney = RP_ReduceMoney;
        }

        public int getRP_ValidType() {
            return RP_ValidType;
        }

        public void setRP_ValidType(int RP_ValidType) {
            this.RP_ValidType = RP_ValidType;
        }

        public String getRP_ValidWeekMonth() {
            return RP_ValidWeekMonth;
        }

        public void setRP_ValidWeekMonth(String RP_ValidWeekMonth) {
            this.RP_ValidWeekMonth = RP_ValidWeekMonth;
        }

        public Object getRP_ValidStartTime() {
            return RP_ValidStartTime;
        }

        public void setRP_ValidStartTime(Object RP_ValidStartTime) {
            this.RP_ValidStartTime = RP_ValidStartTime;
        }

        public Object getRP_ValidEndTime() {
            return RP_ValidEndTime;
        }

        public void setRP_ValidEndTime(Object RP_ValidEndTime) {
            this.RP_ValidEndTime = RP_ValidEndTime;
        }

        public int getRP_ISDouble() {
            return RP_ISDouble;
        }

        public void setRP_ISDouble(int RP_ISDouble) {
            this.RP_ISDouble = RP_ISDouble;
        }

        public String getRP_Creator() {
            return RP_Creator;
        }

        public void setRP_Creator(String RP_Creator) {
            this.RP_Creator = RP_Creator;
        }

        public String getRP_CreateTime() {
            return RP_CreateTime;
        }

        public void setRP_CreateTime(String RP_CreateTime) {
            this.RP_CreateTime = RP_CreateTime;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public Object getRP_Remark() {
            return RP_Remark;
        }

        public void setRP_Remark(Object RP_Remark) {
            this.RP_Remark = RP_Remark;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ActiveBean that = (ActiveBean) o;
            return Double.compare(that.RP_Discount, RP_Discount) == 0 &&
                    RP_IsOpen == that.RP_IsOpen &&
                    RP_Type == that.RP_Type &&
                    Double.compare(that.RP_RechargeMoney, RP_RechargeMoney) == 0 &&
                    Double.compare(that.RP_GiveMoney, RP_GiveMoney) == 0 &&
                    RP_GivePoint == that.RP_GivePoint &&
                    Double.compare(that.RP_ReduceMoney, RP_ReduceMoney) == 0 &&
                    RP_ValidType == that.RP_ValidType &&
                    RP_ISDouble == that.RP_ISDouble &&
                    Objects.equals(GID, that.GID) &&
                    Objects.equals(RP_Name, that.RP_Name) &&
                    Objects.equals(RP_ValidWeekMonth, that.RP_ValidWeekMonth) &&
                    Objects.equals(RP_ValidStartTime, that.RP_ValidStartTime) &&
                    Objects.equals(RP_ValidEndTime, that.RP_ValidEndTime) &&
                    Objects.equals(RP_Creator, that.RP_Creator) &&
                    Objects.equals(RP_CreateTime, that.RP_CreateTime) &&
                    Objects.equals(CY_GID, that.CY_GID) &&
                    Objects.equals(RP_Remark, that.RP_Remark);
        }

        @Override
        public int hashCode() {
            return Objects.hash(RP_Discount, RP_IsOpen, GID, RP_Name, RP_Type, RP_RechargeMoney, RP_GiveMoney, RP_GivePoint, RP_ReduceMoney, RP_ValidType, RP_ValidWeekMonth, RP_ValidStartTime, RP_ValidEndTime, RP_ISDouble, RP_Creator, RP_CreateTime, CY_GID, RP_Remark);
        }
    }
}

package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

public class VipMsg implements Serializable {
 private String   GID;//	会员GID	string
    private String     VIP_HeadImg;//	头像地址	string
    private String     VCH_Card;//	会员卡号	string
    private String     VIP_Name;//	会员姓名	string
    private int   VIP_Sex;//	会员性别	Int32
    private String      VCH_CreateTime;//	开卡时间	DateTime
    private String     VIP_Birthday;//	生日	string
    private String     VIP_CellPhone;//	手机号	string
    private String     VIP_ICCard;//	身份证号	string
    private String     VIP_Email;//	电子邮箱	string
    private String     VIP_Remark;//	备注	string
    private int   VIP_IsForver;//	是否永久有效	Int32
    private String    VIP_Overdue;//	过期时间	DateTime?
    private int    VIP_State;//	会员状态	Int32
    private String       VIP_FaceNumber;//	卡面号码	string
    private String     VIP_Label;//	会员标签	string
    private String    VG_GID;//	等级GID	string
    private String     VIP_Referee;//	推荐人卡号	string
    private String     VIP_Addr;//	会员地址	string
    private String    VIP_FixedPhone;//	固定电话	string
    private String    VG_Name;//	等级名称	string
    private double   MA_AvailableBalance;//	可用余额	decimal
    private double    MA_AvailableIntegral;//	可用积分	decimal
    private int    MCA_HowMany;//	剩余充次总数	int
    private List<VipDengjiMsg> VGInfo;

    public List<VipDengjiMsg> getVGInfo() {
        return VGInfo;
    }

    public void setVGInfo(List<VipDengjiMsg> VGInfo) {
        this.VGInfo = VGInfo;
    }

    public String getGID() {
      return GID;
   }

   public void setGID(String GID) {
      this.GID = GID;
   }

   public String getVIP_HeadImg() {
      return VIP_HeadImg;
   }

   public void setVIP_HeadImg(String VIP_HeadImg) {
      this.VIP_HeadImg = VIP_HeadImg;
   }

   public String getVCH_Card() {
      return VCH_Card;
   }

   public void setVCH_Card(String VCH_Card) {
      this.VCH_Card = VCH_Card;
   }

   public String getVIP_Name() {
      return VIP_Name;
   }

   public void setVIP_Name(String VIP_Name) {
      this.VIP_Name = VIP_Name;
   }

   public int getVIP_Sex() {
      return VIP_Sex;
   }

   public void setVIP_Sex(int VIP_Sex) {
      this.VIP_Sex = VIP_Sex;
   }

   public String getVCH_CreateTime() {
      return VCH_CreateTime;
   }

   public void setVCH_CreateTime(String VCH_CreateTime) {
      this.VCH_CreateTime = VCH_CreateTime;
   }

   public String getVIP_Birthday() {
      return VIP_Birthday;
   }

   public void setVIP_Birthday(String VIP_Birthday) {
      this.VIP_Birthday = VIP_Birthday;
   }

   public String getVIP_CellPhone() {
      return VIP_CellPhone;
   }

   public void setVIP_CellPhone(String VIP_CellPhone) {
      this.VIP_CellPhone = VIP_CellPhone;
   }

   public String getVIP_ICCard() {
      return VIP_ICCard;
   }

   public void setVIP_ICCard(String VIP_ICCard) {
      this.VIP_ICCard = VIP_ICCard;
   }

   public String getVIP_Email() {
      return VIP_Email;
   }

   public void setVIP_Email(String VIP_Email) {
      this.VIP_Email = VIP_Email;
   }

   public String getVIP_Remark() {
      return VIP_Remark;
   }

   public void setVIP_Remark(String VIP_Remark) {
      this.VIP_Remark = VIP_Remark;
   }

   public int getVIP_IsForver() {
      return VIP_IsForver;
   }

   public void setVIP_IsForver(int VIP_IsForver) {
      this.VIP_IsForver = VIP_IsForver;
   }

   public String getVIP_Overdue() {
      return VIP_Overdue;
   }

   public void setVIP_Overdue(String VIP_Overdue) {
      this.VIP_Overdue = VIP_Overdue;
   }

   public int getVIP_State() {
      return VIP_State;
   }

   public void setVIP_State(int VIP_State) {
      this.VIP_State = VIP_State;
   }

   public String getVIP_FaceNumber() {
      return VIP_FaceNumber;
   }

   public void setVIP_FaceNumber(String VIP_FaceNumber) {
      this.VIP_FaceNumber = VIP_FaceNumber;
   }

   public String getVIP_Label() {
      return VIP_Label;
   }

   public void setVIP_Label(String VIP_Label) {
      this.VIP_Label = VIP_Label;
   }

   public String getVG_GID() {
      return VG_GID;
   }

   public void setVG_GID(String VG_GID) {
      this.VG_GID = VG_GID;
   }

   public String getVIP_Referee() {
      return VIP_Referee;
   }

   public void setVIP_Referee(String VIP_Referee) {
      this.VIP_Referee = VIP_Referee;
   }

   public String getVIP_Addr() {
      return VIP_Addr;
   }

   public void setVIP_Addr(String VIP_Addr) {
      this.VIP_Addr = VIP_Addr;
   }

   public String getVIP_FixedPhone() {
      return VIP_FixedPhone;
   }

   public void setVIP_FixedPhone(String VIP_FixedPhone) {
      this.VIP_FixedPhone = VIP_FixedPhone;
   }

   public String getVG_Name() {
      return VG_Name;
   }

   public void setVG_Name(String VG_Name) {
      this.VG_Name = VG_Name;
   }

   public double getMA_AvailableBalance() {
      return MA_AvailableBalance;
   }

   public void setMA_AvailableBalance(double MA_AvailableBalance) {
      this.MA_AvailableBalance = MA_AvailableBalance;
   }

   public double getMA_AvailableIntegral() {
      return MA_AvailableIntegral;
   }

   public void setMA_AvailableIntegral(double MA_AvailableIntegral) {
      this.MA_AvailableIntegral = MA_AvailableIntegral;
   }

   public int getMCA_HowMany() {
      return MCA_HowMany;
   }

   public void setMCA_HowMany(int MCA_HowMany) {
      this.MCA_HowMany = MCA_HowMany;
   }
}

package com.wycd.yushangpu.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class SysSwitchRes implements Parcelable {
    private String GID;//	开关设置GID	string
    private String SS_Name;//	开关名称	string
    private int SS_Code;//	开关编码	Int32?
    private int SS_State;//	状态	string  1开启、0关闭
    private String SS_Remark;//	备注	string
    private String SS_Update;//	修改者	string
    private String SS_UpdateTime;//修改时间	DateTime?
    private String CY_GID;//	企业GID	string
    private int SS_Sort;//	排序	Int32?
    private String SS_Value;//	开关对应参数值	string
    private boolean isMoren;

    public boolean isMoren() {
        return isMoren;
    }

    public void setMoren(boolean moren) {
        isMoren = moren;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getSS_Name() {
        return SS_Name;
    }

    public void setSS_Name(String SS_Name) {
        this.SS_Name = SS_Name;
    }

    public int getSS_Code() {
        return SS_Code;
    }

    public void setSS_Code(int SS_Code) {
        this.SS_Code = SS_Code;
    }

    public int getSS_State() {
        return SS_State;
    }

    public void setSS_State(int SS_State) {
        this.SS_State = SS_State;
    }

    public String getSS_Remark() {
        return SS_Remark;
    }

    public void setSS_Remark(String SS_Remark) {
        this.SS_Remark = SS_Remark;
    }

    public String getSS_Update() {
        return SS_Update;
    }

    public void setSS_Update(String SS_Update) {
        this.SS_Update = SS_Update;
    }

    public String getSS_UpdateTime() {
        return SS_UpdateTime;
    }

    public void setSS_UpdateTime(String SS_UpdateTime) {
        this.SS_UpdateTime = SS_UpdateTime;
    }

    public String getCY_GID() {
        return CY_GID;
    }

    public void setCY_GID(String CY_GID) {
        this.CY_GID = CY_GID;
    }

    public int getSS_Sort() {
        return SS_Sort;
    }

    public void setSS_Sort(int SS_Sort) {
        this.SS_Sort = SS_Sort;
    }

    public String getSS_Value() {
        return SS_Value;
    }

    public void setSS_Value(String SS_Value) {
        this.SS_Value = SS_Value;
    }

    @Override
    public String toString() {
        return "SysSwitchRes{" +
                "GID='" + GID + '\'' +
                ", SS_Name='" + SS_Name + '\'' +
                ", SS_Code=" + SS_Code +
                ", SS_State=" + SS_State +
                ", SS_Remark='" + SS_Remark + '\'' +
                ", SS_Update='" + SS_Update + '\'' +
                ", SS_UpdateTime='" + SS_UpdateTime + '\'' +
                ", CY_GID='" + CY_GID + '\'' +
                ", SS_Sort=" + SS_Sort +
                ", SS_Value='" + SS_Value + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.GID);
        dest.writeString(this.SS_Name);
        dest.writeInt(this.SS_Code);
        dest.writeInt(this.SS_State);
        dest.writeString(this.SS_Remark);
        dest.writeString(this.SS_Update);
        dest.writeString(this.SS_UpdateTime);
        dest.writeString(this.CY_GID);
        dest.writeInt(this.SS_Sort);
        dest.writeString(this.SS_Value);
        dest.writeByte(this.isMoren ? (byte) 1 : (byte) 0);
    }

    public SysSwitchRes() {
    }

    protected SysSwitchRes(Parcel in) {
        this.GID = in.readString();
        this.SS_Name = in.readString();
        this.SS_Code = in.readInt();
        this.SS_State = in.readInt();
        this.SS_Remark = in.readString();
        this.SS_Update = in.readString();
        this.SS_UpdateTime = in.readString();
        this.CY_GID = in.readString();
        this.SS_Sort = in.readInt();
        this.SS_Value = in.readString();
        this.isMoren = in.readByte() != 0;
    }

    public static final Parcelable.Creator<SysSwitchRes> CREATOR = new Parcelable.Creator<SysSwitchRes>() {
        @Override
        public SysSwitchRes createFromParcel(Parcel source) {
            return new SysSwitchRes(source);
        }

        @Override
        public SysSwitchRes[] newArray(int size) {
            return new SysSwitchRes[size];
        }
    };

    public enum Type {
        Type11(11),//商品消费
        Type101(101),//现金支付
        Type401(401),//商品简码
        Type402(402),//会员价格
        Type102(102),//余额支付
        Type10(10),//快速消费
        Type403(403),//商品品牌
        Type26(26),//商品寄存
        Type105(105),//微信记账
        Type404(404),//规格型号
        Type106(106),//支付宝记账
        Type27(27),//商品领取
        Type103(103),//银联支付
        Type405(405),//参考进价
        Type12(12),//计次消费
        Type21(21),//计时消费
        Type110(110),//优惠券
        Type406(406),//初始库存
        Type111(111),//扫码支付
        Type18(18),//房台消费
        Type407(407),//库存预警值
        Type408(408),//排序编号
        Type113(113),//其他支付
        Type17(17),//限时消费
        Type409(409),//保质期
        Type107(107),//积分支付
        Type13(13),//礼品兑换
        Type451(451),//会员生日
        Type109(109),//积分支付限制
        Type1(1),//添加会员
        Type602(602),//禁止0库存销售
        Type108(108),//默认支付
        Type2(2),//会员充值
        Type452(452),//电子邮箱
        Type305(305),//法定假日积分翻倍
        Type201(201),//会员卡号同手机号
        Type3(3),//会员充次
        Type453(453),//身份证号
        Type218(218),//禁止删除余额不为0的会员
        Type213(213),//手机号可重复
        Type454(454),//固定电话
        Type7(7),//积分变动
        Type6(6),//积分清零
        Type803(803),//四舍五入到“元”
        Type455(455),//推荐人
        Type208(208),//会员卡卡面卡号
        Type219(219),//自由充值
        Type203(203),//初始金额和初始积分
        Type456(456),//开卡人
        Type8(8),//修改密码
        Type209(209),//会员查询弹窗
        Type220(220),//系统语音提醒
        Type222(222),//微店自由充值
        Type802(802),//四舍五入到“角”
        Type221(221),//允许负库存
        Type804(804),//直接舍弃“角”
        Type457(457),//会员标签
        Type9(9),//会员挂失
        Type210(210),//是否显示它店会员
        Type805(805),//直接舍弃“分”
        Type4(4),//会员升级
        Type458(458),//会员地址
        Type211(211),//必填手机号
        Type212(212),//计次消费规则
        Type459(459),//备注信息
        Type223(223),//消费后显示余额
        Type5(5),//会员降级
        Type22(22),//会员返利
        Type214(214),//必须刷卡
        Type601(601),//商品数据修改
        Type23(23),//获得优惠券
        Type20(20),//优惠券发送
        Type301(301),//员工提成
        Type302(302),//员工提成按比例分成
        Type16(16),//到期提醒
        Type215(215),//撤单密码
        Type14(14),//生日提醒
        Type202(202),//开卡初始密码
        Type303(303),//固定提成
        Type204(204),//消费密码验证
        Type24(24),//会员签到
        Type205(205),//转账密码验证
        Type217(217),//消费短信验证码验证
        Type900(900),//修改单价
        Type25(25),//一键加油
        Type901(901),//修改折扣
        Type206(206),//积分兑换密码验证
        Type207(207),//换卡密码验证
        Type902(902),//修改小计
        Type903(903),//修改数量
        Type503(503),//会员推荐提成
        Type904(904),//员工提成
        Type501(501),//会员消费提成
        Type502(502),//会员获得积分提成
        Type905(905),//挂单/取单
        Type701(701),//开启客显
        Type906(906),//挂账/结账
        Type702(702),//通讯端口
        Type907(907),//快捷充值
        Type703(703),//波特率
        Type908(908),//会员列表
        Type801(801),//自由抹零
        Type909(909),//交易记录
        Type216(216);//自动匹配优惠活动

        private int value;

        Type(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }

        public String getValueStr() {
            return value + "";
        }
    }

}

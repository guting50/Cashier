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
        T11(11),//商品消费
        T101(101),//现金支付
        T401(401),//商品简码
        T402(402),//会员价格
        T102(102),//余额支付
        T10(10),//快速消费
        T403(403),//商品品牌
        T26(26),//商品寄存
        T105(105),//微信记账
        T404(404),//规格型号
        T106(106),//支付宝记账
        T27(27),//商品领取
        T103(103),//银联支付
        T405(405),//参考进价
        T12(12),//计次消费
        T21(21),//计时消费
        T110(110),//优惠券
        T406(406),//初始库存
        T111(111),//扫码支付
        T18(18),//房台消费
        T407(407),//库存预警值
        T408(408),//排序编号
        T113(113),//其他支付
        T17(17),//限时消费
        T409(409),//保质期
        T107(107),//积分支付
        T13(13),//礼品兑换
        T451(451),//会员生日
        T109(109),//积分支付限制
        T1(1),//添加会员
        T602(602),//禁止0库存销售
        T108(108),//默认支付
        T2(2),//会员充值
        T452(452),//电子邮箱
        T305(305),//法定假日积分翻倍
        T201(201),//会员卡号同手机号
        T3(3),//会员充次
        T453(453),//身份证号
        T218(218),//禁止删除余额不为0的会员
        T213(213),//手机号可重复
        T454(454),//固定电话
        T7(7),//积分变动
        T6(6),//积分清零
        T803(803),//四舍五入到“元”
        T455(455),//推荐人
        T208(208),//会员卡卡面卡号
        T219(219),//自由充值
        T203(203),//初始金额和初始积分
        T456(456),//开卡人
        T8(8),//修改密码
        T209(209),//会员查询弹窗
        T220(220),//系统语音提醒
        T222(222),//微店自由充值
        T802(802),//四舍五入到“角”
        T221(221),//允许负库存
        T804(804),//直接舍弃“角”
        T457(457),//会员标签
        T9(9),//会员挂失
        T210(210),//是否显示它店会员
        T805(805),//直接舍弃“分”
        T4(4),//会员升级
        T458(458),//会员地址
        T211(211),//必填手机号
        T212(212),//计次消费规则
        T459(459),//备注信息
        T223(223),//消费后显示余额
        T5(5),//会员降级
        T22(22),//会员返利
        T214(214),//必须刷卡
        TypT(601),//商品数据修改
        T23(23),//获得优惠券
        T20(20),//优惠券发送
        T301(301),//员工提成
        T302(302),//员工提成按比例分成
        T16(16),//到期提醒
        T215(215),//撤单密码
        T14(14),//生日提醒
        T202(202),//开卡初始密码
        T303(303),//固定提成
        T204(204),//消费密码验证
        T24(24),//会员签到
        T205(205),//转账密码验证
        T217(217),//消费短信验证码验证
        T900(900),//修改单价
        T25(25),//一键加油
        T901(901),//修改折扣
        T206(206),//积分兑换密码验证
        T207(207),//换卡密码验证
        T902(902),//修改小计
        T903(903),//修改数量
        T503(503),//会员推荐提成
        T904(904),//员工提成
        T501(501),//会员消费提成
        T502(502),//会员获得积分提成
        T905(905),//挂单/取单
        T701(701),//开启客显
        T906(906),//挂账/结账
        T702(702),//通讯端口
        T907(907),//快捷充值
        T703(703),//波特率
        T908(908),//会员列表
        T801(801),//自由抹零
        T909(909),//交易记录
        T216(216);//自动匹配优惠活动

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

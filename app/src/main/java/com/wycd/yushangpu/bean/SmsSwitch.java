package com.wycd.yushangpu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YSL on 2018-06-22.
 * 短信开关bean
 */

public class SmsSwitch implements Serializable {

    /**
     * success : true
     * code : null
     * msg : 执行成功
     * data : [{"ST_State":null,"GID":"1","ST_Code":"001","ST_Name":"添加会员","ST_Content":"尊敬的会员：恭喜您！您于#当前时间#成为本店会员，会员卡号为#卡号#，感谢您的光临！","ST_Wildcard":"卡号|姓名|当前时间|到期时间","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"2","ST_Code":"002","ST_Name":"会员充值","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间#充值#充值金额#元，当前会员卡账户余额为#账户余额#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|充值金额|账户余额|积分数量|账户积分","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"3","ST_Code":"003","ST_Name":"会员充次","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 充次:#充次详情#，剩余计次详情：#计次账户详情#,消费金额#折后金额# 元，获得积分#积分数量#，当前会员账户积分为#账户积分#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|充次详情|计次账户详情|积分数量|账户积分|折后金额|折前金额|账户余额","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"4","ST_Code":"004","ST_Name":"会员升级","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 会员等级由#旧等级# 升级为#新等级#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|旧等级|新等级","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"5","ST_Code":"005","ST_Name":"会员降级","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 会员等级由#旧等级# 降级为#新等级#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|旧等级|新等级","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"6","ST_Code":"006","ST_Name":"积分清零","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 积分由#清除积分量# 变更为0，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|清除积分量","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":"1","GID":"0d131309-cb31-4f4a-aed3-2d42f48fafa4","ST_Code":"007","ST_Name":"积分变动","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# #变动类型##变动数量#，当前积分为#账户积分#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|变动类型|变动数量|变动原因|账户积分","CY_GID":"8d72205d-d282-4b32-a9fb-af87fb5d5b8e","ST_CreateTime":"2018-05-03 17:29:17"},{"ST_State":null,"GID":"8","ST_Code":"008","ST_Name":"修改密码","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 密码已经重置为#新密码#，请妥善保管您的密码，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|新密码","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"9","ST_Code":"009","ST_Name":"会员挂失","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 会员卡状态已经变更为#卡片状态#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|卡片状态","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"10","ST_Code":"010","ST_Name":"快速消费","ST_Content":"尊敬的会员：您尾号为#卡片尾号# 的会员卡于#当前时间# 消费金额#折后金额#元，获得积分#积分数量#，当前会员积分账户为#账户积分#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|积分数量|账户积分|折后金额|折前金额|账户余额","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"11","ST_Code":"011","ST_Name":"商品消费","ST_Content":"尊敬的会员，您尾号为#卡片尾号# 的会员卡于#当前时间# 商品消费：#商品消费详情#。消费金额#折后金额# 元，获得积分#积分数量#，当前会员积分账户为#账户积分#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|积分数量|账户积分|折后金额|折前金额|账户余额|商品消费详情","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"12","ST_Code":"012","ST_Name":"计次消费","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 计次消费：#计次消费详情#。剩余次数：#计次账户详情#。感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|计次消费详情|计次账户详情","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"13","ST_Code":"013","ST_Name":"礼品兑换","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 兑换礼品：#礼品详情#，消耗积分#积分数量#，当前会员账户积分为#账户积分#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|礼品详情|积分数量|账户积分","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"14","ST_Code":"014","ST_Name":"生日提醒","ST_Content":"尊敬的#姓名#：你的生日就要到了，在此送给您最真挚的祝福！","ST_Wildcard":"卡号|姓名|生日时间","CY_GID":"1","ST_CreateTime":"2017-02-27 00:00:00"},{"ST_State":null,"GID":"16","ST_Code":"016","ST_Name":"到期提醒","ST_Content":"尊敬的会员，您尾号为#卡片尾号# 的会员卡将于#到期时间# 到期，请您及时到本店办理相关延期业务，过期将不会享受本店的会员特权！","ST_Wildcard":"卡号|卡片尾号|姓名|到期时间|账户积分|账户余额|计次账户详情","CY_GID":"1","ST_CreateTime":"2017-10-31 16:51:27"},{"ST_State":null,"GID":"17","ST_Code":"017","ST_Name":"刷卡登记","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 刷卡登记#登记次数# 次，当前账户剩余#剩余次数# 次，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|登记次数|剩余次数|过期时间","CY_GID":"1","ST_CreateTime":"2017-12-08 00:00:00"},{"ST_State":null,"GID":"18","ST_Code":"018","ST_Name":"房台消费","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 消费#消费金额#，商品消费#商品消费详情#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|账户余额|房台费用|消费金额|商品费用|商品消费详情","CY_GID":"1","ST_CreateTime":"2017-12-08 00:00:00"},{"ST_State":null,"GID":"19","ST_Code":"019","ST_Name":"套餐消费","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 消费套餐#消费金额# 元，套餐包含#商品消费详情#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|账户余额|消费金额|商品消费详情","CY_GID":"1","ST_CreateTime":"2017-12-08 00:00:00"},{"ST_State":null,"GID":"20","ST_Code":"020","ST_Name":"优惠券发送","ST_Content":"尊敬的客户，你有一张#优惠金额/折扣#元优惠劵到账，在#有效时间#内可在本店使用","ST_Wildcard":"优惠券名称|优惠金额/折扣|使用条件|有效时间|会员姓名|卡片尾号","CY_GID":"1","ST_CreateTime":"2018-01-03 19:16:01"},{"ST_State":null,"GID":"21","ST_Code":"021","ST_Name":"计时消费","ST_Content":"尊敬的会员：你尾号为#卡片尾号# 的会员卡于#当前时间# 计时消费#消费金额# 元，包含#商品消费详情#，感谢您的光临！","ST_Wildcard":"卡号|卡片尾号|姓名|当前时间|账户余额|消费金额|商品消费详情|开始时间|服务项目","CY_GID":"1","ST_CreateTime":"2017-12-28 00:00:00"}]
     */

    private boolean success;
    private Object code;
    private String msg;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * ST_State : null
         * GID : 1
         * ST_Code : 001
         * ST_Name : 添加会员
         * ST_Content : 尊敬的会员：恭喜您！您于#当前时间#成为本店会员，会员卡号为#卡号#，感谢您的光临！
         * ST_Wildcard : 卡号|姓名|当前时间|到期时间
         * CY_GID : 1
         * ST_CreateTime : 2017-02-27 00:00:00
         */
        /**
         * ST_Code:"001" ST_Name:"添加会员"
         * ST_Code:"002" ST_Name:"会员充值"
         * ST_Code:"003" ST_Name:"会员充次"
         * ST_Code:"004" ST_Name:"会员升级"
         * ST_Code:"005" ST_Name:"会员降级"
         * ST_Code:"006" ST_Name:"积分清零"
         * ST_Code:"007" ST_Name:"积分变动"
         * ST_Code:"008" ST_Name:"修改密码"
         * ST_Code:"009" ST_Name:"会员挂失"
         * ST_Code:"010" ST_Name:"快速消费"
         * ST_Code:"011" ST_Name:"商品消费"
         * ST_Code:"012" ST_Name:"计次消费"
         * ST_Code:"013" ST_Name:"礼品兑换"
         * ST_Code:"014" ST_Name:"生日提醒"
         * ST_Code:"016" ST_Name:"到期提醒"
         * ST_Code:"017" ST_Name:"刷卡登记"
         * ST_Code:"018" ST_Name:"房台消费"
         * ST_Code:"019" ST_Name:"套餐消费"
         * ST_Code:"020" ST_Name:"优惠券发送"
         * ST_Code:"021" ST_Name:"计时消费"
         *
         */
        private Object ST_State;
        private String GID;
        private String ST_Content;
        private String ST_Wildcard;
        private String CY_GID;
        private String ST_CreateTime;
        private String ST_Code;
        private String ST_Name;

        public Object getST_State() {
            return ST_State;
        }

        public void setST_State(Object ST_State) {
            this.ST_State = ST_State;
        }

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getST_Code() {
            return ST_Code;
        }

        public void setST_Code(String ST_Code) {
            this.ST_Code = ST_Code;
        }

        public String getST_Name() {
            return ST_Name;
        }

        public void setST_Name(String ST_Name) {
            this.ST_Name = ST_Name;
        }

        public String getST_Content() {
            return ST_Content;
        }

        public void setST_Content(String ST_Content) {
            this.ST_Content = ST_Content;
        }

        public String getST_Wildcard() {
            return ST_Wildcard;
        }

        public void setST_Wildcard(String ST_Wildcard) {
            this.ST_Wildcard = ST_Wildcard;
        }

        public String getCY_GID() {
            return CY_GID;
        }

        public void setCY_GID(String CY_GID) {
            this.CY_GID = CY_GID;
        }

        public String getST_CreateTime() {
            return ST_CreateTime;
        }

        public void setST_CreateTime(String ST_CreateTime) {
            this.ST_CreateTime = ST_CreateTime;
        }
    }
}

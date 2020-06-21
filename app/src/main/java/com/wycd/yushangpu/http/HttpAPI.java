package com.wycd.yushangpu.http;

import com.wycd.yushangpu.MyApplication;

/**
 * author Yuan Cheng
 * blog yuancheng91.top
 * email jasoncheng9111@163.com
 * created 2017/4/26 10:06
 */
public class HttpAPI {
    //正式版和测试版轮换打包测试或发布的时候，注释另一个就行

    /**
     * 测试版
     *
     * @return
     */
    /*public static HttpAPIBeta API() {
        return HttpAPIBeta.getHttpAPIBeta();
    }*/


    /**
     * 正式版
     *
     * @return
     */
    public static HttpAPIOfficial API() {
        return HttpAPIOfficial.getHttpAPIOfficial();
    }


    /**
     * 内测API
     */
    public static final class HttpAPIBeta {
        //会员头像默认地址
        public static final String DEFALUT_HEAD_IMAGE = "/img/nohead.png";

        static final HttpAPIBeta instance = new HttpAPIBeta();
        public static final String MAIN_DOMAIN = "http://djtest.zhiluovip.com";//域名
        public static final String DOMAIN = "http://cttest.zhiluovip.com";//测试版域名

        // 静态方法返回该类的实例
        static HttpAPIBeta getHttpAPIBeta() {
            return instance;
        }

    }


    /**
     * 正式版API
     */
    public static final class HttpAPIOfficial {
        public HttpAPIOfficial() {

        }

        static final HttpAPIOfficial instance = new HttpAPIOfficial();

        public static final String DEFALUT_HEAD_IMAGE = "/img/nohead.png";

        // 静态方法返回该类的实例
        static HttpAPIOfficial getHttpAPIOfficial() {
            return instance;
        }

        //修改密码
        public static final String EDIT_USERPWD = MyApplication.BASE_URL + "api/UserManager/EditUsersPwd";

        //员工列表
        public static final String GET_EMPLLIST = MyApplication.BASE_URL + "api/Empl/QueryEmplListPaging";

        //查询商品规格
        public static final String GOODSMODEL = MyApplication.BASE_URL + "api/ProductConfig/GetModelList";

        //查询商品组合
        public static final String GROUPGOODS_LIST = MyApplication.BASE_URL + "api/ProductManger/GetGroupGoodsList";

        //查询消费订单列表
        public static final String QUERYALL_LIST = MyApplication.BASE_URL + "api/ConsumeOrder/QueryAllOrderList";

        //登陆
        public static final String LOGIN = MyApplication.BASE_URL + "api/UserManager/Login";

        //获取验证码
        public static final String GET_CODE = MyApplication.BASE_URL + "api/VerifyCode/GetCode";

        //获取版本更新
        public static final String GET_NEWS_VERSION = MyApplication.CTMONEY_URL + "TouchScreen/GetNewsVersion";

        //根据卡号查询会员列表
        public static final String QUERY_SINGLE_LIST = MyApplication.BASE_URL + "api/VIP/GetQuerySingleList";

        //商品消费挂账
        public static final String GUAZHANG = MyApplication.BASE_URL + "api/ConsumeOrder/PaymentConsumOrder_GuaZhang";

        //商品消费支付
        public static final String GOODS_CONSUME_PAY = MyApplication.BASE_URL + "api/ConsumeOrder/PaymentConsumOrder";

        //快速消费支付
        public static final String GOODS_CELERITY_PAY = MyApplication.BASE_URL + "api/ConsumeOrder/PaymentCelerityOrder";

        //退出登录
        public static final String SIGNOUT = MyApplication.BASE_URL + "api/User/SignOut";

        //登录预加载接口
        public static final String PRE_LOAD = MyApplication.BASE_URL + "api/Report/PreloadingData";

        //解挂接口
        public static final String REVOKE_GUADAN = MyApplication.BASE_URL + "api/ConsumeOrder/RevokeGuadanOrder";

        //扫码支付
        public static final String BAR_CODE_PAY = MyApplication.BASE_URL + "api/PayOrder/BarcodePay";

        //扫码支付查询
        public static final String QUERY_PAY_RESULT = MyApplication.BASE_URL + "api/PayOrder/QueryPayResult";

        //产品类型
        public static final String PRODUCTTYPE = MyApplication.BASE_URL + "api/ProductTypeManager/QueryAllProductTypeBySM_ID";

        //查询带套餐商品列表
        public static final String COMBOGOODS = MyApplication.BASE_URL + "api/ProductManger/QueryProductAndComboDataList";

        //店铺详细信息
        public static final String GET_SHOP_INFO = MyApplication.BASE_URL + "api/Shops/GetShopInfo";

        //店铺详细信息2
        public static final String GET_SHOPS_INFO = MyApplication.BASE_URL + "api/Shops/GetShops";

        //商品消费提交
        public static final String GOODS_CONSUME_SUB = MyApplication.BASE_URL + "api/ConsumeOrder/SubmitConsumOrder";

        //快速消费提交
        public static final String GOODS_CELERITY_SUB = MyApplication.BASE_URL + "api/ConsumeOrder/SubmitCelerityOrder";

        //挂单
        public static final String GOODS_CONSUME_GUADAN = MyApplication.BASE_URL + "api/ConsumeOrder/SubmitConsumOrder_GuaDan";

        //取消挂单
        public static final String CLOSE_GUADAN_ORDER = MyApplication.BASE_URL + "api/ConsumeOrder/CloseGuadanOrder";

        //商品消费挂账
        public static final String CONSUME_GUAZHANG = MyApplication.BASE_URL + "api/ConsumeOrder/SubmitConsumOrder_GuaZhang";

        //获取商品消费打印参数
        public static final String GET_GOODS_PRINT_DATA = MyApplication.BASE_URL + "api/PrintTemplate/PrintConsumeOrder";
        //会员开卡打印参数
        public static final String PRINT_VIP_OPEN_CARD = MyApplication.BASE_URL + "api/PrintTemplate/PrintVipOpenCard";

        //参数开关
        public static final String GET_SWITCH_LIST = MyApplication.BASE_URL + "api/SetSwitch/GetSysSwitchList";

        //获取用户信息
        public static final String USER_INFORMATION = MyApplication.BASE_URL + "api/UserManager/UserInformation";

        //获取有效提成规则
        public static final String GET_VALIDRULE = MyApplication.BASE_URL + "api/StaffCommission/GetValidRule";

        //会员列表
        public static final String VIPLIST = MyApplication.BASE_URL + "api/VIP/QueryDataList";

        //获取优惠券列表
        public static final String QUERY_COUPONS_BYCODE = MyApplication.BASE_URL + "api/CouponManager/QueryCouponsByCode";

        //获取打印模板
        public static final String GET_PRINT_TEMP = MyApplication.BASE_URL + "api/PrintTemplate/GetPrintTemplateList";

        //获取打印设置
        public static final String GET_PRINT_SET = MyApplication.BASE_URL + "api/PrintSet/GetPrintSet";

        //编辑打印设置
        public static final String EDIT_PRINT_SET = MyApplication.BASE_URL + "api/PrintSet/EditPrintSet";

        //短信开关
        public static final String SMS_LIST = MyApplication.BASE_URL + "api/SysSMSTemp/GetList";

        //验证密码
        public static final String PASSWORD_VERIFY = MyApplication.BASE_URL + "api/VIP/PasswordVerify";
        //获取短信验证码
        public static final String GET_VIP_SMS_VERIFY = MyApplication.BASE_URL + "api/VIP/GetVIPSmsVerify";
        //验证短信验证码
        public static final String CHECK_VERIFY = MyApplication.BASE_URL + "api/VIP/CheckVerify";
        //会员标签
        public static final String MEMBER_LABEL = MyApplication.BASE_URL + "api/MemberLabel/QueryDataList";
        //添加会员
        public static final String ADDUSER = MyApplication.BASE_URL + "api/VIP/AddVIP";
        //修改会员信息
        public static final String EDIVIP = MyApplication.BASE_URL + "api/VIP/EditVIP";
        //上传会员头像
        public static final String UPLOAD_MEMBER_PHOTO = MyApplication.BASE_URL + "api/RecvImage/UploadImg";
        //获取有效优惠活动
        public static final String DISSCOUNT_ACTIVITY = MyApplication.BASE_URL + "api/RechargePackage/GetValidList";
        //会员充值接口提交
        public static final String MEM_RECHARGE_SUB = MyApplication.BASE_URL + "api/Recharge/SubmitRecharge";
        //会员充值接口支付
        public static final String MEM_RECHARGE_PAY = MyApplication.BASE_URL + "api/Recharge/PaymentRecharge";

    }

}


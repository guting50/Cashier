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

        // 静态方法返回该类的实例
        static HttpAPIOfficial getHttpAPIOfficial() {
            return instance;
        }

        //修改密码
        public static final String EDIT_USERPWD = MyApplication.BASE_URL + "api/UserManager/EditUsersPwd";
        //员工列表
        public static final String GET_EMPLLIST = MyApplication.BASE_URL + "api/Empl/GetEmplList";
        //查询商品规格
        public static final String GOODSMODEL = MyApplication.BASE_URL + "api/ProductConfig/GetModelList";
        //查询商品组合
        public static final String GROUPGOODS_LIST = MyApplication.BASE_URL + "api/ProductManger/GetGroupGoodsList";
        //查询商品列表
        public static final String QUERYALL_LIST = MyApplication.BASE_URL + "api/ConsumeOrder/QueryAllOrderList";
        //登陆
        public static final String LOGIN = MyApplication.BASE_URL + "api/UserManager/Login";
        //获取验证码
        public static final String GET_CODE = MyApplication.BASE_URL + "api/VerifyCode/GetCode";

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

        //商品消费挂账
        public static final String CONSUME_GUAZHANG = MyApplication.BASE_URL + "api/ConsumeOrder/SubmitConsumOrder_GuaZhang";

        //获取商品消费打印参数
        public static final String GET_GOODS_PRINT_DATA = MyApplication.BASE_URL + "api/PrintTemplate/PrintConsumeOrder";

        //参数开关
        public static final String GET_SWITCH_LIST = MyApplication.BASE_URL + "api/SetSwitch/GetSysSwitchList";

        //获取用户信息
        public static final String USER_INFORMATION = MyApplication.BASE_URL + "api/UserManager/UserInformation";


        //获取部门列表
        public static final String GET_VALIDRULE = MyApplication.BASE_URL + "api/StaffCommission/GetValidRule";

        //会员列表
        public static final String VIPLIST = MyApplication.BASE_URL + "api/VIP/QueryDataList";

        //获取优惠券列表
        public static final String QUERY_COUPONS_BYCODE = MyApplication.BASE_URL + "api/CouponManager/QueryCouponsByCode";


        //获取打印模板
        public static final String GET_PRINT_TEMP = MyApplication.BASE_URL + "api/PrintTemplate/GetPrintTemplateList";
        //获取打印设置
        public static final String GET_PRINT_SET = MyApplication.BASE_URL + "api/PrintSet/GetPrintSet";

        //短信开关
        public static final String SMS_LIST = MyApplication.BASE_URL + "api/SysSMSTemp/GetList";

    }

}


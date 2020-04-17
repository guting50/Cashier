package com.wycd.yushangpu.tools;

/**
 * 输入格式校验工具类
 * 作者：罗咏哲 on 2017/7/21 13:46.
 * 邮箱：137615198@qq.com
 */

public class RegexUtil {
    /**
     * 手机号号段校验，
     * 第1位：1；
     * 第2位：{3、4、5、6、7、8}任意数字；
     * 第3—11位：0—9任意数字
     *
     * 第一位1
     * 2-11位{0-9任意数字}
     * @param value
     * @return
     */
//    public static boolean isTelPhoneNumber(String value) {
//        if (value != null && value.length() == 11) {
//            Pattern pattern = Pattern.compile("^1[3|4|5|6|7|8][0-9]\\d{8}$");
//            Matcher matcher = pattern.matcher(value);
//            return matcher.matches();
//        }
//        return false;
//    }

    /****
     * 第一位1
     * 2-11位{0-9任意数字}
     * @param value
     * @return
    //     */
    public static boolean isTelPhoneNumber(String value) {
        String str = value.substring(0, 1);
        if (value != null && value.length() == 11 && str.equals("1")) {
            return true;
        }
        return false;
    }


    /**
     * 验证输入的身份证号是否合法
     */
    public static boolean isLegalId(String id) {
        return id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)");
    }

    /**
     * 校验输入的是否是0-1之间形如0.1，0.01的数，包括0，1，
     *
     * @param dis
     * @return
     */
    public static boolean isDiscount(String dis) {
        return dis.matches("^[0]$|0\\.[0-9]{0,2}$");
    }

    /**
     * 是否时一个金额
     *
     * @param money
     * @return
     */
    public static boolean isMoney(String money) {
        return money.matches("(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^(0){1}$)|(^\\d\\.\\d{1,2}?$)");
    }

    /**
     * 是否是1-100之间的数，包括1、100
     *
     * @param dis
     * @return
     */
    public static boolean isDis(String dis) {
        return dis.matches("^([1-9]\\d?|100)$");
    }

}

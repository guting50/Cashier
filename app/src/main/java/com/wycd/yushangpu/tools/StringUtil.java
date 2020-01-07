package com.wycd.yushangpu.tools;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 */
public class StringUtil {

    static DecimalFormat df = new DecimalFormat("0.00");

    /***
     * 保留两位小数 末尾保四舍五入
     * @param num
     * @return
     */
    public static String twoNum(double num) {
        return twoNum(num + "");
    }

    public static String twoNum(String num) {
        return num == null || num.equals("0") || num.equals("0.0") || num.equals("") ? df.format(0.00) : df.format(Double.parseDouble(num));
    }

    public static String onlyTwoNum(String rateStr) {
        if (rateStr.indexOf(".") != -1) {
            //获取小数点的位置
            int num = 0;
            //找到小数点在字符串中的位置,找到返回一个int类型的数字,不存在的话返回 -1
            num = rateStr.indexOf(".");

            String dianAfter = rateStr.substring(0, num + 1);//输入100.30,dianAfter = 100.
            String afterData = rateStr.replace(dianAfter, "");//把原字符(rateStr)串包括小数点和小数点前的字符替换成"",最后得到小数点后的字符(不包括小数点)

            //判断小数点后字符的长度并做不同的操作,得到小数点后两位的字符串
            if (afterData.length() < 2) {
                afterData = afterData + "0";
            } else {
                afterData = afterData;
            }
            //返回元字符串开始到小数点的位置 + "." + 小数点后两位字符
            return rateStr.substring(0, num) + "." + afterData.substring(0, 2);
        } else {

            return rateStr + ".00";

        }

    }

    /**
     * 加密排序用
     *
     * @param source
     * @return
     */
    public static List<String> sort(List<String> source) {
        Collections.sort(source, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return source;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || str.equals("")) {
            return true;
        }
        return false;
    }

    public static String dateFormat(String date) {
        String resultDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            resultDate = sdf.format(sdf.parse(date));
        } catch (Exception e) {
            Log.e(StringUtil.class.getName(), e.getMessage());
        }

        return resultDate;
    }

    public static boolean isTwoPoint(String str) {
        if (str.contains(".")) {
            int posdian = str.indexOf(".");
            int mLenth = str.length();
            if (mLenth - posdian > 3) {
                return false;
            } else {
                return true;
            }
        }
        return true;


    }
}

package com.wycd.yushangpu.printutil;

import java.text.DecimalFormat;

/**
 * 将金额类的数值转换为0.00格式
 * Created by Cheng on 2017/2/27.
 */
public class Decima2KeeplUtil {
    static DecimalFormat df = new DecimalFormat("0.00");

    public static String stringToDecimal(String num) {

        return num == null || num.equals("0") || num.equals("0.0") || num.equals("") ? df.format(0.00) : df.format(Double.parseDouble(num));
    }

}

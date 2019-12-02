package com.wycd.yushangpu.tools;

/**
 * Created by Administrator on 2018/6/21 0021.
 */

public class NullUtils {
    public static Object noNullHandle(Object ob) {
        if (null == ob) {
            if (ob instanceof Integer) {
                return 0;
            } else if (ob instanceof String) {
                return "";
            } else if (ob instanceof Double) {
                return 0.0;
            } else if (ob instanceof Boolean) {
                return false;
            } else {
                return "";
            }
        } else {
            return ob;
        }
    }

    /**
     * 判断StringBuilder是否为空
     * @param sb
     * @return
     */
    public static boolean isNull(StringBuilder sb) {
        if (sb == null) {
            return true;
        }
        if (sb.length() == 0) {
            return true;
        }
        return false;
    }

}

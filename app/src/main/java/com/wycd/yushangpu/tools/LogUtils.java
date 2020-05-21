package com.wycd.yushangpu.tools;

import android.util.Log;

import com.gt.utils.LogsUtils;
import com.wycd.yushangpu.MyApplication;

public class LogUtils {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static final int LEVEL = 1;

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
            //LogsUtils.writeInfoLog(MyApplication.getContext(), MyApplication.loginBean == null ? "" : MyApplication.loginBean.getUM_Acount(), tag + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg);
        }
        LogsUtils.writeEooroLog(MyApplication.getContext(), MyApplication.loginBean == null ? "" : MyApplication.loginBean.getUM_Acount(), tag + msg);
    }
}
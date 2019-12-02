package com.wycd.yushangpu.tools;

import android.util.Log;

import com.google.gson.Gson;

public class LogUtils {
public static final int VERBOSE = 1;
public static final int DEBUG = 2;
public static final int INFO = 3;
public static final int WARN = 4;
public static final int ERROR = 5;
public static final int NOTHING = 6;
public static final int LEVEL = 0;
    public static final String tag = "xxlog";
public static void v( String msg) {
if (LEVEL <= VERBOSE) {
Log.v(tag, msg);
}
}
public static void d( String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }
    public static void d(String ta,String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(ta, msg);
        }
    }
    public static void d( Object msg) {
        if (LEVEL <= DEBUG) {
            Gson gson=new Gson();
            Log.d(tag, gson.toJson(msg));
        }
    }
public static void i( String msg) {
if (LEVEL <= INFO) {
Log.i(tag, msg);
}
}
public static void w(String msg) {
if (LEVEL <= WARN) {
Log.w(tag, msg);
}
}
public static void e(String msg) {
if (LEVEL <= ERROR) {
Log.e(tag, msg);
}
}
}
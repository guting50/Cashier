package com.wycd.yushangpu.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceHelper {
    /**
     * SharedPreferences操作工具包<br>
     * <p>
     * <b>说明</b> 本工具包只能在单进程项目下使用，多进程共享请使用如下demo的两行代码重写: <br>
     * Context otherContext = c.createPackageContext( "com.android.contacts",
     * Context.CONTEXT_IGNORE_SECURITY); <br>
     * SharedPreferences sp = otherContext.getSharedPreferences( "my_file",
     * Context.MODE_MULTI_PROCESS);<br>
     * <p>
     * <b>创建时间</b> 2014-7-27
     *
     * @author kymjs (https://github.com/kymjs)
     */


    public static void write(Context context, String fileName, String k, int v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static void write(Context context, String fileName, String k,
                             boolean v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static void write(Context context, String fileName, String k,
                             String v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public static int readInt(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getInt(k, 0);
    }

    public static int readInt(Context context, String fileName, String k,
                              int defv) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getInt(k, defv);
    }

    public static boolean readBoolean(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getBoolean(k, false);
    }

    public static boolean readBoolean(Context context, String fileName,
                                      String k, boolean defBool) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getBoolean(k, defBool);
    }

    public static String readString(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getString(k, null);
    }

    public static String readString(Context context, String fileName, String k,
                                    String defV) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        return preference.getString(k, defV);
    }

    public static void remove(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void clean(Context cxt, String fileName) {
        SharedPreferences preference = cxt.getSharedPreferences(fileName,
                Context.MODE_MULTI_PROCESS);
        Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }
}

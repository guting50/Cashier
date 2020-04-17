package com.wycd.yushangpu.tools;

import android.content.Context;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期时间工具
 * 作者：罗咏哲 on 2017/9/6 14:33.
 * 邮箱：137615198@qq.com
 */

public class DateTimeUtil {
    /**
     * 获取今天日期（yyyy-mm-dd）
     *
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        return format.format(curDate);
    }

    public static String getReallyTimeNow() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
//        Date curDate = new Date(System.currentTimeMillis());

        String currentTime = format.format(System.currentTimeMillis());
        return currentTime;
    }

    public static String getReallyTimeNow(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
//        Date curDate = new Date(System.currentTimeMillis());

        String currentTime = format.format(System.currentTimeMillis());
        return currentTime;
    }

    /**
     * 获取昨天日期
     *
     * @return
     */
    public static String getLastDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis() - 86400000);
        return format.format(curDate);
    }


    /**
     * 获取本周第一天
     *
     * @return
     */
    public static String getNowWeekFirstDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 2);
        cal.getTime();
        return format.format(cal.getTime());
    }

    /**
     * 获取本周最后一天
     *
     * @return
     */
    public static String getNowWeekFinalDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        cal.getTime();
        return format.format(cal.getTime());
    }

    /**
     * 获取本年第一天
     *
     * @return
     */
    public static String getNowYearFirstDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.getTime();
        return format.format(cal.getTime());
    }

    /**
     * 获取本年最后一天
     *
     * @return
     */
    public static String getNowYearFinalDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
//        cal.add(Calendar.DAY_OF_YEAR,1);
        cal.getTime();
        return format.format(cal.getTime());
    }


    public static boolean isOverTime(Context context, String startdate, String entdate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        long starttime = sdf.parse(startdate + "").getTime();
        long endTime = sdf.parse(entdate + "").getTime();
        long time = starttime - endTime;
        if (time > 0) {
            Toast.makeText(context, "结束时间不能小于开始时间！", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCurTime(Context context, String date) {
        boolean a = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long overtime = sdf.parse(date + "").getTime();
            long currentTime = System.currentTimeMillis();

            long time = overtime - currentTime;
            if (time > 0) {
                Toast.makeText(context, "选择日期不能超过当前日期！", Toast.LENGTH_LONG).show();
                a = false;
            } else {
//                postVip(mMemberInfo.getVCH_Card());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return a;


    }

    public static String formatTime(String data) {
        String str = null;
        if (data.length() > 10)
            str = data.substring(0, 10);
        return str;
    }

}

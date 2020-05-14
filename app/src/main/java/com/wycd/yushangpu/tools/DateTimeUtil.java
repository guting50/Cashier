package com.wycd.yushangpu.tools;

import android.content.Context;
import android.text.TextUtils;
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

    public static boolean isBirthday(String birthday, int isLunar/*农历生日:0:否,1:是*/) {
        return isBirthday(birthday, getReallyTimeNow(), isLunar);
    }

    public static boolean isBirthday(String data1, String data2, int isLunar/*农历生日:0:否,1:是*/) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        try {
            if (isLunar == 1) {
                //农历生日
                LunarUtil lunar = new LunarUtil(Calendar.getInstance());
                if (TextUtils.equals(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd下·").parse(data1)),
                        (lunar.month < 10 ? ("0" + lunar.month) : lunar.month) + "-" + lunar.day)) {
                    return true;
                }
            } else {
                //公历生日
                if (TextUtils.equals(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd").parse(data1)),
                        dateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data2)))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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


    public static String handlerTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String entry_time = formatter.format(curDate);
//        0-6点是凌晨,6-11.59点是上午12点是中午12-18是下午,18-24是晚上
        String time = entry_time.substring(5, 7);
        int timen = Integer.parseInt(time);
        String welcome = "早上好！";
        if (timen < 6) {
            welcome = "早上好";
        } else if (timen > 6 && timen < 12) {
            welcome = "上午好";
        } else if (timen == 12) {
            welcome = "中午好";
        } else if (timen > 12 && timen < 18) {
            welcome = "下午好";
        } else {
            welcome = "晚上好";
        }
        return welcome;
    }

    private static SimpleDateFormat sf = null;

    /* 获取系统时间 格式为："yyyy/MM/dd " */
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /* 时间戳转换成字符窜 */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String times = sf.format(d);
        return times.substring(0, 11);
    }

    public static String getDateToStringAll(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String times = sf.format(d);
        return times;
    }

    /**
     * 而最常用的：
     * 由于服务端返回的一般是UNIX时间戳，所以需要把UNIX时间戳timeStamp转换成固定格式的字符串
     */
    public static String formatData(String dataFormat, long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        timeStamp = timeStamp * 1000;
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }

    public static String formatAndroidData(String dataFormat, long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }

    /* 将字符串转为时间戳 */
    public static long getStringToDate(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static String getCurrentTime(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String entry_time = formatter.format(curDate);
        return entry_time;
    }

    /***
     * yu 当前时间判断是否过期
     * @param date
     * @return
     */
    public static boolean isOverTime(String date) {
        if (date != null) {//为空永久有效 返回true
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                long overtime = sdf.parse(date + "").getTime();
                long currentTime = sdf.parse(sdf.format(System.currentTimeMillis())).getTime();
                long time = overtime - currentTime;
                if (time < 0) {
                    //过期
                    return false;
                } else {

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        return true;

    }

}

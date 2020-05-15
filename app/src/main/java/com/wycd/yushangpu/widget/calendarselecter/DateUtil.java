package com.wycd.yushangpu.widget.calendarselecter;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lmt on 16/7/6.
 */
public class DateUtil {

    public static final String ymdhms = "yyyy-MM-dd HH:mm:ss";
    public static final String ymd = "yyyy-MM-dd";

    public static String monthNumToMonthName(String month) {
        String m = month;
        if ("1".equals(month)) {
            m = "一月";
        } else if ("2".equals(month)) {
            m = "二月";
        } else if ("3".equals(month)) {
            m = "三月";
        } else if ("4".equals(month)) {
            m = "四月";
        } else if ("5".equals(month)) {
            m = "五月";
        } else if ("6".equals(month)) {
            m = "六月";
        } else if ("7".equals(month)) {
            m = "七月";
        } else if ("8".equals(month)) {
            m = "八月";
        } else if ("9".equals(month)) {
            m = "九月";
        } else if ("10".equals(month)) {
            m = "十月";
        } else if ("11".equals(month)) {
            m = "冬月";
        } else if ("12".equals(month)) {
            m = "腊月";
        }
        return m;
    }

    public static String dayToDayName(String day) {
        String n = day;

        if ("1".equals(day)) {
            n = "初一";
        } else if ("2".equals(day)) {
            n = "初二";
        } else if ("3".equals(day)) {
            n = "初三";
        } else if ("4".equals(day)) {
            n = "初四";
        } else if ("5".equals(day)) {
            n = "初五";
        } else if ("6".equals(day)) {
            n = "初六";
        } else if ("7".equals(day)) {
            n = "初七";
        } else if ("8".equals(day)) {
            n = "初八";
        } else if ("9".equals(day)) {
            n = "初九";
        } else if ("10".equals(day)) {
            n = "初十";
        } else if ("11".equals(day)) {
            n = "十一";
        } else if ("12".equals(day)) {
            n = "十二";
        } else if ("13".equals(day)) {
            n = "十三";
        } else if ("14".equals(day)) {
            n = "十四";
        } else if ("15".equals(day)) {
            n = "十五";
        } else if ("16".equals(day)) {
            n = "十六";
        } else if ("17".equals(day)) {
            n = "十七";
        } else if ("18".equals(day)) {
            n = "十八";
        } else if ("19".equals(day)) {
            n = "十九";
        } else if ("20".equals(day)) {
            n = "廿十";
        } else if ("21".equals(day)) {
            n = "廿一";
        } else if ("22".equals(day)) {
            n = "廿二";
        } else if ("23".equals(day)) {
            n = "廿三";
        } else if ("24".equals(day)) {
            n = "廿四";
        } else if ("25".equals(day)) {
            n = "廿五";
        } else if ("26".equals(day)) {
            n = "廿六";
        } else if ("27".equals(day)) {
            n = "廿七";
        } else if ("28".equals(day)) {
            n = "廿八";
        } else if ("29".equals(day)) {
            n = "廿九";
        } else if ("30".equals(day)) {
            n = "三十";
        } else if ("31".equals(day)) {
            n = "三十一";
        }
        return n;
    }


    public static String getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "-" + (month > 9 ? month : ("0" + month)) + "-" + day;
    }

    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "-" + (month > 9 ? month : ("0" + month)) + "-" + day;
    }

    public static List<Integer> getDateForString(String date) {
        String[] dates = date.split("-");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(dates[0]));
        list.add(Integer.parseInt(dates[1]));
        list.add(Integer.parseInt(dates[2].split(" ")[0]));
        Log.e("dialog------", list.toString());
        return list;
    }

    public static List<String> getStringForlist(String str) {
        String[] strs = str.split("\\|");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return list;
    }

    public static List<Integer> getReallyDateForString(String date) {
        String[] dates1 = date.split(" ");
        String[] dates2 = dates1[0].split("-");
        String[] dates3 = dates1[1].split(":");

        String[] dates = date.split("-");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(dates2[0]));
        list.add(Integer.parseInt(dates2[1]));
        list.add(Integer.parseInt(dates2[2]));
        list.add(Integer.parseInt(dates3[0]));
        list.add(Integer.parseInt(dates3[1]));
        list.add(Integer.parseInt(dates3[2]));
        Log.e("dialog------", list.toString());
        return list;
    }

    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    public static String formatDate(String date, String format) {
        String resultD = date;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(date);
            resultD = sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultD;
    }

    public static String formatDate(long milliseconds, String format) {
        String resultD = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = new Date(milliseconds);
            resultD = sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultD;
    }

    public static Date formatDateStr(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * 通过年份和月份 得到当月的日子
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDays(int year, int month) {
        month++;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    /**
     * 返回当前月份1号位于周几
     *
     * @param year  年份
     * @param month 月份，传入系统获取的，不需要正常的
     * @return 日：1		一：2		二：3		三：4		四：5		五：6		六：7
     */
    @SuppressLint("WrongConstant")
    public static int getFirstDayWeek(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        Log.d("DateView", "DateView:First:" + calendar.getFirstDayOfWeek());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    @SuppressLint("WrongConstant")
    public static String getDayWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Log.d("DateView", "DateView:First:" + calendar.getFirstDayOfWeek());

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "周日";

            case 2:
                return "周一";

            case 3:
                return "周二";

            case 4:
                return "周三";

            case 5:
                return "周四";

            case 6:
                return "周五";

            case 7:
                return "周六";

            default:
                return "";

        }
    }
}

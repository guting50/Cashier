package com.wycd.yushangpu.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by songxiaotao on 2018/2/7.
 */

public class DateUtils {
    /**
     * 45.     * 获取当前时间
     * 46.     *
     * 47.     * @return
     * 48.
     */
    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 掉此方法输入所要转换的时间输入例如（"2014年06月14日16时09分00秒"）返回时间戳
     */
    public static String timeTodata(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
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
        if (date!=null){//为空永久有效 返回true
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

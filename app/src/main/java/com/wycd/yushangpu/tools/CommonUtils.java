package com.wycd.yushangpu.tools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    /**
     * 获取屏幕宽高
     */
    public static int[] getViewWith(View view) {
        int

                width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);

        int

                height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);

        view.measure(width, height);
        int[] wh = new int[2];
        wh[1] = view.getMeasuredHeight();
        wh[0] = view.getMeasuredWidth();
        return wh;
    }

    //�验证手机号是否正确ֻ��
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return !m.matches();
    }

    /**
     * 判断本地的私有文件夹里面是否存在当前名字的文件
     */
    public static boolean isFileExist(String fileName, Context cxt) {
        String bitmapName = fileName.substring(fileName.lastIndexOf("/") + 1);
        List<String> nameLst = Arrays.asList(cxt.fileList());
        if (nameLst.contains(bitmapName)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 判断网络是否连接
     */
    public static boolean checkNet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null;// 网络是否连接
    }

//	public static String obtainUrl(Context context, Map<String, Object> map,
//			String url) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(ContansUtils.BASE_URL + url + "?");
//		Iterator<Entry<String, Object>> iter = CommonUtil.addSign(context, map)
//				.entrySet().iterator();
//		while (iter.hasNext()) {
//			Entry<String, Object> entry = (Entry<String, Object>) iter
//					.next();
//			// 拼接
//			sb.append(entry.getKey() + "=");
//			sb.append(entry.getValue() + "&");
//		}
//		return sb.toString();
//	}


    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                /*
                 * BACKGROUND=400 EMPTY=500 FOREGROUND=100 GONE=1000
                 * PERCEPTIBLE=130 SERVICE=300 ISIBLE=200
                 */
                Log.i("xx", "此appimportace =" + appProcess.importance
                        + ",context.getClass().getName()="
                        + context.getClass().getName());
                if (appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    Log.i("xx", "处于后台" + appProcess.processName);
                    return true;
                } else {
                    Log.i("xx", "处于前台" + appProcess.processName);
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1
     * @param v2
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        return add(Double.toString(v1), Double.toString(v2));
    }

    public static double add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 去除空格
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1
     * @param v2
     * @return 两个参数的数学积，以字符串格式返回
     */
    public static double multiply(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(replaceBlank(v1));
        BigDecimal b2 = new BigDecimal(replaceBlank(v2));
        return b1.multiply(b2).doubleValue();

    }

    public static double multiply(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).doubleValue();

    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(String v1, String v2, int scale) {
        return div(Double.parseDouble(v1), Double.parseDouble(v2), scale, BigDecimal.ROUND_HALF_UP);
    }

    public static double div(double v1, double v2, int scale) {
        return div(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static double div(double v1, double v2, int scale, int roundingMode) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        if (v2 == 0) {
            return 0;
        } else {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, scale, roundingMode).doubleValue();
        }
    }

    /**
     * double 相减
     *
     * @param d1
     * @param d2
     * @return
     */

    public static double del(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * 得到当前系统上个月的时间
     *
     * @return
     */
    public static String getAgoDate(int num) {
        Calendar c = Calendar.getInstance();
        // c.add(Calendar.MONTH, -1);
        c.add(Calendar.MONTH, num);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
        return df.format(c.getTime());// new Date()为获取当前系统时间
    }

    /**
     * 得到当前时间上个月的时间
     *
     * @return
     */
    public static String getAgoDate(String time, int num) {
        String[] ti = time.split("/");
        // java月份是从0-11,月份设置时要减1.
        Calendar c = new GregorianCalendar(Integer.parseInt(ti[0]),
                Integer.parseInt(ti[1]) - 1, Integer.parseInt(ti[2]));
        // c.add(Calendar.MONTH, -1);
        c.add(c.MONTH, num);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
        return df.format(c.getTime());// new Date()为获取当前系统时间
    }

    public static boolean checkWifiConnect(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
     * 删除保存于手机上的缓存
     */

    // clear the cache before time numDays
    public static int clearCacheFolder(File dir, long numDays) {
        int deletedFiles = 0;
        if (dir != null && dir.isDirectory()) {
            try {
                for (File child : dir.listFiles()) {
                    if (child.isDirectory()) {
                        deletedFiles += clearCacheFolder(child, numDays);
                    }
                    if (child.lastModified() < numDays) {
                        if (child.delete()) {
                            deletedFiles++;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return deletedFiles;
    }

    /**
     * 清除cookie
     */

    public static void clearCookies(Context context) {
        // Edge case: an illegal state exception is thrown if an instance of
        // CookieSyncManager has not be created. CookieSyncManager is normally
        // created by a WebKit view, but this might happen if you start the
        // app, restore saved state, and click logout before running a UI
        // dialog in a WebView -- in which case the app crashes
        @SuppressWarnings("unused")
        CookieSyncManager cookieSyncMngr = CookieSyncManager
                .createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }

    // 以下是获得版本信息的工具方法

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断某个界面是否在前台
     *
     * @param context
     * @param className 某个界面名称
     */
    public static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }

        return false;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static boolean wifiIsUsed(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetworkInfo != null && wifiNetworkInfo.isAvailable()) {

            return true;
        }
        return false;
    }

    // public static String Base64ss(String string) {
    // // String base64Token =
    // // android.util.Base64.encodeToString(string.trim().getBytes(),
    // // Base64.NO_WRAP);
    // // byte[] mmmm = Base64.decode(base64Token,Base64.DEFAULT);
    // // return new String(mmmm);
    // return Base64.encode(string);
    // //
    // // byte[] buffer=string.trim().getBytes();
    // // return Base64.encodeToString(buffer, 0, buffer.length,
    // // Base64.DEFAULT);
    // }
    public static String lasttwo(double money) {

        BigDecimal bigDec = new BigDecimal(money);

        double total = bigDec.setScale(2, BigDecimal.ROUND_HALF_UP)

                .doubleValue();

        DecimalFormat df = new DecimalFormat("0.00");

        return df.format(total);

    }
}

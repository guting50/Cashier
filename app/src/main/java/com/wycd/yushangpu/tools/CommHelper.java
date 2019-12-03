package com.wycd.yushangpu.tools;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/***
 * 基础攻击类
 * 
 * @author huangyc
 * 
 */
public class CommHelper {


	/***
	 * 检测应用是否安装
	 * @param context
	 * @param bundleName
	 * @return
	 */
	public static  boolean isInstallAPK(Context context, String bundleName){
		List<PackageInfo> list= context.getPackageManager().getInstalledPackages(0);
		for(PackageInfo item:list){
			if (bundleName.equals(item.packageName)){
				return true;
			}
		}
		return false;
	}

	/***
	 * 获取颜色
	 * @param context
	 * @param resId
     * @return
     */
	public static int getColor(Context context, int resId){
		if(Build.VERSION.SDK_INT>=23) {
			return context.getResources().getColor(resId, null);
		}else{
			return context.getResources().getColor(resId);
		}
	}

	public static String getAppVersion(Context context){
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public static int getAppVersionCode(Context context){
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static String getAppName(Context context) {
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			int labelRes = packageInfo.applicationInfo.labelRes;
			return context.getResources().getString(labelRes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/***
	 * 检测权限
	 * @param context
	 * @param permissions
     */
	public  static List<String> checkPermissions(Activity context, String[] permissions){
		List<String> list=new ArrayList<String>();
		for (String p :permissions){
			if (ContextCompat.checkSelfPermission(context,p)!=PackageManager.PERMISSION_GRANTED){
				list.add(p);
			}
		}
		if (list.size()>0){
			return list;
		}
		return null;
	}

	/***
	 * 申请权限
	 * @param context
	 * @param permissions
     */
	public static void requestPermissions(Activity context, List<String> permissions){
		if(permissions==null || permissions.size()==0){
			return;
		}
		ActivityCompat.requestPermissions(context,permissions.toArray(new String[]{}),1);
	}

	/***
	 * 申请权限
	 * @param context
	 * @param permission
     */
	public static  void requestPermission(Activity context, String permission){
		if(ContextCompat.checkSelfPermission(context,permission) != PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(context,new String[]{permission},1);
		}
	}


	/***
	 * 设置状态栏颜色
	 * @param context
	 * @param color
     */
	public static void setWindowStatusBarColor(Activity context, int color){
		try{
			if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
				Window window=context.getWindow();
				window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				window.setStatusBarColor(color);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getAnnotation
	 * @Description: 获取注解
	 * @param @param field
	 * @param @param t
	 * @param @return 参数
	 * @return T 返回类型
	 * @author huangyc
	 * @date 2014-11-7 下午8:48:05
	 */
	public static <T> T getAnnotation(Field field, Class<T> t) {
		Annotation v_ans[] = field.getDeclaredAnnotations();
		if (v_ans == null || v_ans.length == 0) {
			return null;
		}
		for (Annotation an : v_ans) {
			Class b = an.annotationType();
			String c = b.getName();
			String d = t.getName();
			if (c.equals(d)) {
				return (T) an;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getField
	 * @Description: 查询父类字段
	 * @param @param v_list
	 * @param @param classz 参数
	 * @return void 返回类型
	 * @author huangyc
	 * @date 2014-11-7 下午8:23:32
	 */
	public static void getField(List<Field> v_list, Class<?> classz) {
		Field v_fs[] = classz.getDeclaredFields();
		for (Field f : v_fs) {
			v_list.add(f);
		}
		if (classz.getSuperclass() != Activity.class) {
			getField(v_list, classz.getSuperclass());
		}
	}

	public static Method getMethod(Class<?> classz, String methodName, Class<?> param) {
		Method d = null;
		try {
			d = classz.getDeclaredMethod(methodName, param);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		if (d == null && classz != View.class) {
			return getMethod(classz.getSuperclass(), methodName, param);
		} else {
			return d;
		}
	}

	/***
	 * 
	 * @Title: showKeyBord
	 * @Description: 显示软键盘
	 * @param @param primaryTextField 参数
	 * @return void 返回类型
	 * @author huangyc
	 * @date 2014-10-22 下午3:43:09
	 */
	public static void showKeyBord(final EditText primaryTextField) {
		(new Handler()).postDelayed(new Runnable() {
			public void run() {
				primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0));
				primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0, 0, 0));
				primaryTextField.setSelection(primaryTextField.getText().length());
			}
		}, 100);
	}

	/**
	 * 
	 * @Title: hideKeyBord
	 * @Description: 关闭软键盘
	 * @param @param activity
	 * @param @param ed 参数
	 * @return void 返回类型
	 * @author huangyc
	 * @date 2014-10-22 下午3:43:59
	 */
	public static void hideKeyBord(final Context activity, final EditText ed) {
		InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(ed.getWindowToken(), 0);
	}

	/**
	 * 
	 * @Title: requestLayoutListView
	 * @Description: 重新布局listView高度，使其不滚动
	 * @param @param listView 参数
	 * @return void 返回类型
	 * @throws
	 * @author huangyc
	 * @date 2014-7-4 下午4:22:35
	 */
	public static void requestLayoutListView(ListView listView) {
		ListAdapter mAdapter = listView.getAdapter();
		if (mAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < mAdapter.getCount(); i++) {
			View mView = mAdapter.getView(i, null, listView);
			if (mView == null) {
				continue;
			}
			mView.measure(0, 0);
			totalHeight += mView.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
		listView.setLayoutParams(params);
		listView.requestLayout();
	}

	/***
	 * 
	 * @Title: getIMEI
	 * @Description: 获取IMEI
	 * @param @param context
	 * @param @return 参数
	 * @return String 返回类型
	 * @author huangyc
	 * @date 2014-10-16 下午12:09:46
	 */
	public static String getIMEI(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}

	/***
	 * 
	 * @Title: getIMSI
	 * @Description: 获取IMSI
	 * @param @param context
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 * @author huangyc
	 * @date 2014-10-16 下午12:09:58
	 */
	public static String getIMSI(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getSubscriberId();
	}

	/***
	 * 
	 * @Title: getSimSerialNumber
	 * @Description: 获取sim卡序列号
	 * @param @param context
	 * @param @return 参数
	 * @return String 返回类型
	 * @author huangyc
	 * @date 2014-10-16 下午12:10:10
	 */
	public static String getSimSerialNumber(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getSimSerialNumber();
	}

	/**
	 * 
	 * @Title: getPhoneNum
	 * @Description: 获取电话号码
	 * @param @param context
	 * @param @return 参数
	 * @return String 返回类型
	 * @author huangyc
	 * @date 2014-10-16 下午12:10:28
	 */
	public static String getPhoneNum(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getLine1Number();
	}

	/**
	 * 
	 * @Title: isNetworkConnected
	 * @Description: 检测网络是否可用
	 * @param @param context
	 * @param @return 参数
	 * @return boolean 返回类型
	 * @author huangyc
	 * @date 2014-10-16 下午12:03:27
	 */
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null && ni.isConnectedOrConnecting();
	}

	/**
	 * 
	 * @Title: getNetworkType
	 * @Description: 获取当前网络类型
	 * @param @param context
	 * @param @return 参数
	 * @return int 返回类型 0：没有网络 1：WIFI网络 2：MOBILE
	 * @author huangyc
	 * @date 2014-10-16 下午12:02:59
	 */
	public static int getNetworkType(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo == null) {
			return 0;
		}
		int nType = networkInfo.getType();
		if (nType == ConnectivityManager.TYPE_MOBILE) {
			return 2;
		} else if (nType == ConnectivityManager.TYPE_WIFI) {
			return 1;
		} else {
			return 0;
		}
	}

	/***
	 * 
	 * @Title: getString
	 * @Description: 获取字符串
	 * @param @param context
	 * @param @param strId
	 * @param @return 参数
	 * @return String 返回类型
	 * @author huangyc
	 * @date 2014-10-16 上午11:09:40
	 */
	public static String getString(Context context, int strId) {
		return context.getString(strId);
	}

	/***
	 * 
	 * @Title: getString
	 * @Description: 获取字符串
	 *               <p>
	 *               String tiptext
	 *               =getString(R.string.format_error,"用户名","昵称","密码");
	 * 
	 *               strings.xml 中 format_error 为：
	 * 
	 *               <string name="format_error">请使用%1$s:%2$s:%3$s的格式</string>
	 * 
	 *               返回结果： tiptext ="请使用用户名:昵称:密码的格式";
	 *               </p>
	 * 
	 * 
	 * @param @param context
	 * @param @param strId
	 * @param @param params
	 * @param @return 参数
	 * @return String 返回类型
	 * @author huangyc
	 * @date 2014-10-16 上午11:11:11
	 */
	public static String getString(Context context, int strId, Object... params) {
		return context.getString(strId, params);
	}

	/***
	 * 检测字符是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkNull(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 显示提示消息
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToastShort(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示提示消息
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToastLong(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	/**
	 * 
	 * 功能描述：
	 * <p/>
	 * 将金额分转换为元
	 * 
	 * @param @param i_fen 金额(分)
	 * @param @param i_message 错误消息名
	 * @param @param i_logger 日志对象
	 * @param @return 参数对应内容描述
	 * @return String 返回对应内容描述
	 */
	public static String formatMeoney2Y(String i_fen) {
		try {
			NumberFormat formater = null;
			double num = Double.parseDouble(i_fen) / 100;
			formater = new DecimalFormat("0.00");
			return formater.format(num);
		} catch (Exception e) {
			return i_fen;
		}
	}

	
	/**
	 * 
	 * 功能描述：
	 * <p/>
	 * 将金额元转换为分
	 * 
	 * @param @param i_yuan 金额(元)
	 * @param @param i_logger
	 * @param @return 参数对应内容描述
	 * @return String 返回对应内容描述
	 */
	public static String formatMeoney2F(String i_yuan) {
		try {
			double v_yuan = Double.valueOf(i_yuan);
			double aa = v_yuan * 100;
			DecimalFormat formater = new DecimalFormat("#");
			return formater.format(aa);
		} catch (Exception e) {
			return i_yuan;
		}
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 sp 的单位 转成为 px
	 */
	public static int sp2px(Context context, float sp) {
		float f1 = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp * f1 + 0.5F);
	}

	/**
	 * 根据手机的分辨率从 px 的单位 转成为 sp
	 */
	public static int px2sp(Context context, float sp) {
		float f1 = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp / f1 + 0.5F);
	}
	/**
	 * HEX编码 将形如0x12 0x2A 0x01 转换为122A01
	 * 
	 * @param data
	 * @return
	 */
	public static String hexEncode(byte[] data) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String tmp = Integer.toHexString(data[i] & 0xff);
			if (tmp.length() < 2) {
				buffer.append('0');
			}
			buffer.append(tmp);
		}
		String retStr = buffer.toString().toUpperCase();
		return retStr;

	}

	/**
	 * HEX解码 将形如122A01 转换为0x12 0x2A 0x01
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] hexDecode(String data) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		for (int i = 0; i < data.length(); i += 2) {
			String onebyte = data.substring(i, i + 2);
			int b = Integer.parseInt(onebyte, 16) & 0xff;
			out.write(b);
		}
		return out.toByteArray();
	}
	public static String getVersionName(Context context){
		String code=null;
		try {
			PackageManager packageManager =context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
			code=packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return code;
	}
}

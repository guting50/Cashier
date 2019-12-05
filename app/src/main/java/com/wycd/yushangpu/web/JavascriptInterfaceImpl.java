package com.wycd.yushangpu.web;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;


import com.google.gson.Gson;
import com.tencent.smtt.sdk.WebView;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.widget.dialog.LoadingDialog;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
import com.wycd.yushangpu.ui.HomeActivity;

/**
 * 自定义的Android代码和JavaScript代码之间的桥梁类
 * @author 1
 * 
 */
public class JavascriptInterfaceImpl {

	private final String TAG = JavascriptInterfaceImpl.class.getSimpleName();
	private static Activity mContext;
	private static WebView mWebView;
	private static Handler mHandler;
	public static Dialog dialog;

	/**
	 * Instantiate the interface and set the context
	 */
	JavascriptInterfaceImpl(Activity c, WebView webView) {
		mContext = c;
		mWebView = webView;
		mHandler = new Handler(Looper.getMainLooper());
		dialog = LoadingDialog.loadingDialog(mContext, 1);
	}


	/**
	 * 1获取蓝牙列表
	 * get BlueThooth Devicve Name List
	 */

	@JavascriptInterface
	public String ts_getPrinterList() {
		Gson gson = new Gson();
		String s = gson.toJson(MyApplication.mPrintList);
		return s;
	}

	/**
	 * 提供js获取登录返回数据接口
	 * @return
	 */

	@JavascriptInterface
	public String ts_getLoginApiData() {
//		ToastUtils.showToast(mContext,"调用ts_getLoginApiData成功");
		return MyApplication.getLoginBean();
	}


	/**
	 * 3更新本地打印设置
	 * * Set Print Param **/

	@JavascriptInterface
	public void ts_setPrintParam(){
		GetPrintSet.getPrintSet();

	}

	/***
	 * close the dialog
	 */

	@JavascriptInterface
	public  void ts_closeBrowser(){
		HomeActivity.closeDialog();
	}

	/***
	 * close the dialog
	 */

	@JavascriptInterface
	public  String IsPopup(){
		return MyApplication.isDialog;
	}


	/***
	 * 判断蓝牙是否开启
	 */

	@JavascriptInterface
	public  String ts_IsBluetoothOpen(){
		if (MyApplication.PRINT_IS_OPEN){
			return "1";
		}else {
			return "0";
		}
	}


	/***
	 * 更新手机端用户头像
	 */

	@JavascriptInterface
	public  void ts_SetUserHead(String headurl){
		HomeActivity.loadHeadImg(headurl);

	}

	/***
	 * 后台退出登录
	 */

	@JavascriptInterface
	public  void ts_LogOut(){
		WebActivity.loginOut();

	}

	/***
	 * 后台返回前台
	 */

	@JavascriptInterface
	public  void ts_GotoDesk(){
		WebActivity.close();

	}


	/**
	 * 交班打印
	 */
	@JavascriptInterface
	public void ts_PrintShift(String data){

		if (!data.equals("undefined")){
			new HttpGetPrintContents().JB(mContext, data);
			HomeActivity.closeJbDialog();
		}else {
//			ToastUtils.showToast(mContext,"获取打印数据失败");
			com.blankj.utilcode.util.ToastUtils.showShort("获取打印数据失败");
		}

	}

	/**
	 * 会员充值打印
	 */
	@JavascriptInterface
	public void ts_PrintMemberRecharge(String data){
		if (! data.equals("undefined")){
			new HttpGetPrintContents().HYCZ(mContext, data);
		}else {
//			ToastUtils.showToast(mContext,"获取打印数据失败");
			com.blankj.utilcode.util.ToastUtils.showShort("获取打印数据失败");
		}

	}


	/**
	 * 开始加载动画
	 */
	@JavascriptInterface
	public void ts_StartLoading(){

	}

	public static void startLoading(){
		dialog.show();
	}


	/**
	 * 结束加载动画
	 */
	@JavascriptInterface
	public void ts_EndLoading(){

		dialog.dismiss();
	}
}

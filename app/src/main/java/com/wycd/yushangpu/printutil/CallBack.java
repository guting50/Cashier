package com.wycd.yushangpu.printutil;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.dialog.LoadingDialog;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.ui.LoginActivity;


import cz.msebera.android.httpclient.Header;



/**
 * 作者：罗咏哲 on 2017/10/10 10:37.
 * 邮箱：137615198@qq.com
 */

public abstract class CallBack extends TextHttpResponseHandler {
    private String mAPI = "";
    private Dialog mDialog;
    private static  Gson gson = new Gson();

//    private T webResult;

    /**
     * 请求成功回掉
     *
     * @param responseString 返回字符串
     */
    public abstract void onSuccess(String responseString, Gson gson);

    /**
     * 请求失败提示
     *
     * @param msg 提示信息
     */
    public abstract void onFailure(String msg);

//    public abstract void onSuccess(WebResult<T> result);
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

        if (mDialog != null) {
            mDialog.dismiss();
        }
        if (statusCode != 200) {
            if (statusCode == 301 || statusCode == 302 || statusCode == 307) {
                for (int i = 0;i<headers.length;i++){
                    if (headers[i].getName().equals("Location")){
                        redirect(headers[i].getValue());
                    }
                }
//                redirect(statusCode);
            } else {
                if (mAPI != null && !mAPI.equals("")) {
                    Toast.makeText(MyApplication.getContext(), "API:" + mAPI + " 错误码：" + statusCode + " 网络错误,请检查网络是否连接!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MyApplication.getContext(), "错误码：" + statusCode + " 网络错误,请检查网络是否连接!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String strResponse) {
        //关闭动画
        if (mDialog != null) {
            mDialog.dismiss();
        }
        //请求成功处理
        if (statusCode == 200) {
            SuccessEntry obj  = CommonFun.JsonToObj(strResponse, SuccessEntry.class);
            //别处登录和登录超时跳转登录页面
            if (obj.getCode().equals("RemoteLogin") || obj.getCode().equals("LoginTimeout")) {
                ActivityManager.getInstance().exit();
                Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
                Toast.makeText(MyApplication.getContext(),obj.getMsg(), Toast.LENGTH_SHORT).show();
                return;
            }
            //接口请求成功 回调onSuccess
            if (obj.isSuccess()) {
                if (!obj.getData().equals("")) {
                    this.onSuccess(strResponse, gson);
                }
                return;
            }
            //接口请求失败 回调onFailure
            this.onFailure(obj.getMsg());
        }
    }

    /**
     * 重新登录
     */
    private void reLogin(String msg) {
//        Le("IIN_relogin");
//        SweetAlertDialog dialog = new SweetAlertDialog(MyApplication.getContext(), SweetAlertDialog.WARNING_TYPE);
//        dialog.setTitleText("提示");
//        dialog.setConfirmText("确认");
//        dialog.setCancelable(false);
//        dialog.setContentText("长时间未登录或已在别处登录，请重新登录！");
//        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//            @Override
//            public void onClick(SweetAlertDialog sweetAlertDialog) {
//                ActivityCollector.finishAll();
//                Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                MyApplication.getContext().startActivity(intent);
//                sweetAlertDialog.dismiss();
//                MyApplication.dialogFlag = true;
//            }
//        });
        // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);//小米，魅族不支持，故采用另一种方式
       // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
       // dialog.show();
//        ActivityCollector.finishAll();
//        Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        MyApplication.getContext().startActivity(intent);
//        CustomToast.makeText(MyApplication.getmContext(),msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置加载动画
     *
     * @param context
     * @param msg     显示信息
     * @param b       是否可取消
     */
    public void setLoadingAnimation(Context context, String msg, boolean b) {
        mDialog = LoadingDialog.loadingDialog(context, 1);
    }

    /**
     * 更换域名跳转操作
     *
     * @param statusCode
     */
    public void redirect(String statusCode) {


    }

    public void setmAPI(String mAPI) {
        this.mAPI = mAPI;
    }
}

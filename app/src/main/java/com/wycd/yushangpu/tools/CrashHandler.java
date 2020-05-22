package com.wycd.yushangpu.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;

import com.blankj.utilcode.util.ActivityUtils;
import com.gt.utils.LogsUtils;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.ui.BaseActivity;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import androidx.appcompat.app.AlertDialog;

/**
 * Created by Administrator on 2017/6/13.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static CrashHandler INSTANCE = new CrashHandler();
    //程序的Context对象
    private Context mContext;

    /**
     * 保证只有一个CrashHandler实例
     */
    private CrashHandler() {
    }

    /**
     * 获取CrashHandler实例 ,单例模式
     */
    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e(TAG, "error : ", e);
            }
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
                                ActivityUtils.finishAllActivitiesExceptNewest();
            System.exit(1);*/
        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                //Toast.makeText(mContext, "很抱歉,程序出现异常,即将退出.哈哈哈", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.ac);
                String msg = exceptionToString(ex);
                LogsUtils.writeEooroLog(MyApplication.getContext(), MyApplication.loginBean == null ? "" : MyApplication.loginBean.getUM_Acount(), msg);
                builder.setTitle("程序出现异常").setMessage(msg)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                android.os.Process.killProcess(android.os.Process.myPid());
                                ActivityUtils.finishAllActivitiesExceptNewest();
                                System.exit(1);
                            }
                        })
                        .create().show();

                Looper.loop();
            }
        }.start();
        ex.printStackTrace();
        //上传错误信息
        //App.getInstance().uploadErrorLogs(exceptionToString(ex));
        return true;
    }

    private String exceptionToString(Throwable ex) {

        StringBuffer sb = new StringBuffer();
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        return sb.toString();
    }
}

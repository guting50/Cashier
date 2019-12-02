package com.wycd.yushangpu.tools;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.wycd.yushangpu.R;

/**
 * Toast工具类,优化Toast
 * Created by HDL on 2016/7/26.
 */
public class ToastUtils {
    private static Toast mToast;

    /**
     * 显示对话框
     *
     * @param content 要显示的内容
     */
    public static void showToast(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }


//        View view = LayoutInflater.from(context).inflate(
//                R.layout.toast_style, null); //加载要出现的layout布局文件，转化成view
//        mToast.setView(view); //给toast设置view
//        mToast.setGravity(Gravity.TOP, 0, 0); //给toast设置在父布局中要出现的位置
        mToast.show();
    }
}

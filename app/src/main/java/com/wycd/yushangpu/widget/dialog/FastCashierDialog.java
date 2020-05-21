package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ZPH on 2019-08-07.
 */

public class FastCashierDialog {

    public static Dialog noticeDialog(final Activity context, InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_fast_cashier_layout, null);
        ImageView iv_close = (ImageView) view.findViewById(R.id.iv_close);
        NumInputView edit_view = (NumInputView) view.findViewById(R.id.edit_view);
        TextView num_keyboard_add = (TextView) view.findViewById(R.id.num_keyboard_add);
        View li_jiesuan = (View) view.findViewById(R.id.li_jiesuan);
        TextView tv_total = (TextView) view.findViewById(R.id.tv_total);

        NumKeyboardUtils numKeyboardUtils = new NumKeyboardUtils(context, view, edit_view);

        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        dialog.setContentView(view);
        Window window = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes(); //获取对话框当前的参数值
        p.width = (int) (d.getHeight() * 0.8); //宽度设置为屏幕的0.8
        p.height = (int) (d.getHeight() * 0.8);
        dialog.getWindow().setAttributes(p); //设置生效
        dialog.show();

        window.setGravity(Gravity.CENTER);

        iv_close.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });
        numKeyboardUtils.setOnDelClickListener(new NumKeyboardUtils.OnDelClickListener() {
            @Override
            public void popBack(String str) {
                edit_view.setText("");
                tv_total.setText("0.00");
                /*if (!TextUtils.isEmpty(str)) {
                    if (str.length() > 0) {
                        if (str.length() > 1 && str.contains("+")) {
                            tv_total.setText("0.00");
                        } else if (!TextUtils.equals("+", str)) {
                            tv_total.setText(
                                    Double.parseDouble(tv_total.getText().toString()) -
                                            Double.parseDouble(str) + "");
                        }
                    }
                }*/
            }
        });
        num_keyboard_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_view.getText().toString();
                if (!TextUtils.isEmpty(text) &&
                        !TextUtils.equals("+", text.substring(text.length() - 1)) &&
                        !TextUtils.equals(".", text.substring(text.length() - 1))) {
                    edit_view.addText("+");
                    String[] strList = text.split("\\+");
                    tv_total.setText(CommonUtils.add(strList[strList.length - 1], tv_total.getText().toString()) + "");
                }
            }
        });
        li_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_keyboard_add.performClick();
                back.onResponse(tv_total.getText().toString());
                dialog.dismiss();
            }
        });

        return dialog;
    }
}

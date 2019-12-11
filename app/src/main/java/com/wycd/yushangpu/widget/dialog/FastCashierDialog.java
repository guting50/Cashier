package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.InterfaceBack;
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
                if (!TextUtils.isEmpty(text) && !TextUtils.equals("+", text.substring(text.length() - 1))) {
                    edit_view.addText("+");
                    String[] strList = text.split("\\+");
                    tv_total.setText(
                            Double.parseDouble(strList[strList.length - 1]) +
                                    Double.parseDouble(tv_total.getText().toString()) + "");
                }
            }
        });
        li_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.onResponse(null);
            }
        });

        return dialog;
    }
}

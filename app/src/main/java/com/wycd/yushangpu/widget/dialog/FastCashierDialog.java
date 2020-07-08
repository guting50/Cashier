package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;
import com.wycd.yushangpu.widget.views.GtEditText;

/**
 * Created by ZPH on 2019-08-07.
 */

public class FastCashierDialog {

    public static Dialog noticeDialog(final Activity context, InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_fast_cashier_layout, null);
        ImageView iv_close = view.findViewById(R.id.iv_close);
        NumInputView edit_view = view.findViewById(R.id.edit_view);
        TextView num_keyboard_add = view.findViewById(R.id.num_keyboard_add);
        View li_jiesuan = view.findViewById(R.id.li_jiesuan);
        TextView tv_total = view.findViewById(R.id.tv_total);

        NumKeyboardUtils numKeyboardUtils = new NumKeyboardUtils(context, view, edit_view);

        dialog = new Dialog(context, R.style.ActionSheetDialogStyle) {
            int frontKeyCode;

            @Override
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                boolean result = false;
                if (event.getKeyCode() == KeyEvent.KEYCODE_EQUALS) {
                    if (frontKeyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
                        num_keyboard_add.performClick();
                        result = true;
                    }
                }
                if (keyCode == KeyEvent.KEYCODE_NUMPAD_ADD) {
                    num_keyboard_add.performClick();
                    result = true;
                }
                frontKeyCode = event.getKeyCode();
                if (frontKeyCode == KeyEvent.KEYCODE_ENTER || frontKeyCode == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                    li_jiesuan.performClick();
                    result = true;
                }
                if (result) {
                    return false;
                }
                return edit_view.onGtKeyDown(keyCode, event);
            }
        };
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
            }
        });
        iv_close.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                li_jiesuan.performClick();
                return true;
            }
            return false;
        });
        numKeyboardUtils.setOnDelClickListener(str -> {
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
        });
        num_keyboard_add.setOnClickListener(v -> {
            String text = edit_view.getText().toString();
            if (!TextUtils.isEmpty(text) &&
                    !TextUtils.equals("+", text.substring(text.length() - 1)) &&
                    !TextUtils.equals(".", text.substring(text.length() - 1))) {
                edit_view.addText("+");
                String[] strList = text.split("\\+");
                tv_total.setText(CommonUtils.add(strList[strList.length - 1], tv_total.getText().toString()) + "");
            }
        });
        li_jiesuan.setOnClickListener(v -> {
            num_keyboard_add.performClick();
            back.onResponse(tv_total.getText().toString());
            dialog.dismiss();
        });

        edit_view.setKeyEventCallback(new GtEditText.KeyEventCallback() {
            int frontKeyCode;

            @Override
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_EQUALS) {
                    if (frontKeyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
                        num_keyboard_add.performClick();
                    }
                }
                if (keyCode == KeyEvent.KEYCODE_NUMPAD_ADD) {
                    num_keyboard_add.performClick();
                }
                frontKeyCode = event.getKeyCode();
                if (frontKeyCode == KeyEvent.KEYCODE_ENTER || frontKeyCode == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                    li_jiesuan.performClick();
                }
                return false;
            }
        });
        edit_view.setFocusable(true);

        return dialog;
    }
}

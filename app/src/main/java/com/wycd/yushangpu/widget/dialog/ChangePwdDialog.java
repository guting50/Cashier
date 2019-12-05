package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpEditUsersPwd;
import com.wycd.yushangpu.ui.LoginActivity;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ChangePwdDialog {
     static Dialog dialog;

    public static Dialog numchangeDialog(final Activity context,int showingLocation){


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_change_pwd, null);

        final EditText oldPwd = (EditText) view.findViewById(R.id.ed_old_pwd);
        final EditText newPwd = (EditText) view.findViewById(R.id.ed_new_pwd);
        final EditText ensureNewPwd = (EditText) view.findViewById(R.id.ed_ensure_new_pwd);
        TextView tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tvSure = (TextView) view.findViewById(R.id.tv_sure);
        ImageView ivClose = (ImageView) view.findViewById(R.id.iv_close);
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view, new LinearLayout.LayoutParams(
                (int)(screenWidth *0.4), LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        dialog.show();

        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (oldPwd.getText().toString().length()<6){
                    oldPwd.requestFocus();
//                    ToastUtils.showToast(context,"密码不能少于6个字符");
                    com.blankj.utilcode.util.ToastUtils.showShort("密码不能少于6个字符");
                }else if (newPwd.getText().toString().length()<6){
                    newPwd.requestFocus();
//                    ToastUtils.showToast(context,"密码不能少于6个字符");
                    com.blankj.utilcode.util.ToastUtils.showShort("密码不能少于6个字符");
                }else if (ensureNewPwd.getText().toString().length()<6){
                    ensureNewPwd.requestFocus();
//                    ToastUtils.showToast(context,"密码不能少于6个字符");
                    com.blankj.utilcode.util.ToastUtils.showShort("密码不能少于6个字符");
                } else if (!ensureNewPwd.getText().toString().equals(newPwd.getText().toString())) {
                    ensureNewPwd.requestFocus();
//                    ToastUtils.showToast(context,"与新密码不一致");
                    com.blankj.utilcode.util.ToastUtils.showShort("新密码与确认新密码输入不一致");
                }else {
                    changePwd(context, oldPwd.getText().toString(), newPwd.getText().toString());

                }
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        switch (showingLocation) {
            case 0:
                window.setGravity(Gravity.TOP); // 此处可以设置dialog显示的位置
                break;
            case 1:
                window.setGravity(Gravity.CENTER);
                break;
            case 2:
                window.setGravity(Gravity.BOTTOM);
                break;
            case 3:
                WindowManager.LayoutParams params = window.getAttributes();
                dialog.onWindowAttributesChanged(params);
                params.x = screenWidth - dip2px(context, 100);// 设置x坐标
                params.gravity = Gravity.TOP;
                params.y = dip2px(context, 45);// 设置y坐标
                Log.d("xx", params.y + "");
                window.setGravity(Gravity.TOP);
                window.setAttributes(params);
                break;
            default:
                window.setGravity(Gravity.CENTER);
                break;
        }
        return dialog;
    }



    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private static void changePwd(final Activity ac, String oidPwd, String newPwd){
        ImpEditUsersPwd impEditUsersPwd = new ImpEditUsersPwd();
        impEditUsersPwd.editPwd(ac, oidPwd, newPwd, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
//                ToastUtils.showToast(ac,"修改密码成功");
                ac.finish();
                Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
                com.blankj.utilcode.util.ToastUtils.showShort("修改密码成功");
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
    }
}

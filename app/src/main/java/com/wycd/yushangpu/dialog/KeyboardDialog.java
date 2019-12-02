package com.wycd.yushangpu.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.tools.ToastUtils;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by ZPH on 2019-06-13.
 */

public class KeyboardDialog {

    private static StringBuilder mEditContentBuilder;

    public static Dialog numchangeDialog(final Activity context, final String title, String value,
                                         final ShopMsg shopMsg, int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_keyborad, null);

        TextView keyboard_title = (TextView) view.findViewById(R.id.keyboard_title);
        final TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        ImageView iv_del = (ImageView) view.findViewById(R.id.iv_del);
        ImageView iv_close = (ImageView) view.findViewById(R.id.iv_close);

        Button btt1 = (Button) view.findViewById(R.id.btn_keyboard_1);
        Button btt2 = (Button) view.findViewById(R.id.btn_keyboard_2);
        Button btt3 = (Button) view.findViewById(R.id.btn_keyboard_3);
        Button btt4 = (Button) view.findViewById(R.id.btn_keyboard_4);
        Button btt5 = (Button) view.findViewById(R.id.btn_keyboard_5);
        Button btt6 = (Button) view.findViewById(R.id.btn_keyboard_6);
        Button btt7 = (Button) view.findViewById(R.id.btn_keyboard_7);
        Button btt8 = (Button) view.findViewById(R.id.btn_keyboard_8);
        Button btt9 = (Button) view.findViewById(R.id.btn_keyboard_9);
        Button btt0 = (Button) view.findViewById(R.id.btn_keyboard_0);
        Button btt00 = (Button) view.findViewById(R.id.btn_keyboard_00);
        Button bttdian = (Button) view.findViewById(R.id.btn_keyboard_dian);

        LinearLayout ll_delet = (LinearLayout) view.findViewById(R.id.btn_keyboard_delete);
        LinearLayout ll_confirm = (LinearLayout) view.findViewById(R.id.ll_keyboard_confirm);



        keyboard_title.setText(title);
        tv_content.setText(StringUtil.twoNum(value));

        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        int screenHeight = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getHeight();

        dialog.setContentView(view, new LinearLayout.LayoutParams(
                (int)(screenWidth *0.3), LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        dialog.show();
        mEditContentBuilder = new StringBuilder("");

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

        iv_close.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });

        iv_del.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                tv_content.setText("");
                mEditContentBuilder = new StringBuilder("");
            }
        });

        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("1");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("2");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("3");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });


        btt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("4");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("5");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("6");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("7");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });
        btt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("8");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });

        btt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("9");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });

        btt0.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("0");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });

        btt00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditContentBuilder.append("00");
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });

        bttdian.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                if (!NullUtils.isNull(mEditContentBuilder) && !mEditContentBuilder.toString().contains(".")) {
                    mEditContentBuilder.append(".");
                }
                if (NullUtils.isNull(mEditContentBuilder)) {
                    mEditContentBuilder.append("0.");
                }
                if (!NullUtils.isNull(mEditContentBuilder)) {
                    String[] str = mEditContentBuilder.toString().split("\\+");
                    if (!str[str.length - 1].contains(".")) {
                        mEditContentBuilder.append(".");
                    }
                }
                tv_content.setText(mEditContentBuilder.toString() +"");
            }
        });

        //删除
        ll_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!NullUtils.isNull(mEditContentBuilder)) {
                    mEditContentBuilder.deleteCharAt(mEditContentBuilder.length() - 1);
                }
                tv_content.setText(mEditContentBuilder.toString() + "");
            }
        });

        //确定
        ll_confirm.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (tv_content.getText().toString().equals("") || "0.0".equals(tv_content.getText().toString())) {
//                    ToastUtils.showToast(context, "请输入数字");
                    com.blankj.utilcode.util.ToastUtils.showShort("请输入数字");
                }else if (title.equals("改折扣") && Double.parseDouble(tv_content.getText().toString())>1 ){
//                    ToastUtils.showToast(context, "输入数字不正确");
                    com.blankj.utilcode.util.ToastUtils.showShort("输入数字不正确");
                }else if (!StringUtil.isTwoPoint(tv_content.getText().toString())){
//                    ToastUtils.showToast(context, "只能输入两位小数");
                    com.blankj.utilcode.util.ToastUtils.showShort("只能输入两位小数");
                }else if (shopMsg !=null && (shopMsg.getPM_IsService() ==1 ||shopMsg.getPM_IsService() == 3) &&title.equals("改数量") && tv_content.getText().toString().contains(".")){
//                    ToastUtils.showToast(context, "服务或套餐的数量不能为小数");
                    com.blankj.utilcode.util.ToastUtils.showShort("服务或套餐的数量不能为小数");
                }else {
                    back.onResponse(tv_content.getText().toString());
                    dialog.dismiss();
                    HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                    event.setMsg("Change_color");
                    EventBus.getDefault().post(event);
                }
            }
        });

//        tv_content.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.toString().contains(".") && s.toString().length() - s.toString().indexOf(".")>3){
//                    tv_content.setText(s.toString().substring(0,s.toString().indexOf(".")+2));
//                }
//            }
//        });


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



}

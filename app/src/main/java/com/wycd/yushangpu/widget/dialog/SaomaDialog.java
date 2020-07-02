package com.wycd.yushangpu.widget.dialog;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpSaoma;
import com.wycd.yushangpu.tools.MyOnEditorActionListener;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;
import com.wycd.yushangpu.widget.views.ClearEditText;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class SaomaDialog {
    private Dialog dialog;

    public SaomaDialog(final Activity context, String money, int showingLocation, final InterfaceBack back) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_saomapay, null);
        final ClearEditText et_saoma = (ClearEditText) view.findViewById(R.id.et_saoma);
        ImageView iv_clone = (ImageView) view.findViewById(R.id.iv_clone);
        TextView tv_money = (TextView) view.findViewById(R.id.tv_money);
        View on_open_saoma = (View) view.findViewById(R.id.on_open_saoma);
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle) {
            public void dismiss() {
                super.dismiss();
                back.onErrorResponse(null);
            }
        };
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        dialog.show();

        iv_clone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        if (MyApplication.loginBean.getShopList().get(0).getSaoBei_State() == 0) {
            on_open_saoma.setVisibility(View.VISIBLE);
        } else {
            et_saoma.requestFocus();
            on_open_saoma.setVisibility(View.GONE);
            tv_money.setText("￥" + money);

            et_saoma.setOnEditorActionListener(new MyOnEditorActionListener(context) {
                @Override
                public void onEditorAction(String text) {
                    back.onResponse(text);
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
        }
        KeyboardUtils.hideSoftInput(context);
    }

    public boolean isShowing() {
        return dialog.isShowing();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public void saomaPay(String Code, String smPayMoney, String OrderGID, String OrderNo, OrderPayResult orderPayResult,
                         JiesuanBFragment.OrderType orderType, InterfaceBack back) {
        ImpSaoma saoma = new ImpSaoma();
        saoma.saomaPay(Code, smPayMoney, OrderGID, OrderNo, orderPayResult,
                orderType, new InterfaceBack<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("==========扫码支付成功 (免密) =============== ");
                        back.onResponse(response);
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        if (msg instanceof BaseRes) {
                            BaseRes baseRes = (BaseRes) msg;
                            if (("410004").equals(baseRes.getCode())) {
                                Type type = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Map<String, Object> map = baseRes.getData(type);
                                String gid = map.get("GID").toString();
                                Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        ActivityUtils.getTopActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                saoma.saomaPayQuery(gid, new InterfaceBack<BaseRes>() {
                                                    @Override
                                                    public void onResponse(BaseRes response) {
                                                        checkPayResult(response);
                                                    }

                                                    @Override
                                                    public void onErrorResponse(Object msg) {
                                                        if (msg instanceof BaseRes) {
                                                            checkPayResult((BaseRes) msg);
                                                        } else {
                                                            timer.cancel();
                                                            back.onErrorResponse(null);
                                                        }
                                                    }

                                                    public void checkPayResult(BaseRes response) {
                                                        if (!("410004").equals(response.getCode())) {
                                                            timer.cancel();
                                                            if (response.isSuccess()) {
                                                                System.out.println("==========扫码支付成功=============== ");
                                                                Map<String, Object> map = response.getData(type);
                                                                String Order_GID = map.get("Order_GID").toString();
                                                                back.onResponse(Order_GID);
                                                            } else {
                                                                back.onErrorResponse(response.getMsg());
                                                            }
                                                        } else {
                                                            ToastUtils.showLong("支付中");
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }, 2000, 2000);
                            } else {
                                back.onErrorResponse(baseRes.getMsg());
                            }
                        } else {
                            back.onErrorResponse(null);
                        }
                    }
                });
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

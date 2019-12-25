package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.YouhuiquanAdapter;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpYhq;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.views.ClearEditText;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class YouhuiquanDialog {
    private static List<YhqMsg> choselist;
    private static List<YhqMsg> list = new ArrayList<>();
    private static YouhuiquanAdapter adapter;

    public static Dialog yhqDialog(final Activity context, final String paymoney, VipInfoMsg mVipDengjiMsg, List<YhqMsg> yhqMsgs,
                                   int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_youhuiquan, null);
        final RelativeLayout rl_confirm = (RelativeLayout) view.findViewById(R.id.rl_confirm);
        final RelativeLayout rl_cancle = (RelativeLayout) view.findViewById(R.id.rl_cancle);
        final RecyclerView gridview = (RecyclerView) view.findViewById(R.id.gridview);
        final ClearEditText et_search = (ClearEditText) view.findViewById(R.id.et_search);

        LinearLayout li_search = (LinearLayout) view.findViewById(R.id.li_search);
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        dialog.show();
//        gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
        choselist = new ArrayList<>();

        if (yhqMsgs != null && yhqMsgs.size() > 0) {
            choselist.addAll(yhqMsgs);
        }

        final Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);
//        loadingdialog.show();

        addDate(mVipDengjiMsg);
        adapter = new YouhuiquanAdapter(context, list, paymoney, choselist);
        gridview.setLayoutManager(new GridLayoutManager(context, 3));
        gridview.setAdapter(adapter);

        rl_cancle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                back.onErrorResponse("");
            }
        });
        rl_confirm.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (choselist != null) {
                    back.onResponse(choselist);
                } else {
                    back.onErrorResponse("");
                }
            }
        });
        li_search.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (et_search.getText().toString().equals("")) {
//                    ToastUtils.showToast(context, "请输入优惠券名称");
                    com.blankj.utilcode.util.ToastUtils.showShort("请输入优惠券名称");
                } else {
                    loadingdialog.show();
                    ImpYhq impYhq = new ImpYhq();
                    impYhq.yhqlist(context, paymoney, et_search.getText().toString(), new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            loadingdialog.dismiss();
                            YhqMsg slist = (YhqMsg) response;

                            if (list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getGID().equals(slist.getGID())) {
                                        return;
                                    } else if (i == list.size() - 1) {
                                        list.add(0, slist);
                                        break;
                                    }
                                }

                            } else {
                                list.add(0, slist);
                            }

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            loadingdialog.dismiss();
                        }
                    });
                }
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

    private static void addDate(VipInfoMsg mVipDengjiMsg) {
        list.clear();
        if (mVipDengjiMsg != null && mVipDengjiMsg.getCouponsList() != null) {
            for (VipInfoMsg.CouponsListBean msg : mVipDengjiMsg.getCouponsList()) {
                YhqMsg bean = new YhqMsg();
                bean.setGID(msg.getGID());
                bean.setVIP_GID(msg.getVIP_GID());
                bean.setEC_GID(msg.getEC_GID());
                bean.setEC_ReddemCode(msg.getEC_ReddemCode());
                bean.setVCR_IsForver(msg.getVCR_IsForver());
                bean.setVCR_StatrTime(msg.getVCR_StatrTime());
                bean.setVCR_EndTime(msg.getVCR_EndTime());
                bean.setVCR_IsUse(msg.getVCR_IsUse());
                bean.setVCR_CreatorTime(msg.getVCR_CreatorTime());
                bean.setEC_Denomination(msg.getEC_Denomination());
                bean.setEC_Discount(msg.getEC_Discount());
                bean.setEC_DiscountType(msg.getEC_DiscountType());
                bean.setEC_GiftCondition(msg.getEC_GiftCondition());
                bean.setEC_IsOverlay(msg.getEC_IsOverlay());
                bean.setEC_Name(msg.getEC_Name());
                bean.setEC_UseType(msg.getEC_UseType());
                bean.setCY_GID(msg.getCY_GID());
                bean.setSM_GID(msg.getSM_GID());
                bean.setSM_Name(msg.getSM_Name());

                if (choselist.size() > 0) {
                    for (int j = 0; j < choselist.size(); j++) {
                        if (msg.getGID().equals(choselist.get(j).getGID())) {
                            bean.setChose(true);
                        }
                    }
                }
                list.add(bean);
            }


        }
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

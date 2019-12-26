package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpYhq;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.widget.views.ClearEditText;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class YouhuiquanDialog {

    public static Dialog yhqDialog(final Activity context, final String payMoney, VipInfoMsg mVipInfoMsg, List<YhqMsg> yhqMsgs,
                                   int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_youhuiquan, null);
        View rl_confirm = view.findViewById(R.id.rl_confirm);
        View rl_cancle = view.findViewById(R.id.rl_cancle);
        RecyclerView gridview = (RecyclerView) view.findViewById(R.id.gridview);
        ClearEditText et_search = (ClearEditText) view.findViewById(R.id.et_search);

        LinearLayout li_search = (LinearLayout) view.findViewById(R.id.li_search);
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view);
        Window window = dialog.getWindow();
//        gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));

        final Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);
//        loadingdialog.show();

        List<YhqMsg> list = addDate(mVipInfoMsg, yhqMsgs);
        YouhuiquanAdapter adapter = new YouhuiquanAdapter(context, list, payMoney,
                yhqMsgs == null ? new ArrayList<>() : yhqMsgs);
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
                if (adapter.choselist != null) {
                    back.onResponse(adapter.choselist);
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
                    impYhq.yhqlist(context, payMoney, et_search.getText().toString(), new InterfaceBack() {
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

    private static List<YhqMsg> addDate(VipInfoMsg mVipDengjiMsg, List<YhqMsg> choselist) {
        List<YhqMsg> list = new ArrayList<>();
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

                if (choselist != null && choselist.size() > 0) {
                    for (int j = 0; j < choselist.size(); j++) {
                        if (msg.getGID().equals(choselist.get(j).getGID())) {
                            bean.setChose(true);
                        }
                    }
                }
                list.add(bean);
            }
        }
        return list;
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

    public static class YouhuiquanAdapter extends RecyclerView.Adapter {
        private List<YhqMsg> list;
        private List<YhqMsg> choselist;
        private Context context;
        private String pamoney;
        private AdapterView.OnItemClickListener listener;

        public YouhuiquanAdapter(Context context, List<YhqMsg> list, String pamoney, List<YhqMsg> choselist) {
            this.list = list;
            this.context = context;
            this.pamoney = pamoney;
            this.choselist = choselist;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_youhuiquan, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final YhqMsg vipMsg = list.get(position);
            Holder holder1 = (Holder) holder;

            holder1.rootView.setBackgroundResource(R.mipmap.bg_yhq_no_select);
            holder1.mTvYhqmsg.setTextColor(context.getResources().getColor(R.color.title_color));
            holder1.mTvYouxiao.setTextColor(context.getResources().getColor(R.color.color_999999));

            ViewGroup viewGroup = (ViewGroup) holder1.mTvMoney.getParent();
            ((TextView) viewGroup.getChildAt(0)).setTextColor(context.getResources().getColor(R.color.color_fe3d51));
            ((TextView) viewGroup.getChildAt(1)).setTextColor(context.getResources().getColor(R.color.color_fe3d51));
            ((TextView) viewGroup.getChildAt(2)).setTextColor(context.getResources().getColor(R.color.color_fe3d51));
            if (Double.parseDouble(pamoney) < vipMsg.getEC_Denomination()) {
                holder1.rootView.setBackgroundResource(R.mipmap.bg_yhq_ban);
                holder1.mTvYhqmsg.setTextColor(context.getResources().getColor(R.color.textcc));
                holder1.mTvYouxiao.setTextColor(context.getResources().getColor(R.color.textcc));

                ((TextView) viewGroup.getChildAt(0)).setTextColor(context.getResources().getColor(R.color.textcc));
                ((TextView) viewGroup.getChildAt(1)).setTextColor(context.getResources().getColor(R.color.textcc));
                ((TextView) viewGroup.getChildAt(2)).setTextColor(context.getResources().getColor(R.color.textcc));
            }

            holder1.mTvAction.setText(NullUtils.noNullHandle(vipMsg.getEC_Name()).toString());

            holder1.mTvAllshop.setText(NullUtils.noNullHandle(vipMsg.getSM_Name()).toString().equals("") ? "所有店铺可用" : NullUtils.noNullHandle(vipMsg.getSM_Name()).toString());

            holder1.mTvDiejia.setText(NullUtils.noNullHandle(vipMsg.getEC_IsOverlay()).toString().equals("1") ? "可叠加使用" : "不可叠加使用");

            if (vipMsg.getEC_DiscountType() == 1) {
                holder1.tv_type.setText("代金券");
                holder1.mTvMoney.setText("¥" + vipMsg.getEC_Discount());
            } else {
                holder1.tv_type.setText("折扣券");
                holder1.mTvMoney.setText((vipMsg.getEC_Discount()) / 10 + "折");
            }
            holder1.mTvYhqmsg.setText("满" + NullUtils.noNullHandle(vipMsg.getEC_Denomination()).toString() + "元减" + vipMsg.getEC_Discount());

            switch (NullUtils.noNullHandle(vipMsg.getVCR_IsForver()).toString()) {
                case "0":
                    holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_StatrTime()).toString() + "～" + NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString() + "有效");
                    break;
                case "1":
                    holder1.mTvYouxiao.setText("永久有效");
                    break;
                case "2":
                    holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString() + "前有效");
                    break;
            }
            holder1.mTvYouxiao.setText("有效期:" + holder1.mTvYouxiao.getText());

            holder1.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Double.parseDouble(pamoney) < vipMsg.getEC_Denomination()) {
//                    ToastUtils.showToast(context,"未达到使用金额");
                        com.blankj.utilcode.util.ToastUtils.showShort("未达到使用金额");
                        return;
                    }
                    if (choselist.contains(vipMsg)) {
                        vipMsg.setChose(false);
                        choselist.remove(vipMsg);
                    } else {
                        if (vipMsg.getEC_IsOverlay() == 0) { // 可不叠加
                            for (int j = 0; j < choselist.size(); j++) {
                                if (choselist.get(j).getEC_IsOverlay() == 0) {
                                    com.blankj.utilcode.util.ToastUtils.showShort("一个订单中，不可叠加优惠券只能使用一张");
                                    return;
                                }
                            }
                        }
                        vipMsg.setChose(true);
                        choselist.add(vipMsg);
                    }

                    if (vipMsg.isChose()) {
//                          holder1.mIvChose.setVisibility(View.VISIBLE);
                        holder1.rootView.setBackgroundResource(R.mipmap.bg_yhq_selected);
                        holder1.mTvYhqmsg.setTextColor(Color.WHITE);
                    } else {
//                          holder1.mIvChose.setVisibility(View.GONE);
                        holder1.rootView.setBackgroundResource(R.mipmap.bg_yhq_no_select);
                        holder1.mTvYhqmsg.setTextColor(context.getResources().getColor(R.color.title_color));
                    }
                }
            });
//        holder1.tv_ygcode.setText(NullUtils.noNullHandle(vipMsg.getEM_Code()).toString());
//        holder1.tv_ygsex.setText(Integer.parseInt(NullUtils.noNullHandle(vipMsg.getEM_Sex()).toString()) == 1 ? "男" : "女");
        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_type)
            TextView tv_type;
            @BindView(R.id.tv_money)
            TextView mTvMoney;
            @BindView(R.id.tv_yhqmsg)
            TextView mTvYhqmsg;
            @BindView(R.id.tv_action)
            TextView mTvAction;
            @BindView(R.id.tv_youxiao)
            TextView mTvYouxiao;
            @BindView(R.id.tv_allshop)
            TextView mTvAllshop;
            @BindView(R.id.tv_diejia)
            TextView mTvDiejia;
            @BindView(R.id.iv_chose)
            ImageView mIvChose;
            View rootView;

            public Holder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                rootView = view;
            }
        }
    }

}

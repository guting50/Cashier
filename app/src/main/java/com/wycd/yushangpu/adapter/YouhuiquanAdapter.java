package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class YouhuiquanAdapter extends RecyclerView.Adapter {
    private List<YhqMsg> list = new ArrayList<>();
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
        if (Double.parseDouble(pamoney) >= Double.parseDouble(NullUtils.noNullHandle(vipMsg.getEC_Denomination()).toString())) {
            holder1.mRlState.setBackgroundColor(context.getResources().getColor(R.color.textyellow));
        } else {
            holder1.mRlState.setBackgroundColor(context.getResources().getColor(R.color.viewcb));
        }
        holder1.mTvYhqmsg.setText("满" + NullUtils.noNullHandle(vipMsg.getEC_Denomination()).toString() + "元可用");

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

        holder1.tv_type.setText(NullUtils.noNullHandle(vipMsg.getEC_DiscountType()).toString().equals("1") ? "代金券" : "折扣券");

        switch (NullUtils.noNullHandle(vipMsg.getVCR_IsForver()).toString()) {
            case "0":
                holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_StatrTime()).toString() + "- -" + NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString() + "有效");
                break;
            case "1":
                holder1.mTvYouxiao.setText("永久有效");
                break;
            case "2":
                holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString() + "前有效");
                break;
        }
        if (NullUtils.noNullHandle(vipMsg.isChose()).toString().equals("true")) {
            holder1.mIvChose.setVisibility(View.VISIBLE);
        } else {
            holder1.mIvChose.setVisibility(View.GONE);
        }

        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YhqMsg yhqMsg = vipMsg;
                if (Double.parseDouble(pamoney) < Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Denomination()).toString())) {
//                    ToastUtils.showToast(context,"未达到使用金额");
                    com.blankj.utilcode.util.ToastUtils.showShort("未达到使用金额");
                    return;
                }
                if (NullUtils.noNullHandle(yhqMsg.getEC_IsOverlay()).toString().equals("1")) {//可叠加使用
                    if (choselist.size() > 0) {
                        for (int j = 0; j < choselist.size(); j++) {
                            if (choselist.get(j).getGID().equals(yhqMsg.getGID())) {
                                choselist.remove(j);
                                yhqMsg.setChose(false);
                                notifyDataSetChanged();
                                return;
                            } else if (j == choselist.size() - 1) {
                                yhqMsg.setChose(true);
                                choselist.add(yhqMsg);
                                notifyDataSetChanged();
                                return;
                            }
                        }
                    } else {
                        yhqMsg.setChose(true);
                        choselist.add(yhqMsg);
                        notifyDataSetChanged();
                    }
                } else {
                    if (choselist.size() > 0) {
                        for (int j = 0; j < choselist.size(); j++) {
                            if (choselist.get(j).getEC_IsOverlay() == 0) {
                                if (choselist.get(j).getGID().equals(yhqMsg.getGID())) {
                                    choselist.remove(j);
                                    yhqMsg.setChose(false);
                                    notifyDataSetChanged();
                                } else {
//                                    ToastUtils.showToast(context,"一个订单中，不可叠加优惠券只能使用一张");
                                    com.blankj.utilcode.util.ToastUtils.showShort("一个订单中，不可叠加优惠券只能使用一张");
                                }
                                return;
                            } else if (j == choselist.size() - 1) {
                                if (yhqMsg.isChose()) {
                                    choselist.remove(j);
                                    yhqMsg.setChose(false);
                                    notifyDataSetChanged();
                                } else {
                                    yhqMsg.setChose(true);
                                    choselist.add(yhqMsg);
                                    notifyDataSetChanged();
                                }
                                return;
                            }
                        }

                    } else {

                        yhqMsg.setChose(true);
                        choselist.add(yhqMsg);
                        notifyDataSetChanged();
                    }

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

    static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_money)
        TextView mTvMoney;
        @BindView(R.id.li_mo)
        LinearLayout mLiMo;
        @BindView(R.id.tv_yhqmsg)
        TextView mTvYhqmsg;
        @BindView(R.id.rl_state)
        RelativeLayout mRlState;
        @BindView(R.id.rl_xiaofei)
        RelativeLayout mRlXiaofei;
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
        @BindView(R.id.rl_bg)
        RelativeLayout mRlBg;
        View rootView;

        public Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            rootView = view;

        }
    }

}

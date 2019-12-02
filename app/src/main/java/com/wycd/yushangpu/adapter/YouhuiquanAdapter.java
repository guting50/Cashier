package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class YouhuiquanAdapter extends BaseAdapter {
    private List<YhqMsg> list;
    private Context context;
    private LayoutInflater inflater;
    private String pamoney;

    public YouhuiquanAdapter(Context context, List<YhqMsg> list,String pamoney) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.pamoney=pamoney;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder1;
        if (view == null) {
            view = inflater.inflate(R.layout.item_youhuiquan, null);
            holder1 = new ViewHolder(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder) view.getTag();
        }
        final YhqMsg vipMsg = list.get(i);
        if (i % 2 == 1) {
            holder1.view_line.setVisibility(View.GONE);
        } else {
            holder1.view_line.setVisibility(View.VISIBLE);
        }

        if(Double.parseDouble(pamoney)>=Double.parseDouble(NullUtils.noNullHandle(vipMsg.getEC_Denomination()).toString())){
            holder1.mRlState.setBackgroundColor(context.getResources().getColor(R.color.textyellow));
        }else{
            holder1.mRlState.setBackgroundColor(context.getResources().getColor(R.color.viewcb));
        }
        holder1.mTvYhqmsg.setText("满"+NullUtils.noNullHandle(vipMsg.getEC_Denomination()).toString()+"元可用");

        holder1.mTvAction.setText(NullUtils.noNullHandle(vipMsg.getEC_Name()).toString());

        holder1.mTvAllshop.setText(NullUtils.noNullHandle(vipMsg.getSM_Name()).toString().equals("")?"所有店铺可用":NullUtils.noNullHandle(vipMsg.getSM_Name()).toString());

        holder1.mTvDiejia.setText(NullUtils.noNullHandle(vipMsg.getEC_IsOverlay()).toString().equals("1")?"可叠加使用":"不可叠加使用");

        if (vipMsg.getEC_DiscountType() == 1) {
            holder1.tv_type.setText("代金券");
            holder1.mTvMoney.setText("¥" + vipMsg.getEC_Discount());
        } else  {
            holder1.tv_type.setText("折扣券");
            holder1.mTvMoney.setText((vipMsg.getEC_Discount())/10+"折");
        }

        holder1.tv_type.setText(NullUtils.noNullHandle(vipMsg.getEC_DiscountType()).toString().equals("1")?"代金券":"折扣券");

        switch (NullUtils.noNullHandle(vipMsg.getVCR_IsForver()).toString()){
            case "0":
                holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_StatrTime()).toString()+"- -"+NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString()+"有效");
                break;
            case "1":
                holder1.mTvYouxiao.setText("永久有效");
                break;
            case "2":
                holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString()+"前有效");
                break;
        }
        if(NullUtils.noNullHandle(vipMsg.isChose()).toString().equals("true")){
            holder1.mIvChose.setVisibility(View.VISIBLE);
        }else{
            holder1.mIvChose.setVisibility(View.GONE);
        }
//        holder1.tv_ygcode.setText(NullUtils.noNullHandle(vipMsg.getEM_Code()).toString());
//        holder1.tv_ygsex.setText(Integer.parseInt(NullUtils.noNullHandle(vipMsg.getEM_Sex()).toString()) == 1 ? "男" : "女");
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.tv_type)
        TextView tv_type;
        @Bind(R.id.view_line)
        View view_line;
        @Bind(R.id.tv_money)
        TextView mTvMoney;
        @Bind(R.id.li_mo)
        LinearLayout mLiMo;
        @Bind(R.id.tv_yhqmsg)
        TextView mTvYhqmsg;
        @Bind(R.id.rl_state)
        RelativeLayout mRlState;
        @Bind(R.id.rl_xiaofei)
        RelativeLayout mRlXiaofei;
        @Bind(R.id.tv_action)
        TextView mTvAction;
        @Bind(R.id.tv_youxiao)
        TextView mTvYouxiao;
        @Bind(R.id.tv_allshop)
        TextView mTvAllshop;
        @Bind(R.id.tv_diejia)
        TextView mTvDiejia;
        @Bind(R.id.iv_chose)
        ImageView mIvChose;
        @Bind(R.id.rl_bg)
        RelativeLayout mRlBg;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class VipListAdapter extends BaseAdapter {
    private List<VipInfoMsg> list;
    private Context context;
    private LayoutInflater inflater;

    public VipListAdapter(Context context, List<VipInfoMsg> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);

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
            view = inflater.inflate(R.layout.item_chosevip, null);
            holder1 = new ViewHolder(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder) view.getTag();
        }
        final VipInfoMsg vipMsg = list.get(i);
        holder1.mTvVipcard.setText(NullUtils.noNullHandle(vipMsg.getVCH_Card()).toString());
        holder1.mTvVipname.setText(NullUtils.noNullHandle(vipMsg.getVIP_Name()).toString());
        holder1.mTvVipdnegji.setText(NullUtils.noNullHandle(vipMsg.getVG_Name()).toString());
        holder1.mTvVipyue.setText(StringUtil.twoNum(NullUtils.noNullHandle(vipMsg.getMA_AvailableBalance()).toString()));
        holder1.mTvVipjifen.setText((int) Double.parseDouble(NullUtils.noNullHandle(vipMsg.getMA_AvailableIntegral()).toString()) + "");
        holder1.mTvVipnum.setText(NullUtils.noNullHandle(vipMsg.getMCA_HowMany()).toString());
        return view;
    }

    class ViewHolder {
        @BindView(R.id.tv_vipcard)
        TextView mTvVipcard;
        @BindView(R.id.tv_vipname)
        TextView mTvVipname;
        @BindView(R.id.tv_vipdnegji)
        TextView mTvVipdnegji;
        @BindView(R.id.tv_vipyue)
        TextView mTvVipyue;
        @BindView(R.id.tv_vipjifen)
        TextView mTvVipjifen;
        @BindView(R.id.tv_vipnum)
        TextView mTvVipnum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

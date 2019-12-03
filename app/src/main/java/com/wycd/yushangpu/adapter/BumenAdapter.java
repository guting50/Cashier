package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ValiRuleMsg;
import com.wycd.yushangpu.tools.NullUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class BumenAdapter extends BaseAdapter {
    private List<ValiRuleMsg> list;
    private Context context;
    private LayoutInflater inflater;

    public BumenAdapter(Context context, List<ValiRuleMsg> list) {
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
            view = inflater.inflate(R.layout.item_shopdetail_bumen, null);
            holder1 = new ViewHolder(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder) view.getTag();
        }
        final ValiRuleMsg vipMsg = list.get(i);
        holder1.tv_name.setText(NullUtils.noNullHandle(vipMsg.getDM_Name()).toString());
        if (vipMsg.isIschose()) {
            holder1.li_bg.setBackgroundResource(R.color.textgreen);
        } else {
            holder1.li_bg.setBackgroundResource(R.color.white);
        }
        return view;
    }

    class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.li_bg)
        LinearLayout li_bg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

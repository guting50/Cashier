package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class YuangongAdapter extends BaseAdapter {
    private List<EmplMsg> list;
    private Context context;
    private LayoutInflater inflater;

    public YuangongAdapter(Context context, List<EmplMsg> list) {
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
            view = inflater.inflate(R.layout.item_shopdetail_yuangong, viewGroup, false);
            holder1 = new ViewHolder(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder) view.getTag();
        }
        final EmplMsg vipMsg = list.get(i);
        holder1.tv_ygname.setText(NullUtils.noNullHandle(vipMsg.getEM_Name()).toString());
        holder1.tv_ygcode.setText(NullUtils.noNullHandle(vipMsg.getEM_Code()).toString());
//        holder1.tv_ygsex.setText(Integer.parseInt(NullUtils.noNullHandle(vipMsg.getEM_Sex()).toString()) == 1 ? "男" : "女");
        holder1.tv_ygsex.setText(NullUtils.noNullHandle(vipMsg.getDM_Name()).toString());
        if (vipMsg.isIschose()) {
            holder1.iv_chose.setBackgroundResource(R.drawable.emp_chose);
        } else {
            holder1.iv_chose.setBackgroundResource(R.drawable.emp_not);
        }
        return view;
    }

    class ViewHolder {
        @BindView(R.id.tv_ygname)
        TextView tv_ygname;
        @BindView(R.id.tv_ygcode)
        TextView tv_ygcode;
        @BindView(R.id.tv_ygsex)
        TextView tv_ygsex;
        @BindView(R.id.iv_chose)
        ImageView iv_chose;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

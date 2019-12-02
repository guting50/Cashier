package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.http.InterfaceThreeBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZPH on 2019-07-01.
 */


public class SearchVipPopAdapter extends BaseAdapter {
    private VipDengjiMsg list;
    private Context context;
    private LayoutInflater inflater;

    public SearchVipPopAdapter(Context context, VipDengjiMsg list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return list.getData().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder vh;
        if (view == null) {
            view = inflater.inflate(R.layout.item_pop_vip_search, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        final VipDengjiMsg.DataBean ts = list.getData().get(i);

        vh.tvName.setText(NullUtils.noNullHandle(ts.getVIP_Name())+"");
        vh.tvCardnum.setText(NullUtils.noNullHandle(ts.getVCH_Card())+"");
        vh.tvPhone.setText(NullUtils.noNullHandle(ts.getVIP_CellPhone())+"");
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_cardnum)
        TextView tvCardnum;
        @Bind(R.id.tv_phone)
        TextView tvPhone;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

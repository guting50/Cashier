package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.GuadanList;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class GuadanListAdapter extends BaseAdapter {
    private List<GuadanList> list;
    private Context context;
    private LayoutInflater inflater;
    private InterfaceBack mBack;

    public GuadanListAdapter(Context context, List<GuadanList> list, InterfaceBack mBack) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mBack = mBack;

    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
            view = inflater.inflate(R.layout.item_gualist, null);
            holder1 = new ViewHolder(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder) view.getTag();
        }
        final GuadanList vipMsg = list.get(i);
        holder1.tvCode.setText(NullUtils.noNullHandle(vipMsg.getCO_OrderCode()).toString());
        holder1.tvCodetime.setText(NullUtils.noNullHandle(vipMsg.getCO_UpdateTime()).toString());
        holder1.tvCard.setText(NullUtils.noNullHandle(vipMsg.getVIP_Card()).toString());
        if (!NullUtils.noNullHandle(vipMsg.getVIP_Phone()).toString().equals("")) {
            holder1.tvVipmsg.setText(NullUtils.noNullHandle(vipMsg.getVIP_Name()).toString() + "/" + NullUtils.noNullHandle(vipMsg.getVIP_Phone()).toString());
        } else {
            holder1.tvVipmsg.setText(NullUtils.noNullHandle(vipMsg.getVIP_Name()).toString());
        }
        holder1.tvOrdermoney.setText(StringUtil.twoNum(NullUtils.noNullHandle(vipMsg.getCO_TotalPrice()).toString()));
        holder1.tvHandler.setText(NullUtils.noNullHandle(vipMsg.getCO_Creator()).toString());
        if (vipMsg.getCO_IdentifyingState().equals("1")) {
            holder1.tvHandle.setText("解挂");
        } else if (vipMsg.getCO_IdentifyingState().equals("8")) {
            holder1.tvHandle.setText("结算");
        }

        holder1.tvHandle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                mBack.onResponse(vipMsg);
            }
        });
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class ViewHolder {
        @BindView(R.id.tv_code)
        TextView tvCode;
        @BindView(R.id.tv_codetime)
        TextView tvCodetime;
        @BindView(R.id.tv_card)
        TextView tvCard;
        @BindView(R.id.tv_vipmsg)
        TextView tvVipmsg;
        @BindView(R.id.tv_ordermoney)
        TextView tvOrdermoney;
        @BindView(R.id.tv_handler)
        TextView tvHandler;
        @BindView(R.id.tv_handle)
        TextView tvHandle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

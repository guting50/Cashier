package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gt.utils.view.OnNoDoubleClickListener;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZPH on 2019-07-01.
 */


public class SearchVipPopAdapter extends RecyclerView.Adapter {
    private List<VipDengjiMsg.DataBean> list = new ArrayList<>();
    private Context context;
    private InterfaceBack back;

    public SearchVipPopAdapter(Context context, InterfaceBack back) {
        this.context = context;
        this.back = back;
    }

    public void addList(VipDengjiMsg.DataBean list) {
        this.list.add(list);
    }

    public void setList(List<VipDengjiMsg.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pop_vip_search, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Holder vh = (Holder) holder;
        final VipDengjiMsg.DataBean ts = list.get(position);

        vh.tvGid.setText(NullUtils.noNullHandle(ts.getGID()) + "");
        vh.tvName.setText(NullUtils.noNullHandle(ts.getVIP_Name()) + "");
        vh.tvCardnum.setText("卡号：" + NullUtils.noNullHandle(ts.getVCH_Card()) + "");
        vh.tvPhone.setText(NullUtils.noNullHandle(ts.getVIP_CellPhone()) + "");

        vh.rootView.setOnClickListener(new OnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                back.onResponse(ts);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        View rootView;
        @BindView(R.id.tv_gid)
        TextView tvGid;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_cardnum)
        TextView tvCardnum;
        @BindView(R.id.tv_phone)
        TextView tvPhone;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView = itemView;
        }
    }
}

package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gt.utils.view.BgFrameLayout;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.GuadanList;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class GuadanListAdapter extends RecyclerView.Adapter {
    private List<GuadanList> list;
    private Context context;
    private InterfaceBack mBack;
    private Holder selectedHolder;

    public GuadanListAdapter(Context context, List<GuadanList> list, InterfaceBack mBack) {
        this.list = list;
        this.context = context;
        this.mBack = mBack;

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gualist, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final GuadanList vipMsg = list.get(position);
        Holder holder1 = (Holder) holder;
        holder1.tvCount.setText("数量：" + vipMsg.getViewGoodsDetail().size() + "");
        holder1.tvTime.setText("挂单时间：" + vipMsg.getCO_UpdateTime());
        holder1.tvCode.setText(NullUtils.noNullHandle(vipMsg.getCO_OrderCode()).toString());
        holder1.tvCodetime.setText(NullUtils.noNullHandle(vipMsg.getCO_UpdateTime()).toString());
        holder1.tvCard.setText(NullUtils.noNullHandle(vipMsg.getVIP_Card()).toString());
        if (!NullUtils.noNullHandle(vipMsg.getVIP_Phone()).toString().equals("")) {
            holder1.tvVipmsg.setText("会员：" + NullUtils.noNullHandle(vipMsg.getVIP_Name()).toString() + "/" + NullUtils.noNullHandle(vipMsg.getVIP_Phone()).toString());
        } else {
            holder1.tvVipmsg.setText("会员：" + NullUtils.noNullHandle(vipMsg.getVIP_Name()).toString());
        }
        holder1.tvOrdermoney.setText("金额：" + StringUtil.twoNum(NullUtils.noNullHandle(vipMsg.getCO_TotalPrice()).toString()));
        holder1.tvHandler.setText(NullUtils.noNullHandle(vipMsg.getCO_Creator()).toString());
        if (vipMsg.getCO_IdentifyingState().equals("1")) {
            holder1.tvHandle.setText("解挂");
        } else if (vipMsg.getCO_IdentifyingState().equals("8")) {
            holder1.tvHandle.setText("结算");
        }
        if (selectedHolder != null) {
            ((ViewGroup) selectedHolder.rootView).getChildAt(0).setBackgroundResource(R.drawable.bg_edittext_normal);
            selectedHolder.tvTime.setTextColor(context.getResources().getColor(R.color.text60));
            ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(0xffEBEBF5);
        }
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBack.onResponse(vipMsg);
                if (selectedHolder != null) {
                    ((ViewGroup) selectedHolder.rootView).getChildAt(0).setBackgroundResource(R.drawable.bg_edittext_normal);
                    selectedHolder.tvTime.setTextColor(context.getResources().getColor(R.color.text60));
                    ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(0xffEBEBF5);
                }
                selectedHolder = holder1;
                ((ViewGroup) selectedHolder.rootView).getChildAt(0).setBackgroundResource(R.drawable.bg_edittext_focused);
                selectedHolder.tvTime.setTextColor(context.getResources().getColor(R.color.white));
                ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(context.getResources().getColor(R.color.textgreen));
            }
        });
        holder1.deleteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.blankj.utilcode.util.ToastUtils.showShort("删除挂单");
            }
        });

        holder1.tvHandle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                mBack.onResponse(vipMsg);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class Holder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.delete_layout)
        View deleteLayout;
        View rootView;

        public Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            rootView = view;
        }
    }
}

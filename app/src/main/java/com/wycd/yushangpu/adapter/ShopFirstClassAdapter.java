package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ClassMsg;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopFirstClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context mContext;//上下文
    private LayoutInflater inflater;
    private List<ClassMsg> list;
    private int index = -1;

    private OnItemClickListener onItemClickListener;

    public ShopFirstClassAdapter(Context mContext, List<ClassMsg> list) {
        this.mContext = mContext;
        this.list = list;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_class, parent, false);
        LinkHolder vh = new LinkHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ClassMsg classMsg = list.get(position);
        LinkHolder holder1 = (LinkHolder) holder;
        holder1.itemView.setTag(position);
        if (Boolean.parseBoolean(NullUtils.noNullHandle(classMsg.isChose()).toString())) {
            holder1.mRlBg.setBackgroundResource(R.drawable.shap_home_classchose);
            holder1.mTvName.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            holder1.mRlBg.setBackgroundResource(R.drawable.shap_home_classnot);
            holder1.mTvName.setTextColor(mContext.getResources().getColor(R.color.text60));
        }
        holder1.mTvName.setText(classMsg.getPT_Name());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class LinkHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.rl_bg)
        RelativeLayout mRlBg;

        public LinkHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            LogUtils.d("xxclicl", view.getTag().toString());
            onItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int tag);
    }
}

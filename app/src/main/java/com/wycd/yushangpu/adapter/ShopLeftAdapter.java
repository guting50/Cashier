package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.InterfaceThreeBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class ShopLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ShopMsg> list;
    private Context context;
    InterfaceThreeBack back;

    public ShopLeftAdapter(Context context, List<ShopMsg> list, InterfaceThreeBack back) {
        this.list = list;
        this.context = context;
        this.back = back;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_left, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        final ViewHolder vh = (ViewHolder) holder;
        final ShopMsg ts = list.get(i);
        vh.mTvNum.setText(ts.getNum() + "");
        vh.mTvName.setText(NullUtils.noNullHandle(ts.getPM_Name()).toString() + "  " + NullUtils.noNullHandle(ts.getPM_Modle()).toString());
        if (ts.isCheck()) {
            vh.mRlBg.setBackgroundResource(R.color.enablenot);
        } else {
            vh.mRlBg.setBackgroundResource(R.color.white);
        }

//        if(NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")){
//            if(!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")){
//                //有特价折扣
//                if(NullUtils.noNullHandle(ts.getPM_MinDisCountValue()).toString().equals("0.0")){
//                    //无最低折扣
//                    vh.mTvTeprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice()+"",ts.getPM_SpecialOfferValue()+"")));
//                }else {
//                    //有最低折扣
//                    if(ts.getPM_SpecialOfferValue()>ts.getPM_MinDisCountValue()){
//                        vh.mTvTeprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice()+"",ts.getPM_SpecialOfferValue()+"")));
//                    }else{
//                        vh.mTvTeprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice()+"",ts.getPM_MinDisCountValue()+"")));
//                    }
//                }
//            }else {
//                //无特价折扣
//                if(!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("0.0")){
//                    //有会员价
//                    vh.mTvTeprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
//                }else {
//                    vh.mTvTeprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString()));
//                }
//
//            }
//        }else{
//            if(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("0.0")){
//                vh.mTvTeprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString()));
//            }else{
//                vh.mTvTeprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
//            }
//        }

        if (ts.getPD_Discount() == 1) {
            vh.mTvTeprice.setVisibility(View.GONE);
        } else {
            vh.mTvTeprice.setVisibility(View.VISIBLE);
            vh.mTvTeprice.setText(StringUtil.twoNum(NullUtils.noNullHandle(ts.getPD_Discount()).toString()) + "折");
        }


        vh.mTvVipprice.setText("￥ " + StringUtil.twoNum(NullUtils.noNullHandle(ts.getJisuanPrice()).toString()));
//        if(PreferenceHelper.readBoolean(context,"yunshangpu","vip",false)){
//            String  p1=CommonUtils.multiply(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString(),NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString());
//           String xiaoji= CommonUtils.multiply(p1,vh.mTvNum.getText().toString());
//            vh.mTvPrice.setText(StringUtil.twoNum(xiaoji));
//         }else{
//            String  p1=CommonUtils.multiply(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString(),NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString());
//        String xiaoji = CommonUtils.multiply(NullUtils.noNullHandle(ts.getJisuanPrice()).toString(), vh.mTvNum.getText().toString());

        vh.mTvPrice.setText(StringUtil.twoNum(ts.getAllprice() + ""));
//        }
        vh.mTvSt.setText(NullUtils.noNullHandle(ts.getPM_Modle()).toString());
        if (ts.isIsgive()) {
            vh.mTvZeng.setVisibility(View.VISIBLE);
        } else {
            vh.mTvZeng.setVisibility(View.GONE);
        }

        if (ts.getEM_NameList() != null && !ts.getEM_NameList().equals("")) {
            vh.tvStaff.setVisibility(View.VISIBLE);
            vh.tvStaff.setText(ts.getEM_NameList());
        } else {
            vh.tvStaff.setVisibility(View.GONE);
        }


        vh.mIvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = ts.getNum();
                vh.mTvNum.setText((num + 1) + "");
                ts.setNum(num + 1);
                ts.setChosePosion(i);
                String xiaoji = CommonUtils.multiply(CommonUtils.multiply(NullUtils.noNullHandle
                        (ts.getJisuanPrice()).toString(), vh.mTvNum.getText().toString()), ts.getPD_Discount() + "");
                ts.setAllprice(Double.parseDouble(xiaoji));
                vh.mTvPrice.setText(StringUtil.twoNum(xiaoji));
                back.onResponse(ts);
            }
        });
        vh.mIvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = ts.getNum();
                if (num <= 1) {
                    ts.setChosePosion(-1);
                    back.onErrorResponse(i);
                } else {
                    vh.mTvNum.setText((num - 1) + "");
                    ts.setNum(num - 1);
                    ts.setChosePosion(i);
                    String xiaoji = CommonUtils.multiply(CommonUtils.multiply(NullUtils.noNullHandle
                            (ts.getJisuanPrice()).toString(), vh.mTvNum.getText().toString()), ts.getPD_Discount() + "");
                    ts.setAllprice(Double.parseDouble(xiaoji));
                    vh.mTvPrice.setText(StringUtil.twoNum(xiaoji));
                    back.onResponse(ts);
                }
            }
        });
        vh.mRlBg.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                back.onThreeResponse(i);
            }
        });
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_zeng)
        TextView mTvZeng;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_st)
        TextView mTvSt;
        @BindView(R.id.tv_vipprice)
        TextView mTvVipprice;
        @BindView(R.id.tv_teprice)
        TextView mTvTeprice;
        @BindView(R.id.tv_price)
        TextView mTvPrice;
        @BindView(R.id.iv_del)
        ImageView mIvDel;
        @BindView(R.id.tv_num)
        TextView mTvNum;
        @BindView(R.id.iv_add)
        ImageView mIvAdd;
        @BindView(R.id.view_line)
        View mViewLine;
        @BindView(R.id.rl_bg)
        RelativeLayout mRlBg;
        @BindView(R.id.tv_staff)
        TextView tvStaff;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

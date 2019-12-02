package com.wycd.yushangpu.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.views.ShapedImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/8/16.
 */

public class ShopRightAdapter extends BaseAdapter {
    private List<ShopMsg> list;
    private Context context;
    private LayoutInflater inflater;

    public ShopRightAdapter(Context context, List<ShopMsg> list) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view == null) {
            view = inflater.inflate(R.layout.item_home_rightshop, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        ShopMsg ts = list.get(i);
        vh.mTvName.setText(NullUtils.noNullHandle(ts.getPM_Name()).toString());
        VolleyResponse.instance().getInternetImg(context, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(ts.getPM_BigImg()).toString()), vh.mIvShop, R.mipmap.messge_nourl);
        vh.mTvXinghao.setText(NullUtils.noNullHandle(ts.getPM_Modle()).toString());
        //库存
//        if (ts.getPM_Metering() != null) {
//            vh.mTvKunum.setText(String.valueOf(ts.getCurrtStock_Number()) + ts.getPM_Metering());
//        } else {
            vh.mTvKunum.setText(ts.getStock_Number() + "");
//        }

//        vh.mTvKunum.setText(NullUtils.noNullHandle(ts.getPM_Repertory()).toString());
//        int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
        switch (NullUtils.noNullHandle(ts.getPM_IsService()).toString()) {
            case "0":
                vh.mIvState.setText("普");
                vh.mIvState.setTextColor(context.getResources().getColor(R.color.textblue));
//                vh.mIvState.setBackgroundResource(R.drawable.home_pu);
                vh.llKucun.setVisibility(View.VISIBLE);
                break;
            case "1":
                vh.mIvState.setText("服");
                vh.mIvState.setTextColor(context.getResources().getColor(R.color.textgreen));
                vh.llKucun.setVisibility(View.INVISIBLE);
                break;
            case "2":
                vh.mIvState.setText("礼");
                vh.mIvState.setTextColor(context.getResources().getColor(R.color.textred));
//                vh.mIvState.setBackgroundResource(R.drawable.shop_li);
                vh.llKucun.setVisibility(View.VISIBLE);
                break;
            case "3":
                vh.mIvState.setText("套");
                vh.mIvState.setTextColor(context.getResources().getColor(R.color.textblue));
//                vh.mIvState.setBackgroundResource(R.drawable.shop_pt);
                vh.llKucun.setVisibility(View.INVISIBLE);
                break;
            case "4":
                vh.mIvState.setText("套");
                vh.mIvState.setTextColor(context.getResources().getColor(R.color.textgreen));
//                vh.mIvState.setBackgroundResource(R.drawable.shop_ci);
                vh.llKucun.setVisibility(View.INVISIBLE);
                break;
        }
//        PM_IsDiscount	商品折扣	int	0关闭 1开启

//        2、textView设置中划线
//        vh.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
//        vh.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
//
//        3、textView取消中划线或者下划线
//        vh.mTvVipprice.getPaint().setFlags(0); // 取消设置的的划线

        if (NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")) {
            if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferMoney()).toString().equals("0.0") && ts.getPM_SpecialOfferMoney() != -1) {
                //无最低折扣
                vh.mTvVipprice.setText("特：" + ts.getPM_SpecialOfferMoney());
                vh.mTvSanprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); //中划线
                vh.mTvSanprice.setTextColor(context.getResources().getColor(R.color.a5a5a5));

            } else if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")) {
                //有特价折扣
                if (NullUtils.noNullHandle(ts.getPM_MinDisCountValue()).toString().equals("0.0")) {
                    //无最低折扣
                    vh.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_SpecialOfferValue() + "")));
                } else {
                    //有最低折扣
                    if (ts.getPM_SpecialOfferValue() > ts.getPM_MinDisCountValue()) {
                        vh.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_SpecialOfferValue() + "")));
                    } else {
                        vh.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_MinDisCountValue() + "")));
                    }
                }
                vh.mTvSanprice.setTextColor(context.getResources().getColor(R.color.a5a5a5));
                vh.mTvSanprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); //中划线
            } else {
                //无特价折扣
                if (!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                    //有会员价
                    vh.mTvVipprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
                } else {
                    vh.mTvVipprice.setText("");
                }
                vh.mTvSanprice.getPaint().setFlags(0|Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
                vh.mTvSanprice.setTextColor(context.getResources().getColor(R.color.textred));
            }
        } else {
            if (!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                vh.mTvVipprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
            } else {
                vh.mTvVipprice.setText("");
            }
            vh.mTvSanprice.getPaint().setFlags(0|Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
            vh.mTvSanprice.setTextColor(context.getResources().getColor(R.color.textred));
        }
        vh.mTvSanprice.setText("售：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString()));
        return view;
    }

    static class ViewHolder {


        @Bind(R.id.iv_shop)
        ShapedImageView mIvShop;
        @Bind(R.id.iv_state)
        TextView mIvState;
        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.tv_xinghao)
        TextView mTvXinghao;
        @Bind(R.id.tv_sanprice)
        TextView mTvSanprice;
        @Bind(R.id.tv_vipprice)
        TextView mTvVipprice;
        @Bind(R.id.iv_ku)
        TextView mIvKu;
        @Bind(R.id.tv_kunum)
        TextView mTvKunum;
        @Bind(R.id.ll_kucun)
        LinearLayout llKucun;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

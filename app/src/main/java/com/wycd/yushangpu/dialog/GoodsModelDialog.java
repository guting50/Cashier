package com.wycd.yushangpu.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.ShopRulesAdapter;
import com.wycd.yushangpu.bean.GoodsModelBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.views.ShapedImageView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ZPH on 2019-06-28.
 */

public class GoodsModelDialog {

    private static ShapedImageView ivGoodsImage;
    private static TextView tvName;
    private static TextView tvCode;
    private static TextView tvPrice;
    private static TextView tvesPrice;
    private static LinearLayout ll_esprice;
    private static TextView tvStork;
    private static ShopRulesAdapter mShopRulesAdapter;
    private static List<List<GoodsModelBean>> modelList;
    private static List<ShopMsg> goodsList;
    private static ShopMsg goodsitem;

    public static Dialog goodsModelDialog(final Activity context,
                                          int showingLocation, final List<List<GoodsModelBean>> mmodelList, List<ShopMsg> msllist, final boolean isZeroStock, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_sm_goods_rule_pop, null);

        modelList = mmodelList;
        goodsList = msllist;

        TextView tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tvSure = (TextView) view.findViewById(R.id.tv_sure);
        ImageView ivclose = (ImageView) view.findViewById(R.id.iv_close);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mShopRulesAdapter = new ShopRulesAdapter(context, modelList, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                modelList = (List<List<GoodsModelBean>>) response;

                initpop(context);
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
//        mRulePopupWindow.setOnDismissListener(context);
        recyclerView.setAdapter(mShopRulesAdapter);

        ivGoodsImage = (ShapedImageView) view.findViewById(R.id.iv_item_goods);
        tvName = (TextView) view.findViewById(R.id.tv_item_goods_name);
        tvCode = (TextView) view.findViewById(R.id.tv_item_goods_code);
        tvPrice = (TextView) view.findViewById(R.id.tv_item_goods_price);
        tvesPrice = (TextView) view.findViewById(R.id.tv_item_goods_esprice);
        ll_esprice = (LinearLayout) view.findViewById(R.id.ll_esprice);

        tvStork = (TextView) view.findViewById(R.id.tv_item_goods_stock);

        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view, new LinearLayout.LayoutParams(
                screenWidth - dip2px(context, 600), 550));
        Window window = dialog.getWindow();
        dialog.show();


        initpop(context);
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (goodsitem != null) {
                    if (isZeroStock && goodsitem.getStock_Number() <= 0 && goodsitem.getPM_IsService() == 0) {
//                        ToastUtils.showToast(context,"当前库存不足");
                        com.blankj.utilcode.util.ToastUtils.showShort("当前库存不足");
                    } else {
                        back.onResponse(goodsitem);
                    }
                }
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ivclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        switch (showingLocation) {
            case 0:
                window.setGravity(Gravity.TOP); // 此处可以设置dialog显示的位置
                break;
            case 1:
                window.setGravity(Gravity.CENTER);
                break;
            case 2:
                window.setGravity(Gravity.BOTTOM);
                break;
            case 3:
                WindowManager.LayoutParams params = window.getAttributes();
                dialog.onWindowAttributesChanged(params);
                params.x = screenWidth - dip2px(context, 100);// 设置x坐标
                params.gravity = Gravity.TOP;
                params.y = dip2px(context, 45);// 设置y坐标
                Log.d("xx", params.y + "");
                window.setGravity(Gravity.TOP);
                window.setAttributes(params);
                break;
            default:
                window.setGravity(Gravity.CENTER);
                break;
        }
        return dialog;
    }


    private static void initpop(Activity context) {
        goodsitem = null;
        StringBuilder modelName = new StringBuilder("");
        for (int j = 0; j < modelList.size(); j++) {
            for (int k = 0; k < modelList.get(j).size(); k++) {
                if (modelList.get(j).get(k).isChecked()) {
                    modelName.append(modelList.get(j).get(k).getPM_Properties() + "|");
                }
            }
        }
        String str = String.valueOf(modelName);
        if (str.substring(str.length() - 1, str.length()).equals("|")) {
            str = str.substring(0, str.length() - 1);
        }

        for (int i = 0; i < goodsList.size(); i++) {
            if (str.equals(goodsList.get(i).getPM_Modle())) {

                goodsitem = goodsList.get(i);
            }
        }

        if (goodsitem != null) {
            //头像
            VolleyResponse.instance().getInternetImg(context, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(goodsitem.getPM_BigImg()).toString()), ivGoodsImage, R.mipmap.messge_nourl);

            tvName.setText(goodsitem.getPM_Name() + "");
            tvCode.setText(goodsitem.getPM_Code() + "");


            if (NullUtils.noNullHandle(goodsitem.getPM_IsDiscount()).toString().equals("1")) {
                ll_esprice.setVisibility(View.VISIBLE);
                if (!NullUtils.noNullHandle(goodsitem.getPM_SpecialOfferMoney()).toString().equals("0.0") && goodsitem.getPM_SpecialOfferMoney() != -1) {
                    //无最低折扣
                    tvesPrice.setText("特：" + goodsitem.getPM_SpecialOfferMoney());
                    tvPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
                    tvPrice.setTextColor(context.getResources().getColor(R.color.a5a5a5));

                } else if (!NullUtils.noNullHandle(goodsitem.getPM_SpecialOfferValue()).toString().equals("0.0")) {
                    //有特价折扣
                    if (NullUtils.noNullHandle(goodsitem.getPM_MinDisCountValue()).toString().equals("0.0")) {
                        //无最低折扣
                        tvesPrice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(goodsitem.getPM_UnitPrice() + "", goodsitem.getPM_SpecialOfferValue() + "")));
                    } else {
                        //有最低折扣
                        if (goodsitem.getPM_SpecialOfferValue() > goodsitem.getPM_MinDisCountValue()) {
                            tvesPrice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(goodsitem.getPM_UnitPrice() + "", goodsitem.getPM_SpecialOfferValue() + "")));
                        } else {
                            tvesPrice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(goodsitem.getPM_UnitPrice() + "", goodsitem.getPM_MinDisCountValue() + "")));
                        }
                    }
                    tvPrice.setTextColor(context.getResources().getColor(R.color.a5a5a5));
                    tvPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
                } else {
                    //无特价折扣
                    if (!NullUtils.noNullHandle(goodsitem.getPM_MemPrice()).toString().equals("")) {
                        //有会员价
                        tvesPrice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(goodsitem.getPM_MemPrice()).toString()));
                        ll_esprice.setVisibility(View.VISIBLE);
                    } else {
                        tvesPrice.setText("");
                        ll_esprice.setVisibility(View.GONE);
                    }
                    tvPrice.getPaint().setFlags(0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
                    tvPrice.setTextColor(context.getResources().getColor(R.color.text60));
                }
            } else {
                if (!NullUtils.noNullHandle(goodsitem.getPM_MemPrice()).toString().equals("")) {
                    tvesPrice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(goodsitem.getPM_MemPrice()).toString()));
                    ll_esprice.setVisibility(View.VISIBLE);
                } else {
                    tvesPrice.setText("");
                    ll_esprice.setVisibility(View.GONE);
                }
                tvPrice.getPaint().setFlags(0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
                tvPrice.setTextColor(context.getResources().getColor(R.color.text60));
            }

            tvPrice.setText("售：" + StringUtil.twoNum(goodsitem.getPM_UnitPrice() + ""));
//            tvesPrice.setText("特："+  StringUtil.twoNum(goodsitem.getPM_UnitPrice() + ""));

            //库存
            if (goodsitem.getPM_Metering() != null) {
                tvStork.setText(String.valueOf(goodsitem.getStock_Number()) + goodsitem.getPM_Metering());
            } else {
                tvStork.setText(goodsitem.getStock_Number() + "");
            }
        } else {
            ivGoodsImage.setImageResource(R.mipmap.messge_nourl);
            tvName.setText("无此规格商品");
            tvCode.setVisibility(View.GONE);
            tvPrice.setText("¥0.00");
            tvStork.setText("0");
        }
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}

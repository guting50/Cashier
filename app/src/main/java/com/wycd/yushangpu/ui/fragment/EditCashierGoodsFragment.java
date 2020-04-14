package com.wycd.yushangpu.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gt.utils.view.BgFrameLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;
import com.wycd.yushangpu.widget.dialog.ShopDetailDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EditCashierGoodsFragment extends BaseFragment {
    @BindView(R.id.info_goods_name)
    TextView infoGoodsName;
    @BindView(R.id.goods_code)
    TextView goodsCode;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.bn_edit_num)
    BgFrameLayout bnEditNum;
    @BindView(R.id.bn_edit_price)
    BgFrameLayout bnEditPrice;
    @BindView(R.id.bn_edit_give)
    BgFrameLayout bnEditGive;
    @BindView(R.id.bn_edit_subtotal)
    BgFrameLayout bnEditSubtotal;
    @BindView(R.id.bn_edit_discount)
    BgFrameLayout bnEditDiscount;
    @BindView(R.id.discount_unit)
    TextView discountUnit;
    @BindView(R.id.bn_edit_royalty)
    BgFrameLayout bnEditRoyalty;
    @BindView(R.id.tv_edit_title_view)
    TextView tvEditTitleView;
    @BindView(R.id.edit_layout)
    LinearLayout editLayout;
    @BindView(R.id.edit_num_del)
    BgFrameLayout editNumDel;
    @BindView(R.id.edit_num_add)
    BgFrameLayout ediNumAdd;
    @BindView(R.id.edit_layout_place)
    View editLayoutPlace;
    @BindView(R.id.keyboard_layout)
    View keyboardLayout;
    @BindView(R.id.edit_text_layout)
    NumInputView editTextLayout;

    ShopMsg shopBean;

    @Override
    public int getContentView() {
        return R.layout.fragment_edit_cashier_goods;
    }

    @Override
    public void onCreated() {
        new NumKeyboardUtils(getActivity(), rootView, editTextLayout);
    }

    public void setData(ShopMsg shopBean) {
        this.shopBean = shopBean;
        super.setData();
    }

    public void updateData() {
        if (shopBean != null) {
            infoGoodsName.setText(shopBean.getPM_Name());
            goodsCode.setText("条码：" + shopBean.getPM_Code());
            tvPrice.setText("售价：￥" + shopBean.getPM_UnitPrice() + "");
            bnEditNum.performClick();
        }
    }

    @OnClick({R.id.info_goods_layout, R.id.iv_clone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.info_goods_layout:
                break;
            case R.id.iv_clone:
                resetBnEdit(null);
                getFragmentManager().beginTransaction().hide(this).commit();
                break;
        }
    }

    BgFrameLayout currentSelectedBn;

    @OnClick({R.id.bn_edit_num, R.id.bn_edit_price, R.id.bn_edit_give, R.id.bn_edit_subtotal, R.id.bn_edit_discount,
            R.id.bn_edit_royalty})
    public void onViewClickedBn(View view) {
        switch (view.getId()) {
            case R.id.bn_edit_num:
                resetBnEdit(view);
                tvEditTitleView.setText("改数量");
                editLayout.setVisibility(View.VISIBLE);
                editNumDel.setVisibility(View.VISIBLE);
                ediNumAdd.setVisibility(View.VISIBLE);
                editLayoutPlace.setVisibility(View.GONE);
                editTextLayout.setText(shopBean.getNum() + "");
                editTextLayout.selectAll();
                break;
            case R.id.bn_edit_price:
                if (homeActivity.cashierFragment.mModifyPrice == 0 || homeActivity.cashierFragment.mChangePrice == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改单价 后再操作");
                    return;
                }
                if (NullUtils.noNullHandle(shopBean.getPM_IsService()).toString().equals("3")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("套餐不能修改单价");
                    return;
                }
                resetBnEdit(view);
                tvEditTitleView.setText("改单价");
                editLayout.setVisibility(View.VISIBLE);
                editTextLayout.setText(shopBean.getJisuanPrice() + "");
                editTextLayout.selectAll();
                break;
            case R.id.bn_edit_subtotal:
                if (homeActivity.cashierFragment.mModifyPrice == 0 || homeActivity.cashierFragment.mChangeSubtotal == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改小计 后再操作");
                    return;
                }
                if (shopBean.isIsgive()) {
                    com.blankj.utilcode.util.ToastUtils.showShort("赠送商品不能改小计");
                    return;
                }
                resetBnEdit(view);
                tvEditTitleView.setText("改小计");
                editLayout.setVisibility(View.VISIBLE);
                editTextLayout.setText(CommonUtils.multiply(NullUtils.noNullHandle(
                        shopBean.getJisuanPrice() * shopBean.getPD_Discount()).toString(),
                        NullUtils.noNullHandle(shopBean.getNum()).toString()) + "");
                editTextLayout.selectAll();
                break;
            case R.id.bn_edit_discount:
                if (homeActivity.cashierFragment.mModifyPrice == 0 || homeActivity.cashierFragment.mChangeDiscount == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改折扣 后再操作");
                    return;
                }
                if (shopBean.isIsgive()) {
                    com.blankj.utilcode.util.ToastUtils.showShort("赠送商品不能改折扣");
                    return;
                }
                resetBnEdit(view);
                discountUnit.setVisibility(View.VISIBLE);
                tvEditTitleView.setText("改折扣");
                editLayout.setVisibility(View.VISIBLE);
                editTextLayout.setText(shopBean.getPD_Discount() + "");
                editTextLayout.selectAll();
                break;
            case R.id.bn_edit_give:
                NoticeDialog.noticeDialog(homeActivity, "商品赠送", "是否赠送此商品？", 1, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        resetBnEdit(view);
                        double discount = 0;
                        shopBean.setIschanged(true);
                        shopBean.setIsgive(true);
                        shopBean.setPD_Discount(discount);
                        shopBean.setAllprice(0);
                        homeActivity.cashierFragment.mShopLeftAdapter.notifyDataSetChanged();
                        homeActivity.cashierFragment.jisuanAllPrice();
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
                break;
            case R.id.bn_edit_royalty:
                resetBnEdit(view);
                editLayout.setVisibility(View.GONE);
                //提成员工
                ShopDetailDialog.shopdetailDialog(getActivity(), shopBean,
                        null == homeActivity.cashierFragment.mVipMsg ? "" : homeActivity.cashierFragment.mVipMsg.getVG_GID(),
                        shopBean.getEM_GIDList(), MyApplication.loginBean.getShopID(), 1, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {

                                List<EmplMsg> mEmplMsgList = (List<EmplMsg>) response;

                                StringBuilder mStaffName = new StringBuilder("");//提成员工姓名
                                List<String> tcGID = new ArrayList<>();
                                for (int i = 0; i < mEmplMsgList.size(); i++) {
                                    if (mEmplMsgList.get(i).isIschose()) {
                                        tcGID.add(mEmplMsgList.get(i).getGID());
                                        if (i == mEmplMsgList.size() - 1) {
                                            mStaffName.append(mEmplMsgList.get(i).getEM_Name());
                                        } else {
                                            mStaffName.append(mEmplMsgList.get(i).getEM_Name() + "、");
                                        }
                                    }
                                }

                                shopBean.setEM_GIDList(tcGID);
                                shopBean.setEM_NameList(mStaffName.toString());
                                homeActivity.cashierFragment.mShopLeftAdapter.notifyDataSetChanged();
                                homeActivity.cashierFragment.jisuanAllPrice();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                break;
        }
    }

    @OnClick({R.id.edit_num_add, R.id.edit_num_del, R.id.edit_confirm})
    public void onViewClickedEditBn(View view) {
        switch (view.getId()) {
            case R.id.edit_num_del:
                editTextLayout.subtractNum();
                break;
            case R.id.edit_num_add:
                editTextLayout.addNum();
                break;
            case R.id.edit_confirm:
                if (editTextLayout.getText().toString().equals("") || "0.0".equals(editTextLayout.getText().toString())) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请输入数字");
                    return;
                }
                if (!StringUtil.isTwoPoint(editTextLayout.getText().toString())) {
                    com.blankj.utilcode.util.ToastUtils.showShort("只能输入两位小数");
                    return;
                }
                if (currentSelectedBn != null) {
                    double editValue = Double.parseDouble(editTextLayout.getText().toString());
                    switch (currentSelectedBn.getId()) {
                        case R.id.bn_edit_num:
                            if (shopBean != null && (shopBean.getPM_IsService() == 1 || shopBean.getPM_IsService() == 3)) {
                                String[] strs = editTextLayout.getText().toString().split("\\.");
                                if (strs.length == 2 && Integer.parseInt(strs[1]) > 0) {
                                    com.blankj.utilcode.util.ToastUtils.showShort("服务或套餐的数量不能为小数");
                                    return;
                                }
                            }
                            shopBean.setNum(editValue);
                            break;
                        case R.id.bn_edit_price:
                            if (shopBean.getPM_IsDiscount() == 1 && shopBean.getPM_SpecialOfferMoney() != -1) {
                                shopBean.setPD_Discount(shopBean.getPM_SpecialOfferMoney() / editValue);
                                shopBean.setJisuanPrice(editValue);
                            } else {
                                shopBean.setJisuanPrice(editValue);
                            }
                            shopBean.setPM_UnitPrice(editValue);
                            break;
                        case R.id.bn_edit_subtotal:
                            double dicount = editValue / (shopBean.getNum() * shopBean.getJisuanPrice());
                            if (0 <= dicount && dicount < 1) {
                                shopBean.setIschanged(true);
                                shopBean.setPD_Discount(dicount);
                                shopBean.setAllprice(editValue);
                            }
                            break;
                        case R.id.bn_edit_discount:
                            if (editValue > 1) {
                                com.blankj.utilcode.util.ToastUtils.showShort("输入数字不正确");
                                return;
                            }
                            shopBean.setIschanged(true);
                            shopBean.setPD_Discount(editValue);
                            double xiaoji = Double.parseDouble(
                                    CommonUtils.multiply(NullUtils.noNullHandle(shopBean.getJisuanPrice() * editValue).toString(), shopBean.getNum() + "") + "");
                            shopBean.setAllprice(xiaoji);
                            break;
                    }
                }
                homeActivity.cashierFragment.mShopLeftAdapter.notifyDataSetChanged();
                homeActivity.cashierFragment.jisuanAllPrice();

                resetBnEdit(null);
                getFragmentManager().beginTransaction().hide(this).commit();
                break;
        }
    }

    public void resetBnEdit(View view) {
        bnEditNum.setSolidColor(Color.alpha(R.color.white));
        bnEditNum.setStrokeWidth(1);
        ((TextView) bnEditNum.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));
        bnEditPrice.setSolidColor(Color.alpha(R.color.white));
        bnEditPrice.setStrokeWidth(1);
        ((TextView) bnEditPrice.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));
        bnEditGive.setSolidColor(Color.alpha(R.color.white));
        bnEditGive.setStrokeWidth(1);
        ((TextView) bnEditGive.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));
        bnEditSubtotal.setSolidColor(Color.alpha(R.color.white));
        bnEditSubtotal.setStrokeWidth(1);
        ((TextView) bnEditSubtotal.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));
        bnEditDiscount.setSolidColor(Color.alpha(R.color.white));
        bnEditDiscount.setStrokeWidth(1);
        ((TextView) bnEditDiscount.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));
        bnEditRoyalty.setSolidColor(Color.alpha(R.color.white));
        bnEditRoyalty.setStrokeWidth(1);
        ((TextView) bnEditRoyalty.getChildAt(0)).setTextColor(getResources().getColor(R.color.title_color));

        currentSelectedBn = (BgFrameLayout) view;
        if (currentSelectedBn != null) {
            currentSelectedBn.setSolidColor(getResources().getColor(R.color.yunpu));
            currentSelectedBn.setStrokeWidth(0);
            ((TextView) currentSelectedBn.getChildAt(0)).setTextColor(getResources().getColor(R.color.color_f3));
        }

        editLayout.setVisibility(View.GONE);
        editNumDel.setVisibility(View.INVISIBLE);
        ediNumAdd.setVisibility(View.GONE);
        editLayoutPlace.setVisibility(View.VISIBLE);
        discountUnit.setVisibility(View.GONE);
    }

    public ShopMsg getShopBean() {
        return shopBean;
    }
}

package com.wycd.yushangpu.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gt.utils.view.BgFrameLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.dialog.ShopDetailDialog;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.ui.HomeActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class EditCashierGoodsFragment extends Fragment {
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
    @BindView(R.id.bn_edit_royalty)
    BgFrameLayout bnEditRoyalty;
    @BindView(R.id.tv_edit_view)
    EditText editView;
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

    HomeActivity homeActivity;
    ShopMsg shopBean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_cashier_goods, null);
        ButterKnife.bind(this, rootView);

        homeActivity = (HomeActivity) getActivity();

        editView.setInputType(InputType.TYPE_NULL);

        return rootView;
    }

    public void setData(ShopMsg shopBean) {
        this.shopBean = shopBean;
        infoGoodsName.setText(shopBean.getPM_Name());
        goodsCode.setText("条码：" + shopBean.getPM_Code());
        tvPrice.setText("售价：￥" + shopBean.getPM_UnitPrice() + "");
    }

    @OnClick({R.id.info_goods_layout, R.id.close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.info_goods_layout:
                break;
            case R.id.close:
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
                editView.setText(shopBean.getNum() + "");
                editViewSelectAll();
                break;
            case R.id.bn_edit_price:
                if (homeActivity.mModifyPrice == 0 || homeActivity.mChangePrice == 0) {
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
                editView.setText(shopBean.getJisuanPrice() + "");
                editViewSelectAll();
                break;
            case R.id.bn_edit_subtotal:
                if (homeActivity.mModifyPrice == 0 || homeActivity.mChangeSubtotal == 0) {
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
                editView.setText(CommonUtils.multiply(NullUtils.noNullHandle(
                        shopBean.getJisuanPrice() * shopBean.getPD_Discount()).toString(),
                        NullUtils.noNullHandle(shopBean.getNum()).toString()));
                editViewSelectAll();
                break;
            case R.id.bn_edit_discount:
                if (homeActivity.mModifyPrice == 0 || homeActivity.mChangeDiscount == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改折扣 后再操作");
                    return;
                }
                if (shopBean.isIsgive()) {
                    com.blankj.utilcode.util.ToastUtils.showShort("赠送商品不能改折扣");
                    return;
                }
                resetBnEdit(view);
                tvEditTitleView.setText("改折扣");
                editLayout.setVisibility(View.VISIBLE);
                editView.setText(shopBean.getPD_Discount() + "");
                editViewSelectAll();
                break;
            case R.id.bn_edit_give:
                resetBnEdit(view);
                double discount = 0;
                shopBean.setIschanged(true);
                shopBean.setIsgive(true);
                shopBean.setPD_Discount(discount);
                shopBean.setAllprice(0);
                homeActivity.mShopLeftAdapter.notifyDataSetChanged();
                homeActivity.jisuanAllPrice();
                break;
            case R.id.bn_edit_royalty:
                resetBnEdit(view);
                editLayout.setVisibility(View.GONE);
                //提成员工
                ShopDetailDialog.shopdetailDialog(getActivity(), shopBean,
                        null == homeActivity.mVipMsg ? "" : homeActivity.mVipMsg.getVG_GID(),
                        shopBean.getEM_GIDList(), MyApplication.loginBean.getData().getShopID(), 1, new InterfaceBack() {
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
                                homeActivity.mShopLeftAdapter.notifyDataSetChanged();
                                homeActivity.jisuanAllPrice();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                break;
        }
    }

    @OnClick({R.id.tv_edit_view, R.id.edit_num_add, R.id.edit_num_del, R.id.edit_confirm})
    public void onViewClickedEditBn(View view) {
        switch (view.getId()) {
            case R.id.tv_edit_view:
                if (view.getTag() == null)
                    editViewSelectAll();
                else
                    setEditViewText(editView.getText() != null ? editView.getText().toString() : "");
                break;
            case R.id.edit_num_del:
                if (!TextUtils.isEmpty(editView.getText())) {
                    double num = Double.parseDouble(editView.getText().toString());
                    if (num > 0)
                        editView.setText(num - 1 + "");
                }
                break;
            case R.id.edit_num_add:
                double num = 0;
                if (!TextUtils.isEmpty(editView.getText())) {
                    num = Double.parseDouble(editView.getText().toString());
                }
                editView.setText(num + 1 + "");
                break;
            case R.id.edit_confirm:
                if (currentSelectedBn != null) {
                    switch (currentSelectedBn.getId()) {
                        case R.id.bn_edit_num:
                            shopBean.setNum(Double.parseDouble(editView.getText().toString()));
                            break;
                        case R.id.bn_edit_price:
                            double price = Double.parseDouble(editView.getText().toString());
                            if (shopBean.getPM_IsDiscount() == 1 && shopBean.getPM_SpecialOfferMoney() != -1) {
                                shopBean.setPD_Discount(shopBean.getPM_SpecialOfferMoney() / price);
                                shopBean.setJisuanPrice(price);
                            } else {
                                shopBean.setJisuanPrice(price);
                            }
                            shopBean.setPM_UnitPrice(price);
                            break;
                        case R.id.bn_edit_subtotal:
                            double price1 = Double.parseDouble(editView.getText().toString());
                            double dicount = price1 / (shopBean.getNum() * shopBean.getJisuanPrice());
                            if (0 <= dicount && dicount < 1) {
                                shopBean.setIschanged(true);
                                shopBean.setPD_Discount(dicount);
                                shopBean.setAllprice(price1);
                            }
                            break;
                        case R.id.bn_edit_discount:
                            double discount = Double.parseDouble(editView.getText().toString());
                            shopBean.setIschanged(true);
                            shopBean.setPD_Discount(discount);
                            double xiaoji = Double.parseDouble(
                                    CommonUtils.multiply(NullUtils.noNullHandle(shopBean.getJisuanPrice() * discount).toString(), shopBean.getNum() + ""));
                            shopBean.setAllprice(xiaoji);
                            break;
                    }
                }
                homeActivity.mShopLeftAdapter.notifyDataSetChanged();
                homeActivity.jisuanAllPrice();

                resetBnEdit(null);
                getFragmentManager().beginTransaction().hide(this).commit();
                break;
        }
    }

    public void resetBnEdit(View view) {
        bnEditNum.setSolidColor(Color.alpha(R.color.white));
        bnEditNum.setStrokeWidth(1);
        ((TextView) bnEditNum.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
        bnEditPrice.setSolidColor(Color.alpha(R.color.white));
        bnEditPrice.setStrokeWidth(1);
        ((TextView) bnEditPrice.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
        bnEditGive.setSolidColor(Color.alpha(R.color.white));
        bnEditGive.setStrokeWidth(1);
        ((TextView) bnEditGive.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
        bnEditSubtotal.setSolidColor(Color.alpha(R.color.white));
        bnEditSubtotal.setStrokeWidth(1);
        ((TextView) bnEditSubtotal.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
        bnEditDiscount.setSolidColor(Color.alpha(R.color.white));
        bnEditDiscount.setStrokeWidth(1);
        ((TextView) bnEditDiscount.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
        bnEditRoyalty.setSolidColor(Color.alpha(R.color.white));
        bnEditRoyalty.setStrokeWidth(1);
        ((TextView) bnEditRoyalty.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));

        currentSelectedBn = (BgFrameLayout) view;
        if (currentSelectedBn != null) {
            currentSelectedBn.setSolidColor(getResources().getColor(R.color.texty6b));
            currentSelectedBn.setStrokeWidth(0);
            ((TextView) currentSelectedBn.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
        }

        editLayout.setVisibility(View.GONE);
        editNumDel.setVisibility(View.INVISIBLE);
        ediNumAdd.setVisibility(View.GONE);
        editLayoutPlace.setVisibility(View.VISIBLE);
    }

    @OnTouch({R.id.num_keyboard_7, R.id.num_keyboard_8, R.id.num_keyboard_9, R.id.num_keyboard_4,
            R.id.num_keyboard_5, R.id.num_keyboard_6, R.id.num_keyboard_1, R.id.num_keyboard_2,
            R.id.num_keyboard_3, R.id.num_keyboard_0, R.id.num_keyboard_dot, R.id.num_keyboard_delete})
    public boolean onViewTouchKeyboard(View view, MotionEvent event) {
        if (view.getId() == R.id.num_keyboard_delete) {
            Timer timer = (Timer) view.getTag();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (timer == null) {
                        timer = new Timer();
                        view.setTag(timer);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                homeActivity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!TextUtils.isEmpty(editView.getText())) {
                                            if (editView.getTag() == null) {
                                                String content = editView.getText().toString();
                                                editView.setText(content.substring(0, content.length() - 1));
                                            } else {
                                                setEditViewText("");
                                            }
                                        }
                                    }
                                });
                            }
                        }, 0, 80);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (timer != null) {
                        timer.cancel();
                        view.setTag(null);
                    }
                    break;
            }
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundResource(R.color.text0050);
                break;
            case MotionEvent.ACTION_UP:
                view.setBackgroundResource(R.color.result_view);
                switch (view.getId()) {
                    case R.id.num_keyboard_7:
                        setEditViewText("7");
                        break;
                    case R.id.num_keyboard_8:
                        setEditViewText("8");
                        break;
                    case R.id.num_keyboard_9:
                        setEditViewText("9");
                        break;
                    case R.id.num_keyboard_4:
                        setEditViewText("4");
                        break;
                    case R.id.num_keyboard_5:
                        setEditViewText("5");
                        break;
                    case R.id.num_keyboard_6:
                        setEditViewText("6");
                        break;
                    case R.id.num_keyboard_1:
                        setEditViewText("1");
                        break;
                    case R.id.num_keyboard_2:
                        setEditViewText("2");
                        break;
                    case R.id.num_keyboard_3:
                        setEditViewText("3");
                        break;
                    case R.id.num_keyboard_0:
                        setEditViewText("0");
                        break;
                    case R.id.num_keyboard_dot:
                        if (!TextUtils.isEmpty(editView.getText()) && editView.getTag() == null) {
                            if (!editView.getText().toString().contains("."))
                                editView.setText(editView.getText() + ".");
                        } else
                            setEditViewText("0.");
                        break;
                }
                break;
        }
        return true;
    }


    private void editViewSelectAll() {
        editView.clearFocus();
        editView.requestFocus();
        editView.selectAll();
        editView.setTag(true);
    }

    private void setEditViewText(String text) {
        if (editView.getTag() == null) {
            editView.setText(editView.getText() + text);
        } else {
            editView.setText(text);
            editView.setTag(null);
        }
    }
}

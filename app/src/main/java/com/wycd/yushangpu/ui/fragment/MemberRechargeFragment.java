package com.wycd.yushangpu.ui.fragment;

import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.widget.BgLayout;
import com.gt.utils.widget.FlowLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.DiscountTypeBean;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.OrderCanshu;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpSubmitOrder;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.widget.dialog.ShopDetailDialog;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 会员充值
 */
public class MemberRechargeFragment extends BaseFragment {

    @BindView(R.id.tv_member_recharge_name)
    TextView tv_member_recharge_name;
    @BindView(R.id.tv_member_recharge_card)
    TextView tv_member_recharge_card;
    @BindView(R.id.tv_member_recharge_balance)
    TextView tv_member_recharge_balance;
    @BindView(R.id.tv_member_recharge_integral)
    TextView tv_member_recharge_integral;
    @BindView(R.id.et_recharge_order_number)
    TextView et_recharge_order_number;
    @BindView(R.id.et_recharge_create_timer)
    TextView et_recharge_create_timer;
    @BindView(R.id.et_recharge_em_name)
    TextView et_recharge_em_name;
    @BindView(R.id.fl_recharge_amount)
    FlowLayout fl_recharge_amount;
    @BindView(R.id.et_recharge_total)
    TextView et_recharge_total;
    @BindView(R.id.et_recharge_integral)
    TextView et_recharge_integral;
    @BindView(R.id.et_recharge_remark)
    TextView et_recharge_remark;

    private VipInfoMsg vipInfoMsg;
    private String orderNumber;
    private List<String> mStaffListGids = new ArrayList<>();
    private List<Double> staffProportionList = new ArrayList<>();
    private List<DiscountTypeBean> mRechargeTypeList;
    private String rechargeMoney, giveMoney, mDiscountActivityGid;
    private double getPoints;

    @Override

    public int getContentView() {
        return R.layout.fragment_member_recharge;
    }

    public void setData(VipInfoMsg info) {
        vipInfoMsg = info;
        super.setData();
    }

    @Override
    public void onCreated() {

    }

    protected void updateData() {
        if (vipInfoMsg != null) {
            tv_member_recharge_name.setText(vipInfoMsg.getVIP_Name());
            tv_member_recharge_card.setText(vipInfoMsg.getVCH_Card());
            tv_member_recharge_balance.setText(vipInfoMsg.getMA_AvailableBalance() + "");
            tv_member_recharge_integral.setText(vipInfoMsg.getMA_AvailableIntegral() + "");
        }

        orderNumber = CreateOrder.createOrder("CZ");//获取订单号
        et_recharge_order_number.setText(orderNumber);
        et_recharge_create_timer.setText(DateTimeUtil.getReallyTimeNow());

        et_recharge_em_name.setText("");
        mStaffListGids.clear();
        staffProportionList.clear();
        et_recharge_total.setText("");
        et_recharge_integral.setText("");

        getDiscountActivity();
    }

    @OnClick({R.id.tv_title, R.id.fl_cancel, R.id.fl_submit, R.id.et_recharge_select_em_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
            case R.id.fl_cancel:
                hide();
                break;
            case R.id.fl_submit:
                if (TextUtils.isEmpty(rechargeMoney)) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择充值金额");
                    return;
                }
                homeActivity.dialog.show();
                new ImpSubmitOrder().submitRechargeOrder(orderNumber, et_recharge_create_timer.getText().toString(),
                        vipInfoMsg.getVCH_Card(), mDiscountActivityGid, rechargeMoney, giveMoney, getPoints,
                        mStaffListGids, staffProportionList, et_recharge_remark.getText().toString(), new InterfaceBack<OrderCanshu>() {
                            @Override
                            public void onResponse(OrderCanshu response) {
                                response.setCO_OrderCode(orderNumber);
                                toJieSuan(response);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                super.onErrorResponse(msg);
                                homeActivity.dialog.dismiss();
                            }
                        });
                break;
            case R.id.et_recharge_select_em_name://选择员工
                ShopDetailDialog.shopdetailDialog(getActivity(), null, "",
                        mStaffListGids, MyApplication.loginBean.getShopID(), 1, true, 3, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                List<EmplMsg> mEmplMsgList = (List<EmplMsg>) response;
                                if (mEmplMsgList != null && mEmplMsgList.size() == 1) {
                                    StringBuilder mStaffName = new StringBuilder("");//提成员工姓名
                                    mStaffListGids.clear();
                                    staffProportionList.clear();
                                    for (int i = 0; i < mEmplMsgList.size(); i++) {
                                        if (mEmplMsgList.get(i).isIschose()) {
                                            mStaffListGids.add(mEmplMsgList.get(i).getGID());
                                            staffProportionList.add(mEmplMsgList.get(i).getStaffProportion());
                                            if (i == mEmplMsgList.size() - 1) {
                                                mStaffName.append(mEmplMsgList.get(i).getEM_Name());
                                            } else {
                                                mStaffName.append(mEmplMsgList.get(i).getEM_Name() + "、");
                                            }
                                        }
                                    }
                                    et_recharge_em_name.setText(mStaffName.toString());
                                }
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                break;
        }
    }

    private void toJieSuan(OrderCanshu jso) {
        homeActivity.jiesuanBFragment.show(homeActivity, R.id.fragment_content);
        homeActivity.jiesuanBFragment.setData(rechargeMoney, rechargeMoney, vipInfoMsg, jso,
                JiesuanBFragment.OrderType.MEM_RECHARGE_PAY, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        homeActivity.jiesuanBFragment.hide();
                        homeActivity.vipMemberFragment.reset();
                        hide();
                    }
                });
    }


    /**
     * 获取充值优惠活动
     */
    private BgLayout frameLayout;
    private EditText ed_RechargeMoney;

    private void getDiscountActivity() {
        AsyncHttpUtils.postHttp(HttpAPI.API().DISSCOUNT_ACTIVITY, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<DiscountTypeBean>>() {
                }.getType();
                mRechargeTypeList = response.getData(listType);

                fl_recharge_amount.removeAllViews();
                for (DiscountTypeBean discountTypeBean : mRechargeTypeList) {
                    if (discountTypeBean.getRP_Type() == 1) {
                        if (discountTypeBean.getRP_ValidType() == 4) {
                            if (vipInfoMsg.getVIP_Birthday() == null || !vipInfoMsg.getVIP_Birthday().contains(DateTimeUtil.getNowDate())) {
                                continue;
                            }
                        }
                        View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_recharge_amount, null);
                        fl_recharge_amount.addView(view);
                        ((TextView) view.findViewById(R.id.tv_RechargeMoney))
                                .setText(discountTypeBean.getRP_RechargeMoney() + "元");
                        String str = "赠送<font color=\"#ff0000\">" + discountTypeBean.getRP_GiveMoney() + "</font>元";
                        ((TextView) view.findViewById(R.id.tv_RP_GiveMoney))
                                .setText(Html.fromHtml(str));
                        view.findViewById(R.id.tv_RP_GiveMoney).setTag(discountTypeBean.getRP_GiveMoney() + "");
                        View viewRoot = (View) view.findViewById(R.id.tv_RechargeMoney).getParent();
                        viewRoot.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                ed_RechargeMoney.setText("");
                                if (frameLayout != null) {
                                    frameLayout.setFocused(false);
                                    frameLayout.setChecked(false);
                                    TextView tv = frameLayout.findViewById(R.id.tv_RechargeMoney);
                                    if (tv != null) {
                                        tv.setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                        ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                                .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                        String str = "赠送<font color=\"#ff0000\">" + (String) frameLayout.findViewById(R.id.tv_RP_GiveMoney).getTag() + "</font>元";
                                        ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                                .setText(Html.fromHtml(str));
                                    }
                                }
                                BgLayout bgFrameLayout = (BgLayout) viewRoot.getParent();
                                frameLayout = bgFrameLayout;
                                frameLayout.setChecked(true);
                                ((TextView) frameLayout.findViewById(R.id.tv_RechargeMoney))
                                        .setTextColor(0xffffffff);
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setTextColor(0xffffffff);
                                rechargeMoney = discountTypeBean.getRP_RechargeMoney() + "";
                                giveMoney = discountTypeBean.getRP_GiveMoney() + "";
                                getPoints = discountTypeBean.getRP_GivePoint();
                                mDiscountActivityGid = discountTypeBean.getGID();
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney)).setText("赠送" + giveMoney + "元");
                                et_recharge_total.setText(CommonUtils.add(rechargeMoney, giveMoney) + "");
                                et_recharge_integral.setText(
                                        StringUtil.twoNum(CommonUtils.add(CommonUtils.multiply(rechargeMoney, vipInfoMsg.getRS_Value() + ""), getPoints) + ""));
                            }
                        });
                    }
                }
                View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_recharge_edit_amount, null);
                View viewRoot = (View) view.findViewById(R.id.ed_RechargeMoney).getParent();
                ed_RechargeMoney = view.findViewById(R.id.ed_RechargeMoney);
                ed_RechargeMoney.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (frameLayout != null) {
                            frameLayout.setChecked(false);
                            TextView tv = frameLayout.findViewById(R.id.tv_RechargeMoney);
                            if (tv != null) {
                                tv.setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                String str = "赠送<font color=\"#ff0000\">" + (String) frameLayout.findViewById(R.id.tv_RP_GiveMoney).getTag() + "</font>元";
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setText(Html.fromHtml(str));
                            }
                        }

                        frameLayout = (BgLayout) viewRoot;
                        frameLayout.setChecked(true);
                        et_recharge_total.setText("");
                        et_recharge_integral.setText("");
                    }
                });
                ed_RechargeMoney.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        ed_RechargeMoney.performClick();
                    }
                });

                ed_RechargeMoney.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        String text = charSequence.toString();
                        if (!StringUtil.isTwoPoint(text)) {
                            charSequence = text.substring(0, text.length() - 1);
                            ed_RechargeMoney.setText(charSequence.toString());
                            ed_RechargeMoney.setSelection(charSequence.length());
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        et_recharge_total.setText(editable);
                        rechargeMoney = editable.toString();
                        giveMoney = "";
                        getPoints = 0;
                        mDiscountActivityGid = "1";
                    }
                });
                fl_recharge_amount.addView(view);
                viewRoot.setEnabled(true);
                ed_RechargeMoney.setEnabled(true);
                if (CacheDoubleUtils.getInstance().getParcelable(SysSwitchRes.Type.T219.getValueStr(), SysSwitchRes.CREATOR).getSS_State() != 1) {
                    viewRoot.setEnabled(false);
                    ed_RechargeMoney.setEnabled(false);
                }
            }
        });
    }
}

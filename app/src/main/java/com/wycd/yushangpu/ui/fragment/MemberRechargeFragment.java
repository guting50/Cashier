package com.wycd.yushangpu.ui.fragment;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.gt.utils.view.FlowLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.DiscountTypeBean;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.widget.dialog.ShopDetailDialog;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;

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
    private String mStaffListGid;
    private List<DiscountTypeBean> mRechargeTypeList;

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

        getDiscountActivity();
    }

    @OnClick({R.id.tv_title, R.id.fl_cancel, R.id.fl_submit, R.id.et_recharge_select_em_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
            case R.id.fl_cancel:
                homeActivity.fragmentManager.beginTransaction().hide(this).commit();
                break;
            case R.id.fl_submit:

                break;
            case R.id.et_recharge_select_em_name:
                ShopDetailDialog.shopdetailDialog(getActivity(), null, "",
                        null, MyApplication.loginBean.getShopID(), 1, true, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                List<EmplMsg> mEmplMsgList = (List<EmplMsg>) response;
                                if (mEmplMsgList != null && mEmplMsgList.size() == 1) {
                                    et_recharge_em_name.setText(mEmplMsgList.get(0).getEM_Name());
                                    mStaffListGid = mEmplMsgList.get(0).getGID();
                                }
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                break;
        }
    }

    private void toJieSuan(OrderCanshhu jso, JiesuanBFragment.OrderType orderType) {
        if (homeActivity.jiesuanBFragment == null) {
            homeActivity.jiesuanBFragment = new JiesuanBFragment();
            homeActivity.fragmentManager.beginTransaction().add(R.id.fragment_content, homeActivity.jiesuanBFragment).commit();
        } else
            homeActivity.fragmentManager.beginTransaction().show(homeActivity.jiesuanBFragment).commit();
//        homeActivity.jiesuanBFragment.setData(totalMoney, allmoney, mVipMsg, jso.getGID(), jso.getCO_Type(), jso.getCO_OrderCode(),
//                mShopLeftList, moren, paytypelist, orderType, new InterfaceBack() {
//                    @Override
//                    public void onResponse(Object response) {
//                        homeActivity.fragmentManager.beginTransaction().hide(jiesuanBFragment).commit();
//                        if (response != null) {
//                            String gid = (String) response;
//                            homeActivity.imgPaySuccess.setVisibility(View.VISIBLE);
//                            new Timer().schedule(new TimerTask() {
//                                @Override
//                                public void run() {
//                                    homeActivity.runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            homeActivity.imgPaySuccess.setVisibility(View.GONE);
//                                        }
//                                    });
//                                }
//                            }, 2000);
//
//                            //打印小票
//                            if (MyApplication.PRINT_IS_OPEN) {
//                                if (MyApplication.mGoodsConsumeMap.isEmpty()) {
//                                    GetPrintSet.getPrintParamSet();
//                                }
//                                new HttpGetPrintContents().SPXF(homeActivity, gid);
//                            }
//
//                            if (ISLABELCONNECT && LABELPRINT_IS_OPEN) {
//                                for (int i = 0; i < mShopLeftList.size(); i++) {
//                                    homeActivity.labelPrint(mShopLeftList.get(i));
//                                }
//                            }
//                            resetCashier();
//                        }
//                    }
//
//                    @Override
//                    public void onErrorResponse(Object msg) {
//                    }
//
//                });
    }


    /**
     * 获取充值优惠活动
     */
    private BgFrameLayout frameLayout;
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
                        viewRoot.setVisibility(View.VISIBLE);
                        viewRoot.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                ed_RechargeMoney.setText("");
                                if (frameLayout != null) {
                                    frameLayout.setSolidColor(0xffffffff);
                                    ((TextView) frameLayout.findViewById(R.id.tv_RechargeMoney))
                                            .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                    ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                            .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                    String str = "赠送<font color=\"#ff0000\">" + (String) frameLayout.findViewById(R.id.tv_RP_GiveMoney).getTag() + "</font>元";
                                    ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                            .setText(Html.fromHtml(str));
                                }
                                BgFrameLayout bgFrameLayout = (BgFrameLayout) viewRoot.getParent();
                                frameLayout = bgFrameLayout;
                                frameLayout.setSolidColor(0xff149f4a);
                                ((TextView) frameLayout.findViewById(R.id.tv_RechargeMoney))
                                        .setTextColor(0xffffffff);
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setTextColor(0xffffffff);
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setText("赠送" + discountTypeBean.getRP_GiveMoney() + "元");
                                et_recharge_total.setText(
                                        CommonUtils.add(discountTypeBean.getRP_RechargeMoney(), discountTypeBean.getRP_GiveMoney()) + "");
                                et_recharge_integral.setText(discountTypeBean.getRP_GivePoint() + "");

                                bgFrameLayout.setFocusable(true);
                                bgFrameLayout.setFocusableInTouchMode(true);
                                bgFrameLayout.requestFocus();
                                bgFrameLayout.requestFocusFromTouch();
                            }
                        });
                    }
                }
                View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_recharge_amount, null);
                ed_RechargeMoney = view.findViewById(R.id.ed_RechargeMoney);
                ed_RechargeMoney.setVisibility(View.VISIBLE);
                ed_RechargeMoney.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if (b) {
                            if (frameLayout != null) {
                                frameLayout.setSolidColor(0xffffffff);
                                ((TextView) frameLayout.findViewById(R.id.tv_RechargeMoney))
                                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                                String str = "赠送<font color=\"#ff0000\">" + (String) frameLayout.findViewById(R.id.tv_RP_GiveMoney).getTag() + "</font>元";
                                ((TextView) frameLayout.findViewById(R.id.tv_RP_GiveMoney))
                                        .setText(Html.fromHtml(str));
                            }
                            et_recharge_total.setText("");
                            et_recharge_integral.setText("");
                        }
                    }
                });
                ed_RechargeMoney.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        et_recharge_total.setText(editable);
                    }
                });
                fl_recharge_amount.addView(view);
            }
        });
    }
}

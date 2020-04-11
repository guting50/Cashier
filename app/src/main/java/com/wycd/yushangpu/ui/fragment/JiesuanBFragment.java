package com.wycd.yushangpu.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.SmsSwitch;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOrderPay;
import com.wycd.yushangpu.model.ImpPreLoading;
import com.wycd.yushangpu.model.ImpSaoma;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.tools.YSLUtils;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;
import com.wycd.yushangpu.widget.dialog.LoadingDialog;
import com.wycd.yushangpu.widget.dialog.PromotionDialog;
import com.wycd.yushangpu.widget.dialog.SaomaDialog;
import com.wycd.yushangpu.widget.dialog.YouhuiquanDialog;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.wycd.yushangpu.MyApplication.shortMessage;

public class JiesuanBFragment extends Fragment {

    private List<ShopMsg> list;
    private AppCompatActivity context;

    @BindView(R.id.et_ys_money)
    TextView mEtYsMoney;
    @BindView(R.id.tv_all_coupon_money)
    TextView tvAllCouponMoney;
    @BindView(R.id.tv_coupon_money)
    TextView tvCouponMoney;
    @BindView(R.id.tv_promotion)
    TextView tvPromotion;
    @BindView(R.id.tv_zhaoling)
    TextView tv_zhaoling;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.cb_small_ticket)
    CheckBox cbSmallTicket;
    @BindView(R.id.cb_short_message)
    CheckBox cbMessage;

    @BindView(R.id.et_moling)
    NumInputView et_moling;

    @BindView(R.id.li_xianjin)
    LinearLayout mLiXianjin;
    @BindView(R.id.li_yue)
    LinearLayout mLiYue;
    @BindView(R.id.li_saoma)
    LinearLayout mLiSaoma;
    @BindView(R.id.li_ali)
    LinearLayout mLiAli;
    @BindView(R.id.li_wx)
    LinearLayout mLiWx;
    @BindView(R.id.li_yinlian)
    LinearLayout mLiYinlian;
    @BindView(R.id.li_jifen)
    LinearLayout mLiJifen;
    @BindView(R.id.li_qita)
    LinearLayout li_qita;

    @BindView(R.id.iv_viptx)
    CircleImageView mIvViptx;
    @BindView(R.id.tv_vipname)
    TextView mTvVipname;
    @BindView(R.id.tv_blance)
    TextView tvBlance;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.tv_bill_count)
    TextView tvBillCount;
    @BindView(R.id.li_jiesuan)
    FrameLayout li_jiesuan;
    @BindView(R.id.li_close)
    View liClose;
    @BindView(R.id.pay_mode_list)
    RecyclerView payModeListView;

    PayModeListAdapter payModeListAdapter;

    private boolean isInit;
    private InterfaceBack back;
    private List<PayTypeMsg> payModeList;
    private PayTypeMsg defaultMode;
    private boolean isMember;
    //            原价总金额，折后金额  , 总共优惠金额 ， 应收金额
    private String totalMoney, zhMoney, totalYhMoney, ysMoney;
    //                 订单号       订单GID  会员积分  会员积分可抵扣金额   余额
    private String CO_OrderCode, CO_Type, GID, jifen, dkmoney, yue;
    private OrderPayResult result;
    private String jifendkbfb;
    private String yuePayXz;
    private Dialog yhqDialog;
    private Dialog promotionDialog;
    private List<YhqMsg> yhqMsgs;
    private ReportMessageBean.ActiveBean promotionMsg;
    private OrderType orderType;
    private VipInfoMsg mVipMsg;
    private Dialog dialog;
    private double promotionMoney; // 优惠活动金额

    private int consumeCheck = 0;//1 余额消费密码验证 ；2 余额消费短信验证码验证
    private double yueMoney = 0;

    View rootView;
    NumKeyboardUtils numKeyboardUtils;

    public enum OrderType {
        CONSUM_ORDER, //商品消费订单
        CELERITY_ORDER, // 快速消费订单
        GUAZHANG_ORDER //挂账订单
    }

    public enum PayMode {
        XJZF("现金支付"),
        YEZF("余额支付"),
        YLZF("银联支付"),
        WXJZ("微信支付"),
        ZFBJZ("支付宝支付"),
        JFZF("积分支付"),
        SMZF("扫码支付"),
        QTZF("其它支付");

        private String str;

        PayMode(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_jiesuan_new, null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);

        numKeyboardUtils = new NumKeyboardUtils(getActivity(), rootView, et_moling);

        this.context = (AppCompatActivity) getActivity();

        setView();

        setCbShortMessage("011");
        dialog = LoadingDialog.loadingDialog(context, 1);
    }

    public void setData(String totalMoney, String money, VipInfoMsg vipMsg, String dkmoney,
                        String GID, String CO_Type, String CO_OrderCode, ArrayList<ShopMsg> list, PayTypeMsg moren, ArrayList<PayTypeMsg> paylist,
                        OrderType orderType, InterfaceBack back) {
        this.totalMoney = totalMoney;
        this.zhMoney = money;
        this.mVipMsg = vipMsg;
        this.dkmoney = dkmoney;
        this.GID = GID;
        this.CO_Type = CO_Type;
        this.CO_OrderCode = CO_OrderCode;
        this.list = list;
        this.defaultMode = moren;
        this.payModeList = paylist;
        this.orderType = orderType;
        this.back = back;
        if (isInit)
            updateData();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(totalMoney) && !isInit)
            updateData();
        isInit = true;
    }

    private void updateData() {
        et_moling.setText("");
        tv_zhaoling.setText("");
        tvCouponMoney.setText("");
        tvCouponMoney.setHint("请选择优惠券");
        tvPromotion.setText("");
        promotionMoney = 0;
        yhqMsgs = null;

        this.yue = "0.00";
        this.jifen = "0.00";
        this.isMember = false;

        Glide.with(context).load(R.mipmap.member_head_nohead).into(mIvViptx);
        mTvVipname.setText("散客");
        tvBlance.setText("余额:0.00");
        tvIntegral.setText("积分:0");
        cbSmallTicket.setChecked(MyApplication.PRINT_IS_OPEN);

        if (mVipMsg != null) {
            this.yue = mVipMsg.getMA_AvailableBalance() + "";
            this.jifen = mVipMsg.getMA_AvailableIntegral() + "";
            this.isMember = true;

            int couponCount = 0;
            Glide.with(context).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(
                    mVipMsg.getVIP_HeadImg()).toString())).error(R.mipmap.member_head_nohead).into(mIvViptx);
            mTvVipname.setText(NullUtils.noNullHandle(mVipMsg.getVIP_Name()).toString());
            tvBlance.setText("余额:" + StringUtil.twoNum(NullUtils.noNullHandle(mVipMsg.getMA_AvailableBalance()).toString()));
            tvIntegral.setText("积分:" + Double.parseDouble(NullUtils.noNullHandle(mVipMsg.getMA_AvailableIntegral()).toString()) + "");

            for (VipInfoMsg.CouponsListBean vipMsg : mVipMsg.getCouponsList()) {
                if (Double.parseDouble(zhMoney) >= vipMsg.getEC_Denomination()) {
                    couponCount++;
                }
            }
            tvCouponMoney.setHint("有" + couponCount + "张优惠券可用");
        }

        if (ImpPreLoading.REPORT_BEAN != null) {
            for (ReportMessageBean.ActiveBean active : ImpPreLoading.REPORT_BEAN.getActive()) {
                if (active.getRP_Type() != 1 && Double.parseDouble(zhMoney) >= active.getRP_RechargeMoney()) {
                    double temp = computePromotionMoney(active);
                    if (promotionMoney < temp) {
                        promotionMoney = temp;
                        promotionMsg = active;
                        tvPromotion.setText(promotionMsg.getRP_Name());
                    }
                }
            }
            for (ReportMessageBean.GetSysSwitchListBean bean : ImpPreLoading.REPORT_BEAN.getGetSysSwitchList()) {
                if (TextUtils.equals(bean.getSS_Code(), "204") && bean.getSS_State() == 1) {// 消费密码验证
                    consumeCheck = 1;
                } else if (TextUtils.equals(bean.getSS_Code(), "217") && bean.getSS_State() == 1) { //消费短信验证码验证
                    consumeCheck = 2;
                }
            }
        }

        String discount = CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(zhMoney)) + "";
        tvDiscount.setText(StringUtil.twoNum(discount));
        tvBillCount.setText(StringUtil.twoNum(totalMoney));

        setDefaultPayMode(defaultMode);
        resetPayModeList(payModeList);
        computeYsMoney();

        yhqDialog = YouhuiquanDialog.showDialog(context, zhMoney, mVipMsg, /*yhqMsgs*/null, 1, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                yhqMsgs = (List<YhqMsg>) response;
                yhqDialog.dismiss();
//                        if (yhqMsgs.size() <= 0) {
//                            return;
//                        }
                LogUtils.d("xxyhq", new Gson().toJson(yhqMsgs));

                double yhqmo = 0.0;
                for (YhqMsg yhqMsg : yhqMsgs) {
                    if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                        yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                    } else {
                        yhqmo = CommonUtils.add(yhqmo, CommonUtils.del(Double.parseDouble(zhMoney),
                                CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), zhMoney)));
                    }
                }
                tvCouponMoney.setText("抵扣金额：" + yhqmo);
                computeYsMoney();
            }

            @Override
            public void onErrorResponse(Object msg) {
                yhqDialog.dismiss();
            }
        });
        promotionDialog = PromotionDialog.showDialog(context, zhMoney, promotionMsg, 1, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                promotionDialog.dismiss();
                promotionMsg = (ReportMessageBean.ActiveBean) response;
                if (promotionMsg != null) {
                    tvPromotion.setText(promotionMsg.getRP_Name());
                    promotionMoney = computePromotionMoney(promotionMsg);
                } else {
                    promotionMoney = 0;
                    tvPromotion.setText("");
                }
                computeYsMoney();
            }

            @Override
            public void onErrorResponse(Object msg) {
                promotionDialog.dismiss();
            }
        });
    }

    @OnClick({R.id.jiesuan_layout,
            R.id.li_10, R.id.li_20, R.id.li_50, R.id.li_100, R.id.li_xianjin, R.id.li_yue, R.id.li_yinlian,
            R.id.li_wx, R.id.li_ali, R.id.li_yhq, R.id.li_promotion, R.id.li_jifen, R.id.li_saoma, R.id.li_qita})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiesuan_layout:
                break;
            case R.id.li_10:
                numKeyboardUtils.getEditView().addNum(10);
                break;
            case R.id.li_20:
                numKeyboardUtils.getEditView().addNum(20);
                break;
            case R.id.li_50:
                numKeyboardUtils.getEditView().addNum(50);
                break;
            case R.id.li_100:
                numKeyboardUtils.getEditView().addNum(100);
                break;
            case R.id.li_yhq:
                yhqDialog.show();
                break;
            case R.id.li_promotion:
                promotionDialog.show();
                break;
            case R.id.li_xianjin:
                resetPayBg(view, PayMode.XJZF.getStr());
                break;
            case R.id.li_yue:
                resetPayBg(view, PayMode.YEZF.getStr());
                break;
            case R.id.li_wx:
                resetPayBg(view, PayMode.WXJZ.getStr());
                break;
            case R.id.li_yinlian:
                resetPayBg(view, PayMode.YLZF.getStr());
                break;
            case R.id.li_ali:
                resetPayBg(view, PayMode.ZFBJZ.getStr());
                break;
            case R.id.li_jifen:
                resetPayBg(view, PayMode.JFZF.getStr());
                break;
            case R.id.li_qita:
                resetPayBg(view, PayMode.QTZF.getStr());
                break;
            case R.id.li_saoma:
                if (getZhaoling() < 0) {
                    if (MyApplication.loginBean.getShopList().get(0).getSaoBei_State() == 1) {
                        com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过,但未签署电子协议");
                        return;
                    }
                    if (MyApplication.loginBean.getShopList().get(0).getSaoBei_State() == 2) {
                        com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核驳回");
                        return;
                    }
                    if (MyApplication.loginBean.getShopList().get(0).getSaoBei_State() == 3) {
                        com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核中");
                        return;
                    }
                    if (MyApplication.loginBean.getShopList().get(0).getSaoBei_State() == 5) {
                        com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过且已签署电子协议");
                        return;
                    }

                    resetPayBg(view, PayMode.SMZF.getStr());
                }
                break;
        }
    }

    private void setView() {
        li_jiesuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                double xjPayMoney = 0;
                for (PayModeListAdapter.MyPayMode itemMode : payModeListAdapter.getData()) {
                    if (TextUtils.equals(itemMode.getPayName(), PayMode.XJZF.getStr())) {
                        xjPayMoney = itemMode.getValue();
                    }
                }
                if (getZhaoling() > 0 && getZhaoling() >= xjPayMoney) {
                    com.blankj.utilcode.util.ToastUtils.showShort("找零金额不能大于等于现金支付金额");
                } else if (getZhaoling() < 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("支付金额小于折后金额");
                } else {
                    //结算
                    obtainOrderPayResult();
                    if (consumeCheck > 0 && yueMoney > 0) {
                        switch (consumeCheck) {
                            case 1:
                                com.blankj.utilcode.util.ToastUtils.showShort("余额消费密码验证");
                                break;
                            case 2:
                                com.blankj.utilcode.util.ToastUtils.showShort("余额消费短信验证码验证");
                                break;
                        }
                        return;
                    }
                    orderPay();
                }
            }
        });

        liClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.onResponse(null);
            }
        });

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (back != null)
                    back.onResponse(null);
            }
        });

        et_moling.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                computeYsMoney();
            }
        });

        payModeListAdapter = new PayModeListAdapter();
        payModeListView.setLayoutManager(new LinearLayoutManager(getContext()));
        payModeListView.setAdapter(payModeListAdapter);
    }

    private void orderPay() {
        dialog.show();
        ImpOrderPay orderPay = new ImpOrderPay();
        orderPay.orderpay(context, GID, result, orderType, new InterfaceBack<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                back.onResponse(response);
            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });
    }

    private void obtainOrderPayResult() {
        shortMessage = cbMessage.isChecked();
        result = new OrderPayResult();
        //找零
        result.setGiveChange(getZhaoling());
        result.setPayTotalMoney(getPayTotal());
        List<PayType> typeList = payWay();
        result.setDisMoney(Double.parseDouble(ysMoney));
        result.setMolingMoney(getMoling());
        result.setPayTypeList(typeList);
        result.setPrint(cbSmallTicket.isChecked());
        result.setYhqList(yhqMsgs);
        result.setActive(promotionMsg);
    }

    private double computePromotionMoney(ReportMessageBean.ActiveBean active) {
        double temp = 0.0;
        double multiple = 1;
        if (active.getRP_ISDouble() > 0) {
            multiple = CommonUtils.div(Double.parseDouble(zhMoney), active.getRP_RechargeMoney(), 0, BigDecimal.ROUND_DOWN);
        }

        if (active.getRP_Discount() != -1) { // 折扣活动
            temp = CommonUtils.del(Double.parseDouble(zhMoney),
                    CommonUtils.multiply(zhMoney, CommonUtils.div(active.getRP_Discount(), 10, 2) + ""));
        }
        if (active.getRP_GiveMoney() != -1) { // 赠送活动
            temp = active.getRP_GiveMoney();
        }
        if (active.getRP_ReduceMoney() != -1) { // 满减活动
            temp = active.getRP_ReduceMoney();
        }

        temp = CommonUtils.multiply(temp + "", multiple + "");

        if (active.getRP_GiveMoney() != -1) // 如果是赠送活动，优惠金额设置为0
            temp = 0;
        return temp;
    }

    /**
     * 计算应收金额
     */
    private void computeYsMoney() {
        double payTotal = getPayTotal();
        double tempTotalYhMoney = CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(zhMoney));//折扣优惠
        tempTotalYhMoney = CommonUtils.add(tempTotalYhMoney, getCouponMoney()); // + 优惠券
        tempTotalYhMoney = CommonUtils.add(tempTotalYhMoney, promotionMoney); // + 优惠活动
        tempTotalYhMoney = CommonUtils.add(tempTotalYhMoney, getMoling());// + 抹零
        totalYhMoney = tempTotalYhMoney + "";

        tvAllCouponMoney.setText(StringUtil.twoNum(totalYhMoney));
        ysMoney = CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(totalYhMoney)) + "";
        mEtYsMoney.setText(StringUtil.twoNum(ysMoney));

        double zlMoney = CommonUtils.del(0, CommonUtils.del(Double.parseDouble(ysMoney), payTotal));
        tv_zhaoling.setText(StringUtil.twoNum(zlMoney + ""));
    }

    private double getMoling() {
        return et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
    }

    private double getCouponMoney() {
        if (!TextUtils.isEmpty(tvCouponMoney.getText())) {
            String[] strs = tvCouponMoney.getText().toString().split("：");
            return Double.parseDouble(strs[strs.length - 1]);
        }
        return 0.00;
    }

    private double getZhaoling() {
        return tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
    }

    private double getPayTotal() {
        double payTotal = 0.0;
        for (PayModeListAdapter.MyPayMode itemMode : payModeListAdapter.getData()) {
            payTotal = CommonUtils.add(payTotal, itemMode.getValue());
        }
        return payTotal;
    }

    /***
     * 判断支付是否开启
     * @param list
     */
    private void resetPayModeList(List<PayTypeMsg> list) {
        for (PayTypeMsg msg : list) {
            switch (NullUtils.noNullHandle(msg.getSS_Code()).toString()) {
                case "101"://现金
                    mLiXianjin.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        mLiXianjin.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiXianjin.setEnabled(false);
                    }
                    break;
                case "102"://余额
                    mLiYue.setEnabled(true);
                    if (msg.getSS_State() != 1 || !isMember) {
                        mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYue.setEnabled(false);
                    }
                    yuePayXz = NullUtils.noNullHandle(msg.getSS_Value()).toString();
                    break;
                case "103"://银联
                    mLiYinlian.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        mLiYinlian.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYinlian.setEnabled(false);
                    }
                    break;
                case "105"://微信
                    mLiWx.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        mLiWx.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiWx.setEnabled(false);
                    }
                    break;
                case "106"://支付宝
                    mLiAli.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        mLiAli.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiAli.setEnabled(false);
                    }
                    break;
                case "107"://积分支付
                    mLiJifen.setEnabled(true);
                    if (msg.getSS_State() != 1 || !isMember) {
                        mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiJifen.setEnabled(false);
                    }
                    jifendkbfb = NullUtils.noNullHandle(msg.getSS_Value()).toString();
                    break;
                case "111"://扫码支付
                    mLiSaoma.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        mLiSaoma.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiSaoma.setEnabled(false);
                    }
                    break;
                case "113"://其它支付
                    li_qita.setEnabled(true);
                    if (msg.getSS_State() != 1) {
                        li_qita.setBackgroundResource(R.drawable.shap_enable_not);
                        li_qita.setEnabled(false);
                    }
                    break;
            }
        }
    }

    /***
     * 设置默认支付
     * @param msg
     */
    private void setDefaultPayMode(PayTypeMsg msg) {
        payModeListAdapter.getData().clear();
        payModeListAdapter.notifyDataSetChanged();
        mLiXianjin.setTag(null);
        mLiXianjin.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiYue.setTag(null);
        mLiYue.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiWx.setTag(null);
        mLiWx.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiAli.setTag(null);
        mLiAli.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiJifen.setTag(null);
        mLiJifen.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiSaoma.setTag(null);
        mLiSaoma.setBackgroundResource(R.drawable.shap_jiesunnot);
        li_qita.setTag(null);
        li_qita.setBackgroundResource(R.drawable.shap_jiesunnot);

        String name = PayMode.XJZF.getStr();
        View view = mLiXianjin;
        switch (NullUtils.noNullHandle(msg.getSS_Value()).toString()) {
            case "XJZF"://现金
                view = mLiXianjin;
                name = PayMode.XJZF.getStr();
                break;
            case "YEZF"://余额
                if (isMember) {
                    view = mLiYue;
                    name = PayMode.YEZF.getStr();
                } else {
                    //默认余额支付时为非会员 改为默认现金支付
                    view = mLiXianjin;
                    name = PayMode.XJZF.getStr();
                }
                break;
            case "YLZF"://银联
                view = mLiYinlian;
                name = PayMode.YLZF.getStr();
                break;
            case "WXJZ"://微信
                view = mLiWx;
                name = PayMode.WXJZ.getStr();
                break;
            case "ZFBJZ"://支付宝
                view = mLiAli;
                name = PayMode.ZFBJZ.getStr();
                break;
            case "JFZF"://积分支付
                if (isMember) {
                    view = mLiJifen;
                    name = PayMode.JFZF.getStr();
                } else {
                    view = mLiXianjin;
                    name = PayMode.XJZF.getStr();
                }
                break;
            case "SMZF"://扫码支付
                view = mLiSaoma;
                name = PayMode.SMZF.getStr();
                break;
            case "QTZF"://其它支付
                view = li_qita;
                name = PayMode.QTZF.getStr();
                break;
        }

        view.setTag(true);
        view.setBackgroundResource(R.drawable.bg_edittext_focused);
        payModeListAdapter.addData(name);
    }

    private void resetPayBg(View view, String name) {
        resetPayBg(view, name, view.getTag() == null);
    }

    private void resetPayBg(View view, String name, boolean isAdd) {
        if (isAdd) {
            view.setTag(true);
            view.setBackgroundResource(R.drawable.bg_edittext_focused);
            payModeListAdapter.addData(name);
        } else {
            view.setTag(null);
            view.setBackgroundResource(R.drawable.shap_jiesunnot);
            for (PayModeListAdapter.MyPayMode payMode : payModeListAdapter.getData()) {
                if (TextUtils.equals(payMode.getPayName(), name)) {
                    payModeListAdapter.getData().remove(payMode);
                    computeYsMoney();
                    break;
                }
            }
        }
        payModeListAdapter.notifyDataSetChanged();
    }

    private List<PayType> payWay() {
        List<PayType> typeList = new ArrayList<>();
        for (PayTypeMsg m : payModeList) {
            for (PayModeListAdapter.MyPayMode payMode : payModeListAdapter.getData()) {
                PayType p = new PayType();
                String name = payMode.getPayName();
                double modeMoney = payMode.getValue();
                if (TextUtils.equals(name, PayMode.XJZF.getStr())
                        && m.getSS_Name().equals("现金支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("XJZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else if (TextUtils.equals(name, PayMode.YEZF.getStr())
                        && m.getSS_Name().equals("余额支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("YEZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                    if (modeMoney > 0) {
                        yueMoney = modeMoney;
                    }
                } else if (TextUtils.equals(name, PayMode.YLZF.getStr())
                        && m.getSS_Name().equals("银联支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("YLZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else if (TextUtils.equals(name, PayMode.WXJZ.getStr())
                        && m.getSS_Name().equals("微信记账")) {
                    p.setGID(new String[0]);
                    p.setPayCode("WX_JZ");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else if (TextUtils.equals(name, PayMode.ZFBJZ.getStr())
                        && m.getSS_Name().equals("支付宝记账")) {
                    p.setGID(new String[0]);
                    p.setPayCode("ZFB_JZ");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else if (TextUtils.equals(name, PayMode.JFZF.getStr())
                        && m.getSS_Name().equals("积分支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("JFZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    String jifenm = String.valueOf(modeMoney);
                    String jifennumber = CommonUtils.multiply(jifenm, TextUtils.isEmpty(jifendkbfb) ? "0" : jifendkbfb) + "";
                    p.setPayPoint(Double.parseDouble(jifennumber));
                } else if (TextUtils.equals(name, PayMode.QTZF.getStr())
                        && m.getSS_Name().equals("其他支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("QTZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else if (TextUtils.equals(name, PayMode.SMZF.getStr())
                        && m.getSS_Name().equals("扫码支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("SMZF");
                    p.setPayMoney(modeMoney);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                } else {
                    p = null;
                }
                if (p != null)
                    typeList.add(p);
            }
        }

        return typeList;
    }

    /**
     * @param code ,参照SmsSwitch实体类的值
     *             根据短信发送开关是否打开，设置checkbox
     */
    private void setCbShortMessage(String code) {
        try {
            SmsSwitch.DataBean smsSwitch = YSLUtils.getSmsSwitch(code);
            if (smsSwitch != null) {
                if (smsSwitch.getST_State() == null || !smsSwitch.getST_State().equals("1")) {
                    cbMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "发送短信未开启，请到PC端去开启", Toast.LENGTH_SHORT).show();
                            cbMessage.setChecked(false);
                        }
                    });
                } else {
                    cbMessage.setChecked(true);
                }
            } else {
                getSmsSet(code);
            }
        } catch (Exception e) {
            cbMessage.setVisibility(View.INVISIBLE);
            LogUtils.e("======== Error ========", e.getMessage());
        }
    }

    /**
     * 获取短信开关
     */
    private void getSmsSet(final String code) {
        AsyncHttpUtils.postHttp(HttpAPI.API().SMS_LIST, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                SmsSwitch bean = response.getData(SmsSwitch.class);
                for (int i = 0; i < bean.getData().size(); i++) {
                    if (bean.getData().get(i).getST_Code().equals(code)) {
                        if (bean.getData().get(i).getST_State() == null || !bean.getData().get(i).getST_State().equals("1")) {
                            cbMessage.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(context, "发送短信未开启，请到PC端去开启", Toast.LENGTH_SHORT).show();
                                    cbMessage.setChecked(false);
                                }
                            });
                        } else {
                            cbMessage.setChecked(true);
                        }
                    }
                }
                CacheData.saveObject("shortmessage", bean);//缓存短信开关到本地
            }
        });
    }

    /**
     * 打开扫码支付
     *
     * @param smPayMoney
     */
    Dialog saomaDialog;

    private void showSaomaDialog(final double smPayMoney) {
        if (mLiSaoma.getTag() != null && (saomaDialog == null || !saomaDialog.isShowing())) {
            saomaDialog = SaomaDialog.saomaDialog(context, smPayMoney + "", 1, new InterfaceBack() {
                @Override
                public void onResponse(Object response) {
                    obtainOrderPayResult();
                    ImpSaoma saoma = new ImpSaoma();
                    saoma.saomaPay(response.toString(), smPayMoney + "", GID, CO_OrderCode, result, new InterfaceBack<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("==========扫码支付成功 (免密) =============== ");
                            back.onResponse(response);
                            if (saomaDialog != null)
                                saomaDialog.dismiss();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            if (msg instanceof BaseRes) {
                                BaseRes baseRes = (BaseRes) msg;
                                if (("410004").equals(baseRes.getCode())) {
                                    Type type = new TypeToken<Map<String, Object>>() {
                                    }.getType();
                                    Map<String, Object> map = baseRes.getData(type);
                                    String gid = map.get("GID").toString();
                                    Timer timer = new Timer();
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    saoma.saomaPayQuery(gid, new InterfaceBack<BaseRes>() {
                                                        @Override
                                                        public void onResponse(BaseRes response) {
                                                            checkPayResult(response);
                                                        }

                                                        @Override
                                                        public void onErrorResponse(Object msg) {
                                                            if (msg instanceof BaseRes) {
                                                                checkPayResult((BaseRes) msg);
                                                            } else {
                                                                timer.cancel();
                                                                saomaPayError();
                                                            }
                                                        }

                                                        public void checkPayResult(BaseRes response) {
                                                            if (!("410004").equals(response.getCode())) {
                                                                timer.cancel();
                                                                if (response.isSuccess()) {
                                                                    System.out.println("==========扫码支付成功=============== ");
                                                                    Map<String, Object> map = response.getData(type);
                                                                    String Order_GID = map.get("Order_GID").toString();
                                                                    back.onResponse(Order_GID);
                                                                    if (saomaDialog != null)
                                                                        saomaDialog.dismiss();
                                                                } else {
                                                                    saomaPayError();
                                                                }
                                                            } else {
                                                                com.blankj.utilcode.util.ToastUtils.showShort("支付中");
                                                            }
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    }, 2000, 2000);
                                } else {
                                    saomaPayError();
                                }
                            } else {
                                saomaPayError();
                            }
                        }
                    });
                }

                @Override
                public void onErrorResponse(Object msg) {
                    resetPayBg(mLiSaoma, PayMode.SMZF.getStr(), false);
                }

                public void saomaPayError() {
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付失败");
                    resetPayBg(mLiSaoma, PayMode.SMZF.getStr(), false);
                    if (saomaDialog != null && saomaDialog.isShowing())
                        saomaDialog.dismiss();
                }
            });
        }
    }

    class PayModeListAdapter extends RecyclerView.Adapter {

        private MyPayMode currentSelectedPay;
        private List<MyPayMode> payModeList = new ArrayList<>();

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_pay_mode_input_layout, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyHolder myHolder = (MyHolder) holder;
            numKeyboardUtils.addEditView(myHolder.etValue);
            MyPayMode itemData = payModeList.get(position);
            myHolder.tvPayName.setText(itemData.getPayName());
            myHolder.etValue.setText(itemData.getValue() + "");
            myHolder.etValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        String name = myHolder.tvPayName.getText().toString();
                        String value = myHolder.etValue.getText().toString();
                        if (!TextUtils.equals(name, PayMode.XJZF.getStr())) {
                            if (getZhaoling() < 0) {
                                myHolder.etValue.setText(CommonUtils.add(Double.parseDouble(TextUtils.isEmpty(value) ? "0" : value), getZhaoling() * -1) + "");
                            } else {
                                myHolder.etValue.setText(CommonUtils.del(Double.parseDouble(TextUtils.isEmpty(value) ? "0" : value), getZhaoling()) + "");
                            }
                        }
                    }
                }
            });
            myHolder.etValue.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String name = myHolder.tvPayName.getText().toString();
                    double value = Double.parseDouble(TextUtils.isEmpty(s) ? "0" : s.toString());
                    if (TextUtils.equals(itemData.getPayName(), name)) {
                        if (itemData.getValue() != value) {
                            if (TextUtils.equals(name, PayMode.YEZF.getStr())) {
                                double yueLimit = CommonUtils.multiply(CommonUtils.div(ysMoney, TextUtils.isEmpty(yuePayXz) ? "0" : yuePayXz, 100000), 100);
                                if (value > yueLimit) {
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(yueLimit + ""));
                                    com.blankj.utilcode.util.ToastUtils.showShort("超过余额支付限制");
                                    return;
                                }
                                if (value > Double.parseDouble(yue)) {
                                    com.blankj.utilcode.util.ToastUtils.showShort("余额不足");
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(yue + ""));
                                    return;
                                }
                            }

                            if (TextUtils.equals(name, PayMode.JFZF.getStr())) {
                                if (value > Double.parseDouble(dkmoney)) {
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(dkmoney + ""));
                                    com.blankj.utilcode.util.ToastUtils.showShort("超过积分支付限制");
                                    return;
                                }
                                if (value > Double.parseDouble(jifen)) {
                                    com.blankj.utilcode.util.ToastUtils.showShort("积分不足");
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(jifen + ""));
                                    return;
                                }
                            }
                        }

                        if (TextUtils.equals(name, PayMode.SMZF.getStr()) && value > 0) {
                            showSaomaDialog(value);
                        }
                        itemData.setValue(value);
                        computeYsMoney();
                    }
                }
            });

            if (!payModeList.contains(currentSelectedPay)) {
                if (position == payModeList.size() - 1) {
                    myHolder.etValue.setFocusable(true);
                    myHolder.etValue.selectAll();
                }
            } else {
                if (TextUtils.equals(currentSelectedPay.getPayName(), itemData.getPayName())) {
                    myHolder.etValue.setFocusable(true);
                    myHolder.etValue.selectAll();
                }
            }
        }

        @Override
        public int getItemCount() {
            return payModeList.size();
        }

        public void addData(String name) {
            MyPayMode mode = new MyPayMode();
            mode.setPayName(name);
            currentSelectedPay = mode;
            payModeList.add(mode);
        }

        public List<MyPayMode> getData() {
            return payModeList;
        }

        class MyHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_pay_name)
            TextView tvPayName;
            @BindView(R.id.et_value)
            NumInputView etValue;
            View holderRootView;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                holderRootView = itemView;
            }
        }

        public class MyPayMode {
            private String payName;
            private double value;

            public String getPayName() {
                return payName;
            }

            public void setPayName(String payName) {
                this.payName = payName;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }
        }
    }
}

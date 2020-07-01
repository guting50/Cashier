package com.wycd.yushangpu.ui.fragment;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.GsonUtils;
import com.gt.utils.widget.BgTextView;
import com.gt.utils.widget.OnNoDoubleClickListener;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.OrderCanshu;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.bean.SmsSwitch;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.SysSwitchType;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.BasicEucalyptusPresnter;
import com.wycd.yushangpu.model.ImpOrderPay;
import com.wycd.yushangpu.model.ImpParamLoading;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.tools.YSLUtils;
import com.wycd.yushangpu.ui.Presentation.GuestShowPresentation;
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
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.wycd.yushangpu.MyApplication.shortMessage;
import static com.wycd.yushangpu.ui.fragment.JiesuanBFragment.OrderType.HYCZ;

public class JiesuanBFragment extends BaseFragment {

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
    @BindView(R.id.tv_moling)
    TextView tv_moling;

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
    BgTextView li_jiesuan;
    @BindView(R.id.li_close)
    View liClose;
    @BindView(R.id.pay_mode_list)
    RecyclerView payModeListView;
    @BindView(R.id.lz_layout)
    FrameLayout lzLayout;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;

    private PayModeListAdapter payModeListAdapter;

    private InterfaceBack back;
    private boolean isMember;
    //            原价总金额，折后金额  , 总共优惠金额 ， 应收金额
    private String totalMoney, zhMoney, totalYhMoney, ysMoney;
    //                 订单号       订单GID  会员积分  余额
    private String CO_OrderCode, GID, jifen, yue;
    private OrderPayResult result;
    private String jifendk, jinfenzfxz;
    private String yuePayXz;
    private Dialog yhqDialog;
    private Dialog promotionDialog;
    private List<YhqMsg> yhqMsgs;
    private ReportMessageBean.ActiveBean promotionMsg;
    private OrderType orderType;
    private VipInfoMsg mVipMsg;
    private Dialog dialog;
    private double promotionMoney, yueLimit, dkmoney; // 优惠活动金额 ,可用余额，积分可抵扣金额

    private int consumeCheck = 0;//1 余额消费密码验证 ；2 余额消费短信验证码验证
    private double yueMoney = 0;
    private int count = 60;

    private NumKeyboardUtils numKeyboardUtils;

    public enum OrderType {
        SPXF, //商品消费订单
        KSXF, // 快速消费订单
        GUAZHANG_ORDER, //挂账订单
        HYCZ,//会员充值
        HYKK,//新增会员
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

    @Override
    public int getContentView() {
        return R.layout.fragment_jiesuan;
    }

    @Override
    public void onCreated() {
        numKeyboardUtils = new NumKeyboardUtils(getActivity(), rootView, et_moling);
        this.context = (AppCompatActivity) getActivity();

        setView();
        dialog = LoadingDialog.loadingDialog(context, 1);
    }

    /**
     * @param totalMoney  合计
     * @param zhMoney     折后金额
     * @param vipMsg      会员对象
     * @param orderCanshu 提交订单后的订单参数
     * @param orderType   结算类型
     * @param back
     */
    public void setData(String totalMoney, String zhMoney, VipInfoMsg vipMsg, OrderCanshu orderCanshu,
                        OrderType orderType, InterfaceBack back) {
        this.totalMoney = totalMoney;
        this.zhMoney = zhMoney;
        this.mVipMsg = vipMsg;
        this.GID = orderCanshu.getGID();
        this.CO_OrderCode = orderCanshu.getCO_OrderCode();
        this.orderType = orderType;
        this.back = back;
        super.setData();
    }

    public void updateData() {
        homeActivity.dialog.dismiss();

        setCbShortMessage("011");

        et_moling.setText("");
        tv_moling.setText("");
        tv_zhaoling.setText("");
        tvCouponMoney.setText("");
        tvCouponMoney.setHint("请选择优惠券");
        tvPromotion.setText("");
        promotionMoney = 0;
        yhqMsgs = null;
        consumeCheck = 0;

        rootView.findViewById(R.id.li_yhq).setEnabled(true);
        rootView.findViewById(R.id.li_promotion).setEnabled(true);
        rootView.findViewById(R.id.li_moling).setEnabled(false);
        et_moling.setVisibility(View.GONE);

        this.yue = "0.00";
        this.jifen = "0.00";
        this.isMember = false;

        Glide.with(context).load(R.mipmap.member_head_nohead).into(mIvViptx);
        mTvVipname.setText("散客");
        tvBlance.setText("余额:0.00");
        tvIntegral.setText("积分:0");
        cbSmallTicket.setChecked(GetPrintSet.PRINT_IS_OPEN);

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
            if (orderType != HYCZ) // 会员充值不能使用优惠券
                tvCouponMoney.setHint("有" + couponCount + "张优惠券可用");
        }

        if (ImpParamLoading.REPORT_BEAN != null && ImpParamLoading.REPORT_BEAN != null) {
            if (orderType != HYCZ && ImpParamLoading.REPORT_BEAN.getActiveOth() != null)
                for (ReportMessageBean.ActiveBean active : ImpParamLoading.REPORT_BEAN.getActiveOth()) {
                    // 会员充值不能使用优惠活动
                    if (active.getRP_Type() != 1 && Double.parseDouble(zhMoney) >= active.getRP_RechargeMoney()) {
                        if (active.getRP_ValidType() == 4) {//生日当天使用
                            if (mVipMsg == null) {
                                continue;
                            }
                            if (!DateTimeUtil.isBirthday(mVipMsg.getVIP_Birthday(), mVipMsg.getVIP_IsLunarCalendar())) {
                                continue;
                            }
                        }
                        double temp = computePromotionMoney(active);
                        if (promotionMoney < temp) {
                            promotionMoney = temp;
                            promotionMsg = active;
                            tvPromotion.setText(promotionMsg.getRP_Name());
                        }
                    }
                }

            if (SysSwitchRes.getSwitch(SysSwitchType.T204.getV()).getSS_State() == 1) {// 消费密码验证
                consumeCheck = 1;
            } else if (SysSwitchRes.getSwitch(SysSwitchType.T217.getV()).getSS_State() == 1) { //消费短信验证码验证
                consumeCheck = 2;
            }
        }

        String discount = CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(zhMoney)) + "";
        tvDiscount.setText(StringUtil.twoNum(discount));
        tvBillCount.setText(StringUtil.twoNum(totalMoney));

        setDefaultPayMode(BasicEucalyptusPresnter.defaultMode);
        resetPayModeList();
        computeYsMoney();

        if (orderType == HYCZ) {// 会员充值不能使用优惠券\优惠活动\抹零
            rootView.findViewById(R.id.li_yhq).setEnabled(false);
            rootView.findViewById(R.id.li_promotion).setEnabled(false);
            et_moling.setVisibility(View.GONE);
            rootView.findViewById(R.id.li_moling).setEnabled(false);
        } else {
            if (SysSwitchRes.getSwitch(SysSwitchType.T801.getV()).getSS_State() == 1) {//自由抹零
                rootView.findViewById(R.id.li_moling).setEnabled(true);
                et_moling.setVisibility(View.VISIBLE);
            }
        }


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
                yhqDialog = YouhuiquanDialog.showDialog(context, zhMoney, mVipMsg, /*yhqMsgs*/null, new InterfaceBack() {
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
                yhqDialog.show();
                break;
            case R.id.li_promotion:
                promotionDialog = PromotionDialog.showDialog(context, zhMoney, promotionMsg, mVipMsg, new InterfaceBack() {
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
                        checkVerify();
                    } else
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

    private void checkVerify() {
        lzLayout.setVisibility(View.VISIBLE);
        EditText editText = lzLayout.findViewById(R.id.lz_edit_view);
        TextView getVipSmsVerify = lzLayout.findViewById(R.id.get_vip_sms_verify);
        ImageView ivChose = lzLayout.findViewById(R.id.iv_chose);
        lzLayout.setOnClickListener(new OnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {

            }
        });
        ivChose.setOnClickListener(new OnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                count = 0;
                lzLayout.setVisibility(View.GONE);
            }
        });
        switch (consumeCheck) {
            case 1:
                getVipSmsVerify.setVisibility(View.GONE);
                lzLayout.findViewById(R.id.ly_yz_ok).setOnClickListener(new OnNoDoubleClickListener() {
                    @Override
                    public void onNoDoubleClick(View v) {
                        if (TextUtils.isEmpty(editText.getText())) {
                            com.blankj.utilcode.util.ToastUtils.showShort("请输入密码");
                            return;
                        }
                        dialog.show();
                        RequestParams params = new RequestParams();
                        params.put("VCH_Card", mVipMsg.getVCH_Card());
                        params.put("VCH_Pwd", editText.getText().toString());
                        AsyncHttpUtils.postHttp(HttpAPI.API().PASSWORD_VERIFY, params, new CallBack() {
                            @Override
                            public void onResponse(BaseRes response) {
                                dialog.dismiss();
                                editText.setText("");
                                orderPay();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                dialog.dismiss();
                                com.blankj.utilcode.util.ToastUtils.showShort("密码错误");
                            }
                        });
                    }
                });
                break;
            case 2:
                getVipSmsVerify.setVisibility(View.VISIBLE);
                getVipSmsVerify.setOnClickListener(new OnNoDoubleClickListener() {
                    @Override
                    public void onNoDoubleClick(View v) {
                        if (v.getTag() != null) {
                            return;
                        }
                        if (TextUtils.isEmpty(mVipMsg.getVIP_CellPhone())) {
                            ToastUtils.showLong("没有会员手机号");
                            return;
                        }
                        RequestParams params = new RequestParams();
                        params.put("Phone", mVipMsg.getVIP_CellPhone());
                        AsyncHttpUtils.postHttp(HttpAPI.API().GET_VIP_SMS_VERIFY, params, new CallBack() {
                            @Override
                            public void onResponse(BaseRes response) {
                                v.setTag("isGet");
                                count = 60;
                                Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        if (count > 0) {
                                            count--;
                                        } else {
                                            v.setTag(null);
                                            timer.cancel();
                                        }
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                getVipSmsVerify.setText(count == 0 ? "获取验证码" : count + "秒后再试");
                                            }
                                        });
                                    }
                                }, 0, 1000);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                if (msg instanceof BaseRes && ((BaseRes) msg).getMsg().contains("BuySms")) {
                                    ToastUtils.showLong("短信余额不足，请前往后台充值");
                                }
                            }
                        });
                    }
                });
                lzLayout.findViewById(R.id.ly_yz_ok).setOnClickListener(new OnNoDoubleClickListener() {
                    @Override
                    public void onNoDoubleClick(View v) {
                        if (TextUtils.isEmpty(editText.getText())) {
                            com.blankj.utilcode.util.ToastUtils.showShort("请输入验证码");
                            return;
                        }
                        dialog.show();
                        RequestParams params = new RequestParams();
                        params.put("Phone", mVipMsg.getVIP_CellPhone());
                        params.put("Verify", editText.getText().toString());
                        AsyncHttpUtils.postHttp(HttpAPI.API().CHECK_VERIFY, params, new CallBack() {
                            @Override
                            public void onResponse(BaseRes response) {
                                dialog.dismiss();
                                editText.setText("");
                                orderPay();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                dialog.dismiss();
                                com.blankj.utilcode.util.ToastUtils.showShort("验证码错误");
                            }
                        });
                    }
                });
                break;
        }
    }

    private void orderPay() {
        dialog.show();
        ImpOrderPay orderPay = new ImpOrderPay();
        orderPay.orderpay(GID, result, orderType, new InterfaceBack<String>() {
            @Override
            public void onResponse(String response) {
                paySuccess();
                back.onResponse(response);
            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
                if (msg instanceof BaseRes && ((BaseRes) msg).getMsg().contains("BuySms")) {
                    ToastUtils.showLong("支付成功，但短信发送失败，企业短信库存不足");
                    paySuccess();
                    back.onResponse(((BaseRes) msg).getData());
                } else {
                    super.onErrorResponse(msg);
                }
            }
        });
    }

    private void obtainOrderPayResult() {
        yueMoney = 0;
        shortMessage = cbMessage.isChecked();
        result = new OrderPayResult();
        //找零
        result.setGiveChange(getZhaoling());
        result.setPayTotalMoney(getPayTotal());
        List<PayType> typeList = payWay();
        result.setDisMoney(Double.parseDouble(ysMoney));
        result.setMolingMoney(getMoling());
        result.setPayTypeList(typeList);
        result.setPrint(GetPrintSet.PRINT_IS_OPEN = cbSmallTicket.isChecked());
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
        double ysMoney_ = CommonUtils.del(Double.parseDouble(totalMoney), tempTotalYhMoney);
        if (SysSwitchRes.getSwitch(SysSwitchType.T802.getV()).getSS_State() == 1) {//四舍五入到“角”
            tv_moling.setText(StringUtil.twoNum(CommonUtils.del(ysMoney_, CommonUtils.div(ysMoney_, 1, 1, BigDecimal.ROUND_HALF_UP)) + ""));
        } else if (SysSwitchRes.getSwitch(SysSwitchType.T803.getV()).getSS_State() == 1) {//四舍五入到“元”
            tv_moling.setText(StringUtil.twoNum(CommonUtils.del(ysMoney_, CommonUtils.div(ysMoney_, 1, 0, BigDecimal.ROUND_HALF_UP)) + ""));
        } else if (SysSwitchRes.getSwitch(SysSwitchType.T804.getV()).getSS_State() == 1) {//直接舍弃“角”
            tv_moling.setText(StringUtil.twoNum(CommonUtils.del(ysMoney_, CommonUtils.div(ysMoney_, 1, 0, BigDecimal.ROUND_DOWN)) + ""));
        } else if (SysSwitchRes.getSwitch(SysSwitchType.T805.getV()).getSS_State() == 1) {//直接舍弃“分”
            tv_moling.setText(StringUtil.twoNum(CommonUtils.del(ysMoney_, CommonUtils.div(ysMoney_, 1, 1, BigDecimal.ROUND_DOWN)) + ""));
        }
        tempTotalYhMoney = CommonUtils.add(tempTotalYhMoney, getMoling());// + 抹零
        totalYhMoney = tempTotalYhMoney + "";

        tvAllCouponMoney.setText(StringUtil.twoNum(totalYhMoney));
        ysMoney = StringUtil.twoNum(CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(totalYhMoney)) + "");
        mEtYsMoney.setText(ysMoney);

        double zlMoney = CommonUtils.del(0, CommonUtils.del(Double.parseDouble(ysMoney), payTotal));
        tv_zhaoling.setText(StringUtil.twoNum(zlMoney + ""));
    }

    private double getMoling() {
        if (et_moling.getVisibility() == View.VISIBLE)
            return et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
        else
            return tv_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_moling.getText().toString());
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
     */
    private void resetPayModeList() {
        //现金
        mLiXianjin.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T101.getV()).getSS_State() != 1) {
            mLiXianjin.setBackgroundResource(R.drawable.shap_enable_not);
            mLiXianjin.setEnabled(false);
        }
        //余额
        mLiYue.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T102.getV()).getSS_State() != 1
                || !isMember || orderType == HYCZ) {
            mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
            mLiYue.setEnabled(false);
        }
        yuePayXz = NullUtils.noNullHandle(SysSwitchRes.getSwitch(SysSwitchType.T102.getV()).getSS_Value()).toString();
        //银联
        mLiYinlian.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T103.getV()).getSS_State() != 1) {
            mLiYinlian.setBackgroundResource(R.drawable.shap_enable_not);
            mLiYinlian.setEnabled(false);
        }
        //微信
        mLiWx.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T105.getV()).getSS_State() != 1) {
            mLiWx.setBackgroundResource(R.drawable.shap_enable_not);
            mLiWx.setEnabled(false);
        }
        //支付宝
        mLiAli.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T106.getV()).getSS_State() != 1) {
            mLiAli.setBackgroundResource(R.drawable.shap_enable_not);
            mLiAli.setEnabled(false);
        }
        //积分支付
        mLiJifen.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T107.getV()).getSS_State() != 1
                || !isMember || orderType == HYCZ) {
            mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
            mLiJifen.setEnabled(false);
        }
        jifendk = NullUtils.noNullHandle(SysSwitchRes.getSwitch(SysSwitchType.T107.getV()).getSS_Value()).toString();
        //积分支付限制
        jinfenzfxz = NullUtils.noNullHandle(SysSwitchRes.getSwitch(SysSwitchType.T109.getV()).getSS_Value()).toString();
        //扫码支付
        mLiSaoma.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T111.getV()).getSS_State() != 1) {
            mLiSaoma.setBackgroundResource(R.drawable.shap_enable_not);
            mLiSaoma.setEnabled(false);
        }
        //其它支付
        li_qita.setEnabled(true);
        if (SysSwitchRes.getSwitch(SysSwitchType.T113.getV()).getSS_State() != 1) {
            li_qita.setBackgroundResource(R.drawable.shap_enable_not);
            li_qita.setEnabled(false);
        }
    }

    /***
     * 设置默认支付
     * @param msg
     */
    private void setDefaultPayMode(SysSwitchRes msg) {
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
        if (msg != null)
            switch (NullUtils.noNullHandle(msg.getSS_Value()).toString()) {
                case "XJZF"://现金
                    view = mLiXianjin;
                    name = PayMode.XJZF.getStr();
                    break;
                case "YEZF"://余额
                    if (isMember && orderType != HYCZ) {
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
                    if (isMember && orderType != HYCZ) {
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
                if (payMode.getPayName().contains(name)) {
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
        for (PayModeListAdapter.MyPayMode payMode : payModeListAdapter.getData()) {
            PayType p = new PayType();
            String name = payMode.getPayName();
            double modeMoney = payMode.getValue();
            if (TextUtils.equals(name, PayMode.XJZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("XJZF");
                p.setPayMoney(modeMoney);
                p.setPayName("现金支付");
                p.setPayPoint(0.00);
            } else if (TextUtils.equals(name, PayMode.YEZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("YEZF");
                p.setPayMoney(modeMoney);
                p.setPayName("余额支付");
                p.setPayPoint(0.00);
                yueMoney = modeMoney;
            } else if (TextUtils.equals(name, PayMode.YLZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("YLZF");
                p.setPayMoney(modeMoney);
                p.setPayName("银联支付");
                p.setPayPoint(0.00);
            } else if (TextUtils.equals(name, PayMode.WXJZ.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("WX_JZ");
                p.setPayMoney(modeMoney);
                p.setPayName("微信记账");
                p.setPayPoint(0.00);
            } else if (TextUtils.equals(name, PayMode.ZFBJZ.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("ZFB_JZ");
                p.setPayMoney(modeMoney);
                p.setPayName("支付宝记账");
                p.setPayPoint(0.00);
            } else if (TextUtils.equals(name, PayMode.JFZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("JFZF");
                p.setPayMoney(modeMoney);
                p.setPayName("积分支付");
                String jifenm = String.valueOf(modeMoney);
                String jifennumber = CommonUtils.multiply(jifenm, TextUtils.isEmpty(jifendk) ? "0" : jifendk) + "";
                p.setPayPoint(Double.parseDouble(jifennumber));
            } else if (TextUtils.equals(name, PayMode.QTZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("QTZF");
                p.setPayMoney(modeMoney);
                p.setPayName("其他支付");
                p.setPayPoint(0.00);
            } else if (TextUtils.equals(name, PayMode.SMZF.getStr())) {
                p.setGID(new String[0]);
                p.setPayCode("SMZF");
                p.setPayMoney(modeMoney);
                p.setPayName("扫码支付");
                p.setPayPoint(0.00);
            } else {
                p = null;
            }
            if (p != null)
                typeList.add(p);
        }

        return typeList;
    }

    /**
     * @param code ,参照SmsSwitch实体类的值
     *             根据短信发送开关是否打开，设置checkbox
     */
    private void setCbShortMessage(String code) {
        try {
            SmsSwitch smsSwitch = YSLUtils.getSmsSwitch(code);
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
                Type type = new TypeToken<List<SmsSwitch>>() {
                }.getType();
                List<SmsSwitch> bean = response.getData(type);
                for (int i = 0; i < bean.size(); i++) {
                    if (bean.get(i).getST_Code().equals(code)) {
                        if (bean.get(i).getST_State() == null || !bean.get(i).getST_State().equals("1")) {
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
                CacheDoubleUtils.getInstance().put("shortmessage", GsonUtils.getGson().toJson(bean));
            }
        });
    }

    /**
     * 打开扫码支付
     *
     * @param smPayMoney
     */
    SaomaDialog saomaDialog;

    private void showSaomaDialog(final double smPayMoney) {
        if (mLiSaoma.getTag() != null && (saomaDialog == null || !saomaDialog.isShowing())) {
            saomaDialog = new SaomaDialog(context, smPayMoney + "", 1, new InterfaceBack() {

                @Override
                public void onResponse(Object response) {
                    homeActivity.dialog.show();
                    obtainOrderPayResult();
                    saomaDialog.saomaPay(response.toString(), smPayMoney + "", GID, CO_OrderCode, result,
                            orderType, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    paySuccess();
                                    saomaDialog.dismiss();
                                    back.onResponse(response);

                                    homeActivity.dialog.dismiss();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    if (msg == null) {
                                        msg = "扫码支付失败";
                                    }
                                    ToastUtils.showLong(msg.toString());
                                    resetPayBg(mLiSaoma, PayMode.SMZF.getStr(), false);
                                    if (saomaDialog != null && saomaDialog.isShowing())
                                        saomaDialog.dismiss();
                                    homeActivity.dialog.dismiss();
                                }
                            });
                }

                @Override
                public void onErrorResponse(Object msg) {
                    resetPayBg(mLiSaoma, PayMode.SMZF.getStr(), false);
                }
            });
        }
    }

    private void paySuccess() {
        homeActivity.imgPaySuccess.setVisibility(View.VISIBLE);
        GuestShowPresentation.playAudio();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                homeActivity.runOnUiThread(() -> homeActivity.imgPaySuccess.setVisibility(View.GONE));
            }
        }, 2000);
        dialog.dismiss();
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
            myHolder.payHint.setVisibility(View.GONE);
            myHolder.payHintIcon.setVisibility(View.GONE);
            myHolder.hintLayout.setVisibility(View.GONE);
            View.OnClickListener payHintListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myHolder.hintLayout.setVisibility(myHolder.hintLayout.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                    myHolder.hintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            myHolder.hintLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int[] intArray = new int[2];
                            nestedScrollView.getLocationOnScreen(intArray);
                            int nestedScrollViewTop = intArray[1];
                            myHolder.hintLayout.getLocationOnScreen(intArray);
                            int dy = intArray[1];
                            int distance = dy - nestedScrollViewTop;//必须算上nestedScrollView本身与屏幕的距离
                            nestedScrollView.fling(distance);//添加上这句滑动才有效
                            nestedScrollView.scrollBy(0, distance);
                        }
                    });
                }
            };
            if (TextUtils.equals(itemData.getPayName(), PayMode.YEZF.getStr())) {
                myHolder.hintText.setText("1.可用余额不得超过每单金额的" + yuePayXz + "%\n2.可用余额不得超过账户余额");
                yueLimit = CommonUtils.multiply(CommonUtils.div(ysMoney, 100 + "", 100000) + "",
                        TextUtils.isEmpty(yuePayXz) ? "0" : yuePayXz);
                yueLimit = yueLimit > Double.parseDouble(yue) ? Double.parseDouble(yue) : yueLimit;
                myHolder.payHint.setText("可用金额 " + yueLimit);
                myHolder.payHint.setVisibility(View.VISIBLE);
                myHolder.payHintIcon.setVisibility(View.VISIBLE);
                myHolder.payHint.setOnClickListener(payHintListener);
                myHolder.payHintIcon.setOnClickListener(payHintListener);
            } else if (TextUtils.equals(itemData.getPayName(), PayMode.JFZF.getStr())) {
                myHolder.hintText.setText("1." + jifendk + "抵扣1元\n2.积分支付不得超过剩余积分的" + jinfenzfxz + "%");
                //可抵扣金额 = 会员积分 / 积分抵扣百分比 * 积分支付限制百分比
                dkmoney = CommonUtils.div(CommonUtils.div(CommonUtils.multiply(jifen,
                        TextUtils.isEmpty(jinfenzfxz) ? "0" : jinfenzfxz), 100, 2),
                        Double.parseDouble(TextUtils.isEmpty(jifendk) ? "0" : jifendk), 2);//可抵扣金额
                myHolder.payHint.setText("可抵扣金额 " + dkmoney);
                myHolder.payHint.setVisibility(View.VISIBLE);
                myHolder.payHintIcon.setVisibility(View.VISIBLE);
                myHolder.payHint.setOnClickListener(payHintListener);
                myHolder.payHintIcon.setOnClickListener(payHintListener);
            }
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
                    if (name.contains(itemData.getPayName())) {
                        if (itemData.getValue() != value) {
                            if (name.contains(PayMode.YEZF.getStr())) {
                                if (value > yueLimit) {
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(yueLimit + ""));
//                                    ToastUtils.showLong("超过余额支付限制");
                                    return;
                                }
                            }

                            if (name.contains(PayMode.JFZF.getStr())) {
                                if (value > dkmoney) {
                                    myHolder.etValue.setText(StringUtil.onlyTwoNum(dkmoney + ""));
//                                    ToastUtils.showLong("超过积分支付限制");
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
            @BindView(R.id.pay_hint)
            TextView payHint;
            @BindView(R.id.pay_hint_icon)
            ImageView payHintIcon;
            @BindView(R.id.hint_layout)
            FrameLayout hintLayout;
            @BindView(R.id.hint_text)
            TextView hintText;
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

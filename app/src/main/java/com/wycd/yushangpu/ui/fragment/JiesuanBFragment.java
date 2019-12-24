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
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.SmsSwitch;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.model.ImpOrderPay;
import com.wycd.yushangpu.model.ImpSaoma;
import com.wycd.yushangpu.printutil.CallBack;
import com.wycd.yushangpu.printutil.CommonFun;
import com.wycd.yushangpu.printutil.HttpHelper;
import com.wycd.yushangpu.printutil.YSLUtils;
import com.wycd.yushangpu.printutil.bean.SPXF_Success_Bean;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;
import com.wycd.yushangpu.widget.dialog.LoadingDialog;
import com.wycd.yushangpu.widget.dialog.SaomaDialog;
import com.wycd.yushangpu.widget.dialog.YouhuiquanDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @BindView(R.id.et_zhmoney)
    TextView mEtZhmoney;
    @BindView(R.id.tv_coupon_money)
    TextView tvCouponMoney;
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

    @BindView(R.id.li_yhq)
    FrameLayout mLiYhq;

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
    List<Map<String, Double>> payModeList = new ArrayList<>();

    private InterfaceBack back;
    private List<PayTypeMsg> paylist;
    private PayTypeMsg moren;
    private boolean isMember;
    private String totalMoney, money, CO_OrderCode, CO_Type, GID, dkmoney, yue;//折扣金额 订单号 订单GID 会员积分  会员积分可抵扣金额   余额
    private OrderPayResult result;
    private String jifendkbfb;
    private String yuezfxz;
    private Dialog yhqdialog;
    private List<YhqMsg> yhqMsgs;
    private OrderType orderType;
    private VipDengjiMsg.DataBean mVipDengjiMsg;
    private VipDengjiMsg.DataBean mVipMsg;
    private Dialog dialog;

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

    public void setData(String totalMoney, String money, VipDengjiMsg.DataBean vipMsg, VipDengjiMsg.DataBean mVipDengjiMsg, String dkmoney,
                        String GID, String CO_Type, String CO_OrderCode, ArrayList<ShopMsg> list, PayTypeMsg moren, ArrayList<PayTypeMsg> paylist,
                        OrderType orderType, InterfaceBack back) {
        this.totalMoney = totalMoney;
        this.money = money;
        this.mVipMsg = vipMsg;
        this.mVipDengjiMsg = mVipDengjiMsg;
        this.dkmoney = dkmoney;
        this.GID = GID;
        this.CO_Type = CO_Type;
        this.CO_OrderCode = CO_OrderCode;
        this.list = list;
        this.moren = moren;
        this.paylist = paylist;
        this.orderType = orderType;
        this.back = back;
        if (this.isResumed())
            updateData();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(money))
            updateData();
    }

    private void updateData() {
        et_moling.setText("");
        tv_zhaoling.setText("");

        this.yue = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableBalance() + "";
        this.isMember = null == mVipMsg ? false : true;

        if (mVipDengjiMsg != null) {
            VolleyResponse.instance().getInternetImg(context, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(
                    mVipDengjiMsg.getVIP_HeadImg()).toString()), mIvViptx, R.mipmap.member_head_nohead);
            mTvVipname.setText(NullUtils.noNullHandle(mVipDengjiMsg.getVIP_Name()).toString());
            tvBlance.setText("余额:" + StringUtil.twoNum(NullUtils.noNullHandle(mVipDengjiMsg.getMA_AvailableBalance()).toString()));
            tvIntegral.setText("积分:" + Double.parseDouble(NullUtils.noNullHandle(mVipDengjiMsg.getMA_AvailableIntegral()).toString()) + "");
        } else if (mVipMsg != null) {
            VolleyResponse.instance().getInternetImg(context, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(
                    mVipMsg.getVIP_HeadImg()).toString()), mIvViptx, R.mipmap.member_head_nohead);
            mTvVipname.setText(NullUtils.noNullHandle(mVipMsg.getVIP_Name()).toString());
            tvBlance.setText("余额:" + StringUtil.twoNum(NullUtils.noNullHandle(mVipMsg.getMA_AvailableBalance()).toString()));
            tvIntegral.setText("积分:" + Double.parseDouble(NullUtils.noNullHandle(mVipMsg.getMA_AvailableIntegral()).toString()) + "");
        } else {
            Glide.with(context).load(R.mipmap.member_head_nohead).into(mIvViptx);
            mTvVipname.setText("散客");
            tvBlance.setText("余额:0.00");
            tvIntegral.setText("积分:0");
        }

        tvDiscount.setText(CommonUtils.del(Double.parseDouble(totalMoney), Double.parseDouble(money)) + "");
        tvBillCount.setText(StringUtil.twoNum(totalMoney));
        mEtZhmoney.setText(StringUtil.twoNum(money));
        LogUtils.d("xxxxxx", new Gson().toJson(moren));

        setMorenPay(moren);
        setPay(paylist);
        jisuanZhaolingMoney();
    }

    @OnClick({R.id.jiesuan_layout,
            R.id.li_10, R.id.li_20, R.id.li_50, R.id.li_100, R.id.li_xianjin, R.id.li_yue, R.id.li_yinlian,
            R.id.li_wx, R.id.li_ali, R.id.li_yhq, R.id.li_jifen, R.id.li_saoma, R.id.li_qita})
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
                yhqdialog = YouhuiquanDialog.yhqDialog(context, money, mVipDengjiMsg, yhqMsgs, 1, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        yhqMsgs = (List<YhqMsg>) response;
                        yhqdialog.dismiss();
                        if (yhqMsgs.size() <= 0) {
                            return;
                        }
                        LogUtils.d("xxyhq", new Gson().toJson(yhqMsgs));

                        double yhqmo = 0.0;
                        for (YhqMsg yhqMsg : yhqMsgs) {
                            if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                                yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                            } else {
                                yhqmo += CommonUtils.del(Double.parseDouble(money), Double.parseDouble(
                                        CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), money)));
                            }
                        }
                        tvCouponMoney.setText(yhqmo + "");
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        yhqdialog.dismiss();
                    }
                });
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
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 1) {
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过,但未签署电子协议");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 2) {
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核驳回");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 3) {
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核中");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 5) {
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过且已签署电子协议");
                    return;
                }

                resetPayBg(view, PayMode.SMZF.getStr());
                if (view.getTag() != null) {
                    SaomaDialog.saomaDialog(context, money, 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {

//                        dialog.show();
                            ImpSaoma saoma = new ImpSaoma();
                            obtainOrderPayResult();
                            saoma.saomaPay(context, response.toString(), money, GID, CO_OrderCode, result, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    System.out.println("==========扫一扫===22222============random:" + response.toString());
                                    jisuanZhaolingMoney();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    back.onResponse(msg);
                                }
                            });
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                }

                break;
        }
    }

    private void setView() {
        li_jiesuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                for (Map<String, Double> map : payModeList) {
                    for (String name : map.keySet()) {
                        if (TextUtils.equals(name, PayMode.XJZF.getStr())) {
                            if (getZhaoling() > Double.parseDouble(map.get(name).toString())) {
                                com.blankj.utilcode.util.ToastUtils.showShort("找零金额不能大于现金支付");
                                return;
                            }
                        }
                    }
                }

                System.out.println("============000=========");
                double yfmoney = CommonUtils.del(Double.parseDouble(money), getMoling()); //折后 - 抹零
                double ym = CommonUtils.del(yfmoney, getCouponMoney());//折后 - 抹零 - 优惠金额（应收）
                double xjm = CommonUtils.del(ym, getPayTotal());//折后 - 抹零 - 优惠金额 - 组合支付

                double zlmoney = CommonUtils.del(0, xjm);
                LogUtils.d("xxzhmoney", xjm + "");

                System.out.println("============3333=========");

                if (zlmoney < 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("支付金额小于折后金额");
                } else {
                    System.out.println("============4444=========");
                    //结算
                    obtainOrderPayResult();
                    System.out.println("============555=========");
                    dialog.show();
                    ImpOrderPay orderPay = new ImpOrderPay();
                    shortMessage = cbMessage.isChecked();
                    orderPay.orderpay(context, GID, result, orderType, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            System.out.println("============666=========" + response.toString());

                            String responseString = (String) response;
                            Gson gson = new Gson();
                            final SPXF_Success_Bean spxf_success_bean = gson.fromJson(responseString, SPXF_Success_Bean.class);
                            dialog.dismiss();
                            back.onResponse(spxf_success_bean.getData().getGID());
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            dialog.dismiss();
                        }
                    });
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
                jisuanZhaolingMoney();
            }
        });

        payModeListAdapter = new PayModeListAdapter();
        payModeListView.setLayoutManager(new LinearLayoutManager(getContext()));
        payModeListView.setAdapter(payModeListAdapter);
    }

    private void obtainOrderPayResult() {
        result = new OrderPayResult();
        //找零
        result.setGiveChange(getZhaoling());
        result.setPayTotalMoney(getCouponMoney() + getPayTotal());
        List<PayType> typeList = payWay();

//        if (getMoling() > 0) {
//            PayType p = new PayType();
//            p.setGID(new String[0]);
//            p.setPayCode("EZJZ");
//            p.setPayMoney(getMoling());
//            p.setPayName("抹零");
//            p.setPayPoint(0.00);
//            typeList.add(p);
//        }
        result.setDisMoney(Double.parseDouble(money) - getCouponMoney() - getMoling());
        result.setMolingMoney(getMoling());
        result.setPayTypeList(typeList);
        result.setPrint(cbSmallTicket.isChecked());
    }

    private void jisuanZhaolingMoney() {
        double payTotal = getPayTotal();
        double yfmoney = CommonUtils.del(Double.parseDouble(money), getMoling());

        double ym = CommonUtils.del(yfmoney, payTotal);

        double xjm = CommonUtils.del(ym, getCouponMoney());
        double zlmoney = CommonUtils.del(0, xjm);
        tv_zhaoling.setText(StringUtil.twoNum(zlmoney + ""));
    }

    private double getMoling() {
        return et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
    }

    private double getCouponMoney() {
        return tvCouponMoney.getText().toString().equals("") ? 0.00 : Double.parseDouble(tvCouponMoney.getText().toString());
    }

    private double getZhaoling() {
        return tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
    }

    private double getPayTotal() {
        double payTotal = 0.0;
        for (Map<String, Double> map : payModeList) {
            for (String name : map.keySet()) {
                String str = map.get(name).toString();
                Double value = Double.parseDouble(str);
                payTotal = CommonUtils.add(payTotal, value);
            }
        }
        return payTotal;
    }

    /***
     * 判断支付是否开启
     * @param list
     */
    private void setPay(List<PayTypeMsg> list) {
        for (PayTypeMsg msg : list) {
            switch (NullUtils.noNullHandle(msg.getSS_Code()).toString()) {
                case "101"://现金
                    if (msg.getSS_State() != 1) {
                        mLiXianjin.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiXianjin.setEnabled(false);
                    }
                    break;
                case "102"://余额
                    if (msg.getSS_State() != 1 || !isMember) {
                        mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYue.setEnabled(false);
                        yuezfxz = NullUtils.noNullHandle(msg.getSS_Value()).toString();
                    }
                    break;
                case "103"://银联
                    if (msg.getSS_State() != 1) {
                        mLiYinlian.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYinlian.setEnabled(false);
                    }
                    break;
                case "105"://微信
                    if (msg.getSS_State() != 1) {
                        mLiWx.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiWx.setEnabled(false);
                    }
                    break;
                case "106"://支付宝
                    if (msg.getSS_State() != 1) {
                        mLiAli.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiAli.setEnabled(false);
                    }
                    break;
                case "110"://优惠券
                    if (msg.getSS_State() != 1) {
                        mLiYhq.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYhq.setEnabled(false);
                    }
                    break;
                case "107"://积分支付
                    if (msg.getSS_State() != 1 || !isMember) {
                        mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiJifen.setEnabled(false);
                        jifendkbfb = NullUtils.noNullHandle(msg.getSS_Value()).toString();
                    }
                    break;
                case "111"://扫码支付
                    if (msg.getSS_State() != 1) {
                        mLiSaoma.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiSaoma.setEnabled(false);
                    }
                    break;
                case "113"://其它支付
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
    private void setMorenPay(PayTypeMsg msg) {
        payModeList.clear();
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
            case "YHQ"://优惠券
//                view = mLiYhq;
//                name = "优惠金额";
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
        Map<String, Double> map = new HashMap<>();
        map.put(name, 0.00);
        payModeList.add(map);
    }

    private void resetPayBg(View view, String name) {
        if (view.getTag() == null) {
            view.setTag(true);
            view.setBackgroundResource(R.drawable.bg_edittext_focused);
            Map<String, Double> map = new HashMap<>();
            map.put(name, 0.0);
            payModeList.add(map);
        } else {
            view.setTag(null);
            view.setBackgroundResource(R.drawable.shap_jiesunnot);
            for (Map map : payModeList) {
                if (map.containsKey(name)) {
                    payModeList.remove(map);
                    jisuanZhaolingMoney();
                    break;
                }
            }
        }
        payModeListAdapter.notifyDataSetChanged();
    }

    private List<PayType> payWay() {
        List<PayType> typeList = new ArrayList<>();
        for (PayTypeMsg m : paylist) {
            for (Map<String, Double> map : payModeList) {
                for (String name : map.keySet()) {
                    PayType p = new PayType();
                    double money = map.get(name);
                    if (TextUtils.equals(name, PayMode.XJZF.getStr())
                            && m.getSS_Name().equals("现金支付")) {
                        p.setGID(new String[0]);
                        p.setPayCode("XJZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else if (TextUtils.equals(name, PayMode.YEZF.getStr())
                            && m.getSS_Name().equals("余额支付")) {
                        p.setGID(new String[0]);
                        p.setPayCode("YEZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else if (TextUtils.equals(name, PayMode.YLZF.getStr())
                            && m.getSS_Name().equals("银联支付")) {
                        p.setGID(new String[0]);
                        p.setPayCode("YLZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else if (TextUtils.equals(name, PayMode.WXJZ.getStr())
                            && m.getSS_Name().equals("微信记账")) {
                        p.setGID(new String[0]);
                        p.setPayCode("WX_JZ");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else if (TextUtils.equals(name, PayMode.ZFBJZ.getStr())
                            && m.getSS_Name().equals("支付宝记账")) {
                        p.setGID(new String[0]);
                        p.setPayCode("ZFB_JZ");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else if (TextUtils.equals(name, PayMode.JFZF.getStr())
                            && m.getSS_Name().equals("积分支付")) {
                        p.setGID(new String[0]);
                        p.setPayCode("JFZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        String jifenm = String.valueOf(money);
                        String jifennumber = CommonUtils.multiply(jifenm, jifendkbfb);
                        p.setPayPoint(Double.parseDouble(jifennumber));
                    } else if (TextUtils.equals(name, PayMode.QTZF.getStr())
                            && m.getSS_Name().equals("其他支付")) {
                        p.setGID(new String[0]);
                        p.setPayCode("QTZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    } else {
                        p = null;
                    }
                    if (p != null)
                        typeList.add(p);
                }
            }

            PayType p = new PayType();
            if (m.getSS_Name().equals("优惠券")) {
                if (yhqMsgs != null) {
                    String[] yhq = new String[yhqMsgs.size()];
                    for (int i = 0; i < yhqMsgs.size(); i++) {
                        yhq[i] = yhqMsgs.get(i).getGID();
                    }
                    p.setGID(yhq);
                    p.setPayCode("YHJZF");
                    p.setPayMoney(getCouponMoney());
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                    typeList.add(p);
                }
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
        }
    }

    /**
     * 获取短信开关
     */
    private void getSmsSet(final String code) {
        HttpHelper.post(context, HttpAPI.API().SMS_LIST, new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                SmsSwitch bean = CommonFun.JsonToObj(responseString, SmsSwitch.class);
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

            @Override
            public void onFailure(String msg) {
            }
        });
    }

    class PayModeListAdapter extends RecyclerView.Adapter {

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
            Map<String, Double> map = payModeList.get(position);
            for (String name : map.keySet()) {
                myHolder.tvPayName.setText(name);
                myHolder.etValue.setText(map.get(name) + "");
            }
            myHolder.etValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        String name = myHolder.tvPayName.getText().toString();
                        String value = myHolder.etValue.getText().toString();
                        if (!TextUtils.equals(name, PayMode.XJZF.getStr())) {
                            if (getZhaoling() < 0) {
                                myHolder.etValue.setText(CommonUtils.add(Double.parseDouble(value), getZhaoling() * -1) + "");
                            } else {
                                myHolder.etValue.setText(CommonUtils.del(Double.parseDouble(value), getZhaoling()) + "");
                            }
                        }
                    }
                }
            });
            myHolder.etValue.addTextChangedListener(new TextWatcher() {
                CharSequence chat;

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    this.chat = s;
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!TextUtils.equals(s.toString(), chat)) {
                        String name = myHolder.tvPayName.getText().toString();
                        double value = 0.0;
                        for (String n : map.keySet()) {
                            value = Double.parseDouble(TextUtils.isEmpty(s) ? "0" : s.toString());
                            if (TextUtils.equals(n, name)) {
                                if (map.get(n) != value) {
                                    if (TextUtils.equals(name, PayMode.YEZF.getStr())) {
                                        if (value > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {
                                            myHolder.etValue.setText(StringUtil.onlytwoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
                                            com.blankj.utilcode.util.ToastUtils.showShort("超过余额支付限制");
                                            return;
                                        }

                                        if (TextUtils.equals(name, PayMode.YEZF.getStr())) {
                                            if (value > Double.parseDouble(yue)) {
                                                com.blankj.utilcode.util.ToastUtils.showShort("余额不足");
                                                myHolder.etValue.setText(StringUtil.onlytwoNum(yue + ""));
                                                return;
                                            }
                                        }
                                    }

                                    if (TextUtils.equals(name, PayMode.JFZF.getStr())) {
                                        if (value > Double.parseDouble(dkmoney)) {
                                            myHolder.etValue.setText(StringUtil.onlytwoNum(dkmoney + ""));
                                            com.blankj.utilcode.util.ToastUtils.showShort("超过积分支付限制");
                                            return;
                                        }
                                        if (TextUtils.equals(name, PayMode.JFZF.getStr())) {
                                            if (value > Double.parseDouble(dkmoney)) {
                                                com.blankj.utilcode.util.ToastUtils.showShort("积分不足");
                                                myHolder.etValue.setText(StringUtil.onlytwoNum(dkmoney + ""));
                                                return;
                                            }
                                        }
                                    }
                                }
                                map.put(name, value);
                                jisuanZhaolingMoney();
                            }
                        }
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return payModeList.size();
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
    }
}

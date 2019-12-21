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
    @BindView(R.id.et_yue)
    TextView mEtYue;
    @BindView(R.id.tv_zhaoling)
    TextView tv_zhaoling;

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
    @BindView(R.id.cb_short_message)
    CheckBox cbMessage;
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
    private boolean isxianjinpay = true, isyuepay = true, isYinlianpay = true, iswxpay = true, isalipay = true, isyhqpay = true, isjfpay = true, issmpay = true, isqtpay = true;
    private String money, CO_OrderCode, CO_Type, GID, jifen, dkmoney, yue;//折扣金额 订单号 订单GID 会员积分  会员积分可抵扣金额   余额
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
        handleZhaoling();

        setCbShortMessage("011");
        dialog = LoadingDialog.loadingDialog(context, 1);

        payModeListAdapter = new PayModeListAdapter();
        payModeListView.setLayoutManager(new LinearLayoutManager(getContext()));
        payModeListView.setAdapter(payModeListAdapter);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (back != null)
                    back.onResponse(null);
            }
        });
    }

    public enum OrderType {
        CONSUM_ORDER, //商品消费订单
        CELERITY_ORDER, // 快速消费订单
        GUAZHANG_ORDER //挂账订单
    }

    public void setData(String money, VipDengjiMsg.DataBean vipMsg, VipDengjiMsg.DataBean mVipDengjiMsg, String dkmoney,
                        String GID, String CO_Type, String CO_OrderCode, ArrayList<ShopMsg> list, PayTypeMsg moren, ArrayList<PayTypeMsg> paylist,
                        OrderType orderType, InterfaceBack back) {
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

        this.jifen = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableIntegral() + "";
        this.yue = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableBalance() + "";
        this.isMember = null == mVipMsg ? false : true;

        for (PayTypeMsg m : paylist) {
            if (m.getSS_Name().equals("积分支付")) {
                jifendkbfb = NullUtils.noNullHandle(m.getSS_Value()).toString();
            }
            if (m.getSS_Name().equals("余额支付")) {
                yuezfxz = NullUtils.noNullHandle(m.getSS_Value()).toString();
            }
        }
        setPay(paylist);

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

        tvBillCount.setText(StringUtil.twoNum(money));
        mEtZhmoney.setText(StringUtil.twoNum(money));
        LogUtils.d("xxxxxx", new Gson().toJson(moren));
        setMorenPay(moren);
    }

    @OnClick({R.id.jiesuan_layout,
            R.id.li_10, R.id.li_20, R.id.li_50, R.id.li_100, R.id.li_xianjin, R.id.li_yue, R.id.li_yinlian,
            R.id.li_wx, R.id.li_ali, R.id.li_yhq, R.id.li_jifen, R.id.li_saoma, R.id.li_qita})
    public void onViewClicked(View view) {
        double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
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
            case R.id.li_xianjin:
                resetPayBg(view, "现金支付");
                break;
            case R.id.li_yue:
                resetPayBg(view, "余额支付");
                break;
            case R.id.li_wx:
                resetPayBg(view, "微信支付");
                break;
            case R.id.li_yinlian:
                resetPayBg(view, "银联支付");
                break;
            case R.id.li_ali:
                resetPayBg(view, "支付宝支付");
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
                        mEtYue.setText(yhqmo + "");
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        yhqdialog.dismiss();
                    }
                });
                break;
            case R.id.li_jifen:
                resetPayBg(view, "积分支付");
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
                resetPayBg(view, "扫码");

                if (view.getTag() == null) {
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
            case R.id.li_qita:
                resetPayBg(view, "其他");
                break;
        }
    }

    private void setView() {
        li_jiesuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //优惠金额
                double yuemoney = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());
                //找零
                double zhaoling = tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
                //抹零
                double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());

                double payTotal = 0.0;
                for (Map<String, Double> map : payModeList) {
                    for (String name : map.keySet()) {
                        String str = map.get(name).toString();
                        if (!StringUtil.isTwoPoint(str)) {
                            com.blankj.utilcode.util.ToastUtils.showShort("只能输入两位小数");
                            return;
                        }
                        Double value = Double.parseDouble(str);
                        if (TextUtils.equals(name, "余额支付")) {
                            if (value > Double.parseDouble(yue)) {
                                com.blankj.utilcode.util.ToastUtils.showShort("余额不足");
                                return;
                            }
                        }
                        if (TextUtils.equals(name, "积分支付")) {
                            if (value > Double.parseDouble(dkmoney)) {
                                com.blankj.utilcode.util.ToastUtils.showShort("积分不足");
                                return;
                            }
                        }
                        if (TextUtils.equals(name, "现金支付")) {
                            if (zhaoling > value) {
                                com.blankj.utilcode.util.ToastUtils.showShort("找零金额不能大于现金支付");
                                return;
                            }
                        }
                        payTotal = CommonUtils.add(payTotal, value);
                    }
                }

                System.out.println("============000=========");
                double zhmoney = Double.parseDouble(money);//应收(折后)
                double yfmoney = CommonUtils.del(zhmoney, molingmoney); //应收 - 抹零
                double ym = CommonUtils.del(yfmoney, yuemoney);//应收 - 抹零 - 优惠金额
                double xjm = CommonUtils.del(ym, payTotal);//应收 - 抹零 - 优惠金额 - 组合支付

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

        liClose.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                back.onResponse(null);
            }
        });
    }

    private void handleZhaoling() {
//        mEtXianjin.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
//                if (s.toString().contains(".")) {
//                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
//                        s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
//                        mEtXianjin.setText(s.toString());
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (editable.toString().equals("")) {
//                    tv_zhaoling.setText("0.00");
//                }
//                if (!editable.toString().equals("") && tvPayname1.getText().toString().equals("余额支付") &&
//                        Double.parseDouble(editable.toString()) > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {
//
//                    mEtXianjin.setText(StringUtil.onlytwoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
////                    ToastUtils.showToast(context,"超过余额支付限制");
//                    com.blankj.utilcode.util.ToastUtils.showShort("超过余额支付限制");
//                    return;
//                }
//
//                if (!editable.toString().equals("") && tvPayname1.getText().toString().equals("积分支付") &&
//                        Double.parseDouble(editable.toString()) > Double.parseDouble(dkmoney)) {
//                    mEtXianjin.setText(StringUtil.onlytwoNum(dkmoney + ""));
////                    ToastUtils.showToast(context,"超过积分支付限制");
//                    com.blankj.utilcode.util.ToastUtils.showShort("超过积分支付限制");
//                    return;
//                }
//
//                jisuanZhaolingMoney();
//            }
//        });
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
    }

    private void obtainOrderPayResult() {
        result = new OrderPayResult();
        //折后金额
        result.setDisMoney(Double.parseDouble(money));
        //找零
        double zhaoling = tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
        result.setGiveChange(zhaoling);
        double yuemoney = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());
        double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
        result.setPayTotalMoney(yuemoney + getPayTotal());
        List<PayType> typeList = new ArrayList<>();

        for (Map<String, Double> map : payModeList) {
            for (String name : map.keySet()) {
                payWay(name, typeList, map.get(name));
            }
        }

        if (!et_moling.getText().toString().equals("")) {
            PayType p = new PayType();
            p.setGID(new String[0]);
            p.setPayCode("EZJZ");
            p.setPayMoney(molingmoney);
            p.setPayName("抹零");
            p.setPayPoint(0.00);
            typeList.add(p);
        }
        result.setPayTypeList(typeList);
    }

    private void jisuanZhaolingMoney() {
        double payTotal = getPayTotal();
        if (payTotal > 0) {
            double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
            double zhmoney = Double.parseDouble(money);
            double yfmoney = CommonUtils.del(zhmoney, molingmoney);

            double ym = CommonUtils.del(yfmoney, payTotal);

            double yuemoney = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());

            double xjm = CommonUtils.del(ym, yuemoney);
//            double smm = CommonUtils.del(xjm, saomamoney);
            double zlmoney = CommonUtils.del(0, xjm);
            tv_zhaoling.setText(StringUtil.twoNum(zlmoney + ""));
        }
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
                        isxianjinpay = false;
                    }
                    break;
                case "102"://余额
                    if (msg.getSS_State() != 1) {
                        mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYue.setEnabled(false);
                        isyuepay = false;
                    }
                    break;
                case "103"://银联
                    if (msg.getSS_State() != 1) {
                        mLiYinlian.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYinlian.setEnabled(false);
                        isYinlianpay = false;
                    }
                    break;
                case "105"://微信
                    if (msg.getSS_State() != 1) {
                        mLiWx.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiWx.setEnabled(false);
                        iswxpay = false;
                    }
                    break;
                case "106"://支付宝
                    if (msg.getSS_State() != 1) {
                        mLiAli.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiAli.setEnabled(false);
                        isalipay = false;
                    }
                    break;
                case "110"://优惠券
                    if (msg.getSS_State() != 1) {
                        mLiYhq.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiYhq.setEnabled(false);
                        isyhqpay = false;
                    }
                    break;
                case "107"://积分支付
                    if (msg.getSS_State() != 1) {
                        mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiJifen.setEnabled(false);
                        isjfpay = false;
                    }
                    break;
                case "111"://扫码支付
                    if (msg.getSS_State() != 1) {
                        mLiSaoma.setBackgroundResource(R.drawable.shap_enable_not);
                        mLiSaoma.setEnabled(false);
                        issmpay = false;
                    }
                    break;
                case "113"://其它支付
                    if (msg.getSS_State() != 1) {
                        li_qita.setBackgroundResource(R.drawable.shap_enable_not);
                        li_qita.setEnabled(false);
                        isqtpay = false;
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

        String name = "现金支付";
        View view = mLiXianjin;
        switch (NullUtils.noNullHandle(msg.getSS_Value()).toString()) {
            case "XJZF"://现金
                view = mLiXianjin;
                name = "现金支付";
                break;
            case "YEZF"://余额
                if (isMember) {
                    view = mLiYue;
                    name = "余额支付";
                } else {
                    //默认余额支付时为非会员 改为默认现金支付
                    view = mLiXianjin;
                    name = "现金支付";
                }
                break;
            case "YLZF"://银联
                view = mLiYinlian;
                name = "银联支付";
                break;
            case "WXJZ"://微信
                view = mLiWx;
                name = "微信支付";
                break;
            case "ZFBJZ"://支付宝
                view = mLiAli;
                name = "支付宝支付";
                break;
            case "YHQ"://优惠券
//                view = mLiYhq;
//                name = "优惠金额";
                break;
            case "JFZF"://积分支付
                if (isMember) {
                    view = mLiJifen;
                    name = "积分支付";
                } else {
                    view = mLiXianjin;
                    name = "现金支付";
                }
                break;
            case "SMZF"://扫码支付
                view = mLiSaoma;
                name = "扫码支付";
                break;
            case "QTZF"://其它支付
                view = li_qita;
                name = "其它支付";
                break;
        }

        view.setTag(true);
        view.setBackgroundResource(R.drawable.bg_edittext_focused);
        Map<String, Double> map = new HashMap<>();
        map.put(name, 0.00);
        payModeList.add(map);

        if (!isMember) {
            mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
            mLiJifen.setEnabled(false);
            mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
            mLiYue.setEnabled(false);
            isyuepay = false;
            isjfpay = false;
        }
    }

    private void resetPayBg(View view, String name) {
        if (view.getTag() == null) {
            view.setTag(true);
            view.setBackgroundResource(R.drawable.bg_edittext_focused);
            Map<String, Double> map = new HashMap<>();
            map.put(name, 0.00);
            payModeList.add(map);
        } else {
            view.setTag(null);
            view.setBackgroundResource(R.drawable.shap_jiesunnot);
            for (Map map : payModeList) {
                if (map.containsKey(name)) {
                    payModeList.remove(map);
                    break;
                }
            }
        }
        payModeListAdapter.notifyDataSetChanged();
    }

    private void payWay(String str, List<PayType> typeList, double money) {
        if (str.equals("现金支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("现金支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("XJZF");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
        if (str.equals("余额支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("余额支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("YEZF");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
        if (str.equals("银联支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("银联支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("YLZF");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
        if (str.equals("微信支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("微信记账")) {
                    p.setGID(new String[0]);
                    p.setPayCode("WX_JZ");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
        if (str.equals("支付宝支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("支付宝记账")) {
                    p.setGID(new String[0]);
                    p.setPayCode("ZFB_JZ");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
        if (str.equals("优惠金额")) {
            PayType p = new PayType();
            if (yhqMsgs != null) {
                for (PayTypeMsg m : paylist) {
                    if (m.getSS_Name().equals("优惠券")) {
                        String[] yhq = new String[yhqMsgs.size()];
                        for (int i = 0; i < yhqMsgs.size(); i++) {
                            yhq[i] = yhqMsgs.get(i).getGID();
                        }
                        p.setGID(yhq);
                        p.setPayCode("YHJZF");
                        p.setPayMoney(money);
                        p.setPayName(m.getSS_Name());
                        p.setPayPoint(0.00);
                    }
                }
            }
            typeList.add(p);
        }
        if (str.equals("积分支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("积分支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("JFZF");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    String jifenm = String.valueOf(money);
                    String jifennumber = CommonUtils.multiply(jifenm, jifendkbfb);
                    p.setPayPoint(Double.parseDouble(jifennumber));
                }
            }
            typeList.add(p);
        }
        if (str.equals("其他支付")) {
            PayType p = new PayType();
            for (PayTypeMsg m : paylist) {
                if (m.getSS_Name().equals("其他支付")) {
                    p.setGID(new String[0]);
                    p.setPayCode("QTZF");
                    p.setPayMoney(money);
                    p.setPayName(m.getSS_Name());
                    p.setPayPoint(0.00);
                }
            }
            typeList.add(p);
        }
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
            }
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

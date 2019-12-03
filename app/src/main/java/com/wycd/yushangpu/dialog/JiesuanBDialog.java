package com.wycd.yushangpu.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.bean.YhqMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOrderPay;
import com.wycd.yushangpu.model.ImpSaoma;
import com.wycd.yushangpu.printutil.bean.SPXF_Success_Bean;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.views.ClearEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class JiesuanBDialog extends Dialog {

    private InterfaceBack back;
    private List<ShopMsg> list;
    private Activity context;

    @BindView(R.id.iv_close)
    ImageView mIvClose;

    @BindView(R.id.et_zhmoney)
    TextView mEtZhmoney;
    @BindView(R.id.et_xianjin)
    ClearEditText mEtXianjin;
    @BindView(R.id.rl_xianjin)
    RelativeLayout mRlXianjin;
    @BindView(R.id.et_yue)
    ClearEditText mEtYue;
    @BindView(R.id.rl_yue)
    RelativeLayout mRlYue;
    @BindView(R.id.tv_zhaoling)
    TextView tv_zhaoling;
    @BindView(R.id.tv_payname_1)
    TextView tvPayname1;
    @BindView(R.id.tv_payname_2)
    TextView tvPayname2;

    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.li_1)
    LinearLayout mLi1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.li_2)
    LinearLayout mLi2;
    @BindView(R.id.tv_3)
    TextView mTv3;
    @BindView(R.id.li_3)
    LinearLayout mLi3;
    @BindView(R.id.et_moling)
    EditText et_moling;
    @BindView(R.id.tv_20)
    TextView mTv20;
    @BindView(R.id.li_20)
    RelativeLayout mLi20;

    @BindView(R.id.tv_4)
    TextView mTv4;
    @BindView(R.id.li_4)
    LinearLayout mLi4;
    @BindView(R.id.tv_5)
    TextView mTv5;
    @BindView(R.id.li_5)
    LinearLayout mLi5;
    @BindView(R.id.tv_6)
    TextView mTv6;
    @BindView(R.id.li_6)
    LinearLayout mLi6;
    @BindView(R.id.tv_50)
    TextView mTv50;
    @BindView(R.id.li_50)
    RelativeLayout mLi50;

    @BindView(R.id.tv_7)
    TextView mTv7;
    @BindView(R.id.li_7)
    LinearLayout mLi7;
    @BindView(R.id.tv_8)
    TextView mTv8;
    @BindView(R.id.li_8)
    LinearLayout mLi8;
    @BindView(R.id.tv_9)
    TextView mTv9;
    @BindView(R.id.li_9)
    LinearLayout mLi9;
    @BindView(R.id.tv_100)
    TextView mTv100;
    @BindView(R.id.li_100)
    RelativeLayout mLi100;

    @BindView(R.id.tv_0)
    TextView mTv0;
    @BindView(R.id.rl_moling)
    RelativeLayout rl_moling;
    @BindView(R.id.li_0)
    LinearLayout mLi0;
    @BindView(R.id.tv_dian)
    TextView mTvDian;
    @BindView(R.id.li_dian)
    LinearLayout mLiDian;
    @BindView(R.id.li_c)
    LinearLayout mLiC;
    @BindView(R.id.li_moling)
    RelativeLayout mLiMoling;

    @BindView(R.id.iv_xianjin)
    ImageView mIvXianjin;
    @BindView(R.id.tv_xianjin)
    TextView mTvXianjin;
    @BindView(R.id.li_xianjin)
    LinearLayout mLiXianjin;
    @BindView(R.id.iv_saoma)
    ImageView mIvSaoma;
    @BindView(R.id.tv_saoma)
    TextView mTvSaoma;
    @BindView(R.id.li_saoma)
    LinearLayout mLiSaoma;

    @BindView(R.id.iv_yue)
    ImageView mIvYue;
    @BindView(R.id.tv_yue)
    TextView mTvYue;
    @BindView(R.id.li_yue)
    LinearLayout mLiYue;
    @BindView(R.id.iv_ali)
    ImageView mIvAli;
    @BindView(R.id.tv_ali)
    TextView mTvAli;
    @BindView(R.id.li_ali)
    LinearLayout mLiAli;
    @BindView(R.id.iv_wx)
    ImageView mIvWx;
    @BindView(R.id.tv_wx)
    TextView mTvWx;
    @BindView(R.id.li_wx)
    LinearLayout mLiWx;
    @BindView(R.id.iv_yinlian)
    ImageView mIvYinlian;
    @BindView(R.id.tv_yinlian)
    TextView mTvYinlian;
    @BindView(R.id.li_yinlian)
    LinearLayout mLiYinlian;

    @BindView(R.id.iv_jifen)
    ImageView mIvJifen;
    @BindView(R.id.tv_jifen)
    TextView mTvJifen;
    @BindView(R.id.li_jifen)
    LinearLayout mLiJifen;
    @BindView(R.id.iv_yhq)
    ImageView mIvYhq;
    @BindView(R.id.tv_yhq)
    TextView mTvYhq;
    @BindView(R.id.li_yhq)
    LinearLayout mLiYhq;
    @BindView(R.id.iv_qita)
    ImageView mIvQita;
    @BindView(R.id.tv_qita)
    TextView mTvQita;
    @BindView(R.id.li_qita)
    LinearLayout li_qita;
    @BindView(R.id.iv_union)
    ImageView ivUnion;
    @BindView(R.id.tv_union)
    TextView tvUnion;
    @BindView(R.id.li_union)
    LinearLayout liUnion;


    @BindView(R.id.li_jiesuan)
    LinearLayout li_jiesuan;
    private PayTypeMsg moren;//默认支付
    private List<PayTypeMsg> paylist;
    private Dialog dialog;
    private boolean isMember;
    private boolean isxianjinpay = true, isyuepay = true, isYinlianpay = true, iswxpay = true, isalipay = true, isyhqpay = true, isjfpay = true, issmpay = true, isqtpay = true;
    private boolean isXianjin = false, isYue = false, isYinlian = false, isWx = false, isAli = false, isYhq = false, isJifen = false, isSaoma = false, isQita = false, isUnion = false, isMoling = false;
    private String money, CO_OrderCode, CO_Type, GID, jifen, dkmoney, yue;//折扣金额 订单号 订单GID 会员积分  会员积分可抵扣金额   余额
    private OrderPayResult result;
    private String jifendkbfb;
    private String yuezfxz;
    private Dialog yhqdialog;
    private List<YhqMsg> yhqMsgs;
    private boolean isguazhang;
    private VipDengjiMsg.DataBean mVipDengjiMsg;
    private double moneyFlag;

    public JiesuanBDialog(Activity context, String money, String yue, String jifen, VipDengjiMsg.DataBean mVipDengjiMsg, String dkmoney, boolean ismember,
                          String GID, String CO_Type, String CO_OrderCode, final List<ShopMsg> list, PayTypeMsg moren, List<PayTypeMsg> paylist, boolean isguazhang, final InterfaceBack back) {
        super(context, R.style.ActionSheetDialogStyle);
        this.back = back;
        this.list = list;
        this.context = context;
        this.moren = moren;
        this.paylist = paylist;
        this.money = money;
        this.GID = GID;
        this.CO_OrderCode = CO_OrderCode;
        this.CO_Type = CO_Type;
        this.jifen = jifen;
        this.yue = yue;
        this.mVipDengjiMsg = mVipDengjiMsg;
        this.dkmoney = dkmoney;
        this.isMember = ismember;
        this.isguazhang = isguazhang;
        dialog = LoadingDialog.loadingDialog(context, 1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_jiesuan_new);
        ButterKnife.bind(this);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        for (PayTypeMsg m : paylist) {
            if (m.getSS_Name().equals("积分支付")) {
                jifendkbfb = NullUtils.noNullHandle(m.getSS_Value()).toString();
            }
            if (m.getSS_Name().equals("余额支付")) {
                yuezfxz = NullUtils.noNullHandle(m.getSS_Value()).toString();
            }

        }
        setView();
        handleZhaoling();

    }

    private void fullScreenImmersive(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }


    private void handleZhaoling() {
        mEtXianjin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
                        mEtXianjin.setText(s);
                        mEtXianjin.setSelection(s.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")) {
                    tv_zhaoling.setText("0.00");
                }
                if (!editable.toString().equals("") && tvPayname1.getText().toString().equals("余额支付") && Double.parseDouble(editable.toString()) > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {

                    mEtXianjin.setText(StringUtil.onlytwoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
//                    ToastUtils.showToast(context,"超过余额支付限制");
                    com.blankj.utilcode.util.ToastUtils.showShort("超过余额支付限制");
                    return;
                }

                if (!editable.toString().equals("") && tvPayname1.getText().toString().equals("积分支付") && Double.parseDouble(editable.toString()) > Double.parseDouble(dkmoney)) {
                    mEtXianjin.setText(StringUtil.onlytwoNum(dkmoney + ""));
//                    ToastUtils.showToast(context,"超过积分支付限制");
                    com.blankj.utilcode.util.ToastUtils.showShort("超过积分支付限制");
                    return;
                }

                jisuanZhaolingMoney();
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
//        mEtYue.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                jisuanZhaolingMoney();
//            }
//        });


    }

    private void setView() {

        //优惠金额不编辑
        mEtYue.setFocusable(false);
        mEtYue.setFocusableInTouchMode(false);

        mEtZhmoney.setText(StringUtil.twoNum(money));
        LogUtils.d("xxxxxx", new Gson().toJson(moren));
        setPay(paylist);
        setMorenPay(moren);

        li_jiesuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                double xianjinzhifu = 0.00;

                double xianjin = mEtXianjin.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtXianjin.getText().toString());
                double yuemoney = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());
                //找零
                double zhaoling = tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
                double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());

                if (tvPayname1.getText().toString().equals("现金支付")) {
                    xianjinzhifu = xianjin;
                } else if (tvPayname2.getText().toString().equals("现金支付")) {
                    xianjinzhifu = yuemoney;
                }
                if (!StringUtil.isTwoPoint(mEtXianjin.getText().toString())) {
//                    ToastUtils.showToast(context, "只能输入两位小数");
                    com.blankj.utilcode.util.ToastUtils.showShort("只能输入两位小数");
                } else if (tvPayname1.getText().toString().equals("余额支付") && xianjin > Double.parseDouble(yue)) {
//                    ToastUtils.showToast(context, "余额不足");
                    com.blankj.utilcode.util.ToastUtils.showShort("余额不足");
                } else if (tvPayname2.getText().toString().equals("余额支付") && yuemoney > Double.parseDouble(yue)) {
//                    ToastUtils.showToast(context, "余额不足");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                } else if (tvPayname1.getText().toString().equals("积分支付") && xianjin > Double.parseDouble(dkmoney)) {
//                    ToastUtils.showToast(context, "积分不足");
                    com.blankj.utilcode.util.ToastUtils.showShort("积分不足");
                } else if (tvPayname2.getText().toString().equals("积分支付") && yuemoney > Double.parseDouble(dkmoney)) {
//                    ToastUtils.showToast(context, "积分不足");
                    com.blankj.utilcode.util.ToastUtils.showShort("积分不足");
                } else if (zhaoling > xianjinzhifu) {
//                    ToastUtils.showToast(context, "找零金额不能大于现金支付");
                    com.blankj.utilcode.util.ToastUtils.showShort("找零金额不能大于现金支付");
                } else {
                    System.out.println("============000=========");
                    double zhmoney = Double.parseDouble(money);
                    double yfmoney = CommonUtils.del(zhmoney, molingmoney);

                    double ym = CommonUtils.del(yfmoney, yuemoney);

                    double xjm = CommonUtils.del(ym, xianjin);


                    double zlmoney = CommonUtils.del(0, xjm);
                    LogUtils.d("xxzhmoney", xjm + "");
                    if (mEtXianjin.getText().toString().equals("")) {
                        System.out.println("============111=========");
                        //无找零金额
                        if (xjm > 0) {
//                            ToastUtils.showToast(context, "小于折后金额");
                            com.blankj.utilcode.util.ToastUtils.showShort("小于折后金额");
                        } else if (xjm < 0) {
//                            ToastUtils.showToast(context, "大于折后金额");
                            com.blankj.utilcode.util.ToastUtils.showShort("大于折后金额");
                        } else {
                            System.out.println("============2222=========");
                            //结算
                            obtainOrderPayResult();
                            dialog.show();
                            ImpOrderPay orderPay = new ImpOrderPay();
                            orderPay.orderpay(context, GID, result, isguazhang, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    dialog.dismiss();
                                    dismiss();
                                    back.onResponse("");
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    } else {
                        System.out.println("============3333=========");
                        //有找零金额
//                        if (zlmoney > 0) {
////                            ToastUtils.showToast(context, "支付金额大于折后金额");
////                            com.blankj.utilcode.util.ToastUtils.showShort("支付金额大于折后金额");
//                        } else
                            if (zlmoney < 0) {
//                            ToastUtils.showToast(context, "支付金额小于折后金额");
                            com.blankj.utilcode.util.ToastUtils.showShort("支付金额小于折后金额");
                        } else {
                            System.out.println("============4444=========");
                            //结算
                            obtainOrderPayResult();
                            System.out.println("============555=========");
                            dialog.show();
                            ImpOrderPay orderPay = new ImpOrderPay();
                            orderPay.orderpay(context, GID, result, isguazhang, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    System.out.println("============666=========" + response.toString());

                                    String responseString = (String) response;
                                    Gson gson = new Gson();
                                    final SPXF_Success_Bean spxf_success_bean = gson.fromJson(responseString, SPXF_Success_Bean.class);
                                    dialog.dismiss();
                                    dismiss();
                                    back.onResponse(spxf_success_bean.getData().getGID());
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    dialog.dismiss();
                                }
                            });
                        }

                    }
                }
            }
        });
        mIvClose.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dismiss();
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
        double xianjin = mEtXianjin.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtXianjin.getText().toString());
        double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
        result.setPayTotalMoney(yuemoney + xianjin);
        List<PayType> typeList = new ArrayList<>();

        payWay(tvPayname1.getText().toString(), typeList, xianjin);
        payWay(tvPayname2.getText().toString(), typeList, yuemoney);

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
            if (isYhq) {
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
                        mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                        mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);
                        mLiXianjin.setEnabled(false);
                        isxianjinpay = false;
                    }

                    break;
                case "102"://余额
                    if (msg.getSS_State() != 1) {
                        mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvYue.setTextColor(context.getResources().getColor(R.color.white));
                        mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);
                        mLiYue.setEnabled(false);
                        isyuepay = false;
                    }
                    break;
                case "103"://银联
                    if (msg.getSS_State() != 1) {
                        mLiYinlian.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvYinlian.setTextColor(context.getResources().getColor(R.color.white));
                        mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union_active);
                        mLiYinlian.setEnabled(false);
                        isYinlianpay = false;
                    }


                    break;
                case "105"://微信

                    if (msg.getSS_State() != 1) {
                        mLiWx.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvWx.setTextColor(context.getResources().getColor(R.color.white));
                        mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat_active);
                        mLiWx.setEnabled(false);
                        iswxpay = false;
                    }

                    break;
                case "106"://支付宝

                    if (msg.getSS_State() != 1) {
                        mLiAli.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvAli.setTextColor(context.getResources().getColor(R.color.white));
                        mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay_active);
                        mLiAli.setEnabled(false);
                        isalipay = false;
                    }

                    break;
                case "110"://优惠券
                    if (msg.getSS_State() != 1) {
                        mLiYhq.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvYhq.setTextColor(context.getResources().getColor(R.color.white));
                        mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon_active);
                        mLiYhq.setEnabled(false);
                        isyhqpay = false;
                    }

                    break;
                case "107"://积分支付
                    if (msg.getSS_State() != 1) {
                        mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
                        mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);
                        mLiJifen.setEnabled(false);
                        isjfpay = false;
                    }

                    break;
                case "111"://扫码支付

                    if (msg.getSS_State() != 1) {
                        mLiSaoma.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvSaoma.setTextColor(context.getResources().getColor(R.color.white));
                        mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan_active);
                        mLiSaoma.setEnabled(false);
                        issmpay = false;
                    }

                    break;
                case "113"://其它支付

                    if (msg.getSS_State() != 1) {
                        li_qita.setBackgroundResource(R.drawable.shap_enable_not);
                        mTvQita.setTextColor(context.getResources().getColor(R.color.white));
                        mIvQita.setBackgroundResource(R.drawable.cash_ico_other_active);
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

        switch (NullUtils.noNullHandle(msg.getSS_Value()).toString()) {
            case "XJZF"://现金
                mLiXianjin.setBackgroundResource(R.drawable.shap_xianjin);
                mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);
                tvPayname1.setText("现金支付");
//                mEtXianjin.setText(money);

                break;
            case "YEZF"://余额
                if (isMember) {
                    mLiYue.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvYue.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);
                    tvPayname1.setText("余额支付");
//                    mEtXianjin.setText(money);
                } else {
                    //默认余额支付时为非会员 改为默认现金支付
                    mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
                    mTvYue.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);

                    mLiXianjin.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                    mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);
                    tvPayname1.setText("现金支付");
//                    mEtXianjin.setText(money);
                }
                break;

            case "YLZF"://银联
                mLiYinlian.setBackgroundResource(R.drawable.shap_xianjin);
                mTvYinlian.setTextColor(context.getResources().getColor(R.color.white));
                mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union_active);
                tvPayname1.setText("银联支付");
//                mEtXianjin.setText(money);

                break;
            case "WXJZ"://微信
                mLiWx.setBackgroundResource(R.drawable.shap_xianjin);
                mTvWx.setTextColor(context.getResources().getColor(R.color.white));
                mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat_active);
                tvPayname1.setText("微信支付");
//                mEtXianjin.setText(money);

                break;
            case "ZFBJZ"://支付宝
                mLiAli.setBackgroundResource(R.drawable.shap_xianjin);
                mTvAli.setTextColor(context.getResources().getColor(R.color.white));
                mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay_active);
                tvPayname1.setText("支付宝支付");
//                mEtXianjin.setText(money);

                break;
            case "YHQ"://优惠券
                mLiYhq.setBackgroundResource(R.drawable.shap_xianjin);
                mTvYhq.setTextColor(context.getResources().getColor(R.color.white));
                mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon_active);
                tvPayname1.setText("优惠金额");
//                mEtXianjin.setText(money);

                break;
            case "JFZF"://积分支付
                if (isMember) {
                    mLiJifen.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
                    mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);
                    tvPayname1.setText("积分支付");
//                    mEtXianjin.setText(money);
                } else {
                    //默认积分支付时为非会员 改为默认现金支付
                    mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
                    mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
                    mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);

                    mLiXianjin.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                    mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);
                    tvPayname1.setText("现金支付");
                    mEtXianjin.setText(money);
                }

                break;
            case "SMZF"://扫码支付

                mLiSaoma.setBackgroundResource(R.drawable.shap_xianjin);
                mTvSaoma.setTextColor(context.getResources().getColor(R.color.white));
                mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan_active);
                tvPayname1.setText("扫码支付");
//                mEtXianjin.setText(money);

                break;
            case "QTZF"://其它支付
                li_qita.setBackgroundResource(R.drawable.shap_xianjin);
                mTvQita.setTextColor(context.getResources().getColor(R.color.white));
                mIvQita.setBackgroundResource(R.drawable.cash_ico_other_active);
                tvPayname1.setText("其它支付");
//                mEtXianjin.setText(money);
                break;


        }

        if (!isMember) {
            mLiJifen.setBackgroundResource(R.drawable.shap_enable_not);
            mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
            mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);
            mLiJifen.setEnabled(false);
            isyuepay = false;
            isjfpay = false;

            mLiYue.setBackgroundResource(R.drawable.shap_enable_not);
            mTvYue.setTextColor(context.getResources().getColor(R.color.white));
            mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);
            mLiYue.setEnabled(false);
        }

    }

    @Override
    public void show() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
//        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//        layoutParams.gravity = Gravity.CENTER;
//        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
////        getWindow().getDecorView().setPadding(0, 0, 0, 0);
//        getWindow().setAttributes(layoutParams);

        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

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

    /**
     * 去掉累加时，double自带的.0
     */
    public void etPay(String s){
        String s1[] = s.split("[.]");
        int num;
        if (s1.length == 2){
            num = Integer.parseInt(s1[1]);
            if (num == 0){
                mEtXianjin.setText(((int) Double.parseDouble(s+""))+"");
            }else {
                mEtXianjin.setText(s);
            }
        }else {
            mEtXianjin.setText(s);
        }
    }

    @OnClick({R.id.li_xianjin, R.id.li_1, R.id.li_2, R.id.li_3, R.id.li_20, R.id.li_yue, R.id.li_4, R.id.li_5, R.id.li_6, R.id.li_50, R.id.li_yinlian, R.id.li_7, R.id.li_8, R.id.li_9, R.id.li_100, R.id.li_wx, R.id.li_0, R.id.li_dian, R.id.li_c, R.id.li_moling, R.id.li_ali, R.id.li_yhq, R.id.li_jifen, R.id.li_saoma, R.id.li_qita, R.id.li_union})
    public void onViewClicked(View view) {
        double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
        switch (view.getId()) {
            case R.id.li_1:
                addMoney("1");
                break;
            case R.id.li_2:
                addMoney("2");
                break;
            case R.id.li_3:
                addMoney("3");
                break;
            case R.id.li_20:
                if (mEtXianjin.getText().toString().equals("")) {
                    mEtXianjin.setText("20");
                    return;
                }
                moneyFlag = Double.parseDouble(mEtXianjin.getText().toString());
                int moneyFlag20 = (int) moneyFlag;
                if (moneyFlag20 != 0) {
                    moneyFlag = moneyFlag + 20;
                    etPay(moneyFlag+"");
                    return;
                }
                mEtXianjin.setText("20");
                break;
            case R.id.li_4:
                addMoney("4");
                break;
            case R.id.li_5:
                addMoney("5");
                break;
            case R.id.li_6:
                addMoney("6");
                break;
            case R.id.li_50:
                if (mEtXianjin.getText().toString().equals("")) {
                    mEtXianjin.setText("50");
                    return;
                }
                moneyFlag = Double.parseDouble(mEtXianjin.getText().toString());
                int moneyFlag50 = (int) moneyFlag;
                if (moneyFlag50 != 0) {
                    moneyFlag = moneyFlag + 50;
                    etPay(moneyFlag+"");
                    return;
                }
                mEtXianjin.setText("50");
                break;
            case R.id.li_7:
                addMoney("7");
                break;
            case R.id.li_8:
                addMoney("8");
                break;
            case R.id.li_9:
                addMoney("9");
                break;
            case R.id.li_100:
                if (mEtXianjin.getText().toString().equals("")) {
                    mEtXianjin.setText("100");
                    return;
                }
                moneyFlag = Double.parseDouble(mEtXianjin.getText().toString());
                int moneyFlag100 = (int) moneyFlag;
                if (moneyFlag100 != 0) {
                    moneyFlag = moneyFlag + 100;
                    etPay(moneyFlag+"");
                    return;
                }
                mEtXianjin.setText("100");
                break;

            case R.id.li_0:
                addMoney("0");
                break;
            case R.id.li_dian:
                addMoneyDian(".");
                break;
            case R.id.li_c:
                delMoney();
                break;

            case R.id.li_moling:
                if (isMoling) {
                    isMoling = false;
                    mLiMoling.setBackgroundResource(R.drawable.shap_jiesunmoney);
                } else {
                    isMoling = true;
                    mLiMoling.setBackgroundResource(R.drawable.moling_true);
                }

                break;
            case R.id.li_xianjin:
//                1开启、0关闭

                if (isXianjin) {
                    return;
                }
                resetPayRl("现金支付");
                resetIsPay();
                isXianjin = true;

                mLiXianjin.setBackgroundResource(R.drawable.shap_xianjin);
                mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);

//                tvPayname1.setText("现金支付");
//                mEtXianjin.setText("0");

                break;
            case R.id.li_yue:
                if (isYue) {
                    return;
                }

                resetPayRl("余额支付");
                resetIsPay();
                isYue = true;

                mLiYue.setBackgroundResource(R.drawable.shap_xianjin);
                mTvYue.setTextColor(context.getResources().getColor(R.color.white));
                mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);
//                tvPayname1.setText("余额支付");
//                mEtXianjin.setText("0");
                break;
            case R.id.li_wx:
                if (isWx) {
                    return;
                }
                resetPayRl("微信支付");
                resetIsPay();
                isWx = true;
                mLiWx.setBackgroundResource(R.drawable.shap_xianjin);
                mTvWx.setTextColor(context.getResources().getColor(R.color.white));
                mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat_active);
//                tvPayname1.setText("微信支付");
//                mEtXianjin.setText("0");

                break;
            case R.id.li_yinlian:
                if (isYinlian) {
                    return;
                }
                resetPayRl("银联支付");
                resetIsPay();
                isYinlian = true;
//                tvPayname1.setText("银联支付");
                mLiYinlian.setBackgroundResource(R.drawable.shap_xianjin);
                mTvYinlian.setTextColor(context.getResources().getColor(R.color.white));
                mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union_active);

//                mEtXianjin.setText("0");

                break;
            case R.id.li_ali:
                if (isAli) {
                    return;
                }
                resetPayRl("支付宝支付");
                resetIsPay();
                isAli = true;
                mLiAli.setBackgroundResource(R.drawable.shap_xianjin);
                mTvAli.setTextColor(context.getResources().getColor(R.color.white));
                mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay_active);
//                tvPayname1.setText("支付宝支付");
//                mEtXianjin.setText("0");
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
                        if (isUnion) {
                            if (isYhq) {
                                if (tvPayname1.getText().toString().equals("优惠金额")) {

                                    for (YhqMsg yhqMsg : yhqMsgs) {
                                        if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                                            yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                                        } else {
                                            yhqmo += CommonUtils.del(Double.parseDouble(money), Double.parseDouble(CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), money)));
                                        }
                                    }
                                    mEtXianjin.setText(yhqmo + "");
                                } else if (tvPayname2.getText().toString().equals("优惠金额")) {

                                    for (YhqMsg yhqMsg : yhqMsgs) {
                                        if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                                            yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                                        } else {
                                            yhqmo += CommonUtils.del(Double.parseDouble(money), Double.parseDouble(CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), money)));
                                        }
                                    }
                                    mEtYue.setText(yhqmo + "");
                                    mEtXianjin.setText(CommonUtils.del(Double.parseDouble(money), yhqmo) + "");
                                }

                            } else {
                                resetPayRl("优惠金额");
                                resetIsPay();
                                isYhq = true;
                                mLiYhq.setBackgroundResource(R.drawable.shap_xianjin);
                                mTvYhq.setTextColor(context.getResources().getColor(R.color.white));
                                mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon_active);
//                            tvPayname1.setText("优惠金额");

                                for (YhqMsg yhqMsg : yhqMsgs) {
                                    if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                                        yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                                    } else {
                                        yhqmo += CommonUtils.del(Double.parseDouble(money), Double.parseDouble(CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), money)));
                                    }
                                }
                                mEtXianjin.setText(yhqmo + "");
                            }

                        } else {
                            isYhq = true;
                            for (YhqMsg yhqMsg : yhqMsgs) {
                                if (yhqMsg.getEC_DiscountType() == 1) {//代金券
                                    yhqmo = CommonUtils.add(Double.parseDouble(NullUtils.noNullHandle(yhqMsg.getEC_Discount()).toString()), yhqmo);
                                } else {
                                    yhqmo += CommonUtils.del(Double.parseDouble(money), Double.parseDouble(CommonUtils.multiply(String.valueOf(CommonUtils.div(yhqMsg.getEC_Discount(), 100, 2)), money)));
                                }
                            }
                            mEtYue.setText(yhqmo + "");
                            mEtXianjin.setText(CommonUtils.del(Double.parseDouble(money), yhqmo) + "");
                        }

//                        jisuanZhaolingMoney();
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        yhqdialog.dismiss();
                    }
                });

                break;
            case R.id.li_jifen:

                if (isJifen) {
                    return;
                }
                resetPayRl("积分支付");
                resetIsPay();
                isJifen = true;
                mLiJifen.setBackgroundResource(R.drawable.shap_xianjin);
                mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
                mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);

//                tvPayname1.setText("积分支付");
//                mEtXianjin.setText("0");

                break;
            case R.id.li_saoma:

                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 0){
                    com.blankj.utilcode.util.ToastUtils.showShort("商家未开通扫码支付功能");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 1){
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过,但未签署电子协议");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 2){
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核驳回");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 3){
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核中");
                    return;
                }
                if (MyApplication.loginBean.getData().getShopList().get(0).getSaoBei_State() == 5){
                    com.blankj.utilcode.util.ToastUtils.showShort("扫码支付功能审核通过且已签署电子协议");
                    return;
                }

                resetPayRl("扫码");
                resetIsPay();
                isSaoma = true;
                mLiSaoma.setBackgroundResource(R.drawable.shap_xianjin);
                mTvSaoma.setTextColor(context.getResources().getColor(R.color.white));
                mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan_active);
//                tvPayname1.setText("扫码");
//                mEtXianjin.setText("0");

                SaomaDialog.saomaDialog(context, 1, new InterfaceBack() {
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
                                dismiss();
                            }
                        });
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });

                break;
            case R.id.li_qita:
                if (isQita) {
                    return;
                }
                resetPayRl("其他支付");
                resetIsPay();
                isQita = true;
                li_qita.setBackgroundResource(R.drawable.shap_xianjin);
                mTvQita.setTextColor(context.getResources().getColor(R.color.white));
                mIvQita.setBackgroundResource(R.drawable.cash_ico_other_active);
//                tvPayname1.setText("其他支付");
//                mEtXianjin.setText("0");

                break;
            case R.id.li_union:
//                resetIsPay();
                if (!isUnion) {
                    isUnion = true;

                    liUnion.setBackgroundResource(R.drawable.shap_xianjin);
                    tvUnion.setTextColor(context.getResources().getColor(R.color.white));
                    ivUnion.setBackgroundResource(R.drawable.cash_ico_check_active);

                    isYhq = true;
                    mLiYhq.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvYhq.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon_active);
                } else {
                    isUnion = false;
                    liUnion.setBackgroundResource(R.drawable.shap_jiesunnot);
                    tvUnion.setTextColor(context.getResources().getColor(R.color.text60));
                    ivUnion.setBackgroundResource(R.drawable.cash_ico_check);

                    switch (tvPayname2.getText().toString()) {
                        case "现金支付"://现金
                            mLiXianjin.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvXianjin.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet);
                            isXianjin = false;
                            break;
                        case "余额支付"://余额
                            mLiYue.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvYue.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvYue.setBackgroundResource(R.drawable.cash_ico_purse);
                            isYue = false;
                            break;
                        case "银联支付"://银联
                            mLiYinlian.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvYinlian.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union);
                            isYinlian = false;
                            break;
                        case "微信支付"://微信
                            mLiWx.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvWx.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat);
                            isWx = false;
                            break;
                        case "支付宝支付"://支付宝
                            mLiAli.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvAli.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay);
                            isAli = false;
                            break;
                        case "优惠金额"://优惠券
                            mLiYhq.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvYhq.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon);
                            isYhq = false;
                            break;
                        case "积分支付"://积分支付
                            mLiJifen.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvJifen.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin);
                            isJifen = false;
                            break;
                        case "扫码支付"://扫码支付
                            mLiSaoma.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvSaoma.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan);
                            isSaoma = false;
                            break;
                        case "其他支付"://其它支付
                            li_qita.setBackgroundResource(R.drawable.shap_jiesunnot);
                            mTvQita.setTextColor(context.getResources().getColor(R.color.text60));
                            mIvQita.setBackgroundResource(R.drawable.cash_ico_other);
                            isQita = false;
                            break;
                    }
                    tvPayname2.setText("优惠金额");
                    mEtYue.setText("0.00");
                    jisuanZhaolingMoney();
                }
                break;
        }
    }


    private void jisuanZhaolingMoney() {
        if (!mEtXianjin.getText().toString().equals("")) {
            double xianjin = mEtXianjin.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtXianjin.getText().toString());
            double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
            double zhmoney = Double.parseDouble(money);
            double yfmoney = CommonUtils.del(zhmoney, molingmoney);

            double ym = CommonUtils.del(yfmoney, xianjin);

            if (isUnion) {
                if (!tvPayname2.getText().toString().equals("优惠金额")) {
                    if (ym > 0) {
                        if (tvPayname2.getText().toString().equals("余额支付") && ym > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {
                            mEtYue.setText(StringUtil.twoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
                        } else if (tvPayname2.getText().toString().equals("积分支付") && ym > Double.parseDouble(dkmoney)) {
                            mEtYue.setText(StringUtil.twoNum(dkmoney + ""));
                        } else {
                            mEtYue.setText(ym + "");
                        }
                    } else {
                        mEtYue.setText("0.00");
                    }
                }
            }
            double yuemoney = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());

            double xjm = CommonUtils.del(ym, yuemoney);
//            double smm = CommonUtils.del(xjm, saomamoney);
            double zlmoney = CommonUtils.del(0, xjm);
            tv_zhaoling.setText(StringUtil.twoNum(zlmoney + ""));
        }
    }

    private void setPayType(OrderPayResult orderPayResult) {
        orderPayResult.setDisMoney(Double.parseDouble(mEtZhmoney.getText().toString()));
        double zhaoling = tv_zhaoling.getText().toString().equals("") ? 0.00 : Double.parseDouble(tv_zhaoling.getText().toString());
        orderPayResult.setGiveChange(zhaoling);
        double xianjin = mEtXianjin.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtXianjin.getText().toString());
        orderPayResult.setPayTotalMoney(xianjin);
        if (!mEtXianjin.getText().toString().equals("")) {
            PayType p = new PayType();
        }
    }


    private void delMoney() {
        StringBuffer mon = new StringBuffer();
        if (isMoling) {
            String s = et_moling.getText().toString();
            if (s.length() > 0) {
                mon.append(s.substring(0, s.length() - 1));
            } else {
                mon.append("");
            }
            et_moling.setText(mon.toString());
        } else {
            String s = mEtXianjin.getText().toString();
            if (s.length() > 0) {
                mon.append(s.substring(0, s.length() - 1));
            } else {
                mon.append("");
            }
            mEtXianjin.setText(mon.toString());
        }

    }

    private void addMoney(String i) {
        StringBuffer mon = new StringBuffer();


        if (isMoling) {
            String s = et_moling.getText().toString();
            if (!s.equals("0")) {
                mon.append(s);
            }
            mon.append(i);
            et_moling.setText(mon.toString());
        } else {
            String s = mEtXianjin.getText().toString();
            if (!s.equals("0")) {
                mon.append(s);
            }
            mon.append(i);
            mEtXianjin.setText(mon.toString());
        }
    }

    private void addMoneyDian(String i) {
        StringBuffer mon = new StringBuffer();
        if (isMoling) {
            String s = et_moling.getText().toString();
            mon.append(s);
            if (!s.equals("") && !s.contains(".")) {
                mon.append(i);
            }
            et_moling.setText(mon.toString());
        } else {
            String s = mEtXianjin.getText().toString();
            mon.append(s);
            if (!s.equals("") && !s.contains(".")) {
                mon.append(i);
            }
            mEtXianjin.setText(mon.toString());
        }
    }

    private void resetPayLi() {
        mLiXianjin.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiYue.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiYinlian.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiWx.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiAli.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiYhq.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiJifen.setBackgroundResource(R.drawable.shap_jiesunnot);
        mLiSaoma.setBackgroundResource(R.drawable.shap_jiesunnot);
        li_qita.setBackgroundResource(R.drawable.shap_jiesunnot);
    }

    private void resetIsPay() {
        isXianjin = false;
        isYue = false;
        isYinlian = false;
        isWx = false;
        isAli = false;
        isYhq = false;
        isJifen = false;
        isSaoma = false;
        isQita = false;
        isMoling = false;
    }

    private void resetPayRl(String payWay) {

        if (isxianjinpay) {
            mLiXianjin.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvXianjin.setTextColor(context.getResources().getColor(R.color.text60));
            mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet);

        }
        if (issmpay) {
            mLiSaoma.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvSaoma.setTextColor(context.getResources().getColor(R.color.text60));
            mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan);
        }
        if (isyuepay) {
            mLiYue.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvYue.setTextColor(context.getResources().getColor(R.color.text60));
            mIvYue.setBackgroundResource(R.drawable.cash_ico_purse);
        }
        if (isalipay) {
            mLiAli.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvAli.setTextColor(context.getResources().getColor(R.color.text60));
            mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay);
        }
        if (iswxpay) {
            mLiWx.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvWx.setTextColor(context.getResources().getColor(R.color.text60));
            mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat);
        }
        if (isYinlianpay) {
            mLiYinlian.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvYinlian.setTextColor(context.getResources().getColor(R.color.text60));
            mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union);
        }
        if (isjfpay) {
            mLiJifen.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvJifen.setTextColor(context.getResources().getColor(R.color.text60));
            mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin);
        }
        if (isyhqpay) {
            mLiYhq.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvYhq.setTextColor(context.getResources().getColor(R.color.text60));
            mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon);
        }
        if (isqtpay) {
            li_qita.setBackgroundResource(R.drawable.shap_jiesunnot);
            mTvQita.setTextColor(context.getResources().getColor(R.color.text60));
            mIvQita.setBackgroundResource(R.drawable.cash_ico_other);
        }

        if (!isUnion) {
            liUnion.setBackgroundResource(R.drawable.shap_jiesunnot);
            tvUnion.setTextColor(context.getResources().getColor(R.color.text60));
            ivUnion.setBackgroundResource(R.drawable.cash_ico_check);
        }

        if (isUnion) {
            switch (tvPayname1.getText().toString()) {
                case "现金支付"://现金
                    mLiXianjin.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvXianjin.setTextColor(context.getResources().getColor(R.color.white));
                    mIvXianjin.setBackgroundResource(R.drawable.cash_ico_wallet_active);
                    isXianjin = true;
                    break;
                case "余额支付"://余额
                    mLiYue.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvYue.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYue.setBackgroundResource(R.drawable.cash_ico_purse_active);
                    isYue = true;
                    break;
                case "银联支付"://银联
                    mLiYinlian.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvYinlian.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYinlian.setBackgroundResource(R.drawable.cash_ico_union_active);
                    isYinlian = true;
                    break;
                case "微信支付"://微信
                    mLiWx.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvWx.setTextColor(context.getResources().getColor(R.color.white));
                    mIvWx.setBackgroundResource(R.drawable.cash_ico_wechat_active);
                    isWx = true;
                    break;
                case "支付宝支付"://支付宝
                    mLiAli.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvAli.setTextColor(context.getResources().getColor(R.color.white));
                    mIvAli.setBackgroundResource(R.drawable.cash_ico_alipay_active);
                    isAli = true;
                    break;
                case "优惠金额"://优惠券
                    mLiYhq.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvYhq.setTextColor(context.getResources().getColor(R.color.white));
                    mIvYhq.setBackgroundResource(R.drawable.cash_ico_coupon_active);
                    isYhq = true;
                    break;
                case "积分支付"://积分支付
                    mLiJifen.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvJifen.setTextColor(context.getResources().getColor(R.color.white));
                    mIvJifen.setBackgroundResource(R.drawable.cash_ico_coin_active);
                    isJifen = true;
                    break;
                case "扫码支付"://扫码支付
                    mLiSaoma.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvSaoma.setTextColor(context.getResources().getColor(R.color.white));
                    mIvSaoma.setBackgroundResource(R.drawable.cash_ico_scan_active);
                    isSaoma = true;
                    break;
                case "其他支付"://其它支付
                    li_qita.setBackgroundResource(R.drawable.shap_xianjin);
                    mTvQita.setTextColor(context.getResources().getColor(R.color.white));
                    mIvQita.setBackgroundResource(R.drawable.cash_ico_other_active);
                    isQita = true;
                    break;

            }
            double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
            double xjmoney = mEtXianjin.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtXianjin.getText().toString());
            double zhmoney = Double.parseDouble(money);
            double yfmoney = CommonUtils.del(zhmoney, molingmoney);
            if (tvPayname1.getText().toString().equals("优惠金额")) {
                mEtYue.setText(xjmoney + "");
            } else {
                if (yfmoney > 0) {

                    if (tvPayname1.getText().toString().equals("余额支付") && yfmoney > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {
                        mEtYue.setText(StringUtil.twoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
                    } else if (tvPayname1.getText().toString().equals("积分支付") && yfmoney > Double.parseDouble(dkmoney)) {
                        mEtYue.setText(StringUtil.twoNum(dkmoney + ""));
                    } else {
                        mEtYue.setText(yfmoney + "");
                    }
                } else {
                    mEtYue.setText("0.00");
                }
            }

            tvPayname2.setText(tvPayname1.getText().toString());
            tvPayname1.setText(payWay);
            mEtXianjin.setText("0");


        } else {
            double molingmoney = et_moling.getText().toString().equals("") ? 0.00 : Double.parseDouble(et_moling.getText().toString());
            double youhui = mEtYue.getText().toString().equals("") ? 0.00 : Double.parseDouble(mEtYue.getText().toString());
            double zhmoney = Double.parseDouble(money);
            double yfmoney = CommonUtils.del(zhmoney, molingmoney) - youhui;
//            mEtXianjin.setText(tvPayname1.getText().toString());
            tvPayname1.setText(payWay);
            if (yfmoney > 0) {
                if (tvPayname1.getText().toString().equals("余额支付") && yfmoney > Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100) {
                    mEtXianjin.setText(StringUtil.twoNum(Double.parseDouble(money) * Double.parseDouble(yuezfxz) / 100 + ""));
                } else if (tvPayname1.getText().toString().equals("积分支付") && yfmoney > Double.parseDouble(dkmoney)) {
                    mEtXianjin.setText(StringUtil.twoNum(dkmoney + ""));
                } else {
                    mEtXianjin.setText(yfmoney + "");
                }

            } else {
                mEtXianjin.setText("0");
            }
        }

    }


}

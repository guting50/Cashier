package com.wycd.yushangpu.ui.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.Presenter.BasicEucalyptusPresnter;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.ShopLeftAdapter;
import com.wycd.yushangpu.bean.GoodsModelBean;
import com.wycd.yushangpu.bean.OrderCanshu;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.InterfaceThreeBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.model.ImpSubmitOrder;
import com.wycd.yushangpu.model.ImpSubmitOrder_Guazhang;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.widget.dialog.FastCashierDialog;
import com.wycd.yushangpu.widget.dialog.GoodsModelDialog;
import com.wycd.yushangpu.widget.dialog.KeyboardDialog;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;
import com.wycd.yushangpu.widget.dialog.VipChooseDialog;
import com.wycd.yushangpu.widget.views.ClearEditText;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;

public class CashierFragment extends BaseFragment {
    @BindView(R.id.tv_ordernum)
    TextView tv_ordernum;
    @BindView(R.id.tv_ordertime)
    TextView tv_ordertime;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.vip_name_layout)
    BgFrameLayout vipNameLayout;
    @BindView(R.id.et_login_account)
    public ClearEditText mEtLoginAccount;
    @BindView(R.id.recyclerview_shoplist)
    RecyclerView mRecyclerviewShoplist;
    @BindView(R.id.tv_num_total)
    TextView tvNumTotal;
    @BindView(R.id.tv_heji)
    TextView mTvHeji;
    @BindView(R.id.btt_get_order)
    TextView bttGetOrder;
    @BindView(R.id.order_count_layout)
    BgFrameLayout orderCountLayout;
    @BindView(R.id.tv_shoukuan)
    BgFrameLayout tvShoukuan;
    @BindView(R.id.btt_hung_money)
    Button bttHungMoney;
    @BindView(R.id.btt_reture_goods)
    Button bttRetureGoods;
    @BindView(R.id.btt_recharge)
    Button bttRecharge;
    @BindView(R.id.btt_vip_member)
    Button bttVipMember;
    @BindView(R.id.btt_business)
    Button bttBusiness;

    public ShopLeftAdapter mShopLeftAdapter;
    private ArrayList<ShopMsg> mShopLeftList = new ArrayList<>();
    private EditCashierGoodsFragment editCashierGoodsFragment = new EditCashierGoodsFragment();
    private QudanFragment qudanFragment;
    private GoodsListFragment goodsListFragment = new GoodsListFragment();
    private int leftpos = -1;// 购物车选中位子 -1表示没有选中
    private String order;
    private CharSequence ordertime;
    public VipInfoMsg mVipMsg;
    private String allmoney, totalMoney;

    private double mPoint;//积分
    private int mPD_Discount = 0;
    private List<GoodsModelBean> ModelList;
    private List<List<GoodsModelBean>> modelList = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.fragment_cashier;
    }

    public void onCreated() {
        initView();
        initEvent();
        getProductModel();

        //更新订单时间
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                long sysTime = System.currentTimeMillis();
                CharSequence ordertime2 = DateFormat
                        .format("MM/dd  HH:mm:ss", sysTime);
                ordertime = DateFormat
                        .format("yyyy-MM-dd HH:mm:ss", sysTime);
                homeActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_ordertime.setText("" + ordertime2);
                    }
                });
            }
        }, 1000, 1000);
    }

    public void initView() {
        order = CreateOrder.createOrder("SP");
        tv_ordernum.setText(order);
        mShopLeftAdapter = new ShopLeftAdapter(homeActivity, mShopLeftList, new InterfaceThreeBack() {

            //加减
            @Override
            public void onResponse(Object response) {

            }

            //移除
            @Override
            public void onErrorResponse(Object msg) {
                int po = (int) msg;
                if (mShopLeftList.size() > 0) {
                    if (editCashierGoodsFragment.getShopBean() != null &&
                            TextUtils.equals(mShopLeftList.get(po).getGID(),
                                    editCashierGoodsFragment.getShopBean().getGID()))
                        editCashierGoodsFragment.hide();

                    mShopLeftList.remove(po);
                    leftpos = leftpos - 1;
                    mShopLeftAdapter.notifyItemRemoved(po);
                    mShopLeftAdapter.notifyItemRangeChanged(po, mShopLeftAdapter.getItemCount());
                    jisuanAllPrice();

                    updateBttGetOrder();
                }
            }

            //选中
            @Override
            public void onThreeResponse(Object object) {
                final int i = (int) object;
                leftpos = i;
                for (int j = 0; j < mShopLeftList.size(); j++) {
                    mShopLeftList.get(j).setCheck(false);
                }
                mShopLeftList.get(i).setCheck(true);
                mShopLeftAdapter.notifyDataSetChanged();

                editCashierGoodsFragment.setData(mShopLeftList.get(i));
                editCashierGoodsFragment.show(homeActivity, R.id.right_fragment_layout);
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(homeActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerviewShoplist.setLayoutManager(llm);
        mRecyclerviewShoplist.setAdapter(mShopLeftAdapter);

        mEtLoginAccount.requestFocus();

        goodsListFragment.show(homeActivity, R.id.right_fragment_layout);

        qudanFragment = new QudanFragment(homeActivity);
        qudanFragment.obtainGuadanList();
    }

    private void getProductModel() {
        String url = HttpAPI.API().GOODSMODEL;
        AsyncHttpUtils.postHttp(url, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<GoodsModelBean>>() {
                }.getType();
                ModelList = response.getData(listType);
            }
        });
    }

    private void initEvent() {
        mEtLoginAccount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    homeActivity.dialog.show();
                    InputMethodManager imm = (InputMethodManager) homeActivity.getSystemService(Context.INPUT_METHOD_SERVICE); //得到InputMethodManager的实例
                    if (imm.isActive()) {//如果开启
                        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);//关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
                    }
                    goodsListFragment.obtainHomeShop(mEtLoginAccount.getText().toString(), true);
                }
                return false;
            }
        });

        ivSearch.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                KeyboardDialog.numchangeDialog(homeActivity, "商品搜索", mEtLoginAccount.getText().toString(), null, 1, new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        String search = (String) response;
                        goodsListFragment.obtainHomeShop(search + "", true);
                    }
                });
            }
        });

        tvShoukuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() > 0) {
                    homeActivity.dialog.show();
                    ImpSubmitOrder submitOrder = new ImpSubmitOrder();

                    if (mShopLeftList.size() == 1 && TextUtils.isEmpty(mShopLeftList.get(0).getGID()))
                        submitOrder.submitCelerityOrder(homeActivity, order, ordertime.toString(),
                                null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), allmoney, new InterfaceBack<OrderCanshu>() {
                                    @Override
                                    public void onResponse(OrderCanshu response) {
                                        toJieSuan(response, JiesuanBFragment.OrderType.CELERITY_ORDER);
                                    }

                                    @Override
                                    public void onErrorResponse(Object msg) {
                                        homeActivity.dialog.dismiss();
                                    }
                                });
                    else
                        submitOrder.submitOrder(homeActivity, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(),
                                mShopLeftList, false, new InterfaceBack<OrderCanshu>() {
                                    @Override
                                    public void onResponse(OrderCanshu response) {
                                        toJieSuan(response, JiesuanBFragment.OrderType.CONSUM_ORDER);
                                    }

                                    @Override
                                    public void onErrorResponse(Object msg) {
                                        homeActivity.dialog.dismiss();
                                    }
                                });
                } else {
                    FastCashierDialog.noticeDialog(homeActivity, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            String mone = response.toString();
                            ShopMsg shopMsg = new ShopMsg();
                            shopMsg.setGID("");
                            shopMsg.setPM_UnitPrice(Double.parseDouble(mone));
                            shopMsg.setJisuanPrice(Double.parseDouble(mone));
                            shopMsg.setStock_Number(1);
                            shopMsg.setPM_IsService(1);
                            shopMsg.setPM_Name("快速收银商品");
                            addCashierList(shopMsg);
                        }
                    });
                }
            }
        });

        bttHungMoney.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //挂帐
                if (mShopLeftList.size() > 0) {

                    NoticeDialog.noticeDialog(homeActivity, "收银台挂账提示", "你确定要挂账吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
//                            homeActivity.dialog.show();
                            ImpSubmitOrder_Guazhang submitOrder = new ImpSubmitOrder_Guazhang();
                            submitOrder.submitOrder(homeActivity, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, true, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    homeActivity.dialog.dismiss();
//                                    ToastUtils.showToast(homeActivity, "挂账成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂账成功");

                                    resetCashier();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    homeActivity.dialog.dismiss();
                                }
                            });
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                } else {
//                    ToastUtils.showToast(homeActivity, "请选择商品");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });

        bttGetOrder.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() == 0 && qudanFragment.getListCount() == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    return;
                }
                qudanFragment.show(homeActivity, R.id.fragment_content);
                //挂单
                if (mShopLeftList.size() > 0) {
                    qudanFragment.guaDan(order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            qudanFragment.hide();
                            resetCashier();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            qudanFragment.hide();
                        }
                    });

                    /*NoticeDialog.noticeDialog(homeActivity, "收银台挂单提示", "你确定要挂单吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
//                            homeActivity.dialog.show();
                            ImpSubmitOrder submitOrder = new ImpSubmitOrder();
                            submitOrder.submitGuaOrder(homeActivity, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    homeActivity.dialog.dismiss();
//                                    ToastUtils.showToast(homeActivity, "挂单成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂单成功");

                                    resetCashier();
                                    qudanFragment.obtainGuadanList();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    homeActivity.dialog.dismiss();
                                }
                            });
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });*/
                } else if (qudanFragment.getListCount() > 0) {
                    //取单
                    qudanFragment.getGuaDan(new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            qudanFragment.hide();
                            if (response != null) {
                                homeActivity.dialog.dismiss();
                                order = CreateOrder.createOrder("SP");
                                RevokeGuaDanBean guadanDetail = (RevokeGuaDanBean) response;
                                initGetOrder(guadanDetail);
                                if (guadanDetail.getVIP_Card() != null &&
                                        !guadanDetail.getVIP_Card().equals("00000") &&
                                        !guadanDetail.getVIP_Card().equals("")) {
                                    initVIP(guadanDetail.getVIP_Card());
                                } else {
                                    PreferenceHelper.write(homeActivity, "yunshangpu", "vip", false);
                                }
                                mShopLeftAdapter.notifyDataSetChanged();
                                jisuanAllPrice(false);
                            }
                            updateBttGetOrder();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            qudanFragment.hide();
                            updateBttGetOrder();
                        }
                    });
                }
            }
        });
        /*//退货
        bttRetureGoods.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                showWebDialog("退货", MyApplication.BASE_URL + "/WebUI/CashierDesk/ConsumeOrder.html", width * 9 / 10, 680);

            }
        });

        //会员充值
        bttRecharge.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("会员充值", "/WebUI/Member/MBalanceMage.shtml", 800, 680);
            }
        });

        //会员
        bttVipMember.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("会员列表", MyApplication.BASE_URL + "/WebUI/Member/MList.html", width * 9 / 10, 680);
            }
        });

        //交易
        bttBusiness.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("交易", MyApplication.BASE_URL + "/WebUI/CashierDesk/ConsumeOrder.html", width * 9 / 10, 680);
            }
        });*/
    }

    public void jisuanAllPrice() {
        jisuanAllPrice(true);
    }

    public void jisuanAllPrice(boolean isJisuanDiscount) {
        double allprice = 0;
        double totalPrice = 0;
        double onepoint = 0;
        double num = 0;
        for (ShopMsg shopMsg : mShopLeftList) {
            //商品积分计算
            if (mVipMsg != null) {
                if (shopMsg.getPM_IsPoint() == 0 || shopMsg.getPM_IsPoint() == 3) {//0没有设置积分规则，3本商品不计分
                    shopMsg.setEachPoint(0);
                } else if (shopMsg.getPM_IsPoint() == 2) {//本商品按固定积分
                    shopMsg.setEachPoint(shopMsg.getPM_FixedIntegralValue());
                } else if (shopMsg.getPM_IsPoint() == 1) {//本商品按等级积分
                    if (mVipMsg.getVG_IsIntegral() == 0) {//会员等级积分开关没有有打开
                        shopMsg.setEachPoint(0);
                    } else if (mVipMsg.getVG_IsIntegral() == 1) {
                        for (int m = 0; m < mVipMsg.getVGInfo().size(); m++) {//所选商品种类的数量，不等于所选商品数量；
                            if (mVipMsg.getVGInfo().get(m).getPT_GID().equals(shopMsg.getPT_ID())) {
                                double bl = mVipMsg.getVGInfo().get(m).getVS_CMoney();
                                if (bl != 0) {
                                    if (shopMsg.getPM_MemPrice() != null) {
                                        double memprice = Double.parseDouble(shopMsg.getPM_MemPrice());
                                        if (memprice < shopMsg.getJisuanPrice() * shopMsg.getPD_Discount()) {
                                            double fb = memprice / bl;
                                            shopMsg.setEachPoint(fb);
                                        } else {
                                            double fb = shopMsg.getJisuanPrice() * shopMsg.getPD_Discount() / bl;
                                            shopMsg.setEachPoint(fb);
                                        }
                                    } else {
                                        double fb = shopMsg.getJisuanPrice() * shopMsg.getPD_Discount() / bl;
                                        shopMsg.setEachPoint(fb);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (isJisuanDiscount) {
                jisuanDiscount(shopMsg);

                int type = 0;
                switch (NullUtils.noNullHandle(shopMsg.getPM_IsService()).toString()) {
                    case "0":
                    case "1":
                    case "2":
                        type = 0;
                        break;
                    case "3":
                    case "4":
                        type = 1;
                        break;
                }
                shopMsg.setType(type);
            }

            allprice += shopMsg.getAllprice();
            totalPrice += shopMsg.getTotalPrice();
            onepoint += shopMsg.getEachPoint() * shopMsg.getNum();
            num += shopMsg.getNum();
        }

        if (!PreferenceHelper.readBoolean(homeActivity, "yunshangpu", "vip", false)) {
            mPoint = 0;
        }
        mPoint = Double.parseDouble(StringUtil.twoNum(onepoint + ""));
        allmoney = StringUtil.twoNum(allprice + "");
        totalMoney = StringUtil.twoNum(totalPrice + "");
        mTvHeji.setText(allmoney);
        tvNumTotal.setText(num + "");
        if (num != 0) {
            tvShoukuan.setTag(1);
            ((TextView) tvShoukuan.getChildAt(0)).setText("结账[Enter]");
        } else {
            tvShoukuan.setTag(0);
            ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
        }

        mShopLeftAdapter.notifyDataSetChanged();
    }

    private void jisuanDiscount(ShopMsg ts) {
        boolean isVip = PreferenceHelper.readBoolean(homeActivity, "yunshangpu", "vip", false);
        if (!ts.isIschanged()) {
            if (NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")) {
                //有特价折扣
                if (ts.getPM_SpecialOfferMoney() != -1) { // 特价金额值
                    ts.setPD_Discount(ts.getPM_SpecialOfferMoney() / ts.getPM_UnitPrice());
                    ts.setHasvipDiscount(false);
                    ts.setJisuanPrice(ts.getPM_UnitPrice());
                } else if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")) { // 特价折扣开关的值
                    //有特价折扣
                    // 如果特价折扣 > 最低折扣 按特价折扣算，否者按最低折扣算
                    if (ts.getPM_SpecialOfferValue() > ts.getPM_MinDisCountValue()) {
                        ts.setPD_Discount(ts.getPM_SpecialOfferValue());
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    } else {
                        ts.setPD_Discount(ts.getPM_MinDisCountValue());
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    }
                } else {
                    //无特价折扣
                    if (isVip) {
                        if (ts.getPM_MemPrice() != null) {
                            //有会员价
                            ts.setPD_Discount(1);
                            ts.setHasvipDiscount(true);
                            ts.setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                        } else if (mPD_Discount > 0) {
                            //无会员价
                            // 如果等级折扣 > 最低折扣 按等级折扣算，否者按最低折扣算
                            if (CommonUtils.div(mPD_Discount, 100, 2) > ts.getPM_MinDisCountValue()) {
                                ts.setPD_Discount(CommonUtils.div(mPD_Discount, 100, 2));
                                ts.setHasvipDiscount(true);
                                ts.setJisuanPrice(ts.getPM_UnitPrice());
                            } else {
                                ts.setPD_Discount(ts.getPM_MinDisCountValue());
                                ts.setHasvipDiscount(true);
                                ts.setJisuanPrice(ts.getPM_UnitPrice());
                            }
                        } else {
                            ts.setPD_Discount(1);
                            ts.setHasvipDiscount(false);
                            ts.setJisuanPrice(ts.getPM_UnitPrice());
                        }
                    } else {
                        ts.setPD_Discount(1);
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    }
                }
            } else { // 会员折扣
                //没有开启折扣开关
                if (isVip && !NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                    //有会员价
                    ts.setPD_Discount(1);
                    ts.setHasvipDiscount(true);
                    ts.setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                } else {
                    ts.setPD_Discount(1);
                    ts.setHasvipDiscount(false);
                    ts.setJisuanPrice(ts.getPM_UnitPrice());
                }
            }

            if (NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("0.0")) {
                ts.setPM_MemPrice(ts.getPM_UnitPrice() + "");
            }
            double allprice = CommonUtils.multiply(CommonUtils.multiply(ts.getJisuanPrice(), ts.getNum()), ts.getPD_Discount());
            ts.setAllprice(allprice);

            double totalPrice = CommonUtils.multiply(ts.getPM_UnitPrice(), ts.getNum());
            ts.setTotalPrice(totalPrice);
        }
    }

    public void addCashierList(ShopMsg shopMsg) {
        if (mShopLeftList.size() == 1 && TextUtils.isEmpty(mShopLeftList.get(0).getGID())) {
            //如果有快速收银商品 ，就不在添加其他的商品
            return;
        }
        if (shopMsg.getStock_Number() <= 0 && BasicEucalyptusPresnter.isZeroStock && shopMsg.getPM_IsService() == 0) {
            com.blankj.utilcode.util.ToastUtils.showShort("当前库存不足");
            return;
        }
        double addnum = 1;
        if (BasicEucalyptusPresnter.isZeroStock && shopMsg.getPM_IsService() == 0) {//禁止0库存销售的普通商品
            if (shopMsg.getStock_Number() - 1 >= 0) { //库存大于等于1
                addnum = 1;
            } else {//库存大于0小于1
                addnum = shopMsg.getStock_Number();
            }
        } else {
            addnum = 1;
        }

        if (!TextUtils.isEmpty(shopMsg.getPM_GroupGID())/* && Integer.parseInt(shopMsg.getGroupCount()) > 1*/) {
            homeActivity.dialog.show();
            final double finalAddnum = addnum;
            String url = HttpAPI.API().GROUPGOODS_LIST;
            RequestParams params = new RequestParams();
            params.put("GroupGID", shopMsg.getPM_GroupGID());
            AsyncHttpUtils.postHttp(url, params, new CallBack() {
                @Override
                public void onResponse(BaseRes response) {
                    homeActivity.dialog.dismiss();
                    Type listType = new TypeToken<List<ShopMsg>>() {
                    }.getType();
                    List<ShopMsg> sllist = response.getData(listType);
                    if (sllist.size() == 1) {
                        addShopLeftList(shopMsg, finalAddnum);
                    } else {
                        showGoodsModelDialog(sllist, finalAddnum);
                    }
                }
            });
        } else {
            addShopLeftList(shopMsg, addnum);
        }
    }

    private void addShopLeftList(ShopMsg shopMsg, double addnum) {
        String json = JSON.toJSONString(shopMsg);
        shopMsg = JSON.parseObject(json, ShopMsg.class);
        double num = 0;
        int pos = 0;

        for (int j = 0; j < mShopLeftList.size(); j++) {
            if (shopMsg.getGID().equals(mShopLeftList.get(j).getGID()) && !mShopLeftList.get(j).isIsgive()) {
                num = mShopLeftList.get(j).getNum();
                pos = j;
            }
        }
        shopMsg.setNum(num + addnum);
        if (num == 0) {
            shopMsg.setCheck(false);
            mShopLeftList.add(0, shopMsg);
            if (leftpos != -1) {
                leftpos += 1;
            }

            updateBttGetOrder();
        } else {
            mShopLeftList.get(pos).setNum(num + addnum);
        }
        jisuanAllPrice();
        for (int i = 0; i < mShopLeftList.size(); i++) {
            if (shopMsg.getGID().equals(mShopLeftList.get(i).getGID()) && !mShopLeftList.get(i).isIsgive()) {
                mShopLeftList.get(i).setCheck(true);
                leftpos = i;
            } else {
                mShopLeftList.get(i).setCheck(false);
            }
        }
        mShopLeftAdapter.notifyDataSetChanged();
    }

    private void showGoodsModelDialog(List<ShopMsg> sllist, double addnum) {
        if (ModelList != null) {
            //初始化
            for (int i = 0; i < ModelList.size(); i++) {
                ModelList.get(i).setChecked(false);
                ModelList.get(i).setEnable(false);
            }
            //将商品有的规格设置成可点击
            for (ShopMsg shopMsg : sllist) {
                if (!TextUtils.isEmpty(shopMsg.getPM_Modle())) {
                    for (String str : shopMsg.getPM_Modle().split("\\|")) {
                        for (GoodsModelBean modelBean : ModelList) {
                            if (str.equals(modelBean.getPM_Properties())) {
                                modelBean.setEnable(true);
                            }
                        }
                    }
                }
            }
            modelList.clear();

            //组装规格数据
            if (ModelList != null && ModelList.size() > 1) {
                for (int i = 0; i < ModelList.size(); i++) {
                    if (ModelList.get(i).getPM_Type() == 0) {
                        List<GoodsModelBean> list = new ArrayList<>();
                        list.add(ModelList.get(i));
                        modelList.add(list);
                    } else {
                        for (int j = 0; j < modelList.size(); j++) {
                            if (modelList.get(j).get(0).getPM_Name().equals(ModelList.get(i).getPM_Name())) {
                                if (ModelList.get(i).isEnable()) {/*不可点击的不显示2020.4.11*/
                                    modelList.get(j).add(ModelList.get(i));
                                }
                            }
                        }
                    }
                }
            }
            //设置第一个默认选中
            for (int i = 0; i < modelList.size(); i++) {
                int num = 0;
                for (int j = 0; j < modelList.get(i).size(); j++) {
                    if (modelList.get(i).get(j).isEnable() && modelList.get(i).get(j).getPM_Type() != 0) {
                        modelList.get(i).get(j).setChecked(true);
                        num++;
                        break;
                    }
                }
                if (num == 0) {
                    modelList.remove(i);
                    i--;
                } else {
                    modelList.get(i).remove(0);
                }
            }

            homeActivity.dialog.dismiss();
            GoodsModelDialog.goodsModelDialog(homeActivity, 1, modelList, sllist,
                    BasicEucalyptusPresnter.isZeroStock, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            ShopMsg goodsitem = (ShopMsg) response;
                            addShopLeftList(goodsitem, addnum);
                        }
                    });

        } else {
            com.blankj.utilcode.util.ToastUtils.showShort("没有获取到规格列表，请稍后再尝试");
            getProductModel();
        }
    }

    private void initVIP(String VIP_Card) {
        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        onlyVipMsg.vipMsg(VIP_Card, new InterfaceBack<VipInfoMsg>() {
            @Override
            public void onResponse(VipInfoMsg response) {
                mVipMsg = response;

                if (mVipMsg != null) {
                    PreferenceHelper.write(homeActivity, "yunshangpu", "vip", true);

//                mPD_Discount = obtainVipPD_Discount(mVipMsg.getVG_GID(), mVipMsg.getVGInfo());
//                jisuanDiscount(mPD_Discount, mShopLeftList);
                    if (!TextUtils.isEmpty(mVipMsg.getVIP_Name())) {
                        vipNameLayout.setVisibility(View.VISIBLE);
                        ((TextView) vipNameLayout.getChildAt(0)).setText(mVipMsg.getVIP_Name().substring(0, 1));
                    } else {
                        com.blankj.utilcode.util.ToastUtils.showShort("会员名为空");
                    }
                }
            }
        });
    }

    private void initGetOrder(RevokeGuaDanBean guadanDetail) {
        mShopLeftList.clear();
        for (RevokeGuaDanBean.ViewGoodsDetailBean msg : guadanDetail.getViewGoodsDetail()) {
            if (msg.getGOD_Type() != 11) {
                ShopMsg newmsg = new ShopMsg();
                newmsg.setJisuanPrice(msg.getPM_UnitPrice());
                newmsg.setPD_Discount(msg.getPM_Discount());
                newmsg.setNum(msg.getPM_Number());
                newmsg.setPM_UnitPrice(msg.getPM_OriginalPrice());
                newmsg.setAllprice(msg.getGOD_DiscountPrice());
                newmsg.setPM_BigImg(msg.getPM_Img());
                newmsg.setGID(msg.getPM_GID());
                newmsg.setPM_Code(msg.getPM_Code());
                newmsg.setPM_Name(msg.getPM_Name());
                newmsg.setPM_Modle(msg.getPM_Modle());
                newmsg.setPT_ID(msg.getPT_GID());
                newmsg.setPT_Name(msg.getPT_Name());
                //setPM_IsDiscount
                if (msg.getGOD_Type() == 0) {
                    newmsg.setPM_IsService(0);
                } else if (msg.getGOD_Type() == 10) {
                    newmsg.setPM_IsService(1);
                    newmsg.setType(1);
                }
                if (msg.getGOD_EMName() != null && !msg.getGOD_EMName().equals("")) {
                    List<String> eMlist = new ArrayList<>();
                    String[] str = msg.getGOD_EMGID().split(",");
                    for (String str1 : str) {
                        eMlist.add(str1);
                    }
                    newmsg.setEM_GIDList(eMlist);
                    newmsg.setEM_NameList(msg.getGOD_EMName());
                }
                mShopLeftList.add(newmsg);
                updateBttGetOrder();
            }
        }
    }

    private void toJieSuan(OrderCanshu jso, JiesuanBFragment.OrderType orderType) {
        homeActivity.jiesuanBFragment.show(homeActivity, R.id.fragment_content);
        homeActivity.jiesuanBFragment.setData(totalMoney, allmoney, mVipMsg, jso, orderType, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                homeActivity.jiesuanBFragment.hide();
                if (response != null) {
                    String gid = (String) response;

                    //打印小票
                    if (MyApplication.PRINT_IS_OPEN) {
                        if (MyApplication.mGoodsConsumeMap.isEmpty()) {
                            GetPrintSet.getPrintParamSet();
                        }
                        new HttpGetPrintContents().SPXF(homeActivity, gid);
                    }

                    if (ISLABELCONNECT && LABELPRINT_IS_OPEN) {
                        for (int i = 0; i < mShopLeftList.size(); i++) {
                            homeActivity.labelPrint(mShopLeftList.get(i));
                        }
                    }
                    resetCashier();
                }
            }
        });
    }

    public void updateBttGetOrder() {
        orderCountLayout.setVisibility(View.GONE);
        if (mShopLeftList.size() > 0) {
            bttGetOrder.setText("挂单[F1]");
        } else if (qudanFragment.getListCount() > 0) {
            orderCountLayout.setVisibility(View.VISIBLE);
            ((TextView) orderCountLayout.getChildAt(0)).setText(qudanFragment.getListCount() + "");
            bttGetOrder.setText("取单[F1]");
        }
    }

    private void resetCashier() {
        mShopLeftList.clear();
        mShopLeftAdapter.notifyDataSetChanged();
        order = CreateOrder.createOrder("SP");
        tv_ordernum.setText(order);
        mVipMsg = null;
        vipNameLayout.setVisibility(View.GONE);
        PreferenceHelper.write(homeActivity, "yunshangpu", "vip", false);
        mTvHeji.setText("0.00");
        tvShoukuan.setTag(0);
        ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
        tvNumTotal.setText("0");
        updateBttGetOrder();

        editCashierGoodsFragment.hide();
    }

    @OnClick({R.id.im_clear, R.id.member_bg_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_clear:
                //清空
                mShopLeftList.clear();
                mShopLeftAdapter.notifyDataSetChanged();
                order = CreateOrder.createOrder("SP");
                tv_ordernum.setText(order);
                mTvHeji.setText("0.00");
                tvShoukuan.setTag(0);
                ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
                tvNumTotal.setText("0");
                leftpos = -1;

                updateBttGetOrder();

                editCashierGoodsFragment.hide();
                break;
            case R.id.member_bg_layout:
                VipChooseDialog vipChooseDialog = new VipChooseDialog(homeActivity, mVipMsg, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        selectedVIP((VipInfoMsg) response);
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        mVipMsg = null;
                        vipNameLayout.setVisibility(View.GONE);
                        PreferenceHelper.write(homeActivity, "yunshangpu", "vip", false);
                        if (mShopLeftList.size() > 0) {
                            for (int i = 0; i < mShopLeftList.size(); i++) {
                                if (mShopLeftList.get(i).isHasvipDiscount()) {
                                    mShopLeftList.get(i).setHasvipDiscount(false);
                                    mShopLeftList.get(i).setPD_Discount(1);
                                    mShopLeftList.get(i).setJisuanPrice(mShopLeftList.get(i).getPM_UnitPrice());
                                }
                            }
                            jisuanAllPrice();
                            mShopLeftAdapter.notifyDataSetChanged();
                        }
                    }
                });
                vipChooseDialog.show();
                break;
        }
    }

    public void selectedVIP(VipInfoMsg infoMsg) {
        mVipMsg = infoMsg;
        if (mVipMsg != null) {
            PreferenceHelper.write(homeActivity, "yunshangpu", "vip", true);

            mPD_Discount = obtainVipPD_Discount(mVipMsg.getVG_GID(), mVipMsg.getVGInfo());
            jisuanAllPrice();

            if (!TextUtils.isEmpty(mVipMsg.getVIP_Name())) {
                vipNameLayout.setVisibility(View.VISIBLE);
                ((TextView) vipNameLayout.getChildAt(0)).setText(mVipMsg.getVIP_Name().substring(0, 1));
            } else {
                com.blankj.utilcode.util.ToastUtils.showShort("会员名为空");
            }
        }
    }

    private int obtainVipPD_Discount(String vg_gid, List<VipInfoMsg.VGInfoBean> sllist) {
        int PD_Discount = 0;
        for (int i = 0; i < sllist.size(); i++) {
            if (sllist.get(i).getVG_GID().equals(vg_gid)) {
                PD_Discount = sllist.get(i).getPD_Discount();
            }
        }
        return PD_Discount;
    }

}


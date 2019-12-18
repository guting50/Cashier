package com.wycd.yushangpu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maimengmami.waveswiperefreshlayout.WaveSwipeRefreshLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.GuadanListAdapter;
import com.wycd.yushangpu.bean.GuadanList;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpGuadanList;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.model.ImpRevokeGuaDanOrder;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.ui.HomeActivity;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class QudanFragment extends Fragment {
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.tv_card)
    TextView tvCard;
    @BindView(R.id.tv_vipmsg)
    TextView tvVipmsg;
    @BindView(R.id.tv_ordermoney)
    TextView tvOrdermoney;
    @BindView(R.id.tv_handler)
    TextView tvHandler;
    @BindView(R.id.tv_handle)
    TextView tvHandle;
    @BindView(R.id.listview)
    RecyclerView listview;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.srl_freshmanage_activity)
    WaveSwipeRefreshLayout mRefresh;
    private InterfaceBack back;
    private List<GuadanList> list = new ArrayList<>();
    private HomeActivity homeActivity;
    private GuadanListAdapter guadanListAdapter;
    private String jifen;
    private double dkmoney;
    private VipDengjiMsg.DataBean mVipMsg;
    private ArrayList<ShopMsg> mShopLeftList = new ArrayList<>();
    private PayTypeMsg moren;//默认支付
    private ArrayList<PayTypeMsg> paytypelist;
    private String jifendkbfb, jinfenzfxzbfb;
    private int refreshnum = 2;
    private boolean mIsLoadMore;
    private int mPageTotal;//数据总页数
    View rootView;

    public QudanFragment(){

    }

    public QudanFragment(HomeActivity activity){
        this.homeActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_gualist, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);

        guadanListAdapter = new GuadanListAdapter(homeActivity, list, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                final GuadanList guadanList = (GuadanList) response;
                if (guadanList.getCO_IdentifyingState().equals("1")) {//挂单
                    //解挂接口
                    homeActivity.dialog.show();
                    ImpRevokeGuaDanOrder impRevokeGuaDanOrder = new ImpRevokeGuaDanOrder();
                    impRevokeGuaDanOrder.revokeGuaDan(homeActivity, guadanList.getGID(), new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            homeActivity.dialog.dismiss();
                            RevokeGuaDanBean guaDanBean = (RevokeGuaDanBean) response;
                            back.onResponse(guaDanBean);
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                            list.remove(guadanList);
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            back.onResponse(null);
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                        }
                    });
                } else if (guadanList.getCO_IdentifyingState().equals("8")) {//挂账
                    initGetOrder(guadanList);
                    //可抵扣金额= 会员积分/积分抵扣百分比 *积分支付限制百分比
                    if (!guadanList.getVIP_Card().equals("00000")) {
                        homeActivity.dialog.show();
                        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
                        onlyVipMsg.vipMsg(homeActivity, guadanList.getVIP_Card(), new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                VipDengjiMsg mVipDengjiMsg = (VipDengjiMsg) response;
                                homeActivity.dialog.dismiss();
                                mVipMsg = mVipDengjiMsg.getData().get(0);
                                jifen = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableIntegral() + "";
                                dkmoney = CommonUtils.div(Double.parseDouble(CommonUtils.multiply(jifen, jinfenzfxzbfb)), Double.parseDouble(jifendkbfb), 2);//可抵扣金额
                                jiesuan(guadanList, mVipMsg);
                                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                                event.setMsg("Change_color");
                                EventBus.getDefault().post(event);
                                list.remove(guadanList);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                    } else {
                        dkmoney = 0.00;//可抵扣金额

                        jiesuan(guadanList, null);
                    }


                }

            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
        listview.setLayoutManager(new GridLayoutManager(homeActivity, 3));
        listview.setAdapter(guadanListAdapter);
        setView();
        obtainGuadanList();

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setData(PayTypeMsg moren, ArrayList<PayTypeMsg> paytypelist, InterfaceBack back) {
        this.moren = moren;
        this.paytypelist = paytypelist;
        this.back = back;

        for (PayTypeMsg msg : paytypelist) {
            if (msg.getSS_Name().equals("积分支付")) {
                jifendkbfb = msg.getSS_Value();
            }
            if (msg.getSS_Name().equals("积分支付限制")) {
                jinfenzfxzbfb = msg.getSS_Value();
            }
        }
        obtainGuadanList();
    }

    private void jiesuan(GuadanList guadanList, VipDengjiMsg.DataBean mVipMsg) {
        if (homeActivity.jiesuanBFragment == null) {
            homeActivity.jiesuanBFragment = new JiesuanBFragment();
            homeActivity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_content, homeActivity.jiesuanBFragment).commit();
        } else
            homeActivity.getSupportFragmentManager().beginTransaction().show(homeActivity.jiesuanBFragment).commit();

        homeActivity.jiesuanBFragment.setData(guadanList.getCO_TotalPrice(), mVipMsg, mVipMsg,
                dkmoney + "", guadanList.getGID(), guadanList.getCO_Type(), guadanList.getCO_OrderCode(),
                mShopLeftList, moren, paytypelist, JiesuanBFragment.OrderType.GUAZHANG_ORDER, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        homeActivity.getSupportFragmentManager().beginTransaction().hide(homeActivity.jiesuanBFragment).commit();
                        if (response != null) {
                            com.blankj.utilcode.util.ToastUtils.showShort("结算成功");
                            mShopLeftList.clear();
                            obtainGuadanList();
                        }
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                    }

                });

    }

    private void initGetOrder(GuadanList guadanDetail) {
        mShopLeftList.clear();

        for (GuadanList.ViewGoodsDetailBean msg : guadanDetail.getViewGoodsDetail()) {
            if (msg.getGOD_Type() != 11) {
                ShopMsg newmsg = new ShopMsg();
                newmsg.setJisuanPrice(msg.getPM_UnitPrice());
                newmsg.setPD_Discount(msg.getPM_Discount());
                newmsg.setNum(msg.getPM_Number());
                newmsg.setPM_UnitPrice(msg.getPM_UnitPrice());
                newmsg.setAllprice(msg.getDiscountPrice());
                newmsg.setPM_BigImg(msg.getPM_BigImg());
                newmsg.setGID(msg.getPM_GID());
                newmsg.setPM_Code(msg.getPM_Code());
                newmsg.setPM_Name(msg.getPM_Name());
                newmsg.setPM_Modle(msg.getPM_Modle());
                newmsg.setPT_ID(msg.getPT_GID());
                newmsg.setPT_Name(msg.getPT_Name());
                if (msg.getGOD_Type() == 0) {
                    newmsg.setPM_IsService(0);
                } else if (msg.getGOD_Type() == 10) {
                    newmsg.setPM_IsService(1);
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
            }

        }
    }

    public void obtainGuadanList() {
        obtainGuadanList(1);
    }

    private void obtainGuadanList(int index) {
        ImpGuadanList shopHome = new ImpGuadanList();
        shopHome.guadanList(MyApplication.getContext(), index, 20, MyApplication.loginBean.getData().getShopID(), new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                try {
                    Gson mGson = new Gson();
                    JSONObject js = (JSONObject) response;
                    Type listType = new TypeToken<List<GuadanList>>() {
                    }.getType();
                    mPageTotal = js.getInt("PageTotal");
                    List<GuadanList> sllist = mGson.fromJson(js.getString("DataList"), listType);
                    if (list != null && !mIsLoadMore) {
                        list.clear();
                    }
                    for (GuadanList guadanList : sllist) {
                        if (guadanList.getCO_IdentifyingState().equals("1") || guadanList.getCO_IdentifyingState().equals("8")) {
                            list.add(guadanList);
                        }
                    }
                    updateData();
                    homeActivity.updateBttGetOrder();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });

    }

    private void updateData() {
        if (this.isResumed()) {
            guadanListAdapter.notifyDataSetChanged();
            mIsLoadMore = false;
            mRefresh.setRefreshing(false);
            mRefresh.setLoading(false);
        }
    }

    private void setView() {
        ivClose.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                back.onResponse(null);
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });


        mRefresh.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                obtainGuadanList();
                refreshnum = 2;
            }

            @Override
            public void onLoad() {
                if (refreshnum <= mPageTotal) {
                    mIsLoadMore = true;
                    obtainGuadanList(refreshnum);
                    refreshnum++;
                } else {
//                    ToastUtils.showToast(context,"没有更多数据了");
                    com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了");
                    mRefresh.setLoading(false);
                }
            }

            @Override
            public boolean canLoadMore() {
                return true;
            }

            @Override
            public boolean canRefresh() {
                return true;
            }
        });

    }

    public int getListCount() {
        return list.size();
    }
}

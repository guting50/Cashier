package com.wycd.yushangpu.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.GuadanList;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.model.ImpSubmitOrder;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.ui.HomeActivity;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songxiaotao on 2017/12/21.
 */

public class QudanFragment extends BaseFragment {
    @BindView(R.id.listview)
    XRecyclerView listview;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    private InterfaceBack back;
    private List<GuadanList> list = new ArrayList<>();
    private GuadanListAdapter guadanListAdapter;
    private VipInfoMsg mVipMsg;
    private ArrayList<ShopMsg> mShopLeftList = new ArrayList<>();
    private PayTypeMsg moren;//默认支付
    private ArrayList<PayTypeMsg> paytypelist;
    private int refreshnum = 2;
    private boolean mIsLoadMore;
    private int mPageTotal;//数据总页数

    private boolean isGuaDan;
    private String orderCode, orderTime, vipCard;
    private List<ShopMsg> newShoplist;

    public QudanFragment() {

    }

    public QudanFragment(HomeActivity activity) {
        homeActivity = activity;
    }

    @Override
    public int getContentView() {
        return R.layout.dialog_gualist;
    }

    public void onCreated() {
        guadanListAdapter = new GuadanListAdapter();
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

    public void guaDan(String CO_OrderCode, String OrderTime, String VIP_Card, List<ShopMsg> shoplist,
                       final InterfaceBack back) {
        this.isGuaDan = true;
        this.back = back;
        this.orderCode = CO_OrderCode;
        this.orderTime = OrderTime;
        this.vipCard = VIP_Card;
        this.newShoplist = shoplist;

        obtainGuadanList();
    }

    public void getGuaDan(PayTypeMsg moren, ArrayList<PayTypeMsg> paytypelist, InterfaceBack back) {
        this.moren = moren;
        this.paytypelist = paytypelist;
        this.back = back;
        this.isGuaDan = false;
        obtainGuadanList();
    }

    private void jiesuan(GuadanList guadanList, VipInfoMsg mVipMsg) {
        homeActivity.jiesuanBFragment.show(homeActivity, R.id.fragment_content);
        homeActivity.jiesuanBFragment.setData(guadanList.getCO_TotalPrice(), guadanList.getCO_TotalPrice(), mVipMsg,
                guadanList.getGID(), guadanList.getCO_Type(), guadanList.getCO_OrderCode(),
                mShopLeftList, moren, paytypelist, JiesuanBFragment.OrderType.GUAZHANG_ORDER, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        homeActivity.jiesuanBFragment.hide();
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
            }

        }
    }

    public void obtainGuadanList() {
        obtainGuadanList(1);
    }

    private void obtainGuadanList(int index) {
        RequestParams params = new RequestParams();
        params.put("PageIndex", index);
        params.put("PageSize", 20);
        params.put("CO_TypeCode", "SPXF");
        params.put("SM_GID", MyApplication.loginBean.getShopID());
        params.put("IdentifyingState", 20);

        String url = HttpAPI.API().QUERYALL_LIST;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                BasePageRes basePageRes = response.getData(BasePageRes.class);
                Type listType = new TypeToken<List<GuadanList>>() {
                }.getType();
                mPageTotal = basePageRes.getPageTotal();
                List<GuadanList> sllist = basePageRes.getData(listType);
                if (!mIsLoadMore) {
                    list.clear();
                }
                for (GuadanList guadanList : sllist) {
                    if (guadanList.getCO_IdentifyingState().equals("1") || guadanList.getCO_IdentifyingState().equals("8")) {
                        list.add(guadanList);
                    }
                }
                upData();
                homeActivity.cashierFragment.updateBttGetOrder();
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                listview.refreshComplete();
                listview.loadMoreComplete();
            }
        });
    }

    public void upData() {
        if (this.isResumed()) {
            guadanListAdapter.notifyDataSetChanged();
            mIsLoadMore = false;
            listview.refreshComplete();
            listview.loadMoreComplete();
        }
    }

    private void setView() {
        ivClose.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                back.onErrorResponse(null);
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });

        listview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                obtainGuadanList();
                refreshnum = 2;
            }

            @Override
            public void onLoadMore() {
                if (refreshnum <= mPageTotal) {
                    mIsLoadMore = true;
                    obtainGuadanList(refreshnum);
                    refreshnum++;
                } else {
//                    ToastUtils.showToast(context,"没有更多数据了");
                    com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了");
                    listview.setLoadingMoreEnabled(false);
                }
            }
        });

    }

    public int getListCount() {
        return list.size();
    }

    class GuadanListAdapter extends RecyclerView.Adapter {
        private Holder selectedHolder;

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getItemCount() {
            return isGuaDan ? list.size() + 1 : list.size();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_gualist, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            Holder holder1 = (Holder) holder;
            holder1.addGuadanLayout.setVisibility(View.GONE);
            holder1.itemLayout.setVisibility(View.VISIBLE);
            if (isGuaDan && position == 0) {
                holder1.addGuadanLayout.setVisibility(View.VISIBLE);
                holder1.itemLayout.setVisibility(View.GONE);

                holder1.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClick(holder1, null);
                    }
                });
            } else {
                GuadanList guadanList = list.get(isGuaDan ? position - 1 : position);
                holder1.tvCount.setText("数量：" + guadanList.getViewGoodsDetail().size() + "");
                holder1.tvTime.setText("挂单时间：" + guadanList.getCO_UpdateTime());
                if (!NullUtils.noNullHandle(guadanList.getVIP_Phone()).toString().equals("")) {
                    holder1.tvVipmsg.setText("会员：" + NullUtils.noNullHandle(guadanList.getVIP_Name()).toString() + "/" + NullUtils.noNullHandle(guadanList.getVIP_Phone()).toString());
                } else {
                    holder1.tvVipmsg.setText("会员：" + NullUtils.noNullHandle(guadanList.getVIP_Name()).toString());
                }
                holder1.tvOrdermoney.setText("金额：" + StringUtil.twoNum(NullUtils.noNullHandle(guadanList.getCO_TotalPrice()).toString()));

                holder1.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClick(holder1, guadanList);
                    }
                });
                holder1.deleteLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new ImpSubmitOrder().closeGuadanOrder(homeActivity, guadanList.getGID(), new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                list.remove(guadanList);
                                notifyDataSetChanged();
                                com.blankj.utilcode.util.ToastUtils.showShort("删除挂单");
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                com.blankj.utilcode.util.ToastUtils.showShort("删除挂单失败" + msg);
                            }
                        });
                    }
                });
            }
            if (selectedHolder != null) {
                selectedHolder.rootView.setBackgroundResource(R.drawable.bg_edittext_normal);
                selectedHolder.tvTime.setTextColor(homeActivity.getResources().getColor(R.color.text60));
                ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(0xffEBEBF5);
            }
        }

        private void itemClick(Holder holder1, GuadanList guadanList) {
            homeActivity.dialog.show();
            if (selectedHolder != null) {
                selectedHolder.rootView.setBackgroundResource(R.drawable.bg_edittext_normal);
                selectedHolder.tvTime.setTextColor(homeActivity.getResources().getColor(R.color.text60));
                ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(0xffEBEBF5);
            }
            selectedHolder = holder1;
            selectedHolder.rootView.setBackgroundResource(R.drawable.bg_edittext_focused);
            selectedHolder.tvTime.setTextColor(homeActivity.getResources().getColor(R.color.white));
            ((BgFrameLayout) selectedHolder.tvTime.getParent()).setSolidColor(homeActivity.getResources().getColor(R.color.textgreen));
            if (isGuaDan) {
                if (guadanList == null) {
                    submitGuaOrder("挂单");
                } else {
                    homeActivity.dialog.dismiss();
                    NoticeDialog.noticeDialog(homeActivity, "提示", "您确定要替换该销售单吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            new ImpSubmitOrder().closeGuadanOrder(homeActivity, guadanList.getGID(), new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    list.remove(guadanList);
                                    notifyDataSetChanged();
                                    submitGuaOrder("替换销售单");
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    com.blankj.utilcode.util.ToastUtils.showShort("替换销售单失败" + msg);
                                }
                            });
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                }
            } else {
                if (guadanList.getCO_IdentifyingState().equals("1")) {//挂单
                    //解挂接口
                    RequestParams params = new RequestParams();
                    params.put("GID", guadanList.getGID());
                    String url = HttpAPI.API().REVOKE_GUADAN;
                    AsyncHttpUtils.postHttp(url, params, new CallBack() {
                        @Override
                        public void onResponse(BaseRes response) {
                            homeActivity.dialog.dismiss();
                            back.onResponse(response.getData(RevokeGuaDanBean.class));
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                            list.remove(guadanList);
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            super.onErrorResponse(msg);
                            homeActivity.dialog.dismiss();
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                        }
                    });
                } else if (guadanList.getCO_IdentifyingState().equals("8")) {//挂账
                    initGetOrder(guadanList);
                    //可抵扣金额= 会员积分/积分抵扣百分比 *积分支付限制百分比
                    if (!guadanList.getVIP_Card().equals("00000")) {
                        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
                        onlyVipMsg.vipMsg(guadanList.getVIP_Card(), new InterfaceBack<VipInfoMsg>() {
                            @Override
                            public void onResponse(VipInfoMsg response) {
                                mVipMsg = response;
                                homeActivity.dialog.dismiss();
                                jiesuan(guadanList, mVipMsg);
                                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                                event.setMsg("Change_color");
                                EventBus.getDefault().post(event);
                                list.remove(guadanList);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                homeActivity.dialog.dismiss();
                            }
                        });
                    } else {
                        jiesuan(guadanList, null);
                        homeActivity.dialog.dismiss();
                    }
                }
            }
        }

        private void submitGuaOrder(String message) {
            new ImpSubmitOrder().submitGuaOrder(homeActivity, orderCode, orderTime, vipCard, newShoplist, new InterfaceBack<OrderCanshhu>() {
                @Override
                public void onResponse(OrderCanshhu response) {
                    com.blankj.utilcode.util.ToastUtils.showShort(message + "成功");

                    obtainGuadanList();
                    back.onResponse(null);
                    homeActivity.dialog.dismiss();
                }

                @Override
                public void onErrorResponse(Object msg) {
                    com.blankj.utilcode.util.ToastUtils.showShort(message + "失败" + msg);
                    homeActivity.dialog.dismiss();
                }
            });
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        class Holder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_vipmsg)
            TextView tvVipmsg;
            @BindView(R.id.tv_ordermoney)
            TextView tvOrdermoney;
            @BindView(R.id.tv_count)
            TextView tvCount;
            @BindView(R.id.tv_time)
            TextView tvTime;
            @BindView(R.id.delete_layout)
            View deleteLayout;
            @BindView(R.id.item_layout)
            View itemLayout;
            @BindView(R.id.add_guadan_layout)
            View addGuadanLayout;
            View rootView;

            public Holder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                rootView = view;
            }
        }
    }

}

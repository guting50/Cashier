package com.wycd.yushangpu.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maimengmami.waveswiperefreshlayout.WaveSwipeRefreshLayout;
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
import com.wycd.yushangpu.tools.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class QudanDialog extends Dialog {
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
    ListView listview;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.srl_freshmanage_activity)
    WaveSwipeRefreshLayout mRefresh;
    private InterfaceBack back;
    private List<GuadanList> list;
    private Activity context;
    public Dialog dialog;
    private GuadanListAdapter guadanListAdapter;
    private String yue;
    private String jifen;
    private boolean ismember;
    private double dkmoney;
    private VipDengjiMsg.DataBean mVipMsg;
    private List<ShopMsg> mShopLeftList = new ArrayList<>();
    private PayTypeMsg moren;//默认支付
    private List<PayTypeMsg> paytypelist;
    private String jifendkbfb, jinfenzfxzbfb;
    private int refreshnum = 2;
    private boolean mIsLoadMore;
    private int mPageTotal;//数据总页数
    private String mSmGid;

    public QudanDialog(Activity context, PayTypeMsg moren, List<PayTypeMsg> paytypelist, String mSmGid ,InterfaceBack back) {
        super(context, R.style.ActionSheetDialogStyle);
        this.back = back;
        this.context = context;
        this.moren = moren;
        this.mSmGid = mSmGid;
        this.paytypelist = paytypelist;
        dialog = LoadingDialog.loadingDialog(context, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_gualist);
        ButterKnife.bind(this);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        list = new ArrayList<>();
        guadanListAdapter = new GuadanListAdapter(context, list, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                final GuadanList guadanList = (GuadanList) response;
                if (guadanList.getCO_IdentifyingState().equals("1")) {//挂单
                    //解挂接口
                    dialog.show();
                    ImpRevokeGuaDanOrder impRevokeGuaDanOrder = new ImpRevokeGuaDanOrder();
                    impRevokeGuaDanOrder.revokeGuaDan(context, guadanList.getGID(), new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            dialog.dismiss();
                            dismiss();
                            RevokeGuaDanBean guaDanBean = (RevokeGuaDanBean) response;
                            back.onResponse(guaDanBean);
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            dialog.dismiss();
                            HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                            event.setMsg("Change_color");
                            EventBus.getDefault().post(event);
                        }
                    });
                } else if (guadanList.getCO_IdentifyingState().equals("8")) {//挂账
                    initGetOrder(guadanList);
                    //可抵扣金额= 会员积分/积分抵扣百分比 *积分支付限制百分比
                    if (!guadanList.getVIP_Card().equals("00000")) {
                        dialog.show();
                        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
                        onlyVipMsg.vipMsg(context, guadanList.getVIP_Card(), new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                VipDengjiMsg mVipDengjiMsg = (VipDengjiMsg) response;
                                dialog.dismiss();
                                mVipMsg = mVipDengjiMsg.getData().get(0);
                                yue = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableBalance() + "";
                                jifen = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableIntegral() + "";
                                String s = CommonUtils.multiply(jifen, jinfenzfxzbfb);
                                ismember = null == mVipMsg ? false : true;
                                dkmoney = CommonUtils.div(Double.parseDouble(s), Double.parseDouble(jifendkbfb), 2);//可抵扣金额
                                jiesuan(guadanList,mVipMsg);
                                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                                event.setMsg("Change_color");
                                EventBus.getDefault().post(event);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                    } else {
                        yue = "0.00";
                        jifen = "0.00";
                        ismember = false;
                        dkmoney = 0.00;//可抵扣金额

                        jiesuan(guadanList,null);
                    }


                }

            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
        listview.setAdapter(guadanListAdapter);
        setView();
        obtainGuadanList(1);
    }

    private void jiesuan(GuadanList guadanList,VipDengjiMsg.DataBean mVipMsg) {
        final JiesuanBDialog jiesuanBDialog = new JiesuanBDialog(context, guadanList.getCO_TotalPrice(), yue, jifen, mVipMsg,dkmoney + "", ismember, guadanList.getGID(),
                guadanList.getCO_Type(), guadanList.getCO_OrderCode(), mShopLeftList, moren, paytypelist, true, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
//                ToastUtils.showToast(context, "结算成功");
                com.blankj.utilcode.util.ToastUtils.showShort("结算成功");
                mShopLeftList.clear();
                obtainGuadanList(1);
//                                    mTvShoukuan.setText("收 款  ￥ 0.00");
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });
        jiesuanBDialog.show();

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

    private void obtainGuadanList(int index) {
        dialog.show();
        ImpGuadanList shopHome = new ImpGuadanList();
        shopHome.guadanList(context, index, 20, mSmGid,new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
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
//                list.addAll(sllist);
                    guadanListAdapter.notifyDataSetChanged();

                    mIsLoadMore = false;
                    mRefresh.setRefreshing(false);
                    mRefresh.setLoading(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


//                List<GuadanList> sllist = (List<GuadanList>) response;


            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });

    }

    private void setView() {
        ivClose.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });


        mRefresh.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                obtainGuadanList(1);
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

        for (PayTypeMsg msg : paytypelist) {
            if (msg.getSS_Name().equals("积分支付")) {
                jifendkbfb = msg.getSS_Value();
            }
            if (msg.getSS_Name().equals("积分支付限制")) {
                jinfenzfxzbfb = msg.getSS_Value();
            }

        }

    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);
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
}

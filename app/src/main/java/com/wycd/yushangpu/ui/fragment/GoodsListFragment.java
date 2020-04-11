package com.wycd.yushangpu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ClassMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpShopHome;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.ui.HomeActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.tab_all)
    TextView tabAll;
    @BindView(R.id.tab_all_indicator)
    View tabAllIndicator;
    @BindView(R.id.goods_list)
    XRecyclerView goodsList;
    @BindView(R.id.empty_state_layout)
    FrameLayout emptyStateLayout;

    private List<ClassMsg> mClassMsgList = new ArrayList<>();//分类数据列表
    private int PageIndex = 1;
    private int PageSize = 20;
    public String PT_GID = "";

    HomeActivity homeActivity;
    Adapter adapter;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_goods_list, null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
        homeActivity = (HomeActivity) getActivity();

        initView();
        obtainShopClass();

        obtainHomeShop(true);
    }

    private void initView() {
        goodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter();
        goodsList.setAdapter(adapter);

//        goodsList.setLoadingMoreEnabled(false);
        //刷新或加载更多
        goodsList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                obtainHomeShop(false);
            }

            @Override
            public void onLoadMore() {
                // load more data here
                obtainHomeShop("", ++PageIndex, false);
            }
        });
    }

    private void obtainShopClass() {
        String url = HttpAPI.API().PRODUCTTYPE;
        AsyncHttpUtils.postHttp(url, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<ClassMsg>>() {
                }.getType();
                List<ClassMsg> sllist = response.getData(listType);
                mClassMsgList.clear();
                mClassMsgList.addAll(sllist);

                ClassMsg classMsg0 = new ClassMsg();
                classMsg0.setChose(true);
                classMsg0.setPT_Name("全部");
                classMsg0.setGID("");
                mClassMsgList.add(0, classMsg0);

                ClassMsg classMsg1 = new ClassMsg();
                classMsg1.setChose(false);
                classMsg1.setPT_Name("套餐");
                classMsg1.setGID("combo");
                mClassMsgList.add(1, classMsg1);

//                for (ClassMsg classMsg : sllist) {
//                    if (!NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals("")) {
//                        for (int i = 0; i < mClassMsgList.size(); i++) {
//                            if (NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals(NullUtils.noNullHandle(mClassMsgList.get(i).getGID()).toString())) {
//                                mClassMsgList.get(i).setTwolist(classMsg);
//                            }
//                        }
//                    }
//                }

                for (ClassMsg item : mClassMsgList) {
                    TabLayout.Tab tab = tabLayout.newTab();
                    LinearLayout layout = tab.view;
                    layout.setBackgroundResource(R.color.transparent);
                    tab.setText(item.getPT_Name());
                    tab.setTag(item.getGID());
                    tabLayout.addTab(tab);
                }

                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        PT_GID = tab.getTag().toString();
                        obtainHomeShop(true);
                        if (tab.getPosition() > 0) {
                            tabAll.setTextColor(getContext().getResources().getColor(R.color.text66));
                            tabAll.setBackgroundResource(R.color.textf5);
                            tabAllIndicator.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        obtainHomeShop(true);
                    }
                });
                tabAll.setVisibility(View.VISIBLE);
                tabAllIndicator.setVisibility(View.VISIBLE);
                tabAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tabLayout.getTabAt(0).select();
                        tabAll.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
                        tabAll.setBackgroundResource(R.color.texted);
                        tabAllIndicator.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }

    public void obtainHomeShop(boolean isShowDialog) {
        obtainHomeShop("", isShowDialog);
    }

    public void obtainHomeShop(String PM_CodeOrNameOrSimpleCode, boolean isShowDialog) {
        PageIndex = 1;
        obtainHomeShop(PM_CodeOrNameOrSimpleCode, PageIndex, isShowDialog);
    }

    public void obtainHomeShop(String PM_CodeOrNameOrSimpleCode, int pageIndex, boolean isShowDialog) {
        if (isShowDialog)
            homeActivity.dialog.show();
        ImpShopHome shopHome = new ImpShopHome();
        shopHome.shoplist(pageIndex, PageSize, PT_GID, PM_CodeOrNameOrSimpleCode, new InterfaceBack<BasePageRes>() {
            @Override
            public void onResponse(BasePageRes response) {
                Type listType = new TypeToken<List<ShopMsg>>() {
                }.getType();
                List<ShopMsg> sllist = response.getData(listType);

                homeActivity.mEtLoginAccount.setText("");
                if (PageIndex == 1) {
                    adapter.getShopMsgList().clear();
                }
                adapter.addShopMsgList(sllist);
//                 int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
//                for (ShopMsg msg : sllist) {
//                    if (NullUtils.noNullHandle(msg.getPM_IsService()).toString().equals("2")) {
//                        adapter.getShopMsgList().remove(msg);
//                    }
//                }
                adapter.notifyDataSetChanged();
                homeActivity.dialog.dismiss();
                emptyStateLayout.setVisibility(View.GONE);
                if (adapter.getShopMsgList().size() <= 0) {
                    emptyStateLayout.setVisibility(View.VISIBLE);
                }
                goodsList.refreshComplete();
                goodsList.loadMoreComplete();

                if (response.getDataCount() <= adapter.getShopMsgList().size()) {
                    goodsList.setLoadingMoreEnabled(false);
                } else {
                    goodsList.setLoadingMoreEnabled(true);
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                homeActivity.dialog.dismiss();
                goodsList.refreshComplete();
                goodsList.loadMoreComplete();
            }
        });
    }

    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<ShopMsg> shopMsgList = new ArrayList<>();
        int spanCount = 15;

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_home_rightshop_root, parent, false);
            return new RootHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            RootHolder myRootHolder = (RootHolder) holder;
            myRootHolder.init();
            for (int i = 0; i < (position < getItemCount() - 1 ? spanCount : shopMsgList.size() - (position * spanCount)); i++) {
                onBindViewHolder(myRootHolder.itemViews.get(i), shopMsgList.get(position * spanCount + i));
            }
        }

        private void onBindViewHolder(Holder myHolder, ShopMsg ts) {
            myHolder.rootView.setVisibility(View.VISIBLE);
            ((View) myHolder.rootView.getParent()).setVisibility(View.VISIBLE);
            ts.init();
            myHolder.mTvName.setText(NullUtils.noNullHandle(ts.getPM_Name()).toString());
            Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(ts.getPM_BigImg()).toString()))
                    .placeholder(R.mipmap.messge_nourl)
                    .transform(new CenterCrop(getContext()), new GlideTransform.GlideCornersTransform(getContext(), 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(myHolder.mIvShop);

            myHolder.mTvXinghao.setText(NullUtils.noNullHandle(ts.getPM_Modle()).toString());
            //库存
//        if (ts.getPM_Metering() != null) {
//            myHolder.mTvKunum.setText(String.valueOf(ts.getCurrtStock_Number()) + ts.getPM_Metering());
//        } else {
            myHolder.mTvKunum.setText(ts.getStock_Number() + "");
//        }

            myHolder.mIvState.setText(ts.PM_IsServiceText);
            myHolder.mIvState.setTextColor(getContext().getResources().getColor(ts.StateTextColor));
            myHolder.mIvKu.setVisibility(ts.KuVisibility);
            myHolder.mTvKunum.setVisibility(ts.KuVisibility);

//        PM_IsDiscount	商品折扣	int	0关闭 1开启

//        2、textView设置中划线
//        myHolder.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
//        myHolder.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
//
//        3、textView取消中划线或者下划线
//        myHolder.mTvVipprice.getPaint().setFlags(0); // 取消设置的的划线


            myHolder.mTvVipprice.setText(ts.TvVippriceText);
            myHolder.mTvSanprice.getPaint().setFlags(ts.TvSanpriceFlags); //中划线
            myHolder.mTvSanprice.setTextColor(getContext().getResources().getColor(ts.TvSanpriceTextColor));

            myHolder.mTvSanprice.setText("售：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString()));
            myHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homeActivity.addCashierList(ts);
                }
            });
        }

        public List<ShopMsg> getShopMsgList() {
            return shopMsgList;
        }

        public void addShopMsgList(List<ShopMsg> shopMsgList) {
            this.shopMsgList.addAll(shopMsgList);
        }

        @Override
        public int getItemCount() {
//            return shopMsgList.size();
            return shopMsgList.size() % spanCount == 0 ? shopMsgList.size() / spanCount : shopMsgList.size() / spanCount + 1;
        }
    }

    class RootHolder extends RecyclerView.ViewHolder {

        List<View> rowViews = new ArrayList<>();
        List<Holder> itemViews = new ArrayList<>();

        public RootHolder(@NonNull View itemView) {
            super(itemView);
            int rows = ((ViewGroup) itemView).getChildCount();
            for (int i = 0; i < rows; i++) {
                ViewGroup rowView = (ViewGroup) ((ViewGroup) itemView).getChildAt(i);
                rowViews.add(rowView);
                for (int j = 0; j < rowView.getChildCount(); j++) {
                    itemViews.add(new Holder(rowView.getChildAt(j)));
                }
            }
        }

        public void init() {
            for (View view : rowViews) {
                view.setVisibility(View.GONE);
            }
            for (Holder holder : itemViews) {
                holder.rootView.setVisibility(View.INVISIBLE);
            }
        }
    }

    class Holder extends RecyclerView.ViewHolder {

        View rootView;
        @BindView(R.id.iv_shop)
        ImageView mIvShop;
        @BindView(R.id.iv_state)
        TextView mIvState;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_xinghao)
        TextView mTvXinghao;
        @BindView(R.id.tv_sanprice)
        TextView mTvSanprice;
        @BindView(R.id.tv_vipprice)
        TextView mTvVipprice;
        @BindView(R.id.iv_ku)
        TextView mIvKu;
        @BindView(R.id.tv_kunum)
        TextView mTvKunum;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView = itemView;
        }
    }
}

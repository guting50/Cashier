package com.wycd.yushangpu.ui.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.OnNoDoubleClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ClassMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpShopClass;
import com.wycd.yushangpu.model.ImpShopHome;
import com.wycd.yushangpu.tools.CommonUtils;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.goods_list)
    XRecyclerView goodsList;
    @BindView(R.id.empty_state_layout)
    FrameLayout emptyStateLayout;

    private List<ClassMsg> mClassMsgList = new ArrayList<>();//分类数据列表
    private int PageIndex = 1;
    private int PageSize = 100;

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

        obtainHomeShop("", "");
    }

    private void initView() {
        int spanCount = 3;
//        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        if (width > 1600) {
//            spanCount = 5;
//        } else if (width < 1300) {
//            spanCount = 3;
//        }
        GridLayoutManager glm = new GridLayoutManager(getContext(), spanCount);
        goodsList.setLayoutManager(glm);
        adapter = new Adapter();
        goodsList.setAdapter(adapter);

        goodsList.setLoadingMoreEnabled(false);
        //刷新或加载更多
        goodsList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                obtainHomeShop("", false);
            }

            @Override
            public void onLoadMore() {
                // load more data here
                obtainHomeShop("", "", ++PageIndex, false);
            }
        });
    }

    private void obtainShopClass() {
        ImpShopClass shopClass = new ImpShopClass();
        shopClass.shopclass(getActivity(), new InterfaceBack() {//获取商品列表
            @Override
            public void onResponse(Object response) {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<ClassMsg>>() {
                }.getType();
                List<ClassMsg> sllist = gson.fromJson(response.toString(), listType);
                mClassMsgList.clear();
                mClassMsgList.addAll(sllist);
                for (ClassMsg classMsg : sllist) {
                    if (!NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals("")) {
                        for (int i = 0; i < mClassMsgList.size(); i++) {
                            if (NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals(NullUtils.noNullHandle(mClassMsgList.get(i).getGID()).toString())) {
                                mClassMsgList.get(i).setTwolist(classMsg);
                            }
                        }
                    }
                }

                ClassMsg classMsg = new ClassMsg();
                classMsg.setChose(true);
                classMsg.setPT_Name("全部");
                classMsg.setGID("");
                mClassMsgList.add(0, classMsg);

                ClassMsg classMsg1 = new ClassMsg();
                classMsg1.setChose(false);
                classMsg1.setPT_Name("套餐");
                classMsg1.setGID("combo");
                mClassMsgList.add(1, classMsg1);


                for (ClassMsg item : mClassMsgList) {
                    TabLayout.Tab tab = tabLayout.newTab();
//                    tab.getCustomView().setLayoutParams(new FrameLayout.LayoutParams(100, ViewGroup.LayoutParams.MATCH_PARENT));
                    tab.setText(item.getPT_Name());
                    tab.setTag(item.getGID());
                    tabLayout.addTab(tab);
                }

                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        obtainHomeShop("", tab.getTag().toString());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });
    }

    public void obtainHomeShop(String PT_GID, boolean isShowDialog) {
        obtainHomeShop(PT_GID, homeActivity.mEtLoginAccount.getText().toString(), PageIndex, isShowDialog);
    }

    public void obtainHomeShop(String PT_GID, String PM_CodeOrNameOrSimpleCode) {
        PageIndex = 1;
        obtainHomeShop(PT_GID, PM_CodeOrNameOrSimpleCode, PageIndex, true);
    }

    public void obtainHomeShop(String PT_GID, String PM_CodeOrNameOrSimpleCode, int pageIndex, boolean isShowDialog) {
        if (isShowDialog)
            homeActivity.dialog.show();
        ImpShopHome shopHome = new ImpShopHome();
        shopHome.shoplist(getActivity(), pageIndex, PageSize, PT_GID, PM_CodeOrNameOrSimpleCode, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                List<ShopMsg> sllist = (List<ShopMsg>) response;
                homeActivity.mEtLoginAccount.setText("");
                if (PageIndex == 1) {
                    adapter.getShopMsgList().clear();
                }
                adapter.addShopMsgList(sllist);
//                 int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
                for (ShopMsg msg : sllist) {
                    if (NullUtils.noNullHandle(msg.getPM_IsService()).toString().equals("2")) {
                        adapter.getShopMsgList().remove(msg);
                    }
                }
                adapter.notifyDataSetChanged();
                homeActivity.dialog.dismiss();
                emptyStateLayout.setVisibility(View.GONE);
                if (adapter.getShopMsgList().size() <= 0) {
                    emptyStateLayout.setVisibility(View.VISIBLE);
                }
                goodsList.refreshComplete();
                goodsList.loadMoreComplete();
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

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_home_rightshop, null);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ShopMsg ts = shopMsgList.get(position);
            Holder myHolser = (Holder) holder;
            myHolser.mTvName.setText(NullUtils.noNullHandle(ts.getPM_Name()).toString());
            Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(ts.getPM_BigImg()).toString()))
                    .placeholder(R.mipmap.messge_nourl)
                    .transform(new CenterCrop(getContext()), new GlideTransform.GlideCornersTransform(getContext(), 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(myHolser.mIvShop);

            myHolser.mTvXinghao.setText(NullUtils.noNullHandle(ts.getPM_Modle()).toString());
            //库存
//        if (ts.getPM_Metering() != null) {
//            myHolser.mTvKunum.setText(String.valueOf(ts.getCurrtStock_Number()) + ts.getPM_Metering());
//        } else {
            myHolser.mTvKunum.setText(ts.getStock_Number() + "");
//        }

//        myHolser.mTvKunum.setText(NullUtils.noNullHandle(ts.getPM_Repertory()).toString());
//        int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
            switch (NullUtils.noNullHandle(ts.getPM_IsService()).toString()) {
                case "0":
                    myHolser.mIvState.setText("普");
                    myHolser.mIvState.setTextColor(getContext().getResources().getColor(R.color.textblue));
//                myHolser.mIvState.setBackgroundResource(R.drawable.home_pu);
                    myHolser.mIvKu.setVisibility(View.VISIBLE);
                    myHolser.mTvKunum.setVisibility(View.VISIBLE);
                    break;
                case "1":
                    myHolser.mIvState.setText("服");
                    myHolser.mIvState.setTextColor(getContext().getResources().getColor(R.color.textgreen));
                    myHolser.mIvKu.setVisibility(View.INVISIBLE);
                    myHolser.mTvKunum.setVisibility(View.INVISIBLE);
                    break;
                case "2":
                    myHolser.mIvState.setText("礼");
                    myHolser.mIvState.setTextColor(getContext().getResources().getColor(R.color.textred));
//                myHolser.mIvState.setBackgroundResource(R.drawable.shop_li);
                    myHolser.mIvKu.setVisibility(View.VISIBLE);
                    myHolser.mTvKunum.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    myHolser.mIvState.setText("套");
                    myHolser.mIvState.setTextColor(getContext().getResources().getColor(R.color.textblue));
//                myHolser.mIvState.setBackgroundResource(R.drawable.shop_pt);
                    myHolser.mIvKu.setVisibility(View.INVISIBLE);
                    myHolser.mTvKunum.setVisibility(View.INVISIBLE);
                    break;
                case "4":
                    myHolser.mIvState.setText("套");
                    myHolser.mIvState.setTextColor(getContext().getResources().getColor(R.color.textgreen));
//                myHolser.mIvState.setBackgroundResource(R.drawable.shop_ci);
                    myHolser.mIvKu.setVisibility(View.INVISIBLE);
                    myHolser.mTvKunum.setVisibility(View.INVISIBLE);
                    break;
            }
//        PM_IsDiscount	商品折扣	int	0关闭 1开启

//        2、textView设置中划线
//        myHolser.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
//        myHolser.mTvVipprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
//
//        3、textView取消中划线或者下划线
//        myHolser.mTvVipprice.getPaint().setFlags(0); // 取消设置的的划线

            if (NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")) {
                if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferMoney()).toString().equals("0.0") && ts.getPM_SpecialOfferMoney() != -1) {
                    //无最低折扣
                    myHolser.mTvVipprice.setText("特：" + ts.getPM_SpecialOfferMoney());
                    myHolser.mTvSanprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
                    myHolser.mTvSanprice.setTextColor(getContext().getResources().getColor(R.color.a5a5a5));

                } else if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")) {
                    //有特价折扣
                    if (NullUtils.noNullHandle(ts.getPM_MinDisCountValue()).toString().equals("0.0")) {
                        //无最低折扣
                        myHolser.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_SpecialOfferValue() + "")));
                    } else {
                        //有最低折扣
                        if (ts.getPM_SpecialOfferValue() > ts.getPM_MinDisCountValue()) {
                            myHolser.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_SpecialOfferValue() + "")));
                        } else {
                            myHolser.mTvVipprice.setText("特：" + StringUtil.twoNum(CommonUtils.multiply(ts.getPM_UnitPrice() + "", ts.getPM_MinDisCountValue() + "")));
                        }
                    }
                    myHolser.mTvSanprice.setTextColor(getContext().getResources().getColor(R.color.a5a5a5));
                    myHolser.mTvSanprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
                } else {
                    //无特价折扣
                    if (!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                        //有会员价
                        myHolser.mTvVipprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
                    } else {
                        myHolser.mTvVipprice.setText("");
                    }
                    myHolser.mTvSanprice.getPaint().setFlags(0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
//                    myHolser.mTvSanprice.setTextColor(getContext().getResources().getColor(R.color.textred));
                }
            } else {
                if (!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                    myHolser.mTvVipprice.setText("会：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_MemPrice()).toString()));
                } else {
                    myHolser.mTvVipprice.setText("");
                }
                myHolser.mTvSanprice.getPaint().setFlags(0 | Paint.ANTI_ALIAS_FLAG); // 取消设置的的划线
//                myHolser.mTvSanprice.setTextColor(getContext().getResources().getColor(R.color.textred));
            }
            myHolser.mTvSanprice.setText("售：" + StringUtil.twoNum(NullUtils.noNullHandle(ts.getPM_UnitPrice()).toString()));

            myHolser.rootView.setOnClickListener(new OnNoDoubleClickListener() {
                @Override
                public void onNoDoubleClick(View v) {
                    homeActivity.addCashierList(ts);
                }
            });
        }

        public void setShopMsgList(List<ShopMsg> shopMsgList) {
            this.shopMsgList = shopMsgList;
        }

        public List<ShopMsg> getShopMsgList() {
            return shopMsgList;
        }

        public void addShopMsgList(List<ShopMsg> shopMsgList) {
            this.shopMsgList.addAll(shopMsgList);
        }

        @Override
        public int getItemCount() {
            return shopMsgList.size();
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

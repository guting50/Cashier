package com.wycd.yushangpu.ui.fragment;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.LabelBean;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.SysSwitchType;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.tools.MyOnEditorActionListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.widget.views.GtEditText;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipMemberFragment extends BaseFragment {
    @BindView(R.id.search_list)
    XRecyclerView searchList;
    @BindView(R.id.edit_text_layout)
    GtEditText editTextLayout;
    @BindView(R.id.tv_member_count)
    TextView tvMemberCount;
    @BindView(R.id.member_head_info_layout)
    RelativeLayout memberHeadInfoLayout;
    @BindView(R.id.member_info_layout)
    RelativeLayout memberInfoLayout;
    @BindView(R.id.null_state_layout)
    LinearLayout nullStateLayout;

    private MemberAdapter memberAdapter;
    private int pageIndex = 1;

    private AddOrEditMemberFragment addOrEditMemberFragment = new AddOrEditMemberFragment();
    private MemberRechargeFragment memberRechargeFragment = new MemberRechargeFragment();
    private VipInfoMsg infoMsg;
    private ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();

    public int getContentView() {
        return R.layout.fragment_vip_member;
    }

    public void onCreated() {
        searchList.setLayoutManager(new LinearLayoutManager(homeActivity));
        memberAdapter = new MemberAdapter();
        searchList.setAdapter(memberAdapter);

        searchList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pageIndex = 1;
                obtainVipList();
            }

            @Override
            public void onLoadMore() {
                pageIndex++;
                obtainVipList();
            }
        });
        showAttr();
        editTextLayout.setOnEditorActionListener(new MyOnEditorActionListener(homeActivity) {
            @Override
            public void onEditorAction(String text) {
                obtainVipList();
            }
        });
        editTextLayout.setKeyEventCallback((keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                obtainVipList();
            }
            return true;
        });
    }

    @Override
    protected void updateData() {
        super.updateData();
        reset();
    }

    public void reset() {
        obtainVipList();
        memberHeadInfoLayout.setVisibility(View.GONE);
        memberInfoLayout.setVisibility(View.GONE);
        addOrEditMemberFragment.hide();
        memberRechargeFragment.hide();
    }

    @OnClick({R.id.li_search, R.id.iv_clone, R.id.iv_add_member, R.id.ly_vip_recharge, R.id.ly_goods_consume, R.id.ly_update_info})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.li_search:
                obtainVipList();
                break;
            case R.id.iv_clone:
                memberHeadInfoLayout.setVisibility(View.GONE);
                memberInfoLayout.setVisibility(View.GONE);
                if (memberAdapter.selectedHolder != null)
                    memberAdapter.selectedHolder.rootView.setBackgroundResource(R.color.white);
                break;
            case R.id.iv_add_member://新增会员
                addOrEditMemberFragment.show(homeActivity, R.id.fragment_vip_content);
                addOrEditMemberFragment.setData(null);
                break;
            case R.id.ly_update_info://修改资料
                addOrEditMemberFragment.show(homeActivity, R.id.fragment_vip_content);
                addOrEditMemberFragment.setData(infoMsg);
                break;
            case R.id.ly_vip_recharge://会员充值
                memberRechargeFragment.show(homeActivity, R.id.fragment_vip_content);
                homeActivity.dialog.show();
                onlyVipMsg.vipMsg(infoMsg.getVCH_Card(), new InterfaceBack<VipInfoMsg>() {
                    @Override
                    public void onResponse(VipInfoMsg response) {
                        homeActivity.dialog.dismiss();
                        memberRechargeFragment.setData(response);
                    }
                });
                break;
            case R.id.ly_goods_consume://商品消费
                homeActivity.onTaskbarClick(homeActivity.btn_cashier);
                homeActivity.dialog.show();
                onlyVipMsg.vipMsg(infoMsg.getVCH_Card(), new InterfaceBack<VipInfoMsg>() {
                    @Override
                    public void onResponse(VipInfoMsg response) {
                        homeActivity.dialog.dismiss();
                        homeActivity.cashierFragment.selectedVIP(response);
                    }
                });
                break;
        }
    }

    private void obtainVipList() {
        homeActivity.dialog.show();
        if (pageIndex == 1) {
            memberAdapter.getList().clear();
        }
        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        String SM_GID = SysSwitchRes.getSwitch(SysSwitchType.T210.getV()).getSS_State() == 0 ? MyApplication.loginBean.getShopID() : "";
        onlyVipMsg.vipMsgs(editTextLayout.getText().toString(), pageIndex, 20, SM_GID, new InterfaceBack<BasePageRes>() {
            @Override
            public void onResponse(BasePageRes response) {
                homeActivity.dialog.dismiss();
                Type listType = new TypeToken<List<VipInfoMsg>>() {
                }.getType();
                List<VipInfoMsg> vipDengjiMsg = response.getData(listType);

                if (pageIndex == 1) {
                    memberAdapter.getList().clear();
                }
                memberAdapter.addAllList(vipDengjiMsg);
                memberAdapter.notifyDataSetChanged();
                if (response.getDataCount() <= memberAdapter.getList().size()) {
                    searchList.setLoadingMoreEnabled(false);
                } else {
                    searchList.setLoadingMoreEnabled(true);
                }
                searchList.loadMoreComplete();
                searchList.refreshComplete();

                tvMemberCount.setText("共有" + response.getDataCount() + "个会员");
                nullStateLayout.setVisibility(View.VISIBLE);
                if (response.getDataCount() > 0) {
                    nullStateLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onErrorResponse(Object msg) {
                homeActivity.dialog.dismiss();
                searchList.loadMoreComplete();
                searchList.refreshComplete();
            }
        });
    }

    private void showMemberInfo(VipInfoMsg info) {
        infoMsg = info;
        memberHeadInfoLayout.setVisibility(View.VISIBLE);
        memberInfoLayout.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(info.getVIP_HeadImg()).toString()))
                .placeholder(R.mipmap.member_head_nohead)
                .transform(new CenterCrop(homeActivity), new GlideTransform.GlideCornersTransform(homeActivity, 4))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) rootView.findViewById(R.id.iv_info_head_img));
        ((TextView) rootView.findViewById(R.id.tv_info_name)).setText(info.getVIP_Name());
        ((TextView) rootView.findViewById(R.id.tv_info_phone)).setText(info.getVIP_CellPhone());
        ((TextView) rootView.findViewById(R.id.tv_info_vg_Name)).setText("Lv." + info.getVG_Name());
        ((TextView) rootView.findViewById(R.id.tv_info_card)).setText(info.getVCH_Card());
        ((TextView) rootView.findViewById(R.id.tv_create_time)).setText(info.getVCH_CreateTime());
        ((TextView) rootView.findViewById(R.id.tv_referee)).setText(info.getVIP_Referee());
        ((TextView) rootView.findViewById(R.id.tv_birthday)).setText(info.getVIP_Birthday());
        ((TextView) rootView.findViewById(R.id.tv_email)).setText(info.getVIP_Email());
        ((TextView) rootView.findViewById(R.id.tv_fee)).setText(info.getVCH_Fee() + "");
        ((TextView) rootView.findViewById(R.id.tv_addr)).setText(info.getVIP_Addr());
        StringBuilder mLabName = new StringBuilder();
        if (!TextUtils.isEmpty(info.getVIP_Label())) {
            Type listType = new TypeToken<List<LabelBean>>() {
            }.getType();
            List<LabelBean> varLabBean = new Gson().fromJson(info.getVIP_Label(), listType);
            if (varLabBean != null) {
                for (int i = 0; i < varLabBean.size(); i++) {
                    if (i == varLabBean.size() - 1 || i == 0) {
                        mLabName.append(varLabBean.get(i).getItemName());
                    } else {
                        mLabName.append(varLabBean.get(i).getItemName() + "、");
                    }
                }
            }
        }
        ((TextView) rootView.findViewById(R.id.tv_label)).setText(mLabName);
        String VIP_State = "";
        switch (info.getVIP_State()) {
            case 0:
                VIP_State = "正常";
                break;
            case 1:
                VIP_State = "锁定";
                break;
            case 2:
                VIP_State = "挂失";
                break;
        }
        ((TextView) rootView.findViewById(R.id.tv_state)).setText(VIP_State);
        if (info.getVIP_IsForver() == 1) {
            ((TextView) rootView.findViewById(R.id.tv_overdue)).setText("永久");
        } else
            ((TextView) rootView.findViewById(R.id.tv_overdue)).setText(info.getVIP_Overdue());
        ((TextView) rootView.findViewById(R.id.tv_face_number)).setText(info.getVIP_FaceNumber());
        ((TextView) rootView.findViewById(R.id.tv_ic_card)).setText(info.getVIP_ICCard());
        ((TextView) rootView.findViewById(R.id.tv_g_id)).setText(info.getSM_Name());
        ((TextView) rootView.findViewById(R.id.tv_fixed_phone)).setText(info.getVIP_FixedPhone());
        ((TextView) rootView.findViewById(R.id.tv_em_name)).setText(info.getEM_Name());
        ((TextView) rootView.findViewById(R.id.tv_wx_vip)).setText("未绑定");
        if (!TextUtils.isEmpty(info.getVIP_OpenID()))
            ((TextView) rootView.findViewById(R.id.tv_wx_vip)).setText("已绑定");
    }

    class MemberAdapter extends RecyclerView.Adapter {

        private List<VipInfoMsg> list = new ArrayList<>();
        public MemberHolder selectedHolder;

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_member_layout, parent, false);
            return new MemberHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MemberHolder myHolder = (MemberHolder) holder;
            VipInfoMsg item = list.get(position);
            Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(item.getVIP_HeadImg()).toString()))
                    .placeholder(R.mipmap.member_head_nohead)
                    .transform(new CenterCrop(homeActivity), new GlideTransform.GlideCornersTransform(homeActivity, 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(myHolder.ivHeadImg);
            myHolder.tvCard.setText(item.getVCH_Card());
            myHolder.tvName.setText(item.getVIP_Name());
            myHolder.tvPhone.setText(item.getVIP_CellPhone());
            myHolder.rootView.setBackgroundResource(R.color.white);
            myHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (DateTimeUtil.isOverTime(item.getVCH_CreateTime())) {
                        ToastUtils.showLong("该会员还未到激活时间");
                        return;
                    }
                    if (selectedHolder != null)
                        selectedHolder.rootView.setBackgroundResource(R.color.white);
                    selectedHolder = myHolder;
                    myHolder.rootView.setBackgroundResource(R.color.texted);
                    showMemberInfo(item);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void addAllList(List<VipInfoMsg> list) {
            this.list.addAll(list);
        }

        public List<VipInfoMsg> getList() {
            return list;
        }
    }

    class MemberHolder extends RecyclerView.ViewHolder {

        View rootView;
        @BindView(R.id.iv_head_img)
        ImageView ivHeadImg;
        @BindView(R.id.tv_card)
        TextView tvCard;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;

        public MemberHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView = itemView;
        }
    }

    private void showAttr() {
        if (SysSwitchRes.getSwitch(SysSwitchType.T451.getV()).getSS_State() == 0) {//会员生日
            rootView.findViewById(R.id.tv_birthday).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_birthday_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T452.getV()).getSS_State() == 0) {//电子邮箱
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T453.getV()).getSS_State() == 0) {//身份证号
            rootView.findViewById(R.id.tv_ic_card).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_ic_card_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T454.getV()).getSS_State() == 0) {//固定电话
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T455.getV()).getSS_State() == 0) {//推荐人
            rootView.findViewById(R.id.tv_referee).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_referee_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T456.getV()).getSS_State() == 0) {//开卡人
            rootView.findViewById(R.id.tv_em_name).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_em_name_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T457.getV()).getSS_State() == 0) {//会员标签
            rootView.findViewById(R.id.tv_label).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_label_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T458.getV()).getSS_State() == 0) {//会员地址
            rootView.findViewById(R.id.tv_addr).setVisibility(View.GONE);
            rootView.findViewById(R.id.tv_addr_title).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T459.getV()).getSS_State() == 0) {//备注信息
        }
    }
}

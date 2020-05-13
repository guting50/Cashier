package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.SearchVipPopAdapter;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

import java.lang.reflect.Type;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ZPH on 2019-06-29.
 */

public class VipChooseDialog extends Dialog {

    private static String memoryText;

    @BindView(R.id.search_list)
    XRecyclerView searchList;

    private SearchVipPopAdapter searchVipPopAdapter;

    private Activity mContext;
    private InterfaceBack back;
    private Dialog dialog;
    private VipInfoMsg mVipDetail;
    private NumInputView editTextLayout;
    private int pageIndex = 1;

    public VipChooseDialog(Activity context, VipInfoMsg vipMsg, final InterfaceBack back) {
        super(context, R.style.ActionSheetDialogStyle);
        this.mContext = context;
        this.back = back;
        dialog = LoadingDialog.loadingDialog(context, 1);
        mVipDetail = vipMsg;
    }

    public void show() {
        super.show();
        searchList.setLayoutManager(new LinearLayoutManager(mContext));
        searchVipPopAdapter = new SearchVipPopAdapter(mContext, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                mVipDetail = (VipInfoMsg) response;

                ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
                onlyVipMsg.vipMsg(mVipDetail.getVCH_Card(), new InterfaceBack<VipInfoMsg>() {
                    @Override
                    public void onResponse(VipInfoMsg response) {
                        mVipDetail = response;
                        back.onResponse(mVipDetail);
                        dismiss();
                    }
                });
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
        if (mVipDetail != null) {
            searchVipPopAdapter.addList(mVipDetail);
            editTextLayout.setText(memoryText);
        }
        searchList.setAdapter(searchVipPopAdapter);
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
        obtainVipList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choose_vip);
        ButterKnife.bind(this);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        editTextLayout = (NumInputView) findViewById(R.id.edit_text_layout);

        new NumKeyboardUtils(mContext, getWindow().getDecorView(), editTextLayout);
    }

    @OnClick({R.id.iv_close, R.id.li_search, R.id.rl_confirm, R.id.rl_delete})
    public void onViewClicked(View view) {
        KeyboardUtils.hideSoftInput(view);
        switch (view.getId()) {
            case R.id.iv_close:
                dismiss();
                break;
            case R.id.li_search:
                memoryText = editTextLayout.getText().toString();
                pageIndex = 1;
                obtainVipList();
                break;
            case R.id.rl_confirm:
                if (mVipDetail != null) {
                    back.onResponse(mVipDetail);
                    dismiss();
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择会员");
                }
                break;
            case R.id.rl_delete:
                memoryText = "";
                back.onErrorResponse(null);
                dismiss();
                break;
        }
    }

    private void obtainVipList() {
        dialog.show();
        if (pageIndex == 1) {
            searchVipPopAdapter.getList().clear();
        }
        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        String SM_GID = CacheDoubleUtils.getInstance().
                getParcelable(SysSwitchRes.Type.T210.getValueStr(), SysSwitchRes.CREATOR).getSS_State() == 0 ? MyApplication.loginBean.getShopID() : "";
        onlyVipMsg.vipMsgs(editTextLayout.getText().toString(), pageIndex, 20, SM_GID, new InterfaceBack<BasePageRes>() {
            @Override
            public void onResponse(BasePageRes response) {
                dialog.dismiss();
                Type listType = new TypeToken<List<VipInfoMsg>>() {
                }.getType();
                List<VipInfoMsg> vipDengjiMsg = response.getData(listType);

                searchVipPopAdapter.addAllList(vipDengjiMsg);
                searchVipPopAdapter.notifyDataSetChanged();
                if (response.getDataCount() <= searchVipPopAdapter.getList().size()) {
                    searchList.setLoadingMoreEnabled(false);
                } else {
                    searchList.setLoadingMoreEnabled(true);
                }
                searchList.loadMoreComplete();
                searchList.refreshComplete();
            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
                searchList.loadMoreComplete();
                searchList.refreshComplete();
            }
        });
    }
}

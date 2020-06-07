package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.SearchVipPopAdapter;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.SysSwitchType;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.MyOnEditorActionListener;
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

        WindowManager m = mContext.getWindowManager();
        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes(); //获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.8); //宽度设置为屏幕的0.8
        p.height = (int) (d.getHeight() * 0.8);
        getWindow().setAttributes(p); //设置生效

        editTextLayout = (NumInputView) findViewById(R.id.edit_text_layout);

        new NumKeyboardUtils(mContext, getWindow().getDecorView(), editTextLayout);

        editTextLayout.setOnEditorActionListener(new MyOnEditorActionListener(mContext) {
            @Override
            public void onEditorAction(String text) {
                findViewById(R.id.li_search).performClick();
            }
        });
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
        String SM_GID = SysSwitchRes.getSwitch(SysSwitchType.T210.getV()).getSS_State() == 0 ? MyApplication.loginBean.getShopID() : "";
        onlyVipMsg.vipMsgs(editTextLayout.getText().toString(), pageIndex, 20, SM_GID, new InterfaceBack<BasePageRes>() {
            @Override
            public void onResponse(BasePageRes response) {
                dialog.dismiss();
                Type listType = new TypeToken<List<VipInfoMsg>>() {
                }.getType();
                List<VipInfoMsg> vipDengjiMsg = response.getData(listType);
                if (vipDengjiMsg == null || vipDengjiMsg.size() == 0) {
                    ToastUtils.showLong("未找到该会员");
                }
                for (VipInfoMsg vipInfoMsg : vipDengjiMsg) {
                    if (!DateTimeUtil.isOverTime(vipInfoMsg.getVCH_CreateTime())) {
                        searchVipPopAdapter.addList(vipInfoMsg);
                    }
                }

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

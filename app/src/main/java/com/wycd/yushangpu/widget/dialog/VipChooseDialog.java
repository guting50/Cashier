package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.KeyboardUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.SearchVipPopAdapter;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ZPH on 2019-06-29.
 */

public class VipChooseDialog extends Dialog {

    private static String memoryText;

    @BindView(R.id.search_list)
    RecyclerView searchList;

    SearchVipPopAdapter searchVipPopAdapter;

    private Activity mContext;
    private InterfaceBack back;
    private Dialog dialog;
    private VipInfoMsg mVipDetail;
    NumInputView editTextLayout;

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
                onlyVipMsg.vipMsg(mContext, mVipDetail.getVCH_Card(), new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        mVipDetail = (VipInfoMsg) response;
                        back.onResponse(mVipDetail);
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
                dismiss();
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
                obtainVipList(mContext, editTextLayout.getText().toString());
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

    private void obtainVipList(Activity context, String serachContent) {
        dialog.show();

        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        onlyVipMsg.vipMsgs(context, serachContent, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
                List<VipInfoMsg> vipDengjiMsg = (List<VipInfoMsg>) response;

                searchVipPopAdapter.setList(vipDengjiMsg);
                searchVipPopAdapter.notifyDataSetChanged();
            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });
    }
}

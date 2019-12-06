package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.KeyboardUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.SearchVipPopAdapter;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

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
    private VipDengjiMsg.DataBean mVipDetail;
    NumInputView editTextLayout;

    public VipChooseDialog(Activity context, VipDengjiMsg.DataBean vipMsg, final InterfaceBack back) {
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
                mVipDetail = (VipDengjiMsg.DataBean) response;
                back.onResponse(mVipDetail);
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

        new NumKeyboardUtils(mContext, getWindow().getDecorView(),
                editTextLayout, "会员卡号/手机号/卡面号");
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
        onlyVipMsg.vipMsg(context, serachContent, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
                VipDengjiMsg vipDengjiMsg = (VipDengjiMsg) response;

                searchVipPopAdapter.setList(vipDengjiMsg.getData());
                searchVipPopAdapter.notifyDataSetChanged();
            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });
    }
}

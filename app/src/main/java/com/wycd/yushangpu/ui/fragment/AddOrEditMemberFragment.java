package com.wycd.yushangpu.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.VipInfoMsg;

import butterknife.OnClick;

public class AddOrEditMemberFragment extends BaseFragment {
    VipInfoMsg vipInfoMsg;

    @Override
    public int getContentView() {
        return R.layout.fragment_add_or_edit_member;
    }

    public void setData(VipInfoMsg info) {
        vipInfoMsg = info;
        super.setData();
    }

    protected void updateData() {
        if (vipInfoMsg == null) {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("新增会员");
        } else
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("编辑会员");
    }

    @OnClick({R.id.tv_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                homeActivity.fragmentManager.beginTransaction().hide(this).commit();
                break;
        }
    }
}

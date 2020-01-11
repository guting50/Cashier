package com.wycd.yushangpu.widget.popwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.bean.UserInfomationBean;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.tools.NullUtils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ShowMemberPopWindow extends PopupWindow implements View.OnClickListener {
    private Activity ac;
    private LoginBean loginBean;
    private View mView;//PopWindow布局
    private CircleImageView imgHead;
    private TextView mStoreName, mStoreEmail, mChangePwd, mOut, mNameSet, mChangeHead;
    private OnItemClickListener mListener;

    public ShowMemberPopWindow(Activity ac, LoginBean loginBean) {

        this.ac = ac;
        this.loginBean = loginBean;
//        loadData();
        init(ac);
        setPopWindow();
    }

    private void loadData() {
        String url = HttpAPI.API().USER_INFORMATION;
        RequestParams params = new RequestParams();
        params.put("GID", loginBean.getGID());
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                mStoreName.setText(response.getData(UserInfomationBean.class).getUM_Name());
            }
        });
    }

    private void init(Activity context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.pop_member_info, null);

        imgHead = (CircleImageView) mView.findViewById(R.id.img_hedimg);
        mStoreName = (TextView) mView.findViewById(R.id.tv_store_name);
        mStoreEmail = (TextView) mView.findViewById(R.id.tv_store_account);
        mChangePwd = (TextView) mView.findViewById(R.id.tv_change_pwd);
        mOut = (TextView) mView.findViewById(R.id.tv_sigin_out);
        mNameSet = (TextView) mView.findViewById(R.id.tv_store_name_set);
        mChangeHead = (TextView) mView.findViewById(R.id.tv_change_head);


        mChangePwd.setOnClickListener(this);
        mOut.setOnClickListener(this);
        mNameSet.setOnClickListener(this);
        mChangeHead.setOnClickListener(this);

        if (loginBean.getUM_ChatHead() != null) {
            Glide.with(context).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(loginBean.getUM_ChatHead()).toString())).error(R.mipmap.member_head_nohead).into(imgHead);
        }
        if (loginBean.getUM_Name().equals(loginBean.getUM_Acount())) {
            mStoreName.setText("暂无名称");
//            mNameSet.setVisibility(View.VISIBLE);
        } else {
            mStoreName.setText(loginBean.getUM_Name());
            mNameSet.setVisibility(View.GONE);
        }
        mStoreEmail.setText(loginBean.getUM_Acount());
    }

    /**
     * 设置PopWindow相关属性
     */
    private void setPopWindow() {
        this.setContentView(mView);
        this.setWidth(240);
        this.setHeight(RadioGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setTouchable(true);//设置允许弹出窗口
//        this.setAnimationStyle(R.style.pop_show_style);//设置弹出动画
        this.setBackgroundDrawable(new ColorDrawable());//设置背景透明

    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.setOnItemClick(view);
        }
    }


    public interface OnItemClickListener {
        void setOnItemClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

}

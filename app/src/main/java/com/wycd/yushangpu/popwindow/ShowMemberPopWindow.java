package com.wycd.yushangpu.popwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.bean.UserInfomationBean;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.model.ImpUserInfomation;
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
    private TextView mStoreName,mStoreEmail,mChangePwd,mOut,mNameSet,mChangeHead;
    private OnItemClickListener mListener;

    public ShowMemberPopWindow(Activity ac,LoginBean loginBean){

        this.ac = ac;
        this.loginBean = loginBean;
//        loadData();
        init(ac);
        setPopWindow();
    }

    private void loadData() {

        ImpUserInfomation impUserInfomation = new ImpUserInfomation();
        impUserInfomation.userInfo(ac, loginBean.getData().getGID(), new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                UserInfomationBean sllist = (UserInfomationBean) response;
                mStoreName.setText(sllist.getUM_Name());
            }

            @Override
            public void onErrorResponse(Object msg) {

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

        if (loginBean.getData().getUM_ChatHead() != null) {
            VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(loginBean.getData().getUM_ChatHead()).toString()), imgHead, R.mipmap.member_head_nohead);
        }
        if (loginBean.getData().getUM_Name().equals(loginBean.getData().getUM_Acount())){
            mStoreName.setText("暂无名称");
//            mNameSet.setVisibility(View.VISIBLE);
        }else {
            mStoreName.setText(loginBean.getData().getUM_Name());
            mNameSet.setVisibility(View.GONE);
        }
        mStoreEmail.setText(loginBean.getData().getUM_Acount());
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

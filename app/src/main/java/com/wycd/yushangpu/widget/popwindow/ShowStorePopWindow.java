package com.wycd.yushangpu.widget.popwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.tools.NullUtils;

/**
 * Created by ZPH on 2019-07-05.
 */

public class ShowStorePopWindow extends PopupWindow implements View.OnClickListener{

    private Activity ac;
    private ShopInfoBean shopInfoBean;
    private View mView;//PopWindow布局
    private ImageView imgHead;
    private TextView mStartTime,mEndTime,mVersion,mUser,mMember,mgoods,mShopName,mShopInfo;
    private ShowStorePopWindow.OnItemStoreClickListener mListener;


    public ShowStorePopWindow(Activity ac,ShopInfoBean shopInfoBean){

        this.ac = ac;
        this.shopInfoBean = shopInfoBean;
        init(ac);

        setPopWindow();
    }

    private void init(Activity context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.dialog_shop_info, null);

        imgHead = (ImageView) mView.findViewById(R.id.iv_shop);
        mStartTime = (TextView) mView.findViewById(R.id.tv_start_time);
        mEndTime = (TextView) mView.findViewById(R.id.tv_end_time);
        mVersion = (TextView) mView.findViewById(R.id.tv_version);
        mUser = (TextView) mView.findViewById(R.id.tv_user);
        mMember = (TextView) mView.findViewById(R.id.tv_member);
        mgoods = (TextView) mView.findViewById(R.id.tv_goods);
        mShopName = (TextView) mView.findViewById(R.id.tv_shop_name);
        mShopInfo= (TextView) mView.findViewById(R.id.show_shop_info);

        mShopInfo.setOnClickListener(this);

        if (shopInfoBean.getData().getShopImg() != null) {
            VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(shopInfoBean.getData().getShopImg()).toString()), imgHead, R.drawable.defalut_store);
        }
        mShopName.setText(NullUtils.noNullHandle(shopInfoBean.getData().getShopName()).toString() );
        mEndTime.setText("到期："+NullUtils.noNullHandle(shopInfoBean.getData().getShopOverTime()).toString());
        mStartTime.setText("开通："+NullUtils.noNullHandle(shopInfoBean.getData().getShopCreateTime()).toString());
        mVersion.setText("版本："+NullUtils.noNullHandle(shopInfoBean.getData().getShopType()).toString());
        mUser.setText("用户数："+NullUtils.noNullHandle(shopInfoBean.getData().getShopUsers()).toString());
        mMember.setText("会员数："+NullUtils.noNullHandle(shopInfoBean.getData().getShopMbers()).toString());
        mgoods.setText("商品数："+NullUtils.noNullHandle(shopInfoBean.getData().getShopGoods()).toString());
    }

    /**
     * 设置PopWindow相关属性
     */
    private void setPopWindow() {
        this.setContentView(mView);
        this.setWidth(380);
        this.setHeight(RadioGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setTouchable(true);//设置允许弹出窗口
//        this.setAnimationStyle(R.style.pop_show_style);//设置弹出动画
        this.setBackgroundDrawable(new ColorDrawable());//设置背景透明
//        mView.setOnTouchListener(new View.OnTouchListener() {//设置触摸位置在窗口外则销毁
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (mView.findViewById(R.id.pop_layout) != null) {
//                    int height = mView.findViewById(R.id.pop_layout).getTop();
//                    int y = (int) motionEvent.getY();
//                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//                        if (y < height) {
//                            dismiss();
//                        }
//                    }
//                    return true;
//                }
//                return false;
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.setOnItemClick(view);
        }
    }


    public interface OnItemStoreClickListener {
        void setOnItemClick(View v);
    }

    public void setOnItemStoreClickListener(ShowStorePopWindow.OnItemStoreClickListener mListener) {
        this.mListener = mListener;
    }
}

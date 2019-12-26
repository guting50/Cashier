package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpPreLoading;
import com.wycd.yushangpu.tools.NullUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class PromotionDialog {

    public static Dialog yhqDialog(final Activity context, int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_youhuiquan, null);
        ((View) view.findViewById(R.id.rl_confirm).getParent()).setVisibility(View.GONE);
        ((TextView) view.findViewById(R.id.tv_title)).setText("优惠活动");

        RecyclerView gridView = view.findViewById(R.id.gridview);

        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view);
        Window window = dialog.getWindow();

        PromotionAdapter adapter = new PromotionAdapter(context, back);
        gridView.setLayoutManager(new GridLayoutManager(context, 3));
        gridView.setAdapter(adapter);

        switch (showingLocation) {
            case 0:
                window.setGravity(Gravity.TOP); // 此处可以设置dialog显示的位置
                break;
            case 1:
                window.setGravity(Gravity.CENTER);
                break;
            case 2:
                window.setGravity(Gravity.BOTTOM);
                break;
            case 3:
                WindowManager.LayoutParams params = window.getAttributes();
                dialog.onWindowAttributesChanged(params);
                params.x = screenWidth - dip2px(context, 100);// 设置x坐标
                params.gravity = Gravity.TOP;
                params.y = dip2px(context, 45);// 设置y坐标
                Log.d("xx", params.y + "");
                window.setGravity(Gravity.TOP);
                window.setAttributes(params);
                break;
            default:
                window.setGravity(Gravity.CENTER);
                break;
        }
        return dialog;
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

    public static class PromotionAdapter extends RecyclerView.Adapter {
        private List<ReportMessageBean.DataBean.ActiveBean> list;
        private ReportMessageBean.DataBean.ActiveBean currentBean;
        private Holder currentHolder;
        private Context context;
        private InterfaceBack back;

        public PromotionAdapter(Context context, InterfaceBack back) {
            if (ImpPreLoading.REPORT_BEAN != null && ImpPreLoading.REPORT_BEAN.getData() != null)
                this.list = ImpPreLoading.REPORT_BEAN.getData().getActive();
            this.context = context;
            this.back = back;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_promotion, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final ReportMessageBean.DataBean.ActiveBean activeBean = list.get(position);
            Holder holder1 = (Holder) holder;

            holder1.rootView.setBackgroundResource(R.mipmap.bg_promotion_no_select);
            holder1.tvName1.setTextColor(context.getResources().getColor(R.color.title_color));
            holder1.mTvYouxiao.setTextColor(context.getResources().getColor(R.color.color_999999));

            holder1.tvName.setText(activeBean.getRP_Name());
            holder1.tvName1.setText(activeBean.getRP_Name());

//            switch (NullUtils.noNullHandle(vipMsg.getVCR_IsForver()).toString()) {
//                case "0":
//                    holder1.mTvYouxiao.setText(NullUtils.noNullHandle(activeBean.getRP_CreateTime()).toString() + "～" + NullUtils.noNullHandle(activeBean.getRP_ValidEndTime()).toString() + "有效");
//                    break;
//                case "1":
//                    holder1.mTvYouxiao.setText("永久有效");
//                    break;
//                case "2":
//                    holder1.mTvYouxiao.setText(NullUtils.noNullHandle(vipMsg.getVCR_EndTime()).toString() + "前有效");
//                    break;
//            }
//            holder1.mTvYouxiao.setText("有效期:" + holder1.mTvYouxiao.getText());

            holder1.mTvYouxiao.setText("有效期:" + NullUtils.noNullHandle(activeBean.getRP_CreateTime()).toString() + "～" + NullUtils.noNullHandle(activeBean.getRP_ValidEndTime()).toString() + "有效");

            holder1.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentHolder != null) {
                        currentHolder.rootView.setBackgroundResource(R.mipmap.bg_promotion_no_select);
                        currentHolder.tvName1.setTextColor(context.getResources().getColor(R.color.title_color));
                    }
                    currentHolder = holder1;
                    currentHolder.rootView.setBackgroundResource(R.mipmap.bg_promotion_selected);
                    currentHolder.tvName1.setTextColor(Color.WHITE);
                    back.onResponse(activeBean);
                }
            });
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_name)
            TextView tvName;
            @BindView(R.id.tv_name_1)
            TextView tvName1;
            @BindView(R.id.tv_youxiao)
            TextView mTvYouxiao;
            View rootView;

            public Holder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                rootView = view;

            }
        }

    }

}

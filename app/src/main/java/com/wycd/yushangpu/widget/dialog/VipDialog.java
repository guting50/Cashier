package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.VipListAdapter;
import com.wycd.yushangpu.bean.VipMsg;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpVipList;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.views.ClearEditText;

import java.util.List;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class VipDialog {
    public static Dialog languageChoseDialog(final Activity context,
                                             int showingLocation, final List<VipMsg> vipList, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_chosevip, null);
        final ClearEditText et_search = (ClearEditText) view.findViewById(R.id.et_search);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        ImageView iv_close = (ImageView) view.findViewById(R.id.iv_close);
        LinearLayout li_search = (LinearLayout) view.findViewById(R.id.li_search);
        final Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);
        final VipListAdapter mVipListAdapter = new VipListAdapter(context, vipList);
        listView.setAdapter(mVipListAdapter);
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view, new LinearLayout.LayoutParams(
                screenWidth - dip2px(context, 600), LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        dialog.show();
        if (vipList.size() == 0) {
            obtainVipList(context, loadingdialog, vipList, mVipListAdapter,"");
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VipMsg vipMsg = (VipMsg) adapterView.getItemAtPosition(i);
                back.onResponse(vipMsg);
                dialog.dismiss();
            }
        });
        iv_close.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
            }
        });

        li_search.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if(!et_search.getText().toString().equals("")){
                    obtainVipList(context, loadingdialog, vipList, mVipListAdapter,et_search.getText().toString());
                }else{
//                    ToastUtils.showToast(context,"请输入会员卡号/姓名/手机号/卡面号");
                    com.blankj.utilcode.util.ToastUtils.showShort("请输入会员卡号/姓名/手机号/卡面号");
                }
            }
        });
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

    private static void obtainVipList(Activity context, final Dialog loadingdialog, final List<VipMsg> vipList, final VipListAdapter mVipListAdapter,String search) {
        loadingdialog.show();
        ImpVipList shopHome = new ImpVipList();
        shopHome.vipList(context, "yes", 1, 50,search, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                loadingdialog.dismiss();
                List<VipMsg> sllist = (List<VipMsg>) response;
                vipList.addAll(sllist);
                LogUtils.d("xxshoplist", vipList.size() + "");
                mVipListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onErrorResponse(Object msg) {
                loadingdialog.dismiss();
            }
        });

    }
}

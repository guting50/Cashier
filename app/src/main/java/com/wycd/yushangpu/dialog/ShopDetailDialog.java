package com.wycd.yushangpu.dialog;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.BumenAdapter;
import com.wycd.yushangpu.adapter.YuangongAdapter;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.ValiRuleMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpEmplList;
import com.wycd.yushangpu.model.ImpValidRule;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.views.ClearEditText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class ShopDetailDialog {
    private static List<ValiRuleMsg> bumenlist = new ArrayList<>();
    private static List<EmplMsg> emplist = new ArrayList<>();
    private static List<String> mEmplMsgList3;
    private static String mSmGid;
    private static Boolean mChoseUserAll = false;

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID,List<String> mEmplGidList,
                                           String SmGid,int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_shopdetail, null);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        TextView iv_state = (TextView) view.findViewById(R.id.iv_state);
        ListView bumenlistview = (ListView) view.findViewById(R.id.bumenlistview);
        RelativeLayout rl_confirm = (RelativeLayout) view.findViewById(R.id.rl_confirm);
        ImageView rl_cancle = (ImageView) view.findViewById(R.id.rl_cancle);
        TextView tv_ygname = (TextView) view.findViewById(R.id.tv_ygname);
        final ImageView iv_chose_all = (ImageView) view.findViewById(R.id.iv_chose_all);

        final TextView tv_allbumen = (TextView) view.findViewById(R.id.tv_allbumen);
        LinearLayout li_search = (LinearLayout) view.findViewById(R.id.li_search);
        final ClearEditText et_search = (ClearEditText) view.findViewById(R.id.et_search);
        final LinearLayout li_allbumen = (LinearLayout) view.findViewById(R.id.li_allbumen);

        Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);

        //部门列表
        final List<ValiRuleMsg> mValiRuleMsgList = new ArrayList<>();
        //员工列表
        final List<EmplMsg> mEmplMsgList = new ArrayList<>();
        mEmplMsgList3 = mEmplGidList;
        mSmGid = SmGid;

        //员工适配器
        final YuangongAdapter yuangongAdapter = new YuangongAdapter(context, mEmplMsgList);
        listView.setAdapter(yuangongAdapter);
        final BumenAdapter bumenAdapter = new BumenAdapter(context, mValiRuleMsgList);
        bumenlistview.setAdapter(bumenAdapter);
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view, new LinearLayout.LayoutParams(
                screenWidth - dip2px(context, 450), LinearLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        dialog.show();
        obtainBumenList(context, loadingdialog, mShopMsg, VGID, mValiRuleMsgList, bumenAdapter, mEmplMsgList, yuangongAdapter);

        mChoseUserAll = false;
        iv_chose_all.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (!mChoseUserAll) {
                    mChoseUserAll = true;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_chose);
                } else {
                    mChoseUserAll = false;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_not);
                }
                for (int i = 0, len = mEmplMsgList.size(); i < len; i++) {
                    mEmplMsgList.get(i).setIschose(mChoseUserAll);
                }
                yuangongAdapter.notifyDataSetChanged();
            }
        });
        tv_ygname.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (!mChoseUserAll) {
                    mChoseUserAll = true;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_chose);
                } else {
                    mChoseUserAll = false;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_not);
                }
                for (int i = 0, len = mEmplMsgList.size(); i < len; i++) {
                    mEmplMsgList.get(i).setIschose(mChoseUserAll);
                }
                yuangongAdapter.notifyDataSetChanged();
            }
        });

        li_search.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (!et_search.getText().toString().equals("")) {
                    mEmplMsgList.clear();
                    for (EmplMsg emplMsg : emplist) {
                        if (emplMsg.getEM_Name().contains(et_search.getText().toString())) {
                            mEmplMsgList.add(emplMsg);
                        }
                    }
                    yuangongAdapter.notifyDataSetChanged();
                    mChoseUserAll = false;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_not);
                } else {
                    mEmplMsgList.clear();
                    mEmplMsgList.addAll(emplist);
                    yuangongAdapter.notifyDataSetChanged();
                    mChoseUserAll = false;
                    iv_chose_all.setBackgroundResource(R.drawable.emp_not);
                }

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mEmplMsgList.get(i).isIschose()) {
                    mEmplMsgList.get(i).setIschose(false);
                } else {
                    mEmplMsgList.get(i).setIschose(true);
                }
                yuangongAdapter.notifyDataSetChanged();
            }
        });
        bumenlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                li_allbumen.setBackgroundResource(R.drawable.shap_bumennot);
                tv_allbumen.setTextColor(context.getResources().getColor(R.color.text60));
                mEmplMsgList.clear();
                ValiRuleMsg bumenMsg = (ValiRuleMsg) adapterView.getItemAtPosition(i);
                List<EmplMsg> first = new ArrayList<>();
                for (EmplMsg emplMsg : emplist) {
                    if (emplMsg.getEM_TipGoodsConsume() == 1) {
                        first.add(emplMsg);
                    }
                }
                //   过滤调没有提成部门的员工
                for (EmplMsg em : first) {
                    if (em.getDM_GID().equals(bumenMsg.getGID())) {
                        mEmplMsgList.add(em);
                    }
                }
                for (int j = 0; j < mValiRuleMsgList.size(); j++) {
                    mValiRuleMsgList.get(j).setIschose(false);
                }
                mValiRuleMsgList.get(i).setIschose(true);
                bumenAdapter.notifyDataSetChanged();
                yuangongAdapter.notifyDataSetChanged();

                mChoseUserAll = false;
                iv_chose_all.setBackgroundResource(R.drawable.emp_not);
            }
        });
        li_allbumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                li_allbumen.setBackgroundResource(R.drawable.shap_bumen);
                tv_allbumen.setTextColor(context.getResources().getColor(R.color.white));
                mEmplMsgList.clear();
                List<EmplMsg> first = new ArrayList<>();
                for (EmplMsg emplMsg : emplist) {
                    if (emplMsg.getEM_TipGoodsConsume() == 1) {
                        first.add(emplMsg);
                    }
                }
                //   过滤调没有提成部门的员工
                for (EmplMsg em : first) {
                    for (ValiRuleMsg valiRuleMsg : bumenlist) {
                        if (em.getDM_GID().equals(valiRuleMsg.getGID())) {
                            mEmplMsgList.add(em);
                        }
                    }
                }
                yuangongAdapter.notifyDataSetChanged();
                for (int j = 0; j < mValiRuleMsgList.size(); j++) {
                    mValiRuleMsgList.get(j).setIschose(false);
                }
                bumenAdapter.notifyDataSetChanged();
                mChoseUserAll = false;
                iv_chose_all.setBackgroundResource(R.drawable.emp_not);
            }
        });


        rl_cancle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });
        rl_confirm.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                List<EmplMsg> mEmplMsgList2 = new ArrayList<>();
                for (EmplMsg emp : mEmplMsgList) {
                    if (emp.isIschose()) {
                        mEmplMsgList2.add(emp);
                    }
                }
                dialog.dismiss();
                back.onResponse(mEmplMsgList2);
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);

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


    private static void obtainBumenList(final Activity context, final Dialog loadingdialog, ShopMsg mShopMsg, String VGID,
                                        final List<ValiRuleMsg> ValiRuleMsg, final BumenAdapter bumenAdapter, final List<EmplMsg> emplMsgList, final YuangongAdapter yuangongAdapter) {
        loadingdialog.show();
        ImpValidRule validRule = new ImpValidRule();
        validRule.valiRule(context, VGID, mShopMsg.getGID(),mShopMsg.getPT_ID(), new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                List<ValiRuleMsg> mValiRuleMsgList = (List<ValiRuleMsg>) response;
                bumenlist.clear();
                bumenlist.addAll(mValiRuleMsgList);
                ValiRuleMsg.addAll(mValiRuleMsgList);
                bumenAdapter.notifyDataSetChanged();
                ImpEmplList emplList = new ImpEmplList();
                //预加载接口获取员工列表
                emplList.emplList(context, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        loadingdialog.dismiss();
                        List<EmplMsg> sllist = (List<EmplMsg>) response;
                        choseEmplList(ValiRuleMsg, sllist, emplMsgList, yuangongAdapter);
                        HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                        event.setMsg("Change_color");
                        EventBus.getDefault().post(event);
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        loadingdialog.dismiss();
                        HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                        event.setMsg("Change_color");
                        EventBus.getDefault().post(event);
                    }
                });
            }

            @Override
            public void onErrorResponse(Object msg) {
                loadingdialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });
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



    private static void choseEmplList(List<ValiRuleMsg> valiRuleMsgList, List<EmplMsg> sllist, List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {

        for (int i=0;i<sllist.size();i++){//这个for是排除非当前店铺，但不排除没有设置店铺的员工
            if (sllist.get(i).getSM_GID()!=null&&!sllist.get(i).getSM_GID().equals(mSmGid)){
                sllist.remove(i);
            }
        }
//        过滤调没有开启商品消费提成的员工
        emplist.clear();
        List<EmplMsg> first = new ArrayList<>();
        for (EmplMsg emplMsg : sllist) {
            if (emplMsg.getEM_TipGoodsConsume() == 1) {
                first.add(emplMsg);
            }
        }
        //   过滤调没有提成部门的员工
        for (EmplMsg em : first) {
            for (ValiRuleMsg valiRuleMsg : valiRuleMsgList) {
                if (em.getDM_GID().equals(valiRuleMsg.getGID())) {
                    emplMsgList.add(em);
                    emplist.add(em);
                }
            }
        }
        if (mEmplMsgList3 !=null && mEmplMsgList3.size()>0){
            for (int i = 0;i<mEmplMsgList3.size();i++){
                for (int j = 0;j<emplMsgList.size();j++){
                    if (mEmplMsgList3.get(i).equals(emplMsgList.get(j).getGID())){
                        emplMsgList.get(j).setIschose(true);
                    }
                }
            }
        }
        yuangongAdapter.notifyDataSetChanged();

    }
}

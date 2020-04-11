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
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.YuangongAdapter;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.ValiRuleMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
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

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID, List<String> mEmplGidList,
                                          String SmGid, int showingLocation, final InterfaceBack back) {
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_shopdetail, null);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        BgFrameLayout rl_confirm = (BgFrameLayout) view.findViewById(R.id.rl_confirm);
        ImageView rl_cancle = (ImageView) view.findViewById(R.id.rl_cancle);
        NumInputView editTextLayout = (NumInputView) view.findViewById(R.id.edit_text_layout);

        BgFrameLayout li_search = (BgFrameLayout) view.findViewById(R.id.li_search);

        new NumKeyboardUtils(context, view, editTextLayout);

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
        dialog = new Dialog(context, R.style.DialogNotitle1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        int screenWidth = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        dialog.show();
        obtainBumenList(loadingdialog, mShopMsg, VGID, mValiRuleMsgList, mEmplMsgList, yuangongAdapter);

        li_search.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (!editTextLayout.getText().toString().equals("")) {
                    mEmplMsgList.clear();
                    for (EmplMsg emplMsg : emplist) {
                        if (emplMsg.getEM_Code().contains(editTextLayout.getText().toString()) ||
                                emplMsg.getEM_Name().contains(editTextLayout.getText().toString())) {
                            mEmplMsgList.add(emplMsg);
                        }
                    }
                    yuangongAdapter.notifyDataSetChanged();
                } else {
                    mEmplMsgList.clear();
                    mEmplMsgList.addAll(emplist);
                    yuangongAdapter.notifyDataSetChanged();
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

    private static void obtainBumenList(Dialog loadingdialog, ShopMsg mShopMsg, String VGID,
                                        List<ValiRuleMsg> ValiRuleMsg, List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {
        loadingdialog.show();

        RequestParams params = new RequestParams();
//        Type	提成类型	int	否
//        VGID	等级GID	string	是
//        PGID	商品GID	string	是
        params.put("Type", 50);
        params.put("VGID", VGID);
        params.put("PGID", mShopMsg.getGID());
        params.put("PTGID", mShopMsg.getPT_ID());
        if (VGID.equals("")) {
            params.put("VIP_Card", "00000");
        }
        String url = HttpAPI.API().GET_VALIDRULE;
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<ValiRuleMsg>>() {
                }.getType();
                List<ValiRuleMsg> mValiRuleMsgList = response.getData(listType);
                bumenlist.clear();
                bumenlist.addAll(mValiRuleMsgList);
                ValiRuleMsg.addAll(mValiRuleMsgList);
                //预加载接口获取员工列表
                RequestParams params = new RequestParams();
                params.put("PageIndex", 1);
                params.put("PageSize", 10000);
                params.put("SM_GID", MyApplication.loginBean.getShopID());
                AsyncHttpUtils.postHttp(HttpAPI.API().GET_EMPLLIST, params, new CallBack() {
                    @Override
                    public void onResponse(BaseRes response) {
                        loadingdialog.dismiss();
                        Type listType = new TypeToken<List<EmplMsg>>() {
                        }.getType();
                        List<EmplMsg> sllist = response.getData(BasePageRes.class).getData(listType);
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
                super.onErrorResponse(msg);
                loadingdialog.dismiss();
                HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);
            }
        });
    }

    private static void choseEmplList(List<ValiRuleMsg> valiRuleMsgList, List<EmplMsg> sllist, List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {

        for (int i = 0; i < sllist.size(); i++) {//这个for是排除非当前店铺，但不排除没有设置店铺的员工
            if (sllist.get(i).getSM_GID() != null && !sllist.get(i).getSM_GID().equals(mSmGid)) {
                sllist.remove(i);
            }
        }
//        过滤调没有开启商品消费提成的员工
        emplist.clear();
        List<EmplMsg> first = new ArrayList<>();
        for (EmplMsg emplMsg : sllist) {
            if (emplMsg.getEM_TipGoodsConsume() > 0) {
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
        if (mEmplMsgList3 != null && mEmplMsgList3.size() > 0) {
            for (int i = 0; i < mEmplMsgList3.size(); i++) {
                for (int j = 0; j < emplMsgList.size(); j++) {
                    if (mEmplMsgList3.get(i).equals(emplMsgList.get(j).getGID())) {
                        emplMsgList.get(j).setIschose(true);
                    }
                }
            }
        }
        yuangongAdapter.notifyDataSetChanged();

    }
}

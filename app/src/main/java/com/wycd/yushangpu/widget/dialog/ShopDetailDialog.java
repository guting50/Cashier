package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.YuangongAdapter;
import com.wycd.yushangpu.bean.DeductRuleBean;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.ValiRuleMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BasePageRes;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpParamLoading;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.widget.NumInputView;
import com.wycd.yushangpu.widget.NumKeyboardUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by songxiaotao on 2017/12/21.
 */

public class ShopDetailDialog {
    private static List<EmplMsg> emplist = new ArrayList<>();
    private static List<String> mEmplMsgList3;// 已选员工列表
    private static String mSmGid;
    private static boolean isSingle;
    private static int mType = 0;//1:商品消费，2：会员开卡，3：会员充值

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID, List<String> mEmplGidList,
                                          String SmGid, int showingLocation, int type, final InterfaceBack back) {
        return shopdetailDialog(context, mShopMsg, VGID, mEmplGidList, SmGid, showingLocation, false, type, back);
    }

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID, List<String> mEmplGidList,
                                          String SmGid, int showingLocation, boolean single, int type, final InterfaceBack back) {
        boolean allow = false;
        if (ImpParamLoading.REPORT_BEAN != null) {
            List<DeductRuleBean> deductRuleBeans = ImpParamLoading.REPORT_BEAN.getDeductRule();
            for (DeductRuleBean bean : deductRuleBeans) {
                switch (type) {
                    case 1:
                        if (bean.getSS_Type() == 50) {
                            allow = true;
                        }
                        break;
                    case 2:
                        if (bean.getSS_Type() == 10) {
                            allow = true;
                        }
                        break;
                    case 3:
                        if (bean.getSS_Type() == 20) {
                            allow = true;
                        }
                        break;
                }
            }
        }
        if (!allow) {
            ToastUtils.showLong("没有提成规则");
            return null;
        }
        final Dialog dialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_shopdetail, null);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        BgFrameLayout rl_confirm = (BgFrameLayout) view.findViewById(R.id.rl_confirm);
        ImageView rl_cancle = (ImageView) view.findViewById(R.id.rl_cancle);
        NumInputView editTextLayout = (NumInputView) view.findViewById(R.id.edit_text_layout);
        FrameLayout flProportionLayout = view.findViewById(R.id.flProportionLayout);
        TextView tv_title_proportion = view.findViewById(R.id.tv_title_proportion);
        RecyclerView recyclerProportion = view.findViewById(R.id.recycler_proportion);

        BgFrameLayout li_search = (BgFrameLayout) view.findViewById(R.id.li_search);

        new NumKeyboardUtils(context, view, editTextLayout);

        Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);

        //部门列表
        final List<ValiRuleMsg> mValiRuleMsgList = new ArrayList<>();
        //员工列表
        final List<EmplMsg> mEmplMsgList = new ArrayList<>();
        mEmplMsgList3 = mEmplGidList;
        mSmGid = SmGid;
        isSingle = single;
        mType = type;

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
                mEmplMsgList.get(i).setStaffProportion(0);
                if (mEmplMsgList.get(i).isIschose()) {
                    mEmplMsgList.get(i).setIschose(false);
                } else {
                    mEmplMsgList.get(i).setIschose(true);
                }
                yuangongAdapter.notifyDataSetChanged();
                if (isSingle) {
                    rl_confirm.performClick();
                }
            }
        });

        rl_cancle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
                /*HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);*/
            }
        });

        ProportionAdapter adapter = new ProportionAdapter(context);
        recyclerProportion.setLayoutManager(new LinearLayoutManager(context));
        recyclerProportion.setAdapter(adapter);

        //选择员工后的确定
        rl_confirm.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //员工提成按比例分成
                SysSwitchRes switchRes302 = CacheDiskUtils.getInstance().getParcelable("302", SysSwitchRes.CREATOR);
                //员工提成按固定
                SysSwitchRes switchRes303 = CacheDiskUtils.getInstance().getParcelable("303", SysSwitchRes.CREATOR);

                List<EmplMsg> mEmplMsgList2 = new ArrayList<>();
                for (EmplMsg emp : mEmplMsgList) {
                    if (emp.isIschose()) {
                        mEmplMsgList2.add(emp);
                    }
                }
                adapter.setData(mEmplMsgList2);
                if (switchRes302.getSS_State() == 1) {
                    tv_title_proportion.setText("提成比例");
                    flProportionLayout.setVisibility(View.VISIBLE);
                    adapter.setType(1);
                } else if (switchRes303.getSS_State() == 1) {
                    tv_title_proportion.setText("固定提成");
                    flProportionLayout.setVisibility(View.VISIBLE);
                    adapter.setType(2);
                } else {
                    dialog.dismiss();
                    back.onResponse(mEmplMsgList2);
                   /* HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                    event.setMsg("Change_color");
                    EventBus.getDefault().post(event);*/
                }
            }
        });
        //清除
        view.findViewById(R.id.bgReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                back.onResponse(new ArrayList<>());
            }
        });
        //关闭提成框 右上角关闭按钮
        view.findViewById(R.id.iv_cancle_proportion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flProportionLayout.setVisibility(View.GONE);
            }
        });
        //关闭提成框 取消按钮
        view.findViewById(R.id.bg_cancle_proportion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flProportionLayout.setVisibility(View.GONE);
            }
        });
        // 输入提成后的确定
        view.findViewById(R.id.bg_confirm_proportion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.check()) {
                    flProportionLayout.setVisibility(View.GONE);
                    dialog.dismiss();
                    back.onResponse(adapter.getData());
                }
            }
        });
        flProportionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                                        List<ValiRuleMsg> valiRuleMsg, List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {
        loadingdialog.show();

        if (mShopMsg == null) {
            obtainEmpList(loadingdialog, null, emplMsgList, yuangongAdapter);
            return;
        }

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
                valiRuleMsg.addAll(mValiRuleMsgList);
                obtainEmpList(loadingdialog, valiRuleMsg, emplMsgList, yuangongAdapter);
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                loadingdialog.dismiss();
                /*HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);*/
            }
        });
    }

    private static void obtainEmpList(Dialog loadingdialog, List<ValiRuleMsg> valiRuleMsg,
                                      List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {
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
                choseEmplList(valiRuleMsg, sllist, emplMsgList, yuangongAdapter);
                /*HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);*/
            }

            @Override
            public void onErrorResponse(Object msg) {
                loadingdialog.dismiss();
                /*HomeButtonColorChangeEvent event = new HomeButtonColorChangeEvent();
                event.setMsg("Change_color");
                EventBus.getDefault().post(event);*/
            }
        });
    }

    private static void choseEmplList(List<ValiRuleMsg> valiRuleMsgList, List<EmplMsg> sllist, List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {

        for (int i = 0; i < sllist.size(); i++) {//这个for是排除非当前店铺，但不排除没有设置店铺的员工
            if (sllist.get(i).getSM_GID() != null && !sllist.get(i).getSM_GID().equals(mSmGid)) {
                sllist.remove(i);
            }
        }
        List<EmplMsg> first = new ArrayList<>();
        emplist.clear();
        for (EmplMsg emplMsg : sllist) {
            switch (mType) {
                case 1:
//                  过滤调没有开启商品消费提成的员工
                    if (emplMsg.getEM_TipGoodsConsume() > 0) {
                        first.add(emplMsg);
                    }
                    break;
                case 2:
//                  过滤调没有开启售卡提成的员工
                    if (emplMsg.getEM_TipCard() > 0) {
                        first.add(emplMsg);
                    }
                    break;
                case 3:
//                  过滤调没有开启充值提成的员工
                    if (emplMsg.getEM_TipRecharge() > 0) {
                        first.add(emplMsg);
                    }
                    break;
            }
        }
        if (valiRuleMsgList != null) {
            //   过滤掉没有提成部门的员工
            for (EmplMsg em : first) {
                for (ValiRuleMsg valiRuleMsg : valiRuleMsgList) {
                    if (em.getDM_GID().equals(valiRuleMsg.getGID())) {
                        emplMsgList.add(em);
                        emplist.add(em);
                    }
                }
            }
        } else {
            emplist.addAll(first);
        }
        emplMsgList.clear();
        emplMsgList.addAll(emplist);

        //回显
        if (mEmplMsgList3 != null && mEmplMsgList3.size() > 0) {
            for (int i = 0; i < mEmplMsgList3.size(); i++) {
                for (int j = 0; j < emplMsgList.size(); j++) {
                    emplMsgList.get(j).setStaffProportion(0);
                    if (mEmplMsgList3.get(i).equals(emplMsgList.get(j).getGID())) {
                        emplMsgList.get(j).setIschose(true);
                        emplMsgList.get(j).setStaffProportion(emplMsgList.get(i).getStaffProportion());
                    }
                }
            }
        }
        yuangongAdapter.notifyDataSetChanged();

    }

    static class ProportionAdapter extends RecyclerView.Adapter<ProportionAdapter.ProportionHolder> {
        private List<EmplMsg> data = new ArrayList<>();
        private Activity context;
        private int type;

        public ProportionAdapter(Activity context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ProportionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_proportion, parent, false);
            return new ProportionHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProportionHolder holder, int position) {
            EmplMsg item = data.get(position);
            holder.tvTcName.setText(item.getEM_Name());
            if (type == 1) {
                holder.tvTcType.setText("%提成");
            } else if (type == 2) {
                holder.tvTcType.setText("元");
            }
            holder.etTcValue.addTextChangedListener(new TextWatcher() {
                CharSequence before;

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    before = s;
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    int val = 0;
                    if (!TextUtils.isEmpty(s)) {
                        try {
                            val = Integer.valueOf(s.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showLong("金额只能输入数字");
                        }
                    }
                    if (type == 1) {
                        if (val > 100) {
                            holder.etTcValue.setText(before);
                            ToastUtils.showLong("比例不能大于 100");
                            return;
                        }
                    } else if (type == 2)
                        if (val > 999999.99) {
                            holder.etTcValue.setText(before);
                            ToastUtils.showLong("金额不能大于 999999.99");
                            return;
                        }
                    item.setStaffProportion(val);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public List<EmplMsg> getData() {
            return data;
        }

        public void setData(List<EmplMsg> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean check() {
            if (type == 1) {
                double total = 0;
                for (EmplMsg item : data) {
                    total = CommonUtils.add(total, item.getStaffProportion());
                }
                if (total == 100) {
                    return true;
                }
                ToastUtils.showLong("员工提成比例总和应为100");
                return false;
            }
            return true;
        }

        class ProportionHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tvTcName)
            TextView tvTcName;
            @BindView(R.id.etTcValue)
            EditText etTcValue;
            @BindView(R.id.tvTcType)
            TextView tvTcType;

            public ProportionHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}

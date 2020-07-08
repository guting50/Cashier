package com.wycd.yushangpu.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.widget.BgLayout;
import com.gt.utils.widget.BgTextView;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.DeductRuleBean;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.SysSwitchType;
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
import com.wycd.yushangpu.tools.NullUtils;
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

public class StaffChooseDialog {
    private static List<EmplMsg> emplist = new ArrayList<>();
    private static List<String> mEmplMsgList3;// 已选员工列表
    private static String mSmGid;
    private static boolean isSingle;
    private static int mType = 0;//提成类型 10售卡提成20充值提成30充次提成40快速消费提成50商品消费提成60计次提成80计时提成 90房台消费提成

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID, List<String> mEmplGidList,
                                          String SmGid, int type, final InterfaceBack back) {
        return shopdetailDialog(context, mShopMsg, VGID, mEmplGidList, SmGid, false, type, back);
    }

    public static Dialog shopdetailDialog(final Activity context, final ShopMsg mShopMsg, String VGID, List<String> mEmplGidList,
                                          String SmGid, boolean single, int type, final InterfaceBack back) {
        mType = type;
        boolean allow = false;
        if (ImpParamLoading.REPORT_BEAN != null) {
            List<DeductRuleBean> deductRuleBeans = ImpParamLoading.REPORT_BEAN.getDeductRule();
            for (DeductRuleBean bean : deductRuleBeans) {
                if (bean.getSS_Type() == mType) {
                    allow = true;
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
        View view = inflater.inflate(R.layout.dialog_choose_staff, null);
        ListView listView = view.findViewById(R.id.listview);
        BgTextView rl_confirm = view.findViewById(R.id.rl_confirm);
        ImageView rl_cancle = view.findViewById(R.id.rl_cancle);
        NumInputView editTextLayout = view.findViewById(R.id.edit_text_layout);
        FrameLayout flProportionLayout = view.findViewById(R.id.flProportionLayout);
        TextView tv_title_proportion = view.findViewById(R.id.tv_title_proportion);
        RecyclerView recyclerProportion = view.findViewById(R.id.recycler_proportion);

        BgLayout li_search = view.findViewById(R.id.li_search);

        new NumKeyboardUtils(context, view, editTextLayout);
        editTextLayout.setFocusable(true);

        Dialog loadingdialog = LoadingDialog.loadingDialog(context, 1);

        //员工列表
        final List<EmplMsg> mEmplMsgList = new ArrayList<>();
        mEmplMsgList3 = mEmplGidList;
        mSmGid = SmGid;
        isSingle = single;

        //员工适配器
        final YuangongAdapter yuangongAdapter = new YuangongAdapter(context, mEmplMsgList, editTextLayout);
        listView.setAdapter(yuangongAdapter);
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(view);

        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes(); //获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.8); //宽度设置为屏幕的0.8
        p.height = (int) (d.getHeight() * 0.8);
        dialog.getWindow().setAttributes(p); //设置生效

        dialog.show();
        obtainBumenList(loadingdialog, mShopMsg, VGID, mEmplMsgList, yuangongAdapter);

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
            int aaa = -1;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mEmplMsgList.get(i).setStaffProportion("100");
                if (isSingle) {
                    if (aaa >= 0) {
                        mEmplMsgList.get(aaa).setIschose(false);
                    }
                    mEmplMsgList.get(i).setIschose(true);
                    aaa = i;
                    rl_confirm.performClick();
                } else {
                    if (mEmplMsgList.get(i).isIschose()) {
                        mEmplMsgList.get(i).setIschose(false);
                    } else {
                        mEmplMsgList.get(i).setIschose(true);
                    }
                }
                yuangongAdapter.notifyDataSetChanged();
            }
        });

        rl_cancle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                dialog.dismiss();
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
                SysSwitchRes switchRes302 = SysSwitchRes.getSwitch(SysSwitchType.T302.getV());
                //员工提成按固定
                SysSwitchRes switchRes303 = SysSwitchRes.getSwitch(SysSwitchType.T303.getV());

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
                }
            }
        });
        //清除
        view.findViewById(R.id.bgReset).setOnClickListener(v -> {
            dialog.dismiss();
            back.onResponse(new ArrayList<>());
        });
        //关闭提成框 右上角关闭按钮
        view.findViewById(R.id.iv_cancle_proportion).setOnClickListener(v -> flProportionLayout.setVisibility(View.GONE));
        //关闭提成框 取消按钮
        view.findViewById(R.id.bg_cancle_proportion).setOnClickListener(v -> flProportionLayout.setVisibility(View.GONE));
        // 输入提成后的确定
        view.findViewById(R.id.bg_confirm_proportion).setOnClickListener(v -> {
            if (adapter.check()) {
                flProportionLayout.setVisibility(View.GONE);
                dialog.dismiss();
                back.onResponse(adapter.getData());
            }
        });
        flProportionLayout.setOnClickListener(v -> {

        });

        editTextLayout.setKeyEventCallback((keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                List<EmplMsg> mEmplMsgList2 = new ArrayList<>();
                for (EmplMsg emp : mEmplMsgList) {
                    if (emp.isIschose()) {
                        mEmplMsgList2.add(emp);
                    }
                }
                if (mEmplMsgList2.size() > 0) {
                    rl_confirm.performClick();
                } else {
                    li_search.performClick();
                }
                editTextLayout.setFocusable(true);
            }
            return false;
        });
        return dialog;
    }

    private static void obtainBumenList(Dialog loadingdialog, ShopMsg mShopMsg, String VGID,
                                        List<EmplMsg> emplMsgList, YuangongAdapter yuangongAdapter) {
        loadingdialog.show();

        RequestParams params = new RequestParams();
        params.put("Type", mType);
        params.put("VGID", VGID);
        if (mShopMsg != null) {
            params.put("PGID", mShopMsg.getGID());
            params.put("PTGID", mShopMsg.getPT_ID());
        }
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
                obtainEmpList(loadingdialog, mValiRuleMsgList, emplMsgList, yuangongAdapter);
            }

            @Override
            public void onErrorResponse(Object msg) {
                super.onErrorResponse(msg);
                loadingdialog.dismiss();
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
            }

            @Override
            public void onErrorResponse(Object msg) {
                loadingdialog.dismiss();
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
        //提成类型 10售卡提成20充值提成30充次提成40快速消费提成50商品消费提成60计次提成80计时提成 90房台消费提成
        for (EmplMsg emplMsg : sllist) {
            switch (mType) {
                case 50:
//                  过滤调没有开启商品消费提成的员工
                    if (emplMsg.getEM_TipGoodsConsume() > 0) {
                        first.add(emplMsg);
                    }
                    break;
                case 10:
//                  过滤调没有开启售卡提成的员工
                    if (emplMsg.getEM_TipCard() > 0) {
                        first.add(emplMsg);
                    }
                    break;
                case 20:
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
                    emplMsgList.get(j).setStaffProportion("0");
                    if (mEmplMsgList3.get(i).equals(emplMsgList.get(j).getGID())) {
                        emplMsgList.get(j).setIschose(true);
                        emplMsgList.get(j).setStaffProportion(emplMsgList.get(i).getStaffProportion());
                    }
                }
            }
        }
        yuangongAdapter.notifyDataSetChanged();

    }

    static class YuangongAdapter extends BaseAdapter {
        private List<EmplMsg> list;
        private Context context;
        private NumInputView editTextLayout;

        public YuangongAdapter(Context context, List<EmplMsg> list, NumInputView editTextLayout) {
            this.list = list;
            this.context = context;
            this.editTextLayout = editTextLayout;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final ViewHolder holder1;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_shopdetail_yuangong, viewGroup, false);
                holder1 = new ViewHolder(view);
                view.setTag(holder1);
            } else {
                holder1 = (ViewHolder) view.getTag();
            }
            final EmplMsg vipMsg = list.get(i);
            holder1.tv_ygname.setText(NullUtils.noNullHandle(vipMsg.getEM_Name()).toString());
            holder1.tv_ygcode.setText(NullUtils.noNullHandle(vipMsg.getEM_Code()).toString());
//        holder1.tv_ygsex.setText(Integer.parseInt(NullUtils.noNullHandle(vipMsg.getEM_Sex()).toString()) == 1 ? "男" : "女");
            holder1.tv_ygsex.setText(NullUtils.noNullHandle(vipMsg.getDM_Name()).toString());
            if (vipMsg.isIschose()) {
                holder1.iv_chose.setBackgroundResource(R.drawable.emp_chose);
            } else {
                holder1.iv_chose.setBackgroundResource(R.drawable.emp_not);
            }
            editTextLayout.setFocusable(true);
            return view;
        }

        class ViewHolder {
            @BindView(R.id.tv_ygname)
            TextView tv_ygname;
            @BindView(R.id.tv_ygcode)
            TextView tv_ygcode;
            @BindView(R.id.tv_ygsex)
            TextView tv_ygsex;
            @BindView(R.id.iv_chose)
            ImageView iv_chose;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
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
                holder.etTcValue.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else if (type == 2) {
                holder.tvTcType.setText("元");
                holder.etTcValue.setInputType(0x00002002);
            }
            holder.etTcValue.addTextChangedListener(new TextWatcher() {
                String mBefore;

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    mBefore = s.toString();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    double val = 0;
                    if (!TextUtils.isEmpty(s)) {
                        try {
                            val = Double.valueOf(s.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showLong("只能输入数字");
                        }
                    }
                    if (type == 1 && val > 100) {
                        holder.etTcValue.setText(mBefore);
                        ToastUtils.showLong("比例不能大于 100");
                    } else if (type == 2 && val > 999999.99) {
                        holder.etTcValue.setText(mBefore);
                        ToastUtils.showLong("金额不能大于 999999.99");
                    } else {
                        item.setStaffProportion(s.toString());
                    }
                    holder.etTcValue.setSelection(holder.etTcValue.getText().length());
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

        public int getType() {
            return type;
        }

        public boolean check() {
            if (type == 1) {
                double total = 0;
                for (EmplMsg item : data) {
                    total = CommonUtils.add(total, Double.valueOf(item.getStaffProportion()));
                }
                if (total == 100) {
                    return true;
                }
                ToastUtils.showLong("员工提成比例总和应为100");
                return false;
            } else {
                for (EmplMsg item : data) {
                    if (Double.valueOf(item.getStaffProportion()) == 0) {
                        ToastUtils.showLong("请输入金额");
                        return false;
                    }
                }
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

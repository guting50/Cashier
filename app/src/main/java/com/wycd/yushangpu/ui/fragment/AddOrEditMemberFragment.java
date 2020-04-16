package com.wycd.yushangpu.ui.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.MemberLabel;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpPreLoading;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.widget.calendarselecter.CalendarSelector;
import com.wycd.yushangpu.widget.calendarselecter.DateUtil;
import com.wycd.yushangpu.widget.dialog.ShopDetailDialog;
import com.wycd.yushangpu.widget.dialog.VipChooseDialog;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddOrEditMemberFragment extends BaseFragment {

    @BindView(R.id.et_VCH_Card)
    EditText et_VCH_Card;
    @BindView(R.id.et_VIP_Name)
    EditText et_VIP_Name;
    @BindView(R.id.et_VIP_FaceNumber)
    EditText et_VIP_FaceNumber;
    @BindView(R.id.et_VIP_Overdue)
    TextView et_VIP_Overdue;
    @BindView(R.id.et_VIP_ICCard)
    EditText et_VIP_ICCard;
    @BindView(R.id.et_MA_AggregateAmount)
    EditText et_MA_AggregateAmount;
    @BindView(R.id.et_VIP_Referee)
    TextView et_VIP_Referee;
    @BindView(R.id.et_EM_Name)
    TextView et_EM_Name;
    @BindView(R.id.et_VCH_CreateTime)
    TextView et_VCH_CreateTime;
    @BindView(R.id.et_VIP_Addr)
    EditText et_VIP_Addr;
    @BindView(R.id.et_VIP_CellPhone)
    EditText et_VIP_CellPhone;
    @BindView(R.id.et_VG_GID)
    TextView et_VG_GID;
    @BindView(R.id.et_VIP_Birthday)
    TextView et_VIP_Birthday;
    @BindView(R.id.et_VIP_Email)
    EditText et_VIP_Email;
    @BindView(R.id.et_VIP_FixedPhone)
    EditText et_VIP_FixedPhone;
    @BindView(R.id.et_MA_AvailableIntegral)
    EditText et_MA_AvailableIntegral;
    @BindView(R.id.et_SM_Name)
    EditText et_SM_Name;
    @BindView(R.id.et_VCH_Fee)
    EditText et_VCH_Fee;
    @BindView(R.id.et_VIP_Label)
    TextView et_VIP_Label;
    @BindView(R.id.et_VIP_Remark)
    EditText et_VIP_Remark;


    @BindView(R.id.select_recycler_view)
    RecyclerView select_recycler_view;

    private VipInfoMsg vipInfoMsg;
    private boolean mCardContactPhone, mIsfilltel = true;//会员卡号同手机号
    private boolean isCardNum;
    private SelectAdapter selectAdapter;
    List<ReportMessageBean.VIPGradeListBean> mMemberGrade;
    List<MemberLabel> mModelLabel;
    private List<String> mGradeNameList = new ArrayList<>();//会员等级名称集合
    private List<String> mModelLabelList = new ArrayList<>();//会员等级名称集合

    @Override
    public int getContentView() {
        return R.layout.fragment_add_or_edit_member;
    }

    @Override
    public void onCreated() {
        et_VIP_Name.setOnFocusChangeListener(onFocusChangeListener);
        et_VIP_Overdue.setOnFocusChangeListener(onFocusChangeListener);
        et_MA_AggregateAmount.setOnFocusChangeListener(onFocusChangeListener);
        et_VIP_Referee.setOnFocusChangeListener(onFocusChangeListener);
        et_EM_Name.setOnFocusChangeListener(onFocusChangeListener);
        et_MA_AvailableIntegral.setOnFocusChangeListener(onFocusChangeListener);
        et_VIP_Birthday.setOnFocusChangeListener(onFocusChangeListener);

        rootView.findViewById(R.id.tv_VIP_Sex_0).setSelected(true);
        rootView.findViewById(R.id.et_select_VIP_Referee).setSelected(true);
        rootView.findViewById(R.id.et_select_EM_Name).setSelected(true);

        ((CheckBox) rootView.findViewById(R.id.cb_is_perpetual)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    et_VIP_Overdue.setText("");
                    et_VIP_Overdue.setTag("");
                    et_VIP_Overdue.setEnabled(false);
                } else {
                    et_VIP_Overdue.setEnabled(true);
                }
            }
        });
        select_recycler_view.setLayoutManager(new LinearLayoutManager(homeActivity));
        select_recycler_view.setAdapter(selectAdapter = new SelectAdapter());
    }

    private void getMemberLabel() {
        RequestParams params = new RequestParams();
        params.put("ML_Name", "");
        AsyncHttpUtils.postHttp(HttpAPI.API().MEMBER_LABEL, params, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                Type listType = new TypeToken<List<MemberLabel>>() {
                }.getType();
                mModelLabelList.clear();
                mModelLabel = response.getData(listType);
                if (mModelLabel != null && mModelLabel.size() > 0) {
                    for (int i = 0; i < mModelLabel.size(); i++) {
                        mModelLabelList.add(mModelLabel.get(i).getML_Name());
                    }
                }
            }
        });
    }

    private View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            View v = ((ViewGroup) view.getParent()).getChildAt(3);
            if (b) {
                v.setBackgroundResource(R.color.graeen_botton);
            } else {
                v.setBackgroundResource(R.color.view_gray_line);
            }
        }
    };

    public void setData(VipInfoMsg info) {
        vipInfoMsg = info;
        super.setData();
    }

    protected void updateData() {
        if (vipInfoMsg == null) {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("新增会员");
            et_VCH_Card.setText("");
            et_VIP_Name.setText("");
            et_VIP_FaceNumber.setText("");
            et_VIP_Overdue.setText("");
            et_VIP_ICCard.setText("");
            et_MA_AggregateAmount.setText("0");
            et_VIP_Referee.setText("");
            et_EM_Name.setText("");
            et_VCH_CreateTime.setText(DateTimeUtil.getNowDate());
            et_VCH_CreateTime.setTag(DateTimeUtil.getNowDate());
            et_VIP_Addr.setText("");
            et_VIP_CellPhone.setText("");
            et_VG_GID.setText("");
            et_VIP_Birthday.setText("");
            et_VIP_Email.setText("");
            et_VIP_FixedPhone.setText("");
            et_MA_AvailableIntegral.setText("0");
            et_SM_Name.setText(MyApplication.loginBean.getSM_Name());
            et_SM_Name.setTag(MyApplication.loginBean.getShopID());
            et_VCH_Fee.setText("");
            et_VIP_Label.setText("");
            et_VIP_Remark.setText("");
        } else {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("编辑会员");
        }
        List<ReportMessageBean.GetSysSwitchListBean> mSwitchEntity = ImpPreLoading.REPORT_BEAN.getGetSysSwitchList();

        mCardContactPhone = false;
        et_VCH_Card.setEnabled(true);
        mIsfilltel = false;
        ((ViewGroup) et_VIP_CellPhone.getParent()).getChildAt(1).setVisibility(View.INVISIBLE);
        et_VIP_FaceNumber.setEnabled(false);
        isCardNum = false;
        rootView.findViewById(R.id.et_select_EM_Name).setEnabled(false);
        if (mSwitchEntity != null && mSwitchEntity.size() > 0) {
            for (ReportMessageBean.GetSysSwitchListBean sysSwitchListBean : mSwitchEntity) {
                switch (sysSwitchListBean.getSS_Code()) {
                    case "201"://会员卡号同手机号
                        if (sysSwitchListBean.getSS_State() == 1) {
                            mCardContactPhone = true;
                            et_VCH_Card.setEnabled(false);
                        }
                        break;
                    case "211"://是否必填手机号
                        if (sysSwitchListBean.getSS_State() == 1) {
                            mIsfilltel = true;
                            ((ViewGroup) et_VIP_CellPhone.getParent()).getChildAt(1).setVisibility(View.VISIBLE);
                        }
                        break;
                    case "208"://卡面号码
                        if (sysSwitchListBean.getSS_State() == 1) {
                            et_VIP_FaceNumber.setEnabled(true);
                            isCardNum = true;
                        }
                        break;
                    case "202"://初始密码
                        if (sysSwitchListBean.getSS_State() == 1) {

                        }
                        break;
                    case "103"://银联支付
                        if (sysSwitchListBean.getSS_State() == 1) {

                        }
                        break;
                    case "101"://现金支付
                        if (sysSwitchListBean.getSS_State() == 1) {

                        }
                        break;
                    case "106"://支付宝记账
                        if (sysSwitchListBean.getSS_State() == 1) {

                        }
                        break;
                    case "105"://微信记账
                        if (sysSwitchListBean.getSS_State() == 1) {

                        }
                        break;
                    case "301": //员工提成
                        if (sysSwitchListBean.getSS_State() == 1) {
                            rootView.findViewById(R.id.et_select_EM_Name).setEnabled(true);
                        }
                        break;
                }
            }
        }

        getMemberLabel();
        mMemberGrade = ImpPreLoading.REPORT_BEAN.getVIPGradeList();
        mGradeNameList.clear();
        if (mMemberGrade != null && mMemberGrade.size() > 0) {
            selectedMemberGrade(mMemberGrade.get(0));
            for (int i = 0; i < mMemberGrade.size(); i++) {
                mGradeNameList.add(mMemberGrade.get(i).getVG_Name());
            }
        }
    }

    private void selectedMemberGrade(ReportMessageBean.VIPGradeListBean vipGradeListBean) {
        et_VG_GID.setText(vipGradeListBean.getVG_Name());
        et_VG_GID.setTag(vipGradeListBean.getGID());
        et_MA_AggregateAmount.setText(Decima2KeeplUtil.stringToDecimal(vipGradeListBean.getVG_InitialAmount() + ""));//会员初始金额
        et_VCH_Fee.setText(vipGradeListBean.getVG_CardAmount() + "");//售卡金额
        et_MA_AvailableIntegral.setText(vipGradeListBean.getVG_InitialIntegral() + "");//初始积分
        if (vipGradeListBean.getVG_IsTime() == 1 && vipGradeListBean.getVG_IsTimeNum() != null) {
            et_VIP_Overdue.setText(addTime(vipGradeListBean.getVG_IsTimeUnit(), Double.parseDouble(vipGradeListBean.getVG_IsTimeNum() + "")));
            et_VIP_Overdue.setEnabled(false);
            rootView.findViewById(R.id.cb_is_perpetual).setEnabled(false);
        } else if (vipGradeListBean.getVG_IsTime() == 1 && vipGradeListBean.getVG_IsTimeNum() == null) {
            rootView.findViewById(R.id.cb_is_perpetual).setEnabled(false);
            ((CheckBox) rootView.findViewById(R.id.cb_is_perpetual)).setChecked(true);
            et_VIP_Overdue.setEnabled(false);
        } else {
            rootView.findViewById(R.id.cb_is_perpetual).setEnabled(true);
            ((CheckBox) rootView.findViewById(R.id.cb_is_perpetual)).setChecked(false);
            et_VIP_Overdue.setEnabled(true);
        }
    }

    private String addTime(String str, double num) {
        int No = (int) num;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        if (str.equals("天")) {
            c.add(Calendar.DATE, No);
        } else if (str.equals("月")) {
            c.add(Calendar.MONTH, No);
        } else if (str.equals("年")) {
            c.add(Calendar.YEAR, No);
        }
        return sdf.format(c.getTime());
    }

    @OnClick({R.id.tv_title, R.id.fl_cancel, R.id.tv_VIP_Sex_0, R.id.tv_VIP_Sex_1, R.id.et_select_VIP_Referee,
            R.id.et_select_EM_Name, R.id.fl_submit, R.id.et_VIP_Overdue, R.id.et_VIP_Birthday, R.id.et_VCH_CreateTime,
            R.id.et_VG_GID, R.id.et_VIP_Label})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
            case R.id.fl_cancel:
                homeActivity.fragmentManager.beginTransaction().hide(this).commit();
                break;
            case R.id.tv_VIP_Sex_0://男
                rootView.findViewById(R.id.tv_VIP_Sex_1).setSelected(false);
                ((TextView) rootView.findViewById(R.id.tv_VIP_Sex_1))
                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                view.setSelected(true);
                ((TextView) view).setTextColor(homeActivity.getResources().getColor(R.color.white));
                break;
            case R.id.tv_VIP_Sex_1://女
                rootView.findViewById(R.id.tv_VIP_Sex_0).setSelected(false);
                ((TextView) rootView.findViewById(R.id.tv_VIP_Sex_0))
                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                view.setSelected(true);
                ((TextView) view).setTextColor(homeActivity.getResources().getColor(R.color.white));
                break;
            case R.id.et_select_VIP_Referee://选择推荐人
                VipChooseDialog vipChooseDialog = new VipChooseDialog(homeActivity, null, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        VipInfoMsg vipInfoMsg = (VipInfoMsg) response;
                        et_VIP_Referee.setText(vipInfoMsg.getVIP_Name());
                        et_VIP_Referee.setTag(vipInfoMsg.getVCH_Card());
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
                vipChooseDialog.show();
                break;
            case R.id.et_select_EM_Name://选择人员
                ShopDetailDialog.shopdetailDialog(getActivity(), null, "",
                        null, MyApplication.loginBean.getShopID(), 1, true, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                List<EmplMsg> mEmplMsgList = (List<EmplMsg>) response;
                                if (mEmplMsgList != null && mEmplMsgList.size() == 1) {
                                    et_EM_Name.setText(mEmplMsgList.get(0).getEM_Name());
                                    et_EM_Name.setTag(mEmplMsgList.get(0).getGID());
                                }
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                break;
            case R.id.et_VIP_Overdue:// 过期时间
                CalendarSelector mCalendarSelector = new CalendarSelector(homeActivity, 0, new CalendarSelector.ICalendarSelectorCallBack() {
                    @Override
                    public void transmitPeriod(HashMap<String, String> result) {
                        et_VIP_Overdue.setText(result.get("year") + result.get("month") + result.get("day"));
                        et_VIP_Overdue.setTag(result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval"));
                    }
                });
                mCalendarSelector.show(et_VIP_Overdue);
                if (et_VIP_Overdue.getText().toString().isEmpty()) {
                    mCalendarSelector.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                } else {
                    mCalendarSelector.setPosition(DateUtil.getDateForString(et_VIP_Overdue.getTag().toString()), "0", "0");
                }
                break;
            case R.id.et_VIP_Birthday://会员生日
                CalendarSelector mCalendarSelector1 = new CalendarSelector(homeActivity, 0, new CalendarSelector.ICalendarSelectorCallBack() {
                    @Override
                    public void transmitPeriod(HashMap<String, String> result) {
                        et_VIP_Birthday.setText(result.get("year") + result.get("month") + result.get("day"));
                        et_VIP_Birthday.setTag(result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval"));
                        ((TextView) rootView.findViewById(R.id.tv_select_birthday_type))
                                .setText(TextUtils.equals("1", result.get("islunar")) ? "农历" : "公历");
//                        calaryMonth = result.get("CalaryMonth");
//                        isLunar = result.get("islunar");
                    }
                });
                mCalendarSelector1.show(et_VIP_Birthday);
                mCalendarSelector1.showSelectType();
                if (et_VIP_Birthday.getText().toString().isEmpty()) {
                    mCalendarSelector1.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                } else {
                    mCalendarSelector1.setPosition(DateUtil.getDateForString(et_VIP_Birthday.getTag().toString()), "0", "0");
                }
                break;
            case R.id.et_VCH_CreateTime://开卡日期
                CalendarSelector mCalendarSelector2 = new CalendarSelector(homeActivity, 0, new CalendarSelector.ICalendarSelectorCallBack() {
                    @Override
                    public void transmitPeriod(HashMap<String, String> result) {
                        et_VCH_CreateTime.setText(result.get("year") + result.get("month") + result.get("day"));
                        et_VCH_CreateTime.setTag(result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval"));
                    }
                });
                mCalendarSelector2.show(et_VCH_CreateTime);
                if (et_VCH_CreateTime.getText().toString().isEmpty()) {
                    mCalendarSelector2.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                } else {
                    mCalendarSelector2.setPosition(DateUtil.getDateForString(et_VCH_CreateTime.getTag().toString()), "0", "0");
                }
                break;
            case R.id.et_VG_GID://会员等级
                View viewParent = (View) select_recycler_view.getParent();
                viewParent.setVisibility(View.VISIBLE);
                ((RelativeLayout.LayoutParams) viewParent.getLayoutParams())
                        .addRule(RelativeLayout.BELOW, R.id.ly_VG_GID);
                selectAdapter.setData(mGradeNameList, et_VG_GID.getText().toString(), new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        selectedMemberGrade(mMemberGrade.get((int) response));
                    }
                });
                break;
            case R.id.et_VIP_Label:
                View viewParent1 = (View) select_recycler_view.getParent();
                viewParent1.setVisibility(View.VISIBLE);
                ((RelativeLayout.LayoutParams) viewParent1.getLayoutParams())
                        .addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ly_VIP_Label);
                selectAdapter.setData(mModelLabelList, et_VIP_Label.getText().toString(), new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        et_VIP_Label.setText(mModelLabel.get((int) response).getML_Name());
                    }
                });
                break;
            case R.id.fl_submit://提交
                break;
        }
    }

    class SelectAdapter extends RecyclerView.Adapter {

        List<String> data = new ArrayList<>();
        String positionId = "";
        Holder selectedHolser;
        InterfaceBack back;

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(homeActivity).inflate(R.layout.item_select_lable, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Holder myHolder = (Holder) holder;
            String item = data.get(position);
            myHolder.tv_select_lable.setText(item);
            myHolder.tv_select_lable.setTag(position);
            myHolder.tv_select_lable.setTextColor(homeActivity.getResources().getColor(R.color.text66));
            myHolder.tv_select_lable.setBackgroundResource(R.color.white);
            if (TextUtils.equals(item, positionId)) {
                myHolder.tv_select_lable.setTextColor(homeActivity.getResources().getColor(R.color.white));
                myHolder.tv_select_lable.setBackgroundResource(R.color.color_149f4a);
            }
            myHolder.tv_select_lable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (selectedHolser != null) {
                        selectedHolser.tv_select_lable.setTextColor(homeActivity.getResources().getColor(R.color.text66));
                        selectedHolser.tv_select_lable.setBackgroundResource(R.color.white);
                    }
                    selectedHolser = myHolder;
                    selectedHolser.tv_select_lable.setTextColor(homeActivity.getResources().getColor(R.color.white));
                    selectedHolser.tv_select_lable.setBackgroundResource(R.color.color_149f4a);
                    ((View) select_recycler_view.getParent()).setVisibility(View.GONE);
                    back.onResponse(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void setData(List<String> data, String positionId, InterfaceBack back) {
            this.data = data;
            this.positionId = positionId;
            this.back = back;
            notifyDataSetChanged();
        }

        class Holder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_select_lable)
            TextView tv_select_lable;

            public Holder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}

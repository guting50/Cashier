package com.wycd.yushangpu.ui.fragment;

import android.net.Uri;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gt.photopicker.PhotoPickerActivity;
import com.gt.photopicker.SelectModel;
import com.gt.photopicker.intent.PhotoPickerIntent;
import com.gt.utils.PermissionUtils;
import com.gt.utils.widget.OnNoDoubleClickListener;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.LabelBean;
import com.wycd.yushangpu.bean.MemberLabel;
import com.wycd.yushangpu.bean.OrderPayResult;
import com.wycd.yushangpu.bean.PayType;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.bean.SysSwitchRes;
import com.wycd.yushangpu.bean.SysSwitchType;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpParamLoading;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
import com.wycd.yushangpu.tools.DateTimeUtil;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.GlideTransform;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.RegexUtil;
import com.wycd.yushangpu.widget.MaxHeightRecyclerView;
import com.wycd.yushangpu.widget.calendarselecter.CalendarSelector;
import com.wycd.yushangpu.widget.calendarselecter.DateUtil;
import com.wycd.yushangpu.widget.dialog.SaomaDialog;
import com.wycd.yushangpu.widget.dialog.ShopDetailDialog;
import com.wycd.yushangpu.widget.dialog.VipChooseDialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 添加或编辑会员
 */
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
    @BindView(R.id.et_VCH_Pwd)
    EditText et_VCH_Pwd;
    @BindView(R.id.et_VCH_Pwd_Confirm)
    EditText et_VCH_Pwd_Confirm;
    @BindView(R.id.et_VIP_Birthday)
    TextView et_VIP_Birthday;
    @BindView(R.id.et_MA_AvailableIntegral)
    EditText et_MA_AvailableIntegral;
    @BindView(R.id.et_SM_Name)
    TextView et_SM_Name;
    @BindView(R.id.et_VCH_Fee)
    EditText et_VCH_Fee;
    @BindView(R.id.et_VIP_Label)
    TextView et_VIP_Label;
    @BindView(R.id.et_VIP_Remark)
    EditText et_VIP_Remark;
    @BindView(R.id.tv_select_Pay_Way)
    TextView tv_select_Pay_Way;
    @BindView(R.id.recycler_view_costomfields)
    RecyclerView recycler_view_costomfields;
    @BindView(R.id.iv_edit_head_img)
    ImageView iv_edit_head_img;

    @BindView(R.id.select_recycler_view)
    RecyclerView select_recycler_view;

    private VipInfoMsg vipInfoMsg;
    private boolean mCardContactPhone, mIsfilltel = true;//会员卡号同手机号
    private boolean isCardNum;
    private SelectAdapter selectAdapter;
    private List<ReportMessageBean.VIPGradeListBean> mMemberGrade;
    private List<ReportMessageBean.GetCustomFieldsVIPBean> costomfields;
    private List<MemberLabel> mModelLabel;
    private List<String> mGradeNameList = new ArrayList<>();//会员等级名称集合
    private List<String> mModelLabelList = new ArrayList<>();
    private List<String> mPayWayList = new ArrayList<>();
    private List<LabelBean> mLabList = new ArrayList<>();

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
        et_VCH_Fee.setOnFocusChangeListener(onFocusChangeListener);

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
        mMemberGrade = ImpParamLoading.REPORT_BEAN.getVIPGradeList();
        costomfields = ImpParamLoading.REPORT_BEAN.getGetCustomFieldsVIP();
        mPayWayList.clear();
        mPayWayList.add("现金支付");
        showAttr();
        rootView.findViewById(R.id.et_select_EM_Name).setEnabled(false);
        rootView.findViewById(R.id.et_select_EM_Name).setSelected(false);
        ((TextView) rootView.findViewById(R.id.et_select_EM_Name))
                .setTextColor(homeActivity.getResources().getColor(R.color.color_999999));
        if (vipInfoMsg == null) {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("新增会员");
            et_VCH_Card.setText("");
            et_VIP_Name.setText("");
            et_VIP_FaceNumber.setText("");
            et_VIP_Overdue.setText("");
            et_VIP_Overdue.setTag("");
            et_VIP_ICCard.setText("");
            et_MA_AggregateAmount.setText("0");
            et_VIP_Referee.setText("");
            et_EM_Name.setText("");
            et_VCH_CreateTime.setText(DateTimeUtil.getNowDate());
            et_VCH_CreateTime.setTag(DateTimeUtil.getNowDate());
            et_VIP_Addr.setText("");
            et_VIP_CellPhone.setText("");
            et_VG_GID.setText("");
            et_VCH_Pwd.setText("");
            et_VCH_Pwd_Confirm.setText("");
            et_VIP_Birthday.setText("");
            et_VIP_Birthday.setTag("");
            et_MA_AvailableIntegral.setText("0");
            et_SM_Name.setText(MyApplication.loginBean.getSM_Name());
            et_SM_Name.setTag(MyApplication.loginBean.getShopID());
            et_VCH_Fee.setText("");
            et_VIP_Label.setText("");
            et_VIP_Remark.setText("");

            et_VCH_Card.setEnabled(true);
            et_VCH_Pwd.setText("");
            et_VCH_Pwd_Confirm.setText("");
            et_VCH_Pwd.setEnabled(true);
            et_VCH_Pwd_Confirm.setEnabled(true);
            et_MA_AggregateAmount.setEnabled(true);
            et_MA_AvailableIntegral.setEnabled(true);
            et_VCH_Fee.setEnabled(true);
            tv_select_Pay_Way.setEnabled(true);
            mPayTypeCode = "XJZF";
            mPayTypeName = mPayWayList.get(0);

            iv_edit_head_img.setImageResource(R.mipmap.member_head_nohead);
        } else {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText("编辑会员");
            et_VCH_Card.setEnabled(false);
            et_VCH_Pwd.setEnabled(false);
            et_VCH_Pwd_Confirm.setEnabled(false);
            et_MA_AggregateAmount.setEnabled(false);
            et_MA_AvailableIntegral.setEnabled(false);
            et_VCH_Fee.setEnabled(false);
            tv_select_Pay_Way.setEnabled(false);

            mGradeGid = vipInfoMsg.getVG_GID();
            mPayTypeName = vipInfoMsg.getVCH_Fee_PayTypeText();

            et_VCH_Card.setText(vipInfoMsg.getVCH_Card());
            et_VIP_Name.setText(vipInfoMsg.getVIP_Name());
            et_VIP_FaceNumber.setText(vipInfoMsg.getVIP_FaceNumber());
            et_VIP_Overdue.setText(vipInfoMsg.getVIP_Overdue());
            et_VIP_Overdue.setTag(vipInfoMsg.getVIP_Overdue());
            et_VIP_ICCard.setText(vipInfoMsg.getVIP_ICCard());
            et_MA_AggregateAmount.setText(vipInfoMsg.getMA_AggregateAmount() + "");
            et_VIP_Referee.setText(vipInfoMsg.getVIP_Referee());
            et_EM_Name.setText(vipInfoMsg.getEM_Name());
            et_VCH_CreateTime.setText(vipInfoMsg.getVCH_CreateTime());
            et_VCH_CreateTime.setTag(vipInfoMsg.getVCH_CreateTime());
            et_VIP_Addr.setText(vipInfoMsg.getVIP_Addr());
            et_VIP_CellPhone.setText(vipInfoMsg.getVIP_CellPhone());
            et_VG_GID.setText(vipInfoMsg.getVG_GID());
            et_VCH_Pwd.setText("......");
            et_VCH_Pwd_Confirm.setText("......");
            et_VIP_Birthday.setText(vipInfoMsg.getVIP_Birthday());
            et_VIP_Birthday.setTag(vipInfoMsg.getVIP_Birthday());
            et_MA_AvailableIntegral.setText(vipInfoMsg.getMA_AvailableIntegral() + "");
            et_SM_Name.setText(vipInfoMsg.getSM_Name());
            et_VCH_Fee.setText(vipInfoMsg.getVCH_Fee() + "");
            et_VIP_Label.setText(vipInfoMsg.getVIP_Label());
            //标签
            StringBuilder mLabName = new StringBuilder();
            if (!TextUtils.isEmpty(vipInfoMsg.getVIP_Label())) {
                Type listType = new TypeToken<List<LabelBean>>() {
                }.getType();
                List<LabelBean> varLabBean = new Gson().fromJson(vipInfoMsg.getVIP_Label(), listType);
                if (varLabBean != null) {
                    mLabList.clear();
                    for (int i = 0; i < varLabBean.size(); i++) {
                        mLabList.add(varLabBean.get(i));
                        if (i == varLabBean.size() - 1 || i == 0) {
                            mLabName.append(varLabBean.get(i).getItemName());
                        } else {
                            mLabName.append(varLabBean.get(i).getItemName() + "、");
                        }
                    }
                }
            }
            et_VIP_Label.setText(mLabName);
            et_VIP_Remark.setText(vipInfoMsg.getVIP_Remark());

            for (int i = 0; i < costomfields.size(); i++) {
                if (vipInfoMsg.getCustomeFieldList() != null && vipInfoMsg.getCustomeFieldList().size() > 0) {
                    for (int j = 0; j < vipInfoMsg.getCustomeFieldList().size(); j++) {
                        if (costomfields.get(i).getCF_FieldName().equals(vipInfoMsg.getCustomeFieldList().get(j).getCF_FieldName())) {
                            costomfields.get(i).setM_ItemsValue(vipInfoMsg.getCustomeFieldList().get(j).getCF_Value());
                        }
                    }
                }
            }

            Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(vipInfoMsg.getVIP_HeadImg()).toString()))
                    .placeholder(R.mipmap.member_head_nohead)
                    .transform(new CenterCrop(homeActivity), new GlideTransform.GlideCornersTransform(homeActivity, 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv_edit_head_img);
        }

        mCardContactPhone = false;
        mIsfilltel = false;
        ((ViewGroup) et_VIP_CellPhone.getParent()).getChildAt(1).setVisibility(View.INVISIBLE);
        et_VIP_FaceNumber.setEnabled(false);
        isCardNum = false;
        
        //会员卡号同手机号
        if (SysSwitchRes.getSwitch(SysSwitchType.T201.getV()).getSS_State() == 1) {
            mCardContactPhone = true;
            et_VCH_Card.setEnabled(false);
        }
        //是否必填手机号
        if (SysSwitchRes.getSwitch(SysSwitchType.T211.getV()).getSS_State() == 1) {
            mIsfilltel = true;
            ((ViewGroup) et_VIP_CellPhone.getParent()).getChildAt(1).setVisibility(View.VISIBLE);
        }
        //卡面号码
        if (SysSwitchRes.getSwitch(SysSwitchType.T208.getV()).getSS_State() == 1) {
            et_VIP_FaceNumber.setEnabled(true);
            ((ViewGroup) et_VIP_FaceNumber.getParent()).getChildAt(1).setVisibility(View.VISIBLE);
            isCardNum = true;
        }
        //初始密码
        if (vipInfoMsg == null && SysSwitchRes.getSwitch(SysSwitchType.T202.getV()).getSS_State() == 1) {
            et_VCH_Pwd.setText(SysSwitchRes.getSwitch(SysSwitchType.T202.getV()).getSS_Value());
            et_VCH_Pwd_Confirm.setText(SysSwitchRes.getSwitch(SysSwitchType.T202.getV()).getSS_Value());
        }
        //银联支付
        if (SysSwitchRes.getSwitch(SysSwitchType.T103.getV()).getSS_State() == 1) {
            mPayWayList.add("银联支付");
        }
        //现金支付
        if (SysSwitchRes.getSwitch(SysSwitchType.T101.getV()).getSS_State() == 1) {
//                            mPayWayList.add("现金支付");
        }
        //支付宝记账
        if (SysSwitchRes.getSwitch(SysSwitchType.T106.getV()).getSS_State() == 1) {
            mPayWayList.add("支付宝记账");
        }
        //微信记账
        if (SysSwitchRes.getSwitch(SysSwitchType.T105.getV()).getSS_State() == 1) {
            mPayWayList.add("微信记账");
        }
        //扫码支付
        if (SysSwitchRes.getSwitch(SysSwitchType.T111.getV()).getSS_State() == 1) {
            mPayWayList.add("扫码支付");
        }
        //其他支付
        if (SysSwitchRes.getSwitch(SysSwitchType.T113.getV()).getSS_State() == 1) {
            mPayWayList.add("其他支付");
        }
        //员工提成
        if (vipInfoMsg == null && SysSwitchRes.getSwitch(SysSwitchType.T301.getV()).getSS_State() == 1) {
            rootView.findViewById(R.id.et_select_EM_Name).setEnabled(true);
            rootView.findViewById(R.id.et_select_EM_Name).setSelected(true);
            ((TextView) rootView.findViewById(R.id.et_select_EM_Name))
                    .setTextColor(homeActivity.getResources().getColor(R.color.white));
        }

        tv_select_Pay_Way.setText(mPayTypeName);

        getMemberLabel();
        initCostomfieldsAdapter();
        mGradeNameList.clear();
        if (mMemberGrade != null && mMemberGrade.size() > 0) {
            selectedMemberGrade(mMemberGrade.get(0));
            for (int i = 0; i < mMemberGrade.size(); i++) {
                mGradeNameList.add(mMemberGrade.get(i).getVG_Name());
            }
        }

        et_VIP_CellPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mCardContactPhone) {
                    if (!TextUtils.isEmpty(s.toString())) {
                        et_VCH_Card.setText(s.toString());
                    } else {
                        et_VCH_Card.setText("");
                    }
                }
            }
        });

        onClick(rootView.findViewById(R.id.tv_basic_data));
    }

    private void initCostomfieldsAdapter() {
        recycler_view_costomfields.setLayoutManager(new GridLayoutManager(homeActivity, 2));
        CostomfieldsAdapter adapter = new CostomfieldsAdapter();
        recycler_view_costomfields.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void selectedMemberGrade(ReportMessageBean.VIPGradeListBean vipGradeListBean) {
        mGradeGid = vipGradeListBean.getGID();
        et_VG_GID.setText(vipGradeListBean.getVG_Name());
        et_VG_GID.setTag(vipGradeListBean.getGID());
        et_MA_AggregateAmount.setText(Decima2KeeplUtil.stringToDecimal(vipGradeListBean.getVG_InitialAmount() + ""));//会员初始金额
        et_VCH_Fee.setText(vipGradeListBean.getVG_CardAmount() + "");//售卡金额
        mInitPoint = (int) vipGradeListBean.getVG_InitialIntegral() + "";//初始积分
        et_MA_AvailableIntegral.setText(mInitPoint + "");
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
            ((CheckBox) rootView.findViewById(R.id.cb_is_perpetual)).setChecked(true);
            et_VIP_Overdue.setEnabled(false);
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

    @OnClick({R.id.tv_title, R.id.fl_cancel, R.id.tv_basic_data, R.id.tv_costomfields, R.id.tv_VIP_Sex_0, R.id.tv_VIP_Sex_1,
            R.id.et_select_VIP_Referee, R.id.et_select_EM_Name, R.id.fl_submit, R.id.et_VIP_Overdue, R.id.et_VIP_Birthday,
            R.id.tv_select_birthday_type, R.id.et_VCH_CreateTime, R.id.et_VG_GID, R.id.et_VIP_Label, R.id.tv_select_Pay_Way, R.id.bg_upload_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
            case R.id.fl_cancel:
                this.hide();
                break;
            case R.id.tv_basic_data:
                ((TextView) rootView.findViewById(R.id.tv_basic_data)).setTextColor(homeActivity.getResources().getColor(R.color.color_149f4a));
                ((TextView) rootView.findViewById(R.id.tv_costomfields)).setTextColor(homeActivity.getResources().getColor(R.color.color_999999));
                rootView.findViewById(R.id.fl_costomfields_layout).setVisibility(View.GONE);
                break;
            case R.id.tv_costomfields:
                ((TextView) rootView.findViewById(R.id.tv_basic_data)).setTextColor(homeActivity.getResources().getColor(R.color.color_999999));
                ((TextView) rootView.findViewById(R.id.tv_costomfields)).setTextColor(homeActivity.getResources().getColor(R.color.color_149f4a));
                rootView.findViewById(R.id.fl_costomfields_layout).setVisibility(View.VISIBLE);
                break;
            case R.id.tv_VIP_Sex_0://男
                rootView.findViewById(R.id.tv_VIP_Sex_1).setSelected(false);
                ((TextView) rootView.findViewById(R.id.tv_VIP_Sex_1))
                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                view.setSelected(true);
                ((TextView) view).setTextColor(homeActivity.getResources().getColor(R.color.white));
                mSex = 0;
                break;
            case R.id.tv_VIP_Sex_1://女
                rootView.findViewById(R.id.tv_VIP_Sex_0).setSelected(false);
                ((TextView) rootView.findViewById(R.id.tv_VIP_Sex_0))
                        .setTextColor(homeActivity.getResources().getColor(R.color.title_color));
                view.setSelected(true);
                ((TextView) view).setTextColor(homeActivity.getResources().getColor(R.color.white));
                mSex = 1;
                break;
            case R.id.et_select_VIP_Referee://选择推荐人
                VipChooseDialog vipChooseDialog = new VipChooseDialog(homeActivity, null, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        VipInfoMsg vipInfoMsg = (VipInfoMsg) response;
                        et_VIP_Referee.setText(vipInfoMsg.getVIP_Name());
                        et_VIP_Referee.setTag(vipInfoMsg.getVCH_Card());
                        mRecommendCardNum = vipInfoMsg.getVCH_Card();
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
                vipChooseDialog.show();
                break;
            case R.id.et_select_EM_Name://选择人员
                ShopDetailDialog.shopdetailDialog(getActivity(), null, "",
                        null, MyApplication.loginBean.getShopID(), true, 2, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                List<EmplMsg> mEmplMsgList = (List<EmplMsg>) response;
                                if (mEmplMsgList != null && mEmplMsgList.size() == 1) {
                                    et_EM_Name.setText(mEmplMsgList.get(0).getEM_Name());
                                    et_EM_Name.setTag(mEmplMsgList.get(0).getGID());
                                    mStaffListGid = mEmplMsgList.get(0).getGID();
                                    mStaffListPercent = mEmplMsgList.get(0).getStaffProportion();
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
                if (TextUtils.isEmpty(et_VIP_Overdue.getText())) {
                    mCalendarSelector.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                } else {
                    mCalendarSelector.setPosition(DateUtil.getDateForString(et_VIP_Overdue.getTag().toString()), "0", "0");
                }
                break;
            case R.id.et_VIP_Birthday://会员生日
            case R.id.tv_select_birthday_type:
                CalendarSelector mCalendarSelector1 = new CalendarSelector(homeActivity, 0, new CalendarSelector.ICalendarSelectorCallBack() {
                    @Override
                    public void transmitPeriod(HashMap<String, String> result) {
                        et_VIP_Birthday.setText(result.get("year") + result.get("month") + result.get("day"));
                        et_VIP_Birthday.setTag(result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval"));
                        ((TextView) rootView.findViewById(R.id.tv_select_birthday_type))
                                .setText(TextUtils.equals("1", result.get("islunar")) ? "农历" : "公历");
                        calaryMonth = result.get("CalaryMonth");
                        isLunar = result.get("islunar");
                        mBirthday = result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval");
                    }
                });
                mCalendarSelector1.show(et_VIP_Birthday);
                mCalendarSelector1.showSelectType();
                if (TextUtils.isEmpty(et_VIP_Birthday.getText().toString())) {
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
                if (TextUtils.isEmpty(et_VCH_CreateTime.getText().toString())) {
                    mCalendarSelector2.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                } else {
                    mCalendarSelector2.setPosition(DateUtil.getDateForString(et_VCH_CreateTime.getTag().toString()), "0", "0");
                }
                break;
            case R.id.et_VG_GID://会员等级
                View viewParent = (View) select_recycler_view.getParent();
                if (viewParent.getVisibility() == View.GONE) {
                    selectAdapter.setData(mGradeNameList, et_VG_GID.getText().toString(), new InterfaceBack() {

                        @Override
                        public void onResponse(Object response) {
                            selectedMemberGrade(mMemberGrade.get((int) response));
                        }
                    }).show(viewParent, RelativeLayout.BELOW, R.id.ly_VG_GID);
                } else {
                    viewParent.setVisibility(View.GONE);
                }
                break;
            case R.id.et_VIP_Label://会员标签
                View viewParent1 = (View) select_recycler_view.getParent();
                if (viewParent1.getVisibility() == View.GONE) {
                    selectAdapter.setData(mModelLabelList, et_VIP_Label.getText().toString(), new InterfaceBack() {

                        @Override
                        public void onResponse(Object response) {
                            mLabList.clear();
                            et_VIP_Label.setText(mModelLabel.get((int) response).getML_Name());
                            LabelBean labelBean = new LabelBean();
                            labelBean.setItemName(mModelLabel.get((int) response).getML_Name());
                            labelBean.setItemGID(mModelLabel.get((int) response).getML_GID());
                            labelBean.setItemColor(mModelLabel.get((int) response).getML_ColorValue());
                            mLabList.add(labelBean);
                        }
                    }).show(viewParent1, RelativeLayout.ALIGN_BOTTOM, R.id.ly_VCH_Fee);
                } else {
                    viewParent1.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_select_Pay_Way://选择支付方式
                View viewParent3 = (View) select_recycler_view.getParent();
                if (viewParent3.getVisibility() == View.GONE) {
                    selectAdapter.setData(mPayWayList, tv_select_Pay_Way.getText().toString(), new InterfaceBack() {

                        @Override
                        public void onResponse(Object response) {
                            tv_select_Pay_Way.setText(mPayWayList.get((int) response));
                            mPayTypeName = mPayWayList.get((int) response);
                            switch (mPayWayList.get((int) response)) {
                                case "现金支付":
                                    mPayTypeCode = "XJZF";
                                    break;
                                case "银联支付":
                                    mPayTypeCode = "YLZF";
                                    break;
                                case "微信记账":
                                    mPayTypeCode = "WX_JZ";
                                    break;
                                case "支付宝记账":
                                    mPayTypeCode = "ZFB_JZ";
                                    break;
                                case "扫码支付":
                                    mPayTypeCode = "SMZF";
                                    break;
                                case "其他支付":
                                    mPayTypeCode = "QTZF";
                                    break;
                            }
                        }
                    }).show(viewParent3, RelativeLayout.ALIGN_BOTTOM, R.id.ly_SM_Name);
                } else {
                    viewParent3.setVisibility(View.GONE);
                }
                break;
            case R.id.bg_upload_img:
                PermissionUtils.requestPermission(homeActivity, PermissionUtils.READ_EXTERNAL_STORAGE, new PermissionUtils.PermissionGrant() {
                    @Override
                    public void onPermissionGranted(int... requestCode) {
                        PhotoPickerIntent intent = new PhotoPickerIntent(homeActivity);
                        intent.setSelectModel(SelectModel.MULTI);
                        intent.setMaxTotal(1);
                        intent.gotoPhotoPickerActivity(homeActivity, new PhotoPickerActivity.OnSelectedCallbackListener() {
                            @Override
                            public void onSelectedCallback(ArrayList<String> resultList) {
                                for (String str : resultList) {
                                    iv_edit_head_img.setImageURI(Uri.fromFile(new File(str)));
                                    postUploadMemberPhoto(new File(str));
                                }
                            }
                        });
                    }
                });
                break;
            case R.id.fl_submit://提交
                if (getTextValue()) {
                    if ("SMZF".equals(mPayTypeCode)) {
                        showSaomaDialog(mMoney);
                    } else
                        addMemberPost();
                }
                break;
        }
    }

    /**
     * 获取文本框中的值
     */
    private boolean getTextValue() {
        mPhoneNum = et_VIP_CellPhone.getText().toString();
        if (mIsfilltel) {
            if (!TextUtils.isEmpty(et_VIP_CellPhone.getText())) {
                if (!RegexUtil.isTelPhoneNumber(mPhoneNum)) {
                    mPhoneNum = "";
                    warnDialog("【手机号码】格式不正确");
                    return false;
                }
            } else {
                warnDialog("【手机号】不能为空");
                mPhoneNum = "";
            }
        } else {
            if (mCardContactPhone && TextUtils.isEmpty(et_VIP_CellPhone.getText())) {
                warnDialog("您开启了会员卡同手机号，请填写手机号");
                return false;
            }
        }

        if (!TextUtils.isEmpty(et_VIP_Name.getText())) {
            mMemberName = et_VIP_Name.getText().toString();
        } else {
            warnDialog("【姓名】不能为空");
            return false;
        }

        if (!TextUtils.isEmpty(et_VCH_Card.getText())) {
            mCardNum = et_VCH_Card.getText().toString();
        } else {
            warnDialog("【卡号】不能为空");
            return false;
        }

        if (isCardNum) {
            if (!TextUtils.isEmpty(et_VIP_FaceNumber.getText())) {
                if (et_VIP_FaceNumber.getText().toString().length() > 1) {
                    mcardId = et_VIP_FaceNumber.getText().toString();
                } else {
                    warnDialog("【卡面号码】不能少于两位");
                    return false;
                }
            } else {
                warnDialog("【卡面号码】不能为空");
                return false;
            }
        }
        if (TextUtils.isEmpty(et_VCH_Pwd.getText())) {
            warnDialog("必须输入初始密码");
            return false;
        }
        if (!TextUtils.equals(et_VCH_Pwd.getText(), et_VCH_Pwd_Confirm.getText())) {
            warnDialog("两次输入的密码不一致");
            return false;
        }

        if (!TextUtils.isEmpty(et_VCH_Fee.getText())) {
            mMoney = Double.parseDouble(et_VCH_Fee.getText().toString());
        } else {
            mMoney = 0;
        }
        if (!TextUtils.isEmpty(et_MA_AggregateAmount.getText())) {
            mInitMoney = Decima2KeeplUtil.stringToDecimal(et_MA_AggregateAmount.getText().toString());
        }
        if (!TextUtils.isEmpty(et_MA_AvailableIntegral.getText())) {
            mInitPoint = et_MA_AvailableIntegral.getText().toString();
        } else {
            mInitPoint = "0";
        }

        if (!TextUtils.isEmpty(et_VIP_Overdue.getText())) {//过期时间存在，不为永久会员
            mOverdueDate = et_VIP_Overdue.getText().toString();
            mIsForver = 0;
        } else {//过期时间不存在，则为永久会员
            if (((CheckBox) rootView.findViewById(R.id.cb_is_perpetual)).isChecked()) {

            }
            mIsForver = 1;
        }
        if (!TextUtils.isEmpty(et_VIP_ICCard.getText())) {
            mId = et_VIP_ICCard.getText().toString();
            if (!RegexUtil.isLegalId(mId)) {
                warnDialog("【身份证号】格式不正确");
                mId = "";
                return false;
            }
        }
        if (!TextUtils.isEmpty(et_VIP_Addr.getText())) {
            mAddress = et_VIP_Addr.getText().toString();
        }
        if (!TextUtils.isEmpty(et_VIP_Remark.getText())) {
            mRemark = et_VIP_Remark.getText().toString();
        }

        if (mMoney > 0 && vipInfoMsg == null && TextUtils.isEmpty(tv_select_Pay_Way.getText().toString())) {
            warnDialog("请选择支付方式！");
            return false;
        }
        for (int i = 0; i < costomfields.size(); i++) {
            if (costomfields.get(i).getCF_Required().equals("是")
                    && (costomfields.get(i).getM_ItemsValue() == null || costomfields.get(i).getM_ItemsValue().equals(""))) {
                warnDialog("请填写" + costomfields.get(i).getCF_FieldName() + "!");
                return false;
            }
        }
        return true;
    }

    private String mCardNum, mPhoneNum, mMemberName, mcardId, mInitMoney, mInitPoint, mOverdueDate,
            mId, mAddress, mRemark, calaryMonth, isLunar, mBirthday, mRecommendCardNum, mStaffListGid,
            mGradeGid, mPayTypeCode, mPayTypeName, mMemberPhotoAddress = "/img/nohead.png";
    private double mStaffListPercent, mMoney;
    private int mIsForver, mSex;

    private void addMemberPost() {
        RequestParams params = new RequestParams();
        params.put("VCH_Card", mCardNum);
        params.put("VG_GID", mGradeGid);
        params.put("VT_Code", "IntegerCard");
        params.put("VIP_Name", mMemberName);
        params.put("VIP_Sex", mSex);
        params.put("VIP_CellPhone", mPhoneNum);
        params.put("VIP_Email", "");
        params.put("VIP_InterCalaryMonth", calaryMonth);
        params.put("VIP_Birthday", mBirthday);
        params.put("VIP_IsLunarCalendar", isLunar);
        params.put("VIP_ICCard", mId);
        params.put("VIP_IsForver", mIsForver);//永久会员
        params.put("VIP_FixedPhone", "");
        params.put("SM_Name", "默认店铺");//店铺名称
        params.put("VIP_Referee", mRecommendCardNum);//推荐人卡号
        params.put("VIP_Label", new Gson().toJson(mLabList));//标签
        params.put("VIP_Addr", mAddress);
        params.put("VIP_Remark", mRemark);
        params.put("VIP_FaceNumber", mcardId);//卡面号码
        params.put("VIP_Overdue", mOverdueDate == null ? "" : (mOverdueDate + " 23:59:59"));//过期日期
        params.put("VCH_CreateTime", et_VCH_CreateTime.getTag());//开发日期
        for (int i = 0; i < costomfields.size(); i++) {//自定义属性
            params.put("FildsId[]", costomfields.get(i).getCF_GID());
            params.put("FildsValue[]", costomfields.get(i).getM_ItemsValue() == null ? ""
                    : costomfields.get(i).getM_ItemsValue());
        }
        params.put("Smsg", 1);

        if (mMemberPhotoAddress != null) {
            params.put("VIP_HeadImg", mMemberPhotoAddress);
        } else {
            params.put("VIP_HeadImg", HttpAPI.API().DEFALUT_HEAD_IMAGE);
        }
        if (!TextUtils.isEmpty(mStaffListGid)) {//提成员工GID
            params.put("EM_GIDList[]", mStaffListGid);
            params.put("VIP_Percent[]", mStaffListPercent + "");
        }

        String url = HttpAPI.API().ADDUSER;
        if (vipInfoMsg == null) {
            params.put("VIP_State", 1);
            params.put("VCH_Fee", mMoney);//开卡费用
            params.put("VCH_Fee_PayType", mPayTypeCode);
            params.put("VCH_Fee_PayTypeText", mPayTypeName);
            params.put("MA_AvailableIntegral", Integer.parseInt(mInitPoint));//初始积分
            params.put("MA_AggregateAmount", mInitMoney);//初始金额
            if (!TextUtils.isEmpty(et_VCH_Pwd.getText().toString())) {
                params.put("VCH_Pwd", et_VCH_Pwd.getText().toString());
            }
            params.put("IS_Sms", true);
            params.put("VIP_RegSource", 5);
        } else {
            url = HttpAPI.API().EDIVIP;
            params.put("GID", vipInfoMsg.getGID());
            params.put("VIP_State", 0);
            params.put("MA_AvailableIntegral", "");
            params.put("MA_AggregateAmount", "");
            params.put("EM_Name", "");
        }


        homeActivity.dialog.show();
        AsyncHttpUtils.postHttp(url, params, new CallBack() {
            String msgStr = vipInfoMsg == null ? "添加会员" : "修改会员";

            @Override
            public void onResponse(BaseRes response) {
                homeActivity.dialog.dismiss();
                new HttpGetPrintContents().HYKK(homeActivity, new Gson().toJson(response));
                warnDialog(msgStr + "成功");
                homeActivity.vipMemberFragment.reset();
                hide();
            }

            @Override
            public void onErrorResponse(Object msg) {
                homeActivity.dialog.dismiss();
                if (msg.toString().contains("SmsSign")) {
                    warnDialog(msgStr + "成功,短信未发送，未设置默认签名！");
                    homeActivity.vipMemberFragment.reset();
                } else if (msg.toString().contains("BuySms")) {
                    warnDialog(msgStr + "成功，短信未发送，短信库存不足！");
                    homeActivity.vipMemberFragment.reset();
                } else if (msg.toString().contains("UpgradeShop")) {
                    warnDialog("会员数已达上限,请升级店铺！");
                } else {
                    warnDialog(((BaseRes) msg).getMsg());
                }
            }
        });
    }

    SaomaDialog saomaDialog;

    private void showSaomaDialog(final double smPayMoney) {
        if (saomaDialog == null || !saomaDialog.isShowing()) {
            saomaDialog = new SaomaDialog(homeActivity, smPayMoney + "", 1, new InterfaceBack() {

                @Override
                public void onResponse(Object response) {
                    homeActivity.dialog.show();
                    OrderPayResult result = new OrderPayResult();
                    result = new OrderPayResult();
                    //找零
                    result.setGiveChange(0);
                    result.setPayTotalMoney(smPayMoney);
                    result.setDisMoney(smPayMoney);
                    List<PayType> typeList = new ArrayList<>();
                    PayType p = new PayType();
                    p.setPayCode("SMZF");
                    p.setPayMoney(smPayMoney);
                    p.setPayName("扫码支付");
                    result.setPayTypeList(typeList);
//                    String OrderCode = "202041215117";
                    String OrderCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                    saomaDialog.saomaPay(response.toString(), smPayMoney + "", OrderCode, OrderCode, result,
                            JiesuanBFragment.OrderType.ADDO_MEMBER, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    saomaDialog.dismiss();
                                    addMemberPost();

                                    homeActivity.dialog.dismiss();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    if (msg == null) {
                                        msg = "扫码支付失败";
                                    }
                                    ToastUtils.showLong(msg.toString());
                                    if (saomaDialog != null && saomaDialog.isShowing())
                                        saomaDialog.dismiss();
                                    homeActivity.dialog.dismiss();
                                }
                            });
                }
            });
        }
    }

    private void warnDialog(String msg) {
        com.blankj.utilcode.util.ToastUtils.showShort(msg);
    }

    /**
     * 上传图片
     */
    private void postUploadMemberPhoto(File file) {
        RequestParams params = new RequestParams();
        try {
            params.put("photo", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AsyncHttpUtils.postHttp(HttpAPI.API().UPLOAD_MEMBER_PHOTO, params, new CallBack() {

            @Override
            public void onResponse(BaseRes response) {
                Log.e("imgPath", (String) response.getData());
                mMemberPhotoAddress = (String) response.getData();
                warnDialog("上传成功");
            }
        });
    }

    class CostomfieldsAdapter extends RecyclerView.Adapter {
        final int TYPE_1 = 0;
        final int TYPE_2 = 1;
        final int TYPE_3 = 2;
        final int TYPE_4 = 3;
        final int TYPE_5 = 5;

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case TYPE_1:
                case TYPE_2:
                    view = LayoutInflater.from(homeActivity).inflate(R.layout.item_costomfields_input, parent, false);
                    return new InputHolder(view);
                case TYPE_3:
                case TYPE_4:
                case TYPE_5:
                    view = LayoutInflater.from(homeActivity).inflate(R.layout.item_costomfields_select, parent, false);
                    return new SelectHolder(view);
                default:
                    return null;
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ReportMessageBean.GetCustomFieldsVIPBean vipBean = costomfields.get(position);
            CostomfieldsHolder myHolder = (CostomfieldsHolder) holder;
            myHolder.tv_costomfields_name.setText(vipBean.getCF_FieldName());
            if (vipBean.getCF_Required().equals("是")) {
                myHolder.isFill.setVisibility(View.VISIBLE);
            } else if (vipBean.getCF_Required().equals("否")) {
                myHolder.isFill.setVisibility(View.GONE);
            }
            if (vipBean.getM_ItemsValue() != null && !vipBean.getM_ItemsValue().equals("null")) {
                myHolder.et_costomfields_value.setText(vipBean.getM_ItemsValue());
            } else {
                myHolder.et_costomfields_value.setText("");
            }
            myHolder.et_costomfields_value.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    vipBean.setM_ItemsValue(s.toString());
                }
            });

            if (holder instanceof InputHolder) {
                InputHolder inputHolder = (InputHolder) holder;
                inputHolder.et_costomfields_value.setHint("请输入" + vipBean.getCF_FieldName());
                inputHolder.et_costomfields_value.setInputType(InputType.TYPE_CLASS_TEXT);
                if (getItemViewType(position) == TYPE_2) {
                    inputHolder.et_costomfields_value.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
            } else if (holder instanceof SelectHolder) {
                SelectHolder selectHolder = (SelectHolder) holder;
                selectHolder.et_costomfields_value.setOnClickListener(new OnNoDoubleClickListener() {
                    @Override
                    public void onNoDoubleClick(View v) {
                        switch (getItemViewType(position)) {
                            case TYPE_3:
                                MaxHeightRecyclerView recyclerView = rootView.findViewById(R.id.select_recycler_costomfields_view);
                                View viewParent = (View) recyclerView.getParent();
                                if (viewParent.getVisibility() == View.GONE) {
                                    SelectAdapter selectAdapter = new SelectAdapter();
                                    recyclerView.setLayoutManager(new LinearLayoutManager(homeActivity));
                                    recyclerView.setAdapter(selectAdapter);
                                    selectAdapter.setData(vipBean.getCF_ItemsValue().split("\\,"),
                                            selectHolder.et_costomfields_value.getText().toString(), new InterfaceBack() {

                                                @Override
                                                public void onResponse(Object response) {
                                                    selectHolder.et_costomfields_value.setText(selectAdapter.data.get((int) response));
                                                }
                                            }).show(viewParent, RelativeLayout.CENTER_IN_PARENT, -1);
                                } else {
                                    viewParent.setVisibility(View.GONE);
                                }
                                break;
                            case TYPE_4:
                                CalendarSelector mCalendarSelector = new CalendarSelector(homeActivity, 0,
                                        new CalendarSelector.ICalendarSelectorCallBack() {
                                            @Override
                                            public void transmitPeriod(HashMap<String, String> result) {
                                                selectHolder.et_costomfields_value.setText(
                                                        result.get("yearval") + "-" + result.get("monthval") + "-" + result.get("dayval"));
                                            }
                                        });
                                mCalendarSelector.show(selectHolder.et_costomfields_value);
                                if (TextUtils.isEmpty(selectHolder.et_costomfields_value.getText().toString())) {
                                    mCalendarSelector.setPosition(DateUtil.getDateForString(DateTimeUtil.getNowDate()), "0", "0");
                                } else {
                                    mCalendarSelector.setPosition(DateUtil.getDateForString(
                                            selectHolder.et_costomfields_value.getText().toString()), "0", "0");
                                }
                                break;
                            case TYPE_5:
                                PermissionUtils.requestPermission(homeActivity, PermissionUtils.READ_EXTERNAL_STORAGE,
                                        new PermissionUtils.PermissionGrant() {
                                            @Override
                                            public void onPermissionGranted(int... requestCode) {
                                                PhotoPickerIntent intent = new PhotoPickerIntent(homeActivity);
                                                intent.setSelectModel(SelectModel.MULTI);
                                                intent.setMaxTotal(1);
                                                intent.gotoPhotoPickerActivity(homeActivity, new PhotoPickerActivity.OnSelectedCallbackListener() {
                                                    @Override
                                                    public void onSelectedCallback(ArrayList<String> resultList) {
                                                        for (String str : resultList) {
                                                            RequestParams params = new RequestParams();
                                                            try {
                                                                params.put("photo", new File(str));
                                                            } catch (FileNotFoundException e) {
                                                                e.printStackTrace();
                                                            }
                                                            AsyncHttpUtils.postHttp(HttpAPI.API().UPLOAD_MEMBER_PHOTO, params, new CallBack() {

                                                                @Override
                                                                public void onResponse(BaseRes response) {
                                                                    selectHolder.et_costomfields_value.setText((String) response.getData());
                                                                    warnDialog("上传成功");
                                                                }
                                                            });
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                break;
                        }
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            return costomfields == null ? 0 : costomfields.size();
        }

        @Override
        public int getItemViewType(int position) {
            String type = costomfields.get(position).getCF_FieldType();
            if (type.contains("文本"))
                return TYPE_1;
            else if (type.contains("数字"))
                return TYPE_2;
            else if (type.contains("选项"))
                return TYPE_3;
            else if (type.contains("日期"))
                return TYPE_4;
            else if (type.contains("图片"))
                return TYPE_5;
            else
                return TYPE_1;
        }

        class CostomfieldsHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_costomfields_name)
            TextView tv_costomfields_name;
            @BindView(R.id.isFill)
            TextView isFill;
            @BindView(R.id.et_costomfields_value)
            TextView et_costomfields_value;

            public CostomfieldsHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        class InputHolder extends CostomfieldsHolder {

            @BindView(R.id.et_costomfields_value)
            EditText et_costomfields_value;

            public InputHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

        class SelectHolder extends CostomfieldsHolder {

            @BindView(R.id.et_costomfields_value)
            TextView et_costomfields_value;

            public SelectHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

    class SelectAdapter extends RecyclerView.Adapter {

        List<String> data = new ArrayList<>();
        String positionId = "";
        Holder selectedHolser;
        InterfaceBack back;
        View viewParent;

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
                    viewParent.setVisibility(View.GONE);
                    back.onResponse(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public SelectAdapter setData(String[] data, String positionId, InterfaceBack back) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                list.add(data[i]);
            }
            return setData(list, positionId, back);
        }

        public SelectAdapter setData(List<String> data, String positionId, InterfaceBack back) {
            this.data = data;
            this.positionId = positionId;
            this.back = back;
            notifyDataSetChanged();
            return this;
        }

        public void show(View viewParent, int verb, int subject) {
            this.viewParent = viewParent;
            viewParent.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(324, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 3, 0, -3);
            if (subject > 0) {
                layoutParams.addRule(verb, subject);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
            } else
                layoutParams.addRule(verb);
            viewParent.setLayoutParams(layoutParams);
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

    private void showAttr() {
        if (SysSwitchRes.getSwitch(SysSwitchType.T451.getV()).getSS_State() == 0) {//会员生日
            rootView.findViewById(R.id.ly_VIP_Birthday).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T452.getV()).getSS_State() == 0) {//电子邮箱
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T453.getV()).getSS_State() == 0) {//身份证号
            rootView.findViewById(R.id.ly_VIP_ICCard).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T454.getV()).getSS_State() == 0) {////固定电话
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T455.getV()).getSS_State() == 0) {//推荐人
            rootView.findViewById(R.id.ly_VIP_Referee).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T456.getV()).getSS_State() == 0) {//开卡人
            rootView.findViewById(R.id.ly_EM_Name).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T457.getV()).getSS_State() == 0) {//会员标签
            rootView.findViewById(R.id.ly_VIP_Label).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T458.getV()).getSS_State() == 0) {//会员地址
            rootView.findViewById(R.id.ly_VIP_Addr).setVisibility(View.GONE);
        }
        if (SysSwitchRes.getSwitch(SysSwitchType.T459.getV()).getSS_State() == 0) {//备注信息
            rootView.findViewById(R.id.ly_VIP_Remark).setVisibility(View.GONE);
        }
    }
}

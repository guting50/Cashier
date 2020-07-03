package com.wycd.yushangpu.ui.fragment;

import android.content.Intent;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gt.utils.widget.BgLayout;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.http.AsyncHttpUtils;
import com.wycd.yushangpu.http.BaseRes;
import com.wycd.yushangpu.http.CallBack;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOutLogin;
import com.wycd.yushangpu.model.ImpParamLoading;
import com.wycd.yushangpu.model.ImpShopInfo;
import com.wycd.yushangpu.printutil.ConnectPrinter;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.UpdateAppVersion;
import com.wycd.yushangpu.ui.LoginActivity;
import com.wycd.yushangpu.ui.LogoActivity;
import com.wycd.yushangpu.ui.Presentation.GuestShowPresentation;
import com.wycd.yushangpu.ui.popwin.PopWinSetImage;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import androidx.appcompat.widget.SwitchCompat;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class PrintSetFragment extends BaseFragment {

    private TextView mTvPrint, mTvConnect;
    private RadioGroup rgPrinterSelect;
    private RadioGroup rgPrinterSelectLabelSize;
    private TextView rbAboutShop, rbPrinterLabel, rbPrinterDevice, rbAssistantScreenSet, rbSoftwareInfo;
    private RadioButton rgPrinterSelectedUsb, rgPrinterSelectedBluetooth;
    private RadioButton rgPrinterSelectLabelSmall, rgPrinterSelectLabelLarge;
    private EditText mEtGoodsConsume, mEtHandDutyTime;
    private LinearLayout llPrintSetSwitch, llPrintSet;
    private SwitchCompat scPrintSwitch;
    private View aboutShopLayout, settingLayout, assistantScreenSetLayout, softwareInfoLayout;
    private TextView tv_version_number;
    private View upgrade, upgradeSign;

    ImageView sm_picture;
    TextView tv_sm_edition, tv_sersion_life, tv_create_time, tv_end_time, tv_shop_users, tv_shop_mbers, tv_shop_goods,
            tv_shop_name, tv_contacter, tv_industry, tv_address, tv_range, tv_phone, tv_remarks;

    Switch switch1, switch2, switch3;
    BgLayout timeLayout;

    private int mPrintSwitch = 1;
    private HashMap<String, String> mPrintMap = new HashMap<>();
    private int i;
    private PrintSetBean mPrintSetBean;

    private int paperType = 2;

    @Override
    public int getContentView() {
        return R.layout.fragment_print_set;
    }

    @Override
    public void onCreated() {
        initView();
        setListener();
    }

    private void initView() {
        llPrintSetSwitch = (LinearLayout) rootView.findViewById(R.id.ll_print_set_switch);
        llPrintSet = (LinearLayout) rootView.findViewById(R.id.ll_print_set);
        mTvPrint = (TextView) rootView.findViewById(R.id.tv_print_set_print);
        mTvConnect = (TextView) rootView.findViewById(R.id.tv_connect_set_print);

        rbAboutShop = (TextView) rootView.findViewById(R.id.rb_about_shop);
        rbPrinterLabel = (TextView) rootView.findViewById(R.id.rb_printer_label_set);
        rbPrinterDevice = (TextView) rootView.findViewById(R.id.rb_printer_device_set);
        rbAssistantScreenSet = (TextView) rootView.findViewById(R.id.rb_assistant_screen_set);
        rbSoftwareInfo = (TextView) rootView.findViewById(R.id.rb_software_info);

        rgPrinterSelect = (RadioGroup) rootView.findViewById(R.id.rb_printer_select);
        rgPrinterSelectedUsb = (RadioButton) rootView.findViewById(R.id.rb_printer_selected_usb);
        rgPrinterSelectedBluetooth = (RadioButton) rootView.findViewById(R.id.rb_printer_selected_bluetooth);

        rgPrinterSelectLabelSize = (RadioGroup) rootView.findViewById(R.id.rb_printer_select_label_size);
        rgPrinterSelectLabelSmall = (RadioButton) rootView.findViewById(R.id.rb_printer_select_label_small);
        rgPrinterSelectLabelLarge = (RadioButton) rootView.findViewById(R.id.rb_printer_select_label_large);

        scPrintSwitch = (SwitchCompat) rootView.findViewById(R.id.sc_print_switch);

        aboutShopLayout = rootView.findViewById(R.id.about_shop_layout);
        aboutShopLayout.setVisibility(View.VISIBLE);
        settingLayout = rootView.findViewById(R.id.setting_layout);
        settingLayout.setVisibility(View.GONE);
        assistantScreenSetLayout = rootView.findViewById(R.id.assistant_screen_set_layout);
        assistantScreenSetLayout.setVisibility(View.GONE);
        softwareInfoLayout = rootView.findViewById(R.id.software_info_layout);
        softwareInfoLayout.setVisibility(View.GONE);

        tv_version_number = rootView.findViewById(R.id.tv_version_number);
        upgrade = rootView.findViewById(R.id.upgrade);
        upgradeSign = rootView.findViewById(R.id.upgrade_sign);

        mEtGoodsConsume = (EditText) rootView.findViewById(R.id.et_print_set_goods_consume);
        mEtHandDutyTime = (EditText) rootView.findViewById(R.id.et_print_set_hand_duty);

        sm_picture = (ImageView) rootView.findViewById(R.id.sm_picture);
        tv_sm_edition = (TextView) rootView.findViewById(R.id.tv_sm_edition);
        tv_sersion_life = (TextView) rootView.findViewById(R.id.tv_sersion_life);
        tv_create_time = (TextView) rootView.findViewById(R.id.tv_create_time);
        tv_end_time = (TextView) rootView.findViewById(R.id.tv_end_time);
        tv_shop_users = (TextView) rootView.findViewById(R.id.tv_shop_users);
        tv_shop_mbers = (TextView) rootView.findViewById(R.id.tv_shop_mbers);
        tv_shop_goods = (TextView) rootView.findViewById(R.id.tv_shop_goods);
        tv_shop_name = (TextView) rootView.findViewById(R.id.tv_shop_name);
        tv_contacter = (TextView) rootView.findViewById(R.id.tv_contacter);
        tv_industry = (TextView) rootView.findViewById(R.id.tv_referee);
        tv_address = (TextView) rootView.findViewById(R.id.tv_address);
        tv_range = (TextView) rootView.findViewById(R.id.tv_range);
        tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
        tv_remarks = (TextView) rootView.findViewById(R.id.tv_remarks);

        switch1 = rootView.findViewById(R.id.switch1);
        switch2 = rootView.findViewById(R.id.switch2);
        switch3 = rootView.findViewById(R.id.switch3);
        timeLayout = rootView.findViewById(R.id.timeLayout);

        if (GetPrintSet.ISBULETOOTHCONNECT)
            rgPrinterSelect.check(rgPrinterSelectedBluetooth.getId());
        if (GetPrintSet.ISCONNECT)
            rgPrinterSelect.check(rgPrinterSelectedUsb.getId());
        rgPrinterSelectLabelSize.check(rgPrinterSelectLabelSmall.getId());
        mEtGoodsConsume.setText("1");
        mEtHandDutyTime.setText("1");
        mTvPrint.setText("请选择打印机");
        mTvConnect.setText("未连接");

        ConnectPrinter.consumer = (Consumer<String>) s -> {
            mTvConnect.setText(s);
        };
    }

    public void updateData() {
        mEtGoodsConsume.requestFocus();
        if (GetPrintSet.LABELPRINT_IS_OPEN) {
            rbPrinterLabel.setVisibility(View.VISIBLE);
        }
        String ReceiptUSBName = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName) && GetPrintSet.ISCONNECT) {
            mTvPrint.setText(ReceiptUSBName);
            mTvConnect.setText(getString(R.string.con_success));
        }

        tv_version_number.setText("版本号:" + MyApplication.versionCode);

        mPrintMap.put("SPXF", "1");
        mPrintMap.put("JB", "1");

        AsyncHttpUtils.postHttp(HttpAPI.API().GET_PRINT_SET, new CallBack() {
            @Override
            public void onResponse(BaseRes response) {
                mPrintSetBean = response.getData(PrintSetBean.class);
                if (mPrintSetBean != null) {
                    if (mPrintSetBean.getPS_IsEnabled() == 1) {
                        scPrintSwitch.setChecked(true);
                        if (mPrintSetBean.getPS_PaperType() == 2) {
                            rgPrinterSelectLabelSize.check(rgPrinterSelectLabelSmall.getId());
                        } else if (mPrintSetBean.getPS_PaperType() == 3) {
                            rgPrinterSelectLabelSize.check(rgPrinterSelectLabelLarge.getId());
                        }
                    } else {
                        scPrintSwitch.setChecked(false);
                    }
                    if (mPrintSetBean.getPrintTimesList() != null) {
                        for (int j = 0; j < mPrintSetBean.getPrintTimesList().size(); j++) {
                            if (mPrintSetBean.getPrintTimesList().get(j).getPT_Code().equals("SPXF")) {
                                mEtGoodsConsume.setText("" + mPrintSetBean.getPrintTimesList().get(j).getPT_Times());
                            } else if (mPrintSetBean.getPrintTimesList().get(j).getPT_Code().equals("JB")) {
                                mEtHandDutyTime.setText("" + mPrintSetBean.getPrintTimesList().get(j).getPT_Times());
                            }
                        }
                    }
                }
            }
        });

        new ImpShopInfo().shopInfo(new InterfaceBack<ShopInfoBean>() {
            @Override
            public void onResponse(ShopInfoBean shopInfoBean) {
                if (shopInfoBean != null) {
                    Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(shopInfoBean.getShopImg()).toString()))
//                .placeholder(R.mipmap.messge_nourl)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(sm_picture);
                    tv_sm_edition.setText(NullUtils.noNullHandle(shopInfoBean.getShopType()).toString().split("\\(")[0]);
                    tv_sersion_life.setText(NullUtils.noNullHandle(shopInfoBean.getSM_SersionLife()).toString() + "年");
                    tv_create_time.setText("开通时间\n" + NullUtils.noNullHandle(shopInfoBean.getShopCreateTime()).toString());
                    tv_end_time.setText("到期时间：" + NullUtils.noNullHandle(shopInfoBean.getShopOverTime()).toString());
                    tv_shop_users.setText("用户数\n" + NullUtils.noNullHandle(shopInfoBean.getShopUsers()).toString());
                    tv_shop_mbers.setText("会员人数\n" + NullUtils.noNullHandle(shopInfoBean.getShopMbers()).toString());
                    tv_shop_goods.setText("商品数量\n" + NullUtils.noNullHandle(shopInfoBean.getShopGoods()).toString());
                    tv_shop_name.setText("店铺名称：" + NullUtils.noNullHandle(shopInfoBean.getShopName()).toString());
                    tv_contacter.setText("联  系  人：" + NullUtils.noNullHandle(shopInfoBean.getShopContact()).toString());
                    tv_industry.setText("所属行业：" + NullUtils.noNullHandle(shopInfoBean.getSM_Industry()).toString());
                    tv_address.setText("店铺地址：" + NullUtils.noNullHandle(shopInfoBean.getSM_DetailAddr()).toString());
                    tv_range.setText("经营范围：" + NullUtils.noNullHandle(shopInfoBean.getSM_Range()).toString());
                    tv_phone.setText("联系电话：" + NullUtils.noNullHandle(shopInfoBean.getShopTel()).toString());
                    tv_remarks.setText("备注信息：" + NullUtils.noNullHandle(shopInfoBean.getSM_Remark()).toString());
                }
            }
        });
        rbAboutShop.performClick();
        switch1.setChecked(TextUtils.equals("true", CacheDoubleUtils.getInstance().getString("showBill")));
        switch2.setChecked(TextUtils.equals("true", CacheDoubleUtils.getInstance().getString("guestShow")));
        switch3.setChecked(TextUtils.equals("true", CacheDoubleUtils.getInstance().getString("showVoice")));
        ((TextView) rootView.findViewById(R.id.timeVal)).setText(CacheDoubleUtils.getInstance().getString("timeInterval", "0 S"));
    }

    private void setListener() {
        //保存设置
        rootView.findViewById(R.id.tv_print_set_save).setOnClickListener(v -> {
            RequestParams params = new RequestParams();
            params.put("PS_IsEnabled", mPrintSwitch);
            params.put("PS_IsPreview", 0);

            if (mPrintSetBean == null) {
                params.put("PS_PaperType", paperType);
                params.put("PS_PrinterName", "XP-58");
                params.put("PS_StylusPrintingName:", "XP-58");
            } else {
                params.put("PS_PaperType", paperType);
                params.put("PS_PrinterName", mPrintSetBean.getPS_PrinterName());
                params.put("PS_StylusPrintingName:", mPrintSetBean.getPS_StylusPrintingName());
            }

            if (mPrintMap.size() > 0) {
                Iterator iterator = mPrintMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    params.put("PrintTimesList[" + i + "][PT_Code]", key);
                    params.put("PrintTimesList[" + i + "][PT_Times]", value);
                    i++;
                }

                AsyncHttpUtils.postHttp(HttpAPI.API().EDIT_PRINT_SET, params, new CallBack() {
                    @Override
                    public void onResponse(BaseRes response) {
                        ImpParamLoading.preLoad();
                        NoticeDialog.noticeDialog(getActivity(), "设置", "打印设置保存成功!", 1, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                i = 0;
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                            }
                        });
                    }
                });
            }

        });

        //输入框监听
        mEtGoodsConsume.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    mPrintMap.put("SPXF", s.toString());
                }
            }
        });

        //输入框监听
        mEtHandDutyTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    mPrintMap.put("JB", s.toString());
                }
            }
        });

        rgPrinterSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String name = "";
                switch (checkedId) {
                    case R.id.rb_printer_selected_usb:
                        ConnectPrinter.rbType = 0;
                        name = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
                        break;
                    case R.id.rb_printer_selected_bluetooth:
                        ConnectPrinter.rbType = 2;
                        name = CacheDoubleUtils.getInstance().getString("BlueToothName");
                        break;
                }
                if (name != null && !"".equals(name) && GetPrintSet.ISBULETOOTHCONNECT) {
                    mTvPrint.setText(name);
                    mTvConnect.setText(getString(R.string.con_success));
                } else {
                    mTvPrint.setText("请选择打印机");
                    mTvConnect.setText("未连接");
                }
            }
        });

        rgPrinterSelectLabelSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_printer_select_label_small:
                        paperType = 2;
                        break;
                    case R.id.rb_printer_select_label_large:
                        paperType = 3;
                        break;
                }
            }
        });

        scPrintSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mPrintSwitch = 1;

                    mEtGoodsConsume.setInputType(InputType.TYPE_CLASS_NUMBER);
                    mEtHandDutyTime.setInputType(InputType.TYPE_CLASS_NUMBER);

                    mEtGoodsConsume.setText("1");
                    mEtHandDutyTime.setText("1");

                    rgPrinterSelectLabelLarge.setEnabled(true);
                    rgPrinterSelectLabelSmall.setEnabled(true);
                    rgPrinterSelectedBluetooth.setEnabled(true);
                    rgPrinterSelectedUsb.setEnabled(true);
                    mEtHandDutyTime.setEnabled(true);
                    mEtGoodsConsume.setEnabled(true);
                    mTvPrint.setEnabled(true);
                    mTvConnect.setEnabled(true);
                    rgPrinterSelectLabelSmall.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    rgPrinterSelectLabelLarge.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    rgPrinterSelectedBluetooth.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    rgPrinterSelectedUsb.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    mEtHandDutyTime.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    mEtGoodsConsume.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    mTvPrint.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                    mTvConnect.setTextColor(getContext().getResources().getColor(R.color.color_main_text_black));
                } else {
                    mPrintSwitch = 0;

                    mEtGoodsConsume.setInputType(InputType.TYPE_NULL);
                    mEtHandDutyTime.setInputType(InputType.TYPE_NULL);

                    rgPrinterSelectLabelLarge.setEnabled(false);
                    rgPrinterSelectLabelSmall.setEnabled(false);
                    rgPrinterSelectedBluetooth.setEnabled(false);
                    rgPrinterSelectedUsb.setEnabled(false);
                    mEtHandDutyTime.setEnabled(false);
                    mEtGoodsConsume.setEnabled(false);
                    mTvPrint.setEnabled(false);
                    mTvConnect.setEnabled(false);
                    rgPrinterSelectLabelSmall.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    rgPrinterSelectLabelLarge.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    rgPrinterSelectedBluetooth.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    rgPrinterSelectedUsb.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    mEtHandDutyTime.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    mEtGoodsConsume.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    mTvPrint.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                    mTvConnect.setTextColor(getContext().getResources().getColor(R.color.color_b7));
                }
            }
        });

        //打印机连接
        mTvPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ConnectPrinter.rbType) {
                    case 0:
                    case 1:
                        ConnectPrinter.setUSB(homeActivity, mTvPrint);
                        break;
                    case 2:
                        ConnectPrinter.setBluetooth(homeActivity, mTvPrint);
                        break;
                }
            }
        });

        rootView.findViewById(R.id.sigin_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoticeDialog.noticeDialog(homeActivity, "系统提示信息", "是否退出当前账户", 1, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        //退出
//                        dialog.show();
                        ImpOutLogin outLogin = new ImpOutLogin();
                        outLogin.outLogin(new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                hide();
                                homeActivity.dialog.dismiss();
                                Intent intent = new Intent(homeActivity, LoginActivity.class);
                                startActivity(intent);
                                ActivityUtils.finishAllActivitiesExceptNewest();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                homeActivity.dialog.dismiss();
                            }
                        });
                    }
                });
            }
        });

        upgrade.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(LogoActivity.VERSION_ADDRESS)) {
            upgrade.setVisibility(View.VISIBLE);
            upgradeSign.setVisibility(View.VISIBLE);
            upgrade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new UpdateAppVersion(getActivity()).downLoadNewApk(LogoActivity.VERSION_ADDRESS);
                }
            });
        }

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CacheDoubleUtils.getInstance().put("showBill", isChecked + "");
            GuestShowPresentation.reload();
        });
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CacheDoubleUtils.getInstance().put("guestShow", isChecked + "");
            GuestShowPresentation.reload();
        });
        switch3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CacheDoubleUtils.getInstance().put("showVoice", isChecked + "");
            GuestShowPresentation.reload();
        });

        LinearLayout layout = rootView.findViewById(R.id.timeLayout1);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            if (view instanceof TextView) {
                view.setOnClickListener(v -> {
                    CacheDoubleUtils.getInstance().put("timeInterval", ((TextView) view).getText().toString());
                    ((TextView) rootView.findViewById(R.id.timeVal)).setText(CacheDoubleUtils.getInstance().getString("timeInterval", "0 S"));
                    timeLayout.setVisibility(View.GONE);
                    GuestShowPresentation.reload();
                });
            }
        }
    }

    @OnClick({R.id.rb_about_shop, R.id.rb_printer_label_set, R.id.rb_printer_device_set, R.id.rb_assistant_screen_set, R.id.rb_software_info})
    public void onTabClick(View view) {
        aboutShopLayout.setVisibility(View.GONE);
        settingLayout.setVisibility(View.GONE);
        assistantScreenSetLayout.setVisibility(View.GONE);
        softwareInfoLayout.setVisibility(View.GONE);
        rbAboutShop.setBackgroundResource(R.color.white);
        rbPrinterLabel.setBackgroundResource(R.color.white);
        rbPrinterDevice.setBackgroundResource(R.color.white);
        rbAssistantScreenSet.setBackgroundResource(R.color.white);
        rbSoftwareInfo.setBackgroundResource(R.color.white);
        view.setBackgroundResource(R.color.item_bg);

        switch (view.getId()) {
            case R.id.rb_about_shop:
                aboutShopLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_printer_label_set:
                settingLayout.setVisibility(View.VISIBLE);
                ConnectPrinter.rbType = 1;
                llPrintSetSwitch.setVisibility(View.GONE);
                llPrintSet.setVisibility(View.GONE);
                break;
            case R.id.rb_printer_device_set:
                settingLayout.setVisibility(View.VISIBLE);
                switch (rgPrinterSelect.getCheckedRadioButtonId()) {
                    case R.id.rb_printer_selected_usb:
                        ConnectPrinter.rbType = 0;
                        break;
                    case R.id.rb_printer_selected_bluetooth:
                        ConnectPrinter.rbType = 2;
                        break;
                }
                llPrintSetSwitch.setVisibility(View.VISIBLE);
                llPrintSet.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_assistant_screen_set:
                assistantScreenSetLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_software_info:
                softwareInfoLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    @OnClick({R.id.setImage, R.id.textView3})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.setImage:
                new PopWinSetImage().show(homeActivity, view);
                break;
            case R.id.textView3:
                if (timeLayout.getVisibility() == View.GONE)
                    timeLayout.setVisibility(View.VISIBLE);
                else
                    timeLayout.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        i = 0;
        mPrintMap.clear();
    }
}

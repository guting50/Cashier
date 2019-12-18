package com.wycd.yushangpu.ui.fragment;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpOutLogin;
import com.wycd.yushangpu.printutil.CallBack;
import com.wycd.yushangpu.printutil.CommonFun;
import com.wycd.yushangpu.printutil.HttpHelper;
import com.wycd.yushangpu.printutil.IPrintSetPresenter;
import com.wycd.yushangpu.printutil.IPrintSetView;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.DeviceReceiver;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.Utils;
import com.wycd.yushangpu.ui.HomeActivity;
import com.wycd.yushangpu.ui.LoginActivity;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;

import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.PosPrinterDev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.tools.Constant.ACTION_USB_PERMISSION;

public class PrintSetFragment extends Fragment {

    private String TAG = "PrintSetFragment";

    private TextView mTvPrint, mTvConnect;
    private RadioGroup rgPrinterSelect;
    private RadioGroup rgPrinterSelectLabelSize;
    private TextView rbAboutShop, rbPrinterLabel, rbPrinterDevice, rbSoftwareInfo;
    private RadioButton rgPrinterSelectedUsb, rgPrinterSelectedBluetooth;
    private RadioButton rgPrinterSelectLabelSmall, rgPrinterSelectLabelLarge;
    private EditText mEtGoodsConsume, mEtHandDutyTime;
    private LinearLayout llPrintSetSwitch, llPrintSet;
    private SwitchCompat scPrintSwitch;
    private View aboutShopLayout, settingLayout, softwareInfoLayout;
    private TextView tv_version_number;

    ImageView sm_picture;
    TextView tv_sm_edition, tv_sersion_life, tv_create_time, tv_end_time, tv_shop_users, tv_shop_mbers, tv_shop_goods,
            tv_shop_name, tv_contacter, tv_industry, tv_address, tv_range, tv_phone, tv_remarks;

    private IPrintSetPresenter mPresenter;
    private IPrintSetView mView;
    private int mPrintSwitch = 1;
    private HashMap<String, String> mPrintMap = new HashMap<>();
    private int i;
    private PrintSetBean mPrintSetBean;

    private int paperType = 2;

    private int rbType = 0;

    //蓝牙连接相关
    private List<String> btList = new ArrayList<>();
    private ArrayList<String> btFoundList = new ArrayList<>();
    private ArrayAdapter<String> BtBoudAdapter, BtfoundAdapter;
    private View BtDialogView;
    private ListView BtBoundLv, BtFoundLv;
    private LinearLayout ll_BtFound;
    private AlertDialog btdialog;
    private Button btScan;
    private DeviceReceiver BtReciever;
    private BluetoothAdapter bluetoothAdapter;

    //usb连接相关
    View dialogView3;
    private TextView tv_usb;
    private List<String> usbList;
    private ListView lv_usb;
    private ArrayAdapter<String> adapter3;
    String usbDev = "";
    private int id = 0;
    private UsbManager usbManager;
    private PendingIntent mPermissionIntent;

    ShopInfoBean shopInfoBean;

    private HomeActivity homeActivity;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_print_set, null);
        homeActivity = (HomeActivity) getActivity();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);

        usbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);

        initView();
        setListener();
        initBroadcast();

    }

    public void setData(ShopInfoBean shopInfoBean) {
        this.shopInfoBean = shopInfoBean;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void initView() {
        llPrintSetSwitch = (LinearLayout) rootView.findViewById(R.id.ll_print_set_switch);
        llPrintSet = (LinearLayout) rootView.findViewById(R.id.ll_print_set);
        mTvPrint = (TextView) rootView.findViewById(R.id.tv_print_set_print);
        mTvConnect = (TextView) rootView.findViewById(R.id.tv_connect_set_print);

        rbAboutShop = (TextView) rootView.findViewById(R.id.rb_about_shop);
        rbPrinterLabel = (TextView) rootView.findViewById(R.id.rb_printer_label_set);
        rbPrinterDevice = (TextView) rootView.findViewById(R.id.rb_printer_device_set);
        rbSoftwareInfo = (TextView) rootView.findViewById(R.id.rb_software_info);

        rgPrinterSelect = (RadioGroup) rootView.findViewById(R.id.rb_printer_select);
        rgPrinterSelectedUsb = (RadioButton) rootView.findViewById(R.id.rb_printer_selected_usb);
        rgPrinterSelectedBluetooth = (RadioButton) rootView.findViewById(R.id.rb_printer_selected_bluetooth);

        rgPrinterSelectLabelSize = (RadioGroup) rootView.findViewById(R.id.rb_printer_select_label_size);
        rgPrinterSelectLabelSmall = (RadioButton) rootView.findViewById(R.id.rb_printer_select_label_small);
        rgPrinterSelectLabelLarge = (RadioButton) rootView.findViewById(R.id.rb_printer_select_label_large);

        scPrintSwitch = (SwitchCompat) rootView.findViewById(R.id.sc_print_switch);

        aboutShopLayout = rootView.findViewById(R.id.about_shop_layout);
        settingLayout = rootView.findViewById(R.id.setting_layout);
        softwareInfoLayout = rootView.findViewById(R.id.software_info_layout);

        tv_version_number = rootView.findViewById(R.id.tv_version_number);

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
        tv_industry = (TextView) rootView.findViewById(R.id.tv_industry);
        tv_address = (TextView) rootView.findViewById(R.id.tv_address);
        tv_range = (TextView) rootView.findViewById(R.id.tv_range);
        tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
        tv_remarks = (TextView) rootView.findViewById(R.id.tv_remarks);

        rgPrinterSelect.check(rgPrinterSelectedUsb.getId());
        rgPrinterSelectLabelSize.check(rgPrinterSelectLabelSmall.getId());
        mEtGoodsConsume.setText("1");
        mEtHandDutyTime.setText("1");
        mTvPrint.setText("请选择打印机");
        mTvConnect.setText("未连接");

    }

    //更新打印设置缓存
    private void getAllMessage() {
        HttpHelper.post(getActivity(), HttpAPI.API().PRE_LOAD, new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                ReportMessageBean reportbean = CommonFun.JsonToObj(responseString, ReportMessageBean.class);
                if (reportbean != null) {
                    ReportMessageBean.DataBean.PrintSetBean printbean = reportbean.getData().getPrintSet();
                    if (printbean.getPS_IsEnabled() == 1) {
                        MyApplication.PRINT_IS_OPEN = true;
                    } else {
                        MyApplication.PRINT_IS_OPEN = false;
                    }
                    if (printbean != null && printbean.getPrintTimesList() != null) {
                        for (int i = 0; i < printbean.getPrintTimesList().size(); i++) {
                            ReportMessageBean.DataBean.PrintSetBean.PrintTimesListBean bean = printbean.getPrintTimesList().get(i);
                            if ("SPXF".equals(bean.getPT_Code())) {
                                MyApplication.SPXF_PRINT_TIMES = bean.getPT_Times();
                            }
                            if ("JB".equals(bean.getPT_Code())) {
                                MyApplication.JB_PRINT_TIMES = bean.getPT_Times();
                            }
                        }
                    }

                }

            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }

    private void loadData() {
        mEtGoodsConsume.requestFocus();
        if (LABELPRINT_IS_OPEN) {
            rbPrinterLabel.setVisibility(View.VISIBLE);
        }
        String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName) && ISCONNECT) {
            mTvPrint.setText(ReceiptUSBName);
            mTvConnect.setText(getString(R.string.con_success));
        }

        PackageManager manager = getContext().getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            tv_version_number.setText("版本" + info.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPrintMap.put("SPXF", "1");
        mPrintMap.put("JB", "1");

        mPresenter = new IPrintSetPresenter(getActivity());
        mPresenter.onCreate("");
        mView = new IPrintSetView() {
            @Override
            public void getPrintSetSuccess(PrintSetBean bean) {
                mPrintSetBean = bean;
                if (mPrintSetBean != null) {
                    if (bean.getData().getPS_IsEnabled() == 1) {
                        scPrintSwitch.setChecked(true);
                        if (bean.getData().getPS_PaperType() == 2) {
                            rgPrinterSelectLabelSize.check(rgPrinterSelectLabelSmall.getId());
                        } else if (bean.getData().getPS_PaperType() == 3) {
                            rgPrinterSelectLabelSize.check(rgPrinterSelectLabelLarge.getId());
                        }
                    } else {
                        scPrintSwitch.setChecked(false);
                    }
                    if (bean.getData().getPrintTimesList() != null) {
                        for (int j = 0; j < bean.getData().getPrintTimesList().size(); j++) {
                            if (bean.getData().getPrintTimesList().get(j).getPT_Code().equals("SPXF")) {
                                mEtGoodsConsume.setText("" + bean.getData().getPrintTimesList().get(j).getPT_Times());
                            } else if (bean.getData().getPrintTimesList().get(j).getPT_Code().equals("JB")) {
                                mEtHandDutyTime.setText("" + bean.getData().getPrintTimesList().get(j).getPT_Times());
                            }
                        }
                    }
                }
            }

            @Override
            public void getPrintSetFail(String result) {
                if (!result.equals("执行失败")) {
                    Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void saveSetSuccess() {
                getAllMessage();
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

            @Override
            public void saveSetFail(String result) {
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        };
        mPresenter.attachView(mView);

        Glide.with(getContext()).load(ImgUrlTools.obtainUrl(NullUtils.noNullHandle(shopInfoBean.getData().getShopImg()).toString()))
//                .placeholder(R.mipmap.messge_nourl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(sm_picture);
        tv_sm_edition.setText(NullUtils.noNullHandle(shopInfoBean.getData().getShopType()).toString().split("\\(")[0]);
        tv_sersion_life.setText(NullUtils.noNullHandle(shopInfoBean.getData().getSM_SersionLife()).toString() + "年");
        tv_create_time.setText("开通时间\n" + NullUtils.noNullHandle(shopInfoBean.getData().getShopCreateTime()).toString());
        tv_end_time.setText("到期时间：" + NullUtils.noNullHandle(shopInfoBean.getData().getShopOverTime()).toString());
        tv_shop_users.setText("用户数\n" + NullUtils.noNullHandle(shopInfoBean.getData().getShopUsers()).toString());
        tv_shop_mbers.setText("会员人数\n" + NullUtils.noNullHandle(shopInfoBean.getData().getShopMbers()).toString());
        tv_shop_goods.setText("商品数量\n" + NullUtils.noNullHandle(shopInfoBean.getData().getShopGoods()).toString());
        tv_shop_name.setText("店铺名称：" + NullUtils.noNullHandle(shopInfoBean.getData().getShopName()).toString());
        tv_contacter.setText("联  系  人：" + NullUtils.noNullHandle(shopInfoBean.getData().getShopContact()).toString());
        tv_industry.setText("所属行业：" + NullUtils.noNullHandle(shopInfoBean.getData().getSM_Industry()).toString());
        tv_address.setText("店铺地址：" + NullUtils.noNullHandle(shopInfoBean.getData().getSM_DetailAddr()).toString());
        tv_range.setText("经营范围：" + NullUtils.noNullHandle(shopInfoBean.getData().getSM_Range()).toString());
        tv_phone.setText("联系电话：" + NullUtils.noNullHandle(shopInfoBean.getData().getShopTel()).toString());
        tv_remarks.setText("备注信息：" + NullUtils.noNullHandle(shopInfoBean.getData().getSM_Remark()).toString());

    }

    private void setListener() {
        //保存设置
        rootView.findViewById(R.id.tv_print_set_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("PS_IsEnabled", mPrintSwitch);
                params.put("PS_IsPreview", 0);

                if (mPrintSetBean == null) {
                    params.put("PS_PaperType", paperType);
                    params.put("PS_PrinterName", "XP-58");
                    params.put("PS_StylusPrintingName:", "XP-58");
                } else {
                    params.put("PS_PaperType", paperType);
                    params.put("PS_PrinterName", mPrintSetBean.getData().getPS_PrinterName());
                    params.put("PS_StylusPrintingName:", mPrintSetBean.getData().getPS_StylusPrintingName());
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
                    mPresenter.savePrintSet(getActivity(), params);
                }

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
                        rbType = 0;
                        name = (String) CacheData.restoreObject("ReceiptUSBName");
                        break;
                    case R.id.rb_printer_selected_bluetooth:
                        rbType = 2;
                        name = (String) CacheData.restoreObject("BlueToothName");
                        break;
                }
                if (name != null && !"".equals(name) && ISBULETOOTHCONNECT) {
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
                switch (rbType) {
                    case 0:
                    case 1:
                        setUSB();
                        break;
                    case 2:
                        setBluetooth();
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
                        outLogin.outLogin(homeActivity, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                homeActivity.getSupportFragmentManager().beginTransaction()
                                        .hide(homeActivity.printSetFragment).commit();
                                homeActivity.dialog.dismiss();
                                Intent intent = new Intent(homeActivity, LoginActivity.class);
                                startActivity(intent);
                                homeActivity.finish();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                homeActivity.dialog.dismiss();
                            }
                        });
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
            }
        });
    }

    @OnClick({R.id.rb_about_shop, R.id.rb_printer_label_set, R.id.rb_printer_device_set, R.id.rb_software_info})
    public void onTabClick(View view) {
        aboutShopLayout.setVisibility(View.GONE);
        settingLayout.setVisibility(View.GONE);
        softwareInfoLayout.setVisibility(View.GONE);
        switch (view.getId()) {
            case R.id.rb_about_shop:
                aboutShopLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_printer_label_set:
                settingLayout.setVisibility(View.VISIBLE);
                rbType = 1;
                llPrintSetSwitch.setVisibility(View.GONE);
                llPrintSet.setVisibility(View.GONE);
                break;
            case R.id.rb_printer_device_set:
                settingLayout.setVisibility(View.VISIBLE);
                switch (rgPrinterSelect.getCheckedRadioButtonId()) {
                    case R.id.rb_printer_selected_usb:
                        rbType = 0;
                        break;
                    case R.id.rb_printer_selected_bluetooth:
                        rbType = 2;
                        break;
                }
                llPrintSetSwitch.setVisibility(View.VISIBLE);
                llPrintSet.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_software_info:
                softwareInfoLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 获取标签USB列表
     */
    private void setUSB() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        dialogView3 = inflater.inflate(R.layout.usb_link, null);
        tv_usb = (TextView) dialogView3.findViewById(R.id.textView1);
        lv_usb = (ListView) dialogView3.findViewById(R.id.listView1);

        usbList = PosPrinterDev.GetUsbPathNames(getActivity());
        if (usbList == null) {
            usbList = new ArrayList<>();
        }

        tv_usb.setText(getString(R.string.usb_pre_con) + usbList.size());
        adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, usbList);
        lv_usb.setAdapter(adapter3);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(dialogView3).create();
        dialog.show();

        setUsbLisener(dialog);
    }

    private void setUsbLisener(final AlertDialog dialog) {
        lv_usb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                usbDev = usbList.get(i);
                mTvPrint.setText(usbDev);
                //通过USB设备名找到USB设备
                UsbDevice usbDevice = Utils.getUsbDeviceFromName(getActivity(), usbDev);
                //判断USB设备是否有权限
                if (usbManager.hasPermission(usbDevice)) {
                    switch (rbType) {
                        case 0:
                            connectUSB(usbDev);
                            break;
                        case 1:
                            closeport();
                            connectLabelUSB(usbDevice);
                            break;
                    }
                } else {//请求权限
                    mPermissionIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent(ACTION_USB_PERMISSION), 0);
                    usbManager.requestPermission(usbDevice, mPermissionIntent);
                }
                dialog.cancel();
                Log.e("usbDev: ", usbDev);
            }
        });
    }

    /**
     * USB连接标签打印机
     */
    public void connectLabelUSB(UsbDevice usbDevice) {
        new DeviceConnFactoryManager.Build()
                .setId(id)
                .setConnMethod(DeviceConnFactoryManager.CONN_METHOD.USB)
                .setUsbDevice(usbDevice)
                .setContext(getActivity())
                .build();
        DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].openPort();
    }

    /**
     * 连接usb
     */
    public void connectUSB(final String usbAddress) {
        myBinder.ConnectUsbPort(getActivity(), usbAddress, new TaskCallback() {
            @Override
            public void OnSucceed() {
                ISCONNECT = true;
                ISBULETOOTHCONNECT = false;
                CacheData.saveObject("ReceiptUSBName", usbAddress);
                mTvConnect.setText(getString(R.string.con_success));
            }

            @Override
            public void OnFailed() {
                ISCONNECT = false;
                mTvConnect.setText(getString(R.string.con_failed));
            }
        });
    }

    /**
     * 重新连接回收上次连接的对象，避免内存泄漏
     */
    private void closeport() {
        if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id] != null && DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort != null) {
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].reader.cancel();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort.closePort();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort = null;
        }
    }

    /**
     * 注册广播
     * Registration broadcast
     */
    private void initBroadcast() {
        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);//USB访问权限广播
        filter.addAction(ACTION_USB_DEVICE_DETACHED);//USB线拔出
//        filter.addAction(ACTION_QUERY_PRINTER_STATE);//查询打印机缓冲区状态广播，用于一票一控
        filter.addAction(DeviceConnFactoryManager.ACTION_CONN_STATE);//与打印机连接状态
        filter.addAction(ACTION_USB_DEVICE_ATTACHED);//USB线插入
        getActivity().registerReceiver(receiver, filter);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                //USB请求访问权限
                case ACTION_USB_PERMISSION:
                    synchronized (getActivity()) {
                        UsbDevice device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                        if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                            if (device != null) {//用户点击授权
                                switch (rbType) {
                                    case 0:
                                        connectUSB(usbDev);
                                        break;
                                    case 1:
                                        closeport();
                                        connectLabelUSB(device);
                                        break;
                                }
                            }
                        } else {//用户点击不授权,则无权限访问USB
                            Log.e(TAG, "No access to USB");
                        }
                    }
                    break;
                //Usb连接断开广播
                case ACTION_USB_DEVICE_DETACHED:
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                    String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
                    if (ReceiptUSBName.equals(usbDevice.getDeviceName()) && rbType == 0) {
                        mTvConnect.setText("未连接");
                    }
                    String LabelUSBName = (String) CacheData.restoreObject("LabelUSBName");
                    if (LabelUSBName.equals(usbDevice.getDeviceName()) && rbType == 1) {
                        mTvConnect.setText("未连接");
                    }
                    break;
                case DeviceConnFactoryManager.ACTION_CONN_STATE:
                    int state = intent.getIntExtra(DeviceConnFactoryManager.STATE, -1);
                    int deviceId = intent.getIntExtra(DeviceConnFactoryManager.DEVICE_ID, -1);
                    switch (state) {
                        case DeviceConnFactoryManager.CONN_STATE_DISCONNECT:
                            if (id == deviceId) {
                                Log.e(TAG, "connection is lost");
                            }
                            break;
                        case DeviceConnFactoryManager.CONN_STATE_CONNECTING:
                            mTvConnect.setText("连接中");
                            break;
                        case DeviceConnFactoryManager.CONN_STATE_CONNECTED:
                            ISLABELCONNECT = true;
                            CacheData.saveObject("LabelUSBName", usbDev);
                            mTvConnect.setText(getString(R.string.con_success));
                            break;
                        case DeviceConnFactoryManager.CONN_STATE_FAILED:
                            ISLABELCONNECT = false;
                            mTvConnect.setText(getString(R.string.con_failed));
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
    };

    /**
     * 选择蓝牙设备
     */
    private void setBluetooth() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //判断是否打开蓝牙设备
        if (!bluetoothAdapter.isEnabled()) {
            //请求用户开启
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 1);
        } else {
            showblueboothlist();
        }
    }

    private void showblueboothlist() {
        if (!bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.startDiscovery();
        }
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        BtDialogView = inflater.inflate(R.layout.printer_list, null);
        BtBoudAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, btList);
        BtBoundLv = (ListView) BtDialogView.findViewById(R.id.listView1);
        btScan = (Button) BtDialogView.findViewById(R.id.btn_scan);
        ll_BtFound = (LinearLayout) BtDialogView.findViewById(R.id.ll1);
        BtFoundLv = (ListView) BtDialogView.findViewById(R.id.listView2);
        BtfoundAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, btFoundList);
        BtBoundLv.setAdapter(BtBoudAdapter);
        BtFoundLv.setAdapter(BtfoundAdapter);
        btdialog = new AlertDialog.Builder(getActivity()).setView(BtDialogView).create();
        btdialog.show();

        BtReciever = new DeviceReceiver(btFoundList, BtfoundAdapter, BtFoundLv);

        //注册蓝牙广播接收者
        IntentFilter filterStart = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        IntentFilter filterEnd = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        getActivity().registerReceiver(BtReciever, filterStart);
        getActivity().registerReceiver(BtReciever, filterEnd);

        setDlistener();
        findAvalibleDevice();
    }

    private void setDlistener() {
        // TODO Auto-generated method stub
        btScan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ll_BtFound.setVisibility(View.VISIBLE);
            }
        });
        //已配对的设备的点击连接
        BtBoundLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                try {
                    if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                        bluetoothAdapter.cancelDiscovery();
                    }
                    String mac = btList.get(arg2);
                    mTvPrint.setText(mac.substring(0, mac.indexOf("\n")));
                    mTvConnect.setText("连接中");
                    btdialog.cancel();
                    connectBT(mac.substring(0, mac.indexOf("\n")), mac.substring(mac.length() - 17));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //未配对的设备，点击，配对，再连接
        BtFoundLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                try {
                    if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                        bluetoothAdapter.cancelDiscovery();
                    }
                    String msg = btFoundList.get(arg2);
                    mTvPrint.setText(msg.substring(0, msg.indexOf("\n")));
                    mTvConnect.setText("连接中");
                    btdialog.cancel();
                    connectBT(msg.substring(0, msg.indexOf("\n")), msg.substring(msg.length() - 17));
                    Log.i("TAG", "mac=" + msg);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    /*
    找可连接的蓝牙设备
     */
    private void findAvalibleDevice() {
        // TODO Auto-generated method stub
        //获取可配对蓝牙设备
        Set<BluetoothDevice> device = bluetoothAdapter.getBondedDevices();

        btList.clear();
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            BtBoudAdapter.notifyDataSetChanged();
        }
        if (device.size() > 0) {
            //存在已经配对过的蓝牙设备
            for (Iterator<BluetoothDevice> it = device.iterator(); it.hasNext(); ) {
                BluetoothDevice btd = it.next();
                btList.add(btd.getName() + '\n' + btd.getAddress());
                BtBoudAdapter.notifyDataSetChanged();
            }
        } else {  //不存在已经配对过的蓝牙设备
            btList.add("不存在已经配对过的蓝牙设备");
            BtBoudAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 连接蓝牙
     */
    private void connectBT(final String btName, final String btAddress) {
        if (btAddress.equals("")) {
            mTvConnect.setText(getString(R.string.con_failed));
        } else {
            myBinder.ConnectBtPort(btAddress, new TaskCallback() {
                @Override
                public void OnSucceed() {
                    ISBULETOOTHCONNECT = true;
                    ISCONNECT = false;
                    CacheData.saveObject("BlueToothName", btName);
                    CacheData.saveObject("BlueToothAddress", btAddress);
                    mTvConnect.setText(getString(R.string.con_success));
                }

                @Override
                public void OnFailed() {
                    ISBULETOOTHCONNECT = false;
                    mTvConnect.setText(getString(R.string.con_failed));
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        i = 0;
        mPrintMap.clear();
        getActivity().unregisterReceiver(receiver);
        if (usbManager != null) {
            usbManager = null;
        }
    }

}

package com.wycd.yushangpu.ui.fragment;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
import com.wycd.yushangpu.printutil.bean.PrintSetBean;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.DeviceReceiver;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.USBUtils;
import com.wycd.yushangpu.tools.UpdateAppVersion;
import com.wycd.yushangpu.ui.LoginActivity;
import com.wycd.yushangpu.ui.LogoActivity;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;

import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.PosPrinterDev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import androidx.appcompat.widget.SwitchCompat;
import butterknife.OnClick;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;
import static com.wycd.yushangpu.MyApplication.myBinder;

public class PrintSetFragment extends BaseFragment {

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
    private View upgrade, upgradeSign;

    ImageView sm_picture;
    TextView tv_sm_edition, tv_sersion_life, tv_create_time, tv_end_time, tv_shop_users, tv_shop_mbers, tv_shop_goods,
            tv_shop_name, tv_contacter, tv_industry, tv_address, tv_range, tv_phone, tv_remarks;

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

    private ShopInfoBean shopInfoBean;

    @Override
    public int getContentView() {
        return R.layout.fragment_print_set;
    }

    @Override
    public void onCreated() {
        usbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);

        initView();
        setListener();
        initBroadcast();
    }

    public void setData(ShopInfoBean shopInfoBean) {
        this.shopInfoBean = shopInfoBean;
        super.setData();
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

        if (ISBULETOOTHCONNECT)
            rgPrinterSelect.check(rgPrinterSelectedBluetooth.getId());
        if (ISCONNECT)
            rgPrinterSelect.check(rgPrinterSelectedUsb.getId());
        rgPrinterSelectLabelSize.check(rgPrinterSelectLabelSmall.getId());
        mEtGoodsConsume.setText("1");
        mEtHandDutyTime.setText("1");
        mTvPrint.setText("请选择打印机");
        mTvConnect.setText("未连接");

    }

    public void updateData() {
        mEtGoodsConsume.requestFocus();
        if (LABELPRINT_IS_OPEN) {
            rbPrinterLabel.setVisibility(View.VISIBLE);
        }
        String ReceiptUSBName = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName) && ISCONNECT) {
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
                        name = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
                        break;
                    case R.id.rb_printer_selected_bluetooth:
                        rbType = 2;
                        name = CacheDoubleUtils.getInstance().getString("BlueToothName");
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
                UsbDevice usbDevice = USBUtils.getUsbDeviceFromName(getActivity(), usbDev);
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
                    mPermissionIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent("com.android.example.USB_PERMISSION"), 0);
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
                CacheDoubleUtils.getInstance().put("ReceiptUSBName", usbAddress);
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
        IntentFilter filter = new IntentFilter("com.android.example.USB_PERMISSION");//USB访问权限广播
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
                case "com.android.example.USB_PERMISSION":
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
                    String ReceiptUSBName = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
                    if (TextUtils.equals(ReceiptUSBName, usbDevice.getDeviceName()) && rbType == 0) {
                        mTvConnect.setText("未连接");
                    }
                    String LabelUSBName = CacheDoubleUtils.getInstance().getString("LabelUSBName");
                    if (TextUtils.equals(LabelUSBName, usbDevice.getDeviceName()) && rbType == 1) {
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
                            CacheDoubleUtils.getInstance().put("LabelUSBName", usbDev);
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
                    LogUtils.e("======== Error ========", e.getMessage());
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
                    LogUtils.e("======== Error ========", e.getMessage());
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
                    CacheDoubleUtils.getInstance().put("BlueToothName", btName);
                    CacheDoubleUtils.getInstance().put("BlueToothAddress", btAddress);
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

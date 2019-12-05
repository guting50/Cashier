package com.wycd.yushangpu.ui;

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
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ReportMessageBean;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.printutil.CallBack;
import com.wycd.yushangpu.printutil.CommonFun;
import com.wycd.yushangpu.printutil.HttpHelper;
import com.wycd.yushangpu.printutil.IPrintSetPresenter;
import com.wycd.yushangpu.printutil.IPrintSetView;
import com.wycd.yushangpu.printutil.bean.PrintSetBean;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.DeviceReceiver;
import com.wycd.yushangpu.tools.Utils;

import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.PosPrinterDev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.ButterKnife;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.tools.Constant.ACTION_USB_PERMISSION;

public class PrintSetActivity extends BaseActivity {

    private TextView mTvPrint,mTvConnect;
    private RadioGroup mRgPrintSwitch;//打印开关
    private RadioGroup rgPrinterSet;
    private RadioButton rbPrinterReceipt,rbPrinterLabel,rbPrinterBlueTooth;
    private RadioButton mRbOpen, mRbClose;
    private EditText  mEtGoodsConsume,  mEtHandDutyTime;
    private LinearLayout llPrintSetSwitch,llPrintSet;
    private Spinner printPaper;
    private IPrintSetPresenter mPresenter;
    private IPrintSetView mView;
    private int mPrintSwitch = 1;
    private HashMap<String, String> mPrintMap = new HashMap<>();
    private int i;
    private PrintSetBean mPrintSetBean;

    private ArrayAdapter<String> mSpinnerPaperAdapter;
    private ArrayList<String> paperTypeList = new ArrayList<>();//类型
    private int paperType = 2;

    private int rbType = 0;

    //蓝牙连接相关
    private List<String> btList = new ArrayList<>();
    private ArrayList<String> btFoundList = new ArrayList<>();
    private ArrayAdapter<String> BtBoudAdapter ,BtfoundAdapter;
    private View BtDialogView;
    private ListView BtBoundLv,BtFoundLv;
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
    String usbDev="";
    private int id = 0;
    private UsbManager usbManager;
    private PendingIntent mPermissionIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_set);
        ButterKnife.bind(this);

        usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);

        initView();
        loadData();
        setListener();
        initBroadcast();

        mEtGoodsConsume.requestFocus();
    }

    private void initView() {

        llPrintSetSwitch = (LinearLayout) findViewById(R.id.ll_print_set_switch);
        llPrintSet = (LinearLayout) findViewById(R.id.ll_print_set);
        mTvPrint = (TextView) findViewById(R.id.tv_print_set_print);
        mTvConnect = (TextView) findViewById(R.id.tv_connect_set_print);
        mRgPrintSwitch = (RadioGroup) findViewById(R.id.rg_print_set_switch);
        mRbOpen = (RadioButton) findViewById(R.id.rb_print_set_open);
        mRbClose = (RadioButton) findViewById(R.id.rb_print_set_close);
        mRgPrintSwitch.check(mRbClose.getId());

        rgPrinterSet = (RadioGroup) findViewById(R.id.rg_printer_print_set);
        rbPrinterReceipt = (RadioButton) findViewById(R.id.rb_printer_receipt_set);
        rbPrinterLabel = (RadioButton) findViewById(R.id.rb_printer_label_set);
        rbPrinterBlueTooth = (RadioButton) findViewById(R.id.rb_printer_bluetooth_set);
        rgPrinterSet.check(rbPrinterReceipt.getId());

        String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName) && ISCONNECT) {
            mTvPrint.setText(ReceiptUSBName);
            mTvConnect.setText(getString(R.string.con_success));
        }

        if (LABELPRINT_IS_OPEN){
            rbPrinterLabel.setVisibility(View.VISIBLE);
        }

        mEtGoodsConsume = (EditText) findViewById(R.id.et_print_set_goods_consume);
        mEtHandDutyTime = (EditText) findViewById(R.id.et_print_set_hand_duty);
        printPaper = (Spinner) findViewById(R.id.sp_print_paper);
        paperTypeList.add("58mm纸张");
        paperTypeList.add("80mm纸张");

        mSpinnerPaperAdapter = new ArrayAdapter<String>(ac,
                R.layout.item_spinner, R.id.tv_item_spinner, paperTypeList);
        printPaper.setAdapter(mSpinnerPaperAdapter);
        printPaper.setSelection(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ac = PrintSetActivity.this;
    }


    //更新打印设置缓存
    private void getAllMessage() {
        HttpHelper.post(ac, HttpAPI.API().PRE_LOAD, new CallBack() {
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
        mPrintMap.put("SPXF", "1");
        mPrintMap.put("JB", "1");

        mPresenter = new IPrintSetPresenter(ac);
        mPresenter.onCreate("");
        mView = new IPrintSetView() {
            @Override
            public void getPrintSetSuccess(PrintSetBean bean) {
                mPrintSetBean = bean;
                if (mPrintSetBean != null) {
                    if (bean.getData().getPS_IsEnabled() == 1) {
                        mRgPrintSwitch.check(mRbOpen.getId());
                        if (bean.getData().getPS_PaperType() == 2) {
                            printPaper.setSelection(0);
                        } else if (bean.getData().getPS_PaperType() == 3) {
                            printPaper.setSelection(1);
                        }
                    } else {
                        mRgPrintSwitch.check(mRbClose.getId());
                    }
                    if (bean.getData().getPrintTimesList() != null) {
                        for (int j = 0; j < bean.getData().getPrintTimesList().size(); j++) {

                           if (bean.getData().getPrintTimesList().get(j).getPT_Code().equals("SPXF")) {
                                mEtGoodsConsume.setText("" + bean.getData().getPrintTimesList().get(j).getPT_Times());
                            }  else if (bean.getData().getPrintTimesList().get(j).getPT_Code().equals("JB")) {
                                mEtHandDutyTime.setText("" + bean.getData().getPrintTimesList().get(j).getPT_Times());
                            }
                        }
                    }
                }
            }

            @Override
            public void getPrintSetFail(String result) {
                if (!result.equals("执行失败")) {
                    Toast.makeText(ac, result, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void saveSetSuccess() {
                getAllMessage();
                NoticeDialog.noticeDialog(ac, "设置", "打印设置保存成功!", 1, new InterfaceBack() {
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
                Toast.makeText(ac, result, Toast.LENGTH_SHORT).show();
            }
        };
        mPresenter.attachView(mView);

    }

    private void setListener() {
        //返回
        findViewById(R.id.iv_print_set_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //保存设置
        findViewById(R.id.tv_print_set_save).setOnClickListener(new View.OnClickListener() {
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
                    mPresenter.savePrintSet(ac, params);
                }

            }
        });

        //打印机开关
        mRgPrintSwitch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRbOpen.getId()) {
                    mPrintSwitch = 1;

                    mEtGoodsConsume.setInputType(InputType.TYPE_CLASS_NUMBER);
                    mEtHandDutyTime.setInputType(InputType.TYPE_CLASS_NUMBER);

                    mEtGoodsConsume.setText("1");
                    mEtHandDutyTime.setText("1");

                }
                if (checkedId == mRbClose.getId()) {
                    mPrintSwitch = 0;

                    mEtGoodsConsume.setInputType(InputType.TYPE_NULL);
                    mEtHandDutyTime.setInputType(InputType.TYPE_NULL);
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

        printPaper.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paperType = position + 2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rgPrinterSet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_printer_receipt_set:
                        rbType = 0;
                        llPrintSetSwitch.setVisibility(View.VISIBLE);
                        llPrintSet.setVisibility(View.VISIBLE);
                        String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
                        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName) && ISCONNECT) {
                            mTvPrint.setText(ReceiptUSBName);
                            mTvConnect.setText(getString(R.string.con_success));
                        } else {
                            mTvPrint.setText("请选择打印机");
                            mTvConnect.setText("未连接");
                        }
                        break;
                    case R.id.rb_printer_label_set:
                        rbType = 1;
                        llPrintSetSwitch.setVisibility(View.GONE);
                        llPrintSet.setVisibility(View.GONE);
                        String LabelUSBName = (String) CacheData.restoreObject("LabelUSBName");
                        if (LabelUSBName != null && !"".equals(LabelUSBName) && ISLABELCONNECT) {
                            mTvPrint.setText(LabelUSBName);
                            mTvConnect.setText(getString(R.string.con_success));
                        } else {
                            mTvPrint.setText("请选择打印机");
                            mTvConnect.setText("未连接");
                        }
                        break;
                    case R.id.rb_printer_bluetooth_set:
                        rbType = 2;
                        llPrintSetSwitch.setVisibility(View.VISIBLE);
                        llPrintSet.setVisibility(View.VISIBLE);
                        String BlueToothName = (String) CacheData.restoreObject("BlueToothName");
                        if (BlueToothName != null && !"".equals(BlueToothName) && ISBULETOOTHCONNECT) {
                            mTvPrint.setText(BlueToothName);
                            mTvConnect.setText(getString(R.string.con_success));
                        } else {
                            mTvPrint.setText("请选择打印机");
                            mTvConnect.setText("未连接");
                        }
                        break;
                }
            }
        });

        //打印机连接
        mTvPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rbType){
                    case 0:
                        setUSB();
                        break;
                    case 1:
                        setUSB();
                        break;
                    case 2:
                        setBluetooth();
                        break;
                }
            }
        });
    }

    /**
     * 获取标签USB列表
     */
    private void setUSB(){
        LayoutInflater inflater=LayoutInflater.from(this);
        dialogView3=inflater.inflate(R.layout.usb_link,null);
        tv_usb= (TextView) dialogView3.findViewById(R.id.textView1);
        lv_usb= (ListView) dialogView3.findViewById(R.id.listView1);

        usbList= PosPrinterDev.GetUsbPathNames(this);
        if (usbList==null){
            usbList=new ArrayList<>();
        }

        tv_usb.setText(getString(R.string.usb_pre_con)+usbList.size());
        adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usbList);
        lv_usb.setAdapter(adapter3);

        AlertDialog dialog=new AlertDialog.Builder(this)
                .setView(dialogView3).create();
        dialog.show();

        setUsbLisener(dialog);
    }

    private void setUsbLisener(final AlertDialog dialog) {
        lv_usb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                usbDev=usbList.get(i);
                mTvPrint.setText(usbDev);
                //通过USB设备名找到USB设备
                UsbDevice usbDevice = Utils.getUsbDeviceFromName(PrintSetActivity.this, usbDev);
                //判断USB设备是否有权限
                if (usbManager.hasPermission(usbDevice)) {
                    switch (rbType){
                        case 0:
                            connectUSB(usbDev);
                            break;
                        case 1:
                            closeport();
                            connectLabelUSB(usbDevice);
                            break;
                    }
                } else {//请求权限
                    mPermissionIntent = PendingIntent.getBroadcast(PrintSetActivity.this, 0, new Intent(ACTION_USB_PERMISSION), 0);
                    usbManager.requestPermission(usbDevice, mPermissionIntent);
                }
                dialog.cancel();
                Log.e("usbDev: ",usbDev);
            }
        });
    }

    /**
     * USB连接标签打印机
     */
    public void connectLabelUSB(UsbDevice usbDevice){
            new DeviceConnFactoryManager.Build()
                    .setId(id)
                    .setConnMethod(DeviceConnFactoryManager.CONN_METHOD.USB)
                    .setUsbDevice(usbDevice)
                    .setContext(this)
                    .build();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].openPort();
    }

    /**
     * 连接usb
     */
    public void connectUSB(final String usbAddress){
            myBinder.ConnectUsbPort(this, usbAddress, new TaskCallback() {
                @Override
                public void OnSucceed() {
                    ISCONNECT = true;
                    ISBULETOOTHCONNECT = false;
                    CacheData.saveObject("ReceiptUSBName",usbAddress);
                    mTvConnect.setText(getString(R.string.con_success));
                }

                @Override
                public void OnFailed() {
                    ISCONNECT = false;
                    mTvConnect.setText(getString(R.string.con_failed));
                }
            } );
    }

    /**
     * 重新连接回收上次连接的对象，避免内存泄漏
     */
    private void closeport(){
        if(DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id]!=null&&DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort!=null) {
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].reader.cancel();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort.closePort();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].mPort=null;
        }
    }

    /**
     *注册广播
     * Registration broadcast
     */
    private void initBroadcast() {
        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);//USB访问权限广播
        filter.addAction(ACTION_USB_DEVICE_DETACHED);//USB线拔出
//        filter.addAction(ACTION_QUERY_PRINTER_STATE);//查询打印机缓冲区状态广播，用于一票一控
        filter.addAction(DeviceConnFactoryManager.ACTION_CONN_STATE);//与打印机连接状态
        filter.addAction(ACTION_USB_DEVICE_ATTACHED);//USB线插入
        registerReceiver(receiver, filter);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                //USB请求访问权限
                case ACTION_USB_PERMISSION:
                    synchronized (this) {
                        UsbDevice device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                        if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                            if (device != null) {//用户点击授权
                                switch (rbType){
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
                            Log.e(TAG,"No access to USB");
                        }
                    }
                    break;
                //Usb连接断开广播
                case ACTION_USB_DEVICE_DETACHED:
                    UsbDevice usbDevice = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                    String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
                    if (ReceiptUSBName.equals(usbDevice.getDeviceName()) && rbType == 0){
                        mTvConnect.setText("未连接");
                    }
                    String LabelUSBName = (String) CacheData.restoreObject("LabelUSBName");
                    if (LabelUSBName.equals(usbDevice.getDeviceName()) && rbType == 1){
                        mTvConnect.setText("未连接");
                    }
                    break;
                case DeviceConnFactoryManager.ACTION_CONN_STATE:
                    int state = intent.getIntExtra(DeviceConnFactoryManager.STATE, -1);
                    int deviceId = intent.getIntExtra(DeviceConnFactoryManager.DEVICE_ID, -1);
                    switch (state) {
                        case DeviceConnFactoryManager.CONN_STATE_DISCONNECT:
                            if (id == deviceId) {
                                Log.e(TAG,"connection is lost");
                            }
                            break;
                        case DeviceConnFactoryManager.CONN_STATE_CONNECTING:
                            mTvConnect.setText("连接中");
                            break;
                        case DeviceConnFactoryManager.CONN_STATE_CONNECTED:
                            ISLABELCONNECT = true;
                            CacheData.saveObject("LabelUSBName",usbDev);
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
     *选择蓝牙设备
     */
    private void setBluetooth(){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        //判断是否打开蓝牙设备
        if (!bluetoothAdapter.isEnabled()){
            //请求用户开启
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 1);
        }else {
            showblueboothlist();
        }
    }

    private void showblueboothlist() {
        if (!bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.startDiscovery();
        }
        LayoutInflater inflater=LayoutInflater.from(this);
        BtDialogView=inflater.inflate(R.layout.printer_list, null);
        BtBoudAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, btList);
        BtBoundLv= (ListView) BtDialogView.findViewById(R.id.listView1);
        btScan= (Button) BtDialogView.findViewById(R.id.btn_scan);
        ll_BtFound= (LinearLayout) BtDialogView.findViewById(R.id.ll1);
        BtFoundLv=(ListView) BtDialogView.findViewById(R.id.listView2);
        BtfoundAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, btFoundList);
        BtBoundLv.setAdapter(BtBoudAdapter);
        BtFoundLv.setAdapter(BtfoundAdapter);
        btdialog=new AlertDialog.Builder(this).setView(BtDialogView).create();
        btdialog.show();

        BtReciever=new DeviceReceiver(btFoundList,BtfoundAdapter,BtFoundLv);

        //注册蓝牙广播接收者
        IntentFilter filterStart=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        IntentFilter filterEnd=new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(BtReciever, filterStart);
        registerReceiver(BtReciever, filterEnd);

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
                    if(bluetoothAdapter!=null&&bluetoothAdapter.isDiscovering()){
                        bluetoothAdapter.cancelDiscovery();
                    }
                    String mac=btList.get(arg2);
                    mTvPrint.setText(mac.substring(0,mac.indexOf("\n")));
                    mTvConnect.setText("连接中");
                    btdialog.cancel();
                    connectBT(mac.substring(0,mac.indexOf("\n")),mac.substring(mac.length()-17));
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
                    if(bluetoothAdapter!=null&&bluetoothAdapter.isDiscovering()){
                        bluetoothAdapter.cancelDiscovery();
                    }
                    String msg=btFoundList.get(arg2);
                    mTvPrint.setText(msg.substring(0,msg.indexOf("\n")));
                    mTvConnect.setText("连接中");
                    btdialog.cancel();
                    connectBT(msg.substring(0,msg.indexOf("\n")),msg.substring(msg.length()-17));
                    Log.i("TAG", "mac="+msg);
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
        Set<BluetoothDevice> device=bluetoothAdapter.getBondedDevices();

        btList.clear();
        if(bluetoothAdapter!=null&&bluetoothAdapter.isDiscovering()){
            BtBoudAdapter.notifyDataSetChanged();
        }
        if(device.size()>0){
            //存在已经配对过的蓝牙设备
            for(Iterator<BluetoothDevice> it = device.iterator(); it.hasNext();){
                BluetoothDevice btd=it.next();
                btList.add(btd.getName()+'\n'+btd.getAddress());
                BtBoudAdapter.notifyDataSetChanged();
            }
        }else{  //不存在已经配对过的蓝牙设备
            btList.add("不存在已经配对过的蓝牙设备");
            BtBoudAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 连接蓝牙
     */
    private void connectBT(final String btName , final String btAddress){
        if (btAddress.equals("")){
            mTvConnect.setText(getString(R.string.con_failed));
        }else {
            myBinder.ConnectBtPort(btAddress, new TaskCallback() {
                @Override
                public void OnSucceed() {
                    ISBULETOOTHCONNECT = true;
                    ISCONNECT = false;
                    CacheData.saveObject("BlueToothName",btName);
                    CacheData.saveObject("BlueToothAddress",btAddress);
                    mTvConnect.setText(getString(R.string.con_success));
                }

                @Override
                public void OnFailed() {
                    ISBULETOOTHCONNECT = false;
                    mTvConnect.setText(getString(R.string.con_failed));
                }
            } );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        i = 0;
        mPrintMap.clear();
        unregisterReceiver(receiver);
        if (usbManager!=null){
            usbManager=null;
        }
    }

}

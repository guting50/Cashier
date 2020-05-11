package com.wycd.yushangpu.ui;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.model.ImpShopInfo;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.PrintContent;
import com.wycd.yushangpu.tools.SystemUIUtils;
import com.wycd.yushangpu.tools.ThreadPool;
import com.wycd.yushangpu.tools.Utils;
import com.wycd.yushangpu.ui.fragment.CashierFragment;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;
import com.wycd.yushangpu.ui.fragment.PrintSetFragment;
import com.wycd.yushangpu.ui.fragment.VipMemberFragment;
import com.wycd.yushangpu.web.WebDialog;

import net.posprinter.posprinterface.TaskCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.tools.Constant.ACTION_USB_PERMISSION;
import static com.wycd.yushangpu.tools.DeviceConnFactoryManager.PrinterCommand.TSC;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.ig_exchange)
    ImageView igExchange;
    @BindView(R.id.rl_jiaoban)
    RelativeLayout mRlJiaoban;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.img_pay_success)
    public ImageView imgPaySuccess;
    @BindView(R.id.img_hedimg)
    CircleImageView imgHedimg;

    private long firstTime = 0;

    private int width;
    private static WebDialog webDialog;

    private static final int CONN_PRINTER = 0x12;
    private int id = 0;

    public CashierFragment cashierFragment = new CashierFragment();
    public JiesuanBFragment jiesuanBFragment = new JiesuanBFragment();
    public PrintSetFragment printSetFragment = new PrintSetFragment();
    public VipMemberFragment vipMemberFragment = new VipMemberFragment();
    private boolean isFirstLaunch = false;

    private BluetoothAdapter bluetoothAdapter;
    //    private static BluetoothAdapter mBluetoothAdapter;//蓝牙适配器
//    private static final UUID BLUETOOTH_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");//串口全局唯一标识符
//    private static BluetoothDevice mDevice;//蓝牙设备
//    private static BluetoothSocket mBluetoothSocket;//蓝牙通信端口
//    private OutputStream mOutputStream;//输出数据流
//
//    private byte[] mData;//接受打印小票数据的字节码
//    private int recepits_num;//存在本地的循环打印次数
//    private SharedPreferences mSharedPreferences;
//    private static SharedPreferences.Editor mEditor;
//
//    private static List<Map<String, String>> list_bluedevice = new ArrayList<>();
//    private static List<String> list_device_name = new ArrayList<>();//蓝牙名称列表
//    private static Map<String, String> map_bluedevice = new HashMap<>();//蓝牙名称、mac地址集合
//    private String mBluetoothName;//已经连接的蓝牙设备名称

    //usb连接相关
    private ThreadPool threadPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        isFirstLaunch = true;
        ButterKnife.bind(this);

        initBroadcast();

        initData();
        initEvent();

        initPrint();
    }

    private void initPrint() {
        String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
        if (ReceiptUSBName != null && !"".equals(ReceiptUSBName)) {
            myBinder.ConnectUsbPort(this, ReceiptUSBName, new TaskCallback() {
                @Override
                public void OnSucceed() {
                    ISCONNECT = true;
                    ISBULETOOTHCONNECT = false;
                }

                @Override
                public void OnFailed() {
                    ISCONNECT = false;
                }
            });
        } else {
            String BlueToothAddress = (String) CacheData.restoreObject("BlueToothAddress");
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            //判断是否打开蓝牙设备
            if (bluetoothAdapter.isEnabled() && BlueToothAddress != null && !"".equals(BlueToothAddress)) {
                myBinder.ConnectBtPort(BlueToothAddress, new TaskCallback() {
                    @Override
                    public void OnSucceed() {
                        ISBULETOOTHCONNECT = true;
                        ISCONNECT = false;
                    }

                    @Override
                    public void OnFailed() {
                        ISBULETOOTHCONNECT = false;
                    }
                });
            }
        }
        String LabelUSBName = (String) CacheData.restoreObject("LabelUSBName");
        if (LabelUSBName != null && !"".equals(LabelUSBName)) {
            UsbDevice usbDevice = Utils.getUsbDeviceFromName(HomeActivity.this, LabelUSBName);
            new DeviceConnFactoryManager.Build()
                    .setId(id)
                    .setConnMethod(DeviceConnFactoryManager.CONN_METHOD.USB)
                    .setUsbDevice(usbDevice)
                    .setContext(this)
                    .build();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].openPort();
        }
    }

    /**
     * 注册广播
     * Registration broadcast
     */
    private void initBroadcast() {
        try {
            IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);//USB访问权限广播
            filter.addAction(ACTION_USB_DEVICE_DETACHED);//USB线拔出
//        filter.addAction(ACTION_QUERY_PRINTER_STATE);//查询打印机缓冲区状态广播，用于一票一控
            filter.addAction(DeviceConnFactoryManager.ACTION_CONN_STATE);//与打印机连接状态
            filter.addAction(ACTION_USB_DEVICE_ATTACHED);//USB线插入
            registerReceiver(new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    switch (action) {
                        //Usb连接断开广播
                        case ACTION_USB_DEVICE_DETACHED:
                            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                            String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
                            if (ReceiptUSBName != null && ReceiptUSBName.equals(usbDevice.getDeviceName())) {
                                ISCONNECT = false;
                            }
                            String LabelUSBName = (String) CacheData.restoreObject("LabelUSBName");
                            if (LabelUSBName.equals(usbDevice.getDeviceName())) {
                                ISLABELCONNECT = false;
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
                                    break;
                                case DeviceConnFactoryManager.CONN_STATE_CONNECTED:
                                    ISLABELCONNECT = true;
                                    break;
                                case DeviceConnFactoryManager.CONN_STATE_FAILED:
                                    ISLABELCONNECT = false;
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
            }, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initFragment() {
        cashierFragment.show(this, R.id.subsidiary_fragment);
    }

    private void initData() {
        GetPrintSet.getPrintSet();
        getShopInfo();

        PreferenceHelper.write(ac, "yunshangpu", "vip", false);

        if (MyApplication.loginBean != null) {
            if (MyApplication.loginBean.getUM_ChatHead() != null) {
                Glide.with(ac).load(ImgUrlTools.obtainUrl(
                        NullUtils.noNullHandle(MyApplication.loginBean.getUM_ChatHead()).toString()))
                        .error(R.mipmap.member_head_nohead).into(imgHedimg);
            }
            tvStoreName.setText(MyApplication.loginBean.getUM_Name());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            long secndTime = System.currentTimeMillis();
            if (secndTime - firstTime > 3000) {
                firstTime = secndTime;
                Toast.makeText(ac, "再按一次退出", Toast.LENGTH_LONG)
                        .show();
            } else {
                ActivityManager.getInstance().exit();
            }
            return true;
        }
        return false;
    }

    private void initEvent() {
        mRlJiaoban.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //交班
                showWebDialog("交班", "/WebUI/Other/OExchange.html", width * 9 / 10, 680);

            }
        });
    }

    @BindView(R.id.btn_cashier)
    public ImageView btn_cashier;
    @BindView(R.id.btn_home_set)
    ImageView btn_home_set;
    @BindView(R.id.btn_member)
    ImageView btn_member;
    @BindView(R.id.btn_goods)
    ImageView btn_goods;
    @BindView(R.id.btn_sale)
    ImageView btn_sale;
    @BindView(R.id.btn_houtai)
    ImageView btn_houtai;

    @OnClick({R.id.btn_cashier, R.id.btn_home_set, R.id.btn_member, R.id.btn_goods, R.id.btn_sale})
    public void onTaskbarClick(View view) {
        btn_cashier.setImageResource(R.mipmap.btn_cashier_false);
        btn_home_set.setImageResource(R.mipmap.btn_home_set_false);
        btn_member.setImageResource(R.mipmap.btn_member_false);
        btn_goods.setImageResource(R.mipmap.btn_goods_false);
        btn_sale.setImageResource(R.mipmap.btn_sale_false);
        btn_houtai.setImageResource(R.mipmap.btn_houtai_false);
        cashierFragment.hide();
        printSetFragment.hide();
        vipMemberFragment.hide();
        switch (view.getId()) {
            case R.id.btn_cashier:
                btn_cashier.setImageResource(R.mipmap.btn_cashier_true);
                cashierFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_home_set:
                btn_home_set.setImageResource(R.mipmap.btn_home_set_true);
                printSetFragment.setData(shopInfoBean);
                printSetFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_member:
                btn_member.setImageResource(R.mipmap.btn_member_true);
                vipMemberFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_goods:
                btn_goods.setImageResource(R.mipmap.btn_goods_true);
                break;
            case R.id.btn_sale:
                btn_sale.setImageResource(R.mipmap.btn_sale_true);
                break;
        }
    }

    @OnClick({R.id.subsidiary_fragment, R.id.rl_out, R.id.btn_houtai})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_houtai:
                btn_houtai.setImageResource(R.mipmap.btn_houtai_false);
                int version = (int) (1 + Math.random() * (1000000 - 1 + 1));

//                showWebDialog("index.html");

                //后台
//                Intent intent = new Intent(ac, WebActivity.class);
//                intent.putExtra("versionDownURL",  MyApplication.BASE_URL+"loginTSCash.html?URL=index.html&v=" +String.valueOf(version));
//                //http://192.168.1.240:807/login.html
//                startActivity(intent);

                Intent intent = new Intent(ac, WebActivity.class);
//                intent.putExtra("html_url", "https://pc.yunvip123.com/login.html");
                intent.putExtra("html_url", "https://pc.yunvip123.com/loginTSCash.html");
                startActivity(intent);
                break;
            case R.id.subsidiary_fragment:
                break;
            case R.id.rl_out:
                /*mShowMemberPop = new ShowMemberPopWindow(HomeActivity.this, MyApplication.loginBean);
                mShowMemberPop.setOnItemClickListener(HomeActivity.this);
                mShowMemberPop.showAsDropDown(HomeActivity.this.findViewById(R.id.rl_out), -10, 0);*/
                break;
        }
    }

    private void showWebDialog(String title, String url, int mwidth, int mheight) {
        int version = (int) (1 + Math.random() * (1000000 - 1 + 1));
        webDialog = new WebDialog(ac, mwidth, mheight, MyApplication.BASE_URL + "loginTSCash.html?URL=" + url + "&Name=" + title + "&v=" + String.valueOf(version));
        SystemUIUtils.setStickFullScreen(webDialog.getWindow().getDecorView());
        webDialog.show();
//        JavascriptInterfaceImpl.startLoading();
        MyApplication.isDialog = "1";
    }

    public static void closeDialog() {
        if (webDialog != null) {
            webDialog.dismiss();
            MyApplication.isDialog = "0";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ac = HomeActivity.this;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (isFirstLaunch) {
                isFirstLaunch = false;
                // TODO 第一次启动界面加载完毕后的操作
                initFragment();
            }
        }
    }

    ShopInfoBean shopInfoBean;

    public void getShopInfo() {
        ImpShopInfo impShopInfo = new ImpShopInfo();
        impShopInfo.shopInfo(new InterfaceBack<ShopInfoBean>() {
            @Override
            public void onResponse(ShopInfoBean response) {
                shopInfoBean = response;
            }
        });
    }

    /**
     * 打印标签
     */
    public void labelPrint(final ShopMsg shopMsg) {
        threadPool = ThreadPool.getInstantiation();
        threadPool.addSerialTask(new Runnable() {
            @Override
            public void run() {
                if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id] == null ||
                        !DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].getConnState()) {
//                    cashierFragment.obtainMessage(CONN_PRINTER).sendToTarget();
                    return;
                }
                if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].getCurrentPrinterCommand() == TSC) {
                    DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].sendDataImmediately(PrintContent.getLabel(shopMsg));
                }
            }
        });
    }

}

package com.wycd.yushangpu.ui;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gt.utils.view.BgFrameLayout;
import com.maimengmami.waveswiperefreshlayout.WaveSwipeRefreshLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.ShopFirstClassAdapter;
import com.wycd.yushangpu.adapter.ShopLeftAdapter;
import com.wycd.yushangpu.adapter.ShopRightAdapter;
import com.wycd.yushangpu.bean.ClassMsg;
import com.wycd.yushangpu.bean.EmplMsg;
import com.wycd.yushangpu.bean.GoodsModelBean;
import com.wycd.yushangpu.bean.LoginBean;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.SmsSwitch;
import com.wycd.yushangpu.bean.VipDengjiMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.dialog.ChangePwdDialog;
import com.wycd.yushangpu.dialog.GoodsModelDialog;
import com.wycd.yushangpu.dialog.JiesuanBDialog;
import com.wycd.yushangpu.dialog.KeyboardDialog;
import com.wycd.yushangpu.dialog.NoticeDialog;
import com.wycd.yushangpu.dialog.QudanDialog;
import com.wycd.yushangpu.dialog.ShopDetailDialog;
import com.wycd.yushangpu.dialog.VipChooseDialog;
import com.wycd.yushangpu.http.HttpAPI;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.InterfaceThreeBack;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.model.ImpGoodsModel;
import com.wycd.yushangpu.model.ImpGroupGoodsList;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.model.ImpOutLogin;
import com.wycd.yushangpu.model.ImpShopClass;
import com.wycd.yushangpu.model.ImpShopHome;
import com.wycd.yushangpu.model.ImpSubmitOrder;
import com.wycd.yushangpu.model.ImpSubmitOrder_Guazhang;
import com.wycd.yushangpu.model.ImpSystemCanshu;
import com.wycd.yushangpu.popwindow.ShowMemberPopWindow;
import com.wycd.yushangpu.popwindow.ShowStorePopWindow;
import com.wycd.yushangpu.printutil.CallBack;
import com.wycd.yushangpu.printutil.CommonFun;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
import com.wycd.yushangpu.printutil.HttpHelper;
import com.wycd.yushangpu.printutil.YSLUtils;
import com.wycd.yushangpu.tools.ActivityManager;
import com.wycd.yushangpu.tools.CacheData;
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.CreateOrder;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.tools.PrintContent;
import com.wycd.yushangpu.tools.PrinterCommand;
import com.wycd.yushangpu.tools.RecycleViewUtiles;
import com.wycd.yushangpu.tools.SignUtils;
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.tools.SystemUIUtils;
import com.wycd.yushangpu.tools.ThreadPool;
import com.wycd.yushangpu.tools.Utils;
import com.wycd.yushangpu.views.ClearEditText;
import com.wycd.yushangpu.web.WebDialog;

import net.posprinter.posprinterface.TaskCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.MyApplication.shortMessage;
import static com.wycd.yushangpu.tools.Constant.ACTION_USB_PERMISSION;

public class HomeActivity extends BaseActivity implements ShowMemberPopWindow.OnItemClickListener, ShowStorePopWindow.OnItemStoreClickListener {
    @BindView(R.id.ig_back)
    ImageView igBack;
    @BindView(R.id.rl_houtai)
    RelativeLayout mRlHoutai;
    @BindView(R.id.ig_exchange)
    ImageView igExchange;
    @BindView(R.id.rl_jiaoban)
    RelativeLayout mRlJiaoban;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.rl_out)
    RelativeLayout rlOut;
    @BindView(R.id.et_login_account)
    ClearEditText mEtLoginAccount;
    @BindView(R.id.tv_ordertime)
    TextView tv_ordertime;
    @BindView(R.id.tv_ordernum)
    TextView tv_ordernum;
    @BindView(R.id.recyclerview_shoplist)
    RecyclerView mRecyclerviewShoplist;
    @BindView(R.id.im_clear)
    ImageView imClear;
    @BindView(R.id.rl_clear)
    TextView mRlClear;
    @BindView(R.id.rl_jifen)
    LinearLayout rlJifen;
    @BindView(R.id.tv_heji)
    TextView mTvHeji;
    @BindView(R.id.iv_viptx)
    CircleImageView mIvViptx;
    @BindView(R.id.tv_vipname)
    TextView mTvVipname;
    @BindView(R.id.tv_blance)
    TextView tvBlance;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.member_bg_layout)
    BgFrameLayout mRlVip;
    @BindView(R.id.delet_vip)
    ImageView deletVip;
    @BindView(R.id.tv_shoukuan)
    TextView tvShoukuan;
    @BindView(R.id.btt_price_exchange)
    Button bttPriceExchange;
    @BindView(R.id.btt_dicount_exchange)
    Button bttDicountExchange;
    @BindView(R.id.btt_money_exchange)
    Button bttMoneyExchange;
    @BindView(R.id.btt_num_exchange)
    Button bttNumExchange;
    @BindView(R.id.btt_delte)
    Button bttDelte;
    @BindView(R.id.btt_give)
    Button bttGive;
    @BindView(R.id.btt_royalty)
    Button bttRoyalty;
    @BindView(R.id.btt_get_order)
    Button bttGetOrder;
    @BindView(R.id.btt_hung_order)
    Button bttHungOrder;
    @BindView(R.id.btt_hung_money)
    Button bttHungMoney;
    @BindView(R.id.btt_reture_goods)
    Button bttRetureGoods;
    @BindView(R.id.btt_recharge)
    Button bttRecharge;
    @BindView(R.id.btt_vip_member)
    Button bttVipMember;
    @BindView(R.id.btt_business)
    Button bttBusiness;
    @BindView(R.id.iv_top_left)
    ImageView ivTopLeft;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.recyclerview_firstclass)
    RecyclerView mRecyclerviewFirstclass;
    @BindView(R.id.gridview)
    GridView mGridview;
    @BindView(R.id.tv_front_page)
    TextView tvFrontPage;
    @BindView(R.id.tv_page)
    TextView tvPage;
    @BindView(R.id.tv_total_page)
    TextView tvTotalPage;
    @BindView(R.id.im_next_page)
    TextView imNextPage;
    @BindView(R.id.sp_goods_order_num)
    Spinner spGoodsOrderNum;
    @BindView(R.id.tv_tatol_num)
    TextView tvTatolNum;
    @BindView(R.id.vip_message)
    LinearLayout vipMessage;
    @BindView(R.id.tv_get_integral)
    TextView tvGetIntegral;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.cb_short_message)
    CheckBox cbMessage;
    @BindView(R.id.refresh_goods_consume)
    WaveSwipeRefreshLayout mRefreshLayout;//刷新布局
    @BindView(R.id.btn_home_print_set)
    Button btnHomePrint;
    @BindView(R.id.btn_home_label)
    Button btnHomeLabel;

    private int PageIndex = 1;
    private int PageSize = 20;
    private static int totalPage;
    private static int totalCount;
    private static CircleImageView imgHedimg;
    private ArrayAdapter<String> mSpinnerAdapter;
    private ArrayList<String> GoodsTypeList = new ArrayList<>();//每页显示商品数目
    private List<ClassMsg> mClassMsgList = new ArrayList<>();//分类数据列表
    private String mPT_Gid = "";
    //    private List<ClassMsg> twoClassList;
//    private Gson mGson;
    private List<ShopMsg> mShopMsgList = new ArrayList<>();
    private LinearLayoutManager linearmanger;
    private ShopFirstClassAdapter mFirstClassAdapter;
    private ShopLeftAdapter mShopLeftAdapter;
    private List<ShopMsg> mShopLeftList = new ArrayList<>();
    private List<EmplMsg> mEmplMsgList2;
    private ShopRightAdapter mShopRightAdapter;
    private VipDengjiMsg.DataBean mVipMsg;
    private VipDengjiMsg mVipDengjiMsg;
    //    private List<GoodOrdeList> goodOrdeLists = new ArrayList<>();
    private CharSequence ordertime;
    private String order;
    private List<PayTypeMsg> paytypelist = new ArrayList<>();
    private PayTypeMsg moren;
    private String allmoney;
    private double mPoint;
    private long firstTime = 0;
    private String jifendkbfb, jinfenzfxzbfb;
    //    private double PD_Discount = 0;
    private int leftpos = -1;// 购物车选中位子 -1表示没有选中
    private static LoginBean loginBean;//登录数据
    private String mSmGid;
    private int mPD_Discount = 0;
    private List<GoodsModelBean> ModelList;
    private List<List<GoodsModelBean>> modelList = new ArrayList<>();

    private ShowMemberPopWindow mShowMemberPop;
    private ShowStorePopWindow mShowStorePop;
    private boolean isZeroStock;
    private int width;
    private int height;//屏幕高度
    private static WebDialog webDialog;

    //usb连接相关
    private ThreadPool threadPool;
    private static final int CONN_PRINTER = 0x12;
    private static final int PRINTER_COMMAND_ERROR = 0x008;//使用打印机指令错误
    private int id = 0;

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


    private int mButtonGreen[] = new int[]{R.id.btn_home_label, R.id.btt_price_exchange, R.id.btt_dicount_exchange, R.id.btt_dicount_exchange, R.id.btt_money_exchange, R.id.btt_num_exchange, R.id.btt_royalty, R.id.btt_get_order, R.id.btt_hung_money};

    //商品数据修改(修改单价/修改折扣/修改小计/修改数量)
    private int mModifyPrice = 0;
    //修改改价
    private int mChangePrice = 0;
    //修改折扣
    private int mChangeDiscount = 0;
    //修改小计
    private int mChangeSubtotal = 0;

//    public HomeActivity() {
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
//        ActivityStack.create().addActivity(HomeActivity.this);
        EventBus.getDefault().register(this);

        initBroadcast();

        initView();
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
        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);//USB访问权限广播
        filter.addAction(ACTION_USB_DEVICE_DETACHED);//USB线拔出
//        filter.addAction(ACTION_QUERY_PRINTER_STATE);//查询打印机缓冲区状态广播，用于一票一控
        filter.addAction(DeviceConnFactoryManager.ACTION_CONN_STATE);//与打印机连接状态
        filter.addAction(ACTION_USB_DEVICE_ATTACHED);//USB线插入
        registerReceiver(receiver, filter);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                //Usb连接断开广播
                case ACTION_USB_DEVICE_DETACHED:
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                    String ReceiptUSBName = (String) CacheData.restoreObject("ReceiptUSBName");
                    if (ReceiptUSBName.equals(usbDevice.getDeviceName())) {
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
    };

    protected void initView() {
        imgHedimg = (CircleImageView) findViewById(R.id.img_hedimg);
        linearmanger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerviewFirstclass.setLayoutManager(linearmanger);
        mFirstClassAdapter = new ShopFirstClassAdapter(ac, mClassMsgList);
        mRecyclerviewFirstclass.setAdapter(mFirstClassAdapter);


        mShopRightAdapter = new ShopRightAdapter(ac, mShopMsgList);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        if (width > 1600) {
            mGridview.setNumColumns(5);
        } else if (width < 1300) {
            mGridview.setNumColumns(3);
        }
        mGridview.setAdapter(mShopRightAdapter);

        mShopLeftAdapter = new ShopLeftAdapter(ac, mShopLeftList, new InterfaceThreeBack() {

            //加减
            @Override
            public void onResponse(Object response) {
                ShopMsg shopMsg = (ShopMsg) response;
                mShopLeftList.set(shopMsg.getChosePosion(), shopMsg);
//                if (mShopMsgList.size() > 0) {
//                    for (int i = 0; i < mShopLeftList.size(); i++) {
//                        for (int j = 0; j < mShopMsgList.size(); j++) {
//                            if (mShopLeftList.get(i).getGID().equals(mShopMsgList.get(j).getGID())) {
//                                mShopMsgList.get(j).setCurrtStock_Number(mShopMsgList.get(j).getStock_Number() - mShopLeftList.get(i).getNum());
//                            }
//                        }
//                    }
//                }
                mShopRightAdapter.notifyDataSetChanged();
                jisuanAllPrice();
            }

            //移除
            @Override
            public void onErrorResponse(Object msg) {
                int po = (int) msg;
                if (mShopLeftList.size() > 0) {
//                    if (mShopMsgList.size() > 0) {
//                        for (int j = 0; j < mShopMsgList.size(); j++) {
//                            if (mShopLeftList.get(po).getGID().equals(mShopMsgList.get(j).getGID())) {
//                                mShopMsgList.get(j).setCurrtStock_Number(mShopMsgList.get(j).getStock_Number());
//                            }
//                        }
//                    }
                    mShopRightAdapter.notifyDataSetChanged();

                    mShopLeftList.remove(po);
                    leftpos = leftpos - 1;
                    mShopLeftAdapter.notifyDataSetChanged();
                    jisuanAllPrice();
                    if (mShopLeftList.size() > 0) {
                        bttGetOrder.setText("挂单");
                    } else {
                        bttGetOrder.setText("取单");
                    }
                }
            }

            //选中
            @Override
            public void onThreeResponse(Object object) {
                final int i = (int) object;
                leftpos = i;
                for (int j = 0; j < mShopLeftList.size(); j++) {
                    mShopLeftList.get(j).setCheck(false);
                }
                mShopLeftList.get(i).setCheck(true);
                mShopLeftAdapter.notifyDataSetChanged();
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerviewShoplist.setLayoutManager(llm);
        mRecyclerviewShoplist.setAdapter(mShopLeftAdapter);


        mFirstClassAdapter.setOnItemClickListener(new ShopFirstClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int tag) {
                ClassMsg classMsg1 = mClassMsgList.get(tag);
                for (ClassMsg c : mClassMsgList) {
                    c.setChose(false);
                }
                mClassMsgList.get(tag).setChose(true);
                mFirstClassAdapter.notifyDataSetChanged();
                mPT_Gid = classMsg1.getGID();
                PageIndex = 1;
                obtainHomeShop(mPT_Gid, mEtLoginAccount.getText().toString());
            }
        });

        mEtLoginAccount.requestFocus();

//        mSharedPreferences = getSharedPreferences("bluetooth_address", MODE_PRIVATE);
//        mEditor = mSharedPreferences.edit();

//        try {
//            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//            IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
//            IntentFilter filter2 = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
//            IntentFilter filter3 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED);
//            this.registerReceiver(receiver, filter);
//            this.registerReceiver(receiver, filter1);
//            this.registerReceiver(receiver, filter2);
//            this.registerReceiver(receiver, filter3);
//            mRegisterTag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        getBlueToothList();
    }


    /**
     * 检查设备是否支持蓝牙
     */
//    @SuppressLint("WrongConstant")
//    private static void checkBlueToothSupportSwitch(Context context) {
//        System.out.println("========checkBlueToothSupportSwitch=====random:" + mBluetoothAdapter);
//        if (mBluetoothAdapter != null) {
//            blueToothIsSwitch();
//        } else {
////            ToastUtils.showToast(context, "该设备不支持蓝牙");
//            com.blankj.utilcode.util.ToastUtils.showShort("该设备不支持蓝牙");
//        }
//    }

    /**
     * 判断蓝牙开关是否打开
     */
//    private static void blueToothIsSwitch() {
//        if (!mBluetoothAdapter.isEnabled()) {
//            mBluetoothAdapter.enable();
//            getBoundedDevices();
//        } else {
//            getBoundedDevices();
//        }
//    }


    /**
     * 获得已配对的蓝牙设备信息并保存
     */
//    private static void getBoundedDevices() {
//        Set<BluetoothDevice> devices_set = mBluetoothAdapter.getBondedDevices();
//        System.out.println("======getBoundedDevices=======random:" + devices_set.size());
//        map_bluedevice.clear();
//        list_bluedevice.clear();
//        list_device_name.clear();
//        if (devices_set.size() > 0) {
//            for (BluetoothDevice device : devices_set) {
//                System.out.println(device.getAddress() + "======getBoundedDevices=======random:" + device.getName());
//                map_bluedevice.put(device.getName(), device.getAddress());
//                list_bluedevice.add(map_bluedevice);
//                list_device_name.add(device.getName());
//            }
//            MyApplication.mPrintList = list_device_name;
//        }
//    }


//    public static void getBlueToothList() {
//
//        checkBlueToothSupportSwitch(ac);
//
//        if (!mBluetoothAdapter.isEnabled()) {
//            return;
//        }
//        //判断是否正在扫描
//        if (!mBluetoothAdapter.isDiscovering()) {
//            Log.i(TAG, "getBlueToothList:开始扫描蓝牙 ");
//            mBluetoothAdapter.startDiscovery();
//        }
//    }


//    public static void printConnect(final Context context, final String mBluetoothName) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                try {
//                    if (mBluetoothAdapter.isDiscovering()) {
//                        mBluetoothAdapter.cancelDiscovery();
//                    }
//
//                    if (list_device_name.size() > 0) {
////                        for (int i = 0;i<list_device_name.size();i++){
////                            if ( list_device_name.get(i).equals(mBluetoothName)){
//                        mDevice = mBluetoothAdapter.getRemoteDevice(map_bluedevice.get(list_device_name.get(0)));
//                        mBluetoothSocket = mDevice.createRfcommSocketToServiceRecord(BLUETOOTH_UUID);
//                        if (mBluetoothSocket != null) {
//                            mBluetoothSocket.connect();
//                        }
//                        mEditor.putString("address", map_bluedevice.get(list_device_name.get(0)));
//                        mEditor.commit();
////                    mBluetoothName = list_device_name.get(i);
////                                ToastUtils.showToast(context, "蓝牙连接成功");
//                        com.blankj.utilcode.util.ToastUtils.showShort("蓝牙连接成功");
////                                break;
////                            }else if (i == list_device_name.size()-1){
////                                ToastUtils.showToast(context, "设置的蓝牙名称不存在，请到后台更新打印设置");
////                            }
////                        }
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    mBluetoothSocket = null;
//                    mDevice = null;
////                    ToastUtils.showToast(context, "蓝牙连接失败");
//                    com.blankj.utilcode.util.ToastUtils.showShort("蓝牙连接失败");
//
//                }
//                Looper.loop();// 进入loop中的循环，查看消息队列
//            }
//        }).start();
//    }

//    private Runnable mRunnable = new Runnable() {
//        @SuppressLint("WrongConstant")
//        @Override
//        public void run() {
//            for (int i = 1; i <= recepits_num; i++) {
//                try {
//                    mOutputStream = mBluetoothSocket.getOutputStream();
//                    mOutputStream.write(mData, 0, mData.length);
//                    mOutputStream.flush();
//                    Thread.sleep(3000);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    };

    /**
     * 发送数据
     */
//    @SuppressLint("WrongConstant")
//    public void send(byte[] data, int recepits_num, SharedPreferences preferences) {
//        if (recepits_num == 0) {
//            this.recepits_num = 0;
//        } else {
//            this.recepits_num = recepits_num;
//        }
//
//        try {
//            if (preferences == null || preferences.getString("address", "").equals("")) {
//                return;
//            }
//            mDevice = mBluetoothAdapter.getRemoteDevice(preferences.getString("address", ""));
//            mBluetoothSocket = mDevice.createRfcommSocketToServiceRecord(BLUETOOTH_UUID);
//            mBluetoothSocket.connect();
//            mData = data;
//            new Thread(mRunnable).start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//            //            CustomToast.makeText(BlueToothActivity.this, "连接异常", Toast.LENGTH_SHORT).show();
//        }
//    }

//    private final BroadcastReceiver receiver = new BroadcastReceiver() {
//        @SuppressLint("WrongConstant")
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//
//            if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
//                Log.d(TAG, "ACTION_ACL_CONNECTED: ");
//                mBluetoothAdapter.getState();
//            }
//
//            if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
//                Log.d(TAG, "ACTION_BOND_STATE_CHANGED: ");
//            }
//
//            if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
//                Log.d(TAG, "ACTION_ACL_DISCONNECTED: ");
//            }
//
//            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//                Log.i(TAG, "onReceive: 蓝牙扫描结束");
//                ac.unregisterReceiver(receiver);//注销广播
//                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//
//                //判断该device的状态是否是已绑定的设备
//                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
//                    list_device_name.clear();
//
//                    map_bluedevice.put(device.getName(), device.getAddress());
//
//                    Set<String> key = map_bluedevice.keySet();
//                    Iterator<String> device_name = key.iterator();
//                    while (device_name.hasNext()) {
//                        list_device_name.add(device_name.next());
//                    }
//                    if (list_device_name.get(0) == null) {
//                        list_device_name.remove(0);
//
//                    }
//                    list_bluedevice.add(map_bluedevice);
//                    mBluetoothAdapter.cancelDiscovery();
//
//                    MyApplication.mPrintList = list_device_name;
////                    printConnect(ac,list_device_name.get(0));
//                }
//            }
//        }
//    };
    private void initData() {

        getproductmodel();
        obtainShopClass();
        obtainSystemCanshu();
        GetPrintSet.getPrintSet();
        setCbShortMessage("011");

        loginBean = (LoginBean) getIntent().getSerializableExtra("loginBean");
        MyApplication.loginBean = loginBean;

        PreferenceHelper.write(ac, "yunshangpu", "vip", false);
//        mGson = new Gson();
//        mClassMsgList = null;//清空分类


        //更新订单时间
        new TimeThread().start();

        order = CreateOrder.createOrder("SP");
        tv_ordernum.setText(order);

        GoodsTypeList.add("20");
        GoodsTypeList.add("50");
        GoodsTypeList.add("100");

        mSpinnerAdapter = new ArrayAdapter<String>(HomeActivity.this,
                R.layout.item_spinner, R.id.tv_item_spinner, GoodsTypeList);
        spGoodsOrderNum.setAdapter(mSpinnerAdapter);
        spGoodsOrderNum.setSelection(0);
        if (loginBean != null) {
            mSmGid = loginBean.getData().getShopID();
//            if (loginBean.getData().getAgents().getAG_LogoUrl() != null) {
//                VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(loginBean.getData().getShopList().get(0).getSM_Picture()).toString()), ivShop, R.drawable.defalut_store);
//
//            }
            if (loginBean.getData().getUM_ChatHead() != null) {
                VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(loginBean.getData().getUM_ChatHead()).toString()), imgHedimg, R.mipmap.member_head_nohead);
            }
            tvStoreName.setText(loginBean.getData().getUM_Name());
        }
    }

    public static void setTotal(int pageTotal, int Count) {
        totalPage = pageTotal;
        totalCount = Count;
    }

    @Override
    public void setOnItemClick(View v) {

        switch (v.getId()) {

            case R.id.tv_change_pwd:
                if (loginBean != null) {
                    mShowMemberPop.dismiss();
                    ChangePwdDialog.numchangeDialog(ac, 1);
                } else {
//                    ToastUtils.showToast(ac, "未获取到登录信息");
                    com.blankj.utilcode.util.ToastUtils.showShort("未获取到登录信息");
                }
                break;
            case R.id.tv_sigin_out:

                NoticeDialog.noticeDialog(ac, "系统提示信息", "是否退出当前账户", 1, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        //退出
//                        dialog.show();
                        ImpOutLogin outLogin = new ImpOutLogin();
                        outLogin.outLogin(ac, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                mShowMemberPop.dismiss();
                                dialog.dismiss();
                                Intent intent = new Intent(ac, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {
                                dialog.dismiss();
                            }
                        });
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });

                break;

            //跳转后台修改头像
            case R.id.tv_change_head:
                mShowMemberPop.dismiss();
                showWebDialog("修改头像", "/WebUI/Shop/SUserEditChatHead.html", width / 2, height * 7 / 10);
                break;

            //跳转后台修改账户名
            case R.id.tv_store_name_set:
                mShowMemberPop.dismiss();
                showWebDialog("编辑用户信息", "/WebUI/Shop/SUserAdd.html", width / 2, 600);

                break;
            //跳转后台显示店铺信息
            case R.id.show_shop_info:
                mShowStorePop.dismiss();
                showWebDialog("店铺编辑", "/WebUI/Shop/ShopEdit.html", width * 3 / 5, height * 4 / 5);

                break;

        }

    }


    public class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    long sysTime = System.currentTimeMillis();
                    CharSequence ordertime2 = DateFormat
                            .format("MM/dd  HH:mm:ss", sysTime);
                    ordertime = DateFormat
                            .format("yyyy-MM-dd HH:mm:ss", sysTime);
                    tv_ordertime.setText("" + ordertime2);
                    break;
                default:
                    break;
            }
        }
    };


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

    private void obtainSystemCanshu() {
        ImpSystemCanshu systemCanshu = new ImpSystemCanshu();
        systemCanshu.systemCanshu(ac, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                List<PayTypeMsg> sllist = (List<PayTypeMsg>) response;
                handleSystemc(sllist);
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });
    }

    /**
     * @param code ,参照SmsSwitch实体类的值
     *             根据短信发送开关是否打开，设置checkbox
     */
    private void setCbShortMessage(String code) {
        try {
            SmsSwitch.DataBean smsSwitch = YSLUtils.getSmsSwitch(code);
            if (smsSwitch != null) {
                if (smsSwitch.getST_State() == null || !smsSwitch.getST_State().equals("1")) {
                    cbMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(HomeActivity.this, "发送短信未开启，请到PC端去开启", Toast.LENGTH_SHORT).show();
                            cbMessage.setChecked(false);
                        }
                    });
                } else {
                    cbMessage.setChecked(true);
                }
            } else {
                getSmsSet(code);
            }
        } catch (Exception e) {
            cbMessage.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 获取短信开关
     */
    private void getSmsSet(final String code) {
        HttpHelper.post(HomeActivity.this, HttpAPI.API().SMS_LIST, new CallBack() {
            @Override
            public void onSuccess(String responseString, Gson gson) {
                SmsSwitch bean = CommonFun.JsonToObj(responseString, SmsSwitch.class);
                for (int i = 0; i < bean.getData().size(); i++) {
                    if (bean.getData().get(i).getST_Code().equals(code)) {
                        if (bean.getData().get(i).getST_State() == null || !bean.getData().get(i).getST_State().equals("1")) {
                            cbMessage.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(HomeActivity.this, "发送短信未开启，请到PC端去开启", Toast.LENGTH_SHORT).show();
                                    cbMessage.setChecked(false);
                                }
                            });
                        } else {
                            cbMessage.setChecked(true);
                        }
                    }
                }
                CacheData.saveObject("shortmessage", bean);//缓存短信开关到本地
            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }

    private void handleSystemc(List<PayTypeMsg> sllist) {
        for (PayTypeMsg p : sllist) {
            switch (p.getSS_Name()) {
                case "默认支付":
                    moren = p;
//                    paytypelist.add(p);
                    break;
                case "现金支付":
                    paytypelist.add(p);
                    break;
                case "余额支付":
                    paytypelist.add(p);
                    break;
                case "银联支付":
                    paytypelist.add(p);
                    break;
                case "微信记账":
                    paytypelist.add(p);
                    break;
                case "支付宝记账":
                    paytypelist.add(p);
                    break;
                case "优惠券":
                    paytypelist.add(p);
                    break;
                case "积分支付":
                    paytypelist.add(p);
                    jifendkbfb = p.getSS_Value();
                    break;
                case "扫码支付":
                    paytypelist.add(p);
                    break;
                case "其他支付":
                    paytypelist.add(p);
                    break;
                case "积分支付限制":
                    paytypelist.add(p);
                    jinfenzfxzbfb = p.getSS_Value();
                    break;
                case "禁止0库存销售":
                    if (p.getSS_State() == 1) {
                        isZeroStock = true;
                    } else {
                        isZeroStock = false;
                    }
                    break;
            }
            if (p.getSS_Code() == 601) {
                //商品数据修改
                mModifyPrice = p.getSS_State();
            } else if (p.getSS_Code() == 900) {
                //修改单价
                mChangePrice = p.getSS_State();
            } else if (p.getSS_Code() == 901) {
                //修改折扣
                mChangeDiscount = p.getSS_State();
            } else if (p.getSS_Code() == 902) {
                //修改小计
                mChangeSubtotal = p.getSS_State();
            }
        }

    }

    private void setMorenPay(PayTypeMsg msg) {
        switch (msg.getSS_Value()) {
            case "XJZF":

                break;
            case "YEZF":
                break;
            case "YLZF":
                break;
            case "WXJZ":
                break;
            case "ZFBJZ":
                break;
            case "YHQ":
                break;
            case "JFZF":
                break;
            case "SMZF":
                break;
            case "QTZF":
                break;
        }
    }

    private void jisuanAllPrice() {

        if (mVipDengjiMsg != null) {
            //商品积分计算
            for (int k = 0; k < mShopLeftList.size(); k++) {
                if (mShopLeftList.get(k).getPM_IsPoint() == 0 || mShopLeftList.get(k).getPM_IsPoint() == 3) {//0没有设置积分规则，3本商品不计分
                    mShopLeftList.get(k).setEachPoint(0);
                } else if (mShopLeftList.get(k).getPM_IsPoint() == 2) {//本商品按固定积分
                    mShopLeftList.get(k).setEachPoint(mShopLeftList.get(k).getPM_FixedIntegralValue());
                } else if (mShopLeftList.get(k).getPM_IsPoint() == 1) {//本商品按等级积分
                    if (mVipDengjiMsg.getData().get(0).getVG_IsIntegral() == 0) {//会员等级积分开关没有有打开
                        mShopLeftList.get(k).setEachPoint(0);
                    } else if (mVipDengjiMsg.getData().get(0).getVG_IsIntegral() == 1) {
                        for (int m = 0; m < mVipDengjiMsg.getData().get(0).getVGInfo().size(); m++) {//所选商品种类的数量，不等于所选商品数量；
//                                            for (int n = 0; n < mShopLeftList.size(); n++) {
                            if (mVipDengjiMsg.getData().get(0).getVGInfo().get(m).getPT_GID().equals(mShopLeftList.get(k).getPT_ID())) {
                                double bl = mVipDengjiMsg.getData().get(0).getVGInfo().get(m).getVS_CMoney();
                                if (bl != 0) {
                                    if (mShopLeftList.get(k).getPM_MemPrice() != null) {
                                        double memprice = Double.parseDouble(mShopLeftList.get(k).getPM_MemPrice());
                                        if (memprice < mShopLeftList.get(k).getJisuanPrice() * mShopLeftList.get(k).getPD_Discount()) {
//                                                            double fb = YSLUtils.siOutFiveIn(memprice / bl);
                                            double fb = memprice / bl;
                                            mShopLeftList.get(k).setEachPoint(fb);
                                        } else {
                                            double fb = mShopLeftList.get(k).getJisuanPrice() * mShopLeftList.get(k).getPD_Discount() / bl;
                                            mShopLeftList.get(k).setEachPoint(fb);
                                        }
                                    } else {
                                        double fb = mShopLeftList.get(k).getJisuanPrice() * mShopLeftList.get(k).getPD_Discount() / bl;
                                        mShopLeftList.get(k).setEachPoint(fb);
                                    }
                                }
                            }
//                                            }
                        }
                    }
                }
            }
        }

//        goodOrdeLists.clear();
        if (PreferenceHelper.readBoolean(ac, "yunshangpu", "vip", false)) {
            double allprice = 0;
            double onepoint = 0;
            for (int i = 0; i < mShopLeftList.size(); i++) {
                ShopMsg ts = mShopLeftList.get(i);
                double xiaoji = Double.parseDouble(CommonUtils.multiply(CommonUtils.multiply
                        (NullUtils.noNullHandle(ts.getJisuanPrice()).toString(), ts.getNum() + ""), ts.getPD_Discount() + ""));
                allprice = allprice + xiaoji;
                onepoint += mShopLeftList.get(i).getEachPoint() * mShopLeftList.get(i).getNum();


                int type = 0;
                switch (NullUtils.noNullHandle(ts.getPM_IsService()).toString()) {
                    case "0":
                        type = 0;
                        break;
                    case "1":
                        type = 0;
                        break;
                    case "2":
                        type = 0;
                        break;
                    case "3":
                        type = 1;
                        break;
                    case "4":
                        type = 1;
                        break;
                }
                mShopLeftList.get(i).setType(type);
                mShopLeftList.get(i).setAllprice(xiaoji);
            }

            mPoint = Double.parseDouble(StringUtil.twoNum(onepoint + ""));
            allmoney = StringUtil.twoNum(allprice + "");
            mTvHeji.setText("￥ " + allmoney);
            tvGetIntegral.setText(mPoint + "");


        } else {
            double allprice = 0;
            for (int i = 0; i < mShopLeftList.size(); i++) {
                ShopMsg ts = mShopLeftList.get(i);
                double xiaoji = Double.parseDouble(CommonUtils.multiply(CommonUtils.multiply
                        (NullUtils.noNullHandle(ts.getJisuanPrice()).toString(), ts.getNum() + ""), ts.getPD_Discount() + ""));
                allprice = allprice + xiaoji;

                int type = 0;
                switch (NullUtils.noNullHandle(ts.getPM_IsService()).toString()) {
                    case "0":
                        type = 0;
                        break;
                    case "1":
                        type = 0;
                        break;
                    case "2":
                        type = 0;
                        break;
                    case "3":
                        type = 1;
                        break;
                    case "4":
                        type = 1;
                        break;
                }

                mShopLeftList.get(i).setType(type);
                mShopLeftList.get(i).setAllprice(xiaoji);
            }
            allmoney = StringUtil.twoNum(allprice + "");
            mTvHeji.setText("￥" + allmoney);
            tvGetIntegral.setText("0");
        }
        mShopLeftAdapter.notifyDataSetChanged();
    }


    private void initEvent() {
        mEtLoginAccount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    dialog.show();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); //得到InputMethodManager的实例
                    if (imm.isActive()) {//如果开启
                        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);//关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
                    }
                    PageIndex = 1;
                    obtainHomeShop("", mEtLoginAccount.getText().toString());

                }
                return false;
            }
        });

        rlOut.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                mShowMemberPop = new ShowMemberPopWindow(HomeActivity.this, loginBean);
                mShowMemberPop.setOnItemClickListener(HomeActivity.this);
                mShowMemberPop.showAsDropDown(HomeActivity.this.findViewById(R.id.rl_out), -10, 0);

            }
        });

        btnHomePrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YSLUtils.isFastClick()) {
                    Intent intents = new Intent(ac, PrintSetActivity.class);
                    startActivity(intents);
                }
            }
        });

//        ivShop.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View view) {
//                ImpShopInfo impShopInfo = new ImpShopInfo();
//                impShopInfo.shopInfo(ac, new InterfaceBack() {
//                    @Override
//                    public void onResponse(Object response) {
//                        ShopInfoBean shopInfoBean = mGson.fromJson(response.toString(), ShopInfoBean.class);
//
//                        mShowStorePop = new ShowStorePopWindow(HomeActivity.this, shopInfoBean);
//                        mShowStorePop.setOnItemStoreClickListener(HomeActivity.this);
//                        mShowStorePop.showAsDropDown(HomeActivity.this.findViewById(R.id.iv_shop), 50, -20);
//                    }
//
//                    @Override
//                    public void onErrorResponse(Object msg) {
//
//                    }
//                });
//            }
//        });

        ivSearch.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                KeyboardDialog.numchangeDialog(HomeActivity.this, "商品搜索", mEtLoginAccount.getText().toString(), null, 1, new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        String search = (String) response;
                        obtainHomeShop("", search + "");
                        mEtLoginAccount.setText("");
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
            }
        });


        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ShopMsg shopMsg = (ShopMsg) parent.getItemAtPosition(position);

                if (shopMsg.getStock_Number() <= 0 && isZeroStock && shopMsg.getPM_IsService() == 0) {
//                    ToastUtils.showToast(ac, "当前库存不足");
                    com.blankj.utilcode.util.ToastUtils.showShort("当前库存不足");
                    return;
                }
                double addnum = 1;
                if (isZeroStock && shopMsg.getPM_IsService() == 0) {//禁止0库存销售的普通商品
                    if (shopMsg.getStock_Number() - 1 >= 0) { //库存大于等于1
//                        shopMsg.setCurrtStock_Number(shopMsg.getCurrtStock_Number() - 1);
                        addnum = 1;
                    } else {//库存大于0小于1
//                        shopMsg.setCurrtStock_Number(0);
                        addnum = shopMsg.getStock_Number();
                    }
                } else {
//                    shopMsg.setCurrtStock_Number(shopMsg.getCurrtStock_Number() - 1);
                    addnum = 1;
                }

                if (shopMsg.getPM_GroupGID() != null && !shopMsg.getPM_GroupGID().equals("")) {
                    ImpGroupGoodsList impGroupGoodsList = new ImpGroupGoodsList();
                    final double finalAddnum = addnum;
                    impGroupGoodsList.getGroupGoodsList(ac, shopMsg.getPM_GroupGID(), new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            List<ShopMsg> sllist = (List<ShopMsg>) response;
                            if (sllist.size() == 1) {
                                double num = 0;
                                int pos = 0;

                                for (int j = 0; j < mShopLeftList.size(); j++) {
                                    if (sllist.get(0).getGID().equals(mShopLeftList.get(j).getGID()) && !mShopLeftList.get(j).isIsgive()) {
                                        num = mShopLeftList.get(j).getNum();
                                        pos = j;
                                    }
                                }

                                sllist.get(0).setNum(num + finalAddnum);
                                if (num == 0) {
                                    sllist.get(0).setCheck(false);
                                    mShopLeftList.add(0, sllist.get(0));
                                    if (leftpos != -1) {
                                        leftpos += 1;
                                    }
                                    jisuanShopjisuanPrice(mPD_Discount, mShopLeftList);
                                    if (mShopLeftList.size() > 0) {
                                        bttGetOrder.setText("挂单");
                                    } else {
                                        bttGetOrder.setText("取单");
                                    }
                                } else {
                                    mShopLeftList.get(pos).setNum(num + finalAddnum);
                                    jisuanAllPrice();
                                }
                                for (int i = 0; i < mShopLeftList.size(); i++) {
                                    if (sllist.get(0).getGID().equals(mShopLeftList.get(i).getGID()) && !mShopLeftList.get(i).isIsgive()) {
                                        mShopLeftList.get(i).setCheck(true);
                                        leftpos = i;
                                    } else {
                                        mShopLeftList.get(i).setCheck(false);
                                    }
                                }
                                mShopRightAdapter.notifyDataSetChanged();
                                mShopLeftAdapter.notifyDataSetChanged();

                            } else {
                                if (ModelList != null) {
                                    //初始化
                                    for (int i = 0; i < ModelList.size(); i++) {
                                        ModelList.get(i).setChecked(false);
                                        ModelList.get(i).setEnable(false);
                                    }
                                    //将商品有的规格设置成可点击
                                    for (int i = 0; i < sllist.size(); i++) {
                                        if (sllist.get(i).getPM_Modle() != null && !sllist.get(i).getPM_Modle().equals("")) {
                                            List<String> list = SignUtils.getStringForlist(sllist.get(i).getPM_Modle());
                                            for (int j = 0; j < list.size(); j++) {
                                                for (int k = 0; k < ModelList.size(); k++) {
                                                    if (list.get(j).equals(ModelList.get(k).getPM_Properties())) {
                                                        ModelList.get(k).setEnable(true);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    modelList.clear();

                                    //组装规格数据
                                    if (ModelList != null && ModelList.size() > 1) {
                                        for (int i = 0; i < ModelList.size(); i++) {
                                            if (ModelList.get(i).getPM_Type() == 0) {
                                                List<GoodsModelBean> list = new ArrayList<>();
                                                list.add(ModelList.get(i));
                                                modelList.add(list);
                                            } else {
                                                for (int j = 0; j < modelList.size(); j++) {
                                                    if (modelList.get(j).get(0).getPM_Name().equals(ModelList.get(i).getPM_Name())) {
                                                        modelList.get(j).add(ModelList.get(i));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    //设置第一个默认选中
                                    for (int i = 0; i < modelList.size(); i++) {
                                        int num = 0;
                                        for (int j = 0; j < modelList.get(i).size(); j++) {
                                            if (modelList.get(i).get(j).isEnable() && modelList.get(i).get(j).getPM_Type() != 0) {
                                                modelList.get(i).get(j).setChecked(true);
                                                num++;
                                                break;
                                            }
                                        }
                                        if (num == 0) {
                                            modelList.remove(i);
                                            i--;
                                        } else {
                                            modelList.get(i).remove(0);
                                        }
                                    }

                                    GoodsModelDialog.goodsModelDialog(ac, 1, modelList, sllist, isZeroStock, new InterfaceBack() {
                                        @Override
                                        public void onResponse(Object response) {
                                            ShopMsg goodsitem = (ShopMsg) response;

                                            double num = 0;
                                            int pos = 0;
                                            for (int j = 0; j < mShopLeftList.size(); j++) {
                                                if (goodsitem.getGID().equals(mShopLeftList.get(j).getGID())) {
                                                    num = mShopLeftList.get(j).getNum();
                                                    pos = j;
                                                }
                                            }

                                            goodsitem.setNum(num + finalAddnum);
                                            if (num == 0) {
                                                goodsitem.setCheck(false);
                                                mShopLeftList.add(0, goodsitem);
                                                if (leftpos != -1) {
                                                    leftpos += 1;
                                                }
                                                jisuanShopjisuanPrice(mPD_Discount, mShopLeftList);
                                                if (mShopLeftList.size() > 0) {
                                                    bttGetOrder.setText("挂单");
                                                } else {
                                                    bttGetOrder.setText("取单");
                                                }
                                            } else {
                                                mShopLeftList.get(pos).setNum(num + finalAddnum);
                                                jisuanAllPrice();
                                            }
                                            for (int i = 0; i < mShopLeftList.size(); i++) {
                                                if (goodsitem.getGID().equals(mShopLeftList.get(i).getGID())) {
                                                    mShopLeftList.get(i).setCheck(true);
                                                    leftpos = i;
                                                } else {
                                                    mShopLeftList.get(i).setCheck(false);
                                                }
                                            }
                                            mShopRightAdapter.notifyDataSetChanged();
                                            mShopLeftAdapter.notifyDataSetChanged();

                                        }

                                        @Override
                                        public void onErrorResponse(Object msg) {

                                        }
                                    });

                                } else {
//                                    ToastUtils.showToast(ac, "没有获取到规格列表，请稍后再尝试");
                                    com.blankj.utilcode.util.ToastUtils.showShort("没有获取到规格列表，请稍后再尝试");
                                    getproductmodel();
                                }
                            }
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                } else {
                    double num = 0;
                    int pos = 0;

                    for (int j = 0; j < mShopLeftList.size(); j++) {
                        if (shopMsg.getGID().equals(mShopLeftList.get(j).getGID()) && !mShopLeftList.get(j).isIsgive()) {
                            num = mShopLeftList.get(j).getNum();
                            pos = j;
//                        return;
                        }
//                    mShopLeftList.get(j).setCheck(false);
                    }
//                shopMsg.setCheck(true);
                    shopMsg.setNum(num + addnum);
                    if (num == 0) {
                        shopMsg.setCheck(false);
                        mShopLeftList.add(0, shopMsg);
                        if (leftpos != -1) {
                            leftpos += 1;
                        }
                        jisuanShopjisuanPrice(mPD_Discount, mShopLeftList);
                        if (mShopLeftList.size() > 0) {
                            bttGetOrder.setText("挂单");
                        } else {
                            bttGetOrder.setText("取单");
                        }
                    } else {
                        mShopLeftList.get(pos).setNum(num + addnum);
                        jisuanAllPrice();
                    }
                    for (int i = 0; i < mShopLeftList.size(); i++) {
                        if (shopMsg.getGID().equals(mShopLeftList.get(i).getGID()) && !mShopLeftList.get(i).isIsgive()) {
                            mShopLeftList.get(i).setCheck(true);
                            leftpos = i;
                        } else {
                            mShopLeftList.get(i).setCheck(false);
                        }
                    }
                    mShopRightAdapter.notifyDataSetChanged();
                    mShopLeftAdapter.notifyDataSetChanged();
                }

            }

        });

        //刷新或加载更多
        mRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                obtainShopClass();
                obtainHomeShop("", mEtLoginAccount.getText().toString());
                mRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onLoad() {
            }

            @Override
            public boolean canLoadMore() {
                return false;
            }

            @Override
            public boolean canRefresh() {
                return true;
            }
        });


        mRlClear.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                //库存显示设置
//                for (int j = 0; j < mShopMsgList.size(); j++) {
//                    mShopMsgList.get(j).setCurrtStock_Number(mShopMsgList.get(j).getStock_Number());
//                }
                mShopRightAdapter.notifyDataSetChanged();
                //清空
                mShopLeftList.clear();
                mShopLeftAdapter.notifyDataSetChanged();
                order = CreateOrder.createOrder("SP");
                tv_ordernum.setText(order);
                mTvHeji.setText("￥0.00");
                tvGetIntegral.setText("0");
                leftpos = -1;
                if (mShopLeftList.size() > 0) {
                    bttGetOrder.setText("挂单");
                } else {
                    bttGetOrder.setText("取单");
                }

//                mTvShoukuan.setText("收 款  ￥ 0.00");
            }
        });


        tvShoukuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() > 0) {
//                    dialog.show();
                    ImpSubmitOrder submitOrder = new ImpSubmitOrder();
                    submitOrder.submitOrder(ac, order, ordertime.toString(), null == mVipDengjiMsg ? "00000" : mVipDengjiMsg.getData().get(0).getVCH_Card(), mShopLeftList, false, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            dialog.dismiss();
                            OrderCanshhu jso = (OrderCanshhu) response;
//                                可抵扣金额= 会员积分/积分抵扣百分比 *积分支付限制百分比
                            String yue = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableBalance() + "";
                            String jifen = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableIntegral() + "";
                            double s = CommonUtils.div(Double.parseDouble(CommonUtils.multiply(jifen, jinfenzfxzbfb)), 100, 2);
                            boolean ismember = null == mVipMsg ? false : true;
                            double dkmoney = CommonUtils.div(s, Double.parseDouble(jifendkbfb), 2);//可抵扣金额
                            shortMessage = cbMessage.isChecked();
                            final JiesuanBDialog jiesuanBDialog = new JiesuanBDialog(HomeActivity.this, allmoney, yue, jifen, mVipDengjiMsg == null ? null : mVipDengjiMsg.getData().get(0), dkmoney + "", ismember, jso.getGID(),
                                    jso.getCO_Type(), jso.getCO_OrderCode(), mShopLeftList, moren, paytypelist, false, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    String gid = (String) response;
//                                    ToastUtils.showToast(ac, "结算成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("结算成功");

                                    //打印小票
                                    if (MyApplication.PRINT_IS_OPEN) {
                                        if (MyApplication.mGoodsConsumeMap.isEmpty()) {
                                            GetPrintSet.getPrintParamSet();
                                        }
                                        new HttpGetPrintContents().SPXF(ac, gid);
                                    }

                                    if (ISLABELCONNECT && LABELPRINT_IS_OPEN) {
                                        for (int i = 0; i < mShopLeftList.size(); i++) {
                                            labelPrint(mShopLeftList.get(i));
                                        }
                                    }

                                    mShopLeftList.clear();
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    order = CreateOrder.createOrder("SP");
                                    tv_ordernum.setText(order);
                                    mVipMsg = null;
                                    mVipDengjiMsg = null;
                                    PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                                    VolleyResponse.instance().getInternetImg(ac, "", mIvViptx, R.mipmap.member_head_nohead);
                                    deletVip.setVisibility(View.GONE);
                                    mRlVip.setVisibility(View.VISIBLE);
                                    vipMessage.setVisibility(View.GONE);
                                    mTvVipname.setText("散客");
                                    tvBlance.setText("0.00");
                                    tvIntegral.setText("0");
                                    mTvHeji.setText("￥0.00");
                                    tvGetIntegral.setText("0");
//                                    mTvShoukuan.setText("收 款  ￥ 0.00");


                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                }
                            });
                            jiesuanBDialog.show();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            dialog.dismiss();
                        }
                    });
                } else {
//                    ToastUtils.showToast(ac, "请选择商品");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });

        mRlVip.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                VipChooseDialog vipChooseDialog = new VipChooseDialog(HomeActivity.this, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        mVipMsg = (VipDengjiMsg.DataBean) response;

                        VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(mVipMsg.getVIP_HeadImg()).toString()), mIvViptx, R.mipmap.member_head_nohead);
                        mTvVipname.setText(NullUtils.noNullHandle(mVipMsg.getVIP_Name()).toString());
                        vipMessage.setVisibility(View.VISIBLE);
                        tvBlance.setText(StringUtil.twoNum(NullUtils.noNullHandle(mVipMsg.getMA_AvailableBalance()).toString()));
                        tvIntegral.setText(Double.parseDouble(NullUtils.noNullHandle(mVipMsg.getMA_AvailableIntegral()).toString()) + "");
                        mRlVip.setVisibility(View.GONE);
                        deletVip.setVisibility(View.VISIBLE);
                        PreferenceHelper.write(ac, "yunshangpu", "vip", true);


                        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
                        onlyVipMsg.vipMsg(ac, mVipMsg.getVCH_Card(), new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {
                                mVipDengjiMsg = (VipDengjiMsg) response;
                                mPD_Discount = obtainVipPD_Discount(mVipMsg.getVG_GID(), mVipDengjiMsg.getData().get(0).getVGInfo());
                                jisuanShopjisuanPrice(mPD_Discount, mShopLeftList);
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                    }

                    @Override
                    public void onErrorResponse(Object msg) {

                    }
                });
                vipChooseDialog.show();

//                VipDialog.languageChoseDialog(HomeActivity.this, 1, vipList, new InterfaceBack() {
//                    @Override
//                    public void onResponse(Object response) {
//
//
//                    }
//
//                    @Override
//                    public void onErrorResponse(Object msg) {
//
//                    }
//                });
            }
        });
        //删除会员
        deletVip.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                deletVip.setVisibility(View.GONE);
                mRlVip.setVisibility(View.VISIBLE);
                vipMessage.setVisibility(View.GONE);
                mTvVipname.setText("散客");
                mVipMsg = null;
                mVipDengjiMsg = null;
                PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                tvBlance.setText("0.00");
                tvIntegral.setText("0");
                Glide.with(ac).load(R.mipmap.member_head_nohead).into(mIvViptx);
                if (mShopLeftList.size() > 0) {
                    for (int i = 0; i < mShopLeftList.size(); i++) {
                        if (mShopLeftList.get(i).isHasvipDiscount()) {
                            mShopLeftList.get(i).setHasvipDiscount(false);
                            mShopLeftList.get(i).setPD_Discount(1);
                            mShopLeftList.get(i).setJisuanPrice(mShopLeftList.get(i).getPM_UnitPrice());
                        }
                    }
                    jisuanAllPrice();
                    mShopLeftAdapter.notifyDataSetChanged();
                }
            }
        });

        //改单价
        bttPriceExchange.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mModifyPrice == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改单价 后再操作");
                    return;
                } else {
                    if (mChangePrice == 0) {
                        com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改单价 后再操作");
                        return;
                    }
                }
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        if (NullUtils.noNullHandle(mShopLeftList.get(leftpos).getPM_IsService()).toString().equals("3")) {
//                            ToastUtils.showToast(HomeActivity.this, "套餐不能修改单价");
                            com.blankj.utilcode.util.ToastUtils.showShort("套餐不能修改单价");
                        } else {
                            KeyboardDialog.numchangeDialog(HomeActivity.this, "改单价", mShopLeftList.get(leftpos).getJisuanPrice() + "", null, 1, new InterfaceBack() {

                                @Override
                                public void onResponse(Object response) {

                                    double price = Double.parseDouble((String) response);
                                    mShopLeftList.get(leftpos).setIschanged(true);
                                    if (mShopLeftList.get(leftpos).getPM_IsDiscount() == 1 && mShopLeftList.get(leftpos).getPM_SpecialOfferMoney() != -1) {
                                        mShopLeftList.get(leftpos).setPD_Discount(mShopLeftList.get(leftpos).getPM_SpecialOfferMoney() / price);
                                        mShopLeftList.get(leftpos).setJisuanPrice(price);
                                    } else {
                                        mShopLeftList.get(leftpos).setJisuanPrice(price);
                                    }
//                                    if (price>mShopLeftList.get(leftpos).getJisuanPrice()*mShopLeftList.get(leftpos).getPD_Discount()){
//
//                                        mShopLeftList.get(leftpos).setPD_Discount(Double.parseDouble(CommonUtils.multiply
//                                                (mShopLeftList.get(leftpos).getJisuanPrice()+"",mShopLeftList.get(leftpos).getPD_Discount()+""))/price);
//                                        mShopLeftList.get(leftpos).setJisuanPrice(price);
//                                    }else {
//                                        mShopLeftList.get(leftpos).setPD_Discount(1);
//                                        mShopLeftList.get(leftpos).setJisuanPrice(price);
//                                    }
                                    mShopLeftList.get(leftpos).setPM_UnitPrice(price);
//                                    mShopLeftList.get(leftpos).setJisuanPrice(price);
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    jisuanAllPrice();

                                }

                                @Override
                                public void onErrorResponse(Object msg) {

                                }
                            });
                        }
                        setButtonGreen(R.id.btt_price_exchange);
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }


            }
        });


        //改折扣
        bttDicountExchange.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mModifyPrice == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改折扣 后再操作");
                    return;
                } else {
                    if (mChangeDiscount == 0) {
                        com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改折扣 后再操作");
                        return;
                    }
                }
                setButtonGreen(R.id.btt_dicount_exchange);
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        if (!mShopLeftList.get(leftpos).isIsgive()) {
                            KeyboardDialog.numchangeDialog(HomeActivity.this, "改折扣", mShopLeftList.get(leftpos).getPD_Discount() + "", null, 1, new InterfaceBack() {

                                @Override
                                public void onResponse(Object response) {
                                    double discount = Double.parseDouble((String) response);
                                    mShopLeftList.get(leftpos).setIschanged(true);
                                    mShopLeftList.get(leftpos).setPD_Discount(discount);
//                                    mShopLeftList.get(leftpos).setJisuanPrice(Double.parseDouble(CommonUtils.multiply(mShopLeftList.get(leftpos).getJisuanPrice() + "", discount + "")));
                                    double xiaoji = Double.parseDouble(
                                            CommonUtils.multiply(NullUtils.noNullHandle(mShopLeftList.get(leftpos).getJisuanPrice() * discount).toString(), mShopLeftList.get(leftpos).getNum() + ""));
                                    mShopLeftList.get(leftpos).setAllprice(xiaoji);
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    jisuanAllPrice();
                                }

                                @Override
                                public void onErrorResponse(Object msg) {

                                }
                            });
                        } else {
//                            ToastUtils.showToast(HomeActivity.this, "赠送商品不能改折扣");
                            com.blankj.utilcode.util.ToastUtils.showShort("赠送商品不能改折扣");
                        }
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }

            }
        });

        //改小计
        bttMoneyExchange.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mModifyPrice == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改小计 后再操作");
                    return;
                } else {
                    if (mChangeSubtotal == 0) {
                        com.blankj.utilcode.util.ToastUtils.showShort("请开启 商品消费改小计 后再操作");
                        return;
                    }
                }
                setButtonGreen(R.id.btt_money_exchange);
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        if (!mShopLeftList.get(leftpos).isIsgive()) {
                            KeyboardDialog.numchangeDialog(HomeActivity.this, "改小计",
                                    CommonUtils.multiply(NullUtils.noNullHandle(mShopLeftList.get(leftpos).getJisuanPrice() * mShopLeftList.get(leftpos).getPD_Discount()).toString(), NullUtils.noNullHandle(mShopLeftList.get(leftpos).getNum()).toString()),
                                    null, 1, new InterfaceBack() {

                                        @Override
                                        public void onResponse(Object response) {
                                            double price = Double.parseDouble((String) response);
                                            double dicount = price / (mShopLeftList.get(leftpos).getNum() * mShopLeftList.get(leftpos).getJisuanPrice());
                                            if (0 <= dicount && dicount < 1) {
                                                mShopLeftList.get(leftpos).setIschanged(true);

                                                mShopLeftList.get(leftpos).setPD_Discount(dicount);
//                                            mShopLeftList.get(leftpos).setJisuanPrice(Double.parseDouble(CommonUtils.multiply(mShopLeftList.get(leftpos).getPM_UnitPrice() + "", dicount + "")));

//                                            double xiaoji = Double.parseDouble(CommonUtils.multiply(mShopLeftList.get(leftpos).getNum() + "", mShopLeftList.get(leftpos).getJisuanPrice() + ""));
                                                mShopLeftList.get(leftpos).setAllprice(price);

                                                mShopLeftAdapter.notifyDataSetChanged();
                                                jisuanAllPrice();
                                            }

                                        }

                                        @Override
                                        public void onErrorResponse(Object msg) {

                                        }
                                    });
                        } else {
//                            ToastUtils.showToast(HomeActivity.this, "赠送商品不能改小计");
                            com.blankj.utilcode.util.ToastUtils.showShort("赠送商品不能改小计");
                        }


                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }

            }
        });

        //改数量
        bttNumExchange.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        KeyboardDialog.numchangeDialog(HomeActivity.this, "改数量", mShopLeftList.get(leftpos).getNum() + "", mShopLeftList.get(leftpos), 1, new InterfaceBack() {

                            @Override
                            public void onResponse(Object response) {
                                double num = Double.parseDouble((String) response);
//                                double kucun = mShopMsgList.get
//                                mShopLeftList.get(leftpos).getNum();

                                mShopLeftList.get(leftpos).setNum(num);
                                mShopLeftAdapter.notifyDataSetChanged();
                                jisuanAllPrice();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                        setButtonGreen(R.id.btt_num_exchange);
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }

            }
        });

        //删除商品
        bttDelte.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        mShopLeftList.remove(leftpos);
                        leftpos = leftpos - 1;
                        jisuanAllPrice();
                        if (mShopLeftList.size() > 0) {
                            bttGetOrder.setText("挂单");
                        } else {
                            bttGetOrder.setText("取单");
                        }
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });

        bttGive.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                double discount = 0;
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        mShopLeftList.get(leftpos).setIschanged(true);
                        mShopLeftList.get(leftpos).setIsgive(true);
                        mShopLeftList.get(leftpos).setPD_Discount(discount);
//                        mShopLeftList.get(leftpos).setJisuanPrice(0);
                        double xiaoji = 0;
                        mShopLeftList.get(leftpos).setAllprice(xiaoji);
                        mShopLeftAdapter.notifyDataSetChanged();
                        jisuanAllPrice();
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });


        bttRoyalty.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() > 0) {
                    if (leftpos != -1) {
                        ShopMsg shopMsg = mShopLeftList.get(leftpos);
//                        GoodOrdeList good = goodOrdeLists.get(leftpos);
                        //提成员工
                        ShopDetailDialog.shopdetailDialog(HomeActivity.this, shopMsg, null == mVipMsg ? "" : mVipMsg.getVG_GID(), mShopLeftList.get(leftpos).getEM_GIDList(), mSmGid, 1, new InterfaceBack() {
                            @Override
                            public void onResponse(Object response) {

                                mEmplMsgList2 = (List<EmplMsg>) response;

                                StringBuilder mStaffName = new StringBuilder("");//提成员工姓名
                                List<String> tcGID = new ArrayList<>();
                                for (int i = 0; i < mEmplMsgList2.size(); i++) {
                                    if (mEmplMsgList2.get(i).isIschose()) {
                                        tcGID.add(mEmplMsgList2.get(i).getGID());
                                        if (i == mEmplMsgList2.size() - 1) {
                                            mStaffName.append(mEmplMsgList2.get(i).getEM_Name());
                                        } else {
                                            mStaffName.append(mEmplMsgList2.get(i).getEM_Name() + "、");
                                        }
                                    }
                                }

                                mShopLeftList.get(leftpos).setEM_GIDList(tcGID);
                                mShopLeftList.get(leftpos).setEM_NameList(mStaffName.toString());

//                                GoodOrdeList good = (GoodOrdeList) response;
//                                LogUtils.d("xxg", mGson.toJson(good));
//                                goodOrdeLists.set(leftpos, good);
//                                jisuanAllPrice();

                                mShopLeftAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onErrorResponse(Object msg) {

                            }
                        });
                        setButtonGreen(R.id.btt_royalty);
                    } else {
//                        ToastUtils.showToast(HomeActivity.this, "请选择商品");
                        com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    }
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }

            }
        });

        bttHungOrder.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                //挂单
                if (mShopLeftList.size() > 0) {
                    NoticeDialog.noticeDialog(ac, "收银台挂单提示", "你确定要挂单吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {

//                            dialog.show();
                            ImpSubmitOrder submitOrder = new ImpSubmitOrder();
                            submitOrder.submitOrder(ac, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, true, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    dialog.dismiss();
//                                    ToastUtils.showToast(ac, "挂单成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂单成功");
                                    mShopLeftList.clear();
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    order = CreateOrder.createOrder("SP");
                                    tv_ordernum.setText(order);
                                    mVipMsg = null;
                                    mVipDengjiMsg = null;
                                    VolleyResponse.instance().getInternetImg(ac, "", mIvViptx, R.mipmap.member_head_nohead);
                                    deletVip.setVisibility(View.GONE);
                                    mRlVip.setVisibility(View.VISIBLE);
                                    vipMessage.setVisibility(View.GONE);
                                    PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                                    mTvVipname.setText("散客");
                                    tvBlance.setText("0.00");
                                    tvIntegral.setText("0");
                                    mTvHeji.setText("￥0.00");
                                    tvGetIntegral.setText("0");
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    dialog.dismiss();
                                }
                            });

                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                    setButtonGreen(R.id.btt_hung_order);
                } else {
//                    ToastUtils.showToast(HomeActivity.this, "请选择商品");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }


            }
        });


        bttHungMoney.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //挂帐
                if (mShopLeftList.size() > 0) {

                    NoticeDialog.noticeDialog(ac, "收银台挂账提示", "你确定要挂账吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
//                            dialog.show();
                            ImpSubmitOrder_Guazhang submitOrder = new ImpSubmitOrder_Guazhang();
                            submitOrder.submitOrder(ac, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, true, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    dialog.dismiss();
//                                    ToastUtils.showToast(ac, "挂账成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂账成功");
                                    mShopLeftList.clear();
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    order = CreateOrder.createOrder("SP");
                                    tv_ordernum.setText(order);
                                    mVipMsg = null;
                                    mVipDengjiMsg = null;
                                    VolleyResponse.instance().getInternetImg(ac, "", mIvViptx, R.mipmap.member_head_nohead);

                                    deletVip.setVisibility(View.GONE);
                                    mRlVip.setVisibility(View.VISIBLE);
                                    vipMessage.setVisibility(View.GONE);
                                    PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                                    mTvVipname.setText("散客");
                                    tvBlance.setText("0.00");
                                    tvIntegral.setText("0");
                                    mTvHeji.setText("￥0.00");
                                    tvGetIntegral.setText("0");


                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    dialog.dismiss();
                                }
                            });
                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                    setButtonGreen(R.id.btt_hung_money);
                } else {
//                    ToastUtils.showToast(HomeActivity.this, "请选择商品");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });


        bttGetOrder.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //挂单
                if (mShopLeftList.size() > 0) {
                    NoticeDialog.noticeDialog(ac, "收银台挂单提示", "你确定要挂单吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {

//                            dialog.show();
                            ImpSubmitOrder submitOrder = new ImpSubmitOrder();
                            submitOrder.submitOrder(ac, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, true, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    dialog.dismiss();
//                                    ToastUtils.showToast(ac, "挂单成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂单成功");
                                    mShopLeftList.clear();
                                    mShopLeftAdapter.notifyDataSetChanged();
                                    order = CreateOrder.createOrder("SP");
                                    tv_ordernum.setText(order);
                                    mVipMsg = null;
                                    mVipDengjiMsg = null;
                                    VolleyResponse.instance().getInternetImg(ac, "", mIvViptx, R.mipmap.member_head_nohead);
                                    deletVip.setVisibility(View.GONE);
                                    mRlVip.setVisibility(View.VISIBLE);
                                    vipMessage.setVisibility(View.GONE);
                                    PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                                    mTvVipname.setText("散客");
                                    tvBlance.setText("0.00");
                                    tvIntegral.setText("0");
                                    mTvHeji.setText("￥0.00");
                                    tvGetIntegral.setText("0");
                                }

                                @Override
                                public void onErrorResponse(Object msg) {
                                    dialog.dismiss();
                                }
                            });

                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                    setButtonGreen(R.id.btt_get_order);
                } else {
                    shortMessage = cbMessage.isChecked();
                    //取单
                    QudanDialog qudanDialog = new QudanDialog(ac, moren, paytypelist, mSmGid, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            dialog.dismiss();
                            order = CreateOrder.createOrder("SP");
                            RevokeGuaDanBean guadanDetail = (RevokeGuaDanBean) response;
                            initGetOrder(guadanDetail);
                            if (guadanDetail.getData().getVIP_Card() != null && !guadanDetail.getData().getVIP_Card().equals("00000") && !guadanDetail.getData().getVIP_Card().equals("")) {
                                initVIP(guadanDetail.getData().getVIP_Card());
                            } else {
                                PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                            }
                            mShopLeftAdapter.notifyDataSetChanged();
                            jisuanAllPrice();

                        }

                        @Override
                        public void onErrorResponse(Object msg) {

                        }
                    });
                    qudanDialog.show();
                    setButtonGreen(R.id.btt_get_order);
                }
            }

        });


        mRlHoutai.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                int version = (int) (1 + Math.random() * (1000000 - 1 + 1));

//                showWebDialog("index.html");

                //后台
//                Intent intent = new Intent(ac, WebActivity.class);
//                intent.putExtra("versionDownURL",  MyApplication.BASE_URL+"loginTSCash.html?URL=index.html&v=" +String.valueOf(version));
//                //http://192.168.1.240:807/login.html
//                startActivity(intent);

                Intent intent = new Intent(ac, HtmlActivity.class);
                intent.putExtra("html_url", "https://pc.yunvip123.com/login.html");
                startActivity(intent);
            }
        });

        mRlJiaoban.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                //交班
                showWebDialog("交班", "/WebUI/Other/OExchange.html", width * 9 / 10, 680);

            }
        });
        //退货
        bttRetureGoods.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

                showWebDialog("退货", MyApplication.BASE_URL + "/WebUI/CashierDesk/ConsumeOrder.html", width * 9 / 10, 680);

            }
        });

        //会员充值
        bttRecharge.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("会员充值", "/WebUI/Member/MBalanceMage.shtml", 800, 680);
            }
        });

        //会员
        bttVipMember.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("会员列表", MyApplication.BASE_URL + "/WebUI/Member/MList.html", width * 9 / 10, 680);
            }
        });

        //交易
        bttBusiness.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                showWebDialog("交易", MyApplication.BASE_URL + "/WebUI/CashierDesk/ConsumeOrder.html", width * 9 / 10, 680);
            }
        });

        ivTopLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecycleViewUtiles.MoveToPosition(linearmanger, mRecyclerviewFirstclass, mClassMsgList.size(), true);
            }

        });

        ivTopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecycleViewUtiles.MoveToPosition(linearmanger, mRecyclerviewFirstclass, mClassMsgList.size(), false);
            }

        });


        spGoodsOrderNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    PageSize = 20;
                } else if (position == 1) {
                    PageSize = 50;
                } else if (position == 2) {
                    PageSize = 100;
                }
                PageIndex = 1;
                obtainHomeShop(mPT_Gid, mEtLoginAccount.getText().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tvFrontPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PageIndex > 1) {
                    PageIndex -= 1;

                    obtainHomeShop(mPT_Gid, mEtLoginAccount.getText().toString());
                }
            }
        });

        imNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PageIndex < totalPage) {
                    PageIndex += 1;

                    obtainHomeShop(mPT_Gid, mEtLoginAccount.getText().toString());
                } else {
//                    ToastUtils.showToast(ac, "已经是最后一页了");
                    com.blankj.utilcode.util.ToastUtils.showShort("已经是最后一页了");
                }
            }
        });

    }

    private void showWebDialog(String title, String url, int mwidth, int mheight) {

        int version = (int) (1 + Math.random() * (1000000 - 1 + 1));

        webDialog = new WebDialog(ac, mwidth, mheight, MyApplication.BASE_URL + "loginTSCash.html?URL=" + url + "&Name=" + title + "&v=" + String.valueOf(version));
        SystemUIUtils.setStickFullScreen(webDialog.getWindow().getDecorView());
        webDialog.show();
//        JavascriptInterfaceImpl.startLoading();
        MyApplication.isDialog = "1";
    }


    private void initVIP(String VIP_Card) {
        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        onlyVipMsg.vipMsg(ac, VIP_Card, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                mVipDengjiMsg = (VipDengjiMsg) response;

                VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(mVipDengjiMsg.getData().get(0).getVIP_HeadImg()).toString()), mIvViptx, R.mipmap.member_head_nohead);
                mTvVipname.setText(NullUtils.noNullHandle(mVipDengjiMsg.getData().get(0).getVIP_Name()).toString());
                vipMessage.setVisibility(View.VISIBLE);
                tvBlance.setText(StringUtil.twoNum(NullUtils.noNullHandle(mVipDengjiMsg.getData().get(0).getMA_AvailableBalance()).toString()));
                tvIntegral.setText(Double.parseDouble(NullUtils.noNullHandle(mVipDengjiMsg.getData().get(0).getMA_AvailableIntegral()).toString()) + "");
                mRlVip.setVisibility(View.GONE);
                deletVip.setVisibility(View.VISIBLE);
                PreferenceHelper.write(ac, "yunshangpu", "vip", true);

//                mPD_Discount = obtainVipPD_Discount(mVipDengjiMsg.getData().get(0).getVG_GID(), mVipDengjiMsg.getData().get(0).getVGInfo());
//                jisuanShopjisuanPrice(mPD_Discount, mShopLeftList);
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });

    }

    private void initGetOrder(RevokeGuaDanBean guadanDetail) {
        mShopLeftList.clear();

        for (RevokeGuaDanBean.DataBean.ViewGoodsDetailBean msg : guadanDetail.getData().getViewGoodsDetail()) {
            if (msg.getGOD_Type() != 11) {
                ShopMsg newmsg = new ShopMsg();
                newmsg.setJisuanPrice(msg.getPM_UnitPrice());
                newmsg.setPD_Discount(msg.getPM_Discount());
                newmsg.setNum(msg.getPM_Number());
                newmsg.setPM_UnitPrice(msg.getPM_OriginalPrice());
                newmsg.setAllprice(msg.getGOD_DiscountPrice());
                newmsg.setPM_BigImg(msg.getPM_Img());
                newmsg.setGID(msg.getPM_GID());
                newmsg.setPM_Code(msg.getPM_Code());
                newmsg.setPM_Name(msg.getPM_Name());
                newmsg.setPM_Modle(msg.getPM_Modle());
                newmsg.setPT_ID(msg.getPT_GID());
                newmsg.setPT_Name(msg.getPT_Name());
                if (msg.getGOD_Type() == 0) {
                    newmsg.setPM_IsService(0);
                } else if (msg.getGOD_Type() == 10) {
                    newmsg.setPM_IsService(1);
                }
                if (msg.getGOD_EMName() != null && !msg.getGOD_EMName().equals("")) {
                    List<String> eMlist = new ArrayList<>();
                    String[] str = msg.getGOD_EMGID().split(",");
                    for (String str1 : str) {
                        eMlist.add(str1);
                    }
                    newmsg.setEM_GIDList(eMlist);
                    newmsg.setEM_NameList(msg.getGOD_EMName());
                }

                mShopLeftList.add(newmsg);
                if (mShopLeftList.size() > 0) {
                    bttGetOrder.setText("挂单");
                } else {
                    bttGetOrder.setText("取单");
                }
            }

        }
    }

    private void jisuanShopjisuanPrice(int pd_discount, List<ShopMsg> leftlist) {
        boolean isVip = PreferenceHelper.readBoolean(ac, "yunshangpu", "vip", false);
        for (int i = 0; i < leftlist.size(); i++) {
            if (!leftlist.get(i).isIschanged()) {
                ShopMsg ts = leftlist.get(i);
                if (NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")) {
                    if (ts.getPM_SpecialOfferMoney() != -1) {
                        mShopLeftList.get(i).setPD_Discount(ts.getPM_SpecialOfferMoney() / ts.getPM_UnitPrice());
//                        PD_Discount = ts.getPM_SpecialOfferValue();
                        mShopLeftList.get(i).setHasvipDiscount(false);
                        mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());

                    } else if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")) {
                        //有特价折扣
                        if (NullUtils.noNullHandle(ts.getPM_MinDisCountValue()).toString().equals("0.0")) {
                            //无最低折扣
                            mShopLeftList.get(i).setPD_Discount(ts.getPM_SpecialOfferValue());
//                        PD_Discount = ts.getPM_SpecialOfferValue();
                            mShopLeftList.get(i).setHasvipDiscount(false);
                            mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                        } else {
                            //有最低折扣
                            if (ts.getPM_SpecialOfferValue() > ts.getPM_MinDisCountValue()) {
                                mShopLeftList.get(i).setPD_Discount(ts.getPM_SpecialOfferValue());
//                            PD_Discount = ts.getPM_SpecialOfferValue();
                                mShopLeftList.get(i).setHasvipDiscount(false);
                                mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                            } else {
                                mShopLeftList.get(i).setPD_Discount(ts.getPM_MinDisCountValue());
//                            PD_Discount = ts.getPM_SpecialOfferValue();
                                mShopLeftList.get(i).setHasvipDiscount(false);
                                mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                            }
                        }
                    } else {
                        //无特价折扣
                        if (isVip) {
                            if (ts.getPM_MemPrice() != null) {
                                //有会员价
//                            PD_Discount = CommonUtils.div(ts.getPM_MemPrice(),ts.getPM_UnitPrice(),2);
                                mShopLeftList.get(i).setPD_Discount(1);
                                mShopLeftList.get(i).setHasvipDiscount(true);
                                mShopLeftList.get(i).setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                            } else {
                                //无会员价
                                if (pd_discount > 0) {
                                    //有等级折扣
                                    if (NullUtils.noNullHandle(ts.getPM_MinDisCountValue()).toString().equals("0.0")) {
                                        //无最低折扣
//                                    PD_Discount = CommonUtils.div(pd_discount,100,2);
                                        mShopLeftList.get(i).setHasvipDiscount(true);
                                        mShopLeftList.get(i).setPD_Discount(CommonUtils.div(pd_discount, 100, 2));
                                        mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                                    } else {
                                        //有最低折扣
                                        if (CommonUtils.div(pd_discount, 100, 2) > ts.getPM_MinDisCountValue()) {
//                                        PD_Discount = CommonUtils.div(pd_discount,100,2);
                                            mShopLeftList.get(i).setPD_Discount(CommonUtils.div(pd_discount, 100, 2));
                                            mShopLeftList.get(i).setHasvipDiscount(true);
                                            mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                                        } else {
//                                        PD_Discount = ts.getPM_MinDisCountValue();
                                            mShopLeftList.get(i).setHasvipDiscount(true);
                                            mShopLeftList.get(i).setPD_Discount(ts.getPM_MinDisCountValue());
                                            mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                                        }
                                    }

                                } else {
//                                PD_Discount = 1;
                                    mShopLeftList.get(i).setPD_Discount(1);
                                    mShopLeftList.get(i).setHasvipDiscount(false);
                                    mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                                }
                            }
                        } else {
//                        PD_Discount = 1;
                            mShopLeftList.get(i).setPD_Discount(1);
                            mShopLeftList.get(i).setHasvipDiscount(false);
                            mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                        }
                    }
                } else {
                    //没有开启折扣开关
                    if (isVip) {
                        if (!NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                            //有会员价
                            mShopLeftList.get(i).setPD_Discount(1);
                            mShopLeftList.get(i).setHasvipDiscount(true);
                            mShopLeftList.get(i).setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                        } else {
                            mShopLeftList.get(i).setPD_Discount(1);
                            mShopLeftList.get(i).setHasvipDiscount(false);
                            mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                        }
                    } else {
                        mShopLeftList.get(i).setPD_Discount(1);
                        mShopLeftList.get(i).setHasvipDiscount(false);
                        mShopLeftList.get(i).setJisuanPrice(ts.getPM_UnitPrice());
                    }
                }
                if (NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("0.0")) {
                    mShopLeftList.get(i).setPM_MemPrice(ts.getPM_UnitPrice() + "");
                }
                double xiaoji = Double.parseDouble(CommonUtils.multiply(CommonUtils.multiply(ts.getJisuanPrice() + "", ts.getNum() + ""), ts.getPD_Discount() + ""));
                mShopLeftList.get(i).setAllprice(xiaoji);
            }

        }

        jisuanAllPrice();
    }

    private int obtainVipPD_Discount(String vg_gid, List<VipDengjiMsg.DataBean.VGInfoBean> sllist) {
        int PD_Discount = 0;
        for (int i = 0; i < sllist.size(); i++) {
            if (sllist.get(i).getVG_GID().equals(vg_gid)) {
                PD_Discount = sllist.get(i).getPD_Discount();
            }
        }

        return PD_Discount;
    }


    private void obtainShopClass() {
        ImpShopClass shopClass = new ImpShopClass();
        shopClass.shopclass(ac, new InterfaceBack() {//获取商品列表
            @Override
            public void onResponse(Object response) {

                Gson gson = new Gson();
                Type listType = new TypeToken<List<ClassMsg>>() {
                }.getType();
                List<ClassMsg> sllist = gson.fromJson(response.toString(), listType);
                mClassMsgList.clear();
                mClassMsgList.addAll(sllist);
                for (ClassMsg classMsg : sllist) {
                    if (!NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals("")) {
                        for (int i = 0; i < mClassMsgList.size(); i++) {
                            if (NullUtils.noNullHandle(classMsg.getPT_Parent()).toString().equals(NullUtils.noNullHandle(mClassMsgList.get(i).getGID()).toString())) {
                                mClassMsgList.get(i).setTwolist(classMsg);
                            }
                        }
                    }
                }

                ClassMsg classMsg = new ClassMsg();
                classMsg.setChose(true);
                classMsg.setPT_Name("全部");
                mClassMsgList.add(0, classMsg);

                ClassMsg classMsg1 = new ClassMsg();
                classMsg1.setChose(false);
                classMsg1.setPT_Name("套餐");
                classMsg1.setGID("combo");
                mClassMsgList.add(1, classMsg1);

                mFirstClassAdapter.notifyDataSetChanged();

            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });

    }

    private void obtainHomeShop(String PT_GID, String PM_CodeOrNameOrSimpleCode) {
//        dialog.show();
        ImpShopHome shopHome = new ImpShopHome();
        shopHome.shoplist(ac, PageIndex, PageSize, PT_GID, PM_CodeOrNameOrSimpleCode, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                dialog.dismiss();
                List<ShopMsg> sllist = (List<ShopMsg>) response;
                mEtLoginAccount.setText("");
                tvPage.setText(PageIndex + "");
                tvTotalPage.setText(totalPage + "");
                tvTatolNum.setText(totalCount + "");
                mShopMsgList.clear();
                mShopMsgList.addAll(sllist);
//                 int  0  表示普通商品    1表示服务商品  2表示礼品   3普通套餐   4充次套餐
                for (ShopMsg msg : sllist) {
                    if (NullUtils.noNullHandle(msg.getPM_IsService()).toString().equals("2")) {
                        mShopMsgList.remove(msg);
                    }
                }

                //库存显示设置
//                for (int j = 0; j < mShopMsgList.size(); j++) {
//                    mShopMsgList.get(j).setCurrtStock_Number(mShopMsgList.get(j).getStock_Number());
//                    if (mShopLeftList.size() > 0) {
//                        for (int i = 0; i < mShopLeftList.size(); i++) {
//                            if (mShopMsgList.get(j).getGID().equals(mShopLeftList.get(i).getGID())) {
//                                mShopMsgList.get(j).setCurrtStock_Number(mShopMsgList.get(j).getStock_Number() - mShopLeftList.get(i).getNum());
//                            }
//                        }
//                    }
//                }
                mShopRightAdapter.notifyDataSetChanged();

            }

            @Override
            public void onErrorResponse(Object msg) {
                dialog.dismiss();
            }
        });

    }

    private void getproductmodel() {

        ImpGoodsModel impGoodsModel = new ImpGoodsModel();
        impGoodsModel.getGoodsModel(ac, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                ModelList = (List<GoodsModelBean>) response;
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });


    }

    public static void closeDialog() {
        if (webDialog != null) {
            webDialog.dismiss();
            MyApplication.isDialog = "0";

        }
    }

    public static void closeJbDialog() {
        handler.sendEmptyMessage(2);
    }

    public static void loadHeadImg(String url) {

        Message msg = new Message();
        msg.obj = url;
        msg.what = 1;
        handler.sendMessage(msg);


    }

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (msg.obj != null) {
                        VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(String.valueOf(msg.obj)), imgHedimg, R.mipmap.member_head_nohead);
//                        ToastUtils.showToast(ac,"修改头像成功");
                        com.blankj.utilcode.util.ToastUtils.showShort("修改头像成功");
                    }
                    loginBean.getData().setUM_ChatHead(String.valueOf(msg.obj));
                    if (webDialog != null) {
                        webDialog.dismiss();
                        MyApplication.isDialog = "0";
                    }
                    break;

                case 2:
                    if (webDialog != null) {
                        webDialog.dismiss();
                        MyApplication.isDialog = "0";
                    }
//                    dialog.show();
                    ImpOutLogin outLogin = new ImpOutLogin();
                    outLogin.outLogin(ac, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {

                            dialog.dismiss();
                            Intent intent = new Intent(ac, LoginActivity.class);
                            ac.startActivity(intent);
                            ac.finish();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            dialog.dismiss();
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    };

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
                    mHandler.obtainMessage(CONN_PRINTER).sendToTarget();
                    return;
                }
                if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].getCurrentPrinterCommand() == PrinterCommand.TSC) {
                    DeviceConnFactoryManager.getDeviceConnFactoryManagers()[id].sendDataImmediately(PrintContent.getLabel(shopMsg));
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ac = HomeActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消蓝牙搜索
//        mBluetoothAdapter.cancelDiscovery();
//        if (receiver.getDebugUnregister()) {
//            ac.unregisterReceiver(receiver);
//            mRegisterTag = false;
//        }
        EventBus.getDefault().unregister(this);
    }

    //    private void addGoods(ShopMsg shopMsg){
//
//
//        if (mShopMsgList!=null &&mShopMsgList.size()>0){
//
//            if (mShopMsgList.size() ==1){
//                double numgoods = 0;
//                if (mShopLeftList.size() > 0 && mShopMsgList.size()>0) {
//                    for (int i = 0; i < mShopMsgList.size(); i++) {
//                        for (int j = 0; j < mShopLeftList.size(); j++) {
//                            if (mShopMsgList.get(i).getGID().equals(mShopLeftList.get(j).getGID())) {
//                                numgoods = mShopLeftList.get(j).getNum();
//                                mShopLeftList.remove(j);
//                            }
//                        }
//                    }
//                }
//
//                mShopMsgList.get(0).setNum(numgoods+1);
//                mShopLeftList.add(mShopMsgList.get(0));
//                countGoodsNum();
//                setRightAdapter();
//
//                mTvHaveChossed.setText(mGoodsNum + "");
//                mTvTotalMoney.setText(Decima2KeeplUtil.stringToDecimal(mTotalMoney + ""));
//                continuePreview();
//                try {
//                    Thread.currentThread().sleep(1500);
//                }catch (Exception e){
//
//                }
//            } else {
//                if (ModelList != null) {
//                    //初始化
//                    for (int i = 0;i<ModelList.getData().size();i++){
//                        ModelList.getData().get(i).setChecked(false);
//                        ModelList.getData().get(i).setEnable(false);
//                    }
//                    //将商品有的规格设置成可点击
//                    for (int i = 0; i < mShopMsgList.size(); i++) {
//                        if (mShopMsgList.get(i).getPM_Modle() != null && !mShopMsgList.get(i).getPM_Modle().equals("")) {
//                            List<String> list = DateUtil.getStringForlist(mShopMsgList.get(i).getPM_Modle());
//                            for (int j = 0; j < list.size(); j++) {
//                                for (int k = 0; k < ModelList.getData().size(); k++) {
//                                    if (list.get(j).equals(ModelList.getData().get(k).getPM_Properties())){
//                                        ModelList.getData().get(k).setEnable(true);
//                                    }
//                                }
//                            }
//                        }
//                    }
////                            for (int i= 0;i<ModelList.getData().size();i++){
////                                if (!ModelList.getData().get(i).isEnable() &&ModelList.getData().get(i).getPM_Type() !=0){
////                                    ModelList.getData().get(i).remove();
////                                }
////                            }
//                    modelList.clear();
//
//                    //组装规格数据
//                    if (ModelList!=null &&ModelList.getData().size()>1){
//                        for (int i = 0;i<ModelList.getData().size();i++) {
//                            if (ModelList.getData().get(i).getPM_Type() ==0){
//                                List<GoodsModelListBean.DataBean> list = new ArrayList<>();
//                                list.add(ModelList.getData().get(i));
//                                modelList.add(list);
//                            }else {
//                                for (int j = 0;j<modelList.size();j++){
//                                    if (modelList.get(j).get(0).getPM_Name().equals(ModelList.getData().get(i).getPM_Name())){
//                                        modelList.get(j).add(ModelList.getData().get(i));
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    //设置第一个默认选中
//                    for (int i = 0;i<modelList.size();i++){
//                        int num = 0;
//                        for (int j = 0;j<modelList.get(i).size();j++){
//                            if (modelList.get(i).get(j).isEnable()&&modelList.get(i).get(j).getPM_Type()!=0){
//                                modelList.get(i).get(j).setChecked(true);
//                                num++;
//                                break;
//                            }
//                        }
//                        if (num ==0){
//                            modelList.remove(i);
//                            i--;
//                        }else {
//                            modelList.get(i).remove(0);
//                        }
//                    }
//                    showRulePop();
//                } else {
//                    CustomToast.makeText(CaptureActivity.this, "没有获取到规格列表，请刷新后尝试", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        } else if (mShopMsgList != null && mShopMsgList.size() == 0) {
//            mSweetAlertDialog = new SweetAlertDialog(CaptureActivity.this, SweetAlertDialog.WARNING_TYPE);
//            mSweetAlertDialog.setTitleText("没有该商品");
//            mSweetAlertDialog.setConfirmText("新增");
//            mSweetAlertDialog.setCancelText("关闭");
//            mSweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                @Override
//                public void onClick(SweetAlertDialog sweetAlertDialog) {
//                    mSweetAlertDialog.dismiss();
//                    Intent intent = new Intent(CaptureActivity.this, YSLAddGoodsActivity.class);
//                    intent.putExtra("Searchcontetnt",Searchcontetnt);
//                    startActivity(intent);
//                }
//            });
//            mSweetAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    continuePreview();
//                }
//            });
//            mSweetAlertDialog.show();
//        }
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMemberValueRefresh(HomeButtonColorChangeEvent notifyShopCarEvent) {
        if (notifyShopCarEvent.getMsg().equals("Change_color")) {
            setButtonGreen(0);
        }
    }

    /**
     * 竖排按钮变颜色
     */
    private void setButtonGreen(int viewId) {
        for (int i = 0, len = mButtonGreen.length; i < len; i++) {
            Button buttonView = (Button) findViewById(mButtonGreen[i]);
            if (viewId == mButtonGreen[i]) {
                buttonView.setBackgroundResource(R.drawable.background_green);
            } else {
                buttonView.setBackgroundResource(R.drawable.background_white);
            }
        }
    }

}

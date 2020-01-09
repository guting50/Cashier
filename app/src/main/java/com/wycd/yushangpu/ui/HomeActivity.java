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
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.utils.view.BgFrameLayout;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.ShopLeftAdapter;
import com.wycd.yushangpu.bean.GoodsModelBean;
import com.wycd.yushangpu.bean.OrderCanshhu;
import com.wycd.yushangpu.bean.PayTypeMsg;
import com.wycd.yushangpu.bean.RevokeGuaDanBean;
import com.wycd.yushangpu.bean.ShopInfoBean;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.bean.VipInfoMsg;
import com.wycd.yushangpu.bean.event.HomeButtonColorChangeEvent;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.http.InterfaceThreeBack;
import com.wycd.yushangpu.http.VolleyResponse;
import com.wycd.yushangpu.model.ImpGoodsModel;
import com.wycd.yushangpu.model.ImpGroupGoodsList;
import com.wycd.yushangpu.model.ImpOnlyVipMsg;
import com.wycd.yushangpu.model.ImpOutLogin;
import com.wycd.yushangpu.model.ImpShopInfo;
import com.wycd.yushangpu.model.ImpSubmitOrder;
import com.wycd.yushangpu.model.ImpSubmitOrder_Guazhang;
import com.wycd.yushangpu.model.ImpSystemCanshu;
import com.wycd.yushangpu.printutil.GetPrintSet;
import com.wycd.yushangpu.printutil.HttpGetPrintContents;
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
import com.wycd.yushangpu.tools.StringUtil;
import com.wycd.yushangpu.tools.SystemUIUtils;
import com.wycd.yushangpu.tools.ThreadPool;
import com.wycd.yushangpu.tools.Utils;
import com.wycd.yushangpu.ui.fragment.EditCashierGoodsFragment;
import com.wycd.yushangpu.ui.fragment.GoodsListFragment;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;
import com.wycd.yushangpu.ui.fragment.PrintSetFragment;
import com.wycd.yushangpu.ui.fragment.QudanFragment;
import com.wycd.yushangpu.web.WebDialog;
import com.wycd.yushangpu.widget.dialog.ChangePwdDialog;
import com.wycd.yushangpu.widget.dialog.FastCashierDialog;
import com.wycd.yushangpu.widget.dialog.GoodsModelDialog;
import com.wycd.yushangpu.widget.dialog.KeyboardDialog;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;
import com.wycd.yushangpu.widget.dialog.VipChooseDialog;
import com.wycd.yushangpu.widget.popwindow.ShowMemberPopWindow;
import com.wycd.yushangpu.widget.popwindow.ShowStorePopWindow;
import com.wycd.yushangpu.widget.views.ClearEditText;

import net.posprinter.posprinterface.TaskCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.LABELPRINT_IS_OPEN;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.tools.Constant.ACTION_USB_PERMISSION;

public class HomeActivity extends BaseActivity implements ShowMemberPopWindow.OnItemClickListener, ShowStorePopWindow.OnItemStoreClickListener {
    @BindView(R.id.ig_exchange)
    ImageView igExchange;
    @BindView(R.id.rl_jiaoban)
    RelativeLayout mRlJiaoban;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.et_login_account)
    public ClearEditText mEtLoginAccount;
    @BindView(R.id.tv_ordertime)
    TextView tv_ordertime;
    @BindView(R.id.tv_ordernum)
    TextView tv_ordernum;
    @BindView(R.id.recyclerview_shoplist)
    RecyclerView mRecyclerviewShoplist;
    @BindView(R.id.tv_num_total)
    TextView tvNumTotal;
    @BindView(R.id.tv_heji)
    TextView mTvHeji;
    @BindView(R.id.tv_shoukuan)
    BgFrameLayout tvShoukuan;
    @BindView(R.id.btt_get_order)
    TextView bttGetOrder;
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
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.btn_home_label)
    Button btnHomeLabel;
    @BindView(R.id.order_count_layout)
    BgFrameLayout orderCountLayout;
    @BindView(R.id.vip_name_layout)
    BgFrameLayout vipNameLayout;

    private static CircleImageView imgHedimg;
    //    private List<ClassMsg> twoClassList;
//    private Gson mGson;
    public ShopLeftAdapter mShopLeftAdapter;
    private ArrayList<ShopMsg> mShopLeftList = new ArrayList<>();
    public VipInfoMsg mVipMsg;
    private CharSequence ordertime;
    private String order;
    private ArrayList<PayTypeMsg> paytypelist = new ArrayList<>();
    private PayTypeMsg moren;
    private String allmoney, totalMoney;
    private double mPoint;//积分
    private long firstTime = 0;
    private String jifendkbfb = "0", jinfenzfxzbfb = "0";
    //    private double PD_Discount = 0;
    private int leftpos = -1;// 购物车选中位子 -1表示没有选中
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

    private FragmentManager fragmentManager;
    private EditCashierGoodsFragment editCashierGoodsFragment;
    private GoodsListFragment goodsListFragment;
    public JiesuanBFragment jiesuanBFragment;
    private QudanFragment qudanFragment;
    public PrintSetFragment printSetFragment;
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

    //商品数据修改(修改单价/修改折扣/修改小计/修改数量)
    public int mModifyPrice = 0;
    //修改改价
    public int mChangePrice = 0;
    //修改折扣
    public int mChangeDiscount = 0;
    //修改小计
    public int mChangeSubtotal = 0;

//    public HomeActivity() {
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        isFirstLaunch = true;
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

        mShopLeftAdapter = new ShopLeftAdapter(ac, mShopLeftList, new InterfaceThreeBack() {

            //加减
            @Override
            public void onResponse(Object response) {
                ShopMsg shopMsg = (ShopMsg) response;
                mShopLeftList.set(shopMsg.getChosePosion(), shopMsg);
                jisuanAllPrice();
            }

            //移除
            @Override
            public void onErrorResponse(Object msg) {
                int po = (int) msg;
                if (mShopLeftList.size() > 0) {
                    if (editCashierGoodsFragment != null)
                        if (editCashierGoodsFragment.getShopBean() != null &&
                                TextUtils.equals(mShopLeftList.get(po).getGID(),
                                        editCashierGoodsFragment.getShopBean().getGID()))
                            fragmentManager.beginTransaction().hide(editCashierGoodsFragment).commit();

                    mShopLeftList.remove(po);
                    leftpos = leftpos - 1;
                    mShopLeftAdapter.notifyDataSetChanged();
                    jisuanAllPrice();

                    updateBttGetOrder();
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

                if (editCashierGoodsFragment == null) {
                    editCashierGoodsFragment = new EditCashierGoodsFragment();
                    fragmentManager.beginTransaction().add(R.id.right_fragment_layout, editCashierGoodsFragment).commit();
                } else
                    fragmentManager.beginTransaction().show(editCashierGoodsFragment).commit();
                editCashierGoodsFragment.setData(mShopLeftList.get(i));
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerviewShoplist.setLayoutManager(llm);
        mRecyclerviewShoplist.setAdapter(mShopLeftAdapter);

        mEtLoginAccount.requestFocus();
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();

        goodsListFragment = new GoodsListFragment();
        fragmentManager.beginTransaction().add(R.id.right_fragment_layout, goodsListFragment).commit();

        qudanFragment = new QudanFragment(this);
        qudanFragment.obtainGuadanList();
    }

    private void initData() {
        getproductmodel();
        obtainSystemCanshu();
        GetPrintSet.getPrintSet();
        getShopInfo();

        PreferenceHelper.write(ac, "yunshangpu", "vip", false);
//        mGson = new Gson();
//        mClassMsgList = null;//清空分类

        if (MyApplication.loginBean != null) {
            if (MyApplication.loginBean.getUM_ChatHead() != null) {
                VolleyResponse.instance().getInternetImg(ac, ImgUrlTools.obtainUrl(NullUtils.noNullHandle(MyApplication.loginBean.getUM_ChatHead()).toString()), imgHedimg, R.mipmap.member_head_nohead);
            }
            tvStoreName.setText(MyApplication.loginBean.getUM_Name());
        }

        //更新订单时间
        new TimeThread().start();

        order = CreateOrder.createOrder("SP");
        tv_ordernum.setText(order);
    }

    @Override
    public void setOnItemClick(View v) {

        switch (v.getId()) {

            case R.id.tv_change_pwd:
                if (MyApplication.loginBean != null) {
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
                        dialog.show();
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
                handleSystem(sllist);
            }

            @Override
            public void onErrorResponse(Object msg) {
            }
        });
    }


    private void handleSystem(List<PayTypeMsg> sllist) {
        for (PayTypeMsg p : sllist) {
            switch (p.getSS_Name()) {
                case "默认支付":
                    moren = p;
                    break;
                case "现金支付":
                case "余额支付":
                case "银联支付":
                case "微信记账":
                case "支付宝记账":
                case "优惠券":
                case "扫码支付":
                case "其他支付":
                    paytypelist.add(p);
                    break;
                case "积分支付":
                    jifendkbfb = p.getSS_Value();
                    paytypelist.add(p);
                    break;
                case "积分支付限制":
                    jinfenzfxzbfb = p.getSS_Value();
                    paytypelist.add(p);
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

    public void jisuanAllPrice() {
        jisuanAllPrice(true);
    }

    public void jisuanAllPrice(boolean isJisuanDiscount) {
        double allprice = 0;
        double totalPrice = 0;
        double onepoint = 0;
        double num = 0;
        for (ShopMsg shopMsg : mShopLeftList) {
            //商品积分计算
            if (mVipMsg != null) {
                if (shopMsg.getPM_IsPoint() == 0 || shopMsg.getPM_IsPoint() == 3) {//0没有设置积分规则，3本商品不计分
                    shopMsg.setEachPoint(0);
                } else if (shopMsg.getPM_IsPoint() == 2) {//本商品按固定积分
                    shopMsg.setEachPoint(shopMsg.getPM_FixedIntegralValue());
                } else if (shopMsg.getPM_IsPoint() == 1) {//本商品按等级积分
                    if (mVipMsg.getVG_IsIntegral() == 0) {//会员等级积分开关没有有打开
                        shopMsg.setEachPoint(0);
                    } else if (mVipMsg.getVG_IsIntegral() == 1) {
                        for (int m = 0; m < mVipMsg.getVGInfo().size(); m++) {//所选商品种类的数量，不等于所选商品数量；
                            if (mVipMsg.getVGInfo().get(m).getPT_GID().equals(shopMsg.getPT_ID())) {
                                double bl = mVipMsg.getVGInfo().get(m).getVS_CMoney();
                                if (bl != 0) {
                                    if (shopMsg.getPM_MemPrice() != null) {
                                        double memprice = Double.parseDouble(shopMsg.getPM_MemPrice());
                                        if (memprice < shopMsg.getJisuanPrice() * shopMsg.getPD_Discount()) {
                                            double fb = memprice / bl;
                                            shopMsg.setEachPoint(fb);
                                        } else {
                                            double fb = shopMsg.getJisuanPrice() * shopMsg.getPD_Discount() / bl;
                                            shopMsg.setEachPoint(fb);
                                        }
                                    } else {
                                        double fb = shopMsg.getJisuanPrice() * shopMsg.getPD_Discount() / bl;
                                        shopMsg.setEachPoint(fb);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (isJisuanDiscount) {
                jisuanDiscount(shopMsg);

                int type = 0;
                switch (NullUtils.noNullHandle(shopMsg.getPM_IsService()).toString()) {
                    case "0":
                    case "1":
                    case "2":
                        type = 0;
                        break;
                    case "3":
                    case "4":
                        type = 1;
                        break;
                }
                shopMsg.setType(type);
            }

            allprice += shopMsg.getAllprice();
            totalPrice += shopMsg.getTotalPrice();
            onepoint += shopMsg.getEachPoint() * shopMsg.getNum();
            num += shopMsg.getNum();
        }

        if (!PreferenceHelper.readBoolean(ac, "yunshangpu", "vip", false)) {
            mPoint = 0;
        }
        mPoint = Double.parseDouble(StringUtil.twoNum(onepoint + ""));
        allmoney = StringUtil.twoNum(allprice + "");
        totalMoney = StringUtil.twoNum(totalPrice + "");
        mTvHeji.setText(allmoney);
        tvNumTotal.setText(num + "");
        if (num != 0) {
            tvShoukuan.setTag(1);
            ((TextView) tvShoukuan.getChildAt(0)).setText("结账[Enter]");
        } else {
            tvShoukuan.setTag(0);
            ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
        }

        mShopLeftAdapter.notifyDataSetChanged();
    }

    private void jisuanDiscount(ShopMsg ts) {
        boolean isVip = PreferenceHelper.readBoolean(ac, "yunshangpu", "vip", false);
        if (!ts.isIschanged()) {
            if (NullUtils.noNullHandle(ts.getPM_IsDiscount()).toString().equals("1")) {
                //有特价折扣
                if (ts.getPM_SpecialOfferMoney() != -1) { // 特价金额值
                    ts.setPD_Discount(ts.getPM_SpecialOfferMoney() / ts.getPM_UnitPrice());
                    ts.setHasvipDiscount(false);
                    ts.setJisuanPrice(ts.getPM_UnitPrice());
                } else if (!NullUtils.noNullHandle(ts.getPM_SpecialOfferValue()).toString().equals("0.0")) { // 特价折扣开关的值
                    //有特价折扣
                    // 如果特价折扣 > 最低折扣 按特价折扣算，否者按最低折扣算
                    if (ts.getPM_SpecialOfferValue() > ts.getPM_MinDisCountValue()) {
                        ts.setPD_Discount(ts.getPM_SpecialOfferValue());
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    } else {
                        ts.setPD_Discount(ts.getPM_MinDisCountValue());
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    }
                } else {
                    //无特价折扣
                    if (isVip) {
                        if (ts.getPM_MemPrice() != null) {
                            //有会员价
                            ts.setPD_Discount(1);
                            ts.setHasvipDiscount(true);
                            ts.setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                        } else if (mPD_Discount > 0) {
                            //无会员价
                            // 如果等级折扣 > 最低折扣 按等级折扣算，否者按最低折扣算
                            if (CommonUtils.div(mPD_Discount, 100, 2) > ts.getPM_MinDisCountValue()) {
                                ts.setPD_Discount(CommonUtils.div(mPD_Discount, 100, 2));
                                ts.setHasvipDiscount(true);
                                ts.setJisuanPrice(ts.getPM_UnitPrice());
                            } else {
                                ts.setPD_Discount(ts.getPM_MinDisCountValue());
                                ts.setHasvipDiscount(true);
                                ts.setJisuanPrice(ts.getPM_UnitPrice());
                            }
                        } else {
                            ts.setPD_Discount(1);
                            ts.setHasvipDiscount(false);
                            ts.setJisuanPrice(ts.getPM_UnitPrice());
                        }
                    } else {
                        ts.setPD_Discount(1);
                        ts.setHasvipDiscount(false);
                        ts.setJisuanPrice(ts.getPM_UnitPrice());
                    }
                }
            } else { // 会员折扣
                //没有开启折扣开关
                if (isVip && !NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("")) {
                    //有会员价
                    ts.setPD_Discount(1);
                    ts.setHasvipDiscount(true);
                    ts.setJisuanPrice(Double.parseDouble(ts.getPM_MemPrice()));
                } else {
                    ts.setPD_Discount(1);
                    ts.setHasvipDiscount(false);
                    ts.setJisuanPrice(ts.getPM_UnitPrice());
                }
            }

            if (NullUtils.noNullHandle(ts.getPM_MemPrice()).toString().equals("0.0")) {
                ts.setPM_MemPrice(ts.getPM_UnitPrice() + "");
            }
            double allprice = CommonUtils.multiply(CommonUtils.multiply(ts.getJisuanPrice(), ts.getNum()), ts.getPD_Discount());
            ts.setAllprice(allprice);

            double totalPrice = CommonUtils.multiply(ts.getPM_UnitPrice(), ts.getNum());
            ts.setTotalPrice(totalPrice);
        }
    }

    public void addCashierList(ShopMsg shopMsg) {
        if (mShopLeftList.size() == 1 && TextUtils.isEmpty(mShopLeftList.get(0).getGID())) {
            //如果有快速收银商品 ，就不在添加其他的商品
            return;
        }
        if (shopMsg.getStock_Number() <= 0 && isZeroStock && shopMsg.getPM_IsService() == 0) {
            com.blankj.utilcode.util.ToastUtils.showShort("当前库存不足");
            return;
        }
        double addnum = 1;
        if (isZeroStock && shopMsg.getPM_IsService() == 0) {//禁止0库存销售的普通商品
            if (shopMsg.getStock_Number() - 1 >= 0) { //库存大于等于1
                addnum = 1;
            } else {//库存大于0小于1
                addnum = shopMsg.getStock_Number();
            }
        } else {
            addnum = 1;
        }

        if (!TextUtils.isEmpty(shopMsg.getPM_GroupGID())/* && Integer.parseInt(shopMsg.getGroupCount()) > 1*/) {
            dialog.show();
            ImpGroupGoodsList impGroupGoodsList = new ImpGroupGoodsList();
            final double finalAddnum = addnum;
            impGroupGoodsList.getGroupGoodsList(ac, shopMsg.getPM_GroupGID(), new InterfaceBack() {
                @Override
                public void onResponse(Object response) {
                    dialog.dismiss();
                    List<ShopMsg> sllist = (List<ShopMsg>) response;
                    if (sllist.size() == 1) {
                        addShopLeftList(shopMsg, finalAddnum);
                    } else {
                        showGoodsModelDialog(sllist, finalAddnum);
                    }
                }

                @Override
                public void onErrorResponse(Object msg) {
                    dialog.dismiss();
                }
            });
        } else {
            addShopLeftList(shopMsg, addnum);
        }
    }

    private void addShopLeftList(ShopMsg shopMsg, double addnum) {
        double num = 0;
        int pos = 0;

        for (int j = 0; j < mShopLeftList.size(); j++) {
            if (shopMsg.getGID().equals(mShopLeftList.get(j).getGID()) && !mShopLeftList.get(j).isIsgive()) {
                num = mShopLeftList.get(j).getNum();
                pos = j;
            }
        }
        shopMsg.setNum(num + addnum);
        if (num == 0) {
            shopMsg.setCheck(false);
            mShopLeftList.add(0, shopMsg);
            if (leftpos != -1) {
                leftpos += 1;
            }

            updateBttGetOrder();
        } else {
            mShopLeftList.get(pos).setNum(num + addnum);
        }
        jisuanAllPrice();
        for (int i = 0; i < mShopLeftList.size(); i++) {
            if (shopMsg.getGID().equals(mShopLeftList.get(i).getGID()) && !mShopLeftList.get(i).isIsgive()) {
                mShopLeftList.get(i).setCheck(true);
                leftpos = i;
            } else {
                mShopLeftList.get(i).setCheck(false);
            }
        }
        mShopLeftAdapter.notifyDataSetChanged();
    }

    private void showGoodsModelDialog(List<ShopMsg> sllist, double addnum) {
        if (ModelList != null) {
            //初始化
            for (int i = 0; i < ModelList.size(); i++) {
                ModelList.get(i).setChecked(false);
                ModelList.get(i).setEnable(false);
            }
            //将商品有的规格设置成可点击
            for (ShopMsg shopMsg : sllist) {
                if (!TextUtils.isEmpty(shopMsg.getPM_Modle())) {
                    for (String str : shopMsg.getPM_Modle().split("\\|")) {
                        for (GoodsModelBean modelBean : ModelList) {
                            if (str.equals(modelBean.getPM_Properties())) {
                                modelBean.setEnable(true);
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

            dialog.dismiss();
            GoodsModelDialog.goodsModelDialog(ac, 1, modelList, sllist, isZeroStock, new InterfaceBack() {
                @Override
                public void onResponse(Object response) {
                    ShopMsg goodsitem = (ShopMsg) response;
                    addShopLeftList(goodsitem, addnum);
                }
            });

        } else {
            com.blankj.utilcode.util.ToastUtils.showShort("没有获取到规格列表，请稍后再尝试");
            getproductmodel();
        }
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
                    goodsListFragment.obtainHomeShop("", mEtLoginAccount.getText().toString());
                }
                return false;
            }
        });

        ivSearch.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                KeyboardDialog.numchangeDialog(HomeActivity.this, "商品搜索", mEtLoginAccount.getText().toString(), null, 1, new InterfaceBack() {

                    @Override
                    public void onResponse(Object response) {
                        String search = (String) response;
                        goodsListFragment.obtainHomeShop("", search + "");
                    }
                });
            }
        });

        tvShoukuan.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() > 0) {
                    dialog.show();
                    ImpSubmitOrder submitOrder = new ImpSubmitOrder();

                    if (mShopLeftList.size() == 1 && TextUtils.isEmpty(mShopLeftList.get(0).getGID()))
                        submitOrder.submitCelerityOrder(ac, order, ordertime.toString(),
                                null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), allmoney, new InterfaceBack() {
                                    @Override
                                    public void onResponse(Object response) {
                                        OrderCanshhu jso = (OrderCanshhu) response;
                                        toJieSuan(jso, JiesuanBFragment.OrderType.CELERITY_ORDER);
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onErrorResponse(Object msg) {
                                        dialog.dismiss();
                                    }
                                });
                    else
                        submitOrder.submitOrder(ac, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(),
                                mShopLeftList, false, new InterfaceBack() {
                                    @Override
                                    public void onResponse(Object response) {
                                        OrderCanshhu jso = (OrderCanshhu) response;
                                        toJieSuan(jso, JiesuanBFragment.OrderType.CONSUM_ORDER);
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onErrorResponse(Object msg) {
                                        dialog.dismiss();
                                    }
                                });
                } else {
                    FastCashierDialog.noticeDialog(ac, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            String mone = response.toString();
                            ShopMsg shopMsg = new ShopMsg();
                            shopMsg.setGID("");
                            shopMsg.setPM_UnitPrice(Double.parseDouble(mone));
                            shopMsg.setJisuanPrice(Double.parseDouble(mone));
                            shopMsg.setStock_Number(1);
                            shopMsg.setPM_IsService(1);
                            shopMsg.setPM_Name("快速收银商品");
                            addCashierList(shopMsg);
                        }
                    });
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

                                    resetCashier();
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
                } else {
//                    ToastUtils.showToast(HomeActivity.this, "请选择商品");
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                }
            }
        });

        bttGetOrder.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                if (mShopLeftList.size() == 0 && qudanFragment.getListCount() == 0) {
                    com.blankj.utilcode.util.ToastUtils.showShort("请选择商品");
                    return;
                }
                if (!qudanFragment.isAdded())
                    fragmentManager.beginTransaction().add(R.id.fragment_content, qudanFragment).commit();
                else
                    fragmentManager.beginTransaction().show(qudanFragment).commit();
                //挂单
                if (mShopLeftList.size() > 0) {
                    qudanFragment.guaDan(order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            fragmentManager.beginTransaction().hide(qudanFragment).commit();
                            resetCashier();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            fragmentManager.beginTransaction().hide(qudanFragment).commit();
                        }
                    });

                    /*NoticeDialog.noticeDialog(ac, "收银台挂单提示", "你确定要挂单吗？", 1, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
//                            dialog.show();
                            ImpSubmitOrder submitOrder = new ImpSubmitOrder();
                            submitOrder.submitGuaOrder(ac, order, ordertime.toString(), null == mVipMsg ? "00000" : mVipMsg.getVCH_Card(), mShopLeftList, new InterfaceBack() {
                                @Override
                                public void onResponse(Object response) {
                                    dialog.dismiss();
//                                    ToastUtils.showToast(ac, "挂单成功");
                                    com.blankj.utilcode.util.ToastUtils.showShort("挂单成功");

                                    resetCashier();
                                    qudanFragment.obtainGuadanList();
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
                    });*/
                } else if (qudanFragment.getListCount() > 0) {
                    //取单
                    qudanFragment.getGuaDan(moren, paytypelist, new InterfaceBack() {
                        @Override
                        public void onResponse(Object response) {
                            fragmentManager.beginTransaction().hide(qudanFragment).commit();
                            if (response != null) {
                                dialog.dismiss();
                                order = CreateOrder.createOrder("SP");
                                RevokeGuaDanBean guadanDetail = (RevokeGuaDanBean) response;
                                initGetOrder(guadanDetail);
                                if (guadanDetail.getVIP_Card() != null &&
                                        !guadanDetail.getVIP_Card().equals("00000") &&
                                        !guadanDetail.getVIP_Card().equals("")) {
                                    initVIP(guadanDetail.getVIP_Card());
                                } else {
                                    PreferenceHelper.write(ac, "yunshangpu", "vip", false);
                                }
                                mShopLeftAdapter.notifyDataSetChanged();
                                jisuanAllPrice(false);
                            }
                            updateBttGetOrder();
                        }

                        @Override
                        public void onErrorResponse(Object msg) {
                            fragmentManager.beginTransaction().hide(qudanFragment).commit();
                            updateBttGetOrder();
                        }
                    });
                }
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
    }

    private void toJieSuan(OrderCanshhu jso, JiesuanBFragment.OrderType orderType) {
        String jifen = null == mVipMsg ? "0.00" : mVipMsg.getMA_AvailableIntegral() + "";
//        可抵扣金额 = 会员积分 / 积分抵扣百分比 * 积分支付限制百分比
        double dkmoney = CommonUtils.div(CommonUtils.div(CommonUtils.multiply(jifen,
                TextUtils.isEmpty(jinfenzfxzbfb) ? "0" : jinfenzfxzbfb), 100, 2),
                Double.parseDouble(TextUtils.isEmpty(jifendkbfb) ? "0" : jifendkbfb), 2);//可抵扣金额

        if (jiesuanBFragment == null) {
            jiesuanBFragment = new JiesuanBFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_content, jiesuanBFragment).commit();
        } else
            fragmentManager.beginTransaction().show(jiesuanBFragment).commit();
        jiesuanBFragment.setData(totalMoney, allmoney, mVipMsg,
                dkmoney + "", jso.getGID(), jso.getCO_Type(), jso.getCO_OrderCode(),
                mShopLeftList, moren, paytypelist, orderType, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        fragmentManager.beginTransaction().hide(jiesuanBFragment).commit();
                        if (response != null) {
                            String gid = (String) response;
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
                            resetCashier();
                        }
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                    }

                });
    }

    @BindView(R.id.btn_cashier)
    ImageView btn_cashier;
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
        switch (view.getId()) {
            case R.id.btn_cashier:
                btn_cashier.setImageResource(R.mipmap.btn_cashier_true);
                if (printSetFragment != null)
                    fragmentManager.beginTransaction().hide(printSetFragment).commit();
                break;
            case R.id.btn_home_set:
                btn_home_set.setImageResource(R.mipmap.btn_home_set_true);
                if (printSetFragment == null) {
                    printSetFragment = new PrintSetFragment();
                    printSetFragment.setData(shopInfoBean);
                    fragmentManager.beginTransaction().add(R.id.subsidiary_fragment, printSetFragment).commit();
                } else {
                    printSetFragment.setData(shopInfoBean);
                    fragmentManager.beginTransaction().show(printSetFragment).commit();
                }
                break;
            case R.id.btn_member:
                btn_member.setImageResource(R.mipmap.btn_member_true);
                break;
            case R.id.btn_goods:
                btn_goods.setImageResource(R.mipmap.btn_goods_true);
                break;
            case R.id.btn_sale:
                btn_sale.setImageResource(R.mipmap.btn_sale_true);
                break;
        }
    }

    @OnClick({R.id.subsidiary_fragment, R.id.rl_out, R.id.member_bg_layout, R.id.im_clear, R.id.btn_houtai})
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

                Intent intent = new Intent(ac, HtmlActivity.class);
                intent.putExtra("html_url", "https://pc.yunvip123.com/login.html");
                startActivity(intent);
                break;
            case R.id.subsidiary_fragment:
                break;
            case R.id.rl_out:
                mShowMemberPop = new ShowMemberPopWindow(HomeActivity.this, MyApplication.loginBean);
                mShowMemberPop.setOnItemClickListener(HomeActivity.this);
                mShowMemberPop.showAsDropDown(HomeActivity.this.findViewById(R.id.rl_out), -10, 0);
                break;
            case R.id.member_bg_layout:
                VipChooseDialog vipChooseDialog = new VipChooseDialog(HomeActivity.this, mVipMsg, new InterfaceBack() {
                    @Override
                    public void onResponse(Object response) {
                        mVipMsg = (VipInfoMsg) response;

                        if (mVipMsg != null) {
                            PreferenceHelper.write(ac, "yunshangpu", "vip", true);

                            mPD_Discount = obtainVipPD_Discount(mVipMsg.getVG_GID(), mVipMsg.getVGInfo());
                            jisuanAllPrice();

                            if (!TextUtils.isEmpty(mVipMsg.getVIP_Name())) {
                                vipNameLayout.setVisibility(View.VISIBLE);
                                ((TextView) vipNameLayout.getChildAt(0)).setText(mVipMsg.getVIP_Name().substring(0, 1));
                            } else {
                                com.blankj.utilcode.util.ToastUtils.showShort("会员名为空");
                            }
                        }
                    }

                    @Override
                    public void onErrorResponse(Object msg) {
                        mVipMsg = null;
                        vipNameLayout.setVisibility(View.GONE);
                        PreferenceHelper.write(ac, "yunshangpu", "vip", false);
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
                vipChooseDialog.show();
                break;
            case R.id.im_clear:
                //清空
                mShopLeftList.clear();
                mShopLeftAdapter.notifyDataSetChanged();
                order = CreateOrder.createOrder("SP");
                tv_ordernum.setText(order);
                mTvHeji.setText("0.00");
                tvShoukuan.setTag(0);
                ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
                tvNumTotal.setText("0");
                leftpos = -1;

                updateBttGetOrder();

                if (editCashierGoodsFragment != null)
                    fragmentManager.beginTransaction().hide(editCashierGoodsFragment).commit();
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

    private void initVIP(String VIP_Card) {
        ImpOnlyVipMsg onlyVipMsg = new ImpOnlyVipMsg();
        onlyVipMsg.vipMsg(ac, VIP_Card, new InterfaceBack() {
            @Override
            public void onResponse(Object response) {
                mVipMsg = (VipInfoMsg) response;

                if (mVipMsg != null) {
                    PreferenceHelper.write(ac, "yunshangpu", "vip", true);

//                mPD_Discount = obtainVipPD_Discount(mVipMsg.getVG_GID(), mVipMsg.getVGInfo());
//                jisuanDiscount(mPD_Discount, mShopLeftList);
                    if (!TextUtils.isEmpty(mVipMsg.getVIP_Name())) {
                        vipNameLayout.setVisibility(View.VISIBLE);
                        ((TextView) vipNameLayout.getChildAt(0)).setText(mVipMsg.getVIP_Name().substring(0, 1));
                    } else {
                        com.blankj.utilcode.util.ToastUtils.showShort("会员名为空");
                    }
                }
            }

            @Override
            public void onErrorResponse(Object msg) {

            }
        });
    }

    private void initGetOrder(RevokeGuaDanBean guadanDetail) {
        mShopLeftList.clear();
        for (RevokeGuaDanBean.ViewGoodsDetailBean msg : guadanDetail.getViewGoodsDetail()) {
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
                //setPM_IsDiscount
                if (msg.getGOD_Type() == 0) {
                    newmsg.setPM_IsService(0);
                } else if (msg.getGOD_Type() == 10) {
                    newmsg.setPM_IsService(1);
                    newmsg.setType(1);
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
                updateBttGetOrder();
            }
        }
    }

    public void updateBttGetOrder() {
        orderCountLayout.setVisibility(View.GONE);
        if (mShopLeftList.size() > 0) {
            bttGetOrder.setText("挂单[F1]");
        } else if (qudanFragment.getListCount() > 0) {
            orderCountLayout.setVisibility(View.VISIBLE);
            ((TextView) orderCountLayout.getChildAt(0)).setText(qudanFragment.getListCount() + "");
            bttGetOrder.setText("取单[F1]");
        }
    }

    private int obtainVipPD_Discount(String vg_gid, List<VipInfoMsg.VGInfoBean> sllist) {
        int PD_Discount = 0;
        for (int i = 0; i < sllist.size(); i++) {
            if (sllist.get(i).getVG_GID().equals(vg_gid)) {
                PD_Discount = sllist.get(i).getPD_Discount();
            }
        }

        return PD_Discount;
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
                    MyApplication.loginBean.setUM_ChatHead(String.valueOf(msg.obj));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMemberValueRefresh(HomeButtonColorChangeEvent notifyShopCarEvent) {
        if (notifyShopCarEvent.getMsg().equals("Change_color")) {
        }
    }

    ShopInfoBean shopInfoBean;

    public void getShopInfo() {
        ImpShopInfo impShopInfo = new ImpShopInfo();
        impShopInfo.shopInfo(ac, new InterfaceBack<ShopInfoBean>() {
            @Override
            public void onResponse(ShopInfoBean response) {
                shopInfoBean = response;
            }
        });
    }

    private void resetCashier() {
        mShopLeftList.clear();
        mShopLeftAdapter.notifyDataSetChanged();
        order = CreateOrder.createOrder("SP");
        tv_ordernum.setText(order);
        mVipMsg = null;
        vipNameLayout.setVisibility(View.GONE);
        PreferenceHelper.write(ac, "yunshangpu", "vip", false);
        mTvHeji.setText("0.00");
        tvShoukuan.setTag(0);
        ((TextView) tvShoukuan.getChildAt(0)).setText("快速收银[Enter]");
        tvNumTotal.setText("0");
        updateBttGetOrder();

        if (editCashierGoodsFragment != null)
            fragmentManager.beginTransaction().hide(editCashierGoodsFragment).commit();
    }

}

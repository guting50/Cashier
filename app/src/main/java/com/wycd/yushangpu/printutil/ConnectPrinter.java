package com.wycd.yushangpu.printutil;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gt.utils.PermissionUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.DeviceReceiver;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PrintContent;
import com.wycd.yushangpu.tools.ThreadPool;

import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.PosPrinterDev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.myBinder;
import static com.wycd.yushangpu.printutil.GetPrintSet.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.printutil.GetPrintSet.ISCONNECT;
import static com.wycd.yushangpu.printutil.GetPrintSet.ISLABELCONNECT;
import static com.wycd.yushangpu.tools.DeviceConnFactoryManager.PrinterCommand.TSC;

@SuppressLint("CheckResult")
public class ConnectPrinter {

    private static int printerId = 0;
    private static BroadcastReceiver receiver;
    public static int rbType = 0;//0:usb pos打印机 1：usb标签打印机 2：蓝牙打印机
    public static String connectState = "";
    public static Consumer consumer;
    public static Observable<String> observable;

    static {
        observable = Observable.create(emitter -> {
            emitter.onNext(connectState);
        });
        observable.observeOn(AndroidSchedulers.mainThread());
    }

    public static void connect(Activity activity) {
        initBroadcast(activity);
        initPrint(activity);
    }

    private static void initPrint(Activity activity) {
        String ReceiptUSBName = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
        if (!TextUtils.isEmpty(ReceiptUSBName)) {
            myBinder.ConnectUsbPort(activity, ReceiptUSBName, new TaskCallback() {
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
            String BlueToothAddress = CacheDoubleUtils.getInstance().getString("BlueToothAddress");
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            //判断是否打开蓝牙设备
            if (bluetoothAdapter.isEnabled() && !TextUtils.isEmpty(BlueToothAddress)) {
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
        String LabelUSBName = CacheDoubleUtils.getInstance().getString("LabelUSBName");
        if (!TextUtils.isEmpty(LabelUSBName)) {
            UsbDevice usbDevice = getUsbDeviceFromName(activity, LabelUSBName);
            new DeviceConnFactoryManager.Build()
                    .setId(printerId)
                    .setConnMethod(DeviceConnFactoryManager.CONN_METHOD.USB)
                    .setUsbDevice(usbDevice)
                    .setContext(activity)
                    .build();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].openPort();
        }
    }

    /**
     * 注册广播
     * Registration broadcast
     */
    private static void initBroadcast(Activity activity) {
        try {
            IntentFilter filter = new IntentFilter("com.android.example.USB_PERMISSION");//USB访问权限广播
            filter.addAction(ACTION_USB_DEVICE_DETACHED);//USB线拔出
//        filter.addAction(ACTION_QUERY_PRINTER_STATE);//查询打印机缓冲区状态广播，用于一票一控
            filter.addAction(DeviceConnFactoryManager.ACTION_CONN_STATE);//与打印机连接状态
            filter.addAction(ACTION_USB_DEVICE_ATTACHED);//USB线插入
            activity.registerReceiver(receiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    try {
                        String action = intent.getAction();
                        switch (action) {
                            //USB请求访问权限
                            case "com.android.example.USB_PERMISSION":
                                synchronized (activity) {
                                    UsbDevice device = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                                        if (device != null) {//用户点击授权
                                            switch (rbType) {
                                                case 0:
                                                    connectUSB(activity, device.getDeviceName());
                                                    break;
                                                case 1:
                                                    closeport();
                                                    connectLabelUSB(activity, device);
                                                    break;
                                            }
                                        }
                                    } else {//用户点击不授权,则无权限访问USB
                                        ToastUtils.showLong("No access to USB");
                                    }
                                }
                                break;
                            //Usb连接断开广播
                            case ACTION_USB_DEVICE_DETACHED: {
                                UsbDevice usbDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                                String ReceiptUSBName = CacheDoubleUtils.getInstance().getString("ReceiptUSBName");
                                if (TextUtils.equals(ReceiptUSBName, usbDevice.getDeviceName()) && rbType == 0) {
                                    ISCONNECT = false;
                                    connectState = "未连接";
                                    observable.subscribe(consumer);
                                }
                                String LabelUSBName = CacheDoubleUtils.getInstance().getString("LabelUSBName");
                                if (TextUtils.equals(LabelUSBName, usbDevice.getDeviceName()) && rbType == 1) {
                                    ISLABELCONNECT = false;
                                    connectState = "未连接";
                                    observable.subscribe(consumer);

                                }
                            }
                            break;
                            //Usb连接广播
                            case ACTION_USB_DEVICE_ATTACHED:
                                UsbDevice usbDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                                ToastUtils.showLong("打印机连接中");
                                connectState = "连接中";
                                observable.subscribe(consumer);
                                authorizationConnectUSB(activity, usbDevice.getDeviceName());
                                break;
                            case DeviceConnFactoryManager.ACTION_CONN_STATE:
                                int state = intent.getIntExtra(DeviceConnFactoryManager.STATE, -1);
                                int deviceId = intent.getIntExtra(DeviceConnFactoryManager.DEVICE_ID, -1);
                                switch (state) {
                                    case DeviceConnFactoryManager.CONN_STATE_DISCONNECT:
                                        if (printerId == deviceId) {
                                            Log.e("ConnectPrinter", "connection is lost");
                                        }
                                        break;
                                    case DeviceConnFactoryManager.CONN_STATE_CONNECTING:
                                        ToastUtils.showLong("打印机连接中");
                                        connectState = "连接中";
                                        observable.subscribe(consumer);
                                        break;
                                    case DeviceConnFactoryManager.CONN_STATE_CONNECTED:
                                        ToastUtils.showLong("打印机连接成功");
                                        ISLABELCONNECT = true;
                                        String deviceName = DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].usbDevice().getDeviceName();
                                        CacheDoubleUtils.getInstance().put("LabelUSBName", deviceName);
                                        connectState = activity.getString(R.string.con_success);
                                        observable.subscribe(consumer);
                                        break;
                                    case DeviceConnFactoryManager.CONN_STATE_FAILED:
                                        ToastUtils.showLong("打印机连接失败");
                                        ISLABELCONNECT = false;
                                        connectState = activity.getString(R.string.con_failed);
                                        observable.subscribe(consumer);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void authorizationConnectUSB(Activity activity, String usbAddress) {
        UsbManager usbManager = (UsbManager) activity.getSystemService(Context.USB_SERVICE);
        //通过USB设备名找到USB设备
        UsbDevice usbDevice = getUsbDeviceFromName(activity, usbAddress);
        //判断USB设备是否有权限
        if (usbManager.hasPermission(usbDevice)) {
            switch (rbType) {
                case 0:
                    connectUSB(activity, usbAddress);
                    break;
                case 1:
                    closeport();
                    connectLabelUSB(activity, usbDevice);
                    break;
            }
        } else {//请求权限
            PendingIntent mPermissionIntent = PendingIntent.getBroadcast(activity, 0,
                    new Intent("com.android.example.USB_PERMISSION"), 0);
            usbManager.requestPermission(usbDevice, mPermissionIntent);
        }
    }

    /**
     * 连接usb
     */
    public static void connectUSB(Activity activity, final String usbAddress) {
        myBinder.ConnectUsbPort(activity, usbAddress, new TaskCallback() {
            @Override
            public void OnSucceed() {
                ISCONNECT = true;
                ISBULETOOTHCONNECT = false;
                CacheDoubleUtils.getInstance().put("ReceiptUSBName", usbAddress);
                connectState = activity.getString(R.string.con_success);
                observable.subscribe(consumer);
            }

            @Override
            public void OnFailed() {
                ISCONNECT = false;
                connectState = activity.getString(R.string.con_failed);
                observable.subscribe(consumer);
            }
        });
    }

    /**
     * USB连接标签打印机
     */
    public static void connectLabelUSB(Activity activity, UsbDevice usbDevice) {
        new DeviceConnFactoryManager.Build()
                .setId(printerId)
                .setConnMethod(DeviceConnFactoryManager.CONN_METHOD.USB)
                .setUsbDevice(usbDevice)
                .setContext(activity)
                .build();
        DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].openPort();
    }

    private static final int CONN_PRINTER = 0x12;

    /**
     * 打印标签
     */
    public static void labelPrint(final ShopMsg shopMsg) {
        ThreadPool.getInstantiation().addSerialTask(() -> {
            if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId] == null ||
                    !DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].getConnState()) {
//                    cashierFragment.obtainMessage(CONN_PRINTER).sendToTarget();
                return;
            }
            if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].getCurrentPrinterCommand() == TSC) {
                DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].sendDataImmediately(PrintContent.getLabel(shopMsg));
            }
        });
    }

    /**
     * 重新连接回收上次连接的对象，避免内存泄漏
     */
    private static void closeport() {
        if (DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId] != null &&
                DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].mPort != null) {
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].reader.cancel();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].mPort.closePort();
            DeviceConnFactoryManager.getDeviceConnFactoryManagers()[printerId].mPort = null;
        }
    }

    public static UsbDevice getUsbDeviceFromName(Context context, String usbName) {
        UsbManager usbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> usbDeviceList = usbManager.getDeviceList();
        return usbDeviceList.get(usbName);
    }


    /**
     * 获取标签USB列表
     */
    public static void setUSB(Activity activity, TextView mTvPrint) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View dialogView3 = inflater.inflate(R.layout.usb_link, null);
        TextView tv_usb = (TextView) dialogView3.findViewById(R.id.textView1);
        ListView lv_usb = (ListView) dialogView3.findViewById(R.id.listView1);

        List<String> usbList = PosPrinterDev.GetUsbPathNames(activity);
        if (usbList == null) {
            usbList = new ArrayList<>();
        }

        tv_usb.setText(activity.getString(R.string.usb_pre_con) + usbList.size());
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, usbList);
        lv_usb.setAdapter(adapter3);

        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setView(dialogView3).create();
        dialog.show();

        lv_usb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTvPrint.setText(adapter3.getItem(i));
                ConnectPrinter.authorizationConnectUSB(activity, adapter3.getItem(i));
                dialog.cancel();
            }
        });
    }

    /**
     * 选择蓝牙设备
     */
    public static void setBluetooth(Activity activity, TextView mTvPrint) {
        List<String> btList = new ArrayList<>();
        ArrayList<String> btFoundList = new ArrayList<>();

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //判断是否打开蓝牙设备
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
            setBluetooth(activity, mTvPrint);
            return;
        }
        if (!bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.startDiscovery();
        }
        PermissionUtils.requestPermission(activity, PermissionUtils.ACCESS_COARSE_LOCATION, new PermissionUtils.PermissionGrant() {
            @Override
            public void onPermissionGranted(int... requestCode) {
                PermissionUtils.requestPermission(activity, PermissionUtils.ACCESS_FINE_LOCATION, new PermissionUtils.PermissionGrant() {
                    @Override
                    public void onPermissionGranted(int... requestCode) {
                        LayoutInflater inflater = LayoutInflater.from(activity);
                        View BtDialogView = inflater.inflate(R.layout.printer_list, null);
                        ArrayAdapter<String> btBoudAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, btList);
                        ListView btBoundLv = (ListView) BtDialogView.findViewById(R.id.listView1);
                        Button btScan = (Button) BtDialogView.findViewById(R.id.btn_scan);
                        LinearLayout ll_BtFound = (LinearLayout) BtDialogView.findViewById(R.id.ll1);
                        ListView btFoundLv = (ListView) BtDialogView.findViewById(R.id.listView2);
                        ArrayAdapter<String> btfoundAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, btFoundList);
                        btBoundLv.setAdapter(btBoudAdapter);
                        btFoundLv.setAdapter(btfoundAdapter);
                        AlertDialog btdialog = new AlertDialog.Builder(activity).setView(BtDialogView).create();
                        btdialog.show();

                        DeviceReceiver btReciever = new DeviceReceiver(btFoundList, btfoundAdapter, btFoundLv);

                        //注册蓝牙广播接收者
                        IntentFilter filterStart = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                        IntentFilter filterEnd = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
                        activity.registerReceiver(btReciever, filterStart);
                        activity.registerReceiver(btReciever, filterEnd);

                        btScan.setOnClickListener(v -> {
                            // TODO Auto-generated method stub
                            ll_BtFound.setVisibility(View.VISIBLE);
                        });
                        //已配对的设备的点击连接
                        btBoundLv.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
                            // TODO Auto-generated method stub
                            try {
                                if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                                    bluetoothAdapter.cancelDiscovery();
                                }
                                String mac = btList.get(arg2);
                                mTvPrint.setText(mac.substring(0, mac.indexOf("\n")));
                                connectState = "连接中";
                                observable.subscribe(consumer);
                                btdialog.cancel();
                                connectBT(activity, mac.substring(0, mac.indexOf("\n")), mac.substring(mac.length() - 17));
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                LogUtils.e("======== Error ========", e.getMessage());
                            }
                        });
                        //未配对的设备，点击，配对，再连接
                        btFoundLv.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
                            // TODO Auto-generated method stub
                            try {
                                if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                                    bluetoothAdapter.cancelDiscovery();
                                }
                                String msg = btFoundList.get(arg2);
                                mTvPrint.setText(msg.substring(0, msg.indexOf("\n")));
                                connectState = "连接中";
                                observable.subscribe(consumer);
                                btdialog.cancel();
                                connectBT(activity, msg.substring(0, msg.indexOf("\n")), msg.substring(msg.length() - 17));
                                Log.i("TAG", "mac=" + msg);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                LogUtils.e("======== Error ========", e.getMessage());
                            }
                        });
                        //获取可配对蓝牙设备
                        Set<BluetoothDevice> device = bluetoothAdapter.getBondedDevices();

                        btList.clear();
                        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                            btBoudAdapter.notifyDataSetChanged();
                        }
                        if (device.size() > 0) {
                            //存在已经配对过的蓝牙设备
                            for (Iterator<BluetoothDevice> it = device.iterator(); it.hasNext(); ) {
                                BluetoothDevice btd = it.next();
                                btList.add(btd.getName() + '\n' + btd.getAddress());
                                btBoudAdapter.notifyDataSetChanged();
                            }
                        } else {  //不存在已经配对过的蓝牙设备
                            btList.add("不存在已经配对过的蓝牙设备");
                            btBoudAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
    }

    /**
     * 连接蓝牙
     */
    public static void connectBT(Activity activity, final String btName, final String btAddress) {
        if (btAddress.equals("")) {
            connectState = activity.getString(R.string.con_failed);
            observable.subscribe(consumer);
        } else {
            myBinder.ConnectBtPort(btAddress, new TaskCallback() {
                @Override
                public void OnSucceed() {
                    ISBULETOOTHCONNECT = true;
                    ISCONNECT = false;
                    CacheDoubleUtils.getInstance().put("BlueToothName", btName);
                    CacheDoubleUtils.getInstance().put("BlueToothAddress", btAddress);
                    connectState = activity.getString(R.string.con_success);
                    observable.subscribe(consumer);
                }

                @Override
                public void OnFailed() {
                    ISBULETOOTHCONNECT = false;
                    connectState = activity.getString(R.string.con_failed);
                    observable.subscribe(consumer);
                }
            });
        }
    }

    public static void unregisterReceiver(Activity activity) {
        try {
            activity.unregisterReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

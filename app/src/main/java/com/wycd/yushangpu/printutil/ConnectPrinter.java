package com.wycd.yushangpu.printutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.tools.DeviceConnFactoryManager;
import com.wycd.yushangpu.tools.PrintContent;
import com.wycd.yushangpu.tools.ThreadPool;

import net.posprinter.posprinterface.TaskCallback;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_ATTACHED;
import static android.hardware.usb.UsbManager.ACTION_USB_DEVICE_DETACHED;
import static com.wycd.yushangpu.MyApplication.ISBULETOOTHCONNECT;
import static com.wycd.yushangpu.MyApplication.ISCONNECT;
import static com.wycd.yushangpu.MyApplication.ISLABELCONNECT;
import static com.wycd.yushangpu.MyApplication.myBinder;
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

    public static void unregisterReceiver(Activity activity) {
        activity.unregisterReceiver(receiver);
    }
}

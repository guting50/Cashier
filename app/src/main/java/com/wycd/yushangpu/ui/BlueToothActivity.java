package com.wycd.yushangpu.ui;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wycd.yushangpu.R;
import com.wycd.yushangpu.adapter.BlueToothListAdapter;
import com.wycd.yushangpu.widget.dialog.NoticeDialog;
import com.wycd.yushangpu.http.InterfaceBack;
import com.wycd.yushangpu.printutil.uSharedPreferencesUtiles;
import com.wycd.yushangpu.tools.NoDoubleClickListener;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BlueToothActivity extends BaseActivity {
    private ListView mLvBluetooth;//蓝牙设备列表控件
    private Button mBtnScanBluetooth;//扫描蓝牙按钮
    private ImageView mIvBack;//返回按钮

    private BluetoothAdapter mBluetoothAdapter;//蓝牙适配器
    private static final UUID BLUETOOTH_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");//串口全局唯一标识符
    private BluetoothDevice mDevice;//蓝牙设备
    private BluetoothSocket mBluetoothSocket;//蓝牙通信端口
    private OutputStream mOutputStream;//输出数据流

    private static byte[] mData;//接受打印小票数据的字节码
    private int recepits_num;//存在本地的循环打印次数
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private List<Map<String, String>> list_bluedevice = new ArrayList<>();
    private List<String> list_device_name = new ArrayList<>();//蓝牙名称列表
    private Map<String, String> map_bluedevice = new HashMap<>();//蓝牙名称、mac地址集合
    private String mBluetoothName;//已经连接的蓝牙设备名称

    public BlueToothActivity() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }


    private void assignViews() {
        mIvBack = (ImageView) findViewById(R.id.iv_bluetooth_back);
        mLvBluetooth = (ListView) findViewById(R.id.lv_bluetooth);
        mBtnScanBluetooth = (Button) findViewById(R.id.btn_scan_bluetooth);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);

        mSharedPreferences = getSharedPreferences("bluetooth_address", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                //不透明状态栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                getWindow().setStatusBarColor(getResources().getColor(R.color.yunpu));
//            }
//        }

        assignViews();
        initListener();
        checkBlueToothSupportSwitch();


        try {
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
            IntentFilter filter2 = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
            IntentFilter filter3 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED);
            this.registerReceiver(receiver, filter);
            this.registerReceiver(receiver, filter1);
            this.registerReceiver(receiver, filter2);
            this.registerReceiver(receiver, filter3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 检查设备是否支持蓝牙
     */
    @SuppressLint("WrongConstant")
    private void checkBlueToothSupportSwitch() {
        if (mBluetoothAdapter != null) {
            blueToothIsSwitch();
        } else {
            Toast.makeText(this, "改设备不支持蓝牙", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 判断蓝牙开关是否打开
     */
    private void blueToothIsSwitch() {

        if (!mBluetoothAdapter.isEnabled()) {
            NoticeDialog.noticeDialog(ac, "友情提示", "蓝牙未开启，确定要开启吗？", 1, new InterfaceBack(){
                @Override
                public void onResponse(Object response) {
                    mBluetoothAdapter.enable();
                    getBoundedDevices();
                }

                @Override
                public void onErrorResponse(Object msg) {
                }
            });
        } else {
            getBoundedDevices();
        }
    }


    /**
     * 获得已配对的蓝牙设备信息并保存
     */
    private void getBoundedDevices() {
        Set<BluetoothDevice> devices_set = mBluetoothAdapter.getBondedDevices();
        map_bluedevice.clear();
        list_bluedevice.clear();
        list_device_name.clear();
        if (devices_set.size() > 0) {
            for (BluetoothDevice device : devices_set) {
                map_bluedevice.put(device.getName(), device.getAddress());
                list_bluedevice.add(map_bluedevice);
                list_device_name.add(device.getName());
            }

            mLvBluetooth.setAdapter(new BlueToothListAdapter(ac, list_device_name));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mBluetoothName != null) {
                mBluetoothAdapter.cancelDiscovery();
                Intent intent = new Intent();
                intent.putExtra("bluetooth", mBluetoothName);
                ac.setResult(666, intent);
            }
            finish();
        }
        return true;
    }


    private void initListener() {
        //扫描蓝牙
        mBtnScanBluetooth.setOnClickListener(new NoDoubleClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onNoDoubleClick(View v) {
                blueToothIsSwitch();

                if (!mBluetoothAdapter.isEnabled()) {
                    return;
                }
                //判断是否正在扫描
                if (!mBluetoothAdapter.isDiscovering()) {
                    Toast.makeText(ac, "扫描蓝牙...", Toast.LENGTH_SHORT).show();
                    mBluetoothAdapter.startDiscovery();
                }
            }
        });

        //返回
        mIvBack.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                mBluetoothAdapter.cancelDiscovery();
                if (mBluetoothName != null) {
                    Intent intent = new Intent();
                    intent.putExtra("bluetooth", mBluetoothName);
                    uSharedPreferencesUtiles.put(ac, "BluetoothName", mBluetoothName);
                    BlueToothActivity.this.setResult(666, intent);
                }
                finish();
            }
        });

        //蓝牙列表
        mLvBluetooth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final TextView tv = (TextView) view.findViewById(R.id.tv_connect_state);
                final ImageView iv = (ImageView) view.findViewById(R.id.iv_bluetooth_connect);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (mBluetoothAdapter.isDiscovering()) {
                                mBluetoothAdapter.cancelDiscovery();
                            }

                            mDevice = mBluetoothAdapter.getRemoteDevice(map_bluedevice.get(list_device_name.get(i)));
                            mBluetoothSocket = mDevice.createRfcommSocketToServiceRecord(BLUETOOTH_UUID);
                            if (mBluetoothSocket != null) {
                                mBluetoothSocket.connect();
                            }
                            mEditor.putString("address", map_bluedevice.get(list_device_name.get(i)));
                            mEditor.commit();
                            mBluetoothName = list_device_name.get(i);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText("连接成功");

                                    iv.setImageResource(R.mipmap.bluetooth_connected48);

                                    Toast.makeText(ac, "连接成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            mBluetoothSocket = null;
                            mDevice = null;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mBluetoothName = "";
                                    Toast.makeText(ac, "连接失败", Toast.LENGTH_SHORT).show();

                                    tv.setText("点击连接");

                                    iv.setImageResource(R.mipmap.bluetooth_disconnect48);
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @SuppressLint("WrongConstant")
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
                Log.d(TAG, "ACTION_ACL_CONNECTED: ");
                mBluetoothAdapter.getState();
            }

            if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                Log.d(TAG, "ACTION_BOND_STATE_CHANGED: ");
            }

            if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
                Log.d(TAG, "ACTION_ACL_DISCONNECTED: ");
            }

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                Toast.makeText(ac, "扫描完毕", Toast.LENGTH_SHORT).show();

                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                //判断该device的状态是否是已绑定的设备
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    list_device_name.clear();

                    map_bluedevice.put(device.getName(), device.getAddress());

                    Set<String> key = map_bluedevice.keySet();
                    Iterator<String> device_name = key.iterator();
                    while (device_name.hasNext()) {
                        list_device_name.add(device_name.next());

                    }
                    if (list_device_name.get(0)==null){
                        list_device_name.remove(0);

                    }
                    list_bluedevice.add(map_bluedevice);
                    mLvBluetooth.setAdapter(new BlueToothListAdapter(BlueToothActivity.this, list_device_name));
                    new BlueToothListAdapter(BlueToothActivity.this, list_device_name).notifyDataSetChanged();
                    mBluetoothAdapter.cancelDiscovery();
                }
            }
        }
    };

    private Runnable mRunnable = new Runnable() {
        @SuppressLint("WrongConstant")
        @Override
        public void run() {
            for (int i = 1; i <= recepits_num; i++) {
                try {
                    mOutputStream = mBluetoothSocket.getOutputStream();
                    mOutputStream.write(mData, 0, mData.length);
                    mOutputStream.flush();
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(ac, "发送失败！", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };


    /**
     * 发送数据
     */
    @SuppressLint("WrongConstant")
    public void send(byte[] data, int recepits_num, SharedPreferences preferences) {
        if (recepits_num == 0) {
            this.recepits_num = 0;
        } else {
            this.recepits_num = recepits_num;
        }

        try {
            if (preferences == null || preferences.getString("address", "").equals("")) {
                return;
            }
            mDevice = mBluetoothAdapter.getRemoteDevice(preferences.getString("address", ""));
            mBluetoothSocket = mDevice.createRfcommSocketToServiceRecord(BLUETOOTH_UUID);
            mBluetoothSocket.connect();
            mData = data;
            new Thread(mRunnable).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消蓝牙搜索
        mBluetoothAdapter.cancelDiscovery();
        this.unregisterReceiver(receiver);
    }

}

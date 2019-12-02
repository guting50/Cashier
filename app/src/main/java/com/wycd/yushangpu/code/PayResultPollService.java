package com.wycd.yushangpu.code;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import com.wycd.yushangpu.http.UrlTools;
import com.wycd.yushangpu.tools.LogUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;

public class PayResultPollService extends Service {
    private Intent intent = new Intent("com.example.communication.RECEIVER");
//	1457573655

    private final IBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public PayResultPollService getService() {
            return PayResultPollService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
//		get
//		getPayResult();
//
//		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//		int anHour =30 * 1000; // 这是一小时的毫秒数 60 * 60 * 1000
//		long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
//		Intent i = new Intent(this, AlarmReceiver.class);
//		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
//		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return null;
    }

    @Override
    public void onCreate() {
        // TODO 自动生成的方法存根
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO 自动生成的方法存根
      String payway=  PreferenceHelper.readString(getApplicationContext(), "lottery", "payway", "ali");
        if(payway.equals("ali")){
            getAliPayResult();
        }else{
            getWxPayResult();
        }
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        String s = PreferenceHelper.readString(getApplicationContext(), "PayOk", "time", "false");
        if (s.equals("true")) {
            int anHour = 2 * 1000; // 这是一小时的毫秒数 60 * 60 * 1000
            long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
            Intent i = new Intent(this, AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
//			manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
            manager.cancel(pi);
        } else {
            int anHour = 2 * 1000; // 这是一小时的毫秒数 60 * 60 * 1000
            long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
            Intent i = new Intent(this, AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void getAliPayResult() {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(getApplicationContext());
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("zfborder", PreferenceHelper.readString(getApplicationContext(), "lottery", "aliOrder", ""));
        LogUtils.d("xxali", params.toString());
        client.post(UrlTools.obtainUrl("jhzf/zfbpay/queryZfborder"), params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Log.d("xxalinotifyS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getInt("code") == 0) {
                        intent.putExtra("success", "success");
                        sendBroadcast(intent);
                        stopSelf();
                    } else {

                        intent.putExtra("success", "false");
                        sendBroadcast(intent);
                        stopSelf();

                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    intent.putExtra("success", "Error");
                    sendBroadcast(intent);
                    stopSelf();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
    }
    private void getWxPayResult() {
        AsyncHttpClient client = new AsyncHttpClient();
        final PersistentCookieStore myCookieStore = new PersistentCookieStore(getApplicationContext());
        client.setCookieStore(myCookieStore);
        RequestParams params = new RequestParams();
        params.put("wxorder", PreferenceHelper.readString(getApplicationContext(), "lottery", "wxOrder", ""));
        LogUtils.d("xxali", params.toString());
        client.post(UrlTools.obtainUrl("jhzf/wxpay/queryWxorder"), params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Log.d("xxwxnotifyS", new String(responseBody, "UTF-8"));
                    JSONObject jso = new JSONObject(new String(responseBody, "UTF-8"));
                    if (jso.getInt("code") == 0) {
                        intent.putExtra("success", "success");
                        sendBroadcast(intent);
                        stopSelf();
                    } else {

                        intent.putExtra("success", "false");
                        sendBroadcast(intent);
                        stopSelf();

                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    intent.putExtra("success", "Error");
                    sendBroadcast(intent);
                    stopSelf();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        // TODO 自动生成的方法存根
        super.onDestroy();
        Log.d("service", "onDestroy");
    }
}

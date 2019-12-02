package com.wycd.yushangpu.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.wycd.yushangpu.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;
    private Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent("com.shoppay.wy.wxpayok");
        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);
        try {
            api.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;
        //有时候支付结果还需要发送给服务器确认支付状态
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (resp.errCode == 0) {
                Toast.makeText(this, getApplication().getResources().getString(R.string.recharge_successful), Toast.LENGTH_LONG).show();
                sendBroadcast(intent);
                finish();
            } else if (resp.errCode == -2) {
                Toast.makeText(this,  getApplication().getResources().getString(R.string.recharge_cancellation), Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this,  getApplication().getResources().getString(R.string.recharge_failed), Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

}

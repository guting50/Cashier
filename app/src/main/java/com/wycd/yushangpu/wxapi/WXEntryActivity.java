package com.wycd.yushangpu.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.tools.LogUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Created by songxiaotao on 2018/7/19.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            MyApplication.mWxApi.handleIntent(getIntent(), this);
        } catch (Exception e) {

        }

    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        MyApplication.mWxApi.handleIntent(getIntent(), this);
//    }

    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq req) {
    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    //app发送消息给微信，处理返回消息的回调
    @Override
    public void onResp(BaseResp resp) {
        LogUtils.d("xxxx", new Gson().toJson(resp));
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {//支付
            int errCode = resp.errCode;
//            if (errCode == 0) {//支付成功
//                Intent in = new Intent(getApplicationContext(), PayResultActivity.class);
//                in.putExtra("type","pay");
//                in.putExtra("result", "OK");
//                startActivity(in);
//               finish();
//            } else {//支付失败
//                Intent in = new Intent(getApplicationContext(), PayResultActivity.class);
//                in.putExtra("type","pay");
//                in.putExtra("result", "Flase");
//                startActivity(in);
//                finish();
//            }
        } else if (resp.getType() == ConstantsAPI.COMMAND_SENDMESSAGE_TO_WX) {//分享
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK://分享成功
                    finish();
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL://取消分享
                    finish();
                    break;
                case BaseResp.ErrCode.ERR_SENT_FAILED://分享失败
                    finish();
                    break;
                default://未知原因
                    finish();
                    break;
            }
        } else if (resp.getType() == ConstantsAPI.COMMAND_SENDAUTH) {//登录
            if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
                String code = ((SendAuth.Resp) resp).code;
                Intent intent = new Intent("com.hengzhong.luliang.login");
                intent.putExtra("success", "success");
                intent.putExtra("type", "wx");
                intent.putExtra("openId", code);
                sendBroadcast(intent);
                finish();
            } else {
                Intent intent = new Intent("com.hengzhong.luliang.login");
                intent.putExtra("success", "false");
                intent.putExtra("type", "wx");
                intent.putExtra("openId", "");
                sendBroadcast(intent);
                finish();
            }
//            switch (resp.errCode) {
//                case BaseResp.ErrCode.ERR_OK://登录成功
//                    break;
//                case BaseResp.ErrCode.ERR_USER_CANCEL://取消登录
//                    break;
//                case BaseResp.ErrCode.ERR_SENT_FAILED://登录失败
//                    break;
//                default://未知原因
//
//                    break;
//            }
        }

    }
}

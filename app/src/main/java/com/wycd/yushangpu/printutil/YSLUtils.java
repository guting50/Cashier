package com.wycd.yushangpu.printutil;

import com.wycd.yushangpu.bean.SmsSwitch;
import com.wycd.yushangpu.tools.CacheData;

public class YSLUtils {

    /**
     * 短信开关
     */
    private static SmsSwitch smsSwitch;


    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    /**
     * @return ，
     * 获取开关
     */
    public static SmsSwitch.DataBean getSmsSwitch(String code) {
        if (smsSwitch == null) {
            smsSwitch = null;
        }
        smsSwitch = (SmsSwitch) CacheData.restoreObject("shortmessage");
        if (smsSwitch!=null){
            for (int i=0;i<smsSwitch.getData().size();i++){
                if (smsSwitch.getData().get(i).getST_Code().equals(code)){//商品消费011 快速消费 010 计次消费 012  礼品兑换 013 添加会员001  会员充值 002 会员充次003 积分变动007
                    return smsSwitch.getData().get(i);
                }
            }
        }
        return null;
    }

    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }

}

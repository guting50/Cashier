package com.wycd.yushangpu.printutil;

import android.content.Intent;


/**
 * 作者：罗咏哲 on 2017/10/4 21:13.
 * 邮箱：137615198@qq.com
 */

public interface Presenter {
    void onCreate(String s);

    void attachIncomingIntent(Intent intent);//暂时没用到

    void attachView(IBaseView view);

}

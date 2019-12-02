package com.wycd.yushangpu.printutil;


import com.wycd.yushangpu.printutil.bean.PrintSetBean;

/**
 * 作者：罗咏哲 on 2017/10/24 17:41.
 * 邮箱：137615198@qq.com
 */

public interface IPrintSetView extends IBaseView {
    void getPrintSetSuccess(PrintSetBean bean);

    void getPrintSetFail(String result);

    void saveSetSuccess();

    void saveSetFail(String result);
}

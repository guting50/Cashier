package com.wycd.yushangpu.printutil;


import com.wycd.yushangpu.printutil.bean.CK_Success_Bean;
import com.wycd.yushangpu.printutil.bean.HandDutyBean;
import com.wycd.yushangpu.printutil.bean.Print_HYCC_Bean;
import com.wycd.yushangpu.printutil.bean.Print_HYCZ_Bean;
import com.wycd.yushangpu.printutil.bean.Print_HYKK_Bean;
import com.wycd.yushangpu.printutil.bean.Print_JCXF_Bean;
import com.wycd.yushangpu.printutil.bean.Print_JFDH_Bean;
import com.wycd.yushangpu.printutil.bean.Print_KSXF_Bean;
import com.wycd.yushangpu.printutil.bean.Print_SPTH_Bean;
import com.wycd.yushangpu.printutil.bean.Print_SPXF_Bean;
import com.wycd.yushangpu.printutil.bean.RK_Success_Bean;

/**
 * 打印小票接口
 * iauthor：Yc
 * date: 2017/7/26 09:52
 * email：jasoncheng9111@gmail.com
 */
public interface IPrinterSetContents {
    /********************快速消费*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_KSXF(Print_KSXF_Bean printBean);



    /********************商品消费*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_SPXF(Print_SPXF_Bean printBean);




    /********************会员充值*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_HYCZ(Print_HYCZ_Bean printBean);



    /********************会员充次*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_HYCC(Print_HYCC_Bean printBean);



    /********************计次消费*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_JCXF(Print_JCXF_Bean printBean);



    /********************积分兑换*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_JFDH(Print_JFDH_Bean printBean);




    /********************会员开卡*******************/
    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_HYKK(Print_HYKK_Bean printBean);

    /********************商品入库*******************/
    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_RK(RK_Success_Bean printBean);

    /********************商品出库*******************/
    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_CK(CK_Success_Bean printBean);


    /********************交班*******************/
    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_JB(HandDutyBean printBean);

    /********************商品退货*******************/

    /**
     * 蓝牙打印sunmi机器
     */
    byte[] printBlueTooth_SPTH(Print_SPTH_Bean printBean);
}

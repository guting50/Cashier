package com.wycd.yushangpu.printutil;


import android.app.Activity;
import android.content.Context;

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
import com.wycd.yushangpu.ui.BlueToothActivity;



/**
 * 打印小票
 * iauthor：Yc
 * date: 2017/6/25 14:17
 * email：jasoncheng9111@gmail.com
 */
public class PrinterUtils {
    private static int mReceitsNum;//打印小票数量
    private Activity mContext;
    private static BlueToothActivity mBlueToothActivity;
    private Object mPrintBean;
    private PrinterSetContentsImpl mPrinterSetContents;//设置打印小票的内容和格式
    private String mIsConsumeName = "";//判断是哪一个消费模块

    public PrinterUtils(Activity context, int receitsNum, Object printBean, String isConsumeName) {
        this.mContext = context;
        mReceitsNum = receitsNum;
        this.mPrintBean = printBean;
        this.mIsConsumeName = isConsumeName;
        this.mPrinterSetContents = new PrinterSetContentsImpl(mContext);
        this.mBlueToothActivity = new BlueToothActivity();
    }



    /**
     * 打印小票
     */
    public void print() {

        switch (mIsConsumeName) {
            //快速消费
            case "KSXF":


                    byte[] bytes = mPrinterSetContents.printBlueTooth_KSXF((Print_KSXF_Bean) mPrintBean);
                    //发送小票格式数据开始打印
                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;
            //会员充值
            case "HYCZ":


                    //配置【会员充值】非拉卡拉、世麦POS机器的小票格式
                     bytes = mPrinterSetContents.printBlueTooth_HYCZ((Print_HYCZ_Bean) mPrintBean);
                    //发送小票格式数据开始打印
                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;
            //会员充次
            case "HYCC":

                    //配置【会员充次】非拉卡拉、世麦POS机器的小票格式
                     bytes = mPrinterSetContents.printBlueTooth_HYCC((Print_HYCC_Bean) mPrintBean);
                    //发送小票格式数据开始打印
                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;
            //计次消费
            case "JCXF":
                //世麦POS机器

                    //配置【计次消费】非拉卡拉、世麦POS机器的小票格式
                     bytes = mPrinterSetContents.printBlueTooth_JCXF((Print_JCXF_Bean) mPrintBean);
                    //发送小票格式数据开始打印
                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));

                break;
            //商品消费
            case "SPXF":
                mPrinterSetContents.printBlueTooth_SPXF((Print_SPXF_Bean) mPrintBean);
                    //发送小票格式数据开始打印
//                if (!ISCONNECT){
//                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
//                }

                break;
            //积分兑换
            case "JFDH":
                 bytes = mPrinterSetContents.printBlueTooth_JFDH((Print_JFDH_Bean) mPrintBean);
                    //发送小票格式数据开始打印
                    mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;

            case "HYKK":

                 bytes = mPrinterSetContents.printBlueTooth_HYKK((Print_HYKK_Bean) mPrintBean);
                //发送小票格式数据开始打印
                mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;

            case "RK":
                bytes = mPrinterSetContents.printBlueTooth_RK((RK_Success_Bean) mPrintBean);
                //发送小票格式数据开始打印
                mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;
            case "CK":
                bytes = mPrinterSetContents.printBlueTooth_CK((CK_Success_Bean) mPrintBean);
                //发送小票格式数据开始打印
                mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;

            case "JB":
                bytes = mPrinterSetContents.printBlueTooth_JB((HandDutyBean) mPrintBean);
//                发送小票格式数据开始打印
                mBlueToothActivity.send(bytes, mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;

            case "SPTH":
                bytes = mPrinterSetContents.printBlueTooth_SPTH((Print_SPTH_Bean) mPrintBean);
                //发送小票格式数据开始打印
                mBlueToothActivity.send(bytes,mReceitsNum, mContext.getSharedPreferences("bluetooth_address", 0));
                break;

        }
    }
}

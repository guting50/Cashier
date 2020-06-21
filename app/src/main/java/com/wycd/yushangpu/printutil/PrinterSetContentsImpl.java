package com.wycd.yushangpu.printutil;

import android.content.Context;
import android.graphics.Bitmap;

import com.blankj.utilcode.util.ToastUtils;
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
import com.wycd.yushangpu.tools.CommonUtils;
import com.wycd.yushangpu.tools.Decima2KeeplUtil;
import com.wycd.yushangpu.tools.ESCUtil;
import com.wycd.yushangpu.tools.LogUtils;

import net.posprinter.posprinterface.ProcessData;
import net.posprinter.posprinterface.TaskCallback;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wycd.yushangpu.MyApplication.myBinder;


/**
 * 设置小票打印内容和格式
 * iauthor：Yc
 * date: 2017/7/26 11:17
 * email：jasoncheng9111@gmail.com
 */
public class PrinterSetContentsImpl implements IPrinterSetContents {
    private JSONObject printJson = new JSONObject();
    private Context mContext;
    public String pPrintJsonStr_KS;
    public Bitmap[] pBitmaps;
    public String pDetails; //打印详细内容
    private SimpleDateFormat mConsumeTime;//消费时间
    public static String mLine = "--------------------------------";
    public static String bank = "  ";
    private int mQueneNum;//排队


    /**********设置蓝牙打印属性**********/
    private byte[] boldOn = ESCUtil.boldOn();//加粗
    private byte[] boldOff = ESCUtil.boldOff();//不加粗
    private byte[] center = ESCUtil.alignCenter();//居中
    private byte[] titlebigger = ESCUtil.fontSizeSetBig(2);//字体放大
    private byte[] titlesmall = ESCUtil.fontSizeSetBig(1);//缩小

    private byte[] ALIGN_CENTER = ESCUtil.ALIGN_CENTER;//中间对齐
    private byte[] alignCenterimg = ESCUtil.alignCenterimg();//居中对齐

    private byte[] left = ESCUtil.alignLeft();//居左
    private byte[] right = ESCUtil.alignRight();//居右
    private byte[] nextLine1 = ESCUtil.nextLine(1);//空1行
    private byte[] nextLine2 = ESCUtil.nextLine(2);//空2行
    private byte[] nextLine3 = ESCUtil.nextLine(3);//空3行
    private byte[] nextLine4 = ESCUtil.nextLine(4);//空4行
    private byte[] nextLine6 = ESCUtil.nextLine(6);//空4行
    private byte[] breakPartial = ESCUtil.feedPaperCutPartial();//结束


    public PrinterSetContentsImpl(Context context) {
        this.mContext = context;
        mConsumeTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    }

    /**
     * 蓝牙打印
     *
     * @param data
     * @return
     */
    public void printBlueTooth(List<byte[]> data, int mReceitsNum) {
        for (int i = 0; i < mReceitsNum; i++) {
            myBinder.writeDataByUSB(new TaskCallback() {
                @Override
                public void OnSucceed() {
//                ToastUtils.showLong("打印完成");
                }

                @Override
                public void OnFailed() {
                    ToastUtils.showLong("打印失败");
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    return data;
                }
            });
        }
    }

    /**
     * 蓝牙打印 商品消费
     *
     * @param printBean
     * @return
     */
    public List<byte[]> printBlueTooth_SPXF(Print_SPXF_Bean printBean) {
        try {
            List<Print_SPXF_Bean.GoodsListBean> goodList = printBean.getGoodsList();
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mGoodsConsumeMap.isEmpty()) {
                if (GetPrintSet.mGoodsConsumeMap.containsKey("LOGO") && GetPrintSet.SPXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.SPXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mGoodsConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                list.add(nextLine1);
                if (GetPrintSet.mGoodsConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(left);
                list.add(("商品名称   " + bank).getBytes("gb2312"));
                list.add((" 单价" + bank).getBytes("gb2312"));
                list.add((" 数量" + bank).getBytes("gb2312"));
                if (GetPrintSet.mGoodsConsumeMap.containsKey("折扣")) {
                    list.add((" 折扣" + bank).getBytes("gb2312"));
                }

                list.add(right);
                list.add(" 小计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);

                double total = 0;
                for (int i = 0; i < goodList.size(); i++) {
                    double price = goodList.get(i).getPM_UnitPrice();
                    double num = goodList.get(i).getPM_Number();
                    double discount = goodList.get(i).getPM_Discount();
                    total += CommonUtils.mul(price, num);
                    list.add(left);
                    list.add(goodList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank + "   ￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_UnitPrice() + "")).getBytes("gb2312"));
                    list.add((bank + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Number() + "")).getBytes("gb2312"));
                    if (GetPrintSet.mGoodsConsumeMap.containsKey("折扣")) {
                        list.add((bank + " " + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Discount() + "")).getBytes("gb2312"));
                    }
                    list.add(right);
                    list.add((bank + "￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getGOD_DiscountPrice() + "")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str1 = printBean.getActivityName() == null ? "无" : printBean.getActivityName() + "";
                if (GetPrintSet.mGoodsConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsConsumeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(total - printBean.getYSMoney()))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mGoodsConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                String facenum = printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber();
                if (GetPrintSet.mGoodsConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }

                if (GetPrintSet.mGoodsConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mGoodsConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mGoodsConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mGoodsConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsConsumeMap.containsKey("二维码") && GetPrintSet.SPXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.SPXF_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称" + bank).getBytes("gb2312"));
                list.add(("单价" + bank).getBytes("gb2312"));
                list.add(("数量" + bank).getBytes("gb2312"));
                list.add(("折扣" + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);
                list.add(nextLine1);

                for (int i = 0; i < goodList.size(); i++) {
                    double price = goodList.get(i).getPM_UnitPrice();
                    double num = goodList.get(i).getPM_Number();
                    double discount = goodList.get(i).getPM_Discount();
                    double total = CommonUtils.mul(CommonUtils.mul(price, num), discount);
                    list.add(left);
                    list.add(goodList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank + "       ￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_UnitPrice() + "")).getBytes("gb2312"));
                    list.add((bank + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Number() + "")).getBytes("gb2312"));
                    list.add((bank + " " + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Discount() + "")).getBytes("gb2312"));
                    list.add((bank + "￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getGOD_DiscountPrice() + "")).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印 快速消费
     *
     * @param printBean
     * @return
     */
    @Override
    public List<byte[]> printBlueTooth_KSXF(Print_KSXF_Bean printBean) {
        try {
            List<byte[]> list = new ArrayList<>();
            String discount;
            if (printBean.getDiscount() == 1 || printBean.getDiscount() == 0) {
                discount = "不打折";
            } else {
                discount = String.valueOf(printBean.getDiscount());
            }
            if (!GetPrintSet.mFastConsumeMap.isEmpty()) {
                if (GetPrintSet.mFastConsumeMap.containsKey("LOGO") && GetPrintSet.KSXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.KSXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mFastConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                list.add(nextLine1);
                if (GetPrintSet.mFastConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("消费金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员折扣:" + discount).getBytes("gb2312"));
                list.add(nextLine1);
                list.add(left);
                list.add(("折后金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                        .getYSMoney()))).getBytes("gb2312"));

                String str1 = printBean.getActivityName() == null ? "无" : printBean.getActivityName() + "";
                if (GetPrintSet.mFastConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (GetPrintSet.mFastConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                            .getIntegralAdd()))).getBytes("gb2312"));
                }


                if (GetPrintSet.mFastConsumeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getConsumeMoney() - printBean
                            .getYSMoney()
                    ))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mFastConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }

                String facenum = printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber();
                if (GetPrintSet.mFastConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + facenum).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mFastConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mFastConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mFastConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mFastConsumeMap.containsKey("二维码") && GetPrintSet.KSXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.KSXF_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);


                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("消费金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员折扣:" + discount).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("折后金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                        .getYSMoney()))).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印 会员充值
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_HYCZ(Print_HYCZ_Bean printBean) {
        try {
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mRechargeMap.isEmpty()) {
                if (GetPrintSet.mRechargeMap.containsKey("LOGO") && GetPrintSet.HYCZ_LOGO != null && !GetPrintSet.HYCZ_LOGO.equals("")) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCZ_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mRechargeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mRechargeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }

                if (GetPrintSet.mRechargeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("充值金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("赠送金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getGiveMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("充值合计:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                        .getRechargeTotal()))).getBytes("gb2312"));

                String STR = printBean.getActivityName() == null ? "无" : printBean.getActivityName();
                if (GetPrintSet.mRechargeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + STR).getBytes("gb2312"));
                }

                if (GetPrintSet.mRechargeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mRechargeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mRechargeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (GetPrintSet.mRechargeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }
                if (GetPrintSet.mRechargeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mRechargeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mRechargeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mRechargeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mRechargeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }

                if (GetPrintSet.mRechargeMap.containsKey("二维码") && GetPrintSet.HYCZ_QR != null && !GetPrintSet.HYCZ_QR.equals("")) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCZ_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
//                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("充值金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("赠送金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getGiveMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("充值合计:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                        .getRechargeTotal()))).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }


    /**
     * 蓝牙打印  会员充次
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_HYCC(Print_HYCC_Bean printBean) {
        try {
            List<Print_HYCC_Bean.ServiceListBean> serviceList = printBean.getServiceList();
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mTimesRechargeMap.isEmpty()) {
                if (GetPrintSet.mTimesRechargeMap.containsKey("LOGO") && GetPrintSet.HYCC_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCC_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mTimesRechargeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("服务名称".getBytes("gb2312"));
                list.add(bank.getBytes("gb2312"));
                list.add("单价".getBytes("gb2312"));
                list.add(bank.getBytes("gb2312"));
                list.add("数量".getBytes("gb2312"));
                list.add(bank.getBytes("gb2312"));
                list.add("折扣".getBytes("gb2312"));
                list.add(bank.getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                double alltatol = 0;
                for (int i = 0; i < serviceList.size(); i++) {
                    double price = serviceList.get(i).getPM_UnitPrice();
                    int num = serviceList.get(i).getPM_Number();
                    double discount = serviceList.get(i).getPM_Discount();
                    String total = Decima2KeeplUtil.stringToDecimal(CommonUtils.mul(CommonUtils.mul(price, num), discount) + "");
                    alltatol += CommonUtils.mul(price, num);
                    list.add(serviceList.get(i).getPM_Name().getBytes("gb2312"));
                    if (GetPrintSet.mTimesRechargeMap.containsKey("到期时间")) {
                        if (serviceList.get(i).getGOD_ExpireDate() != null) {
                            list.add(("(" + serviceList.get(i).getGOD_ExpireDate() + "到期)").getBytes("gb2312"));
                        } else {
                            list.add(("(永久有效)").getBytes("gb2312"));
                        }
                    }

                    list.add(nextLine1);
                    list.add((bank + "      ￥" + Decima2KeeplUtil.stringToDecimal(serviceList.get(i).getPM_UnitPrice() + "")).getBytes("gb2312"));
                    list.add((bank + serviceList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank + "  " + serviceList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank + "￥" + total).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str1 = printBean.getActivityName() == null ? "无" : printBean.getActivityName() + "";
                if (GetPrintSet.mTimesRechargeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (GetPrintSet.mTimesRechargeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                if (GetPrintSet.mTimesRechargeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(alltatol - printBean.getYSMoney()))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mTimesRechargeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (GetPrintSet.mTimesRechargeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + Decima2KeeplUtil.stringToDecimal(printBean.getVCH_Money() + "")).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mTimesRechargeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mTimesRechargeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mTimesRechargeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesRechargeMap.containsKey("二维码") && GetPrintSet.HYCC_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCC_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称" + bank).getBytes("gb2312"));
                list.add(("单价" + bank).getBytes("gb2312"));
                list.add(("数量" + bank).getBytes("gb2312"));
                list.add(("折扣" + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);
                list.add(nextLine1);

                for (int i = 0; i < serviceList.size(); i++) {
                    double price = serviceList.get(i).getPM_UnitPrice();
                    int num = serviceList.get(i).getPM_Number();
                    double discount = serviceList.get(i).getPM_Discount();
                    String total = Decima2KeeplUtil.stringToDecimal(CommonUtils.mul(CommonUtils.mul(price, num), discount) + "");
                    list.add(serviceList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank + "      ￥" + Decima2KeeplUtil.stringToDecimal(serviceList.get(i).getPM_UnitPrice() + "")).getBytes("gb2312"));
                    list.add((bank + serviceList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank + "  " + serviceList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank + "￥" + String.valueOf(total)).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }


    /**
     * 计次消费 蓝牙打印
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_JCXF(Print_JCXF_Bean printBean) {
        try {
            List<Print_JCXF_Bean.ServiceListBean> serviceList = printBean.getServiceList();
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mTimesConsumeMap.isEmpty()) {
                if (GetPrintSet.mTimesConsumeMap.containsKey("LOGO") && GetPrintSet.JCXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JCXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mTimesConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("服务名称    " + bank + bank + bank).getBytes("gb2312"));
                list.add(("使用  " + bank + bank).getBytes("gb2312"));
                list.add("剩余".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < serviceList.size(); i++) {
                    list.add(serviceList.get(i).getSG_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("            " + bank + bank + bank + +serviceList.get(i).getWOD_UseNumber() + "次").getBytes("gb2312"));
                    list.add(("  " + bank + bank + serviceList.get(i).getWOD_ResidueDegree() + "次").getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));


                String str1 = printBean.getActivityName() == null ? "无" : printBean.getActivityName() + "";
                if (GetPrintSet.mTimesConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (GetPrintSet.mTimesConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mTimesConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (GetPrintSet.mTimesConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mTimesConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mTimesConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mTimesConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mTimesConsumeMap.containsKey("二维码") && GetPrintSet.JCXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JCXF_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));

                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("服务名称    " + bank + bank + bank).getBytes("gb2312"));
                list.add(("使用  " + bank + bank).getBytes("gb2312"));
                list.add("剩余".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < serviceList.size(); i++) {
                    list.add(serviceList.get(i).getSG_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("            " + bank + bank + bank + serviceList.get(i).getWOD_UseNumber() + "次").getBytes("gb2312"));
                    list.add(("  " + bank + bank + serviceList.get(i).getWOD_ResidueDegree() + "次").getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }


    /**
     * 积分兑换 蓝牙打印
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_JFDH(Print_JFDH_Bean printBean) {
        try {
            List<Print_JFDH_Bean.GiftListBean> goodList = printBean.getGiftList();
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mIntegralExchangeMap.isEmpty()) {
                if (GetPrintSet.mIntegralExchangeMap.containsKey("LOGO") && GetPrintSet.JFDH_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JFDH_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mIntegralExchangeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("礼品名称" + bank + bank).getBytes("gb2312"));
                list.add(("数量 " + bank + bank).getBytes("gb2312"));
                list.add(("积分 " + bank + bank).getBytes("gb2312"));
                list.add("合计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < goodList.size(); i++) {
                    list.add(goodList.get(i).getGM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("         " + bank + bank + goodList.get(i).getGM_Acount()).getBytes("gb2312"));
                    list.add(("   " + bank + bank + goodList.get(i).getGM_Integral()).getBytes("gb2312"));
                    list.add(("  " + bank + bank + goodList.get(i).getEGD_Score()).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("兑换数量: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getExchangeNum()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("消耗积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getIntegralDeduct()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("剩余积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getVCH_Point()).getBytes("gb2312"));
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mIntegralExchangeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }


                if (GetPrintSet.mIntegralExchangeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }

                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + printBean.getVCH_Money()).getBytes("gb2312"));
                }

                if (GetPrintSet.mIntegralExchangeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mIntegralExchangeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mIntegralExchangeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mIntegralExchangeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mIntegralExchangeMap.containsKey("二维码") && GetPrintSet.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JFDH_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("礼品名称" + bank).getBytes("gb2312"));
                list.add(("数量 " + bank + bank).getBytes("gb2312"));
                list.add(("积分 " + bank + bank).getBytes("gb2312"));
                list.add("合计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < goodList.size(); i++) {
                    list.add(goodList.get(i).getGM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("         " + bank + goodList.get(i).getGM_Acount()).getBytes("gb2312"));
                    list.add(("   " + bank + bank + goodList.get(i).getGM_Integral()).getBytes("gb2312"));
                    list.add(("  " + bank + bank + goodList.get(i).getEGD_Score()).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("兑换数量: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getExchangeNum()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("消耗积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getIntegralDeduct()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("剩余积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getVCH_Point()).getBytes("gb2312"));
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }


    /**
     * 蓝牙打印  会员开卡
     *
     * @param printBean
     * @return
     */
    @Override
    public List<byte[]> printBlueTooth_HYKK(Print_HYKK_Bean printBean) {
        try {
            List<byte[]> list = new ArrayList<>();
            if (!GetPrintSet.mCardOpenMap.isEmpty()) {
                if (GetPrintSet.mCardOpenMap.containsKey("LOGO") && GetPrintSet.HYCC_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCC_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mCardOpenMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                list.add(nextLine1);
                if (GetPrintSet.mCardOpenMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }

                if (GetPrintSet.mCardOpenMap.containsKey("开卡单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("开卡单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("开卡费用:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getVCH_Fee()))).getBytes("gb2312"));//

                if (GetPrintSet.mCardOpenMap.containsKey("初始金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("初始金额:" + printBean.getInitialAmount()).getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("初始积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("初始积分:" + printBean.getInitialIntegral()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mCardOpenMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getEMName() == null || printBean.getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getEMName();
                }
                if (GetPrintSet.mCardOpenMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getVCH_Card().getBytes("gb2312"));//

                String facenum = printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber();
                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("卡面卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((facenum).getBytes("gb2312"));//

                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }

                if (GetPrintSet.mCardOpenMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }

                if (GetPrintSet.mCardOpenMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mCardOpenMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mCardOpenMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mCardOpenMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mCardOpenMap.containsKey("二维码") && GetPrintSet.HYCC_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.HYCC_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("开卡费用:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getVCH_Fee()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getVCH_Card().getBytes("gb2312"));//

                String facenum = printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber();
                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("卡面卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((facenum).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return list;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印  入库
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_RK(RK_Success_Bean printBean) {
        RK_Success_Bean bean = printBean;
//        String  shopname = (String) uSharedPreferencesUtiles.get(mContext, "ShopName", "默认店铺");
        try {
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mGoodsIn.isEmpty()) {

                if (GetPrintSet.mGoodsIn.containsKey("LOGO") && GetPrintSet.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.RK_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mGoodsIn.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mGoodsIn.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                String STR = printBean.getSI_Hander() == null ? "" : printBean.getSI_Hander();
                if (GetPrintSet.mGoodsIn.containsKey("经手人")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("经 手 人:" + STR).getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsIn.containsKey("供应商")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("供 应 商:" + printBean.getSL_Name()).getBytes("gb2312"));
                }
                String str = null;
                if (printBean.getSI_InType().equals("1")) {//1采购进货 2调拨 3退货
                    str = "采购进货";
                } else if (printBean.getSI_InType().equals("2")) {
                    str = "库存调拨";
                } else if (printBean.getSI_InType().equals("3")) {
                    str = "商品退货";
                }

                if (GetPrintSet.mGoodsIn.containsKey("入库类型")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("入库类型:" + str).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("入库日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("入库日期:" + printBean.getSI_CreateTime()).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getSI_TrackingNo()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称" + bank + bank + bank).getBytes("gb2312"));
                list.add(("进价 " + bank + bank).getBytes("gb2312"));
                list.add(("数量 " + bank + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                double totalPrice = 0;
                double totalNum = 0;
                list.add(nextLine1);
                for (int i = 0; i < bean.getStockInDetailList().size(); i++) {
                    list.add(bean.getStockInDetailList().get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    String pmcode = bean.getStockInDetailList().get(i).getPM_Code();
                    String pmcode1 = null;
                    String pmcode2 = null;
                    if (pmcode.length() > 10) {
                        pmcode1 = pmcode.substring(0, 10);
                        pmcode2 = pmcode.substring(10, pmcode.length());
                    } else {
                        pmcode1 = pmcode;
                    }
                    if (GetPrintSet.mGoodsIn.containsKey("商品编码")) {
                        list.add(pmcode1.getBytes("gb2312"));
                        list.add((bank + bean.getStockInDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    } else {
                        list.add(("         " + bank + bank + bank + bean.getStockInDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    }
                    list.add(("   " + bank + bank + bean.getStockInDetailList().get(i).getSID_Amount()).getBytes("gb2312"));
                    list.add(("  " + bank + bank + bean.getStockInDetailList().get(i).getSID_TotalPrice()).getBytes("gb2312"));
                    list.add(nextLine1);
                    if (GetPrintSet.mGoodsIn.containsKey("商品编码")) {
                        if (pmcode.length() > 11) {
                            list.add(pmcode2.getBytes("gb2312"));
                            list.add(nextLine1);
                        }
                    }
                    totalPrice += bean.getStockInDetailList().get(i).getSID_TotalPrice();
                    totalNum += bean.getStockInDetailList().get(i).getSID_Amount();
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                if (GetPrintSet.mGoodsIn.containsKey("合计金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计金额:" + totalPrice).getBytes("gb2312"));
                }


                if (GetPrintSet.mGoodsIn.containsKey("其他金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("其他金额:" + printBean.getSI_OtherMoney()).getBytes("gb2312"));
                }
                String all = Decima2KeeplUtil.stringToDecimal(String.valueOf(totalPrice + printBean.getSI_OtherMoney()));
                list.add(nextLine1);
                list.add(boldOn);
                list.add(left);
                list.add(("总计金额:" + all).getBytes("gb2312"));
                list.add(boldOff);

                String str1 = null;
                if (printBean.getSI_PayCode().equals("XJZF")) {
                    str1 = "现金支付";
                } else if (printBean.getSI_PayCode().equals("YLZF")) {
                    str1 = "银联支付";
                } else if (printBean.getSI_PayCode().equals("WX_JZ")) {
                    str1 = "微信记账";
                } else if (printBean.getSI_PayCode().equals("ZFB_JZ")) {
                    str1 = "支付宝记账";
                }

                if (GetPrintSet.mGoodsIn.containsKey("支付方式")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付方式:" + str1 + "(" + all + ")").getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("合计数量")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计数量:" + totalNum).getBytes("gb2312"));
                }

                String STR1 = printBean.getSI_Remark() == null ? "" : printBean.getSI_Remark();
                if (GetPrintSet.mGoodsIn.containsKey("备注信息")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备注信息:" + STR1).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mGoodsIn.get("联系电话")).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mGoodsIn.get("联系地址")).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsIn.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mGoodsIn.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsIn.containsKey("二维码") && GetPrintSet.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.RK_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);

            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(boldOn);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine2);
                list.add(left);
                list.add(("操 作 员:" + bean.getStockInDetailList().get(0).getSID_Creator()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("入库时间:" + bean.getStockInDetailList().get(0).getSID_CreateTime()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getSI_TrackingNo()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("供 应 商:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getSL_Name()).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("商品名称:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(bean.getStockInDetailList().get(0).getPM_Name().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("入库数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((bean.getStockInDetailList().get(0).getSID_Amount() + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("备    注:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getSI_Remark().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("签    名:".getBytes("gb2312"));
                list.add(boldOff);
//            list.add("".getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }

            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印  出库
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_CK(CK_Success_Bean printBean) {
        CK_Success_Bean bean = printBean;
//        String  shopname = (String) uSharedPreferencesUtiles.get(mContext, "ShopName", "默认店铺");
        try {


            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mGoodsOut.isEmpty()) {

                if (GetPrintSet.mGoodsOut.containsKey("LOGO") && GetPrintSet.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.CK_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mGoodsOut.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mGoodsOut.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                String STR = printBean.getSO_Hander() == null ? "" : (String) printBean.getSO_Hander();
                if (GetPrintSet.mGoodsOut.containsKey("经手人")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("经 手 人:" + STR).getBytes("gb2312"));
                }

                String str = null;//2 采购退货  0 商品报废 3 库存调拨 1 商品消费
                if (printBean.getSO_OutType().equals("2")) {//1采购进货 2调拨 3退货
                    str = "采购退货";
                } else if (printBean.getSO_OutType().equals("0")) {
                    str = "商品报废";
                } else if (printBean.getSO_OutType().equals("3")) {
                    str = "其它";
                } else if (printBean.getSO_OutType().equals("1")) {
                    str = "商品消费";
                }

                if (GetPrintSet.mGoodsOut.containsKey("出库类型")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("出库类型:" + str).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsOut.containsKey("出库日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("出库日期:" + printBean.getSO_CreateTime()).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsOut.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getSO_TrackingNo()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称" + bank + bank + bank).getBytes("gb2312"));
                list.add(("单价/原价" + bank).getBytes("gb2312"));
                list.add(("数量 " + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                double totalPrice = 0;
                double totalNum = 0;

                list.add(nextLine1);
                for (int i = 0; i < bean.getStockOutDetailList().size(); i++) {
                    double siglePrice = bean.getStockOutDetailList().get(i).getSOD_DiscountPrice() / bean.getStockOutDetailList().get(i).getSOD_Amount();
                    list.add(bean.getStockOutDetailList().get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);

                    String pmcode = bean.getStockOutDetailList().get(i).getPM_Code();
                    String pmcode1 = null;
                    String pmcode2 = null;
                    if (pmcode.length() > 11) {
                        pmcode1 = pmcode.substring(0, 10);
                        pmcode2 = pmcode.substring(10, pmcode.length());
                    } else {
                        pmcode1 = pmcode;
                    }
                    if (GetPrintSet.mGoodsOut.containsKey("商品编码")) {
                        list.add(pmcode1.getBytes("gb2312"));
                        list.add((bank + siglePrice + "/" + bean.getStockOutDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    } else {
                        list.add(("         " + bank + bank + bank + siglePrice + "/" + bean.getStockOutDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    }
                    list.add(("   " + bank + bean.getStockOutDetailList().get(i).getSOD_Amount()).getBytes("gb2312"));
                    list.add(("  " + bank + bean.getStockOutDetailList().get(i).getSOD_TotalPrice()).getBytes("gb2312"));
                    list.add(nextLine1);
                    if (GetPrintSet.mGoodsOut.containsKey("商品编码")) {
                        if (pmcode.length() > 11) {
                            list.add(pmcode2.getBytes("gb2312"));
                            list.add(nextLine1);
                        }
                    }
                    totalPrice += bean.getStockOutDetailList().get(i).getSOD_TotalPrice();
                    totalNum += bean.getStockOutDetailList().get(i).getSOD_Amount();
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                if (GetPrintSet.mGoodsOut.containsKey("合计金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计金额:" + totalPrice).getBytes("gb2312"));
                }


                if (GetPrintSet.mGoodsOut.containsKey("其他金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("其他金额:" + printBean.getSO_OtherMoney()).getBytes("gb2312"));
                }
                String all = Decima2KeeplUtil.stringToDecimal(String.valueOf(totalPrice + printBean.getSO_OtherMoney()));
                list.add(nextLine1);
                list.add(boldOn);
                list.add(left);
                list.add(("总计金额:" + all).getBytes("gb2312"));
                list.add(boldOff);

                String str1 = null;
                if (printBean.getSO_PayCode().equals("XJZF")) {
                    str1 = "现金支付";
                } else if (printBean.getSO_PayCode().equals("YLZF")) {
                    str1 = "银联支付";
                } else if (printBean.getSO_PayCode().equals("WX_JZ")) {
                    str1 = "微信记账";
                } else if (printBean.getSO_PayCode().equals("ZFB_JZ")) {
                    str1 = "支付宝记账";
                }

                if (GetPrintSet.mGoodsOut.containsKey("支付方式")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付方式:" + str1).getBytes("gb2312"));
                }

                String STR1 = printBean.getSO_Remark() == null ? "" : (String) printBean.getSO_Remark();
                if (GetPrintSet.mGoodsOut.containsKey("备注信息")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备注信息:" + STR1).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsOut.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mGoodsOut.get("联系电话")).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsOut.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mGoodsOut.get("联系地址")).getBytes("gb2312"));
                }

                if (GetPrintSet.mGoodsOut.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mGoodsOut.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mGoodsOut.containsKey("二维码") && GetPrintSet.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.CK_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);

            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(boldOn);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine2);
                list.add(left);
                list.add(("操 作 员:" + bean.getStockOutDetailList().get(0).getSOD_Creator()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("出库时间:" + bean.getStockOutDetailList().get(0).getSOD_CreateTime()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getSO_TrackingNo()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("商品名称:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(bean.getStockOutDetailList().get(0).getPM_Name().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("出库数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((bean.getStockOutDetailList().get(0).getSOD_Amount() + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("备    注:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getSO_Remark() + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("签    名:".getBytes("gb2312"));
                list.add(boldOff);
//            list.add("".getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }

            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印  交班
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_JB(HandDutyBean printBean) {
        List<byte[]> list = new ArrayList<>();
        try {
            if (!GetPrintSet.mHandOverMap.isEmpty()) {

                if (GetPrintSet.mHandOverMap.containsKey("LOGO") && GetPrintSet.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JB_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mHandOverMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mHandOverMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (GetPrintSet.mHandOverMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getSA_ShiftName()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getSA_CreateTime()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员开卡数据".getBytes("gb2312"));
                list.add(boldOff);

                if (GetPrintSet.mHandOverMap.containsKey("新增会员数")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("新增会员数:" + printBean.getSA_NewMemberNumber()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("会员开卡")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员开卡:" + printBean.getSA_OpenCardTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("会员充值")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员充值:" + printBean.getSA_RechargeTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("会员充次")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员充次:" + printBean.getSA_ChargeTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("会员延期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员延期:" + printBean.getSA_DelayTotal()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("消费数据统计".getBytes("gb2312"));
                list.add(boldOff);

                if (GetPrintSet.mHandOverMap.containsKey("商品消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("商品消费:" + printBean.getSA_ConsumptionTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("快速消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("快速消费:" + printBean.getSA_FastConsumptionTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("套餐消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("套餐消费:" + printBean.getSA_ComboTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("计时消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("计时消费:" + printBean.getSA_TimeTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("房台消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("房台消费:" + printBean.getSA_HouseTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("商品退货")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("商品退货:" + printBean.getSA_ReturnGoodsTotal()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("综合数据统计".getBytes("gb2312"));
                list.add(boldOff);

                if (GetPrintSet.mHandOverMap.containsKey("现金收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("现金收入:" + printBean.getSA_CashTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("银联收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("银联收入:" + printBean.getSA_UnionTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("余额收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("余额收入:" + printBean.getSA_BalanceTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("微信收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("微信收入:" + printBean.getSA_WeChatpayTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("支付宝收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付宝收入:" + printBean.getSA_AlipaypayTotal()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("总收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("总收入:" + printBean.getSA_AllTotal()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("交班信息".getBytes("gb2312"));
                list.add(boldOff);

                if (GetPrintSet.mHandOverMap.containsKey("上交营业金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("上交营业金额:" + printBean.getSA_HandInBusiness()).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("下发营业金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("下发营业金额:" + printBean.getSA_IssuedBusiness()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                if (GetPrintSet.mHandOverMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mHandOverMap.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mHandOverMap.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mHandOverMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mHandOverMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                }
                if (GetPrintSet.mHandOverMap.containsKey("二维码") && GetPrintSet.JB_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.JB_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);

            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine1);
                list.add(left);
                list.add(("收 银 员:" + printBean.getSA_ShiftName()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getSA_CreateTime()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员开卡数据".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                list.add(left);
                list.add(("新增会员数:" + printBean.getSA_NewMemberNumber()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员开卡:" + printBean.getSA_OpenCardTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员充值:" + printBean.getSA_RechargeTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员充次:" + printBean.getSA_ChargeTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员延期:" + printBean.getSA_DelayTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("消费数据统计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                list.add(left);
                list.add(("商品消费:" + printBean.getSA_ConsumptionTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("快速消费:" + printBean.getSA_FastConsumptionTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("套餐消费:" + printBean.getSA_ComboTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("计时消费:" + printBean.getSA_TimeTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("房台消费:" + printBean.getSA_HouseTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("商品退货:" + printBean.getSA_ReturnGoodsTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("综合数据统计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                list.add(left);
                list.add(("现金收入:" + printBean.getSA_CashTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("银联收入:" + printBean.getSA_UnionTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("余额收入:" + printBean.getSA_BalanceTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("微信收入:" + printBean.getSA_WeChatpayTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("支付宝收入:" + printBean.getSA_AlipaypayTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("总收入:" + printBean.getSA_AllTotal()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("交班信息".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                list.add(left);
                list.add(("上交营业金额:" + printBean.getSA_HandInBusiness()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("下发营业金额:" + printBean.getSA_IssuedBusiness()).getBytes("gb2312"));

                list.add(nextLine4);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }

            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

    /**
     * 蓝牙打印 商品退货
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_SPTH(Print_SPTH_Bean printBean) {
        try {
            List<Print_SPTH_Bean.GoodsListBean> goodList = printBean.getGoodsList();
            List<byte[]> list = new ArrayList<>();

            if (!GetPrintSet.mReTureOrder.isEmpty()) {
                if (GetPrintSet.mReTureOrder.containsKey("LOGO") && GetPrintSet.SPXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.SPTH_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (GetPrintSet.mReTureOrder.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((GetPrintSet.mReTureOrder.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (GetPrintSet.mReTureOrder.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add(("商品名称" + bank).getBytes("gb2312"));
                list.add(("单价" + bank).getBytes("gb2312"));
                list.add(("数量" + bank).getBytes("gb2312"));
                list.add(("折扣" + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);

                double totalnum = 0;
                for (int i = 0; i < goodList.size(); i++) {
                    double price = goodList.get(i).getPM_UnitPrice();
                    double num = goodList.get(i).getPM_Number();
                    totalnum += num;
                    double discount = goodList.get(i).getPM_Discount();
                    double total = CommonUtils.mul(CommonUtils.mul(price, num), discount);
                    list.add(left);
                    list.add(goodList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank + "      ￥" + goodList.get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    list.add((bank + goodList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank + " " + goodList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank + "￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getRO_Monetary() + "")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("合计数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((totalnum + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("扣除积分:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getIntegralDeduct() + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款总额:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + printBean.getYSMoney()).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款方式:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getRemark() == null ? "无" : printBean.getRemark();
                if (GetPrintSet.mReTureOrder.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                if (GetPrintSet.mReTureOrder.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                String facenum = printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber();
                if (GetPrintSet.mReTureOrder.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() == null ? "无" : printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }

                if (GetPrintSet.mReTureOrder.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + GetPrintSet.mReTureOrder.get("联系电话")).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + GetPrintSet.mReTureOrder.get("联系地址")).getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((GetPrintSet.mReTureOrder.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (GetPrintSet.mReTureOrder.containsKey("二维码") && GetPrintSet.SPXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(GetPrintSet.SPTH_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            } else {
                list.add(nextLine1);
                list.add(center);
                list.add(titlebigger);
                list.add("欢迎光临".getBytes("gb2312"));
                list.add(titlesmall);

                list.add(nextLine2);
                list.add(left);
                list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add(("商品名称" + bank).getBytes("gb2312"));
                list.add(("单价" + bank + bank).getBytes("gb2312"));
                list.add(("数量" + bank + bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);

                double totalnum = 0;
                for (int i = 0; i < goodList.size(); i++) {
                    double price = goodList.get(i).getPM_UnitPrice();
                    double num = goodList.get(i).getPM_Number();
                    totalnum += num;
                    double discount = goodList.get(i).getPM_Discount();
                    double total = CommonUtils.mul(CommonUtils.mul(price, num), discount);
                    list.add(left);
                    list.add(goodList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank + "      ￥" + goodList.get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    list.add((bank + bank + goodList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank + bank + "￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getROD_DiscountPrice() + "")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("合计数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((totalnum + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("扣除积分:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getIntegralDeduct() + "").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款总额:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + printBean.getYSMoney()).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款方式:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));

                list.add(nextLine2);
                list.add(center);
                list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                list.add(nextLine4);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);
            }
            return ESCUtil.byteMerger(list);

        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("======== Error ========", e.getMessage());
        }
        return null;
    }

}

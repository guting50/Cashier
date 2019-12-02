package com.wycd.yushangpu.printutil;

import android.content.Context;
import android.graphics.Bitmap;


import com.wycd.yushangpu.MyApplication;
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

import net.posprinter.posprinterface.ProcessData;
import net.posprinter.posprinterface.TaskCallback;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    public static String bank = " ";
    private int mQueneNum;//排队


    /**********设置蓝牙打印属性**********/
    private byte[] boldOn = ESCUtil.boldOn();//加粗
    private byte[] boldOff = ESCUtil.boldOff();//不加粗
    private byte[] center = ESCUtil.alignCenter();//居中
    private byte[] titlebigger = ESCUtil.fontSizeSetBig(2);//字体放大
    private byte[] titlesmall = ESCUtil.fontSizeSetBig(1);//缩小

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


    private List<byte[]> getSPXFList(Print_SPXF_Bean printBean){
        try {
            List<Print_SPXF_Bean.DataBean.GoodsListBean> goodList = printBean.getData().getGoodsList();
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mGoodsConsumeMap.isEmpty()) {
                if (MyApplication.mGoodsConsumeMap.containsKey("LOGO") && MyApplication.SPXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.SPXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mGoodsConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
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
                if (MyApplication.mGoodsConsumeMap.containsKey("折扣")) {
                    list.add(("折扣" + bank).getBytes("gb2312"));
                }

                list.add("小计".getBytes("gb2312"));
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
                    list.add((bank + "      ￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_UnitPrice()+"")).getBytes("gb2312"));
                    list.add((bank + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Number()+"")).getBytes("gb2312"));
                    if (MyApplication.mGoodsConsumeMap.containsKey("折扣")) {
                        list.add((bank + " " + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Discount()+"")).getBytes("gb2312"));
                    }
                    list.add((bank + "￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getGOD_DiscountPrice() + "")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str1 = printBean.getData().getActivityName() == null ? "无" : printBean.getData().getActivityName() + "";
                if (MyApplication.mGoodsConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsConsumeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(total - printBean.getData().getYSMoney()))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str = printBean.getData().getRemark() == null ? "无" : printBean.getData().getRemark();
                if (MyApplication.mGoodsConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getData().getEMName() == null || printBean.getData().getEMName().equals("")) {
                    str2 = "无";
                } else {
                    str2 = printBean.getData().getEMName();
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }
                String facenum = printBean.getData().getVIP_FaceNumber() == null ? "无" : printBean.getData().getVIP_FaceNumber();
                if (MyApplication.mGoodsConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getData().getVIP_FaceNumber() == null ? "无" : printBean.getData().getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getData().getVIP_Name();
                if (memName == null || memName.equals("")) {
                    memName = "无";
                }

                if (MyApplication.mGoodsConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getData().getVCH_Money()).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getData().getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mGoodsConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mGoodsConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mGoodsConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mGoodsConsumeMap.containsKey("二维码") && MyApplication.SPXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.SPXF_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

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
                    list.add((bank + "       ￥" + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_UnitPrice()+"")).getBytes("gb2312"));
                    list.add((bank + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Number()+"")).getBytes("gb2312"));
                    list.add((bank + " " + Decima2KeeplUtil.stringToDecimal(goodList.get(i).getPM_Discount()+"")).getBytes("gb2312"));
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
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

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
    public byte[] printBlueTooth_KSXF(Print_KSXF_Bean printBean) {
        try {
            List<byte[]> list = new ArrayList<>();
            String discount;
            if (printBean.getData().getDiscount() == 1 || printBean.getData().getDiscount() == 0) {
                discount = "不打折";
            } else {
                discount = String.valueOf(printBean.getData().getDiscount());
            }
            if (!MyApplication.mFastConsumeMap.isEmpty()) {
                if (MyApplication.mFastConsumeMap.containsKey("LOGO") && MyApplication.KSXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.KSXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mFastConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mFastConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);

                }
                if (MyApplication.mFastConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("消费金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员折扣:" + discount).getBytes("gb2312"));
                list.add(nextLine1);
                list.add(left);
                list.add(("折后金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                        .getYSMoney()))).getBytes("gb2312"));

                String str1 = printBean.getData().getActivityName()==null?"无":printBean.getData().getActivityName()+"";
                if (MyApplication.mFastConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (MyApplication.mFastConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                            .getIntegralAdd()))).getBytes("gb2312"));
                }


                if (MyApplication.mFastConsumeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getConsumeMoney()-printBean.getData()
                                    .getYSMoney()
                            ))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mFastConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getData().getEMName()==null||printBean.getData().getEMName().equals("")){
                    str2 = "无";
                }else {
                    str2 = printBean.getData().getEMName();
                }
                if (MyApplication.mFastConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" +str2).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }

                String facenum = printBean.getData().getVIP_FaceNumber()==null?"无":printBean.getData().getVIP_FaceNumber();
                if (MyApplication.mFastConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + facenum).getBytes("gb2312"));
                }
                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }
                if (MyApplication.mFastConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getData().getVCH_Money()).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getData().getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mFastConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mFastConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mFastConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mFastConsumeMap.containsKey("二维码") && MyApplication.KSXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.KSXF_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("消费金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getConsumeMoney())))
                        .getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("会员折扣:" + discount).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("折后金额:" + "￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                        .getYSMoney()))).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

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
        }
        return null;
    }

    /**
     * 蓝牙打印 商品消费
     *
     * @param printBean
     * @return
     */
    @Override
    public byte[] printBlueTooth_SPXF(final Print_SPXF_Bean printBean) {
            myBinder.writeDataByUSB(new TaskCallback() {
                @Override
                public void OnSucceed() {
//                    Toast.makeText(MyApplication.getContext(),getString(R.string.con_success),Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnFailed() {
//                    Toast.makeText(MyApplication.getContext(),getString(R.string.con_failed),Toast.LENGTH_SHORT).show();
                }
                }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    return getSPXFList(printBean);
                }
            });
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

            if (!MyApplication.mRechargeMap.isEmpty()) {
                if (MyApplication.mRechargeMap.containsKey("LOGO") && MyApplication.HYCZ_LOGO != null&& !MyApplication.HYCZ_LOGO.equals("")) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCZ_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mRechargeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mRechargeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }

                if (MyApplication.mRechargeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("流水单号")) {
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

                String STR = printBean.getActivityName() ==null?"无":printBean.getActivityName();
                if (MyApplication.mRechargeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" +STR).getBytes("gb2312"));
                }

                if (MyApplication.mRechargeMap.containsKey("赠送积分")) {
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

                String str =printBean.getRemark()==null?"无":printBean.getRemark();
                if (MyApplication.mRechargeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getEMName()==null||printBean.getEMName().equals("")){
                    str2 = "无";
                }else {
                    str2 = printBean.getEMName();
                }
                if (MyApplication.mRechargeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (MyApplication.mRechargeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getVCH_Card()).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getVIP_FaceNumber() ==null?"无":printBean.getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }
                if (MyApplication.mRechargeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getVCH_Money()).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mRechargeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mRechargeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mRechargeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mRechargeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }

                if (MyApplication.mRechargeMap.containsKey("二维码") && MyApplication.HYCZ_QR != null&& !MyApplication.HYCZ_QR.equals("")) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCZ_QR);
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
            List<Print_HYCC_Bean.DataBean.ServiceListBean> serviceList = printBean.getData().getServiceList();
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mTimesRechargeMap.isEmpty()) {
                if (MyApplication.mTimesRechargeMap.containsKey("LOGO") && MyApplication.HYCC_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCC_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mTimesRechargeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mTimesRechargeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
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
                    if (MyApplication.mTimesRechargeMap.containsKey("到期时间")) {
                        if (serviceList.get(i).getGOD_ExpireDate() != null) {
                            list.add(("(" + serviceList.get(i).getGOD_ExpireDate()+"到期)").getBytes("gb2312"));
                        }else {
                            list.add(("(永久有效)").getBytes("gb2312"));
                        }
                    }

                    list.add(nextLine1);
                    list.add((bank+"      ￥"+  Decima2KeeplUtil.stringToDecimal(serviceList.get(i).getPM_UnitPrice()+"")).getBytes("gb2312"));
                    list.add((bank + serviceList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank+ "  "+serviceList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank+"￥" + total).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str1 = printBean.getData().getActivityName()==null?"无":printBean.getData().getActivityName()+"";
                if (MyApplication.mTimesRechargeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (MyApplication.mTimesRechargeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                if (MyApplication.mTimesRechargeMap.containsKey("优惠金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠金额:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(alltatol-printBean.getData().getYSMoney()))).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mTimesRechargeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                String str2;
                if (printBean.getData().getEMName()==null||printBean.getData().getEMName().equals("")){
                    str2 = "无";
                }else {
                    str2 = printBean.getData().getEMName();
                }
                if (MyApplication.mTimesRechargeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (MyApplication.mTimesRechargeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getData().getVIP_FaceNumber() ==null?"无":printBean.getData().getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }
                if (MyApplication.mTimesRechargeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" +  Decima2KeeplUtil.stringToDecimal(printBean.getData().getVCH_Money()+"")).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getData().getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mTimesRechargeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mTimesRechargeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mTimesRechargeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mTimesRechargeMap.containsKey("二维码") && MyApplication.HYCC_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCC_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称"+bank).getBytes("gb2312"));
                list.add(("单价"+bank).getBytes("gb2312"));
                list.add(("数量"+bank).getBytes("gb2312"));
                list.add(("折扣"+bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);
                list.add(nextLine1);

                for (int i = 0; i < serviceList.size(); i++) {
                    double price = serviceList.get(i).getPM_UnitPrice();
                    int num = serviceList.get(i).getPM_Number();
                    double discount = serviceList.get(i).getPM_Discount();
                    String total =  Decima2KeeplUtil.stringToDecimal(CommonUtils.mul(CommonUtils.mul(price, num), discount)+"");
                    list.add(serviceList.get(i).getPM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add((bank+"      ￥" +  Decima2KeeplUtil.stringToDecimal(serviceList.get(i).getPM_UnitPrice()+"")).getBytes("gb2312"));
                    list.add((bank + serviceList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank +"  " +serviceList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank+"￥" + String.valueOf(total)).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("应    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getYSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("实    收:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getSSMoney()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("支付详情:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//


                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("找    零:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getZLMoney()))).getBytes("gb2312"));//

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
            List<Print_JCXF_Bean.DataBean.ServiceListBean> serviceList = printBean.getData().getServiceList();
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mTimesConsumeMap.isEmpty()) {
                if (MyApplication.mTimesConsumeMap.containsKey("LOGO") && MyApplication.JCXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JCXF_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mTimesConsumeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mTimesConsumeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("服务名称    "+bank+bank+bank).getBytes("gb2312"));
                list.add(("使用  "+bank+bank).getBytes("gb2312"));
                list.add("剩余".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < serviceList.size(); i++) {
                    list.add(serviceList.get(i).getSG_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("            "+bank+bank+bank+ + serviceList.get(i).getWOD_UseNumber() + "次").getBytes("gb2312"));
                    list.add(("  "+bank+bank + serviceList.get(i).getWOD_ResidueDegree() + "次").getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));


                String str1 = printBean.getData().getActivityName()==null?"无":printBean.getData().getActivityName()+"";
                if (MyApplication.mTimesConsumeMap.containsKey("优惠活动")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("优惠活动:" + str1).getBytes("gb2312"));
                }

                if (MyApplication.mTimesConsumeMap.containsKey("赠送积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("赠送积分:" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData()
                            .getIntegralAdd()))).getBytes("gb2312"));
                }

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mTimesConsumeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getData().getEMName()==null||printBean.getData().getEMName().equals("")){
                    str2 = "无";
                }else {
                    str2 = printBean.getData().getEMName();
                }
                if (MyApplication.mTimesConsumeMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                if (MyApplication.mTimesConsumeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getData().getVIP_FaceNumber() ==null?"无":printBean.getData().getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }
                if (MyApplication.mTimesConsumeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + printBean.getData().getVCH_Money()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getData().getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mTimesConsumeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mTimesConsumeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mTimesConsumeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mTimesConsumeMap.containsKey("二维码") && MyApplication.JCXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JCXF_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("服务名称    "+bank+bank+bank).getBytes("gb2312"));
                list.add(("使用  "+bank+bank).getBytes("gb2312"));
                list.add("剩余".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < serviceList.size(); i++) {
                    list.add(serviceList.get(i).getSG_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("            " +bank+bank+bank+ serviceList.get(i).getWOD_UseNumber() + "次").getBytes("gb2312"));
                    list.add(("  "+bank+bank + serviceList.get(i).getWOD_ResidueDegree() + "次").getBytes("gb2312"));
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
            List<Print_JFDH_Bean.DataBean.GiftListBean> goodList = printBean.getData().getGiftList();
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mIntegralExchangeMap.isEmpty()) {
                if (MyApplication.mIntegralExchangeMap.containsKey("LOGO") && MyApplication.JFDH_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JFDH_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mIntegralExchangeMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("礼品名称"+bank+bank).getBytes("gb2312"));
                list.add(("数量 "+bank+bank).getBytes("gb2312"));
                list.add(("积分 "+bank+bank).getBytes("gb2312"));
                list.add("合计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < goodList.size(); i++) {
                    list.add(goodList.get(i).getGM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("         "+bank+bank + goodList.get(i).getGM_Acount()).getBytes("gb2312"));
                    list.add(("   "+bank+bank + goodList.get(i).getGM_Integral()).getBytes("gb2312"));
                    list.add(("  "+bank+bank + goodList.get(i).getEGD_Score()).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("兑换数量: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getExchangeNum()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("消耗积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getIntegralDeduct()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("剩余积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getVCH_Point()).getBytes("gb2312"));
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mIntegralExchangeMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }


                if (MyApplication.mIntegralExchangeMap.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getData().getVIP_FaceNumber() ==null?"无":printBean.getData().getVIP_FaceNumber())).getBytes("gb2312"));
                }

                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + printBean.getData().getVCH_Money()).getBytes("gb2312"));
                }

                if (MyApplication.mIntegralExchangeMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mIntegralExchangeMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mIntegralExchangeMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mIntegralExchangeMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mIntegralExchangeMap.containsKey("二维码") && MyApplication.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JFDH_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("礼品名称"+bank).getBytes("gb2312"));
                list.add(("数量 "+bank+bank).getBytes("gb2312"));
                list.add(("积分 "+bank+bank).getBytes("gb2312"));
                list.add("合计".getBytes("gb2312"));
                list.add(boldOff);

                list.add(nextLine1);
                for (int i = 0; i < goodList.size(); i++) {
                    list.add(goodList.get(i).getGM_Name().getBytes("gb2312"));
                    list.add(nextLine1);
                    list.add(("         "+bank + goodList.get(i).getGM_Acount()).getBytes("gb2312"));
                    list.add(("   " +bank+bank+ goodList.get(i).getGM_Integral()).getBytes("gb2312"));
                    list.add(("  "+bank+bank + goodList.get(i).getEGD_Score()).getBytes("gb2312"));
                    list.add(nextLine1);
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("兑换数量: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getExchangeNum()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("消耗积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getIntegralDeduct()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add("剩余积分: ".getBytes("gb2312"));
                list.add(boldOff);
                list.add(String.valueOf(printBean.getData().getVCH_Point()).getBytes("gb2312"));
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
    public byte[] printBlueTooth_HYKK(Print_HYKK_Bean printBean) {
        try {

            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mCardOpenMap.isEmpty()) {
                if (MyApplication.mCardOpenMap.containsKey("LOGO") && MyApplication.HYCC_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCC_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mCardOpenMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mCardOpenMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mCardOpenMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }

                if (MyApplication.mCardOpenMap.containsKey("开卡单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("开卡单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("开卡费用:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getVCH_Fee()))).getBytes("gb2312"));//

                if (MyApplication.mCardOpenMap.containsKey("初始金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("初始金额:" + printBean.getData().getInitialAmount()).getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("初始积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("初始积分:" + printBean.getData().getInitialIntegral()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mCardOpenMap.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }
                String str2;
                if (printBean.getData().getEMName()==null||printBean.getData().getEMName().equals("")){
                    str2 = "无";
                }else {
                    str2 = printBean.getData().getEMName();
                }
                if (MyApplication.mCardOpenMap.containsKey("服务员工")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("服务员工:" + str2).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getVCH_Card().getBytes("gb2312"));//

                String facenum = printBean.getData().getVIP_FaceNumber()==null?"无":printBean.getData().getVIP_FaceNumber();
                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("卡面卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((facenum).getBytes("gb2312"));//

                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }

                if (MyApplication.mCardOpenMap.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }

                if (MyApplication.mCardOpenMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mCardOpenMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mCardOpenMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mCardOpenMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mCardOpenMap.containsKey("二维码") && MyApplication.HYCC_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.HYCC_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("开卡费用:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥" + Decima2KeeplUtil.stringToDecimal(String.valueOf(printBean.getData().getVCH_Fee()))).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("会员卡号:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getVCH_Card().getBytes("gb2312"));//

                String facenum = printBean.getData().getVIP_FaceNumber()==null?"无":printBean.getData().getVIP_FaceNumber();
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
            return ESCUtil.byteMerger(list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
        RK_Success_Bean.DataBean bean = printBean.getData();
//        String  shopname = (String) uSharedPreferencesUtiles.get(mContext, "ShopName", "默认店铺");
        try {
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mGoodsIn.isEmpty()) {

                if (MyApplication.mGoodsIn.containsKey("LOGO") && MyApplication.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.RK_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mGoodsIn.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mGoodsIn.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                String STR = printBean.getData().getSI_Hander()==null?"":printBean.getData().getSI_Hander();
                if (MyApplication.mGoodsIn.containsKey("经手人")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("经 手 人:" + STR).getBytes("gb2312"));
                }
                if (MyApplication.mGoodsIn.containsKey("供应商")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("供 应 商:" + printBean.getData().getSL_Name()).getBytes("gb2312"));
                }
                String str = null;
                if (printBean.getData().getSI_InType().equals("1")) {//1采购进货 2调拨 3退货
                    str = "采购进货";
                } else if (printBean.getData().getSI_InType().equals("2")) {
                    str = "库存调拨";
                } else if (printBean.getData().getSI_InType().equals("3")) {
                    str = "商品退货";
                }

                if (MyApplication.mGoodsIn.containsKey("入库类型")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("入库类型:" + str).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("入库日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("入库日期:" + printBean.getData().getSI_CreateTime()).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getSI_TrackingNo()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称"+bank+bank+bank).getBytes("gb2312"));
                list.add(("进价 "+bank+bank).getBytes("gb2312"));
                list.add(("数量 "+bank+bank).getBytes("gb2312"));
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
                    if (MyApplication.mGoodsIn.containsKey("商品编码")) {
                        list.add(pmcode1.getBytes("gb2312"));
                        list.add((bank + bean.getStockInDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    } else {
                        list.add(("         " + bank + bank + bank + bean.getStockInDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    }
                    list.add(("   " + bank + bank + bean.getStockInDetailList().get(i).getSID_Amount()).getBytes("gb2312"));
                    list.add(("  " + bank + bank + bean.getStockInDetailList().get(i).getSID_TotalPrice()).getBytes("gb2312"));
                    list.add(nextLine1);
                    if (MyApplication.mGoodsIn.containsKey("商品编码")) {
                        if (pmcode.length() > 11) {
                            list.add(pmcode2.getBytes("gb2312"));
                            list.add(nextLine1);
                        }
                    }
                    totalPrice +=bean.getStockInDetailList().get(i).getSID_TotalPrice();
                    totalNum += bean.getStockInDetailList().get(i).getSID_Amount();
                }
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                if (MyApplication.mGoodsIn.containsKey("合计金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计金额:" + totalPrice).getBytes("gb2312"));
                }


                if (MyApplication.mGoodsIn.containsKey("其他金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("其他金额:" + printBean.getData().getSI_OtherMoney()).getBytes("gb2312"));
                }
                String all = Decima2KeeplUtil.stringToDecimal(String.valueOf(totalPrice+ printBean.getData().getSI_OtherMoney()));
                list.add(nextLine1);
                list.add(boldOn);
                list.add(left);
                list.add(("总计金额:" + all).getBytes("gb2312"));
                list.add(boldOff);

                String str1 = null;
                if (printBean.getData().getSI_PayCode().equals("XJZF")){
                    str1 = "现金支付";
                }else if (printBean.getData().getSI_PayCode().equals("YLZF")){
                    str1 = "银联支付";
                }else if (printBean.getData().getSI_PayCode().equals("WX_JZ")){
                    str1 = "微信记账";
                }else if (printBean.getData().getSI_PayCode().equals("ZFB_JZ")){
                    str1 = "支付宝记账";
                }

                if (MyApplication.mGoodsIn.containsKey("支付方式")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付方式:" + str1+"("+all+")").getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("合计数量")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计数量:" + totalNum).getBytes("gb2312"));
                }

                String STR1 = printBean.getData().getSI_Remark()==null?"":printBean.getData().getSI_Remark();
                if (MyApplication.mGoodsIn.containsKey("备注信息")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备注信息:" + STR1).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mGoodsIn.get("联系电话")).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mGoodsIn.get("联系地址")).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsIn.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mGoodsIn.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mGoodsIn.containsKey("二维码") && MyApplication.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.RK_QR);
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

            }else {
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
                list.add(("流水单号:" + printBean.getData().getSI_TrackingNo()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("供 应 商:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getData().getSL_Name()).getBytes("gb2312"));//

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
                list.add(printBean.getData().getSI_Remark() .getBytes("gb2312"));//

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
        CK_Success_Bean.DataBean bean = printBean.getData();
//        String  shopname = (String) uSharedPreferencesUtiles.get(mContext, "ShopName", "默认店铺");
        try {


            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mGoodsOut.isEmpty()) {

                if (MyApplication.mGoodsOut.containsKey("LOGO") && MyApplication.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.CK_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mGoodsOut.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mGoodsOut.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                String STR = printBean.getData().getSO_Hander()==null?"": (String) printBean.getData().getSO_Hander();
                if (MyApplication.mGoodsOut.containsKey("经手人")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("经 手 人:" + STR).getBytes("gb2312"));
                }

                String str = null;//2 采购退货  0 商品报废 3 库存调拨 1 商品消费
                if (printBean.getData().getSO_OutType().equals("2")) {//1采购进货 2调拨 3退货
                    str = "采购退货";
                } else if (printBean.getData().getSO_OutType().equals("0")) {
                    str = "商品报废";
                } else if (printBean.getData().getSO_OutType().equals("3")) {
                    str = "其它";
                }else if (printBean.getData().getSO_OutType().equals("1")) {
                    str = "商品消费";
                }

                if (MyApplication.mGoodsOut.containsKey("出库类型")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("出库类型:" + str).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsOut.containsKey("出库日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("出库日期:" + printBean.getData().getSO_CreateTime()).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsOut.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getSO_TrackingNo()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(boldOn);
                list.add(("商品名称"+bank+bank+bank).getBytes("gb2312"));
                list.add(("单价/原价"+bank).getBytes("gb2312"));
                list.add(("数量 "+bank).getBytes("gb2312"));
                list.add("小计".getBytes("gb2312"));
                list.add(boldOff);

                double totalPrice = 0;
                double totalNum = 0;

                list.add(nextLine1);
                for (int i = 0; i < bean.getStockOutDetailList().size(); i++) {
                    double siglePrice= bean.getStockOutDetailList().get(i).getSOD_DiscountPrice()/bean.getStockOutDetailList().get(i).getSOD_Amount();
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
                    if (MyApplication.mGoodsOut.containsKey("商品编码")){
                        list.add(pmcode1.getBytes("gb2312"));
                        list.add((bank +siglePrice+"/" + bean.getStockOutDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    }else {
                        list.add(("         "+bank+bank+bank +siglePrice+"/"+ bean.getStockOutDetailList().get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    }
                    list.add(("   "+bank + bean.getStockOutDetailList().get(i).getSOD_Amount()).getBytes("gb2312"));
                    list.add(("  "+bank + bean.getStockOutDetailList().get(i).getSOD_TotalPrice()).getBytes("gb2312"));
                    list.add(nextLine1);
                    if (MyApplication.mGoodsOut.containsKey("商品编码")) {
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

                if (MyApplication.mGoodsOut.containsKey("合计金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("合计金额:" + totalPrice).getBytes("gb2312"));
                }


                if (MyApplication.mGoodsOut.containsKey("其他金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("其他金额:" + printBean.getData().getSO_OtherMoney()).getBytes("gb2312"));
                }
                String all = Decima2KeeplUtil.stringToDecimal(String.valueOf(totalPrice+ printBean.getData().getSO_OtherMoney()));
                list.add(nextLine1);
                list.add(boldOn);
                list.add(left);
                list.add(("总计金额:" + all).getBytes("gb2312"));
                list.add(boldOff);

                String str1 = null;
                if (printBean.getData().getSO_PayCode().equals("XJZF")){
                    str1 = "现金支付";
                }else if (printBean.getData().getSO_PayCode().equals("YLZF")){
                    str1 = "银联支付";
                }else if (printBean.getData().getSO_PayCode().equals("WX_JZ")){
                    str1 = "微信记账";
                }else if (printBean.getData().getSO_PayCode().equals("ZFB_JZ")){
                    str1 = "支付宝记账";
                }

                if (MyApplication.mGoodsOut.containsKey("支付方式")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付方式:" + str1).getBytes("gb2312"));
                }

                String STR1 = printBean.getData().getSO_Remark()==null?"": (String) printBean.getData().getSO_Remark();
                if (MyApplication.mGoodsOut.containsKey("备注信息")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备注信息:" + STR1).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsOut.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mGoodsOut.get("联系电话")).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsOut.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mGoodsOut.get("联系地址")).getBytes("gb2312"));
                }

                if (MyApplication.mGoodsOut.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mGoodsOut.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mGoodsOut.containsKey("二维码") && MyApplication.JFDH_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.CK_QR);
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

            }else {
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
                list.add(("流水单号:" + printBean.getData().getSO_TrackingNo()).getBytes("gb2312"));

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
                list.add((printBean.getData().getSO_Remark()+"").getBytes("gb2312"));//

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
            if (!MyApplication.mHandOverMap.isEmpty()) {

                if (MyApplication.mHandOverMap.containsKey("LOGO") && MyApplication.JB_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JB_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mHandOverMap.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mHandOverMap.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mHandOverMap.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getSA_ShiftName()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("结账日期")) {
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

                if (MyApplication.mHandOverMap.containsKey("新增会员数")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("新增会员数:" + printBean.getSA_NewMemberNumber()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("会员开卡")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员开卡:" + printBean.getSA_OpenCardTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("会员充值")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员充值:" + printBean.getSA_RechargeTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("会员充次")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员充次:" + printBean.getSA_ChargeTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("会员延期")) {
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

                if (MyApplication.mHandOverMap.containsKey("商品消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("商品消费:" + printBean.getSA_ConsumptionTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("快速消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("快速消费:" + printBean.getSA_FastConsumptionTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("套餐消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("套餐消费:" + printBean.getSA_ComboTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("计时消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("计时消费:" + printBean.getSA_TimeTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("房台消费")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("房台消费:" + printBean.getSA_HouseTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("商品退货")) {
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

                if (MyApplication.mHandOverMap.containsKey("现金收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("现金收入:" + printBean.getSA_CashTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("银联收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("银联收入:" + printBean.getSA_UnionTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("余额收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("余额收入:" + printBean.getSA_BalanceTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("微信收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("微信收入:" + printBean.getSA_WeChatpayTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("支付宝收入")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("支付宝收入:" + printBean.getSA_AlipaypayTotal()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("总收入")) {
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

                if (MyApplication.mHandOverMap.containsKey("上交营业金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("上交营业金额:" + printBean.getSA_HandInBusiness()).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("下发营业金额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("下发营业金额:" + printBean.getSA_IssuedBusiness()).getBytes("gb2312"));
                }

                list.add(nextLine1);
                list.add(mLine.getBytes("gb2312"));

                if (MyApplication.mHandOverMap.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mHandOverMap.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mHandOverMap.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mHandOverMap.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mHandOverMap.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));

                }
                if (MyApplication.mHandOverMap.containsKey("二维码") && MyApplication.JB_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.JB_QR);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                    list.add(center);
                }
                list.add(nextLine4);
                list.add(mLine.getBytes("gb2312"));
                list.add(breakPartial);
                list.add(nextLine1);

            }else {
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
            List<Print_SPTH_Bean.DataBean.GoodsListBean> goodList = printBean.getData().getGoodsList();
            List<byte[]> list = new ArrayList<>();

            if (!MyApplication.mReTureOrder.isEmpty()) {
                if (MyApplication.mReTureOrder.containsKey("LOGO") && MyApplication.SPXF_LOGO != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.SPTH_LOGO);
                    list.add(nextLine1);
                    list.add(center);
                    list.add(ESCUtil.printBitmap(bitmap));
                }
                if (MyApplication.mReTureOrder.containsKey("标题")) {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add((MyApplication.mReTureOrder.get("标题").getBytes("gb2312")));
                    list.add(titlesmall);
                } else {
                    list.add(nextLine1);
                    list.add(center);
                    list.add(titlebigger);
                    list.add("欢迎光临".getBytes("gb2312"));
                    list.add(titlesmall);
                }
                if (MyApplication.mReTureOrder.containsKey("收银员")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("结账日期")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("流水单号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));
                }
                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add(("商品名称"+bank).getBytes("gb2312"));
                list.add(("单价"+bank).getBytes("gb2312"));
                list.add(("数量"+bank).getBytes("gb2312"));
                list.add(("折扣"+bank).getBytes("gb2312"));
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
                    list.add((bank+"      ￥" + goodList.get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    list.add((bank + goodList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank+" "+ goodList.get(i).getPM_Discount()).getBytes("gb2312"));
                    list.add((bank+"￥" + Decima2KeeplUtil.stringToDecimal( goodList.get(i).getRO_Monetary()+"")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("合计数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((totalnum+"").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("扣除积分:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getData().getIntegralDeduct()+"").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款总额:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥"+printBean.getData().getYSMoney()).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款方式:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                String str =printBean.getData().getRemark()==null?"无":printBean.getData().getRemark();
                if (MyApplication.mReTureOrder.containsKey("备注")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("备    注:" + str).getBytes("gb2312"));
                }

                if (MyApplication.mReTureOrder.containsKey("会员卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员卡号:" + printBean.getData().getVCH_Card()).getBytes("gb2312"));
                }
                String facenum = printBean.getData().getVIP_FaceNumber()==null?"无":printBean.getData().getVIP_FaceNumber();
                if (MyApplication.mReTureOrder.containsKey("卡面卡号")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡面卡号:" + (printBean.getData().getVIP_FaceNumber() ==null?"无":printBean.getData().getVIP_FaceNumber())).getBytes("gb2312"));
                }
                String memName = printBean.getData().getVIP_Name();
                if (memName ==null||memName.equals("")){
                    memName = "无";
                }

                if (MyApplication.mReTureOrder.containsKey("会员姓名")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("会员姓名:" + memName).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("卡内余额")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内余额:" + "￥" + printBean.getData().getVCH_Money()).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("卡内积分")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("卡内积分:" + printBean.getData().getVCH_Point()).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("打印时间")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("打印时间:" + mConsumeTime.format(new Date())).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("联系电话")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系电话:" + MyApplication.mReTureOrder.get("联系电话")).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("联系地址")) {
                    list.add(nextLine1);
                    list.add(left);
                    list.add(("联系地址:" + MyApplication.mReTureOrder.get("联系地址")).getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("脚注")) {
                    list.add(nextLine2);
                    list.add(center);
                    list.add((MyApplication.mReTureOrder.get("脚注")).getBytes("gb2312"));
                } else {
                    list.add(nextLine2);
                    list.add(center);
                    list.add("谢谢惠顾,欢迎下次光临！".getBytes("gb2312"));
                }
                if (MyApplication.mReTureOrder.containsKey("二维码") && MyApplication.SPXF_QR != null) {
                    Bitmap bitmap = ESCUtil.scaleImage(MyApplication.SPTH_QR);
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
                list.add(("收 银 员:" + printBean.getData().getCashier()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("结账日期:" + printBean.getData().getCheckoutDate()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(("流水单号:" + printBean.getData().getOrderCode()).getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add(("商品名称"+bank).getBytes("gb2312"));
                list.add(("单价"+bank+bank).getBytes("gb2312"));
                list.add(("数量"+bank+bank).getBytes("gb2312"));
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
                    list.add((bank+"      ￥" + goodList.get(i).getPM_UnitPrice()).getBytes("gb2312"));
                    list.add((bank+bank + goodList.get(i).getPM_Number()).getBytes("gb2312"));
                    list.add((bank+bank+"￥" + Decima2KeeplUtil.stringToDecimal( goodList.get(i).getROD_DiscountPrice()+"")).getBytes("gb2312"));
                    list.add(nextLine1);
                }

                list.add(left);
                list.add(mLine.getBytes("gb2312"));

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("合计数量:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((totalnum+"").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("扣除积分:".getBytes("gb2312"));
                list.add(boldOff);
                list.add((printBean.getData().getIntegralDeduct()+"").getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款总额:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(("￥"+printBean.getData().getYSMoney()).getBytes("gb2312"));//

                list.add(nextLine1);
                list.add(left);
                list.add(boldOn);
                list.add("退款方式:".getBytes("gb2312"));
                list.add(boldOff);
                list.add(printBean.getData().getPayInfo().getBytes("gb2312"));//

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
        }
        return null;
    }

}

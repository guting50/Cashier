package com.wycd.yushangpu.tools;

import com.gprinter.command.EscCommand;
import com.gprinter.command.LabelCommand;
import com.wycd.yushangpu.bean.ShopMsg;
import com.wycd.yushangpu.printutil.Decima2KeeplUtil;

import java.util.Vector;

import static com.wycd.yushangpu.MyApplication.LABEL_TYPE;
import static com.wycd.yushangpu.MyApplication.SHOP_NAME;

public class PrintContent {

    /**
     * 发送打印标签数据格式
     * @return
     */
    public static Vector<Byte> getLabel(ShopMsg shopMsg) {
        LabelCommand tsc = new LabelCommand();
        // 设置标签尺寸宽高，按照实际尺寸设置 单位mm
        tsc.addSize(40, 30);
        // 设置标签间隙，按照实际尺寸设置，如果为无间隙纸则设置为0 单位mm
        tsc.addGap(0);
        // 设置打印方向
        tsc.addDirection(LabelCommand.DIRECTION.FORWARD, LabelCommand.MIRROR.NORMAL);
        // 设置原点坐标
        tsc.addReference(0, 0);
        //设置浓度
        tsc.addDensity(LabelCommand.DENSITY.DNESITY4);
        // 撕纸模式开启
        tsc.addTear(EscCommand.ENABLE.ON);
        // 清除打印缓冲区
        tsc.addCls();
        if (LABEL_TYPE == 0){
           // 绘制商品名
           tsc.addText(100, 10, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                   LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_Name());
           // 绘制一维条码
           tsc.add1DBarcode(20, 45, LabelCommand.BARCODETYPE.CODE128, 100, LabelCommand.READABEL.EANBEL,
                   LabelCommand.ROTATION.ROTATION_0, shopMsg.getPM_Code());
           // 绘制价格
           tsc.addText(20, 180, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                   LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "￥" + Decima2KeeplUtil.stringToDecimal(shopMsg.getPM_UnitPrice()+""));
           // 绘制规格
           tsc.addText(130, 180, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                   LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_Modle());
       }
        if (LABEL_TYPE == 1){
            // 绘制商品名
            tsc.addText(100, 30, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_Name());
            // 绘制一维条码
            tsc.add1DBarcode(20, 65, LabelCommand.BARCODETYPE.CODE128, 100, LabelCommand.READABEL.EANBEL,
                    LabelCommand.ROTATION.ROTATION_0, shopMsg.getPM_Code());
        }
        if (LABEL_TYPE == 2){
            tsc.addText(20, 20, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "零售价：");
            // 绘制价格
            tsc.addText(100, 65, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "￥" + Decima2KeeplUtil.stringToDecimal(shopMsg.getPM_UnitPrice()+""));
            // 绘制商品名
            tsc.addText(20, 110, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "品    名：" + shopMsg.getPM_Name());
            // 绘制规格
            tsc.addText(20, 155, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "规    格：" + shopMsg.getPM_Modle());
            // 绘制一维条码
            tsc.add1DBarcode(20, 200, LabelCommand.BARCODETYPE.CODE128, 100, LabelCommand.READABEL.EANBEL,
                    LabelCommand.ROTATION.ROTATION_0, shopMsg.getPM_Code());
        }
        if (LABEL_TYPE == 3){
            tsc.addText(20, 20, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "零售价：");
            // 绘制价格
            tsc.addText(100, 65, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "￥" + Decima2KeeplUtil.stringToDecimal(shopMsg.getPM_UnitPrice()+""));
            // 绘制商品名
            tsc.addText(20, 110, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "品    名：" + shopMsg.getPM_Name());
            // 绘制规格
            tsc.addText(20, 155, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "规    格：" + shopMsg.getPM_Modle());
            // 绘制一维条码
            tsc.add1DBarcode(20, 200, LabelCommand.BARCODETYPE.CODE128, 100, LabelCommand.READABEL.EANBEL,
                    LabelCommand.ROTATION.ROTATION_0, shopMsg.getPM_Code());
        }
        if (LABEL_TYPE == 4){
            // 绘制商品名
            tsc.addText(100, 10, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, SHOP_NAME);
            // 绘制商品名
            tsc.addText(20, 55, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "名称：" + shopMsg.getPM_Name());
            // 绘制规格
            tsc.addText(20, 110, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "规格：" + shopMsg.getPM_Modle());
            // 绘制价格
            tsc.addText(20, 165, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "价格：" + "￥" + Decima2KeeplUtil.stringToDecimal(shopMsg.getPM_UnitPrice()+""));
        }
        if (LABEL_TYPE == 5){
            // 绘制商品名
            tsc.addText(20, 10, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, SHOP_NAME);
            // 绘制商品简码
            tsc.addText(20, 65, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_SimpleCode());
            // 绘制价格
            tsc.addText(20, 110, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, "￥" + Decima2KeeplUtil.stringToDecimal(shopMsg.getPM_UnitPrice()+""));
            // 绘制商品名
            tsc.addText(20, 165, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_Name());
            // 绘制规格
            tsc.addText(20, 220, LabelCommand.FONTTYPE.SIMPLIFIED_CHINESE, LabelCommand.ROTATION.ROTATION_0,
                    LabelCommand.FONTMUL.MUL_1, LabelCommand.FONTMUL.MUL_1, shopMsg.getPM_Modle());
        }
        // 打印标签
        tsc.addPrint(1, 1);
        // 打印标签后 蜂鸣器响
//        tsc.addSound(2, 100);
        Vector<Byte> datas = tsc.getCommand();
        // 发送数据
        return datas;
    }

}

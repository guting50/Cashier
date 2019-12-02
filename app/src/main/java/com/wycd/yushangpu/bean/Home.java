package com.wycd.yushangpu.bean;

import java.io.Serializable;

/**
 * Created by songxiaotao on 2017/6/30.
 */

public class Home implements Serializable {
    public String account;
    public String biaohao;
    public String zhuNum;
    public String aheadLotteryNumber;
    public String behindLotteryNumber;
    public boolean isChose;
    public String number;
    public String lotteryId;
    public String FirstPinYin;
    public String PinYin;
    public String price;
    public String lotteryType;//11, //彩票种类
    public String lotteryNo;//1//多少期
    public String name;//奥地利 - 欧洲百万彩票,
    public String total;//120.00,
    public String company;//百万,
    public String aheadCount;//6,    //前面需要猜测的号码数量
    public String aheadMaxNumber;//99, //前面可选择的号码最大值
    public String behindCount;//1,   //最后需要猜测的号码数量
    public String behindMaxNumber;//99, //最后可以选择的号码最大值
    public String icon;//"",
    public String symbol;//$,
    public String lotteryTime;//0,    //开奖时间
    public String type;//1,            //为图片还是文字 1 文字 name  2 图片 icon
    public String aheadChoseNumber;
    public String behindChoseNumber;
    public int chosenumberTop;
    public int chosenumberDown;
}

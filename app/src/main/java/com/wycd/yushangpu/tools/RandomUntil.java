package com.wycd.yushangpu.tools;

import java.util.Random;

/**
 * 随机数、字母 工具类
 * Created by admin on 2017/2/20.
 */
public class RandomUntil {


    public static int[] getRandomNum(int endNum, int randomNum) {
        Random r = new Random();
        int[] a = new int[randomNum];
        for (int i = 0; i < randomNum; i++) {
            int temp = r.nextInt(endNum);
            if (i == 0) {
                a[i] = temp;
            } else {
                //判断生成随机数是否在数组中
                //如果在i-1 否则把这个数放入数组
                if (contains(a, temp)) {
                    i = i - 1;
                } else {
                    a[i] = temp;
                }
            }
        }
        return a;
    }

    public static String [] getStringRandom(int endNum, int randomNum){
        String [] strings=new String[randomNum];
        int[] intrandom=getRandomNum(endNum, randomNum);
        for(int i=0;i<intrandom.length;i++){
           strings[i] = intrandom[i] < 10 ? "0" + intrandom[i] : intrandom[i] + "";
        }
        return strings;
    }
    /**
     * 生成一个0 到 count 之间的随机数
     *
     * @param endNum
     * @return
     */
    public static int getNum(int endNum) {
        if (endNum > 0) {
            Random random = new Random();
            return random.nextInt(endNum);
        }
        return 0;
    }

    /**
     * 生成一个startNum 到 endNum之间的随机数(不包含endNum的随机数)
     *
     * @param startNum
     * @param endNum
     * @return
     */
    public static int getNum(int startNum, int endNum) {
        if (endNum > startNum) {
            Random random = new Random();
            return random.nextInt(endNum - startNum) + startNum;
        }
        return 0;
    }


    //该方法完成判断temp在a数组中是否包含
    //包含返回true
    public static boolean contains(int[] a, int temp) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == temp) {
                return true;
            }
        }
        return false;
    }


    /**
     * 生成随机大写字母
     *
     * @return
     */
    public static String getLargeLetter() {
        Random random = new Random();
        return String.valueOf((char) (random.nextInt(27) + 'A'));
    }

    /**
     * 生成随机大写字母字符串
     *
     * @return
     */
    public static String getLargeLetter(int size) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            buffer.append((char) (random.nextInt(27) + 'A'));
        }
        return buffer.toString();
    }

    /**
     * 生成随机小写字母
     *
     * @return
     */
    public static String getSmallLetter() {
        Random random = new Random();
        return String.valueOf((char) (random.nextInt(27) + 'a'));
    }

    /**
     * 生成随机小写字母字符串
     *
     * @return
     */
    public static String getSmallLetter(int size) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            buffer.append((char) (random.nextInt(27) + 'a'));
        }
        return buffer.toString();
    }

    /**
     * 数字与小写字母混编字符串
     *
     * @param size
     * @return
     */
    public static String getNumSmallLetter(int size) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextInt(2) % 2 == 0) {//字母
                buffer.append((char) (random.nextInt(27) + 'a'));
            } else {//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /**
     * 数字与大写字母混编字符串
     *
     * @param size
     * @return
     */
    public static String getNumLargeLetter(int size) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextInt(2) % 2 == 0) {//字母
                buffer.append((char) (random.nextInt(27) + 'A'));
            } else {//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /**
     * 数字与大小写字母混编字符串
     *
     * @param size
     * @return
     */
    public static String getNumLargeSmallLetter(int size) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextInt(2) % 2 == 0) {//字母
                if (random.nextInt(2) % 2 == 0) {
                    buffer.append((char) (random.nextInt(27) + 'A'));
                } else {
                    buffer.append((char) (random.nextInt(27) + 'a'));
                }
            } else {//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }
}

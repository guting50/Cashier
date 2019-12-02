package com.wycd.yushangpu.tools;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by songxiaotao on 2018/3/8.
 */

public class WriteToSdcard {

public static void writeToSdcard(String msg) {


    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
        File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录,2.2的时候为:/mnt/sdcart  2.1的时候为：/sdcard，所以使用静态方法得到路径会好一点。
        File saveFile = new File(sdCardDir, "abc.txt");
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(saveFile);
            outStream.write(msg.getBytes());
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}

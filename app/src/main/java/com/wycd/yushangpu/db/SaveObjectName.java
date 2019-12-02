package com.wycd.yushangpu.db;

import com.wycd.yushangpu.MyApplication;

/**
 * Created by ZPH on 2019-08-01.
 */

public class SaveObjectName {


    public static ObjectName Name() {
        return ObjectName.getSaveName();
    }

    public static final class ObjectName {
        public ObjectName() {

        }

        static final ObjectName instance = new ObjectName();

        // 静态方法返回该类的实例
        static ObjectName getSaveName() {
            return instance;
        }

        //登录数据缓存key
        public static final String LOGIN = "login";

        //打印设置缓存key
        public static final String PRINT = "print";

    }
}

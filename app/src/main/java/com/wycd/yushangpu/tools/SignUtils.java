package com.wycd.yushangpu.tools;

import android.content.Context;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignUtils {

    public static String obtainSign(Context context, Map<String, Object> paramsValue) {
        paramsValue.put("appSecret", "D0UFVymvzkQETmxQuIDJFOHgJGqvwe6MdWL1PoxzZoORs8Xj5Scrb7KPnhu04AhM");
        List<String> target = StringUtil.sort(new ArrayList<String>(paramsValue.keySet()));
        StringBuilder encryptPre = new StringBuilder();
        for (int i = 0, size = target.size(); i < size; i++) {
            String paramName = target.get(i);
            if (i != 0) {
                encryptPre.append("&");
            }
            encryptPre.append(paramName);
            encryptPre.append("=");
            encryptPre.append(paramsValue.get(paramName));
        }
        return encryptPre.toString().toLowerCase();
    }

    public static RequestParams obtainRequestParams(Context context, Map<String, Object> map) {
        RequestParams params = new RequestParams();
        Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iter.next();
            // 拼接
            params.put(entry.getKey(), entry.getValue());
        }
        params.put("nonce", System.currentTimeMillis() + "");
        params.put("extraData", "");
//        "nonce":"15337317388361", // nonce, 使用基于毫秒的时间戳 (每个时间戳只能使用一次且大于之前的值)
//                "sign":"..."  // 数据签名
//        "extraData":"" //扩展字段
        return params;
    }

    public static Map<String,Object> obtainAllMap(Context context, Map<String, Object> map) {
//        map.put("nonce", System.currentTimeMillis() + "");
//        map.put("extraData", "");
//        map.put("sign","");
//        "nonce":"15337317388361", // nonce, 使用基于毫秒的时间戳 (每个时间戳只能使用一次且大于之前的值)
//                "sign":"..."  // 数据签名
//        "extraData":"" //扩展字段
        return map;
    }
    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
                    try {
                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                else
                    retBuf.append(unicodeStr.charAt(i));
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }

    public static List<String> getStringForlist(String str) {
        String[] strs = str.split("\\|");
        List<String> list = new ArrayList<>();
        for (int i = 0;i<strs.length;i++){
            list.add(strs[i]);
        }
        return list;
    }
}

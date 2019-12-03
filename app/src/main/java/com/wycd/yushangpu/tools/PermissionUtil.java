package com.wycd.yushangpu.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import androidx.multidex.BuildConfig;

/**
 * Created by zhengb on 2016/11/17.
 */
public class PermissionUtil {

    public static void checkPermission(Activity context) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        List<String> list = CommHelper.checkPermissions(context, new String[]{
                "android.permission.READ_PHONE_STATE",
                "android.permission.INTERNET",
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_EXTERNAL_STORAGE"
                , "android.permission.ACCESS_WIFI_STATE",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.BLUETOOTH",
                "android.permission.BLUETOOTH_ADMIN",
                "android.permission.RECORD_AUDIO",
                "android.permission.CAMERA"
                , "android.permission.ACCESS_COARSE_LOCATION",
                "android.permission.ACCESS_FINE_LOCATION",
                "android.permission.ACCESS_NETWORK_STATE"
                , "android.permission.ACCESS_WIFI_STATE",
                "android.permission.CHANGE_WIFI_STATE",
                "android.permission.CALL_PHONE"});
        if (list != null) {
            CommHelper.requestPermissions(context, list);
        } else {
//            ToastUtils.showToast(context,"请申请权限");
            com.blankj.utilcode.util.ToastUtils.showShort("请申请权限");
        }
    }


    /***
     * 检测资源版本
     *
     * @param context
     * @param SDCardResourcePath
     * @return true 从asset起
     */
    public static boolean checkResource2LoadFromAssets(Activity context, String SDCardResourcePath) {
        try {
            File sdFile = new File(SDCardResourcePath);
            if (!sdFile.exists()) {
                return true;
            }

            InputStream is = context.getResources().getAssets().open("common/resVersion.txt");
            BufferedReader dd = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String assetVersion = dd.readLine();
            dd.close();

            BufferedReader dd2 = new BufferedReader(new InputStreamReader(new FileInputStream(sdFile), "utf-8"));
            String sdVersion = dd2.readLine();
            dd2.close();

            if (CommHelper.checkNull(assetVersion) || CommHelper.checkNull(sdVersion)) {
                return true;
            }
            return compareVersion(assetVersion, sdVersion);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }

    }

    /*
     * 1.0.4.1    1.0.5
     *
     * */
    public static boolean compareVersion(String version1, String version2) {
        boolean flag = false;
        try {
            String[] versions1 = version1.split("\\.");
            String[] versions2 = version2.split("\\.");
            if (versions1.length > versions2.length) {
                for (int i = 0; i < versions2.length; i++) {
                    if (Integer.parseInt(versions1[i]) < Integer.parseInt(versions2[i])) {
                        flag = false;
                        break;
                    } else if (Integer.parseInt(versions1[i]) == Integer.parseInt(versions2[i])) {
                        flag = true;
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }

            } else {

                for (int j = 0; j < versions1.length; j++) {
                    if (Integer.parseInt(versions1[j]) < Integer.parseInt(versions2[j])) {
                        flag = false;
                        break;
                    } else if (Integer.parseInt(versions1[j]) == Integer.parseInt(versions2[j])) {
                        flag = false;
                        continue;

                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void checkPermissionAccept(Context context) {
        switch (Build.MANUFACTURER.toUpperCase()) {
            case "HUAWEI":
                try {
                    Intent intent = new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
                    intent.setComponent(comp);
                    if (context.getPackageManager().resolveActivity(intent, 0) == null) { // 判断是否存在这个activity
                        goSettingView(context);
                        return;
                    }
                    context.startActivity(intent);
                } catch (Exception e) {
                    goSettingView(context);
                }

                break;
            case "MEIZU":
                try {
                    Intent intent2 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent2.addCategory(Intent.CATEGORY_DEFAULT);
                    intent2.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    if (context.getPackageManager().resolveActivity(intent2, 0) == null) { // 判断是否存在这个activity
                        goSettingView(context);
                        return;
                    }
                    context.startActivity(intent2);
                } catch (Exception e) {
                    goSettingView(context);
                }


                break;
            case "XIAOMI":

                try {
                    Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                    ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                    intent3.setComponent(componentName);
                    intent3.putExtra("extra_pkgname", BuildConfig.APPLICATION_ID);
                    if (context.getPackageManager().resolveActivity(intent3, 0) == null) { // 判断是否存在这个activity
                        goSettingView(context);
                        return;
                    }
                    context.startActivity(intent3);
                } catch (Exception e) {
                    goSettingView(context);
                }

                break;

            default:
                goSettingView(context);
        }
    }


    public static void goSettingView(Context context) {

        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(localIntent);


    }
}

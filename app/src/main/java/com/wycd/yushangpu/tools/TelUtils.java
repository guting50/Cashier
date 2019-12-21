package com.wycd.yushangpu.tools;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by songxiaotao on 2018/3/9.
 */

public class TelUtils {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public static void toTel(Activity context, String phoneNumber){

// 检查是否获得了权限（Android6.0运行时权限）
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
// 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.CALL_PHONE)) {
// 返回值：
//如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
// 弹窗需要解释为何需要该权限，再次请求授权
                Toast.makeText(context, "请授权！", Toast.LENGTH_LONG).show();
// 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            }else{
// 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        }else {
// 已经获得授权，可以打电话

//        1）直接拨打
            Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            context.startActivity(intentPhone);
        }
        
    }

    public static void toBohao(Activity context){
//        // 检查是否获得了权限（Android6.0运行时权限）
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//// 没有获得授权，申请授权
//            if (ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.CALL_PHONE)) {
//// 返回值：
////如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
////如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
////如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
//// 弹窗需要解释为何需要该权限，再次请求授权
//                Toast.makeText(context, "请授权！", Toast.LENGTH_LONG).show();
//// 帮跳转到该应用的设置界面，让用户手动授权
//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
//                intent.getGuaDan(uri);
//                context.startActivity(intent);
//            }else{
//// 不需要解释为何需要该权限，直接请求授权
//                ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
//            }
//        }else {

//        2）跳转到拨号界面
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "400-820-6666"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
//        }
    }

//
//    2、跳转到联系人页面，使用一下代码：
//    Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
//    startActivity(intentPhone);
}

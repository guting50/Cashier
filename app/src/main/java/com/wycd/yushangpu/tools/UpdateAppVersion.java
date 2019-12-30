package com.wycd.yushangpu.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import com.gt.utils.MuchThreadDown;
import com.gt.utils.PermissionUtils;
import com.wycd.yushangpu.BuildConfig;
import com.wycd.yushangpu.R;

import java.io.File;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;

/**
 * 版本升级
 *
 * @author hongsir
 * Created by Administrator on 2017/4/1.
 */

public class UpdateAppVersion {
    /**
     * 版本升级对象
     */
    private UpdateInfoRes updateInfoRes;
    /**
     * 回调
     */
    private OnUpdateVersionBackListener listener;
    /**
     * 上下文
     */
    private Activity context;

    public UpdateAppVersion(Activity ct) {
        context = ct;
    }

    public UpdateAppVersion(Activity ct, UpdateInfoRes mUpdateInfoBean, OnUpdateVersionBackListener listener) {
        this(ct);
        this.updateInfoRes = mUpdateInfoBean;
        this.listener = listener;
    }

    /**
     * 当前版本信息
     *
     * @return 版本号
     */
    private int getLocalVersion() {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 版本比较
     * 当前版本小于服务端设定最小版本，提示强制升级
     * 当前版本小于服务端设定最新版本，提示升级
     */
    public void compareVersion() {
        //系统运行最小版本号始终小于或等于最新版本号，当当前版本号小于系统运行最小版本号时，一定小于最新版本号
        if (getLocalVersion() < updateInfoRes.getMinversionrequire()) { //系统运行最小版本号
            showUpdataDialog(true);
        } else if (getLocalVersion() < updateInfoRes.getCurrentversion()) { //最新版本号
            showUpdataDialog(false);
        } else {
            listener.onBackListener();
        }
    }

    /**
     * 安装apk
     *
     * @param file 文件
     */
    protected void installApk(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".gt_utils.fileprovider", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            Uri contentUri = Uri.fromFile(file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * 版本升级核心处理函数
     *
     * @param force true-强制升级
     */
    protected void showUpdataDialog(final boolean force) {
        String[] contents = updateInfoRes.getContent().split("&");
        new AlertDialog.Builder(context).setIcon(R.mipmap.logo).setTitle("版本升级")
                .setMessage("升级版本：" + updateInfoRes.getCurrentversiondesc()
                        + "\n" + "当前版本：" + getLocalVersionName(context)
                        + "\n" + (contents.length > 1 ? "新版大小：" + contents[0] + "\n" + "更新内容：" + contents[1] : "更新内容：" + updateInfoRes.getContent()))
                .setPositiveButton("现在升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtils.requestPermission(context, PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE, new PermissionUtils.PermissionGrant() {
                            @Override
                            public void onPermissionGranted(int... requestCode) {
                                Toast.makeText(context, "正在升级中...", Toast.LENGTH_LONG).show();
                                downLoadNewApk(updateInfoRes.getUrl());  //通过通知栏更新
//                                downLoadNewApk("https://dldir1.qq.com/weixin/android/weixin7010android1580.apk");
                                if (!force) {
                                    listener.onBackListener();
                                }
                            }
                        });
                    }
                })
                .setNegativeButton(force ? "退出应用" : "暂不升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (force) {
                            exitAPP(context);
                        } else {
                            listener.onBackListener();
                        }
                    }
                }).create().show();
    }

    public static final String KMS_DIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "apk";

    public void downLoadNewApk(String apkUri) {
        new MuchThreadDown(apkUri, KMS_DIR).isShowLog(true).download(new MuchThreadDown.OnDownloadListener() {
            @Override
            protected void onDownloadComplete(String name, String url, String filePath) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pd != null) {
                            pd.setMessage("下载完成");
                            pd.setProgress(100);
                            pd.cancel();
                            String[] path = filePath.split("/");
                            installApk(new File(KMS_DIR + File.separator + path[path.length - 1]));
                        }
                    }
                });
            }

            protected void onDownloadError(String url, Exception e) {
                e.printStackTrace();
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pd != null) {
                            pd.setMessage("下载失败:" + e.getMessage());
                        }
                    }
                });
            }

            protected void onDownloads(String url, int completed, int endIndex) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pd != null) {
                            pd.setProgress((int) ((float) completed / (float) endIndex * 100));
                        }
                    }
                });
            }
        });

        initProgressDialog();
    }

    ProgressDialog pd;

    private void initProgressDialog() {
        pd = new ProgressDialog(context);
        pd.setTitle("更新新版本");//设置一个标题
        pd.setMessage("正在下载当中...");//设置消息
        pd.setIcon(R.mipmap.logo);//设置一个图标
        pd.setMax(100);//设置进度条的最大值
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setProgress(0);//设置进度条的当前进度
        pd.setCancelable(false);//这是是否可撤销/也就是这个对话框是否可以关闭
        pd.setIndeterminate(false);//设置是否是确定值
        pd.show();//展示对话框
        //还可以这样设置 ProgressDialog pd=new ProgressDialog.show(每个参数);
    }

    /**
     * 版本升级回调接口
     */
    public interface OnUpdateVersionBackListener {
        void onBackListener();
    }

    /**
     * 当前版本信息
     *
     * @return 版本代号
     */
    public static String getLocalVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void exitAPP(Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<android.app.ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
    }

    public static class UpdateInfoRes {

        /**
         * content :
         * currentversion : 1
         * currentversiondesc : 1.0.2
         * minversionrequire : 1
         * minversionrequiredesc : 1.0.1
         * type : 0
         * uploaddate : 2017-04-01 18:24:53
         * url :
         */

        private String content;
        private double currentversion;
        private String currentversiondesc;
        private double minversionrequire;
        private String minversionrequiredesc;
        private int type;
        private String uploaddate;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public double getCurrentversion() {
            return currentversion;
        }

        public void setCurrentversion(double currentversion) {
            this.currentversion = currentversion;
        }

        public String getCurrentversiondesc() {
            return currentversiondesc == null ? "" : currentversiondesc;
        }

        public void setCurrentversiondesc(String currentversiondesc) {
            this.currentversiondesc = currentversiondesc;
        }

        public double getMinversionrequire() {
            return minversionrequire;
        }

        public void setMinversionrequire(double minversionrequire) {
            this.minversionrequire = minversionrequire;
        }

        public String getMinversionrequiredesc() {
            return minversionrequiredesc;
        }

        public void setMinversionrequiredesc(String minversionrequiredesc) {
            this.minversionrequiredesc = minversionrequiredesc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUploaddate() {
            return uploaddate;
        }

        public void setUploaddate(String uploaddate) {
            this.uploaddate = uploaddate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}



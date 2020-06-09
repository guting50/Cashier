package com.wycd.yushangpu.ui;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.wycd.yushangpu.MyApplication;
import com.wycd.yushangpu.R;
import com.wycd.yushangpu.http.ImgUrlTools;
import com.wycd.yushangpu.printutil.ConnectPrinter;
import com.wycd.yushangpu.tools.NoDoubleClickListener;
import com.wycd.yushangpu.tools.NullUtils;
import com.wycd.yushangpu.tools.PreferenceHelper;
import com.wycd.yushangpu.ui.Presentation.TestPresentation;
import com.wycd.yushangpu.ui.fragment.CashierFragment;
import com.wycd.yushangpu.ui.fragment.JiesuanBFragment;
import com.wycd.yushangpu.ui.fragment.PrintSetFragment;
import com.wycd.yushangpu.ui.fragment.VipMemberFragment;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class HomeActivity extends BaseActivity {

    @BindView(R.id.ig_exchange)
    ImageView igExchange;
    @BindView(R.id.rl_jiaoban)
    RelativeLayout mRlJiaoban;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.img_pay_success)
    public ImageView imgPaySuccess;
    @BindView(R.id.img_hedimg)
    CircleImageView imgHedimg;

    private long firstTime = 0;

    public CashierFragment cashierFragment = new CashierFragment();
    public JiesuanBFragment jiesuanBFragment = new JiesuanBFragment();
    public PrintSetFragment printSetFragment = new PrintSetFragment();
    public VipMemberFragment vipMemberFragment = new VipMemberFragment();
    private boolean isFirstLaunch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);//usb拔插会重新走onCreate 此时savedInstanceState不为null
        setContentView(R.layout.activity_home);
        isFirstLaunch = true;
        ButterKnife.bind(this);

        initView();
        initEvent();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ConnectPrinter.connect(ac);
            }
        }).start();
        if (Settings.canDrawOverlays(this)) {
            showPresentation();
        } else {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 100);
        }
    }

    private void initFragment() {
        cashierFragment.show(this, R.id.subsidiary_fragment);
    }

    private void initView() {
        PreferenceHelper.write(ac, "yunshangpu", "vip", false);

        if (MyApplication.loginBean != null) {
            if (MyApplication.loginBean.getUM_ChatHead() != null) {
                Glide.with(ac).load(ImgUrlTools.obtainUrl(
                        NullUtils.noNullHandle(MyApplication.loginBean.getUM_ChatHead()).toString()))
                        .error(R.mipmap.member_head_nohead).into(imgHedimg);
            }
            tvStoreName.setText(MyApplication.loginBean.getUM_Name());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            long secndTime = System.currentTimeMillis();
            if (secndTime - firstTime > 3000) {
                firstTime = secndTime;
                Toast.makeText(ac, "再按一次退出", Toast.LENGTH_LONG)
                        .show();
            } else {
                ActivityUtils.finishAllActivities();
            }
            return true;
        }
        return false;
    }

    private void initEvent() {
        mRlJiaoban.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {

            }
        });
    }

    @BindView(R.id.btn_cashier)
    public ImageView btn_cashier;
    @BindView(R.id.btn_home_set)
    ImageView btn_home_set;
    @BindView(R.id.btn_member)
    ImageView btn_member;
    @BindView(R.id.btn_goods)
    ImageView btn_goods;
    @BindView(R.id.btn_sale)
    ImageView btn_sale;
    @BindView(R.id.btn_houtai)
    ImageView btn_houtai;

    @OnClick({R.id.btn_cashier, R.id.btn_home_set, R.id.btn_member, R.id.btn_goods, R.id.btn_sale})
    public void onTaskbarClick(View view) {
        btn_cashier.setImageResource(R.mipmap.btn_cashier_false);
        btn_home_set.setImageResource(R.mipmap.btn_home_set_false);
        btn_member.setImageResource(R.mipmap.btn_member_false);
        btn_goods.setImageResource(R.mipmap.btn_goods_false);
        btn_sale.setImageResource(R.mipmap.btn_sale_false);
        btn_houtai.setImageResource(R.mipmap.btn_houtai_false);
        cashierFragment.hide();
        printSetFragment.hide();
        vipMemberFragment.hide();
        switch (view.getId()) {
            case R.id.btn_cashier:
                btn_cashier.setImageResource(R.mipmap.btn_cashier_true);
                cashierFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_home_set:
                btn_home_set.setImageResource(R.mipmap.btn_home_set_true);
                printSetFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_member:
                btn_member.setImageResource(R.mipmap.btn_member_true);
                vipMemberFragment.show(this, R.id.subsidiary_fragment);
                break;
            case R.id.btn_goods:
                btn_goods.setImageResource(R.mipmap.btn_goods_true);
                break;
            case R.id.btn_sale:
                btn_sale.setImageResource(R.mipmap.btn_sale_true);
                break;
        }
    }

    @OnClick({R.id.subsidiary_fragment, R.id.rl_out, R.id.btn_houtai})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_houtai:
                btn_houtai.setImageResource(R.mipmap.btn_houtai_false);
                int version = (int) (1 + Math.random() * (1000000 - 1 + 1));

                Intent intent = new Intent(ac, WebActivity.class);
//                intent.putExtra("html_url", MyApplication.BASE_URL + "login.html");
                intent.putExtra("html_url", MyApplication.BASE_URL + "loginTSCash.html?v=" + String.valueOf(version));
                startActivityForResult(intent, 500);
                break;
            case R.id.subsidiary_fragment:
                break;
            case R.id.rl_out:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 500) {
            cashierFragment.isInit = printSetFragment.isInit = vipMemberFragment.isInit = false;
        } else if (requestCode == 100) {
            showPresentation();
        }
    }

    public void showPresentation() {
        if (Settings.canDrawOverlays(this)) {
            DisplayManager mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
            Display[] displays = mDisplayManager.getDisplays();
            if (displays.length > 1) {
                TestPresentation mPresentation = new TestPresentation(ac, displays[1]);//displays[1]是副屏
                mPresentation.getWindow().setType(WindowManager.LayoutParams.TYPE_PHONE);
                mPresentation.show();
            }
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (isFirstLaunch) {
                isFirstLaunch = false;
                // TODO 第一次启动界面加载完毕后的操作
                initFragment();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ConnectPrinter.unregisterReceiver(this);
    }
}

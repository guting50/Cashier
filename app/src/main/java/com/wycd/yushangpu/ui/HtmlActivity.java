package com.wycd.yushangpu.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;
import com.wycd.yushangpu.R;

public class HtmlActivity extends BaseActivity {

    private LinearLayout ll_container;
    private ImageView iv_close;

    private AgentWeb mAgentWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        initView();

        initData();
    }

    private void initView() {
        ll_container = (LinearLayout) findViewById(R.id.ll_container);
        iv_close = (ImageView) findViewById(R.id.iv_close);

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        String url = getIntent().getStringExtra("html_url");
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(ll_container, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
//                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(url);
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }
    };

    private com.just.agentweb.WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mAgentWeb.getIndicatorController().setProgress(newProgress);
            if (newProgress == 100) {
//                if (tv_title.equals("曝光台")) {
//                    new Handler().postDelayed(new Runnable() {
//                        public void run() {
//                            mAgentWeb.getJsAccessEntrace().quickCallJs("callAreaMobile", SPStaticUtils.getString(Constant.SP.MST_AREA_ID));
//                        }
//                    }, 1000);
//                }
            }
        }
    };

}

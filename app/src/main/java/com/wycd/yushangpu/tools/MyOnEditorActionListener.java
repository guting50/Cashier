package com.wycd.yushangpu.tools;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.blankj.utilcode.util.KeyboardUtils;

import java.util.Timer;
import java.util.TimerTask;

public abstract class MyOnEditorActionListener implements TextView.OnEditorActionListener {

    private Activity activity;

    public MyOnEditorActionListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        KeyboardUtils.hideSoftInput(v);
        if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
//                    homeActivity.dialog.show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!TextUtils.isEmpty(v.getText().toString())) {
                                onEditorAction(v.getText().toString());
                                v.setText("");
                            }
                        }
                    });
                }
            }, 100);
        }
        return true;
    }

    public abstract void onEditorAction(String text);
}

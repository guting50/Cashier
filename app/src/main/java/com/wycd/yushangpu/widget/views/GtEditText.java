package com.wycd.yushangpu.widget.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
public class GtEditText extends EditText {
    KeyEventCallback keyEventCallback;

    public GtEditText(Context context) {
        super(context);
    }

    public GtEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GtEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GtEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyEventCallback != null) {
            if (!keyEventCallback.onKeyDown(keyCode, event)) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setKeyEventCallback(KeyEventCallback keyEventCallback) {
        this.keyEventCallback = keyEventCallback;
    }

    public interface KeyEventCallback {
        boolean onKeyDown(int keyCode, KeyEvent event);
    }
}

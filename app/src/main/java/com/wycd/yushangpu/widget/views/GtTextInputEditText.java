package com.wycd.yushangpu.widget.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import com.google.android.material.textfield.TextInputEditText;

public class GtTextInputEditText extends TextInputEditText {
    public GtTextInputEditText(Context context) {
        super(context);
    }

    public GtTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GtTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.wycd.yushangpu.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class NumInputView extends RelativeLayout {

    private EditText editText;
    private TextView editTextHint;
    private View textCursor;
    private Context context;
    private NumKeyboardUtils numKeyboardUtils;
    private NumInputView numInputView;

    public NumInputView(Context context) {
        this(context, null);
    }

    public NumInputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.numInputView = this;
        init(attrs);
    }

    private TypedArray getTypedArray(AttributeSet attrs, String name) {
        int[] textAppearanceStyleArr = new int[0];
        try {
            Class clasz = Class.forName("com.android.internal.R$styleable");
            Field field = clasz.getDeclaredField(name);
            field.setAccessible(true);
            textAppearanceStyleArr = (int[]) field.get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return context.obtainStyledAttributes(attrs,
                textAppearanceStyleArr);
    }

    private int getStyleId(String name) {
        int styleId = 0;
        try {
            Class clasz = Class.forName("com.android.internal.R$styleable");
            Field field = clasz.getDeclaredField(name);
            field.setAccessible(true);
            styleId = (Integer) field.get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return styleId;
    }

    private void init(AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_edit_layout, this, true);

        editText = (EditText) view.findViewById(R.id.edit_text);
        editTextHint = (TextView) view.findViewById(R.id.edit_text_hint);
        textCursor = (View) view.findViewById(R.id.edit_text_cursor);

        TypedArray array = getTypedArray(attrs, "TextView");
        CharSequence text = array.getText(getStyleId("TextView_text"));
        CharSequence hint = array.getText(getStyleId("TextView_hint"));
        ColorStateList textColor = array.getColorStateList(getStyleId("TextView_textColor"));
        ColorStateList textHintColor = array.getColorStateList(getStyleId("TextView_textColorHint"));
        int textSize = array.getDimensionPixelSize(getStyleId("TextView_textSize"),
                (int) (editText.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity + 0.5f));
        if (text != null) {
            editText.setText(text);
        }
        if (textColor != null) {
            editText.setTextColor(textColor);
        }
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        if (hint != null) {
            editTextHint.setText(hint);
        }
        if (textHintColor != null) {
            editTextHint.setTextColor(textHintColor);
        }
        editTextHint.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        if ((getGravity() & Gravity.RIGHT) == Gravity.RIGHT) {
            RelativeLayout.LayoutParams rlpCursor = ((RelativeLayout.LayoutParams) textCursor.getLayoutParams());
            rlpCursor.addRule(ALIGN_PARENT_RIGHT);
            rlpCursor.addRule(RIGHT_OF);
            textCursor.setLayoutParams(rlpCursor);

            RelativeLayout.LayoutParams rlpEdit = ((RelativeLayout.LayoutParams) editText.getLayoutParams());
            rlpEdit.addRule(LEFT_OF, textCursor.getId());
            editText.setLayoutParams(rlpEdit);

            RelativeLayout.LayoutParams rlpHint = ((RelativeLayout.LayoutParams) editTextHint.getLayoutParams());
            rlpHint.addRule(RIGHT_OF);
            rlpHint.addRule(LEFT_OF, textCursor.getId());
            editTextHint.setLayoutParams(rlpHint);
        }

        if (!TextUtils.isEmpty(editText.getText().toString())) {
            editTextHint.setVisibility(GONE);
        }

        editText.setInputType(InputType.TYPE_NULL);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editTextHint.setVisibility(View.VISIBLE);
                if (s.toString().length() > 0)
                    editTextHint.setVisibility(View.GONE);
            }
        });

        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    showCursor(false);
                    cleanSelectAll();
                }
            }
        });

        editText.setOnTouchListener(touchListener);
        view.setOnTouchListener(touchListener);
    }

    OnTouchListener touchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                showCursor(true);
                if (numKeyboardUtils != null)
                    numKeyboardUtils.setEditView(numInputView);
                if (!isSelectAll()) {
                    selectAll();
                } else {
                    cleanSelectAll();
                }
            }
            return false;
        }
    };

    public void bindNumKeyboard(NumKeyboardUtils numKeyboardUtils) {
        this.numKeyboardUtils = numKeyboardUtils;
    }

    public void selectAll() {
        editText.requestFocus();
        editText.selectAll();
        setSelectAll();
    }

    public void cleanSelectAll() {
        setText(editText.getText() != null ? editText.getText().toString() : "");
    }

    Timer timer;

    public void showCursor(boolean isShow) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (isShow) {
            textCursor.setVisibility(VISIBLE);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    textCursor.post(new Runnable() {
                        @Override
                        public void run() {
                            if (textCursor.getVisibility() == View.VISIBLE) {
                                textCursor.setVisibility(View.INVISIBLE);
                            } else {
                                textCursor.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }, 500, 500);
        } else {
            textCursor.setVisibility(INVISIBLE);
        }

    }

    public boolean isSelectAll() {
        return editText.getTag() != null;
    }

    private void setSelectAll() {
        editText.setTag(true);
    }

    private void notSelectAll() {
        editText.setTag(null);
    }

    public void addText(String text) {
        if (!isSelectAll()) {
            editText.setText(editText.getText() + text);
        } else {
            editText.setText(text);
            notSelectAll();
        }
    }

    public void setHint(String str) {
        editTextHint.setText(str);
    }

    public void setText(String str) {
        editText.setText(str);
        notSelectAll();
    }

    public Editable getText() {
        return editText.getText();
    }

    public void popBack() {
        if (!TextUtils.isEmpty(editText.getText())) {
            if (!isSelectAll()) {
                String content = editText.getText().toString();
                editText.setText(content.substring(0, content.length() - 1));
            } else {
                editText.setText("");
            }
        }
    }

    public void addNum() {
        double num = 0;
        if (!TextUtils.isEmpty(editText.getText()) && !isSelectAll()) {
            num = Double.parseDouble(editText.getText().toString());
        }
        editText.setText(num + 1 + "");
    }

    public void subtractNum() {
        if (!TextUtils.isEmpty(editText.getText()) && !isSelectAll()) {
            double num = Double.parseDouble(editText.getText().toString());
            if (num > 0) {
                editText.setText(num - 1 + "");
                return;
            }
        }
        editText.setText("");
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }

}

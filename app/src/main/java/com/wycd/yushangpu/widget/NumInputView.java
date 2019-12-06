package com.wycd.yushangpu.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wycd.yushangpu.R;

import androidx.annotation.Nullable;

public class NumInputView extends RelativeLayout {

    private EditText editView;
    private TextView editTextHint;
    private View textCursor;
    private Context context;
    private NumKeyboardUtils numKeyboardUtils;
    private NumInputView numInputView;

    public NumInputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.numInputView = this;
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_edit_layout, this, true);

        editView = (EditText) view.findViewById(R.id.edit_text);
        editTextHint = (TextView) view.findViewById(R.id.edit_text_hint);
        textCursor = (View) view.findViewById(R.id.edit_text_cursor);

        switch (getGravity()) {
            case Gravity.RIGHT:
                RelativeLayout.LayoutParams rlpCursor = ((RelativeLayout.LayoutParams) textCursor.getLayoutParams());
                rlpCursor.addRule(ALIGN_PARENT_RIGHT);
                rlpCursor.addRule(RIGHT_OF);
                textCursor.setLayoutParams(rlpCursor);

                RelativeLayout.LayoutParams rlpEdit = ((RelativeLayout.LayoutParams) editView.getLayoutParams());
                rlpEdit.addRule(LEFT_OF, textCursor.getId());
                editView.setLayoutParams(rlpEdit);

                RelativeLayout.LayoutParams rlpHint = ((RelativeLayout.LayoutParams) editTextHint.getLayoutParams());
                rlpHint.addRule(RIGHT_OF);
                rlpHint.addRule(LEFT_OF, textCursor.getId());
                editTextHint.setLayoutParams(rlpHint);
                break;
        }
        if (!TextUtils.isEmpty(editView.getText().toString())) {
            editTextHint.setVisibility(GONE);
        }

        editView.setInputType(InputType.TYPE_NULL);
        editView.addTextChangedListener(new TextWatcher() {
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

        editView.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    textCursor.setVisibility(INVISIBLE);
                    cleanSelectAll();
                }
            }
        });

        editView.setOnTouchListener(touchListener);
        view.setOnTouchListener(touchListener);
    }

    OnTouchListener touchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                textCursor.setVisibility(VISIBLE);
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
        editView.requestFocus();
        editView.selectAll();
        setSelectAll();
    }

    public void cleanSelectAll() {
        setText(editView.getText() != null ? editView.getText().toString() : "");
    }

    public boolean isSelectAll() {
        return editView.getTag() != null;
    }

    private void setSelectAll() {
        editView.setTag(true);
    }

    private void notSelectAll() {
        editView.setTag(null);
    }

    public void addText(String text) {
        if (!isSelectAll()) {
            editView.setText(editView.getText() + text);
        } else {
            editView.setText(text);
            notSelectAll();
        }
    }

    public void setEditTextHint(String str) {
        editTextHint.setText(str);
    }

    public void setText(String str) {
        editView.setText(str);
        notSelectAll();
    }

    public Editable getText() {
        return editView.getText();
    }

    public void popBack() {
        if (!TextUtils.isEmpty(editView.getText())) {
            if (!isSelectAll()) {
                String content = editView.getText().toString();
                editView.setText(content.substring(0, content.length() - 1));
            } else {
                editView.setText("");
            }
        }
    }

    public void addNum() {
        double num = 0;
        if (!TextUtils.isEmpty(editView.getText()) && !isSelectAll()) {
            num = Double.parseDouble(editView.getText().toString());
        }
        editView.setText(num + 1 + "");
    }

    public void subtractNum() {
        if (!TextUtils.isEmpty(editView.getText()) && !isSelectAll()) {
            double num = Double.parseDouble(editView.getText().toString());
            if (num > 0) {
                editView.setText(num - 1 + "");
                return;
            }
        }
        editView.setText("");
    }

//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (textCursor.getVisibility() == View.VISIBLE) {
//                            textCursor.setVisibility(View.INVISIBLE);
//                        } else {
//                            textCursor.setVisibility(View.VISIBLE);
//                        }
//                    }
//                });
//            }
//        }, 500, 500);
}

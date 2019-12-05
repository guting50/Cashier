package com.wycd.yushangpu.widget;

import android.app.Activity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wycd.yushangpu.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnTouch;

public class NumKeyboardUtils {

    private EditText editView;
    private TextView editTextHint;
    private View textCursor;
    private Activity activity;

    public NumKeyboardUtils(Activity activity, View rootView, View editViewLayout) {
        this(activity, rootView, editViewLayout, "");
    }

    public NumKeyboardUtils(Activity activity, View rootView, View editViewLayout, String hintStr) {
        View keyboardViewLayout = rootView.findViewById(R.id.keyboard_layout);
        ButterKnife.bind(this, keyboardViewLayout);
        this.activity = activity;

        setEditView(editViewLayout, hintStr);
    }

    public void setEditView(View editViewLayout, String hintStr) {
        if (textCursor != null)
            textCursor.setVisibility(View.INVISIBLE);
        if (editView != null) {
            editView.setText(editView.getText());
        }
        int count = ((ViewGroup) editViewLayout).getChildCount();
        for (int i = 0; i < count; i++) {
            View view = ((ViewGroup) editViewLayout).getChildAt(i);
            if (view instanceof EditText) {
                editView = (EditText) view;
            } else if (view instanceof TextView) {
                editTextHint = (TextView) view;
            } else
                textCursor = view;
        }
        editTextHint.setText(hintStr);
        textCursor.setVisibility(View.VISIBLE);
        editView.setInputType(InputType.TYPE_NULL);
        editView.clearFocus();
        editView.requestFocus();

        editView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTag() == null)
                    editViewSelectAll();
                else
                    setEditViewText(editView.getText() != null ? editView.getText().toString() : "");
            }
        });
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

    @OnTouch({R.id.num_keyboard_7, R.id.num_keyboard_8, R.id.num_keyboard_9, R.id.num_keyboard_4,
            R.id.num_keyboard_5, R.id.num_keyboard_6, R.id.num_keyboard_1, R.id.num_keyboard_2,
            R.id.num_keyboard_3, R.id.num_keyboard_0, R.id.num_keyboard_dot, R.id.num_keyboard_delete})
    public boolean onViewTouchKeyboard(View view, MotionEvent event) {
        if (view.getId() == R.id.num_keyboard_delete) {
            Timer timer = (Timer) view.getTag();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (timer == null) {
                        timer = new Timer();
                        view.setTag(timer);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!TextUtils.isEmpty(editView.getText())) {
                                            if (editView.getTag() == null) {
                                                String content = editView.getText().toString();
                                                editView.setText(content.substring(0, content.length() - 1));
                                            } else {
                                                setEditViewText("");
                                            }
                                        }
                                    }
                                });
                            }
                        }, 0, 80);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (timer != null) {
                        timer.cancel();
                        view.setTag(null);
                    }
                    break;
            }
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundResource(R.color.text0050);
                break;
            case MotionEvent.ACTION_UP:
                view.setBackgroundResource(R.color.result_view);
                switch (view.getId()) {
                    case R.id.num_keyboard_7:
                        setEditViewText("7");
                        break;
                    case R.id.num_keyboard_8:
                        setEditViewText("8");
                        break;
                    case R.id.num_keyboard_9:
                        setEditViewText("9");
                        break;
                    case R.id.num_keyboard_4:
                        setEditViewText("4");
                        break;
                    case R.id.num_keyboard_5:
                        setEditViewText("5");
                        break;
                    case R.id.num_keyboard_6:
                        setEditViewText("6");
                        break;
                    case R.id.num_keyboard_1:
                        setEditViewText("1");
                        break;
                    case R.id.num_keyboard_2:
                        setEditViewText("2");
                        break;
                    case R.id.num_keyboard_3:
                        setEditViewText("3");
                        break;
                    case R.id.num_keyboard_0:
                        setEditViewText("0");
                        break;
                    case R.id.num_keyboard_dot:
                        if (!TextUtils.isEmpty(editView.getText()) && editView.getTag() == null) {
                            if (!editView.getText().toString().contains("."))
                                editView.setText(editView.getText() + ".");
                        } else
                            setEditViewText("0.");
                        break;
                }
                break;
        }
        return true;
    }

    public void editViewSelectAll() {
        editView.clearFocus();
        editView.requestFocus();
        editView.selectAll();
        editView.setTag(true);
    }

    private void setEditViewText(String text) {
        if (editView.getTag() == null) {
            editView.setText(editView.getText() + text);
        } else {
            editView.setText(text);
            editView.setTag(null);
        }
    }

    public void setText(String str) {
        editView.setText(str);
    }

    public Editable getText() {
        return editView.getText();
    }
}

package com.wycd.yushangpu.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

import com.wycd.yushangpu.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnTouch;

public class NumKeyboardUtils {

    private NumInputView numInputView;
    private Activity activity;
    private OnDelClickListener onDelClickListener;

    public NumKeyboardUtils(Activity activity, View rootView, NumInputView editViewLayout) {
        View keyboardViewLayout = rootView.findViewById(R.id.keyboard_layout);
        ButterKnife.bind(this, keyboardViewLayout);
        this.activity = activity;

        setEditView(editViewLayout);
        addEditView(editViewLayout);
    }

    public void addEditView(NumInputView editViewLayout) {
        editViewLayout.bindNumKeyboard(this);
    }

    public void setEditView(NumInputView editViewLayout) {
        if (numInputView != null)
            numInputView.showCursor(false);
        numInputView = editViewLayout;
        numInputView.showCursor(true);
    }

    public NumInputView getEditView() {
        return numInputView;
    }

    public interface OnDelClickListener {
        void popBack(String str);
    }

    public void setOnDelClickListener(OnDelClickListener onDelClickListener) {
        this.onDelClickListener = onDelClickListener;
    }

    @OnTouch({R.id.num_keyboard_7, R.id.num_keyboard_8, R.id.num_keyboard_9, R.id.num_keyboard_4,
            R.id.num_keyboard_5, R.id.num_keyboard_6, R.id.num_keyboard_1, R.id.num_keyboard_2,
            R.id.num_keyboard_3, R.id.num_keyboard_0, R.id.num_keyboard_dot, R.id.num_keyboard_delete})
    public boolean onViewTouchKeyboard(View view, MotionEvent event) {
        if (view.getId() == R.id.num_keyboard_delete) {
            Timer timer = (Timer) view.getTag();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    String result = numInputView.popBack();
                    if (onDelClickListener != null) {
                        onDelClickListener.popBack(result);
                    }
                    if (timer == null) {
                        timer = new Timer();
                        view.setTag(timer);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String result = numInputView.popBack();
                                        if (onDelClickListener != null) {
                                            onDelClickListener.popBack(result);
                                        }
                                    }
                                });
                            }
                        }, 500, 100);
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
                        numInputView.addText("7");
                        break;
                    case R.id.num_keyboard_8:
                        numInputView.addText("8");
                        break;
                    case R.id.num_keyboard_9:
                        numInputView.addText("9");
                        break;
                    case R.id.num_keyboard_4:
                        numInputView.addText("4");
                        break;
                    case R.id.num_keyboard_5:
                        numInputView.addText("5");
                        break;
                    case R.id.num_keyboard_6:
                        numInputView.addText("6");
                        break;
                    case R.id.num_keyboard_1:
                        numInputView.addText("1");
                        break;
                    case R.id.num_keyboard_2:
                        numInputView.addText("2");
                        break;
                    case R.id.num_keyboard_3:
                        numInputView.addText("3");
                        break;
                    case R.id.num_keyboard_0:
                        numInputView.addText("0");
                        break;
                    case R.id.num_keyboard_dot:
                        if (!TextUtils.isEmpty(numInputView.getText()) && !numInputView.isSelectAll()) {
                            if (!numInputView.getText().toString().contains("."))
                                numInputView.addText(".");
                        } else
                            numInputView.setText("0.");
                        break;
                }
                break;
        }
        return true;
    }
}

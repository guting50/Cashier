package com.wycd.yushangpu.tools;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTimerPass extends CountDownTimer {

	private TextView btn;
	private Activity mActivity;
	private RelativeLayout rl_click;
 private Handler mHandler;
	public MyTimerPass(Activity mActivity, long millisInFuture,
					   long countDownInterval, TextView btn, RelativeLayout rl_click, Handler handler) {
		super(millisInFuture, countDownInterval);
		// TODO Auto-generated constructor stub
		this.btn = btn;
		this.rl_click = rl_click;
		this.mActivity = mActivity;
		mHandler=handler;
	}

	@Override
	public void onTick(long millisUntilFinished) {
		// TODO Auto-generated method stub
//		rl_click.setClickable(false);// ���ò��ܵ��
		btn.setText("跳过"+"("+millisUntilFinished / 1000 + ")");// ���õ���ʱʱ��

		// ���ð�ťΪ��ɫ����ʱ�ǲ��ܵ����
		Spannable span = new SpannableString(btn.getText().toString());// ��ȡ��ť������
		btn.setText(span);

	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		btn.setText("跳过");
//		rl_click.setClickable(true);// ���»�õ��
		LogUtils.d("xx",PreferenceHelper.readBoolean(mActivity,"yunding","gowhere",false)+"");
		if(!PreferenceHelper.readBoolean(mActivity,"yunding","gowhere",false)){
			Message message=mHandler.obtainMessage();
			message.what=111;
			mHandler.sendMessage(message);
		}
	}

}

package com.rucrazia.painmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;import com.rucrazia.iotmanager.MainActivity;import com.rucrazia.iotmanager.R;

public class IntroActivity extends Activity {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	private TextView mImage = null;
	private AlphaAnimation mFadeIn = null;
	private AnimationSet mAnimationSet = null;

	private int mDurationMillis1 = 1500;
	
	private int mHandlerId1 = 1;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == mHandlerId1) {
				startActivity();
			} 
		}
	};

	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//

	// _______________________CONSTRUCTOR____________________________________________________________________//

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_intro);

		initAnimation();
		initAnimationSet();
		initHandler();
	}

	@Override
	public boolean onKeyDown(int KeyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			if (KeyCode == KeyEvent.KEYCODE_BACK) {
				return false;
			}
		}
		return super.onKeyDown(KeyCode, event);
	}

	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//
	private void initAnimation() {
		mFadeIn = new AlphaAnimation(0.1f, 1);
		mFadeIn.setDuration(mDurationMillis1);
		mFadeIn.setStartOffset(0);
	}

	private void initAnimationSet() {
		mAnimationSet = new AnimationSet(true);
		mAnimationSet.setInterpolator(new LinearInterpolator());
		mAnimationSet.addAnimation(mFadeIn);
	}

	private void initHandler() {
		Message m1 = new Message();
		m1.arg1 = mHandlerId1;
		handler.sendMessageDelayed(m1, mDurationMillis1);
	}

	private void startActivity() {
		Intent i = new Intent(IntroActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}

}

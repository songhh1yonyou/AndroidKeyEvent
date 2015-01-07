package com.example.androidkeyeventtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG = "TestKeyEvent";
	private ImageView mImage;
	private TextView mAlphaValueText;
	private int mAlphaValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mImage = (ImageView) findViewById(R.id.image);
		mAlphaValueText = (TextView) findViewById(R.id.alphavalue);
		mAlphaValue = 100;

		mImage.setAlpha(mAlphaValue);
		mAlphaValueText.setText("Alpha=" + mAlphaValue * 100 / 0xff + "%");

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent msg) {
		// TODO Auto-generated method stub
		Log.v(TAG, "KeyDown:keyCode=" + keyCode);
		Log.v(TAG, "KeyDown:String=:" + msg.toString());

		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP:
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			mAlphaValue += 20;
			break;

		case KeyEvent.KEYCODE_DPAD_DOWN:
		case KeyEvent.KEYCODE_DPAD_LEFT:
			mAlphaValue -= 20;
			break;
		default:
			mAlphaValue += 20;
			break;
		}
		
		if(mAlphaValue>=0xFF) 
			mAlphaValue=0xFF;
		if(mAlphaValue<=0x0)
			mAlphaValue=0x0;
		mImage.setAlpha(mAlphaValue);
		mAlphaValueText.setText("Alpha=" + mAlphaValue * 100 / 0xff + "%");
		

		return super.onKeyDown(keyCode, msg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

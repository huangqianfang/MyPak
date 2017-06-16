package com.hqf.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

	@butterknife.BindView(R.id.button)
	Button button;
	@butterknife.BindView(R.id.textview)
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		butterknife.ButterKnife.bind(this);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent( MainActivity.this , SecondActivity.class));
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		EventBus.getDefault().register(this);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}


	@Subscribe(threadMode = ThreadMode.POSTING)
	public void onEventMainThread(FirstEvent event) {

		String msg = "onEventMainThread收到了消息：" + event.getMsg();
		Log.d("harvic", msg);
		textview.setText(msg);
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}
}

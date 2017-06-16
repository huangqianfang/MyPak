package com.hqf.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangqianfang on 2017/6/16.
 * email huangqianfanghn@gmail.com
 */

public class SecondActivity extends Activity {

	@BindView(R.id.button2)
	Button button2;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		ButterKnife.bind(this);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EventBus.getDefault().post(new FirstEvent("0000"));
			}
		});
	}
}

package com.hqf.circleimageview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hqf.circleimageview.view.CircleImageView2;

public class MainActivity extends AppCompatActivity {

	@butterknife.BindView(R.id.circleImageView)
	CircleImageView2 circleImageView;

	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		butterknife.ButterKnife.bind(this);
		final LoopThread loopThread = new LoopThread();
		loopThread.start();
		circleImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(loopThread.isAlive())
					loopThread.handler.sendEmptyMessage(123);

			}
		});

	}

	class LoopThread extends    Thread{


		public   Handler handler = null;

		@Override
		public void run() {
			Looper.prepare();
			handler = new Handler(){
				@Override
				public void handleMessage(Message msg) {
					super.handleMessage(msg);
					switch (msg.what){
						case 123:
							Log.d(TAG ,"000000");
							break;
					}

				}
			};
			Looper.loop();

		}
	}
}

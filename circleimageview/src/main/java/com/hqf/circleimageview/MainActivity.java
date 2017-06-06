package com.hqf.circleimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hqf.circleimageview.view.CircleImageView2;

public class MainActivity extends AppCompatActivity {

	@butterknife.BindView(R.id.circleImageView)
	CircleImageView2 circleImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		butterknife.ButterKnife.bind(this);

	}
}

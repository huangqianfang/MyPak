package com.hqf.mypak.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hqf.mypak.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangqianfang on 2017/6/2.
 * email huangqianfanghn@gmail.com
 */

public class AboutMetralDesignActivity extends AppCompatActivity {

	@BindView(R.id.fruit_image_view)
	ImageView fruitImageView;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.collapsing_toolbar)
	CollapsingToolbarLayout collapsingToolbar;
	@BindView(R.id.appBar)
	AppBarLayout appBar;
	@BindView(R.id.fruit_context_text)
	TextView fruitContextText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_metral_design);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar); //  tool bar 代替 标题栏
		ActionBar actionBar = getSupportActionBar(); // 获取 标题栏对象
		if (actionBar != null)
			actionBar.setDisplayHomeAsUpEnabled(true);   // 显示 标题栏的返回按钮 , 如果if 后边没有加大括号 作用于止于if后边的第一个分号
		collapsingToolbar.setTitle("这里测试rxjava");
		Glide.with(this).load(R.drawable.rxjava).into(fruitImageView);
		initText();
	}

	private void initText() {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i< 50 ;i++){
//		fruitContextText.setText();
			stringBuffer.append("这里测试rxjava");
		}

		fruitContextText.setText(stringBuffer.toString());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case  android.R.id.home:
				finish();
				return  true;

		}
		return super.onOptionsItemSelected(item);
	}
}

package com.hqf.mypak.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hqf.mypak.R;

/**
 * Created by huangqianfang on 2017/5/26.
 * email huangqianfanghn@gmail.com
 */

public class SecondActivity extends AppCompatActivity {

	public static final  String FRUIT_NAME = "fruit_name";
	public static final  String FRUIT_IMAGE_ID = "fruit_name_id";


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);

		Intent intent = getIntent();
		String fruitname = intent.getStringExtra(FRUIT_NAME);
		int fruitimageid = intent.getIntExtra(FRUIT_IMAGE_ID , -1);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

		CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

		ImageView fruitImageView = (ImageView) findViewById(R.id.fruit_image_view);
		TextView  fruitcontenttext = (TextView) findViewById(R.id.fruit_context_text);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if(actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		collapsingToolbarLayout.setTitle(fruitname);

		Glide.with(this).load(fruitimageid).into(fruitImageView);
		String fruitContent  = generateFruitContent(fruitname);
		fruitcontenttext.setText(fruitContent);

	}

	private String generateFruitContent(String fruitName){
		StringBuffer fruitContent = new StringBuffer();
		for(int i = 0; i<500;i++){
			fruitContent.append(fruitName);
		}
	return  fruitContent.toString();
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

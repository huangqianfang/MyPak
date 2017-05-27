package com.hqf.mypak.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by huangqianfang on 2017/5/26.
 * email huangqianfanghn@gmail.com
 */

public class MyApp extends Application {

	private static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
	}

	public static Context getContext(){
		return  context;
	}
}

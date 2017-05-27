package com.hqf.mypak.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by huangqianfang on 2017/5/26.
 * email huangqianfanghn@gmail.com
 */

public class MyApp extends Application {

	public static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
	}
}

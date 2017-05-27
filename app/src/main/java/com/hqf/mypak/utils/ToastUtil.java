package com.hqf.mypak.utils;

import android.widget.Toast;

import com.hqf.mypak.application.MyApp;

/**
 * Created by huangqianfang on 2017/5/26.
 * email huangqianfanghn@gmail.com
 */

public class ToastUtil {

	public static  void showToast(String str){
		Toast.makeText(MyApp.context , str , Toast.LENGTH_SHORT).show();
	}
}

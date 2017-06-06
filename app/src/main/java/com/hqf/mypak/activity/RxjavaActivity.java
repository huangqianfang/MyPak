package com.hqf.mypak.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.hqf.mypak.R;
import com.hqf.mypak.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by huangqianfang on 2017/6/2.
 * email huangqianfanghn@gmail.com
 */

public class RxjavaActivity extends AppCompatActivity {

	private static final String TAG = "RxjavaActivity";
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.imageview)
	ImageView imageview;
	private Observer<String> observer;
	private Subscriber<String> subscriber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rxjava);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		actionBar.setTitle("RxJava");
		testUseObserverAndSubscriber();

//		testUseObservable1();
//		testUseObservable2();
//		testUseObservable3();
//		putOutLog();
        addImageRecoseToImageView();
//		threadChange();
	}

	private void threadChange() {
		Observable.from(new String[] {"1","2","3","4",}).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				LogUtil.d(TAG , s.toString());
			}
		});
	}

	/**
	 *
	 */
	private void addImageRecoseToImageView() {
		final  int drawable2 = R.drawable.ic_side;
		Observable.create(new OnSubscribe<Drawable>() {
			@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
			@Override
			public void call(Subscriber<? super Drawable> subscriber) {
				Drawable drawable = getTheme().getDrawable(drawable2);
				subscriber.onNext(drawable);
				subscriber.onCompleted();

			}
		}).subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new Subscriber<Drawable>() {
				@Override
				public void onCompleted() {
					LogUtil.d(TAG ,"调用完成");
				}

				@Override
				public void onError(Throwable e) {
					LogUtil.d(TAG , e.getMessage());

				}

				@Override
				public void onNext(Drawable drawable) {
					imageview.setImageDrawable(drawable);
				}
			});

	}

	/**
	 * 打印出 相关的东西
	 */
	private void putOutLog() {
		String[] names = {"123", "1232", "132"};

		Observable.from(names).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				LogUtil.d(TAG, s.toString());
			}
		});

	}

	private void testUseObservable1() {

		Observable observable = Observable.create(new OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("Hello");
				subscriber.onNext("Hi");
				subscriber.onNext("Aloha");
				subscriber.onCompleted();
			}
		});

		observable.subscribe(observer);

	}

	private void testUseObservable2() {

		Observable observable = Observable.just("hello", "hi", "alopa");

	}

	private void testUseObservable3() {

		String[] words = {"Hello", "Hi", "Aloha"};
		Observable observable = Observable.from(words);
		observable.subscribe(subscriber);

	}


	private void testUseObserverAndSubscriber() {

		observer = new Observer<String>() {


			@Override
			public void onNext(String s) {
				LogUtil.d(TAG, s);
			}

			@Override
			public void onCompleted() {
				LogUtil.d(TAG, "onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				LogUtil.d(TAG, e.getMessage());
			}


		};


		subscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				LogUtil.d(TAG, "onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				LogUtil.d(TAG, e.getMessage());
			}

			@Override
			public void onNext(String s) {
				LogUtil.d(TAG, s);
			}
		};
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);

	}

	private void action() {


	}
}

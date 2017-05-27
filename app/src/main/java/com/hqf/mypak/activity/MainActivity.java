package com.hqf.mypak.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hqf.mypak.R;
import com.hqf.mypak.adapter.FruitAdapter;
import com.hqf.mypak.bean.Fruit;
import com.hqf.mypak.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@BindView(R.id.toolbar)
	Toolbar toolbar;
	//	@BindView(R.id.textview_side)
//	TextView textviewSide;
	@BindView(R.id.drawerlayout)
	DrawerLayout drawerlayout;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.fab)
	FloatingActionButton fab;
	@BindView(R.id.swipe_refresh)
	SwipeRefreshLayout swipeRefresh;

	private Fruit[] fruits = {new Fruit("pc1", R.drawable.pc1), new Fruit("pc2", R.drawable.pc2),
			new Fruit("pc3", R.drawable.pc3), new Fruit("pc4", R.drawable.pc4), new Fruit("pc5", R.drawable.pc5),
			new Fruit("pc6", R.drawable.pc6), new Fruit("pc7", R.drawable.pc7), new Fruit("pc8", R.drawable.pc8),
			new Fruit("pc9", R.drawable.pc9), new Fruit("pc10", R.drawable.pc10), new Fruit("pc11", R.drawable.pc11),
			new Fruit("pc12", R.drawable.pc12)};
	private List<Fruit> fruitList = new ArrayList<Fruit>();

	private FruitAdapter mFuitAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeAsUpIndicator(R.drawable.ic_side);
		}
		initFruits();
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
		recyclerView.setLayoutManager(layoutManager);
		mFuitAdapter = new FruitAdapter(fruitList);
		recyclerView.setAdapter(mFuitAdapter);

		swipeRefresh.setColorSchemeResources(android.R.color.holo_blue_light,
				android.R.color.holo_red_light,android.R.color.holo_orange_light,
				android.R.color.holo_green_light);

		swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				refreshFruits();
			}

		});



		navView.setCheckedItem(R.id.nav_view);
		navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				drawerlayout.closeDrawers();
				return true;
			}
		});
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				ToastUtil.showToast("dianji le  zan men de xuanfu chuang");
				Snackbar.make(v, "show snackbar", Snackbar.LENGTH_SHORT).setAction("undo", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ToastUtil.showToast("dianjile snackbar");
					}
				}).show();
			}

		});



	}


	private void refreshFruits() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						initFruits();
						mFuitAdapter.notifyDataSetChanged();
						swipeRefresh.setRefreshing(false);
					}
				});
			}
		}).start();

	}

	private void initFruits() {
		fruitList.clear();
		for (int i = 0; i < 50; i++) {
			Random random = new Random();
			int index = random.nextInt(fruits.length);
			fruitList.add(fruits[index]);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.toolbar, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String btnMsg = null;
		switch (item.getItemId()) {
			case R.id.backup:
				btnMsg = "backup";
				break;

			case R.id.delete:
				btnMsg = "delete";
				break;

			case R.id.seting:
				btnMsg = "seting";
				break;
			case android.R.id.home:
				drawerlayout.openDrawer(GravityCompat.START);
				return true;
//				break;
			default:
				btnMsg = "weizhi";
				break;

		}
		ToastUtil.showToast(btnMsg);
		return true;
	}
}

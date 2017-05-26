package com.hqf.mypak;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by huangqianfang on 2017/5/26.
 * email huangqianfanghn@gmail.com
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

	private Context mContext;

	private List<Fruit> mFuitList;

	public FruitAdapter(List<Fruit> fruitList){
		mFuitList = fruitList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if(mContext == null){
			mContext =parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent , false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Fruit fruit = mFuitList.get(position);
		holder.fruitName.setText(fruit.getName());
		Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);

	}

	@Override
	public int getItemCount() {
		return mFuitList.size();
	}

	static class ViewHolder extends  RecyclerView.ViewHolder{

		CardView cardView;
		ImageView fruitImage;
		TextView fruitName;

		public ViewHolder(View itemView) {
			super(itemView);

			cardView = (CardView) itemView;
			fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
			fruitName = (TextView) itemView.findViewById(R.id.fruit_name);

		}
	}

}

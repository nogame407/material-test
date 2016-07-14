package com.ryancordero.materialdesigned;

import android.support.v7.*;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Collections;
import java.util.List;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.sax.Element;
import android.content.Intent;

public class NavRecyclerAdapter extends RecyclerView.Adapter<NavRecyclerAdapter.MyViewHolder>
{
	private LayoutInflater inflater;
	List<Information> data = Collections.emptyList();
	private Context context;


	public NavRecyclerAdapter(Context context, List<Information> data)
	{
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.data = data;
	}

	public void delete(int position)
	{
		data.remove(position);
		notifyItemRemoved(position);
	}


	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View view = inflater.inflate(R.layout.custom_row, parent, false);
		MyViewHolder holder = new MyViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position)
	{
		Information current = data.get(position);
		holder.title.setText(current.title);
		holder.icon.setImageResource(current.iconID);

	}

	@Override
	public int getItemCount()
	{ return data.size(); }

	class MyViewHolder extends RecyclerView.ViewHolder 	implements OnClickListener
	{

		TextView title;
		ImageView icon;

		public MyViewHolder(View itemView)
		{
			super(itemView); 
			itemView.setOnClickListener(this);

			title = (TextView) itemView.findViewById(R.id.listText);
			icon = (ImageView) itemView.findViewById(R.id.listIcon);

		}

		@Override
		public void onClick(View v)
		{
			context.startActivity(new Intent(context, SubActivity.class));

		}


	}



}

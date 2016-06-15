package com.ryancordero.materialdesigned;
import android.support.v7.app.*;
import android.os.*;
import android.view.*;
import android.support.v7.widget.*;

public class SubActivity extends ActionBarActivity
{
	private Toolbar toolbar;
	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState, persistentState);
		toolbar = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(toolbar);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
}

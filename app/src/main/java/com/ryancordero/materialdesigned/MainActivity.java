package com.ryancordero.materialdesigned;

import android.view.*;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
 {
	private Toolbar toolbar;
	// Log tag below
	private static final String MATERIAL ="Material Design";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		Log.d(MATERIAL, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);
		
		Log.d(MATERIAL, "Main Layout");
		toolbar = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		
		Log.d(MATERIAL, "ToolBar Setup"); 
		
		 NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) 
			getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
			
		Log.d(MATERIAL, "NavigationDrawerFragment");
			
		 drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)(findViewById(R.id.drawer_layout)), toolbar);
		
    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		//getMenuInflater().inflate(R.menu.menu_main, menu);
		//return super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		for (int i = 0; i < menu.size(); i++) {
			menu.getItem(i).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		Log.d(MATERIAL, "Menu Inflater");
		
		return super.onCreateOptionsMenu(menu);
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		int id = item.getItemId();
		
		if(id == R.id.hello){
			Toast.makeText(this, "Hey you just hit " +item.getTitle(),Toast.LENGTH_SHORT).show();
		}
		
		if(id == R.id.Menu1){
			Toast.makeText(this, "hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
		}
		
		if(id == R.id.Menu2){
			Toast.makeText(this, "Hey you selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
		}
		
		if(id == R.id.navigate){
			startActivity(new Intent(this, SubActivity.class));
			}
		return super.onOptionsItemSelected(item);
	}
	
}

package com.ryancordero.materialdesigned;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity
{
	
	private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		toolbar = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(toolbar);
		
		
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		int id = item.getItemId();
		
		
		if(id == R.id.navigate){
			startActivity(new Intent(this, SubActivity.class));
			}
		return super.onOptionsItemSelected(item);
	}
	


	
	
}

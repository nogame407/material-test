package com.ryancordero.materialdesigned;

import android.content.*;
import android.view.*;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;

import com.ryancordero.materialdesigned.NavRecyclerAdapter;
import com.ryancordero.materialdesigned.Information;




public class NavigationDrawerFragment extends Fragment
{
	private RecyclerView recyclerView;
	public static final String PREF_FILE_NAME="testpref";
	public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";	
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private NavRecyclerAdapter mAdapter;
	private boolean mUserLearnedDrawer;

	private boolean mFromSavedInstanceState;
	private View containerView;

	private static final String LOG_NAVIGATION_FRAGMENT = "Navigation Fragment";

	public NavigationDrawerFragment()
	{
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
		Log.d(LOG_NAVIGATION_FRAGMENT, "mUserLearedDrawer Boolean set");

		if (savedInstanceState != null) {
			
			mFromSavedInstanceState = true;
		}
	}


	public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolBar)
	{
		containerView=getActivity().findViewById(fragmentId);
		
		mDrawerLayout = drawerLayout;
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolBar, R.string.drawer_open, R.string.drawer_close){

			@Override
			public void onDrawerOpened(View drawerView)
			{
				if(!mUserLearnedDrawer){
					mUserLearnedDrawer = true;
					saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
					super.onDrawerOpened(drawerView);
				}
				getActivity().invalidateOptionsMenu();
			}
			
			@Override
			public void onDrawerClosed(View drawerView)
			{
				getActivity().invalidateOptionsMenu();
				super.onDrawerClosed(drawerView);
			}
			
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset)
			{
				super.onDrawerSlide(drawerView, slideOffset);
				if(slideOffset<0.6){
					toolBar.setAlpha(1-slideOffset);
				}
			}
			
		};
		
		if(!mUserLearnedDrawer && !mFromSavedInstanceState){
			
			mDrawerLayout.openDrawer(containerView);
		}

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mDrawerLayout.post(new Runnable() {

				@Override
				public void run()
				{
					mDrawerToggle.syncState();
				}
		});
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Log.d(LOG_NAVIGATION_FRAGMENT, "onCreateView Start");
		
		View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
		recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
		mAdapter = new NavRecyclerAdapter(getActivity(), getData());
		recyclerView.setAdapter(mAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		
		Log.d(LOG_NAVIGATION_FRAGMENT, "RecyclerView finished");
		
		return layout;
	}
	
	public static List<Information> getData() 
	{	
		List<Information> data = new ArrayList<>();
		int[] icons={R.drawable.ic_number1, R.drawable.ic_number2, R.drawable.ic_number3, R.drawable.ic_number4};
		String[] titles = {"Ryan", "Anthony", "Adrian", "Michael"};
		for(int i = 0; i < titles.length && i < icons.length; i++)
		{
			Information current = new Information();
			current.iconID = icons[i];
			current.title = titles[i];
			data.add(current);
		}
		Log.d(LOG_NAVIGATION_FRAGMENT, "Create static information list");
		return data;
	}

	public static void saveToPreferences(Context context, String preferenceName, String preferenceValue)
	{
		Log.d(LOG_NAVIGATION_FRAGMENT, "Saved prefrences");
		SharedPreferences SharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = SharedPreferences.edit();
		editor.putString(preferenceName, preferenceValue);
		editor.apply();
	}

	public static String readFromPreferences(Context context, String preferenceName, String defaultValue)
	{
		Log.d(LOG_NAVIGATION_FRAGMENT, "Read preferences");
		SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

		return sharedPreferences.getString(preferenceName, defaultValue);
	}

}

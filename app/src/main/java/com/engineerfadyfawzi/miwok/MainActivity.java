package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView( R.layout.activity_main );
        
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById( R.id.view_pager );
        
        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter categoryAdapter = new CategoryAdapter( this, getSupportFragmentManager() );
        
        // set the adapter onto the view pager
        viewPager.setAdapter( categoryAdapter );
        
        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById( R.id.tab_layout );
        
        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager( viewPager );
    }
}
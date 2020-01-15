package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
        CategoryAdapter categoryAdapter = new CategoryAdapter( getSupportFragmentManager() );
        
        // set the adapter onto the view pager
        viewPager.setAdapter( categoryAdapter );
    }
}
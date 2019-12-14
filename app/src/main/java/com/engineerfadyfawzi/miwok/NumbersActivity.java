package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity
{
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_numbers );
        
        // create a list fo words
        ArrayList< String > words = new ArrayList< String >();
        words.add( "one" );
        words.add( "two" );
        words.add( "three" );
        words.add( "four" );
        words.add( "five" );
        words.add( "six" );
        words.add( "seven" );
        words.add( "eight" );
        words.add( "nine" );
        words.add( "ten" );
        
        // Find the root view we can add child views to it
        LinearLayout rootView = findViewById( R.id.root_view );
        
        // Create a variable to keep track of the current index position
        int index = 0;
        
        // Keep looping until we've reached the end of the list (which means keep looping
        // as long as the current index position is less than the length of the list)
        while ( index < words.size() )
        {
            // Create a new TextView
            TextView wordView = new TextView( this );
            
            // Set the text to be word at the current index
            wordView.setText( words.get( index ) );
            
            // Add this TextView as another child to the root view of this layout
            rootView.addView( wordView );
            
            // Increment the index variable by 1
            index++;
        }
    }
}
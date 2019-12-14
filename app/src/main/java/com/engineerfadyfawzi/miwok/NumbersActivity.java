package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
        
        // Verify the contents of the list by printing out each array element to the logs
        Log.v( "NumbersActivity", "Word at index 0: " + words.get( 0 ) );
        Log.v( "NumbersActivity", "Word at index 1: " + words.get( 1 ) );
        Log.v( "NumbersActivity", "Word at index 2: " + words.get( 2 ) );
        Log.v( "NumbersActivity", "Word at index 3: " + words.get( 3 ) );
        Log.v( "NumbersActivity", "Word at index 4: " + words.get( 4 ) );
        Log.v( "NumbersActivity", "Word at index 5: " + words.get( 5 ) );
        Log.v( "NumbersActivity", "Word at index 6: " + words.get( 6 ) );
        Log.v( "NumbersActivity", "Word at index 7: " + words.get( 7 ) );
        Log.v( "NumbersActivity", "Word at index 8: " + words.get( 8 ) );
        Log.v( "NumbersActivity", "Word at index 9: " + words.get( 9 ) );
    }
}
package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity
{
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_list );
        
        // create a list of words
        ArrayList< Word > words = new ArrayList< Word >();
        words.add( new Word( "one", "lutti" ) );
        words.add( new Word( "two", "otiiko" ) );
        words.add( new Word( "three", "tolookosu" ) );
        words.add( new Word( "four", "oyyisa" ) );
        words.add( new Word( "five", "massokka" ) );
        words.add( new Word( "six", "temmokka" ) );
        words.add( new Word( "seven", "kenekaku" ) );
        words.add( new Word( "eight", "kawinta" ) );
        words.add( new Word( "nine", "wo’e" ) );
        words.add( new Word( "ten", "na’aacha" ) );
        
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        WordAdapter wordsAdapter = new WordAdapter( this, words );
        
        // Find the {@link ListView) object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        // in the word_list.xml layout file.
        ListView listView = findViewById( R.id.list_view );
        
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list of words.
        listView.setAdapter( wordsAdapter );
    }
}
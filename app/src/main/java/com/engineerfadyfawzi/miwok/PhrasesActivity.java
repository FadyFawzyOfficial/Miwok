package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity
{
    private WordAdapter wordAdapter;
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_list );
        
        // create a list of words
        final ArrayList< Word > words = new ArrayList< Word >();
        words.add( new Word( R.string.phrase_where_are_you_going, R.string.miwok_phrase_where_are_you_going, R.raw.phrase_where_are_you_going ) );
        words.add( new Word( R.string.phrase_what_is_your_name, R.string.miwok_phrase_what_is_your_name, R.raw.phrase_what_is_your_name ) );
        words.add( new Word( R.string.phrase_my_name_is, R.string.miwok_phrase_my_name_is, R.raw.phrase_my_name_is ) );
        words.add( new Word( R.string.phrase_how_are_you_feeling, R.string.miwok_phrase_how_are_you_feeling, R.raw.phrase_how_are_you_feeling ) );
        words.add( new Word( R.string.phrase_im_feeling_good, R.string.miwok_phrase_im_feeling_good, R.raw.phrase_im_feeling_good ) );
        words.add( new Word( R.string.phrase_are_you_coming, R.string.miwok_phrase_are_you_coming, R.raw.phrase_are_you_coming ) );
        words.add( new Word( R.string.phrase_yes_im_coming, R.string.miwok_phrase_yes_im_coming, R.raw.phrase_yes_im_coming ) );
        words.add( new Word( R.string.phrase_im_coming, R.string.miwok_phrase_im_coming, R.raw.phrase_im_coming ) );
        words.add( new Word( R.string.phrase_lets_go, R.string.miwok_phrase_lets_go, R.raw.phrase_lets_go ) );
        words.add( new Word( R.string.phrase_come_here, R.string.miwok_phrase_come_here, R.raw.phrase_come_here ) );
        
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        wordAdapter = new WordAdapter( this, words, R.color.category_phrases );
        
        // Find the {@link ListView) object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        // in the word_list layout file.
        ListView listView = findViewById( R.id.list_view );
        
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list of words.
        listView.setAdapter( wordAdapter );
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
        
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        wordAdapter.releaseMediaPlayer();
    }
}
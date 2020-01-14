package com.engineerfadyfawzi.miwok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class ColorsFragment extends Fragment
{
    // make {@link WordAdapter} variable global so we can call its methods
    // in onCreate method as well as onStop method
    private WordAdapter wordAdapter;
    
    public ColorsFragment()
    {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState )
    {
        View rootView = inflater.inflate( R.layout.word_list, container, false );
        
        // create a list of words
        final ArrayList< Word > words = new ArrayList< Word >();
        words.add( new Word( R.string.color_red, R.string.miwok_color_red, R.drawable.color_red, R.raw.color_red ) );
        words.add( new Word( R.string.color_mustard_yellow, R.string.miwok_color_mustard_yellow, R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow ) );
        words.add( new Word( R.string.color_dusty_yellow, R.string.miwok_color_dusty_yellow, R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow ) );
        words.add( new Word( R.string.color_green, R.string.miwok_color_green, R.drawable.color_green, R.raw.color_green ) );
        words.add( new Word( R.string.color_brown, R.string.miwok_color_brown, R.drawable.color_brown, R.raw.color_brown ) );
        words.add( new Word( R.string.color_gray, R.string.miwok_color_gray, R.drawable.color_gray, R.raw.color_gray ) );
        words.add( new Word( R.string.color_black, R.string.miwok_color_black, R.drawable.color_black, R.raw.color_black ) );
        words.add( new Word( R.string.color_white, R.string.miwok_color_white, R.drawable.color_white, R.raw.color_white ) );
        
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        wordAdapter = new WordAdapter( getActivity(), words, R.color.category_colors );
        
        // Find the {@link ListView) object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        // in the word_list.xml layout file.
        ListView listView = rootView.findViewById( R.id.list_view );
        
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list of words.
        listView.setAdapter( wordAdapter );
        
        return rootView;
    }
    
    @Override
    public void onStop()
    {
        super.onStop();
    
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        wordAdapter.releaseMediaPlayer();
    }
}
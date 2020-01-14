package com.engineerfadyfawzi.miwok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class NumbersFragment extends Fragment
{
    // make {@link WordAdapter} variable global so we can call its methods
    // in onCreate method as well as onStop method
    private WordAdapter wordAdapter;
    
    public NumbersFragment()
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
        words.add( new Word( R.string.number_one, R.string.miwok_number_one, R.drawable.number_one, R.raw.number_one ) );
        words.add( new Word( R.string.number_two, R.string.miwok_number_two, R.drawable.number_two, R.raw.number_two ) );
        words.add( new Word( R.string.number_three, R.string.miwok_number_three, R.drawable.number_three, R.raw.number_three ) );
        words.add( new Word( R.string.number_four, R.string.miwok_number_four, R.drawable.number_four, R.raw.number_four ) );
        words.add( new Word( R.string.number_five, R.string.miwok_number_five, R.drawable.number_five, R.raw.number_five ) );
        words.add( new Word( R.string.number_six, R.string.miwok_number_six, R.drawable.number_six, R.raw.number_six ) );
        words.add( new Word( R.string.number_seven, R.string.miwok_number_seven, R.drawable.number_seven, R.raw.number_seven ) );
        words.add( new Word( R.string.number_eight, R.string.miwok_number_eight, R.drawable.number_eight, R.raw.number_eight ) );
        words.add( new Word( R.string.number_nine, R.string.miwok_number_nine, R.drawable.number_nine, R.raw.number_nine ) );
        words.add( new Word( R.string.number_ten, R.string.miwok_number_ten, R.drawable.number_ten, R.raw.number_ten ) );
        
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        wordAdapter = new WordAdapter( getActivity(), words, R.color.category_numbers );
        
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
package com.engineerfadyfawzi.miwok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of family vocabulary words.
 */
public class FamilyFragment extends Fragment
{
    // make {@link WordAdapter} variable global so we can call its methods
    // in onCreate method as well as onStop method
    private WordAdapter wordAdapter;
    
    public FamilyFragment()
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
        words.add( new Word( R.string.family_father, R.string.miwok_family_father, R.drawable.family_father, R.raw.family_father ) );
        words.add( new Word( R.string.family_mother, R.string.miwok_family_mother, R.drawable.family_mother, R.raw.family_mother ) );
        words.add( new Word( R.string.family_son, R.string.miwok_family_son, R.drawable.family_son, R.raw.family_son ) );
        words.add( new Word( R.string.family_daughter, R.string.miwok_family_daughter, R.drawable.family_daughter, R.raw.family_daughter ) );
        words.add( new Word( R.string.family_older_brother, R.string.miwok_family_older_brother, R.drawable.family_older_brother, R.raw.family_older_brother ) );
        words.add( new Word( R.string.family_younger_brother, R.string.miwok_family_younger_brother, R.drawable.family_younger_brother, R.raw.family_younger_brother ) );
        words.add( new Word( R.string.family_older_sister, R.string.miwok_family_older_sister, R.drawable.family_older_sister, R.raw.family_older_sister ) );
        words.add( new Word( R.string.family_younger_sister, R.string.miwok_family_younger_sister, R.drawable.family_younger_sister, R.raw.family_younger_sister ) );
        words.add( new Word( R.string.family_grandmother, R.string.miwok_family_grandmother, R.drawable.family_grandmother, R.raw.family_grandmother ) );
        words.add( new Word( R.string.family_grandfather, R.string.miwok_family_grandfather, R.drawable.family_grandfather, R.raw.family_grandfather ) );
    
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list.
        wordAdapter = new WordAdapter( getActivity(), words, R.color.category_family );
    
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
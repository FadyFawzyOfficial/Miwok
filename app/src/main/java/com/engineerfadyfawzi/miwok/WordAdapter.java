package com.engineerfadyfawzi.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter< Word >
{
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;
    
    /**
     * Create a new {@link WordAdapter} object.
     *
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to infalte the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context is the current context (i.e. Activity) that adapter is being created in.
     * The current context. Used to inflate the layout file.
     * @param words is the list of {@link Word}s to be displayed.
     * A list of Word objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter( Context context, ArrayList< Word > words, int colorResourceId )
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super( context, 0, words );
        mColorResourceId = colorResourceId;
    }
    
    /**
     * Provides a view for an Adapter View ( ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     * list item View.
     * @param convertView the recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if ( listItemView == null )
            listItemView = LayoutInflater.from( getContext() ).inflate( R.layout.list_item, parent, false );
        
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem( position );
        
        // Find the TextView in the list_item.xml layout with the ID miwok_translation_text_view.
        TextView miwokTranslationTextView = listItemView.findViewById( R.id.miwok_translation_text_view );
        
        // Get the Miwok translation from the currentWord object and set this text on the Miwok TextView.
        miwokTranslationTextView.setText( currentWord.getMiwokTranslationId() );
        
        // Find the TextView in the list_item.xml layout with the ID default_translation_text_view.
        TextView defaultTranslationTextView = listItemView.findViewById( R.id.default_translation_text_view );
        
        // Get the default translation from the currentWord object and set this text on the default TextView.
        defaultTranslationTextView.setText( currentWord.getDefaultTranslationId() );
        
        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById( R.id.image );
        
        // Check if an image is provided for this Word or not
        if ( currentWord.hasImage() )
        {
            // If an image is available, display the provided image based on the resource ID
            
            // Get the image resource ID from the currentWord object and
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource( currentWord.getImageResourceId() );
            
            // make sure the view is visible
            // imageView.setVisibility( View.VISIBLE );
        }
        else
        {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility( View.GONE );
        }
        
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById( R.id.text_container );
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor( getContext(), mColorResourceId );
        // Set the background color of the text container View
        textContainer.setBackgroundColor( color );
        
        //        // Set the theme color for the list item
        //        View textContainer = listItemView.findViewById( R.id.text_container );
        //        // Set the background color of the text container View
        //        textContainer.setBackgroundResource( mColorResourceId );
        
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView.
        return listItemView;
    }
}
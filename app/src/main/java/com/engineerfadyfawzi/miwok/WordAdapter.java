package com.engineerfadyfawzi.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;
    
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion( MediaPlayer mediaPlayer )
        {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    
    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;
    
    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange( int focusChange )
        {
            switch ( focusChange )
            {
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    // Pause playback because your Audio Focus was
                    // temporarily stolen, but will be back soon.
                    // i.e. for a phone call
                    
                    // Lower the volume, because something else is also playing audio over you.
                    // i.e. for notifications or navigation directions, So
                    // Depending on your audio playback, you may prefer to pause playback here instead.
                    
                    // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus
                    // for a short amount og time.
                    // The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that our app is allowed to
                    // continue playing sound but at a lower volume.
                    // We'll both cases the same way because our app is playing short sound files.
                    
                    // Pause playback and reset player to the start of the file. That way, we can
                    // play the word from the beginning when we resume playback.
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo( 0 );
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    // Resume playback, because you hold the Audio Focus again!
                    // i.e. the phone call ended or the nav directions are finished
                    // If you implement ducking and lower the volume,
                    // be sure to return it to normal here, as well.
                    
                    // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    // Stop playback, because you lost the Audio Focus.
                    // i.e. the user started some other playback app
                    // Remember to unregister your controls/buttons here. And release the Audio Focus!
                    
                    // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                    // Stop playback and clean up resources.
                    releaseMediaPlayer();
                    break;
            }
        }
    };
    
    
    /**
     * Create a new {@link WordAdapter} object.
     *
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
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
        
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = ( AudioManager ) getContext().getSystemService( Context.AUDIO_SERVICE );
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
        final Word currentWord = getItem( position );
        
        // Find the TextView in the list_item.xml layout with the ID miwok_translation_text_view.
        TextView miwokTranslationTextView = listItemView.findViewById( R.id.miwok_translation_text_view );
        
        // Get the Miwok translation from the currentWord object and set this text on the Miwok TextView.
        miwokTranslationTextView.setText( currentWord.getMiwokTranslation() );
        
        // Find the TextView in the list_item.xml layout with the ID default_translation_text_view.
        TextView defaultTranslationTextView = listItemView.findViewById( R.id.default_translation_text_view );
        
        // Get the default translation from the currentWord object and set this text on the default TextView.
        defaultTranslationTextView.setText( currentWord.getDefaultTranslation() );
        
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
        
        // Set a click listener to play the audio when the list item is clicked on
        // Add OnClickListener to each item view
        listItemView.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                
                // Request audio focus so in order to play the audio file, The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT
                int result = mAudioManager.requestAudioFocus( mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT );
                
                if ( result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED )
                {
                    // We have an audio focus now.
                    // Start playback
                    
                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word object (in the array list)
                    mMediaPlayer = MediaPlayer.create( getContext(), currentWord.getAudioResourceId() );
                    
                    // Start the audio file
                    mMediaPlayer.start();
                    
                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener( mCompletionListener );
                }
            }
        } );
        
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView.
        return listItemView;
    }
    
    /**
     * Clean up the media player by releasing its resources.
     */
    public void releaseMediaPlayer()
    {
        // If the media player is not null, then it may be currently playing a sound.
        if ( mMediaPlayer != null )
        {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            
            // Regardless of whether or not we were granted audio focus, abandon it.
            // Tis also unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus( mOnAudioFocusChangeListener );
        }
    }
}
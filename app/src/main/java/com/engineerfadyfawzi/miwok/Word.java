package com.engineerfadyfawzi.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class Word
{
    /**
     * String resource Id for the default translation of the word
     */
    private int mDefaultTranslationId;
    
    /**
     * String resource Id for the Miwok translation of the word
     */
    private int mMiwokTranslationId;
    
    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;
    
    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    
    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    
    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     * user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     * @param audioResourceId is the resource ID for the audio file associated with the word
     */
    public Word( int defaultTranslationId, int miwokTranslationId, int audioResourceId )
    {
        mDefaultTranslationId = defaultTranslationId;
        mMiwokTranslationId = miwokTranslationId;
        mAudioResourceId = audioResourceId;
    }
    
    /**
     * Create a new Word object with image.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     * user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for image associated with the word
     * @param audioResourceId is the resource ID for the audio file associated with the word
     */
    public Word( int defaultTranslationId, int miwokTranslationId, int imageResourceId, int audioResourceId )
    {
        mDefaultTranslationId = defaultTranslationId;
        mMiwokTranslationId = miwokTranslationId;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }
    
    /**
     * Get the string resource ID for the default translation of the word.
     *
     * @return
     */
    public int getDefaultTranslationId()
    {
        return mDefaultTranslationId;
    }
    
    /**
     * Get the string resource ID for the Miwok translation of the word.
     *
     * @return
     */
    public int getMiwokTranslationId()
    {
        return mMiwokTranslationId;
    }
    
    /**
     * Return the image resource ID of the word.
     *
     * @return
     */
    public int getImageResourceId()
    {
        return mImageResourceId;
    }
    
    /**
     * Return the audio resource ID of the word.
     *
     * @return
     */
    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }
    
    /**
     * Returns whether or not there is an image for this word.
     *
     * @return
     */
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    
    // So we could of added two setter methods to allow the two strings to be changed
    // by an outside Word class
    // However for the purpose of this app, one we create the word object,
    // we don't expect the English or Miwok words to change.
    // Hence we won't provide setter methods to modify the state of the word object.
}
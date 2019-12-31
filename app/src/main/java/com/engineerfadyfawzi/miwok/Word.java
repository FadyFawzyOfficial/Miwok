package com.engineerfadyfawzi.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and an image for that word.
 */
public class Word
{
    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    
    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;
    
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
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word( String defaultTranslation, String miwokTranslation )
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    
    /**
     * Create a new Word object with image.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for image associated with the word
     */
    public Word( String defaultTranslation, String miwokTranslation, int imageResourceId )
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }
    
    /**
     * Get the default translation of the word.
     *
     * @return
     */
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }
    
    /**
     * Get the Miwok translation of the word.
     *
     * @return
     */
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
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
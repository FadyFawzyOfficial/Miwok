package com.engineerfadyfawzi.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
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
    
    // So we could of added two setter methods to allow the two strings to be changed
    // by an outside Word class
    // However for the purpose of this app, one we create the word object,
    // we don't expect the English or Miwok words to change.
    // Hence we won't provide setter methods to modify the state of the word object.
}
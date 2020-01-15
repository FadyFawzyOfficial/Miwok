package com.engineerfadyfawzi.miwok;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter
{
    /**
     * Context of the app
     */
    private Context mContext;
    
    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     * across swipes.
     */
    public CategoryAdapter( Context context, FragmentManager fm )
    {
        super( fm );
        mContext = context;
    }
    
    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem( int position )
    {
        switch ( position )
        {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            default:
                return new PhrasesFragment();
        }
    }
    
    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount()
    {
        return 4;
    }
    
    /**
     * Return the pageTitle that should be displayed for the each page at the top.
     */
    @Nullable
    @Override
    public CharSequence getPageTitle( int position )
    {
        switch ( position )
        {
            case 0:
                return mContext.getString( R.string.category_numbers );
            case 1:
                return mContext.getString( R.string.category_family );
            case 2:
                return mContext.getString( R.string.category_colors );
            default:
                return mContext.getString( R.string.category_phrases );
        }
    }
}
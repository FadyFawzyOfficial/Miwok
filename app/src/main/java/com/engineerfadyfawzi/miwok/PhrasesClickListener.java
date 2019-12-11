package com.engineerfadyfawzi.miwok;

import android.view.View;
import android.widget.Toast;

public class PhrasesClickListener implements View.OnClickListener
{
    
    @Override
    public void onClick( View view )
    {
        Toast.makeText( view.getContext(),
                "open the list of phrases", Toast.LENGTH_SHORT ).show();
    }
}

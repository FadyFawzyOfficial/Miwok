package com.engineerfadyfawzi.miwok;

import android.view.View;
import android.widget.Toast;

public class ColorsClickListener implements View.OnClickListener
{
    
    @Override
    public void onClick( View view )
    {
        Toast.makeText( view.getContext(),
                "open the list for Colors", Toast.LENGTH_SHORT ).show();
    }
}
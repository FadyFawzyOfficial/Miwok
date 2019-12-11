package com.engineerfadyfawzi.miwok;

import android.view.View;
import android.widget.Toast;

public class FamilyClickListener implements View.OnClickListener
{
    @Override
    public void onClick( View view )
    {
        Toast.makeText( view.getContext(),
                "open the list of family members", Toast.LENGTH_SHORT ).show();
    }
}
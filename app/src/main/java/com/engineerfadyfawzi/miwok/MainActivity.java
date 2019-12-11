package com.engineerfadyfawzi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        // Find the View that shows the numbers category
        TextView numbers = findViewById( R.id.numbers );
        
        // Set a click listener on that View
        numbers.setOnClickListener( new View.OnClickListener()
        {
            // The code in this method will be executed when the numbers View is clicked on
            @Override
            public void onClick( View view )
            {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent( MainActivity.this, NumbersActivity.class );
                // Start the new activity
                startActivity( numbersIntent );
            }
        } );
        
        // Find the View that shows the family category
        TextView family = findViewById( R.id.family );
        
        // Set a click listener on that View
        family.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                // Create a new intent to open the {@link FamilyActivity}
                Intent familyIntent = new Intent( MainActivity.this, FamilyActivity.class );
                
                // Start the new activity
                startActivity( familyIntent );
            }
        } );
        
        // Find the View that shows the colors category
        TextView colors = findViewById( R.id.colors );
        
        // Set a click listener on that View
        colors.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                // Create a new intent to open the {@link ColorsActivity}
                Intent colorsIntent = new Intent( MainActivity.this, ColorsActivity.class );
                
                // Start the new activity
                startActivity( colorsIntent );
                
            }
        } );
        
        // Find the View that shows the phrases category
        TextView phrases = findViewById( R.id.phrases );
        
        // Set a click listener on that View
        phrases.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent( MainActivity.this, ColorsActivity.class );
                
                // Start the new activity
                startActivity( phrasesIntent );
            }
        } );
    }
}
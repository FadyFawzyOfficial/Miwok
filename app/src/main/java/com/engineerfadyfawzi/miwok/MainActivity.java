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
        
        // create an object of NumbersClickListener class to pass it as an argument
        // to any View's setOnClickListener method.
        // So when the user click on this View (TextView in this case) the view
        // check if it has OnClickListener object then implements all instruction
        // have been written in OnClick overridden method which implemented in this class
        // that I've created the next instance object of.
        NumbersClickListener numbersClickListener = new NumbersClickListener();
        
        // Find the View that shows the numbers category
        TextView numbers = findViewById( R.id.numbers );
        
        // Set a numbersClickListener on that View
        numbers.setOnClickListener( numbersClickListener );
        
        // These next three lines as I did before in the previous three lines (excluding comments).
        FamilyClickListener familyClickListener = new FamilyClickListener();
        TextView family = findViewById( R.id.family );
        family.setOnClickListener( familyClickListener );
        
        // Same as the previous
        ColorsClickListener colorsClickListener = new ColorsClickListener();
        TextView colors = findViewById( R.id.colors );
        colors.setOnClickListener( colorsClickListener );
        
        // Same as the previous
        PhrasesClickListener phrasesClickListener = new PhrasesClickListener();
        TextView phrases = findViewById( R.id.phrases );
        phrases.setOnClickListener( phrasesClickListener );
    }
}

package com.example.asuper.foodforconveniencetest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecipeDisplay extends AppCompatActivity
{
    private ImageButton BackButton;

    private Button fetchDataButton;

    public static TextView servingsAndTime_RecipeDisplay;
    public static TextView method_RecipeDisplay;
    public static TextView ingredients_RecipeDisplay;
    public static TextView recipeName_RecipeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_display);

        BackButton = (ImageButton) findViewById(R.id.backbutton);
        fetchDataButton = (Button) findViewById(R.id.fetchDataButton4);

        servingsAndTime_RecipeDisplay = (TextView) findViewById(R.id.servingsandtimetext);
        method_RecipeDisplay = (TextView) findViewById(R.id.methodtext);
        ingredients_RecipeDisplay = (TextView) findViewById(R.id.ingredientstext);
        recipeName_RecipeDisplay = (TextView) findViewById(R.id.titleDisplay);

        BackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                moveToRecipesAvailable();
            }
        });
        fetchDataButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RecipeDisplay_fetchData process = new RecipeDisplay_fetchData();
                process.execute();
            }
        });
    }
    private void moveToRecipesAvailable()
    {
        Intent startRecipesAvailable = new Intent(RecipeDisplay.this, RecipesAvailable.class);
        startActivity(startRecipesAvailable);
    }
}

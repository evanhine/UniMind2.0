package com.example.asuper.foodforconveniencetest2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecipesAvailable extends AppCompatActivity
{
    private ImageButton Recipe1Button;
    private ImageButton Recipe2Button;
    private ImageButton BackButton;

    private Button fetchDataButton;

    public static TextView recipeName_RecipesAvailable;
    public static TextView recipePrepTime_RecipesAvailable;
    public static TextView recipeCookTime_RecipesAvailable;
    public static TextView recipeServings_RecipesAvailable;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_available);

        Recipe1Button = (ImageButton) findViewById(R.id.recipe1button);
        Recipe1Button.setVisibility(View.VISIBLE);
        Recipe1Button.setBackgroundColor(Color.TRANSPARENT);

        Recipe2Button = (ImageButton) findViewById(R.id.recipe2button);
        Recipe2Button.setVisibility(View.VISIBLE);
        Recipe2Button.setBackgroundColor(Color.TRANSPARENT);

        BackButton = (ImageButton) findViewById(R.id.backbutton);
        fetchDataButton = (Button) findViewById(R.id.fetchDataButton3);

        recipeName_RecipesAvailable = (TextView) findViewById(R.id.RA_RecipeName);
        recipePrepTime_RecipesAvailable = (TextView) findViewById(R.id.RA_PrepTime);
        recipeCookTime_RecipesAvailable = (TextView) findViewById(R.id.RA_CookTime);
        recipeServings_RecipesAvailable = (TextView) findViewById(R.id.RA_Servings);

        Recipe1Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                moveToRecipeDisplay();
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                moveToIngredientsAvailable();
            }
        });
        fetchDataButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RecipesAvailable_fetchData process = new RecipesAvailable_fetchData();
                process.execute();
            }
        });
    }

    private void moveToIngredientsAvailable()
    {
        Intent startIngredientsAvailable = new Intent( RecipesAvailable.this, IngredientsAvailable.class);
        startActivity(startIngredientsAvailable);
    }
    private void moveToRecipeDisplay()
    {
        Intent startRecipeDisplay = new Intent( RecipesAvailable.this, RecipeDisplay.class);
        startActivity(startRecipeDisplay);
    }
}














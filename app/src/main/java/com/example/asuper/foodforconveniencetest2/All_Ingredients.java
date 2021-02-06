package com.example.asuper.foodforconveniencetest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class All_Ingredients extends AppCompatActivity
{
    private ImageButton DoneButton;

    private Button fetchDataButton;

    public static TextView ingredientNames_All_Ingredients;
    public static TextView ingredientIDs_All_Ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__ingredients);

        DoneButton = (ImageButton) findViewById(R.id.donebutton);
        fetchDataButton = (Button) findViewById(R.id.fetchDataButton);

        ingredientNames_All_Ingredients = (TextView) findViewById(R.id.AI_IngredientNameDisplay);
        ingredientIDs_All_Ingredients = (TextView) findViewById(R.id.AI_IngredientIDDisplay);

        DoneButton.setOnClickListener(new View.OnClickListener()
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
                All_Ingredients_fetchData process = new All_Ingredients_fetchData();
                process.execute();
            }
        });

    }

    private void moveToIngredientsAvailable()
    {
        Intent startIngredientsAvailable = new Intent( All_Ingredients.this, IngredientsAvailable.class);
        startActivity(startIngredientsAvailable);
    }
}






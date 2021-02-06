package com.example.asuper.foodforconveniencetest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

import android.widget.Button;
import android.widget.TextView;


public class IngredientsAvailable extends AppCompatActivity
{
    private ImageButton SearchRecipesButton;
    private ImageButton EditButton;
    private Button fetchDataButton;

    public static TextView ingredientNames_IngredientsAvailable;
    public static TextView ingredientIDs_IngredientsAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_available);

        SearchRecipesButton = (ImageButton) findViewById(R.id.searchrecipesbutton);
        EditButton = (ImageButton) findViewById(R.id.editbutton);
        fetchDataButton = (Button) findViewById(R.id.fetchDataButton2);

        ingredientNames_IngredientsAvailable = (TextView) findViewById(R.id.IA_IngredientNameDisplay);
        ingredientIDs_IngredientsAvailable = (TextView) findViewById(R.id.IA_IngredientIDDisplay);

        SearchRecipesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                moveToRecipesAvailable();
            }

        });
        EditButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                moveToAllIngredients();
            }
        });
        fetchDataButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                IngredientsAvailable_fetchData process = new IngredientsAvailable_fetchData();
                process.execute();
            }
        });

    }
    private void moveToRecipesAvailable()
    {
        Intent startRecipesAvailable = new Intent(IngredientsAvailable.this, RecipesAvailable.class);
        startActivity(startRecipesAvailable);
    }
    private void moveToAllIngredients()
    {
        Intent startAllIngredients = new Intent(IngredientsAvailable.this, All_Ingredients.class);
        startActivity(startAllIngredients);
    }
}
    /*
    private static final String TAG = IngredientsAvailable.class.getSimpleName();
    private List<Recipes> recipes;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredients_available);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recipes = new ArrayList<>();
        getRecipesFromDB(0);

        gridLayout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new RecipesAdapter(this, recipes);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(gridLayout.findLastCompletelyVisibleItemPosition() == recipes.size() -1)
                {
                    getRecipesFromDB(recipes.get(recipes.size() -1).getId());
                }
            }
        });
    }

    private void getRecipesFromDB(int id)
    {
        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>()
        {
            @Override
            protected Void doInBackground(Integer... recipeIds)
            {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("192.168.1.77" = recipeIds[0])
                        .build();
                try{
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    Recipe recipe = new Recipe(object.getInt("id"), object.getString("recipe_name"));

                    IngredientsAvailable.this.recipes.add(recipe);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
                protected void onPostExecute(Void aVoid)
        {
            adapter.notifyDataSetChanged();
        }
    };

    asyncTask.execute(id);

    */


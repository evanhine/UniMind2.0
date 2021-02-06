package com.example.asuper.foodforconveniencetest2;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecipeDisplay_fetchData extends AsyncTask<Void, Void, Void>
{

    private String method = "";
    private String servingsAndTime = "";
    private String ingredients = "";
    private String recipeName = "";
    private String methodParsed = "";
    private String servingsAndTimeParsed = "";
    private String ingredientsParsed = "";
    private String recipeNameParsed = "";

    private String methodSingleParsed = "";
    private String servingsAndTimeSingleParsed = "";
    private String ingredientsSingleParsed = "";
    private String recipeNameSingleParsed = "";

    @Override
    protected Void doInBackground(Void... voids)
    {

        try
        {
            URL methodUrl = new URL("https://api.myjson.com/bins/kxmo8");
            URL servingsAndTimeUrl = new URL("https://api.myjson.com/bins/grlfs");
            URL ingredientsUrl = new URL("https://api.myjson.com/bins/im1ew");
            URL recipeNameUrl = new URL("https://api.myjson.com/bins/r3twg");

            HttpURLConnection httpURLConnection1 = (HttpURLConnection) methodUrl.openConnection();
            InputStream inputStream1 = httpURLConnection1.getInputStream();
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));

            HttpURLConnection httpURLConnection2 = (HttpURLConnection) servingsAndTimeUrl.openConnection();
            InputStream inputStream2 = httpURLConnection2.getInputStream();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));

            HttpURLConnection httpURLConnection3 = (HttpURLConnection) ingredientsUrl.openConnection();
            InputStream inputStream3 = httpURLConnection3.getInputStream();
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream3));

            HttpURLConnection httpURLConnection4 = (HttpURLConnection) recipeNameUrl.openConnection();
            InputStream inputStream4 = httpURLConnection4.getInputStream();
            BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(inputStream4));

            String methodLine = "";
            String servingsAndTimeLine = "";
            String ingredientsLine = "";
            String recipeNameLine = "";

            while(methodLine != null)
            {
                methodLine = bufferedReader1.readLine();
                method = method + methodLine;
            }
            while(servingsAndTimeLine != null)
            {
                servingsAndTimeLine = bufferedReader2.readLine();
                servingsAndTime = servingsAndTime + servingsAndTimeLine;
            }
            while(ingredientsLine != null)
            {
                ingredientsLine = bufferedReader3.readLine();
                ingredients = ingredients + ingredientsLine;
            }
            while(recipeNameLine != null)
            {
                recipeNameLine = bufferedReader4.readLine();
                recipeName = recipeName + recipeNameLine;
            }

            //Parsing data
            JSONArray methodJsonArray = new JSONArray(method);
            JSONArray servingsAndTimeJsonArray = new JSONArray(servingsAndTime);
            JSONArray ingredientsJsonArray = new JSONArray(ingredients);
            JSONArray recipeNameJsonArray = new JSONArray(recipeName);

            int i;
            for(i=0;i < methodJsonArray.length(); i++)
            {
                JSONObject methodJsonObject = (JSONObject) methodJsonArray.get(i);

                methodSingleParsed = methodJsonObject.get("Method")+"\n\n\n\n";

                methodParsed = methodParsed + methodSingleParsed;
            }
            for(i=0;i < servingsAndTimeJsonArray.length(); i++)
            {
                JSONObject servingsAndTimeJsonObject = (JSONObject) servingsAndTimeJsonArray.get(i);

                servingsAndTimeSingleParsed = "Servings:"+ servingsAndTimeJsonObject.get("Servings")+"\n"+
                                                "Prep Time:"+ servingsAndTimeJsonObject.get("Prep_Time")+"\n"+
                                                "Cook Time:"+ servingsAndTimeJsonObject.get("Cook_Time")+"\n";

                servingsAndTimeParsed = servingsAndTimeParsed + servingsAndTimeSingleParsed;
            }
            for(i=0;i < ingredientsJsonArray.length(); i++)
            {
                JSONObject ingredientsJsonObject = (JSONObject) ingredientsJsonArray.get(i);

                ingredientsSingleParsed = ingredientsJsonObject.get("IName")+"\n";

                ingredientsParsed = ingredientsParsed + ingredientsSingleParsed;
            }
            for(i=0;i < recipeNameJsonArray.length(); i++)
            {
                JSONObject recipeNameJsonObject = (JSONObject) recipeNameJsonArray.get(i);

                recipeNameSingleParsed = recipeNameJsonObject.get("RName")+"\n";

                recipeNameParsed = recipeNameParsed + recipeNameSingleParsed;
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        RecipeDisplay.servingsAndTime_RecipeDisplay.setText(this.servingsAndTimeParsed);
        RecipeDisplay.method_RecipeDisplay.setText(this.methodParsed);
        RecipeDisplay.ingredients_RecipeDisplay.setText(this.ingredientsParsed);
        RecipeDisplay.recipeName_RecipeDisplay.setText(this.recipeNameParsed);
    }
}
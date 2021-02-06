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

public class RecipesAvailable_fetchData extends AsyncTask<Void, Void, Void>
{

    private String recipeName = "";
    private String recipePrepTime = "";
    private String recipeCookTime = "";
    private String recipeServings = "";

    private String recipeNameParsed = "";
    private String recipePrepTimeParsed = "";
    private String recipeCookTimeParsed = "";
    private String recipeServingsParsed = "";
    private String recipeNameSingleParsed = "";
    private String recipePrepTimeSingleParsed = "";
    private String recipeCookTimeSingleParsed = "";
    private String recipeServingsSingleParsed = "";

    @Override
    protected Void doInBackground(Void... voids)
    {
        try
        {
            URL recipeNameUrl = new URL("https://api.myjson.com/bins/rgfls");
            URL recipePrepTimeUrl = new URL("https://api.myjson.com/bins/6oelc");
            URL recipeCookTimeUrl = new URL("https://api.myjson.com/bins/138mfs");
            URL recipeServingsUrl = new URL("https://api.myjson.com/bins/1fqq54");

            HttpURLConnection httprecipeNameURLConnection = (HttpURLConnection) recipeNameUrl.openConnection();
            InputStream recipeNameinputStream = httprecipeNameURLConnection.getInputStream();
            BufferedReader recipeNameBufferedReader = new BufferedReader(new InputStreamReader(recipeNameinputStream));

            HttpURLConnection httprecipePrepTimeURLConnection = (HttpURLConnection) recipePrepTimeUrl.openConnection();
            InputStream recipePrepTimeinputStream = httprecipePrepTimeURLConnection.getInputStream();
            BufferedReader recipePrepTimeBufferedReader = new BufferedReader(new InputStreamReader(recipePrepTimeinputStream));

            HttpURLConnection httprecipeCookTimeURLConnection = (HttpURLConnection) recipeCookTimeUrl.openConnection();
            InputStream recipeCookTimeinputStream = httprecipeCookTimeURLConnection.getInputStream();
            BufferedReader recipeCookTimeBufferedReader = new BufferedReader(new InputStreamReader(recipeCookTimeinputStream));

            HttpURLConnection httprecipeServingsURLConnection = (HttpURLConnection) recipeServingsUrl.openConnection();
            InputStream recipeServingsinputStream = httprecipeServingsURLConnection.getInputStream();
            BufferedReader recipeServingsBufferedReader = new BufferedReader(new InputStreamReader(recipeServingsinputStream));

            String recipeNameLine = "";
            String recipePrepTimeLine = "";
            String recipeCookTimeLine = "";
            String recipeServingsLine = "";

            while(recipeNameLine != null)
            {
                recipeNameLine = recipeNameBufferedReader.readLine();
                recipeName = recipeName + recipeNameLine;
            }
            while(recipePrepTimeLine != null)
            {
                recipePrepTimeLine = recipePrepTimeBufferedReader.readLine();
                recipePrepTime = recipePrepTime + recipePrepTimeLine;
            }
            while(recipeCookTimeLine != null)
            {
                recipeCookTimeLine = recipeCookTimeBufferedReader.readLine();
                recipeCookTime = recipeCookTime + recipeCookTimeLine;
            }
            while(recipeServingsLine != null)
            {
                recipeServingsLine = recipeServingsBufferedReader.readLine();
                recipeServings = recipeServings + recipeServingsLine;
            }


            //Parsing data
            JSONArray recipeNameJsonArray = new JSONArray(recipeName);
            JSONArray recipePrepTimeJsonArray = new JSONArray(recipePrepTime);
            JSONArray recipeCookTimeJsonArray = new JSONArray(recipeCookTime);
            JSONArray recipeServingsJsonArray = new JSONArray(recipeServings);

            int i;
            for(i=0;i < recipeNameJsonArray.length(); i++)
            {
                JSONObject recipeNameJsonObject = (JSONObject) recipeNameJsonArray.get(i);

                recipeNameSingleParsed = recipeNameJsonObject.get("RName")+"\n\n\n\n";

                recipeNameParsed = recipeNameParsed + recipeNameSingleParsed;
            }
            for(i=0;i < recipePrepTimeJsonArray.length(); i++)
            {
                JSONObject recipePrepTimeJsonObject = (JSONObject) recipePrepTimeJsonArray.get(i);

                recipePrepTimeSingleParsed = recipePrepTimeJsonObject.get("Prep_Time")+"\n\n\n\n\n";

                recipePrepTimeParsed = recipePrepTimeParsed + recipePrepTimeSingleParsed;
            }
            for(i=0;i < recipeCookTimeJsonArray.length(); i++)
            {
                JSONObject recipeCookTimeJsonObject = (JSONObject) recipeCookTimeJsonArray.get(i);

                recipeCookTimeSingleParsed = recipeCookTimeJsonObject.get("Cook_Time")+"\n\n\n\n\n";

                recipeCookTimeParsed = recipeCookTimeParsed + recipeCookTimeSingleParsed;
            }
            for(i=0;i < recipeServingsJsonArray.length(); i++)
            {
                JSONObject recipeServingsJsonObject = (JSONObject) recipeServingsJsonArray.get(i);

                recipeServingsSingleParsed = recipeServingsJsonObject.get("Servings")+"\n\n\n\n\n";

                recipeServingsParsed = recipeServingsParsed + recipeServingsSingleParsed;
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

        RecipesAvailable.recipeName_RecipesAvailable.setText(this.recipeNameParsed);
        RecipesAvailable.recipePrepTime_RecipesAvailable.setText(this.recipePrepTimeParsed);
        RecipesAvailable.recipeCookTime_RecipesAvailable.setText(this.recipeCookTimeParsed);
        RecipesAvailable.recipeServings_RecipesAvailable.setText(this.recipeServingsParsed);

    }
}

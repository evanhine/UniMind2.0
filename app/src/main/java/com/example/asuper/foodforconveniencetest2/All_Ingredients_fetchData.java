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

public class All_Ingredients_fetchData extends AsyncTask<Void, Void, Void>
{

    private String ingredientNames = "";
    private String ingredientIDs = "";

    private String ingredientNamesParsed = "";
    private String ingredientIDsParsed = "";

    private String ingredientNamesSingleParsed = "";
    private String ingredientIDsSingleParsed = "";

    @Override
    protected Void doInBackground(Void... voids)
    {

        try
        {
            URL ingredientNamesUrl = new URL("https://api.myjson.com/bins/1ezm28");
            URL ingredientIDsUrl = new URL("https://api.myjson.com/bins/birlk");

            HttpURLConnection httpURLConnection1 = (HttpURLConnection) ingredientNamesUrl.openConnection();
            InputStream inputStream1 = httpURLConnection1.getInputStream();
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));

            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ingredientIDsUrl.openConnection();
            InputStream inputStream2 = httpURLConnection2.getInputStream();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));


            String ingredientNamesLine = "";
            String ingredientIDsLine = "";

            while(ingredientNamesLine != null)
            {
                ingredientNamesLine = bufferedReader1.readLine();
                ingredientNames = ingredientNames + ingredientNamesLine;
            }
            while(ingredientIDsLine != null)
            {
                ingredientIDsLine = bufferedReader2.readLine();
                ingredientIDs = ingredientIDs + ingredientIDsLine;
            }

            //Parsing data
            JSONArray ingredientNamesJsonArray = new JSONArray(ingredientNames);
            JSONArray ingredientIDsJsonArray = new JSONArray(ingredientIDs);

            int i;
            for(i = 0; i < ingredientNamesJsonArray.length(); i++)
            {
                JSONObject ingredientNamesJsonObject = (JSONObject) ingredientNamesJsonArray.get(i);

                //ingredientNamesSingleParsed = "IName:" + ingredientNamesJsonObject.get("IName") + "\n";
                ingredientNamesSingleParsed = ingredientNamesJsonObject.get("IName") + "\n";

                ingredientNamesParsed = ingredientNamesParsed + ingredientNamesSingleParsed;
            }
            for(i = 0; i < ingredientIDsJsonArray.length(); i++)
            {
                JSONObject ingredientIDsJsonObject = (JSONObject) ingredientIDsJsonArray.get(i);

                //ingredientIDsSingleParsed = "ID:" + ingredientIDsJsonObject.get("IID") + "\n";
                ingredientIDsSingleParsed = ingredientIDsJsonObject.get("IID") + "\n";

                ingredientIDsParsed = ingredientIDsParsed + ingredientIDsSingleParsed;
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

        All_Ingredients.ingredientNames_All_Ingredients.setText(this.ingredientNamesParsed);
        All_Ingredients.ingredientIDs_All_Ingredients.setText(this.ingredientIDsParsed);
    }


}










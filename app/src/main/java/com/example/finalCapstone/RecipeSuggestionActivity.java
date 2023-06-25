package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.example.finalCapstone.APIClient.ClientAPI;
import com.example.finalCapstone.Adapters.RecipeSuggestionAdapter;
import com.example.finalCapstone.Models.RecipeModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class RecipeSuggestionActivity extends AppCompatActivity {
    String TAG = "vannekala";
    ArrayList<String> recipe_ids;
    ArrayList<RecipeModel> recipes = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> cookTimes = new ArrayList<>();
    ArrayList<String> imageURLs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_suggestion);

        Intent i = getIntent();
        recipe_ids = i.getStringArrayListExtra("recipe_ids");
        if(recipe_ids.size() == 0)
        {
            Toast.makeText(this, "No recipe found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // make API calls
            Collections.shuffle(recipe_ids);
            for(int counter = 0; counter <recipe_ids.size();counter++)
            {
                //ids.add(recipe_ids.get(counter));
                makeAPICall(recipe_ids.get(counter),counter,counter == recipe_ids.size()-1);
            }
        }

    }
    void makeAPICall(String id, int count, boolean last)
    {
        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                ClientAPI.recipeInfo(activity, b, updateCallback, id);
            }
        };

        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {
            @Override
            public void onSuccess(Bundle result) {
                ids.add(id);
                String name = result.getString("0");
                names.add(name);
                String imageURL = result.getString("7");
                imageURLs.add(imageURL);
                String time = result.getString("2");
                cookTimes.add(time);
                //Log.i(TAG, name+time);
                RecipeModel model = new RecipeModel(id,name,imageURL,time);
                recipes.add(model);
                //Log.i(TAG, String.valueOf(count)+" "+ String.valueOf(n));
                if(last)
                {
                   Log.i(TAG, "called Adapter");
                    Intent i = new Intent(RecipeSuggestionActivity.this, RecipeLlistGridActivity.class);
                    i.putStringArrayListExtra("names",names);
                    i.putStringArrayListExtra("ids", ids);
                    i.putStringArrayListExtra("imageURLs", imageURLs);
                    i.putStringArrayListExtra("cookTimes", cookTimes);
                    startActivity(i);
                    //finish();

                }
            }
        };
        Bundle b = new Bundle();
        ClientAPI.generateAccessToken(this, api2Callback, b, update2Callback);
    }

}
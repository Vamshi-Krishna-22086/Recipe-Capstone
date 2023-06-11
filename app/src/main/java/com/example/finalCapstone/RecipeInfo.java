package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalCapstone.APIClient.ClientAPI;
import com.squareup.picasso.Picasso;

public class RecipeInfo extends AppCompatActivity {
    ImageView iv;
    String recipe_image_url;
    TextView tv, instructions, recipeTitle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        tv=findViewById(R.id.infoShow);
        instructions = findViewById(R.id.instructions);
        recipeTitle = findViewById(R.id.recipeTitle);

        Intent i=getIntent();
        String id=i.getStringExtra("id");

        iv=findViewById(R.id.RecipeImage);


        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback() {

            @Override

            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {

                ClientAPI.recipeInfo(activity,b,updateCallback,id);

            }

        };
        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {

            @Override

            public void onSuccess(Bundle result) {

                String ss="";
                char[] utensils = result.getString("6").toCharArray();
                String utensil = "";
                for(int i=0;i<utensils.length -1 ;i++)
                {
                    if(utensils[i] == '|' && utensils[i+1]== '|')
                    {
                        utensil = utensil+" ,";
                        i = i+1;
                    }
                    else {
                        utensil = utensil + utensils[i];
                    }
                }
                utensil = utensil + utensils[utensils.length-1];


                //String[] arrOfStr = str.split("@", 2)


// String x=result.getString("recipe_title");
                //ss=ss+"recipe title: "+result.getString("0")+"\nsubregion: "+result.getString("1");

                ss=ss+"\nSubregion: "+result.getString("1")+"\nPreparation  time: "+result.getString("2") +" Minutes"+"\nServings: "+result.getString("3")+"\nCalories: "+result.getString("4")+"\nUtensils Required: "+utensil;
                recipe_image_url=result.getString("7");
                Picasso.get().load(recipe_image_url).into(iv);
                tv.setText(ss);
                recipeTitle.setText(result.getString("0"));

                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();

                //Log.i("recipeinfo", "before: "+ss);

            }
        };

        ClientAPI.APICallback apiCallback_instructions = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                ClientAPI.recipeInstructions(activity,b,updateCallback,id);
            }
        };

        ClientAPI.UpdateCallback updateCallback_instructions = new ClientAPI.UpdateCallback() {
            @Override
            public void onSuccess(Bundle result) {
                String ss="";
                ss=ss+result.getString("0");
                //data.setText(ss);
                //Toast.makeText(MainActivity.this, "bye", Toast.LENGTH_SHORT).show();
                instructions.setText(ss);
                Log.i("recipeinfo", "before: "+ss);
            }
        };

        Bundle b =new Bundle();
        ClientAPI.generateAccessToken(this, api2Callback,b, update2Callback);

        Bundle bt_instructions=new Bundle();
        ClientAPI.generateAccessToken(this, apiCallback_instructions,bt_instructions, updateCallback_instructions);




    }
}
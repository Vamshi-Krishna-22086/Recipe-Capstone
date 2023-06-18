package com.example.finalCapstone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalCapstone.APIClient.ClientAPI;
import com.squareup.picasso.Picasso;


public class HomeFragment extends Fragment {
    String recipeofday_url;
    String rel;
    ImageView recipe_picture;
    TextView recipeday;
    public HomeFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        //we are initializing the image view  for showcasing the recipe image of the day
        recipeday=v.findViewById(R.id.Recipe_Day);
        recipe_picture=v.findViewById(R.id.imageRecipeOfDay);
        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback()
        {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                ClientAPI.recipeOfDay(activity,b,updateCallback);
            }
        };
        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {

            @Override

            public void onSuccess(Bundle result) {

                String ss="";

// String x=result.getString("recipe_title");

                //ss=ss+"recipe title: "+result.getString("0")+"\nsubregion: "+result.getString("1");
                //getting the recipe of the day name and also the image url from the from index 7
                ss=ss+result.getString("0");
                recipeofday_url=result.getString("7");
                //Toast.makeText(getContext(),recipeofday_url , Toast.LENGTH_SHORT).show();
                Log.i("TAG", String.valueOf(recipeofday_url));
                rel=result.getString("8");
                Log.i("Soumya", String.valueOf(rel));
                Picasso.get().load(recipeofday_url).into(recipe_picture);
                recipeday.setText(ss);
                //setting a on click listener so that on clicking the image and text we go to a recipe description activity
                recipeday.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i= new Intent(getContext(),RecipeDetailActivity.class);
                        i.putExtra("id",rel);
                        startActivity(i);
                    }
                });

                recipe_picture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i= new Intent(getContext(),RecipeDetailActivity.class);
                        //Intent i= new Intent(getContext(),RecipeLlistGridActivity.class);
                        i.putExtra("id",rel);
                        startActivity(i);
                    }
                });

                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();

                //Log.i("recipeinfo", "before: "+ss);

            }

        };
        Bundle b =new Bundle();
        ClientAPI.generateAccessToken(getActivity(), api2Callback,b, update2Callback);
        return v;

    }
}
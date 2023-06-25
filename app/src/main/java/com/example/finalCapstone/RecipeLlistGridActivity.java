package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalCapstone.APIClient.ClientAPI;
import com.example.finalCapstone.Adapters.IngredientAdapter;
import com.example.finalCapstone.Adapters.RecipeGridViewAdapter;
import com.example.finalCapstone.Models.IngredientModel;
import com.example.finalCapstone.Models.TileModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeLlistGridActivity extends AppCompatActivity {

    GridView recipeGrid;
    String[] arr;
    //ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> cookTime = new ArrayList<>();

    ArrayList<String> s1 = new ArrayList<>();
    ArrayList<String> s2 = new ArrayList<>();
    ArrayList<String> s1_id = new ArrayList<>();
    ArrayList<String> s2_id = new ArrayList<>();
    final ArrayList<String> temp_id = new ArrayList<>();
    //String[] images;
    //String[] cookTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_llist_grid);

        recipeGrid = findViewById(R.id.gv_recipe_list);

        // fetching the recipe names
        ClientAPI.APICallback apiCallback_recipeNames = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                //ClientAPI.recipeInfo(activity,b,updateCallback);
                ClientAPI.recipesByIngredient(activity, b, updateCallback);
            }
        };

//        ArrayList<String> s1 = new ArrayList<>();
//        ArrayList<String> s2 = new ArrayList<>();
//        ArrayList<String> s1_id = new ArrayList<>();
//        ArrayList<String> s2_id = new ArrayList<>();
//        final ArrayList<String> temp_id = new ArrayList<>();

        ClientAPI.UpdateCallback updateCallback = new ClientAPI.UpdateCallback() {

            @Override
            public void onSuccess(Bundle result) {
                String s = "";
                ArrayList<String> names = new ArrayList<String>();
                ArrayList<String> recipe_id = new ArrayList<String>();
                names = result.getStringArrayList("names");
                recipe_id = result.getStringArrayList("recipes");
                Log.i("names", "first: " + names + " " + recipe_id);
                //String s[] = new String[100];
                //s=s + names.get(i);
                s1.addAll(names);
                s1_id.addAll(recipe_id);
                if (s2.size() == 0) {
                    s2.addAll(names);
                    s2_id.addAll(recipe_id);
                } else {
                    Log.i("names", "before: " + names.get(1) + " " + s2.size() + " " + s1.size());
                    s2.retainAll(s1);
                    s2_id.retainAll(s1_id);
                    Log.i("names", "after: " + names.get(1) + " " + s2.size() + " " + s1.size());
                }
                s1.clear();
                s1_id.clear();
                String temp = "";
                for (int j = 0; j < s2.size(); j++)
                    temp = temp + s2.get(j) + "%";

                arr = temp.split("%");
                temp_id.addAll(s2_id);
                getImages_func();
                CustomAdapter customAdapter = new CustomAdapter();
                recipeGrid.setAdapter(customAdapter);

//                temp_id.addAll(s2_id);
                Log.i("Vannekala", String.valueOf(temp_id.size()));

                recipeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(RecipeLlistGridActivity.this, RecipeDetailActivity.class);
                        intent.putExtra("id", s2_id.get(i));
                        startActivity(intent);
                    }
                });
//                getImages_func();
                Log.i("names", "final: ***" + names.get(1) + " " + s2.size() + " " + s1.size());
            }
        };


        // to get image URL and cook time
//        ClientAPI.APICallback api2Callback = null;
        //ClientAPI.UpdateCallback update2Callback = null;
        //for (int id = 0; id < 5; id++) {
            //int finalId = id;
//            api2Callback = new ClientAPI.APICallback() {
//                @Override
//                public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
//                    //Log.i("TAG", "afterGenerated: " + s2_id.get(0));
//                    ClientAPI.recipeInfo(activity, b, updateCallback, "9610");
//                    ClientAPI.recipeInfo(activity, b, updateCallback, "9610");
//
//                }
//            };
//        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {
//                @Override
//                public void onSuccess(Bundle result) {
//                    String imageURL = result.getString("7");
//                    Log.i("Vamshi", "onSuccess: " + imageURL);
//                    Log.i("krishna", "Hi");
//                    images.add(imageURL);
//                    String time = result.getString("2");
//                    cookTime.add(time);
//
////                try {
////                    Picasso.get().load(result.getString("7")).into(v);
////                }
////                catch (Exception e){
////                    Log.e("error img",e.toString());
////                    e.printStackTrace();
////                }
//                }
//            };
        //}


        // calling the APIs
        Bundle b = new Bundle();
        Bundle bt = new Bundle();
        ClientAPI.generateAccessToken(this, apiCallback_recipeNames, bt, updateCallback);
        //ClientAPI.generateAccessToken(this, api2Callback, b, update2Callback);
        // setting up grid view
//                CustomAdapter customAdapter = new CustomAdapter();
//                recipeGrid.setAdapter(customAdapter);
//
//                recipeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Intent intent = new Intent(RecipeLlistGridActivity.this, RecipeDetailActivity.class);
//                        intent.putExtra("id", "9610");
//                        startActivity(intent);
//                    }
//                });


    }
    void getImages_func()
    {
        Log.i("Varun", String.valueOf(temp_id.size()));
        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                //Log.i("TAG", "afterGenerated: " + s2_id.get(0));
                ClientAPI.recipeInfo(activity, b, updateCallback, "9610");
                Log.i("jyothi", "gfbnfgnfnh");
                ClientAPI.recipeInfo(activity, b, updateCallback, "9610");

            }
        };
        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {
            @Override
            public void onSuccess(Bundle result) {
                String imageURL = result.getString("7");
                Log.i("Vamshi", "onSuccess: " + imageURL);
                Log.i("krishna", "Hi");
                images.add(imageURL);
                String time = result.getString("2");
                cookTime.add(time);

//                try {
//                    Picasso.get().load(result.getString("7")).into(v);
//                }
//                catch (Exception e){
//                    Log.e("error img",e.toString());
//                    e.printStackTrace();
//                }
            }
        };

        Bundle b = new Bundle();
        ClientAPI.generateAccessToken(this, api2Callback, b, update2Callback);
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arr.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = getLayoutInflater().inflate(R.layout.card_llist_recipe,null);

            TextView RName = v.findViewById(R.id.tile_recipe_name);
            ImageView image = v.findViewById(R.id.tile_recipe_image);
            TextView cooktime = v.findViewById(R.id.tile_recipe_cook_time);

            RName.setText(arr[i]);
            Picasso.get().load(images.get(0)).into(image);
            //cooktime.setText(cookTime.get(0) + " mins");

            return v;
        }
    }
}
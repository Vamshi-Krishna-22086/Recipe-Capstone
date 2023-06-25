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

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> cookTimes = new ArrayList<>();
    ArrayList<String> imageURLs = new ArrayList<>();
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_llist_grid);

        gridView = findViewById(R.id.gv_recipe_list);

        Intent i = getIntent();
        names = i.getStringArrayListExtra("names");
        ids = i.getStringArrayListExtra("ids");
        cookTimes = i.getStringArrayListExtra("cookTimes");
        imageURLs = i.getStringArrayListExtra("imageURLs");

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RecipeLlistGridActivity.this, RecipeDetailActivity.class);
                intent.putExtra("id", ids.get(i));
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ids.size();
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
            View v = getLayoutInflater().inflate(R.layout.card_llist_recipe, null);

            TextView RName = v.findViewById(R.id.tile_recipe_name);
            ImageView image = v.findViewById(R.id.tile_recipe_image);
            TextView cooktime = v.findViewById(R.id.tile_recipe_cook_time);

            RName.setText(names.get(i));
            Picasso.get().load(imageURLs.get(i)).into(image);
            cooktime.setText(cookTimes.get(i) + " mins");

            return v;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent home = new Intent(RecipeLlistGridActivity.this, Dashboard.class);
        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);

    }
}
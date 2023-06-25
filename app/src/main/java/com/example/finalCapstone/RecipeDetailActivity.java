package com.example.finalCapstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.text.method.ScrollingMovementMethod;

import android.util.AttributeSet;

import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalCapstone.APIClient.ClientAPI;
import com.example.finalCapstone.Adapters.IngredientAdapter;
import com.example.finalCapstone.Adapters.RecipeGridViewAdapter;
import com.example.finalCapstone.Models.IngredientModel;
import com.example.finalCapstone.Models.TileModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.http.Url;

public class RecipeDetailActivity extends Activity {
    public List<String> tileNames = new ArrayList<String>(Arrays.asList("Protein : ","Calories : ","Total-Time (mins): ", "Servings : ","Cuisine : "));
    //public List<String> tileNames = new ArrayList<String>(Arrays.asList("Total-Time : ", "Servings : ","Cuisine : "));
    String[] ingdreintList;
    public List<Integer> iconList = new ArrayList<Integer>(Arrays.asList(R.drawable.protien,R.drawable.calories,R.drawable.cooktime,R.drawable.servings,R.drawable.cuisine));
    //public List<Integer> iconList = new ArrayList<Integer>(Arrays.asList(R.drawable.cooktime,R.drawable.servings,R.drawable.cuisine));
    TextView title;
    Intent intent;
    ImageView v;
    ImageButton favButton;
    Boolean isFavourite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        favButton = findViewById(R.id.addToFav);
        //TODO :: Check if fav from ROOM DB
        isFavourite = false;
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFavourite = !isFavourite;
                if(isFavourite)
                    favButton.setImageResource(R.drawable.fav);
                else
                    favButton.setImageResource(R.drawable.unfav);
            }
        });
        Context c = this;
        title = findViewById(R.id.recipe_title);
        v = findViewById(R.id.header_recipe_detail);
        intent=getIntent();
        ArrayList<TileModel> tileModelArrayList = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                ClientAPI.recipeInfo(activity,b,updateCallback,id);
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
                String unProcessed = result.getString("instructions");
                // TODO :: SHOW INSTRUCTIONS IN A CLEANER WAY

                TextView textView=((TextView)(findViewById(R.id.instructions)));
                unProcessed = unProcessed.replace(';','\n');
                ((TextView)(findViewById(R.id.instructions))).setText(unProcessed.replace('.','\n'));

            }
        };
        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {
            @Override
            public void onSuccess(Bundle result) {
                title.setText(result.getString("0"));
                String utensils = result.getString("6");
//                Log.d("DetailPage", Arrays.toString(ingdreintList));
                String[] utensilArr= utensils.split("\\|\\|");
                String region = "Region : "+result.getString("4");
                ((TextView)(findViewById(R.id.cuisineText))).setText(region);

                for(int i = 2 ; i < 4; i++)
                {
                    tileModelArrayList.add(new TileModel(tileNames.get(i),result.getString(""+i),iconList.get(i)));
                }
//                ingdreintList = result.getStringArray("ingredient");
                ArrayList<IngredientModel> ingredientModelList = new ArrayList<>();
                ArrayList<IngredientModel> utensilModelList = new ArrayList<>();

//                for(String ing : utensilArr) {
//
//                    ingredientModelList.add(new IngredientModel(ing));
//                }
                for(String ing : utensilArr) {

                    utensilModelList.add(new IngredientModel(ing));
                }

                RecipeGridViewAdapter adapter = new RecipeGridViewAdapter(c,tileModelArrayList);
                IngredientAdapter adapterIngredients = new IngredientAdapter(utensilModelList,c);
                IngredientAdapter adapterUtensils = new IngredientAdapter(utensilModelList,c);
                ((GridView)(findViewById(R.id.GVnutrition))).setAdapter(adapter);
                RecyclerView rv = findViewById(R.id.GVingredients);
                RecyclerView rvU = findViewById(R.id.GVutensil);

                rv.setLayoutManager(new GridLayoutManager(c,3));
                rv.setAdapter(adapterIngredients);
                rvU.setLayoutManager(new GridLayoutManager(c,4));
                rvU.setAdapter(adapterUtensils);
                try {
                    Picasso.get().load(result.getString("7")).into(v);
                }
                catch (Exception e){
                    Log.e("error img",e.toString());
                    e.printStackTrace();
                }
            }
        };
        Bundle b =new Bundle();
        int id2 = intent.getIntExtra("recipe_id",0);
        b.putInt("recipe_id",id2);
        Bundle bt =new Bundle();
        bt.putString("recipe_id",intent.getStringExtra("recipe_title"));
        ClientAPI.generateAccessToken(this,api2Callback,bt,update2Callback);
        ClientAPI.generateAccessToken(this,apiCallback_instructions,b,updateCallback_instructions);



    }


}

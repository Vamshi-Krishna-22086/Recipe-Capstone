package com.example.finalCapstone.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalCapstone.Models.TileModel;
import com.example.finalCapstone.R;

import java.util.ArrayList;

public class RecipeGridViewAdapter extends ArrayAdapter<TileModel> {

    public RecipeGridViewAdapter(@NonNull Context context, ArrayList<TileModel> recipeModelArrayList) {
        super(context, 0, recipeModelArrayList);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_recipe, parent, false);
        }

        TileModel recipeModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.recipeCardText);
        ImageView courseIV = listitemView.findViewById(R.id.recipeCardId);

        courseTV.setText(recipeModel.tileName + recipeModel.val);
        courseIV.setImageResource(recipeModel.img);



        return listitemView;
    }
}

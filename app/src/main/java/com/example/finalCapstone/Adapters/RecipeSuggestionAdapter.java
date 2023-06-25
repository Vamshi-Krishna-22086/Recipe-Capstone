package com.example.finalCapstone.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalCapstone.Models.RecipeModel;
import com.example.finalCapstone.R;
import com.example.finalCapstone.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeSuggestionAdapter extends ArrayAdapter<RecipeModel> {

    static class ViewHolder{
        ImageView image;
        TextView name;
        TextView time;
    }

//    Context context;
    ArrayList<RecipeModel> recipeList;
    LayoutInflater inflater;
    public RecipeSuggestionAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
//        this.context = context;
//        this.recipeList = recipes;
        //Log.i("krishna", String.valueOf(recipeList.size()));
    }

    @Override
    public int getCount() {
        return recipeList.size();
    }
    @Override
    public void add(RecipeModel object) {
        recipeList.add(object);
        super.add(object);
    }

    @Override
    public RecipeModel getItem(int i) {
        return recipeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.card_llist_recipe, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.tile_recipe_name);
            viewHolder.time = (TextView) row.findViewById(R.id.tile_recipe_cook_time);
            viewHolder.image = (ImageView) row.findViewById(R.id.tile_recipe_image);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }
        RecipeModel card = getItem(i);
        viewHolder.name.setText(card.getName());
//        Picasso.with(viewGroup.getContext())
//                .load(card.getImageUrl()).resize(100,100)
//                .into(viewHolder.image);
        Picasso.get().load(card.getImageUrl()).into(viewHolder.image);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), RecipeDetailActivity.class);
                intent.putExtra("recipe_id",card.getId());
//                intent.putExtra("recipe_title",card.g());
                viewGroup.getContext().startActivity(intent);
            }
        });
        return row;


//        viewHolder holder = null;
//        if(view == null)
//        {
//            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.card_llist_recipe, null);
//            holder = new viewHolder();
//            holder.image = view.findViewById(R.id.tile_recipe_image);
//            holder.name = view.findViewById(R.id.tile_recipe_name);
//            holder.time = view.findViewById(R.id.tile_recipe_cook_time);
//            //Log.i("krishna", "values set");
//        }
////        ImageView image = view.findViewById(R.id.tile_recipe_image);
////        TextView name = view.findViewById(R.id.tile_recipe_name);
////        TextView time = view.findViewById(R.id.tile_recipe_cook_time);
//        RecipeModel curr_obj = recipeList.get(i);
//        Log.i("iiitd", curr_obj.getName());
//
//
//        //Picasso.get().load(recipeList.get(i).getImageUrl()).into(holder.image);
//        holder.name.setText(curr_obj.getName());
////        holder.time.setText(curr_obj.getCookTime() + " mins");
//        return view;
    }
}

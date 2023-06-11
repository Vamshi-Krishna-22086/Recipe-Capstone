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
import androidx.recyclerview.widget.RecyclerView;


import com.example.finalCapstone.Models.IngredientModel;
import com.example.finalCapstone.R;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientModelHolder> {
    ArrayList<IngredientModel> ingredientModelArrayList;
    Context context;
    public IngredientAdapter(ArrayList<IngredientModel> ingredientModelArrayList,Context context) {
        this.context = context;
        this.ingredientModelArrayList=ingredientModelArrayList;
    }



    @NonNull
    @Override
    public IngredientModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ingredient, parent, false);
        return new IngredientModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientModelHolder holder, int position) {
        holder.ingredientTV.setText(ingredientModelArrayList.get(position).IngredientName);
    }


    @Override
    public int getItemCount() {
        return ingredientModelArrayList.size();
    }
}


class IngredientModelHolder extends RecyclerView.ViewHolder {

    public TextView ingredientTV;

    public IngredientModelHolder(@NonNull View itemView) {
        super(itemView);
        ingredientTV = itemView.findViewById(R.id.ingredientName);
    }
}

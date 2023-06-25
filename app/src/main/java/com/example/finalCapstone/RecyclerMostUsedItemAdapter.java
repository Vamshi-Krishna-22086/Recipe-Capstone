package com.example.finalCapstone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//this is the adapter for the recycler view which consist of the most frequent ingredient items
public class RecyclerMostUsedItemAdapter extends RecyclerView.Adapter<RecyclerMostUsedItemAdapter.ViewHolder>
{
    Context context;
    MostViewedListener listener;
    int[] IngredientImages = {R.drawable.salt,R.drawable.onion,R.drawable.butter,R.drawable.garlic,R.drawable.oliveoil,R.drawable.sugar,R.drawable.tomato,R.drawable.blackpepper,
            R.drawable.flour,R.drawable.parsley,R.drawable.carrot,R.drawable.cumin,R.drawable.potato,R.drawable.lemon,R.drawable.soysauce};

    RecyclerMostUsedItemAdapter(Context context,MostViewedListener listener)
    {   //setting the context and listener interface in this adapter
        this.context=context;
        this.listener=listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v=LayoutInflater.from(context).inflate(R.layout.mostviewed_card,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        //we are connecting the view holder with the correct position element from arraylist
//        holder.iv1.setImageResource(GlobalTopIngredients.arr.get(position).url);
        holder.iv1.setImageResource(IngredientImages[position]);
        holder.tv1.setText(GlobalTopIngredients.arr.get(position).name);
        holder.cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.onItemClicked(GlobalTopIngredients.arr.get(position));
            }
        });
    }

    @Override
    public int getItemCount()
    {
        //returning the arraylist size
        return GlobalTopIngredients.arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        //describing the view holder , we are connecting the view in the view holder
        TextView tv1;
        ImageView iv1;
        CardView cv1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv1=itemView.findViewById(R.id.TextMostViewed);
            iv1=itemView.findViewById(R.id.ImageMostViewed);
            cv1=itemView.findViewById(R.id.MostViewedCardView);
        }
    }
}

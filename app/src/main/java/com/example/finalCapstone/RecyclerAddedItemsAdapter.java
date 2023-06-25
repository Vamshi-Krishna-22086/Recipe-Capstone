package com.example.finalCapstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// this is the added ingredients  adapter
public class RecyclerAddedItemsAdapter extends RecyclerView.Adapter<RecyclerAddedItemsAdapter.ViewHolder>
{
    Context context;



    public RecyclerAddedItemsAdapter(Context context)
    {
        //setting the context in this adapter
        this.context=context;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.addedmodel_card,parent,false);
//        ViewHolder vh=new ViewHolder(v);
//        return vh;
        // added by Vk
        return new ViewHolder(v).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position)
    {
        //binding the holder with the model object at position
        holder.tv1.setText(AddedIngredients.myarray.get(position).name);
        holder.iv1.setImageResource(AddedIngredients.myarray.get(position).url);



    }

    @Override
    public int getItemCount()
    {
        return AddedIngredients.myarray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv1;
        ImageView iv1;
        ImageButton del;
        //added by VK
        private RecyclerAddedItemsAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv1=itemView.findViewById(R.id.AddedImageView);
            this.tv1=itemView.findViewById(R.id.AddedTextView);
            this.del=itemView.findViewById(R.id.AddedDeleteButton);

            // deleting item from the recycler view (added list)
            // added by VK
            del.setOnClickListener(view ->{
                AddedIngredients.myarray.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });

        }

        // added by VK
        public ViewHolder linkAdapter(RecyclerAddedItemsAdapter adapter)
        {
            this.adapter = adapter;
            return this;
        }

    }

}

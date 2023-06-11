package com.example.finalCapstone;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AddIngredientsFragment extends Fragment implements MostViewedListener
{

    RecyclerView rv1;
    RecyclerView rv2;
    Button searchButton;
    // button to see recipe list
    Button show;
    public AddIngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_add_ingredients, container, false);
        //adding the search button context in java file
        searchButton = (Button) v.findViewById(R.id.searchButton);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //we are using 2 recycler view
        //rv1 is the first recycler view which deals with the most popular ingredients
        //rv2 is the second recycler view which deals with  added ingredients ,which are viewing as a grid layout
        rv1=view.findViewById(R.id.mostViewRecycle);
        rv1.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,true));
        rv2=view.findViewById(R.id.addedRecycle);
        rv2.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        GlobalTopIngredients.set_items();
        RecyclerMostUsedItemAdapter myadapter= new RecyclerMostUsedItemAdapter(getContext(),this);
        //setting the adapter
        rv1.setAdapter(myadapter);

        Intent i = new Intent(getContext(), SearchIngredientActivity.class);
        //this will lead to the the next activity where we can search more items from the ingredients list
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        // displaying the added ingredients
        RecyclerAddedItemsAdapter adapter = new RecyclerAddedItemsAdapter(getContext());
        rv2.clearOnChildAttachStateChangeListeners();
        rv2.setAdapter(adapter);

        // initializing the button to show recipes
        show = (Button) view.findViewById(R.id.showRecipes);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AddedIngredients.myarray.size() == 0)
                {
                    //if the added ingredients arraylist size is 0 ..then this toast message will be showcased
                    Toast.makeText(getContext(), "Please add Ingredients", Toast.LENGTH_SHORT).show();
                }
                else {
                    //else we will go to a new activity which will show the recipes in the form list view
                    Intent s = new Intent(getActivity(), RecipieListActivity.class);
                    startActivity(s);
                }
            }
        });

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(Model myModel)
    {
        //on clicking the item in rv1 we will get the object and we will add in the added ingredients list
        AddedIngredients.set_details(myModel);
        RecyclerAddedItemsAdapter adapter = new RecyclerAddedItemsAdapter(getContext());
        rv2.clearOnChildAttachStateChangeListeners();
        rv2.setAdapter(adapter);
        //Toast.makeText(getContext(), myModel.name, Toast.LENGTH_SHORT).show();

    }



}
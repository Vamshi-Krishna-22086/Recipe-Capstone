package com.example.finalCapstone;

import java.util.ArrayList;
public class GlobalTopAllergens
{
    static ArrayList<Model>  allergens_arr = new ArrayList<>();
    static void set_items()
    {
        //this is the static allergens list
        allergens_arr.add(new Model(R.drawable.burger,"Milk"));
        allergens_arr.add(new Model(R.drawable.burger,"Eggs"));
        allergens_arr.add(new Model(R.drawable.burger,"Soybeans"));
        allergens_arr.add(new Model(R.drawable.burger,"Peanuts"));
        allergens_arr.add(new Model(R.drawable.burger,"Wheat"));
        allergens_arr.add(new Model(R.drawable.burger,"Sesame"));
        allergens_arr.add(new Model(R.drawable.burger,"Shrimp"));
        allergens_arr.add(new Model(R.drawable.burger,"Almonds"));
        allergens_arr.add(new Model(R.drawable.burger,"Celery"));
        allergens_arr.add(new Model(R.drawable.burger,"Mustard"));
        allergens_arr.add(new Model(R.drawable.burger,"Apricot"));
        allergens_arr.add(new Model(R.drawable.burger,"Fish"));

    }
}

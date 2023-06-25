package com.example.finalCapstone;

import java.util.ArrayList;

public class GlobalTopIngredients
{
    static ArrayList<Model>  arr = new ArrayList<>();
    static void set_items()
    {
        //here we are adding the common ingredients so that the user need not explicitly mention the ingredient
        //we are creating each element as a object of model class and storing in 'arr' ,which is static
        //we can directly access the arraylist since it is static
        arr.add(new Model(R.drawable.burger,"Salt"));
        arr.add(new Model(R.drawable.burger,"Onion"));
        arr.add(new Model(R.drawable.burger,"Butter"));
        arr.add(new Model(R.drawable.burger,"Garlic"));
        arr.add(new Model(R.drawable.burger,"Olive oil"));
        arr.add(new Model(R.drawable.burger,"Sugar"));
        arr.add(new Model(R.drawable.burger,"Tomato"));
        arr.add(new Model(R.drawable.burger,"Black Pepper"));
        arr.add(new Model(R.drawable.burger,"Flour"));
        arr.add(new Model(R.drawable.burger,"Parsley"));
        arr.add(new Model(R.drawable.burger,"Carrot"));
        arr.add(new Model(R.drawable.burger,"Cumin"));
        arr.add(new Model(R.drawable.burger,"Potato"));
        arr.add(new Model(R.drawable.burger,"Lemon"));
        arr.add(new Model(R.drawable.burger,"Soy Sauce"));

    }
}

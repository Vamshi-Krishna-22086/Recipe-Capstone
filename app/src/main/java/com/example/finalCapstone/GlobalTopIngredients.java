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
        arr.add(new Model(R.drawable.burger,"potato"));
        arr.add(new Model(R.drawable.burger,"onion"));
        arr.add(new Model(R.drawable.burger,"tomato"));
        arr.add(new Model(R.drawable.burger,"carrot"));
        arr.add(new Model(R.drawable.burger,"capsicum"));
        arr.add(new Model(R.drawable.burger,"salt"));
        arr.add(new Model(R.drawable.burger,"sugar"));
        arr.add(new Model(R.drawable.burger,"milk"));
        arr.add(new Model(R.drawable.burger,"cumin"));
        arr.add(new Model(R.drawable.burger,"honey"));
        arr.add(new Model(R.drawable.burger,"oil"));
        arr.add(new Model(R.drawable.burger,"orange"));

    }
}

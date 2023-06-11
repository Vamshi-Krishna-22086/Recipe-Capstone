package com.example.finalCapstone;

import java.util.ArrayList;

public class AddedIngredients
{
    //once the user click something in the card view of ingredients ,ingredients wil come in this arraylist
    public static ArrayList<Model> myarray= new ArrayList<>();

    public static void set_details(Model mymodel)
    {
        myarray.add(mymodel);
    }
    public static void remove(int index)
    {

    }

}

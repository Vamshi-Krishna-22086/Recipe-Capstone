package com.example.finalCapstone;

import java.io.Serializable;

import java.util.ArrayList;



public class UserData implements Serializable {

    public String diet;

    public ArrayList<String> allergens;

    public ArrayList<String> cuisines;



    public void setDiet(String s)

    {

        this.diet = s;

    }



    public void setAllergens(ArrayList<String> allergens) {

        this.allergens = allergens;

    }



    public void setCuisines(ArrayList<String> cuisines) {

        this.cuisines = cuisines;

    }

}
package com.example.finalCapstone.Models;

public class RecipeModel {
    String id;
    String name;
    String imageUrl;
    String cookTime;

    public RecipeModel() {
    }

    public RecipeModel(String id, String name, String imageUrl, String cookTime) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.cookTime = cookTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }
}

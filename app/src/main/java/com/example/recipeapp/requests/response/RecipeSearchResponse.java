package com.example.recipeapp.requests.response;

import com.example.recipeapp.models.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("recipe")
    @Expose()
    private List<Recipe> recipe;

    public int getCount() {
        return count;
    }

    public List<Recipe> getRecipes() {
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeSearchResponse{" +
                "count=" + count +
                ", recipe=" + recipe +
                '}';
    }
}

package com.example.recipeapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.models.Recipe;
import com.example.recipeapp.repository.RecipeRepository;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<Recipe> getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId){
        mRecipeRepository.searchRecipeById(recipeId);
    }
}

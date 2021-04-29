package com.example.recipeapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.models.Recipe;

import java.util.List;

public class RecipeListViewModel extends ViewModel {

    public MutableLiveData<List<Recipe>> mRecipes = new MutableLiveData<>();

    public RecipeListViewModel() {
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipes;
    }
}

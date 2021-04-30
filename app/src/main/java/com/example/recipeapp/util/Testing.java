package com.example.recipeapp.util;

import android.util.Log;

import com.example.recipeapp.models.Recipe;
import com.example.recipeapp.requests.RecipeApi;
import com.example.recipeapp.requests.ServiceGenerator;
import com.example.recipeapp.requests.response.RecipeResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Testing {

    public static void printRecipe(List<Recipe> list, String tag){
        for (Recipe recipe: list){
            Log.d(tag, "onChanged: " + recipe.getTitle());
        }
    }

//    private void testRetrofitRequest(){
//        searchRecipeApi("chicken", 1);
//    }

    private void testRetrofitRequest2(){
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

        //Do search using Retrofit
        Call<RecipeResponse> responseCall = recipeApi
                .getRecipe(
                        Constants.API_KEY,
                        "12142"
                );

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                if(response.code() == 200){
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    Recipe recipes = response.body().getRecipe();

                }
                else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }

}

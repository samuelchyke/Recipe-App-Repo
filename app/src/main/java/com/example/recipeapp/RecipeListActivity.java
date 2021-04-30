package com.example.recipeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.adapters.OnRecipeListener;
import com.example.recipeapp.adapters.RecipeRecyclerAdapter;
import com.example.recipeapp.models.Recipe;
import com.example.recipeapp.requests.RecipeApi;
import com.example.recipeapp.requests.ServiceGenerator;
import com.example.recipeapp.requests.response.RecipeResponse;
import com.example.recipeapp.requests.response.RecipeSearchResponse;
import com.example.recipeapp.util.Constants;
import com.example.recipeapp.util.Testing;
import com.example.recipeapp.viewmodel.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecipeListActivity extends BaseActivity
implements OnRecipeListener {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;

    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mRecipeRecyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mRecyclerView = findViewById(R.id.recipe_list);

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);
        initRecyclerView();
        subscribeObservers();
        initSearchView();

    }

    private void initRecyclerView(){
        mRecipeRecyclerAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mRecipeRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void searchRecipeApi(String query, int pageNumber){
        mRecipeListViewModel.searchRecipesApi(query, pageNumber);
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if(recipes!= null){
                    Testing.printRecipe(recipes, "recipes test");
                    mRecipeRecyclerAdapter.setRecipes(recipes);
                }
            }
        });
    }

    private void initSearchView(){
        final SearchView searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecipeApi(query, 1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }
}
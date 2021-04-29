package com.example.recipeapp;

import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.models.Recipe;
import com.example.recipeapp.requests.RecipeApiClient;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private static AppExecutors  instance;

    // Singleton Pattern
    public static AppExecutors  getInstance(){
        if(instance == null){
            instance = new AppExecutors();
        }
        return instance;
    }

    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO() {
        return mNetworkIO;
    }
}

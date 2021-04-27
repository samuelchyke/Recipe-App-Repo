package com.example.recipeapp;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {

        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout fragmentLayout = constraintLayout.findViewById(R.id.activity_content);

        getLayoutInflater().inflate(layoutResID, fragmentLayout, true);

        mProgressBar = constraintLayout.findViewById(R.id.progress_bar);

        super.setContentView(layoutResID);
    }

    public void showProgressBar(boolean visible){
        mProgressBar.setVisibility(visible ? View.VISIBLE: View.INVISIBLE);
    }
}

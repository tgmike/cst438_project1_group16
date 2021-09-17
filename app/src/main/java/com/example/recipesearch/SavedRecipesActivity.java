package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SavedRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipes);
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, SavedRecipesActivity.class);
        return intent;
    }
}
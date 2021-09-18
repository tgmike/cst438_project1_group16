package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserMainMenu extends AppCompatActivity {
    List<Recipe> recipes;
    private recipeDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_menu);
        db = recipeDB.getInstance(this);
        db.seed();
        recipes = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            makeRecipe();
        }
    }
    private void makeRecipe(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.themealdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        recipeAPI recipeService = retrofit.create(recipeAPI.class);
        Call<RecipeHelper> call = recipeService.getRandomRecipe();
        call.enqueue(new Callback<RecipeHelper>() {
            @Override
            public void onResponse(Call<RecipeHelper> call, Response<RecipeHelper> response) {
                if (response.isSuccessful()) {
                    for(Recipe recipe: response.body().getMeals()){
                        Log.d("RECIPE", recipe.toString());
                        recipes.add(recipe);
                    }

                }
            }

            @Override
            public void onFailure(Call<RecipeHelper> call, Throwable t) {
                Log.d("RECIPE", "Running error");
                Toast.makeText(UserMainMenu.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
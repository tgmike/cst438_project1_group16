package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.recipesearch.db.AppDAO;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchRecipes extends AppCompatActivity {

    private TextView recipeResultsTV;
    private Button searchBtn;
    private EditText recipeName;
    private AppDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);

        recipeResultsTV = findViewById(R.id.RecipeResultsTV);
        searchBtn = findViewById(R.id.SearchBtn);
        recipeName = findViewById(R.id.SearchRecipeET);

        searchBtn.setOnClickListener(view -> {
            String name = recipeName.getText().toString();
            recipeResultsTV.setText("Something is cooking...");
            getRecipe(name);
        });

    }

    private void getRecipe(String name){
        recipeAPI api = Util.getAPI();

        Call<List<Recipe>> call = api.searchRecipes(name);

        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(!response.isSuccessful()){
                    Log.e("HTTP Call fail", response.code() + ": " + response.message());
                    recipeResultsTV.setText("Search Failed: "+ response.code());
                    return;
                }

                List<Recipe> recipes = response.body();

                for(Recipe recipe :recipes){
                    String content ="";
                    content += "Meal ID: " +recipe.getIdMeal()+ "\n";
                    content += "Meal : "+ recipe.getStrMeal() + "\n";
                    content += "Category: " + recipe.getStrCategory() +"\n\n";

                    recipeResultsTV.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e("HTTP Call fail", t.getMessage());
                recipeResultsTV.setText("Failure:"+ t.getMessage() +"\n"+ t.getLocalizedMessage());
            }
        });
    }

    public User getUser(){
        return User.getSignedInUser(dao);
    }
    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, SearchRecipes.class);
        return intent;
    }

}
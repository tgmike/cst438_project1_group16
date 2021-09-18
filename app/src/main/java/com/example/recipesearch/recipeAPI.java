package com.example.recipesearch;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface recipeAPI {
    @GET("/api/json/v1/1//random.php")
    Call<RecipeHelper>getRandomRecipe();
    @GET("/api/json/v1/1//lookup.php?i={id}")
    Call<RecipeHelper>getRecipe(@Path("id") String id);
}

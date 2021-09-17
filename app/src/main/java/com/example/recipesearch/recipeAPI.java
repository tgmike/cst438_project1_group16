package com.example.recipesearch;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface recipeAPI {
    public static final String BASE_URL = "www.themealdb.com/api/json/v1/1/search.php?";

    @GET("s={name}")
    Call<List<Recipe>> searchRecipes(@Path("name") String name);


}

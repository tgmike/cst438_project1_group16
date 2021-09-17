package com.example.recipesearch;

import com.google.gson.annotations.SerializedName;

public class Recipe {

    private int idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;

//    @SerializedName("body")
//    private String strInstructions;

    public int getIdMeal() {
        return idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

//    public String getStrInstructions() {
//        return strInstructions;
}


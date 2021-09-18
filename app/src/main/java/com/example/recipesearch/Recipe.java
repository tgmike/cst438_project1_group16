package com.example.recipesearch;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String idMeal;
    private String strMeal;
    private String strInstructions;
    private String strMealThumb;
    private List<String> strIngredients;
    private List<String> strMeasurements;
    private String intermediate;
    public Recipe(){
        idMeal = "52772";
        strMeal = "Teriyaki Chicken Casserole";
        strInstructions = "Preheat oven to 350...";
        strMealThumb = "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wvpsxx1468256321.jpg";
        strIngredients = new ArrayList<String>();
        strIngredients.add("soy sauce");
        strMeasurements = new ArrayList<String>();
        strMeasurements.add("3\\/4 cup");
    }

    public Recipe(String idMeal, String strMeal, String strInstructions, String strMealThumb){
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
    }


    public String getIdMeal() {
        return idMeal;
    }
    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }
    public String getStrMeal() {
        return strMeal;
    }
    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }
    public String getStrInstructions() {
        return strInstructions;
    }
    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }
    public String getStrMealThumb() {
        return strMealThumb;
    }
    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
    public List<String> getStrIngredients() {
        return strIngredients;
    }
    public void setStrIngredients(List<String> strIngredients) {
        this.strIngredients = strIngredients;
    }
    public List<String> getStrMeasurements() {
        return strMeasurements;
    }
    public void setStrMeasurements(List<String> strMeasurements) {
        this.strMeasurements = strMeasurements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return idMeal.equals(recipe.idMeal) && Objects.equals(strMeal, recipe.strMeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeal, strMeal);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "idMeal='" + idMeal + '\'' +
                ", strMeal='" + strMeal + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strMealThumb='" + strMealThumb + '\'' +
                '}';
    }
}

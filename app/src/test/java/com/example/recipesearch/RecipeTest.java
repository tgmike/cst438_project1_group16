package com.example.recipesearch;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeTest {
    @Test
    public void getMealIdTest(){
        Recipe recipe = new Recipe();
        String mealId = recipe.getIdMeal();
        assertEquals("52772", mealId);
    }
    @Test
    public void setMealIdTest(){
        Recipe recipe = new Recipe();
        recipe.setIdMeal("12345");
        String mealId = recipe.getIdMeal();
        assertEquals("12345", mealId);
    }
    @Test
    public void getMealTest(){
        Recipe recipe = new Recipe();
        String meal = recipe.getStrMeal();
        assertEquals("Teriyaki Chicken Casserole", meal);
    }
    @Test
    public void setMealTest(){
        Recipe recipe = new Recipe();
        recipe.setStrMeal("Orange Chicken");
        String meal = recipe.getStrMeal();
        assertEquals("Orange Chicken", meal);
    }
    @Test
    public void getInstructionsTest(){
        Recipe recipe = new Recipe();
        String instructions = recipe.getStrInstructions();
        assertEquals("Preheat oven to 350...", instructions);
    }
    @Test
    public void setInstructionsTest(){
        Recipe recipe = new Recipe();
        recipe.setStrInstructions("Freeze chicken");
        String instructions = recipe.getStrInstructions();
        assertEquals("Freeze chicken", instructions);
    }
    @Test
    public void getThumbTest(){
        Recipe recipe = new Recipe();
        String thumb = recipe.getStrMealThumb();
        assertEquals("https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wvpsxx1468256321.jpg", thumb);
    }
    @Test
    public void setThumbTest(){
        Recipe recipe = new Recipe();
        recipe.setStrMealThumb("www");
        String thumb = recipe.getStrMealThumb();
        assertEquals("www", thumb);
    }
    @Test
    public void getIngredientsTest(){
        Recipe recipe = new Recipe();
        List<String> ingredients = recipe.getStrIngredients();
        List<String> given = new ArrayList<String>();
        given.add("soy sauce");
        assertEquals(given, ingredients);
    }
    @Test
    public void setIngredientsTest(){
        Recipe recipe = new Recipe();
        List<String> given = new ArrayList<String>();
        given.add("chicken");
        recipe.setStrIngredients(given);
        List<String> ingredients = recipe.getStrIngredients();
        assertEquals(given, ingredients);
    }
}

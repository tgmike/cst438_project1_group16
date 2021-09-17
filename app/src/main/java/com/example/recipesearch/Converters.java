package com.example.recipesearch;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Converters {
    @TypeConverter
    public String convertListToString(List<String> jobs) {
        Gson gson = new Gson();
        return gson.toJson(jobs);
    }

    @TypeConverter
    public List<String> convertStringToList(String jobs) {
        Gson gson = new Gson();
        return gson.fromJson(jobs, new TypeToken<List<String>>(){}.getType());
    }

}
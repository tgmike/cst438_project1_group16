package com.example.recipesearch;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import androidx.room.Room;

import com.example.recipesearch.db.AppDAO;
import com.example.recipesearch.db.AppDatabase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Util {

    private static recipeAPI apiSingleton = null;

    public static Toast toastMaker(Context ctx, String str) {
        Toast toast = Toast.makeText(ctx, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }

    public static AppDAO getDAO(Context ctx) {
        return Room.databaseBuilder(ctx, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();
    }

    public static recipeAPI getAPI(){
        if (Util.apiSingleton == null) {
            Util.apiSingleton = new Retrofit.Builder()
                    .baseUrl(recipeAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(recipeAPI.class);
        }

        return Util.apiSingleton;
    }

}

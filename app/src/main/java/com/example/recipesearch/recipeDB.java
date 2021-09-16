package com.example.recipesearch;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Admin.class, User.class}, version = 1, exportSchema = false)
public abstract class recipeDB extends RoomDatabase{
    public abstract adminDAO admin();
    public abstract userDAO user();
    private static recipeDB sInstance;

    public static synchronized recipeDB getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    recipeDB.class, "recipeDB.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void seed() {
        if (user().count() == 0) {
            User bob = new User(
                    "Bob",
                    "password"
            );

            User bill = new User(
                    "Bill",
                    "password234"
            );
            user().insertAll(bob, bill);
        }
        if (admin().count() == 0) {
            Admin badmin = new Admin(
                    "Badmin",
                    "admin123",
                    "admin@admin.com"
            );

            admin().insert(badmin);
        }
    }
    public adminDAO getAdminDAO(){
        return admin();
    }
}

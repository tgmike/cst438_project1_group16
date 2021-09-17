package com.example.recipesearch.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.recipesearch.Admin;
import com.example.recipesearch.Converters;
import com.example.recipesearch.User;

@Database(entities = {User.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase{
//    public abstract adminDAO admin();
//    private static AppDatabase sInstance;
    public static final String DB_NAME = "RECIPE_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public abstract AppDAO getDAO();


//    public static synchronized AppDatabase getInstance(Context context) {
//        if (sInstance == null) {
//            sInstance = Room.databaseBuilder(context.getApplicationContext(),
//                    AppDatabase.class, "recipeDB.db")
//                    .fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
//                    .build();
//        }
//        return sInstance;
//    }

//    public void seed() {
//        if (user().count() == 0) {
//            User bob = new User(
//                    "Bob",
//                    "password", false
//            );
//
//            User bill = new User(
//                    "Bill",
//                    "password234",
//                    true
//            );
//            user().insertAll(bob, bill);
//        }
//        if (admin().count() == 0) {
//            Admin badmin = new Admin(
//                    "Badmin",
//                    "admin123",
//                    "admin@admin.com"
//            );
//
//            admin().insert(badmin);
//        }
//    }
//    public adminDAO getAdminDAO(){
//        return admin();
//    }
}

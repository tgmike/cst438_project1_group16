package com.example.recipesearch;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.recipesearch.DAO.adminDAO;
import com.example.recipesearch.DAO.userDAO;

@Database(version = 1, entities = {User.class, Admin.class})
abstract class AppDatabase extends RoomDatabase{
    abstract public userDAO userDao();
    abstract public adminDAO adminDao();


}
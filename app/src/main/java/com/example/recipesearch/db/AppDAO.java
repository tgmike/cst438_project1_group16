package com.example.recipesearch.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recipesearch.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Dao
public interface AppDAO {

    @Insert
    void insert(User... user);

    @Insert
    void insertAll(User... users);

//    @Query("SELECT * FROM user WHERE id=:id")
//    User getUser(long id);


    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE username =:name")
    User getUserByUsername(String name);

    @Update
    public void update(User... user);
//    public void update(User user, String[] params) {
//        user.setName(Objects.requireNonNull(
//                params[0], "Name cannot be null"));
//        user.setPassword(Objects.requireNonNull(
//                params[1], "Password cannot be null"));
//
//        users.add(user);
//    }

    @Delete
    void delete(User user);

}
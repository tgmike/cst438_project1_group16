package com.example.recipesearch;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.recipesearch.db.AppDAO;
import com.example.recipesearch.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User{

    @PrimaryKey ()
    @NonNull
    private String username;
    private String password;
    private boolean isAdmin;
    private List<String> savedRecipes;

    @Ignore
    private static User signedInUser = null;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.savedRecipes = new ArrayList<>();
    }


    public User() {
        this.username = "none";
        this.password = "none";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(List<String> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

    public User addToDB(AppDAO dao) {
        if (dao.getUserByUsername(this.username) != null) {
            Log.e("Create Account", "Username '" + this.username + "' already exists!");
            return null;
        }

        dao.insert(this);

        if (dao.getUserByUsername(this.username) == null) {
            Log.e("Create Account", "Error: Account could not be created!");
            return null;
        }

        return this;
    }

    public void signIn(){
        User.signedInUser = this;
    }

    public void signOut(){
        User.signedInUser = null;
    }

    public static User getSignedInUser(AppDAO appDao){
        return User.signedInUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +                "name='" + username + '\'' +
                ", email='" + password + '\'' +
                '}';
    }

}
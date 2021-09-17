package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.recipesearch.db.AppDAO;

public class UserMainMenu extends AppCompatActivity {

    private Button myRecipesBtn;
    private Button searchRecipesBtn;
    private Button createRecipeBtn;
    private TextView menuTitle;
    private Button logOutBtn;

    private User user;
    private AppDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_menu);

        dao = Util.getDAO(this);
        user = getUser();
        menuTitle = findViewById(R.id.MenuWelcomeMsg);
        myRecipesBtn = findViewById(R.id.MenuMyRecipesBtn);
        searchRecipesBtn = findViewById(R.id.MenuSearchRecipeBtn);
        createRecipeBtn = findViewById(R.id.MenuCreateRecipeBtn);
        logOutBtn = findViewById(R.id.logOutBtn);


        menuTitle.setText("Welcome "+ user.getUsername());
        myRecipesBtn.setOnClickListener(view -> {
            startActivity(SavedRecipesActivity.intentFactory(getApplicationContext()));
        });

        searchRecipesBtn.setOnClickListener(view -> {
            startActivity(SearchRecipes.intentFactory(getApplicationContext()));
        });

//        createRecipeBtn.setOnClickListener(view -> {
//            startActivity(CreateRecipe.intentFactory(getApplicationContext()));
//        });

        logOutBtn.setOnClickListener(view -> {
            logOut(user);
            startActivity(MainActivity.intentFactory(getApplicationContext()));
        });
    }

    public User getUser(){
        return User.getSignedInUser(dao);
    }

    public void logOut(User user){
        user.signOut();
    }
    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, UserMainMenu.class);
        return intent;
    }
}
package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.recipesearch.db.AppDAO;

import java.util.List;

public class AdminMainMenu extends AppCompatActivity {

    private Button viewUsersBtn;
    private Button viewRecipesBtn;
    private Button logOutBtn;

    private User user;
    private AppDAO dao;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_menu);

        dao = Util.getDAO(this);
        users = dao.getAllUsers();
        user = getUser();

        viewUsersBtn = findViewById(R.id.ViewUsersBtn);
        viewRecipesBtn = findViewById(R.id.ViewRecipesBtn);
        logOutBtn = findViewById(R.id.AdminLogOutBtn);

        viewUsersBtn.setOnClickListener(view -> {
            startActivity(AdminViewUsers.intentFactory(getApplicationContext()));
        });

        viewRecipesBtn.setOnClickListener(view -> {

        });

        logOutBtn.setOnClickListener(view -> {
            logOut(user);
            startActivity(MainActivity.intentFactory(getApplicationContext()));
        });
    }

    public void logOut(User user){
        user.signOut();
    }

    public User getUser(){
        return User.getSignedInUser(dao);
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, AdminMainMenu.class);
        return intent;
    }

}
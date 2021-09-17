package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.recipesearch.db.AppDAO;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;
    private EditText confPasswordEt;
    private Button createAccBtn;
    private Button logInbtn;

    private AppDAO appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        usernameEt = findViewById(R.id.createAccUsernameET);
        passwordEt = findViewById(R.id.createAccPasswordET);
        confPasswordEt =findViewById(R.id.createAccConfirmET);
        createAccBtn = findViewById(R.id.createAccBtn);
        logInbtn = findViewById(R.id.logInBtn);

        appDao = Util.getDAO(this);

        createAccBtn.setOnClickListener(view -> {
            String username = usernameEt.getText().toString().trim();
            String password = passwordEt.getText().toString().trim();
            String confPassword = confPasswordEt.getText().toString().trim();

            if (!password.equals(confPassword)) {
                confPasswordEt.setBackgroundColor(Color.RED);
                return;
            } else  {
                confPasswordEt.setBackgroundColor(Color.WHITE);
            }

            User user;
            if ((user = createAccount(username, password)) == null) {
                Util.toastMaker(getApplicationContext(), "Account not created! Username: " +
                        username + " already exists!").show();
            } else {
                startActivity(UserMainMenu.intentFactory(getApplicationContext()));
            }
        });

        logInbtn.setOnClickListener(v -> {
            startActivity(MainActivity.intentFactory(getApplicationContext()));
        });
    }

    public User createAccount(String username, String password) {
        User user;
        if(username.equals("admin")) {
            user = new User(username, password, true);
        }
        else{
            user = new User(username, password, false);
        }

        return user.addToDB(appDao);
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, CreateAccountActivity.class);
        return intent;
    }
}
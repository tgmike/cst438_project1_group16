package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;
    private EditText confPasswordEt;
    private Button createBtn;
    private Button logInbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        usernameEt = findViewById(R.id.createAccUsernameET);
        passwordEt = findViewById(R.id.createAccPasswordET);
        confPasswordEt =findViewById(R.id.createAccConfirmET);

        logInbtn.setOnClickListener(v -> {
            startActivity(MainActivity.intentFactory(getApplicationContext()));
        });
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, CreateAccountActivity.class);
        return intent;
    }
}
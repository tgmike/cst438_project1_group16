package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

//import com.google.firebase.inappmessaging.model.Button

public class MainActivity extends AppCompatActivity {

    EditText mUsername;
    EditText mPassword;

    private Button mLogInBtn;
    private Button mCreateAccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.usernameEditText);
        mPassword= findViewById(R.id.passwordEditText);
        mLogInBtn = findViewById(R.id.mainLogInBtn);

        mCreateAccBtn = findViewById(R.id.mainCreateAccBtn);

        mCreateAccBtn.setOnClickListener(v -> {
            startActivity(CreateAccountActivity.intentFactory(getApplicationContext()));
        });
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, CreateAccountActivity.class);
        return intent;
    }
}
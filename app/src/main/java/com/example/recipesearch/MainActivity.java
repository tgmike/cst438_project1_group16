package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipesearch.db.AppDAO;


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

        mLogInBtn.setOnClickListener(view -> {
            String username = mUsername.getText().toString();
            String password = mPassword.getText().toString();

            User user = verifyLogin(username,password);
            if(user == null ){
                Toast toast = Toast.makeText(this, "Try Again",Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                if(user.isAdmin()){
                    startActivity(AdminMainMenu.intentFactory(getApplicationContext()));
                }
                else {
                    startActivity(UserMainMenu.intentFactory((getApplicationContext())));
                }

            }

        });

        mCreateAccBtn = findViewById(R.id.mainCreateAccBtn);

        mCreateAccBtn.setOnClickListener(v -> {
            startActivity(CreateAccountActivity.intentFactory(getApplicationContext()));
        });
    }

    private User verifyLogin(String username, String password){
        AppDAO dao = Util.getDAO(getApplicationContext());
        User user = dao.getUserByUsername(username);

        if(user == null){
            Toast toast = Toast.makeText(this, "Invalid Username",Toast.LENGTH_LONG);
            toast.show();
            mUsername.setText(null);
            mPassword.setText(null);
            return null;
        }

        String truePassword = user.getPassword();
        if(truePassword.equals(password)){
            user.signIn();
            return user;
        }
        else{
            Toast toast = Toast.makeText(this, "Invalid Password",Toast.LENGTH_LONG);
            toast.show();
            mPassword.setText(null);
            return null;
        }
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, MainActivity.class);
        return intent;
    }
}
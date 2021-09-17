package com.example.recipesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.recipesearch.db.AppDAO;

import java.util.List;

public class AdminViewUsers extends AppCompatActivity {

    private ListView listView;
    private AppDAO dao;
    private List<User> users;
    private String[] usernamesArr;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_users);

        dao = Util.getDAO(this);
        users = dao.getAllUsers();
        getUserNames();

        listView = findViewById(R.id.AdminListView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, usernamesArr);
        listView.setAdapter(arrayAdapter);
    }

    private void getUserNames() {
        usernamesArr = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usernamesArr[i] = users.get(i).getUsername();
        }
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, AdminViewUsers.class);
        return intent;
    }
}
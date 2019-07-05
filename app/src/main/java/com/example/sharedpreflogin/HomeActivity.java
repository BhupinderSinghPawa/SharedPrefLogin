package com.example.sharedpreflogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textViewUser;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewUser = findViewById(R.id.textViewUser);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        email = sharedPreferences.getString("Email", "");
        password = sharedPreferences.getString("Password", "");

        textViewUser.setText("Welcome " + email + ", you logged in with password " + password);

    }


    public void onClickLogout (View v) {
        // clear the preferences
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        finish();

        // Start the Login Activity
        // Intent intent = new Intent(this, LoginActivity.class);
        // startActivity(intent);
    }

}

package com.example.sharedpreflogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private CheckBox checkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String email, password;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);

        // check if the preferences exist, and auto populate the text fields
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        email = sharedPreferences.getString("Email", "");
        password = sharedPreferences.getString("Password", "");

        if (email != null && password != null) {
            mEmailView.setText(email);
            mPasswordView.setText(password);
            checkBoxRememberMe.setChecked(true);
        }
    }

    public void onClickSignIn (View v) {

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (checkBoxRememberMe.isChecked()) {
            // store the Email and Password in Preferences
            SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.apply();
        }

        // Start the Home Activity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

}

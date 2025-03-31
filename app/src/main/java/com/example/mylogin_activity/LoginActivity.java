package com.example.mylogin_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Match IDs with XML file
        EditText LoginId = findViewById(R.id.LoginId);
        EditText Username = findViewById(R.id.UserName);
        EditText Password = findViewById(R.id.Password);
        Button LoginButton = findViewById(R.id.LoginButton);
        Button ResetButton = findViewById(R.id.ResetButton);

        // Log to ensure the views are initialized
        Log.d(TAG, "Views initialized");

        // Login button functionality
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = LoginId.getText().toString();
                String user = Username.getText().toString();
                String pass = Password.getText().toString();

                if (!login.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                    try {
                        // Redirect to NextActivity
                        Intent intent = new Intent(LoginActivity.this, NextActivity.class);
                        intent.putExtra("LOGIN_ID", login);
                        intent.putExtra("USERNAME", user);
                        startActivity(intent);

                        // Show success popup message
                        Toast.makeText(LoginActivity.this, "You have successfully logged in to your account!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e(TAG, "Error starting NextActivity", e);
                        Toast.makeText(LoginActivity.this, "Error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Show popup if any field is empty
                    Toast.makeText(LoginActivity.this, "Please fill all details!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
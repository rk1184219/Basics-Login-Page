package com.example.mylogin_activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        TextView detailsView = findViewById(R.id.detailsView);

        // Retrieve data passed from LoginActivity
        String loginId = getIntent().getStringExtra("LOGIN_ID");
        String username = getIntent().getStringExtra("USERNAME");

        if (loginId != null && username != null) {
            detailsView.setText("Login ID: " + loginId + "\nUsername: " + username);
        } else {
            detailsView.setText("No login details provided.");
        }
    }
}
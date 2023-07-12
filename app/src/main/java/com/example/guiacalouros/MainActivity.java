package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseConnection connection = new DatabaseConnection();
//        connection.connect();

        setContentView(R.layout.activity_home);
    }
}
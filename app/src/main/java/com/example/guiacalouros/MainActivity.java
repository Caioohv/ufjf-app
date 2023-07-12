package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

    }

    public void redirectUfjfPage(View view){
        this.startActivity(new Intent(this, InfoUfjfView.class));
    }

    public void redirectRegisterPage(View view){
        this.startActivity(new Intent(this, RegisterView.class));
    }


}
package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

    }

    public void redirectUfjfPage(View view){
        this.startActivity(new Intent(this,InfoUfjf.class));
    }

    public void redirectRegisterPage(View view){
        this.startActivity(new Intent(this, Register.class));
    }


}
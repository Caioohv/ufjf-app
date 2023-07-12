package com.example.guiacalouros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }
    public void redirectHome(View view){
        this.startActivity(new Intent(this, HomeView.class));
    }
}
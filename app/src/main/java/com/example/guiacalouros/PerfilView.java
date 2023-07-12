package com.example.guiacalouros;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);

        TextView username = findViewById(R.id.textView12);
        TextView email = findViewById(R.id.textView14);
        TextView cpf = findViewById(R.id.textView16);
        Log.e("teste", LoggedUser.name);
//
//
        username.setText(LoggedUser.name);
        email.setText(LoggedUser.email);
        cpf.setText(LoggedUser.cpf);


    }
    public void redirectHome(View view){
        this.finish();
    }
}
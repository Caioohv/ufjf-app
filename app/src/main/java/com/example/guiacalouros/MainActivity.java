package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiacalouros.DB.UserDAO;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        EditText cpf = findViewById(R.id.loginName);
        EditText password = findViewById(R.id.loginPassword);

        String cpfText = cpf.getText().toString();
        String passwordText = password.getText().toString();

        UserDAO connection = new UserDAO(MainActivity.this);
        UserClass result = connection.getUser(cpfText, passwordText);

        if(result != null){
            LoggedUser.id = result.getId();
            LoggedUser.name = result.getName();
            LoggedUser.email = result.getEmail();
            Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            this.startActivity(new Intent(this, HomeView.class));
        }else{
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void redirectRegisterPage(View view){
        this.startActivity(new Intent(this, RegisterView.class));
    }


}
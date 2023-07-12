package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guiacalouros.DB.UserDAO;

public class RegisterView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void RegisterUser(View view) {
        EditText edtCPF = findViewById(R.id.edtCPF);
        EditText edtSenha = findViewById(R.id.edtSenha);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtNome = findViewById(R.id.edtNome);

        UserClass user;

        try {
             user = new UserClass(edtNome.getText().toString(), edtCPF.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString());
        } catch (Exception e) {
             user = new UserClass("error", "error", "error", "error");

        }

        UserDAO userDAO = new UserDAO(RegisterView.this);
        boolean success = userDAO.addUser(user);

        if(success) {
            Toast.makeText(RegisterView.this, "Success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(RegisterView.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void returnLogin(View view){
        this.startActivity(new Intent(this, LoginView.class));
    }

}
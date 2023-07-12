package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
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

        GuiaUser user;

        try {
             user = new GuiaUser(edtNome.getText().toString(), edtCPF.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString());
        } catch (Exception e) {
             user = new GuiaUser("error", "error", "error", "error");

        }

        DatabaseConnection databaseConnection = new DatabaseConnection(Register.this);
        boolean success = databaseConnection.addOne(user);

        Toast.makeText(Register.this, "Success= " + success, Toast.LENGTH_SHORT).show();
    }

}
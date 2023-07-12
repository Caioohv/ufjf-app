package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void cadastroUser(View view) {
        EditText edtCPF = findViewById(R.id.edtCPF);
        EditText edtSenha = findViewById(R.id.edtSenha);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtNome = findViewById(R.id.edtNome);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://aws.connect.psdb.cloud/midivide?sslMode=VERIFY_IDENTITY", "gygbfj5syog2254scfx5", "pscale_pw_IpjshB5YDeXXDvgPQSjnDYsuP7dHOVoqytpMVGnOR2w");
            GuiaUser user = new GuiaUser(edtNome.getText().toString(), edtCPF.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString());
            UserDAO userDB = new UserDAO(conn);
            userDB.createUser(user);
        } catch (Exception e) {
            edtCPF.setText("Banco não foi");

        }
    }

}
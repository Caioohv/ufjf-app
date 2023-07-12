package com.example.guiacalouros;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(LoggedUser.id != 0) {

            setContentView(R.layout.activity_home);

            TextView username = findViewById(R.id.textView3);
            TextView email = findViewById(R.id.textView4);

            username.setText(LoggedUser.name);
            email.setText(LoggedUser.email);

        }else{
            this.startActivity(new Intent(this,MainActivity.class));
        }
    }

    public void logout(View view){
        LoggedUser.id = 0;
        LoggedUser.name = null;
        LoggedUser.email = null;
        this.startActivity(new Intent(this, MainActivity.class));
    }

    public void redirectUfjfPage(View view){

        this.startActivity(new Intent(this, InfoUfjfView.class));
    }

}

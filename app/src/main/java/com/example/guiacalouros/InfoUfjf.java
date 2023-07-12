package com.example.guiacalouros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InfoUfjf extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_ufjf);

    }

    public void returnHome(View view){
        this.startActivity(new Intent(this, MainActivity.class));
    }

    public void moreInformation(View view){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www2.ufjf.br/ufjf/sobre/apresentacao/"));
        startActivity(viewIntent);
    }
}
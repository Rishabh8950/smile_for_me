package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donordashboard extends AppCompatActivity {
    Button donatengobtn,uploaditembtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donordashboard);
        donatengobtn=(Button)findViewById(R.id.payngo);
        uploaditembtn=(Button)findViewById(R.id.uploaditem);
        donatengobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donate=new Intent(getApplicationContext(),ngolistactivity.class);
                startActivity(donate);
            }
        });
        uploaditembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upload=new Intent(getApplicationContext(),Uploaditem.class);
                startActivity(upload);
            }
        });


    }
}
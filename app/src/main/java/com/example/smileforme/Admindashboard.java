package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admindashboard extends AppCompatActivity {
    Button newadminbtn,recipientrequest,donorrequest,ngorequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);
        newadminbtn=findViewById(R.id.addjunioradmin);
        recipientrequest=findViewById(R.id.recipientrequest);
        donorrequest=findViewById(R.id.donorrequest);
        ngorequest=findViewById(R.id.ngorequest);


        newadminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addadmin=new Intent(getApplicationContext(),Newjunioradmin.class);
                startActivity(addadmin);

            }
        });

        recipientrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewrecipientrequests=new Intent(getApplicationContext(),Recipientrequests.class);
                startActivity(viewrecipientrequests);
            }
        });

        donorrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewdonorrequests=new Intent(getApplicationContext(),Donorrequests.class);
                startActivity(viewdonorrequests);
            }
        });
        ngorequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewngorequests=new Intent(getApplicationContext(),ngorequests.class);
                startActivity(viewngorequests);
            }
        });

    }
}
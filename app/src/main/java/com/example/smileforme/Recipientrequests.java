package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Recipientrequests extends AppCompatActivity {

    database recipientdb=null;
    EditText verifyBPL,listofrequests;
    Button accept,decline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipientrequests);
        recipientdb=new database(this,"",null,1);
        verifyBPL=(EditText) findViewById(R.id.bplverification);
        listofrequests=(EditText)findViewById(R.id.recipientrequestlist);
        accept=(Button)findViewById(R.id.bplacceptbtn);
        decline=(Button)findViewById(R.id.bpldeclinebtn);
    }
}
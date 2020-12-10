package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Recipientrequests extends AppCompatActivity {

    database recipientdb=null;
    EditText verifyBPL;
    TextView viewreq;
    Button accept,decline,listofrequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipientrequests);
        recipientdb=new database(this);
        verifyBPL=(EditText) findViewById(R.id.bplverification);
        listofrequests=(Button) findViewById(R.id.recipientrequestsbtn);
        accept=(Button)findViewById(R.id.bplacceptbtn);
        decline=(Button)findViewById(R.id.bpldeclinebtn);
        viewreq=(TextView) findViewById(R.id.recipientrequestlist);

        listofrequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipientdb.viewrecipientreq(viewreq);

            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipientdb.acceptrecipient(verifyBPL.getText().toString());
                Toast.makeText(getApplicationContext(),"Recipient successfully added",Toast.LENGTH_LONG).show();
                Intent refresh=new Intent(getApplicationContext(),Recipientrequests.class);
                startActivity(refresh);

            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipientdb.declinerecipient(verifyBPL.getText().toString());
                Toast.makeText(getApplicationContext(),"Request denied",Toast.LENGTH_LONG).show();
                Intent ref=new Intent(getApplicationContext(),Recipientrequests.class);
                startActivity(ref);
            }
        });
    }
}
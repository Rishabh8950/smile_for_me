package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ngorequests extends AppCompatActivity {
    database ngodb=null;
    EditText verifyid;
    TextView viewreq;
    Button accept,decline,listofrequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngorequests);
        verifyid=(EditText) findViewById(R.id.ngoverification);
        listofrequests=(Button) findViewById(R.id.ngorequestsbtn);
        accept=(Button)findViewById(R.id.ngoacceptbtn);
        decline=(Button)findViewById(R.id.ngodeclinebtn);
        viewreq=(TextView) findViewById(R.id.ngorequestlist);
        ngodb=new database(this,"",null,1);



        listofrequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ngodb.viewngoreq(viewreq);

            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngodb.acceptngo(verifyid.getText().toString());
                Toast.makeText(getApplicationContext(),"NGO successfully registered",Toast.LENGTH_LONG).show();
                Intent refresh=new Intent(getApplicationContext(),ngorequests.class);
                startActivity(refresh);

            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngodb.declinengo(verifyid.getText().toString());
                Toast.makeText(getApplicationContext(),"Request denied",Toast.LENGTH_LONG).show();
                Intent ref=new Intent(getApplicationContext(),ngorequests.class);
                startActivity(ref);
            }
        });
    }
}
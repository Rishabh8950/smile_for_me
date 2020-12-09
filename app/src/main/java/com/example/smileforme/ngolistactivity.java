package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ngolistactivity extends AppCompatActivity {
    EditText contact;
    TextView listofngos;
    Button pay,viewlist;
    database ngodb=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngolistactivity);
        contact=(EditText)findViewById(R.id.ngonumber);
        pay=(Button)findViewById(R.id.ngopaybtn);
        viewlist=(Button)findViewById(R.id.ngolistbtn);
        ngodb= new database(this,"",null,1);
        listofngos=(TextView)findViewById(R.id.ngolist);

        viewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngodb.viewngolist(listofngos);

            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ngodb.ngocontactvalidation(contact.getText().toString())==1)
                {
                    String url="http://m.p-y.tm";
                    Intent pay=new Intent(Intent.ACTION_VIEW);
                    pay.setData(Uri.parse(url));
                    startActivity(pay);
                }
                else
                    Toast.makeText(getApplicationContext(),"Check Number",Toast.LENGTH_LONG).show();
            }
        });

    }
}
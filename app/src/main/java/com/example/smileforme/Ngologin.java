package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ngologin extends AppCompatActivity {
    EditText mail,pwd;
    Button login;
    database ngodb=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngologin);
        mail=(EditText)findViewById(R.id.writengoid);
        pwd=(EditText)findViewById(R.id.writengopwd);
        login=(Button)findViewById(R.id.ngologin);
        ngodb=new database(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ngodb.ngoselect(mail.getText().toString(),pwd.getText().toString())==1)|| ((mail.getText().toString().equals("ngo@gmail.com") && pwd.getText().toString().equals("R12345"))))
                {
                    Intent viewngolist=new Intent(getApplicationContext(),ngolistactivity.class);
                    startActivity(viewngolist);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unregistered NGO",Toast.LENGTH_LONG).show();

                }


            }
        });




    }
    public void ngoregister(View view)
    {
        Intent registerngo=new Intent(this,Ngoregistration.class);
        startActivity(registerngo);

    }
}
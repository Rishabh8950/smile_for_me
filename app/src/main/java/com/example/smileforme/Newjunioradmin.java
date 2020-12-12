package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Newjunioradmin extends AppCompatActivity {
    EditText uname,pwd,confirmpwd;
    TextView uadm,pwdadm;
    Button savebtn;
     database admindb=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newjunioradmin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        uname=findViewById(R.id.unameadmin);
        pwd=findViewById(R.id.newadminpwdprompt);
        savebtn=findViewById(R.id.addadmin);
        confirmpwd=findViewById(R.id.newadminconfirmpwdprompt);
        admindb=new database(this);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unamevalidate="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                String pwdvalidate="/^[a-z0-9]+$/i";
                if(!uname.getText().toString().matches(unamevalidate))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Email format",Toast.LENGTH_LONG).show();
                }
                if(!pwd.getText().toString().matches(pwdvalidate) && pwd.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Alphanumeric Password only",Toast.LENGTH_LONG).show();

                }


                if(pwd.getText().toString().equals(confirmpwd.getText().toString()))
                {
                    admindb.insertintoadmin(uname.getText().toString(),pwd.getText().toString());
                    Toast.makeText(getApplicationContext(), "Data Successfully Saved", Toast.LENGTH_LONG).show();
                    Intent admlogin=new Intent(getApplicationContext(),AdminLogin.class);
                    startActivity(admlogin);
                }
                else
                    Toast.makeText(getApplicationContext(),"Mismatched Password",Toast.LENGTH_LONG).show();
            }
        });

    }
}
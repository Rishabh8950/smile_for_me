package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

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
        uname=findViewById(R.id.unameadmin);
        pwd=findViewById(R.id.newadminpwdprompt);
        savebtn=findViewById(R.id.addadmin);
        confirmpwd=findViewById(R.id.newadminconfirmpwdprompt);
        admindb=new database(this,"",null,1);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pwd.getText().toString().equals(confirmpwd.getText().toString()))
                {
                    admindb.insertintoadmin(uname.getText().toString(),pwd.getText().toString());
                    Toast.makeText(getApplicationContext(), "Data Successfully Saved", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Mismatched Password",Toast.LENGTH_LONG).show();
            }
        });

    }
}
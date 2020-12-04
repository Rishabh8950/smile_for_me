package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "AdminLogin";
    Button btn;
    EditText username,pwd;
    database admindb=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Log.i(ACTIVITY_NAME,"in onCreate()");
        username=(EditText)findViewById(R.id.unameadm);
        pwd=(EditText)findViewById(R.id.admpwdprompt);
        btn=(Button)findViewById(R.id.admloginbtn);
        admindb=new database(this,"",null,1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("garg2030@mylaurier.ca")&& pwd.getText().toString().equals("R12345"))
                {
                    Intent admlogin=new Intent(getApplicationContext(),Admindashboard.class);
                    startActivity(admlogin);

                }else if(admindb.adselect(username.getText().toString(),pwd.getText().toString())==1){
                    Intent admlogin=new Intent(getApplicationContext(),Admindashboard.class);

                    startActivity(admlogin);

                }


                else
                    Toast.makeText(getApplicationContext(),"Incorrect Log_in credentials",Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }



}
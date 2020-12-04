package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smileforme.data.DonorSignUp;

public class DonorLogin extends AppCompatActivity {
    EditText user,pwd;
    Button loginbtn;
    database donordb=null;

    protected final String ACTIVITY_NAME = "DonorLogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);
        Log.i(ACTIVITY_NAME,"In onCreate()");
        user=(EditText)findViewById(R.id.unamedonor);
        pwd=(EditText)findViewById(R.id.donorpwdprompt);
        loginbtn=(Button)findViewById(R.id.donorlogin);
        donordb=new database(this,"",null,1);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(donordb.donselect(user.getText().toString(),pwd.getText().toString())==1)
                {
                    Intent uploaditem=new Intent(getApplicationContext(),Uploaditem.class);
                    startActivity(uploaditem);
                }

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

    public void donorsignup(View view) {
        Intent signup = new Intent(this, DonorSignUp.class);
        startActivity(signup);
    }
}
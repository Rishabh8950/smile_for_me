package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecipientLogin extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "RecipientLogin";
    EditText user,pwd;
    Button loginbtn;
    database recipientdb=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_login);
        Log.i(ACTIVITY_NAME, "in onCreate()");
        user=(EditText)findViewById(R.id.unamerecipient);
        pwd=(EditText)findViewById(R.id.recipientpwdprompt);
        loginbtn=(Button)findViewById(R.id.recipientlogin);
        recipientdb=new database(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((recipientdb.recselect(user.getText().toString(),pwd.getText().toString())==1)|| ((user.getText().toString().equals("recipient@gmail.com") && pwd.getText().toString().equals("R12345"))))
                {
                    Intent openlistofitems=new Intent(getApplicationContext(),Items.class);
                    startActivity(openlistofitems);

                }
                else
                    Toast.makeText(getApplicationContext(),"User not found",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    public void recipientsignup(View view) {
        Intent rsignup = new Intent(this, RecipientSignup.class);
        startActivity(rsignup);
    }
}


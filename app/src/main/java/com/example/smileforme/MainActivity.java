package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME,"in onCreate()");


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

    public void openAdmin(View view) {
        Log.i(ACTIVITY_NAME,"Go to admin page");
        Intent admin = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(admin);
    }

    public void donorlogin(View view) {
        Log.i(ACTIVITY_NAME,"Go to Donor login page");
        Intent dlogin = new Intent(this, DonorLogin.class);
        startActivity(dlogin);
    }
    public void recipientlogin(View view) {
        Log.i(ACTIVITY_NAME,"Go to recipient login page");
        Intent rlogin = new Intent(this, RecipientLogin.class);
        startActivity(rlogin);
    }
    public void openngo(View view){
        Log.i(ACTIVITY_NAME,"Go to recipient login page");
        Intent ngologin=new Intent(getApplicationContext(),Ngologin.class);
        startActivity(ngologin);

    }

}

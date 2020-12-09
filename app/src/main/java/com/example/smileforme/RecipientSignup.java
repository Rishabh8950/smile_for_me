package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RecipientSignup extends AppCompatActivity {
    protected final String ACTIVITY_NAME = "RecipientSignup";
    database recipientdb=null;
    Button signinbtn;
    EditText name,dob,mail,mobile,pwd,re_pwd,bpl;
    RadioButton male,female,other;
    String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_signup);
        Log.i(ACTIVITY_NAME, "in onCreate()");
        signinbtn=findViewById(R.id.recipientsignin);
        recipientdb=new database(this,"",null,1);
        name=findViewById(R.id.enterrecipientname);
        dob=findViewById(R.id.enterrecipientdob);
        mail=findViewById(R.id.enterrecipientemail);
        mobile=findViewById(R.id.enterrecipientmob);
        pwd=findViewById(R.id.enterrecipientpwd);
        re_pwd=findViewById(R.id.enterrecipientpass);
        bpl=findViewById(R.id.BPLcard);
        male=findViewById(R.id.rmale);
        female=findViewById(R.id.rfemale);
        other=findViewById(R.id.rother);

        if(male.isChecked())
        {
            gen=male.getText().toString();
        }
        else if(female.isChecked())
        {
            gen=female.getText().toString();
        }
        else
            gen=other.getText().toString();


        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullnamevalidation="[a-zA-Z][a-zA-Z ]{2,}";
                String dobvalidation="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
                String emailvalidation="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                String mobilevalidation="^[89][0-9]{9}";
                String pwdvalidation="/^[a-z0-9]+$/i";

                String bplvalidation="^[0-9]{10}";
                if(!name.getText().toString().matches(fullnamevalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Name",Toast.LENGTH_LONG).show();
                }
                else if(!dob.getText().toString().matches(dobvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid DOB",Toast.LENGTH_LONG).show();
                }
                else if(!mail.getText().toString().matches(emailvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid EMAIL",Toast.LENGTH_LONG).show();
                }
                else if(!mobile.getText().toString().matches(mobilevalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
                }

                else if(pwd.getText().toString().isEmpty() && !pwd.getText().toString().equals(pwdvalidation)) {
                    Toast.makeText(getApplicationContext(), "Password can contain only alphabets and numbers", Toast.LENGTH_LONG).show();
                }
                else if(!bpl.getText().toString().matches(bplvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid BPL",Toast.LENGTH_LONG).show();

                }
                else if(gen.equals(null))
                {
                    Toast.makeText(getApplicationContext(),"Please select Gender",Toast.LENGTH_LONG).show();
                }




                else if(pwd.getText().toString().equals(re_pwd.getText().toString()))
                {


                    recipientdb.insertintorecipient(name.getText().toString(),dob.getText().toString(),gen,mail.getText().toString(),mobile.getText().toString(),pwd.getText().toString(),bpl.getText().toString());
                   Toast.makeText(getApplicationContext(),"Request generated. Please wait for 24 hours",Toast.LENGTH_LONG).show();
                    Intent main=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(main);

                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Details",Toast.LENGTH_LONG).show();


                

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


}
package com.example.smileforme.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.smileforme.Items;
import com.example.smileforme.R;
import com.example.smileforme.Uploaditem;
import com.example.smileforme.database;

public class DonorSignUp extends AppCompatActivity {

    protected final String ACTIVITY_NAME = "DonorSignUp";
    database donordb=null;
    Button signinbtn;
    EditText name,dob,mail,mobile,pwd,re_pwd;
    RadioButton male,female,other;
    String gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);
        Log.i(ACTIVITY_NAME,"in onCreate()");
        donordb=new database(this,"",null,1);
        name=findViewById(R.id.enterdname);
        dob=findViewById(R.id.enterddob);
        mail=findViewById(R.id.enterdemail);
        mobile=findViewById(R.id.enterdmob);
        pwd=findViewById(R.id.enterdpwd);
        re_pwd=findViewById(R.id.enterdpass);
        signinbtn=findViewById(R.id.dsignin);
        male=findViewById(R.id.dmale);
        female=findViewById(R.id.dfemale);
        other=findViewById(R.id.dother);

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
                String pwdvalidation="/^[0-9a-zA-Z]+$/";

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
                else if(!pwd.getText().toString().matches(pwdvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Password can contain only alphabets and numbers",Toast.LENGTH_LONG).show();
                }

                else if(gen.equals(null))
                {
                    Toast.makeText(getApplicationContext(),"Please select Gender",Toast.LENGTH_LONG).show();
                }
                else if(!pwd.equals(re_pwd)){
                    Toast.makeText(getApplicationContext(),"Check password",Toast.LENGTH_LONG).show();

                }



                else if(pwd.getText().toString().equals(re_pwd))
                {


                    donordb.insertintodonor(name.getText().toString(),dob.getText().toString(),gen,mail.getText().toString(),mobile.getText().toString(),pwd.getText().toString());
                    Intent uploaditem=new Intent(getApplicationContext(), Uploaditem.class);
                    startActivity(uploaditem);

                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Details",Toast.LENGTH_LONG).show();




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
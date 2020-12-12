package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class DonorSignUp extends AppCompatActivity {

    protected final String ACTIVITY_NAME = "DonorSignUp";
    database donordb=null;
    Button signinbtn;
    EditText name,dob,mail,mobile,pwd,re_pwd;
    RadioButton male,female,other;
    String gen;
    
    String fullnamevalidation="^[A-Za-z]+\\s[A-Za-z]+$";
    String dobvalidation="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String emailvalidation="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+[.][a-zA-Z]{2,}+$";
    String mobilevalidation="^[89][0-9]{9}";
    String pwdvalidation="^[0-9a-zA-Z]+$";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);
        Log.i(ACTIVITY_NAME,"in onCreate()");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        donordb=new database(this);
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
                

                if(!validateName(name.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Name",Toast.LENGTH_LONG).show();
                }
                else if(!validateDob(dob.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid DOB",Toast.LENGTH_LONG).show();
                }
                else if(!validateMail(mail.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid EMAIL",Toast.LENGTH_LONG).show();
                }
                else if(!validateMobile(mobile.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
                }
                else if(!validatePwd(pwd.getText().toString()) || !validatePwd(re_pwd.getText().toString()) )
                {
                    Toast.makeText(getApplicationContext(),"Password can contain only alphabets and numbers",Toast.LENGTH_LONG).show();
                }

                else if(gen.equals(null))
                {
                    Toast.makeText(getApplicationContext(),"Please select Gender",Toast.LENGTH_LONG).show();
                }




                else if(!pwd.getText().toString().equals(re_pwd.getText().toString()))
                {

                	Toast.makeText(getApplicationContext(),"Both Password should Match",Toast.LENGTH_LONG).show();


                }
                else {
                	donordb.insertintodonor(name.getText().toString(),dob.getText().toString(),gen,mail.getText().toString(),mobile.getText().toString(),pwd.getText().toString());
                    Intent enter=new Intent(getApplicationContext(), donormainpage.class);
                    startActivity(enter);
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
    
    public boolean validateName(String name) {
    	if(name.matches(fullnamevalidation))
    		return true;
    	else return false;
    }
    
    public boolean validateDob(String Dob) {
    	if(Dob.matches(dobvalidation))
    		return true;
    	else return false;
    }
    
    public boolean validateMail(String mail) {
    	if(mail.matches(emailvalidation))
    		return true;
    	else return false;
    }
    
    public boolean validateMobile(String mobile) {
    	if(mobile.matches(mobilevalidation))
    		return true;
    	else return false;
    }
    
    public boolean validatePwd(String pwd) {
    	if(pwd.matches(pwdvalidation))
    		return true;
    	else return false;
    }
    
    
    
    
}
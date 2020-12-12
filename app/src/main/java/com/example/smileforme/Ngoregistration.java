package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ngoregistration extends AppCompatActivity {
    EditText ngoname,ngoid,email,mobile,pwd,ngodetails,repwd;
    database ngodb=null;
    Button register;

    String fullnamevalidation="^[A-Za-z]+\\s[A-Za-z]+$";
    String emailvalidation="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+[.][a-zA-Z]{2,}+$";
    String mobilevalidation="^[89][0-9]{9}";
    String pwdvalidation="^[0-9a-zA-Z]+$";
    String ngoidvalidation="^[0-9]{10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoregistration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ngoname=(EditText)findViewById(R.id.enterngoname);
        ngoid=(EditText)findViewById(R.id.enterngoid);
        email=(EditText)findViewById(R.id.enterngoemail);
        mobile=(EditText)findViewById(R.id.enterngomob);
        pwd=(EditText)findViewById(R.id.enterngopwd);
        repwd=(EditText)findViewById(R.id.enterngopass);
        ngodetails=(EditText)findViewById(R.id.ngodetails);
        register=(Button)findViewById(R.id.ngosignin);

        ngodb=new database(this);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateName(ngoname.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Name",Toast.LENGTH_LONG).show();
                }
                else if(!validateMail(email.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid EMAIL",Toast.LENGTH_LONG).show();
                }
                else if(!validateMobile(mobile.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
                }
                else if(!validatePwd(pwd.getText().toString()) || !validatePwd(repwd.getText().toString()) )
                {
                    Toast.makeText(getApplicationContext(),"Password can contain only alphabets and numbers",Toast.LENGTH_LONG).show();
                }
                else if(!validateNgoId(ngoid.getText().toString()) || ngodb.ngoidvalidation(ngoid.getText().toString())==1)
                {
                    Toast.makeText(getApplicationContext(),"Invalid ID",Toast.LENGTH_LONG).show();

                }
            /*    else if(!ngodetails.getText().toString().matches(ngodetailsvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Type",Toast.LENGTH_LONG).show();
                }*/
                else if(!pwd.getText().toString().equals(repwd.getText().toString()))
                {

                    Toast.makeText(getApplicationContext(),"Both Password should Match",Toast.LENGTH_LONG).show();

                }
                else {
                    ngodb.insertintongo(ngoname.getText().toString(),ngoid.getText().toString(),email.getText().toString(),mobile.getText().toString(),pwd.getText().toString(),ngodetails.getText().toString());
                    Toast.makeText(getApplicationContext(),"Request generated. Please wait for 24 hours",Toast.LENGTH_LONG).show();
                    Intent main=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(main);
                }


            }
        });

    }
    public boolean validateName(String name) {
        if(name.matches(fullnamevalidation))
            return true;
        else return false;
    }

    public boolean validateNgoId(String Id) {
        if(Id.matches(ngoidvalidation))
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
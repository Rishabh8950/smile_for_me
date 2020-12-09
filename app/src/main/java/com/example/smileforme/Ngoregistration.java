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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoregistration);
        ngoname=(EditText)findViewById(R.id.enterngoname);
        ngoid=(EditText)findViewById(R.id.enterngoid);
        email=(EditText)findViewById(R.id.enterngoemail);
        mobile=(EditText)findViewById(R.id.enterngomob);
        pwd=(EditText)findViewById(R.id.enterngopwd);
        repwd=(EditText)findViewById(R.id.enterngopass);
        ngodetails=(EditText)findViewById(R.id.ngodetails);
        register=(Button)findViewById(R.id.ngosignin);

        ngodb=new database(this,"",null,1);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullnamevalidation="[a-zA-Z][a-zA-Z ]{2,}";
                String emailvalidation="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                String mobilevalidation="^[89][0-9]{9}";
                String pwdvalidation="/^[a-z0-9]+$/i";
                String idvalidation="^[0-9]{10}";
             //   String ngodetailsvalidation="[a-zA-Z][a-zA-Z ][a-zA-Z ]{3,}";

                if(!ngoname.getText().toString().matches(fullnamevalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Name",Toast.LENGTH_LONG).show();
                }
                else if(!email.getText().toString().matches(emailvalidation))
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
                else if(!ngoid.getText().toString().matches(idvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid ID",Toast.LENGTH_LONG).show();

                }
            /*    else if(!ngodetails.getText().toString().matches(ngodetailsvalidation))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Type",Toast.LENGTH_LONG).show();
                }*/
                else if(pwd.getText().toString().equals(repwd.getText().toString()))
                {


                    ngodb.insertintongo(ngoname.getText().toString(),ngoid.getText().toString(),email.getText().toString(),mobile.getText().toString(),pwd.getText().toString(),ngodetails.getText().toString());
                    Toast.makeText(getApplicationContext(),"Request generated. Please wait for 24 hours",Toast.LENGTH_LONG).show();
                    Intent main=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(main);


                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Details",Toast.LENGTH_LONG).show();

            }
        });


    }

}
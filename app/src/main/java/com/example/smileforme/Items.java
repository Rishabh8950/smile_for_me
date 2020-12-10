package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Items extends AppCompatActivity {
    EditText itemid,bpl;
    TextView viewitems;
    Button accept,viewdetaill,openlist;
    database itemdb=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        itemid=(EditText) findViewById(R.id.itemidverification);
        bpl=(EditText)findViewById(R.id.enterbplrec);
        openlist=(Button) findViewById(R.id.viewitemsbtn);
        accept=(Button)findViewById(R.id.acceptbtn);
        viewdetaill=(Button)findViewById(R.id.viewbtn);
        viewitems=(TextView) findViewById(R.id.productslist);
        itemdb=new database(this,"",null,1);

        openlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    itemdb.viewallitems(viewitems);
                    Toast.makeText(getApplicationContext(), "list", Toast.LENGTH_LONG).show();


            }
        });
        viewdetaill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemdb.viewselecteditem(viewitems,bpl.getText().toString());


            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 {
                     if(itemdb.recipientvalidationfordonation(bpl.getText().toString())==1) {
                         itemdb.acceptitem(bpl.getText().toString(), itemid.getText().toString());
                         Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_LONG).show();
                         Intent refresh=new Intent(getApplicationContext(),Items.class);
                         startActivity(refresh);
                     }

                     else
                         Toast.makeText(getApplicationContext(),"check details",Toast.LENGTH_LONG).show();
                }

            }
        });






    }
}
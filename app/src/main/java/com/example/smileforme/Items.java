package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Items extends AppCompatActivity {
    EditText itemid,bpl;
    TextView viewitems;
    Button accept,viewdetail,openlist;
    database itemdb=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        itemid=(EditText) findViewById(R.id.itemidverification);
        bpl=(EditText)findViewById(R.id.enterbplrec);
        openlist=(Button) findViewById(R.id.viewitemsbtn);
        accept=(Button)findViewById(R.id.acceptbtn);
        viewdetail=(Button)findViewById(R.id.viewbtn);
        viewitems=(TextView) findViewById(R.id.productslist);
        itemdb=new database(this,"",null,1);

        viewitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemdb.viewallitems(viewitems);
            }
        });
        viewdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemdb.viewselecteditem(viewdetail,bpl.getText().toString());
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemdb.acceptitem(bpl.getText().toString());
            }
        });






    }
}
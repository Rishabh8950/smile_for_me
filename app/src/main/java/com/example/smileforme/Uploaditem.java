package com.example.smileforme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.provider.MediaStore.Images.Media.getBitmap;

public class Uploaditem extends AppCompatActivity {
    private static final String TEMP_IMAGE ="" ;
    EditText mob,itemtype,itemdetails;
    database itemsdb=null;
    Button uploadbtn,imgupload;



            @Override
            protected void onCreate (Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_uploaditem);

                mob = (EditText) findViewById(R.id.enterdmob);
                uploadbtn = (Button) findViewById(R.id.uploaditembtn);
                itemdetails = (EditText) findViewById(R.id.enterproductdetails);
                itemtype = (EditText) findViewById(R.id.enterproducttype);
                imgupload = (Button) findViewById(R.id.imgupload);

                itemsdb = new database(this, "", null, 1);

                imgupload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            openFileOutput(TEMP_IMAGE, MODE_WORLD_WRITEABLE).close();
                         //   tempImageUri = Uri.fromFile(getFileStreamPath(TEMP_IMAGE));
                            String tempImageUri="";
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, tempImageUri);
                          //  startActivityForResult(intent, TAKE_SNAPSHOT);

                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(getApplicationContext(), "No camera app found!", Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), "Unable to write file on internal storage", Toast.LENGTH_LONG).show();
                        }


                    }
                });


                uploadbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemsdb.insertintoitems(itemtype.getText().toString(), itemdetails.getText().toString(), mob.getText().toString());

                    }
                });


            }

        }
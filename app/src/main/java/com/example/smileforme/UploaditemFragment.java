package com.example.smileforme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploaditemFragment extends Fragment {

    private static final String ACTIVITY_NAME="UploaditemFragment.java";
    EditText mob,itemtype,itemdetails,itemsno;
    database itemsdb=null;
    Button uploadbtn,imgupload;

    String mobilevalidation="^[89][0-9]{9}";
    String itemtypevalidation="^[A-Za-z]+$";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME,"in oncreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uploaditem, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mob = view.findViewById(R.id.dphone);
        uploadbtn = view.findViewById(R.id.uploaditembtn);
        itemdetails = view.findViewById(R.id.enterproductdetails);
        itemtype = view.findViewById(R.id.enterproducttype);
       // imgupload = view.findViewById(R.id.imgupload);
        itemsno = view.findViewById(R.id.itemcount);

        itemsdb = new database(getContext());

       /* imgupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //openFileOutput(TEMP_IMAGE, MODE_WORLD_WRITEABLE).close();
                    //   tempImageUri = Uri.fromFile(getFileStreamPath(TEMP_IMAGE));
                    String tempImageUri="";
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, tempImageUri);
                    //  startActivityForResult(intent, TAKE_SNAPSHOT);

                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "No camera app found!", Toast.LENGTH_LONG).show();
                } //catch (IOException e) {
                    //Toast.makeText(getContext(), "Unable to write file on internal storage", Toast.LENGTH_LONG).show();
                //}


            }
        }); */
        Log.i(ACTIVITY_NAME,"in onViewCreated()");

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME,"clicked on upload item");
                if(!validateMobile(mob.getText().toString()))
                {
                    Toast.makeText(getContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
                }
                else if(itemtype.equals(null) || !validateItemType(itemtype.getText().toString()))
                {
                    Toast.makeText(getContext(),"Invalid Item Type",Toast.LENGTH_LONG).show();
                }
                else if(itemdetails.equals(null))
                {
                    Toast.makeText(getContext(),"Please Enter Item Details",Toast.LENGTH_LONG).show();
                }
                else {
                    itemsdb.insertintoitems(itemtype.getText().toString(), itemdetails.getText().toString(), Integer.parseInt(itemsno.getText().toString()),
                            mob.getText().toString());
                Toast.makeText(getContext(),"Item uploaded",Toast.LENGTH_LONG).show();
                Intent home=new Intent(getContext(),donormainpage.class);
                startActivity(home);
                }
            }
        });


    }

    private boolean validateMobile(String mobile) {
            if(mobile.matches(mobilevalidation))
                return true;
            else return false;
        }
        private boolean validateItemType(String itemType) {
            if(itemType.matches(itemtypevalidation))
                return true;
            else return false;
        }


    }
package com.example.smileforme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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

    private static final String TEMP_IMAGE ="" ;
    EditText mob,itemtype,itemdetails;
    database itemsdb=null;
    Button uploadbtn,imgupload;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uploaditem, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mob = view.findViewById(R.id.enterdmob);
        uploadbtn = view.findViewById(R.id.uploaditembtn);
        itemdetails = view.findViewById(R.id.enterproductdetails);
        itemtype = view.findViewById(R.id.enterproducttype);
        imgupload = view.findViewById(R.id.imgupload);

        itemsdb = new database(getContext(), "", null, 1);

        imgupload.setOnClickListener(new View.OnClickListener() {
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
        });


        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsdb.insertintoitems(itemtype.getText().toString(), itemdetails.getText().toString(), mob.getText().toString());

            }
        });


    }

}
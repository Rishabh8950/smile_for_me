package com.example.smileforme;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NgolistFragment extends Fragment {

//    EditText contact;
//    Button pay,viewlist;
//    database ngodb;
//    RecyclerView listofngos;
//    NgoCustomAdapter ngoadapter;
//    ArrayList<String> ngoname, ngotype;
//    ArrayList<Integer> ngoid;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_ngolist, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
////        contact=view.findViewById(R.id.ngonumber);
////        pay=view.findViewById(R.id.ngopaybtn);
////        viewlist=view.findViewById(R.id.ngolistbtn);
//        ngodb= new database(getContext());
//        listofngos=view.findViewById(R.id.ngorecycler);
//
//        ngoname = new ArrayList<>();
//        ngotype = new ArrayList<>();
//        ngoid = new ArrayList<>();
//
//        storingNgoList();
//        ngoadapter = new NgoCustomAdapter(getContext(), ngoname, ngoid, ngotype);
//        listofngos.setAdapter(ngoadapter);
//        listofngos.setLayoutManager(new LinearLayoutManager(getContext()));
//
////        pay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if(ngodb.ngocontactvalidation(contact.getText().toString())==1)
////                {
////                    String url="http://m.p-y.tm";
////
////
////
////                    Intent pay=new Intent(Intent.ACTION_VIEW);
////                    pay.setData(Uri.parse(url));
////                    startActivity(pay);
////                }
////                else
////                    Toast.makeText(getContext(),"Check Number",Toast.LENGTH_LONG).show();
////            }
////        });
//
//    }
//
//    private void storingNgoList() {
//        Cursor cursor = ngodb.viewngolist();
//        if(cursor.getCount() == 0){
//            Toast.makeText(getContext(), "No list available", Toast.LENGTH_LONG).show();
//        }
//        else{
//            while(cursor.moveToNext()){
//                ngoname.add(cursor.getString(1));
//                ngoid.add(cursor.getInt(2));
//                ngotype.add(cursor.getString(6));
//            }
//        }
//    }
}
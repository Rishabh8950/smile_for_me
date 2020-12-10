package com.example.smileforme;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DonorDBFragment extends Fragment {

    Button clothes,food,others,ngo;
    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_db, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        clothes = view.findViewById(R.id.clothes);
        food = view.findViewById(R.id.food);
        others = view.findViewById(R.id.others);
        ngo = view.findViewById(R.id.payngo);

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent cloth = new Intent(getContext(), Uploaditem.class);
                //startActivity(cloth);
                fragment = new UploaditemFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.donormain, fragment).addToBackStack(null);
                ft.commit();
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent food = new Intent(getContext(), Uploaditem.class);
                //startActivity(food);
                fragment = new UploaditemFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.donormain, fragment).addToBackStack(null);
                ft.commit();
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent other = new Intent(getContext(), Uploaditem.class);
                //startActivity(other);
                fragment = new UploaditemFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.donormain, fragment).addToBackStack(null);
                ft.commit();
            }
        });
        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ngo = new Intent(getContext(), ngolistactivity.class);
                startActivity(ngo);
//                fragment = new NgolistFragment();
//                fm = getFragmentManager();
//                ft = fm.beginTransaction();
//                ft.replace(R.id.donormain, fragment).addToBackStack(null);
//                ft.commit();
            }
        });
    }

}
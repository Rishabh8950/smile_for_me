package com.example.smileforme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class donormainpage extends AppCompatActivity {


    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donormainpage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment = new DonorDBFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.donormain, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.donor_toolbar, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch(id) {
            case R.id.action_one:
                Intent home = new Intent(donormainpage.this, donormainpage.class);
                startActivity(home);
                break;

            case R.id.action_two://need to change this after donationslist fragment is created
                fragment = new DonorDBFragment();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.donormain, fragment).addToBackStack(null);
                ft.commit();
                break;

            case R.id.action_three:
                AlertDialog.Builder feedbackalert = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                final View v = inflater.inflate(R.layout.feedback_layout, null);
                feedbackalert.setView(v)
                        .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //on clicking cancel it stays on the same page
                            }
                        });
                feedbackalert.create().show();
                break;

            case R.id.action_four:
                fragment = new AboutusFragment();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.donormain, fragment).addToBackStack(null);
                ft.commit();
                break;

            case R.id.action_five:
                Intent ngolist = new Intent(donormainpage.this, ngolistactivity.class);
                startActivity(ngolist);
                break;
        }
        return true;
    }

}
package com.example.himshikha.bloodo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.content.res.Resources;
import android.widget.EditText;

import com.example.himshikha.bloodo.models.DonorDetailModel;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db1;
    String bloodgrp,address;
    EditText loc,blood;
    //private DonorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();

        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        openHelper=new DatabaseHelper(this);
//
//        Cursor cursor=db.showData();
//        db1=db.getWritableDatabase();
//        RecyclerView recyclerView=findViewById(R.id.donor_list);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter=new DonorAdapter(this,cursor);
//        recyclerView.setAdapter(adapter);

        loc=(EditText)findViewById(R.id.searchLoc);
        blood=(EditText)findViewById(R.id.searchBlood);


        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        Button btn1,btn2,btn3,btn4,btn5,btn6;

        //opens register activity
        btn1=( Button)findViewById(R.id.Register);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,register.class);
                startActivity(i);
            }
        });

        //opens set donation activity
        btn2=( Button)findViewById(R.id.Setup);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,setdonation.class);
                startActivity(i1);
            }
        });


        //Language translator
        btn3=(Button)findViewById(R.id.changelang);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showChangeLanguageDialog();

            }
        });

        //Shows donor list
        btn4=(Button)findViewById(R.id.showDonor);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=db.showData();
                if(cursor.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;

                }


                StringBuffer buffer=new StringBuffer();
                while(cursor.moveToNext()){
                    buffer.append("ID: "+ cursor.getString(0)+"\n");
                    buffer.append("Name: "+ cursor.getString(1)+"\n");
                    buffer.append("Phone: "+ cursor.getString(2)+"\n");
                    buffer.append("Email: "+ cursor.getString(3)+"\n");
                    buffer.append("Password: "+ cursor.getString(4)+"\n");
                    buffer.append("Address: "+ cursor.getString(5)+"\n");
                    buffer.append("Blood Group: "+ cursor.getString(6)+"\n");



                }

                showMessage("Data",buffer.toString());
            }
        });

        //Search for required blood
        btn5=(Button)findViewById(R.id.searchBox);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor=db.searchData(loc.getText().toString(), blood.getText().toString());
                String address = loc.getText().toString();
                String bloodGroup = blood.getText().toString();
                if(cursor.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
               // DonorDetailModel donor = new DonorDetailModel();

                while(cursor.moveToNext()){
                    buffer.append("ID: "+ cursor.getString(0)+"\n");
                    buffer.append("Name: "+ cursor.getString(1)+"\n");
                    buffer.append("Phone: "+ cursor.getString(2)+"\n");
                    buffer.append("Email: "+ cursor.getString(3)+"\n");
                    buffer.append("Password: "+ cursor.getString(4)+"\n");
                    buffer.append("Address: "+ cursor.getString(5)+"\n");
                    buffer.append("Blood Group: "+ cursor.getString(6)+"\n");


                    /*donor.setId(cursor.getString(0));
                    donor.setName(cursor.getString(1));
                    donor.setPhone(cursor.getString(2));
                    donor.setEmail(cursor.getString(3));
                    donor.setPassword(cursor.getString(4));
                    donor.setAddress(cursor.getString(5));
                    donor.setBloodGroup(cursor.getString(6));*/

                }

                showMessage("Search Result",buffer.toString());
                //showMessage(donor);

            }
        });
        //show blood banks

        btn6=(Button)findViewById(R.id.showBloodBank);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,bloodBanks.class);
                startActivity(intent);
            }
        });

    }

//    private void showMessage(DonorDetailModel donor) {
//        Intent intent = new Intent(this, DonorDetails.class);
//        //intent.putExtra("donor", donor);
//        startActivity(intent);
//    }


    //above called method to change language
    private void showChangeLanguageDialog(){

        final String[] listItems= {"नेपाली","English","French"};
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0){
                    setLocale("ne");
                    recreate();
                }
                else if(i==1){
                    setLocale("en");
                    recreate();
                }
                else if(i==2){
                    setLocale("fr");
                    recreate();
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog=mBuilder.create();
        mDialog.show();

    }


    private void setLocale(String lang){

        Locale locale=new Locale(lang);
        Locale.setDefault(locale);

        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();

    }

     public void loadLocale(){
        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }

    //called method to show donor list
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

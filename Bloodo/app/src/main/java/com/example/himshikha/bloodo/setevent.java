package com.example.himshikha.bloodo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setevent extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View myview=inflater.inflate(R.layout.setevent, container,false);
        return myview;
    }

    /*SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg1;
    EditText _time,_date,_location;
    String enterTime,enterDate,enterLoc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        openHelper=new database(this);


        _date=(EditText)findViewById(R.id.enterDate);
        _time=(EditText)findViewById(R.id.enterTime);
        _location=(EditText)findViewById(R.id.enterPlace);

        _btnreg1=(Button)findViewById(R.id.register2);
        _btnreg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db=openHelper.getWritableDatabase();
                String enterDate=_date.getText().toString();
                String enterTime=_time.getText().toString();
                String enterLoc=_location.getText().toString();
                insertdata(enterDate,enterTime,enterLoc);
                Toast.makeText(getApplicationContext(),"Registered Sucessfully",Toast.LENGTH_LONG).show();


            }*/





}

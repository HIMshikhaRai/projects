package com.example.himshikha.bloodo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;

public class setdonation extends AppCompatActivity {

    SQLiteOpenHelper openHelper1;
    SQLiteDatabase db1;
    Button _btnreg1, _btnevent;
    EditText _txtdate,_txttime,_txtlocation;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setdonation);

        db=new DatabaseHelper(this);
        openHelper1=new DatabaseHelper(this);

        _btnreg1 =(Button)findViewById(R.id.register);
        _txtdate=(EditText)findViewById(R.id.enterDate);
        _txttime=(EditText)findViewById(R.id.enterTime);
        _txtlocation=(EditText)findViewById(R.id.enterPlace);


        _btnreg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db1=openHelper1.getWritableDatabase();

                String date=_txtdate.getText().toString();
                String time=_txttime.getText().toString();
                String location=_txtlocation.getText().toString();

                insertdata(date, time, location);

                Toast.makeText(getApplicationContext(), " Successfully", Toast.LENGTH_SHORT).show();


            }
        });

        _btnevent=(Button)findViewById(R.id.Donationevent);
        _btnevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor=db.showDonationEvent();
                if(cursor.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;

                }


                StringBuffer buffer=new StringBuffer();
                while(cursor.moveToNext()){

                    buffer.append("ID: "+ cursor.getString(0)+"\n");
                    buffer.append("Date: "+ cursor.getString(1)+"\n");
                    buffer.append("Time: "+ cursor.getString(2)+"\n");
                    buffer.append("Location: "+ cursor.getString(3)+"\n");


                }

                showMessage("Donation Events",buffer.toString());

            }
        });

    }

    public void insertdata(String date,String time,String location){

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COLM_2,date);
        contentValues.put(DatabaseHelper.COLM_3,time);
        contentValues.put(DatabaseHelper.COLM_4,location);


        long id=db1.insert(DatabaseHelper.TABLE_NAME1,null,contentValues);


    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

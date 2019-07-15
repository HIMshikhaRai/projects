package com.example.himshikha.bloodo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class register extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg,btnlogin;
    EditText _txtname,_txtphone,_txtemail,_txtpassword,_txtaddress,_txtblood;
    private String enterName, enterPhone,enterEmail,enterPassword,enterAddress,enterBloodGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper=new DatabaseHelper(this);

        _btnreg =(Button)findViewById(R.id.button);
        _txtname=(EditText)findViewById(R.id.enterName);
        _txtphone=(EditText)findViewById(R.id.enterPhone);
        _txtemail=(EditText)findViewById(R.id.enterEmail);
        _txtpassword=(EditText)findViewById(R.id.enterPassword);
        _txtaddress=(EditText)findViewById(R.id.enterAddress);
        _txtblood=(EditText)findViewById(R.id.enterBloodGroup);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();



                register();
                //insertdata(name,phone,email,password,address,bloodgrp);


            }



            private void register() {
                initialize();
                if(!validate()){
                    Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
                }
                else{

                    String enterName=_txtname.getText().toString();
                    String enterPhone=_txtphone.getText().toString();
                    String enterEmail=_txtemail.getText().toString();
                    String enterPassword=_txtpassword.getText().toString();
                    String enterAddress=_txtaddress.getText().toString();
                    String enterBloodGroup=_txtblood.getText().toString();

                    insertdata(enterName,enterPhone,enterEmail,enterPassword,enterAddress,enterBloodGroup);
                    onRegisterSuccess();
                }

            }

            private boolean validate() {
                boolean valid=true;
                if(enterName.isEmpty()||_txtname.length()>32){
                    _txtname.setError("Please Enter valid first name");
                    valid=false;
                }
                if(enterPhone.isEmpty()||_txtphone.length()>32){
                    _txtphone.setError("Please Enter valid number");
                    valid=false;
                }

                if(enterEmail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(enterEmail).matches()){
                    _txtemail.setError("Please Enter valid email");
                    valid=false;
                }
                if(enterPassword.isEmpty()||_txtpassword.length()>32){
                    _txtpassword.setError("Please Enter valid password");
                    valid=false;
                }
                if(enterAddress.isEmpty()||_txtaddress.length()>32){
                    _txtaddress.setError("Please Enter valid address");
                    valid=false;
                }
                if(enterBloodGroup.isEmpty()||_txtblood.length()>3){
                    _txtblood.setError("Please Enter valid address");
                    valid=false;
                }
                return valid;
            }

            private void onRegisterSuccess() {

                Toast.makeText(getApplicationContext(), "Registered Successfully  " , Toast.LENGTH_SHORT).show();

            }

            private void initialize() {
                enterName = _txtname.getText().toString().trim();
                enterPhone = _txtphone.getText().toString().trim();
                enterEmail = _txtemail.getText().toString().trim();
                enterPassword = _txtpassword.getText().toString().trim();
                enterAddress = _txtaddress.getText().toString().trim();
                enterBloodGroup=_txtblood.getText().toString().trim();

            }

        });




        btnlogin=(Button)findViewById(R.id.button3);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(register.this,Login.class);
                startActivity(i);

            }
        });

    }

    public void insertdata(String name,String phone,String email,String password,String address,String bloodgrp){

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,name);
        contentValues.put(DatabaseHelper.COL_3,phone);
        contentValues.put(DatabaseHelper.COL_4,email);
        contentValues.put(DatabaseHelper.COL_5,password);
        contentValues.put(DatabaseHelper.COL_6,address);
        contentValues.put(DatabaseHelper.COL_7,bloodgrp);

        long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }

}

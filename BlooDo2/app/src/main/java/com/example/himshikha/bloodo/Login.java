package com.example.himshikha.bloodo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnlogin;
    EditText _txtemail,_txtpass;

    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper =new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        _btnlogin=(Button)findViewById(R.id.button2);
        _txtemail=(EditText)findViewById(R.id.enterEmail2);
        _txtpass=(EditText)findViewById(R.id.enterPassword2);


        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=_txtemail.getText().toString();
                String pass=_txtpass.getText().toString();

                cursor =db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE "
                        +DatabaseHelper.COL_4 + " =? AND " + DatabaseHelper.COL_5+ " =?",new String[]{email,pass});
                if(cursor!=null){
                    if(cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(),"Login Sucessfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Login.this,YourData.class);
                        startActivity(intent);
                    }

                    else{
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}

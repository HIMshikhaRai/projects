package com.example.himshikha.bloodo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Patterns;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

public class Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    /*SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtname, _txtphn,_txtemail,_txtpass,_txtaddress,_txtGroup;
    String enterName,enterPhone,enterPassword,enterEmail,enterAddress,enterBloodGroup;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        /*openHelper=new database(this);


        _txtname=(EditText)findViewById(R.id.enterName);
        _txtphn=(EditText)findViewById(R.id.enterPhone);
        _txtemail=(EditText)findViewById(R.id.enterEmail);
        _txtpass=(EditText)findViewById(R.id.enterPassword);
        _txtaddress=(EditText)findViewById(R.id.enterAddress);
        _txtGroup=(EditText)findViewById(R.id.enterBloodGroup);




        _btnreg=(Button)findViewById(R.id.button);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db=openHelper.getWritableDatabase();
                String enterName=_txtname.getText().toString();
                String enterPhone=_txtphn.getText().toString();
                String enterEmail=_txtemail.getText().toString();
                String enterPassword=_txtpass.getText().toString();
                String enterAddress=_txtaddress.getText().toString();
                String enterBloodGroup=_txtGroup.getText().toString();
                insertdata(enterName,enterPhone,enterEmail,enterPassword,enterAddress,enterBloodGroup);
                Toast.makeText(getApplicationContext(),"Registered Sucessfully",Toast.LENGTH_LONG).show();

              //  register();
            }

           /* private void register() {
                initialize();
                if(!validate()){
                    //Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show();
                }
                else{
                    onRegisterSuccess();
                }

            }

            private boolean validate() {
                boolean valid=true;

                if(enterName.isEmpty()||_txtname.length()>32){
                    _txtname.setError("Please Enter valid name");
                    valid=false;
                }
                if(enterPhone.isEmpty()||_txtphn.length()>32){
                    _txtphn.setError("Please Enter valid number");
                    valid=false;
                }

                if(enterEmail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(enterEmail).matches()){
                    _txtemail.setError("Please Enter valid email");
                    valid=false;
                }
                if(enterPassword.isEmpty()||_txtpass.length()>32){
                    _txtpass.setError("Please Enter valid password");
                    valid=false;
                }

                if(enterAddress.isEmpty()||_txtaddress.length()>32){
                    _txtaddress.setError("Please Enter valid address");
                    valid=false;
                }
                if(enterBloodGroup.isEmpty()||_txtGroup.length()>3){
                    _txtGroup.setError("Please Enter valid Blood Group");
                    valid=false;
                }
                return valid;
            }

            private void onRegisterSuccess() {

            }

            private void initialize() {
                enterName = _txtname.getText().toString().trim();
                enterPhone = _txtphn.getText().toString().trim();
                enterEmail = _txtemail.getText().toString().trim();
                enterPassword = _txtpass.getText().toString().trim();
                enterAddress=_txtaddress.getText().toString().trim();
                enterBloodGroup=_txtGroup.getText().toString().trim();

            }
        });*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_reg) {

             register r=new register();

            FragmentManager fm=getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.nav,r, r.getTag()).commit();
            Toast.makeText(this, "register", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_event) {

            setevent sv=new setevent();

            FragmentManager fm=getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.nav,sv, sv.getTag()).commit();
            Toast.makeText(this, "setevent", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_Lang) {
            fragment f=new fragment();

            FragmentManager fm=getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.nav,f, f.getTag()).commit();
            Toast.makeText(this, "fragment", Toast.LENGTH_LONG).show();

        }
        else if(id==R.id.nav_Login){


        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
     String text=parent.getItemAtPosition(position).toString();
     Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

   /* public void insertdata(String enterName,String enterPhone,String enterEmail,String enterPassword,String enterAddress,String enterBloodGroup){
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.COL_1,enterName);
        contentValues.put(database.COL_2,enterPhone);
        contentValues.put(database.COL_3,enterEmail);
        contentValues.put(database.COL_4,enterPassword);
        contentValues.put(database.COL_5,enterAddress);
        contentValues.put(database.COL_6,enterBloodGroup);
        long id=db.insert(database.TABLE_NAME,null,contentValues);
    }*/


}

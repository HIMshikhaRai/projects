package com.example.himshikha.bloodo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteOpenHelper openHelper;

    public static final String DATABASE_NAME = "sqlitedatabase.db";


    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Phone";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "Address";
    public static final String COL_7 = "BloodGroup";


    public static final String TABLE_NAME1 = "donation";
    public static final String COLM_1 = "ID";
    public static final String COLM_2 = "Date";
    public static final String COLM_3 = "Time";
    public static final String COLM_4 = "Location";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT,Phone TEXT,Email TEXT,Password TEXT,Address TEXT,BloodGroup TEXT )");

        db.execSQL("CREATE TABLE " +TABLE_NAME1+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Date TEXT,Time TEXT,Location TEXT)") ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        onCreate(db);

    }


    public Cursor showData() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT * FROM " + TABLE_NAME ,null );
        return cursor;

    }

    public Cursor searchData( String loc, String blood){
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "SELECT * FROM register WHERE Address = \"" + loc +"\" OR BloodGroup = \""+ blood +"\"";
        Cursor cursor1=db.rawQuery(query, null);
        return cursor1;
    }

    public Cursor showDonationEvent() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT * FROM " + TABLE_NAME1 ,null );
        return cursor;

    }


}

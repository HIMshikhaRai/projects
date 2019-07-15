package com.example.himshikha.bloodo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="Name";
    public static final String COL_2="Phone";
    public static final String COL_3="Email";
    public static final String COL_4="Password";
    public static final String COL_5="Address";
    public static final String COL_6="BloodGroup";

    public static final String DATABASE_NAME1="register.db";
    public static final String TABLE_NAME1="register";
    public static final String COLM_1="Date";
    public static final String COLM_2="Time";
    public static final String COLM_3="Location";


    public database(Nav context) {
        super(context, DATABASE_NAME , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE " +TABLE_NAME+ "(Name TEXT,Phone TEXT, Email TEXT,Password TEXT,Address TEXT,BloodGroup TEXT)") ;

        db.execSQL("CREATE TABLE " +TABLE_NAME1+ "(Date TEXT,Time TEXT,Location TEXT)") ;



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);

        onCreate(db);


    }
}

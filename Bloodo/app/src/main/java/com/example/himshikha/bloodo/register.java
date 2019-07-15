package com.example.himshikha.bloodo;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Fragment{

//    database db=new database((Nav) getActivity());
//
//    private int group1;
//    public static final String ARG_PAGE= "ARG_PAGE";
//
//    private int mPage;
//
//    public static register newInstance(int page){
//        Bundle args=new Bundle();
//        args.putInt(ARG_PAGE, page);
//        register fragment=new register();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        mPage=getArguments().getInt(ARG_PAGE);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
     View myview=inflater.inflate(R.layout.register, container,false);

     return myview;
    }




}

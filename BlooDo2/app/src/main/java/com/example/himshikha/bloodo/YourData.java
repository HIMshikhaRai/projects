package com.example.himshikha.bloodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.view.View;


public class YourData extends AppCompatActivity {

    TextView name,phone,email,password,address,bloodgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_data);

    }
}

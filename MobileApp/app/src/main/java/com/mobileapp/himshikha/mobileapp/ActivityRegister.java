package com.mobileapp.himshikha.mobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Button;


import static android.widget.Toast.LENGTH_SHORT;


public class ActivityRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText f_name, l_name, phone, password, address,email;
    private String enterFirstName, enterSecondName,enterPhn,enterpass,enterMail,enterAddress;
    Button regBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        f_name= (EditText) findViewById(R.id.enterFirstName);
        l_name= (EditText) findViewById(R.id.enterSecondName);
        phone= (EditText) findViewById(R.id.enterNum);
        email= (EditText) findViewById(R.id.enterEmail);
        password= (EditText) findViewById(R.id.enterPassword);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerGrp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, array.group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        address= (EditText) findViewById(R.id.enterAddress);
        regBtn=(Button) findViewById(R.id.newBtn2);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }

            private void register() {
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
                if(enterFirstName.isEmpty()||f_name.length()>32){
                 f_name.setError("Please Enter valid first name");
                 valid=false;
                }
                if(enterSecondName.isEmpty()||l_name.length()>32){
                    l_name.setError("Please Enter valid second name");
                    valid=false;
                }
                if(enterPhn.isEmpty()||phone.length()>32){
                    phone.setError("Please Enter valid number");
                    valid=false;
                }

                    if(enterMail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(enterMail).matches()){
                    email.setError("Please Enter valid email");
                    valid=false;
                    }
                if(enterpass.isEmpty()||password.length()>32){
                    password.setError("Please Enter valid password");
                    valid=false;
                }
                if(enterAddress.isEmpty()||address.length()>32){
                    address.setError("Please Enter valid address");
                    valid=false;
                }
                    return valid;
            }

            private void onRegisterSuccess() {

            }

            private void initialize() {
                enterFirstName = f_name.getText().toString().trim();
                enterSecondName = l_name.getText().toString().trim();
                enterPhn = phone.getText().toString().trim();
                enterMail = email.getText().toString().trim();
                enterpass = password.getText().toString().trim();
                enterAddress=address.getText().toString().trim();

            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(),text, LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

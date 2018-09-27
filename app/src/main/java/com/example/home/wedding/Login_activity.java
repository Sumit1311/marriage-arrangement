package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);



        Button btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usnm=(EditText)findViewById(R.id.usnm);
                String unm=usnm.getText().toString();
                EditText pwd=(EditText)findViewById(R.id.pwd);
                String pwdadmin=pwd.getText().toString();

               // if(unm.equals("Admin") && pwdadmin.equals("Admin"))
                //{
                    Intent i1=new Intent(getApplicationContext(),admin_main.class);
                    startActivity(i1);
                //}
                //else
                  //  Toast.makeText(getApplicationContext(),"Please Enter Valid Username and Password",Toast.LENGTH_LONG).show();

            }
        });
    }
}

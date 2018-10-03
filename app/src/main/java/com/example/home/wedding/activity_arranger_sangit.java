package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_arranger_sangit extends AppCompatActivity {
    Button btn1,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arranger_sangit);
        getSupportActionBar().setTitle("Transport Arranger");

        btn1=(Button)findViewById(R.id.btn_add_sangit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_sangit_upload.class);
                startActivity(i);
            }
        });
        btn3=(Button)findViewById(R.id.btn_view_sangit);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i);
            }
        });
        btn4=(Button)findViewById(R.id.btn_add_participants);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_participants_upload.class);
                startActivity(i);
            }
        });

        btn6=(Button)findViewById(R.id.btn_view_participants);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i);

            }
        });

    }
}

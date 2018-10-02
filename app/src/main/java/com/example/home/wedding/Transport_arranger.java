package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transport_arranger extends AppCompatActivity {
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_arranger);

        getSupportActionBar().setTitle("Transport Arranger");

        btn1=(Button)findViewById(R.id.btn_trans_add);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Transport_arranger.this,activity_admin_transport_upload.class);
                startActivity(i);
            }
        });

        btn2=(Button)findViewById(R.id.btn_edit_trans);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Transport_arranger.this,activity_admin_transport_edit.class);
                startActivity(i1);

            }
        });
        btn3=(Button)findViewById(R.id.btn_view_trans);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Transport_arranger.this, activity_admin_transport_view.class);
                startActivity(i1);

            }
        });
    }
}

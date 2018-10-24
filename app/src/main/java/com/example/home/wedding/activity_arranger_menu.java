package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_arranger_menu extends AppCompatActivity {
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arranger_menu);

        getSupportActionBar().setTitle("Menu Arranger");
        btn1=(Button)findViewById(R.id.btn_add_menu);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_menu_upload.class);
                startActivity(i);
            }
        });
        btn2=(Button)findViewById(R.id.btn_edit_menu);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),activity_admin_menu_edit.class);
                startActivity(i1);
            }
        });
        btn3=(Button)findViewById(R.id.btn_view_menu);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),activity_admin_menu_view.class);
                startActivity(i1);
            }
        });
    }
}

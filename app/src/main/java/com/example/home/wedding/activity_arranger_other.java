package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_arranger_other extends AppCompatActivity {
    Button btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arranger_other);

        getSupportActionBar().setTitle("Vidhi Arranger");
        Button btn=(Button)findViewById(R.id.btn_vidhi_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_other_upload.class);
                startActivity(i);

            }
        });
        Button btn2=(Button)findViewById(R.id.btn_edit_vidhi);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_other_edit.class);
                startActivity(i);

            }
        });
        Button btn3=(Button)findViewById(R.id.btn_view_vidhi);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_admin_other_view.class);
                startActivity(i);

            }
        });

    }
}

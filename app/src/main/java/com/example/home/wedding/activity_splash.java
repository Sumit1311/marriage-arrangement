package com.example.home.wedding;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run() {
                Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
                finish();
            }
        },3000);
    }
}

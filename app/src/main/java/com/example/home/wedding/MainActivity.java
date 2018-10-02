package com.example.home.wedding;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    LinearLayout admin,arranger,guest;
    int splashtime=100;
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean intern = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writed = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean callphone=grantResults[2]==PackageManager.PERMISSION_GRANTED;
                    boolean readphonestate=grantResults[3]==PackageManager.PERMISSION_GRANTED;
                    boolean readd=grantResults[4]==PackageManager.PERMISSION_GRANTED;
                    if (intern && writed && callphone && readphonestate && readd) {
                        //Snackbar.make(ll1, "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();
                    }
                    else {
                        //Snackbar.make(ll1, "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermission()) {
            //Snackbar.make(ll1, "Permission already granted.", Snackbar.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG).show();
        } else {
            //Snackbar.make(ll1, "Please request permission.", Snackbar.LENGTH_LONG).show();
            requestPermission();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Dialog myDialog;
                myDialog= new Dialog(MainActivity.this);
                myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                myDialog.setContentView(R.layout.typeofusers);
                admin=(LinearLayout)myDialog.findViewById(R.id.admin);
                admin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i_admin=new Intent(MainActivity.this,Login_activity.class);
                        startActivity(i_admin);
                    }
                });
               arranger=(LinearLayout)myDialog.findViewById(R.id.arranger);
                arranger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i_arranger=new Intent(MainActivity.this,arranger_login.class);
                        startActivity(i_arranger);
                    }
                });
                guest=(LinearLayout)myDialog.findViewById(R.id.guest);
                guest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i_guest=new Intent(MainActivity.this,guest_main.class);
                        startActivity(i_guest);
                    }
                });
                myDialog.setCancelable(false);
                myDialog.show();
            }
        },splashtime);


    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result2=ContextCompat.checkSelfPermission(getApplicationContext(),READ_PHONE_STATE);
        int result3= ContextCompat.checkSelfPermission(getApplicationContext(),CALL_PHONE);
        int result4=ContextCompat.checkSelfPermission(getApplicationContext(),READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2==PackageManager.PERMISSION_GRANTED && result3==PackageManager.PERMISSION_GRANTED && result4==PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{INTERNET,WRITE_EXTERNAL_STORAGE,READ_PHONE_STATE,CALL_PHONE,READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }
}

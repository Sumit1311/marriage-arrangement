package com.example.home.wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class admin_main extends AppCompatActivity
{
    public static DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
        int days;
        Date strDate;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("Logout"))
        {
            Intent i1=new Intent(getApplicationContext(),Login_activity.class);
            startActivity(i1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Logout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        String my_date = "31/12/2018";
        Date c = Calendar.getInstance().getTime();


        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        long l=System.currentTimeMillis();
        String dateString = "12-12-2018 07:00:32";
        try{
            //formatting the dateString to convert it into a Date
            Date date = sdf.parse(dateString);
            //System.out.println("Given Time in milliseconds : "+date.getTime());
            long fl=date.getTime();
            long dl=fl-l;
            Calendar calendar = Calendar.getInstance();
            days = (int) (dl / (1000*60*60*24));
            //Setting the Calendar date and time to the given date and time
            calendar.setTime(date);
            //System.out.println("Given Time in milliseconds : "+calendar.getTimeInMillis());
            //Toast.makeText(getApplicationContext(),days+" "+dl+" "+fl+" "+l,Toast.LENGTH_LONG).show();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Animation startanim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blinkinganimation);
        TextView tv1=(TextView)findViewById(R.id.txtmrgdate);
        tv1.setText(days+"Days Remaining");
        tv1.startAnimation(startanim);




        mToolbar=(Toolbar)findViewById(R.id.action_bar);
        //mToolbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout_admin);
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
}

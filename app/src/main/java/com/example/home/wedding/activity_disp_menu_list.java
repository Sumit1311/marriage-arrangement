package com.example.home.wedding;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.Adapter.menu_adapter;
import com.example.home.model.invitation;
import com.example.home.model.menu_details;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_disp_menu_list extends AppCompatActivity {
    ArrayList<menu_details> al1,al2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_menu_list);

        /*TextView tx = (TextView)findViewById(R.id.txt_date18);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/BEBAS.ttf");
        tx.setTypeface(custom_font);
*/
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<menu_details>> call=api.getmenudetails();
        call.enqueue(new Callback<List<menu_details>>() {
            @Override
            public void onResponse(Call<List<menu_details>> call, Response<List<menu_details>> response) {
                List<menu_details> slist=response.body();
        //        Toast.makeText(getApplicationContext(),slist.get(0).getMenu_img(),Toast.LENGTH_LONG).show();
                al1=new ArrayList<>();
                al2=new ArrayList<>();
                for(int i=0;i<slist.size();i++)
                {
                    //if(slist.get(i).getMenu_dt().equals("18/12/2018"))
                    //{
                        menu_details md1 = new menu_details();
                        md1.setM_id(slist.get(i).getM_id());
                        md1.setMenu_type(slist.get(i).getMenu_type());
                        md1.setMenu_time(slist.get(i).getMenu_time());
                        md1.setMenu_dt(slist.get(i).getMenu_dt());
          //              md1.setMenu_img(slist.get(i).getMenu_img());
                        al1.add(md1);
                    //}
                    /*else if(slist.get(i).getMenu_dt().equals("19/12/2018"))
                    {
                        //Toast.makeText(getApplicationContext(),slist.get(i).getMenu_img_path(),Toast.LENGTH_LONG).show();
                        menu_details md2 = new menu_details();
                        md2.setM_id(slist.get(i).getM_id());
                        md2.setMenu_name(slist.get(i).getMenu_name());
                        md2.setMenu_img_path(slist.get(i).getMenu_img_path());
                        md2.setMenu_dt(slist.get(i).getMenu_dt());
                        al2.add(md2);
                    }*/
                }

                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_menu_dt1);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);

                /*RecyclerView rv1=(RecyclerView)findViewById(R.id.recycler_disp_menu_dt2);
                RecyclerView.LayoutManager lm1=new LinearLayoutManager(getApplicationContext());
                rv1.setHasFixedSize(true);
                rv1.setLayoutManager(lm1);
*/
                /*menu_adapter ma1=new menu_adapter(activity_disp_menu_list.this,al1, new customclicklistener() {
                    @Override
                    public void itemclick(View v, int position) {
                        /*String path=al1.get(position).getMenu_img_path();
                        Intent i1=new Intent(getApplicationContext(),activity_dispfullimg_guest.class);
                        i1.putExtra("path",path);
                        startActivity(i1);
                    }
                });*/

  /*              menu_adapter ma2=new menu_adapter(activity_disp_menu_list.this, al2, new customclicklistener() {
                    @Override
                    public void itemclick(View v, int position) {
                        String path=al2.get(position).getMenu_img_path();
                        Intent i1=new Intent(getApplicationContext(),activity_dispfullimg_guest.class);
                        i1.putExtra("path",path);
                        startActivity(i1);
                    }
                });
*/
                //rv.setAdapter(ma1);
  //              rv1.setAdapter(ma2);

            }

            @Override
            public void onFailure(Call<List<menu_details>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

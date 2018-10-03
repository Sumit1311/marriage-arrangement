package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.home.Adapter.menu_adapter;
import com.example.home.model.menu_details;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_menu_view extends AppCompatActivity {
    ArrayList<menu_details> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_view);
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<menu_details>> call=api.getmenudetails();
        call.enqueue(new Callback<List<menu_details>>() {
            @Override
            public void onResponse(Call<List<menu_details>> call, Response<List<menu_details>> response) {
                List<menu_details> slist=response.body();

                al=new ArrayList<>();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_admin_menudisp);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                for(int i=0;i<slist.size();i++)
                {
                    menu_details md1 = new menu_details();
                    md1.setM_id(slist.get(i).getM_id());
                    md1.setMenu_type(slist.get(i).getMenu_type());
                    md1.setMenu_time(slist.get(i).getMenu_time());
                    md1.setMenu_dt(slist.get(i).getMenu_dt());
                    al.add(md1);
                }
                menu_adapter ma=new menu_adapter(getApplicationContext(),al);
                rv.setAdapter(ma);
            }

            @Override
            public void onFailure(Call<List<menu_details>> call, Throwable t) {
Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.home.Adapter.menu_adapter;
import com.example.home.Adapter.other_adapter;
import com.example.home.model.menu_details;
import com.example.home.model.other;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_disp_allevents extends AppCompatActivity {
ArrayList<menu_details> al1;
ArrayList<other> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_allevents);
        getSupportActionBar().setTitle("All Events");
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<menu_details>> call=api.getmenudetails();
        call.enqueue(new Callback<List<menu_details>>() {
            @Override
            public void onResponse(Call<List<menu_details>> call, Response<List<menu_details>> response) {
                List<menu_details> slist = response.body();
                al1 = new ArrayList<>();
                for (int i = 0; i < slist.size(); i++) {
                    menu_details md1 = new menu_details();
                    md1.setM_id(slist.get(i).getM_id());
                    md1.setMenu_type(slist.get(i).getMenu_type());
                    md1.setMenu_time(slist.get(i).getMenu_time());
                    md1.setMenu_dt(slist.get(i).getMenu_dt());
                    al1.add(md1);
                }
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_menu_allevents);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);

                menu_adapter ma=new menu_adapter(getApplicationContext(),al1);
                rv.setAdapter(ma);
            }
            @Override
            public void onFailure(Call<List<menu_details>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

        Call<List<other>> call1=api.getothers();
        call1.enqueue(new Callback<List<other>>() {
            @Override
            public void onResponse(Call<List<other>> call, Response<List<other>> response) {
                List<other> slist=response.body();
                al=new ArrayList<>();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_other_allevents);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                for(int i=0;i<slist.size();i++) {
                    //Toast.makeText(getApplicationContext(),slist.get(i).getVidhiname()+" "+t1,Toast.LENGTH_LONG).show();
                        other o1=new other();
                        o1.setVenue(slist.get(i).getVenue());
                        o1.setPoc(slist.get(i).getPoc());
                        o1.setDescription(slist.get(i).getDescription());
                        o1.setVidhiname(slist.get(i).getVidhiname());
                        al.add(o1);
                }
                other_adapter oa=new other_adapter(getApplicationContext(),al);
                rv.setAdapter(oa);
            }

            @Override
            public void onFailure(Call<List<other>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

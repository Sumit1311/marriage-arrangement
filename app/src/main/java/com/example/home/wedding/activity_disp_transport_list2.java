package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.home.Adapter.menu_adapter;
import com.example.home.Adapter.transport_adapter;
import com.example.home.model.transport;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_disp_transport_list2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_transport_list2);
        final String transport_path=getIntent().getExtras().getString("vehicle_path");
        getSupportActionBar().setTitle(transport_path);
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<transport>> call=api.gettransportdetails();

        call.enqueue(new Callback<List<transport>>() {
            @Override
            public void onResponse(Call<List<transport>> call, Response<List<transport>> response) {
                List<transport> slist=response.body();
                Toast.makeText(getApplicationContext(),slist.get(0).getVehicle_path(),Toast.LENGTH_LONG).show();
                final ArrayList<transport> al1 = new ArrayList<>();
                for(int i=0;i<slist.size();i++)
                {
                    if(slist.get(i).getVehicle_path().equals(transport_path))
                    {
                        //getSupportActionBar().setTitle("Surendranagar To Wadhwan");
                        transport t1=new transport();
                        t1.setDriver_nm(slist.get(i).getDriver_nm());
                        t1.setDriver_mob(slist.get(i).getDriver_mob());
                        t1.setVehicle_no(slist.get(i).getVehicle_no());
                        t1.setVehicle_imgpath(slist.get(i).getVehicle_imgpath());
                        t1.setVehicle_path((slist.get(i).getVehicle_path()));
                        al1.add(t1);
                    }
                }

                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_transport);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);

                transport_adapter ta1=new transport_adapter(activity_disp_transport_list2.this,al1, new customclicklistener() {
                    @Override
                    public void itemclick(View v, int position) {
                        String path=al1.get(position).getVehicle_imgpath();
                        //Toast.makeText(getApplicationContext(),path,Toast.LENGTH_LONG).show();
                        Intent i1=new Intent(getApplicationContext(),activity_dispfullimg_guest.class);
                        i1.putExtra("path",path);
                        startActivity(i1);
                    }
                });

                rv.setAdapter(ta1);

            }

            @Override
            public void onFailure(Call<List<transport>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

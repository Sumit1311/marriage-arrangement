package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.home.Adapter.transport_adapter;
import com.example.home.model.menu_details;
import com.example.home.model.transport;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_trans_view extends AppCompatActivity {
    ArrayList<transport> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_trans_view);
        Button b1=(Button)findViewById(R.id.btnadmintransview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                Api_disp api=rf.create(Api_disp.class);
                Call<List<transport>> call=api.gettransportdetails();
                call.enqueue(new Callback<List<transport>>() {
                    @Override
                    public void onResponse(Call<List<transport>> call, Response<List<transport>> response) {
                        List<transport> slist=response.body();
                        Spinner sp1=(Spinner)findViewById(R.id.spin_trans_view);
                        String rou=sp1.getSelectedItem().toString();
                        //Toast.makeText(getApplicationContext(),slist.size()+"",Toast.LENGTH_LONG).show();
                        al=new ArrayList<>();
                        RecyclerView rv=(RecyclerView)findViewById(R.id.recyclerdisptransport);
                        RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                        rv.setHasFixedSize(true);
                        rv.setLayoutManager(lm);
                        for(int i=0;i<slist.size();i++)
                        {
                            if(slist.get(i).getRoute().equals(rou)) {
                                transport t1 = new transport();
                                t1.setT_id(slist.get(i).getT_id());
                                t1.setDrivername(slist.get(i).getDrivername());
                                t1.setDt(slist.get(i).getDt());
                                t1.setDriverno(slist.get(i).getDriverno());
                                t1.setVehicleno(slist.get(i).getVehicleno());
                                t1.setRoute(slist.get(i).getRoute());
                                al.add(t1);
                            }
                        }

                        transport_adapter ta=new transport_adapter(getApplicationContext(),al);
                        rv.setAdapter(ta);
                    }

                    @Override
                    public void onFailure(Call<List<transport>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}

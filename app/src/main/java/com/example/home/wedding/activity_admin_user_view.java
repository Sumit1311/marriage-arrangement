package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.home.Adapter.user_adapter;
import com.example.home.model.transport;
import com.example.home.model.user;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_user_view extends AppCompatActivity {
    ArrayList<user> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_view);
        getSupportActionBar().setTitle("User Details");
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<user>> call=api.getuser();
        call.enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                List<user> slist=response.body();
                //Toast.makeText(getApplicationContext(),slist.size()+"",Toast.LENGTH_LONG).show();
                al=new ArrayList<>();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycleradminuser);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                for(int i=0;i<slist.size();i++)
                {
                    user u1=new user();
                    u1.setUname(slist.get(i).getUname());
                    u1.setPwd(slist.get(i).getPwd());
                    u1.setArrangertype(slist.get(i).getArrangertype());
                    al.add(u1);
                }
                user_adapter ua=new user_adapter(getApplicationContext(),al);
                rv.setAdapter(ua);
            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }
}

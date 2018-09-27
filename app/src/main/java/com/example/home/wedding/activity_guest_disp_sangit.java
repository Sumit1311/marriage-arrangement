package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.home.Adapter.participants_adapter;
import com.example.home.model.invitation;
import com.example.home.model.participants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_guest_disp_sangit extends AppCompatActivity {
    ArrayList<participants> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_disp_sangit);

        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<participants>> call=api.getparticipants();
        call.enqueue(new Callback<List<participants>>() {
            @Override
            public void onResponse(Call<List<participants>> call, Response<List<participants>> response) {
                final List<participants> slist=response.body();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_participants);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                al=new ArrayList<>();
                for(int i=0;i<slist.size();i++)
                {
                    participants p1=new participants();
                    p1.setP_id(slist.get(i).getP_id());
                    p1.setPname(slist.get(i).getPname());
                    p1.setPmob(slist.get(i).getPmob());
                    p1.setPper(slist.get(i).getPper());
                    al.add(p1);
                }

                participants_adapter pa=new participants_adapter(getApplicationContext(),al);
                rv.setAdapter(pa);
            }

            @Override
            public void onFailure(Call<List<participants>> call, Throwable t) {

            }
        });

    }
}

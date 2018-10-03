package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.Adapter.participants_adapter;
import com.example.home.model.other;
import com.example.home.model.participants;
import com.example.home.model.sangit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_view_sangitrajani extends AppCompatActivity {
    ArrayList<sangit> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_sangitrajani);
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<sangit>> call=api.getsangit();
        call.enqueue(new Callback<List<sangit>>() {
            @Override
            public void onResponse(Call<List<sangit>> call, Response<List<sangit>> response) {
                List<sangit> slist=response.body();
                //Toast.makeText(getApplicationContext(),slist.size()+"",Toast.LENGTH_LONG).show();
                TextView tv1=(TextView)findViewById(R.id.txt_admin_sangit_venue);
                TextView tv2=(TextView)findViewById(R.id.txt_admin_sangit_description);
                TextView tv3=(TextView)findViewById(R.id.txt_admin_sangit_poc);
                tv1.setText(slist.get(0).getVenue());
                tv2.setText(slist.get(0).getDescription());
                tv3.setText(slist.get(0).getPoc());
            }

            @Override
            public void onFailure(Call<List<sangit>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Call<List<participants>> call1=api.getparticipants();
        call1.enqueue(new Callback<List<participants>>() {
            @Override
            public void onResponse(Call<List<participants>> call, Response<List<participants>> response) {
                List<participants> slist=response.body();
                ArrayList<participants> al=new ArrayList<>();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_admin_sangit_view);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                for(int i=0;i<slist.size();i++)
                {
                    participants p1=new participants();
                    p1.setPartname(slist.get(i).getPartname());
                    p1.setPartno(slist.get(i).getPartno());
                    p1.setParttype(slist.get(i).getParttype());
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

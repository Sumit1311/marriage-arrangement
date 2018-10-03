package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.home.Adapter.other_adapter;
import com.example.home.model.other;
import com.example.home.model.room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_other_view extends AppCompatActivity {
ArrayList<other> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_other_view);
        Button b1=(Button)findViewById(R.id.btnotherview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                Api_disp api=rf.create(Api_disp.class);
                Call<List<other>> call=api.getothers();
                call.enqueue(new Callback<List<other>>() {
                    @Override
                    public void onResponse(Call<List<other>> call, Response<List<other>> response) {
                        Spinner sp1=(Spinner)findViewById(R.id.spin_other_view);
                        List<other> slist=response.body();
                        String t1=sp1.getSelectedItem().toString();
                        al=new ArrayList<>();
                        RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_admin_other_view);
                        RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                        rv.setHasFixedSize(true);
                        rv.setLayoutManager(lm);
                        for(int i=0;i<slist.size();i++) {
                            //Toast.makeText(getApplicationContext(),slist.get(i).getVidhiname()+" "+t1,Toast.LENGTH_LONG).show();
                            if(slist.get(i).getVidhiname().equals(t1)) {
                                other o1=new other();
                                o1.setVenue(slist.get(i).getVenue());
                                o1.setPoc(slist.get(i).getPoc());
                                o1.setDescription(slist.get(i).getDescription());
                                o1.setVidhiname(slist.get(i).getVidhiname());
                                al.add(o1);
                            }
                        }

                        //Toast.makeText(getApplicationContext(),slist.get(0).getVidhiname()+" "+t1,Toast.LENGTH_LONG).show();
                        other_adapter oa=new other_adapter(getApplicationContext(),al);
                        rv.setAdapter(oa);
                    }

                    @Override
                    public void onFailure(Call<List<other>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}

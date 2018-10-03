package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.home.Adapter.invitation_adapter;
import com.example.home.model.invitation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_disp_invitation_list extends AppCompatActivity {
    invitation_adapter ia;
    ArrayList<invitation> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_invitation_list);

        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<invitation>> call=api.getinvitation();
        call.enqueue(new Callback<List<invitation>>() {
            @Override
            public void onResponse(Call<List<invitation>> call, Response<List<invitation>> response) {
                final List<invitation> slist=response.body();
                //Toast.makeText(getApplicationContext(),slist.get(0).getInvitation_path(),Toast.LENGTH_LONG).show();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_disp_invitation);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                al=new ArrayList<>();
                for(int i=0;i<slist.size();i++)
                {
                    invitation i1=new invitation();
                    i1.setPageno(slist.get(i).getPageno());
                    i1.setImgpath(slist.get(i).getImgpath());
                    al.add(i1);
                }
                invitation_adapter ia=new invitation_adapter(activity_disp_invitation_list.this,al, new customclicklistener() {
                    @Override
                    public void itemclick(View v, int position) {
                        String path=al.get(position).getImgpath();
                        Intent i1=new Intent(getApplicationContext(),activity_dispfullimg_guest.class);
                        i1.putExtra("path",path);
                        startActivity(i1);

                    }
                });
                rv.setAdapter(ia);
            }

            @Override
            public void onFailure(Call<List<invitation>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

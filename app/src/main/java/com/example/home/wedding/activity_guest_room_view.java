package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.home.Adapter.room_adapter_guest;
import com.example.home.model.menu_details;
import com.example.home.model.room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_guest_room_view extends AppCompatActivity {
ArrayList<room> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_room_view);
        getSupportActionBar().setTitle("Room Details");
        Button b1=(Button)findViewById(R.id.btnguest_roomview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                Api_disp api=rf.create(Api_disp.class);
                Call<List<room>> call=api.getroom();
                call.enqueue(new Callback<List<room>>() {
                    @Override
                    public void onResponse(Call<List<room>> call, Response<List<room>> response) {
                        Spinner sp1=(Spinner)findViewById(R.id.spin_guest_room);
                        List<room> slist=response.body();
                        String t1=sp1.getSelectedItem().toString();

//Toast.makeText(getApplicationContext(),t1,Toast.LENGTH_LONG).show();
                        al=new ArrayList<>();
                        RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_guest_room_view);
                        RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                        rv.setHasFixedSize(true);
                        rv.setLayoutManager(lm);
                        //Toast.makeText(getApplicationContext(),slist.get(0).getRoomno()+"",Toast.LENGTH_LONG).show();
                        for(int i=0;i<slist.size();i++) {

                            if(slist.get(i).getRoomno().equals(t1)) {
                            room r1 = new room();
                            r1.setGuest_nm(slist.get(i).getGuest_nm());
                            r1.setRoomno(slist.get(i).getRoomno());
                            r1.setGuest_mob(slist.get(i).getGuest_mob());
                            al.add(r1);
                            }
                        }
                       // Toast.makeText(getApplicationContext(),al.get(0).getRoomno()+"",Toast.LENGTH_LONG).show();
                        room_adapter_guest raa=new room_adapter_guest(getApplicationContext(),al);
                        rv.setAdapter(raa);
                    }

                    @Override
                    public void onFailure(Call<List<room>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

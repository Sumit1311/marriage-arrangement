package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.model.other;
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
                Toast.makeText(getApplicationContext(),slist.size()+"",Toast.LENGTH_LONG).show();
                /*al=new ArrayList<>();
                for(int i=0;i<slist.size();i++)
                {
                    sangit s1=new sangit();
                    s1.setVenue(slist.get(i).getVenue());
                    s1.setDescription(slist.get(i).getDescription());
                    s1.setPoc(slist.get(i).getPoc());
                    al.add(s1);

                }*/
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

    }
}

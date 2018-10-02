package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.home.Adapter.CustomAdapter;
import com.example.home.model.contactmodel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_send_smscontactlist extends AppCompatActivity {

    private ArrayList<contactmodel> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnselect, btndeselect, btnnext;
    List<contactmodel> slist;
    RecyclerView rv;
    ArrayList<contactmodel> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_send_smscontactlist);

        /*btnselect = (Button) findViewById(R.id.select);
        btndeselect = (Button) findViewById(R.id.deselect);
        btnnext = (Button) findViewById(R.id.next);*/
        rv=(RecyclerView)findViewById(R.id.recycler_sendmsg);


        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<contactmodel>> call=api.getcontact();
        call.enqueue(new Callback<List<contactmodel>>() {
            @Override
            public void onResponse(Call<List<contactmodel>> call, Response<List<contactmodel>> response) {
                slist=response.body();

                modelArrayList = getModel(false);

                customAdapter = new CustomAdapter(getApplicationContext(),modelArrayList);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(customAdapter);

                /*btnselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        modelArrayList = getModel(true);
                        customAdapter = new CustomAdapter(getApplicationContext(),modelArrayList);
                        rv.setAdapter(customAdapter);
                    }
                });
                btndeselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        modelArrayList = getModel(false);
                        customAdapter = new CustomAdapter(getApplicationContext(),modelArrayList);
                        rv.setAdapter(customAdapter);
                    }
                });
                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),NextActivity.class);
                        startActivity(intent);
                    }
                });*/

                ImageView iv1=(ImageView)findViewById(R.id.imgbtnsend);
                iv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText ed1=(EditText)findViewById(R.id.edmsgsend);
                        SmsManager sm=SmsManager.getDefault();
                        String msg=ed1.getText().toString();
                        for (int i = 0; i < CustomAdapter.imageModelArrayList.size(); i++){
                            if(CustomAdapter.imageModelArrayList.get(i).getSelected()) {

                                //       tv.setText(tv.getText() + " " + CustomAdapter.imageModelArrayList.get(i).getCno());

                                sm.sendTextMessage(CustomAdapter.imageModelArrayList.get(i).getCno(),null,msg,null,null);
                            }
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<contactmodel>> call, Throwable t) {
Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
    private ArrayList<contactmodel> getModel(boolean isSelect){
        ArrayList<contactmodel> list = new ArrayList<>();
        for(int i = 0; i < slist.size(); i++){

            contactmodel model = new contactmodel();
            model.setSelected(isSelect);
            model.setCname(slist.get(i).getCname());
            model.setCno(slist.get(i).getCno());
            list.add(model);
        }
        return list;
    }
}

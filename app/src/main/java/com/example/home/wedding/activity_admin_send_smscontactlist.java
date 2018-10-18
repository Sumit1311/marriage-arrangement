package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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
    ArrayList<contactmodel> albride;
    ArrayList<contactmodel> algroom;
    ArrayList<contactmodel> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_send_smscontactlist);
        getSupportActionBar().setTitle("SMS Send");
        rv=(RecyclerView)findViewById(R.id.recycler_sendmsg);

        final Spinner sp1=(Spinner)findViewById(R.id.spin_admin_contacttype);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(sp1.getSelectedItem().toString().equals("Bride")) {
                    Retrofit rf = new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                    Api_disp api = rf.create(Api_disp.class);
                    Call<List<contactmodel>> call = api.getcontact();
                    call.enqueue(new Callback<List<contactmodel>>() {
                        @Override
                        public void onResponse(Call<List<contactmodel>> call, Response<List<contactmodel>> response) {
                            slist = response.body();
                            albride = new ArrayList<>();
                            for (int i = 0; i < slist.size(); i++) {
                                if (slist.get(i).getType_of_guest().equals("Bride")) {
                                    contactmodel model = new contactmodel();
                                    model.setSelected(false);
                                    model.setCname(slist.get(i).getCname());
                                    model.setCno(slist.get(i).getCno());
                                    model.setType_of_guest(slist.get(i).getType_of_guest());
                                    albride.add(model);
                                }
                                customAdapter = new CustomAdapter(getApplicationContext(), albride);
                                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                rv.setAdapter(customAdapter);
                            }
                        }
                        @Override
                        public void onFailure(Call<List<contactmodel>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else if(sp1.getSelectedItem().toString().equals("Groom"))
                {
                    Retrofit rf = new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                    Api_disp api = rf.create(Api_disp.class);
                    Call<List<contactmodel>> call = api.getcontact();
                    call.enqueue(new Callback<List<contactmodel>>() {
                        @Override
                        public void onResponse(Call<List<contactmodel>> call, Response<List<contactmodel>> response) {
                            slist = response.body();
                            algroom=new ArrayList<>();
                            for (int i = 0; i < slist.size(); i++) {
                                if (slist.get(i).getType_of_guest().equals("Groom")) {
                                    contactmodel model = new contactmodel();
                                    model.setSelected(false);
                                    model.setCname(slist.get(i).getCname());
                                    model.setCno(slist.get(i).getCno());
                                    model.setType_of_guest(slist.get(i).getType_of_guest());
                                    algroom.add(model);
                                }
                                customAdapter = new CustomAdapter(getApplicationContext(), algroom);
                                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                rv.setAdapter(customAdapter);
                            }
                        }
                        @Override
                        public void onFailure(Call<List<contactmodel>> call, Throwable t) {
Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                                Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

    }
   /* private ArrayList<contactmodel> getModel(boolean isSelect){
        ArrayList<contactmodel> list = new ArrayList<>();

        for(int i = 0; i < slist.size(); i++){

            contactmodel model = new contactmodel();
            model.setSelected(isSelect);
            model.setCname(slist.get(i).getCname());
            model.setCno(slist.get(i).getCno());
            model.setType_of_guest(slist.get(i).getType_of_guest());
            list.add(model);
        }
        return list;
    }*/
}

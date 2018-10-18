package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.Adapter.CustomAdapter;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_room_upload2 extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_room_upload2);
        getSupportActionBar().setTitle("Upload Room Details");
        tv1=(TextView)findViewById(R.id.txt_guestlist);
        for (int i = 0; i < CustomAdapter.imageModelArrayList.size(); i++){
            if(CustomAdapter.imageModelArrayList.get(i).getSelected()) {
                tv1.setText(tv1.getText() + "\n" + CustomAdapter.imageModelArrayList.get(i).getCname());
            }
        }

        Button b1=(Button)findViewById(R.id.btn_room_allocate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner sp1=(Spinner)findViewById(R.id.spinroomno);
                String roomno=sp1.getSelectedItem().toString();

                RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                Api api = ra.create(Api.class);
                for (int i = 0; i < CustomAdapter.imageModelArrayList.size(); i++){
                    if(CustomAdapter.imageModelArrayList.get(i).getSelected()) {
                        //tv1.setText(tv1.getText() + " " + CustomAdapter.imageModelArrayList.get(i).getCname());
                        String guest_nm=CustomAdapter.imageModelArrayList.get(i).getCname();
                        String guest_mob=CustomAdapter.imageModelArrayList.get(i).getCno();
                        api.insertroomguest(roomno, guest_nm, guest_mob, new Callback<Response>() {
                            @Override
                            public void success(Response response, retrofit.client.Response response2) {
//                                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void failure(RetrofitError error) {
//Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                            }
                        });
                        //Toast.makeText(getApplicationContext(),roomno+guest_nm+guest_mob,Toast.LENGTH_LONG).show();
                    }
                }
                Toast.makeText(getApplicationContext(),"Successfully Allocated",Toast.LENGTH_LONG).show();
            }
        });

    }
}

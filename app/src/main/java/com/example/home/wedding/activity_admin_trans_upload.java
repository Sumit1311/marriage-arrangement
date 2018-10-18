package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_trans_upload extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText et1,et2,et3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_trans_upload);
        getSupportActionBar().setTitle("Upload Transportation Details");
        btn=(Button)findViewById(R.id.btn_upload_trans);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_trans_drivername_upload);
                et2=(EditText)findViewById(R.id.txt_admin_other_driverno_upload);
                et3=(EditText)findViewById(R.id.txt_admin_vehicleno_upload);
                if(et1.getText().toString().equals(""))
                {
                    et1.setError("Enter Value");
                }
                else if(et2.getText().toString().equals(""))
                {
                    et2.setError("Enter Value");
                }
                else if(et3.getText().toString().equals(""))
                {
                    et3.setError("Enter Value");
                }
                else {
                    sp1 = (Spinner) findViewById(R.id.spin_admin_transport_route_upload);
                    String route = sp1.getSelectedItem().toString();
                    sp2 = (Spinner) findViewById(R.id.spin_admin_transport_date_upload);
                    String dt = sp2.getSelectedItem().toString();
                    String drivername = et1.getText().toString();
                    String driverno = et2.getText().toString();
                    String vehicleno = et3.getText().toString();

                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.inserttransport(route, drivername, driverno, vehicleno, dt, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Record Successfully Uploaded", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}

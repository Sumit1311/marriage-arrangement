package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_transport_edit extends AppCompatActivity {
    Spinner sp1, sp2;
    EditText et1, et2, et3;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_transport_edit);

        btn1 = (Button) findViewById(R.id.btn_edit_trans);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp1 = (Spinner) findViewById(R.id.spin_admin_transport_route_edit);
                String route = sp1.getSelectedItem().toString();

                et1 = (EditText) findViewById(R.id.txt_admin_trans_drivername_edit);
                String drivername = et1.getText().toString();

                et2 = (EditText) findViewById(R.id.txt_admin_other_driverno_edit);
                String driverno = et2.getText().toString();
                Integer i1 = Integer.parseInt(driverno);

                et3 = (EditText) findViewById(R.id.txt_admin_vehicleno_edit);
                String vehicleno = et3.getText().toString();

                sp2 = (Spinner) findViewById(R.id.spin_admin_transport_date_edit);
                String transdate = sp1.getSelectedItem().toString();

                RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                Api api = ra.create(Api.class);

                api.edittransport(route, drivername, i1, vehicleno, transdate, new Callback<Response>() {
                    @Override
                    public void success(Response response, retrofit.client.Response response2) {
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}

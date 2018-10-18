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

public class activity_admin_menu_edit extends AppCompatActivity {
    Spinner sp2,sp3;
    Button btn1;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_edit);
        getSupportActionBar().setTitle("Edit Menu Details");
        btn1=(Button)findViewById(R.id.btn_edit_menu);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_mtime_edit);
                et2=(EditText)findViewById(R.id.txt_admin_mid_edit);
                if(et2.getText().toString().equals(""))
                {
                    et2.setError("Enter Value");
                }
                else if (et1.getText().toString().equals("")) {
                    et1.setError("Enter Value");
                }
                else {
                    String mid = et2.getText().toString();
                    Integer i1 = Integer.parseInt(mid);

                    sp2 = (Spinner) findViewById(R.id.spin_admin_mtype_edit);
                    String mtype = sp2.getSelectedItem().toString();

                    sp3 = (Spinner) findViewById(R.id.spin_admin_mdt_edit);
                    String mdt = sp3.getSelectedItem().toString();


                    String mtime = et1.getText().toString();

                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.editmenu(i1, mtype, mtime, mdt, new Callback<Response>() {
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
            }
        });
    }
}

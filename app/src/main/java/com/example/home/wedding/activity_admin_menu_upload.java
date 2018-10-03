package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit.RestAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_menu_upload extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_upload);
        Button b1=(Button)findViewById(R.id.btn_upload_menu);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1=(EditText)findViewById(R.id.txt_admin_mtime_upload);
                if(ed1.getText().toString().equals(""))
                {
                    ed1.setError("Enter Value");
                }
                else {
                    sp1 = (Spinner) findViewById(R.id.spin_admin_mtype_upload);
                    String mtype = sp1.getSelectedItem().toString();
                    String mtime = ed1.getText().toString();

                    sp2 = (Spinner) findViewById(R.id.spin_admin_mdt_upload);
                    String mdt = sp2.getSelectedItem().toString();

                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.insertmenu(mtype, mtime, mdt, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Menu Details Successfully Uploaded", Toast.LENGTH_LONG).show();
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

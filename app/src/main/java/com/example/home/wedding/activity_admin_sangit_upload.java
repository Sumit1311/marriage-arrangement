package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_sangit_upload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sangit_upload);

        Button b1=(Button)findViewById(R.id.btn_upload_sangit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed1=(EditText)findViewById(R.id.ed_admin_sangit_venue_upload);
                String venue=ed1.getText().toString();
                EditText ed2=(EditText)findViewById(R.id.ed_admin_sangit_poc_upload);
                String poc=ed2.getText().toString();
                EditText ed3=(EditText)findViewById(R.id.ed_admin_sangit_desc_upload);
                String desc=ed3.getText().toString();

                RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                Api api = ra.create(Api.class);
                api.insertsangit(venue, poc, desc, new Callback<Response>() {
                    @Override
                    public void success(Response response, retrofit.client.Response response2) {
                        Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Response;

public class activity_admin_participants_upload extends AppCompatActivity {
    TextView tv1;
    EditText et1,et2,et3 ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_participants_upload);



        btn=(Button)findViewById(R.id.btn_upload_partcipants);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_partname_upload);
                String partname =et1.getText().toString();

                et2=(EditText)findViewById(R.id.txt_admin_partno_upload);
                String partno=et2.getText().toString();

                et3=(EditText)findViewById(R.id.txt_admin_parttype_upload);
                String parttype=et3.getText().toString();


                RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                Api api = ra.create(Api.class);
                api.insertparticipants(partname, partno, parttype, new Callback<Response>() {
                    @Override
                    public void success(Response response, retrofit.client.Response response2) {
                        Toast.makeText(getApplicationContext(),"Succesfully Uploaded",Toast.LENGTH_LONG).show();
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

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

public class activity_admin_upload_guest extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5 ;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload_guest);
        getSupportActionBar().setTitle("Upload Guest Details");
        btn=(Button)findViewById(R.id.btn_upload_guest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_guestname_upload);
                et2=(EditText)findViewById(R.id.txt_admin_guestno_upload);
                et3=(EditText)findViewById(R.id.txt_admin_guesttype_upload);
                et4=(EditText)findViewById(R.id.txt_admin_guestaddr_upload);
                et5=(EditText)findViewById(R.id.txt_admin_guestcat_upload);
                if (et1.getText().toString().equals(""))
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
                else if(et4.getText().toString().equals(""))
                {
                    et4.setError("Enter Value");
                }
                else if(et5.getText().toString().equals(""))
                {
                    et5.setError("Enter Value");
                }
                else{
                    String cname=et1.getText().toString();
                String cno = et2.getText().toString();
                String type_of_guest = et3.getText().toString();
                String guestaddr = et4.getText().toString();
                String guestcat = et5.getText().toString();
                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.insertguest(cname, cno, type_of_guest, guestaddr, guestcat, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Succesfully Uploaded", Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


            }}
        });
    }
}

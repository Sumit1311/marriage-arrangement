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

public class activity_admin_other_upload extends AppCompatActivity {
    Spinner sp1;
    EditText et1,et2,et3;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_other_upload);
        getSupportActionBar().setTitle("Upload Other Details");
        btn1=(Button)findViewById(R.id.btn_upload_otherdata);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_other_venue_upload);
                et2=(EditText)findViewById(R.id.txt_admin_other_poc_upload);
                et3=(EditText)findViewById(R.id.txt_admin_other_des_upload);
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
                else {
                    sp1 = (Spinner) findViewById(R.id.spin_admin_other_upload);
                    String vidhiname = sp1.getSelectedItem().toString();
                    String venue = et1.getText().toString();
                    String poc = et2.getText().toString();
                    String description = et3.getText().toString();
                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.insertother(venue, poc, description, vidhiname, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Successfully Uploaded", Toast.LENGTH_LONG).show();
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

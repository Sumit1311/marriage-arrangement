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

public class activity_admin_other_edit extends AppCompatActivity {
    Spinner sp1;
    EditText et1,et2,et3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_other_edit);
        btn=(Button)findViewById(R.id.btn_edit_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText)findViewById(R.id.txt_admin_other_venue_edit);
                et2=(EditText)findViewById(R.id.txt_admin_other_des_edit);
                et3=(EditText)findViewById(R.id.txt_admin_other_poc_edit);
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
                    String description = et2.getText().toString();
                    String poc = et2.getText().toString();
                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.editother(venue, poc, description, vidhiname, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Record Successfully Updated", Toast.LENGTH_LONG).show();
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

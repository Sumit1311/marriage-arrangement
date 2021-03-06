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

public class activity_admin_participants_delete extends AppCompatActivity {
    EditText et1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_participants_delete);
        getSupportActionBar().setTitle("Delete Participants Details");
        btn = (Button) findViewById(R.id.btn_delete_partcipants);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1 = (EditText) findViewById(R.id.txt_admin_part_delete);
                if (et1.getText().toString().equals(""))
                {
                    et1.setError("Enter Value");
                }
                else {
                    String partname = et1.getText().toString();
                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.deleteparticipants(partname, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Succesfully Deleted", Toast.LENGTH_LONG).show();
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

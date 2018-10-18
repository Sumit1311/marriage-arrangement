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

public class activity_admin_user_add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_add);
        getSupportActionBar().setTitle("Add User");
        Button b1=(Button)findViewById(R.id.btn_add_user);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText ed1=(EditText)findViewById(R.id.txt_admin_username_add);
                final EditText ed2=(EditText)findViewById(R.id.txt_admin_password_add);
                if(ed1.getText().toString().equals(""))
                {
                    ed1.setError("Enter Value");
                }
                else if(ed2.getText().toString().equals(""))
                {
                    ed1.setError("Enter Value");
                }
                else {
                    Spinner sp1 = (Spinner) findViewById(R.id.spin_admin_user_add);
                    String uname = ed1.getText().toString();
                    String pwd = ed2.getText().toString();
                    String arrangertype = sp1.getSelectedItem().toString();

                    RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                    Api api = ra.create(Api.class);
                    api.insertuser(uname, pwd, arrangertype, new Callback<Response>() {
                        @Override
                        public void success(Response response, retrofit.client.Response response2) {
                            Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_LONG).show();
                            ed1.setText("");
                            ed2.setText("");
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

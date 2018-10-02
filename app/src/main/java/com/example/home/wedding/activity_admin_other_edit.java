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
    EditText et1,et2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_other_edit);
        btn=(Button)findViewById(R.id.btn_edit_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp1=(Spinner)findViewById(R.id.spin_admin_other_upload);
                String vidhiname=sp1.getSelectedItem().toString();

                et1=(EditText)findViewById(R.id.txt_admin_other_venue_edit);
                String venue=et1.getText().toString();

                et2=(EditText)findViewById(R.id.txt_admin_other_des_edit);
                String description=et2.getText().toString();

                RestAdapter ra = new RestAdapter.Builder().setEndpoint(Api.url).build();
                Api api = ra.create(Api.class);

                api.editother(vidhiname, venue, description, new Callback<Response>() {
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

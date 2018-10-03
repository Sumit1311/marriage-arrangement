package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.home.model.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        Button btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText usnm=(EditText)findViewById(R.id.usnm);
                final EditText pwd=(EditText)findViewById(R.id.pwd);

                final String unm=usnm.getText().toString();
                final String pwdadmin=pwd.getText().toString();
                Spinner sp1=(Spinner)findViewById(R.id.spin_arranger_type);
                final String arrtype=sp1.getSelectedItem().toString();
                    Retrofit rf = new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
                    Api_disp api = rf.create(Api_disp.class);
                    Call<List<user>> call = api.getuser();
                    call.enqueue(new Callback<List<user>>() {
                        @Override
                        public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                            List<user> slist = response.body();
                            for (int i = 0; i < slist.size(); i++) {
                                if (unm.equals(slist.get(i).getUname()) && pwdadmin.equals(slist.get(i).getPwd()) && arrtype.equals(slist.get(i).getArrangertype()))
                                {
                                    //Toast.makeText(getApplicationContext(), slist.get(i).getArrangertype(), Toast.LENGTH_LONG).show();
                                    if(arrtype.equals("Admin"))
                                    {
                                        Intent i1 = new Intent(getApplicationContext(), admin_main.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                    else if(arrtype.equals("Menu Arranger")) {
                                        Intent i1 = new Intent(getApplicationContext(), activity_arranger_menu.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                    else if(arrtype.equals("Transport Arranger"))
                                    {
                                        Intent i1 = new Intent(getApplicationContext(), activity_arranger_transport.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                    else if(arrtype.equals("Vidhi Arranger"))
                                    {
                                        Intent i1 = new Intent(getApplicationContext(), activity_arranger_other.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                    else if(arrtype.equals("Room Management"))
                                    {
                                        Intent i1 = new Intent(getApplicationContext(), activity_arranger_menu.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                    else if(arrtype.equals("Sangit Arranger"))
                                    {
                                        Intent i1 = new Intent(getApplicationContext(), activity_arranger_sangit.class);
                                        startActivity(i1);
                                        overridePendingTransition(R.anim.goup,R.anim.down);
                                    }
                                }

                            }
                        }
                        @Override
                        public void onFailure(Call<List<user>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
            }
        });
    }
}

package com.example.home.wedding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.home.Adapter.CustomAdapter;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        final EditText ed1=(EditText)findViewById(R.id.edmsg);


        Button b1=(Button)findViewById(R.id.btnsend);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sm=SmsManager.getDefault();
                String msg=ed1.getText().toString();
                for (int i = 0; i < CustomAdapter.imageModelArrayList.size(); i++){
                    if(CustomAdapter.imageModelArrayList.get(i).getSelected()) {

                 //       tv.setText(tv.getText() + " " + CustomAdapter.imageModelArrayList.get(i).getCno());

                        sm.sendTextMessage(CustomAdapter.imageModelArrayList.get(i).getCno(),null,msg,null,null);
                    }
                }
            }
        });
        //TextView tv = (TextView) findViewById(R.id.tv);



    }
}

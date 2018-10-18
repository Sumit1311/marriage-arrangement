package com.example.home.wedding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_admin_contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setTitle("Contact Us");
        final TextView tv1=(TextView)findViewById(R.id.listItemNotTitle);
        ImageView iv1=(ImageView)findViewById(R.id.listItemNoteImg);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",tv1.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialintent);
            }
        });

        final TextView tv2=(TextView)findViewById(R.id.listItemNotTitle1);
        ImageView iv2=(ImageView)findViewById(R.id.listItemNoteImg1);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",tv2.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialintent);
            }
        });

        final TextView tv3=(TextView)findViewById(R.id.listItemNotTitle2);
        ImageView iv3=(ImageView)findViewById(R.id.listItemNoteImg2);
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",tv3.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialintent);
            }
        });

        final TextView tv4=(TextView)findViewById(R.id.listItemNotTitle3);
        ImageView iv4=(ImageView)findViewById(R.id.listItemNoteImg3);
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",tv4.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialintent);
            }
        });

        final TextView tv5=(TextView)findViewById(R.id.listItemNotTitle4);
        ImageView iv5=(ImageView)findViewById(R.id.listItemNoteImg4);
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",tv5.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialintent);
            }
        });
    }
}

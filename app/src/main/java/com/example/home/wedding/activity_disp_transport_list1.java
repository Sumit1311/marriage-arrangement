package com.example.home.wedding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class activity_disp_transport_list1 extends AppCompatActivity {
    private ViewFlipper vf;
    int[] images = {R.mipmap.img1, R.mipmap.img2,R.mipmap.img5, R.mipmap.img1, R.mipmap.img2};     // array of images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_transport_list1);

        getSupportActionBar().setTitle("Transport");
        vf = (ViewFlipper)findViewById(R.id.vftransport); // get the reference of ViewFlipper

        for (int i = 0; i < images.length; i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[i]); // set image in ImageView
            vf.addView(imageView); // add the created ImageView in ViewFlipper
        }
        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        vf.setInAnimation(in);
        vf.setOutAnimation(out);
        // set interval time for flipping between views
        vf.setFlipInterval(3000);
        // set auto start for flipping between views
        vf.setAutoStart(true);
        TextView tv2=(TextView)findViewById(R.id.txt_disp_transport_place_to_place);
        final String vehicle_path=tv2.getText().toString();
        TextView tv1=(TextView)findViewById(R.id.txt_disp_transport_viewall);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),activity_disp_transport_list2.class);
                i1.putExtra("vehicle_path",vehicle_path);
                startActivity(i1);
                overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

    }
}

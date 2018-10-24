package com.example.home.wedding;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.model.invitation;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_dispfullimg_guest extends AppCompatActivity {

    String path;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Download");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("Download"))
        {
            DownloadManager dm=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            Uri pathuri=Uri.parse(path);
            DownloadManager.Request req = new DownloadManager.Request(pathuri);
            req.setTitle("Download Start");
            req.setDescription("Invitation");
            req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"Imagenew.jpg");
            long l=dm.enqueue(req);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispfullimg_guest);

//        path=getIntent().getExtras().getString("path");
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<invitation>> call=api.getinvitation();
        call.enqueue(new Callback<List<invitation>>() {
            @Override
            public void onResponse(Call<List<invitation>> call, Response<List<invitation>> response) {
                final List<invitation> slist=response.body();
                path=slist.get(0).getImgpath();
                TextView tv1=(TextView)findViewById(R.id.txt_inviname);
                tv1.setText(slist.get(0).getPageno());
                final ImageView iv=(ImageView)findViewById(R.id.imgfull_guest);
//                Toast.makeText(getApplicationContext(),slist.get(0).getImgpath(),Toast.LENGTH_LONG).show();

                Picasso.with(getApplicationContext()).load(slist.get(0).getImgpath()).resize(200,200).into(iv);
            }

            @Override
            public void onFailure(Call<List<invitation>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

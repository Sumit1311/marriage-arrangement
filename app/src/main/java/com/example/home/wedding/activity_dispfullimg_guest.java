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

import com.squareup.picasso.Picasso;

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

        path=getIntent().getExtras().getString("path");
        final ImageView iv=(ImageView)findViewById(R.id.imgfull_guest);
        Picasso.with(getApplicationContext()).load(path).resize(200,200).into(iv);

    }
}

package com.example.home.wedding;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_admin_upload_invitation extends AppCompatActivity {

    Uri selpath;
    ImageView iv1;
    int PICK_IMAGE = 100;
    String name1;
    Api_insert api_insert;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload_invitation);
        getSupportActionBar().setTitle("Upload Invitation");
        ed1=(EditText)findViewById(R.id.ed_upload_invi);
        Button b1=(Button)findViewById(R.id.btn_upload_invi);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent
                        (Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i1,100);

            }
        });

        Button b2=(Button)findViewById(R.id.btn_upload_invi2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name1=ed1.getText().toString();
                File file=new File(getRealpathfromuri(selpath));
                RequestBody requestFile =RequestBody.create
                        (MediaType.parse(getContentResolver().getType(selpath)),file);
                RequestBody name =RequestBody.create(MediaType.parse("text/plain"),name1);
                Gson gson = new GsonBuilder().setLenient().create();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Api_insert.url).
                        addConverterFactory(GsonConverterFactory.create(gson)).build();
                Api_insert api = retrofit.create(Api_insert.class);
                Call<myResponse> call=api.uploadinvitation(requestFile,name);
                call.enqueue(new Callback<myResponse>() {
                    @Override
                    public void onResponse(Call<myResponse> call, Response<myResponse> response) {
                        Toast.makeText(getApplicationContext(),"Upload",Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),,Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<myResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==100 && resultCode==RESULT_OK)
        {
            selpath=data.getData();
            iv1=(ImageView)findViewById(R.id.imguploadinvi);
            iv1.setImageURI(selpath);
        }
    }

    private String getRealpathfromuri(Uri uri)
    {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader =new CursorLoader(this,uri, proj,null, null,null);
        Cursor cursor = loader.loadInBackground();
        int column_index =cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }
}

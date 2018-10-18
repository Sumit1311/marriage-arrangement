package com.example.home.wedding;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import com.example.home.Adapter.room_adapter_guest;
import com.example.home.model.room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_disp_room_byname extends AppCompatActivity {
ArrayList<room> al;
    private SearchView searchView;
    room_adapter_guest raa;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text=newText;
                raa.getFilter().filter(text);
                //raa.filter(text);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {

        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_room_byname);
getSupportActionBar().setTitle("Room Details");
        Retrofit rf=new Retrofit.Builder().baseUrl(Api_disp.url).addConverterFactory(GsonConverterFactory.create()).build();
        Api_disp api=rf.create(Api_disp.class);
        Call<List<room>> call=api.getroom();
        call.enqueue(new Callback<List<room>>() {
            @Override
            public void onResponse(Call<List<room>> call, Response<List<room>> response) {
                List<room> slist=response.body();
                al=new ArrayList<>();
                RecyclerView rv=(RecyclerView)findViewById(R.id.recycler_guest_room_view_byname);
                RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(lm);
                for(int i=0;i<slist.size();i++) {
                        room r1 = new room();
                        r1.setGuest_nm(slist.get(i).getGuest_nm());
                        r1.setRoomno(slist.get(i).getRoomno());
                        r1.setGuest_mob(slist.get(i).getGuest_mob());
                        al.add(r1);
                }
                raa=new room_adapter_guest(getApplicationContext(),al);
                rv.setAdapter(raa);
            }

            @Override
            public void onFailure(Call<List<room>> call, Throwable t) {

            }
        });
    }
}

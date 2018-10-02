package com.example.home.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.model.menu_details;
import com.example.home.wedding.R;
import com.example.home.wedding.customclicklistener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class menu_adapter extends RecyclerView.Adapter<menu_adapter.ViewHolder> {
    ArrayList<menu_details> al;
    Context context;
    customclicklistener cl;
    public menu_adapter(Context context,ArrayList<menu_details> al)
    {
       // Toast.makeText(context,al.get(0).getMenu_img_path()+"",Toast.LENGTH_LONG).show();
        this.context=context;
        this.al=al;
        //this.cl=cl;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_menu_details,viewGroup,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(""+al.get(i).getM_id());
        viewHolder.tv2.setText(al.get(i).getMenu_dt());
        viewHolder.tv3.setText(al.get(i).getMenu_type());
        viewHolder.tv4.setText(al.get(i).getMenu_time());
        viewHolder.rel1.setBackgroundResource(R.mipmap.img5);
        viewHolder.rel1.getBackground().setAlpha(70);
        /*Picasso.with(context).load(al.get(i).getMenu_img()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                viewHolder.ll1.setBackgroundDrawable(new BitmapDrawable(context.getResources(),bitmap));
                viewHolder.ll1.getBackground().setAlpha(130);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        RelativeLayout rel1;
        LinearLayout ll1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_row_menuid);
            tv2=(TextView)itemView.findViewById(R.id.txt_row_menudt);
            tv3=(TextView)itemView.findViewById(R.id.txt_row_menutype);
            tv4=(TextView)itemView.findViewById(R.id.txt_row_menutime);
            rel1=(RelativeLayout)itemView.findViewById(R.id.relrowmenu);
            //ll1=(LinearLayout)itemView.findViewById(R.id.llmenumain);
        }
    }
}

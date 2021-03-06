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
import android.widget.TextView;

import com.example.home.model.invitation;
import com.example.home.wedding.R;
import com.example.home.wedding.customclicklistener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class invitation_adapter extends RecyclerView.Adapter<invitation_adapter.ViewHolder> {
    Context context;
    customclicklistener cl;
    ArrayList<invitation> al;
    public invitation_adapter(Context context,ArrayList<invitation> al, customclicklistener cl)
    {
        this.cl=cl;
        this.context=context;
        this.al=al;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_guest_disp_invitation,viewGroup,false);
        final ViewHolder vh=new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.itemclick(v,vh.getAdapterPosition());
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        //Picasso.with(context).load(al.get(i).getImgpath()).resize(220,220).into(viewHolder.iv);
        Picasso.with(context).load(al.get(i).getImgpath()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                viewHolder.ll1.setBackgroundDrawable(new BitmapDrawable(context.getResources(),bitmap));
                viewHolder.ll1.getBackground().setAlpha(200);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
        viewHolder.tv1.setText(al.get(i).getPageno());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        LinearLayout ll1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_disp_name_guest_invitation);
     //       iv=(ImageView)itemView.findViewById(R.id.img_disp_guest_invitation);
            ll1=(LinearLayout)itemView.findViewById(R.id.lldispinvitation);

        }
    }
}

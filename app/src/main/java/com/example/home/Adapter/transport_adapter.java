package com.example.home.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.model.transport;
import com.example.home.wedding.R;
import com.example.home.wedding.customclicklistener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class transport_adapter extends RecyclerView.Adapter<transport_adapter.ViewHolder>
{
    Context context;
    ArrayList<transport> al;
    customclicklistener cl;

    public transport_adapter(Context context, ArrayList<transport> al, customclicklistener cl)
    {
        this.context=context;
        this.al=al;
        this.cl=cl;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_guest_transport,viewGroup,false);
        final transport_adapter.ViewHolder vh=new transport_adapter.ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.itemclick(v,vh.getAdapterPosition());
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(al.get(i).getDriver_nm());
        viewHolder.tv2.setText(al.get(i).getDriver_mob());
        viewHolder.tv3.setText(al.get(i).getVehicle_no());
        Picasso.with(context).load(al.get(i).getVehicle_imgpath()).resize(220,220).into(viewHolder.iv1);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        ImageView iv1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_disp_guest_transport_drivername);
            tv2=(TextView)itemView.findViewById(R.id.txt_disp_guest_transport_driverno);
            tv3=(TextView)itemView.findViewById(R.id.txt_disp_guest_transport_vehicleno);
            iv1=(ImageView)itemView.findViewById(R.id.img_disp_guest_transport);
        }
    }
}

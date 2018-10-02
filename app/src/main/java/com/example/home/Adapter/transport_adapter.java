package com.example.home.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    //customclicklistener cl;

    public transport_adapter(Context context, ArrayList<transport> al)
    {
        this.context=context;
        this.al=al;
      //  this.cl=cl;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_trans_details,viewGroup,false);
        final ViewHolder vh=new ViewHolder(v);
        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.itemclick(v,vh.getAdapterPosition());
            }
        });*/
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(""+al.get(i).getT_id());
        viewHolder.tv2.setText(al.get(i).getDt());
        viewHolder.tv3.setText(al.get(i).getRoute());
        viewHolder.tv4.setText(al.get(i).getDrivername());
        viewHolder.tv5.setText(al.get(i).getDriverno());
        viewHolder.tv6.setText(al.get(i).getVehicleno());
        viewHolder.rel.setBackgroundResource(R.drawable.car);
        viewHolder.rel.getBackground().setAlpha(70);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4,tv5,tv6;
        RelativeLayout rel;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_admin_row_transid);
            tv2=(TextView)itemView.findViewById(R.id.txt_admin_row_transdt);
            tv3=(TextView)itemView.findViewById(R.id.txt_admin_row_transroute);
            tv4=(TextView)itemView.findViewById(R.id.txt_admin_row_transdrivername);
            tv5=(TextView)itemView.findViewById(R.id.txt_admin_row_transdriverno);
            tv6=(TextView)itemView.findViewById(R.id.txt_admin_row_transvehicleno);
            rel=(RelativeLayout)itemView.findViewById(R.id.relrowtransport);
        }
    }
}

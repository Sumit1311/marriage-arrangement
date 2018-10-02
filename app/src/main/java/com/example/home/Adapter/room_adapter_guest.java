package com.example.home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.model.room;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class room_adapter_guest extends RecyclerView.Adapter<room_adapter_guest.ViewHolder> {
    private LayoutInflater inflater;
    public static ArrayList<room> al;
    private Context ctx;
    public room_adapter_guest(Context ctx, ArrayList<room> al) {

        inflater = LayoutInflater.from(ctx);
        this.al = al;
        this.ctx = ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_room_details, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv1.setText(al.get(position).getGuest_nm());
        holder.tv2.setText(al.get(position).getGuest_mob());
        holder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno=String.format("tel: %s",holder.tv2.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(dialintent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;
        ImageView iv1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.gname);
            tv2=(TextView)itemView.findViewById(R.id.gmob);
            iv1=(ImageView)itemView.findViewById(R.id.imgrowdialroom);
        }
    }
}

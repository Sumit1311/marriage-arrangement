package com.example.home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.home.model.participants;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class participants_adapter extends RecyclerView.Adapter<participants_adapter.ViewHolder> {
    Context context;
    ArrayList<participants> al;
    public participants_adapter(Context context, ArrayList<participants> al)
    {
        this.context=context;
        this.al=al;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_participants,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv1.setText(al.get(position).getPartname());
        holder.tv2.setText(al.get(position).getParttype());
        holder.tv3.setText(al.get(position).getPartno());
        holder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"OK"+holder.tv2.getText().toString(),Toast.LENGTH_LONG).show();
                String phoneno=String.format("tel: %s",holder.tv3.getText().toString());
                Intent dialintent=new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse(phoneno));
                dialintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(dialintent);
            }
        });
        //holder.ll1.setBackgroundResource(R.mipmap.blank);
        //holder.ll1.getBackground().setAlpha(70);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        ImageView iv1;
        LinearLayout ll1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_row_participantsname);
            tv2=(TextView)itemView.findViewById(R.id.txt_row_participantstype);
            tv3=(TextView)itemView.findViewById(R.id.txt_row_participantscall);
            iv1=(ImageView)itemView.findViewById(R.id.imgrowparticipants);
            ll1=(LinearLayout)itemView.findViewById(R.id.llrowparticipants);
        }
    }
}

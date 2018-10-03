package com.example.home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home.model.transport;
import com.example.home.model.user;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class user_adapter extends RecyclerView.Adapter<user_adapter.ViewHolder> {
    Context context;
    ArrayList<user> al;
    public user_adapter(Context context, ArrayList<user> al)
    {
        this.context=context;
        this.al=al;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_user,parent,false);
        final ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(al.get(position).getUname());
        holder.tv2.setText(al.get(position).getPwd());
        holder.tv3.setText(al.get(position).getArrangertype());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_user_name);
            tv2=(TextView)itemView.findViewById(R.id.txt_user_pwd);
            tv3=(TextView)itemView.findViewById(R.id.txt_user_arrtype);
        }
    }
}

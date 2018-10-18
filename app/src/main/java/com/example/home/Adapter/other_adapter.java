package com.example.home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.home.model.other;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class other_adapter extends RecyclerView.Adapter<other_adapter.ViewHolder> {
    private LayoutInflater inflater;
    public static ArrayList<other> al;
    private Context ctx;
    public other_adapter(Context ctx, ArrayList<other> al) {

        inflater = LayoutInflater.from(ctx);
        this.al = al;
        this.ctx = ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_other_details, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(al.get(position).getVenue());
        holder.tv2.setText(al.get(position).getDescription());
        holder.tv3.setText(al.get(position).getPoc());
        holder.tv4.setText(al.get(position).getVidhiname());
        holder.ll1.setBackgroundResource(R.drawable.vidhi);
        holder.ll1.getBackground().setAlpha(70);

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        LinearLayout ll1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.txt_row_other_venue);
            tv2=(TextView)itemView.findViewById(R.id.txt_row_other_desc);
            tv3=(TextView)itemView.findViewById(R.id.txt_row_other_poc);
            tv4=(TextView)itemView.findViewById(R.id.txt_row_other_vidhi);
            ll1=(LinearLayout)itemView.findViewById(R.id.llrowotherview);
        }
    }
}

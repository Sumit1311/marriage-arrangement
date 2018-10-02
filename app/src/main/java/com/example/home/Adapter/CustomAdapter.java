package com.example.home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.model.contactmodel;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    public static ArrayList<contactmodel> imageModelArrayList;
    private Context ctx;

    public CustomAdapter(Context ctx, ArrayList<contactmodel> imageModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_sendsmsnew, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.checkBox.setChecked(imageModelArrayList.get(position).getSelected());
        holder.tvcname.setText(imageModelArrayList.get(position).getCname());
        holder.tvcno.setText(imageModelArrayList.get(position).getCno());
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(ctx, imageModelArrayList.get(pos).getCno() + " clicked!", Toast.LENGTH_SHORT).show();
                if (imageModelArrayList.get(pos).getSelected()) {
                    imageModelArrayList.get(pos).setSelected(false);
                } else {
                    imageModelArrayList.get(pos).setSelected(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected CheckBox checkBox;
        private TextView tvcname,tvcno;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.cb);
            tvcname = (TextView) itemView.findViewById(R.id.gname);
            tvcno=(TextView)itemView.findViewById(R.id.gmob);

        }
    }
}

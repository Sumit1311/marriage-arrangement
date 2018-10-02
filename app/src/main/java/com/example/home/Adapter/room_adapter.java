package com.example.home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.home.model.room;
import com.example.home.wedding.R;

import java.util.ArrayList;

public class room_adapter extends RecyclerView.Adapter<room_adapter.ViewHolder> {
    private LayoutInflater inflater;
    public static ArrayList<room> imageModelArrayList;
    private Context ctx;
    public room_adapter(Context ctx, ArrayList<room> imageModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_sendsmsnew, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.checkBox.setChecked(imageModelArrayList.get(position).getSelected());
        holder.tvcname.setText(imageModelArrayList.get(position).getGuest_nm());
        holder.tvcno.setText(imageModelArrayList.get(position).getGuest_mob());
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(ctx, imageModelArrayList.get(pos).getGuest_mob() + " clicked!", Toast.LENGTH_SHORT).show();
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected CheckBox checkBox;
        private TextView tvcname,tvcno;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.cb);
            tvcname = (TextView) itemView.findViewById(R.id.gname);
            tvcno=(TextView)itemView.findViewById(R.id.gmob);

        }
    }
}

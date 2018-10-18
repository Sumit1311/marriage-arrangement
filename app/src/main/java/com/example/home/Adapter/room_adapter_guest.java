package com.example.home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.model.room;
import com.example.home.wedding.R;

import java.util.ArrayList;
import java.util.List;

public class room_adapter_guest extends RecyclerView.Adapter<room_adapter_guest.ViewHolder> implements Filterable {
    private LayoutInflater inflater;
    public static ArrayList<room> al;
    private ArrayList<room> contactListFiltered;
    //private ContactsAdapterListener listener;

    private Context ctx;
    public room_adapter_guest(Context ctx, ArrayList<room> al) {

        inflater = LayoutInflater.from(ctx);
        this.al = al;
        this.ctx = ctx;
        this.contactListFiltered=al;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_room_details, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv1.setText(contactListFiltered.get(position).getGuest_nm());
        holder.tv2.setText(contactListFiltered.get(position).getGuest_mob());
        holder.tv3.setText(contactListFiltered.get(position).getRoomno());
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
        return contactListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    contactListFiltered = al;
                } else {
                    ArrayList<room> filteredList = new ArrayList<>();
                    for (room row : al) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getGuest_nm().toLowerCase().contains(charString.toLowerCase()) || row.getGuest_nm().contains(constraint)) {
                            filteredList.add(row);
                        }
                    }

                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                contactListFiltered = (ArrayList<room>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        ImageView iv1;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.gname);
            tv2=(TextView)itemView.findViewById(R.id.gmob);
            tv3=(TextView)itemView.findViewById(R.id.grno);
            iv1=(ImageView)itemView.findViewById(R.id.imgrowdialroom);
        }
    }
}

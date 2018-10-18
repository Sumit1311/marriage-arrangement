package com.example.home.wedding;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;


public class Navigation_drawer_guest extends Fragment {


    public Navigation_drawer_guest() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_navigation_drawer_guest, container, false);
        TextView tv1=(TextView)v.findViewById(R.id.txt_guest_invitationmenu);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),  "font/Dirty Queen Personal Use.ttf");
        tv1.setTypeface(custom_font);

        TextView tv2=(TextView)v.findViewById(R.id.txt_guest_homemenu);
        tv2.setTypeface(custom_font);

        TextView tv3=(TextView)v.findViewById(R.id.txt_guest_alleventsmenu);
        tv3.setTypeface(custom_font);

        TextView tv4=(TextView)v.findViewById(R.id.txt_guest_timetablemenu);
        tv4.setTypeface(custom_font);


        TextView tv5=(TextView)v.findViewById(R.id.txt_guest_menumenu);
        tv5.setTypeface(custom_font);

        TextView tv6=(TextView)v.findViewById(R.id.txt_guest_sangitrajanimenu);
        tv6.setTypeface(custom_font);

        TextView tv7=(TextView)v.findViewById(R.id.txt_guest_othersmenu);
        tv7.setTypeface(custom_font);

        TextView tv8=(TextView)v.findViewById(R.id.txt_guest_transportmenu);
        tv8.setTypeface(custom_font);

        TextView tv9=(TextView)v.findViewById(R.id.txt_guest_roombynumbermenu);
        tv9.setTypeface(custom_font);

        TextView tv10=(TextView)v.findViewById(R.id.txt_guest_roombynamemenu);
        tv10.setTypeface(custom_font);

        TextView tv11=(TextView)v.findViewById(R.id.txt_guest_shareappmenu);
        tv11.setTypeface(custom_font);

        TextView tv12=(TextView)v.findViewById(R.id.txt_guest_contactmenu);
        tv12.setTypeface(custom_font);


        LinearLayout ll1=(LinearLayout)v.findViewById(R.id.llguesthome);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity().getApplicationContext(),"Home",Toast.LENGTH_LONG).show();

                Intent i1=new Intent(getActivity().getApplicationContext(), guest_main.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll2=(LinearLayout)v.findViewById(R.id.llguest_invitation);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_invitation_list.class);
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_dispfullimg_guest.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll3=(LinearLayout)v.findViewById(R.id.llguesttimetable);
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout llmenu=(LinearLayout)getActivity().findViewById(R.id.llguestmenu);
                llmenu.setVisibility(VISIBLE);
                LinearLayout llsangit=(LinearLayout)getActivity().findViewById(R.id.llguestsangit);
                llsangit.setVisibility(VISIBLE);
                LinearLayout llothers=(LinearLayout)getActivity().findViewById(R.id.llguestothers);
                llothers.setVisibility(VISIBLE);
            }
        });

        LinearLayout ll31=(LinearLayout)v.findViewById(R.id.llguestmenu);
        ll31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll32=(LinearLayout)v.findViewById(R.id.llguestsangit);
        ll32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll33=(LinearLayout)v.findViewById(R.id.llguestothers);
        ll33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll4=(LinearLayout)v.findViewById(R.id.llguest_transport);
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //           Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_menu_list.class);
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll5=(LinearLayout)v.findViewById(R.id.llguestshareapp);
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Wedding Invitation");
                    String message = "\nLet me recommend you this application\n\n";
                    message = message + "http://wedding.ajab-gajab.com:8080/wedding/app-debug.apk";
                    i.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(i,"choose one"));
                } catch(Exception e)
                {

                }
            }
        });
        LinearLayout ll6=(LinearLayout)v.findViewById(R.id.llguestroom);
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_guest_room_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll8=(LinearLayout)v.findViewById(R.id.llguestroombyname);
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_room_byname.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll7=(LinearLayout)v.findViewById(R.id.llguestcontactus);
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_contact_us.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll9=(LinearLayout)v.findViewById(R.id.llguest_allevents);
        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_allevents.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        return v;
    }

}

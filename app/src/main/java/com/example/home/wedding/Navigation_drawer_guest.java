package com.example.home.wedding;


import android.content.Intent;
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
        LinearLayout ll1=(LinearLayout)v.findViewById(R.id.llguesthome);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                /*Fragment fg=new frag_upload_invitation();
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.frmguest,fg);
                ft.commit();*/

                Intent i1=new Intent(getActivity().getApplicationContext(), Login_activity.class);

                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll2=(LinearLayout)v.findViewById(R.id.llguest_invitation);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_invitation_list.class);
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
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_menu_list.class);
                startActivity(i1);
            }
        });
        LinearLayout ll32=(LinearLayout)v.findViewById(R.id.llguestsangit);
        ll32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_guest_disp_sangit.class);
                startActivity(i1);
            }
        });
        LinearLayout ll4=(LinearLayout)v.findViewById(R.id.llguest_transport);
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //           Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_menu_list.class);
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_disp_transport_list1.class);
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
                    message = message + "https://play.google.com/store/apps/details?id=com.example.sapna.recipeapp";
                    i.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(i,"choose one"));
                } catch(Exception e)
                {

                }
            }
        });

        return v;
    }

}

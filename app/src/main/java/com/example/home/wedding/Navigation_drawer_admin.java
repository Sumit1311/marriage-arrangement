package com.example.home.wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Navigation_drawer_admin extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View v1=inflater.inflate(R.layout.fragment_navigation_drawer_admin, container, false);

        LinearLayout ll0=(LinearLayout)v1.findViewById(R.id.lladminuser);
        ll0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll01=(LinearLayout)v1.findViewById(R.id.lladminuseradd);
                ll01.setVisibility(View.VISIBLE);

                LinearLayout ll02=(LinearLayout)v1.findViewById(R.id.lladminuserdelete);
                ll02.setVisibility(View.VISIBLE);

                LinearLayout ll03=(LinearLayout)v1.findViewById(R.id.lladminuserview);
                ll03.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout ll01=(LinearLayout)v1.findViewById(R.id.lladminuseradd);
        ll01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_user_add.class);
                startActivity(i1);
            }
        });
        LinearLayout ll02=(LinearLayout)v1.findViewById(R.id.lladminuserdelete);
        ll02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),admin_user_delete.class);
                startActivity(i1);

            }
        });


        LinearLayout ll1=(LinearLayout)v1.findViewById(R.id.lladmininvitation);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladmininviupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladmininvidelete);
                lladmindelete.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout ll11=(LinearLayout)v1.findViewById(R.id.lladmininviupload);
        ll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_upload_invitation.class);
                startActivity(i1);
            }
        });

        LinearLayout ll2=(LinearLayout)v1.findViewById(R.id.lladminmenu);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladminmenuupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminmenuedit);
                lladminedit.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminmenudelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminmenuview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout ll21=(LinearLayout)v1.findViewById(R.id.lladminmenuupload);
        ll21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_upload.class);
                startActivity(i1);
            }
        });
        LinearLayout ll22=(LinearLayout)v1.findViewById(R.id.lladminmenuedit);
        ll22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_edit.class);
                startActivity(i1);
            }
        });
        LinearLayout ll23=(LinearLayout)v1.findViewById(R.id.lladminmenudelete);
        ll23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_delete.class);
                startActivity(i1);
            }
        });
        LinearLayout ll24=(LinearLayout)v1.findViewById(R.id.lladminmenuview);
        ll24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_view.class);
                startActivity(i1);
            }
        });

        LinearLayout ll3=(LinearLayout)v1.findViewById(R.id.lladminSangit);
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladminsangitupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminsangitdelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminsangitview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout ll31=(LinearLayout)v1.findViewById(R.id.lladminsangitupload);
        ll31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_sangit_upload.class);
                startActivity(i1);
            }
        });
        LinearLayout ll32=(LinearLayout)v1.findViewById(R.id.lladminsangitdelete);
        ll32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_sangit_delete.class);
                startActivity(i1);
            }
        });

        LinearLayout ll33=(LinearLayout)v1.findViewById(R.id.lladminsangitview);
        ll33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i1);
            }
        });
        LinearLayout ll4=(LinearLayout)v1.findViewById(R.id.lladminparticipants);
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladminparticipantupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminparticipantedit);
                lladminedit.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminparticipantdelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminparticipantview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout ll5=(LinearLayout)v1.findViewById(R.id.lladminothers);
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladminothersupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminothersedit);
                lladminedit.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminothersdelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminothersview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });
        LinearLayout ll51=(LinearLayout)v1.findViewById(R.id.lladminothersupload);
        ll51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_upload.class);
                startActivity(i1);
            }
        });

        LinearLayout ll52=(LinearLayout)v1.findViewById(R.id.lladminothersedit);
        ll52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_edit.class);
                startActivity(i1);
            }
        });

        LinearLayout ll53=(LinearLayout)v1.findViewById(R.id.lladminothersdelete);
        ll53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_delete.class);
                startActivity(i1);
            }
        });
        LinearLayout ll54=(LinearLayout)v1.findViewById(R.id.lladminothersview);
        ll54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_view.class);
                startActivity(i1);
            }
        });
        LinearLayout ll6=(LinearLayout)v1.findViewById(R.id.lladmintransport);
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladmintransportupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladmintransportedit);
                lladminedit.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladmintransportdelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladmintransportview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });
        LinearLayout ll61=(LinearLayout)v1.findViewById(R.id.lladmintransportupload);
        ll61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_upload.class);
                startActivity(i1);
            }
        });
        LinearLayout ll62=(LinearLayout)v1.findViewById(R.id.lladmintransportedit);
        ll62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_edit.class);
                startActivity(i1);
            }
        });
        LinearLayout ll63=(LinearLayout)v1.findViewById(R.id.lladmintransportdelete);
        ll63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_delete.class);
                startActivity(i1);
            }
        });
        LinearLayout ll64=(LinearLayout)v1.findViewById(R.id.lladmintransportview);
        ll64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_view.class);
                startActivity(i1);
            }
        });
        LinearLayout ll7=(LinearLayout)v1.findViewById(R.id.lladminroomdetails);
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsupload);
                lladminupload.setVisibility(View.VISIBLE);
                LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsdelete);
                lladmindelete.setVisibility(View.VISIBLE);
                LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsview);
                lladminview.setVisibility(View.VISIBLE);
            }
        });
        LinearLayout ll71 =(LinearLayout)v1.findViewById(R.id.lladminroomdetailsupload);
        ll71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_room_upload.class);
                startActivity(i1);
            }
        });

        LinearLayout ll72=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsdelete);
        ll72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_room_delete.class);
                startActivity(i1);
            }
        });
        LinearLayout ll73=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsview);
        ll73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_guest_room_view.class);
                startActivity(i1);
            }
        });
        LinearLayout ll8=(LinearLayout)v1.findViewById(R.id.lladminsendsms);
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_send_smscontactlist.class);
                startActivity(i1);
            }
        });
        LinearLayout ll9=(LinearLayout)v1.findViewById(R.id.lladminshareapp);
        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Wedding Invitation");
                    String message = "\nLet me recommend you this application\n\n";
                    message = message + "https://play.google.com/store/apps/details?id=com.example.wedding";
                    i.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(i,"choose one"));
                } catch(Exception e)
                {

                }

            }
        });
        return v1;
    }

    public Navigation_drawer_admin() {
        // Required empty public constructor

    }

}

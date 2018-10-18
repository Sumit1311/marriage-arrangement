package com.example.home.wedding;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.home.Adapter.participants_adapter;

public class Navigation_drawer_admin extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View v1=inflater.inflate(R.layout.fragment_navigation_drawer_admin, container, false);

        TextView tv1=(TextView)v1.findViewById(R.id.txt_admin_homemenu);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),  "font/Dirty Queen Personal Use.ttf");
        tv1.setTypeface(custom_font);

        TextView tv2=(TextView)v1.findViewById(R.id.txt_admin_usersmenu);
        tv2.setTypeface(custom_font);

        TextView tv3=(TextView)v1.findViewById(R.id.txt_admin_addnewusermenu);
        tv3.setTypeface(custom_font);

        TextView tv4=(TextView)v1.findViewById(R.id.txt_admin_deleteusermenu);
        tv4.setTypeface(custom_font);

        TextView tv5=(TextView)v1.findViewById(R.id.txt_admin_viewusermenu);
        tv5.setTypeface(custom_font);

        TextView tv6=(TextView)v1.findViewById(R.id.txt_admin_invitationmenu);
        tv6.setTypeface(custom_font);

        TextView tv7=(TextView)v1.findViewById(R.id.txt_admin_inviuploadmenu);
        tv7.setTypeface(custom_font);

        TextView tv8=(TextView)v1.findViewById(R.id.txt_admin_deleteinvimenu);
        tv8.setTypeface(custom_font);

        TextView tv9=(TextView)v1.findViewById(R.id.txt_admin_viewinvimenu);
        tv9.setTypeface(custom_font);

        TextView tv10=(TextView)v1.findViewById(R.id.txt_admin_menumenu);
        tv10.setTypeface(custom_font);

        TextView tv11=(TextView)v1.findViewById(R.id.txt_admin_uploadmenumenu);
        tv11.setTypeface(custom_font);

        TextView tv12=(TextView)v1.findViewById(R.id.txt_admin_editmenumenu);
        tv12.setTypeface(custom_font);

        TextView tv13=(TextView)v1.findViewById(R.id.txt_admin_delmenumenu);
        tv13.setTypeface(custom_font);

        TextView tv14=(TextView)v1.findViewById(R.id.txt_admin_viewmenumenu);
        tv14.setTypeface(custom_font);

        TextView tv15=(TextView)v1.findViewById(R.id.txt_admin_sangitmenu);
        tv15.setTypeface(custom_font);

        TextView tv16=(TextView)v1.findViewById(R.id.txt_admin_sangituploadmenu);
        tv16.setTypeface(custom_font);

        TextView tv17=(TextView)v1.findViewById(R.id.txt_admin_sangitdeletemenu);
        tv17.setTypeface(custom_font);

        TextView tv18=(TextView)v1.findViewById(R.id.txt_admin_sangitviewmenu);
        tv18.setTypeface(custom_font);

        TextView tv19=(TextView)v1.findViewById(R.id.txt_admin_part);
        tv19.setTypeface(custom_font);

        TextView tv20=(TextView)v1.findViewById(R.id.txt_admin_part_upload);
        tv20.setTypeface(custom_font);

        TextView tv21=(TextView)v1.findViewById(R.id.txt_admin_parti_delete);
        tv21.setTypeface(custom_font);

        TextView tv22=(TextView)v1.findViewById(R.id.txt_admin_part_view);
        tv22.setTypeface(custom_font);

        TextView tv23=(TextView)v1.findViewById(R.id.txt_admin_others);
        tv23.setTypeface(custom_font);
        TextView tv24=(TextView)v1.findViewById(R.id.txt_admin_others_upload);
        tv24.setTypeface(custom_font);
        TextView tv25=(TextView)v1.findViewById(R.id.txt_admin_others_delete);
        tv25.setTypeface(custom_font);
        TextView tv26=(TextView)v1.findViewById(R.id.txt_admin_others_edit);
        tv26.setTypeface(custom_font);

        TextView tv27=(TextView)v1.findViewById(R.id.txt_admin_others_view);
        tv27.setTypeface(custom_font);

        TextView tv28=(TextView)v1.findViewById(R.id.txt_admin_trans);
        tv28.setTypeface(custom_font);

        TextView tv29=(TextView)v1.findViewById(R.id.txt_admin_trans_upload);
        tv29.setTypeface(custom_font);

        TextView tv30=(TextView)v1.findViewById(R.id.txt_admin_trans_delete);
        tv30.setTypeface(custom_font);

        TextView tv31=(TextView)v1.findViewById(R.id.txt_admin_trans_edit);
        tv31.setTypeface(custom_font);

        TextView tv32=(TextView)v1.findViewById(R.id.txt_admin_trans_view);
        tv32.setTypeface(custom_font);

        TextView tv33=(TextView)v1.findViewById(R.id.txt_admin_room);
        tv33.setTypeface(custom_font);

        TextView tv34=(TextView)v1.findViewById(R.id.txt_admin_room_upload);
        tv34.setTypeface(custom_font);

        TextView tv35=(TextView)v1.findViewById(R.id.txt_admin_room_delete);
        tv35.setTypeface(custom_font);

        TextView tv36=(TextView)v1.findViewById(R.id.txt_admin_room_view);
        tv36.setTypeface(custom_font);

        TextView tv37=(TextView)v1.findViewById(R.id.txt_admin_sendsms);
        tv37.setTypeface(custom_font);

        TextView tv38=(TextView)v1.findViewById(R.id.txt_admin_shareapp);
        tv38.setTypeface(custom_font);

        LinearLayout llhome=(LinearLayout)v1.findViewById(R.id.lladminhome);
        llhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),admin_main.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        final LinearLayout ll0=(LinearLayout)v1.findViewById(R.id.lladminuser);
        final LinearLayout ll01=(LinearLayout)v1.findViewById(R.id.lladminuseradd);
        ll0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll01.getVisibility()==View.VISIBLE)
                {
                    ll01.setVisibility(View.GONE);
                    LinearLayout ll02=(LinearLayout)v1.findViewById(R.id.lladminuserdelete);
                    ll02.setVisibility(View.GONE);

                    LinearLayout ll03=(LinearLayout)v1.findViewById(R.id.lladminuserview);
                    ll03.setVisibility(View.GONE);
                }
                else {
          //          LinearLayout ll01 = (LinearLayout) v1.findViewById(R.id.lladminuseradd);
                    ll01.setVisibility(View.VISIBLE);

                    LinearLayout ll02 = (LinearLayout) v1.findViewById(R.id.lladminuserdelete);
                    ll02.setVisibility(View.VISIBLE);

                    LinearLayout ll03 = (LinearLayout) v1.findViewById(R.id.lladminuserview);
                    ll03.setVisibility(View.VISIBLE);
                }
            }
        });

        //ll01=(LinearLayout)v1.findViewById(R.id.lladminuseradd);
        ll01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_user_add.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll02=(LinearLayout)v1.findViewById(R.id.lladminuserdelete);
        ll02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),admin_user_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);

            }
        });
        LinearLayout ll03=(LinearLayout)v1.findViewById(R.id.lladminuserview);
        ll03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_user_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll1=(LinearLayout)v1.findViewById(R.id.lladmininvitation);
        final LinearLayout lladminupload=(LinearLayout)v1.findViewById(R.id.lladmininviupload);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lladminupload.getVisibility()== View.VISIBLE)
                {
                    lladminupload.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladmininvidelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladmininviview);
                    lladminview.setVisibility(View.GONE);
                }
                else {
                    lladminupload.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete = (LinearLayout) v1.findViewById(R.id.lladmininvidelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview = (LinearLayout) v1.findViewById(R.id.lladmininviview);
                    lladminview.setVisibility(View.VISIBLE);
                }
            }
        });

        LinearLayout ll11=(LinearLayout)v1.findViewById(R.id.lladmininviupload);
        ll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_upload_invitation.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll12=(LinearLayout)v1.findViewById(R.id.lladmininvidelete);
        ll12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_invitation_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll13=(LinearLayout)v1.findViewById(R.id.lladmininviview);
        ll13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_dispfullimg_guest.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll2=(LinearLayout)v1.findViewById(R.id.lladminmenu);
        final LinearLayout lladminuploadmenu=(LinearLayout)v1.findViewById(R.id.lladminmenuupload);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lladminuploadmenu.getVisibility()==View.VISIBLE)
                {
                    lladminuploadmenu.setVisibility(View.GONE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminmenuedit);
                    lladminedit.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminmenudelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminmenuview);
                    lladminview.setVisibility(View.GONE);
                }
                else
                {
                    lladminuploadmenu.setVisibility(View.VISIBLE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminmenuedit);
                    lladminedit.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminmenudelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminmenuview);
                    lladminview.setVisibility(View.VISIBLE);
                }
            }
        });

        LinearLayout ll21=(LinearLayout)v1.findViewById(R.id.lladminmenuupload);
        ll21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll22=(LinearLayout)v1.findViewById(R.id.lladminmenuedit);
        ll22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_edit.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll23=(LinearLayout)v1.findViewById(R.id.lladminmenudelete);
        ll23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll24=(LinearLayout)v1.findViewById(R.id.lladminmenuview);
        ll24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_menu_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll3=(LinearLayout)v1.findViewById(R.id.lladminSangit);
        final LinearLayout ll31=(LinearLayout)v1.findViewById(R.id.lladminsangitupload);
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll31.getVisibility()==View.VISIBLE)
                {
                    ll31.setVisibility(View.GONE);
                    LinearLayout lladmindeletesangit=(LinearLayout)v1.findViewById(R.id.lladminsangitdelete);
                    lladmindeletesangit.setVisibility(View.GONE);
                    LinearLayout lladminviewsangit=(LinearLayout)v1.findViewById(R.id.lladminsangitview);
                    lladminviewsangit.setVisibility(View.GONE);
                }
                else
                {
                    ll31.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminsangitdelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminsangitview);
                    lladminview.setVisibility(View.VISIBLE);
                }
            }
        });

       // LinearLayout ll31=(LinearLayout)v1.findViewById(R.id.lladminsangitupload);
        ll31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_sangit_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll32=(LinearLayout)v1.findViewById(R.id.lladminsangitdelete);
        ll32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_sangit_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll33=(LinearLayout)v1.findViewById(R.id.lladminsangitview);
        ll33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll4=(LinearLayout)v1.findViewById(R.id.lladminparticipants);
        final LinearLayout ll41=(LinearLayout)v1.findViewById(R.id.lladminparticipantupload);
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll41.getVisibility()==View.VISIBLE)
                {
                    ll41.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminparticipantdelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminparticipantview);
                    lladminview.setVisibility(View.GONE);
                }
                else
                {
                    ll41.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminparticipantdelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminparticipantview);
                    lladminview.setVisibility(View.VISIBLE);
                }

            }
        });
        //LinearLayout ll41=(LinearLayout)v1.findViewById(R.id.lladminparticipantupload);
        ll41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_participants_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll42=(LinearLayout)v1.findViewById(R.id.lladminparticipantdelete);
        ll42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_participants_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll43=(LinearLayout)v1.findViewById(R.id.lladminparticipantview);
        ll43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_view_sangitrajani.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll5=(LinearLayout)v1.findViewById(R.id.lladminothers);
        final LinearLayout ll51=(LinearLayout)v1.findViewById(R.id.lladminothersupload);
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll51.getVisibility()==View.VISIBLE)
                {
                    ll51.setVisibility(View.GONE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminothersedit);
                    lladminedit.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminothersdelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminothersview);
                    lladminview.setVisibility(View.GONE);
                }
                else
                {
                    ll51.setVisibility(View.VISIBLE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladminothersedit);
                    lladminedit.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminothersdelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminothersview);
                    lladminview.setVisibility(View.VISIBLE);
                }

            }
        });
        //LinearLayout ll51=(LinearLayout)v1.findViewById(R.id.lladminothersupload);
        ll51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll52=(LinearLayout)v1.findViewById(R.id.lladminothersedit);
        ll52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_edit.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll53=(LinearLayout)v1.findViewById(R.id.lladminothersdelete);
        ll53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll54=(LinearLayout)v1.findViewById(R.id.lladminothersview);
        ll54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_other_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll6=(LinearLayout)v1.findViewById(R.id.lladmintransport);
        final LinearLayout ll61=(LinearLayout)v1.findViewById(R.id.lladmintransportupload);
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll61.getVisibility()==View.VISIBLE)
                {
                    ll61.setVisibility(View.GONE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladmintransportedit);
                    lladminedit.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladmintransportdelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladmintransportview);
                    lladminview.setVisibility(View.GONE);
                }
                else
                {
                    ll61.setVisibility(View.VISIBLE);
                    LinearLayout lladminedit=(LinearLayout)v1.findViewById(R.id.lladmintransportedit);
                    lladminedit.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladmintransportdelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladmintransportview);
                    lladminview.setVisibility(View.VISIBLE);
                }
            }
        });
        //LinearLayout ll61=(LinearLayout)v1.findViewById(R.id.lladmintransportupload);
        ll61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll62=(LinearLayout)v1.findViewById(R.id.lladmintransportedit);
        ll62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_edit.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll63=(LinearLayout)v1.findViewById(R.id.lladmintransportdelete);
        ll63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll64=(LinearLayout)v1.findViewById(R.id.lladmintransportview);
        ll64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_trans_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll7=(LinearLayout)v1.findViewById(R.id.lladminroomdetails);
        final LinearLayout ll71=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsupload);
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll71.getVisibility()==View.VISIBLE)
                {
                    ll71.setVisibility(View.GONE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsdelete);
                    lladmindelete.setVisibility(View.GONE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsview);
                    lladminview.setVisibility(View.GONE);
                }
                else
                {
                    ll71.setVisibility(View.VISIBLE);
                    LinearLayout lladmindelete=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsdelete);
                    lladmindelete.setVisibility(View.VISIBLE);
                    LinearLayout lladminview=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsview);
                    lladminview.setVisibility(View.VISIBLE);
                }

            }
        });
        //LinearLayout ll71 =(LinearLayout)v1.findViewById(R.id.lladminroomdetailsupload);
        ll71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_room_upload.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });

        LinearLayout ll72=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsdelete);
        ll72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_room_delete.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll73=(LinearLayout)v1.findViewById(R.id.lladminroomdetailsview);
        ll73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_guest_room_view.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
            }
        });
        LinearLayout ll8=(LinearLayout)v1.findViewById(R.id.lladminsendsms);
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity().getApplicationContext(),activity_admin_send_smscontactlist.class);
                startActivity(i1);
                getActivity().overridePendingTransition(R.anim.goup,R.anim.down);
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
                    message = message + "http://wedding.ajab-gajab.com:8080/wedding/app-debug.apk";
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

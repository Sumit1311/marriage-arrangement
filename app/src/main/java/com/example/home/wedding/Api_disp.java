package com.example.home.wedding;

import com.example.home.model.contactmodel;
import com.example.home.model.invitation;
import com.example.home.model.menu_details;
import com.example.home.model.other;
import com.example.home.model.participants;
import com.example.home.model.room;
import com.example.home.model.sangit;
import com.example.home.model.transport;
import com.example.home.model.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_disp {
    String url = "http://192.168.43.119/wedding/";
    @GET("disp_user.php")
    Call<List<user>> getuser();

    @GET("disp_invitation.php")
    Call<List<invitation>> getinvitation();

    @GET("disp_menu.php")
    Call<List<menu_details>> getmenudetails();

    @GET("disp_transport.php")
    Call<List<transport>> gettransportdetails();

    @GET("disp_participants.php")
    Call<List<participants>> getparticipants();

    @GET("disp_contact.php")
    Call<List<contactmodel>> getcontact();

    @GET("disp_room.php")
    Call<List<room>> getroom();

    @GET("disp_other.php")
    Call<List<other>> getothers();

    @GET("disp_sangit.php")
    Call<List<sangit>> getsangit();

}
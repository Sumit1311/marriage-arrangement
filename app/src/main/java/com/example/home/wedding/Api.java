package com.example.home.wedding;

import retrofit.Callback;
import retrofit2.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface Api{
    String url= "http://www.wedding.ajab-gajab.com:8080/wedding/";
    @FormUrlEncoded
    @POST("/insert_user.php")
    public void insertuser
            (
                    @Field("uname") String uname,
                    @Field("pwd") String pwd,
                    @Field("arrangertype") String arrangertype,
                    Callback<Response> callback);
    @FormUrlEncoded
    @POST("/insert_guest.php")
    public void insertguest
            (
                    @Field("cname") String cname,
                    @Field("cno") String cno,
                    @Field("type_of_guest") String type_of_guest,
                    @Field("guestaddr") String guestaddr,
                    @Field("guestcat") String guestcat,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_user.php")
    public void deleteuser
            (
                    @Field("uname") String uname,
                    Callback<Response> callback
            );


    @FormUrlEncoded
    @POST("/insert_menu.php")
    public void insertmenu
            (
                    @Field("menu_type") String menu_type,
                    @Field("menu_time") String menu_time,
                    @Field("menu_dt") String menu_dt,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/edit_menu.php")
    public void editmenu
            (
                    @Field("mid") int mid,
                    @Field("menu_type") String menu_type,
                    @Field("menu_time") String menu_time,
                    @Field("menu_dt") String menu_dt,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_menu.php")
    public void deletemenu
            (
                    @Field("mid") int mid,
                    Callback<Response> callback
            );

    @FormUrlEncoded
    @POST("/delete_invitation.php")
    public void deleteinvitation
            (
                    @Field("pageno") String pageno,
                    Callback<Response> callback
            );

    @FormUrlEncoded
    @POST("/insert_sangit.php")
    public void insertsangit
            (
                    @Field("venue") String venue,
                    @Field("poc") String poc,
                    @Field("description") String description,
                    @Field("timing") String timing,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_sangit.php")
    public void deletesangit
            (
                    @Field("venue") String venue,
                    Callback<Response> callback
            );

    @FormUrlEncoded
    @POST("/insert_other.php")
    public void insertother
            (
                    @Field("venue") String venue,
                    @Field("poc") String poc,
                    @Field("description") String description,
                    @Field("vidhiname") String vidhiname,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/edit_other.php")
    public void editother
            (
                    @Field("venue") String venue,
                    @Field("poc") String poc,
                    @Field("description") String description,
                    @Field("vidhiname") String vidhiname,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_other.php")
    public void deleteother
            (
                    @Field("vidhiname") String vidhiname,
                    Callback<Response> callback
            );

    @FormUrlEncoded
    @POST("/insert_transport.php")
    public void inserttransport
            (
                    @Field("route") String route,
                    @Field("drivername") String drivername,
                    @Field("driverno") String driverno,
                    @Field("vehicleno") String vehicleno,
                    @Field("dt") String dt,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/edit_transport.php")
    public void edittransport
            (
                    @Field("t_id") int t_id,
                    @Field("route") String route,
                    @Field("drivername") String drivername,
                    @Field("driverno") String driverno,
                    @Field("vehicleno") String vehicleno,
                    @Field("dt") String dt,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_transport.php")
    public void deletetransport
            (
                    @Field("t_id") int t_id,
                    Callback<Response> callback
            );


    @FormUrlEncoded
    @POST("/insert_roomguest.php")
    public void insertroomguest
            (
                    @Field("roomno") String roomno,
                    @Field("guest_nm") String guest_nm,
                    @Field("guest_mob") String guest_mob,
                    Callback<Response> callback);
    @FormUrlEncoded
    @POST("/delete_room.php")
    public void deleteroom
            (
                    @Field("roomno") String roomno,
                    Callback<Response> callback
            );

    @FormUrlEncoded
    @POST("/insert_participants.php")
    public void insertparticipants
            (
                    @Field("partname") String partname,
                    @Field("partno") String partno,
                    @Field("parttype") String parttype,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_participants.php")
    public void deleteparticipants
            (
                    @Field("partname") String partname,
                    Callback<Response> callback
            );

}

package com.example.home.wedding;

import retrofit.Callback;
import retrofit2.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface Api {
    String url="http://192.168.43.119/wedding/";
    @FormUrlEncoded
    @POST("/insert_menu.php")
    public void insertmenu
            (
                    @Field("menu_type") String menu_type,
                    @Field("menu_time") String menu_time,
                    @Field("menu_dt") String menu_dt,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/insert_sangit.php")
    public void insertsangit
            (
                    @Field("venue") String venue,
                    @Field("poc") String poc,
                    @Field("description") String description,
                    Callback<Response> callback);

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
    @POST("/insert_participants.php")
    public void insertparticipants
            (
                    @Field("partname") String partname,
                    @Field("partno") String partno,
                    @Field("parttype") String parttype,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/insert_transport.php")
    public void inserttransport
            (
                    @Field("route") String route,
                    @Field("drivername") String drivername,
                    @Field("driverno") String driverno,
                    @Field("vehicleno") String vehicleno,
                    @Field("date") String date,
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
    @POST("/edit_other.php")
    public void editother
            (
                    @Field("vidhiname") String vidhiname,
                    @Field("venue") String venue,
                    @Field("des") String des,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/edit_transport.php")
    public void edittransport
            (
                    @Field("route") String route,
                    @Field("drivername") String drivername,
                    @Field("driverno") int driverno,
                    @Field("vehicleno") String vehicleno,
                    @Field("transdate") String transdate,
                    Callback<Response> callback);

    @FormUrlEncoded
    @POST("/delete_menu.php")
    public void deletemenu
            (
                @Field("mid") int mid,
                Callback<Response> callback
            );
}

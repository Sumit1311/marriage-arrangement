package com.example.home.wedding;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api_insert {
    String url="http://192.168.43.119/wedding/";
    @Multipart
    @POST("Api.php?apicall=upload")
    Call<myResponse> uploadinvitation
            (@Part("image\"; filename=\"" +
                    "myfile.jpg\" ") RequestBody file,
             @Part("pageno") RequestBody pageno
            );
    @Multipart
    @POST("/")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("pageno") RequestBody pageno);

}

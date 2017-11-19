package com.vichit.khmersong.retrofit;

import com.vichit.khmersong.model.response.SingerResponse;
import com.vichit.khmersong.model.response.SongRequestByUser;
import com.vichit.khmersong.model.response.SongRespones;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SongService {


    @GET("api/v1/categories/1/songs")
    Call<SongRespones> findAllModernSong();

    @GET("api/v1/categories/2/songs")
    Call<SongRespones> findAllOldSong();

    @GET("api/v1/singers")
    Call<SingerResponse> findAllSinger();

    @GET("api/v1/songs")
    Call<SongRespones> findAllSongBySinger();

//    @GET("api/v1/songs")
//    Call<SongRespones> findAllSong();

    @FormUrlEncoded
    @POST("api/v1/request")
    Call<SongRequestByUser> songRequestByUser(@Field("song_name") String songName,
                                              @Field("singer_name") String singerName,
                                              @Field("general_input") String userInputDetail);
//    @POST("api/v1/request")
//    Call<SongRequestByUser> s (@Body SongRequest songRequest);


}

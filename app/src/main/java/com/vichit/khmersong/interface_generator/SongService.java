package com.vichit.khmersong.interface_generator;

import com.vichit.khmersong.song_respone.SingerResponse;
import com.vichit.khmersong.song_respone.SongRespones;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SongService {


    @GET("/api/v1/categories/2/songs")
    Call<SongRespones> findAllModernSong();

    @GET("api/v1/categories/1/songs")
    Call<SongRespones> findAllOldSong();

    @GET("api/v1/singers")
    Call<SingerResponse> findAllSinger();

    @GET("api/v1/songs")
    Call<SongRespones> findAllSongBySinger();




}

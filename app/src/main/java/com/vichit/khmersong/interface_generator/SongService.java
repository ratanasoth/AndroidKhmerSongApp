package com.vichit.khmersong.interface_generator;

import com.vichit.khmersong.song_respone.SongRespones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by VichitDeveloper on 8/4/17.
 */

public interface SongService {

    @GET("modern.php")
    Call<List<SongRespones>> findAllSong();

    @GET("old.php")
    Call<List<SongRespones>> findAllOldSong();

    @GET("singer.php")
    Call<List<SongRespones>> findSinger();


}

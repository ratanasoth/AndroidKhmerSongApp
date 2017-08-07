package com.vichit.khmersong.interface_generator;

import com.vichit.khmersong.song_respone.SongRespone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by VichitDeveloper on 8/4/17.
 */

public interface SongService {

    @GET("allsong.php")
    Call<List<SongRespone>> findAllSong();


}

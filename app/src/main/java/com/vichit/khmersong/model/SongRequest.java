package com.vichit.khmersong.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 8/26/17.
 */

public class SongRequest {
    @SerializedName("song_name")
    private int songName;
    @SerializedName("singer_name")
    private String singerName;
    @SerializedName("general_input")
    private String generalInput;

    public int getSongName() {
        return songName;
    }

    public void setSongName(int songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getGeneralInput() {
        return generalInput;
    }

    public void setGeneralInput(String generalInput) {
        this.generalInput = generalInput;
    }
}

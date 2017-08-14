package com.vichit.khmersong.song_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by VichitDeveloper on 8/12/17.
 */

public class SingerResponse {


    @SerializedName("Data")
    private List<Singer> singerList;

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSinger(List<Singer> singer) {
        this.singerList = singer;
    }

    public static class Singer {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String singerName;
        @SerializedName("image")
        private String singerImage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSingerName() {
            return singerName;
        }

        public void setName(String name) {
            this.singerName = name;
        }

        public String getSingerImage() {
            return singerImage;
        }

        public void setImage(String image) {
            this.singerImage = image;
        }
    }
}

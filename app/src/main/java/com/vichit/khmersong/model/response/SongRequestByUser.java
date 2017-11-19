package com.vichit.khmersong.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VichitDeveloper on 8/19/17.
 */

public class SongRequestByUser {



    @SerializedName("STATUS")
    private boolean status;
    @SerializedName("DATA")
    private Song song;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public static class Song {
        @SerializedName("song_name")
        private String songName;
        @SerializedName("singer_name")
        private String singerName;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("id")
        private int id;

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public String getSingerName() {
            return singerName;
        }

        public void setSingerName(String singerName) {
            this.singerName = singerName;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

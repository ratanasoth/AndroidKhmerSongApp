package com.vichit.khmersong.song_respone;

import com.google.gson.annotations.SerializedName;

public class SongRespone {


    @SerializedName("id")
    private String id;

    @SerializedName("song_name")
    private String songName;

    @SerializedName("song_url")
    private String songUrl;

    @SerializedName("singer_name")
    private String singerName;

    @SerializedName("singer_image")
    private String singerImage;

    @SerializedName("type_name")
    private String typeName;

    @SerializedName("category_name")
    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerImage() {
        return singerImage;
    }

    public void setSingerImage(String singerImage) {
        this.singerImage = singerImage;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "SongRespone{" +
                "id='" + id + '\'' +
                ", songName='" + songName + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", singerName='" + singerName + '\'' +
                ", singerImage='" + singerImage + '\'' +
                ", typeName='" + typeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

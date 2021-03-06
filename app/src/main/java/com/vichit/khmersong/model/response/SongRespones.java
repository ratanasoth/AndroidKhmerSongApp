package com.vichit.khmersong.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.R.attr.name;

public class SongRespones {


    @SerializedName("Data")
    private List<Songs> songs;

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public static class Category {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
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

        @Override
        public String toString() {
            return "Singer{" +
                    "id=" + id +
                    ", singerName='" + singerName + '\'' +
                    ", singerImage='" + singerImage + '\'' +
                    '}';
        }
    }

    public static class Type {
        @SerializedName("id")
        private int id;
        @SerializedName("type")
        private String typeName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setType(String type) {
            this.typeName = type;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "id=" + id +
                    ", typeName='" + typeName + '\'' +
                    '}';
        }
    }

    public static class Songs {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String SongName;
        @SerializedName("url")
        private String songUrl;
        @SerializedName("category")
        private Category category;
        @SerializedName("singer")
        private Singer singer;
        @SerializedName("type")
        private Type type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSongName() {
            return SongName;
        }

        public void setName(String name) {
            this.SongName = name;
        }

        public String getSongUrl() {
            return songUrl;
        }

        public void setUrl(String url) {
            this.songUrl = url;
        }


        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Singer getSinger() {
            return singer;
        }

        public void setSinger(Singer singer) {
            this.singer = singer;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Songs{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", url='" + songUrl + '\'' +
                    ", singer=" + singer +
                    ", type=" + type +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SongRespones{" +
                "songs=" + songs +
                '}';
    }
}
package com.vichit.khmersong.song_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by VichitDeveloper on 8/4/17.
 */

public class SongRespone {


    @SerializedName("data")
    private List<Songs> listSong;

    public List<Songs> getSong() {
        return listSong;
    }

    public void setSong(List<Songs> listSong) {
        this.listSong = listSong;
    }

    public static class Songs {

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("url")
        private String url;

        @SerializedName("categories_id")
        private int categoriesId;

        @SerializedName("singers_id")
        private int singersId;

        @SerializedName("types_id")
        private int typesId;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("updated_at")
        private String updatedAt;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCategoriesId() {
            return categoriesId;
        }

        public void setCategoriesId(int categoriesId) {
            this.categoriesId = categoriesId;
        }

        public int getSingersId() {
            return singersId;
        }

        public void setSingersId(int singersId) {
            this.singersId = singersId;
        }

        public int getTypesId() {
            return typesId;
        }

        public void setTypesId(int typesId) {
            this.typesId = typesId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}

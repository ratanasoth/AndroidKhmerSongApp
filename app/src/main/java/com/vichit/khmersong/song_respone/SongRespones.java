package com.vichit.khmersong.song_respone;

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
    }

    public static class Songs {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String SongName;
        @SerializedName("url")
        private String songUrl;
        @SerializedName("categories_id")
        private int categoriesId;
        @SerializedName("singers_id")
        private int singersId;
        @SerializedName("types_id")
        private int typesId;
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
                    ", categoriesId=" + categoriesId +
                    ", singersId=" + singersId +
                    ", typesId=" + typesId +
                    ", category=" + category +
                    ", singer=" + singer +
                    ", type=" + type +
                    '}';
        }
    }

}
//
//
//    @SerializedName("id")
//    private String id;
//
//    @SerializedName("song_name")
//    private String songName;
//
//    @SerializedName("song_url")
//    private String songUrl;
//
//    @SerializedName("singer_name")
//    private String singerName;
//
//    @SerializedName("singer_image")
//    private String singerImage;
//
//    @SerializedName("type_name")
//    private String typeName;
//
//    @SerializedName("category_name")
//    private String categoryName;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getSongName() {
//        return songName;
//    }
//
//    public void setSongName(String songName) {
//        this.songName = songName;
//    }
//
//    public String getSongUrl() {
//        return songUrl;
//    }
//
//    public void setSongUrl(String songUrl) {
//        this.songUrl = songUrl;
//    }
//
//    public String getSingerName() {
//        return singerName;
//    }
//
//    public void setSingerName(String singerName) {
//        this.singerName = singerName;
//    }
//
//    public String getSingerImage() {
//        return singerImage;
//    }
//
//    public void setSingerImage(String singerImage) {
//        this.singerImage = singerImage;
//    }
//
//    public String getTypeName() {
//        return typeName;
//    }
//
//    public void setTypeName(String typeName) {
//        this.typeName = typeName;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    @Override
//    public String toString() {
//        return "SongRespones{" +
//                "id='" + id + '\'' +
//                ", songName='" + songName + '\'' +
//                ", songUrl='" + songUrl + '\'' +
//                ", singerName='" + singerName + '\'' +
//                ", singerImage='" + singerImage + '\'' +
//                ", typeName='" + typeName + '\'' +
//                ", categoryName='" + categoryName + '\'' +
//                '}';
//    }
//}

package com.vichit.khmersong.model;


public class MusicModel {

    private String titleName;
    private String singerName;
    private int pathUrl;
    private String profile;

    public MusicModel(String titleName, String singerName, String profile, int pathUrl) {
        this.titleName = titleName;
        this.singerName = singerName;
        this.pathUrl = pathUrl;
        this.profile = profile;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(int pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }




}

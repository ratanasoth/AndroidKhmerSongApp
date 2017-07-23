package com.vichit.khmersong.model;

/**
 * Created by VichitDeveloper on 7/22/17.
 */

public class MusicModel {

    private String titleName;
    private String singerName;
    private String pathUrl;
    private String ivProfile;


    public MusicModel(String titleName, String singerName, String ivProfile, String pathUrl) {
        this.titleName = titleName;
        this.pathUrl = pathUrl;
        this.singerName = singerName;
        this.ivProfile = ivProfile;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getIvProfile() {
        return ivProfile;
    }

    public void setIvProfile(String ivProfile) {
        this.ivProfile = ivProfile;
    }
}

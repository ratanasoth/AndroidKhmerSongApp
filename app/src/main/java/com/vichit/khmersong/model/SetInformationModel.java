package com.vichit.khmersong.model;

/**
 * Created by VichitDeveloper on 8/22/17.
 */

public class SetInformationModel {

    private int image;
    private int tvClearMemory;

    public SetInformationModel(int image, int tvClearMemory) {
        this.image = image;
        this.tvClearMemory = tvClearMemory;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTvClearMemory() {
        return tvClearMemory;
    }

    public void setTvClearMemory(int tvClearMemory) {
        this.tvClearMemory = tvClearMemory;
    }
}

package com.vichit.khmersong.model.local;

import android.support.v4.app.Fragment;

/**
 * Created by VichitDeveloper on 7/22/17.
 */

public class TabModel {

    private String title;
    private Fragment fragment;
    private int icon;

    public TabModel(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

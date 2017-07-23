package com.vichit.khmersong.adapter_tab.model;

import android.support.v4.app.Fragment;

/**
 * Created by VichitDeveloper on 7/22/17.
 */

public class Tab {

    private String title;
    private Fragment fragment;
    private int icon;

    public Tab(String title, Fragment fragment) {
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

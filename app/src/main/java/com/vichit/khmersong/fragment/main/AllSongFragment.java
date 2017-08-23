package com.vichit.khmersong.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;

public class AllSongFragment extends Fragment {

    public AllSongFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_all_song, container, false);
    }

}

package com.vichit.khmersong.ui.fragment.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_tab.adapter.MyPagerApdapter;
import com.vichit.khmersong.model.local.TabModel;
import com.vichit.khmersong.ui.fragment.fragment_tab.SubFragmentModernMusic;
import com.vichit.khmersong.ui.fragment.fragment_tab.SubFragmentOldMusic;

public class MainFragmentSong extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    MyPagerApdapter adapter;
    SubFragmentModernMusic subFragmentModernMusic;
    SubFragmentOldMusic subFragmentOldMusic;

    public MainFragmentSong() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.activity_title_song_session));
        View v = inflater.inflate(R.layout.fragment_main_song, container, false);

        subFragmentModernMusic = new SubFragmentModernMusic();
        subFragmentOldMusic = new SubFragmentOldMusic();

        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new MyPagerApdapter(getChildFragmentManager(), getContext());
        adapter.addTab(new TabModel(getString(R.string.tab_modern_song), subFragmentModernMusic));
        adapter.addTab(new TabModel(getString(R.string.tab_classic_song), subFragmentOldMusic));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}

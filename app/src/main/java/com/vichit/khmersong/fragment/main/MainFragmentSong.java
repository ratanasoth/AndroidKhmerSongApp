package com.vichit.khmersong.fragment.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_tab.adapter.MyPagerApdapter;
import com.vichit.khmersong.adapter_tab.model.Tab;
import com.vichit.khmersong.fragment.fragment_tab.SubFragmentModernMusic;
import com.vichit.khmersong.fragment.fragment_tab.SubFragmentOldMusic;

public class MainFragmentSong extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    MyPagerApdapter adapter;
    SubFragmentModernMusic subFragmentModernMusic;
    SubFragmentOldMusic subFragmentOldMusic;

    public MainFragmentSong() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_song, container, false);

        subFragmentModernMusic = new SubFragmentModernMusic();
        subFragmentOldMusic = new SubFragmentOldMusic();

        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);

        Log.e("ppppp", "onCreateView MainFragment");
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new MyPagerApdapter(getChildFragmentManager(), getContext());
        adapter.addTab(new Tab("ចម្រៀងសម័យ", subFragmentModernMusic));
        adapter.addTab(new Tab("ចម្រៀងបុរាណ", subFragmentOldMusic));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Log.e("ppppp", "MainFragment" + adapter.toString());

        Log.e("ppppp", "onViewCreated MainFragment");


    }

}

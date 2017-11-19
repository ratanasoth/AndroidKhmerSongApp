package com.vichit.khmersong.adapter_tab.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.vichit.khmersong.R;
import com.vichit.khmersong.model.local.TabModel;

import java.util.ArrayList;
import java.util.List;


public class MyPagerApdapter extends FragmentPagerAdapter {

    List<TabModel> tabList;
    Context context;

    public MyPagerApdapter(FragmentManager fm, Context context) {
        super(fm);
        tabList = new ArrayList<>();
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return tabList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position).getTitle();
        //return null;
    }

    public void addTab(TabModel tab) {
        tabList.add(tab);

    }


    //Dynamic TabModel
    public void tabLayoutIcon(TabLayout tabLayout) {
        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.getTabAt(i).setIcon(tabList.get(i).getIcon());
        }
    }


    //Custom TabModel
    public void changeTablayoutCustomIcon(TabLayout tabLayout) {
        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.getTabAt(i).setCustomView(getCustomView(i));
        }
    }

    //Custom TabModel
    private View getCustomView(int position) {
        TabModel tab = tabList.get(position);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tvTitle = (TextView) v.findViewById(R.id.tv_newMusic);
//        ImageView ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
        tvTitle.setText(tab.getTitle());
//        ivIcon.setImageResource(tab.getIcon());
        return v;
    }

}

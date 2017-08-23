package com.vichit.khmersong.fragment.main;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.FavoriteCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.constant_key.SharePreferenceKey;
import com.vichit.khmersong.song_respone.SongRespones;

import java.lang.reflect.Type;
import java.util.List;

public class FavoriteFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnClickListener {
    RecyclerView rvFavorite;
    FavoriteCustomAdapter adapter;
    List<SongRespones.Songs> songSharePreference;
    SwipeRefreshLayout swipeRefreshFavorite;
    String getSongJson;
    OnPassData onPassData;
    SharedPreferences sharedPreferences;


    public FavoriteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        getActivity().setTitle(R.string.nav_saveSong);

        rvFavorite = (RecyclerView) view.findViewById(R.id.rvFavorite);
        rvFavorite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        swipeRefreshFavorite = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshFavorite);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new FavoriteCustomAdapter(getContext());
        getAllSharePreference();

        swipeRefreshFavorite.setOnRefreshListener(this);
        adapter.setOnClickListener(this);

    }

    @Override
    public void onRefresh() {
        getAllSharePreference();
        swipeRefreshFavorite.setRefreshing(false);
    }

    private void getAllSharePreference() {

        sharedPreferences = getContext().getSharedPreferences(SharePreferenceKey.SONG_LIST, Context.MODE_PRIVATE);


        getSongJson = sharedPreferences.getString(SharePreferenceKey.SONG_LIST, "N/A");

        if (!getSongJson.equals("N/A")) {
            Type type = new TypeToken<List<SongRespones.Songs>>() {
            }.getType();
            songSharePreference = new Gson().fromJson(getSongJson, type);
            if (songSharePreference.size() == 0) {
                Toast.makeText(getContext(), R.string.toast_not_have_favorite, Toast.LENGTH_SHORT).show();
            }

            adapter.addMoreItem(songSharePreference);
            rvFavorite.setAdapter(adapter);

        }


    }

    @Override
    public void onClickView(final int position, View view) {

        final PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.inflate(R.menu.remove_favorite);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popup_remove_favorite:
                        songSharePreference.remove(position);
                        addSongToSharePreference();
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();


    }

    @Override
    public void onItemClick(List<SongRespones.Songs> songList, int postion) {
        sendData(songList, postion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            onPassData = (OnPassData) activity;
        }
    }

    //send data to activity
    public void sendData(List<SongRespones.Songs> songList, int postion) {
        onPassData.onPassDataToActivity(songList, postion);

    }

    private void addSongToSharePreference() {

        getSongJson = sharedPreferences.getString(SharePreferenceKey.SONG_LIST, "N/A");
        SharedPreferences.Editor editor = sharedPreferences.edit();

        getSongJson = new Gson().toJson(songSharePreference);
        editor.putString(SharePreferenceKey.SONG_LIST, getSongJson);
        editor.apply();
    }
}

package com.vichit.khmersong.fragment.fragment_tab;


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
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.constant_key.SharePreferenceKey;
import com.vichit.khmersong.interface_generator.SongService;
import com.vichit.khmersong.service_generator.ServiceGenerator;
import com.vichit.khmersong.song_respone.SongRespones;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubFragmentModernMusic extends Fragment implements OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    RecyclerView rvModernSong;
    MusicCustomAdapter adapter;
    SongRespones songRespones;
    OnPassData onPassData;
    List<SongRespones.Songs> songList;
    SwipeRefreshLayout swipeRefreshModernSong;
    SongService songService;


    public SubFragmentModernMusic() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sub_fragment_modern_music, container, false);
        getActivity().setTitle(R.string.nav_newSong);

        rvModernSong = (RecyclerView) v.findViewById(R.id.rvModernMusic);
        rvModernSong.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        swipeRefreshModernSong = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshModernSong);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        songList = new ArrayList<>();
        adapter = new MusicCustomAdapter(getContext());
        getAllSong();

        adapter.setOnClickListener(this);
        swipeRefreshModernSong.setOnRefreshListener(this);
    }

    //refresh
    @Override
    public void onRefresh() {
        getAllSong();
        adapter.notifyDataSetChanged();
        swipeRefreshModernSong.setRefreshing(false);
    }


    @Override
    public void onClickView(final int position, View view) {
        songList = songRespones.getSongs();
        actionManu(position, songList, view, getContext());


    }

    //send data to activity
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

    @Override
    public void onItemClick(List<SongRespones.Songs> songList, int postion) {
        sendData(songList, postion);

    }

    //response all song
    private void getAllSong() {
        songService = ServiceGenerator.createService(SongService.class);
        Call<SongRespones> callAllModernSong = songService.findAllModernSong();
        callAllModernSong.enqueue(new Callback<SongRespones>() {
            @Override
            public void onResponse(Call<SongRespones> call, Response<SongRespones> response) {
                songRespones = response.body();
                adapter.addMoreItem(songRespones.getSongs());
                rvModernSong.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SongRespones> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //static method that save data into share preference.
    public static void actionManu(final int position, final List<SongRespones.Songs> songList, View view, final Context context) {

        PopupMenu popupMenu = new PopupMenu(context, view);

        final SharedPreferences sharedPreferences = context.getSharedPreferences(
                SharePreferenceKey.SONG_LIST, Context.MODE_PRIVATE);

        String getSongToJson = sharedPreferences.getString(SharePreferenceKey.SONG_LIST, "[]");

        Type type = new TypeToken<List<SongRespones.Songs>>() {
        }.getType();
        final List<SongRespones.Songs> songSharePreference = new Gson().fromJson(getSongToJson, type);

        if (isSongExist(songSharePreference, songList.get(position))) {

            popupMenu.inflate(R.menu.remove_favorite);

        } else {
            popupMenu.inflate(R.menu.add_favorite);
        }

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popup_Favorite:

                        songSharePreference.add(songList.get(position));
                        showMessage(context.getString(R.string.toast_data_save), context);
                        break;
                    case R.id.popup_remove_favorite:

                        if (isDeleted(songSharePreference, songList.get(position))) {
                            showMessage(context.getString(R.string.toast_data_was_delete), context);
                        }
                        break;
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();

                String songJson = new Gson().toJson(songSharePreference);

                editor.putString(SharePreferenceKey.SONG_LIST, songJson);
                editor.apply();

                return false;
            }
        });
        popupMenu.show();
    }

    /*
    comparing song response with share preference to show manu.
    if song that responded have in share preference, it's show menu remove_favorite
    but if song that responded don't have in share preference, it's show menu add_favorite
     */
    private static boolean isSongExist(List<SongRespones.Songs> songList, SongRespones.Songs song) {
        for (SongRespones.Songs s : songList) {
            if (s.getId() == song.getId()) {

                return true;
            }
        }
        return false;
    }

    /*
    if song that responded have in share preference, it's will delete when we click.
    but if song that responded don't have in share preference, it's cannot delete.
     */
    public static boolean isDeleted(List<SongRespones.Songs> songList, SongRespones.Songs song) {
        for (SongRespones.Songs s : songList) {
            if (s.getId() == song.getId()) {
                songList.remove(s);
                return true;
            }
        }
        return false;
    }

    private static void showMessage(String message, Context context) {
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }

}


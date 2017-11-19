package com.vichit.khmersong.ui.fragment.fragment_tab;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.retrofit.SongService;
import com.vichit.khmersong.retrofit.ServiceGenerator;
import com.vichit.khmersong.model.response.SongRespones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubFragmentOldMusic extends Fragment implements OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    RecyclerView rvOldMusic;
    List<SongRespones.Songs> songList;
    MusicCustomAdapter adapter;
    OnPassData onPassData;
    SongRespones songRespones;
    SongService songService;
    SwipeRefreshLayout swipeRefreshOldSong;


    public SubFragmentOldMusic() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_fragment_old_music, container, false);
        rvOldMusic = (RecyclerView) view.findViewById(R.id.rvOldMusic);
        rvOldMusic.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, true));

        swipeRefreshOldSong = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshOldSong);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        songList = new ArrayList<>();
        adapter = new MusicCustomAdapter(getContext());
        getAllOldSong();

        adapter.setOnClickListener(this);
        swipeRefreshOldSong.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        getAllOldSong();
        swipeRefreshOldSong.setRefreshing(false);
    }

    private void getAllOldSong() {
        songService = ServiceGenerator.createService(SongService.class);
        Call<SongRespones> callAllOldSong = songService.findAllOldSong();
        callAllOldSong.enqueue(new Callback<SongRespones>() {
            @Override
            public void onResponse(Call<SongRespones> call, Response<SongRespones> response) {
                songRespones = response.body();
                if (songRespones != null) {
                    adapter.addMoreItem(songRespones.getSongs());
                    rvOldMusic.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<SongRespones> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    @Override
    public void onClickView(int position, View view) {
        if (songList != null) {
            songList = songRespones.getSongs();
            SubFragmentModernMusic.actionManu(position, songList, view, getContext());
        }

    }

    @Override
    public void onItemClick(List<SongRespones.Songs> songList, int postion) {
        sendData(songList, postion);

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

    //send data to activity using calback interface
    public void sendData(List<SongRespones.Songs> songList, int postion) {
        onPassData.onPassDataToActivity(songList, postion);

    }


}

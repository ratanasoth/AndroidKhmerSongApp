package com.vichit.khmersong.ui.fragment.detail_fragment;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.Toast;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.ui.fragment.fragment_tab.SubFragmentModernMusic;
import com.vichit.khmersong.retrofit.SongService;
import com.vichit.khmersong.retrofit.ServiceGenerator;
import com.vichit.khmersong.model.response.SongRespones;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailSingerSongFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnClickListener {
    List<SongRespones.Songs> listSong;
    SongRespones songRespones;
    List<SongRespones.Songs> selectedSingersSongs;
    SongService songService;
    MusicCustomAdapter adapter;
    RecyclerView rvSongBySinger;
    SwipeRefreshLayout swipeRefreshSingerDetail;
    OnPassData onPassData;
    int getSingerId;
    private AlertDialog progressDialog;


    public DetailSingerSongFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("តារាចម្រៀង");
        View view = inflater.inflate(R.layout.fragment_detail_singer_song, container, false);

        rvSongBySinger = (RecyclerView) view.findViewById(R.id.rvDetailSingerSong);
        rvSongBySinger.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        swipeRefreshSingerDetail = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshDetailSinger);
        swipeRefreshSingerDetail.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        getSingerId = bundle.getInt("key");

        adapter = new MusicCustomAdapter(getContext());
        getAllSongBySinger();

        progressDialog = new SpotsDialog(getContext(), R.style.customDialog);
        progressDialog.show();

        adapter.setOnClickListener(this);

    }

    @Override
    public void onRefresh() {
        getAllSongBySinger();
        swipeRefreshSingerDetail.setRefreshing(false);

    }


    private void getAllSongBySinger() {
        songService = ServiceGenerator.createService(SongService.class);
        Call<SongRespones> callAllSong = songService.findAllSongBySinger();
        callAllSong.enqueue(new Callback<SongRespones>() {
            @Override
            public void onResponse(Call<SongRespones> call, Response<SongRespones> response) {
                selectedSingersSongs = new ArrayList<>();
                songRespones = response.body();
                listSong = songRespones.getSongs();

                for (SongRespones.Songs songs : listSong) {
                    if (songs.getSinger().getId() == getSingerId) {
                        selectedSingersSongs.add(songs);
                    }
                }
                if (selectedSingersSongs != null) {
                    adapter.addMoreItem(selectedSingersSongs);
                    rvSongBySinger.setAdapter(adapter);
                }
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<SongRespones> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
            }
        });

    }


    //click on menu
    @Override
    public void onClickView(int position, View view) {

        SubFragmentModernMusic.actionManu(position, selectedSingersSongs, view, getContext());


    }

    //reference with activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            onPassData = (OnPassData) activity;
        }
    }

    //click item
    @Override
    public void onItemClick(List<SongRespones.Songs> songList, int postion) {
        sendData(selectedSingersSongs, postion);

    }

    public void sendData(List<SongRespones.Songs> songList, int postion) {
        onPassData.onPassDataToActivity(selectedSingersSongs, postion);

    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}

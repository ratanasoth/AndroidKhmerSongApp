package com.vichit.khmersong.ui.fragment.main;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.SingerCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.ui.fragment.detail_fragment.DetailSingerSongFragment;
import com.vichit.khmersong.retrofit.SongService;
import com.vichit.khmersong.retrofit.ServiceGenerator;
import com.vichit.khmersong.model.response.SingerResponse;
import com.vichit.khmersong.model.response.SongRespones;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnClickListener {
    RecyclerView rvSinger;
    List<SingerResponse.Singer> singersList;
    SingerResponse singerResponse;
    SingerCustomAdapter adapter;
    SwipeRefreshLayout swipeRefreshSinger;
    private AlertDialog progressDialog;


    public SingerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.nav_singer);

        View view = inflater.inflate(R.layout.fragment_singer, container, false);
        rvSinger = (RecyclerView) view.findViewById(R.id.rvSinger);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2,
                LinearLayoutManager.VERTICAL, false);
        rvSinger.setLayoutManager(gridLayoutManager);

        swipeRefreshSinger = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshSinger);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        singersList = new ArrayList<>();
        adapter = new SingerCustomAdapter(getContext());
        getAllSinger();

        progressDialog = new SpotsDialog(getContext(), R.style.customDialog);
        progressDialog.show();

        swipeRefreshSinger.setOnRefreshListener(this);
        adapter.setOnItemClick(this);

    }

    @Override
    public void onRefresh() {
        getAllSinger();
        swipeRefreshSinger.setRefreshing(false);
    }

    private void getAllSinger() {
        SongService songService = ServiceGenerator.createService(SongService.class);
        Call<SingerResponse> callAllSinger = songService.findAllSinger();
        callAllSinger.enqueue(new Callback<SingerResponse>() {
            @Override
            public void onResponse(Call<SingerResponse> call, Response<SingerResponse> response) {
                singerResponse = response.body();
                if (singerResponse != null) {
                    adapter.addMoreSong(singerResponse.getSingerList());
                    rvSinger.setAdapter(adapter);
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<SingerResponse> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
            }
        });
    }


    @Override
    public void onClickView(int position, View view) {

        DetailSingerSongFragment detailSingerSongFragment = new DetailSingerSongFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", singerResponse.getSingerList().get(position).getId());
        detailSingerSongFragment.setArguments(bundle);

        FragmentManager transaction = getActivity().getSupportFragmentManager();
        transaction.beginTransaction()
                .replace(R.id.contentMain, detailSingerSongFragment)
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void onItemClick(List<SongRespones.Songs> songList, int postion) {

    }
}


















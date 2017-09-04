//package com.vichit.khmersong.fragment.main;
//
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.vichit.khmersong.R;
//import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
//import com.vichit.khmersong.callback.OnClickListener;
//import com.vichit.khmersong.callback.OnPassData;
//import com.vichit.khmersong.fragment.fragment_tab.SubFragmentModernMusic;
//import com.vichit.khmersong.interface_generator.SongService;
//import com.vichit.khmersong.service_generator.ServiceGenerator;
//import com.vichit.khmersong.song_respone.SongRespones;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import dmax.dialog.SpotsDialog;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class AllSongFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnClickListener {
//
//    private RecyclerView rvAllSong;
//    private SwipeRefreshLayout swipeRefreshAllSong;
//    private List<SongRespones.Songs> songsList;
//    private SongRespones songRespones;
//    private SongService songService;
//    private MusicCustomAdapter adapter;
//    private OnPassData onPassData;
//    private AlertDialog progressDialog;
//    private Handler handler;
//
//
//    public AllSongFragment() {
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        getActivity().setTitle(getString(R.string.activity_home));
//        View view = inflater.inflate(R.layout.fragment_all_song, container, false);
//
//        rvAllSong = (RecyclerView) view.findViewById(R.id.rvAllSong);
//        rvAllSong.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//
//        swipeRefreshAllSong = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshAllSong);
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        songsList = new ArrayList<>();
//        adapter = new MusicCustomAdapter(getContext());
//        getAllSong();
//
//        progressDialog = new SpotsDialog(getContext(), R.style.customDialog);
//        progressDialog.show();
//
//        swipeRefreshAllSong.setOnRefreshListener(this);
//        adapter.setOnClickListener(this);
//
//
//    }
//
//    @Override
//    public void onRefresh() {
//        getAllSong();
//        swipeRefreshAllSong.setRefreshing(false);
//
//    }
//
//    @Override
//    public void onClickView(int position, View view) {
//        songsList = songRespones.getSongs();
//        SubFragmentModernMusic.actionManu(position, songsList, view, getContext());
//
//    }
//
//    @Override
//    public void onItemClick(List<SongRespones.Songs> songList, int position) {
//        sendData(songList, position);
//
//    }
//
//    //send data to activity
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity;
//        if (context instanceof Activity) {
//            activity = (Activity) context;
//            onPassData = (OnPassData) activity;
//        }
//    }
//
//    //send data to activity
//    public void sendData(List<SongRespones.Songs> songList, int postion) {
//        onPassData.onPassDataToActivity(songList, postion);
//
//    }
//
//    private void getAllSong() {
//        songService = ServiceGenerator.createService(SongService.class);
//        Call<SongRespones> callAllModernSong = songService.findAllSong();
//        callAllModernSong.enqueue(new Callback<SongRespones>() {
//            @Override
//            public void onResponse(Call<SongRespones> call, Response<SongRespones> response) {
//                songRespones = response.body();
//                if (songRespones != null) {
//                    adapter.addMoreItem(songRespones.getSongs());
//                    rvAllSong.setAdapter(adapter);
//                    progressDialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SongRespones> call, Throwable t) {
//                t.printStackTrace();
//                progressDialog.dismiss();
//            }
//        });
//
//    }
//
//
//}

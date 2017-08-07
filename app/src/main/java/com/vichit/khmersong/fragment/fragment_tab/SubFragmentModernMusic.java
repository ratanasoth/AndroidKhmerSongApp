package com.vichit.khmersong.fragment.fragment_tab;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.interface_generator.SongService;
import com.vichit.khmersong.service_generator.ServiceGenerator;
import com.vichit.khmersong.song_respone.SongRespone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubFragmentModernMusic extends Fragment implements OnClickListener {
    RecyclerView rvModernMusic;
    MusicCustomAdapter adapter;
    SongRespone songRespone;
    List<SongRespone> songList;
    OnPassData onPassData;


    public SubFragmentModernMusic() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sub_fragment_modern_music, container, false);

        rvModernMusic = (RecyclerView) v.findViewById(R.id.rvModernMusic);
        rvModernMusic.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        songList = new ArrayList<>();

        SongService songService = ServiceGenerator.createService(SongService.class);
        Call<List<SongRespone>> call = songService.findAllSong();
        call.enqueue(new Callback<List<SongRespone>>() {
            @Override
            public void onResponse(Call<List<SongRespone>> call, Response<List<SongRespone>> response) {
                adapter = new MusicCustomAdapter(response.body(), getContext());
                rvModernMusic.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SongRespone>> call, Throwable t) {
                Log.e("pppppp", "onFailure");
                t.printStackTrace();
            }
        });


//        adapter.setOnClickListener(this);


    }

    @Override
    public void onClickView(int position, View view) {
        songRespone = songList.get(position);
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.inflate(R.menu.add_favorite);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popup_Favorite:
                        showMessage("Favorite");
                        break;
                    case R.id.popup_cencel:
                        showMessage("Cencel");
                        break;
                }

                return false;
            }

        });
        popupMenu.show();

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
    public void sendData(List<SongRespone> songList, int postion) {
        onPassData.onPassDataToActivity(songList, postion);

    }

    @Override
    public void onItemClick(List<SongRespone> songList, int postion) {
        sendData(songList, postion);
        Log.e("ppppp", "send");

    }


    private void showMessage(String message) {
        Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
    }
}

















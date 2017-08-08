package com.vichit.khmersong.fragment.fragment_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.song_respone.SongRespones;

import java.util.ArrayList;
import java.util.List;

public class SubFragmentOldMusic extends Fragment implements OnClickListener {

    RecyclerView rvOldMusic;
    List<SongRespones> songList;
    MusicCustomAdapter adapter;
    SongRespones songRespones;
    OnPassData onPassData;


    public SubFragmentOldMusic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_fragment_old_music, container, false);
        rvOldMusic = (RecyclerView) view.findViewById(R.id.rvOldMusic);
        rvOldMusic.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        songList = new ArrayList<>();

        //adapter = new MusicCustomAdapter(songList, getContext());
        rvOldMusic.setAdapter(adapter);

//        adapter.setOnClickListener(this);

    }


    @Override
    public void onClickView(int position, View view) {
        songRespones = songList.get(position);
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

    @Override
    public void onItemClick(List<SongRespones> songList, int postion) {

    }




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
//    @Override
//    public void onItemClick(List<SongRespones> songList, int position) {
//        sendData(songList, position);
//
//    }


//    //send data to activity using calback interface
//    public void sendData(List<SongRespones> songList, int postion) {
//        onPassData.onPassDataToActivity(songList, postion);
//
//    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}

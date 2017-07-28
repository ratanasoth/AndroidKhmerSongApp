package com.vichit.khmersong.fragment.fragment_tab;


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
import com.vichit.khmersong.model.MusicModel;

import java.util.ArrayList;
import java.util.List;


public class SubFragmentModernMusic extends Fragment implements OnClickListener {
    RecyclerView rvModernMusic;
    MusicCustomAdapter adapter;
    MusicModel musicModel;
    List<MusicModel> musicModelList;


    public SubFragmentModernMusic() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sub_fragment_modern_music, container, false);

        rvModernMusic = (RecyclerView) v.findViewById(R.id.rvModernMusic);

        rvModernMusic.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        Log.e("pppp", "onCreateView SubFragment");
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        musicModelList = new ArrayList<>();
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", R.raw.audio1.mp3));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "audio2.mp3"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", "fd"));


        adapter = new MusicCustomAdapter(musicModelList, getContext());
        rvModernMusic.setAdapter(adapter);

        adapter.setOnClickListener(this);
    }

    @Override
    public void onClickView(int position, View view) {
        musicModel = musicModelList.get(position);
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
    public void onItemClick(int postion) {
        showMessage(postion + "");

    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
    }
}

















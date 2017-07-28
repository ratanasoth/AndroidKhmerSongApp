package com.vichit.khmersong.fragment.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.SingerCustomAdapter;
import com.vichit.khmersong.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingerFragment extends Fragment {
    RecyclerView rvSinger;
    List<MusicModel> musicModelList;
    MusicModel musicModel;
    SingerCustomAdapter adapter;


    public SingerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_singer, container, false);
        rvSinger = (RecyclerView) view.findViewById(R.id.rvSinger);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2,
                LinearLayoutManager.VERTICAL, false);
        rvSinger.setLayoutManager(gridLayoutManager);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        musicModelList = new ArrayList<>();
//
//        musicModelList.add(new MusicModel("បទ៖ ស្រលាញ់គីគីលូ", "ខេមរះ សេរីមន្ត", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", R.raw.audio1));
//        musicModelList.add(new MusicModel("បទ៖ ស្រលាញ់គីគីលូ", "ខេមរះ សេរីមន្ត", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", R.raw.audio1));
//        musicModelList.add(new MusicModel("បទ៖ បងពីមុនឆ្កួតបាត់ហើយ", "ឆាយ វីរះយុទ្ធ", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", R.raw.audio2));
//        musicModelList.add(new MusicModel("បទ៖ ស្រលាញ់គីគីលូ", "ខេមរះ សេរីមន្ត", "http://jomnor.com/images/pictures/thumb/artist/khmer-modern-singers/chhay-virakyuth.jpg", R.raw.audio1));

        adapter = new SingerCustomAdapter(musicModelList, getContext());
        rvSinger.setAdapter(adapter);


    }

}


















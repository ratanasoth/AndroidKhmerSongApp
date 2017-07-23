package com.vichit.khmersong.fragment.fragment_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.MusicCustomAdapter;
import com.vichit.khmersong.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubFragmentOldMusic extends Fragment {
    RecyclerView rvOldMusic;
    List<MusicModel> musicModelList;
    MusicCustomAdapter adapter;


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

        musicModelList = new ArrayList<>();

        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));
        musicModelList.add(new MusicModel("បទ៖ ស្ទឹងសែនប៉ារ៊ីស", "ដួងវីរះសិទ្ធ", "http://cdn.sabay.com/cdn/media.sabay.com/media/sabay-news/Local-Entertainment/DoungVireakseth1_large.jpg", "fd"));

        adapter = new MusicCustomAdapter(musicModelList, getContext());
        rvOldMusic.setAdapter(adapter);


    }
}

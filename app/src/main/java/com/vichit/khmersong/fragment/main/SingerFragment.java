//package com.vichit.khmersong.fragment.main;
//
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.vichit.khmersong.R;
////import com.vichit.khmersong.adapter_layout.SingerCustomAdapter;
//import com.vichit.khmersong.interface_generator.SongService;
//import com.vichit.khmersong.service_generator.ServiceGenerator;
//import com.vichit.khmersong.song_respone.SongRespones;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class SingerFragment extends Fragment {
//    RecyclerView rvSinger;
//    List<SongRespones> songList;
//    //SingerCustomAdapter adapter;
//
//
//    public SingerFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_singer, container, false);
//        rvSinger = (RecyclerView) view.findViewById(R.id.rvSinger);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2,
//                LinearLayoutManager.VERTICAL, false);
//        rvSinger.setLayoutManager(gridLayoutManager);
//
//
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        SongService songService = ServiceGenerator.createService(SongService.class);
//        Call<List<SongRespones>> call = songService.findSinger();
//        call.enqueue(new Callback<List<SongRespones>>() {
//            @Override
//            public void onResponse(Call<List<SongRespones>> call, Response<List<SongRespones>> response) {
//                adapter = new SingerCustomAdapter(getContext());
//                songList = new ArrayList<>();
//                songList = response.body();
//                adapter.addMoreSong(songList);
//                rvSinger.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<SongRespones>> call, Throwable t) {
//
//            }
//        });
//
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

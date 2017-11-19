package com.vichit.khmersong.callback;

import android.view.View;

import com.vichit.khmersong.model.response.SongRespones;

import java.util.List;


public interface OnClickListener {

    void onClickView(int position, View view);

    void onItemClick(List<SongRespones.Songs> songList, int postion);
}

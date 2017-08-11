package com.vichit.khmersong.callback;

import com.vichit.khmersong.song_respone.SongRespones;

import java.util.List;

public interface OnPassData {

    void onPassDataToActivity(List<SongRespones.Songs> songList, int postion);

}

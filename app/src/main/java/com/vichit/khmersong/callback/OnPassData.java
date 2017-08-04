package com.vichit.khmersong.callback;

import com.vichit.khmersong.model.MusicModel;

import java.util.List;

public interface OnPassData {

    void onPassDataToActivity(List<MusicModel> musicModelList, int postion);

}

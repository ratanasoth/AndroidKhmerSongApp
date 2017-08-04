package com.vichit.khmersong.callback;

import android.view.View;

import com.vichit.khmersong.model.MusicModel;

import java.util.List;


public interface OnClickListener {

    void onClickView(int position, View view);

    void onItemClick(List<MusicModel> musicModelList, int postion);
}

package com.vichit.khmersong.adapter_layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.vichit.khmersong.R;
import com.vichit.khmersong.model.MusicModel;

import java.util.List;

/**
 * Created by VichitDeveloper on 7/24/17.
 */

public class SingerCustomAdapter extends RecyclerView.Adapter<SingerCustomAdapter.SingerViewHolder> {

    List<MusicModel> musicModelList;
    MusicModel musicModel;
    Context context;

    public SingerCustomAdapter(List<MusicModel> musicModelList, Context context) {
        this.musicModelList = musicModelList;
        this.context = context;
    }

    @Override
    public SingerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout_singer, parent, false);

        return new SingerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SingerViewHolder holder, int position) {
        musicModel = musicModelList.get(position);

        holder.tvSinger.setText(musicModel.getSingerName());
        Picasso.with(context)
                .load(musicModel.getProfile())
                .into(holder.ivSinger);

    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }


    class SingerViewHolder extends RecyclerView.ViewHolder {
        //ImageView ivSinger;
        RoundedImageView ivSinger;
        TextView tvSinger;

        public SingerViewHolder(View itemView) {
            super(itemView);
            tvSinger = (TextView) itemView.findViewById(R.id.tvSingerName_Singer);
            ivSinger = (RoundedImageView) itemView.findViewById(R.id.ivSinger);


        }
    }
}

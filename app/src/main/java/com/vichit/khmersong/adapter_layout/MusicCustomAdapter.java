package com.vichit.khmersong.adapter_layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.model.MusicModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MusicCustomAdapter extends RecyclerView.Adapter<MusicCustomAdapter.MusicHolder> {

    private List<MusicModel> musicModelList;
    private MusicModel musicModel;
    Context context;
    OnClickListener onClickListener;


    public MusicCustomAdapter(List<MusicModel> musicModelList, Context context) {
        this.musicModelList = musicModelList;
        this.context = context;
    }

    @Override
    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout_song, parent, false);
        return new MusicHolder(view);

    }

    @Override
    public void onBindViewHolder(MusicHolder holder, int position) {
        musicModel = musicModelList.get(position);

        holder.tvSongName.setText(musicModel.getTitleName());
        holder.tvSinger.setText(musicModel.getSingerName());
        Picasso.with(context)
                .load(musicModel.getIvProfile())
                .into(holder.ivProfile);


    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;

    }


    class MusicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSongName;
        TextView tvSinger;
        CircleImageView ivProfile;
        ImageView ivReorder;

        public MusicHolder(View itemView) {
            super(itemView);

            tvSongName = (TextView) itemView.findViewById(R.id.tvNameSong);
            tvSinger = (TextView) itemView.findViewById(R.id.tvSingerName);
            ivProfile = (CircleImageView) itemView.findViewById(R.id.ivProfile);
            ivReorder = (ImageView) itemView.findViewById(R.id.ivReorder);

            ivReorder.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onClickListener.onItemClick(getAdapterPosition(), v);


        }
    }
}

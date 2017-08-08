package com.vichit.khmersong.adapter_layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.song_respone.SongRespones;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MusicCustomAdapter extends RecyclerView.Adapter<MusicCustomAdapter.MusicViewHolder> {

    private List<SongRespones> songList;
    private SongRespones songRespones;
    private OnClickListener onClickListener;
    private Context context;
    private View view;


//    public MusicCustomAdapter(List<SongRespones> songList, Context context) {
//        this.songList = songList;
//        this.context = context;
//
//
//    }


    public MusicCustomAdapter(Context context) {
        songList = new ArrayList<>();
        this.context = context;
    }

    public void addMoreItem(List<SongRespones> songList) {
        /**
         * Have reference with constructor.
         * When call this method
         */
        this.songList = songList;
        notifyDataSetChanged();
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.custom_layout_song, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        songRespones = songList.get(position);

        holder.tvSongName.setText(songRespones.getSongName());
        holder.tvSinger.setText(songRespones.getSingerName());
        Picasso.with(context)
                .load(songRespones.getSingerImage())
                .into(holder.ivProfile);

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        onClickListener = (OnClickListener) recyclerView.getContext();
//
//    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;

    }

    class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSongName;
        TextView tvSinger;
        CircleImageView ivProfile;
        ImageView ivReorder;

        public MusicViewHolder(View itemView) {
            super(itemView);

            tvSongName = (TextView) itemView.findViewById(R.id.tvNameSong);
            tvSinger = (TextView) itemView.findViewById(R.id.tvSingerName_Music);
            ivProfile = (CircleImageView) itemView.findViewById(R.id.ivProfile);
            ivReorder = (ImageView) itemView.findViewById(R.id.ivReorder);

            ivReorder.setOnClickListener(this);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ivReorder:
                    onClickListener.onClickView(getAdapterPosition(), v);
                    Log.e("pppppp", getAdapterPosition() + "");
                    break;
                case R.id.layoutSong:
                    onClickListener.onItemClick(songList, getAdapterPosition());
                    break;

            }

        }
    }

}

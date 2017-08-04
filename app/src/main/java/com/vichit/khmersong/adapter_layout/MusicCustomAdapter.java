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


public class MusicCustomAdapter extends RecyclerView.Adapter<MusicCustomAdapter.MusicViewHolder> {

    private List<MusicModel> musicModelList;
    private MusicModel musicModel;
    private OnClickListener onClickListener;
    private Context context;
    private View view;


    public MusicCustomAdapter(List<MusicModel> musicModelList, Context context) {
        this.musicModelList = musicModelList;
        this.context = context;

    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.custom_layout_song, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        musicModel = musicModelList.get(position);

        holder.tvSongName.setText(musicModel.getTitleName());
        holder.tvSinger.setText(musicModel.getSingerName());
        Picasso.with(context)
                .load(musicModel.getProfile())
                .into(holder.ivProfile);

    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;

    }

    class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSongName;
        TextView tvSinger;
        CircleImageView ivProfile;
        ImageView ivReorder;
        //private View viewAntiProgress;

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
                    break;
                case R.id.layoutSong:
                    onClickListener.onItemClick(musicModelList, getAdapterPosition());

            }


        }
    }

}

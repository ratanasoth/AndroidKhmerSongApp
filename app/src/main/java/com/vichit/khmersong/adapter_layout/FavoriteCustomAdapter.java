package com.vichit.khmersong.adapter_layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.model.response.SongRespones;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class FavoriteCustomAdapter extends RecyclerView.Adapter<FavoriteCustomAdapter.FavoriteViewHolder> {

    List<SongRespones.Songs> songsList;
    SongRespones.Songs songResponse;
    private OnClickListener onClickListener;
    Context context;


    public FavoriteCustomAdapter(Context context) {
        this.context = context;
        songsList = new ArrayList<>();
    }

    public void addMoreItem(List<SongRespones.Songs> songsList) {
        this.songsList = songsList;
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout_favorite, parent, false);

        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteViewHolder holder, int position) {
        songResponse = songsList.get(position);

        holder.tvSongName.setText(songResponse.getSongName());
        holder.tvSingerName.setText(songResponse.getSinger().getSingerName());
        Picasso.with(context)
                .load(songResponse.getSinger().getSingerImage())
                .into(holder.ivProfile);

    }

    @Override
    public int getItemCount() {
        if (songsList != null) {
            return songsList.size();
        }
        return 0;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    public class FavoriteViewHolder extends ViewHolder implements View.OnClickListener {

        TextView tvSongName;
        TextView tvSingerName;
        CircleImageView ivProfile;
        ImageView ivReorder;

        public FavoriteViewHolder(View itemView) {
            super(itemView);

            tvSongName = (TextView) itemView.findViewById(R.id.tvNameSong_Favorite);
            tvSingerName = (TextView) itemView.findViewById(R.id.tvSingerName_Favorite);
            ivProfile = (CircleImageView) itemView.findViewById(R.id.ivProfile_Favorite);
            ivReorder = (ImageView) itemView.findViewById(R.id.ivReorder_Favorite);

            itemView.setOnClickListener(this);
            ivReorder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ivReorder_Favorite:
                    onClickListener.onClickView(getAdapterPosition(), v);
                    break;
                case R.id.layoutSong:
                    onClickListener.onItemClick(songsList, getAdapterPosition());
                    break;

            }
        }
    }
}

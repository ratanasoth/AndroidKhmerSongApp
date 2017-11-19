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
import com.vichit.khmersong.callback.OnClickListener;
import com.vichit.khmersong.model.response.SingerResponse;

import java.util.ArrayList;
import java.util.List;


public class SingerCustomAdapter extends RecyclerView.Adapter<SingerCustomAdapter.SingerViewHolder> {

    List<SingerResponse.Singer> singersList;
    SingerResponse.Singer singerRespones;
    Context context;
    OnClickListener onClickListener;


    public SingerCustomAdapter(Context context) {
        singersList = new ArrayList<>();
        this.context = context;
    }

    public void addMoreSong(List<SingerResponse.Singer> singersList) {
        if (singersList != null) {
            this.singersList = singersList;
        }
    }

    @Override
    public SingerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout_singer, parent, false);

        return new SingerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SingerViewHolder holder, int position) {
        singerRespones = singersList.get(position);


        holder.tvSinger.setText(singerRespones.getSingerName());
        Picasso.with(context)
                .load(singerRespones.getSingerImage())
                .into(holder.ivSinger);

    }

    @Override
    public int getItemCount() {
        if (singersList != null) {
            return singersList.size();
        }
        return 0;
    }

    public void setOnItemClick(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;

    }


    class SingerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RoundedImageView ivSinger;
        TextView tvSinger;

        public SingerViewHolder(View itemView) {
            super(itemView);
            tvSinger = (TextView) itemView.findViewById(R.id.tvSingerName_Singer);
            ivSinger = (RoundedImageView) itemView.findViewById(R.id.ivSinger);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClickView(getAdapterPosition(), v);
        }
    }
}

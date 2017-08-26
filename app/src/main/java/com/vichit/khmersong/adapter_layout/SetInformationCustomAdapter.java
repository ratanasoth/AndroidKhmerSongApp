package com.vichit.khmersong.adapter_layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnClearCache;
import com.vichit.khmersong.model.SetInformationModel;

import java.util.ArrayList;
import java.util.List;


public class SetInformationCustomAdapter extends RecyclerView.Adapter<SetInformationCustomAdapter.SetInformationViewHolder> {

    private List<SetInformationModel> listInformation;
    private SetInformationModel setInformationModel;
    private OnClearCache onClearCache;
    private Context context;


    public SetInformationCustomAdapter(Context context) {
        listInformation = new ArrayList<>();
        this.context = context;

    }

    public void init(List<SetInformationModel> listInformation) {
        this.listInformation = listInformation;
    }

    @Override
    public SetInformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout_setinformation, parent, false);

        return new SetInformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetInformationViewHolder holder, int position) {
        setInformationModel = listInformation.get(position);
        holder.tvClearMemory.setText(setInformationModel.getTvClearMemory());
        holder.ivProfile.setImageResource(setInformationModel.getImage());

    }

    @Override
    public int getItemCount() {
        if (listInformation != null) {
            return listInformation.size();
        }
        return 0;
    }


    public void onClearCacheClickListener(OnClearCache onClearCache) {
        this.onClearCache = onClearCache;
    }

    class SetInformationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvClearMemory;
        ImageView ivProfile;

        public SetInformationViewHolder(View itemView) {
            super(itemView);

            tvClearMemory = (TextView) itemView.findViewById(R.id.tvClearMemory_setInformation);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile_setInformation);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == 0) {
                onClearCache.onClickClearCacheListener();
            }
        }
    }
}

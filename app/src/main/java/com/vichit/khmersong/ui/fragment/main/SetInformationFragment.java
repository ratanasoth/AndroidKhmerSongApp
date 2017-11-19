package com.vichit.khmersong.ui.fragment.main;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vichit.khmersong.R;
import com.vichit.khmersong.adapter_layout.SetInformationCustomAdapter;
import com.vichit.khmersong.callback.OnClearCache;
import com.vichit.khmersong.constant.SharePreferenceKey;
import com.vichit.khmersong.model.local.SetInformationModel;
import com.vichit.khmersong.model.response.SongRespones;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SetInformationFragment extends Fragment implements OnClearCache {
    private RecyclerView rvSetInformation;
    SharedPreferences sharedPreferences;
    List<SongRespones.Songs> songSharePreference;
    String getSongJson;


    public SetInformationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_information, container, false);
        getActivity().setTitle(getString(R.string.activity_title_setting));
        rvSetInformation = (RecyclerView) view.findViewById(R.id.rvSetInformation);
        rvSetInformation.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<SetInformationModel> listInformation = new ArrayList<>();
        listInformation.add(new SetInformationModel(R.drawable.ic_delete, R.string.text_clear_memory));
        // listInformation.add(new SetInformationModel(R.drawable.ic_language, R.string.text_change_language));

        SetInformationCustomAdapter adapter = new SetInformationCustomAdapter(getContext());
        adapter.init(listInformation);
        rvSetInformation.setAdapter(adapter);

        adapter.onClearCacheClickListener(this);


    }

    @Override
    public void onClickClearCacheListener() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle(R.string.text_title_clearcache_alertdialog);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(R.string.alertdialog_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getSharePreference();
                if (!songSharePreference.equals("")) {
                    songSharePreference.clear();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    getSongJson = new Gson().toJson(songSharePreference);
                    editor.putString(SharePreferenceKey.SONG_LIST, getSongJson);
                    editor.apply();

                    Toast.makeText(getContext(), R.string.toast_clear_data, Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.setNegativeButton(R.string.alertdialog_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), R.string.toast_cancel, Toast.LENGTH_SHORT).show();

            }
        });
        alertDialog.create();
        alertDialog.show();

    }

    private void getSharePreference() {
        sharedPreferences = getContext().getSharedPreferences(SharePreferenceKey.SONG_LIST, Context.MODE_PRIVATE);
        getSongJson = sharedPreferences.getString(SharePreferenceKey.SONG_LIST, "N/A");
        if (!getSongJson.equals("N/A")) {
            Type type = new TypeToken<List<SongRespones.Songs>>() {
            }.getType();
            songSharePreference = new Gson().fromJson(getSongJson, type);
        }
    }

}

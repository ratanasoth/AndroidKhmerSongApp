package com.vichit.khmersong.fragment.main;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.vichit.khmersong.R;
import com.vichit.khmersong.interface_generator.SongService;
import com.vichit.khmersong.service_generator.ServiceGenerator;
import com.vichit.khmersong.song_respone.SongRequestByUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestSongFragment extends Fragment implements View.OnClickListener, Validator.ValidationListener {

    @NotEmpty(message = "សូមបញ្ចូលឈ្មោះបទចម្រៀង")
    EditText edSongName;
    @NotEmpty(message = "សូមបញ្ចូលឈ្មោះតារាចម្រៀង")
    EditText edSingerName;

    EditText edGeneralInput;
    Button btnSubmit;
    Validator validator;
    String songName, singerName, generalInput;


    public RequestSongFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request_song, container, false);
        getActivity().setTitle("សំណូរពរចម្រៀង");

        edSingerName = (EditText) view.findViewById(R.id.edSingerName_requestSong);
        edSongName = (EditText) view.findViewById(R.id.edSongName_requestSong);
        edGeneralInput = (EditText) view.findViewById(R.id.edSomethingInput_requestSong);

        btnSubmit = (Button) view.findViewById(R.id.btnSubmitRequest);

        validator = new Validator(this);
        validator.setValidationListener(this);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        validator.validate();


    }

    @Override
    public void onValidationSucceeded() {
        songName = edSongName.getText().toString();
        singerName = edSingerName.getText().toString();
        generalInput = edGeneralInput.getText().toString();

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("បញ្ជាក់!!");
        alertDialog.setMessage("បទ: " + songName + "  ច្រៀងដោយ: " + singerName);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("យល់ព្រម", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SongService songService = ServiceGenerator.createService(SongService.class);
                Call<SongRequestByUser> callBackUserRequest = songService.songRequestByUser(songName, singerName, generalInput);
                callBackUserRequest.enqueue(new Callback<SongRequestByUser>() {
                    @Override
                    public void onResponse(Call<SongRequestByUser> call, Response<SongRequestByUser> response) {
                        if (response.isSuccessful()) {
                            edSongName.setText("");
                            edSingerName.setText("");
                            edGeneralInput.setText("");
                            Toast.makeText(getContext(), "ពត៌មានត្រូវបានបញ្ជូន", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "ការបញ្ជូនពត៌មានមិនបានជោគជ័យ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SongRequestByUser> call, Throwable t) {
                        t.printStackTrace();
                    }
                });


            }
        });
        alertDialog.setNegativeButton("បោះបង់", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.create();
        alertDialog.show();


    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        }
    }
}

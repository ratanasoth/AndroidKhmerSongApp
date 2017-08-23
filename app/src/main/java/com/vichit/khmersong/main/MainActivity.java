package com.vichit.khmersong.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerService;
import com.example.jean.jcplayer.JcPlayerView;
import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.fragment.main.FavoriteFragment;
import com.vichit.khmersong.fragment.main.MainFragmentSong;
import com.vichit.khmersong.fragment.main.RequestSongFragment;
import com.vichit.khmersong.fragment.main.SetInformationFragment;
import com.vichit.khmersong.fragment.main.SingerFragment;
import com.vichit.khmersong.song_respone.SongRespones;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LocalizationActivity implements NavigationView.OnNavigationItemSelectedListener, JcPlayerService.JcPlayerServiceListener, JcPlayerService.OnInvalidPathListener, OnPassData {

    JcPlayerView jcPlayer;
    ArrayList<JcAudio> jcAudiosList;
    String titleName;
    String pathUrl;
    String category = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setDefaultLanguage("km");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        jcPlayer = (JcPlayerView) findViewById(R.id.jcPlayer);
        jcPlayer.initPlaylist(new ArrayList<JcAudio>());
        jcPlayer.registerInvalidPathListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_newSong) {
            MainFragmentSong mainFragmentSong = new MainFragmentSong();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentMain, mainFragmentSong)
                    .commit();
        } else if (id == R.id.nav_singer) {
            SingerFragment singerFragment = new SingerFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentMain, singerFragment)
                    .commit();
        } else if (id == R.id.nav_saveSong) {
            FavoriteFragment favoriteFragment = new FavoriteFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentMain, favoriteFragment)
                    .commit();

        } else if (id == R.id.nav_sendSong) {
            RequestSongFragment requestSongFragment = new RequestSongFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentMain, requestSongFragment)
                    .commit();

        } else if (id == R.id.nav_facebook) {

            String facebookUrl = "https://www.facebook.com/vichitad/";
            try {
                int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                if (versionCode >= 3002850) {
                    Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/336227679757310")));
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));
            }

        } else if (id == R.id.nav_contact) {

            String phoneNumber = "085 687 556";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            SetInformationFragment setInformationFragment = new SetInformationFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentMain, setInformationFragment)
                    .commit();
        } else if (id == R.id.nav_language) {
            String language[] = getResources().getStringArray(R.array.langauge);
            AlertDialog.Builder
                    singleChoiceDialogBuilder = new AlertDialog.Builder(this);
            singleChoiceDialogBuilder.setTitle(R.string.alertdialog_title_choose_langauge);
            singleChoiceDialogBuilder.setItems(language, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int position) {
                    if (position == 0) {
                        setLanguage("km");
                    } else if (position == 1) {
                        setLanguage("en");
                    }
                }
            });
            singleChoiceDialogBuilder.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //get data from old fragments
    @Override
    public void onPassDataToActivity(List<SongRespones.Songs> songList, int position) {

//        if (!songList.get(0).getCategory().getName().equals(category)) {
        category = songList.get(0).getCategory().getName();
        jcPlayer.getMyPlaylist().clear();
        for (SongRespones.Songs m : songList) {
            titleName = m.getSongName();
            pathUrl = m.getSongUrl();
            jcPlayer.getMyPlaylist().add(JcAudio.createFromURL(titleName, pathUrl));
        }

        jcPlayer.playAudio(jcPlayer.getMyPlaylist().get(position));


//        if (!songList.get(0).getType().getTypeName().equals(type)) {
//            type = songList.get(0).getType().getTypeName();
//            Log.e("ppppp type", type);
//            jcPlayer.getMyPlaylist().clear();
//            for (SongRespones.Songs m : songList) {
//                titleName = m.getSongName();
//                pathUrl = m.getSongUrl();
//                jcPlayer.getMyPlaylist().add(JcAudio.createFromURL(titleName, pathUrl));
//            }
//        }
//        jcPlayer.playAudio(jcPlayer.getMyPlaylist().get(position));


//        if (jcPlayer.getMyPlaylist().isEmpty()) {
//            for (SongRespones.Songs m : songList) {
//                titleName = m.getSongName();
//                pathUrl = m.getSongUrl();
//                jcPlayer.getMyPlaylist().add(JcAudio.createFromURL(titleName, pathUrl));
//            }
//        }
//        jcPlayer.playAudio(jcPlayer.getMyPlaylist().get(position));


//        if (songList != null) {
//            jcAudiosList = new ArrayList<>();
//            for (SongRespones.Songs m : songList) {
//
//                titleName = m.getName() ;
//                pathUrl = m.getUrl();
//                jcAudiosList.add(JcAudio.createFromURL(titleName, pathUrl));
//            }
//            jcPlayer.playAudio(jcAudiosList.get(position));
//            jcAudiosList.clear();
//
//
//            //get only song
//            // jcPlayer.playAudio(JcAudio.createFromRaw(songName, pathUrl));
//
//
//        }

    }


    @Override
    public void onPause() {
        super.onPause();
        jcPlayer.createNotification();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jcPlayer.kill();
    }

    @Override
    public void onPreparedAudio(String audioName, int duration) {

    }

    @Override
    public void onCompletedAudio() {
        jcAudiosList.clear();


    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onContinueAudio() {

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onTimeChanged(long currentTime) {

    }

    @Override
    public void updateTitle(String title) {

    }

    @Override
    public void onPathError(JcAudio jcAudio) {

    }
}

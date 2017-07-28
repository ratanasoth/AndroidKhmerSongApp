package com.vichit.khmersong.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerView;
import com.vichit.khmersong.R;
import com.vichit.khmersong.callback.OnPassData;
import com.vichit.khmersong.fragment.main.MainFragmentSong;
import com.vichit.khmersong.fragment.main.SingerFragment;
import com.vichit.khmersong.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnPassData {

    JcPlayerView jcPlayer;
    List<JcAudio> jcAudios;
    MusicModel musicModel;
    String songName;
    int pathUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //get data from old fragments
    @Override
    public void onPassDataToActivity(List<MusicModel> musicModelList, int postion) {

        if (musicModelList != null) {
            jcAudios = new ArrayList<>();
            musicModel = musicModelList.get(postion);

            pathUrl = musicModel.getPathUrl();
            songName = musicModel.getTitleName();

            jcPlayer.playAudio(JcAudio.createFromRaw(songName, pathUrl));

        }

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
}

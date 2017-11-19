package com.vichit.khmersong.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by VichitDeveloper on 11/19/17.
 */

public class InternetConnection {


    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWork = cm.getActiveNetworkInfo();
        return activeNetWork != null && activeNetWork.isConnectedOrConnecting();
    }
}

package com.sajjad.fontmanager;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.google.android.material.color.DynamicColors;

public class Font_Manager extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getAppContext() {
        return Font_Manager.context;
    }

    public void onCreate() {
        super.onCreate();
        Font_Manager.context = getApplicationContext();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
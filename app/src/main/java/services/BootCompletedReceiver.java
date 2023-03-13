package com.sajjad.fontmanager.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.config.PrefConfig;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) && PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "onHomePage")) {
            Log.w("BootCompletedReceiver", "Starting Background Service...");
            context.startService(new Intent(context, BackgroundService.class));
        }
    }
}

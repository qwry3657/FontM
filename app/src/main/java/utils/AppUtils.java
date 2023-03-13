package com.sajjad.fontmanager.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.R;

public class AppUtils {
    public static boolean isAppInstalled(String packageName) {
        PackageManager pm = Font_Manager.getAppContext().getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return pm.getApplicationInfo(packageName, 0).enabled;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Drawable getAppIcon(String packageName) {
        Drawable appIcon = null;
        try {
            appIcon = Font_Manager.getAppContext().getPackageManager().getApplicationIcon(packageName);
            return appIcon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            appIcon = Font_Manager.getAppContext().getResources().getDrawable(R.drawable.ic_android);
            return appIcon;
        }
    }

    public static String getAppName(String packageName) {
        final PackageManager pm = Font_Manager.getAppContext().getApplicationContext().getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            ai = null;
        }
        return (String) (ai == null ? "..." : pm.getApplicationLabel(ai));
    }

    public static void launchApp(Activity activity, String packageName) {
        Intent launchIntent = Font_Manager.getAppContext().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            activity.startActivity(launchIntent);
        } else {
            Toast.makeText(Font_Manager.getAppContext(), "Application not found!", Toast.LENGTH_SHORT).show();
        }
    }
}

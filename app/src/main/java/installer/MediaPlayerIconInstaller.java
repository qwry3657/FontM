package com.sajjad.fontmanager.installer;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.config.PrefConfig;
import com.topjohnwu.superuser.Shell;

import java.io.File;

public class MediaPlayerIconInstaller {

    public static void install_pack(int m, int n) {
        disable_others(m, n);
        enable_pack(m, n);
    }

    protected static void enable_pack(int m, int n) {

        String path = "/system/product/overlay/Font_ManagerComponentMPIP" + m + n + ".apk";

        if (new File(path).exists()) {

            String overlay = (path.replaceAll("/system/product/overlay/", "")).replaceAll("apk", "overlay");

            try {
                Shell.cmd("cmd overlay enable --user current " + overlay).exec();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public static void disable_pack(int m, int n) {

        String path = "/system/product/overlay/Font_ManagerComponentMPIP" + m + n + ".apk";

        if (new File(path).exists()) {

            String overlay = (path.replaceAll("/system/product/overlay/", "")).replaceAll("apk", "overlay");

            try {
                Shell.cmd("cmd overlay disable --user current " + overlay).exec();
                PrefConfig.savePrefBool(Font_Manager.getAppContext(), overlay, false);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    protected static void disable_others(int m, int n) {

        for (int i = 1; i <= 3; i++) {
            if (i != n) {
                String path = "/system/product/overlay/Font_ManagerComponentMPIP" + m + i + ".apk";

                if (new File(path).exists()) {

                    String overlay = (path.replaceAll("/system/product/overlay/", "")).replaceAll("apk", "overlay");

                    try {
                        Shell.cmd("cmd overlay disable --user current " + overlay).exec();
                        PrefConfig.savePrefBool(Font_Manager.getAppContext(), overlay, false);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        }
    }
}
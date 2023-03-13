package com.sajjad.fontmanager.services;

import android.graphics.Color;

import androidx.core.graphics.ColorUtils;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.config.PrefConfig;
import com.sajjad.fontmanager.ui.HomePage;
import com.sajjad.fontmanager.utils.FabricatedOverlay;
import com.sajjad.fontmanager.utils.OverlayUtils;
import com.topjohnwu.superuser.Shell;

import java.util.List;
import java.util.Objects;

public class ApplyOnBoot {

    private static final String INVALID = "null";
    private static List<String> overlays = OverlayUtils.getEnabledOverlayList();
    private static List<String> fabricatedOverlays = FabricatedOverlay.getEnabledOverlayList();

    public static void applyColors() {
        Runnable runnable = () -> {
            String colorAccentPrimary = PrefConfig.loadPrefSettings(Font_Manager.getAppContext(), "colorAccentPrimary");
            String colorAccentSecondary = PrefConfig.loadPrefSettings(Font_Manager.getAppContext(), "colorAccentSecondary");
            if ((PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "customPrimaryColor") || PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "customSecondaryColor")) && (FabricatedOverlay.isOverlayDisabled(fabricatedOverlays, "colorAccentPrimary") || FabricatedOverlay.isOverlayDisabled(fabricatedOverlays, "colorAccentSecondary"))) {
                boolean amc_reApplied = false;
                if (PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "customPrimaryColor") && FabricatedOverlay.isOverlayDisabled(fabricatedOverlays, "colorAccentPrimary")) {
                    if (OverlayUtils.isOverlayEnabled(overlays, "Font_ManagerComponentAMC.overlay")) {
                        OverlayUtils.disableOverlay("Font_ManagerComponentAMC.overlay");
                        OverlayUtils.enableOverlay("Font_ManagerComponentAMC.overlay");
                        amc_reApplied = true;
                    }

                    if (!Objects.equals(colorAccentPrimary, INVALID)) {
                        FabricatedOverlay.buildOverlay("android", "colorAccentPrimary", "color", "holo_blue_light", ColorToSpecialHex(Integer.parseInt(colorAccentPrimary)));
                        FabricatedOverlay.buildOverlay("android", "colorAccentPrimaryDark", "color", "holo_blue_dark", ColorToSpecialHex(ColorUtils.blendARGB(Integer.parseInt(colorAccentPrimary), Color.BLACK, 0.8f)));
                    }
                    else {
                        FabricatedOverlay.buildOverlay("android", "colorAccentPrimary", "color", "holo_blue_light", "0xFF50A6D7");
                        FabricatedOverlay.buildOverlay("android", "colorAccentPrimaryDark", "color", "holo_blue_dark", "0xFF122530");
                    }

                    FabricatedOverlay.enableOverlay("colorAccentPrimary");
                    FabricatedOverlay.enableOverlay("colorAccentPrimaryDark");
                }
                if (PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "customSecondaryColor") && FabricatedOverlay.isOverlayDisabled(fabricatedOverlays, "colorAccentSecondary")) {
                    if (!amc_reApplied && OverlayUtils.isOverlayEnabled(overlays, "Font_ManagerComponentAMC.overlay")) {
                        OverlayUtils.disableOverlay("Font_ManagerComponentAMC.overlay");
                        OverlayUtils.enableOverlay("Font_ManagerComponentAMC.overlay");
                    }

                    if (!Objects.equals(colorAccentSecondary, INVALID))
                        FabricatedOverlay.buildOverlay("android", "colorAccentSecondary", "color", "holo_green_light", ColorToSpecialHex(Integer.parseInt(colorAccentSecondary)));
                    else
                        FabricatedOverlay.buildOverlay("android", "colorAccentSecondary", "color", "holo_green_light", "0xFF387BFF");

                    FabricatedOverlay.enableOverlay("colorAccentSecondary");
                }
                PrefConfig.savePrefBool(Font_Manager.getAppContext(), "customColor", true);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void applyQsCustomization() {
        Runnable runnable = () -> {
            if (!Objects.equals(PrefConfig.loadPrefSettings(Font_Manager.getAppContext(), "boot_id"), Shell.cmd("cat /proc/sys/kernel/random/boot_id").exec().getOut().toString()) && OverlayUtils.isOverlayEnabled(overlays, "Font_ManagerComponentQSPB.overlay")) {
                OverlayUtils.disableOverlay("Font_ManagerComponentQSPB.overlay");
                OverlayUtils.enableOverlay("Font_ManagerComponentQSPB.overlay");
            }
            HomePage.getBootId();

        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static String ColorToHex(int color, boolean opacity, boolean hash) {
        int alpha = android.graphics.Color.alpha(color);
        int blue = android.graphics.Color.blue(color);
        int green = android.graphics.Color.green(color);
        int red = android.graphics.Color.red(color);

        String alphaHex = To00Hex(alpha);
        String blueHex = To00Hex(blue);
        String greenHex = To00Hex(green);
        String redHex = To00Hex(red);

        StringBuilder str;

        if (hash)
            str = new StringBuilder("#");
        else
            str = new StringBuilder();

        if (opacity)
            str.append(alphaHex);
        str.append(redHex);
        str.append(greenHex);
        str.append(blueHex);
        return str.toString();
    }

    public static String ColorToSpecialHex(int color) {
        int alpha = android.graphics.Color.alpha(color);
        int blue = android.graphics.Color.blue(color);
        int green = android.graphics.Color.green(color);
        int red = android.graphics.Color.red(color);

        String alphaHex = To00Hex(alpha);
        String blueHex = To00Hex(blue);
        String greenHex = To00Hex(green);
        String redHex = To00Hex(red);

        StringBuilder str = new StringBuilder("0xFF");
//      str.append(alphaHex);
        str.append(redHex);
        str.append(greenHex);
        str.append(blueHex);
        return str.toString();
    }

    private static String To00Hex(int value) {
        String hex = "00".concat(Integer.toHexString(value));
        return hex.substring(hex.length() - 2);
    }
}

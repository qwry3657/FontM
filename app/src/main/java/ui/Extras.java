package com.sajjad.fontmanager.ui;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.R;
import com.sajjad.fontmanager.config.PrefConfig;
import com.sajjad.fontmanager.utils.FabricatedOverlay;
import com.sajjad.fontmanager.utils.OverlayUtils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.topjohnwu.superuser.Shell;

import java.util.List;
import java.util.Objects;

public class Extras extends AppCompatActivity {

    public static void disableEverything() {
        List<String> overlays = OverlayUtils.getEnabledOverlayList();
        List<String> fabricatedOverlays = FabricatedOverlay.getEnabledOverlayList();

        for (String overlay : overlays) {
            OverlayUtils.disableOverlay(overlay);
            PrefConfig.savePrefBool(Font_Manager.getAppContext(), overlay, false);
        }

        for (String fabricatedOverlay : fabricatedOverlays) {
            FabricatedOverlay.disableOverlay(fabricatedOverlay);
            PrefConfig.savePrefBool(Font_Manager.getAppContext(), fabricatedOverlay, false);
        }
    }

    @SuppressLint({"SetTextI18n", "UseSwitchCompatOrMaterialCode"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extras);

        // Spinner
        LinearLayout spinner = findViewById(R.id.progressBar_Extras);

        // Header
        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Extras");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // Disable Everything
        TextView list_title_disableEverything = findViewById(R.id.list_title_disableEverything);
        TextView list_desc_disableEverything = findViewById(R.id.list_desc_disableEverything);
        Button button_disableEverything = findViewById(R.id.button_disableEverything);

        list_title_disableEverything.setText("Disable Everything");
        list_desc_disableEverything.setText("Disable all the applied UI, changes done by FontM.");

        button_disableEverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show spinner
                spinner.setVisibility(View.VISIBLE);
                // Block touch
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                spinner.postDelayed(new Runnable() {
                    public void run() {
                        disableEverything();
                        // Hide spinner
                        spinner.setVisibility(View.GONE);
                        // Unblock touch
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }, 1000);
            }
        });

        // Restart SystemUI
        TextView list_title_restartSysui = findViewById(R.id.list_title_restartSysui);
        TextView list_desc_restartSysui = findViewById(R.id.list_desc_restartSysui);
        Button button_restartSysui = findViewById(R.id.button_restartSysui);

        list_title_restartSysui.setText("Restart SystemUI");
        list_desc_restartSysui.setText("Sometimes some of the options might get applied but not visible until a SystemUI reboot. In that case you can use this option to restart SystemUI.");

        button_restartSysui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show spinner
                spinner.setVisibility(View.VISIBLE);
                // Block touch
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                spinner.postDelayed(new Runnable() {
                    public void run() {
                        // Hide spinner
                        spinner.setVisibility(View.GONE);
                        // Unblock touch
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        // Restarting sysui
                        Shell.cmd("killall com.android.systemui").exec();
                    }
                }, 1000);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

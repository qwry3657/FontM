package com.sajjad.fontmanager.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sajjad.fontmanager.BuildConfig;
import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.R;
import com.sajjad.fontmanager.config.PrefConfig;
import com.sajjad.fontmanager.utils.ModuleUtil;
import com.sajjad.fontmanager.utils.OverlayUtils;
import com.sajjad.fontmanager.utils.RootUtil;

import java.io.IOException;

public class WelcomePage extends AppCompatActivity {

    private final int versionCode = BuildConfig.VERSION_CODE;
    private final String versionName = BuildConfig.VERSION_NAME;
    LoadingDialog loadingDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        // Loading dialog while installing module
        loadingDialog = new LoadingDialog(this);

        // Continue button
        if (PrefConfig.loadPrefInt(Font_Manager.getAppContext(), "versionCode") < BuildConfig.VERSION_CODE && PrefConfig.loadPrefInt(Font_Manager.getAppContext(), "versionCode") != 0) {
            
            Button reboot_now = findViewById(R.id.reboot_phone);
            reboot_now.setOnClickListener(v -> {
                LoadingDialog rebootingDialog = new LoadingDialog(HomePage.this);
                rebootingDialog.show("Rebooting in 3 seconds");

                runOnUiThread(() -> new Handler().postDelayed(() -> {
                    rebootingDialog.hide();

                    Shell.cmd("su -c 'svc power reboot'").exec();
                }, 3000));
            });
        }

        // Continue button
        Button checkRoot = findViewById(R.id.checkRoot);

        // Dialog to show if root not found
        LinearLayout warn = findViewById(R.id.warn);
        TextView warning = findViewById(R.id.warning);

        // Check for root onClick
        checkRoot.setOnClickListener(v -> {
            if (RootUtil.isDeviceRooted()) {
                if (RootUtil.isMagiskInstalled()) {
                    if ((PrefConfig.loadPrefInt(this, "versionCode") < versionCode) || !ModuleUtil.moduleExists() || !OverlayUtils.overlayExists()) {
                        // Show loading dialog
                        loadingDialog.show("Installing");

                        Runnable runnable = () -> {
                            try {
                                ModuleUtil.handleModule(Font_Manager.getAppContext());
                            } catch (IOException e) {
                                Toast.makeText(Font_Manager.getAppContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                            runOnUiThread(() -> {
                                // Hide loading dialog
                                loadingDialog.hide();

                                if (OverlayUtils.overlayExists()) {
                                    new Handler().postDelayed(() -> {
                                        Intent intent = new Intent(WelcomePage.this, HomePage.class);
                                        startActivity(intent);
                                        finish();
                                    }, 10);
                                } else {
                                    warn.setVisibility(View.VISIBLE);
                                    warning.setText("Reboot your device first!");
                                }
                            });
                        };
                        Thread thread = new Thread(runnable);
                        thread.start();
                    } else {
                        Intent intent = new Intent(WelcomePage.this, HomePage.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    warn.setVisibility(View.VISIBLE);
                    warning.setText("Use Magisk to root your device!");
                }
            } else {
                warn.setVisibility(View.VISIBLE);
                warning.setText("Looks like your device is not rooted!");
            }
        });
    }

    @Override
    public void onDestroy() {
        loadingDialog.hide();
        super.onDestroy();
    }
}
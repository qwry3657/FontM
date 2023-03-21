package com.sajjad.fontmanager.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.sajjad.fontmanager.Font_Manager;
import com.sajjad.fontmanager.R;
import com.sajjad.fontmanager.config.PrefConfig;
import com.sajjad.fontmanager.installer.FontInstaller;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class en extends AppCompatActivity {

    private static final String SAS1 = "SaOverlaysFONTS1.overlay";
    private static final String SAS2 = "SaOverlaysFONTS2.overlay";
    private static final String SAS3 = "SaOverlaysFONTS3.overlay";
    private static final String SAS4 = "SaOverlaysFONTS4.overlay";
    private static final String SAS5 = "SaOverlaysFONTS5.overlay";
    private static final String SAS6 = "SaOverlaysFONTS6.overlay";
    private static final String SAS7 = "SaOverlaysFONTS7.overlay";
    private static final String SAS8 = "SaOverlaysFONTS8.overlay";
    private static final String SAS9 = "SaOverlaysFONTS9.overlay";
    private static final String SAS10 = "SaOverlaysFONTS10.overlay";
    private static final String SAS11 = "SaOverlaysFONTS11.overlay";
    private static final String SAS12 = "SaOverlaysFONTS12.overlay";
    private static final String SAS13 = "SaOverlaysFONTS13.overlay";
    private static final String SAS14 = "SaOverlaysFONTS14.overlay";
    private static final String SAS15 = "SaOverlaysFONTS15.overlay";
    private static final String SAS16 = "SaOverlaysFONTS16.overlay";
    private static final String SAS17 = "SaOverlaysFONTS17.overlay";
    private static final String SAS18 = "SaOverlaysFONTS18.overlay";
    private static final String SAS19 = "SaOverlaysFONTS19.overlay";
    private static final String SAS20 = "SaOverlaysFONTS20.overlay";

    LinearLayout[] Container;
    LinearLayout Sas1Container, Sas2Container, Sas3Container, Sas4Container, Sas5Container, Sas6Container, Sas7Container, Sas8Container, Sas9Container, Sas10Container, Sas11Container, Sas12Container, Sas13Container, Sas14Container, Sas15Container, Sas16Container, Sas17Container, Sas18Container, Sas19Container, Sas20Container;
    Button Sas1_Enable, Sas1_Disable, Sas2_Enable, Sas2_Disable, Sas3_Enable, Sas3_Disable, Sas4_Enable, Sas4_Disable, Sas5_Enable, Sas5_Disable, Sas6_Enable, Sas6_Disable, Sas7_Enable, Sas7_Disable, Sas8_Enable, Sas8_Disable, Sas9_Enable, Sas9_Disable, Sas10_Enable, Sas10_Disable, Sas11_Enable, Sas11_Disable, Sas12_Enable, Sas12_Disable, Sas13_Enable, Sas13_Disable, Sas14_Enable, Sas14_Disable, Sas15_Enable, Sas15_Disable, Sas16_Enable, Sas16_Disable, Sas17_Enable, Sas17_Disable, Sas18_Enable, Sas18_Disable, Sas19_Enable, Sas19_Disable, Sas20_Enable, Sas20_Disable;
    private ViewGroup container;
    LoadingDialog loadingDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fonts_manager);

        // Header
        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Fonts Pack");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Loading dialog while enabling or disabling pack
        loadingDialog = new LoadingDialog(this);

        // Icon Pack list items
        container = (ViewGroup) findViewById(R.id.icon_packs_list);

        // Font.add items in list
        addItem(R.id.sas1_container, "Fucek", "Tap to enable/desable font.", R.id.sas1_enable, R.id.sas1_disable);
        addItem(R.id.sas2_container, "Nothing", "Tap to enable/desable font.", R.id.sas2_enable, R.id.sas2_disable);
        addItem(R.id.sas3_container, "Noto Serif", "Tap to enable/desable font.", R.id.sas3_enable, R.id.sas3_disable);
        addItem(R.id.sas4_container, "Linnote Bold", "Tap to enable/desable font.", R.id.sas4_enable, R.id.sas4_disable);
        addItem(R.id.sas5_container, "Tinkerbell", "Tap to enable/desable font.", R.id.sas5_enable, R.id.sas5_disable);
        addItem(R.id.sas6_container, "sas13sung One", "Tap to enable/desable font.", R.id.sas6_enable, R.id.sas6_disable);
        addItem(R.id.sas7_container, "Corporativ Sans sas12", "Tap to enable/desable font.", R.id.sas7_enable, R.id.sas7_disable);
        addItem(R.id.sas8_container, "FluidSans", "Tap to enable/desable font.", R.id.sas8_enable, R.id.sas8_disable);
        addItem(R.id.sas9_container, "Dosis", "Tap to enable/desable font.", R.id.sas9_enable, R.id.sas9_disable);
        addItem(R.id.sas10_container, "Sfpro", "Tap to enable/desable font.", R.id.sas10_enable, R.id.sas10_disable);
        addItem(R.id.sas11_container, "Opensans", "Tap to enable/desable font.", R.id.sas11_enable, R.id.sas11_disable);
        addItem(R.id.sas12_container, "Cagliostro", "Tap to enable/desable font.", R.id.sas12_enable, R.id.sas12_disable);
        addItem(R.id.sas13_container, "Chula", "Tap to enable/desable font.", R.id.sas13_enable, R.id.sas13_disable);
        addItem(R.id.sas14_container, "Volte-Rounded", "Tap to enable/desable font.", R.id.sas14_enable, R.id.sas14_disable);
        addItem(R.id.sas15_container, "Arial Rounded", "Tap to enable/desable font.", R.id.sas15_enable, R.id.sas15_disable);
        addItem(R.id.sas16_container, "Arial sas12", "Tap to enable/desable font.", R.id.sas16_enable, R.id.sas16_disable);
        addItem(R.id.sas17_container, "Arial sas12", "Tap to enable/desable font.", R.id.sas17_enable, R.id.sas17_disable);
        addItem(R.id.sas18_container, "Arial sas12", "Tap to enable/desable font.", R.id.sas18_enable, R.id.sas18_disable);
        addItem(R.id.sas18_container, "Arial sas12", "Tap to enable/desable font.", R.id.sas19_enable, R.id.sas19_disable);
        addItem(R.id.sas20_container, "Arial sas12", "Tap to enable/desable font.", R.id.sas20_enable, R.id.sas20_disable);

        // Declaration of Aurora
        Sas1Container = findViewById(R.id.sas1_container);
        Sas1_Enable = findViewById(R.id.sas1_enable);
        Sas1_Disable = findViewById(R.id.sas1_disable);

        // Declaration of sas2
        Sas2Container = findViewById(R.id.sas2_container);
        Sas2_Enable = findViewById(R.id.sas2_enable);
        Sas2_Disable = findViewById(R.id.sas2_disable);

        // Declaration of sas3
        Sas3Container = findViewById(R.id.sas3_container);
        Sas3_Enable = findViewById(R.id.sas3_enable);
        Sas3_Disable = findViewById(R.id.sas3_disable);

        // Declaration of sas4
        Sas4Container = findViewById(R.id.sas4_container);
        Sas4_Enable = findViewById(R.id.sas4_enable);
        Sas4_Disable = findViewById(R.id.sas4_disable);

        // Declaration of sas5
        Sas5Container = findViewById(R.id.sas5_container);
        Sas5_Enable = findViewById(R.id.sas5_enable);
        Sas5_Disable = findViewById(R.id.sas5_disable);

        // Declaration of sas6
        Sas6Container = findViewById(R.id.sas6_container);
        Sas6_Enable = findViewById(R.id.sas6_enable);
        Sas6_Disable = findViewById(R.id.sas6_disable);

        // Declaration of sas7
        Sas7Container = findViewById(R.id.sas7_container);
        Sas7_Enable = findViewById(R.id.sas7_enable);
        Sas7_Disable = findViewById(R.id.sas7_disable);

        // Declaration of sas8
        Sas8Container = findViewById(R.id.sas8_container);
        Sas8_Enable = findViewById(R.id.sas8_enable);
        Sas8_Disable = findViewById(R.id.sas8_disable);

        // Declaration of sas9
        Sas9Container = findViewById(R.id.sas9_container);
        Sas9_Enable = findViewById(R.id.sas9_enable);
        Sas9_Disable = findViewById(R.id.sas9_disable);

        // Declaration of sas10
        Sas10Container = findViewById(R.id.sas10_container);
        Sas10_Enable = findViewById(R.id.sas10_enable);
        Sas10_Disable = findViewById(R.id.sas10_disable);

        // Declaration of sas11
        Sas11Container = findViewById(R.id.sas11_container);
        Sas11_Enable = findViewById(R.id.sas11_enable);
        Sas11_Disable = findViewById(R.id.sas11_disable);

        // Declaration of sas12
        Sas12Container = findViewById(R.id.sas12_container);
        Sas12_Enable = findViewById(R.id.sas12_enable);
        Sas12_Disable = findViewById(R.id.sas12_disable);

        // Declaration of sas13
        Sas13Container = findViewById(R.id.sas13_container);
        Sas13_Enable = findViewById(R.id.sas13_enable);
        Sas13_Disable = findViewById(R.id.sas13_disable);

        // Declaration of sas14
        Sas14Container = findViewById(R.id.sas14_container);
        Sas14_Enable = findViewById(R.id.sas14_enable);
        Sas14_Disable = findViewById(R.id.sas14_disable);
        
        // Declaration of sas15
        Sas15Container = findViewById(R.id.sas15_container);
        Sas15_Enable = findViewById(R.id.sas15_enable);
        Sas15_Disable = findViewById(R.id.sas15_disable);

        // Declaration of sas16
        Sas16Container = findViewById(R.id.sas16_container);
        Sas16_Enable = findViewById(R.id.sas16_enable);
        Sas16_Disable = findViewById(R.id.sas16_disable);
        
        // Declaration of sas17
        Sas17Container = findViewById(R.id.sas17_container);
        Sas17_Enable = findViewById(R.id.sas17_enable);
        Sas17_Disable = findViewById(R.id.sas17_disable);

        // Declaration of sas18
        Sas18Container = findViewById(R.id.sas18_container);
        Sas18_Enable = findViewById(R.id.sas18_enable);
        Sas18_Disable = findViewById(R.id.sas18_disable);

        // Declaration of sas19
        Sas19Container = findViewById(R.id.sas19_container);
        Sas19_Enable = findViewById(R.id.sas19_enable);
        Sas19_Disable = findViewById(R.id.sas19_disable);

        // Declaration of sas20
        Sas20Container = findViewById(R.id.sas20_container);
        Sas20_Enable = findViewById(R.id.sas20_enable);
        Sas20_Disable = findViewById(R.id.sas20_disable);


        // List of Icon Pack
        Container = new LinearLayout[]{Sas1Container, Sas2Container, Sas3Container, Sas4Container, Sas5Container, Sas6Container, Sas7Container, Sas8Container, Sas9Container, Sas10Container, Sas11Container, Sas12Container, Sas13Container, Sas14Container, Sas15Container, Sas16Container, Sas17Container, Sas18Container, Sas19Container, Sas20Container};

        // Enable onClick event
        enableOnClickListener(Sas1Container, Sas1_Enable, Sas1_Disable, SAS1, 1);
        enableOnClickListener(Sas2Container, Sas2_Enable, Sas2_Disable, SAS2, 2);
        enableOnClickListener(Sas3Container, Sas3_Enable, Sas3_Disable, SAS3, 3);
        enableOnClickListener(Sas4Container, Sas4_Enable, Sas4_Disable, SAS4, 4);
        enableOnClickListener(Sas5Container, Sas5_Enable, Sas5_Disable, SAS5, 5);
        enableOnClickListener(Sas6Container, Sas6_Enable, Sas6_Disable, SAS6, 6);
        enableOnClickListener(Sas7Container, Sas7_Enable, Sas7_Disable, SAS7, 7);
        enableOnClickListener(Sas8Container, Sas8_Enable, Sas8_Disable, SAS8, 8);
        enableOnClickListener(Sas9Container, Sas9_Enable, Sas9_Disable, SAS9, 9);
        enableOnClickListener(Sas10Container, Sas10_Enable, Sas10_Disable, SAS10, 10);
        enableOnClickListener(Sas11Container, Sas11_Enable, Sas11_Disable, SAS11, 11);
        enableOnClickListener(Sas12Container, Sas12_Enable, Sas12_Disable, SAS12, 12);
        enableOnClickListener(Sas13Container, Sas13_Enable, Sas13_Disable, SAS13, 13);
        enableOnClickListener(Sas14Container, Sas14_Enable, Sas14_Disable, SAS14, 14);
        enableOnClickListener(Sas15Container, Sas15_Enable, Sas15_Disable, SAS15, 15);
        enableOnClickListener(Sas16Container, Sas16_Enable, Sas16_Disable, SAS16, 16);
        enableOnClickListener(Sas17Container, Sas17_Enable, Sas17_Disable, SAS17, 17);
        enableOnClickListener(Sas18Container, Sas18_Enable, Sas18_Disable, SAS18, 18);
        enableOnClickListener(Sas19Container, Sas19_Enable, Sas19_Disable, SAS19, 19);
        enableOnClickListener(Sas20Container, Sas20_Enable, Sas20_Disable, SAS20, 20);
        
        refreshBackground();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Function to check for layout changes
    private void refreshLayout(LinearLayout layout) {
        for (LinearLayout linearLayout : Container) {
            if (!(linearLayout == layout)) {
                if (linearLayout == Sas1Container) {
                    Sas1_Enable.setVisibility(View.GONE);
                    Sas1_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas2Container) {
                    Sas2_Enable.setVisibility(View.GONE);
                    Sas2_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas3Container) {
                    Sas3_Enable.setVisibility(View.GONE);
                    Sas3_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas4Container) {
                    Sas4_Enable.setVisibility(View.GONE);
                    Sas4_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas5Container) {
                    Sas5_Enable.setVisibility(View.GONE);
                    Sas5_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas6Container) {
                    Sas6_Enable.setVisibility(View.GONE);
                    Sas6_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas7Container) {
                    Sas7_Enable.setVisibility(View.GONE);
                    Sas7_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas8Container) {
                    Sas8_Enable.setVisibility(View.GONE);
                    Sas8_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas9Container) {
                    Sas9_Enable.setVisibility(View.GONE);
                    Sas9_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas10Container) {
                    Sas10_Enable.setVisibility(View.GONE);
                    Sas10_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas11Container) {
                    Sas11_Enable.setVisibility(View.GONE);
                    Sas11_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas12Container) {
                    Sas12_Enable.setVisibility(View.GONE);
                    Sas12_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas13Container) {
                    Sas13_Enable.setVisibility(View.GONE);
                    Sas13_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas14Container) {
                    Sas14_Enable.setVisibility(View.GONE);
                    Sas14_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas15Container) {
                    Sas15_Enable.setVisibility(View.GONE);
                    Sas15_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas16Container) {
                    Sas16_Enable.setVisibility(View.GONE);
                    Sas16_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas17Container) {
                    Sas17_Enable.setVisibility(View.GONE);
                    Sas17_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas18Container) {
                    Sas18_Enable.setVisibility(View.GONE);
                    Sas18_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas19Container) {
                    Sas19_Enable.setVisibility(View.GONE);
                    Sas19_Disable.setVisibility(View.GONE);
                } else if (linearLayout == Sas20Container) {
                    Sas20_Enable.setVisibility(View.GONE);
                    Sas20_Disable.setVisibility(View.GONE);
                   
                }
            }
        }
    }

    // Function to check for bg drawable changes
    private void refreshBackground() {
        checkIfApplied(Sas1Container, 1);
        checkIfApplied(Sas2Container, 2);
        checkIfApplied(Sas3Container, 3);
        checkIfApplied(Sas4Container, 4);
        checkIfApplied(Sas5Container, 5);
        checkIfApplied(Sas6Container, 6);
        checkIfApplied(Sas7Container, 7);
        checkIfApplied(Sas8Container, 8);
        checkIfApplied(Sas9Container, 9);
        checkIfApplied(Sas10Container, 10);
        checkIfApplied(Sas11Container, 11);
        checkIfApplied(Sas12Container, 12);
        checkIfApplied(Sas13Container, 13);
        checkIfApplied(Sas14Container, 14);
        checkIfApplied(Sas15Container, 15);
        checkIfApplied(Sas16Container, 16);
        checkIfApplied(Sas17Container, 17);
        checkIfApplied(Sas18Container, 18);
        checkIfApplied(Sas19Container, 19);
        checkIfApplied(Sas20Container, 20);
        
    }

    // Function for onClick events
    private void enableOnClickListener(LinearLayout layout, Button enable, Button disable, String key, int index) {

        // Set onClick operation for options in list
        layout.setOnClickListener(v -> {
            refreshLayout(layout);
            if (!PrefConfig.loadPrefBool(Font_Manager.getAppContext(), key)) {
                disable.setVisibility(View.GONE);
                if (enable.getVisibility() == View.VISIBLE)
                    enable.setVisibility(View.GONE);
                else
                    enable.setVisibility(View.VISIBLE);
            } else {
                enable.setVisibility(View.GONE);
                if (disable.getVisibility() == View.VISIBLE)
                    disable.setVisibility(View.GONE);
                else
                    disable.setVisibility(View.VISIBLE);
            }
        });

        // Set onClick operation for Enable button
        enable.setOnClickListener(v -> {
            refreshLayout(layout);
            // Show loading dialog
            loadingDialog.show("Please Wait");

            Runnable runnable = () -> {
                disable_others(key);
                FontInstaller.install_pack(index);

                runOnUiThread(() -> {
                    PrefConfig.savePrefBool(Font_Manager.getAppContext(), key, true);

                    new Handler().postDelayed(() -> {
                        // Hide loading dialog
                        loadingDialog.hide();

                        // Change background to selected
                        background(layout.getId(), R.drawable.container_selected);

                        // Change button visibility
                        enable.setVisibility(View.GONE);
                        disable.setVisibility(View.VISIBLE);
                        refreshBackground();

                        Toast.makeText(Font_Manager.getAppContext(), "Applied", Toast.LENGTH_SHORT).show();
                    }, 3000);
                });
            };
            Thread thread = new Thread(runnable);
            thread.start();
        });

        // Set onClick operation for Disable button
        disable.setOnClickListener(v -> {
            // Show loading dialog
            loadingDialog.show("Please Wait");

            Runnable runnable = () -> {
                FontInstaller.disable_pack(index);

                runOnUiThread(() -> {
                    PrefConfig.savePrefBool(Font_Manager.getAppContext(), key, false);

                    new Handler().postDelayed(() -> {
                        // Hide loading dialog
                        loadingDialog.hide();

                        // Change background to selected
                        background(layout.getId(), R.drawable.container);

                        // Change button visibility
                        disable.setVisibility(View.GONE);
                        enable.setVisibility(View.VISIBLE);
                        refreshBackground();

                        Toast.makeText(Font_Manager.getAppContext(), "Disabled", Toast.LENGTH_SHORT).show();
                    }, 3000);
                });
            };
            Thread thread = new Thread(runnable);
            thread.start();
        });
    }

    // Function to disable other packs if one is applied
    private void disable_others(String pack) {
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS1, pack.equals(SAS1));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS2, pack.equals(SAS2));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS3, pack.equals(SAS3));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS4, pack.equals(SAS4));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS5, pack.equals(SAS5));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS6, pack.equals(SAS6));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS7, pack.equals(SAS7));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS8, pack.equals(SAS8));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS9, pack.equals(SAS9));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS10, pack.equals(SAS10));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS11, pack.equals(SAS11));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS12, pack.equals(SAS12));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS13, pack.equals(SAS13));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS14, pack.equals(SAS14));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS15, pack.equals(SAS15));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS16, pack.equals(SAS16));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS17, pack.equals(SAS17));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS18, pack.equals(SAS18));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS19, pack.equals(SAS19));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAS20, pack.equals(SAS20));
        
    }

    // Function to change applied pack's bg
    private void checkIfApplied(LinearLayout layout, int icon) {
        if (PrefConfig.loadPrefBool(Font_Manager.getAppContext(), "SaOverlaysFONTS" + icon + ".overlay")) {
            background(layout.getId(), R.drawable.container_selected);
        } else {
            background(layout.getId(), R.drawable.container);
        }
    }

    // Function to add border for installed pack
    private void background(int id, int drawable) {
        LinearLayout layout = findViewById(id);
        layout.setBackground(ContextCompat.getDrawable(this, drawable));
    }

    // Function to add new item in list
    private void addItem(int id, String title, String desc, int enableid, int disableid) {
        View list = LayoutInflater.from(this).inflate(R.layout.list_option_fonts_manager, container, false);

        TextView name = list.findViewById(R.id.list_title_iconpack);
        TextView info = list.findViewById(R.id.list_desc_iconpack);
        Button enable = list.findViewById(R.id.list_button_enable_iconpack);
        Button disable = list.findViewById(R.id.list_button_disable_iconpack);

        list.setId(id);
        name.setText(title);
        info.setText(desc);
        enable.setId(enableid);
        disable.setId(disableid);

        container.addView(list);
    }

    @Override
    public void onDestroy() {
        loadingDialog.hide();
        super.onDestroy();
    }
}
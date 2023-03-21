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

    private static final String AURORA_KEY = "SaOverlaysFONTS1.overlay";
    private static final String GRADICON_KEY = "SaOverlaysFONTS2.overlay";
    private static final String LORN_KEY = "SaOverlaysFONTS3.overlay";
    private static final String PLUMPY_KEY = "SaOverlaysFONTS4.overlay";
    private static final String ACHERUS_KEY = "SaOverlaysFONTS5.overlay";
    private static final String CIRCULAR_KEY = "SaOverlaysFONTS6.overlay";
    private static final String FILLED_KEY = "SaOverlaysFONTS7.overlay";
    private static final String KAI_KEY = "SaOverlaysFONTS8.overlay";
    private static final String OOS_KEY = "SaOverlaysFONTS9.overlay";
    private static final String OUTLINE_KEY = "SaOverlaysFONTS10.overlay";
    private static final String PUI_KEY = "SaOverlaysFONTS11.overlay";
    private static final String ROUNDED_KEY = "SaOverlaysFONTS12.overlay";
    private static final String SAM_KEY = "SaOverlaysFONTS13.overlay";
    private static final String VICTOR_KEY = "SaOverlaysFONTS14.overlay";
    private static final String ACLONICA_KEY = "SaOverlaysFONTS15.overlay";

    LinearLayout[] Container;
    LinearLayout AuroraContainer, GradiconContainer, LornContainer, PlumpyContainer, AcherusContainer, CircularContainer, FilledContainer, KaiContainer, OosContainer, OutlineContainer, PuiContainer, RoundedContainer, SamContainer, VictorContainer, AclonicaContainer;
    Button Aurora_Enable, Aurora_Disable, Gradicon_Enable, Gradicon_Disable, Lorn_Enable, Lorn_Disable, Plumpy_Enable, Plumpy_Disable, Acherus_Enable, Acherus_Disable, Circular_Enable, Circular_Disable, Filled_Enable, Filled_Disable, Kai_Enable, Kai_Disable, Oos_Enable, Oos_Disable, Outline_Enable, Outline_Disable, Pui_Enable, Pui_Disable, Rounded_Enable, Rounded_Disable, Sam_Enable, Sam_Disable, Victor_Enable, Victor_Disable, Aclonica_Enable, Aclonica_Disable;
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
        addItem(R.id.aurora_container, "Fucek", "Tap to enable/desable font.", R.id.aurora_enable, R.id.aurora_disable);
        addItem(R.id.gradicon_container, "Nothing", "Tap to enable/desable font.", R.id.gradicon_enable, R.id.gradicon_disable);
        addItem(R.id.lorn_container, "Noto Serif", "Tap to enable/desable font.", R.id.lorn_enable, R.id.lorn_disable);
        addItem(R.id.plumpy_container, "Linnote Bold", "Tap to enable/desable font.", R.id.plumpy_enable, R.id.plumpy_disable);
        addItem(R.id.acherus_container, "Tinkerbell", "Tap to enable/desable font.", R.id.acherus_enable, R.id.acherus_disable);
        addItem(R.id.circular_container, "Samsung One", "Tap to enable/desable font.", R.id.circular_enable, R.id.circular_disable);
        addItem(R.id.filled_container, "Corporativ Sans Rounded", "Tap to enable/desable font.", R.id.filled_enable, R.id.filled_disable);
        addItem(R.id.kai_container, "FluidSans", "Tap to enable/desable font.", R.id.kai_enable, R.id.kai_disable);
        addItem(R.id.oos_container, "Dosis", "Tap to enable/desable font.", R.id.oos_enable, R.id.oos_disable);
        addItem(R.id.outline_container, "Sfpro", "Tap to enable/desable font.", R.id.outline_enable, R.id.outline_disable);
        addItem(R.id.pui_container, "Opensans", "Tap to enable/desable font.", R.id.pui_enable, R.id.pui_disable);
        addItem(R.id.rounded_container, "Cagliostro", "Tap to enable/desable font.", R.id.rounded_enable, R.id.rounded_disable);
        addItem(R.id.sam_container, "Chula", "Tap to enable/desable font.", R.id.sam_enable, R.id.sam_disable);
        addItem(R.id.victor_container, "Volte-Rounded", "Tap to enable/desable font.", R.id.victor_enable, R.id.victor_disable);
        addItem(R.id.aclonica_container, "Arial Rounded", "Tap to enable/desable font.", R.id.aclonica_enable, R.id.aclonica_disable);

        // Declaration of Aurora
        AuroraContainer = findViewById(R.id.aurora_container);
        Aurora_Enable = findViewById(R.id.aurora_enable);
        Aurora_Disable = findViewById(R.id.aurora_disable);

        // Declaration of Gradicon
        GradiconContainer = findViewById(R.id.gradicon_container);
        Gradicon_Enable = findViewById(R.id.gradicon_enable);
        Gradicon_Disable = findViewById(R.id.gradicon_disable);

        // Declaration of Lorn
        LornContainer = findViewById(R.id.lorn_container);
        Lorn_Enable = findViewById(R.id.lorn_enable);
        Lorn_Disable = findViewById(R.id.lorn_disable);

        // Declaration of Plumpy
        PlumpyContainer = findViewById(R.id.plumpy_container);
        Plumpy_Enable = findViewById(R.id.plumpy_enable);
        Plumpy_Disable = findViewById(R.id.plumpy_disable);

        // Declaration of Acherus
        AcherusContainer = findViewById(R.id.acherus_container);
        Acherus_Enable = findViewById(R.id.acherus_enable);
        Acherus_Disable = findViewById(R.id.acherus_disable);

        // Declaration of Circular
        CircularContainer = findViewById(R.id.circular_container);
        Circular_Enable = findViewById(R.id.circular_enable);
        Circular_Disable = findViewById(R.id.circular_disable);

        // Declaration of Filled
        FilledContainer = findViewById(R.id.filled_container);
        Filled_Enable = findViewById(R.id.filled_enable);
        Filled_Disable = findViewById(R.id.filled_disable);

        // Declaration of Kai
        KaiContainer = findViewById(R.id.kai_container);
        Kai_Enable = findViewById(R.id.kai_enable);
        Kai_Disable = findViewById(R.id.kai_disable);

        // Declaration of Oos
        OosContainer = findViewById(R.id.oos_container);
        Oos_Enable = findViewById(R.id.oos_enable);
        Oos_Disable = findViewById(R.id.oos_disable);

        // Declaration of Outline
        OutlineContainer = findViewById(R.id.outline_container);
        Outline_Enable = findViewById(R.id.outline_enable);
        Outline_Disable = findViewById(R.id.outline_disable);

        // Declaration of Pui
        PuiContainer = findViewById(R.id.pui_container);
        Pui_Enable = findViewById(R.id.pui_enable);
        Pui_Disable = findViewById(R.id.pui_disable);

        // Declaration of Rounded
        RoundedContainer = findViewById(R.id.rounded_container);
        Rounded_Enable = findViewById(R.id.rounded_enable);
        Rounded_Disable = findViewById(R.id.rounded_disable);

        // Declaration of Sam
        SamContainer = findViewById(R.id.sam_container);
        Sam_Enable = findViewById(R.id.sam_enable);
        Sam_Disable = findViewById(R.id.sam_disable);

        // Declaration of Victor
        VictorContainer = findViewById(R.id.victor_container);
        Victor_Enable = findViewById(R.id.victor_enable);
        Victor_Disable = findViewById(R.id.victor_disable);
        
        // Declaration of Aclonica
        AclonicaContainer = findViewById(R.id.aclonica_container);
        Aclonica_Enable = findViewById(R.id.aclonica_enable);
        Aclonica_Disable = findViewById(R.id.aclonica_disable);


        // List of Icon Pack
        Container = new LinearLayout[]{AuroraContainer, GradiconContainer, LornContainer, PlumpyContainer, AcherusContainer, CircularContainer, FilledContainer, KaiContainer, OosContainer, OutlineContainer, PuiContainer, RoundedContainer, SamContainer, VictorContainer};

        // Enable onClick event
        enableOnClickListener(AuroraContainer, Aurora_Enable, Aurora_Disable, AURORA_KEY, 1);
        enableOnClickListener(GradiconContainer, Gradicon_Enable, Gradicon_Disable, GRADICON_KEY, 2);
        enableOnClickListener(LornContainer, Lorn_Enable, Lorn_Disable, LORN_KEY, 3);
        enableOnClickListener(PlumpyContainer, Plumpy_Enable, Plumpy_Disable, PLUMPY_KEY, 4);
        enableOnClickListener(AcherusContainer, Acherus_Enable, Acherus_Disable, ACHERUS_KEY, 5);
        enableOnClickListener(CircularContainer, Circular_Enable, Circular_Disable, CIRCULAR_KEY, 6);
        enableOnClickListener(FilledContainer, Filled_Enable, Filled_Disable, FILLED_KEY, 7);
        enableOnClickListener(KaiContainer, Kai_Enable, Kai_Disable, KAI_KEY, 8);
        enableOnClickListener(OosContainer, Oos_Enable, Oos_Disable, OOS_KEY, 9);
        enableOnClickListener(OutlineContainer, Outline_Enable, Outline_Disable, OUTLINE_KEY, 10);
        enableOnClickListener(PuiContainer, Pui_Enable, Pui_Disable, PUI_KEY, 11);
        enableOnClickListener(RoundedContainer, Rounded_Enable, Rounded_Disable, ROUNDED_KEY, 12);
        enableOnClickListener(SamContainer, Sam_Enable, Sam_Disable, SAM_KEY, 13);
        enableOnClickListener(VictorContainer, Victor_Enable, Victor_Disable, VICTOR_KEY, 14);
        enableOnClickListener(AclonicaContainer, Aclonica_Enable, Aclonica_Disable, ACLONICA_KEY, 15);

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
                if (linearLayout == AuroraContainer) {
                    Aurora_Enable.setVisibility(View.GONE);
                    Aurora_Disable.setVisibility(View.GONE);
                } else if (linearLayout == GradiconContainer) {
                    Gradicon_Enable.setVisibility(View.GONE);
                    Gradicon_Disable.setVisibility(View.GONE);
                } else if (linearLayout == LornContainer) {
                    Lorn_Enable.setVisibility(View.GONE);
                    Lorn_Disable.setVisibility(View.GONE);
                 
                } else if (linearLayout == PlumpyContainer) {
                    Plumpy_Enable.setVisibility(View.GONE);
                    Plumpy_Disable.setVisibility(View.GONE);
                } else if (linearLayout == AcherusContainer) {
                    Acherus_Enable.setVisibility(View.GONE);
                    Acherus_Disable.setVisibility(View.GONE);
                } else if (linearLayout == CircularContainer) {
                    Circular_Enable.setVisibility(View.GONE);
                    Circular_Disable.setVisibility(View.GONE);
                } else if (linearLayout == FilledContainer) {
                    Filled_Enable.setVisibility(View.GONE);
                    Filled_Disable.setVisibility(View.GONE);
                } else if (linearLayout == KaiContainer) {
                    Kai_Enable.setVisibility(View.GONE);
                    Kai_Disable.setVisibility(View.GONE);
                } else if (linearLayout == OosContainer) {
                    Oos_Enable.setVisibility(View.GONE);
                    Oos_Disable.setVisibility(View.GONE);
                } else if (linearLayout == OutlineContainer) {
                    Outline_Enable.setVisibility(View.GONE);
                    Outline_Disable.setVisibility(View.GONE);
                } else if (linearLayout == PuiContainer) {
                    Pui_Enable.setVisibility(View.GONE);
                    Pui_Disable.setVisibility(View.GONE);
                } else if (linearLayout == RoundedContainer) {
                    Rounded_Enable.setVisibility(View.GONE);
                    Rounded_Disable.setVisibility(View.GONE);
                } else if (linearLayout == SamContainer) {
                    Sam_Enable.setVisibility(View.GONE);
                    Sam_Disable.setVisibility(View.GONE);
                } else if (linearLayout == VictorContainer) {
                    Victor_Enable.setVisibility(View.GONE);
                    Victor_Disable.setVisibility(View.GONE);
                } else if (linearLayout == AclonicaContainer) {
                    Aclonica_Enable.setVisibility(View.GONE);
                    Aclonica_Disable.setVisibility(View.GONE);
                   
                }
            }
        }
    }

    // Function to check for bg drawable changes
    private void refreshBackground() {
        checkIfApplied(AuroraContainer, 1);
        checkIfApplied(GradiconContainer, 2);
        checkIfApplied(LornContainer, 3);
        
        checkIfApplied(PlumpyContainer, 4);
        checkIfApplied(AcherusContainer, 5);
        checkIfApplied(CircularContainer, 6);
        checkIfApplied(FilledContainer, 7);
        checkIfApplied(KaiContainer, 8);
        checkIfApplied(OosContainer, 9);
        checkIfApplied(OutlineContainer, 10);
        checkIfApplied(PuiContainer, 11);
        checkIfApplied(RoundedContainer, 12);
        checkIfApplied(SamContainer, 13);
        checkIfApplied(VictorContainer, 14);
        checkIfApplied(AclonicaContainer, 15);
        
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
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), AURORA_KEY, pack.equals(AURORA_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), GRADICON_KEY, pack.equals(GRADICON_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), LORN_KEY, pack.equals(LORN_KEY));
        
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), PLUMPY_KEY, pack.equals(PLUMPY_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), ACHERUS_KEY, pack.equals(ACHERUS_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), CIRCULAR_KEY, pack.equals(CIRCULAR_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), FILLED_KEY, pack.equals(FILLED_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), KAI_KEY, pack.equals(KAI_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), OOS_KEY, pack.equals(OOS_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), OUTLINE_KEY, pack.equals(OUTLINE_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), PUI_KEY, pack.equals(PUI_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), ROUNDED_KEY, pack.equals(ROUNDED_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), SAM_KEY, pack.equals(SAM_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), VICTOR_KEY, pack.equals(VICTOR_KEY));
        PrefConfig.savePrefBool(Font_Manager.getAppContext(), ACLONICA_KEY, pack.equals(ACLONICA_KEY));
        
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
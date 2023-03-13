package com.sajjad.fontmanager.utils;

import android.util.TypedValue;

import com.sajjad.fontmanager.Font_Manager;

public class DisplayUtil {
    public static int IntToDp(int num) {
        return ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, num, Font_Manager.getAppContext().getResources().getDisplayMetrics()));
    }
}

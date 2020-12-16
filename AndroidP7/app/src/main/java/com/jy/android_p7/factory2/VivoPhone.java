package com.jy.android_p7.factory2;

import android.util.Log;

public class VivoPhone implements phone {
    private static final String TAG = "VivoPhone";

    @Override
    public void makephone() {
        Log.e (TAG, "makephone: 这是vivo手机");
    }
}

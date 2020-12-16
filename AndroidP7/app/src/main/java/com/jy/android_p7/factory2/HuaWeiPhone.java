package com.jy.android_p7.factory2;

import android.util.Log;

public class HuaWeiPhone implements phone {
    private static final String TAG = "HuaWeiPhone";

    @Override
    public void makephone() {
        Log.e (TAG, "makephone: 这是华为手机");
    }
}

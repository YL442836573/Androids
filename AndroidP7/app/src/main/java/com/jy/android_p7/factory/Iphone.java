package com.jy.android_p7.factory;

import android.util.Log;

public class Iphone implements phone{
    private static final String TAG = "Iphone";
    @Override
    public void makePhone() {
        Log.e (TAG, "makePhone: iPhone 手机" );
    }
}


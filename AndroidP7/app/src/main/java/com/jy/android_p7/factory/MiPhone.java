package com.jy.android_p7.factory;

import android.util.Log;
import android.widget.Toast;

public class MiPhone implements phone {
    private static final String TAG = "MiPhone";

    @Override
    public void makePhone() {
        Log.e (TAG, "makePhone: 小米手机");
    }
}

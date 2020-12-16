package com.jy.android_p7.factory;

public class PhoneFactory {
    public static phone PhoneFactory(String type) {
        if (type.equals ("MiPhone")) {
            return new MiPhone ();
        } else if (type.equals ("Iphone")) {
            return new Iphone ();
        }
        return null;
    }
}

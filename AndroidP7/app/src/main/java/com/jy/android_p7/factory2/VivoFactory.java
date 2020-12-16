package com.jy.android_p7.factory2;

public class VivoFactory extends CreatePhoneFactory {
    @Override
    public phone createPhone() {
        return new VivoPhone ();
    }
}

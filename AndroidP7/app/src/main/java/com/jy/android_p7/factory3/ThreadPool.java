package com.jy.android_p7.factory3;

import java.util.concurrent.TimeUnit;

public abstract class ThreadPool {
    public void executerTask(Runnable runnable) {

    }

    public void executerTimerTask(Runnable runnable, long firststartTime, long intervelTime, TimeUnit timeUnit) {

    }

    public abstract void removeTask();

    public void removeTask(Runnable runnable) {

    }

}

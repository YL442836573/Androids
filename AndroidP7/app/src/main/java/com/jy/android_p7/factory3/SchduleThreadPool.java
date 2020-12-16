package com.jy.android_p7.factory3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduleThreadPool extends ThreadPool {

    public static SchduleThreadPool schduleThreadPool;
    private final ScheduledExecutorService scheduledExecutorService;

    public synchronized static SchduleThreadPool getSchduleThreadPool() {
        if (schduleThreadPool == null) {
            synchronized (SchduleThreadPool.class) {
                if (schduleThreadPool == null) {
                    schduleThreadPool = new SchduleThreadPool ();
                }
            }
        }
        return schduleThreadPool;
    }

    private SchduleThreadPool() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor ();
    }

    @Override
    public void executerTimerTask(Runnable runnable, long firststartTime, long intervelTime, TimeUnit timeUnit) {
        super.executerTimerTask (runnable, firststartTime, intervelTime, timeUnit);
        scheduledExecutorService.scheduleWithFixedDelay (runnable,firststartTime,intervelTime,timeUnit);
    }


    @Override
    public void removeTask() {

    }

    @Override
    public void removeTask(Runnable runnable) {
        super.removeTask (runnable);
        schduleThreadPool.removeTask (runnable);
    }
}

package com.jy.android_p7.threadfactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduleThreadPool implements TheradPooIInterface {

    private final ScheduledExecutorService scheduledExecutorService;

    public SchduleThreadPool() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor ();
    }

    @Override
    public void executeTask(Runnable runnable) {
        scheduledExecutorService.schedule (runnable, 2, TimeUnit.SECONDS);
    }

    @Override
    public void removeTask() {
        scheduledExecutorService.shutdown ();
    }
}

package com.jy.android_p7.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool implements TheradPooIInterface {

    private final ExecutorService executorService;

    public FixedThreadPool() {
        executorService = Executors.newFixedThreadPool (5);
    }

    @Override
    public void executeTask(Runnable runnable) {
        executorService.execute (runnable);
    }

    @Override
    public void removeTask() {
        executorService.shutdown ();
    }
}

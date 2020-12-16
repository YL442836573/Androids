package com.jy.android_p7.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool implements TheradPooIInterface {

    private final ExecutorService executorService;

    public SingleThreadPool() {
        executorService = Executors.newSingleThreadExecutor ();
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

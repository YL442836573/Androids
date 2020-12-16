package com.jy.android_p7.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaCheThreadPool implements TheradPooIInterface {

    private final ExecutorService executorService;

    public CaCheThreadPool() {
        executorService = Executors.newCachedThreadPool ();
    }

    @Override
    public void executeTask(Runnable runnable) {
        if (executorService != null)
            executorService.execute (runnable);
    }

    @Override
    public void removeTask() {
        executorService.shutdown ();
    }
}

package com.jy.android_p7.factory3;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool extends ThreadPool {

    public static CustomThreadPool customThreadPool;
    private final ThreadPoolExecutor threadPoolExecutor;

    public CustomThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor (10, 20, 30, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable> (), Executors.defaultThreadFactory ());
    }

    public synchronized static CustomThreadPool getCustomThreadPool() {
        if (customThreadPool == null) {
            synchronized (CustomThreadPool.class) {
                if (customThreadPool == null) {
                    customThreadPool = new CustomThreadPool ();
                }
            }
        }
        return customThreadPool;
    }

    @Override
    public void executerTask(Runnable runnable) {
        super.executerTask (runnable);
        if (customThreadPool != null) {
            threadPoolExecutor.execute (runnable);
        }
    }


    @Override
    public void removeTask() {

    }

    @Override
    public void removeTask(Runnable runnable) {
        super.removeTask (runnable);
        customThreadPool.removeTask (runnable);
    }
}

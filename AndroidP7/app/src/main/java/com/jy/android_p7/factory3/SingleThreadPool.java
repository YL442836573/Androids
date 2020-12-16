package com.jy.android_p7.factory3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool extends ThreadPool {

    public static SingleThreadPool singleThreadPool;
    private final ExecutorService executorService;

    public synchronized static SingleThreadPool getSingleThreadPool() {
        if (singleThreadPool == null) {
            synchronized (SingleThreadPool.class) {
                if (singleThreadPool == null) {
                    singleThreadPool = new SingleThreadPool ();
                }
            }
        }
        return singleThreadPool;
    }

    public SingleThreadPool() {
        executorService = Executors.newSingleThreadExecutor ();
    }

    @Override
    public void removeTask() {
        executorService.shutdown ();
    }

    @Override
    public void executerTask(Runnable runnable) {
        super.executerTask (runnable);
        if (singleThreadPool != null)
            singleThreadPool.executerTask (runnable);
    }
}

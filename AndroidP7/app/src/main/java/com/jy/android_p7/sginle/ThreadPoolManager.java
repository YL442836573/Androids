package com.jy.android_p7.sginle;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    // 饿汉式


    // 懒汉式   单例模式 封装自定义线程池.
    private final ThreadPoolExecutor threadPoolExecutor;
    public static ThreadPoolManager threadPoolManager;

    private ThreadPoolManager() {
        threadPoolExecutor = new ThreadPoolExecutor (5, 20, 30, TimeUnit.SECONDS
                , new LinkedBlockingDeque<Runnable> (), Executors.defaultThreadFactory ());

    }

    public synchronized static ThreadPoolManager getThreadPoolManager() {
        if (threadPoolManager == null) {
            synchronized (ThreadPoolManager.class) {
                if (threadPoolManager == null) {
                    threadPoolManager = new ThreadPoolManager ();
                }
            }
        }
        return threadPoolManager;
    }

    // 添加
    public void execuadd(Runnable runnable) {
        if (threadPoolExecutor == null)
            return;

        threadPoolExecutor.execute (runnable);
    }

    // 移除
    public void romove(Runnable runnable) {
        if (threadPoolExecutor == null)
            return;

        threadPoolExecutor.remove (runnable);
    }

}

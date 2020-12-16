package com.jy.android_p7.factory3;

public class ThreadPoolFactory {

    public static final int CUSTOM_THREADPOOL = 0;
    public static final int SINGLE_THREADPOOL = 1;
    public static final int SCHDULE_THREADPOOL = 2;

    public static ThreadPool getThreadPoolFatory(int type) {
        switch (type) {
            case CUSTOM_THREADPOOL:
                return CustomThreadPool.getCustomThreadPool ();

            case SINGLE_THREADPOOL:
                return SingleThreadPool.getSingleThreadPool ();

            case SCHDULE_THREADPOOL:
                return SchduleThreadPool.getSchduleThreadPool ();
        }
        return null;
    }
}

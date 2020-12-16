package com.jy.android_p7.threadfactory;

public class ThreadPoolFactory {
    public static final int CACHE_THREADPOOL = 0;
    public static final int FIXED_THREADPOOL = 1;
    public static final int SINGLE_THREADPOOL = 2;
    public static final int SCHDULE_THREADPOOL = 3;

    public static TheradPooIInterface getExecutor(int type) {
        switch (type) {
            case CACHE_THREADPOOL:
                return new CaCheThreadPool ();
            case FIXED_THREADPOOL:
                return new FixedThreadPool ();
            case SINGLE_THREADPOOL:
                return new SingleThreadPool ();
            case SCHDULE_THREADPOOL:
                return new SchduleThreadPool ();
        }
        return null;
    }
}

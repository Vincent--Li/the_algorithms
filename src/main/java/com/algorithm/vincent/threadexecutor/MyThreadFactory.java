package com.algorithm.vincent.threadexecutor;

import java.util.concurrent.ThreadFactory;

/**
 * @author by zhiyuan.li@hand-china.com
 * 自己定义的ThreadFactory中, 通过封装包含Logger的Thread.UncaughtExceptionHandler, 将异常信息输出
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }
}

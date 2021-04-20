package com.algorithm.vincent.threadpool;

import java.util.Date;
import java.util.concurrent.*;

import io.netty.util.concurrent.SingleThreadEventExecutor;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(()-> {
                System.out.println(new Date());
        }, 0L, 5, TimeUnit.SECONDS);
        ConcurrentMap test;

    }
}

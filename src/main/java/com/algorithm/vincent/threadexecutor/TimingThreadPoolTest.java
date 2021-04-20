package com.algorithm.vincent.threadexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TimingThreadPoolTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1000);
        TimingThreadPool threadPool = new TimingThreadPool(
                10,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        for(int i = 0; i< 1000; i++){
            threadPool.execute(()->{
                System.out.println("I like this");
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

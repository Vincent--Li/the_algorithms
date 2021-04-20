package com.algorithm.vincent.longadder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class LongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                5,
                5000L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        LongAdder longAdder = new LongAdder();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        IntStream.range(0,1000).forEach(x -> {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.submit(()->{
                try{
                    longAdder.add(1);
                } finally {
                    countDownLatch.countDown();
                }
            });
        });
        countDownLatch.await();
        System.out.println(longAdder.longValue());
    }
}

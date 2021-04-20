package com.algorithm.vincent.countdownlatch;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                5,
                5000L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CountDownLatch countDownLatch = new CountDownLatch(5);
        IntStream.range(0, 5).parallel().forEach(x -> {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("divide by zero");
                    Integer tmp = 1 / 0;
                } finally {
                    countDownLatch.countDown();
                }
            });
        });
        countDownLatch.await();
        System.out.println("every thing is fine");

    }

}

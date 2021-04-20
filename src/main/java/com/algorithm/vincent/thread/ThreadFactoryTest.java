package com.algorithm.vincent.thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadFactoryTest {
    public static void main(String[] args) throws InterruptedException {
        UserThreadFactory userThreadFactory = new UserThreadFactory("wakeMeUp");
        Semaphore semaphore = new Semaphore(1, true);
        Integer loops = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(loops);
        IntStream.range(0,loops).parallel().forEach(x -> {
            userThreadFactory.newThread( ()-> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " executing task " + x);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    semaphore.release();
                }
            }).run();
        });
        countDownLatch.await();
    }
}

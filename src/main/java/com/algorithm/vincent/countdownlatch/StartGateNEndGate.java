package com.algorithm.vincent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class StartGateNEndGate {
    public void scheduleTask(final int numberOfThreads, final Runnable task ) throws InterruptedException {
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(numberOfThreads);

        for(int i = 0; i < numberOfThreads; i++){
            new Thread(()->{
                try {
                    startGate.await();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endGate.countDown();
                }
            }).start();
        }


        startGate.countDown();
        endGate.await();
        Thread.sleep(1000);
        System.out.println("Task Finished");
    }

    public static void main(String[] args) throws InterruptedException {
        StartGateNEndGate test = new StartGateNEndGate();
        test.scheduleTask(500, ()->{
            System.out.println(Thread.currentThread().getName());
        });
    }
}

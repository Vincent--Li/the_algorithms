package com.algorithm.vincent.cancellation;

import java.util.concurrent.*;

import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TimedRunDemo {
    public static void main(String[] args) {

        ThreadFactory threadFactory = new DefaultThreadFactory("TEST", true);
        ExecutorService executorService = Executors.newFixedThreadPool(1, threadFactory);
        Executors.newSingleThreadExecutor();


        Future<?> task = executorService.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("TASK INTERRUPTED");
                e.printStackTrace();
            }
        });
        try {
            System.out.println("START GET");
            task.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("TIMEOUT");
            e.printStackTrace();
        } finally {
            System.out.println("FINALLY");
            task.cancel(true);
        }

//        executorService.shutdown();
    }
}

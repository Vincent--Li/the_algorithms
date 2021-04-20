package com.algorithm.vincent.threadlocalrandom;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                5,
                5000L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        IntStream.range(0,10).forEach(x -> {
            threadPoolExecutor.submit(()->{
//                System.out.println(ThreadLocalRandom.current().nextDouble());
                System.out.println(Math.random());
            });
        });

    }
}

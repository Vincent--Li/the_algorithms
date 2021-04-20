package com.algorithm.vincent.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TheadLocalTest {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyy-MM-dd mm:HH:ss");
        }
    };

    public static void main(String[] args) {

        Integer corePoolSize = 2;
        Integer maxPoolSize = 2;
        Long keepAliveTime = 5000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(20);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                timeUnit,
                workQueue
        );

        IntStream.range(0,1000).forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.submit(()->{
                try {
                    DateFormat dateFormat = df.get();
                    System.out.println(dateFormat.format(new Date()));
                } finally {
                    df.remove();
                }
            });
        });
    }
}

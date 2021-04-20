package com.algorithm.vincent.threadexecutor;

import javax.imageio.stream.IIOByteBuffer;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BoundedExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                20,
                20,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                        new MyThreadFactory("TEST"));
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        BoundedExecutor executor = new BoundedExecutor(threadPoolExecutor, 20);
        AtomicInteger i = new AtomicInteger();
        while(true){
            try {
                executor.submitTask(()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i.getAndIncrement()  %20 == 19){
                        throw new NullPointerException();
                    }
                    System.out.println(Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

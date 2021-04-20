package com.algorithm.vincent.thread;

import java.util.concurrent.*;

import javafx.concurrent.Task;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CallableDemo implements Callable <Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 3;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableDemo task = new CallableDemo();
        // callable 的写法
//        Future<Integer> result = executor.submit(task);
//        System.out.println(result.get());
        // futureTask的写法
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        System.out.println(futureTask.get());

        executor.shutdown();
    }
}

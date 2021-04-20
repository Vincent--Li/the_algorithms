package com.algorithm.vincent.multitask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class InvokeAllToMaintainResult {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService  executorService = Executors.newFixedThreadPool(10);

        List<Callable<String>> tasks = new ArrayList<>();

        for( int i = 0; i< 10; i++){
            int finalI = i;
            Callable<String> task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "线程"+ finalI +"睡了"+sleepTime+"秒";
                }
            };

            tasks.add(task);
        }

        List<Future<String>> results = executorService.invokeAll(tasks);

        // 输出结果
        for ( int i=0; i<10; i++ ) {
            Future<String> future = results.get(i);
            String result = future.get();
            System.out.println(result);
        }
    }
}

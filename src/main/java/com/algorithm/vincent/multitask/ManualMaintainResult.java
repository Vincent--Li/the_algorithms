package com.algorithm.vincent.multitask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ManualMaintainResult {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<String>> results = new ArrayList<>();

        for( int i = 0; i< 10 ; i++){
            int finalI = i;
            Future<String> result = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "Thread" + finalI + "sleep" + sleepTime + "seconds";
                }
            });
            results.add(result);
        }

        // 要在这里调用关闭
        executorService.shutdown();

        for (int i = 0; i< 10; i++){
            Future<String> future = results.get(i);
            String result = future.get();
            System.out.println(result);
         }
    }
}

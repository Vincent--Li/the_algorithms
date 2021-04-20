package com.algorithm.vincent.completionservice;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CompletionServiceDemo {
    ExecutorService executorService = Executors.newFixedThreadPool(50);
    ExecutorCompletionService<BigInteger> executorCompletionService = new ExecutorCompletionService<>(executorService);

    public static void main(String[] args) {
        CompletionServiceDemo serviceDemo = new CompletionServiceDemo();

        for(int i = 0; i< 5000; i++){
            int tmp = i;
            Future<BigInteger> future = serviceDemo.executorCompletionService.submit(()->{
                Thread.sleep(tmp %100);
                return BigInteger.valueOf(tmp);
            });
        }

        for(int j =0; j < 5000; j++){
            Future<BigInteger> future = null;
            try {
                future = serviceDemo.executorCompletionService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BigInteger result = null;
            try {
                result = future.get(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

        serviceDemo.executorService.shutdown();
        try {
            serviceDemo.executorService.awaitTermination(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            serviceDemo.executorService.shutdownNow();
        }

    }
}

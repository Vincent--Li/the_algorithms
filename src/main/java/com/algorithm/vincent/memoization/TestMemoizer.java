package com.algorithm.vincent.memoization;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TestMemoizer {
    public static void main(String[] args) throws InterruptedException {

        test(new Memoizer1(new ExpensiveFunction()));
        test(new Memoizer2(new ExpensiveFunction()));
        test(new Memoizer3(new ExpensiveFunction()));
        test(new Memoizer4(new ExpensiveFunction()));
    }

    public static void test(Computable computable) throws InterruptedException {

        int nThread = 50;
        int nRound = 1000000;
        int nRandomBound = 1000000;


        Random random = new Random();
        CountDownLatch latch = new CountDownLatch(nRound);
        ExecutorService es = Executors.newFixedThreadPool(nThread);
        Long start = System.currentTimeMillis();
        System.out.println("Start at: " + start);
        for(int i = 0; i< nRound; i++){
            es.submit(() -> {
                try {
                    computable.compute(String.valueOf(random.nextInt(nRandomBound)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }
                latch.countDown();

            });
        }
        latch.await();
        es.shutdown();
        System.out.println("spent: " + (System.currentTimeMillis() - start));
        System.out.println("cache size is : " + computable.getCacheSize());
        System.out.println("");
    }
}

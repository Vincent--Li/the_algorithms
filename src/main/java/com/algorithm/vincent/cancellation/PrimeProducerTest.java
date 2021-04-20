package com.algorithm.vincent.cancellation;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PrimeProducerTest {
    public static void main(String[] args) {
        BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<>(15);
        PrimeProducer primeProducer = new PrimeProducer(primes);

        // 异步生产
        primeProducer.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(primes.size());
        primeProducer.cancel();

        // 异步消费
        Thread t = new Thread(()->{
            try {
                while(true){
                    System.out.println(primes.take());
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        t.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();

    }
}

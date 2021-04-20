package com.algorithm.vincent.cancellation;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        try {
            while (!Thread.currentThread().isInterrupted()){
                p = p.nextProbablePrime();
                queue.put(p);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void cancel(){
        interrupt();
    }
}
